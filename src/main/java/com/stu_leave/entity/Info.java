package com.stu_leave.entity;

public class Info {
    private String submit_datetime;
    private String course_no;
    private String teacher_no;
    private String teacher_name;
    private String course_name;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getSubmit_datetime() {
        return submit_datetime;
    }

    public void setSubmit_datetime(String submit_datetime) {
        this.submit_datetime = submit_datetime;
    }

    public String getCourse_no() {
        return course_no;
    }

    public void setCourse_no(String course_no) {
        this.course_no = course_no;
    }

    public String getTeacher_no() {
        return teacher_no;
    }

    public void setTeacher_no(String teacher_no) {
        this.teacher_no = teacher_no;
    }
}
