package com.njfu10407.Dao;

import java.sql.SQLException;

import com.njfu10407.Model.AdminModel;

//管理员数据库操作封装
public class AdminDao extends BaseDao {
    public AdminModel Login(String admusername, String admpassword) {
        try{
            String sql = "select * from admin where adminname=? and adminpassword=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, admusername);
            ps.setString(2, admpassword);

            rs = ps.executeQuery();

            if(rs.next()){
                AdminModel adminModel = new AdminModel();
                adminModel.setAdminname(rs.getString("adminname"));
                adminModel.setAdminpassword(rs.getString("adminpassword"));
                return adminModel;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            close();
        }
        return null;
    }
}

