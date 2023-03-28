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
public class AdminController{
    @Autowired
    private AdminServiceimpl service;

    @RequestMapping("/InsertManagementSingle")
    @ResponseBody
    public void insertmanagementsingle(@RequestBody Management management){
        service.insertmanagementsingle(management);
    }
    @RequestMapping("/InsertManagementMultiple")
    @ResponseBody
    public void insertmanagementmultiple(@RequestBody List<Management> management){
        service.insertmanagementmultiple(management);
    }
    @RequestMapping("/SelectManagementSingle")
    @ResponseBody
    public Management selectmanagementsingle(@RequestParam int id){
       return service.selectmanagementsingle(id);
    }
    @RequestMapping("/SelectManagementMultiple")
    @ResponseBody
    public List<Management> selectmanagementmultiple(@RequestParam List<Integer> ids){
        return service.selectmanagementmultiple(ids);
    }
    @RequestMapping("/UpdateManagementSingle")
    @ResponseBody
    public Management updatemanagementsingle(@RequestBody Management management){
        return service.updatemanagementsingle(management);
    }
    @RequestMapping("/UpdateManagementMultiple")
    @ResponseBody
    public List<Management> updatemanagementmultiple(@RequestBody List<Management> management){
        return service.updatemanagementmultiple(management);
    }
    @RequestMapping("/DeleteManagementSingle")
    @ResponseBody
    public Boolean deletemanagementsingle(@RequestParam int id){
        return service.deletemanagementsingle(id);
    }
    @RequestMapping("/DeleteManagementMultiple")
    @ResponseBody
    public List<Boolean> deletemanagementmultiple(@RequestParam List<Integer> ids){
        return service.deletemanagementmultiple(ids);
    }
    @RequestMapping("/SelectManagementAll")
    @ResponseBody
    public List<Management> selectmanagementall(){
        return service.selectmanagementall();
    }
    @RequestMapping("/DeleteManagementAll")
    @ResponseBody
    public Boolean deletemanagementall(){
        return service.deletemanagementall();
    }
    @Autowired
    private ManagementServiceimpl service1;
    @RequestMapping("/InsertTeacherSingle")
    @ResponseBody
    public void insertteachersingle(@RequestBody Teacher teacher){
        service1.insertteachersingle(teacher);
    }
    @RequestMapping("/InsertTeacherMultiple")
    @ResponseBody
    public void insertteachermultiple(@RequestBody List<Teacher> teacher){
        service1.insertteachermultiple(teacher);
    }
    @RequestMapping("/SelectTeacherSingle")
    @ResponseBody
    public Teacher selectteachersingle(@RequestParam int id){
        return service1.selectteachersingle(id);
    }
    @RequestMapping("/SelectTeacherMultiple")
    @ResponseBody
    public List<Teacher> selectteachermultiple(@RequestParam List<Integer> ids){
        return service1.selectteachermultiple(ids);
    }
    @RequestMapping("/UpdateTeacherSingle")
    @ResponseBody
    public Teacher updateteachersingle(@RequestBody Teacher teacher){
        return service1.updateteachersingle(teacher);
    }
    @RequestMapping("/UpdateTeacherMultiple")
    @ResponseBody
    public List<Teacher> updateteachermultiple(@RequestBody List<Teacher> teacher){
        return service1.updateteachermultiple(teacher);
    }
    @RequestMapping("/DeleteTeacherSingle")
    @ResponseBody
    public Boolean deleteteachersingle(@RequestParam int id){
        return service1.deleteteachersingle(id);
    }
    @RequestMapping("/DeleteTeacherMultiple")
    @ResponseBody
    public List<Boolean> deleteteachermultiple(@RequestParam List<Integer> ids){
        return service1.deleteteachermultiple(ids);
    }
    @RequestMapping("/SelectTeacherAll")
    @ResponseBody
    public List<Teacher> selectteacherall(){
        return service1.selectteacherall();
    }
    @RequestMapping("/DeleteTeacherAll")
    @ResponseBody
    public Boolean deleteteacherall(){
        return service1.deleteteacherall();
    }
    @RequestMapping("/AssignTeacherSingle")
    @ResponseBody
    public Teacher assignteachersingle(@RequestBody Teacher teacher){
        return service1.assignteachersingle(teacher);
    }

    @Autowired
    private TeacherServiceimpl service2;

    @RequestMapping("/InsertStudentSingle")
    @ResponseBody
    public void insertstudentsingle(@RequestBody Student student){
        service2.insertstudentsingle(student);
    }
    @RequestMapping("/InsertStudentMultiple")
    @ResponseBody
    public void insertstudentmultiple(@RequestBody List<Student> student){
        service2.insertstudentmultiple(student);
    }
    @RequestMapping("/SelectStudentSingle")
    @ResponseBody
    public Student selectstudentsingle(@RequestParam int roll_no){
        return service2.selectstudentsingle(roll_no);
    }
    @RequestMapping("/SelectStudentMultiple")
    @ResponseBody
    public List<Student> selectstudentmultiple(@RequestParam List<Integer> roll_nos){
        return service2.selectstudentmultiple(roll_nos);
    }
    @RequestMapping("/UpdateStudentSingle")
    @ResponseBody
    public Student updatestudentsingle(@RequestBody Student student){
        return service2.updatestudentsingle(student);
    }
    @RequestMapping("/UpdateStudentMultiple")
    @ResponseBody
    public List<Student> updatestudentmultiple(@RequestBody List<Student> student){
        return service2.updatestudentmultiple(student);
    }
    @RequestMapping("/DeleteStudentSingle")
    @ResponseBody
    public Boolean deletestudentsingle(@RequestParam int roll_no){
        return service2.deletestudentsingle(roll_no);
    }
    @RequestMapping("/DeleteStudentMultiple")
    @ResponseBody
    public List<Boolean> deletestudentmultiple(@RequestParam List<Integer> roll_nos){
        return service2.deletestudentmultiple(roll_nos);
    }
    @RequestMapping("/SelectStudentAll")
    @ResponseBody
    public List<Student> selectstudentall(){
        return service2.selectstudentall();
    }
    @RequestMapping("/DeleteStudentAll")
    @ResponseBody
    public Boolean deletestudentall(){
        return service2.deletestudentall();
    }
}
