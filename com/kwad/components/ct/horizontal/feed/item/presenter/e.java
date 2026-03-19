package com.kwad.components.ct.horizontal.feed.item.presenter;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private KSFrameLayout aLZ;
    private final m aMa = new m() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.e.1
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            e.this.Bz();
        }
    };
    private final m aMb = new m() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.e.2
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            e.this.Hy();
        }
    };
    private KSFrameLayout awm;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awm = (KSFrameLayout) findViewById(R.id.ksad_horizontal_feed_item_root);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_horizontal_feed_item_suggest_log);
        this.aLZ = kSFrameLayout;
        kSFrameLayout.setVisiblePercent(0.6f);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.awm.setViewVisibleListener(this.aMa);
        this.aLZ.setViewVisibleListener(this.aMb);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.awm.setViewVisibleListener(null);
        this.aLZ.setViewVisibleListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Bz() {
        com.kwad.components.ct.e.b.JK().c((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Hy() {
        com.kwad.components.ct.e.b.JK().o((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
    }
}
