package okhttp3.internal;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class a {
    public static a instance;

    public abstract void addLenient(Headers.Builder builder, String str);

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    public abstract int code(Response.Builder builder);

    public abstract boolean connectionBecameIdle(ConnectionPool connectionPool, okhttp3.internal.connection.c cVar);

    public abstract Socket deduplicate(ConnectionPool connectionPool, Address address, f fVar);

    public abstract okhttp3.internal.connection.c get(ConnectionPool connectionPool, Address address, f fVar);

    public abstract HttpUrl getHttpUrlChecked(String str);

    public abstract Call newWebSocketCall(OkHttpClient okHttpClient, Request request);

    public abstract void put(ConnectionPool connectionPool, okhttp3.internal.connection.c cVar);

    public abstract okhttp3.internal.connection.d routeDatabase(ConnectionPool connectionPool);

    public abstract void setCache(OkHttpClient.Builder builder, okhttp3.internal.a.f fVar);

    public abstract f streamAllocation(Call call);

    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }
}
