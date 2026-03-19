package com.bytedance.applog;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IPullAbTestConfigCallback {
    void onRemoteConfig(JSONObject jSONObject);

    void onThrottle(long j);

    void onTimeoutError();
}
