package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements a {
    private c a;

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    public void a(IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.a = c.a(iAdInterListener, this);
        }
    }

    public void a(Context context) {
        this.a.a("onAttach", context);
    }

    public void a(Bundle bundle) {
        this.a.a("onCreate", bundle);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object objA = this.a.a("onCreateView", layoutInflater, viewGroup, bundle);
        if (objA instanceof View) {
            return (View) objA;
        }
        return null;
    }

    public void b(Bundle bundle) {
        this.a.a("onActivityCreated", bundle);
    }

    public void a() {
        this.a.a("onStart");
    }

    public void b() {
        this.a.a("onResume");
    }

    public void c() {
        this.a.a("onPause");
    }

    public void d() {
        this.a.a("onStop");
    }

    public void e() {
        this.a.a("onDestroyView");
    }

    public void f() {
        this.a.a("onDestroy");
    }

    public void g() {
        this.a.a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.a.setTarget(obj);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.a.getType();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.a.getData();
    }
}
