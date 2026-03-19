package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogBindInviteBinding extends ViewDataBinding {
    public final BLEditText etInviteCode;
    public final AppCompatImageView ivClose;
    public final BLTextView tvPrivacyOk;
    public final AppCompatTextView tvTitle;

    protected DialogBindInviteBinding(Object obj, View view, int i, BLEditText bLEditText, AppCompatImageView appCompatImageView, BLTextView bLTextView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.etInviteCode = bLEditText;
        this.ivClose = appCompatImageView;
        this.tvPrivacyOk = bLTextView;
        this.tvTitle = appCompatTextView;
    }

    public static DialogBindInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBindInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogBindInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bind_invite, viewGroup, z, obj);
    }

    public static DialogBindInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBindInviteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogBindInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bind_invite, null, false, obj);
    }

    public static DialogBindInviteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBindInviteBinding bind(View view, Object obj) {
        return (DialogBindInviteBinding) bind(obj, view, R.layout.dialog_bind_invite);
    }
}
