package com.kwad.components.ct.detail;

import com.kwad.components.ct.detail.photo.e.f;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.request.live.model.LiveStatusResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public int abR;
    public boolean aoB;
    public boolean aoC;
    public boolean aoD;
    public boolean aoE;
    public boolean aoF;
    public boolean aoG;
    public boolean aoH;
    public com.kwad.components.ct.g.a aoI;
    public SlidePlayViewPager aok;
    public j aol;
    public boolean aov;
    public boolean aow;
    public LiveStatusResultData.LiveStatus aox;
    public KsFragment aoy;
    public com.kwad.components.ct.detail.e.a aoz;
    public CtAdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public List<com.kwad.components.core.k.a> aoq = new LinkedList();
    public List<com.kwad.components.core.k.c> aor = new ArrayList();
    public List<com.kwad.components.core.k.e> aos = new ArrayList();
    public List<com.kwad.sdk.widget.swipe.a> aot = new LinkedList();
    public List<f.a> aou = new ArrayList();
    public boolean aoA = false;
    public boolean aoJ = false;

    public final void a(com.kwad.components.ct.hotspot.e eVar) {
        j jVar;
        if (!com.kwad.components.ct.response.a.a.aV(this.mAdTemplate) || (jVar = this.aol) == null) {
            return;
        }
        jVar.aHm.add(eVar);
    }

    public final void b(com.kwad.components.ct.hotspot.e eVar) {
        j jVar;
        if (!com.kwad.components.ct.response.a.a.aV(this.mAdTemplate) || (jVar = this.aol) == null) {
            return;
        }
        jVar.aHm.remove(eVar);
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
    }
}
