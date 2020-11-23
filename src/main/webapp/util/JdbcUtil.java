import java.sql.*;
import java.util.Properties;

/**
 * @author dhx
 * 连接数据库
 */
public class JdbcUtil {
    private static String driverName;
    private static String url;
    private static String userName;
    private static String userPwd;
    private static String dbName;
    private static Properties pr = new Properties();

    public JdbcUtil() {
    }

    /**返回数据库连接*/
    public static Connection getConnection() throws SQLException {
        try {
            pr.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            driverName = pr.getProperty("driverName");
            userName = pr.getProperty("userName");
            userPwd = pr.getProperty("userPwd");
            dbName = pr.getProperty("dbName");
            String  url1="jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String url2="&user="+userName+"&password="+userPwd;
            url=url1+url2;
            Class.forName(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, userName, userPwd);
    }

    /**Statement和Resultset的释放*/
    public static void resultFree(ResultSet rs, Statement st, Connection conn) throws Exception{
        if(rs!=null) {
            rs.close();
        }
        if(st!=null) {
            st.close();
        }
        if(conn!=null) {
            conn.close();
        }
    }
}
