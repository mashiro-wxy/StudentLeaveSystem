package com.stu_leave.service;

import com.stu_leave.db.DbManage;
import com.stu_leave.entity.*;
import com.stu_leave.util.SpringUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class SStudent {


    public List<Student> getAllStudent(){
        List<Student> studentList = new ArrayList<Student>();
        String sqlTxt = "select * from stu_info";
        JdbcTemplate jdbcTemplate = (JdbcTemplate)
                SpringUtil.applicationContext.getBean("jdbcTemplate");
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlTxt);
        for (Map<String, Object> map : list){
            Student student = new Student();
            student.setStu_no(map.get("stu_no").toString());
            student.setStu_name(map.get("stu_name").toString());
            student.setStu_pro(map.get("stu_pro").toString());
            student.setStu_phone(map.get("stu_phone").toString());
            student.setStu_sex(map.get("stu_sex").toString());
            student.setStu_age
                    (Integer.parseInt(map.get("stu_age").toString()));
            studentList.add(student);
        }
        return  studentList;
    }


    public Student checkLoginWeb(String stu_no, String stu_pwd){
        String sqlTxt = "select * from stu_info where stu_no='"
                + stu_no  +"' and stu_pwd = '"
                + stu_pwd + "'";
        System.out.println(sqlTxt);
        Student student = null;
        JdbcTemplate jdbcTemplate = (JdbcTemplate)SpringUtil
                .applicationContext.getBean("jdbcTemplate");
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sqlTxt);
        if (list.size() > 0){
            student = new Student();
            student.setStu_no(list.get(0).get("stu_no").toString());
            student.setStu_name(list.get(0).get("stu_name").toString());
            student.setStu_pro(list.get(0).get("stu_pro").toString());
            student.setStu_phone(list.get(0).get("stu_phone").toString());
            student.setStu_sex(list.get(0).get("stu_sex").toString());
            student.setStu_age
                    (Integer.parseInt(list.get(0).get("stu_age").toString()));
        }

        return student;
    }

    public Fdy checkLoginFdy(String fdy_no, String fdy_pwd){
        String sqlTxt = "select * from fdy_info where fdy_id='"
                + fdy_no  +"' and fdy_pwd = '"
                + fdy_pwd + "'";
        System.out.println(sqlTxt);
        Fdy fdy = null;
        JdbcTemplate jdbcTemplate = (JdbcTemplate)SpringUtil
                .applicationContext.getBean("jdbcTemplate");
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sqlTxt);
        if (list.size() > 0){
            fdy = new Fdy();
            fdy.setFdy_id(list.get(0).get("fdy_id").toString());
            fdy.setFdy_name(list.get(0).get("fdy_name").toString());
            fdy.setFdy_pro(list.get(0).get("fdy_pro").toString());
            fdy.setFdy_sex(list.get(0).get("fdy_sex").toString());
        }

        return fdy;
    }

    public School checkLoginSchool(String school_no, String school_pwd){
        String sqlTxt = "select * from school_info where school_id='"
                + school_no  +"' and school_pwd = '"
                + school_pwd + "'";
        System.out.println(sqlTxt);
        School s = null;
        JdbcTemplate jdbcTemplate = (JdbcTemplate)SpringUtil
                .applicationContext.getBean("jdbcTemplate");
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sqlTxt);
        if (list.size() > 0){
            s = new School();
            s.setSchool_id(list.get(0).get("school_id").toString());
            s.setSchool_name(list.get(0).get("school_name").toString());
        }

        return s;
    }

    public Teacher checkLoginTeacher(String teacher_no, String teacher_pwd){
        String sqlTxt = "select * from teacher_info where teacher_no='"
                + teacher_no  +"' and teacher_pwd = '"
                + teacher_pwd + "'";
        System.out.println(sqlTxt);
        Teacher t = null;
        JdbcTemplate jdbcTemplate = (JdbcTemplate)SpringUtil
                .applicationContext.getBean("jdbcTemplate");
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sqlTxt);
        if (list.size() > 0){
            t = new Teacher();
            t.setTeacher_no(list.get(0).get("teacher_no").toString());
            t.setTeacher_name(list.get(0).get("teacher_name").toString());
            t.setTeacher_pro(list.get(0).get("teacher_pro").toString());
            t.setTeacher_sex(list.get(0).get("teacher_sex").toString());
        }

        return t;
    }

}
