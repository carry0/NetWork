package com.menu.network;


import com.menu.network.converter.CustomGsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class RetrofitService {

    private static final long TIME_OUT = 300;
    private static RetrofitService instance;
    private static Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public RetrofitService() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(new AddSessionIdInterceptor())
                    .build();
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.TEST_URL)
                    .client(okHttpClient)
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
    }

    public static RetrofitService getInstance() {
        if (instance == null) {
            synchronized (RetrofitService.class) {
                if (instance == null) {
                    instance = new RetrofitService();
                }
            }
        }
        return instance;
    }

    public <S> S createService(Class<S> clazz) {
        return retrofit.create(clazz);
    }

}
