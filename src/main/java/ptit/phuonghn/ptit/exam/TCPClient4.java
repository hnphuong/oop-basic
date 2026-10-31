package ptit.phuonghn.ptit.exam;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient4 {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2206;

        String studentCode = "K25DTCN301";
        String qCode = "fp2hlV6x";
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);

            long deadline = System.nanoTime() + 5_000_000_000L;
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            send(output, studentCode + ";" + qCode);
            System.out.println("flush data done!");

            String response = receive(socket, input, deadline);
            System.out.println("Response : " + response);
            long rs = calSum(response);
            System.out.println("sum: " + rs);
            send(output, rs + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long calSum(String data) {
        long sum = 0;
        for (String s : data.split("\\|")) {
            sum += Long.parseLong(s.trim());
        }
        return sum;
    }

    private static void send(OutputStream output, String message)
            throws IOException {
        output.write((message + "\n").getBytes(StandardCharsets.UTF_8));
        output.flush();
    }

    private static String receive(
            Socket socket, InputStream input, long deadline)
            throws IOException {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] chunk = new byte[1024];

        while (true) {
            long remainingMs =
                    (deadline - System.nanoTime() + 999_999) / 1_000_000;

            if (remainingMs <= 0) {
                if (buffer.size() > 0) break;
                throw new java.net.SocketTimeoutException(
                        "Vượt quá thời gian giao tiếp 5 giây"
                );
            }

            // Đã có dữ liệu mà server không gửi '\n' thì chờ ngắn rồi chốt
            long idleMs = buffer.size() > 0 ? 300 : remainingMs;
            socket.setSoTimeout((int) Math.max(1, Math.min(idleMs, remainingMs)));

            int n;
            try {
                n = input.read(chunk);
            } catch (java.net.SocketTimeoutException e) {
                if (buffer.size() > 0) break;
                throw e;
            }

            if (n == -1) {
                if (buffer.size() > 0) break;
                throw new IOException(
                        "Server đóng kết nối khi chưa gửi đủ thông điệp"
                );
            }

            buffer.write(chunk, 0, n);

            if (chunk[n - 1] == '\n') break;
        }

        String raw = new String(buffer.toByteArray(), StandardCharsets.UTF_8);
        System.out.println("RAW: [" + raw.replace("\r", "\\r").replace("\n", "\\n") + "]");
        return raw.trim();
    }
}
