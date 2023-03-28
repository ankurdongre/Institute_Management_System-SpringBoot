package org.example.service.impl;

import org.example.model.Teacher;

import java.util.List;

public interface ManagementServiceimpl {
    void insertteachersingle(Teacher teacher);
    void insertteachermultiple(List<Teacher> teacher);
    Teacher selectteachersingle(int id);
    List<Teacher> selectteachermultiple(List<Integer> ids);
    Teacher updateteachersingle(Teacher teacher);
    List<Teacher> updateteachermultiple(List<Teacher> teacher);
    Boolean deleteteachersingle(int id);
    List<Boolean> deleteteachermultiple(List<Integer> ids);
    List<Teacher> selectteacherall();
    Boolean deleteteacherall();
    Teacher assignteachersingle(Teacher teacher);
}
