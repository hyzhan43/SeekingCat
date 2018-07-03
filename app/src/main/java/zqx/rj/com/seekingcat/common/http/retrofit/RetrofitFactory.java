package zqx.rj.com.seekingcat.common.http.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.http
 * 文件名：  RetrofitFactory
 * 创建者：  ZQX
 * 创建时间：2018/6/29 14:30
 * 描述：    TODO
 */

public class RetrofitFactory {

    private Retrofit mRetrofit;

    private RetrofitFactory() {
        initRetrofit();
    }

    public static RetrofitFactory getInstance() {
        return Holder.INSTANCE;
    }

    // 内部类单利
    private static class Holder {
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();
    }


    public  <T> T create(final Class<T> service) {
        return mRetrofit.create(service);
    }

    private void initRetrofit() {

        mRetrofit = new Retrofit.Builder()
                            .baseUrl("http://110.64.211.33/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(initClient())
                            .build();
    }


    private OkHttpClient initClient() {

        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
