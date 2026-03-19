package com.kwad.components.ad.splashscreen.presenter;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends e {
    private List<Integer> dX;
    private final com.kwad.components.core.video.n mVideoPlayStateListener = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.splashscreen.presenter.d.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            d.this.mk();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.c(j2);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            d.this.ml();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.dX = com.kwad.sdk.core.response.b.a.bv(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate));
        if (this.HX.Hi != null) {
            this.HX.Hi.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.HX.Hi != null) {
            this.HX.Hi.a(this.mVideoPlayStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk() {
        com.kwad.sdk.core.adlog.c.cm(this.HX.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml() {
        com.kwad.sdk.core.adlog.c.cn(this.HX.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.dX.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.HX.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }
}
