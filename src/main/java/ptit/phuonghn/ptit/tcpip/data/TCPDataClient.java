package ptit.phuonghn.ptit.tcpip.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPDataClient {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2207;

        String studentCode = "K25DTCN301";
        String qCode = "gWp7M3PQ";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);
            socket.setSoTimeout(5000);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            output.writeUTF(studentCode + ";" + qCode);
            output.flush();

            int a = input.readInt();
            int b = input.readInt();
            System.out.println("Nhận a = " + a + ", b = " + b);

            int sum = a + b;
            int product = a * b;

            output.writeInt(sum);
            output.writeInt(product);
            output.flush();

            System.out.println("Gửi tổng = " + sum + ", tích = " + product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
