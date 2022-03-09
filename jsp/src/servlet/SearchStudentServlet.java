package servlet;

import pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Charley
 * @creat 2021-06-02 19:32
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            int t = i + 1;
            list.add(new Student(t, "name"+t, 18+t, "phone"+t));
        }
        //保存在request域中
        req.setAttribute("StuList", list);
        //请求转发到showStudent.jsp
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);
    }
}
