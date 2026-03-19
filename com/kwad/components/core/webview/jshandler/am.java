package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class am implements com.kwad.sdk.core.webview.c.a {
    private final WebView UO;
    private Handler aeI;
    private com.kwad.sdk.core.webview.c.c aeJ;
    private boolean afq;
    private b gG;

    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "initKsAdFrame";
    }

    public am(com.kwad.sdk.core.webview.b bVar, b bVar2) {
        this(bVar, bVar2, true);
    }

    public am(com.kwad.sdk.core.webview.b bVar, b bVar2, boolean z) {
        this.afq = true;
        this.aeI = new Handler(Looper.getMainLooper());
        this.UO = bVar.UO;
        this.gG = bVar2;
        this.afq = z;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.am.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (am.this.UO != null && am.this.afq) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) am.this.UO.getLayoutParams();
                        marginLayoutParams.width = -1;
                        marginLayoutParams.height = aVar.height;
                        marginLayoutParams.leftMargin = aVar.leftMargin;
                        marginLayoutParams.rightMargin = aVar.rightMargin;
                        marginLayoutParams.bottomMargin = aVar.bottomMargin;
                        am.this.UO.setLayoutParams(marginLayoutParams);
                    }
                    if (am.this.gG != null) {
                        am.this.gG.a(aVar);
                    }
                }
            });
            this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.am.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (am.this.aeJ != null) {
                        am.this.aeJ.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeJ = null;
        this.gG = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }
}
