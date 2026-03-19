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
public abstract class DialogUpdateNicknameBinding extends ViewDataBinding {
    public final AppCompatEditText etNickname;
    public final BLLinearLayout llPhone;
    public final BLTextView tvCancel;
    public final BLTextView tvSure;
    public final TextView tvTitle;

    protected DialogUpdateNicknameBinding(Object obj, View view, int i, AppCompatEditText appCompatEditText, BLLinearLayout bLLinearLayout, BLTextView bLTextView, BLTextView bLTextView2, TextView textView) {
        super(obj, view, i);
        this.etNickname = appCompatEditText;
        this.llPhone = bLLinearLayout;
        this.tvCancel = bLTextView;
        this.tvSure = bLTextView2;
        this.tvTitle = textView;
    }

    public static DialogUpdateNicknameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateNicknameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogUpdateNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_update_nickname, viewGroup, z, obj);
    }

    public static DialogUpdateNicknameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateNicknameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogUpdateNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_update_nickname, null, false, obj);
    }

    public static DialogUpdateNicknameBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateNicknameBinding bind(View view, Object obj) {
        return (DialogUpdateNicknameBinding) bind(obj, view, R.layout.dialog_update_nickname);
    }
}
