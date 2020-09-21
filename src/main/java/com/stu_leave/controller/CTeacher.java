package com.stu_leave.controller;

import com.stu_leave.entity.Student_leave;
import com.stu_leave.entity.Teacher;
import com.stu_leave.service.S_M_leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CTeacher {

    @Autowired
    private S_M_leave s_m_leave;

    @RequestMapping("show_leave_info_teacher")
    public String showLeaveInfoTeacher(HttpServletRequest request, Model model){
        Teacher teacher = (Teacher) request.getSession().getAttribute("a_teacher_info");
        String teacher_id = teacher.getTeacher_no();
        String teacher_pro = teacher.getTeacher_pro();
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getLeaveTeacher(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size),
                teacher_id
        );
        model.addAttribute("leave_list_teacher", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        model.addAttribute("pro", teacher_pro);
        return "show_leave_info_teacher";
    }



}
