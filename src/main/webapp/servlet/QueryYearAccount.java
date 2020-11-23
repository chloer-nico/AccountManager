import cn.hutool.log.StaticLog;
import examples.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author dhx
 * 查询年度账单
 */
@WebServlet("/QueryYearAccount")
public class QueryYearAccount extends HttpServlet {
    public QueryYearAccount() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(true);
        int id= (int) session.getAttribute("sessionId");
        String year=req.getParameter("year");
        AccountDao dao=new AccountDao();
        try {
            List<Account> list=dao.queryByYear(id,year);
            //计算每个月的收入和支出
            double[] income =new double[13];
            double[] expense =new double[13];
            //初始化
            for(double i:income){
                i=0.0;
            }
            for(double i:expense){
                i=0.0;
            }
            for(Account account:list){
                //将date类型转为calendar类型
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(account.getTime());
                StaticLog.info("date="+account.getTime());
                StaticLog.info("calendar="+calendar);
                //判断date的月份
                int month=calendar.get(Calendar.MONTH);
                //month是从0开始的，所以+1
                month++;
                //判断类型
                switch (account.getType()){
                    case "收入":
                        StaticLog.info("accountId="+account.getAccountId()+"为收入");
                        //判断月份
                        switch (month){
                            case 1:income[1]+=account.getMoney();break;
                            case 2:income[2]+=account.getMoney();break;
                            case 3:income[3]+=account.getMoney();break;
                            case 4:income[4]+=account.getMoney();break;
                            case 5:income[5]+=account.getMoney();break;
                            case 6:income[6]+=account.getMoney();break;
                            case 7:income[7]+=account.getMoney();break;
                            case 8:income[8]+=account.getMoney();break;
                            case 9:income[9]+=account.getMoney();break;
                            case 10:income[10]+=account.getMoney();StaticLog.info("月份为"+month+"金额为"+account.getMoney());break;
                            case 11:income[11]+=account.getMoney();StaticLog.info("月份为"+month+"金额为"+account.getMoney());break;
                            case 12:income[12]+=account.getMoney();break;
                            default:break;
                        }break;

                    //除收入以外全为支出
                    default:
                        StaticLog.info("accountId="+account.getAccountId()+"为支出,month="+month);
                        switch (month){
                            case 1:expense[1]+=account.getMoney();StaticLog.info("月份为"+month+"金额为"+account.getMoney());break;
                            case 2:expense[2]+=account.getMoney();break;
                            case 3:expense[3]+=account.getMoney();break;
                            case 4:expense[4]+=account.getMoney();break;
                            case 5:expense[5]+=account.getMoney();break;
                            case 6:expense[6]+=account.getMoney();break;
                            case 7:expense[7]+=account.getMoney();break;
                            case 8:expense[8]+=account.getMoney();break;
                            case 9:expense[9]+=account.getMoney();break;
                            case 10:expense[10]+=account.getMoney();StaticLog.info("月份为"+month+"金额为"+account.getMoney());break;
                            case 11:expense[11]+=account.getMoney();StaticLog.info("月份为"+month+"金额为"+account.getMoney());break;
                            case 12:expense[12]+=account.getMoney();break;
                            default:break;
                        }break;
                }
            }
            session.setAttribute("arrayIncome",income);
            session.setAttribute("arrayExpense",expense);
            RequestDispatcher rd;
            rd=req.getRequestDispatcher("yearChart.jsp");
            rd.forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
