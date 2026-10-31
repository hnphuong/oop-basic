package ptit.phuonghn.ptit.tcpip.ios;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TCPClientIOS {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2206;

        String studentCode = "K25DTCN301";
        String qCode = "mtVM9oiR";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);

            long deadline = System.nanoTime() + 5_000_000_000L;

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            send(output, studentCode + ";" + qCode);

            String response = receive(socket, input, deadline);
            System.out.println("Nhận dãy số: " + response);

            String result = findResult(response);
            send(output, result);

            System.out.println("Gửi kết quả: " + result);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static String findResult(String data) {
        String[] parts = data.split(",", -1);

        if (parts.length < 2) {
            throw new IllegalArgumentException(
                    "Dãy phải có ít nhất 2 phần tử"
            );
        }

        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }

        Arrays.sort(numbers);

        long minDistance = Long.MAX_VALUE;
        int first = numbers[0];
        int second = numbers[1];

        for (int i = 1; i < numbers.length; i++) {
            long distance = (long) numbers[i] - numbers[i - 1];

            // Khi khoảng cách bằng nhau, chọn cặp lớn hơn
            if (distance <= minDistance) {
                minDistance = distance;
                first = numbers[i - 1];
                second = numbers[i];
            }
        }

        return minDistance + "," + first + "," + second;
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
