package ptit.phuonghn.ptit.tcpip.ios;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServerIOS {
    public static void main(String[] args) {
        // Chỉ lắng nghe kết nối từ máy local
        try (ServerSocket server = new ServerSocket(
                2206, 50, InetAddress.getByName("127.0.0.1"))) {

            System.out.println("Server đang chạy tại 127.0.0.1:2206");

            while (true) {
                try (Socket socket = server.accept()) {
                    // Hạn chót cho toàn bộ lượt trao đổi với client
                    long deadline = System.nanoTime() + 5_000_000_000L;

                    InputStream input = socket.getInputStream();
                    OutputStream output = socket.getOutputStream();

                    // a. Nhận studentCode;qCode
                    String request = receive(socket, input, deadline);
                    System.out.println("Nhận yêu cầu: " + request);

                    if (!request.matches("[^;\\s]+;[^;\\s]+")) {
                        throw new IOException("Sai định dạng studentCode;qCode");
                    }

                    // b. Gửi dãy số mẫu
                    String numbers = "1,3,9,19,33,20";
                    send(output, numbers);
                    System.out.println("Gửi dãy số: " + numbers);

                    // c. Nhận kết quả
                    String result = receive(socket, input, deadline);
                    System.out.println("Client trả về: " + result);

                    String expected = "1,19,20";
                    System.out.println(
                            expected.equals(result)
                                    ? "Kết quả: ĐÚNG"
                                    : "Kết quả: SAI, đáp án là " + expected
                    );

                    // d. Socket tự đóng
                } catch (IOException e) {
                    System.err.println("Lỗi xử lý client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        while (true) {
            long remaining = deadline - System.nanoTime();

            if (remaining <= 0) {
                throw new java.net.SocketTimeoutException(
                        "Vượt quá thời gian giao tiếp 5 giây"
                );
            }

            // Mỗi lần đọc chỉ được chờ trong thời gian còn lại
            socket.setSoTimeout(
                    (int) Math.max(1, (remaining + 999_999) / 1_000_000)
            );

            int value = input.read();

            if (value == -1) {
                throw new IOException(
                        "Client đóng kết nối khi chưa gửi đủ thông điệp"
                );
            }

            if (value == '\n') {
                return new String(
                        buffer.toByteArray(), StandardCharsets.UTF_8
                ).trim();
            }

            buffer.write(value);
        }
    }
}
