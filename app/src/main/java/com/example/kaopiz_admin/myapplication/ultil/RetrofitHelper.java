package com.example.kaopiz_admin.myapplication.ultil;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static final int CACHE_SIZE = 50 * 1024 * 1024; // 50 MB

    private static Retrofit sRetrofit;
    private static Retrofit sCachingRetrofit;
    private static OkHttpClient sHttpClient;

    public static Retrofit getRetrofitInstance() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constant.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static Retrofit getCachingRetrofitInstance() {
        if (sCachingRetrofit == null) {
            sCachingRetrofit = new Retrofit.Builder()
                    .baseUrl(Constant.API_BASE_URL)
                    .client(sHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sCachingRetrofit;
    }

    public static void init(final Context context) {
        if (sHttpClient == null) {
            sHttpClient = new OkHttpClient.Builder()
                    .cache(new Cache(context.getCacheDir(), CACHE_SIZE))
                    .addInterceptor(chain -> {
                        Request request = chain.request();

                        if (!Common.isOnline(context)) {
                            CacheControl cacheControl = new CacheControl.Builder()
                                    .maxStale(30, TimeUnit.DAYS)
                                    .build();

                            request = request.newBuilder()
                                    .cacheControl(cacheControl)
                                    .build();
                        }
                        return chain.proceed(request);
                    })
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
    }

    public static void destroy() {
        sHttpClient = null;
        sRetrofit = null;
        sCachingRetrofit = null;
    }
}

