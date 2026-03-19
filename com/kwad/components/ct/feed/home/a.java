package com.kwad.components.ct.feed.home;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.feed.home.a.b.e;
import com.kwad.components.ct.feed.home.a.b.f;
import com.kwad.components.ct.home.adx.AdxAdTemplate;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.feed.home.a.a.b> {
    private com.kwad.components.ct.feed.home.b.b aFq;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final boolean l(boolean z, boolean z2) {
        return z && !z2;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return ER();
    }

    public a(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.components.ct.feed.home.b.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.components.ct.widget.a.a.a());
        this.aFq = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_photo, false);
            case 1:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_ad, false);
            case 2:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_photo_single_small, false);
            case 3:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_ad_single_small, false);
            case 4:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_photo_single_large, false);
            case 5:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_ad_single_large, false);
            case 6:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_wallpaper_double_radius_photo, false);
            case 7:
                return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_feed_home_item_wallpaper_double_photo, false);
            default:
                return new com.kwad.components.core.widget.c(viewGroup.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.a
    /* renamed from: cl, reason: merged with bridge method [inline-methods] */
    public CtAdTemplate getItem(int i) {
        return AdxAdTemplate.getOriginalAdTemplate((CtAdTemplate) super.getItem(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        CtAdTemplate item;
        int i2;
        if (this.ccN == null || i >= this.ccN.size() || (item = getItem(i)) == null || item.mPageInfo == null) {
            return -1;
        }
        int i3 = item.mPageInfo.pageType;
        if (i3 == 0 || i3 == 1) {
            return !com.kwad.components.ct.response.a.a.as(item) ? 1 : 0;
        }
        int i4 = 2;
        if (i3 != 2) {
            i4 = 5;
            if (i3 != 3) {
                if (i3 == 4) {
                    if (!com.kwad.components.ct.response.a.a.as(item)) {
                        return -1;
                    }
                    i2 = 6;
                } else {
                    if (i3 != 5 || !com.kwad.components.ct.response.a.a.as(item)) {
                        return -1;
                    }
                    i2 = 7;
                }
                return i2;
            }
            if (com.kwad.components.ct.response.a.a.as(item)) {
                return 4;
            }
        } else if (!com.kwad.components.ct.response.a.a.as(item)) {
            return 3;
        }
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        switch (i) {
            case 0:
                presenter.d(new com.kwad.components.ct.feed.home.a.b.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.c());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.b.a());
                return presenter;
            case 1:
                presenter.d(new com.kwad.components.ct.feed.home.a.b.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.b());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.c());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.a());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.c());
                return presenter;
            case 2:
                presenter.d(new com.kwad.components.ct.feed.home.a.b.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a());
                presenter.d(new f());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.b.c());
                return presenter;
            case 3:
                presenter.d(new com.kwad.components.ct.feed.home.a.b.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.b());
                presenter.d(new f());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.c());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.b());
                return presenter;
            case 4:
                presenter.d(new com.kwad.components.ct.feed.home.a.b.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a());
                presenter.d(new e());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.b.c());
                return presenter;
            case 5:
                presenter.d(new com.kwad.components.ct.feed.home.a.b.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.b());
                presenter.d(new e());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a.c());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.b());
                return presenter;
            case 6:
            case 7:
                presenter.d(new com.kwad.components.ct.feed.home.a.b.d());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.a().bM(false));
                presenter.d(new com.kwad.components.ct.feed.home.a.b.c());
                presenter.d(new com.kwad.components.ct.feed.home.a.b.b.b());
                return presenter;
            default:
                return presenter;
        }
    }

    private static com.kwad.components.ct.feed.home.a.a.b ER() {
        return new com.kwad.components.ct.feed.home.a.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.feed.home.a.a.b bVar, int i) {
        super.a((a) bVar, i);
        CtAdTemplate item = getItem(i);
        if (item != null && !com.kwad.components.ct.response.a.a.as(item) && com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(item))) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(item);
        } else {
            bVar.mApkDownloadHelper = null;
        }
        bVar.aFq = this.aFq;
    }
}
