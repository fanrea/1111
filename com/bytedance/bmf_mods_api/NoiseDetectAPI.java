package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface NoiseDetectAPI {
    void DownloadModel(Context context, Map<String, String> map);

    void Free();

    int Init(int i, int i2, boolean z, String str);

    float Process(int i, int i2, int i3);

    void SetCallback(NoiseDetectCallbackAPI noiseDetectCallbackAPI);
}
