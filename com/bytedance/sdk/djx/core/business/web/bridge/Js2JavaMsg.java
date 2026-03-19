package com.bytedance.sdk.djx.core.business.web.bridge;

import android.text.TextUtils;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class Js2JavaMsg {
    private static final String TAG = "Js2JavaMsg";
    public String callbackId;
    public String func;
    public JSONObject params;
    public String version;

    public static Js2JavaMsg parser(String str) {
        try {
            Js2JavaMsg js2JavaMsg = new Js2JavaMsg();
            JSONObject jSONObjectBuild = JSON.build(str);
            js2JavaMsg.callbackId = JSON.getString(jSONObjectBuild, "__callback_id");
            js2JavaMsg.func = JSON.getString(jSONObjectBuild, "func");
            js2JavaMsg.params = JSON.getJsonObject(jSONObjectBuild, "__params");
            js2JavaMsg.version = JSON.getString(jSONObjectBuild, "JSSDK");
            return js2JavaMsg;
        } catch (Throwable th) {
            LG.d(TAG, "js msg parser error: ", th);
            return null;
        }
    }

    private Js2JavaMsg() {
    }

    public boolean isOk() {
        return !TextUtils.isEmpty(this.func);
    }

    public boolean isNeedCallback() {
        return !TextUtils.isEmpty(this.callbackId);
    }
}
