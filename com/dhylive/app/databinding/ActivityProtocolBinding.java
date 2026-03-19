package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.just.agentweb.AgentWebView;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityProtocolBinding extends ViewDataBinding {
    public final BLFrameLayout flContainer;
    public final AppCompatImageView ivBack;
    public final BLTextView tvSure;
    public final AppCompatTextView tvTitle;
    public final AppCompatTextView tvTitleSecond;
    public final AgentWebView web;

    protected ActivityProtocolBinding(Object obj, View view, int i, BLFrameLayout bLFrameLayout, AppCompatImageView appCompatImageView, BLTextView bLTextView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AgentWebView agentWebView) {
        super(obj, view, i);
        this.flContainer = bLFrameLayout;
        this.ivBack = appCompatImageView;
        this.tvSure = bLTextView;
        this.tvTitle = appCompatTextView;
        this.tvTitleSecond = appCompatTextView2;
        this.web = agentWebView;
    }

    public static ActivityProtocolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProtocolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityProtocolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_protocol, viewGroup, z, obj);
    }

    public static ActivityProtocolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProtocolBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityProtocolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_protocol, null, false, obj);
    }

    public static ActivityProtocolBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProtocolBinding bind(View view, Object obj) {
        return (ActivityProtocolBinding) bind(obj, view, R.layout.activity_protocol);
    }
}
