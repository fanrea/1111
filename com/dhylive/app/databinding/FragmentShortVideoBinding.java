package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentShortVideoBinding extends ViewDataBinding {
    public final CardView flContainer;

    protected FragmentShortVideoBinding(Object obj, View view, int i, CardView cardView) {
        super(obj, view, i);
        this.flContainer = cardView;
    }

    public static FragmentShortVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentShortVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentShortVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_short_video, viewGroup, z, obj);
    }

    public static FragmentShortVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentShortVideoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentShortVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_short_video, null, false, obj);
    }

    public static FragmentShortVideoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentShortVideoBinding bind(View view, Object obj) {
        return (FragmentShortVideoBinding) bind(obj, view, R.layout.fragment_short_video);
    }
}
