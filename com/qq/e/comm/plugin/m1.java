package com.qq.e.comm.plugin;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class m1 extends fz implements View.OnTouchListener {
    protected h4 b;
    protected jm c;
    protected final long d;
    protected f5 e;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    protected String m;
    private long n;
    private long o;
    protected boolean p;
    private String q;
    private int r;
    private long s;
    protected int a = 1;
    protected boolean f = true;
    private int t = 1;

    protected m1(Activity activity) {
        this.d = activity.getIntent().getLongExtra("landingPageStartTime", System.currentTimeMillis());
        this.m = activity.getIntent().getStringExtra("url");
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void c(String str) throws JSONException {
        super.c(str);
        j();
    }

    protected boolean e() {
        b();
        jm jmVar = this.c;
        if (jmVar == null || !jmVar.canGoBack()) {
            return false;
        }
        this.c.goBack();
        return true;
    }

    protected final void j() throws JSONException {
        int i = this.t;
        if (i == 4 || i == 3) {
            return;
        }
        this.t = 3;
        b(4003010);
    }

    private void i() throws JSONException {
        int i = this.t;
        if (i != 4 && i != 5) {
            if (i != 3) {
                b(4003023);
            } else if (!this.j) {
                b(4003024);
            } else {
                b(4003026);
            }
            this.t = 5;
        }
        g();
    }

    private void b() {
        this.i = false;
        this.h = false;
    }

    protected final void k() {
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws JSONException {
        if (!this.g || this.i || this.c == null) {
            return;
        }
        this.i = true;
        String strReplace = qn.a().replace("__CLICK_TIME__", String.valueOf(this.d));
        long jCurrentTimeMillis = System.currentTimeMillis();
        a(4003047, 0L, 1);
        this.c.a(strReplace, new a(jCurrentTimeMillis));
    }

    /* compiled from: A */
    class a implements ValueCallback<String> {
        final /* synthetic */ long a;

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) throws JSONException {
            if ("true".equals(str)) {
                m1.this.a(4003048, this.a, 1);
            } else {
                m1.this.a(4003049, this.a, 1);
            }
        }

        a(long j) {
            this.a = j;
        }
    }

    private void f() throws JSONException {
        if (!this.g || this.h || !this.i || this.c == null) {
            return;
        }
        this.h = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        qn.a(4003047, this.p, this.a, this.e, 0L, 3);
        this.c.a("typeof __TG_GET_PAGE_PERFORMANCE__ === \"function\"", new b(jCurrentTimeMillis));
    }

    /* compiled from: A */
    class b implements ValueCallback<String> {
        final /* synthetic */ long a;

        b(long j) {
            this.a = j;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                m1.this.a(4003049, this.a, 3);
                return;
            }
            m1.this.a(4003048, this.a, 3);
            if ("true".equals(str)) {
                return;
            }
            m1.this.i = false;
            m1.this.h();
        }
    }

    private void g() throws JSONException {
        if (this.g && this.c != null) {
            a(4003047, 0L, 2);
            this.c.a("__TG_GET_PAGE_PERFORMANCE__()", new c(System.currentTimeMillis()));
            return;
        }
        d();
    }

    /* compiled from: A */
    class c implements ValueCallback<String> {
        final /* synthetic */ long a;

        c(long j) {
            this.a = j;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) throws JSONException {
            int length;
            int iOptInt;
            m1.this.d();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                m1.this.a(4003048, this.a, 2);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("event_report");
                if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && (iOptInt = jSONObject2.optInt("eventId")) != 0) {
                            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(com.alipay.sdk.m.k.b.l);
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.remove("traceid");
                            }
                            m1 m1Var = m1.this;
                            qn.a(iOptInt, m1Var.p, m1Var.a, m1Var.e, jSONObjectOptJSONObject);
                        }
                    }
                }
            } catch (JSONException e) {
                e.getMessage();
                m1.this.a(4003049, this.a, 2);
            }
        }
    }

    protected boolean a() {
        int i = this.t;
        if (i != 3 && i != 4) {
            z = System.currentTimeMillis() - this.s > ((long) this.r);
            if (!z) {
                un.b(this.e, this.b);
            }
        }
        return z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        k();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        jm jmVar = this.c;
        if (jmVar != null) {
            jmVar.d();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        this.o = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        if (this.o > 0) {
            this.n += System.currentTimeMillis() - this.o;
            this.o = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() throws JSONException {
        i();
    }

    protected final void e(String str) throws JSONException {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.s = System.currentTimeMillis();
        if (this.f && !TextUtils.isEmpty(qn.a())) {
            this.g = true;
        }
        b(4003008);
        this.c.loadUrl(str);
    }

    protected final void b(int i) throws JSONException {
        if (this.f) {
            long j = this.d;
            if (i == 4003026) {
                j += this.n;
            }
            qn.a(i, this.p, this.a, this.e, j);
        }
    }

    private void f(String str) throws JSONException {
        if (this.m.equals(str)) {
            this.t = 4;
            b(4003009);
        }
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void d(String str) {
        super.d(str);
        if (this.t == 4) {
            this.t = 1;
        }
        if (a30.a(this.m, this.q)) {
            this.m = str;
        }
        b();
    }

    protected final void b(h4 h4Var) {
        if (h4Var == null) {
            return;
        }
        this.b = h4Var;
        this.e = f5.a(h4Var);
        String strX = h4Var.x();
        this.q = strX;
        this.p = a30.a(this.m, strX);
        this.r = rn.a(h4Var);
    }

    private boolean a(h4 h4Var) {
        String strA = xc.a("dtlvampa", h4Var.y0(), "1,4,10", h4Var.x0());
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        for (String str : strA.split(",")) {
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(h4Var.I()))) {
                return true;
            }
        }
        return false;
    }

    protected final jm a(Activity activity, h4 h4Var) throws JSONException {
        jm jmVarA;
        try {
            b(4003005);
            jmVarA = new qh(activity, h4Var).a();
            try {
                b(4003007);
                jmVarA.a(this);
                jmVarA.a().setOnTouchListener(this);
                if (a(h4Var)) {
                    jmVarA.d(true);
                }
            } catch (Throwable unused) {
                b(4003006);
                return jmVarA;
            }
        } catch (Throwable unused2) {
            jmVarA = null;
        }
        return jmVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j, int i2) throws JSONException {
        if (this.f) {
            qn.a(i, this.p, this.a, this.e, j, i2);
        }
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void a(String str, Bitmap bitmap) throws JSONException {
        super.a(str, bitmap);
        if (this.p && a30.a(str, this.q)) {
            return;
        }
        if (this.t == 1) {
            this.t = 2;
        }
        h();
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void a(int i) throws JSONException {
        super.a(i);
        f();
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void a(int i, String str, String str2) throws JSONException {
        super.a(i, str, str2);
        f(str2);
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh.a
    public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) throws JSONException {
        super.a(webView, webResourceRequest, webResourceResponse);
        if (Build.VERSION.SDK_INT < 21 || webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return;
        }
        f(webResourceRequest.getUrl().toString());
    }
}
