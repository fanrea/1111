package com.kwad.components.ct.hotspot.a;

import android.view.View;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.e;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.hotspot.view.HotspotPanelLayout;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.R;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends e {
    private HotspotPanelLayout aQa;
    private com.kwad.components.ct.hotspot.b aQb;
    private SlidePlayViewPager aok;
    private j aol;
    private final com.kwad.components.ct.hotspot.j aQc = new com.kwad.components.ct.hotspot.j() { // from class: com.kwad.components.ct.hotspot.a.b.1
        @Override // com.kwad.components.ct.hotspot.j
        public final void H(List<HotspotInfo> list) {
            b.this.I(list);
        }
    };
    private final com.kwad.components.ct.hotspot.e aqP = new com.kwad.components.ct.hotspot.e() { // from class: com.kwad.components.ct.hotspot.a.b.2
        @Override // com.kwad.components.ct.hotspot.e
        public final void zp() {
            b.this.aok.h(false, 6);
            b.this.IQ();
        }

        @Override // com.kwad.components.ct.hotspot.e
        public final void bB(int i) {
            b.this.aok.h(true, 6);
            b.this.cG(i);
        }

        @Override // com.kwad.components.ct.hotspot.e
        public final void a(View view, HotspotInfo hotspotInfo, int i) {
            if (hotspotInfo == null) {
                return;
            }
            b.this.b(view, hotspotInfo, i);
            if (b.this.aQb != null) {
                b.this.aQb.a(hotspotInfo);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aQa = (HotspotPanelLayout) findViewById(R.id.ksad_trend_list_panel);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = this.aGP.aok;
        com.kwad.components.ct.api.a.a.a aVarXd = this.aGP.ayi.xd();
        if (aVarXd instanceof com.kwad.components.ct.hotspot.b) {
            this.aQb = (com.kwad.components.ct.hotspot.b) aVarXd;
        }
        this.aol = this.aGP.aol;
        this.aGP.aGM.add(this.aQc);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aQa.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<HotspotInfo> list) {
        this.aQa.a(list, IP(), this.aGP.mSceneImpl);
        this.aQa.setHotspotPanelListener(this.aqP);
        this.aQa.show();
    }

    private HotspotInfo IP() {
        CtAdTemplate currentData = this.aGP.aok.getCurrentData();
        if (currentData == null) {
            return null;
        }
        return com.kwad.components.ct.response.a.a.ay(currentData).mHotspotInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, HotspotInfo hotspotInfo, int i) {
        Iterator<com.kwad.components.ct.hotspot.e> it = this.aGP.aGN.iterator();
        while (it.hasNext()) {
            it.next().a(view, hotspotInfo, i);
        }
        Iterator<com.kwad.components.ct.hotspot.e> it2 = this.aol.aHm.iterator();
        while (it2.hasNext()) {
            it2.next().a(view, hotspotInfo, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IQ() {
        Iterator<com.kwad.components.ct.hotspot.e> it = this.aGP.aGN.iterator();
        while (it.hasNext()) {
            it.next().zp();
        }
        Iterator<com.kwad.components.ct.hotspot.e> it2 = this.aol.aHm.iterator();
        while (it2.hasNext()) {
            it2.next().zp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(int i) {
        Iterator<com.kwad.components.ct.hotspot.e> it = this.aGP.aGN.iterator();
        while (it.hasNext()) {
            it.next().bB(i);
        }
        Iterator<com.kwad.components.ct.hotspot.e> it2 = this.aol.aHm.iterator();
        while (it2.hasNext()) {
            it2.next().bB(i);
        }
    }
}
