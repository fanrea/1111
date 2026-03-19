package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ItemMoguTaskBinding extends ViewDataBinding {
    public final AppCompatImageView ivIcon;
    public final AppCompatTextView tvDesc;
    public final BLTextView tvReward;
    public final BLTextView tvTaskStatus;
    public final AppCompatTextView tvTitle;
    public final BLTextView tvTotal;

    protected ItemMoguTaskBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, BLTextView bLTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView2, BLTextView bLTextView3) {
        super(obj, view, i);
        this.ivIcon = appCompatImageView;
        this.tvDesc = appCompatTextView;
        this.tvReward = bLTextView;
        this.tvTaskStatus = bLTextView2;
        this.tvTitle = appCompatTextView2;
        this.tvTotal = bLTextView3;
    }

    public static ItemMoguTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoguTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMoguTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mogu_task, viewGroup, z, obj);
    }

    public static ItemMoguTaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoguTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMoguTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mogu_task, null, false, obj);
    }

    public static ItemMoguTaskBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoguTaskBinding bind(View view, Object obj) {
        return (ItemMoguTaskBinding) bind(obj, view, R.layout.item_mogu_task);
    }
}
