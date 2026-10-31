package ptit.phuonghn.ptit.tcpip.ios;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class TCPClientIOS2 {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2206;

        String studentCode = "K25DTCN301";
        String qCode = "28vo7VEa";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);

            long deadline = System.nanoTime() + 5_000_000_000L;

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            send(output, studentCode + ";" + qCode);

            String response = receive(socket, input, deadline);
            System.out.println("Nhận dãy số: " + response);

            String result = findSecondLargest(response);
            send(output, result);

            System.out.println("Gửi kết quả: " + result);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Giá trị lớn thứ hai (khác giá trị lớn nhất) và vị trí xuất hiện đầu tiên (đếm từ 0)
    private static String findSecondLargest(String data) {
        String[] parts = data.split(",", -1);
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }

        int max = Integer.MIN_VALUE;
        for (int n : numbers) {
            max = Math.max(max, n);
        }

        boolean found = false;
        int second = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n < max && (!found || n > second)) {
                second = n;
                found = true;
            }
        }

        if (!found) {
            throw new IllegalArgumentException(
                    "Không có giá trị lớn thứ hai"
            );
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == second) {
                return second + "," + i;
            }
        }

        throw new IllegalStateException("Không tìm thấy vị trí");
    }

    private static void send(OutputStream output, String message)
            throws IOException {
        output.write((message + "\n").getBytes(StandardCharsets.UTF_8));
        output.flush();
    }

    // Server có thể không gửi '\n' ở cuối: dừng khi gặp '\n' hoặc khi đã có dữ liệu và im lặng 300ms
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
                throw new SocketTimeoutException(
                        "Vượt quá thời gian giao tiếp 5 giây"
                );
            }

            long idleMs = buffer.size() > 0 ? 300 : remainingMs;
            socket.setSoTimeout((int) Math.max(1, Math.min(idleMs, remainingMs)));

            int n;
            try {
                n = input.read(chunk);
            } catch (SocketTimeoutException e) {
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

        return new String(buffer.toByteArray(), StandardCharsets.UTF_8).trim();
    }
}
