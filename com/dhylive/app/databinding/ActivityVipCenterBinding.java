package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityVipCenterBinding extends ViewDataBinding {
    public final BLConstraintLayout clVipChargeChannel;
    public final AppCompatImageView ivAvatar;
    public final AppCompatImageView ivBack;
    public final AppCompatImageView ivWechat;
    public final AppCompatImageView ivZfb;
    public final BLLinearLayout llVipBuyInfo;
    public final BLLinearLayout llVipReward;
    public final RecyclerView recycler;
    public final RecyclerView recyclerVipReward;
    public final FrameLayout toolbar;
    public final TextView tvAgreement;
    public final BLTextView tvConfirm;
    public final AppCompatTextView tvExpiredTime;
    public final AppCompatTextView tvNickname;
    public final BLTextView tvVipLevel;
    public final AppCompatTextView tvWechatLabel;
    public final AppCompatTextView tvZfbLabel;

    protected ActivityVipCenterBinding(Object obj, View view, int i, BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, FrameLayout frameLayout, TextView textView, BLTextView bLTextView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLTextView bLTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        super(obj, view, i);
        this.clVipChargeChannel = bLConstraintLayout;
        this.ivAvatar = appCompatImageView;
        this.ivBack = appCompatImageView2;
        this.ivWechat = appCompatImageView3;
        this.ivZfb = appCompatImageView4;
        this.llVipBuyInfo = bLLinearLayout;
        this.llVipReward = bLLinearLayout2;
        this.recycler = recyclerView;
        this.recyclerVipReward = recyclerView2;
        this.toolbar = frameLayout;
        this.tvAgreement = textView;
        this.tvConfirm = bLTextView;
        this.tvExpiredTime = appCompatTextView;
        this.tvNickname = appCompatTextView2;
        this.tvVipLevel = bLTextView2;
        this.tvWechatLabel = appCompatTextView3;
        this.tvZfbLabel = appCompatTextView4;
    }

    public static ActivityVipCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVipCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityVipCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_vip_center, viewGroup, z, obj);
    }

    public static ActivityVipCenterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVipCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityVipCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_vip_center, null, false, obj);
    }

    public static ActivityVipCenterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVipCenterBinding bind(View view, Object obj) {
        return (ActivityVipCenterBinding) bind(obj, view, R.layout.activity_vip_center);
    }
}
