package zqx.rj.com.helper;

import zqx.rj.com.net.api.ApiService;
import zqx.rj.com.net.retrofit.RetrofitFactory;

public class BaseHelper {

    protected static ApiService apiHelper(){
        return RetrofitFactory.getInstance().create(ApiService.class);
    }
}
