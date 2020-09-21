package com.stu_leave.entity;

public class Student_leave {

    private String stu_no;
    private String stu_name;
    private String submit_datetime;
    private String leave_start;
    private String leave_end;
    private int leave_days;
    private String leave_type;
    private String leave_reason;
    private int pass_state;
    private int delete_state;
    private int progress_state;


    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getSubmit_datetime() {
        return submit_datetime;
    }

    public void setSubmit_datetime(String submit_datetime) {
        this.submit_datetime = submit_datetime;
    }

    public String getLeave_start() {
        return leave_start;
    }

    public void setLeave_start(String leave_start) {
        this.leave_start = leave_start;
    }

    public String getLeave_end() {
        return leave_end;
    }

    public void setLeave_end(String leave_end) {
        this.leave_end = leave_end;
    }

    public int getLeave_days() {
       String s1 = leave_start.substring(8);
       String s2 = leave_end.substring(8);
       int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        this.leave_days = i2-i1+1;
        return this.leave_days;
    }

    public void setLeave_days(int leave_days) {
        this.leave_days = leave_days;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public String getLeave_reason() {
        return leave_reason;
    }

    public void setLeave_reason(String leave_reason) {
        this.leave_reason = leave_reason;
    }

    public int getPass_state() {
        return pass_state;
    }

    public void setPass_state(int pass_state) {
        this.pass_state = pass_state;
    }

    public int getDelete_state() {
        return delete_state;
    }

    public void setDelete_state(int delete_state) {
        this.delete_state = delete_state;
    }

    public int getProgress_state() {
        return progress_state;
    }

    public void setProgress_state(int progress_state) {
        this.progress_state = progress_state;
    }
}
