package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentDramaDrawBinding extends ViewDataBinding {
    public final FrameLayout flContainer;

    protected FragmentDramaDrawBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.flContainer = frameLayout;
    }

    public static FragmentDramaDrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDramaDrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDramaDrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_drama_draw, viewGroup, z, obj);
    }

    public static FragmentDramaDrawBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDramaDrawBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDramaDrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_drama_draw, null, false, obj);
    }

    public static FragmentDramaDrawBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDramaDrawBinding bind(View view, Object obj) {
        return (FragmentDramaDrawBinding) bind(obj, view, R.layout.fragment_drama_draw);
    }
}
