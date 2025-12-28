package hnp.project.demoactivemq.test.employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String employeeCode;
    private String employeeName;
    private String employeeSex;
    private Date employeeDob;
    private String employeeAddress;
    private String employeeTax;
    private Date employeeDateSig;

    public Employee(String employeeCode, String employeeName, String employeeSex, Date employeeDob
            , String employeeAddress, String employeeTax, Date employeeDateSig) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeSex = employeeSex;
        this.employeeDob = employeeDob;
        this.employeeAddress = employeeAddress;
        this.employeeTax = employeeTax;
        this.employeeDateSig = employeeDateSig;
    }

    public String display(){
        return employeeCode + " " + employeeName + " " + employeeSex + " "
                + convertToString(employeeDob) + " " + employeeAddress + " " + employeeTax + " " + convertToString(employeeDateSig);
    }

    private String convertToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Date getEmployeeDob() {
        return employeeDob;
    }

    public void setEmployeeDob(Date employeeDob) {
        this.employeeDob = employeeDob;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeTax() {
        return employeeTax;
    }

    public void setEmployeeTax(String employeeTax) {
        this.employeeTax = employeeTax;
    }

    public Date getEmployeeDateSig() {
        return employeeDateSig;
    }

    public void setEmployeeDateSig(Date employeeDateSig) {
        this.employeeDateSig = employeeDateSig;
    }
}
