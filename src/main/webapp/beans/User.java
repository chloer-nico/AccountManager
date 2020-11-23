/**
 * @author dhx
 * user表的实体类
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String tel;
    private boolean vip;

    public User() {}

    public User(int id, String name, String password, String tel, boolean vip) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.vip = vip;
    }
    /**向数据库插入时不需要id*/
    public User(String name, String password, String tel, boolean vip) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.vip = vip;
    }

    public User(int id, String name, String password, String tel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tel = tel;
    }

    /**修改user时无需vip*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
