package com.stu_leave.mapper;

import com.stu_leave.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Info_info_Mapper {

    List<Info> getCourse(@Param("0") int w1,
                         @Param("1") int w2);
}
