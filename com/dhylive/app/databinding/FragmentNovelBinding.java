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
public abstract class FragmentNovelBinding extends ViewDataBinding {
    public final RecyclerView recycler;
    public final SmartRefreshLayout refresh;

    protected FragmentNovelBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.recycler = recyclerView;
        this.refresh = smartRefreshLayout;
    }

    public static FragmentNovelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentNovelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentNovelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_novel, viewGroup, z, obj);
    }

    public static FragmentNovelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentNovelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentNovelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_novel, null, false, obj);
    }

    public static FragmentNovelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentNovelBinding bind(View view, Object obj) {
        return (FragmentNovelBinding) bind(obj, view, R.layout.fragment_novel);
    }
}
