package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityCrashBinding extends ViewDataBinding {
    public final DrawerLayout dlCrashDrawer;
    public final AppCompatImageView ivCrashInfo;
    public final AppCompatImageView ivCrashRestart;
    public final AppCompatImageView ivCrashShare;
    public final LinearLayout llCrashBar;
    public final LinearLayout llCrashInfo;
    public final AppCompatTextView tvCrashInfo;
    public final AppCompatTextView tvCrashMessage;
    public final AppCompatTextView tvCrashTitle;

    protected ActivityCrashBinding(Object obj, View view, int i, DrawerLayout drawerLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.dlCrashDrawer = drawerLayout;
        this.ivCrashInfo = appCompatImageView;
        this.ivCrashRestart = appCompatImageView2;
        this.ivCrashShare = appCompatImageView3;
        this.llCrashBar = linearLayout;
        this.llCrashInfo = linearLayout2;
        this.tvCrashInfo = appCompatTextView;
        this.tvCrashMessage = appCompatTextView2;
        this.tvCrashTitle = appCompatTextView3;
    }

    public static ActivityCrashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCrashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCrashBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_crash, viewGroup, z, obj);
    }

    public static ActivityCrashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCrashBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCrashBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_crash, null, false, obj);
    }

    public static ActivityCrashBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCrashBinding bind(View view, Object obj) {
        return (ActivityCrashBinding) bind(obj, view, R.layout.activity_crash);
    }
}
