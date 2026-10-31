package ptit.phuonghn.ptit.exam;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class TCPClient5 {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2208;

        String studentCode = "K25DTCN301";
        String qCode = "ejDAR1Bf";
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);
            long deadline = System.nanoTime() + 5_000_000_000L;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            send(writer, studentCode + ";" + qCode);
            System.out.println("send data done: " + studentCode + ";" + qCode);

            String response = receive(socket, reader, deadline);
            System.out.println("Nhận chuỗi: " + response);

            String result = findRepeatedChars(response);
            send(writer, result);

            System.out.println("Gửi kết quả: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String findRepeatedChars(String data) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char c : data.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                counts.merge(c, 1, Integer::sum);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                result.append(entry.getKey())
                        .append(':')
                        .append(entry.getValue())
                        .append(',');
            }
        }
        return result.toString();
    }

    private static void send(BufferedWriter writer, String message)
            throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }

    private static String receive(
            Socket socket, BufferedReader reader, long deadline)
            throws IOException {
        StringBuilder buffer = new StringBuilder();
        char[] chunk = new char[1024];
        while (true) {
            long remainingMs =
                    (deadline - System.nanoTime() + 999_999) / 1_000_000;
            if (remainingMs <= 0) {
                if (buffer.length() > 0) break;
                throw new SocketTimeoutException(
                        "Vượt quá thời gian giao tiếp 5 giây"
                );
            }
            long idleMs = buffer.length() > 0 ? 300 : remainingMs;
            socket.setSoTimeout((int) Math.max(1, Math.min(idleMs, remainingMs)));
            int n;
            try {
                n = reader.read(chunk);
            } catch (SocketTimeoutException e) {
                if (buffer.length() > 0) break;
                throw e;
            }
            if (n == -1) {
                if (buffer.length() > 0) break;
                throw new IOException(
                        "Server đóng kết nối khi chưa gửi đủ thông điệp"
                );
            }
            buffer.append(chunk, 0, n);
            if (chunk[n - 1] == '\n') break;
        }
        return buffer.toString().trim();
    }
}
