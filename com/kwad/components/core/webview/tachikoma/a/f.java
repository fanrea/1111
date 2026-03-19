package com.kwad.components.core.webview.tachikoma.a;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class f implements m {
    private Handler aeI = new Handler(Looper.getMainLooper());

    protected abstract void a(am.a aVar);

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    final am.a aVar = new am.a();
                    aVar.parseJson(objArr[0] instanceof String ? new JSONObject((String) objArr[0]) : null);
                    this.aeI.post(new bh() { // from class: com.kwad.components.core.webview.tachikoma.a.f.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            f.this.a(aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        return null;
    }
}
