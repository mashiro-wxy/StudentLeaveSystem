package com.stu_leave.controller;

import com.stu_leave.entity.Student_leave;
import com.stu_leave.service.S_M_leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CSchool {

    @Autowired
    private S_M_leave s_m_leave;

    @RequestMapping("show_leave_info_school")
    public String showLeaveInfoFdy(HttpServletRequest request, Model model){
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getLeaveSchool(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size)
        );
        model.addAttribute("leave_list_school", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_leave_info_school";
    }

    @RequestMapping("agree_leave_school")
    public String agreeLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.agreeLeaveSchool(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_leave_info_school?field=default&condition=&page_number=1&page_size=5";
    }


}
