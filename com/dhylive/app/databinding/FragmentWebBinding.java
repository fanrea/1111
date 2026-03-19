package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.just.agentweb.AgentWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class FragmentWebBinding extends ViewDataBinding {
    public final AgentWebView web;

    protected FragmentWebBinding(Object obj, View view, int i, AgentWebView agentWebView) {
        super(obj, view, i);
        this.web = agentWebView;
    }

    public static FragmentWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_web, viewGroup, z, obj);
    }

    public static FragmentWebBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_web, null, false, obj);
    }

    public static FragmentWebBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebBinding bind(View view, Object obj) {
        return (FragmentWebBinding) bind(obj, view, R.layout.fragment_web);
    }
}
