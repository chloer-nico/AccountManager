import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author dhx
 * 对于user表的操作
 */
public class UserDao {
    /**根据id查询用户信息*/
    public User queryById(int userid)throws Exception{
        Connection conn=JdbcUtil.getConnection();
        String sql="select  *  from  user where id=?";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setInt(1,userid);
        ResultSet result=pState.executeQuery();
        User user= new User();
        //依据结果集设置user实例
        if(result.next()){
            user.setId(result.getInt(1));
            user.setName(result.getString(2));
            user.setPassword(result.getString(3));
            user.setTel(result.getString(4));
            user.setVip(result.getBoolean(5));
        }
        JdbcUtil.resultFree(result,pState,conn);
        //id不存在时user为空
        return user;
    }

    /**用户登录时，根据tel查询用户是否存在*/
    public User queryByTel(String tel)throws Exception{
        User user=new User();
        Connection conn=JdbcUtil.getConnection();
        String sql="select  *  from  user where tel=?";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setString(1,tel);
        ResultSet result=pState.executeQuery();
        //依据结果集设置user实例
        if(result.next()){
            user.setId(result.getInt(1));
            user.setName(result.getString(2));
            user.setPassword(result.getString(3));
            user.setTel(result.getString(4));
            user.setVip(result.getBoolean(5));
        }
        JdbcUtil.resultFree(result,pState,conn);
        return user;
    }

    /**插入数据*/
    public boolean insert(User user)throws Exception{
        Connection conn=JdbcUtil.getConnection();
        String sql="INSERT IGNORE INTO user(name,password,tel) values(?,?,?)";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setString(1,user.getName());
        pState.setString(2,user.getPassword());
        pState.setString(3,user.getTel());
        int result=pState.executeUpdate();
        JdbcUtil.resultFree(null,pState,conn);
        //result=0返回false，1返回true
        return result != 0;
    }

    /**更新用户信息*/
    public int update(User user) throws Exception{
        Connection conn=JdbcUtil.getConnection();
        PreparedStatement pState=null;
        String sql="update user set name=?,password=?,tel=? where id=?";
        pState=conn.prepareStatement(sql);
        pState.setString(1,user.getName());
        pState.setString(2,user.getPassword());
        pState.setString(3,user.getTel());
        pState.setInt(4,user.getId());
        //resultNum为受影响的行数,1表示更新成功，0表示更新失败
        int resultNum=pState.executeUpdate();
        JdbcUtil.resultFree(null,pState,conn);
        return resultNum;
    }

}
