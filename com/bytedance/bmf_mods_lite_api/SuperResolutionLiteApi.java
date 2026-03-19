package com.bytedance.bmf_mods_lite_api;

import com.bytedance.bmf_mods_lite_api.bean.MultiScaleParams;
import com.bytedance.bmf_mods_lite_api.bean.OesParams;
import com.bytedance.bmf_mods_lite_api.bean.RoiParams;
import com.bytedance.bmf_mods_lite_api.bean.SRConfig;
import com.bytedance.bmf_mods_lite_api.bean.SharpLevelParams;
import com.bytedance.bmf_mods_lite_api.callback.SRInitCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface SuperResolutionLiteApi {
    default void Free() {
    }

    default int Init(int alg_type, int backend, int scale_type, int pool_size, String libpath, String licenseModuleName, String programCacheDir, int max_width, int max_height) {
        return -1;
    }

    default int Init(int alg_type, int backend, int scale_type, int pool_size, String libpath, String licenseModuleName, String programCacheDir, int max_width, int max_height, SRConfig config, SRInitCallback callback) {
        return -1;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, RoiParams roiParams, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams, OesParams oesParams) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, RoiParams roiParams, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams) {
        return -1;
    }
}
