package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface VqscoreLiveAPI {
    void DownloadModel(Context context, Map<String, String> map);

    void Free();

    int Init(int i, int i2, int i3, int i4, boolean z, String str, int i5);

    @Deprecated
    int Init(int i, int i2, boolean z, String str);

    @Deprecated
    int Init(int i, int i2, boolean z, String str, int i3);

    @Deprecated
    int Init(int i, boolean z);

    float Process(int i, int i2, int i3);

    int ProcessAsync(int i, int i2, int i3, long j);

    int ProcessOesAsync(int i, int i2, int i3, float[] fArr, long j);

    @Deprecated
    void SetCallback(VqscoreLiveCallbackAPI vqscoreLiveCallbackAPI);

    void SetDownloadCallback(VqscoreLiveCallbackAPI vqscoreLiveCallbackAPI);

    void SetProcessCallback(VqscoreProcessCallbackAPI vqscoreProcessCallbackAPI);
}
