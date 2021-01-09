package com.njfu10407.Dao;

import java.sql.*;

import com.njfu10407.Util.DBUtil;

//基础操作类
public class BaseDao {

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public void close() {
        DBUtil.close(conn, ps, rs);
    }

    public BaseDao() {
        try {
            conn = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
