package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentContainerBinding extends ViewDataBinding {
    public final FrameLayout flContainer;

    protected FragmentContainerBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.flContainer = frameLayout;
    }

    public static FragmentContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_container, viewGroup, z, obj);
    }

    public static FragmentContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentContainerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_container, null, false, obj);
    }

    public static FragmentContainerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentContainerBinding bind(View view, Object obj) {
        return (FragmentContainerBinding) bind(obj, view, R.layout.fragment_container);
    }
}
