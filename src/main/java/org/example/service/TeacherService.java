package org.example.service;
import org.example.model.Student;
import org.example.repo.impl.TeacherRepoimpl;
import org.example.service.impl.TeacherServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherServiceimpl {
    @Autowired
    private TeacherRepoimpl repo;
    @Override
    public void insertstudentsingle(Student student){
        repo.insertstudentsingle(student);
    }
    @Override
    public void insertstudentmultiple(List<Student> student){
        for (int i = 0;i<student.size();i++){
            repo.insertstudentsingle(student.get(i));
        }
    }
    @Override
    public Student selectstudentsingle(int roll_no){
        return repo.selectstudentsingle(roll_no);
    }
    @Override
    public List<Student> selectstudentmultiple(List<Integer> roll_nos){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0;i<roll_nos.size();i++){
            Student m1 =repo.selectstudentsingle(roll_nos.get(i));
            studentList.add(m1);
        }
        return studentList;
    }
    @Override
    public Student updatestudentsingle(Student student){
        return repo.updatestudentsingle(student);
    }
    @Override
    public List<Student> updatestudentmultiple(List<Student> student){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0;i<student.size();i++){
            Student m1 = updatestudentsingle(student.get(i));
            studentList.add(m1);
        }
        return studentList;
    }
    @Override
    public Boolean deletestudentsingle(int roll_no){
        return repo.deletestudentsingle(roll_no);
    }
    @Override
    public List<Boolean> deletestudentmultiple(List<Integer> roll_nos){
        List<Boolean> result = new ArrayList<>();
        for (int i = 0;i<roll_nos.size();i++){
            Boolean b1 = deletestudentsingle(roll_nos.get(i));
            result.add(b1);
        }
        return result;
    }
    @Override
    public List<Student> selectstudentall(){
        return repo.selectstudentall();
    }
    @Override
    public Boolean deletestudentall(){
        return repo.deletestudentall();
    }
}
