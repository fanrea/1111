package com.kwad.components.ct.horizontal.video.b.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.horizontal.video.b.a.a.a {
    private final m aMa = new m() { // from class: com.kwad.components.ct.horizontal.video.b.a.b.e.1
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            e.this.HX();
        }
    };
    private final m aMb = new m() { // from class: com.kwad.components.ct.horizontal.video.b.a.b.e.2
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            e.this.ID();
        }
    };
    private KSRelativeLayout aMs;
    private KSFrameLayout aPf;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aMs = (KSRelativeLayout) findViewById(R.id.ksad_horizontal_detail_video_related_item_view);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_horizontal_detail_video_related_suggest_log_view);
        this.aPf = kSFrameLayout;
        kSFrameLayout.setVisiblePercent(0.6f);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aMs.setViewVisibleListener(this.aMa);
        this.aPf.setViewVisibleListener(this.aMb);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aMs.setViewVisibleListener(null);
        this.aPf.setViewVisibleListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void HX() {
        com.kwad.components.ct.e.b.JK().a((CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void ID() {
        com.kwad.components.ct.e.b.JK().b((CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb.mAdTemplate);
    }
}
