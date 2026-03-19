package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.m;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject bGe;
    private String appId;
    private String bGf;
    private String name;
    private String packageName;
    private String version;
    private int versionCode;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public static JSONObject abA() {
        if (!o(bGe)) {
            bGe = abB().toJson();
        }
        return bGe;
    }

    public static a abB() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.getSDKConfig().appId;
            aVar.name = ServiceProvider.getSDKConfig().appName;
            aVar.packageName = ServiceProvider.anu().getPackageName();
            aVar.version = m.dc(ServiceProvider.anu());
            aVar.versionCode = m.de(ServiceProvider.anu());
            aVar.bGf = com.kwad.sdk.utils.f.cQ(ServiceProvider.anu());
            if (!TextUtils.isEmpty(bt.getAppId())) {
                aVar.appId = bt.getAppId();
            }
            if (!TextUtils.isEmpty(bt.getPackageName())) {
                aVar.packageName = bt.getPackageName();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aVar;
    }

    private static boolean o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("appId");
        String strOptString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString) && strOptString.equals(ServiceProvider.getSDKConfig().appId) && strOptString2.equals(ServiceProvider.getSDKConfig().appName);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "appId", this.appId);
        aa.putValue(jSONObject, "name", this.name);
        aa.putValue(jSONObject, "packageName", this.packageName);
        aa.putValue(jSONObject, Config.INPUT_DEF_VERSION, this.version);
        aa.putValue(jSONObject, "versionCode", this.versionCode);
        aa.putValue(jSONObject, "sha1", this.bGf);
        return jSONObject;
    }
}
