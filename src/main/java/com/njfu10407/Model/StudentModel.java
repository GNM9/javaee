package com.njfu10407.Model;

public class StudentModel {
    private String stuNo;
    private String stuName;
    private String stuClass;
    private String stuSex;
    private String stuDorm;
    private String stuDepart;
    private String stuTel;
    private String stuPhoto;

    @Override
    public String toString() {
        return "StudentModel{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuDorm='" + stuDorm + '\'' +
                ", stuDepart='" + stuDepart + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", stuPhoto='" + stuPhoto + '\'' +
                '}';
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuDorm() {
        return stuDorm;
    }

    public void setStuDorm(String stuDorm) {
        this.stuDorm = stuDorm;
    }

    public String getStuDepart() {
        return stuDepart;
    }

    public void setStuDepart(String stuDepart) {
        this.stuDepart = stuDepart;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuPhoto() {
        return stuPhoto;
    }

    public void setStuPhoto(String stuPhoto) {
        this.stuPhoto = stuPhoto;
    }

}
