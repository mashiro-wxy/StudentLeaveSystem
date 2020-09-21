package com.stu_leave.controller;


import com.stu_leave.entity.*;

import com.stu_leave.service.S_M_Student;
import com.stu_leave.service.S_M_leave;
import com.stu_leave.service.SStudent;
import com.stu_leave.service.S_M_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class CStudent_Web {
    @Autowired
    private  SStudent autowiredStudent;
    @Autowired
    private S_M_Student s_m_student;
    @Autowired
    private S_M_leave s_m_leave;
    @Autowired
    private S_M_info s_m_info;



    //数据循环显示在页面上。
    @RequestMapping("show_all_stu_info")
    public String showAllStu_info(HttpServletRequest request, Model model){
        Student student = (Student)
                request.getSession().getAttribute("a_stu_info");
        if (student == null)
            return "redirect:show_login_web";

        List<Student> studentList = null;
        studentList = autowiredStudent.getAllStudent();
        model.addAttribute("stu_list", studentList);
        return "show_stu_info";
    }

    //@RequestMapping("check_login_web") //等价与下面这句话
    @RequestMapping(value = "check_login_web", method = RequestMethod.GET)
    public String checkLoginWeb(HttpServletRequest request, Model model){
        String no = request.getParameter("no");
        String pwd = request.getParameter("pwd");
        String method = request.getParameter("m1");
        System.out.println(no + "...|..." + pwd);
        if (method.equals("学生")) {
            Student student_from_autowired = autowiredStudent.checkLoginWeb(no, pwd);
            if (student_from_autowired == null) {
                return "redirect:show_login";
            } else {
                request.getSession().setAttribute("a_stu_info", student_from_autowired);
                model.addAttribute("a_stu_info", student_from_autowired);
                return "home";
            }
        }
        if (method.equals("辅导员")){
            Fdy fdy = autowiredStudent.checkLoginFdy(no, pwd);
            if (fdy == null) {
                return "redirect:show_login";
            } else {
                request.getSession().setAttribute("a_fdy_info", fdy);
                model.addAttribute("a_fdy_info", fdy);
                return "home_fdy";
            }
        }

        if (method.equals("教务")){
            School s = autowiredStudent.checkLoginSchool(no, pwd);
            if (s == null) {
                return "redirect:show_login";
            } else {
                request.getSession().setAttribute("a_school_info", s);
                model.addAttribute("a_school_info", s);
                return "home_school";
            }
        }

        if (method.equals("教师")){
            Teacher t = autowiredStudent.checkLoginTeacher(no, pwd);
            if (t == null) {
                return "redirect:show_login";
            } else {
                request.getSession().setAttribute("a_teacher_info", t);
                model.addAttribute("a_teacher_info", t);
                return "home_teacher";
            }
        }
        else
            return "error";
    }

    @RequestMapping("show_login")
    public String showLoginWeb(){
        return "login";
    }

    @RequestMapping("show_leave_info_page")
    public String showLeaveInfoPage(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        if (page_number.equals("0"))
            page_number = "1";
        String page_size = request.getParameter("page_size");
        page_size = "5";
        List<Student_leave> leaveList = s_m_leave.getLeavePage(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                stu_no
        );
        model.addAttribute("leave_list", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_leave_info_page";
    }

    @RequestMapping("show_pass_leave")
    public String showPass_Leave(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        //String pass_state = request.getParameter("pass_state");
        List<Student_leave> leaveList = s_m_leave.getPassLeave(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                stu_no

        );
        model.addAttribute("leave_list2", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        //model.addAttribute("pass_state", pass_state);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_pass_leave";
    }

    @RequestMapping("show_gd_pass")
    public String showGdPass(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        //String pass_state = request.getParameter("pass_state");
        List<Student_leave> leaveList = s_m_leave.getGdPass(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                stu_no

        );
        model.addAttribute("leave_list2", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        //model.addAttribute("pass_state", pass_state);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_gd_pass_leave";
    }

    @RequestMapping("show_unpass_leave")
    public String showUnpassLeave(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getUnpassLeave(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                stu_no
        );
        model.addAttribute("leave_list3", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_unpass_leave";
    }

    @RequestMapping("show_gd_unpass")
    public String showGdUnpass(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getGdUnpass(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                stu_no
        );
        model.addAttribute("leave_list3", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_gd_unpass_leave";
    }

    @RequestMapping("show_delete_leave")
    public String showDeleteLeave(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getDeleteLeave(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                stu_no
        );
        model.addAttribute("leave_list4", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_delete_leave";
    }

    @RequestMapping("delete_leave")
    public String deleteLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.deleteLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_leave_info_page?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("submit_leave")
    public String submitLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.submitLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_leave_info_page?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("delete_all_leave")
    public String deleteAllLeave(HttpServletRequest request){
        int i = s_m_leave.deleteAllLeave();
        if (i <= 0)
            return "error";
        else
            return "redirect:show_delete_leave?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("remove_leave")
    public String removeLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.removeLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_delete_leave?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("recover_leave")
    public String recoverLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.recoverLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_delete_leave?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("insert_leave")
    public String insertLeave(@ModelAttribute Student_leave student_leave){
        int i = 0;
        i = s_m_leave.insertLeave(student_leave);
        if (i > 0 )//如果插入成功，则跳转到显示学生信息的分页页面。
            return "redirect:show_leave_info_page?field=default&condition=&page_number=1&page_size=5";
        else//如果插入失败，则跳转回要插入的表单页面。
            return "redirect:show_insert";
    }

    @RequestMapping("edit_leave")
    public String editLeave(@ModelAttribute Student_leave student_leave){
        int i = 0;
        i = s_m_leave.editLeave(student_leave);
        if (i > 0)
            return "redirect:show_leave_info_page?field=default&condition=&page_number=1&page_size=5";
        else
            return "redirect:show_edit_leave";
    }

    @RequestMapping("show_edit_leave")
    public String showLeave(HttpServletRequest request, Model model){

        String submit_datetime = request.getParameter("submit_datetime");

        Student_leave student_leave = s_m_leave.getSingleLeave(submit_datetime);
        model.addAttribute("stu_leave", student_leave);
        return "edit_leave";
    }

    @RequestMapping("show_progress")
    public String showProgress(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        List<Student_leave> leave_list = s_m_leave.getSingleLeave2(stu_no);
        Student_leave student_leave = leave_list.get(leave_list.size()-1);
        String leave_start = student_leave.getLeave_start();
        String leave_end = student_leave.getLeave_end();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(leave_start);
            date2 = simpleDateFormat.parse(leave_end);
        } catch (ParseException e) {
        e.printStackTrace();
        }
        //date算星期几
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int w1 = cal.get(Calendar.DAY_OF_WEEK)-1;
        cal.setTime(date2);
        int w2 = cal.get(Calendar.DAY_OF_WEEK)-1;
        if (w1 > w2){
            int t = w1;
            w1 = w2;
            w2 = t;
        }
        List<Info> info_list = s_m_info.getCourse(w1, w2);
        /*for (Student_leave student_leave1 : leave_list) {
            String submit_datetime_i = student_leave1.getSubmit_datetime();
            String stu_no_i = student_leave1.getStu_no();
            //s_m_info.send(w1, w2, submit_datetime_i, stu_no_i);
        }*/

        int state = student_leave.getProgress_state();
        if (info_list == null){
            return "show_leave_progress";
        }
        else{
        model.addAttribute("stu_leave3", student_leave);
        model.addAttribute("state", state);
        model.addAttribute("course_list", info_list);
        return "show_leave_progress";
        }
    }

    @RequestMapping("show_progress_single")
    public String showProgressSingle(HttpServletRequest request, Model model){

        //List<Student_leave> leave_list = s_m_leave.getSingleLeave2(stu_no);
        String submit_datetime = request.getParameter("submit_datetime");
        Student_leave student_leave = s_m_leave.getSingleLeave(submit_datetime);
        String leave_start = student_leave.getLeave_start();
        String leave_end = student_leave.getLeave_end();
        int leave_days = student_leave.getLeave_days();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(leave_start);
            date2 = simpleDateFormat.parse(leave_end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //date算星期几
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int w1 = cal.get(Calendar.DAY_OF_WEEK);
        cal.setTime(date2);
        int w2 = cal.get(Calendar.DAY_OF_WEEK);
        if (w1 > w2){
            int t = w1;
            w1 = w2;
            w2 = t;
        }
        if (leave_days >= 7){
            w1=0;
            w2=7;
        }
        List<Info> info_list = s_m_info.getCourse(w1, w2);

        int state = student_leave.getProgress_state();
        if (info_list == null){
            return "show_leave_progress";
        }
        else{
            model.addAttribute("stu_leave3", student_leave);
            model.addAttribute("state", state);
            model.addAttribute("course_list", info_list);
            return "show_leave_progress";
        }
    }

    @RequestMapping("show_leave_info_progress")
    public String showLeaveInfoFdy(HttpServletRequest request, Model model){
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getLeaveProgress(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                stu_no
        );
        model.addAttribute("leave_list_progress", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_leave_info_progress";
    }

    @RequestMapping("show_insert")
    public String showInsertLeave(HttpServletRequest request, Model model){
        Student_leave student_leave = new Student_leave();
        Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();
        String stu_name = student.getStu_name();
        student_leave.setStu_no(stu_no);
        student_leave.setStu_name(stu_name);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String submit_time = simpleDateFormat.format(date);
        student_leave.setSubmit_datetime(submit_time);
        model.addAttribute("stu_leave2", student_leave);
        return "insert_leave";
    }

    @RequestMapping("show_main")
    public String showMainWeb(){
        return "main";
    }

    @RequestMapping("show_update_pwd")
    public String showUpdatePwd(HttpServletRequest request){

        return "show_update_pwd";
    }

    @RequestMapping("update_pwd")
    public String updatePwd(HttpServletRequest request){
        /*Student student = (Student) request.getSession().getAttribute("a_stu_info");
        String stu_no = student.getStu_no();*/
        String stu_no = request.getParameter("stu_no");
        String stu_pwd = request.getParameter("stu_pwd");
        int i = s_m_leave.updatePwd(stu_no, stu_pwd);

        if (i <= 0)
            return "error";
        else
            return "redirect:show_update_pwd";
    }

    /*@RequestMapping("show_remai")
    public String showRemaiWeb(){
        return "remai";
    }*/
}
