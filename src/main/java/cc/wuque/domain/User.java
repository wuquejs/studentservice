package cc.wuque.domain;

import java.io.Serializable;

/**
 * @Author 无缺
 * @Date 2021/3/19 21:21
 * 用户实体类
 */
public class User implements Serializable {
    private String uid;
    private String username;
    private String password;
    private String sex;
    private String birthdate;
    private String phonenumber;
    private String qqnumber;
    private String wechat_id;
    private String name;
    private String status;

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", qqnumber='" + qqnumber + '\'' +
                ", wechat_id='" + wechat_id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    public String getWechat_id() {
        return wechat_id;
    }

    public void setWechat_id(String wechat_id) {
        this.wechat_id = wechat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
