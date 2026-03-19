package com.kwad.tachikoma.l;

import android.webkit.JavascriptInterface;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.tachikoma.t.i;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends TKBaseNativeModule {
    private JsValueRef<V8Function> CR;
    private c CS;

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void o(V8Function v8Function) {
        if (com.kwad.tachikoma.t.b.b(this.CR)) {
            ad.unRetainJsValue(this.CR);
        }
        this.CR = ad.retainJsValue(v8Function, this);
    }

    public final void callJS(String str) {
        c cVar = this.CS;
        if (cVar != null) {
            cVar.callJS(str);
        }
    }

    public final void a(c cVar) {
        this.CS = cVar;
    }

    @JavascriptInterface
    public final void callAdBridge(final String str) {
        if (str != null || str.length() > 0) {
            i.runOnUiThread(new Runnable() { // from class: com.kwad.tachikoma.l.e.1
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    if (com.kwad.tachikoma.t.b.b(e.this.CR)) {
                        ((V8Function) e.this.CR.get()).call(null, str);
                    }
                }
            });
        }
    }
}
