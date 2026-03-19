package com.tk.core.component;

import android.content.Context;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kuaishou.tk.export.IBaseNativeModule;
import com.kuaishou.tk.export.INativeModule;
import com.kuaishou.tk.export.ITKContext;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.t;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class TKBaseNativeModule implements IBaseNativeModule {
    private volatile boolean Qq = false;
    private JsValueRef<V8Object> RW;
    private final V8Object ZW;
    protected NativeModuleInitParams ZX;
    private final ITKContext tkContext;

    public enum DestroyReason {
        GC,
        RELEASE
    }

    protected void a(DestroyReason destroyReason, boolean z) {
    }

    public TKBaseNativeModule(NativeModuleInitParams nativeModuleInitParams) {
        this.ZX = nativeModuleInitParams;
        this.tkContext = nativeModuleInitParams.tkContext;
        this.ZW = nativeModuleInitParams.v8This;
    }

    @Override // com.kuaishou.tk.export.IBaseNativeModule
    public V8Object getJsObj() {
        return this.ZW;
    }

    @Deprecated
    public final V8Object pL() {
        if (this.RW == null) {
            this.RW = ad.retainJsValue(this.ZW, this);
        }
        JsValueRef<V8Object> jsValueRef = this.RW;
        if (jsValueRef == null) {
            return null;
        }
        return jsValueRef.get();
    }

    @Deprecated
    public final void pM() {
        ad.unRetainJsValue(this.RW);
    }

    public final boolean pN() {
        return this.Qq;
    }

    @Override // com.kuaishou.tk.export.IBaseNativeModule
    public ITKContext getTKContext() {
        return this.tkContext;
    }

    @Override // com.kuaishou.tk.export.INativeModule
    public final void destroy(boolean z) {
        if (this.Qq) {
            com.tk.core.i.a.a("TKBaseNativeModule", "TKBaseNativeModule is already destroy.", null);
            return;
        }
        this.Qq = true;
        if (!z) {
            ih();
        }
        a(z ? DestroyReason.RELEASE : DestroyReason.GC, ac.sX());
    }

    public void ih() {
        ad.unRetainJsValue(this.RW);
    }

    public final Context getContext() {
        return this.tkContext.getContext();
    }

    public final INativeModule getNativeModule(V8Object v8Object) {
        INativeModule nativeModule = getTKContext().getNativeModule(v8Object);
        if (nativeModule == null && t.isDebug()) {
            throw new RuntimeException("获取 js object 对应的 native 对象返回了 null");
        }
        return nativeModule;
    }

    public final String pn() {
        return pO().pn();
    }

    public final com.tk.core.bridge.b pO() {
        return (com.tk.core.bridge.b) getTKContext();
    }

    public final com.tk.core.bridge.a pP() {
        return pO().pj();
    }

    public final String pq() {
        return pO().pq();
    }

    public final int getVersionCode() {
        TkBundleInfo tkBundleInfoPr = pO().pr();
        if (tkBundleInfoPr == null) {
            return 0;
        }
        return tkBundleInfoPr.mVersionCode;
    }
}
