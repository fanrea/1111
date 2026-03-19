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
public abstract class DialogSendCoinBinding extends ViewDataBinding {
    public final BLEditText etCoin;
    public final BLEditText etUserId;
    public final AppCompatImageView ivClose;
    public final BLTextView tvAllIn;
    public final AppCompatTextView tvCoin;
    public final BLTextView tvConfirm;

    protected DialogSendCoinBinding(Object obj, View view, int i, BLEditText bLEditText, BLEditText bLEditText2, AppCompatImageView appCompatImageView, BLTextView bLTextView, AppCompatTextView appCompatTextView, BLTextView bLTextView2) {
        super(obj, view, i);
        this.etCoin = bLEditText;
        this.etUserId = bLEditText2;
        this.ivClose = appCompatImageView;
        this.tvAllIn = bLTextView;
        this.tvCoin = appCompatTextView;
        this.tvConfirm = bLTextView2;
    }

    public static DialogSendCoinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSendCoinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSendCoinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_send_coin, viewGroup, z, obj);
    }

    public static DialogSendCoinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSendCoinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSendCoinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_send_coin, null, false, obj);
    }

    public static DialogSendCoinBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSendCoinBinding bind(View view, Object obj) {
        return (DialogSendCoinBinding) bind(obj, view, R.layout.dialog_send_coin);
    }
}
