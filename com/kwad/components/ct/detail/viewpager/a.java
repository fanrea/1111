package com.kwad.components.ct.detail.viewpager;

import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b {
    private boolean azG;

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int getFirstValidItemPosition() {
        return 0;
    }

    public a(KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
    }

    public final void CQ() {
        if (this.azG) {
            return;
        }
        this.azG = true;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        int iCR = CR();
        return this.azG ? iCR * 500 : iCR;
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int bO(int i) {
        if (!this.azG) {
            return i;
        }
        if (CR() == 0) {
            return 0;
        }
        return i % CR();
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int bP(int i) {
        if (!this.azG) {
            return i;
        }
        if (CR() == 0) {
            return 0;
        }
        return i % CR();
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int getLastValidItemPosition() {
        return getCount() - 1;
    }
}
