package demo.servlet;

import demo.util.Error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhenya.1291813139.com
 * on 2017/6/17.
 * OnlineTest.
 */
@WebServlet(urlPatterns = "/student")
public class UserAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("register".equals(action)) {
            register(req,resp);
            return;
        }

        req.setAttribute("message", "出现了一点问题。。。");
        req.getRequestDispatcher("default.jsp").forward(req, resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String usernameSql = "SELECT * FROM db_onlineTest.user WHERE username = ? ";
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(usernameSql);
            }else {
                Error.showErrorMessage(req, resp);
                return;
            }
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            boolean isUsernameExit = resultSet.next();

            if (isUsernameExit){
                req.setAttribute("message","用户名已存在，请更换");
            }else {
                String sql = "INSERT INTO db_onlineTest.user VALUE (NULL ,?,password)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.executeUpdate();
                resp.sendRedirect("default.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @Override
        protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }
}
