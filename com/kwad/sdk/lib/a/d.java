package com.kwad.sdk.lib.a;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.core.proxy.h;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import com.kwad.sdk.p.m;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d extends h {
    protected ViewPager aRi;
    protected PagerSlidingTabStrip aXR;
    protected com.kwad.sdk.lib.widget.viewpager.tabstrip.a ccl;
    protected int ccm;
    private ViewPager.OnPageChangeListener ccn;
    protected int cco = -1;
    public String ccp = null;
    protected ViewPager.OnPageChangeListener nb = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.lib.a.d.1
        private boolean ccq;
        private boolean ccr;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
            if (d.this.ccn != null) {
                d.this.ccn.onPageScrolled(i, f, i2);
            }
            this.ccq = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            this.ccr = true;
            d.this.gz(i);
            if (d.this.ccn != null) {
                d.this.ccn.onPageSelected(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
            if (d.this.ccn != null) {
                d.this.ccn.onPageScrollStateChanged(i);
            }
        }
    };

    private static String akK() {
        return "";
    }

    protected abstract int IJ();

    protected abstract int IK();

    public abstract List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> IL();

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.aXR = (PagerSlidingTabStrip) findViewById(IJ());
        this.aRi = (ViewPager) findViewById(IK());
        this.ccl = new com.kwad.sdk.lib.widget.viewpager.tabstrip.a(m.wrapContextIfNeed(getActivity()), getChildFragmentManager());
        List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> listIL = IL();
        this.aRi.setAdapter(this.ccl);
        if (listIL != null && !listIL.isEmpty()) {
            this.ccl.aA(listIL);
            this.ccm = akJ();
            if (getArguments() != null && getArguments().containsKey("last_selected_item_pos")) {
                this.aRi.setCurrentItem(getArguments().getInt("last_selected_item_pos"), false);
            } else {
                this.aRi.setCurrentItem(this.ccm, false);
            }
        }
        this.aXR.setViewPager(this.aRi);
        this.aXR.setOnPageChangeListener(this.nb);
    }

    public final void aA(List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> list) {
        this.ccl.aA(list);
        this.aXR.notifyDataSetChanged();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("last_selected_item_pos", getCurrentItem());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewStateRestored(Bundle bundle) throws Resources.NotFoundException {
        int i;
        if (bundle != null && (i = bundle.getInt("last_selected_item_pos", -1)) != -1) {
            b(i, bundle);
        }
        super.onViewStateRestored(bundle);
    }

    public final int getCurrentItem() {
        ViewPager viewPager = this.aRi;
        if (viewPager != null) {
            return viewPager.getCurrentItem();
        }
        return akJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(int i) {
        int i2;
        com.kwad.sdk.lib.widget.viewpager.tabstrip.a aVar = this.ccl;
        if (aVar == null || i == (i2 = this.ccm)) {
            return;
        }
        aVar.gK(i2);
        this.ccl.gK(i);
        this.ccm = i;
    }

    private int akJ() {
        int iHw;
        if (KB() == null || this.ccl == null || (iHw = hw(KB())) < 0) {
            return 0;
        }
        return iHw;
    }

    private int hw(String str) {
        return this.ccl.hx(str);
    }

    public String KB() {
        if (!TextUtils.isEmpty(this.ccp)) {
            return this.ccp;
        }
        int i = this.cco;
        if (i >= 0) {
            return gA(i);
        }
        return akK();
    }

    private String gA(int i) {
        return this.ccl.gN(i);
    }

    private void b(int i, Bundle bundle) throws Resources.NotFoundException {
        a(i, bundle, false);
    }

    private void a(int i, Bundle bundle, boolean z) throws Resources.NotFoundException {
        this.ccl.c(i, bundle);
        this.aRi.setCurrentItem(i, false);
    }
}
