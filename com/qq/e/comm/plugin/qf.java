package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.callback.biz.LPCallback;
import java.lang.ref.WeakReference;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qf extends m1 implements ACTD {
    private ValueCallback<Uri[]> A;
    private ValueCallback<Uri> B;
    private String C;
    private h4 D;
    private final int E;
    private final boolean F;
    private final Runnable G;
    private boolean H;
    private boolean I;
    private boolean J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f782K;
    private Activity u;
    private long v;
    private long w;
    private boolean x;
    private p7 y;
    private String z;

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    public qf(Activity activity) {
        super(activity);
        this.G = new c();
        this.H = false;
        this.I = false;
        this.J = false;
        this.f782K = false;
        this.u = activity;
        int intExtra = activity.getIntent().getIntExtra("web_page_type", 0);
        this.E = intExtra;
        this.f = intExtra == 2;
        this.a = 1;
        this.F = r1.d().f().a("lpnaspl", 1) == 1;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        i20.a().b(3).b("beforeCreate", 2302300, null);
        this.u.requestWindowFeature(1);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) throws JSONException {
        this.u.getWindow().setBackgroundDrawable(null);
        FrameLayout frameLayout = new FrameLayout(this.u);
        this.u.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.y = new p7(this.u);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 45.0f, this.u.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iApplyDimension);
        layoutParams.gravity = 48;
        this.y.setLayoutParams(layoutParams);
        this.y.setBackgroundColor(-1);
        String stringExtra = this.u.getIntent().getStringExtra("objectId");
        this.C = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.D = ((k1) zm.a(this.C, k1.class)).a();
        }
        b(this.D);
        b(4003034);
        h4 h4Var = this.D;
        if (h4Var != null) {
            if (!TextUtils.isEmpty(h4Var.R0())) {
                this.z = this.D.R0();
            } else {
                this.z = this.D.B();
            }
        } else {
            this.z = "";
        }
        this.y.a(new a());
        frameLayout.addView(this.y);
        this.y.b(new b());
        jm jmVarA = a(this.u, this.D);
        this.c = jmVarA;
        if (jmVarA == null) {
            return;
        }
        if (this.E == 1) {
            jmVarA.addJavascriptInterface(new d(new WeakReference(this)), "TencentFeedbackJSBridge");
        }
        e(this.m);
        un.c(this.e, this.D);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = iApplyDimension;
        this.c.a().setLayoutParams(layoutParams2);
        frameLayout.addView(this.c.a());
        un.d(this.e, this.D);
        xo.a(this.G, 500L);
        i20.a().b(3).b("afterCreate", 2302301, this.e);
        if (yp.e()) {
            new od(this.u, 2302303).c();
        }
        h4 h4Var2 = this.D;
        if (h4Var2 == null || !this.f) {
            return;
        }
        ((LPCallback) x5.b(h4Var2.s0(), LPCallback.class)).o().a();
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (qf.this.e()) {
                return;
            }
            qf.this.l();
        }
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            qf.this.l();
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qf.this.c != null && qf.this.c.canGoBack()) {
                qf.this.y.b();
            } else {
                xo.a(this, 500L);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.pi.ACTD
    public void onResume() {
        super.onResume();
        i20.a().b(3).a("onResume", 2302302, this.e);
        if (this.x) {
            jm jmVar = this.c;
            if (jmVar != null) {
                jmVar.onResume();
            }
            this.x = false;
        }
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.pi.ACTD
    public void onPause() {
        super.onPause();
        jm jmVar = this.c;
        if (jmVar != null) {
            jmVar.onPause();
            this.x = true;
        }
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.pi.ACTD
    public void onDestroy() throws JSONException {
        super.onDestroy();
        h4 h4Var = this.D;
        if (h4Var != null && this.f) {
            ((LPCallback) x5.b(h4Var.s0(), LPCallback.class)).onClose().a();
        }
        z0.a();
        if (!this.H && !this.f782K) {
            un.a(this.e, this.D);
        }
        xo.e(this.G);
        if (this.E == 1) {
            wd.a().a(this.m);
        }
        if (!TextUtils.isEmpty(this.C)) {
            zm.b(this.C, k1.class);
        }
        i20.a().a(3);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (a()) {
            this.u.finish();
            a(2040005, this.m);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        if (1 == i && this.A != null) {
            this.A.onReceiveValue((i2 != -1 || intent == null || (data = intent.getData()) == null) ? null : new Uri[]{data});
            this.A = null;
        } else {
            if (2 != i || this.B == null) {
                return;
            }
            this.B.onReceiveValue((i2 != -1 || intent == null) ? null : intent.getData());
            this.B = null;
        }
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void c(String str) throws JSONException {
        super.c(str);
        if (!this.H) {
            this.H = true;
            this.v = System.currentTimeMillis();
            a(2040003, str);
            un.a(this.e, this.D, this.v - this.d, this.p, this.m);
        }
        a(true);
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void d(String str) {
        super.d(str);
        if (this.I) {
            return;
        }
        this.I = true;
        this.w = System.currentTimeMillis();
        long j = this.d;
        a(2040001, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        wd.a().a(this.m, com.style.widget.ad.f);
        b10.a(1200100, this.e, 0);
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void b(String str) {
        super.b(str);
        if (TextUtils.isEmpty(str)) {
            this.y.a(this.z);
        } else {
            this.y.a(str);
        }
    }

    /* compiled from: A */
    private static class d {
        private WeakReference<qf> a;

        d(WeakReference<qf> weakReference) {
            this.a = weakReference;
        }

        @JavascriptInterface
        public void invoke(String str, Object obj, Object obj2) {
            a(str);
        }

        private void a(String str) {
            qf qfVar = this.a.get();
            if (qfVar == null) {
                return;
            }
            str.hashCode();
            if (str.equals("close")) {
                qfVar.onBackPressed();
            } else if (str.equals("feedbackSuccess")) {
                qfVar.m();
            }
        }
    }

    private void a(boolean z) {
        if (this.E == 3) {
            b10.a(z ? 9140013 : 9140014, this.e);
            l();
        }
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void a(String str, Bitmap bitmap) throws JSONException {
        super.a(str, bitmap);
        if (this.J) {
            return;
        }
        this.J = true;
        a(2040002, str);
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void b(ValueCallback<Uri> valueCallback, Intent intent) {
        super.b(valueCallback, intent);
        if (valueCallback == null || intent == null) {
            return;
        }
        this.B = valueCallback;
        this.u.startActivityForResult(intent, 2);
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void a(int i) throws JSONException {
        super.a(i);
        if (i == 100) {
            this.y.a();
        } else {
            this.y.b(i);
        }
    }

    private void b(int i, String str, String str2) {
        if (this.F) {
            un.a(i, this.d, this.e, str, str2);
        }
    }

    @Override // com.qq.e.comm.plugin.m1, com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void a(int i, String str, String str2) throws JSONException {
        super.a(i, str, str2);
        if (!this.f782K) {
            this.f782K = true;
            ja jaVar = new ja();
            jaVar.a("url", str2);
            jaVar.a("msg", str);
            jaVar.a("data", Boolean.valueOf(this.p));
            un.a(this.e, i, jaVar, this.D);
            b(2040004, str2, str);
        }
        a(false);
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public boolean a(ValueCallback<Uri[]> valueCallback, Intent intent) {
        super.a(valueCallback, intent);
        if (valueCallback == null || intent == null) {
            return false;
        }
        this.A = valueCallback;
        this.u.startActivityForResult(intent, 1);
        return true;
    }

    private void a(int i, String str) {
        b(i, str, null);
    }
}
