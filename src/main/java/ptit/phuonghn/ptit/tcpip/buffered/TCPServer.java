package ptit.phuonghn.ptit.tcpip.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {

    public static void main(String[] args) {
        int port = 2208;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server đang chạy tại localhost:" + port);
            // Tiếp tục chờ client mới sau khi xử lý xong một kết nối
            while (true) {
                try (Socket client = server.accept()) {
                    client.setSoTimeout(5000);

                    System.out.println("Client kết nối: "
                            + client.getRemoteSocketAddress());
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    client.getInputStream(),
                                    StandardCharsets.UTF_8
                            )
                    );
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(
                                    client.getOutputStream(),
                                    StandardCharsets.UTF_8
                            )
                    );

                    // a. Nhận mã sinh viên và mã câu hỏi
                    String request = reader.readLine();
                    if (request == null) {
                        continue;
                    }
                    System.out.println("Nhận yêu cầu: " + request);

                    // b. Gửi danh sách tên miền mẫu
                    String domains =
                            "giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, "
                                    + "wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, "
                                    + "HHjE9.com, 4hXfJe9giAA.edu";

                    writer.write(domains);
                    writer.newLine();
                    writer.flush();

                    // c. Nhận kết quả lọc từ client
                    String result = reader.readLine();

                    System.out.println("Kết quả client gửi: " + result);

                    String expected =
                            "MdpIzhxDVtTFTF.edu, 4hXfJe9giAA.edu";

                    if (expected.equals(result)) {
                        System.out.println("Kết quả: ĐÚNG");
                    } else {
                        System.out.println("Kết quả: SAI");
                    }

                    // d. Socket client tự đóng khi kết thúc khối try
                } catch (Exception e) {
                    System.err.println("Lỗi xử lý client: "
                            + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
