package com.bytedance.sdk.djx.core.business.web.bridge;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class Java2jsMsg {
    public String callbackId;
    public int code = 0;
    public String func;
    public JSONObject params;

    public static Java2jsMsg create() {
        return new Java2jsMsg();
    }

    private Java2jsMsg() {
    }

    public Java2jsMsg setCode(int i) {
        this.code = i;
        return this;
    }

    public Java2jsMsg setCallbackId(String str) {
        this.callbackId = str;
        return this;
    }

    public Java2jsMsg setParams(JSONObject jSONObject) {
        this.params = jSONObject;
        return this;
    }

    public Java2jsMsg putParam(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.params == null) {
                this.params = new JSONObject();
            }
            try {
                this.params.putOpt(str, obj);
            } catch (Throwable unused) {
            }
        }
        return this;
    }

    public void send(DJXBridge dJXBridge) {
        if (dJXBridge != null) {
            dJXBridge.send(toJsonString());
        }
    }

    public void sendOn(String str, DJXBridge dJXBridge) {
        if (dJXBridge != null) {
            this.func = str;
            dJXBridge.sendOn(str, this);
        }
    }

    public String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.code);
            jSONObject.put("__callback_id", this.callbackId);
            jSONObject.put("__params", this.params);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
