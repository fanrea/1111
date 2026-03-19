package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogWaitWithdrawBinding extends ViewDataBinding {
    public final ImageView ivClose;
    public final RecyclerView recyclerView;
    public final TextView tvHint;
    public final TextView tvTitle;

    protected DialogWaitWithdrawBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivClose = imageView;
        this.recyclerView = recyclerView;
        this.tvHint = textView;
        this.tvTitle = textView2;
    }

    public static DialogWaitWithdrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogWaitWithdrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogWaitWithdrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_wait_withdraw, viewGroup, z, obj);
    }

    public static DialogWaitWithdrawBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogWaitWithdrawBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogWaitWithdrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_wait_withdraw, null, false, obj);
    }

    public static DialogWaitWithdrawBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogWaitWithdrawBinding bind(View view, Object obj) {
        return (DialogWaitWithdrawBinding) bind(obj, view, R.layout.dialog_wait_withdraw);
    }
}
