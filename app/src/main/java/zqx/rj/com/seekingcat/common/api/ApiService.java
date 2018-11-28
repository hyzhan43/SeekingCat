package zqx.rj.com.seekingcat.common.api;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.account.model.bean.LoginRsp;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;

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
//    Observable<BaseResponse<LoginRsp>> getLogin(@Field("phone") String phone,
//                                       @Field("password") String password);

    @POST("user/app/login")
    Observable<BaseResponse<LoginRsp>> getLogin(@Query("account") String account,
                                                @Query("password") String password);


    @GET("goods/list/{page}")
    Observable<BaseResponse<PageRsp<List<GoodsRsp>>>> getAllGoods(@Path("page") int page);
}
