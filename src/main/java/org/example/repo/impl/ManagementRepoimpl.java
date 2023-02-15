package org.example.repo.impl;

import org.example.model.Teacher;

import java.util.List;

public interface  ManagementRepoimpl {
    void insertteachersingle(Teacher teacher);
    void insertteacherstudentsingle(Teacher teacher);
    Teacher selectteachersingle(int id);
    Teacher selectteacherstudentsingle(int id);
    Teacher updateteachersingle(Teacher teacher);
    Boolean deleteteachersingle(int id);
    List<Teacher> selectteacherall();
    Boolean deleteteacherall();
}
