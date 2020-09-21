package com.stu_leave.service;

import com.stu_leave.entity.Info;
import com.stu_leave.mapper.Info_info_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_M_info {
    @Autowired
    Info_info_Mapper infoInfoMapper;

    public List<Info> getCourse(int w1, int w2){
        return infoInfoMapper.getCourse(w1, w2);
    }


}
