package com.kwad.components.ad.draw.b;

import android.content.Context;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public KsDrawAd.AdInteractionListener eU;
    private boolean fn;
    public com.kwad.components.ad.draw.c.a fo;
    public IAdLivePlayModule fp;
    public IAdLiveOfflineView fq;
    public com.kwad.components.ad.draw.presenter.b.a fr;
    public com.kwad.components.ad.l.b fs;
    public c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        IAdLivePlayModule iAdLivePlayModule = this.fp;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
            this.fp = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.fq;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.fq = null;
        }
        com.kwad.components.ad.draw.c.a aVar = this.fo;
        if (aVar != null) {
            aVar.release();
        }
    }

    public final void a(int i, Context context, final int i2, int i3) {
        a.C0469a c0469aAG = new a.C0469a(context).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aG(i3);
        IAdLivePlayModule iAdLivePlayModule = this.fp;
        com.kwad.components.core.e.d.a.a(c0469aAG.A(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ay(true).aF(i2).aE(i).a(new a.b() { // from class: com.kwad.components.ad.draw.b.b.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    b.this.a(i2, null);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.eP(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        KsDrawAd.AdInteractionListener adInteractionListener = this.eU;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        if (this.fn) {
            return;
        }
        com.kwad.components.ad.draw.a.c.b(this.mAdTemplate, 1, com.kwad.sdk.core.response.b.b.dB(this.mAdTemplate) ? 2 : 1);
        this.fn = true;
    }
}
