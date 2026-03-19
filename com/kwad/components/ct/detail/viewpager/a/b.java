package com.kwad.components.ct.detail.viewpager.a;

import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.detail.viewpager.e;
import com.kwad.components.ct.detail.viewpager.f;
import com.kwad.components.ct.response.model.CtAdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends f {
    private int aBB;
    private int aBC;
    private SlidePlayViewPager aok;

    @Override // com.kwad.components.ct.detail.viewpager.f, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        SlidePlayViewPager slidePlayViewPager = this.azZ.aok;
        this.aok = slidePlayViewPager;
        slidePlayViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ct.detail.viewpager.a.b.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                SlidePlayTouchViewPager.TargetBoundUpdatedType targetBoundUpdatedType;
                b.this.aBC = i;
                if (b.this.aok.getAdapter() != null) {
                    b.this.aok.getAdapter().e(i, false);
                }
                SlidePlayViewPager slidePlayViewPager2 = b.this.aok;
                if (i > b.this.aBC) {
                    targetBoundUpdatedType = SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_NEXT;
                } else {
                    targetBoundUpdatedType = SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_PRE;
                }
                slidePlayViewPager2.a(targetBoundUpdatedType);
                CtAdTemplate currentData = b.this.aok.getCurrentData();
                if (currentData != null) {
                    currentData.mHasSelected = true;
                }
            }
        });
        this.aok.setOnPageScrollEndListener(new e.f() { // from class: com.kwad.components.ct.detail.viewpager.a.b.2
            @Override // com.kwad.components.ct.detail.viewpager.e.f
            public final void CW() {
                int currentItem = b.this.azZ.aok.getCurrentItem();
                if (b.this.aBB == currentItem) {
                    return;
                }
                b.this.aBB = currentItem;
                if (b.this.aok.getAdapter() != null) {
                    b.this.aok.getAdapter().e(currentItem, true);
                }
            }
        });
    }
}
