package com.kwad.components.ct.horizontal.feed;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ct.horizontal.feed.c.e;
import com.kwad.components.ct.horizontal.feed.c.f;
import com.kwad.components.ct.horizontal.feed.c.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static void a(int i, Presenter presenter, Presenter presenter2) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                presenter.d(presenter2);
                break;
        }
    }

    public static View g(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) com.kwad.sdk.components.d.g(com.kwad.components.ad.b.d.class);
                if (dVar != null) {
                    return dVar.a(viewGroup, i);
                }
                return null;
            case 9:
                return new com.kwad.components.ct.horizontal.feed.c.d(viewGroup.getContext());
            case 10:
                return new e(viewGroup.getContext());
            case 11:
                return new com.kwad.components.ct.horizontal.feed.c.c(viewGroup.getContext());
            case 12:
                return new f(viewGroup.getContext());
            case 13:
                return new g(viewGroup.getContext());
            default:
                return null;
        }
    }

    public final int z(CtAdTemplate ctAdTemplate) {
        if (!com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            return 0;
        }
        int iBk = com.kwad.sdk.core.response.b.a.bk(com.kwad.components.ct.response.a.a.eP(ctAdTemplate));
        FeedType feedTypeFromInt = FeedType.fromInt(ctAdTemplate.type, ctAdTemplate.defaultType);
        if (iBk == 1) {
            return a(feedTypeFromInt);
        }
        if (iBk == 2) {
            return a(feedTypeFromInt, false);
        }
        if (iBk == 3) {
            return a(feedTypeFromInt, true);
        }
        com.kwad.sdk.core.d.c.e("FeedViewAdapterProxy", "getNewFeedView materialType is unknown");
        return 0;
    }

    private static int a(FeedType feedType, boolean z) {
        switch (feedType) {
            case FEED_TYPE_TEXT_ABOVE_GROUP:
                if (z) {
                }
                break;
        }
        return 0;
    }

    private static int a(FeedType feedType) {
        int i = AnonymousClass1.iz[feedType.ordinal()];
        if (i == 6) {
            return 5;
        }
        if (i == 7) {
            return 7;
        }
        if (i != 9) {
            return i != 11 ? 0 : 13;
        }
        return 10;
    }
}
