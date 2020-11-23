import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author dhx
 * 删除Account表
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
    public DeleteAccount() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDao dao=new AccountDao();
        HttpSession session=req.getSession(true);
        int accountId= Integer.parseInt(req.getParameter("accountId"));
        try {
            int result=dao.delete(accountId);
            RequestDispatcher rd;
            if(result==1){
                req.setAttribute("infoCode","11");
            }
            else if(result==0){
                req.setAttribute("infoCode","12");
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
