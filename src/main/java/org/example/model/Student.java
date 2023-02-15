package org.example.model;
public class Student {
    int roll_no;
    String name,email;
    public void setRoll_no(int roll_no){
        this.roll_no = roll_no;
    }
    public void setName(String name){
        this.name= name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getRoll_no(){
        return roll_no;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
}
