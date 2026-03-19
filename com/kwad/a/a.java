package com.kwad.a;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class a<T> {
    protected abstract T hv();

    public final void a(V8Function v8Function) {
        final JsValueRef jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        OfflineHostProvider.getApi().async().execute(new Runnable() { // from class: com.kwad.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                final Object objHv;
                try {
                    objHv = a.this.hv();
                } catch (Throwable unused) {
                    objHv = null;
                }
                OfflineHostProvider.getApi().async().runOnUiThread(new Runnable() { // from class: com.kwad.a.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        if (com.kwad.tachikoma.t.b.b(jsValueRefRetainJsValue)) {
                            ((V8Function) jsValueRefRetainJsValue.get()).call(null, objHv);
                        }
                    }
                });
            }
        });
    }
}
