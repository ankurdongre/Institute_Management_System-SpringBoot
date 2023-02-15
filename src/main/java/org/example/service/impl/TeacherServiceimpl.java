package org.example.service.impl;

import org.example.model.Student;

import java.util.List;

public interface TeacherServiceimpl {
    void insertstudentsingle(Student student);
    void insertstudentmultiple(List<Student> student);
    Student selectstudentsingle(int id);
    List<Student> selectstudentmultiple(List<Integer> ids);
    Student updatestudentsingle(Student student);
    List<Student> updatestudentmultiple(List<Student> student);
    Boolean deletestudentsingle(int id);
    List<Boolean> deletestudentmultiple(List<Integer> ids);
    List<Student> selectstudentall();
    Boolean deletestudentall();
}
