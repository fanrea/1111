package com.kwad.components.ct.detail.b;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ct.detail.b {
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.g.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (g.this.ayB) {
                float fFx = com.kwad.components.ct.home.config.b.Fx();
                if (fFx > 0.0f) {
                    g.this.aoz.setSpeed(fFx);
                }
            }
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
        }
    };
    private com.kwad.components.ct.detail.e.a aoz;
    private boolean ayB;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        long jLongValue;
        super.ay();
        this.aoz = this.aop.aoz;
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        this.ayB = false;
        if (this.aoz == null || ctAdTemplate == null) {
            return;
        }
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            jLongValue = com.kwad.sdk.core.response.b.a.M(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate));
        } else {
            jLongValue = com.kwad.components.ct.response.a.c.f((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate)).longValue() / 1000;
        }
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl != null && sceneImpl.getPageScene() == 1 && jLongValue >= com.kwad.components.ct.home.config.b.Fy()) {
            this.ayB = true;
        }
        if (this.ayB) {
            this.aop.aoq.add(this.aoQ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aop != null) {
            this.aop.aoq.remove(this.aoQ);
        }
    }
}
