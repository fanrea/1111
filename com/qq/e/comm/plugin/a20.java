package com.qq.e.comm.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a20 {
    private static final String m = "kg";
    private static volatile a20 n;
    private String b;
    private int c;
    private volatile long k;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final List<String> d = new ArrayList();
    private final List<String> e = new ArrayList();
    private final AtomicInteger f = new AtomicInteger(0);
    private final AtomicInteger g = new AtomicInteger(0);
    private int h = 0;
    private int i = 0;
    private int j = -1;
    private final Runnable l = new b();

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        pro.getVresult(566, 0, this);
    }

    public void a(String str, boolean z) {
        pro.getVresult(567, 0, this, str, Boolean.valueOf(z));
    }

    private a20() {
    }

    private boolean b() {
        if (this.j < 0) {
            this.j = r1.d().f().a("hdrcdt", 10) * 1000;
        }
        return SystemClock.elapsedRealtime() - this.k > ((long) this.j);
    }

    /* compiled from: A */
    class a implements HostnameVerifier {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (TextUtils.equals(ILogConst.CACHE_PLAY_REASON_NULL, this.a) && a20.this.e.contains(str)) {
                return true;
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a20.this.c();
        }
    }

    private void a(int i, int i2, Exception exc) {
        Object obj = exc;
        if (exc == null) {
            obj = "";
        }
        qm$h$$ExternalSyntheticBackport0.m(obj);
        if (kg.d().n()) {
            if (i == 0) {
                if (this.f.incrementAndGet() >= this.d.size() - 1) {
                    this.f.set(0);
                    ri.b(i2, 5, null);
                    return;
                }
                return;
            }
            if (i != 1 || this.g.incrementAndGet() < this.e.size() - 1) {
                return;
            }
            this.g.set(0);
            ri.b(i2, 6, null);
        }
    }

    public static a20 a() {
        if (n == null) {
            synchronized (a20.class) {
                if (n == null) {
                    n = new a20();
                }
            }
        }
        return n;
    }
}
