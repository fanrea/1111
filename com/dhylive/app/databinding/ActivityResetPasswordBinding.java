package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityResetPasswordBinding extends ViewDataBinding {
    public final AppCompatEditText etCode;
    public final BLEditText etPhone;
    public final AppCompatEditText etPsw;
    public final AppCompatEditText etPsw2;
    public final LayoutToolbarBinding includeToolbar;
    public final AppCompatImageView ivPswVisibility;
    public final AppCompatImageView ivPswVisibility2;
    public final BLLinearLayout llPhone;
    public final BLLinearLayout llPwd;
    public final BLLinearLayout llPwd2;
    public final BLLinearLayout rlCode;
    public final BLTextView tvLogin;
    public final TextView tvLoginHint;
    public final TextView tvSend;

    protected ActivityResetPasswordBinding(Object obj, View view, int i, AppCompatEditText appCompatEditText, BLEditText bLEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, LayoutToolbarBinding layoutToolbarBinding, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, BLLinearLayout bLLinearLayout3, BLLinearLayout bLLinearLayout4, BLTextView bLTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.etCode = appCompatEditText;
        this.etPhone = bLEditText;
        this.etPsw = appCompatEditText2;
        this.etPsw2 = appCompatEditText3;
        this.includeToolbar = layoutToolbarBinding;
        this.ivPswVisibility = appCompatImageView;
        this.ivPswVisibility2 = appCompatImageView2;
        this.llPhone = bLLinearLayout;
        this.llPwd = bLLinearLayout2;
        this.llPwd2 = bLLinearLayout3;
        this.rlCode = bLLinearLayout4;
        this.tvLogin = bLTextView;
        this.tvLoginHint = textView;
        this.tvSend = textView2;
    }

    public static ActivityResetPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityResetPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityResetPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_reset_password, viewGroup, z, obj);
    }

    public static ActivityResetPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityResetPasswordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityResetPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_reset_password, null, false, obj);
    }

    public static ActivityResetPasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityResetPasswordBinding bind(View view, Object obj) {
        return (ActivityResetPasswordBinding) bind(obj, view, R.layout.activity_reset_password);
    }
}
