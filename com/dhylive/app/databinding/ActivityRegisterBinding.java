package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityRegisterBinding extends ViewDataBinding {
    public final AppCompatEditText etCode;
    public final BLEditText etPhone;
    public final AppCompatEditText etPsw;
    public final AppCompatEditText etPsw2;
    public final AppCompatImageView ivBack;
    public final AppCompatImageView ivPswVisibility;
    public final AppCompatImageView ivPswVisibility2;
    public final AppCompatImageView ivSelect;
    public final BLLinearLayout llPhone;
    public final BLLinearLayout llPwd;
    public final BLLinearLayout llPwd2;
    public final LinearLayout llSelect;
    public final BLLinearLayout rlCode;
    public final BLTextView tvLogin;
    public final TextView tvLoginHint;
    public final AppCompatTextView tvPrivacy;
    public final TextView tvSend;

    protected ActivityRegisterBinding(Object obj, View view, int i, AppCompatEditText appCompatEditText, BLEditText bLEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, BLLinearLayout bLLinearLayout3, LinearLayout linearLayout, BLLinearLayout bLLinearLayout4, BLTextView bLTextView, TextView textView, AppCompatTextView appCompatTextView, TextView textView2) {
        super(obj, view, i);
        this.etCode = appCompatEditText;
        this.etPhone = bLEditText;
        this.etPsw = appCompatEditText2;
        this.etPsw2 = appCompatEditText3;
        this.ivBack = appCompatImageView;
        this.ivPswVisibility = appCompatImageView2;
        this.ivPswVisibility2 = appCompatImageView3;
        this.ivSelect = appCompatImageView4;
        this.llPhone = bLLinearLayout;
        this.llPwd = bLLinearLayout2;
        this.llPwd2 = bLLinearLayout3;
        this.llSelect = linearLayout;
        this.rlCode = bLLinearLayout4;
        this.tvLogin = bLTextView;
        this.tvLoginHint = textView;
        this.tvPrivacy = appCompatTextView;
        this.tvSend = textView2;
    }

    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRegisterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_register, viewGroup, z, obj);
    }

    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRegisterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_register, null, false, obj);
    }

    public static ActivityRegisterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRegisterBinding bind(View view, Object obj) {
        return (ActivityRegisterBinding) bind(obj, view, R.layout.activity_register);
    }
}
