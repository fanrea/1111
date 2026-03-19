package com.kwad.components.ct.tube.panel.choose.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.tube.panel.choose.a.a.a {
    private KSRelativeLayout aMs;
    private final m awn = new m() { // from class: com.kwad.components.ct.tube.panel.choose.a.b.c.1
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            c.this.Bz();
        }
    };
    private TubeEpisode mTubeEpisode;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aMs = (KSRelativeLayout) findViewById(R.id.ksad_tube_episode_item_root);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mTubeEpisode = com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay((CtAdTemplate) ((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).cdM));
        this.aMs.setViewVisibleListener(this.awn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aMs.setViewVisibleListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Bz() {
        com.kwad.components.ct.e.b.JK().V((CtAdTemplate) ((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).cdM);
    }
}
