package com.thoughtworks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {
    private String name;
    private String id;
    private Date admissionDate;
    private GregorianCalendar calendar = new GregorianCalendar();
    private int beginYear;
    private int beginDays;

    public Student() {
    }

    public Student(String name, String id, String admissionDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            this.name = name;
            this.id = id;
            this.admissionDate = sdf.parse(admissionDate);
        } catch (ParseException exception) {
            System.out.println("Student传入参数异常");
        }
    }

    /**
     * 设置入学calendar
     */
    private void setBeginCalendar() {
        this.calendar.setTime(this.admissionDate);
        this.beginYear = this.calendar.get(Calendar.YEAR);
        this.beginDays = this.calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 返回学龄时间，只有学龄足一整年的才算一年
     * @return 学龄长度
     */
    public int getSchoolAge() {
        this.setBeginCalendar();
        this.calendar.setTime(new Date(System.currentTimeMillis()));
        int currentYear = this.calendar.get(Calendar.YEAR);
        int currentDays = this.calendar.get(Calendar.DAY_OF_YEAR);
        if (currentDays >= this.beginDays) {
            return (currentYear - this.beginYear);
        } else {
            return (currentYear - this.beginYear - 1);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return ((Student) obj).getId().equals(this.id);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String admissionDate = sdf.format(this.admissionDate);
        return "我叫" + this.name + ", " + "我的学号是" + this.id + ", "
                + admissionDate + "入学, 学龄" + this.getSchoolAge() + "年";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }
}
