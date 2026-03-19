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
public abstract class DialogUpdatePwdBinding extends ViewDataBinding {
    public final AppCompatEditText etNewPsw;
    public final AppCompatEditText etNewPswAgain;
    public final AppCompatEditText etOldPsw;
    public final BLLinearLayout llNewPsw;
    public final BLLinearLayout llNewPswAgain;
    public final BLLinearLayout llOldPsw;
    public final BLTextView tvCancel;
    public final BLTextView tvSure;
    public final TextView tvTitle;

    protected DialogUpdatePwdBinding(Object obj, View view, int i, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, BLLinearLayout bLLinearLayout3, BLTextView bLTextView, BLTextView bLTextView2, TextView textView) {
        super(obj, view, i);
        this.etNewPsw = appCompatEditText;
        this.etNewPswAgain = appCompatEditText2;
        this.etOldPsw = appCompatEditText3;
        this.llNewPsw = bLLinearLayout;
        this.llNewPswAgain = bLLinearLayout2;
        this.llOldPsw = bLLinearLayout3;
        this.tvCancel = bLTextView;
        this.tvSure = bLTextView2;
        this.tvTitle = textView;
    }

    public static DialogUpdatePwdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdatePwdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogUpdatePwdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_update_pwd, viewGroup, z, obj);
    }

    public static DialogUpdatePwdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdatePwdBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogUpdatePwdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_update_pwd, null, false, obj);
    }

    public static DialogUpdatePwdBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdatePwdBinding bind(View view, Object obj) {
        return (DialogUpdatePwdBinding) bind(obj, view, R.layout.dialog_update_pwd);
    }
}
