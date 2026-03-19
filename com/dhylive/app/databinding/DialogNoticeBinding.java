package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogNoticeBinding extends ViewDataBinding {
    public final AppCompatTextView tvContent;
    public final TextView tvPrivacyOk;
    public final TextView tvTitle;

    protected DialogNoticeBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvContent = appCompatTextView;
        this.tvPrivacyOk = textView;
        this.tvTitle = textView2;
    }

    public static DialogNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogNoticeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notice, viewGroup, z, obj);
    }

    public static DialogNoticeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNoticeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogNoticeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notice, null, false, obj);
    }

    public static DialogNoticeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNoticeBinding bind(View view, Object obj) {
        return (DialogNoticeBinding) bind(obj, view, R.layout.dialog_notice);
    }
}
