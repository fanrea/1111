package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityMineDetailsBinding extends ViewDataBinding {
    public final LayoutToolbarBinding includeToolbar;
    public final AppCompatImageView ivAvatar;
    public final RecyclerView recycler;

    protected ActivityMineDetailsBinding(Object obj, View view, int i, LayoutToolbarBinding layoutToolbarBinding, AppCompatImageView appCompatImageView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.includeToolbar = layoutToolbarBinding;
        this.ivAvatar = appCompatImageView;
        this.recycler = recyclerView;
    }

    public static ActivityMineDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMineDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMineDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mine_details, viewGroup, z, obj);
    }

    public static ActivityMineDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMineDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMineDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mine_details, null, false, obj);
    }

    public static ActivityMineDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMineDetailsBinding bind(View view, Object obj) {
        return (ActivityMineDetailsBinding) bind(obj, view, R.layout.activity_mine_details);
    }
}
