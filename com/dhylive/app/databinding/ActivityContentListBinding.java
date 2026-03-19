package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityContentListBinding extends ViewDataBinding {
    public final FrameLayout flContent;
    public final LayoutToolbarBinding includeToolbar;
    public final BLTextView tvDrama;
    public final BLTextView tvNovel;

    protected ActivityContentListBinding(Object obj, View view, int i, FrameLayout frameLayout, LayoutToolbarBinding layoutToolbarBinding, BLTextView bLTextView, BLTextView bLTextView2) {
        super(obj, view, i);
        this.flContent = frameLayout;
        this.includeToolbar = layoutToolbarBinding;
        this.tvDrama = bLTextView;
        this.tvNovel = bLTextView2;
    }

    public static ActivityContentListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityContentListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityContentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_content_list, viewGroup, z, obj);
    }

    public static ActivityContentListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityContentListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityContentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_content_list, null, false, obj);
    }

    public static ActivityContentListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityContentListBinding bind(View view, Object obj) {
        return (ActivityContentListBinding) bind(obj, view, R.layout.activity_content_list);
    }
}
