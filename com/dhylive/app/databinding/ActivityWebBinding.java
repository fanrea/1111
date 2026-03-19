package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.just.agentweb.AgentWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityWebBinding extends ViewDataBinding {
    public final LayoutToolbarBinding includeToolbar;
    public final AgentWebView web;

    protected ActivityWebBinding(Object obj, View view, int i, LayoutToolbarBinding layoutToolbarBinding, AgentWebView agentWebView) {
        super(obj, view, i);
        this.includeToolbar = layoutToolbarBinding;
        this.web = agentWebView;
    }

    public static ActivityWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_web, viewGroup, z, obj);
    }

    public static ActivityWebBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_web, null, false, obj);
    }

    public static ActivityWebBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebBinding bind(View view, Object obj) {
        return (ActivityWebBinding) bind(obj, view, R.layout.activity_web);
    }
}
