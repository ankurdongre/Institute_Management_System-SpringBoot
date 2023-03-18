package org.example.service;
import org.example.model.Teacher;
import org.example.repo.impl.ManagementRepoimpl;
import org.example.service.impl.ManagementServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementService implements ManagementServiceimpl {
    @Autowired
    private ManagementRepoimpl repo;
    @Override
    public void insertteachersingle(Teacher teacher){
        repo.insertteachersingle(teacher);
    }

    @Override
    public void insertteachermultiple(List<Teacher> teacher){
        for (int i = 0;i<teacher.size();i++){
            repo.insertteachersingle(teacher.get(i));
        }
    }

    @Override
    public Teacher selectteachersingle(int id){
        return repo.selectteachersingle(id);
    }

    @Override
    public List<Teacher> selectteachermultiple(List<Integer> ids){
        List<Teacher> teacherList = new ArrayList<>();
        for (int i = 0;i<ids.size();i++){
            Teacher m1 =repo.selectteachersingle(ids.get(i));
            teacherList.add(m1);
        }
        return teacherList;
    }

    @Override
    public Teacher updateteachersingle(Teacher teacher){
        return repo.updateteachersingle(teacher);
    }
    @Override
    public List<Teacher> updateteachermultiple(List<Teacher> teacher){
        List<Teacher> teacherList = new ArrayList<>();
        for (int i = 0;i<teacher.size();i++){
            Teacher m1 = updateteachersingle(teacher.get(i));
            teacherList.add(m1);
        }
        return teacherList;
    }
    @Override
    public Boolean deleteteachersingle(int id){
        return repo.deleteteachersingle(id);
    }
    @Override
    public List<Boolean> deleteteachermultiple(List<Integer> ids){
        List<Boolean> result = new ArrayList<>();
        for (int i = 0;i<ids.size();i++){
            Boolean b1 = deleteteachersingle(ids.get(i));
            result.add(b1);
        }
        return result;
    }
    @Override
    public List<Teacher> selectteacherall(){
        return repo.selectteacherall();
    }
    @Override
    public Boolean deleteteacherall(){
        return repo.deleteteacherall();
    }
}
