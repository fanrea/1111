package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityDramaSearchBinding extends ViewDataBinding {
    public final BLEditText etContent;
    public final FrameLayout flContent;
    public final AppCompatImageView ivBack;
    public final LinearLayout toolbar;
    public final BLTextView tvSearch;

    protected ActivityDramaSearchBinding(Object obj, View view, int i, BLEditText bLEditText, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, BLTextView bLTextView) {
        super(obj, view, i);
        this.etContent = bLEditText;
        this.flContent = frameLayout;
        this.ivBack = appCompatImageView;
        this.toolbar = linearLayout;
        this.tvSearch = bLTextView;
    }

    public static ActivityDramaSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDramaSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDramaSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_drama_search, viewGroup, z, obj);
    }

    public static ActivityDramaSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDramaSearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDramaSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_drama_search, null, false, obj);
    }

    public static ActivityDramaSearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDramaSearchBinding bind(View view, Object obj) {
        return (ActivityDramaSearchBinding) bind(obj, view, R.layout.activity_drama_search);
    }
}
