package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ItemNovelBinding extends ViewDataBinding {
    public final ConstraintLayout clRoot;
    public final AppCompatImageView ivCover;
    public final TextView novItemHomeFeedCategory;
    public final TextView novItemHomeFeedDesc;
    public final TextView novItemHomeFeedTitle;

    protected ItemNovelBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.clRoot = constraintLayout;
        this.ivCover = appCompatImageView;
        this.novItemHomeFeedCategory = textView;
        this.novItemHomeFeedDesc = textView2;
        this.novItemHomeFeedTitle = textView3;
    }

    public static ItemNovelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNovelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNovelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_novel, viewGroup, z, obj);
    }

    public static ItemNovelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNovelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNovelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_novel, null, false, obj);
    }

    public static ItemNovelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNovelBinding bind(View view, Object obj) {
        return (ItemNovelBinding) bind(obj, view, R.layout.item_novel);
    }
}
