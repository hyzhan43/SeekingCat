package zqx.rj.com.net.retrofit;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zqx.rj.com.utils.Constants;
import zqx.rj.com.utils.Log;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.common.http
 * 文件名：  RetrofitFactory
 * 创建者：  ZQX
 * 创建时间：2018/6/29 14:30
 * 描述：    retrofit 封装
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
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(initClient())
                            .build();
    }


    private OkHttpClient initClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        Log.d("LST", original.url().toString());

                        return chain.proceed(original);
                    }
                })
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

}
