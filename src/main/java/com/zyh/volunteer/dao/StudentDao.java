package com.zyh.volunteer.dao;

import com.google.gson.Gson;
import com.zyh.volunteer.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class StudentDao {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void saveStudent(String id, int expireTime, Student student){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(id,gson.toJson(student), expireTime, TimeUnit.SECONDS);
    }

    //从Redis中根据id找Student数据
    public Student findByID(String id){
        Gson gson = new Gson();
        Student student = null;
        String studentJson = redisTemplate.opsForValue().get(id);
        if(studentJson != null && !studentJson.equals("")){
            student = gson.fromJson(studentJson, Student.class);
        }
        return student;
    }
    //从redis中删除
    public void deleteByID(String id){
        redisTemplate.opsForValue().getOperations().delete(id);
    }
}
