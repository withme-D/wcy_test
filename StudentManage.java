package stu_Management_Sys;

import java.util.ArrayList;
import java.util.Scanner;

//思路
//1.用输出语句完成主界面的编写
//2.用Scanner实现键盘录入数据
//3.使用switch语句完成操作的选择
//4.用循环完成再次回到主界面
public class StudentManage {

    public static void main(String[] args) {
        //创建学生集合
        ArrayList<Student> array = new ArrayList<Student>();

        //同输出语句完成主界面的编写
        System.out.println("-----------欢迎来到学生管理系统——---------");
        while (true) {
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.推出");
            System.out.println("请输入你的选择：");

            //使用Scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            int line = sc.nextInt();

            //使用switch语句完成操作的选择
            switch (line) {
                case 1:
                    addStudent(array);
                    //System.out.println("添加学生");
                    break;
                case 2:
                    //System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case 3:
                    //System.out.println("修改学生信息");
                    modifyStudent(array);
                    break;
                case 4:
                    findStudent(array);
                    // System.out.println("查看所有学生");
                    break;
                case 5:
                    System.out.println("谢谢使用");
                    //break;  使用break只能打破当前switch语句，不能打破while循环
                    System.exit(0); //JVM退出。虚拟机推出
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象所需要的数据。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        String sid = sc.next();
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生居住地：");
        String address = sc.next();

        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setAddress(address);
        s.setName(name);
        s.setAge(age);

        //将学生对象添加到学生中
        array.add(s);

        //给出添加成功提示
        System.out.println("添加学生成功");


    }

    public static void findStudent(ArrayList<Student> array) {
        //判断集合中是否有数据，如果没有显示提示信息
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
        }

        //显示表头信息
        System.out.println("学号\t\t\t 姓名\t 年龄\t 居住地");

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁" + "\t\t" + s.getAddress());
        }

    }

    public static void deleteStudent(ArrayList<Student> array) {
        //键盘录入要删除的学生学号，显示提示信息
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你想要删除的学生的学号");
        String sid = sc.nextLine();

        //遍历集合将对应学生对象从集合中删除
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);  //先获得学生对象
            if (s.getSid().equals(sid)) {    //equals比较的是内容是否一样，==比较的是地址是否一样
                array.remove(i);
                //提示删除成功
                System.out.println("删除学生成功！");
                break;
            } else if (i == array.size() - 1) {
                System.out.println("查证并无此学生");
                System.out.println("删除失败");
            }
        }


    }

    public static void modifyStudent(ArrayList<Student> array) {
        //导入Scanner包
        Scanner sc = new Scanner(System.in);
        //选择修改方式
        System.out.println("请选择修改方式");
        System.out.println("1.按学号修改  2.按姓名修改");
        int f = sc.nextInt();
        if (f == 1) {
            //先从控制台录入学生学号
            String Sid = sc.nextLine();

            //遍历数组找到学生
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                String p = s.getSid();
                if (Sid.equals(p)) {
                    System.out.println("1.修改学生年龄");
                    System.out.println("2.修改学生居住地");
                    System.out.println("请输入：");
                    while (true) {
                        int x = sc.nextInt();
                        if (x == 1) {
                            int n = sc.nextInt();
                            s.setAge(n);
                            break;
                        } else if (x == 2) {
                            String d = sc.nextLine();
                            s.setAddress(d);
                            break;
                        } else {
                            System.out.println("请按照提示选择1或者2");
                        }

                    }
                }

            }
        } else if (f == 2) {      //目前不支持有多个同名学生姓名
            //从控制台接受学生姓名
            String n = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                String p = s.getName();
                if (n.equals(p)) {
                    System.out.println("1.修改学生年龄");
                    System.out.println("2.修改学生居住地");
                    System.out.println("请输入：");
                    while (true) {
                        int x = sc.nextInt();
                        if (x == 1) {
                            int na = sc.nextInt();
                            s.setAge(na);
                            break;
                        } else if (x == 2) {
                            String d = sc.nextLine();
                            s.setAddress(d);
                            break;
                        } else {
                            System.out.println("请按照提示选择1或者2");
                        }

                    }

                }


            }


        }


    }

}
