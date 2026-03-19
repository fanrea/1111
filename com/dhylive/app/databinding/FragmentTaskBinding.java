package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.dhylive.app.R;
import com.noober.background.view.BLConstraintLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentTaskBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final BLConstraintLayout clMoney;
    public final AppCompatImageView ivIcon;
    public final RecyclerView recyclerCategory;
    public final AppCompatTextView tvCoinHint;
    public final AppCompatTextView tvCoinNum;
    public final AppCompatTextView tvMoney;
    public final AppCompatTextView tvTitle;
    public final ViewPager2 viewPage;

    protected FragmentTaskBinding(Object obj, View view, int i, Barrier barrier, BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.barrier = barrier;
        this.clMoney = bLConstraintLayout;
        this.ivIcon = appCompatImageView;
        this.recyclerCategory = recyclerView;
        this.tvCoinHint = appCompatTextView;
        this.tvCoinNum = appCompatTextView2;
        this.tvMoney = appCompatTextView3;
        this.tvTitle = appCompatTextView4;
        this.viewPage = viewPager2;
    }

    public static FragmentTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_task, viewGroup, z, obj);
    }

    public static FragmentTaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_task, null, false, obj);
    }

    public static FragmentTaskBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTaskBinding bind(View view, Object obj) {
        return (FragmentTaskBinding) bind(obj, view, R.layout.fragment_task);
    }
}
