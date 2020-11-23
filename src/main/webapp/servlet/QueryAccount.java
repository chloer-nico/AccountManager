import cn.hutool.core.date.DateUtil;
import cn.hutool.log.StaticLog;
import examples.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
import java.util.List;

/**
 * @author dhx
 * 查询账目中所有的账单
 * 接受参数：起始日期:beginDate,结束日期:endDate
 */
@WebServlet("/QueryAccount")
public class QueryAccount extends HttpServlet {
    public QueryAccount() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        java.sql.Date sqlBeginDate = null,sqlEndDate=null;
        //获取当前用户的id
        HttpSession session=req.getSession(true);
        int id= (int) session.getAttribute("sessionId");

            String strBeginDate=req.getParameter("beginDate");
            String strEndDate=req.getParameter("endDate");
            //首先将字符串转为date类型
            DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate= null;
            Date endDate= null;
            try {
                beginDate = format.parse(strBeginDate);
                endDate = format.parse(strEndDate);
                //再将java.util.date转为java.sql.date
                sqlBeginDate = new java.sql.Date(beginDate.getTime());
                sqlEndDate = new java.sql.Date(endDate.getTime());
                AccountDao dao=new AccountDao();
                List<Account> list= null;
                list = dao.queryByDate(sqlBeginDate,sqlEndDate,id);
                session.setAttribute("sessionList",list);
                RequestDispatcher rd;
                rd=req.getRequestDispatcher("./AccountJsp/index.jsp");
                rd.forward(req,resp);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
