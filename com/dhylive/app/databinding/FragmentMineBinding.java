package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentMineBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final ConstraintLayout clMoney;
    public final BLConstraintLayout clVipInfo;
    public final AppCompatImageView ivAvatar;
    public final AppCompatImageView ivScan;
    public final AppCompatImageView ivSetting;
    public final BLLinearLayout llTask;
    public final BLLinearLayout mineLlFeatureTwo;
    public final BLTextView mineTvHome;
    public final TextView mineTvIcode;
    public final TextView mineTvLv;
    public final TextView mineTvNickname;
    public final TextView mineTvVipendtime;
    public final RecyclerView recycler;
    public final BLTextView tvCash;
    public final AppCompatTextView tvCoinHint;
    public final AppCompatTextView tvCoinNum;
    public final AppCompatTextView tvGoTask;
    public final AppCompatTextView tvMoney;
    public final BLTextView tvSendCoin;
    public final BLTextView tvTaskHint;
    public final BLTextView tvVipCharge;
    public final AppCompatTextView tvVipHint1;
    public final AppCompatTextView tvVipType;
    public final View viewCoin;

    protected FragmentMineBinding(Object obj, View view, int i, Barrier barrier, ConstraintLayout constraintLayout, BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, BLTextView bLTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, BLTextView bLTextView3, BLTextView bLTextView4, BLTextView bLTextView5, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, View view2) {
        super(obj, view, i);
        this.barrier = barrier;
        this.clMoney = constraintLayout;
        this.clVipInfo = bLConstraintLayout;
        this.ivAvatar = appCompatImageView;
        this.ivScan = appCompatImageView2;
        this.ivSetting = appCompatImageView3;
        this.llTask = bLLinearLayout;
        this.mineLlFeatureTwo = bLLinearLayout2;
        this.mineTvHome = bLTextView;
        this.mineTvIcode = textView;
        this.mineTvLv = textView2;
        this.mineTvNickname = textView3;
        this.mineTvVipendtime = textView4;
        this.recycler = recyclerView;
        this.tvCash = bLTextView2;
        this.tvCoinHint = appCompatTextView;
        this.tvCoinNum = appCompatTextView2;
        this.tvGoTask = appCompatTextView3;
        this.tvMoney = appCompatTextView4;
        this.tvSendCoin = bLTextView3;
        this.tvTaskHint = bLTextView4;
        this.tvVipCharge = bLTextView5;
        this.tvVipHint1 = appCompatTextView5;
        this.tvVipType = appCompatTextView6;
        this.viewCoin = view2;
    }

    public static FragmentMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mine, viewGroup, z, obj);
    }

    public static FragmentMineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mine, null, false, obj);
    }

    public static FragmentMineBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMineBinding bind(View view, Object obj) {
        return (FragmentMineBinding) bind(obj, view, R.layout.fragment_mine);
    }
}
