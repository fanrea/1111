package com.kwad.components.core.webview.tachikoma.a;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class b implements m {
    private Handler aeI = new Handler(Looper.getMainLooper());

    public abstract void c(WebCloseStatus webCloseStatus);

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        try {
            final WebCloseStatus webCloseStatus = new WebCloseStatus();
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof String) {
                    webCloseStatus.parseJson(new JSONObject((String) obj));
                }
            }
            this.aeI.post(new bh() { // from class: com.kwad.components.core.webview.tachikoma.a.b.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.this.c(webCloseStatus);
                }
            });
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }
}
