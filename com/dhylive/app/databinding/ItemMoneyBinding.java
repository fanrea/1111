package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ItemMoneyBinding extends ViewDataBinding {
    public final BLLinearLayout clRoot;
    public final BLTextView tvMoney;

    protected ItemMoneyBinding(Object obj, View view, int i, BLLinearLayout bLLinearLayout, BLTextView bLTextView) {
        super(obj, view, i);
        this.clRoot = bLLinearLayout;
        this.tvMoney = bLTextView;
    }

    public static ItemMoneyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoneyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMoneyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_money, viewGroup, z, obj);
    }

    public static ItemMoneyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoneyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMoneyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_money, null, false, obj);
    }

    public static ItemMoneyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoneyBinding bind(View view, Object obj) {
        return (ItemMoneyBinding) bind(obj, view, R.layout.item_money);
    }
}
