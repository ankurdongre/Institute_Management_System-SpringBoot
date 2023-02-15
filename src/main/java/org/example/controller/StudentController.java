package org.example.controller;
import org.example.model.Student;
import org.example.service.impl.TeacherServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private TeacherServiceimpl service;
    @RequestMapping("/UpdateStudentSelf")
    @ResponseBody
    public Student updatestudentself(@RequestBody Student student){
        return service.updatestudentsingle(student);
    }

}
