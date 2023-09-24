package servlet;

import Logs.SaveLog;
import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User loginUser = userDao.login(username,password);
        HttpSession session = request.getSession();
        if(loginUser != null){
            SaveLog saveLog = new SaveLog();
            saveLog.saveLoginLog(loginUser);

            //用户登录成功
            //将用户存入session中
            session.setAttribute("user",loginUser);
            session.setAttribute("visitor","false");
            response.sendRedirect(request.getContextPath() + "/static/pages/index.jsp");

        }else{
            //用户登录失败
            session.setAttribute("login_msg","用户名或密码错误！");
            response.sendRedirect(request.getContextPath() + "/static/pages/login.jsp");
            return;
        }
    }
}
