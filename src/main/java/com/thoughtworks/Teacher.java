package com.thoughtworks;

import java.util.ArrayList;

public class Teacher {
    private String name;
    private ArrayList<Student> roster = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public void addStudent(String name, String id, String admissionDate) {
        this.roster.add(new Student(name, id, admissionDate));
    }

    /**
     * 按照学生学号查重重复人员，分别打印重复人员姓名和其全部信息
     */
    public void duplicateCheck() {
        for (int i = 0; i < roster.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (roster.get(i).equals(roster.get(j))) {
                    System.out.println(roster.get(i).getName() + " 与 "
                            + roster.get(j).getName() + "重复 ！ ");
                    System.out.println("重复人员信息 ： ");
                    System.out.println(roster.get(i) + "\n" + roster.get(j));
                }
            }
        }
    }

    /**
     * 遍历输出所有学生信息
     */
    public void showAllStudent() {
        System.out.println("所有学生信息 ： ");
        for (Student student : roster) {
            System.out.println(student);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getRoster() {
        return roster;
    }

    public void setRoster(ArrayList<Student> roster) {
        this.roster = roster;
    }
}
