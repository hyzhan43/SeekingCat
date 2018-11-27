package zqx.rj.com.net.retrofit;


import android.text.TextUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.utils.Preferences;

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

    public <T> T create(final Class<T> service) {
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
                .addInterceptor(initLogIntercept())
                .addInterceptor(initTokenIntercept())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    // 日志拦截器
    private Interceptor initLogIntercept() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    // 设置 token 请求头
    private Interceptor initTokenIntercept() {

        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();

                Request.Builder builder = request.newBuilder();

                // 请求的 url
                String url = request.url().toString();

                // 过滤 login/register
                // 如果是其他 url 就设置 请求 token
                if (!TextUtils.isEmpty(url)
                        && !url.contains(Constants.LOGIN_KEY)
                        && !url.contains(Constants.REGISTER_KEY)) {

                    // 获取 SharedPreferences 中的 token
                    String token = Preferences.getString(Constants.TOKEN, "");
                    if (!TextUtils.isEmpty(token)) {
                        builder.addHeader("token", token);
                    }
                }

                return chain.proceed(builder.build());
            }
        };
    }
}
