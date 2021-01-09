package com.njfu10407.Servlet;

import com.google.gson.Gson;
import com.njfu10407.Dao.StudentDao;
import com.njfu10407.Model.StudentModel;
import com.njfu10407.Util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 295557922308016366L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        String method = request.getParameter("method");
        if(!(StringUtil.isEmpty(method))) {
            if(method.contentEquals("Search")) {
                StudentList(request, response);
            }
            else if(method.contentEquals("Insert")) {
                StudentInsert(request, response);
            }
           else if(method.contentEquals("SearchOneByStuNo")) {
                StudentSearchByStuNo(request, response);
            }
            else if(method.contentEquals("Update")) {
                StudentUpdate(request, response);
            }
            else if(method.contentEquals("Delete")) {
                StudentDelete(request, response);
            }
        }
    }

    private void StudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String stuInfo = request.getParameter("searchText");
        String curPage = request.getParameter("curPage");
        if(!(StringUtil.isEmpty(stuInfo))) {		//所给信息不为空按照给定的条件select
            StudentDao studentDao = new StudentDao();
            List<StudentModel> studentModel = new ArrayList<>();
            studentModel = studentDao.SearchStudent(stuInfo, curPage);
            if(studentModel != null) {
                    String json = new Gson().toJson(studentModel);
                    response.getWriter().write(json);
                    System.out.println(json);
            }
        }
        else {		//所给信息为空就直接全部select出来
            StudentDao studentDao = new StudentDao();
            List<StudentModel> studentModel = new ArrayList<>();
            studentModel = studentDao.SearchAllStudent(curPage);
            if(studentModel != null) {
                String json = new Gson().toJson(studentModel);
                response.getWriter().write(json);
                System.out.println(json);
            }
        }
    }

    private void StudentInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String stuNo = request.getParameter("stuNoText");
        String stuName = request.getParameter("stuNameText");
        String stuClass = request.getParameter("stuClassText");
        String stuSex = request.getParameter("stuSexRadio");
        String stuDorm = request.getParameter("stuDormText");
        String stuDepart = request.getParameter("stuDepartText");
        String stuTel = request.getParameter("stuTelText");
        if(!(StringUtil.isEmpty(stuNo)) && !(StringUtil.isEmpty(stuName)) && !(StringUtil.isEmpty(stuClass)) && !(StringUtil.isEmpty(stuSex)) && !(StringUtil.isEmpty(stuDorm)) && !(StringUtil.isEmpty(stuDepart)) && !(StringUtil.isEmpty(stuTel))) {
            StudentDao studentDao = new StudentDao();
            int success = studentDao.InsertStudent(stuNo, stuName, stuClass, stuSex, stuDorm, stuDepart, stuTel);
            if(success==1) {
                response.getWriter().write("insertSuccess");
            }
        }
        else {
            response.getWriter().write("insertBlank");
        }
    }

    private void StudentSearchByStuNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String stuNo = request.getParameter("stuNo");
        if(!(StringUtil.isEmpty(stuNo))) {
            StudentDao studentDao = new StudentDao();
            StudentModel studentModel = studentDao.SearchStudentByStuNo(stuNo);
            if(studentModel != null) {
                String json = new Gson().toJson(studentModel);
                response.getWriter().write(json);
                System.out.println(json);
            }
        }
    }

    private void StudentUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String stuNo = request.getParameter("stuNoText");
        String stuName = request.getParameter("stuNameText");
        String stuClass = request.getParameter("stuClassText");
        String stuSex = request.getParameter("stuSexRadio");
        String stuDorm = request.getParameter("stuDormText");
        String stuDepart = request.getParameter("stuDepartText");
        String stuTel = request.getParameter("stuTelText");
        if(!(StringUtil.isEmpty(stuNo)) && !(StringUtil.isEmpty(stuName)) && !(StringUtil.isEmpty(stuClass)) && !(StringUtil.isEmpty(stuSex)) && !(StringUtil.isEmpty(stuDorm)) && !(StringUtil.isEmpty(stuDepart)) && !(StringUtil.isEmpty(stuTel))) {
            StudentDao studentDao = new StudentDao();
            int success = studentDao.UpdateStudent(stuNo, stuName, stuClass, stuSex, stuDorm, stuDepart, stuTel);
            if(success==1) {
                response.getWriter().write("updateSuccess");
            }
        }
        else {
            response.getWriter().write("updateBlank");
        }
    }

    private void StudentDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String stuNo = request.getParameter("stuNo");
        if(!(StringUtil.isEmpty(stuNo))) {		//所给数据不为空按照给定的stuNo进行delete
            StudentDao studentDao = new StudentDao();
            int success = studentDao.DeleteStudent(stuNo);
            if(success==1) {
                response.getWriter().write("deleteSuccess");
            }
            else{
                response.getWriter().write("deleteFailed");
            }
        }
    }
}
