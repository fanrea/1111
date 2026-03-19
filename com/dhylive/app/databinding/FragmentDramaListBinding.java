package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentDramaListBinding extends ViewDataBinding {
    public final LinearLayout llContainer;
    public final RecyclerView recyclerCategory;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;

    protected FragmentDramaListBinding(Object obj, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.llContainer = linearLayout;
        this.recyclerCategory = recyclerView;
        this.recyclerView = recyclerView2;
        this.refreshLayout = smartRefreshLayout;
    }

    public static FragmentDramaListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDramaListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDramaListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_drama_list, viewGroup, z, obj);
    }

    public static FragmentDramaListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDramaListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDramaListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_drama_list, null, false, obj);
    }

    public static FragmentDramaListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDramaListBinding bind(View view, Object obj) {
        return (FragmentDramaListBinding) bind(obj, view, R.layout.fragment_drama_list);
    }
}
