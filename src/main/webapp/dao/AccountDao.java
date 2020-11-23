import cn.hutool.log.StaticLog;
import examples.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dhx
 * 对于account表的操作
 */
public class AccountDao {

    /**查询指定用户，在指定日期内的账单数据*/
    public List<Account> queryByDate(java.sql.Date beginDate, java.sql.Date endDate, int id) throws Exception {
        List<Account> list=new ArrayList<>();
        Connection conn=JdbcUtil.getConnection();
        String sql="select * from account where userid = ? and time between ? and ?";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setInt(1,id);
        pState.setString(2, String.valueOf(beginDate));
        pState.setString(3, String.valueOf(endDate));

        ResultSet result=pState.executeQuery();
        Account account;
        while(result.next()){
            int accountId=result.getInt("accountid");
            int userId=result.getInt("userid");
            Date time=result.getDate("time");
            String type=result.getString("type");
            double money=result.getDouble("money");
            String remark=result.getString("remark");
            account=new Account(accountId,userId,time,type,money,remark);
//            account.setAccountId(accountId);
//            account.setUserId(userId);
//            account.setTime(time);
//            account.setType(type);
//            account.setMoney(money);
//            account.setRemark(remark);
            list.add(account);
        }
        JdbcUtil.resultFree(result,pState,conn);
        return list;
    }

    /**向account表插入一条数据*/
    public boolean add(Account account)throws Exception {
        Connection conn = JdbcUtil.getConnection();
        String sql = "INSERT IGNORE INTO account(userid,time,type,money,remark) values(?,?,?,?,?)";
        PreparedStatement pState = conn.prepareStatement(sql);
        pState.setInt(1, account.getUserId());
        //java.util.date-->java.sql.date
        java.sql.Date sqlDate= new java.sql.Date(account.getTime().getTime());
        pState.setDate(2, sqlDate);
        pState.setString(3, account.getType());
        pState.setDouble(4, account.getMoney());
        pState.setString(5, account.getRemark());
        int result = pState.executeUpdate();
        JdbcUtil.resultFree(null, pState, conn);
        //result=0返回false，1返回true
        return result != 0;
    }

    /**更新用户信息*/
    public int update(Account account) throws Exception{
        Connection conn=JdbcUtil.getConnection();
        PreparedStatement pState=null;
        String sql="update account set time=?,type=?,money=?,remark=? where accountid=?";
        pState=conn.prepareStatement(sql);
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        try{
            //java.util.date-->java.sql.date
            java.sql.Date sqlDate= new java.sql.Date(account.getTime().getTime());
            pState.setDate(1,sqlDate);
            pState.setString(2,account.getType());
            pState.setDouble(3,account.getMoney());
            pState.setString(4,account.getRemark());
            pState.setInt(5,account.getAccountId());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //resultNum为受影响的行数,1表示更新成功，0表示更新失败
            int resultNum=pState.executeUpdate();
            JdbcUtil.resultFree(null,pState,conn);
            return resultNum;
        }
    }
    /**根据年份统计账单*/
    public List<Account> queryByYear(int id,String year) throws Exception {
        Connection conn = JdbcUtil.getConnection();
        String sql="select * from account where userid = ? and time between ? and ?";
        PreparedStatement pState=conn.prepareStatement(sql);
        String strBeginDate=year+"-01-01";
        String strEndDate=year+"-12-31";
        //str->util.date
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate=format.parse(strBeginDate);
        Date endDate=format.parse(strEndDate);
        //util.date--->sql.date
        java.sql.Date sqlBeginDate= new java.sql.Date(beginDate.getTime());
        java.sql.Date sqlEndDate= new java.sql.Date(endDate.getTime());

        pState.setInt(1,id);
        pState.setDate(2,sqlBeginDate);
        pState.setDate(3,sqlEndDate);

        ResultSet result=pState.executeQuery();
        List<Account> list=new ArrayList<>();
        Account account;
        while(result.next()){
            int accountId=result.getInt("accountid");
            int userId=result.getInt("userid");
            Date time=result.getDate("time");
            String type=result.getString("type");
            double money=result.getDouble("money");
            String remark=result.getString("remark");
            account=new Account(accountId,userId,time,type,money,remark);
            list.add(account);
        }
        JdbcUtil.resultFree(result,pState,conn);

        return list;
    }
    /**删除一条account*/
    public int delete(int accountId) throws Exception{
        Connection conn=JdbcUtil.getConnection();
        PreparedStatement pState=null;
        String sql="delete from account where accountid=?";
        pState=conn.prepareStatement(sql);
        pState.setInt(1,accountId);
        int result=pState.executeUpdate();
        JdbcUtil.resultFree(null,pState,conn);
        return result;
    }
}
