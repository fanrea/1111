package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.c;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class TkLoggerReporter {

    static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter();

        private Holder() {
        }
    }

    private TkLoggerReporter() {
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, c cVar) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(cVar);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Wz().dW(str).l(0.1d).V("ad_tk_download_performance", "download_state").l(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Wz().dW(str).l(0.1d).V("ad_tk_so_download_event", "download_state").l(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Wz().dW(str).l(0.1d).V("ad_tk_so_load_performence", "download_state").l(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Wz().dW(str).l(0.1d).n(0.001d).V("ad_tk_render_performance", "render_state").l(jSONObject));
    }
}
