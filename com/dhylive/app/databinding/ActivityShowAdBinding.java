package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityShowAdBinding extends ViewDataBinding {
    public final FrameLayout flContainer;

    protected ActivityShowAdBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.flContainer = frameLayout;
    }

    public static ActivityShowAdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityShowAdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityShowAdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_show_ad, viewGroup, z, obj);
    }

    public static ActivityShowAdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityShowAdBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityShowAdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_show_ad, null, false, obj);
    }

    public static ActivityShowAdBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityShowAdBinding bind(View view, Object obj) {
        return (ActivityShowAdBinding) bind(obj, view, R.layout.activity_show_ad);
    }
}
