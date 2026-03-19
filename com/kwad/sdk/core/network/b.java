package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b implements f {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    protected abstract void buildBaseBody();

    protected abstract void buildBaseHeader();

    protected boolean enableCrashReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    protected void onCreate() {
    }

    protected b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader("cookie", com.kwad.sdk.core.response.b.f.abL().abM());
            com.kwad.sdk.core.a.d.j(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.aar());
            addHeader("SystemUa", p.aaq());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    protected void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHeader.put(str, str2);
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        aa.putValue(jSONObject, Config.INPUT_DEF_VERSION, fVar.getSDKVersion());
        if (!TextUtils.isEmpty(bt.getAppId())) {
            aa.putValue(jSONObject, "appId", bt.getAppId());
        } else {
            aa.putValue(jSONObject, "appId", fVar.getAppId());
        }
        aa.putValue(jSONObject, cm.V, com.kwad.sdk.core.a.d.ax(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    protected String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.g.encryptDisable();
    }

    protected String getRequestHost() {
        return com.kwad.sdk.h.SV();
    }

    public void putBody(String str, String str2) {
        aa.putValue(this.mBodyParams, str, str2);
    }

    public void putBody(String str, double d) {
        aa.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, int i) {
        aa.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, float f) {
        aa.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, byte b) {
        aa.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, long j) {
        aa.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, boolean z) {
        aa.putValue(this.mBodyParams, str, z);
    }

    public void putBody(String str, JSONObject jSONObject) {
        aa.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        aa.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        aa.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        aa.putValue(this.mBodyParams, str, list);
    }
}
