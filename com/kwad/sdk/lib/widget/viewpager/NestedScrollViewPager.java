package com.kwad.sdk.lib.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.a.c;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.a;
import com.kwad.sdk.widget.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NestedScrollViewPager extends g implements CustomAppBarFlingConsumer {
    public NestedScrollViewPager(Context context) {
        super(context);
    }

    public NestedScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i, int i2) {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.scrollTo(i, i2);
        }
    }

    private RecyclerView getRecyclerView() {
        PagerAdapter adapter = getAdapter();
        if (!(adapter instanceof a)) {
            return null;
        }
        KsFragment ksFragmentAlg = ((a) adapter).alg();
        if (ksFragmentAlg instanceof c) {
            return ((c) ksFragmentAlg).getRecyclerView();
        }
        return null;
    }

    public final void ale() {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        alf();
    }

    private void alf() {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.stopNestedScroll(1);
        }
    }
}
