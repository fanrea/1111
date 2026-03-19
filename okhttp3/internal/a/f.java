package okhttp3.internal.a;

import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface f {
    Response get(Request request);

    b put(Response response);

    void remove(Request request);

    void trackConditionalCacheHit();

    void trackResponse(c cVar);

    void update(Response response, Response response2);
}
