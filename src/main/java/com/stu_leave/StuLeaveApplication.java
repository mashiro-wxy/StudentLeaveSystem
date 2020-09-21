package com.stu_leave;

import com.stu_leave.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StuLeaveApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(StuLeaveApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);
    }

}
