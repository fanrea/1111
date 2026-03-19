package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityWhithdrawSettingBinding extends ViewDataBinding {
    public final BLConstraintLayout clBindAlipayCount;
    public final BLConstraintLayout clBindBankCard;
    public final BLConstraintLayout clBindWX;
    public final AppCompatEditText etBankAccount;
    public final AppCompatEditText etBankName;
    public final AppCompatEditText etBankSubName;
    public final AppCompatEditText etBankUserName;
    public final AppCompatEditText etZfbAccount;
    public final AppCompatEditText etZfbName;
    public final LayoutToolbarBinding includeToolbar;
    public final TextView tvBankAccountLabel;
    public final TextView tvBankNameLabel;
    public final TextView tvBankSubNameLabel;
    public final TextView tvBankTitleLabel;
    public final TextView tvBankUserNameLabel;
    public final BLTextView tvSaveBank;
    public final BLTextView tvSaveZfb;
    public final BLTextView tvWX;
    public final TextView tvZfbAccountLabel;
    public final TextView tvZfbRealNameLabel;
    public final TextView tvZfbTitleLabel;

    protected ActivityWhithdrawSettingBinding(Object obj, View view, int i, BLConstraintLayout bLConstraintLayout, BLConstraintLayout bLConstraintLayout2, BLConstraintLayout bLConstraintLayout3, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, AppCompatEditText appCompatEditText4, AppCompatEditText appCompatEditText5, AppCompatEditText appCompatEditText6, LayoutToolbarBinding layoutToolbarBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, BLTextView bLTextView, BLTextView bLTextView2, BLTextView bLTextView3, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.clBindAlipayCount = bLConstraintLayout;
        this.clBindBankCard = bLConstraintLayout2;
        this.clBindWX = bLConstraintLayout3;
        this.etBankAccount = appCompatEditText;
        this.etBankName = appCompatEditText2;
        this.etBankSubName = appCompatEditText3;
        this.etBankUserName = appCompatEditText4;
        this.etZfbAccount = appCompatEditText5;
        this.etZfbName = appCompatEditText6;
        this.includeToolbar = layoutToolbarBinding;
        this.tvBankAccountLabel = textView;
        this.tvBankNameLabel = textView2;
        this.tvBankSubNameLabel = textView3;
        this.tvBankTitleLabel = textView4;
        this.tvBankUserNameLabel = textView5;
        this.tvSaveBank = bLTextView;
        this.tvSaveZfb = bLTextView2;
        this.tvWX = bLTextView3;
        this.tvZfbAccountLabel = textView6;
        this.tvZfbRealNameLabel = textView7;
        this.tvZfbTitleLabel = textView8;
    }

    public static ActivityWhithdrawSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWhithdrawSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWhithdrawSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_whithdraw_setting, viewGroup, z, obj);
    }

    public static ActivityWhithdrawSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWhithdrawSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWhithdrawSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_whithdraw_setting, null, false, obj);
    }

    public static ActivityWhithdrawSettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWhithdrawSettingBinding bind(View view, Object obj) {
        return (ActivityWhithdrawSettingBinding) bind(obj, view, R.layout.activity_whithdraw_setting);
    }
}
