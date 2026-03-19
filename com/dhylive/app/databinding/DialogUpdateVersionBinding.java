package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogUpdateVersionBinding extends ViewDataBinding {
    public final Group groupProgress;
    public final AppCompatImageView ivBg;
    public final AppCompatImageView ivClose;
    public final ProgressBar progressBar;
    public final NestedScrollView scroll;
    public final TextView tvContent;
    public final TextView tvProgress;
    public final BLTextView tvSure;
    public final TextView tvTitle;
    public final TextView tvVersion;

    protected DialogUpdateVersionBinding(Object obj, View view, int i, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ProgressBar progressBar, NestedScrollView nestedScrollView, TextView textView, TextView textView2, BLTextView bLTextView, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.groupProgress = group;
        this.ivBg = appCompatImageView;
        this.ivClose = appCompatImageView2;
        this.progressBar = progressBar;
        this.scroll = nestedScrollView;
        this.tvContent = textView;
        this.tvProgress = textView2;
        this.tvSure = bLTextView;
        this.tvTitle = textView3;
        this.tvVersion = textView4;
    }

    public static DialogUpdateVersionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateVersionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogUpdateVersionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_update_version, viewGroup, z, obj);
    }

    public static DialogUpdateVersionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateVersionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogUpdateVersionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_update_version, null, false, obj);
    }

    public static DialogUpdateVersionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateVersionBinding bind(View view, Object obj) {
        return (DialogUpdateVersionBinding) bind(obj, view, R.layout.dialog_update_version);
    }
}
