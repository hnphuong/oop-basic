package kiemtra01;
import java.io.*;
import java.util.*;
public class Bai5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<SinhVien> ds = new ArrayList<>();
        while (sc.hasNextLine()){
            ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(ds);
        for (SinhVien sv: ds){
            System.out.println(sv);
        }
    }
}
class SinhVien implements Comparable<SinhVien> {
    private String maSV, hoTen, lop, email, sdt;
    public SinhVien(String maSV, String hoTen, String lop, String email, String sdt) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
        this.sdt = "0" + sdt;
    }
    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + lop + " " + email + " " + sdt;
    }
    @Override
    public int compareTo(SinhVien o) {
        if(this.lop.compareTo(o.lop) != 0){
            return this.lop.compareTo(o.lop);
        }
        return this.maSV.compareTo(o.maSV);
    }
}

