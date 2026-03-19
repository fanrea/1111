package com.kwai.video.ksvodplayerkit.MultiRate;

import com.baidu.mobstat.forbes.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class HlsAdaptationModel_JsonUtils {
    public static HlsAdaptationModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        HlsAdaptationModel hlsAdaptationModel = new HlsAdaptationModel();
        hlsAdaptationModel.version = jSONObject.optString(Config.INPUT_DEF_VERSION, hlsAdaptationModel.version);
        hlsAdaptationModel.type = jSONObject.optString("type", hlsAdaptationModel.type);
        hlsAdaptationModel.adaptationSet = HlsAdaptationSet_JsonUtils.fromJson(jSONObject.optJSONObject("adaptationSet"));
        return hlsAdaptationModel;
    }

    public static HlsAdaptationModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HlsAdaptationModel hlsAdaptationModel = new HlsAdaptationModel();
        hlsAdaptationModel.version = jSONObject.optString(Config.INPUT_DEF_VERSION, hlsAdaptationModel.version);
        hlsAdaptationModel.type = jSONObject.optString("type", hlsAdaptationModel.type);
        hlsAdaptationModel.adaptationSet = HlsAdaptationSet_JsonUtils.fromJson(jSONObject.optJSONObject("adaptationSet"));
        return hlsAdaptationModel;
    }

    public static String toJson(HlsAdaptationModel hlsAdaptationModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.INPUT_DEF_VERSION, hlsAdaptationModel.version);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("type", hlsAdaptationModel.type);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("adaptationSet", HlsAdaptationSet_JsonUtils.toJson(hlsAdaptationModel.adaptationSet));
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
