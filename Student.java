package stu_Management_Sys;


public class Student {
    //学号
    private String sid;
    //姓名
    private String name;
    //年龄
    private int age;
    //居住的
    private String address;

    //快捷键Alt+insert 快捷建立方法
    //其中Constructor是构造无参和全参方法
    //gitter和setter是构造单独一个参数方法
    //在里面是可以使用Shift进行全选的


    public Student() {
    }

    public Student(String sid, String name, int age, String address) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
