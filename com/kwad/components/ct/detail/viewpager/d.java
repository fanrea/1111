package com.kwad.components.ct.detail.viewpager;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class d extends PagerAdapter {
    protected final SparseArray<List<KsFragment>> aAf = new SparseArray<>();
    private KsFragmentTransaction aAg = null;
    protected KsFragment aAh = null;
    private boolean aAi;
    private final KsFragmentManager mFragmentManager;

    private static long getItemId(int i) {
        return i;
    }

    protected abstract void a(KsFragment ksFragment, int i);

    protected abstract KsFragment bS(int i);

    protected int d(KsFragment ksFragment) {
        return 0;
    }

    protected abstract boolean e(KsFragment ksFragment);

    protected int getItemViewType(int i) {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    public d(KsFragmentManager ksFragmentManager) {
        this.mFragmentManager = ksFragmentManager;
    }

    private List<KsFragment> bX(int i) {
        return this.aAf.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.aAg == null) {
            this.aAg = this.mFragmentManager.beginTransaction();
        }
        long itemId = getItemId(i);
        int itemViewType = getItemViewType(i);
        KsFragment ksFragmentBS = null;
        List<KsFragment> listBX = bX(itemViewType);
        if (listBX != null && listBX.size() > 1) {
            ksFragmentBS = listBX.remove(0);
        }
        if (ksFragmentBS != null) {
            a(ksFragmentBS, i);
            this.aAg.attach(ksFragmentBS);
        } else {
            ksFragmentBS = bS(itemViewType);
            a(ksFragmentBS, i);
            this.aAg.add(viewGroup.getId(), ksFragmentBS, d(viewGroup.getId(), itemId));
        }
        if (ksFragmentBS != this.aAh) {
            ksFragmentBS.setMenuVisibility(false);
            ksFragmentBS.setUserVisibleHint(false);
        }
        return ksFragmentBS;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.aAg == null) {
            this.aAg = this.mFragmentManager.beginTransaction();
        }
        KsFragment ksFragment = (KsFragment) obj;
        if (this.aAi) {
            this.aAg.remove(ksFragment);
            return;
        }
        this.aAg.detach(ksFragment);
        if (e(ksFragment)) {
            int iD = d(ksFragment);
            List<KsFragment> listBX = bX(iD);
            if (listBX == null) {
                listBX = new ArrayList<>();
                this.aAf.put(iD, listBX);
            }
            listBX.add(ksFragment);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        KsFragment ksFragment2 = this.aAh;
        if (ksFragment != ksFragment2) {
            if (ksFragment2 != null) {
                ksFragment2.setMenuVisibility(false);
                this.aAh.setUserVisibleHint(false);
            }
            ksFragment.setMenuVisibility(true);
            ksFragment.setUserVisibleHint(true);
            this.aAh = ksFragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction = this.aAg;
        if (ksFragmentTransaction != null) {
            try {
                ksFragmentTransaction.commitNowAllowingStateLoss();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            this.aAg = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((KsFragment) obj).getView() == view;
    }

    private static String d(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
