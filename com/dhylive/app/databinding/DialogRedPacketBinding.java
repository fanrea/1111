package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogRedPacketBinding extends ViewDataBinding {
    public final FrameLayout flContainer;
    public final AppCompatImageView ivBg;
    public final AppCompatImageView ivClose;
    public final AppCompatImageView ivMainBtn;
    public final AppCompatTextView tvTitle;
    public final AppCompatTextView tvTop;

    protected DialogRedPacketBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.flContainer = frameLayout;
        this.ivBg = appCompatImageView;
        this.ivClose = appCompatImageView2;
        this.ivMainBtn = appCompatImageView3;
        this.tvTitle = appCompatTextView;
        this.tvTop = appCompatTextView2;
    }

    public static DialogRedPacketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRedPacketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRedPacketBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_red_packet, viewGroup, z, obj);
    }

    public static DialogRedPacketBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRedPacketBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRedPacketBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_red_packet, null, false, obj);
    }

    public static DialogRedPacketBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRedPacketBinding bind(View view, Object obj) {
        return (DialogRedPacketBinding) bind(obj, view, R.layout.dialog_red_packet);
    }
}
