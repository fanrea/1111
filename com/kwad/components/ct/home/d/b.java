package com.kwad.components.ct.home.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.home.d.a.b> {
    private c aKJ;
    private int aKK;
    private List<a> aKL;
    private CtAdTemplate aKM;
    private com.kwad.components.ct.detail.e.a aKN;
    private View aKO;
    private SlidePlayViewPager aok;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return Hc();
    }

    public b(KsFragment ksFragment, RecyclerView recyclerView, SlidePlayViewPager slidePlayViewPager) {
        super(ksFragment, recyclerView);
        this.aKL = new LinkedList();
        this.aok = slidePlayViewPager;
    }

    public final void S(View view) {
        this.aKO = view;
    }

    public final void a(CtAdTemplate ctAdTemplate, com.kwad.components.ct.detail.e.a aVar) {
        this.aKM = ctAdTemplate;
        this.aKN = aVar;
        Hd();
    }

    public final CtAdTemplate GX() {
        return this.aKM;
    }

    public final com.kwad.components.ct.detail.e.a GY() {
        return this.aKN;
    }

    public final List<a> GZ() {
        return this.aKL;
    }

    public final void a(CtAdTemplate ctAdTemplate, View view, boolean z) {
        b(ctAdTemplate, view, z);
    }

    public final void a(c cVar) {
        this.aKJ = cVar;
    }

    public final c Ha() {
        return this.aKJ;
    }

    public final void cv(int i) {
        this.aKK = i;
    }

    public final int Hb() {
        return this.aKK;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_slide_home_profile_item, false);
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.home.d.b.b());
        presenter.d(new com.kwad.components.ct.home.d.b.a());
        presenter.d(new com.kwad.components.ct.home.d.b.c());
        return presenter;
    }

    private static com.kwad.components.ct.home.d.a.b Hc() {
        return new com.kwad.components.ct.home.d.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.home.d.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.aok = this.aok;
        bVar.aKR = this.aKO;
        bVar.aKS = this;
    }

    private void Hd() {
        int iIndexOf = this.ccN.indexOf(this.aKM);
        com.kwad.sdk.core.d.c.d("SlideProfileAdapter", "notifyOnSelectChanged selectedPosition:" + iIndexOf);
        if (iIndexOf != -1) {
            Iterator<a> it = this.aKL.iterator();
            while (it.hasNext()) {
                it.next().cu(iIndexOf);
            }
        }
    }

    private void b(CtAdTemplate ctAdTemplate, View view, boolean z) {
        int iIndexOf = this.ccN.indexOf(ctAdTemplate);
        com.kwad.sdk.core.d.c.d("SlideProfileAdapter", "notifyVideoStateChange selectedPosition:" + iIndexOf);
        if (iIndexOf != -1) {
            Iterator<a> it = this.aKL.iterator();
            while (it.hasNext()) {
                it.next().a(iIndexOf, view, z);
            }
        }
    }
}
