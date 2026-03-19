package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogBindPhoneBinding extends ViewDataBinding {
    public final AppCompatEditText etCode;
    public final AppCompatEditText etPhone;
    public final BLLinearLayout llPhone;
    public final BLLinearLayout rlCode;
    public final BLTextView tvCancel;
    public final TextView tvSend;
    public final BLTextView tvSure;
    public final TextView tvTitle;

    protected DialogBindPhoneBinding(Object obj, View view, int i, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, BLTextView bLTextView, TextView textView, BLTextView bLTextView2, TextView textView2) {
        super(obj, view, i);
        this.etCode = appCompatEditText;
        this.etPhone = appCompatEditText2;
        this.llPhone = bLLinearLayout;
        this.rlCode = bLLinearLayout2;
        this.tvCancel = bLTextView;
        this.tvSend = textView;
        this.tvSure = bLTextView2;
        this.tvTitle = textView2;
    }

    public static DialogBindPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBindPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogBindPhoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bind_phone, viewGroup, z, obj);
    }

    public static DialogBindPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBindPhoneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogBindPhoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bind_phone, null, false, obj);
    }

    public static DialogBindPhoneBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBindPhoneBinding bind(View view, Object obj) {
        return (DialogBindPhoneBinding) bind(obj, view, R.layout.dialog_bind_phone);
    }
}
