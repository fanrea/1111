package com.kwad.components.ct.c.a;

import com.dhylive.app.utils.JumpParam;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private a aQR;

    public interface a {
        void e(int i, long j);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "loginSuccess";
    }

    public b(a aVar) {
        this.aQR = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("result");
            long jOptLong = jSONObject.optLong(JumpParam.USER_ID);
            a aVar = this.aQR;
            if (aVar != null) {
                aVar.e(iOptInt, jOptLong);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aQR = null;
    }
}
