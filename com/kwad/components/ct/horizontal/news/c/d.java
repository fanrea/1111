package com.kwad.components.ct.horizontal.news.c;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.news.b.a {
    private View aOg;
    private final com.kwad.sdk.lib.b.f awa = new com.kwad.sdk.lib.b.g() { // from class: com.kwad.components.ct.horizontal.news.c.d.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            super.n(z, z2);
            if (!z || d.this.aNz.aFU.isEmpty()) {
                return;
            }
            d.this.aOg.setVisibility(0);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aOg = com.kwad.sdk.c.a.a.a((ViewGroup) getRootView(), R.layout.ksad_news_header_feed_title_layout, false);
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aOg.setVisibility(8);
        this.aNz.aFW.addHeaderView(this.aOg);
        this.aNz.avY.a(this.awa);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aNz.avY.b(this.awa);
    }
}
