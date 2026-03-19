package com.bytedance.sdk.component.widget;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.de;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.component.widget.web.BizWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SSWebView extends BizWebView {
    private String an;
    private float cb;
    private AtomicBoolean de;
    private float e;
    private boolean gb;
    private JSONObject h;
    private JSONObject he;
    private b j;
    private hc jh;
    private boolean k;
    private long mk;
    private long mq;
    private AtomicBoolean np;
    private int rf;
    private de sy;
    private float tc;
    private float tt;
    private com.bytedance.sdk.component.widget.hc.d u;
    private long uo;
    private AtomicBoolean v;
    private JSONObject vv;
    private float w;
    private AtomicInteger yi;
    private int yo;
    private JSONObject zw;

    public interface b {
        void d(boolean z);
    }

    public interface hc {
        void d(int i);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public com.bytedance.sdk.component.widget.hc.d getMaterialMeta() {
        return this.u;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.hc.d dVar) {
        this.u = dVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.an;
    }

    public void setTag(String str) {
        this.an = str;
    }

    public void setLandingPage(boolean z) {
        this.gb = z;
    }

    public void setTouchStateListener(b bVar) {
        this.j = bVar;
    }

    public SSWebView(Context context) {
        super(context);
        this.tt = 0.0f;
        this.tc = 0.0f;
        this.mk = 0L;
        this.mq = 0L;
        this.uo = 0L;
        this.k = false;
        this.e = 20.0f;
        this.w = 50.0f;
        this.de = new AtomicBoolean();
        this.v = new AtomicBoolean();
        this.np = new AtomicBoolean(true);
        this.yi = new AtomicInteger();
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        an();
        super.G_();
    }

    private void an() {
        this.sy = null;
        this.jh = null;
        setTouchStateListener(null);
        I_();
        this.u = null;
        this.h = null;
        this.gb = false;
    }

    public boolean H_() {
        de deVar = this.sy;
        if (deVar == null) {
            return false;
        }
        return deVar.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.uo.b
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof b) {
            setTouchStateListener((b) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new d();
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentD;
        try {
            d(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.k && (viewParentD = d((View) this)) != null) {
                viewParentD.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.k = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent d(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (hc(view2) || b(view2)) ? parent : d(view2);
    }

    private static boolean hc(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            mq.d(th2);
            return false;
        }
    }

    private boolean b(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            mq.d(th2);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.uo.b
    public void onPause() {
        super.onPause();
        b bVar = this.j;
        if (bVar != null) {
            bVar.d(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar = this.j;
        if (bVar != null) {
            bVar.d(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.uo.b
    public void destroy() {
        super.destroy();
        an();
    }

    public void d(int i, boolean z) {
        this.np.set(z);
        this.yi.set(i);
        this.v.set(true);
        if (this.de.get()) {
            hc(i, z);
        }
    }

    private void hc(int i, boolean z) {
        de deVar = this.sy;
        if (deVar == null) {
            this.sy = new de(getContext(), i, z);
        } else {
            deVar.d(z);
        }
        this.sy.d(this.e);
        this.sy.b(this.cb);
        this.sy.hc(this.w);
        this.sy.d(this.he);
        this.sy.b(this.vv);
        this.sy.hc(this.zw);
        this.sy.u(this.yo);
        this.sy.an(this.rf);
        this.sy.d(new de.d() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.de.d
            public void d(int i2) {
                if (i2 == 1) {
                    SSWebView.this.d(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.d(2);
                }
            }
        });
        de deVar2 = this.sy;
        com.bytedance.sdk.component.widget.hc.d dVar = this.u;
        deVar2.b(dVar != null ? dVar.d() : 0);
    }

    public void d(int i) {
        hc hcVar = this.jh;
        if (hcVar != null) {
            hcVar.d(i);
        }
    }

    public void I_() {
        this.v.set(false);
        de deVar = this.sy;
        if (deVar != null) {
            com.bytedance.sdk.component.widget.hc.d dVar = this.u;
            deVar.c(dVar != null ? dVar.d() : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.de.set(true);
        if (this.v.get()) {
            hc(this.yi.get(), this.np.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.de.set(false);
        de deVar = this.sy;
        if (deVar != null) {
            com.bytedance.sdk.component.widget.hc.d dVar = this.u;
            deVar.hc(dVar != null ? dVar.d() : 0);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        de deVar = this.sy;
        if (deVar != null) {
            if (z) {
                com.bytedance.sdk.component.widget.hc.d dVar = this.u;
                deVar.d(dVar != null ? dVar.d() : 0);
            } else {
                com.bytedance.sdk.component.widget.hc.d dVar2 = this.u;
                deVar.hc(dVar2 != null ? dVar2.d() : 0);
            }
        }
    }

    private void d(MotionEvent motionEvent) {
        if (!this.gb || this.u == null) {
            return;
        }
        if ((this.an == null && this.h == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.tt = motionEvent.getRawX();
                this.tc = motionEvent.getRawY();
                this.mk = System.currentTimeMillis();
                this.h = new JSONObject();
                if (this.hc != null) {
                    this.hc.setTag(2064056319, Long.valueOf(this.mk));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.h.put("start_x", String.valueOf(this.tt));
                this.h.put("start_y", String.valueOf(this.tc));
                this.h.put("offset_x", String.valueOf(motionEvent.getRawX() - this.tt));
                this.h.put("offset_y", String.valueOf(motionEvent.getRawY() - this.tc));
                this.h.put("url", String.valueOf(getUrl()));
                this.h.put("tag", "");
                this.mq = System.currentTimeMillis();
                if (this.hc != null) {
                    this.hc.setTag(2064056318, Long.valueOf(this.mq));
                }
                this.h.put("down_time", this.mk);
                this.h.put("up_time", this.mq);
                if (com.bytedance.sdk.component.widget.d.d.d().hc() != null) {
                    long j = this.uo;
                    long j2 = this.mk;
                    if (j != j2) {
                        this.uo = j2;
                        com.bytedance.sdk.component.widget.d.d.d();
                    }
                }
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public void setShakeValue(float f) {
        this.e = f;
    }

    public void setDeepShakeValue(float f) {
        this.cb = f;
    }

    public void setWriggleValue(float f) {
        this.w = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.he = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.vv = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.zw = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.yo = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.rf = i;
    }

    public void setOnShakeListener(hc hcVar) {
        this.jh = hcVar;
    }

    public static class d extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }
}
