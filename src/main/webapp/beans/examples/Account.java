package examples;

import java.util.Date;

/**
 * @author dhx
 * account表的实体类
 */
public class Account {
    int accountId;
    int userId;
    Date time;
    String type;
    double money;
    String remark;

    public Account() {
    }

    public Account(int accountId, int userId, Date time,
                   String type, double money, String remark) {
        this.accountId = accountId;
        this.userId = userId;
        this.time = time;
        this.type = type;
        this.money = money;
        this.remark = remark;
    }

    public Account(int userId, Date time, String type, double money, String remark) {
        this.userId = userId;
        this.time = time;
        this.type = type;
        this.money = money;
        this.remark = remark;
    }

    /**向account表插入数据时无需accountId*/


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
