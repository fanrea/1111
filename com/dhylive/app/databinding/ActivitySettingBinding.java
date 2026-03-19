package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivitySettingBinding extends ViewDataBinding {
    public final LayoutToolbarBinding includeToolbar;
    public final TextView tvClear;
    public final TextView tvCurrentVersion;
    public final BLTextView tvLogout;
    public final AppCompatTextView tvMemorySize;
    public final AppCompatTextView tvPrivacyAgreement;
    public final TextView tvUpdateVersion;
    public final AppCompatTextView tvUpdateVersionTips;
    public final AppCompatTextView tvUserAgreement;
    public final TextView tvVersion;
    public final View viewBgOther;

    protected ActivitySettingBinding(Object obj, View view, int i, LayoutToolbarBinding layoutToolbarBinding, TextView textView, TextView textView2, BLTextView bLTextView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView3, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, TextView textView4, View view2) {
        super(obj, view, i);
        this.includeToolbar = layoutToolbarBinding;
        this.tvClear = textView;
        this.tvCurrentVersion = textView2;
        this.tvLogout = bLTextView;
        this.tvMemorySize = appCompatTextView;
        this.tvPrivacyAgreement = appCompatTextView2;
        this.tvUpdateVersion = textView3;
        this.tvUpdateVersionTips = appCompatTextView3;
        this.tvUserAgreement = appCompatTextView4;
        this.tvVersion = textView4;
        this.viewBgOther = view2;
    }

    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_setting, viewGroup, z, obj);
    }

    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_setting, null, false, obj);
    }

    public static ActivitySettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySettingBinding bind(View view, Object obj) {
        return (ActivitySettingBinding) bind(obj, view, R.layout.activity_setting);
    }
}
