package com.bytedance.bmf_mods_api;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface VideoSuperResolutionAPI {
    void Free();

    int GetQueuingTaskNum();

    @Deprecated
    int Init(int i, int i2, int i3, int i4, String str, String str2);

    @Deprecated
    int Init(int i, int i2, int i3, int i4, String str, String str2, String str3);

    int Init(int i, int i2, int i3, int i4, String str, String str2, String str3, int i5, int i6);

    int Init(int i, int i2, int i3, int i4, String str, String str2, String str3, int i5, int i6, int i7);

    Bitmap ProcessBitmap(Bitmap bitmap, int i, int i2) throws BmfException;

    Bitmap ProcessMultiScaleBitmap(Bitmap bitmap, int i, int i2) throws BmfException;

    int ProcessOesTexture(int i, int i2, int i3, float[] fArr);

    int ProcessOesTexture(int i, int i2, int i3, float[] fArr, int i4, int i5, int i6, int i7, int i8, long j);

    int ProcessOesTexture(int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3, boolean z);

    int ProcessTexture(int i, int i2, int i3);

    int ProcessTexture(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    int ProcessYuv420p(long j, long j2, long j3, int i, int i2, int i3, int i4);
}
