package com.kwad.components.ad.nativead.a;

import android.view.View;
import com.kwad.components.core.video.n;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends Presenter {
    public n mVideoPlayStateListener;
    public b rg;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.rg = (b) amf();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.rg.rh.a(this.mVideoPlayStateListener);
    }

    protected static void a(View view, String str) {
        if (view == null) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException(" findViewById failed " + str));
        }
    }
}
