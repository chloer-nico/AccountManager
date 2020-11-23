import examples.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dhx
 * 更新account表
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
    public UpdateAccount() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDao dao=new AccountDao();
        HttpSession session=req.getSession(true);
        int userId= (int) session.getAttribute("sessionId");
        int accountId= Integer.parseInt(req.getParameter("accountId"));
        String strTime=req.getParameter("time");
        RequestDispatcher rd;
        if(strTime.equals("")){
            req.setAttribute("infoCode","10");
            rd=req.getRequestDispatcher("infoAlert.jsp");
            rd.forward(req,resp);
        }
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date time=format.parse(strTime);
            String type=req.getParameter("type");
            double money= Double.parseDouble(req.getParameter("money"));
            String remark=req.getParameter("remark");
            Account account=new Account(accountId,userId,time,type,money,remark);
            //resultNum为受影响的行数,1表示更新成功，0表示更新失败
            int resultNum;
            resultNum=dao.update(account);
            //成功
            if(resultNum==1){
                req.setAttribute("infoCode","9");
            }
            //失败
            else if(resultNum==0){
                req.setAttribute("infoCode","10");
            }
            rd=req.getRequestDispatcher("infoAlert.jsp");
            rd.forward(req,resp);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
