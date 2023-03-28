package org.example.model;

import java.util.List;

public class Teacher {
    int id;
    String name,email;
    List<Student> studentList;
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name= name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setStudentList(List<Student> studentList){
        this.studentList = studentList;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public List<Student> getStudentList(){
        return studentList;
    }
}
