package org.example.repo.impl;

import org.example.model.Student;

import java.util.List;

public interface TeacherRepoimpl {
    void insertstudentsingle(Student student);
    Student selectstudentsingle(int id);
    Student updatestudentsingle(Student student);
    Boolean deletestudentsingle(int id);
    List<Student> selectstudentall();
    Boolean deletestudentall();

}
