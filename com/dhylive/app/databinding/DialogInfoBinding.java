package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogInfoBinding extends ViewDataBinding {
    public final BLTextView tvCancel;
    public final TextView tvContent;
    public final BLTextView tvSure;
    public final TextView tvTitle;

    protected DialogInfoBinding(Object obj, View view, int i, BLTextView bLTextView, TextView textView, BLTextView bLTextView2, TextView textView2) {
        super(obj, view, i);
        this.tvCancel = bLTextView;
        this.tvContent = textView;
        this.tvSure = bLTextView2;
        this.tvTitle = textView2;
    }

    public static DialogInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_info, viewGroup, z, obj);
    }

    public static DialogInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_info, null, false, obj);
    }

    public static DialogInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogInfoBinding bind(View view, Object obj) {
        return (DialogInfoBinding) bind(obj, view, R.layout.dialog_info);
    }
}
