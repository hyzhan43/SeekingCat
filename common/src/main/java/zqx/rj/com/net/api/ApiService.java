package zqx.rj.com.net.api;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.account.User;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.common.http
 * 文件名：  ApiService
 * 创建者：  ZQX
 * 创建时间：2018/6/29 17:28
 * 描述：    TODO
 */

public interface ApiService {

    // Test Login
//    @FormUrlEncoded
//    @POST("/login.php")
//    Observable<BaseResponse<User>> getLogin(@Field("phone") String phone,
//                                       @Field("password") String password);

    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseResponse<List<User>>> getLogin(@Field("phone") String phone,
                                                  @Field("password") String password);


}
