package ra.service;

import ra.model.Student;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceIPM implements IGeneric<Student> {
    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call PROC_getAll()}");
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
                list.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call PROC_finById(?)}");
            call.setInt(1, id);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                student.setId(id);
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call PROC_update(?,?,?,?)}");
            call.setInt(1,student.getId());
            call.setString(2,student.getName());
            call.setInt(3,student.getAge());
            call.setBoolean(4,student.isSex());
            call.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call PROC_deleteById(?)}");
            call.setInt(1,id);
            call.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean save(Student student) {
      Connection conn = null;
      try {
          conn = ConnectionDB.getConnection();
          CallableStatement call = conn.prepareCall("{call PROC_create(?,?,?)}");
          call.setString(1,student.getName());
          call.setInt(2,student.getAge());
          call.setBoolean(3,student.isSex());
          call.executeUpdate();
      } catch (Exception e){
          e.printStackTrace();
          return false;
      }
        return true;
    }
}
