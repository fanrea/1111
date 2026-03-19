package com.kwad.components.ct.horizontal.feed.b;

import android.widget.FrameLayout;
import com.kwad.components.core.u.e;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.feed.a.a {
    private FrameLayout aNc;
    private com.kwad.components.core.widget.a.b amL;
    private com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> avY;
    private com.kwad.sdk.core.j.c gZ;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aNc = (FrameLayout) findViewById(R.id.ksad_home_interstitial_ad_container);
    }

    @Override // com.kwad.components.ct.horizontal.feed.a.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.avY = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).avY;
        com.kwad.components.core.widget.a.b bVar = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aFs;
        this.amL = bVar;
        bVar.a(HO());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.amL.b(this.gZ);
        com.kwad.components.ct.home.a.d.Gi().bS("horizontal_feed_interstitial_ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HN() {
        int statusBarHeight = 0;
        if (getActivity() != null && e.e(getActivity())) {
            statusBarHeight = 0 + com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
        }
        com.kwad.components.ct.home.a.d.Gi().a(3, this.aNc, ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).mSceneImpl, "horizontal_feed_interstitial_ad", statusBarHeight);
    }

    private com.kwad.sdk.core.j.c HO() {
        com.kwad.sdk.core.j.c cVar = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.horizontal.feed.b.b.1
            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
            }

            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                if (b.this.avY.isEmpty()) {
                    return;
                }
                long jDQ = ag.dQ(((com.kwad.components.ct.horizontal.feed.a.b) b.this.cck).aGE.getContext());
                com.kwad.components.ct.home.a.d.Gi();
                if (com.kwad.components.ct.home.a.d.n(jDQ, System.currentTimeMillis())) {
                    b.this.HN();
                    b.this.HP();
                }
            }
        };
        this.gZ = cVar;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HP() {
        ag.h(((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aGE.getContext(), System.currentTimeMillis());
    }
}
