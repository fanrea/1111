package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class g implements m {
    protected abstract void a(y yVar);

    protected abstract void bU();

    protected abstract void bV();

    protected abstract void bW();

    protected abstract void bX();

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                final y yVar = new y();
                if (objArr[0] instanceof String) {
                    yVar.parseJson(new JSONObject((String) objArr[0]));
                    bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.a.g.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            if (yVar.wb()) {
                                g.this.bX();
                                return;
                            }
                            if (yVar.wd()) {
                                return;
                            }
                            if (yVar.we()) {
                                g.this.bV();
                                return;
                            }
                            if (yVar.wf()) {
                                g.this.bU();
                            } else if (yVar.wc()) {
                                g.this.bW();
                            } else if (yVar.isFailed()) {
                                g.this.a(yVar);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
