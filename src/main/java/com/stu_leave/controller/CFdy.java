package com.stu_leave.controller;

import com.stu_leave.entity.Student_leave;
import com.stu_leave.service.S_M_leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import java.util.List;

@Controller
public class CFdy {

    @Autowired
    private S_M_leave s_m_leave;

    @RequestMapping("show_leave_info_fdy")
    public String showLeaveInfoFdy(HttpServletRequest request, Model model){
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getLeaveFdy(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size)
        );
        model.addAttribute("leave_list_fdy", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_leave_info_fdy";
    }

    @RequestMapping("show_pass_leave_fdy")
    public String showPass_Leave(HttpServletRequest request, Model model){
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getPassLeaveFdy(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size)
        );
        model.addAttribute("leave_list2", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        //model.addAttribute("pass_state", pass_state);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_pass_leave_fdy";
    }

    @RequestMapping("show_unpass_leave_fdy")
    public String showUnpass_Leave(HttpServletRequest request, Model model){
        String field = request.getParameter("field");
        String condition = request.getParameter("condition");
        String page_number = request.getParameter("page_number");
        String page_size = request.getParameter("page_size");
        List<Student_leave> leaveList = s_m_leave.getUnpassLeaveFdy(
                field,
                condition,
                Integer.parseInt(page_number),
                Integer.parseInt(page_size)
        );
        model.addAttribute("leave_list3", leaveList);
        model.addAttribute("page_number", page_number);
        model.addAttribute("page_size", page_size);
        //model.addAttribute("pass_state", pass_state);
        model.addAttribute("field", field);
        model.addAttribute("condition", condition);
        return "show_unpass_leave_fdy";
    }

    @RequestMapping("agree_leave")
    public String agreeLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.agreeLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_leave_info_fdy?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("disagree_leave")
    public String disagreeLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.disagreeLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_leave_info_fdy?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("gdp_leave")
    public String gdpLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.gdpLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_pass_leave?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("gdup_leave")
    public String gdupLeave(HttpServletRequest request){
        String submit_datetime = request.getParameter("submit_datetime");
        int i = s_m_leave.gdupLeave(submit_datetime);
        if (i <= 0)
            return "error";
        else
            return "redirect:show_unpass_leave?field=default&condition=&page_number=1&page_size=5";
    }

    @RequestMapping("show_tongji")
    public String showYongji(HttpServletRequest request, Model model){
        List<Student_leave> leaveList = s_m_leave.getAllLeaveFdy();
        int bing=0,shi=0,bu=0,gong=0;
        int m12=0,m11=0,m10=0;
        int mostTime=0,m=0;
        for (Student_leave s : leaveList){
            if (s.getLeave_type().equals("病假")) bing++;
            if (s.getLeave_type().equals("事假")) shi++;
            if (s.getLeave_type().equals("补假")) bu++;
            if (s.getLeave_type().equals("公假")) gong++;
            if (s.getLeave_start().substring(5,7).equals("12")) m12++;
            if (s.getLeave_start().substring(5,7).equals("11")) m11++;
            if (s.getLeave_start().substring(5,7).equals("10")) m10++;
        }
        mostTime = Math.max(Math.max(m11,m12),m10);
        if (mostTime == m12) m=12;
        else if (mostTime == m11) m=11;
        else m=10;
        model.addAttribute("bing", bing);
        model.addAttribute("shi", shi);
        model.addAttribute("bu", bu);
        model.addAttribute("gong", gong);
        model.addAttribute("m", m);
        model.addAttribute("mostTime", mostTime);
        return "show_tongji";
    }

}
