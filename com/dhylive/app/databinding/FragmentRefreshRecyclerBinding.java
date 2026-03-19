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
public abstract class FragmentRefreshRecyclerBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;

    protected FragmentRefreshRecyclerBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
    }

    public static FragmentRefreshRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRefreshRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRefreshRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_refresh_recycler, viewGroup, z, obj);
    }

    public static FragmentRefreshRecyclerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRefreshRecyclerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRefreshRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_refresh_recycler, null, false, obj);
    }

    public static FragmentRefreshRecyclerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRefreshRecyclerBinding bind(View view, Object obj) {
        return (FragmentRefreshRecyclerBinding) bind(obj, view, R.layout.fragment_refresh_recycler);
    }
}
