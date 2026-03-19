package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSApiWebView extends WebView {
    private com.kwad.sdk.core.webview.a.a bLA;
    private boolean bLz;

    public KSApiWebView(Context context) {
        super(cj(context));
        this.bLz = true;
        init();
    }

    public KSApiWebView(Context context, AttributeSet attributeSet) {
        super(cj(context), attributeSet);
        this.bLz = true;
        init();
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i) {
        super(cj(context), attributeSet, i);
        this.bLz = true;
        init();
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(cj(context), attributeSet, i, i2);
        this.bLz = true;
        init();
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(cj(context), attributeSet, i, z);
        this.bLz = true;
        init();
    }

    public void setNeedHybridLoad(boolean z) {
        this.bLA.setNeedHybridLoad(z);
    }

    private void init() {
        cc.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.bLA = aVar;
        setWebViewClient(aVar);
    }

    private static Context cj(Context context) {
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context contextFd = m.fd(context);
        if (m.fg(contextFd)) {
            return contextFd;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + contextFd.getClass().getName() + "--classloader:" + contextFd.getClass().getClassLoader() + "--context2:" + m.fd(ServiceProvider.anu()).getClass().getName()));
        return m.fd(ServiceProvider.anu());
    }

    public void setEnableDestroy(boolean z) {
        this.bLz = z;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.bLz) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
