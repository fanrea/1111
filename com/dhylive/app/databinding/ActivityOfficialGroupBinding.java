package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityOfficialGroupBinding extends ViewDataBinding {
    public final LayoutToolbarBinding includeToolbar;
    public final AppCompatImageView ivIcon;

    protected ActivityOfficialGroupBinding(Object obj, View view, int i, LayoutToolbarBinding layoutToolbarBinding, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.includeToolbar = layoutToolbarBinding;
        this.ivIcon = appCompatImageView;
    }

    public static ActivityOfficialGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityOfficialGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityOfficialGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_official_group, viewGroup, z, obj);
    }

    public static ActivityOfficialGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityOfficialGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityOfficialGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_official_group, null, false, obj);
    }

    public static ActivityOfficialGroupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityOfficialGroupBinding bind(View view, Object obj) {
        return (ActivityOfficialGroupBinding) bind(obj, view, R.layout.activity_official_group);
    }
}
