package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentMoguTaskBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;

    protected FragmentMoguTaskBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
    }

    public static FragmentMoguTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoguTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMoguTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mogu_task, viewGroup, z, obj);
    }

    public static FragmentMoguTaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoguTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMoguTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mogu_task, null, false, obj);
    }

    public static FragmentMoguTaskBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoguTaskBinding bind(View view, Object obj) {
        return (FragmentMoguTaskBinding) bind(obj, view, R.layout.fragment_mogu_task);
    }
}
