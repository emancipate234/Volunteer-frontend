package com.zyh.volunteer.repository;

import com.zyh.volunteer.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Student,String> {
    public Student findByUsername(String username);
}
