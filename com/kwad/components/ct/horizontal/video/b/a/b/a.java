package com.kwad.components.ct.horizontal.video.b.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.b;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.horizontal.video.b.a.a.a {
    private com.kwad.components.core.widget.b aLU;
    private KsAdVideoPlayConfig dG = new KsAdVideoPlayConfig.Builder().build();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM;
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
                    ((com.kwad.components.ct.horizontal.feed.c.a) bVar2).b(this.dG);
                }
            }
            a(this.aLU);
            this.aLU.post(new bh() { // from class: com.kwad.components.ct.horizontal.video.b.a.b.a.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.aLU.getLayoutParams();
                    if (marginLayoutParams != null) {
                        marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 16.0f);
                        marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 16.0f);
                        marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 16.0f);
                        marginLayoutParams.rightMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 16.0f);
                        marginLayoutParams.width = -1;
                        a.this.aLU.setLayoutParams(marginLayoutParams);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aLU.cv();
    }

    private void a(com.kwad.components.core.widget.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.a() { // from class: com.kwad.components.ct.horizontal.video.b.a.b.a.2
            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                a.this.By();
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                a.this.HX();
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                ac.ae(a.this.getContext(), "操作成功，将减少此类推荐");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void HX() {
        com.kwad.components.ct.e.b.JK().a((CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void By() {
        com.kwad.components.ct.e.b.JK().c((CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb.mAdTemplate);
    }
}
