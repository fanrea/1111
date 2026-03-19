package com.bytedance.sdk.component.adexpress.u;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.hc.gb;
import com.bytedance.sdk.component.adexpress.hc.h;
import com.bytedance.sdk.component.adexpress.hc.k;
import com.bytedance.sdk.component.adexpress.hc.mk;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d implements com.bytedance.sdk.component.adexpress.d, com.bytedance.sdk.component.adexpress.hc.c<SSWebView>, mk, com.bytedance.sdk.component.adexpress.theme.d {
    private Context an;
    protected SSWebView b;
    protected JSONObject d;
    private String gb;
    private String h;
    protected boolean hc;
    private int k;
    private gb mk;
    private uo mq;
    private boolean tc;
    private volatile h tt;
    private boolean uo;
    protected int c = 8;
    protected AtomicBoolean u = new AtomicBoolean(false);
    private boolean e = false;

    public abstract void an();

    @Override // com.bytedance.sdk.component.adexpress.hc.c
    public int b() {
        return 0;
    }

    protected void d(boolean z, int i) {
    }

    public abstract void hc(int i);

    protected void tc() {
    }

    protected void tt() {
    }

    public d(Context context, uo uoVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.tc = false;
        this.an = context;
        this.mq = uoVar;
        this.h = uoVar.an();
        themeStatusBroadcastReceiver.d(this);
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            mq();
            return;
        }
        SSWebView sSWebViewUo = uo();
        this.b = sSWebViewUo;
        if (sSWebViewUo == null) {
            if (com.bytedance.sdk.component.adexpress.c.getContext() != null) {
                this.b = new SSWebView(com.bytedance.sdk.component.adexpress.c.getContext());
                return;
            }
            return;
        }
        this.tc = true;
    }

    private void mq() {
        if (this.an == null && com.bytedance.sdk.component.adexpress.c.getContext() != null) {
            this.an = com.bytedance.sdk.component.adexpress.c.getContext();
        }
        if (this.an != null) {
            SSWebView sSWebViewUo = uo();
            this.b = sSWebViewUo;
            if (sSWebViewUo == null) {
                this.b = new SSWebView(new MutableContextWrapper(this.an.getApplicationContext()));
            } else {
                this.tc = true;
            }
        }
    }

    private SSWebView uo() {
        if (this.mq.he()) {
            return u.d().d(this.an, this.h);
        }
        return u.d().hc(this.an, this.h);
    }

    private void k() {
        if (this.mq.he()) {
            u.d().hc(this.b);
        } else {
            u.d().b(this.b);
        }
    }

    public void d(String str) {
        this.gb = str;
    }

    public SSWebView d() {
        return this.b;
    }

    public void d(gb gbVar) {
        this.mk = gbVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.c
    public void d(h hVar) {
        this.tt = hVar;
        if (d() == null || d().getWebView() == null) {
            this.tt.d(102, "SSWebview null is " + (d() == null) + " or Webview is null");
            return;
        }
        if (TextUtils.isEmpty(this.gb)) {
            this.tt.d(102, "url is empty");
            return;
        }
        if (!this.mq.he()) {
            if (!this.e && !com.bytedance.sdk.component.adexpress.d.hc.hc.d(this.d)) {
                this.tt.d(103, "data null is " + (this.d == null));
                return;
            } else if (this.e && !com.bytedance.sdk.component.adexpress.d.hc.hc.b(this.d)) {
                this.tt.d(103, "choice ad data null is " + (this.d == null));
                return;
            }
        } else if (b() == 9 && !com.bytedance.sdk.component.adexpress.d.hc.hc.hc(this.d)) {
            this.tt.d(103, "data null is " + (this.d == null));
            return;
        }
        this.mq.h().hc(this.tc);
        if (this.tc) {
            try {
                this.b.clearView();
                this.mq.h().h();
                com.bytedance.sdk.component.utils.mk.d(this.b.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                return;
            } catch (Exception e) {
                u.d().u(this.b);
                this.tt.d(102, "load exception is " + e.getMessage());
                return;
            }
        }
        SSWebView sSWebViewD = d();
        sSWebViewD.clearView();
        this.mq.h().h();
        sSWebViewD.loadUrl(this.gb);
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.c
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public SSWebView h() {
        return d();
    }

    public void c() {
        if (this.u.get()) {
            return;
        }
        this.u.set(true);
        an();
        if (this.b.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        if (this.hc) {
            k();
        } else {
            u.d().u(this.b);
        }
    }

    public void u() {
        if (d() == null) {
            return;
        }
        try {
            d().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void d(boolean z) {
        this.uo = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.mk
    public void d(final k kVar) {
        if (kVar == null) {
            if (this.tt != null) {
                this.tt.d(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zB = kVar.b();
        final float fC = (float) kVar.c();
        final float fU = (float) kVar.u();
        if (b() == 0 && (fC <= 0.0f || fU <= 0.0f)) {
            if (this.tt != null) {
                this.tt.d(105, "width is " + fC + "height is " + fU);
            }
        } else {
            this.hc = zB;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                d(kVar, fC, fU);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.d(kVar, fC, fU);
                    }
                });
            }
        }
    }

    protected void d(k kVar, float f, float f2) {
        d(this.hc, kVar.mk());
        boolean z = this.hc;
        if (z && !this.uo) {
            d(f, f2);
            hc(this.c);
            if (this.tt != null) {
                this.tt.d(d(), kVar);
                return;
            }
            return;
        }
        if (!z) {
            u.d().u(this.b);
        }
        d(kVar.mk(), kVar.tc());
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.mk
    public void d(View view, int i, com.bytedance.sdk.component.adexpress.b bVar) {
        gb gbVar = this.mk;
        if (gbVar != null) {
            gbVar.d(view, i, bVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.mk
    public void d(View view, int i, com.bytedance.sdk.component.adexpress.b bVar, int i2) {
        gb gbVar = this.mk;
        if (gbVar != null) {
            gbVar.d(view, i, bVar, i2);
        }
    }

    protected void d(float f, float f2) {
        this.mq.h().gb();
        if (com.bytedance.sdk.component.adexpress.c.d() && b() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            d().setLayoutParams(layoutParams);
            return;
        }
        int iD = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.an, f);
        int iD2 = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.an, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) d().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iD, iD2);
        }
        layoutParams2.width = iD;
        layoutParams2.height = iD2;
        d().setLayoutParams(layoutParams2);
    }

    private void d(int i, String str) {
        if (this.tt != null) {
            this.tt.d(i, str);
        }
    }

    private int hc(Activity activity) {
        return activity.hashCode();
    }

    public void gb() {
        tt();
        Activity activityD = com.bytedance.sdk.component.utils.hc.d(this.b);
        if (activityD != null) {
            this.k = hc(activityD);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.d
    public void d(Activity activity) {
        if (this.k == 0 || activity == null || activity.hashCode() != this.k) {
            return;
        }
        c();
        tc();
    }

    public uo mk() {
        return this.mq;
    }
}
