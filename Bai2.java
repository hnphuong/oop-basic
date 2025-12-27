package kiemtra01;
import java.util.*;
import java.io.*;

public class Bai2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> ds = (ArrayList<String>) in.readObject();
        TreeSet<Integer> st = new TreeSet<>();
        for (String x : ds) {
            Scanner sc = new Scanner(x);
            while(sc.hasNext()){
                try{
                    int n = Integer.parseInt(sc.next());
                    st.add(n);
                }catch(Exception e){}
            }
        }
        for (Integer n : st) {
            System.out.println(n);
        }
    }
}
