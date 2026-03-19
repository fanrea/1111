package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityWithdrawBinding extends ViewDataBinding {
    public final AppCompatTextView appCompatTextView;
    public final Guideline guideline;
    public final ConstraintLayout llBalance;
    public final AppCompatImageView publicIvBack;
    public final AppCompatTextView publicTvTitle;
    public final RecyclerView recyclerView;
    public final ConstraintLayout toolbar;
    public final BLTextView tvAdd;
    public final BLTextView tvBank;
    public final AppCompatTextView tvCoinHint;
    public final AppCompatTextView tvCoinNum;
    public final AppCompatTextView tvMoney;
    public final BLTextView tvRecord;
    public final BLTextView tvWithdraw;
    public final TextView tvWithdrawLabel;
    public final BLTextView tvWx;
    public final BLTextView tvZfb;

    protected ActivityWithdrawBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, Guideline guideline, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView2, RecyclerView recyclerView, ConstraintLayout constraintLayout2, BLTextView bLTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, BLTextView bLTextView3, BLTextView bLTextView4, TextView textView, BLTextView bLTextView5, BLTextView bLTextView6) {
        super(obj, view, i);
        this.appCompatTextView = appCompatTextView;
        this.guideline = guideline;
        this.llBalance = constraintLayout;
        this.publicIvBack = appCompatImageView;
        this.publicTvTitle = appCompatTextView2;
        this.recyclerView = recyclerView;
        this.toolbar = constraintLayout2;
        this.tvAdd = bLTextView;
        this.tvBank = bLTextView2;
        this.tvCoinHint = appCompatTextView3;
        this.tvCoinNum = appCompatTextView4;
        this.tvMoney = appCompatTextView5;
        this.tvRecord = bLTextView3;
        this.tvWithdraw = bLTextView4;
        this.tvWithdrawLabel = textView;
        this.tvWx = bLTextView5;
        this.tvZfb = bLTextView6;
    }

    public static ActivityWithdrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWithdrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWithdrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_withdraw, viewGroup, z, obj);
    }

    public static ActivityWithdrawBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWithdrawBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWithdrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_withdraw, null, false, obj);
    }

    public static ActivityWithdrawBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWithdrawBinding bind(View view, Object obj) {
        return (ActivityWithdrawBinding) bind(obj, view, R.layout.activity_withdraw);
    }
}
