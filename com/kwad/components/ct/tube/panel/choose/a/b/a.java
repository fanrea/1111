package com.kwad.components.ct.tube.panel.choose.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.tube.panel.choose.TubeEpisodeChooseParam;
import com.kwad.components.ct.tube.slide.b.b;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.tube.panel.choose.a.a.a implements View.OnClickListener {
    private TubeEpisodeChooseParam aXs;
    private TubeEpisode mTubeEpisode;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        getRootView().setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aXs = ((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).aXl.aXr;
        this.mTubeEpisode = com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay((CtAdTemplate) ((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).cdM));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.tube.slide.b.b.KX().KY();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        if (!this.mTubeEpisode.locked) {
            com.kwad.components.ct.tube.panel.a.a.KH().c(((com.kwad.components.ct.tube.panel.choose.c) ((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).avY).KF(), this.mTubeEpisode);
            KG();
        } else {
            com.kwad.components.ct.tube.slide.b.b.KX().a(((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).mSceneImpl, this.aXs.mKSTubeParam, com.kwad.components.ct.tube.d.b.d(this.mTubeEpisode), this.aXs.mNextTubeLockEpisodeNum, new b.InterfaceC0542b() { // from class: com.kwad.components.ct.tube.panel.choose.a.b.a.1
                @Override // com.kwad.components.ct.tube.slide.b.b.InterfaceC0542b
                public final void b(List<CtAdTemplate> list, TubeEpisode tubeEpisode) {
                    com.kwad.components.ct.tube.panel.a.a.KH().c(list, tubeEpisode);
                    a.this.KG();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        com.kwad.components.ct.e.b.JK().JM();
    }
}
