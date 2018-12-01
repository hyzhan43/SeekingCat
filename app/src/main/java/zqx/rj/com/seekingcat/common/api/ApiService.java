package zqx.rj.com.seekingcat.common.api;


import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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


    // 登录
    @POST("user/app/login")
    Observable<BaseResponse<LoginRsp>> getLogin(@Query("account") String account,
                                                @Query("password") String password);


    // 获取所有 物品信息
    @GET("goods/list/{page}")
    Observable<BaseResponse<PageRsp<List<GoodsRsp>>>> getAllGoods(@Path("page") int page);

    // 发布物品
    @Multipart
    @POST("goods")
    Observable<BaseResponse> publishGoods(@Part("name") String name,
                                          @Part("description") String description,
                                          @Part("phone") String phone,
                                          @Part("place") String place,
                                          @Part("type") Integer type,
                                          @Part("reward") String reward,
                                          @Part MultipartBody.Part imageFile
                                          );
}
