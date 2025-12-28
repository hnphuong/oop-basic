package bai6;

import java.io.*;
import java.util.*;

public class Bai7 {

    static class HoaDon {
        String ma, ten;
        int soLuong;
        long donGia, chietKhau, tongTien;

        HoaDon(String ma, String ten, int soLuong, long donGia, long chietKhau) {
            this.ma = ma;
            this.ten = ten;
            this.soLuong = soLuong;
            this.donGia = donGia;
            this.chietKhau = chietKhau;
            this.tongTien = soLuong * donGia - chietKhau;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + soLuong + " " + donGia + " " + chietKhau + " " + tongTien;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) line = br.readLine();
        int n = Integer.parseInt(line.trim());

        List<HoaDon> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ma = br.readLine().trim();
            String ten = br.readLine().trim();
            int soLuong = Integer.parseInt(br.readLine().trim());
            long donGia = Long.parseLong(br.readLine().trim());
            long chietKhau = Long.parseLong(br.readLine().trim());

            list.add(new HoaDon(ma, ten, soLuong, donGia, chietKhau));
        }

        // Sắp xếp giảm dần theo tổng tiền
        list.sort((a, b) -> Long.compare(b.tongTien, a.tongTien));

        StringBuilder sb = new StringBuilder();
        for (HoaDon hd : list) {
            sb.append(hd).append("\n");
        }

        System.out.print(sb.toString());
    }
}
