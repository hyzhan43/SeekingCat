package zqx.rj.com.seekingcat.common;

import zqx.rj.com.net.retrofit.RetrofitFactory;
import zqx.rj.com.seekingcat.common.api.ApiService;

public class BaseHelper {

    protected static ApiService apiHelper(){
        return RetrofitFactory.getInstance().create(ApiService.class);
    }

}
