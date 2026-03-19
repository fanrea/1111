package com.kwad.components.ct.hotspot.a;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.photo.comment.g;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.e;
import com.kwad.components.ct.hotspot.f;
import com.kwad.components.ct.hotspot.j;
import com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.j.d;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e {
    public com.kwad.components.core.widget.a.b aFs;
    private RelativeLayout aPU;
    private TrendsRollingTextContainer aPV;
    private boolean aPW;
    private List<HotspotInfo> aPX;
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.api.a.a.c ayi;
    private HotspotInfo mHotspotInfo;
    private final ViewPager.OnPageChangeListener nb = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.hotspot.a.a.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            int currentItem = a.this.aok.getCurrentItem();
            int i3 = currentItem > i ? currentItem - 1 : currentItem + 1;
            CtAdTemplate ctAdTemplateBR = a.this.aok.bR(currentItem);
            CtAdTemplate ctAdTemplateBR2 = a.this.aok.bR(i3);
            if (ctAdTemplateBR == null || ctAdTemplateBR2 == null) {
                return;
            }
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) && com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                a.this.aPU.setAlpha(1.0f);
                return;
            }
            if (!com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) && !com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                a.this.aPU.setAlpha(0.0f);
                return;
            }
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) && !com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                float f2 = currentItem > i ? (f - 0.5f) * 2.0f : (0.5f - f) * 2.0f;
                a.this.aPU.setAlpha(f2 >= 0.0f ? f2 > 1.0f ? 1.0f : f2 : 0.0f);
            } else {
                if (com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) || !com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                    return;
                }
                float f3 = currentItem > i ? (0.5f - f) * 2.0f : (f - 0.5f) * 2.0f;
                a.this.aPU.setAlpha(f3 >= 0.0f ? f3 > 1.0f ? 1.0f : f3 : 0.0f);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            if (i == 0) {
                CtAdTemplate currentData = a.this.aok.getCurrentData();
                if (currentData == null || !com.kwad.components.ct.response.a.a.as(currentData)) {
                    a.this.aPV.stopScroll();
                    a.this.aPU.setAlpha(0.0f);
                    a.this.aPU.setClickable(false);
                    return;
                } else {
                    a.this.aPV.IZ();
                    a.this.aPU.setAlpha(1.0f);
                    a.this.aPU.setClickable(true);
                    return;
                }
            }
            a.this.aPV.stopScroll();
            a.this.aPU.setClickable(false);
        }
    };
    private final com.kwad.sdk.core.j.c gZ = new d() { // from class: com.kwad.components.ct.hotspot.a.a.3
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            if (a.this.aPW) {
                return;
            }
            a.a(a.this, true);
            com.kwad.components.ct.e.b.JK().a(a.this.aGP.mSceneImpl, a.this.mHotspotInfo);
        }
    };
    private final g aPY = new g() { // from class: com.kwad.components.ct.hotspot.a.a.4
        @Override // com.kwad.components.ct.detail.photo.comment.g
        public final void zp() {
            a.this.IN();
        }

        @Override // com.kwad.components.ct.detail.photo.comment.g
        public final void onClose() {
            a.this.IM();
        }
    };
    private final com.kwad.components.ct.hotspot.e aqP = new f() { // from class: com.kwad.components.ct.hotspot.a.a.5
        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void zp() {
            a.this.IN();
        }

        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void bB(int i) {
            a.this.IM();
        }

        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void a(View view, HotspotInfo hotspotInfo, int i) {
            a.this.IN();
        }
    };
    private final com.kwad.components.ct.api.a.a.b ayn = new com.kwad.components.ct.home.b.d() { // from class: com.kwad.components.ct.hotspot.a.a.6
        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void a(boolean z, boolean z2, int i, int i2) {
            if (z2) {
                return;
            }
            a.this.IN();
        }

        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            List listXc;
            super.c(z, i, i2);
            if (i != 0 || (listXc = a.this.ayi.xc()) == null || listXc.size() <= 0) {
                return;
            }
            if (com.kwad.components.ct.response.a.a.as((CtAdTemplate) listXc.get(0))) {
                a.this.aPU.setAlpha(1.0f);
                a.this.aPU.setClickable(true);
                a.this.IM();
            } else {
                a.this.aPU.setAlpha(0.0f);
                a.this.aPU.setClickable(false);
                a.this.aPV.stopScroll();
                a.this.aPU.setVisibility(0);
            }
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aPW = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aPU = (RelativeLayout) findViewById(R.id.ksad_trends_rolling_container);
        this.aPV = (TrendsRollingTextContainer) findViewById(R.id.ksad_trends_rolling_trend_name_layout);
        this.aPU.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.hotspot.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.ct.e.b.JK().b(a.this.aGP.mSceneImpl, a.this.mHotspotInfo);
                a.this.IO();
            }
        });
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = this.aGP.aok;
        this.aPX = this.aGP.aGG;
        this.mHotspotInfo = this.aGP.mEntryHotspotInfo;
        com.kwad.components.ct.api.a.a.c<CtAdTemplate> cVar = this.aGP.ayi;
        this.ayi = cVar;
        cVar.a(this.ayn);
        com.kwad.components.core.widget.a.b bVar = this.aGP.aol.aFs;
        this.aFs = bVar;
        bVar.a(this.gZ);
        this.aGP.aGN.add(this.aqP);
        this.aGP.aol.auW.add(this.aPY);
        this.aPV.K(this.aPX);
        this.aok.addOnPageChangeListener(this.nb);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aGP.aol.auW.remove(this.aPY);
        this.aGP.aGN.remove(this.aqP);
        this.aFs.b(this.gZ);
        this.aPV.release();
        this.ayi.b(this.ayn);
        this.aok.removeOnPageChangeListener(this.nb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IM() {
        this.aPV.IZ();
        this.aPU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        this.aPV.stopScroll();
        this.aPU.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IO() {
        Iterator<j> it = this.aGP.aGM.iterator();
        while (it.hasNext()) {
            it.next().H(this.aPX);
        }
    }
}
