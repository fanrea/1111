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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ItemDramaBinding extends ViewDataBinding {
    public final ConstraintLayout clRoot;
    public final AppCompatImageView ivCover;
    public final AppCompatTextView tvTitle;
    public final AppCompatTextView tvTotal;

    protected ItemDramaBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.clRoot = constraintLayout;
        this.ivCover = appCompatImageView;
        this.tvTitle = appCompatTextView;
        this.tvTotal = appCompatTextView2;
    }

    public static ItemDramaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDramaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDramaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_drama, viewGroup, z, obj);
    }

    public static ItemDramaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDramaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDramaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_drama, null, false, obj);
    }

    public static ItemDramaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDramaBinding bind(View view, Object obj) {
        return (ItemDramaBinding) bind(obj, view, R.layout.item_drama);
    }
}
