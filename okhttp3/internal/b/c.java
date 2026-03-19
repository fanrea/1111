package okhttp3.internal.b;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Sink;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface c {
    Response.Builder I(boolean z);

    Sink a(Request request, long j);

    ResponseBody b(Response response);

    void b(Request request);

    void cancel();

    void gB();

    void gC();
}
