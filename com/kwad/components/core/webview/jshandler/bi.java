package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bi implements com.kwad.sdk.core.webview.c.a {
    private Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aeJ;
    private b agn;

    public interface b {
        void bd(boolean z);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "setViewPagerEnabled";
    }

    public bi(b bVar) {
        this.agn = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bi.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    bi biVar = bi.this;
                    boolean z = true;
                    if (aVar.agp != 1) {
                        z = false;
                    }
                    biVar.bc(z);
                    if (bi.this.aeJ != null) {
                        bi.this.aeJ.a(null);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (bi.this.aeJ != null) {
                        bi.this.aeJ.onError(-1, e.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agn = null;
        this.aeJ = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(boolean z) {
        b bVar = this.agn;
        if (bVar != null) {
            bVar.bd(z);
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        private int agp;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.agp = jSONObject.optInt("scrollEnabled");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "scrollEnabled", this.agp);
            return jSONObject;
        }
    }
}
