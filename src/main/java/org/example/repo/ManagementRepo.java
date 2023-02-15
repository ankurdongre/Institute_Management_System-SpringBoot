package org.example.repo;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repo.impl.ManagementRepoimpl;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagementRepo implements ManagementRepoimpl {
    String url="jdbc:mysql://localhost:3306/institute_database";
    String user="root";
    String pass = "";
    @Override
    public void insertteachersingle(Teacher teacher){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("insert into teacher values ('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getEmail()+"')");

        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public void insertteacherstudentsingle(Teacher teacher){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            String idt = String.valueOf(teacher.getStudentList().get(0).getRoll_no());
            for(int i = 1 ; i < teacher.getStudentList().size();i++){
                idt = idt + "," + teacher.getStudentList().get(i).getRoll_no();}
            st.executeUpdate("insert into teacher values ('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getEmail()+"','"+idt+"')");
            for(int i = 0 ; i < teacher.getStudentList().size();i++) {
                st.executeUpdate("insert into student values('"+
                        teacher.getStudentList().get(i).getRoll_no()+"','"+
                        teacher.getStudentList().get(i).getName()+"','"+
                        teacher.getStudentList().get(i).getEmail()+"')");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Teacher selectteachersingle(int id){
        Teacher teacher = new Teacher();
        try {
            String s1 = null;
            List<Student> studentList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher where id = '"+id+"'");
            while (rs.next()){
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
                teacher.setStudentList(studentList);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return teacher;
    }
    @Override
    public Teacher selectteacherstudentsingle(int id){
        Teacher teacher = new Teacher();
        try {
            String s1 = null;
            List<Student> studentList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher where id = '"+id+"'");
            List<Integer> integerList = new ArrayList<>();
            while (rs.next()){
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
                teacher.setStudentList(studentList);
                s1 = rs.getString(4);
            }
            String[] s1Split = s1.split(",");
            for (int i = 0 ; i < s1Split.length ; i++){
                integerList.add(Integer.parseInt(s1Split[i]));
            }
            for(int i = 0 ; i< integerList.size();i++){
                Student student = new Student();
                ResultSet rs1 = st.executeQuery("select * from student where roll_no = '"+integerList.get(i)+"'");
                while (rs1.next()){
                    student.setRoll_no(rs1.getInt(1));
                    student.setName(rs1.getString(2));
                    student.setEmail(rs1.getString(3));
                }
                studentList.add(student);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return teacher;
    }
    @Override
    public Teacher updateteachersingle(Teacher teacher){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update teacher set name = '"+teacher.getName()+"',email='"+
                    teacher.getEmail()+"' where id = '"+ teacher.getId()+"'");
            selectteachersingle(teacher.getId());
        }catch (Exception e){
            System.out.println(e);
        }
        return teacher;
    }
    @Override
    public Boolean deleteteachersingle(int id){
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher where id = '"+id +"'");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public List<Teacher> selectteacherall(){
        List<Teacher> teacherList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher");
            while (rs.next()){
                Teacher mt = new Teacher();
                mt.setId(rs.getInt(1));
                mt.setName(rs.getString(2));
                mt.setEmail(rs.getString(3));
                teacherList.add(mt);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return teacherList;
    }
    @Override
    public Boolean deleteteacherall(){
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
