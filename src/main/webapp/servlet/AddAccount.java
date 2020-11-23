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
 * 向account表增加一条记录
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
//    public class InsertUser extends HttpServlet {
//        public InsertUser(){}
//
//        @Override
//        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            UserDao dao=new UserDao();
//            String name = req.getParameter("userName").trim();
//            String password = req.getParameter("userPassword").trim();
//            String tel = req.getParameter("userTel").trim();
//            User user=new User(name,password,tel,false);
//            boolean insertResult;
//            try {
//                insertResult=dao.insert(user);
//                //注册成功
//                RequestDispatcher rd;
//                if(insertResult){
//                    req.setAttribute("infoCode","3");
//                }
//                else {
//                    req.setAttribute("infoCode","4");
//                }
//                rd=req.getRequestDispatcher("infoAlert.jsp");
//                rd.forward(req,resp);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

    public AddAccount() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDao dao=new AccountDao();
        HttpSession session=req.getSession(true);
        RequestDispatcher rd;
        int userId= (int) session.getAttribute("sessionId");
        String strTime=req.getParameter("time").trim();
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Date time= null;
        if(strTime.equals("")){
            req.setAttribute("infoCode","8");
            rd=req.getRequestDispatcher("infoAlert.jsp");
            rd.forward(req,resp);
        }
        try {
            //string->date
            time = format.parse(strTime);
            String type=req.getParameter("type").trim();
            Double money= Double.valueOf(req.getParameter("money"));
            String remark=req.getParameter("remark").trim();
            Account account=new Account(userId,time,type,money,remark);

            boolean insertResult;
            insertResult=dao.add(account);
            //新加成功

            if(insertResult){
                req.setAttribute("infoCode","7");
            }
            else {//失败
                req.setAttribute("infoCode","8");
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
        doPost(req,resp);
    }
}
