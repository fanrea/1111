package com.kwad.components.ct.horizontal.news.a.b;

import android.view.View;
import com.kwad.components.ct.horizontal.news.NewsDetailParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.utils.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.horizontal.news.a.a.a implements View.OnClickListener {
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        getRootView().setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM;
        this.avY = ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).avY;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        Ia();
        By();
    }

    private void Ia() {
        n.d(com.kwad.components.ct.response.a.a.O(this.avY.getItems()), ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).mCurrentPosition);
        NewsDetailParam newsDetailParam = new NewsDetailParam();
        newsDetailParam.mEntryScene = ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).mScene;
        newsDetailParam.mEntryAdTemplate = this.mAdTemplate;
        com.kwad.components.ct.horizontal.news.a.a(getContext(), newsDetailParam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void By() {
        com.kwad.components.ct.e.b.JK().c((CtAdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).aNx.mEntryAdTemplate);
    }
}
