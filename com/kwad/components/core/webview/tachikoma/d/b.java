package com.kwad.components.core.webview.tachikoma.d;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends com.kwad.sdk.mvp.a {
    public long CF;
    public String Cz;
    public com.kwad.components.core.webview.tachikoma.f.c ZP;
    public StyleTemplate ZR;
    public e ahi;
    public i ajq;
    public l ajr;
    public k ajs;
    public boolean ajt;
    public e.a aju;
    public Activity mActivity;
    public AdResultData mAdResultData;

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.ahi = null;
        this.mActivity = null;
        this.ajq = null;
    }
}
