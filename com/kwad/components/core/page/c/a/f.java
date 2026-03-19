package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.b.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.core.page.c.a.a {
    private boolean VV;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public interface a {
        void aW(int i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.VV = TextUtils.equals(this.Vx.mPageUrl, com.kwad.sdk.core.response.b.a.aW(com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate)));
        rC();
    }

    private String getTitle() {
        if (TextUtils.isEmpty(this.Vx.mPageTitle)) {
            return (this.Vx.mAdTemplate.adInfoList == null || this.Vx.mAdTemplate.adInfoList.size() <= 0 || this.Vx.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.b.a.cz(com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate));
        }
        return this.Vx.mPageTitle;
    }

    private void rC() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.Vx.lz);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.aj(true);
        this.mTitleBarHelper.a(new a.InterfaceC0458a() { // from class: com.kwad.components.core.page.c.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC0458a
            public final void x(View view) {
                f.this.A(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0458a
            public final void y(View view) {
                f.this.B(view);
            }
        });
        ViewGroup viewGroupHT = this.mTitleBarHelper.hT();
        int i = 0;
        if (!this.Vx.mAdTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.b.a.cC(this.Vx.mAdTemplate) && !com.kwad.sdk.core.response.b.b.dQ(com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate))) {
            i = 8;
        }
        viewGroupHT.setVisibility(i);
        this.Vx.a(new a() { // from class: com.kwad.components.core.page.c.a.f.2
            @Override // com.kwad.components.core.page.c.a.f.a
            public final void aW(int i2) {
                f.this.mTitleBarHelper.hT().setVisibility(i2 == 1 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(View view) {
        if (this.Vx != null) {
            this.Vx.a(this.VV, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        if (this.Vx.Vy != null) {
            this.Vx.Vy.rd();
        }
    }
}
