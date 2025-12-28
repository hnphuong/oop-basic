package hnp.project.demoactivemq.test.student;

public class Student {
    private String studentCode;
    private String studentName;
    private String studentSex;
    private String studentClass;
    private String studentEmail;
    private String studentPhone;

    public Student(String studentCode, String studentName, String studentSex, String studentClass, String studentEmail, String studentPhone) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentClass = studentClass;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
    }

    public String display() {
        return studentCode + ", "  + studentName + ", " + studentSex + ", " + studentClass + ", "
                + studentEmail + ", " + studentPhone;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }
}
