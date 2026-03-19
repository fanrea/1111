package com.bytedance.bmf_mods_api;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface VideoOCLSRAPI {
    void Free();

    boolean Init(String str, int i, boolean z, int i2, int i3);

    boolean Init(String str, int i, boolean z, int i2, int i3, int i4);

    int OesProcess(int i, int i2, int i3, int i4, float[] fArr, boolean z);

    int Process(int i, int i2, int i3, int i4, boolean z);

    Bitmap Process(Bitmap bitmap, int i, int i2, boolean z);
}
