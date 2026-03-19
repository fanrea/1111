package com.kwai.video.ksvodplayerkit.MultiRate;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class VodAdaptationAzerothModel_JsonUtils {
    public static VodAdaptationAzerothModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        VodAdaptationAzerothModel vodAdaptationAzerothModel = new VodAdaptationAzerothModel();
        vodAdaptationAzerothModel.rateType = jSONObject.optInt("rateType", vodAdaptationAzerothModel.rateType);
        vodAdaptationAzerothModel.bwEstimationType = jSONObject.optInt("bwEstimateType", vodAdaptationAzerothModel.bwEstimationType);
        vodAdaptationAzerothModel.absLowResLowDevice = jSONObject.optInt("absLowResLowDevice", vodAdaptationAzerothModel.absLowResLowDevice);
        vodAdaptationAzerothModel.adaptUnder4G = jSONObject.optInt("adapt4G", vodAdaptationAzerothModel.adaptUnder4G);
        vodAdaptationAzerothModel.adaptUnderWifi = jSONObject.optInt("adaptWifi", vodAdaptationAzerothModel.adaptUnderWifi);
        vodAdaptationAzerothModel.adaptUnderOtherNet = jSONObject.optDouble("adaptOtherNet", vodAdaptationAzerothModel.adaptUnderOtherNet);
        vodAdaptationAzerothModel.absLowRate4G = jSONObject.optInt("absLowRate4G", vodAdaptationAzerothModel.absLowRate4G);
        vodAdaptationAzerothModel.absLowRateWifi = jSONObject.optInt("absLowRateWifi", vodAdaptationAzerothModel.absLowRateWifi);
        vodAdaptationAzerothModel.absLowRes4G = jSONObject.optDouble("absLowRes4G", vodAdaptationAzerothModel.absLowRes4G);
        vodAdaptationAzerothModel.absLowResWifi = jSONObject.optDouble("absLowResWifi", vodAdaptationAzerothModel.absLowResWifi);
        vodAdaptationAzerothModel.shortKeepInterval = jSONObject.optDouble("shortKeepInterval", vodAdaptationAzerothModel.shortKeepInterval);
        vodAdaptationAzerothModel.longKeepInterval = jSONObject.optInt("longKeepInterval", vodAdaptationAzerothModel.longKeepInterval);
        vodAdaptationAzerothModel.bitrateInitLevel = jSONObject.optInt("bitrateInitLevel", vodAdaptationAzerothModel.bitrateInitLevel);
        vodAdaptationAzerothModel.defaultWeight = jSONObject.optDouble("weight", vodAdaptationAzerothModel.defaultWeight);
        vodAdaptationAzerothModel.blockAffectedInterval = jSONObject.optDouble("blockAffectedIntervalMs", vodAdaptationAzerothModel.blockAffectedInterval);
        vodAdaptationAzerothModel.wifiAmend = jSONObject.optDouble("wifiAmend", vodAdaptationAzerothModel.wifiAmend);
        vodAdaptationAzerothModel.fourGAmend = jSONObject.optDouble("fourGAmend", vodAdaptationAzerothModel.fourGAmend);
        vodAdaptationAzerothModel.resAmend = jSONObject.optDouble("resAmend", vodAdaptationAzerothModel.resAmend);
        vodAdaptationAzerothModel.deviceWidthTHR = jSONObject.optDouble("devWidthTh", vodAdaptationAzerothModel.deviceWidthTHR);
        vodAdaptationAzerothModel.deviceHightTHR = jSONObject.optInt("devHeightTh", vodAdaptationAzerothModel.deviceHightTHR);
        vodAdaptationAzerothModel.priorityPolicy = jSONObject.optInt("priorityPolicy", vodAdaptationAzerothModel.priorityPolicy);
        vodAdaptationAzerothModel.wifiAmend1080P = jSONObject.optDouble("wifiAmend1080P", vodAdaptationAzerothModel.wifiAmend1080P);
        vodAdaptationAzerothModel.enableLowResAuto = jSONObject.optInt("enableLowResAuto", vodAdaptationAzerothModel.enableLowResAuto);
        vodAdaptationAzerothModel.shortKeepIntervalWifi = jSONObject.optInt("shortKeepIntervalWifi", vodAdaptationAzerothModel.shortKeepIntervalWifi);
        vodAdaptationAzerothModel.longKeepIntervalWifi = jSONObject.optInt("longKeepIntervalWifi", vodAdaptationAzerothModel.longKeepIntervalWifi);
        return vodAdaptationAzerothModel;
    }

    public static VodAdaptationAzerothModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VodAdaptationAzerothModel vodAdaptationAzerothModel = new VodAdaptationAzerothModel();
        vodAdaptationAzerothModel.rateType = jSONObject.optInt("rateType", vodAdaptationAzerothModel.rateType);
        vodAdaptationAzerothModel.bwEstimationType = jSONObject.optInt("bwEstimateType", vodAdaptationAzerothModel.bwEstimationType);
        vodAdaptationAzerothModel.absLowResLowDevice = jSONObject.optInt("absLowResLowDevice", vodAdaptationAzerothModel.absLowResLowDevice);
        vodAdaptationAzerothModel.adaptUnder4G = jSONObject.optInt("adapt4G", vodAdaptationAzerothModel.adaptUnder4G);
        vodAdaptationAzerothModel.adaptUnderWifi = jSONObject.optInt("adaptWifi", vodAdaptationAzerothModel.adaptUnderWifi);
        vodAdaptationAzerothModel.adaptUnderOtherNet = jSONObject.optDouble("adaptOtherNet", vodAdaptationAzerothModel.adaptUnderOtherNet);
        vodAdaptationAzerothModel.absLowRate4G = jSONObject.optInt("absLowRate4G", vodAdaptationAzerothModel.absLowRate4G);
        vodAdaptationAzerothModel.absLowRateWifi = jSONObject.optInt("absLowRateWifi", vodAdaptationAzerothModel.absLowRateWifi);
        vodAdaptationAzerothModel.absLowRes4G = jSONObject.optDouble("absLowRes4G", vodAdaptationAzerothModel.absLowRes4G);
        vodAdaptationAzerothModel.absLowResWifi = jSONObject.optDouble("absLowResWifi", vodAdaptationAzerothModel.absLowResWifi);
        vodAdaptationAzerothModel.shortKeepInterval = jSONObject.optDouble("shortKeepInterval", vodAdaptationAzerothModel.shortKeepInterval);
        vodAdaptationAzerothModel.longKeepInterval = jSONObject.optInt("longKeepInterval", vodAdaptationAzerothModel.longKeepInterval);
        vodAdaptationAzerothModel.bitrateInitLevel = jSONObject.optInt("bitrateInitLevel", vodAdaptationAzerothModel.bitrateInitLevel);
        vodAdaptationAzerothModel.defaultWeight = jSONObject.optDouble("weight", vodAdaptationAzerothModel.defaultWeight);
        vodAdaptationAzerothModel.blockAffectedInterval = jSONObject.optDouble("blockAffectedIntervalMs", vodAdaptationAzerothModel.blockAffectedInterval);
        vodAdaptationAzerothModel.wifiAmend = jSONObject.optDouble("wifiAmend", vodAdaptationAzerothModel.wifiAmend);
        vodAdaptationAzerothModel.fourGAmend = jSONObject.optDouble("fourGAmend", vodAdaptationAzerothModel.fourGAmend);
        vodAdaptationAzerothModel.resAmend = jSONObject.optDouble("resAmend", vodAdaptationAzerothModel.resAmend);
        vodAdaptationAzerothModel.deviceWidthTHR = jSONObject.optDouble("devWidthTh", vodAdaptationAzerothModel.deviceWidthTHR);
        vodAdaptationAzerothModel.deviceHightTHR = jSONObject.optInt("devHeightTh", vodAdaptationAzerothModel.deviceHightTHR);
        vodAdaptationAzerothModel.priorityPolicy = jSONObject.optInt("priorityPolicy", vodAdaptationAzerothModel.priorityPolicy);
        vodAdaptationAzerothModel.wifiAmend1080P = jSONObject.optDouble("wifiAmend1080P", vodAdaptationAzerothModel.wifiAmend1080P);
        vodAdaptationAzerothModel.enableLowResAuto = jSONObject.optInt("enableLowResAuto", vodAdaptationAzerothModel.enableLowResAuto);
        vodAdaptationAzerothModel.shortKeepIntervalWifi = jSONObject.optInt("shortKeepIntervalWifi", vodAdaptationAzerothModel.shortKeepIntervalWifi);
        vodAdaptationAzerothModel.longKeepIntervalWifi = jSONObject.optInt("longKeepIntervalWifi", vodAdaptationAzerothModel.longKeepIntervalWifi);
        return vodAdaptationAzerothModel;
    }

    public static String toJson(VodAdaptationAzerothModel vodAdaptationAzerothModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rateType", vodAdaptationAzerothModel.rateType);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("bwEstimateType", vodAdaptationAzerothModel.bwEstimationType);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("absLowResLowDevice", vodAdaptationAzerothModel.absLowResLowDevice);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("adapt4G", vodAdaptationAzerothModel.adaptUnder4G);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("adaptWifi", vodAdaptationAzerothModel.adaptUnderWifi);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("adaptOtherNet", vodAdaptationAzerothModel.adaptUnderOtherNet);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("absLowRate4G", vodAdaptationAzerothModel.absLowRate4G);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("absLowRateWifi", vodAdaptationAzerothModel.absLowRateWifi);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("absLowRes4G", vodAdaptationAzerothModel.absLowRes4G);
        } catch (Exception unused9) {
        }
        try {
            jSONObject.put("absLowResWifi", vodAdaptationAzerothModel.absLowResWifi);
        } catch (Exception unused10) {
        }
        try {
            jSONObject.put("shortKeepInterval", vodAdaptationAzerothModel.shortKeepInterval);
        } catch (Exception unused11) {
        }
        try {
            jSONObject.put("longKeepInterval", vodAdaptationAzerothModel.longKeepInterval);
        } catch (Exception unused12) {
        }
        try {
            jSONObject.put("bitrateInitLevel", vodAdaptationAzerothModel.bitrateInitLevel);
        } catch (Exception unused13) {
        }
        try {
            jSONObject.put("weight", vodAdaptationAzerothModel.defaultWeight);
        } catch (Exception unused14) {
        }
        try {
            jSONObject.put("blockAffectedIntervalMs", vodAdaptationAzerothModel.blockAffectedInterval);
        } catch (Exception unused15) {
        }
        try {
            jSONObject.put("wifiAmend", vodAdaptationAzerothModel.wifiAmend);
        } catch (Exception unused16) {
        }
        try {
            jSONObject.put("fourGAmend", vodAdaptationAzerothModel.fourGAmend);
        } catch (Exception unused17) {
        }
        try {
            jSONObject.put("resAmend", vodAdaptationAzerothModel.resAmend);
        } catch (Exception unused18) {
        }
        try {
            jSONObject.put("devWidthTh", vodAdaptationAzerothModel.deviceWidthTHR);
        } catch (Exception unused19) {
        }
        try {
            jSONObject.put("devHeightTh", vodAdaptationAzerothModel.deviceHightTHR);
        } catch (Exception unused20) {
        }
        try {
            jSONObject.put("priorityPolicy", vodAdaptationAzerothModel.priorityPolicy);
        } catch (Exception unused21) {
        }
        try {
            jSONObject.put("wifiAmend1080P", vodAdaptationAzerothModel.wifiAmend1080P);
        } catch (Exception unused22) {
        }
        try {
            jSONObject.put("enableLowResAuto", vodAdaptationAzerothModel.enableLowResAuto);
        } catch (Exception unused23) {
        }
        try {
            jSONObject.put("shortKeepIntervalWifi", vodAdaptationAzerothModel.shortKeepIntervalWifi);
        } catch (Exception unused24) {
        }
        try {
            jSONObject.put("longKeepIntervalWifi", vodAdaptationAzerothModel.longKeepIntervalWifi);
        } catch (Exception unused25) {
        }
        return jSONObject.toString();
    }
}
