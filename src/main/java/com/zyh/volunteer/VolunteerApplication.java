package com.zyh.volunteer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class VolunteerApplication {
    public static void main(String[] args){
        SpringApplication.run(VolunteerApplication.class,args);
    }
}
