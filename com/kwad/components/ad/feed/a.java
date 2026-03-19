package com.kwad.components.ad.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.feed.widget.j;
import com.kwad.components.ad.feed.widget.k;
import com.kwad.components.ad.feed.widget.m;
import com.kwad.components.ad.feed.widget.n;
import com.kwad.components.ad.feed.widget.o;
import com.kwad.components.ad.feed.widget.p;
import com.kwad.components.ad.feed.widget.q;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.d {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.d.class;
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        if (!l.UL().Vn()) {
            feedAdListener.onError(com.kwad.sdk.core.network.e.bCH.errorCode, com.kwad.sdk.core.network.e.bCH.msg);
        } else {
            e.a(ksScene, feedAdListener, !com.kwad.components.ad.feed.a.b.cl());
        }
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        e.a(ksScene, feedAdListener, true);
    }

    @Override // com.kwad.components.ad.b.d
    public final View a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new o(viewGroup.getContext());
            case 2:
                return new p(viewGroup.getContext());
            case 3:
                return new q(viewGroup.getContext());
            case 4:
                return new k(viewGroup.getContext());
            case 5:
                return new com.kwad.components.ad.feed.widget.l(viewGroup.getContext());
            case 6:
                return new m(viewGroup.getContext());
            case 7:
                return new n(viewGroup.getContext());
            case 8:
                return new j(viewGroup.getContext());
            default:
                return null;
        }
    }

    @Override // com.kwad.components.ad.b.d
    public final boolean a(KSFrameLayout kSFrameLayout, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (!(kSFrameLayout instanceof com.kwad.components.ad.feed.widget.c)) {
            return false;
        }
        ((com.kwad.components.ad.feed.widget.c) kSFrameLayout).b(ksAdVideoPlayConfig);
        return true;
    }
}
