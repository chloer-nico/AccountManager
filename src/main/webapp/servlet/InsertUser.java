import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @author dhx
 * 注册用户，向user表插入数据
 */
@WebServlet("/InsertUser")
public class InsertUser extends HttpServlet {
    public InsertUser(){}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao=new UserDao();
        String name = req.getParameter("userName").trim();
        String password = req.getParameter("userPassword").trim();
        String tel = req.getParameter("userTel").trim();
        User user=new User(name,password,tel,false);
        boolean insertResult;
        try {
            insertResult=dao.insert(user);
            //注册成功
            RequestDispatcher rd;
            if(insertResult){
                req.setAttribute("infoCode","3");
            }
            else {
                req.setAttribute("infoCode","4");
            }
            rd=req.getRequestDispatcher("infoAlert.jsp");
            rd.forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
