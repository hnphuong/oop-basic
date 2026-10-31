package ptit.phuonghn.ptit.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPClient3 {
    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2207;

        String studentCode = "K25DTCN301";
        String qCode = "s4MefxtZ";

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);
            socket.setSoTimeout(5000);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            output.writeUTF(studentCode + ";" + qCode);
            output.flush();

            int n = input.readInt();
            System.out.println("Nhận n = " + n);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int b = input.readInt();
                System.out.println("Nhận a = " + n + ", b = " + b);
                list.add(b);
            }
            int[] numbers = list.stream().mapToInt(Integer::intValue).toArray();
            if (n == 0) {
                throw new IllegalArgumentException("Mảng không được rỗng");
            }
            int sum = 0;
            for (int value : numbers) {
                sum += value;
            }
            float average = (float) sum / n;

            float variance = 0;
            for (int value : numbers) {
                float difference = value - average;
                variance += difference * difference;
            }
            variance /= n;
            output.writeInt(sum);
            output.writeFloat(average);
            output.writeFloat(variance);
            output.flush();
            System.out.println("Gửi tổng = " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
