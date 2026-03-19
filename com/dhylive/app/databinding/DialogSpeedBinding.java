package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogSpeedBinding extends ViewDataBinding {
    public final RecyclerView recycler;

    protected DialogSpeedBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recycler = recyclerView;
    }

    public static DialogSpeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSpeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_speed, viewGroup, z, obj);
    }

    public static DialogSpeedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSpeedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_speed, null, false, obj);
    }

    public static DialogSpeedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSpeedBinding bind(View view, Object obj) {
        return (DialogSpeedBinding) bind(obj, view, R.layout.dialog_speed);
    }
}
