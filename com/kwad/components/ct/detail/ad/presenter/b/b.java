package com.kwad.components.ct.detail.ad.presenter.b;

import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private List<Integer> dX;
    private AdInfo mAdInfo;
    private CtAdTemplate mAdTemplate;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.ad.presenter.b.b.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            b.this.mk();
            com.kwad.components.core.u.b.tq().a(b.this.mAdTemplate, null, null);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.c(j2);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            b.this.ml();
        }
    };

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        this.mAdInfo = adInfoEP;
        this.dX = com.kwad.sdk.core.response.b.a.bv(adInfoEP);
        if (this.aop.aoz != null) {
            this.aop.aoz.c(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.mVideoPlayStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk() {
        c.cm(this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml() {
        c.cn(this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.dX) {
            if (iCeil >= num.intValue()) {
                c.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                this.dX.remove(num);
                return;
            }
        }
    }
}
