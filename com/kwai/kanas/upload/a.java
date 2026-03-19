package com.kwai.kanas.upload;

import android.util.Log;
import com.kwai.kanas.Kanas;
import com.kwai.kanas.a.c;
import com.kwai.kanas.upload.response.KanasLogResponse;
import com.kwai.kanas.vader.Channel;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.network.AzerothApiRequester;
import com.kwai.middleware.azeroth.network.EmptyResponse;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.kwai.middleware.azeroth.utils.Callback;
import com.kwai.middleware.azeroth.utils.Charsets;
import com.kwai.middleware.azeroth.utils.CompressUtils;
import com.kwai.middleware.azeroth.utils.DigestUtils;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import com.kwai.middleware.azeroth.utils.TextUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    public static final String a = "/rest/log/open/sdk/collect";
    public static final String b = "/rest/log/open/sdk/realtime/collect";
    private static final int c = 2;
    private final List<String> d;
    private final Executor e;
    private final Executor f;
    private c g;
    private int h;
    private int i;
    private String j;
    private Runnable k;

    private a() {
        this.h = 0;
        this.g = new c();
        this.d = Kanas.get().getConfig().hosts();
        this.j = com.kwai.kanas.b.a.a().d();
        this.e = Executors.newSingleThreadExecutor();
        this.f = Executors.newSingleThreadExecutor();
    }

    public static a a() {
        return b.a;
    }

    public final String b() {
        return this.j;
    }

    public final void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f().specialHost(str).build().doGetRequest("", null, EmptyResponse.class, new Callback<EmptyResponse>() { // from class: com.kwai.kanas.upload.a.1
            @Override // com.kwai.middleware.azeroth.utils.Callback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(EmptyResponse emptyResponse) {
                a.this.j = str;
                if (a.this.k != null) {
                    a.this.k.run();
                }
                com.kwai.kanas.b.a.a().a(str);
            }

            @Override // com.kwai.middleware.azeroth.utils.Callback
            public void onFailure(Throwable th) {
                Log.e(Kanas.c, "Failed to connect to logger.com: ", th);
            }
        });
    }

    public final void a(Runnable runnable) {
        this.k = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AzerothApiRequester.Builder f() {
        return Azeroth.get().newApiRequesterBuilder(Kanas.b).setUseHttps(true).setAzerothApiParams(this.g).needRetry(false).specialHost(d()).ignoreUrlPathVerify().setObserveOnMainThread(false);
    }

    private void g() {
        int i = this.i + 1;
        this.i = i;
        if (i >= 2) {
            this.i = 0;
            c();
        }
    }

    final void c() {
        this.h = (this.h + 1) % this.d.size();
    }

    final String d() {
        return this.d.get(this.h);
    }

    public final void a(Throwable th) {
        g();
        if (!(th instanceof IOException)) {
            Kanas.get().getConfig().logger().logErrors(th);
        }
        if (Azeroth.get().isDebugMode()) {
            Log.e(Kanas.c, "", th);
        }
    }

    public final <T extends JsonAdapter<KanasLogResponse>> void a(Channel channel, final c.a aVar, final com.kwai.kanas.vader.f.g gVar, final Class<T> cls, final Callback<T> callback) {
        Executor executor;
        String str;
        if (channel == Channel.REAL_TIME || channel == Channel.HIGH_FREQ) {
            executor = this.f;
            str = b;
        } else {
            executor = this.e;
            str = a;
        }
        final String str2 = str;
        final Executor executor2 = executor;
        executor.execute(new Runnable() { // from class: com.kwai.kanas.upload.a.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                HashMap map = new HashMap();
                com.kwai.kanas.vader.f.g gVar2 = gVar;
                map.put("priorityType", (gVar2 == null || !gVar2.a()) ? "1" : "2");
                map.put(com.baidu.mobads.container.f.a.a, Long.toString(a.this.h()));
                byte[] bArrGzipCompress = CompressUtils.gzipCompress(JsonUtils.toJson(aVar).toString().getBytes(Charsets.UTF_8));
                map.put("encoding", "gzip");
                map.put(NetworkDefine.PARAM_BODY_MD5, DigestUtils.md5Hex(bArrGzipCompress));
                String strB = a.a().b();
                if (TextUtils.isEmpty(strB)) {
                    strB = a.a().d();
                }
                a.a().f().setExecutor(executor2).specialHost(strB).build().doPostStreamRequest(str2, map, bArrGzipCompress, cls, a.this.new C0653a(callback));
            }
        });
    }

    public final void e() {
        this.j = null;
        com.kwai.kanas.b.a.a().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long h() {
        long j;
        j = com.kwai.kanas.b.a.a().b().getLong(com.kwai.kanas.b.a.c, 0L);
        com.kwai.kanas.b.a.a().c().putLong(com.kwai.kanas.b.a.c, 1 + j).apply();
        return j;
    }

    static class b {
        private static final a a = new a();

        private b() {
        }
    }

    /* renamed from: com.kwai.kanas.upload.a$a, reason: collision with other inner class name */
    class C0653a<T extends JsonAdapter> implements Callback<T> {
        private Callback<T> b;

        C0653a(Callback<T> callback) {
            this.b = callback;
        }

        @Override // com.kwai.middleware.azeroth.utils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(T t) {
            Callback<T> callback = this.b;
            if (callback != null) {
                callback.onSuccess(t);
            }
        }

        @Override // com.kwai.middleware.azeroth.utils.Callback
        public void onFailure(Throwable th) {
            a.this.a(th);
            Callback<T> callback = this.b;
            if (callback != null) {
                callback.onFailure(th);
            }
        }
    }
}
