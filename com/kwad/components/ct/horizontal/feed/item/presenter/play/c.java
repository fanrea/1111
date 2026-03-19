package com.kwad.components.ct.horizontal.feed.item.presenter.play;

import android.view.View;
import com.kwad.components.ct.horizontal.detail.HorizontalFeedParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.horizontal.feed.item.a.b implements View.OnClickListener {
    private View aMq;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewFindViewById = findViewById(R.id.ksad_horizontal_video_desc_view);
        this.aMq = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!com.kwad.sdk.c.a.a.Wl() && view == this.aMq) {
            Hw();
            com.kwad.components.ct.e.b.JK().l((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
            HB();
        }
    }

    private void Hw() {
        HorizontalFeedParam horizontalFeedParam = new HorizontalFeedParam();
        horizontalFeedParam.mScene = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mScene;
        horizontalFeedParam.mAdTemplate = this.mAdTemplate;
        if (((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLG != null) {
            horizontalFeedParam.mEnterPlayPosition = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLG.NN.getCurrentPosition();
        }
        com.kwad.components.ct.horizontal.detail.a.a(getContext(), horizontalFeedParam);
    }

    private void HB() {
        if (((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY != null) {
            ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY.cz(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition);
        }
    }
}
