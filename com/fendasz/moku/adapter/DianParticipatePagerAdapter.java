package com.fendasz.moku.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.fendasz.moku.diandian.model.participate.DianParticipateFragment;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DianParticipatePagerAdapter extends FragmentPagerAdapter {
    private List<DianParticipateFragment> mFragments;
    private List<String> mTitles;

    public DianParticipatePagerAdapter(FragmentManager fragmentManager, List<DianParticipateFragment> list, List<String> list2) {
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
