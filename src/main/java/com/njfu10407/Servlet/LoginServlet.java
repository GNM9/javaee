package com.njfu10407.Servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njfu10407.Dao.AdminDao;
import com.njfu10407.Model.AdminModel;
import com.njfu10407.Util.StringUtil;

/**
 * 登录验证servlet
 */
public class LoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 6545114169688072191L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String admusername = request.getParameter("admusername");
        String admpassword = request.getParameter("admpassword");

        if(StringUtil.isEmpty(admusername) || StringUtil.isEmpty(admpassword)) {		//用户名或密码为空
            response.getWriter().write("blankError");
        }
        else {
            AdminDao adminDao = new AdminDao();
            AdminModel adminModel = adminDao.Login(admusername, admpassword);
            if(adminModel == null) {			//对象不为空说明匹配上了
                response.getWriter().write("loginFailed");
            }
            else {
                response.getWriter().write("loginSuccess");
            }
        }
    }
}

