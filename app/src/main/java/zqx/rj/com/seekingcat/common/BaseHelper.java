package zqx.rj.com.seekingcat.common;

import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.seekingcat.common.api.ApiService;
import zqx.rj.com.net.retrofit.RetrofitFactory;

public class BaseHelper {

    protected static ApiService apiHelper(){
        return RetrofitFactory.getInstance().create(ApiService.class);
    }

}
