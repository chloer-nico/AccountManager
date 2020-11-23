import cn.hutool.log.StaticLog;

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
 * 检查用户是否存在
 * 接受参数：来自login.jsp的电话号码 tel以及密码 password
 */
@WebServlet("/LogCheck")
public class LogCheck extends HttpServlet {

    public LogCheck() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        String tel=req.getParameter("tel");
        String password=req.getParameter("password");
        try{
            //查询
            User user=userDao.queryByTel(tel);
            //用于转发页面
            RequestDispatcher rd;
            //设置session对象
            HttpSession session=req.getSession(true);
            //用户不存在，未注册,user为空
            if(user.getTel()==null){
                //设置infoCode，响应码，1表示用户未注册
//                session.setAttribute("infoCode","1");
                req.setAttribute("infoCode","1");
                //转到信息提示页面
                rd=req.getRequestDispatcher("infoAlert.jsp");
            }
            //用户存在但密码不正确
            else if(!password.equals(user.getPassword())){
                //infoCode=2表示用户密码不正确
//                session.setAttribute("infoCode","2");
                req.setAttribute("infoCode","2");
                rd=req.getRequestDispatcher("infoAlert.jsp");
            }
            //全部正确跳转center.jsp，个人中心
            else{
                session.setAttribute("sessionId",user.getId());
                session.setAttribute("sessionTel",user.getTel());
                session.setAttribute("sessionName",user.getName());
                session.setAttribute("sessionVip",user.isVip());
                rd=req.getRequestDispatcher("center.jsp");
            }
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
