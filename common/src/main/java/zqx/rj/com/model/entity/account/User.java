package zqx.rj.com.model.entity.account;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.account.model.response
 * 文件名：  User
 * 创建者：  ZQX
 * 创建时间：2018/6/29 20:25
 * 描述：    用户 User bean
 */

public class User {

    private int id;
    private String nickname;
    private String phone;
    private String sex;
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
