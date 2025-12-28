package bai6;

import java.io.*;
import java.util.*;

public class Bai6 {
    static class MonHoc {
        String ma, ten, hinhThuc;

        MonHoc(String ma, String ten, String hinhThuc) {
            this.ma = ma;
            this.ten = ten;
            this.hinhThuc = hinhThuc;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + hinhThuc;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        List<MonHoc> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ma = br.readLine();
            while (ma != null && ma.trim().isEmpty()) ma = br.readLine();

            String ten = br.readLine();
            if (ten == null) ten = "";

            String hinhThuc = br.readLine();
            if (hinhThuc == null) hinhThuc = "";

            list.add(new MonHoc(ma.trim(), ten.trim(), hinhThuc.trim()));
        }

        list.sort(Comparator.comparing(m -> m.ma));

        StringBuilder sb = new StringBuilder();
        for (MonHoc m : list) {
            sb.append(m.toString()).append('\n');
        }
        System.out.print(sb.toString());
    }
}
