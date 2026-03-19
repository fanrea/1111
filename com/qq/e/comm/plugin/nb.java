package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nb implements IDynamicScriptLifecycle {
    private final com.qq.e.comm.dynamic.b a;
    private f5 b;

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onAppBackground() throws JSONException {
        in.b().a("GDTLifeCycle", "onAppBackground", new Object[0]).d().a("event_onAppBackground", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onAppForeground() throws JSONException {
        in.b().a("GDTLifeCycle", "onAppForeground", new Object[0]).d().a("event_onAppForeground", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onBindData(JSONObject jSONObject) throws JSONException {
        in.b().a("GDTLifeCycle", "onBindData", jSONObject).d().a("event_onBindData", jSONObject).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onStartAnimation(String str) throws JSONException {
        in.b().a("GDTLifeCycle", "onStartAnimation", str).d().a("event_onStartAnimation", str).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onViewCreate() throws JSONException {
        in.b().a("GDTLifeCycle", "onViewCreate", new Object[0]).d().a("event_onViewCreate", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onViewDestroy() throws JSONException {
        in.b().a("GDTLifeCycle", "onViewDestroy", new Object[0]).d().a("event_onViewDestroy", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onWindowBlur() throws JSONException {
        in.b().a("event_onWindowBlur", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onWindowFocus() throws JSONException {
        in.b().a("event_onWindowFocus", new Object[0]).c().a(this.a, this.b);
    }

    private nb(com.qq.e.comm.dynamic.b bVar, h4 h4Var, yq yqVar) {
        this.a = bVar;
        this.b = f5.a(h4Var, yqVar);
    }

    static nb a(com.qq.e.comm.dynamic.b bVar, h4 h4Var, yq yqVar) throws JSONException {
        if (bVar != null) {
            try {
                Object objB = bVar.b("(typeof(GDTLifeCycle) === 'undefined' || GDTLifeCycle === null) && (typeof(GDTEventBus) === 'undefined' || GDTEventBus === null)");
                if (objB != null && !((Boolean) objB).booleanValue()) {
                    return new nb(bVar, h4Var, yqVar);
                }
                return null;
            } catch (Throwable th) {
                ey.a("typeof(GDTLifeCycle) === 'undefined' || GDTLifeCycle === null", f5.a(h4Var, yqVar), th);
            }
        }
        return null;
    }
}
