package com.project.finalwork.instance;

import java.io.Serializable;

public class StudentInfoEntities implements Serializable {
    String name;
    String student_id;
    String id_number;
    String sex;
    String native_place;
    String birthday;
    String school;
    String major;
    String student_class;
    String phone;
    String email;
    String weixin_number;
    String special_skill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixin_number() {
        return weixin_number;
    }

    public void setWeixin_number(String weixin_number) {
        this.weixin_number = weixin_number;
    }

    public String getSpecial_skill() {
        return special_skill;
    }

    public void setSpecial_skill(String special_skill) {
        this.special_skill = special_skill;
    }

    public String toString(){
        StringBuilder allInfo = new StringBuilder();
        allInfo.append("姓名:"+name+"\n");
        allInfo.append("学号:"+student_id+"\n");
        allInfo.append("身份证号:"+id_number+"\n");
        allInfo.append("性别:"+sex+"\n");
        allInfo.append("籍贯:"+native_place+"\n");
        allInfo.append("生日:"+birthday+"\n");
        allInfo.append("所在学院:"+school+"\n");
        allInfo.append("专业:"+major+"\n");
        allInfo.append("班级:"+student_class+"\n");
        allInfo.append("电话:"+phone+"\n");
        allInfo.append("电子邮箱:"+email+"\n");
        allInfo.append("微信号:"+weixin_number+"\n");
        allInfo.append("特长:"+special_skill+"\n");

        return allInfo.toString();
    }
}
