package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class r extends e {
    private com.kwad.sdk.core.download.a.a Jx;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Jx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.r.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() throws Resources.NotFoundException {
                super.onDownloadStarted();
                Context context = r.this.getContext();
                if (context != null) {
                    String strDd = com.kwad.sdk.utils.m.dd(context);
                    ac.ae(context, strDd != null ? strDd + ":已开始下载" : "已开始下载");
                }
            }
        };
        this.HX.mApkDownloadHelper.b(this.Jx);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        if (this.Jx != null) {
            this.HX.mApkDownloadHelper.c(this.Jx);
        }
    }
}
