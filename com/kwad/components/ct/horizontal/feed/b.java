package com.kwad.components.ct.horizontal.feed;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.horizontal.feed.item.presenter.g;
import com.kwad.components.ct.horizontal.feed.item.presenter.play.e;
import com.kwad.components.ct.horizontal.feed.item.presenter.play.f;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.horizontal.feed.item.a.a> {
    private final com.kwad.components.ct.horizontal.feed.a.b aLK;
    private final a aLL;
    private final SceneImpl mSceneImpl;

    private static boolean cw(int i) {
        return i <= 200 && i > 100;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final boolean l(boolean z, boolean z2) {
        return z && !z2;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return Hr();
    }

    public b(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.components.ct.horizontal.feed.a.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.components.ct.widget.a.a.a());
        this.aLK = bVar;
        this.mSceneImpl = bVar.mSceneImpl;
        this.aLL = new a();
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        if (cw(i)) {
            View viewG = a.g(viewGroup, i - 100);
            if (viewG != null) {
                return viewG;
            }
        } else {
            if (i == 6) {
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_horizontal_feed_item_play_video, false);
            }
            if (i == 1) {
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_horizontal_feed_item_video, false);
            }
            if (i == 2) {
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_feed_item_news_video, false);
            }
            if (i == 3) {
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_feed_item_news_no_imge, false);
            }
            if (i == 4) {
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_feed_item_news_single_imge, false);
            }
            if (i == 5) {
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_feed_item_news_three_imge, false);
            }
        }
        return new View(viewGroup.getContext());
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        if (cw(i)) {
            if (this.aLK.aLP) {
                a.a(i - 100, presenter, new com.kwad.components.ct.horizontal.feed.item.presenter.play.b());
            } else {
                a.a(i - 100, presenter, new com.kwad.components.ct.horizontal.feed.item.presenter.a());
            }
        } else if (i == 6) {
            presenter.d(new f());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.play.d());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.play.c());
            presenter.d(new e());
        } else if (i == 1) {
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.e());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.b());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.d());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.f());
            presenter.d(new g());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.c());
        } else if (i == 2) {
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.e());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.b());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.e());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.f());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.a());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.c());
        } else if (i == 3) {
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.e());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.b());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.a());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.c());
        } else if (i == 4) {
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.e());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.b());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.c());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.a());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.c());
        } else if (i == 5) {
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.e());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.b());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.d());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.a.a());
            presenter.d(new com.kwad.components.ct.horizontal.feed.item.presenter.c());
        }
        return presenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        CtAdTemplate ctAdTemplate;
        if (this.ccN == null || i >= this.ccN.size() || (ctAdTemplate = (CtAdTemplate) this.ccN.get(i)) == null) {
            return 0;
        }
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            return this.aLL.z(ctAdTemplate) + 100;
        }
        if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
            return this.mSceneImpl.getPageScene() == 21 ? this.aLK.aLP ? 6 : 1 : this.mSceneImpl.getPageScene() == 23 ? 2 : 0;
        }
        if (!com.kwad.components.ct.response.a.a.at(ctAdTemplate)) {
            return 0;
        }
        NewsInfo newsInfoAz = com.kwad.components.ct.response.a.a.az(ctAdTemplate);
        if (com.kwad.components.ct.response.a.d.m(newsInfoAz)) {
            return 3;
        }
        if (com.kwad.components.ct.response.a.d.n(newsInfoAz)) {
            return 4;
        }
        return com.kwad.components.ct.response.a.d.o(newsInfoAz) ? 5 : 0;
    }

    private static com.kwad.components.ct.horizontal.feed.item.a.a Hr() {
        return new com.kwad.components.ct.horizontal.feed.item.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.horizontal.feed.item.a.a aVar, int i) {
        super.a((b) aVar, i);
        CtAdTemplate ctAdTemplate = (CtAdTemplate) this.ccN.get(i);
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate) && com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(ctAdTemplate))) {
            aVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(ctAdTemplate);
        } else {
            aVar.mApkDownloadHelper = null;
        }
        aVar.mScene = this.mSceneImpl;
        aVar.aoy = this.aLK.aGE;
        aVar.aLK = this.aLK;
    }
}
