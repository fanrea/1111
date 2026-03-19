package okhttp3.internal.connection;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.b.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a implements Interceptor {
    public final OkHttpClient client;

    public a(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        g gVar = (g) chain;
        Request request = gVar.request();
        f fVarStreamAllocation = gVar.streamAllocation();
        return gVar.a(request, fVarStreamAllocation, fVarStreamAllocation.a(this.client, !request.method().equals("GET")), fVarStreamAllocation.gy());
    }
}
