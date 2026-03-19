package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.SitiAPI;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Siti implements SitiAPI {
    private long mNativePtr = 0;
    private int mAlgType = -1;

    private native long nativeCreateHydraSiti();

    private native int nativeHydraSitiGetResult(long j, double[] dArr, double[] dArr2);

    private native int nativeHydraSitiProcessTexture(long j, int i, int i2, int i3, boolean z);

    private native int nativeInitHydraSiti(long j, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private native void nativeReleaseHydraSiti(long j);

    public Siti() {
        Logging.d("New Siti");
    }

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public int Init(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        this.mAlgType = i;
        if (i != 11 || i6 != 3) {
            Logging.d("Siti: alg_type range is [11,11],backend is [3,3] ");
            return -1;
        }
        long jNativeCreateHydraSiti = nativeCreateHydraSiti();
        this.mNativePtr = jNativeCreateHydraSiti;
        if (jNativeCreateHydraSiti == 0) {
            return -1;
        }
        return nativeInitHydraSiti(jNativeCreateHydraSiti, str, i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public int ProcessTexture(int i, int i2, int i3, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            return -1;
        }
        return nativeHydraSitiProcessTexture(j, i, i2, i3, z);
    }

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public int GetResult(double[] dArr, double[] dArr2) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            return -1;
        }
        return nativeHydraSitiGetResult(j, dArr, dArr2);
    }

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public void Free() {
        long j = this.mNativePtr;
        if (j == 0) {
            return;
        }
        nativeReleaseHydraSiti(j);
    }
}
