package com.kwad.tachikoma.f;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.tachikoma.l.c;
import com.kwad.tachikoma.l.e;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private static AtomicInteger Bt = new AtomicInteger(1);
    private e Cf;
    private g Cg;
    private g Ch;
    private int Ci;
    private String Cj;
    private boolean Ck;
    private String mViewKey;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Ck = false;
        this.Ci = Bt.incrementAndGet();
    }

    public final void q(String str) {
        this.Cj = str;
    }

    public final void setViewKey(String str) {
        this.mViewKey = str;
    }

    private void g(V8Function v8Function) {
        g gVar = this.Cg;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Cg = new g(v8Function, pO());
    }

    public final void i(V8Object v8Object) {
        e eVar = (e) getNativeModule(v8Object);
        eVar.pL();
        this.Cf = eVar;
    }

    public final void h(V8Function v8Function) {
        g gVar = this.Ch;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Ch = new g(v8Function, pO());
    }

    public final void i(V8Function v8Function) {
        g(v8Function);
        ii().a(this);
    }

    public final void dismiss() {
        ii().b(this);
    }

    public final void I(boolean z) {
        this.Ck = z;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        g gVar = this.Ch;
        if (gVar != null) {
            gVar.destroy();
        }
        g gVar2 = this.Cg;
        if (gVar2 != null) {
            gVar2.destroy();
        }
    }

    private com.kwad.tachikoma.e.e ii() {
        return (com.kwad.tachikoma.e.e) pO().getGlobalNativeObject("KSAdNativeContext");
    }

    public final int getDialogId() {
        return this.Ci;
    }

    public final String getViewKey() {
        return this.mViewKey;
    }

    public final String getTemplateString() {
        return this.Cj;
    }

    public final boolean isHideNavigationBar() {
        return this.Ck;
    }

    public final void callbackPageStatus(boolean z, String str) {
        g gVar = this.Cg;
        if (gVar != null) {
            gVar.call(null, Boolean.valueOf(z), str);
        }
    }

    public final void callbackDialogDismiss() {
        g gVar = this.Ch;
        if (gVar != null) {
            gVar.call(null, new Object[0]);
        }
    }

    public final void callTKBridge(String str) {
        e eVar = this.Cf;
        if (eVar != null) {
            eVar.callAdBridge(str);
        }
    }

    public final void a(c cVar) {
        e eVar = this.Cf;
        if (eVar != null) {
            eVar.a(cVar);
        }
    }
}
