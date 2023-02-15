package org.example.model;

import java.util.List;

public class Management {
    int id;
    String name,email;
    List<Teacher> teacherList;

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name= name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTeacherList(List<Teacher> teacherList){
        this.teacherList = teacherList;
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
    public List<Teacher> getTeacherList(){
        return teacherList;
    }
}
