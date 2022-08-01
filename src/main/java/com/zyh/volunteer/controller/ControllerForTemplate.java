package com.zyh.volunteer.controller;

import com.zyh.volunteer.model.Student;
import com.zyh.volunteer.repository.UserRepository;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControllerForTemplate {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Student byUsername = userRepository.findByUsername(username);
        if (byUsername != null) {
            if (password.equals(byUsername.getPassword())) {
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                try {
                    subject.login(token);
                    request.setAttribute("user", byUsername);
                    return "index";
                } catch (UnknownAccountException e) {
                    return "login";
                }
            }
        }
        return "failed";
    }

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //
        Student byUsername = userRepository.findByUsername(username);
        if(byUsername != null){
            return "failed";
        }
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        userRepository.save(student);
        return "index";
    }
}
