package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.noober.background.view.BLImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class LayoutNovHeaderRecommendBinding extends ViewDataBinding {
    public final AppCompatEditText etContent;
    public final RecyclerView novHomeRecyclerCategory;
    public final RecyclerView novHomeRecyclerRecommend;
    public final TextView tvSearch;
    public final BLImageView view;

    protected LayoutNovHeaderRecommendBinding(Object obj, View view, int i, AppCompatEditText appCompatEditText, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, BLImageView bLImageView) {
        super(obj, view, i);
        this.etContent = appCompatEditText;
        this.novHomeRecyclerCategory = recyclerView;
        this.novHomeRecyclerRecommend = recyclerView2;
        this.tvSearch = textView;
        this.view = bLImageView;
    }

    public static LayoutNovHeaderRecommendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNovHeaderRecommendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutNovHeaderRecommendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_nov_header_recommend, viewGroup, z, obj);
    }

    public static LayoutNovHeaderRecommendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNovHeaderRecommendBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutNovHeaderRecommendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_nov_header_recommend, null, false, obj);
    }

    public static LayoutNovHeaderRecommendBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNovHeaderRecommendBinding bind(View view, Object obj) {
        return (LayoutNovHeaderRecommendBinding) bind(obj, view, R.layout.layout_nov_header_recommend);
    }
}
