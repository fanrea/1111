package com.kwad.components.core.page.c;

import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends Presenter {
    private int Vm;
    private FeedVideoView Vn;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) amf();
        KsAdVideoPlayConfig ksAdVideoPlayConfigBuild = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Vn = feedVideoView;
        feedVideoView.d(com.kwad.sdk.core.response.b.c.ev(eVar.adTemplate));
        this.Vn.a(ksAdVideoPlayConfigBuild, eVar.QQ);
        this.Vn.setVisibility(0);
        final AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(eVar.adTemplate);
        this.Vn.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
                        if (eVar.QQ != null) {
                            com.kwad.components.core.e.d.a.a(new a.C0469a(a.this.getActivity()).aq(false).ar(false).av(true).aC(eVar.adTemplate).at(false));
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Vn.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    if (eVar.WN == null || eVar.WN.getAdapter() == null || eVar.WN.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    eVar.WN.scrollToPosition(1);
                    com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Vn.getTouchCoords());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.as(adInfoEP)) {
            this.Vn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
                            if (eVar.QQ != null) {
                                com.kwad.components.core.e.d.a.a(new a.C0469a(a.this.getActivity()).aq(false).ar(false).av(true).aC(eVar.adTemplate).at(false));
                                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.Vn.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        if (eVar.WN == null || eVar.WN.getAdapter() == null || eVar.WN.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        eVar.WN.scrollToPosition(1);
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.Vn.getTouchCoords());
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
        this.Vn.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.c.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void rp() {
                if (eVar.WN != null) {
                    a.this.Vm = eVar.WN.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void rq() {
                if (eVar.WN != null) {
                    eVar.WN.scrollToPosition(a.this.Vm);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Vn.release();
    }
}
