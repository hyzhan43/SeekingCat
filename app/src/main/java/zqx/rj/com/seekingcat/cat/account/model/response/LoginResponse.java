package zqx.rj.com.seekingcat.cat.account.model.response;

import zqx.rj.com.seekingcat.cat.account.model.entity.User;
import zqx.rj.com.seekingcat.common.http.response.BaseResponse;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.account.model.response
 * 文件名：  LoginResponse
 * 创建者：  ZQX
 * 创建时间：2018/6/29 20:24
 * 描述：    TODO
 */

public class LoginResponse extends BaseResponse{

    User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
