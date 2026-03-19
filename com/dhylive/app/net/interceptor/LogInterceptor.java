package com.dhylive.app.net.interceptor;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: LogInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/dhylive/app/net/interceptor/LogInterceptor;", "Lokhttp3/Interceptor;", "()V", "isLog", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LogInterceptor implements Interceptor {
    private final boolean isLog = true;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (!this.isLog) {
            return chain.proceed(request);
        }
        try {
            Response responseProceed = chain.proceed(request);
            Log.e("response_dhy", "url = " + request.url() + "\nmethod   = " + request.method() + "\nheader   = " + LogInterceptorKt.dotHeaders(request) + "\nparam    = " + LogInterceptorKt.parseParams(request) + "\nresponse = " + LogInterceptorKt.printResult(responseProceed));
            return responseProceed;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.d("Http Error: %s", message);
            }
            throw e;
        }
    }
}
