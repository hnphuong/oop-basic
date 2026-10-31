package ptit.phuonghn.ptit.exam;

import ptit.phuonghn.ptit.TCP.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient2 {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2209;

        String studentCode = "K25DTCN301";
        String qCode = "q5AipI0q";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);
            socket.setSoTimeout(5000);

            // Tạo ObjectOutputStream và flush trước để header không làm kẹt ObjectInputStream phía server
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            output.writeObject(studentCode + ";" + qCode);
            output.flush();

            System.out.println("init : " + studentCode + ";" + qCode);

            Product product = (Product) input.readObject();
            System.out.println("product: " + product);
            //output.writeObject(laptop);
            //output.flush();

            //System.out.println("Gửi: " + laptop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
