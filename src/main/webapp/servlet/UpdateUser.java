import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author dhx
 * 对于用户信息的修改,可以修改的值为name,tel,password
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
    public UpdateUser() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao=new UserDao();
        HttpSession session=req.getSession(true);

        int userId= (int) session.getAttribute("sessionId");
        String name=req.getParameter("userName").trim();
        String tel=req.getParameter("userTel").trim();
        String password=req.getParameter("userPassword").trim();
        User user=new User(userId,name,password,tel);
        //resultNum为受影响的行数,1表示更新成功，0表示更新失败
        int resultNum;
        try {
            resultNum=dao.update(user);
            if(resultNum==0){
                //更新失败
                req.setAttribute("infoCode","5");
            }
            if(resultNum==1){
                //更新成功
                req.setAttribute("infoCode","6");
            }
            RequestDispatcher rd=req.getRequestDispatcher("infoAlert.jsp");
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
