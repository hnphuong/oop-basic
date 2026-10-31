package ptit.phuonghn.ptit.tcpip.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPObjectClient {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2209;

        String studentCode = "K25DTCN301";
        String qCode = "aoJ0rKyM";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);
            socket.setSoTimeout(5000);

            // Tạo ObjectOutputStream và flush trước để header không làm kẹt ObjectInputStream phía server
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            output.writeObject(studentCode + ";" + qCode);
            output.flush();

            Laptop laptop = (Laptop) input.readObject();
            System.out.println("Nhận: " + laptop);

            laptop.setName(swapFirstAndLastWord(laptop.getName()));
            laptop.setQuantity(reverseDigits(laptop.getQuantity()));

            output.writeObject(laptop);
            output.flush();

            System.out.println("Gửi: " + laptop);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // "T520 thinkpad lenovo" -> "lenovo thinkpad T520"
    private static String swapFirstAndLastWord(String name) {
        String[] words = name.trim().split("\\s+");

        if (words.length < 2) {
            return name;
        }

        String first = words[0];
        words[0] = words[words.length - 1];
        words[words.length - 1] = first;

        return String.join(" ", words);
    }

    // 1899 -> 9981
    private static int reverseDigits(int value) {
        return Integer.parseInt(
                new StringBuilder(String.valueOf(value)).reverse().toString()
        );
    }
}
