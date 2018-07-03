package zqx.rj.com.seekingcat.cat.account.model;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.account.model
 * 文件名：  ILoginModel
 * 创建者：  ZQX
 * 创建时间：2018/6/29 18:22
 * 描述：    TODO
 */

public interface ILoginModel {

    int LOGIN_SUC = 1;

    int LOGIN_FAIL = -1;

    void login(String phone, String password);

    void register(String phone, String password);
}
