package com.kwad.components.ct.coupon.bridge;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private Handler aeI = new Handler(Looper.getMainLooper());
    private b anc;
    private com.kwad.components.ct.coupon.bridge.a.b and;
    private com.kwad.sdk.core.webview.c.c sd;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String anf;
    }

    public static final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int ang;
        public String anh;
        public String ani;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "setPageTitlebar";
    }

    public d(com.kwad.components.ct.coupon.bridge.a.b bVar) {
        this.and = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("WebCardSetTitlebarHandler", "WebCardSetTitlebarHandler handleJsCall data=" + str);
        this.sd = cVar;
        b bVar = new b();
        this.anc = bVar;
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        this.aeI.post(new bh() { // from class: com.kwad.components.ct.coupon.bridge.d.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (d.this.and != null) {
                    d.this.and.a(d.this.anc);
                }
            }
        });
    }

    public final void xO() {
        if (this.sd != null) {
            a aVar = new a();
            aVar.anf = "rightBtnClick";
            this.sd.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.and = null;
        this.sd = null;
        this.aeI.removeCallbacksAndMessages(null);
    }
}
