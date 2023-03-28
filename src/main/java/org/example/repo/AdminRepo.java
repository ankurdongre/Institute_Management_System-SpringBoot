package org.example.repo;
import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repo.impl.AdminRepoimpl;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AdminRepo implements AdminRepoimpl {
    String url="jdbc:mysql://localhost:3306/institute_database";
    String user="root";
    String pass = "";
    @Override
    public void insertmanagementsingle(Management management){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            String idt = String.valueOf(management.getTeacherList().get(0).getId());
            for(int i = 1 ; i < management.getTeacherList().size();i++){
                    idt = idt + "," + management.getTeacherList().get(i).getId();
            }st.executeUpdate("insert into management values('"+
                    management.getId()+"','"+
                    management.getName()+"','"+management.getEmail()+"','"+idt+"')");
            for(int i = 0 ; i < management.getTeacherList().size();i++) {
                String ids = String.valueOf(management.getTeacherList().get(i).getStudentList().get(0).getRoll_no());
                for(int j = 1 ; j < management.getTeacherList().get(i).getStudentList().size();j++) {
                    ids = ids + "," + management.getTeacherList().get(i).getStudentList().get(j).getRoll_no();
                }
                st.executeUpdate("insert into teacher values('"+
                        management.getTeacherList().get(i).getId()+"','"+
                        management.getTeacherList().get(i).getName()+"','"+
                        management.getTeacherList().get(i).getEmail()+"','"+ids+"')");
            }
            for(int i = 0 ; i < management.getTeacherList().size();i++) {
                for(int j = 0 ; j < management.getTeacherList().get(i).getStudentList().size();j++) {
                    st.executeUpdate("insert into student values('" +
                            management.getTeacherList().get(i).getStudentList().get(j).getRoll_no() + "','" +
                            management.getTeacherList().get(i).getStudentList().get(j).getName() + "','" +
                            management.getTeacherList().get(i).getStudentList().get(j).getEmail() + "')");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Management selectmanagementsingle(int id){
        Management management = new Management();
        try {
            String m1 = "";
            List<Teacher> teacherList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from management where id = '"+id+"'");
            while (rs.next()){
                management.setId(rs.getInt(1));
                management.setName(rs.getString(2));
                management.setEmail(rs.getString(3));
                management.setTeacherList(teacherList);
                m1 = rs.getString(4);
            }
            List<Integer> tid = new ArrayList<>();
            String[] m1Split = m1.split(",");
            for(int i = 0; i < m1Split.length ; i++){
                tid.add(Integer.parseInt(m1Split[i]));
            }
            for (int i = 0 ; i < tid.size();i++){
                Teacher teacher = new Teacher();
                ResultSet rs1 = st.executeQuery("select * from teacher where id = '"+tid.get(i)+"'");
                while (rs1.next()) {
                    teacher.setId(rs1.getInt(1));
                    teacher.setName(rs1.getString(2));
                    teacher.setEmail(rs1.getString(3));
                    teacher.setStudentList(Method(rs1.getString(4)));
                }
                teacherList.add(teacher);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return management;
    }
    public List<Student> Method(String s1 ) {
        List<Student> studentList = new ArrayList<>();
        try {
            List<Integer> integerList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String[] s1Split = s1.split(",");
            for (int i = 0; i < s1Split.length; i++) {
                integerList.add(Integer.parseInt(s1Split[i]));
            }
            for (int i = 0; i < integerList.size(); i++) {
                Student student = new Student();
                ResultSet rs1 = st.executeQuery("select * from student where roll_no = '" + integerList.get(i) + "'");
                while (rs1.next()) {
                    student.setRoll_no(rs1.getInt(1));
                    student.setName(rs1.getString(2));
                    student.setEmail(rs1.getString(3));
                }
                studentList.add(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public Management updatemanagementsingle(Management management){
        try {
            Teacher teacher = new Teacher();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update management set name = '"+management.getName()+"',email='"+
                    management.getEmail()+"' where id = '"+ management.getId()+"'");
            ResultSet rs = st.executeQuery("select * from management where id = '"+management.getId()+"'");
            String m1 = "";
            while (rs.next()){
                m1 = rs.getString(4);
            }
            String [] m1Split = m1.split(",");
            for (int i = 0 ; i< m1Split.length;i++){
                st.executeUpdate("update teacher set name = '"+management.getTeacherList().get(i).getName()+"',email='"+
                        management.getTeacherList().get(i).getEmail()+"' where id = '"+ management.getTeacherList().get(i).getId()+"'");
                ResultSet rs1 = st.executeQuery("select * from teacher where id = '"+teacher.getId()+"'");
            String s1 = "";
            while (rs1.next()){
                s1 = (rs1.getString(4));
            }
            String [] s1Split = s1.split(",");
            for (int j = 0 ; j< s1Split.length;j++){
                st.executeUpdate("update student set name = '"+management.getTeacherList().get(i).getStudentList().get(j).getName()+"',email='"+
                        management.getTeacherList().get(i).getStudentList().get(j).getEmail()+"' where roll_no = '"+ management.getTeacherList().get(i).getStudentList().get(j).getRoll_no()+"'");
            }
            }
            selectmanagementsingle(management.getId());
        }catch (Exception e){
            System.out.println(e);
        }
        return management;
    }
    @Override
    public Boolean deletemanagementsingle(int id){
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from management where id = '"+id +"'");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public List<Management> selectmanagementall(){
        List<Management> managementList = new ArrayList<>();
        try {
            List<Integer> integerList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from management");
            while (rs.next()){
                integerList.add(rs.getInt(1));
            }
            for (int i = 0;i<integerList.size();i++){
                Management m1 =selectmanagementsingle(integerList.get(i));
                managementList.add(m1);
            }
            return managementList;
        }catch (Exception e){
            System.out.println(e);
        }
        return managementList;
    }
    @Override
    public Boolean deletemanagementall(){
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from management");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
