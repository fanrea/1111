package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import com.component.a.f.d;
import com.dhylive.app.net.interceptor.LogInterceptor;
import com.dhylive.app.net.interceptor.MyHeadInterceptor;
import com.dhylive.app.net.interceptor.MyQueryInterceptor;
import com.google.gson.GsonBuilder;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* compiled from: NetworkApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011¢\u0006\u0002\u0010\u0012R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/dhylive/app/net/NetworkApi;", "", "()V", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", d.b, ExifInterface.GPS_DIRECTION_TRUE, "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class NetworkApi {
    public static final NetworkApi INSTANCE = new NetworkApi();

    /* renamed from: okHttpClient$delegate, reason: from kotlin metadata */
    private static final Lazy okHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.dhylive.app.net.NetworkApi$okHttpClient$2
        public final OkHttpClient invoke() {
            return new OkHttpClient.Builder().addInterceptor(new MyHeadInterceptor()).addInterceptor(new MyQueryInterceptor()).addInterceptor(new LogInterceptor()).addInterceptor(new LoggingInterceptor.Builder().setLevel(Level.NONE).build()).connectTimeout(20L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
        }
    });

    /* renamed from: retrofit$delegate, reason: from kotlin metadata */
    private static final Lazy retrofit = LazyKt.lazy(new Function0<Retrofit>() { // from class: com.dhylive.app.net.NetworkApi$retrofit$2
        public final Retrofit invoke() {
            return new Retrofit.Builder().baseUrl("https://tbq.tongbangqu.top/").addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).client(NetworkApi.INSTANCE.getOkHttpClient()).build();
        }
    });

    private NetworkApi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) okHttpClient.getValue();
    }

    private final Retrofit getRetrofit() {
        Object value = retrofit.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Retrofit) value;
    }

    public final <T> T create(Class<T> serviceClass) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        return (T) getRetrofit().create(serviceClass);
    }
}
