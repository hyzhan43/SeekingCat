package zqx.rj.com.model.entity;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.common.http.response
 * 文件名：  BaseResponse
 * 创建者：  ZQX
 * 创建时间：2018/6/29 20:21
 * 描述：    服务器统一返回数据
 */

public class BaseResponse<T> {

    public static final int REQUEST_SUC = 0;

    private int code;

    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
