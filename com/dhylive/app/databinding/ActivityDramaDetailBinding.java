package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityDramaDetailBinding extends ViewDataBinding {
    public final AppCompatImageView djxDramaDetailMore;
    public final AppCompatImageView djxDramaDetailSpeed;
    public final FrameLayout flContainer;
    public final AppCompatImageView ivBack;
    public final LinearLayout toolbar;
    public final AppCompatTextView tvTitle;

    protected ActivityDramaDetailBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.djxDramaDetailMore = appCompatImageView;
        this.djxDramaDetailSpeed = appCompatImageView2;
        this.flContainer = frameLayout;
        this.ivBack = appCompatImageView3;
        this.toolbar = linearLayout;
        this.tvTitle = appCompatTextView;
    }

    public static ActivityDramaDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDramaDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDramaDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_drama_detail, viewGroup, z, obj);
    }

    public static ActivityDramaDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDramaDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDramaDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_drama_detail, null, false, obj);
    }

    public static ActivityDramaDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDramaDetailBinding bind(View view, Object obj) {
        return (ActivityDramaDetailBinding) bind(obj, view, R.layout.activity_drama_detail);
    }
}
