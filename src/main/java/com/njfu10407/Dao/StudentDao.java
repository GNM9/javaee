package com.njfu10407.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.njfu10407.Model.StudentModel;

public class StudentDao extends BaseDao {
    public List<StudentModel> SearchStudent(String information, String curPage) {
        String sql = null;
        List<StudentModel> result = new ArrayList<>();
        try {
            sql = "select * from student where stuNo like ? limit ?,6";       //根据学号查找
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+information+"%");
            ps.setInt(2, (Integer.parseInt(curPage)-1)*6);

            rs = ps.executeQuery();

            while(rs.next()) {
                StudentModel sm = new StudentModel();
                sm.setStuNo(rs.getString("stuNo"));
                sm.setStuName(rs.getString("stuName"));
                sm.setStuClass(rs.getString("stuClass"));
                sm.setStuSex(rs.getString("stuSex"));
                sm.setStuDorm(rs.getString("stuDorm"));
                sm.setStuDepart(rs.getString("stuDepart"));
                sm.setStuTel(rs.getString("stuTel"));
                sm.setStuPhoto(rs.getString("stuPhoto"));
                result.add(sm);
            }

            sql = "select * from student where stuName like ? limit ?,6";       //根据姓名查找
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+information+"%");
            ps.setInt(2, (Integer.parseInt(curPage)-1)*6);

            rs = ps.executeQuery();

            while(rs.next()) {
                StudentModel sm = new StudentModel();
                sm.setStuNo(rs.getString("stuNo"));
                sm.setStuName(rs.getString("stuName"));
                sm.setStuClass(rs.getString("stuClass"));
                sm.setStuSex(rs.getString("stuSex"));
                sm.setStuDorm(rs.getString("stuDorm"));
                sm.setStuDepart(rs.getString("stuDepart"));
                sm.setStuTel(rs.getString("stuTel"));
                sm.setStuPhoto(rs.getString("stuPhoto"));
                result.add(sm);
            }

            sql = "select * from student where stuSex like ? limit ?,6";       //根据性别查找
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+information+"%");
            ps.setInt(2, (Integer.parseInt(curPage)-1)*6);

            rs = ps.executeQuery();

            while(rs.next()) {
                StudentModel sm = new StudentModel();
                sm.setStuNo(rs.getString("stuNo"));
                sm.setStuName(rs.getString("stuName"));
                sm.setStuClass(rs.getString("stuClass"));
                sm.setStuSex(rs.getString("stuSex"));
                sm.setStuDorm(rs.getString("stuDorm"));
                sm.setStuDepart(rs.getString("stuDepart"));
                sm.setStuTel(rs.getString("stuTel"));
                sm.setStuPhoto(rs.getString("stuPhoto"));
                result.add(sm);
            }

            sql = "select * from student where stuDorm like ? limit ?,6";       //根据宿舍查找
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+information+"%");
            ps.setInt(2, (Integer.parseInt(curPage)-1)*6);

            rs = ps.executeQuery();

            while(rs.next()) {
                StudentModel sm = new StudentModel();
                sm.setStuNo(rs.getString("stuNo"));
                sm.setStuName(rs.getString("stuName"));
                sm.setStuClass(rs.getString("stuClass"));
                sm.setStuSex(rs.getString("stuSex"));
                sm.setStuDorm(rs.getString("stuDorm"));
                sm.setStuDepart(rs.getString("stuDepart"));
                sm.setStuTel(rs.getString("stuTel"));
                sm.setStuPhoto(rs.getString("stuPhoto"));
                result.add(sm);
            }

            sql = "select * from student where stuDepart like ? limit ?,6";       //根据专业查找
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+information+"%");
            ps.setInt(2, (Integer.parseInt(curPage)-1)*6);

            rs = ps.executeQuery();

            while(rs.next()) {
                StudentModel sm = new StudentModel();
                sm.setStuNo(rs.getString("stuNo"));
                sm.setStuName(rs.getString("stuName"));
                sm.setStuClass(rs.getString("stuClass"));
                sm.setStuSex(rs.getString("stuSex"));
                sm.setStuDorm(rs.getString("stuDorm"));
                sm.setStuDepart(rs.getString("stuDepart"));
                sm.setStuTel(rs.getString("stuTel"));
                sm.setStuPhoto(rs.getString("stuPhoto"));
                result.add(sm);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            close();
        }
        return result;
    }

    public List<StudentModel> SearchAllStudent(String curPage) {
        String sql = null;
        List<StudentModel> result = new ArrayList<>();
        try {
            sql = "select * from student limit ?,6";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (Integer.parseInt(curPage)-1)*6);

            rs = ps.executeQuery();

            while(rs.next()) {
                StudentModel sm = new StudentModel();
                sm.setStuNo(rs.getString("stuNo"));
                sm.setStuName(rs.getString("stuName"));
                sm.setStuClass(rs.getString("stuClass"));
                sm.setStuSex(rs.getString("stuSex"));
                sm.setStuDorm(rs.getString("stuDorm"));
                sm.setStuDepart(rs.getString("stuDepart"));
                sm.setStuTel(rs.getString("stuTel"));
                sm.setStuPhoto(rs.getString("stuPhoto"));
                result.add(sm);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            close();
        }
        return result;
    }

    public int InsertStudent(String stuNo, String stuName, String stuClass, String stuSex, String stuDorm, String stuDepart, String stuTel) {
        String sql = null;
        int result = 0;
        try {
            sql = "insert into student values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stuClass);
            ps.setString(2, stuNo);
            ps.setString(3, stuName);
            ps.setString(4, stuSex);
            ps.setString(5, stuDorm);
            ps.setString(6, stuDepart);
            ps.setString(7, stuTel);
            if(stuSex.contentEquals("男")){
                ps.setString(8, "images/boy.jpg");
            }
            else{
                ps.setString(8, "images/girl.jpg");
            }

            result = ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            close();
        }
        return result;
    }

    public StudentModel SearchStudentByStuNo(String stuNo) {
        String sql = null;
        StudentModel result = null;
        try {
            sql = "select * from student where stuNo=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stuNo);

            rs = ps.executeQuery();

            if(rs.next()) {
                StudentModel sm = new StudentModel();
                sm.setStuNo(rs.getString("stuNo"));
                sm.setStuName(rs.getString("stuName"));
                sm.setStuClass(rs.getString("stuClass"));
                sm.setStuSex(rs.getString("stuSex"));
                sm.setStuDorm(rs.getString("stuDorm"));
                sm.setStuDepart(rs.getString("stuDepart"));
                sm.setStuTel(rs.getString("stuTel"));
                sm.setStuPhoto(rs.getString("stuPhoto"));
                result = sm;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            close();
        }
        return result;
    }

    public int UpdateStudent(String stuNo, String stuName, String stuClass, String stuSex, String stuDorm, String stuDepart, String stuTel)  {
        String sql = null;
        int result = 0;
        try {
            sql = "update student set stuName=?,stuClass=?,stuSex=?,stuDorm=?,stuDepart=?,stuTel=?,stuPhoto=? where stuno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stuName);
            ps.setString(2, stuClass);
            ps.setString(3, stuSex);
            ps.setString(4, stuDorm);
            ps.setString(5, stuDepart);
            ps.setString(6, stuTel);
            String stuPhoto = null;
            if(stuSex.contentEquals("男")){
                stuPhoto = "images/boy.jpg";
            }else{
                stuPhoto = "images/girl.jpg";
            }
            ps.setString(7, stuPhoto);
            ps.setString(8, stuNo);

            result = ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            close();
        }
        return result;
    }

    public int DeleteStudent(String stuNo) {
        String sql = null;
        int result = 0;
        try {
            sql = "delete from student where stuNo=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stuNo);

            result = ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            close();
        }
        return result;
    }
}
