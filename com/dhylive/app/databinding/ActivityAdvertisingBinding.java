package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityAdvertisingBinding extends ViewDataBinding {
    public final AppCompatImageView ivBg;
    public final AppCompatImageView ivIcon;
    public final ProgressBar progressBar;
    public final FrameLayout splashContainer;
    public final AppCompatTextView tvAppName;

    protected ActivityAdvertisingBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ProgressBar progressBar, FrameLayout frameLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.ivBg = appCompatImageView;
        this.ivIcon = appCompatImageView2;
        this.progressBar = progressBar;
        this.splashContainer = frameLayout;
        this.tvAppName = appCompatTextView;
    }

    public static ActivityAdvertisingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAdvertisingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAdvertisingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_advertising, viewGroup, z, obj);
    }

    public static ActivityAdvertisingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAdvertisingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAdvertisingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_advertising, null, false, obj);
    }

    public static ActivityAdvertisingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAdvertisingBinding bind(View view, Object obj) {
        return (ActivityAdvertisingBinding) bind(obj, view, R.layout.activity_advertising);
    }
}
