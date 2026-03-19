package com.bytedance.applog;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IPresetEventObserver {
    void onLaunch(JSONObject jSONObject);

    void onPageEnter(JSONObject jSONObject);

    void onPageLeave(JSONObject jSONObject);
}
