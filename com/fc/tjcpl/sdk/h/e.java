package com.fc.tjcpl.sdk.h;

import android.os.Handler;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e implements Runnable {
    public com.fc.tjcpl.sdk.h.b a;
    public j b;
    public Handler c;
    public d d;
    public int f;
    public final HostnameVerifier g = new a(this);
    public SSLSocketFactory e = b().getSocketFactory();

    public class a implements HostnameVerifier {
        public a(e eVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public b(int i, String str) {
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = e.this.b;
            if (jVar != null) {
                jVar.a(this.a, this.b);
            }
        }
    }

    public e(com.fc.tjcpl.sdk.h.b bVar, d dVar, j jVar, Handler handler) {
        this.a = bVar;
        this.d = dVar;
        this.b = jVar;
        this.c = handler;
    }

    public final void a() throws Throwable {
        int i;
        try {
            a(this.a.a());
        } catch (IOException e) {
            e.printStackTrace();
            if (!this.a.b() || !this.a.e() || (i = this.f) >= 1) {
                a(200, "an IOException occurs while requesting");
            } else {
                this.f = i + 1;
                a();
            }
        }
    }

    public final void a(int i, String str) {
        this.c.post(new b(i, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e8 A[Catch: Exception -> 0x01ab, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x01ab, blocks: (B:55:0x01a3, B:80:0x01e8), top: B:103:0x000b }] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.h.e.a(java.lang.String):void");
    }

    public final SSLContext b() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustManagerArr = {new i()};
        SSLContext sSLContext = null;
        try {
            SSLContext sSLContext2 = SSLContext.getInstance("SSL");
            try {
                sSLContext2.init(null, trustManagerArr, null);
                return sSLContext2;
            } catch (Exception e) {
                e = e;
                sSLContext = sSLContext2;
                e.printStackTrace();
                return sSLContext;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        a();
    }
}
