package com.kwad.components.ct.horizontal.feed.item.presenter;

import android.view.View;
import com.kwad.components.ct.horizontal.detail.HorizontalFeedParam;
import com.kwad.components.ct.horizontal.news.NewsDetailParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.horizontal.feed.item.a.b implements View.OnClickListener {
    private View aLY;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aLY = findViewById(R.id.ksad_horizontal_feed_item_title);
        getRootView().setOnClickListener(this);
        this.aLY.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        int i = view == this.aLY ? 6 : 1;
        n.d(com.kwad.components.ct.response.a.a.O(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).avY.getItems()), ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition);
        if (com.kwad.components.ct.response.a.a.at(this.mAdTemplate)) {
            Hx();
        } else {
            Hw();
        }
        cx(i);
    }

    private void Hw() {
        HorizontalFeedParam horizontalFeedParam = new HorizontalFeedParam();
        horizontalFeedParam.mScene = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mScene;
        horizontalFeedParam.mAdTemplate = this.mAdTemplate;
        com.kwad.components.ct.horizontal.detail.a.a(getContext(), horizontalFeedParam);
    }

    private void Hx() {
        NewsDetailParam newsDetailParam = new NewsDetailParam();
        newsDetailParam.mEntryScene = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mScene;
        newsDetailParam.mEntryAdTemplate = this.mAdTemplate;
        com.kwad.components.ct.horizontal.news.a.a(getContext(), newsDetailParam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void cx(int i) {
        com.kwad.components.ct.e.b.JK().d((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, i);
    }
}
