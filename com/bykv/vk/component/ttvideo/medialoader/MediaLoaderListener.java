package com.bykv.vk.component.ttvideo.medialoader;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface MediaLoaderListener {
    long getInt64Value(int i, long j);

    void onDataLoaderError(int i, String str);

    void onLogInfo(int i, String str, JSONObject jSONObject);

    void onNotify(int i, long j, long j2, String str);

    void onSwitchLoaderType(int i, String str);
}
