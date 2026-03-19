package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import com.kwad.sdk.api.core.fragment.KsSavedState;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends PagerAdapter implements PagerSlidingTabStrip.c.a {
    private int cdS;
    private final Context mContext;
    private final KsFragmentManager mFragmentManager;
    private final List<b> cdO = new ArrayList();
    private KsFragmentTransaction aAg = null;
    private SparseArray<KsFragment> cdP = new SparseArray<>();
    private SparseArray<KsSavedState> cdQ = new SparseArray<>();
    private SparseArray<Bundle> cdR = new SparseArray<>();
    private KsFragment aAh = null;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup viewGroup) {
    }

    public a(Context context, KsFragmentManager ksFragmentManager) {
        this.mFragmentManager = ksFragmentManager;
        this.mContext = context;
    }

    public final KsFragment gK(int i) {
        return this.cdP.get(i);
    }

    public final void aA(List<b> list) {
        this.cdO.clear();
        aE(list);
    }

    private void aE(List<b> list) {
        if (list == null) {
            throw new RuntimeException("delegates should not be null for setFragments()");
        }
        int size = this.cdO.size();
        int size2 = list.size() + size;
        for (int i = size; i < size2; i++) {
            this.cdR.put(i, list.get(i - size).alj());
        }
        this.cdO.addAll(list);
        notifyDataSetChanged();
    }

    public final void c(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = this.cdR.get(i);
        if (bundle2 != null) {
            bundle2.putAll(bundle);
            bundle = bundle2;
        }
        this.cdR.put(i, bundle);
        gK(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.cdO.size();
    }

    private KsFragment gL(int i) {
        return KsFragment.instantiate(this.mContext, this.cdO.get(i).ali().getName(), this.cdR.get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public KsFragment instantiateItem(ViewGroup viewGroup, int i) {
        KsFragment ksFragment = this.cdP.get(i);
        if (ksFragment != null) {
            this.cdO.get(i);
            return ksFragment;
        }
        if (this.aAg == null) {
            this.aAg = this.mFragmentManager.beginTransaction();
        }
        KsFragment ksFragmentGL = gL(i);
        this.cdO.get(i);
        KsSavedState ksSavedState = this.cdQ.get(i);
        if (ksSavedState != null) {
            ksFragmentGL.setInitialSavedState(ksSavedState);
        }
        ksFragmentGL.setMenuVisibility(false);
        ksFragmentGL.setUserVisibleHint(false);
        this.cdP.put(i, ksFragmentGL);
        this.aAg.add(viewGroup.getId(), ksFragmentGL);
        return ksFragmentGL;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        if (this.aAg == null) {
            this.aAg = this.mFragmentManager.beginTransaction();
        }
        this.cdQ.put(i, this.mFragmentManager.saveFragmentInstanceState(ksFragment));
        this.cdP.remove(i);
        this.aAg.remove(ksFragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        KsFragment ksFragment2 = this.aAh;
        if (ksFragment != ksFragment2) {
            if (ksFragment2 != null) {
                ksFragment2.setMenuVisibility(false);
                this.aAh.setUserVisibleHint(false);
            }
            if (ksFragment != null) {
                ksFragment.setMenuVisibility(true);
                ksFragment.setUserVisibleHint(true);
            }
            this.aAh = ksFragment;
            this.cdS = i;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction = this.aAg;
        if (ksFragmentTransaction != null) {
            ksFragmentTransaction.commitAllowingStateLoss();
            this.aAg = null;
            try {
                this.mFragmentManager.executePendingTransactions();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return ((KsFragment) obj).getView() == view;
    }

    @Override // com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.a
    public final PagerSlidingTabStrip.c gM(int i) {
        if (!this.cdO.isEmpty() && i >= 0 && i < this.cdO.size()) {
            return this.cdO.get(i).alh();
        }
        return null;
    }

    public final int hx(String str) {
        if (this.cdO != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.cdO.size(); i++) {
                b bVar = this.cdO.get(i);
                if (bVar != null && bVar.alh() != null && str.equals(bVar.alh().getId())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final String gN(int i) {
        PagerSlidingTabStrip.c cVarGM = gM(i);
        return (cVarGM == null || cVarGM.getId() == null) ? "" : cVarGM.getId();
    }

    public final KsFragment alg() {
        return this.aAh;
    }
}
