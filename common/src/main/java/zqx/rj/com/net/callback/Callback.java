package zqx.rj.com.net.callback;

/**
 * author：  HyZhan
 * create：  2018/11/29 21:36
 * desc：    TODO
 */
public interface Callback<Data> {

    void onSuccess(Data data);

    void onFail(String msg);
}
