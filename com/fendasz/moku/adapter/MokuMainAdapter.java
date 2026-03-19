package com.fendasz.moku.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.fendasz.moku.diandian.commons.MokuDianFragment;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuMainAdapter extends FragmentPagerAdapter {
    private List<MokuDianFragment> mFragments;
    private List<String> mTitles;

    public MokuMainAdapter(FragmentManager fragmentManager, List<MokuDianFragment> list, List<String> list2) {
        super(fragmentManager);
        this.mFragments = list;
        this.mTitles = list2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.mFragments.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragments.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.mTitles.get(i);
    }
}
