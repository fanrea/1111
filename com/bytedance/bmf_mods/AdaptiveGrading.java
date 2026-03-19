package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.AdaptiveGradingAPI;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdaptiveGrading implements AdaptiveGradingAPI {
    private long mNativePtr = 0;

    private native int nativeAdaptiveGradingGetResultTexture(long j);

    private native int nativeAdaptiveGradingOesProcess(long j, int i, int i2, int i3, float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, boolean z);

    private native int nativeAdaptiveGradingProcess(long j, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, boolean z);

    private native long nativeCreateAdaptiveGrading();

    private native int nativeInitAdaptiveGrading(long j, int i, int i2, String str, float[] fArr, float[] fArr2, float[] fArr3);

    private native void nativeReleaseAdaptiveGrading(long j);

    public AdaptiveGrading() {
        Logging.d("New AdaptiveGrading");
    }

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public int Init(int i, int i2, String str, float[] fArr, float[] fArr2, float[] fArr3) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long jNativeCreateAdaptiveGrading = nativeCreateAdaptiveGrading();
        this.mNativePtr = jNativeCreateAdaptiveGrading;
        if (jNativeCreateAdaptiveGrading == 0) {
            return -1;
        }
        return nativeInitAdaptiveGrading(jNativeCreateAdaptiveGrading, i, i2, str, fArr, fArr2, fArr3);
    }

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public int ProcessTexture(int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            return -1;
        }
        int iNativeAdaptiveGradingProcess = nativeAdaptiveGradingProcess(j, i, i2, i3, f, f2, f3, f4, f5, f6, z);
        return iNativeAdaptiveGradingProcess == 0 ? nativeAdaptiveGradingGetResultTexture(this.mNativePtr) : iNativeAdaptiveGradingProcess;
    }

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public int ProcessOesTexture(int i, int i2, int i3, float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            return -1;
        }
        int iNativeAdaptiveGradingOesProcess = nativeAdaptiveGradingOesProcess(j, i, i2, i3, fArr, f, f2, f3, f4, f5, f6, z);
        return iNativeAdaptiveGradingOesProcess == 0 ? nativeAdaptiveGradingGetResultTexture(this.mNativePtr) : iNativeAdaptiveGradingOesProcess;
    }

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public void Free() {
        long j = this.mNativePtr;
        if (j == 0) {
            return;
        }
        nativeReleaseAdaptiveGrading(j);
    }
}
