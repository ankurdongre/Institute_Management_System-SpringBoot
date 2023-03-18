package org.example.controller;
import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.impl.AdminServiceimpl;
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
public class ManagementController {
    @Autowired
    private ManagementServiceimpl service;
    @Autowired
    private AdminServiceimpl service1;

    @RequestMapping("/UpdateManagementSelf")
    @ResponseBody
    public Management updatemanagementself(@RequestBody Management management){
        return service1.updatemanagementsingle(management);
    }

    @RequestMapping("/InsertTeacherSingle1")
    @ResponseBody
    public void insertteachersingle(@RequestBody Teacher teacher){
        service.insertteachersingle(teacher);
    }
    @RequestMapping("/InsertTeacherMultiple1")
    @ResponseBody
    public void insertteachermultiple(@RequestBody List<Teacher> teacher){
        service.insertteachermultiple(teacher);
    }
    @RequestMapping("/SelectTeacherSingle1")
    @ResponseBody
    public Teacher selectteachersingle(@RequestParam int id){
        return service.selectteachersingle(id);
    }
    @RequestMapping("/SelectTeacherMultiple1")
    @ResponseBody
    public List<Teacher> selectteachermultiple(@RequestParam List<Integer> ids){
        return service.selectteachermultiple(ids);
    }
    @RequestMapping("/UpdateTeacherSingle1")
    @ResponseBody
    public Teacher updateteachersingle(@RequestBody Teacher teacher){
        return service.updateteachersingle(teacher);
    }
    @RequestMapping("/UpdateTeacherMultiple1")
    @ResponseBody
    public List<Teacher> updateteachermultiple(@RequestBody List<Teacher> teacher){
        return service.updateteachermultiple(teacher);
    }
    @RequestMapping("/DeleteTeacherSingle1")
    @ResponseBody
    public Boolean deleteteachersingle(@RequestParam int id){
        return service.deleteteachersingle(id);
    }
    @RequestMapping("/DeleteTeacherMultiple1")
    @ResponseBody
    public List<Boolean> deleteteachermultiple(@RequestParam List<Integer> ids){
        return service.deleteteachermultiple(ids);
    }
    @RequestMapping("/SelectTeacherAll1")
    @ResponseBody
    public List<Teacher> selectteacherall(){
        return service.selectteacherall();
    }
    @RequestMapping("/DeleteTeacherAll1")
    @ResponseBody
    public Boolean deleteteacherall(){
        return service.deleteteacherall();
    }

    @Autowired
    private TeacherServiceimpl service2;

    @RequestMapping("/InsertStudentSingle1")
    @ResponseBody
    public void insertstudentsingle(@RequestBody Student student){
        service2.insertstudentsingle(student);
    }
    @RequestMapping("/InsertStudentMultiple1")
    @ResponseBody
    public void insertstudentmultiple(@RequestBody List<Student> student){
        service2.insertstudentmultiple(student);
    }
    @RequestMapping("/SelectStudentSingle1")
    @ResponseBody
    public Student selectstudentsingle(@RequestParam int id){
        return service2.selectstudentsingle(id);
    }
    @RequestMapping("/SelectStudentMultiple1")
    @ResponseBody
    public List<Student> selectstudentmultiple(@RequestParam List<Integer> ids){
        return service2.selectstudentmultiple(ids);
    }
    @RequestMapping("/UpdateStudentSingle1")
    @ResponseBody
    public Student updatestudentsingle(@RequestBody Student student){
        return service2.updatestudentsingle(student);
    }
    @RequestMapping("/UpdateStudentMultiple1")
    @ResponseBody
    public List<Student> updatestudentmultiple(@RequestBody List<Student> student){
        return service2.updatestudentmultiple(student);
    }
    @RequestMapping("/DeleteStudentSingle1")
    @ResponseBody
    public Boolean deletestudentsingle(@RequestParam int id){
        return service2.deletestudentsingle(id);
    }
    @RequestMapping("/DeleteStudentMultiple1")
    @ResponseBody
    public List<Boolean> deletestudentmultiple(@RequestParam List<Integer> ids){
        return service2.deletestudentmultiple(ids);
    }
    @RequestMapping("/SelectStudentAll1")
    @ResponseBody
    public List<Student> selectstudentall(){
        return service2.selectstudentall();
    }
    @RequestMapping("/DeleteStudentAll1")
    @ResponseBody
    public Boolean deletestudentall(){
        return service2.deletestudentall();
    }

}
