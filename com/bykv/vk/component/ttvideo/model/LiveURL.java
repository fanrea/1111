package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LiveURL {
    public final String backupURL;
    public final String mainURL;
    public String sdkParams;

    public LiveURL(String str, String str2, String str3) {
        this.mainURL = str;
        this.backupURL = str2;
        this.sdkParams = str3;
    }

    public static LiveURL build(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new LiveURL(jSONObject.optString("main_play_url"), jSONObject.optString("backup_play_url"), jSONObject.optString("SdkParams"));
    }

    public String getVCodec() {
        try {
        } catch (JSONException e) {
            mq.d(e);
        }
        JSONObject jSONObject = this.sdkParams != null ? new JSONObject(this.sdkParams) : null;
        if (jSONObject != null && jSONObject.has("VCodec")) {
            String strOptString = jSONObject.optString("VCodec");
            if (!TextUtils.isEmpty(strOptString)) {
                return strOptString;
            }
        }
        return null;
    }
}
