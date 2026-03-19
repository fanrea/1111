package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface SharpPotentialAPI {
    default void DownloadModel(Context context, Map<String, String> map) {
    }

    default void Free() {
    }

    default int Init(int i, int i2, String str) {
        return -1;
    }

    default int Init(int i, int i2, String str, int i3) {
        return -1;
    }

    default int ProcessAsync(int i, int i2, int i3, long j) {
        return -1;
    }

    default int ProcessOesAsync(int i, int i2, int i3, float[] fArr, long j) {
        return -1;
    }

    default float ProcessOesTexture(int i, int i2, int i3, float[] fArr) {
        return -1.0f;
    }

    default float ProcessTexture(int i, int i2, int i3) {
        return -1.0f;
    }

    default void SetDownloadCallback(SharpPotentialDownloadCallback sharpPotentialDownloadCallback) {
    }

    default void SetProcessCallback(SharpPotentialProcessCallback sharpPotentialProcessCallback) {
    }
}
