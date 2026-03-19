package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityLoginAccountBinding extends ViewDataBinding {
    public final ConstraintLayout clAll;
    public final AppCompatEditText etCode;
    public final BLEditText etPhone;
    public final AppCompatEditText etPsw;
    public final BLFrameLayout flWxLogin;
    public final AppCompatImageView ivCodeLogin;
    public final AppCompatImageView ivIcon;
    public final AppCompatImageView ivPhoneLogin;
    public final AppCompatImageView ivPswVisibility;
    public final AppCompatImageView ivSelect;
    public final AppCompatImageView ivSelectWx;
    public final AppCompatImageView ivWxLogin;
    public final BLLinearLayout llPhone;
    public final BLLinearLayout llPwd;
    public final LinearLayout llSelect;
    public final LinearLayout llSelectWx;
    public final LinearLayout llWx;
    public final BLLinearLayout rlCode;
    public final BLTextView tvLogin;
    public final TextView tvLoginHint;
    public final AppCompatTextView tvOtherLoginHint;
    public final AppCompatTextView tvPrivacy;
    public final AppCompatTextView tvPrivacyWx;
    public final AppCompatTextView tvRegister;
    public final AppCompatTextView tvResetPassword;
    public final TextView tvSend;

    protected ActivityLoginAccountBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText, BLEditText bLEditText, AppCompatEditText appCompatEditText2, BLFrameLayout bLFrameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, BLLinearLayout bLLinearLayout3, BLTextView bLTextView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, TextView textView2) {
        super(obj, view, i);
        this.clAll = constraintLayout;
        this.etCode = appCompatEditText;
        this.etPhone = bLEditText;
        this.etPsw = appCompatEditText2;
        this.flWxLogin = bLFrameLayout;
        this.ivCodeLogin = appCompatImageView;
        this.ivIcon = appCompatImageView2;
        this.ivPhoneLogin = appCompatImageView3;
        this.ivPswVisibility = appCompatImageView4;
        this.ivSelect = appCompatImageView5;
        this.ivSelectWx = appCompatImageView6;
        this.ivWxLogin = appCompatImageView7;
        this.llPhone = bLLinearLayout;
        this.llPwd = bLLinearLayout2;
        this.llSelect = linearLayout;
        this.llSelectWx = linearLayout2;
        this.llWx = linearLayout3;
        this.rlCode = bLLinearLayout3;
        this.tvLogin = bLTextView;
        this.tvLoginHint = textView;
        this.tvOtherLoginHint = appCompatTextView;
        this.tvPrivacy = appCompatTextView2;
        this.tvPrivacyWx = appCompatTextView3;
        this.tvRegister = appCompatTextView4;
        this.tvResetPassword = appCompatTextView5;
        this.tvSend = textView2;
    }

    public static ActivityLoginAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityLoginAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login_account, viewGroup, z, obj);
    }

    public static ActivityLoginAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginAccountBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityLoginAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login_account, null, false, obj);
    }

    public static ActivityLoginAccountBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginAccountBinding bind(View view, Object obj) {
        return (ActivityLoginAccountBinding) bind(obj, view, R.layout.activity_login_account);
    }
}
