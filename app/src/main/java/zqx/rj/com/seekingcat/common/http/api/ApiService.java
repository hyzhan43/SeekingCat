package zqx.rj.com.seekingcat.common.http.api;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import zqx.rj.com.seekingcat.cat.account.model.response.LoginResponse;
import zqx.rj.com.seekingcat.common.http.response.BaseResponse;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.http
 * 文件名：  ApiService
 * 创建者：  ZQX
 * 创建时间：2018/6/29 17:28
 * 描述：    TODO
 */

public interface ApiService {

    /**
     *
     *  public static final String GET_TEST = "/c17";
         // phone & password
         public static final String POST_TEST = "/login";

         public static final String LOGIN = "";
     *
     */


    @FormUrlEncoded
    @POST("/login")
    Observable<LoginResponse> getLogin(@Field("phone") String phone, @Field("password") String password);

}
