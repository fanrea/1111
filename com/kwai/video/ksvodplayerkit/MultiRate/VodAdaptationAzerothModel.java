package com.kwai.video.ksvodplayerkit.MultiRate;

import com.kuaishou.socket.nano.SocketMessages;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VodAdaptationAzerothModel {
    public int rateType = 0;
    public int bwEstimationType = 0;
    public int absLowResLowDevice = 0;
    public int adaptUnder4G = 1;
    public int adaptUnderWifi = 1;
    public double adaptUnderOtherNet = 1.0d;
    public int absLowRate4G = 0;
    public int absLowRateWifi = 0;
    public double absLowRes4G = 0.0d;
    public double absLowResWifi = 0.0d;
    public double shortKeepInterval = 60000.0d;
    public int longKeepInterval = 600000;
    public int bitrateInitLevel = 0;
    public double defaultWeight = 1.0d;
    public double blockAffectedInterval = 10000.0d;
    public double wifiAmend = 0.7d;
    public double fourGAmend = 0.3d;
    public double resAmend = 0.6d;
    public double deviceWidthTHR = 720.0d;
    public int deviceHightTHR = SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE;
    public int priorityPolicy = 1;
    public double wifiAmend1080P = 0.8d;
    public int enableLowResAuto = 1;
    public int shortKeepIntervalWifi = 60000;
    public int longKeepIntervalWifi = 600000;

    public String getVodAdaptiveJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate_adapt_type", this.rateType);
            jSONObject.put("bandwidth_estimation_type", this.bwEstimationType);
            jSONObject.put("absolute_low_res_low_device", this.absLowResLowDevice);
            jSONObject.put("adapt_under_4G", this.adaptUnder4G);
            jSONObject.put("adapt_under_wifi", this.adaptUnderWifi);
            jSONObject.put("adapt_under_other_net", this.adaptUnderOtherNet);
            jSONObject.put("absolute_low_rate_4G", this.absLowRate4G);
            jSONObject.put("absolute_low_rate_wifi", this.absLowRateWifi);
            jSONObject.put("absolute_low_res_4G", this.absLowRes4G);
            jSONObject.put("absolute_low_res_wifi", this.absLowResWifi);
            jSONObject.put("short_keep_interval", this.shortKeepInterval);
            jSONObject.put("long_keep_interval", this.longKeepInterval);
            jSONObject.put("short_keep_interval_wifi", this.shortKeepIntervalWifi);
            jSONObject.put("long_keep_interval_wifi", this.longKeepIntervalWifi);
            jSONObject.put("bitrate_init_level", this.bitrateInitLevel);
            jSONObject.put("default_weight", this.defaultWeight);
            jSONObject.put("block_affected_interval", this.blockAffectedInterval);
            jSONObject.put("wifi_amend", this.wifiAmend);
            jSONObject.put("fourG_amend", this.fourGAmend);
            jSONObject.put("resolution_amend", this.resAmend);
            jSONObject.put("device_width_threshold", this.deviceWidthTHR);
            jSONObject.put("device_hight_threshold", this.deviceHightTHR);
            jSONObject.put("priority_policy", this.priorityPolicy);
            jSONObject.put("enable_low_res_auto", this.enableLowResAuto);
            jSONObject.put("wifi_amend_1080p", this.wifiAmend1080P);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
