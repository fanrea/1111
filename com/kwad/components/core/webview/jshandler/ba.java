package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ba extends com.kwad.components.core.webview.tachikoma.b.w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void vd() {
        bg("showStart");
    }

    public final void ve() {
        bg("showEnd");
    }

    public final void vf() {
        bg("hideStart");
    }

    public final void vg() {
        bg("hideEnd");
    }

    public final void vh() {
        bg("pageVisiable");
    }

    public final void vi() {
        bg("pageInvisiable");
    }

    private void bg(String str) {
        a aVar = new a();
        aVar.afZ = str;
        b(aVar);
    }

    public static final class a implements com.kwad.sdk.core.b {
        private String afZ;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lifeStatus", this.afZ);
            return jSONObject;
        }
    }
}
