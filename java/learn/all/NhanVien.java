/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hnp.project.demoactivemq.test.all;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String ma, ten, gioitinh, ngaysinh, 
            diachi, mst, ngayky;

    public NhanVien(String ten, String gioitinh, String ngaysinh, String diachi, String mst, String ngayky) {
        this.ma = "00001";
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.mst = mst;
        this.ngayky = ngayky;
    }
    
    public String toString(){
        return ma + " " + ten + " " + gioitinh + 
                " " + ngaysinh + " " + diachi + " " +
                " " + mst + " " + ngayky;
    }
}
