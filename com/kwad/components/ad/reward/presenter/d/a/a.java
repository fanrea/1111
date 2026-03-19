package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.l.a;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements a.b {
    private FrameLayout gO;
    private o xH;
    private volatile long AM = 0;
    private volatile boolean AN = false;
    private o xI = new o() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.AM = j2;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.AN = true;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.AN = false;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.j
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.AN = false;
        }
    };
    private o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.AM = j2;
            a.this.AN = j - j2 < 800;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.4
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            if (a.this.vb.ub || a.this.vb.ty == null) {
                return;
            }
            a.this.vb.ty.bb();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            a.this.vb.tt.db();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gO = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.AM = 0L;
        this.AN = false;
        AdTemplate adTemplate = this.vb.mAdTemplate;
        com.kwad.components.ad.l.a aVar = this.vb.ty;
        this.xH = this.vb.tu.la() ? this.xI : this.lv;
        if (aVar != null) {
            this.vb.tV = true;
            aVar.a(this);
            aVar.a(this.gF);
            aVar.a(this.gO, this.vb.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0424a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.3
                @Override // com.kwad.components.ad.l.a.InterfaceC0424a
                public final void S(boolean z) {
                    a.this.vb.tV = z;
                }
            });
            aVar.setActivity(this.vb.getActivity());
            aVar.bi();
            this.vb.b(this.mPlayEndPageListener);
            this.vb.tu.a(this.xH);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.c(this.mPlayEndPageListener);
        this.vb.tu.b(this.xH);
    }

    @Override // com.kwad.components.ad.l.a.b
    public final void jK() {
        f.t(this.vb);
    }
}
