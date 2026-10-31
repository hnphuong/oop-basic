package ptit.phuonghn.ptit.tcpip.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TCPClient {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2208;
        String studentCode = "K25DTCN301";
        String qCode = "XMTAjvsB";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);
            socket.setSoTimeout(5000);

            try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))
            ) {

                writer.write(studentCode + ";" + qCode);
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                if (response == null) {
                    throw new IllegalStateException(
                            "Server đã đóng kết nối trước khi gửi dữ liệu"
                    );
                }
                System.out.println("Nhận: " + response);

                List<String> eduDomains = new ArrayList<>();
                for (String item : response.split(",")) {
                    String domain = item.trim();

                    if (domain.endsWith(".edu")) {
                        eduDomains.add(domain);
                    }
                }
                String result = String.join(", ", eduDomains);
                writer.write(result);
                writer.newLine();
                writer.flush();

                System.out.println("Gửi: " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
