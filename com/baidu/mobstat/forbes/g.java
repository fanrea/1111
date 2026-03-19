package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobstat.forbes.f;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    private static final g t = new g();
    private Context a;
    private Activity b;
    private Handler d;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile String j;
    private volatile String k;
    private long l;
    private long m;
    private String n;
    private boolean o;
    private String p;
    private JSONObject q = new JSONObject();
    private JSONObject r = new JSONObject();
    private y s = y.a();
    private Handler u = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.forbes.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private f.a v = new f.a() { // from class: com.baidu.mobstat.forbes.g.2
    };
    private boolean w = true;
    private JSONArray x = new JSONArray();
    private Object y = new Object();
    private h c = new h();
    private HandlerThread e = new HandlerThread("downloadThread");

    public static g a() {
        return t;
    }

    private g() {
        this.e.start();
        this.d = new a(this.e.getLooper());
    }

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 21:
                    g.this.f();
                    break;
                case 22:
                    g.this.g();
                    break;
                case 23:
                    g.this.h();
                    break;
                case 24:
                    Bundle data = message.getData();
                    if (data != null) {
                        g.this.b(data.getString("autoconfig.key"));
                        break;
                    }
                    break;
            }
        }
    }

    public void a(String str) {
        this.n = str;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public boolean a(Activity activity, Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String scheme = data.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        try {
            String queryParameter = data.getQueryParameter(NetworkDefine.PARAM_TOKEN);
            String queryParameter2 = data.getQueryParameter("time");
            if (!scheme.startsWith("mtj") || scheme.length() <= "mtj".length()) {
                return false;
            }
            String strSubstring = scheme.substring("mtj".length());
            if (TextUtils.isEmpty(strSubstring) || !strSubstring.equals(this.n.toLowerCase()) || TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            this.p = queryParameter;
            String strQ = al.a().q(activity);
            if (TextUtils.isEmpty(queryParameter2) || queryParameter2.equals(strQ)) {
                return false;
            }
            al.a().h(activity, queryParameter2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void a(Activity activity) {
    }

    private void d(Activity activity) {
    }

    public void b(Activity activity) {
        Intent intent;
        if (!i()) {
            return;
        }
        this.a = activity.getApplicationContext();
        if (activity != null && (intent = activity.getIntent()) != null && a(activity, intent)) {
            a().e();
        }
        if (this.b != null) {
            b();
        }
        this.b = activity;
        if (ap.a().f()) {
            d(activity);
        }
        k();
        b(activity, true);
        e(activity);
        d();
        a(activity, true);
    }

    public void a(Activity activity, boolean z) {
        if (activity instanceof IIgnoreAutoEvent) {
            return;
        }
        if (z) {
            this.s.a(activity, true, this.r, this.o);
        } else {
            this.s.a(activity, true);
        }
    }

    public void c(Activity activity) {
        if (!i()) {
            return;
        }
        this.b = null;
        b(activity, false);
        c();
        a(activity, false);
    }

    public void a(WebView webView, String str, ag agVar) throws JSONException {
        if (!CooperService.instance().isEnableDownloadJs()) {
            return;
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = aj.a(this.a, c.a);
        }
        b(webView, this.j, agVar);
        if (TextUtils.isEmpty(this.k)) {
            this.k = aj.a(this.a, c.b);
        }
        c(webView, this.k, agVar);
    }

    private void e(Activity activity) {
    }

    private void c() {
    }

    private void d() {
    }

    public void b() {
    }

    private void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f) {
            return;
        }
        boolean zA = z.a(this.a, this.n, 0, true);
        this.f = true;
        if (zA) {
            this.j = aj.a(this.a, c.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!CooperService.instance().isEnableDownloadJs() || this.g || !ar.j(this.a)) {
            return;
        }
        boolean zA = z.a(this.a, this.n, 1, true);
        this.g = true;
        if (zA) {
            this.k = aj.a(this.a, c.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.h || !ar.j(this.a)) {
            return;
        }
        boolean zA = z.a(this.a, this.n, 2, true);
        this.h = true;
        if (zA) {
            this.u.sendMessage(this.u.obtainMessage(34));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        al.a().c(this.a, System.currentTimeMillis());
        aj.a(this.a, c.c, str, false);
        this.u.sendMessage(this.u.obtainMessage(34));
    }

    private boolean i() {
        if (TextUtils.isEmpty(this.n)) {
            return false;
        }
        return true;
    }

    private void b(WebView webView, String str, ag agVar) {
        if (agVar == null) {
            return;
        }
        agVar.a(webView, str);
    }

    private void c(WebView webView, String str, ag agVar) throws JSONException {
        if (agVar == null) {
            return;
        }
        agVar.a(this.b, webView, str, a(this.q, j()), true);
    }

    private String j() {
        if (this.b == null) {
            return null;
        }
        return this.b.getClass().getName();
    }

    private void b(Activity activity, boolean z) {
        if ((activity instanceof IIgnoreAutoTrace) || CooperService.instance().isCloseTrace()) {
            return;
        }
        if (z) {
            BDStatCore.instance().onResume(activity, true);
        } else {
            BDStatCore.instance().onPause(activity, true, null);
        }
    }

    private void k() {
        if (!CooperService.instance().isEnableDownloadJs() || this.g) {
            return;
        }
        if (!this.i) {
            this.k = aj.a(this.a, c.b);
            this.i = true;
        }
        if (this.l == 0) {
            this.l = al.a().m(this.a);
            this.m = al.a().n(this.a);
        }
        long j = this.m * 7;
        if ((this.i && TextUtils.isEmpty(this.k)) || System.currentTimeMillis() - this.l > j) {
            this.d.sendMessage(this.d.obtainMessage(22));
        }
    }

    private JSONObject a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("meta");
            int i = jSONObject2.getInt("matchAll");
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            JSONArray jSONArray2 = new JSONArray();
            boolean z = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                if (str.equals((String) jSONObject3.get("page"))) {
                    jSONArray2.put(jSONObject3);
                }
            }
            if (i != 0) {
                z = true;
            } else if (i == 0 && jSONArray2.length() != 0) {
                z = true;
            }
            if (!z) {
                return null;
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("meta", jSONObject2);
                jSONObject4.put("data", jSONArray2);
                return jSONObject4;
            } catch (Exception e) {
                return jSONObject4;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
