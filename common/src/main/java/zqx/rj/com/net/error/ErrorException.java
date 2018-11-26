package zqx.rj.com.net.error;

/**
 * author：  HyZhan
 * created：2018/9/5 12:56
 * desc：    TODO
 */

public class ErrorException extends Exception{

    private int code;
    private String message;

    public ErrorException(int code, String message) {
        this.code = code;
        this.message = message;
    }

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
