package com.bytedance.bmf_mods_api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface VideoSRLutAPI {
    int AsyncProcess(int i, int i2, int i3, int i4, boolean z);

    int AsyncWait();

    int ClearClBuffer();

    void Free();

    boolean GlSrInit(String str, int i, boolean z, int i2, int i3);

    boolean Init(int i);

    boolean Init(String str, int i, boolean z, int i2, int i3);

    boolean Init(String str, int i, boolean z, int i2, int i3, String str2);

    int Process(int i, int i2, int i3, int i4, boolean z);

    int Process(long j, long j2, long j3, int i, int i2, int i3, int i4);
}
