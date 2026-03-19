package com.kwad.components.ct.detail.photo.d;

import android.view.View;
import android.widget.LinearLayout;
import com.kwad.components.ct.request.live.a;
import com.kwad.components.ct.request.n;
import com.kwad.components.ct.response.model.home.PhotoShareInfo;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class n extends a<LinearLayout> {
    public h asN;
    protected com.kwad.components.ct.detail.photo.e.c asO;
    private boolean asX = false;

    static /* synthetic */ boolean a(n nVar, boolean z) {
        nVar.asX = false;
        return false;
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.asN = this.asK.ati;
        this.asO = this.asK.asO;
        com.kwad.components.ct.e.b.JK().N(this.asN.mAdTemplate);
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.asO = null;
    }

    @Override // com.kwad.components.ct.detail.photo.e.d
    /* renamed from: Ae */
    public LinearLayout Ag() {
        return Af();
    }

    private com.kwad.components.ct.detail.photo.newui.b.a Af() {
        com.kwad.components.ct.detail.photo.newui.b.a aVar = new com.kwad.components.ct.detail.photo.newui.b.a(getContext());
        aVar.setButtonImageResource(((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj().aqz);
        aVar.setButtonText("复制链接");
        return aVar;
    }

    public void onClick(View view) {
        if (this.asN == null) {
            return;
        }
        if (this.asX) {
            com.kwad.sdk.core.d.c.d("PhotoShareButtonPresenter", "mIsRequesting= " + this.asX);
            return;
        }
        this.asX = true;
        EcLiveComponents ecLiveComponents = (EcLiveComponents) com.kwad.sdk.components.d.g(EcLiveComponents.class);
        if (ecLiveComponents != null && com.kwad.components.ct.response.a.a.aq(this.asN.mAdTemplate)) {
            a(ecLiveComponents.LL());
        } else {
            new com.kwad.components.ct.request.n().a(com.kwad.components.ct.response.a.c.j((PhotoInfo) this.asN.mAdTemplate.photoInfo), 0, new n.a() { // from class: com.kwad.components.ct.detail.photo.d.n.1
                @Override // com.kwad.components.ct.request.n.a
                public final void onError(int i, String str) {
                    com.kwad.sdk.core.d.c.d("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                    if (i == com.kwad.sdk.core.network.e.bCJ.errorCode) {
                        ac.ae(n.this.getContext(), str);
                    } else {
                        ac.ae(n.this.getContext(), "复制链接失败，请稍后重试");
                    }
                    if (n.this.asO != null) {
                        n.this.asO.b(n.this);
                    }
                    com.kwad.components.ct.e.b.JK().c(n.this.asN.mAdTemplate, false);
                    n.a(n.this, false);
                }

                @Override // com.kwad.components.ct.request.n.a
                public final void a(PhotoShareInfo photoShareInfo) {
                    com.kwad.sdk.core.d.c.d("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                    com.kwad.sdk.utils.o.a(n.this.getContext(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                    ac.ae(n.this.getContext(), "链接已经复制\n快分享给好友吧");
                    if (n.this.asO != null) {
                        n.this.asO.b(n.this);
                    }
                    com.kwad.components.ct.e.b.JK().c(n.this.asN.mAdTemplate, true);
                    n.a(n.this, false);
                }
            });
        }
    }

    private void a(a.C0534a c0534a) {
        new com.kwad.components.ct.request.n().a(c0534a, new n.a() { // from class: com.kwad.components.ct.detail.photo.d.n.2
            @Override // com.kwad.components.ct.request.n.a
            public final void onError(int i, String str) {
                com.kwad.sdk.core.d.c.d("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                if (i == com.kwad.sdk.core.network.e.bCJ.errorCode) {
                    ac.ae(n.this.getContext(), str);
                } else {
                    ac.ae(n.this.getContext(), "复制链接失败，请稍后重试");
                }
                if (n.this.asO != null) {
                    n.this.asO.b(n.this);
                }
                com.kwad.components.ct.e.b.JK().c(n.this.asN.mAdTemplate, false);
                n.a(n.this, false);
            }

            @Override // com.kwad.components.ct.request.n.a
            public final void a(PhotoShareInfo photoShareInfo) {
                com.kwad.sdk.core.d.c.d("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                com.kwad.sdk.utils.o.a(n.this.getContext(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                ac.ae(n.this.getContext(), "链接已经复制，快分享给好友吧");
                if (n.this.asO != null) {
                    n.this.asO.b(n.this);
                }
                com.kwad.components.ct.e.b.JK().c(n.this.asN.mAdTemplate, true);
                n.a(n.this, false);
            }
        });
    }
}
