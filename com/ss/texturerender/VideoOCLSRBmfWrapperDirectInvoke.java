package com.ss.texturerender;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.bmf_mods_lite_api.SuperResolutionLiteApi;
import com.bytedance.bmf_mods_lite_api.bean.MultiScaleParams;
import com.bytedance.bmf_mods_lite_api.bean.OesParams;
import com.bytedance.bmf_mods_lite_api.bean.RoiParams;
import com.bytedance.bmf_mods_lite_api.bean.SRConfig;
import com.bytedance.bmf_mods_lite_api.bean.SharpLevelParams;
import com.bytedance.bmf_mods_lite_api.callback.SRInitCallback;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoOCLSRBmfWrapperDirectInvoke extends VideoOCLSRBaseWrapper {
    public static final int ASYC_INIT_DOWNLOADING = 200010;
    private static final int ASYNC_INIT_STATUS_INITING = 1;
    private static final int ASYNC_INIT_STATUS_INIT_FAIL = 3;
    private static final int ASYNC_INIT_STATUS_INIT_SUCCESS = 2;
    private static final int ASYNC_INIT_STATUS_UNKONW = 0;
    private static final int HEIGHT_DEFAULT = 4096;
    private static final String LOG_TAG = "VideoOCLSRBmfWrapperDirectInovke";
    private static final String VIDEO_OCLSR_COMPONENT_CLASS_NAME = "com.bytedance.bmf_mods_lite.VideoSuperResolution";
    private static final int WIDTH_DEFAULT = 4096;
    private int algType;
    private int mTexType;
    private SuperResolutionLiteApi mSRObject = null;
    private int bmflogCount = 0;
    private int oTextureId = -1;
    private volatile int mAsyncInitStatus = 0;
    private volatile int mSupportSharpness = SRConfig.SHARP_LEVEL_DEFAULT;
    private MySRInitCallback mMySRInitCallback = null;

    private static class MySRInitCallback implements SRInitCallback {
        private final WeakReference<VideoOCLSRBmfWrapperDirectInvoke> mRef;

        public MySRInitCallback(VideoOCLSRBmfWrapperDirectInvoke videoOCLSRBmfWrapperDirectInvoke) {
            this.mRef = new WeakReference<>(videoOCLSRBmfWrapperDirectInvoke);
        }

        @Override // com.bytedance.bmf_mods_lite_api.callback.SRInitCallback
        public void onInitResult(int i, int i2) {
            VideoOCLSRBmfWrapperDirectInvoke videoOCLSRBmfWrapperDirectInvoke = this.mRef.get();
            if (videoOCLSRBmfWrapperDirectInvoke == null) {
                TextureRenderLog.i(-1, VideoOCLSRBmfWrapperDirectInvoke.LOG_TAG, "bmf on initResult fail vst is null");
            } else {
                videoOCLSRBmfWrapperDirectInvoke.onSRAsyncInitResult(i, i2);
            }
        }
    }

    public void onSRAsyncInitResult(int i, int i2) {
        this.mSupportSharpness = i2;
        if (i != 0) {
            this.mAsyncInitStatus = 3;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "bmf asyncinit fail:" + i);
        } else {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "bmf asyncinit success:" + i2);
            this.mAsyncInitStatus = 2;
        }
    }

    public VideoOCLSRBmfWrapperDirectInvoke(int i) {
        this.mTexType = -1;
        this.mTexType = i;
        TextureRenderLog.d(i, LOG_TAG, "new VideoOCLSRBmfWrapperDirectInvoke");
        _initObjAndMethod();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String str, int i, boolean z, String str2, int i2, int i3, int i4, String str3, String str4) {
        return InitVideoOclSr(str, i, z, false, 4096, 4096, str2, i2, i3, i4, str3, str4);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String str, int i, boolean z, int i2, int i3) {
        return InitVideoOclSr(str, i, z, false, i2, i3, "", 0, 0, 0, "", "");
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String str, int i, boolean z, boolean z2, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4) {
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        this.algType = i;
        Integer numValueOf = null;
        if (this.mSRObject != null) {
            if (str2 != null && str2.length() > 0) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitWithLicenseMethod " + str2);
                numValueOf = Integer.valueOf(this.mSRObject.Init(i, i4, i5, i6, str3, str2, str4, i3, i2));
            } else {
                numValueOf = Integer.valueOf(this.mSRObject.Init(i, i4, i5, i6, str3, "", str4, i3, i2));
            }
        }
        this.mAsyncInitStatus = 2;
        return numValueOf != null && numValueOf.intValue() == 0;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoAsyncOclSr(String str, int i, boolean z, boolean z2, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4, Bundle bundle) {
        SRConfig sRConfigBuild;
        Integer numValueOf;
        if (this.mAsyncInitStatus == 1 || this.mAsyncInitStatus == 2) {
            return false;
        }
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        this.algType = i;
        Integer num = null;
        if (this.mSRObject != null) {
            if (this.mMySRInitCallback == null) {
                this.mMySRInitCallback = new MySRInitCallback(this);
            }
            if (bundle != null) {
                sRConfigBuild = new SRConfig.Builder().setHostAndAccessKey(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, ""), bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, "")).setDeviceId(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, "")).setAppId(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, "")).setAppVersion(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, "")).setSharpLevels(bundle.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_SHARP_LEVELS), bundle.getBoolean(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ALLOW_FALLBACK)).setModelSource(bundle.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_SOURCE, 0)).build();
            } else {
                sRConfigBuild = null;
            }
            if (str2 != null && str2.length() > 0) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitWithLicenseMethod " + str2);
                numValueOf = Integer.valueOf(this.mSRObject.Init(i, i4, i5, i6, str3, str2, str4, i3, i2));
            } else {
                numValueOf = Integer.valueOf(this.mSRObject.Init(i, i4, i5, i6, str3, "", str4, i3, i2, sRConfigBuild, this.mMySRInitCallback));
            }
            num = numValueOf;
            if (num != null && num.intValue() == 200010) {
                this.mAsyncInitStatus = 1;
            } else if (num != null && num.intValue() == 0) {
                this.mSupportSharpness = SRConfig.SHARP_LEVEL_DEFAULT | SRConfig.SHARP_LEVEL_WEAK | SRConfig.SHARP_LEVEL_MEDIUM | SRConfig.SHARP_LEVEL_STRONG;
                this.mAsyncInitStatus = 2;
            }
        }
        if (num == null || num.intValue() < 0) {
            this.mAsyncInitStatus = 3;
        }
        return num != null && num.intValue() == 0;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, int i8, long j, int i9, int i10, Bundle bundle) {
        Integer numValueOf;
        if (this.mAsyncInitStatus != 2) {
            return -1;
        }
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        RoiParams roiParams = new RoiParams(i4, i5, i6, i7, i8, j);
        SharpLevelParams sharpLevelParams = null;
        if (bundle != null && bundle.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL)) {
            int i11 = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
            if (i11 != -1 && (this.mSupportSharpness & i11) == 0) {
                i11 = SRConfig.SHARP_LEVEL_DEFAULT;
            }
            sharpLevelParams = new SharpLevelParams(i11);
        }
        if (this.algType < 7) {
            numValueOf = Integer.valueOf(this.mSRObject.ProcessTexture(i, i2, i3, roiParams, null, sharpLevelParams));
        } else {
            numValueOf = Integer.valueOf(this.mSRObject.ProcessTexture(i, i2, i3, roiParams, new MultiScaleParams(i10), sharpLevelParams));
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            this.oTextureId = iIntValue;
            int i12 = this.bmflogCount;
            if (i12 >= 100 && iIntValue > 0) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess sucess, scale type: " + i10);
                this.bmflogCount = 0;
            } else {
                this.bmflogCount = i12 + 1;
            }
        }
        if (numValueOf == null) {
            return -1;
        }
        return numValueOf.intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int i, int i2, int i3, float[] fArr, boolean z, int i4, int i5, int i6, int i7, int i8, long j, int i9, int i10, Bundle bundle) {
        Integer numValueOf;
        if (this.mAsyncInitStatus != 2) {
            return -1;
        }
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        RoiParams roiParams = new RoiParams(i4, i5, i6, i7, i8, j);
        SharpLevelParams sharpLevelParams = null;
        if (bundle != null && bundle.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL)) {
            int i11 = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
            if (i11 != -1 && (this.mSupportSharpness & i11) == 0) {
                i11 = SRConfig.SHARP_LEVEL_DEFAULT;
            }
            sharpLevelParams = new SharpLevelParams(i11);
        }
        if (this.algType < 7) {
            numValueOf = Integer.valueOf(this.mSRObject.ProcessOesTexture(i, i2, i3, fArr, roiParams, null, sharpLevelParams, null));
        } else {
            numValueOf = Integer.valueOf(this.mSRObject.ProcessOesTexture(i, i2, i3, fArr, roiParams, new MultiScaleParams(i10), sharpLevelParams, null));
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            this.oTextureId = iIntValue;
            int i12 = this.bmflogCount;
            if (i12 >= 100 && iIntValue > 0) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess oes sucess, scale type: " + i10);
                this.bmflogCount = 0;
            } else {
                this.bmflogCount = i12 + 1;
            }
        }
        if (numValueOf == null) {
            return -1;
        }
        return numValueOf.intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3, boolean z, Bundle bundle) {
        if (this.mAsyncInitStatus != 2) {
            return -1;
        }
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        OesParams oesParams = new OesParams(fArr2, fArr3, z);
        SharpLevelParams sharpLevelParams = (bundle == null || !bundle.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL)) ? null : new SharpLevelParams(bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL));
        int i4 = this.algType;
        Integer numValueOf = (i4 == 12 || i4 == 14) ? Integer.valueOf(this.mSRObject.ProcessOesTexture(i, i2, i3, fArr, null, null, sharpLevelParams, oesParams)) : null;
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            this.oTextureId = iIntValue;
            int i5 = this.bmflogCount;
            if (i5 >= 100 && iIntValue > 0) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess oes yuv sucess");
                this.bmflogCount = 0;
            } else {
                this.bmflogCount = i5 + 1;
            }
        }
        if (numValueOf == null) {
            return -1;
        }
        return numValueOf.intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public void ReleaseVideoOclSr() {
        SuperResolutionLiteApi superResolutionLiteApi = this.mSRObject;
        if (superResolutionLiteApi != null) {
            superResolutionLiteApi.Free();
        }
        this.mAsyncInitStatus = 0;
        this.mSRObject = null;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int GetVideoOclSrOutput() {
        return this.oTextureId;
    }

    private void _initObjAndMethod() {
        try {
            Class<?> clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_COMPONENT_CLASS_NAME);
            if (clzUsingPluginLoader != null) {
                this.mSRObject = (SuperResolutionLiteApi) clzUsingPluginLoader.getConstructor(Context.class).newInstance(TextureRenderManager.getManager().getContext());
            }
        } catch (Exception e) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "VideoOCLSR get fail:" + e.toString());
            this.mSRObject = null;
        }
    }
}
