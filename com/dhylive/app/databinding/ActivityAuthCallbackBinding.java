package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityAuthCallbackBinding extends ViewDataBinding {
    protected ActivityAuthCallbackBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityAuthCallbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthCallbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAuthCallbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_auth_callback, viewGroup, z, obj);
    }

    public static ActivityAuthCallbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthCallbackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAuthCallbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_auth_callback, null, false, obj);
    }

    public static ActivityAuthCallbackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthCallbackBinding bind(View view, Object obj) {
        return (ActivityAuthCallbackBinding) bind(obj, view, R.layout.activity_auth_callback);
    }
}
