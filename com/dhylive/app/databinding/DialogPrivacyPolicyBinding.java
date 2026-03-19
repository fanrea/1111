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
public abstract class DialogPrivacyPolicyBinding extends ViewDataBinding {
    public final TextView tvCancel;
    public final TextView tvConfirm;
    public final AppCompatTextView tvContent;
    public final TextView tvTitle;

    protected DialogPrivacyPolicyBinding(Object obj, View view, int i, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3) {
        super(obj, view, i);
        this.tvCancel = textView;
        this.tvConfirm = textView2;
        this.tvContent = appCompatTextView;
        this.tvTitle = textView3;
    }

    public static DialogPrivacyPolicyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPrivacyPolicyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPrivacyPolicyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_privacy_policy, viewGroup, z, obj);
    }

    public static DialogPrivacyPolicyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPrivacyPolicyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPrivacyPolicyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_privacy_policy, null, false, obj);
    }

    public static DialogPrivacyPolicyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPrivacyPolicyBinding bind(View view, Object obj) {
        return (DialogPrivacyPolicyBinding) bind(obj, view, R.layout.dialog_privacy_policy);
    }
}
