package com.stu_leave.mapper;

import com.stu_leave.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface Stu_info_Mapper {



    Student getSingleStudent(String stu_no);

    List<Student> getAllStudent(String stu_no);

    List<Student> getStudentPage(@Param("whereCondition") String whereCondition,
                                 @Param("1") int page_number,
                                 @Param("2") int page_size);

    int deleteStudent(@Param("0") String stu_no);
    int insertStudent(Student student);
    int editStudent(Student student);

    int updateAccount(@Param("0") String stu_no,
                      @Param("1") double money);
}
