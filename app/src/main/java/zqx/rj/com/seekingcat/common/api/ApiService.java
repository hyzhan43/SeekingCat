package zqx.rj.com.seekingcat.common.api;


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
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;

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
    Observable<BaseResponse<PageRsp<GoodsRsp>>> getAllGoods(@Path("page") int page);

    // 获取所有 失物招领信息
    @GET("goods/lose/{page}")
    Observable<BaseResponse<PageRsp<GoodsRsp>>> getLoseGoods(@Path("page") int page);

    // 获取所有 寻物启事信息
    @GET("goods/seek/{page}")
    Observable<BaseResponse<PageRsp<GoodsRsp>>> getSeekGoods(@Path("page") int page);

    // 发布物品
    @Multipart
    @POST("goods")
    Observable<BaseResponse> publishGoods(@Query("name") String name,
                                          @Query("description") String description,
                                          @Query("phone") String phone,
                                          @Query("place") String place,
                                          @Query("type") Integer type,
                                          @Query("reward") String reward,
                                          @Part MultipartBody.Part imageFile
    );

    @GET("user/info")
    Observable<BaseResponse<UserInfoRsp>> getUserInfo();

    @GET("goods/{id}")
    Observable<BaseResponse<GoodsRsp>> getGoodsDetail(@Path("id") int id);

    @POST("goods/search/{page}")
    Observable<BaseResponse<PageRsp<GoodsRsp>>> search(@Path("page") int page,
                                                       @Query("keyword") String keyword);

    @POST("goods/follow/{id}")
    Observable<BaseResponse> followGoods(@Path("id") int id);

    @POST("goods/unfollow/{id}")
    Observable<BaseResponse> unFollowGoods(@Path("id") int id);

    @GET("user/goods/{page}")
    Observable<BaseResponse<PageRsp<GoodsRsp>>> getMyPublish(@Path("page") int page);

    @GET("user/follow/{page}")
    Observable<BaseResponse<PageRsp<GoodsRsp>>> getFollow(@Path("page") int page);
}
