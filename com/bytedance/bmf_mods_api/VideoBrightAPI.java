package com.bytedance.bmf_mods_api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface VideoBrightAPI {
    void Free();

    int GetStatus();

    boolean Init(int i, int i2, int i3, int i4);

    int Process(int i, int i2, int i3, int i4, long j);

    void SetCallback(VideoBrightCallbackAPI videoBrightCallbackAPI);
}
