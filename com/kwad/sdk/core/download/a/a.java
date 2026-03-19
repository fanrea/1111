package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }

    public a() {
    }

    public a(String str) {
        this.downloadId = str;
    }

    public final String pL() {
        return this.downloadId;
    }
}
