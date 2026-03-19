package com.tk.component.d;

import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.a.n;
import com.tk.core.a.o;
import com.tk.core.bridge.IsolatePool;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.network.TKNetErrorInfo;
import com.tk.core.component.network.TKNetResponse;
import com.tk.core.o.ac;
import com.tk.core.o.p;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private Map<String, Object> Ub;
    private volatile boolean Uc;
    private o Ud;
    private long Ue;
    public Map<String, Object> Uf;
    public String Ug;
    public Map<String, String> Uh;
    public int Ui;
    public int Uj;
    public int Uk;
    public boolean Ul;
    public String Um;
    public Map<String, Object> Un;
    public String Uo;
    public String businessName;
    public String method;
    public String url;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Uc = false;
        this.Ud = null;
        this.Ue = 0L;
        this.Uk = 1;
    }

    public final Object ar(V8Function v8Function) {
        this.Uc = false;
        if (this.Uk != 0) {
            nK();
            nL();
        }
        final JsValueRef jsValueRefRetainJsValue = V8Proxy.retainJsValue(v8Function, this);
        p.execute(new Runnable() { // from class: com.tk.component.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.Uc) {
                    return;
                }
                final long[] jArr = new long[1];
                a.this.nK().a(new n() { // from class: com.tk.component.d.a.1.1
                    @Override // com.tk.core.a.n
                    public final void a(TKNetResponse tKNetResponse, TKNetErrorInfo tKNetErrorInfo) {
                        a aVar = a.this;
                        long j = a.this.Ue;
                        long j2 = jArr[0];
                        aVar.a((JsValueRef<V8Function>) jsValueRefRetainJsValue, tKNetResponse, tKNetErrorInfo);
                    }
                });
            }
        });
        return null;
    }

    public final void cancel() {
        if (this.Uc) {
            return;
        }
        this.Uc = true;
        nK().cancel();
    }

    public final Object as(V8Function v8Function) {
        this.Uc = false;
        if (this.Uk != 0) {
            nK();
            nL();
        }
        final JsValueRef jsValueRefRetainJsValue = V8Proxy.retainJsValue(v8Function, this);
        p.execute(new Runnable() { // from class: com.tk.component.d.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.Uc) {
                    return;
                }
                final long[] jArr = new long[1];
                a.this.nK();
                new n() { // from class: com.tk.component.d.a.2.1
                    @Override // com.tk.core.a.n
                    public final void a(TKNetResponse tKNetResponse, TKNetErrorInfo tKNetErrorInfo) {
                        a aVar = a.this;
                        long j = a.this.Ue;
                        long j2 = jArr[0];
                        aVar.a((JsValueRef<V8Function>) jsValueRefRetainJsValue, tKNetResponse, tKNetErrorInfo);
                    }
                };
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final JsValueRef<V8Function> jsValueRef, TKNetResponse tKNetResponse, TKNetErrorInfo tKNetErrorInfo) {
        if (jsValueRef == null || (tKNetResponse == null && tKNetErrorInfo == null)) {
            com.tk.core.i.a.z("tachikoma", "response is null and errorInfo is null");
            return;
        }
        final String json = tKNetResponse != null ? tKNetResponse.toJson() : "";
        final String json2 = tKNetErrorInfo != null ? tKNetErrorInfo.toJson() : "";
        if (pO().po()) {
            IsolatePool.a(false, pO().pj().getBindingIsolateRef()).execute(new Runnable() { // from class: com.tk.component.d.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a(json, json2, (JsValueRef<V8Function>) jsValueRef);
                }
            });
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.d.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a(json, json2, (JsValueRef<V8Function>) jsValueRef);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, JsValueRef<V8Function> jsValueRef) {
        if (this.Uc) {
            return;
        }
        try {
            if (V8Proxy.isV8Valid(jsValueRef.get())) {
                jsValueRef.get().call(null, str, str2);
            }
            V8Proxy.unRetainJsValue(jsValueRef);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    public final void setUrl(String str) {
        nK().setUrl(str);
    }

    public final void setMethod(String str) {
        nK().setMethod(str);
    }

    public final void b(Map<String, Object> map) {
        nK().b(map);
    }

    public final void v(String str) {
        nK().v(str);
    }

    public final void c(Map<String, String> map) {
        nK().c(map);
    }

    public final void setTimeout(int i) {
        nK().setTimeout(i);
    }

    public final void setBusinessName(String str) {
        nK().setBusinessName(str);
    }

    public final void ce(int i) {
        nK().ce(i);
    }

    public final void ae(boolean z) {
        nK();
    }

    public final void aT(String str) {
        nK();
    }

    public final void e(Map<String, Object> map) {
        nK();
    }

    public final void aU(String str) {
        nK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o nK() {
        if (this.Ud == null) {
            this.Ud = com.tk.core.a.oP().oU().hX();
        }
        return this.Ud;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        cancel();
    }

    private Map<String, Object> nL() {
        if (this.Ub == null) {
            this.Ub = new HashMap();
            TkBundleInfo tkBundleInfoPr = pO().pr();
            if (tkBundleInfoPr != null) {
                this.Ub.put("tkBundleId", tkBundleInfoPr.mBundleId);
                this.Ub.put("tkBundleVersionCode", Integer.valueOf(tkBundleInfoPr.mVersionCode));
            }
        }
        return this.Ub;
    }
}
