/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hnp.project.demoactivemq.test.all;

/**
 *
 * @author ADMIN
 */
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        NhanVien x = new NhanVien(in.nextLine(),in.nextLine(),in.nextLine(),in.nextLine(),
//                                        in.nextLine(),in.nextLine());
//        System.out.println(x);
//        String name = "CÔNG TY TNHH ORCHARD DEVELOPMENT";
//        System.out.println(removeVietnameseAccent(name));
        System.out.println(223/100);
    }

    private static String removeVietnameseAccent(String str) {
        // Chuyển chuỗi thành dạng chuẩn (NFC)
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        // Biểu thức chính quy để loại bỏ các dấu
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }
}
