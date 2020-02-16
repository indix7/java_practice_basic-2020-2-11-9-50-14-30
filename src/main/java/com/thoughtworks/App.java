package com.thoughtworks;

public class App {

    public static void main(String[] args) {
        hand();
    }

    public static void hand() {
        Teacher teacher = new Teacher("张龙");
        teacher.addStudent("张三", "001", "2019.02.11");
        teacher.addStudent("李四", "002", "2019.02.10");
        teacher.addStudent("王五", "001", "2019.02.09");
        teacher.showAllStudent();
        teacher.duplicateCheck();

    }
}
