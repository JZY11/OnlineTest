package demo.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhenya.1291813139.com
 * on 2017/6/17.
 * OnlineTest.
 */
public class Error {
    public static void showErrorMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "出了点问题...");
        req.getRequestDispatcher("default.jsp").forward(req,resp);
    }
}
