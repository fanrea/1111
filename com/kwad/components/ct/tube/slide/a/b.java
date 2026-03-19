package com.kwad.components.ct.tube.slide.a;

import com.kwad.components.core.proxy.h;
import com.kwad.components.ct.home.e;
import com.kwad.components.ct.tube.panel.a.c;
import com.kwad.sdk.api.core.fragment.KsFragment;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends e {
    private h aYI;
    private final com.kwad.sdk.m.a.b ayk = new com.kwad.sdk.m.a.b() { // from class: com.kwad.components.ct.tube.slide.a.b.1
        @Override // com.kwad.sdk.m.a.b
        public final boolean onBackPressed() {
            return b.this.KV();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KV() {
        KsFragment ksFragmentFindFragmentByTag = this.aYI.getChildFragmentManager().findFragmentByTag("TubePanelTabFragment");
        if (ksFragmentFindFragmentByTag == null) {
            return false;
        }
        c.KJ().g(ksFragmentFindFragmentByTag);
        return true;
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        h hVar = this.aGP.aGE;
        this.aYI = hVar;
        hVar.addBackPressable(this.ayk, 0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aGP.aGE.removeBackPressable(this.ayk);
    }
}
