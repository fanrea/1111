package com.bytedance.bmf_mods_api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface DenoiseAPI {
    void Free();

    int[] GetReport();

    int GetResult();

    int Init(int i, int i2, int i3, int i4, int i5, int i6, boolean z, String str, int i7, int i8, int i9, int i10, int i11);

    int Init(int i, int i2, int i3, boolean z, String str, int i4, int i5, int i6, int i7);

    int ProcessOesTexture(int i, int i2, int i3, float[] fArr, int i4, boolean z);

    int ProcessTexture(int i, int i2, int i3, int i4, boolean z);

    int ProcessTexture(int i, boolean z, int i2, int i3, float[] fArr, int i4, boolean z2, int i5);
}
