package zqx.rj.com.seekingcat.common.http.response;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.http.response
 * 文件名：  BaseResponse
 * 创建者：  ZQX
 * 创建时间：2018/6/29 20:21
 * 描述：    TODO
 */

public class BaseResponse {

    /**
     *   "code": 200,
         "message": "登录成功",
         "data": {
            "phone": "123",
            "password": "123"
         }
     */

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
