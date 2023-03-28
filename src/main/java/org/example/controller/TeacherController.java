package org.example.controller;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.impl.ManagementServiceimpl;
import org.example.service.impl.TeacherServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private ManagementServiceimpl service;
    @Autowired
    private TeacherServiceimpl service2;

    @RequestMapping("/UpdateTeacherSelf2")
    @ResponseBody
    public Teacher updateteacherself(@RequestBody Teacher teacher){
        return service.updateteachersingle(teacher);
    }

    @RequestMapping("/InsertStudentSingle2")
    @ResponseBody
    public void insertstudentsingle(@RequestBody Student student){
        service2.insertstudentsingle(student);
    }
    @RequestMapping("/InsertStudentMultiple2")
    @ResponseBody
    public void insertstudentmultiple(@RequestBody List<Student> student){
        service2.insertstudentmultiple(student);
    }
    @RequestMapping("/SelectStudentSingle2")
    @ResponseBody
    public Student selectstudentsingle(@RequestParam int roll_no){
        return service2.selectstudentsingle(roll_no);
    }
    @RequestMapping("/SelectStudentMultiple2")
    @ResponseBody
    public List<Student> selectstudentmultiple(@RequestParam List<Integer> roll_nos){
        return service2.selectstudentmultiple(roll_nos);
    }
    @RequestMapping("/UpdateStudentSingle2")
    @ResponseBody
    public Student updatestudentsingle(@RequestBody Student student){
        return service2.updatestudentsingle(student);
    }
    @RequestMapping("/UpdateStudentMultiple2")
    @ResponseBody
    public List<Student> updatestudentmultiple(@RequestBody List<Student> student){
        return service2.updatestudentmultiple(student);
    }
    @RequestMapping("/DeleteStudentSingle2")
    @ResponseBody
    public Boolean deletestudentsingle(@RequestParam int roll_no){
        return service2.deletestudentsingle(roll_no);
    }
    @RequestMapping("/DeleteStudentMultiple2")
    @ResponseBody
    public List<Boolean> deletestudentmultiple(@RequestParam List<Integer> roll_nos){
        return service2.deletestudentmultiple(roll_nos);
    }
    @RequestMapping("/SelectStudentAll2")
    @ResponseBody
    public List<Student> selectstudentall(){
        return service2.selectstudentall();
    }
    @RequestMapping("/DeleteStudentAll2")
    @ResponseBody
    public Boolean deletestudentall(){
        return service2.deletestudentall();
    }
}
