package com.fendasz.moku.planet.common;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class Network {
    private static final String TAG = "Network";
    private static OkHttpClient okHttpClientInstance;

    private static OkHttpClient getOkHttpClientInstance(List<Interceptor> list) {
        if (okHttpClientInstance == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.fendasz.moku.planet.common.Network.1
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String str) {
                    Log.e(Network.TAG, str);
                }
            });
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            OkHttpClient.Builder timeout = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS);
            if (list != null && list.size() > 0) {
                Iterator<Interceptor> it = list.iterator();
                while (it.hasNext()) {
                    timeout.addInterceptor(it.next());
                }
            }
            okHttpClientInstance = timeout.addInterceptor(httpLoggingInterceptor).addNetworkInterceptor(httpLoggingInterceptor).build();
        }
        return okHttpClientInstance;
    }

    protected static Retrofit getRetrofitInstance(String str, List<Interceptor> list) {
        return new Retrofit.Builder().baseUrl(str).client(getOkHttpClientInstance(list)).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }
}
