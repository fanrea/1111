package com.kwad.components.core.page.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public f.a VA;

    @Deprecated
    public com.kwad.components.core.webview.jshandler.b VB;
    public boolean VC = false;
    public boolean VD = false;
    public AdWebViewActivityProxy.a Vi;
    public com.kwad.components.core.page.a.a Vy;
    public KsAdWebView.c Vz;
    public ViewGroup lz;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    public Context mContext;
    public String mPageTitle;
    public String mPageUrl;
    public boolean mShowPermission;
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.Vz = null;
        this.VA = null;
        this.mWebCardCloseListener = null;
        this.VB = null;
    }

    public final boolean rh() {
        return this.mShowPermission;
    }

    public final void a(KsAdWebView.c cVar) {
        this.Vz = cVar;
    }

    public final void a(f.a aVar) {
        this.VA = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    private void aK(boolean z) {
        this.VD = true;
    }

    public final void a(boolean z, View view) {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            if (z) {
                com.kwad.sdk.core.adlog.c.co(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.a aVar = this.Vy;
        if (aVar != null) {
            aVar.rc();
        }
    }

    public final boolean rs() {
        return this.VD;
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.VB = bVar;
        aK(true);
    }

    public final void rm() {
        com.kwad.components.core.webview.jshandler.b bVar = this.VB;
        if (bVar != null) {
            bVar.rG();
        }
    }

    public final boolean rt() {
        return !rh();
    }
}
