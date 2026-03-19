package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.dhylive.app.R;
import com.noober.background.view.BLImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentHomeBinding extends ViewDataBinding {
    public final AppCompatEditText etContent;
    public final LinearLayout llContainer;
    public final RecyclerView recyclerCategory;
    public final LinearLayout toolbar;
    public final TextView tvSearch;
    public final BLImageView view;
    public final ViewPager2 viewPage;

    protected FragmentHomeBinding(Object obj, View view, int i, AppCompatEditText appCompatEditText, LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView, BLImageView bLImageView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.etContent = appCompatEditText;
        this.llContainer = linearLayout;
        this.recyclerCategory = recyclerView;
        this.toolbar = linearLayout2;
        this.tvSearch = textView;
        this.view = bLImageView;
        this.viewPage = viewPager2;
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home, viewGroup, z, obj);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home, null, false, obj);
    }

    public static FragmentHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding bind(View view, Object obj) {
        return (FragmentHomeBinding) bind(obj, view, R.layout.fragment_home);
    }
}
