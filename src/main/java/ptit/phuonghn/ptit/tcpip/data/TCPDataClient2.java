package ptit.phuonghn.ptit.tcpip.data;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPDataClient2 {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2207;
        String studentCode = "K25DTCN301";
        String qCode = "XI5eJpzA";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);
            socket.setSoTimeout(5000);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF(studentCode + ";" + qCode);
            dos.flush();

            System.out.println("flush done message!");

            String encrypt = dis.readUTF();
            int s = dis.readInt();

            System.out.println("Nhận encrypt = " + encrypt + " , s = " + s);

            String decrypted = decrypt(encrypt, s);

            dos.writeUTF(decrypted);
            dos.flush();

            System.out.println("flush done decrypted!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String text, int s) {
        return shift(text, Math.floorMod(s, 26));
    }

    public static String decrypt(String text, int s) {
        int normalizedShift = Math.floorMod(s, 26);
        return shift(text, -normalizedShift);
    }

    private static String shift(String text, int s) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                int position = c - 'A';
                int newPosition = Math.floorMod(position + s, 26);

                result.append((char) ('A' + newPosition));

            } else if (c >= 'a' && c <= 'z') {
                int position = c - 'a';
                int newPosition = Math.floorMod(position + s, 26);

                result.append((char) ('a' + newPosition));

            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
