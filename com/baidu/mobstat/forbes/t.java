package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t {
    private static final t k = new t();
    private static volatile boolean l = true;
    private Context a;
    private Activity b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile String e;
    private long f;
    private long g;
    private String h;
    private PointF i;
    private y j = y.a();

    public static t a() {
        return k;
    }

    private t() {
    }

    public void a(String str) {
        this.h = str;
    }

    public PointF b() {
        return this.i;
    }

    public static void a(boolean z) {
        if (z) {
            y.b();
        }
        l = z;
    }

    public static boolean c() {
        return l;
    }

    private void c(Activity activity) {
    }

    public void a(Activity activity) {
        if (!d()) {
            return;
        }
        a(true);
        this.a = activity.getApplicationContext();
        this.b = activity;
        e();
        c(activity);
        a(activity, true);
    }

    public void a(Activity activity, boolean z) {
        if (activity instanceof IIgnoreAutoEvent) {
            return;
        }
        if (z) {
            this.j.a(activity, false, null, false);
        } else {
            this.j.a(activity, false);
        }
    }

    private void d(Activity activity) {
    }

    public void b(Activity activity) {
        if (!d()) {
            return;
        }
        d(this.b);
        this.b = null;
        a(activity, false);
    }

    public void a(WebView webView, String str, ag agVar) {
        if (TextUtils.isEmpty(this.e)) {
            this.e = aj.a(this.a, c.b);
        }
        b(webView, this.e, agVar);
    }

    private boolean d() {
        if (TextUtils.isEmpty(this.h)) {
            return false;
        }
        return true;
    }

    private void e() {
        if (!CooperService.instance().isEnableDownloadJs() || this.c) {
            return;
        }
        if (!this.d) {
            this.e = aj.a(this.a, c.b);
            this.d = true;
        }
        if (this.f == 0) {
            this.f = al.a().m(this.a);
            this.g = al.a().n(this.a);
        }
        long j = this.g * 7;
        if ((this.d && TextUtils.isEmpty(this.e)) || System.currentTimeMillis() - this.f > j) {
            f();
        }
    }

    private void f() {
        if (!ar.j(this.a)) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mobstat.forbes.t.1
            @Override // java.lang.Runnable
            public void run() {
                if (!t.this.c) {
                    boolean zA = z.a(t.this.a, t.this.h, 1, false);
                    t.this.c = true;
                    if (zA) {
                        t.this.e = aj.a(t.this.a, c.b);
                    }
                }
            }
        });
        thread.setName("downloadThread");
        thread.start();
    }

    private void b(WebView webView, String str, ag agVar) throws JSONException {
        if (agVar == null) {
            return;
        }
        agVar.a(this.b, webView, str, (JSONObject) null, false);
    }
}
