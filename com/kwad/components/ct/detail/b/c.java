package com.kwad.components.ct.detail.b;

import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.detail.b {
    private int abR;
    private com.kwad.components.ct.detail.e.a aoz;
    private com.kwad.components.core.widget.a.b asB;
    private CtAdTemplate mAdTemplate;
    private final boolean axI = false;
    private boolean axJ = false;
    private boolean axK = false;
    private boolean axL = false;
    private final com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.c.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            c.a(c.this, false);
            c.b(c.this, false);
            c.c(c.this, false);
            c.this.asB.a(c.this.gZ);
            if (c.this.aoz == null || com.kwad.components.ct.response.a.a.aq(c.this.aop.mAdTemplate)) {
                return;
            }
            c.this.aoz.c(c.this.mVideoPlayStateListener);
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            if (c.this.axK) {
                c.this.BZ();
            }
            c.this.BX();
            c.this.asB.b(c.this.gZ);
            if (c.this.aoz == null || com.kwad.components.ct.response.a.a.aq(c.this.aop.mAdTemplate)) {
                return;
            }
            c.this.aoz.d(c.this.mVideoPlayStateListener);
        }
    };
    private final com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.detail.b.c.2
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            c.this.BW();
            c.this.BY();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            c.this.BZ();
        }
    };
    private final n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.b.c.3
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            c.this.BW();
            c.this.BY();
            c.this.Ca();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            if (c.this.asB.wO()) {
                c.this.BY();
            }
            c.this.Cc();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            if (!c.this.asB.wO()) {
                c.this.BZ();
            }
            c.this.Cb();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            c.this.Cd();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            c.this.v(i, i2);
        }
    };

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.axJ = false;
        return false;
    }

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.axK = false;
        return false;
    }

    static /* synthetic */ boolean c(c cVar, boolean z) {
        cVar.axL = false;
        return false;
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        j jVar = this.aop.aol;
        if (jVar == null) {
            com.kwad.sdk.core.d.c.w("DetailOpenListener", "homePageHelper is null");
            return;
        }
        this.asB = jVar.aFs;
        this.mAdTemplate = this.aop.mAdTemplate;
        this.abR = this.aop.abR;
        this.aop.aoq.add(0, this.aoQ);
        this.aoz = this.aop.aoz;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aop.aol == null) {
            return;
        }
        this.aop.aoq.remove(this.aoQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW() {
        if (this.axJ) {
            return;
        }
        this.axJ = true;
        com.kwad.components.ct.detail.listener.c.zh().i(this.abR, this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BX() {
        if (this.axJ) {
            com.kwad.components.ct.detail.listener.c.zh().l(this.abR, this.mAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BY() {
        if (!this.axK) {
            com.kwad.components.ct.detail.listener.c.zh().j(this.abR, this.mAdTemplate);
        }
        this.axK = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BZ() {
        if (this.axK) {
            com.kwad.components.ct.detail.listener.c.zh().k(this.abR, this.mAdTemplate);
        }
        this.axK = false;
    }

    protected final void Ca() {
        com.kwad.components.ct.detail.listener.c.zh().e(this.abR, this.mAdTemplate);
        this.axL = false;
    }

    protected final void Cb() {
        this.axL = true;
        com.kwad.components.ct.detail.listener.c.zh().f(this.abR, this.mAdTemplate);
    }

    protected final void Cc() {
        if (this.axL) {
            com.kwad.components.ct.detail.listener.c.zh().g(this.abR, this.mAdTemplate);
        }
        this.axL = false;
    }

    protected final void Cd() {
        com.kwad.components.ct.detail.listener.c.zh().h(this.abR, this.mAdTemplate);
    }

    protected final void v(int i, int i2) {
        com.kwad.components.ct.detail.listener.c.zh().b(this.abR, this.mAdTemplate, i, i2);
    }
}
