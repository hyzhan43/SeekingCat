package zqx.rj.com.data.helper;

import io.reactivex.Observable;
import zqx.rj.com.model.entity.account.User;
import zqx.rj.com.net.api.ApiService;
import zqx.rj.com.net.retrofit.RetrofitFactory;
import zqx.rj.com.rx.ListToBean;

/**
 * author：  HyZhan
 * created：2018/9/4 14:18
 * desc：    用户 辅助类
 */

public class AccountHelper {

    public static Observable<User> login(String phone, String password) {

        return RetrofitFactory.getInstance()
                .create(ApiService.class)
                .getLogin(phone, password)
                .map(new ListToBean<User>());
    }

    public static void register(String phone, String password) {

    }
}
