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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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
            String m1 = null;
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
            List<Student> studentList = new ArrayList<>();
            String s1 = null;
            for (int i = 0 ; i < tid.size();i++){
                Teacher teacher = new Teacher();
                ResultSet rs1 = st.executeQuery("select * from teacher where id = '"+tid.get(i)+"'");
                while (rs1.next()) {
                    teacher.setId(rs1.getInt(1));
                    teacher.setName(rs1.getString(2));
                    teacher.setEmail(rs1.getString(3));
                    s1 = rs1.getString(4);
                    teacher.setStudentList(studentList);
                }

                teacherList.add(teacher);
            }
            List<Integer> sid = new ArrayList<>();
            String[] s1Split = s1.split(",");
            for (int j = 0; j < s1Split.length; j++) {
                sid.add(Integer.parseInt(s1Split[j]));
            }
            for (int k = 0; k < sid.size(); k++) {
                Student student = new Student();
                    ResultSet rs2 = st.executeQuery("select * from student where roll_no = '" + sid.get(k) + "'");
                    while (rs2.next()) {
                        student.setRoll_no(rs2.getInt(1));
                        student.setName(rs2.getString(2));
                        student.setEmail(rs2.getString(3));
                    }
                studentList.add(student);
                }



        }catch (Exception e){
            System.out.println(e);
        }
        return management;
    }
    @Override
    public Management updatemanagementsingle(Management management){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update management set name = '"+management.getName()+"',email='"+
                    management.getEmail()+"' where id = '"+ management.getId()+"'");
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from management");
            while (rs.next()){
                Management mt = new Management();
                mt.setId(rs.getInt(1));
                mt.setName(rs.getString(2));
                mt.setEmail(rs.getString(3));
                managementList.add(mt);
            }
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
