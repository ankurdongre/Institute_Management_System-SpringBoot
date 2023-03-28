package org.example.repo;
import org.example.model.Student;
import org.example.repo.impl.TeacherRepoimpl;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepo implements TeacherRepoimpl {
    String url="jdbc:mysql://localhost:3306/institute_database";
    String user="root";
    String pass = "";
    @Override
    public void insertstudentsingle(Student student){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values('"+student.getRoll_no()+"','"+
                    student.getName()+"','"+student.getEmail()+"')");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Student selectstudentsingle(int roll_no){
        Student mt = new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where roll_no = '"+roll_no+"'");
            while (rs.next()){
                mt.setRoll_no(rs.getInt(1));
                mt.setName(rs.getString(2));
                mt.setEmail(rs.getString(3));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return mt;
    }
    @Override
    public Student updatestudentsingle(Student student){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update student set name = '"+student.getName()+"',email='"+
                    student.getEmail()+"' where id = '"+ student.getRoll_no()+"'");
            selectstudentsingle(student.getRoll_no());
        }catch (Exception e){
            System.out.println(e);
        }
        return student;
    }
    @Override
    public Boolean deletestudentsingle(int roll_no){
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student where roll_no = '"+roll_no +"'");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    @Override
    public List<Student> selectstudentall(){
        List<Student> studentList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()){
                Student mt = new Student();
                mt.setRoll_no(rs.getInt(1));
                mt.setName(rs.getString(2));
                mt.setEmail(rs.getString(3));
                studentList.add(mt);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public Boolean deletestudentall(){
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
