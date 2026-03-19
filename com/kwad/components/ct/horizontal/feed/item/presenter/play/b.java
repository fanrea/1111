package com.kwad.components.ct.horizontal.feed.item.presenter.play;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.b;
import com.kwad.components.ct.horizontal.feed.c.a;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private com.kwad.components.core.widget.b aLU;
    private KsAdVideoPlayConfig dG = new KsAdVideoPlayConfig.Builder().build();
    private a.InterfaceC0524a aMn = new a.InterfaceC0524a() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.b.1
        @Override // com.kwad.components.ct.horizontal.feed.c.a.InterfaceC0524a
        public final void HA() {
            if (((com.kwad.components.ct.horizontal.feed.item.a.a) b.this.cdN).aLK.aMY != null) {
                ((com.kwad.components.ct.horizontal.feed.item.a.a) b.this.cdN).aLK.aMY.cy(((com.kwad.components.ct.horizontal.feed.item.a.a) b.this.cdN).mCurrentPosition);
            }
        }
    };
    private Runnable avO = new Runnable() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.b.3
        @Override // java.lang.Runnable
        public final void run() {
            if (((com.kwad.components.ct.horizontal.feed.item.a.a) b.this.cdN).aLK.aMY != null) {
                ((com.kwad.components.ct.horizontal.feed.item.a.a) b.this.cdN).aLK.aMY.cy(((com.kwad.components.ct.horizontal.feed.item.a.a) b.this.cdN).mCurrentPosition);
            }
        }
    };
    private g aMo = new g() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.b.4
        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.g
        public final void cA(int i) {
        }

        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.g
        public final void start(boolean z) {
            if (b.this.aLU instanceof com.kwad.components.ct.horizontal.feed.c.a) {
                ((com.kwad.components.ct.horizontal.feed.c.a) b.this.aLU).ur();
            } else {
                b.this.aLU.postDelayed(b.this.avO, 6000L);
            }
        }

        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.g
        public final void bW(boolean z) {
            b.this.aLU.removeCallbacks(b.this.avO);
            if (b.this.aLU instanceof com.kwad.components.ct.horizontal.feed.c.a) {
                ((com.kwad.components.ct.horizontal.feed.c.a) b.this.aLU).uq();
            }
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        View rootView = getRootView();
        if (rootView instanceof com.kwad.components.core.widget.b) {
            this.aLU = (com.kwad.components.core.widget.b) rootView;
        }
        com.kwad.components.core.widget.b bVar = this.aLU;
        if (bVar != null) {
            bVar.d(com.kwad.sdk.core.response.b.c.ev(ctAdTemplate));
            com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) com.kwad.sdk.components.d.g(com.kwad.components.ad.b.d.class);
            if (dVar == null || !dVar.a(this.aLU, this.dG)) {
                com.kwad.components.core.widget.b bVar2 = this.aLU;
                if (bVar2 instanceof com.kwad.components.ct.horizontal.feed.c.a) {
                    ((com.kwad.components.ct.horizontal.feed.c.a) bVar2).setCanControlPlay(true);
                    ((com.kwad.components.ct.horizontal.feed.c.a) this.aLU).b(this.dG);
                    ((com.kwad.components.ct.horizontal.feed.c.a) this.aLU).setFeedVideoPlayerControlListener(this.aMn);
                }
            }
            a(this.aLU);
            if (Hv()) {
                this.aLU.post(new bh() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.b.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b.this.aLU.getLayoutParams();
                        if (marginLayoutParams != null) {
                            marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(b.this.getContext(), 10.0f);
                            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(b.this.getContext(), 10.0f);
                            marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(b.this.getContext(), 16.0f);
                            marginLayoutParams.rightMargin = com.kwad.sdk.c.a.a.a(b.this.getContext(), 16.0f);
                            marginLayoutParams.width = -1;
                            b.this.aLU.setLayoutParams(marginLayoutParams);
                        }
                    }
                });
            }
        }
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMX.put(Integer.valueOf(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition), this.cdN);
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLT = this.aMo;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aLU.cv();
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMX.remove(Integer.valueOf(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition));
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLT = null;
    }

    private void a(com.kwad.components.core.widget.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.a() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.b.5
            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                b.this.By();
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                b.this.Bz();
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                ac.ae(b.this.getContext(), "操作成功，将减少此类推荐");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Bz() {
        com.kwad.components.ct.e.b.JK().c((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void By() {
        com.kwad.components.ct.e.b.JK().b((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, 1, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
    }

    private boolean Hv() {
        com.kwad.components.core.widget.b bVar = this.aLU;
        return ((bVar instanceof com.kwad.components.ct.horizontal.feed.c.e) || (bVar instanceof com.kwad.components.ct.horizontal.feed.c.d)) ? false : true;
    }
}
