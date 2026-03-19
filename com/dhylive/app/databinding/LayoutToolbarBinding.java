package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class LayoutToolbarBinding extends ViewDataBinding {
    public final AppCompatImageView publicIvBack;
    public final AppCompatImageView publicIvRightBtnOne;
    public final AppCompatImageView publicIvRightBtnTwo;
    public final BLTextView publicTvRightBtn;
    public final AppCompatTextView publicTvTitle;
    public final ConstraintLayout toolbar;

    protected LayoutToolbarBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, BLTextView bLTextView, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.publicIvBack = appCompatImageView;
        this.publicIvRightBtnOne = appCompatImageView2;
        this.publicIvRightBtnTwo = appCompatImageView3;
        this.publicTvRightBtn = bLTextView;
        this.publicTvTitle = appCompatTextView;
        this.toolbar = constraintLayout;
    }

    public static LayoutToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_toolbar, viewGroup, z, obj);
    }

    public static LayoutToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutToolbarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_toolbar, null, false, obj);
    }

    public static LayoutToolbarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutToolbarBinding bind(View view, Object obj) {
        return (LayoutToolbarBinding) bind(obj, view, R.layout.layout_toolbar);
    }
}
