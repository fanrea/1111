package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityNovelDetailBinding extends ViewDataBinding {
    protected ActivityNovelDetailBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityNovelDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNovelDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityNovelDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_novel_detail, viewGroup, z, obj);
    }

    public static ActivityNovelDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNovelDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityNovelDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_novel_detail, null, false, obj);
    }

    public static ActivityNovelDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNovelDetailBinding bind(View view, Object obj) {
        return (ActivityNovelDetailBinding) bind(obj, view, R.layout.activity_novel_detail);
    }
}
