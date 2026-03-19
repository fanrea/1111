package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogLoadingBinding extends ViewDataBinding {
    public final AppCompatImageView ivLoading;
    public final TextView tvLoading;

    protected DialogLoadingBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView) {
        super(obj, view, i);
        this.ivLoading = appCompatImageView;
        this.tvLoading = textView;
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_loading, viewGroup, z, obj);
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_loading, null, false, obj);
    }

    public static DialogLoadingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogLoadingBinding bind(View view, Object obj) {
        return (DialogLoadingBinding) bind(obj, view, R.layout.dialog_loading);
    }
}
