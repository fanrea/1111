package com.dhylive.app.net.interceptor;

import com.blankj.utilcode.util.SPUtils;
import com.dhylive.app.utils.SPConfig;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: MyQueryInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/dhylive/app/net/interceptor/MyQueryInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MyQueryInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (StringsKt.contains$default((CharSequence) "https://tbq.tongbangqu.top/", (CharSequence) chain.request().url().host(), false, 2, (Object) null)) {
            Request request = chain.request();
            return chain.proceed(request.newBuilder().url(request.url().newBuilder().addQueryParameter(NetworkDefine.PARAM_TOKEN, SPUtils.getInstance().getString(SPConfig.KEY_TOKEN)).addQueryParameter("device_type", "Android").build()).build());
        }
        return chain.proceed(chain.request());
    }
}
