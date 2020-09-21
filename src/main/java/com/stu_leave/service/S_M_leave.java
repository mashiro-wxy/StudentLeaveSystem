package com.stu_leave.service;
;
import com.stu_leave.entity.Student_leave;
import com.stu_leave.mapper.Leave_info_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class S_M_leave {

    @Autowired
    private Leave_info_Mapper leaveInfoMapper;

    public List<Student_leave> getLeavePage(String field, String condition,
                                              int page_number, int page_size, String stu_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getLeavePage(whereCondition, page_number, page_size, stu_no);
    }

    public List<Student_leave> getLeaveFdy(String field, String condition,
                                            int page_number, int page_size){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getLeaveFdy(whereCondition, page_number, page_size);
    }

    public List<Student_leave> getLeaveProgress(String field, String condition,
                                           int page_number, int page_size, String stu_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getLeaveProgress(whereCondition, page_number, page_size, stu_no);
    }

    public List<Student_leave> getLeaveTeacher(String field, String condition,
                                           int page_number, int page_size, String teacher_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getLeaveTeacher(whereCondition, page_number, page_size, teacher_no);
    }

    public List<Student_leave> getLeaveSchool(String field, String condition,
                                           int page_number, int page_size){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getLeaveSchool(whereCondition, page_number, page_size);
    }

    public List<Student_leave> getAllLeaveFdy(){
        return  leaveInfoMapper.getAllLeaveFdy();
    }

    public List<Student_leave> getPassLeave(String field, String condition,
                                            int page_number, int page_size, String stu_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getPassLeave(whereCondition, page_number, page_size, stu_no);
    }

    public List<Student_leave> getGdPass(String field, String condition,
                                            int page_number, int page_size, String stu_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getGdPass(whereCondition, page_number, page_size, stu_no);
    }

    public List<Student_leave> getGdUnpass(String field, String condition,
                                            int page_number, int page_size, String stu_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getGdUnpass(whereCondition, page_number, page_size, stu_no);
    }

    public List<Student_leave> getPassLeaveFdy(String field, String condition,
                                            int page_number, int page_size){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getPassLeaveFdy(whereCondition, page_number, page_size);
    }

    public List<Student_leave> getUnpassLeave(String field, String condition,
                                            int page_number, int page_size, String stu_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getUnpassLeave(whereCondition, page_number, page_size, stu_no);
    }

    public List<Student_leave> getUnpassLeaveFdy(String field, String condition,
                                               int page_number, int page_size){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getUnpassLeaveFdy(whereCondition, page_number, page_size);
    }

    public List<Student_leave> getDeleteLeave(String field, String condition,
                                              int page_number, int page_size, String stu_no){
        String whereCondition = " 1=1 ";
        if (!field.equals("default")){
            whereCondition += " and " + field +
                    " like '%" + condition + "%'";
        }
        page_number = (page_number -1) * page_size;
        return  leaveInfoMapper.getDeleteLeave(whereCondition, page_number, page_size, stu_no);
    }



    public int gdpLeave(String submit_datetime){
        return leaveInfoMapper.gdpLeave(submit_datetime);
    }

    public int gdupLeave(String submit_datetime){
        return leaveInfoMapper.gdupLeave(submit_datetime);
    }

    public int deleteLeave(String submit_datetime){
        return leaveInfoMapper.deleteLeave(submit_datetime);
    }

    public int agreeLeave(String submit_datetime){
        return leaveInfoMapper.agreeLeave(submit_datetime);
    }

    public int agreeLeaveSchool(String submit_datetime){
        return leaveInfoMapper.agreeLeaveSchool(submit_datetime);
    }

    public int disagreeLeave(String submit_datetime){
        return leaveInfoMapper.disagreeLeave(submit_datetime);
    }

    public int submitLeave(String submit_datetime){
        return leaveInfoMapper.submitLeave(submit_datetime);
    }

    public int deleteAllLeave(){
        return leaveInfoMapper.deleteAllLeave();
    }

    public int removeLeave(String submit_datetime){
        return leaveInfoMapper.removeLeave(submit_datetime);
    }

    public int recoverLeave(String submit_datetime){
        return leaveInfoMapper.recoverLeave(submit_datetime);
    }

    public Student_leave getSingleLeave(String submit_datetime){
        return leaveInfoMapper.getSingleLeave(submit_datetime);
    }

    public List<Student_leave> getSingleLeave2(String stu_no){
        return leaveInfoMapper.getSingleLeave2(stu_no);
    }

    public int editLeave(Student_leave student_leave){
        return leaveInfoMapper.editLeave(student_leave);
    }

    public int insertLeave(Student_leave student_leave){
        return leaveInfoMapper.insertLeave(student_leave);
    }

    public int updatePwd(String stu_no, String stu_pwd){
        return leaveInfoMapper.updatePwd(stu_no, stu_pwd);
    }
}
