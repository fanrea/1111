package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.ColorHistAPI;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ColorHist implements ColorHistAPI {
    private long mNativePtr = 0;
    private JsonObject resultJson = new JsonObject();
    private float[] output_data = {-1.0f, -1.0f, -1.0f};

    private native int nativeColorHistOesProcess(long j, int i, float[] fArr, int i2, int i3, long j2, float[] fArr2);

    private native int nativeColorHistProcess(long j, int i, int i2, int i3, long j2, float[] fArr);

    private native int nativeColorHistRestStatus(long j);

    private native long nativeCreateColorHist();

    private native int nativeInitColorHist(long j, int i, int i2, int i3, int i4, int i5);

    private native void nativeReleaseColorHist(long j);

    public ColorHist() {
        Logging.d("New color hist");
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int Init(int i, int i2, int i3, int i4, int i5) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long jNativeCreateColorHist = nativeCreateColorHist();
        this.mNativePtr = jNativeCreateColorHist;
        if (jNativeCreateColorHist == 0) {
            return -1;
        }
        return nativeInitColorHist(jNativeCreateColorHist, i, i2, i3, i4, i5);
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int ProcessTexture(int i, int i2, int i3, long j) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long j2 = this.mNativePtr;
        if (j2 == 0) {
            return -1;
        }
        int iNativeColorHistProcess = nativeColorHistProcess(j2, i, i2, i3, j, this.output_data);
        if (iNativeColorHistProcess > 0) {
            this.resultJson.addProperty("valid", Integer.valueOf(iNativeColorHistProcess));
            this.resultJson.addProperty("constract", Float.valueOf(this.output_data[0]));
            this.resultJson.addProperty("brightness", Float.valueOf(this.output_data[1]));
            this.resultJson.addProperty("saturation", Float.valueOf(this.output_data[2]));
        }
        return iNativeColorHistProcess;
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int ProcessOesTexture(int i, int i2, int i3, float[] fArr, long j) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long j2 = this.mNativePtr;
        if (j2 == 0) {
            return -1;
        }
        int iNativeColorHistOesProcess = nativeColorHistOesProcess(j2, i, fArr, i2, i3, j, this.output_data);
        if (iNativeColorHistOesProcess > 0) {
            this.resultJson.addProperty("valid", Integer.valueOf(iNativeColorHistOesProcess));
            this.resultJson.addProperty("constract", Float.valueOf(this.output_data[0]));
            this.resultJson.addProperty("brightness", Float.valueOf(this.output_data[1]));
            this.resultJson.addProperty("saturation", Float.valueOf(this.output_data[2]));
        }
        return iNativeColorHistOesProcess;
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public JsonObject GetResult() {
        return this.resultJson;
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public void Free() {
        long j = this.mNativePtr;
        if (j == 0) {
            return;
        }
        nativeReleaseColorHist(j);
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int ResetStatus() {
        long j = this.mNativePtr;
        if (j == 0) {
            return -1;
        }
        return nativeColorHistRestStatus(j);
    }
}
