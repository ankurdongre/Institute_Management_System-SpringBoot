package org.example.service.impl;

import org.example.model.Teacher;

import java.util.List;

public interface ManagementServiceimpl {
    void insertteachersingle(Teacher teacher);
    void insertteacherstudentsingle(Teacher teacher);
    void insertteachermultiple(List<Teacher> teacher);
    void insertteacherstudentmultiple(List<Teacher> teacher);
    Teacher selectteachersingle(int id);
    Teacher selectteacherstudentsingle(int id);
    List<Teacher> selectteachermultiple(List<Integer> ids);
    List<Teacher> selectteacherstudentmultiple(List<Integer> ids);
    Teacher updateteachersingle(Teacher teacher);
    List<Teacher> updateteachermultiple(List<Teacher> teacher);
    Boolean deleteteachersingle(int id);
    List<Boolean> deleteteachermultiple(List<Integer> ids);
    List<Teacher> selectteacherall();
    List<Teacher> selectteacherstudentall();
    Boolean deleteteacherall();
}
