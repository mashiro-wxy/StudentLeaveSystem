package com.stu_leave.mapper;

import com.stu_leave.entity.Student_leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Leave_info_Mapper {

    List<Student_leave> getLeavePage(@Param("whereCondition") String whereCondition,
                                     @Param("1") int page_number,
                                     @Param("2") int page_size,
                                     @Param("3") String stu_no
                                     );

    List<Student_leave> getLeaveFdy(@Param("whereCondition") String whereCondition,
                                     @Param("1") int page_number,
                                     @Param("2") int page_size);

    List<Student_leave> getLeaveProgress(@Param("whereCondition") String whereCondition,
                                    @Param("1") int page_number,
                                    @Param("2") int page_size,
                                    @Param("3") String stu_no);

    List<Student_leave> getLeaveSchool(@Param("whereCondition") String whereCondition,
                                    @Param("1") int page_number,
                                    @Param("2") int page_size);

    List<Student_leave> getLeaveTeacher(@Param("whereCondition") String whereCondition,
                                       @Param("1") int page_number,
                                       @Param("2") int page_size,
                                        @Param("3") String teacher_no);

    List<Student_leave> getAllLeaveFdy();


    List<Student_leave> getPassLeave(@Param("whereCondition") String whereCondition,
                                     @Param("1") int page_number,
                                     @Param("2") int page_size,
                                     @Param("3") String stu_no);

    List<Student_leave> getGdPass(@Param("whereCondition") String whereCondition,
                                     @Param("1") int page_number,
                                     @Param("2") int page_size,
                                     @Param("3") String stu_no);

    List<Student_leave> getGdUnpass(@Param("whereCondition") String whereCondition,
                                     @Param("1") int page_number,
                                     @Param("2") int page_size,
                                     @Param("3") String stu_no);

    List<Student_leave> getPassLeaveFdy(@Param("whereCondition") String whereCondition,
                                     @Param("1") int page_number,
                                     @Param("2") int page_size);

    List<Student_leave> getUnpassLeaveFdy(@Param("whereCondition") String whereCondition,
                                        @Param("1") int page_number,
                                        @Param("2") int page_size);

    List<Student_leave> getUnpassLeave(@Param("whereCondition") String whereCondition,
                                     @Param("1") int page_number,
                                     @Param("2") int page_size,
                                       @Param("3") String stu_no);

    List<Student_leave> getDeleteLeave(@Param("whereCondition") String whereCondition,
                                       @Param("1") int page_number,
                                       @Param("2") int page_size,
                                       @Param("3") String stu_no);

    int submitLeave(@Param("0") String submit_datetime);

    int deleteLeave(@Param("0") String submit_datetime);

    int gdpLeave(@Param("0") String submit_datetime);

    int gdupLeave(@Param("0") String submit_datetime);

    int agreeLeave(@Param("0") String submit_datetime);

    int agreeLeaveSchool(@Param("0") String submit_datetime);

    int disagreeLeave(@Param("0") String submit_datetime);

    int removeLeave(@Param("0") String submit_datetime);

    int recoverLeave(@Param("0") String submit_datetime);

    int deleteAllLeave();

    Student_leave getSingleLeave(String submit_datetime);

    List<Student_leave> getSingleLeave2(@Param("0") String stu_no);

    int editLeave(Student_leave student_leave);

    int insertLeave(Student_leave student_leave);

    int updatePwd(@Param("0") String stu_no,
                    @Param("1") String stu_pwd);

}
