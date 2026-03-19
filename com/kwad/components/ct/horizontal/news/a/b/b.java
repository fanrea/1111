package com.kwad.components.ct.horizontal.news.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.news.a.a.a {
    private KSFrameLayout aLZ;
    private final m aNH = new m() { // from class: com.kwad.components.ct.horizontal.news.a.b.b.1
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            b.this.HX();
            b.this.HZ();
        }
    };
    private final m aNI = new m() { // from class: com.kwad.components.ct.horizontal.news.a.b.b.2
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            b.this.HY();
        }
    };
    private KSFrameLayout awm;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awm = (KSFrameLayout) findViewById(R.id.ksad_news_item_root);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_news_suggest_log_view);
        this.aLZ = kSFrameLayout;
        kSFrameLayout.setVisiblePercent(0.6f);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.awm.setViewVisibleListener(this.aNH);
        this.aLZ.setViewVisibleListener(this.aNI);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.awm.setViewVisibleListener(null);
        this.aLZ.setViewVisibleListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void HX() {
        com.kwad.components.ct.e.b.JK().a((CtAdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).aNx.mEntryAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void HY() {
        com.kwad.components.ct.e.b.JK().b((CtAdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).aNx.mEntryAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void HZ() {
        if (com.kwad.components.ct.response.a.a.eH((AdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM)) {
            com.kwad.components.core.u.b.tq().a((AdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM, null, null);
        }
    }
}
