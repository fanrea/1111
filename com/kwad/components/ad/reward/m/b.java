package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.k.a<k> implements g.a {
    private com.kwad.components.core.h.c CY;

    @Override // com.kwad.components.ad.reward.g.a
    public final void hh() {
    }

    public b(AdTemplate adTemplate) {
        super(adTemplate);
        long jN = com.kwad.sdk.core.response.b.a.N(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        com.kwad.components.core.h.c cVar = new com.kwad.components.core.h.c();
        this.CY = cVar;
        cVar.E(jN);
    }

    public final FrameLayout T(Context context) {
        FrameLayout imagePlayerView = this.CY.getImagePlayerView(context);
        this.CY.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    public final void kW() {
        this.CY.setURLs(com.kwad.sdk.core.response.b.a.bg(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)));
        this.CY.play();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.CY.skipToEnd();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.CY.getPlayDuration();
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.CY.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.CY.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void b(k kVar) {
        this.CY.c(kVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void a(k kVar) {
        this.CY.d(kVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        this.CY.destroy();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hi() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hj() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hk() {
        this.CY.destroy();
    }
}
