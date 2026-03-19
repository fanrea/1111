package com.ss.texturerender;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.bmf_mods_lite_api.bean.MultiScaleParams;
import com.bytedance.bmf_mods_lite_api.bean.OesParams;
import com.bytedance.bmf_mods_lite_api.bean.RoiParams;
import com.bytedance.bmf_mods_lite_api.bean.SRConfig;
import com.bytedance.bmf_mods_lite_api.bean.SharpLevelParams;
import com.bytedance.bmf_mods_lite_api.callback.SRInitCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoOCLSRBmfWrapper extends VideoOCLSRBaseWrapper {
    public static final int ASYC_INIT_DOWNLOADING = 200010;
    private static final int ASYNC_INIT_STATUS_INITING = 1;
    private static final int ASYNC_INIT_STATUS_INIT_FAIL = 3;
    private static final int ASYNC_INIT_STATUS_INIT_SUCCESS = 2;
    private static final int ASYNC_INIT_STATUS_UNKONW = 0;
    private static final int HEIGHT_DEFAULT = 4096;
    private static final String LOG_TAG = "VideoOCLSRBmfWrapper";
    private static final String VIDEO_OCLSR_CLASS_NAME = "com.bytedance.bmf_mods.VideoSuperResolution";
    private static final String VIDEO_OCLSR_COMPONENT_CLASS_NAME = "com.bytedance.bmf_mods_lite.VideoSuperResolution";
    private static final String VIDEO_OCLSR_PICO_CLASS_NAME = "com.bytedance.bmf_mods.VideoSRLut";
    private static final int WIDTH_DEFAULT = 4096;
    private int algType;
    private int bmflogCount;
    private int curr_height;
    private int curr_width;
    private Method mAsyncInitMethod;
    private volatile int mAsyncInitStatus;
    private Method mFreeMethod;
    private Method mGlInitMethod;
    private Method mInitMethod;
    private Method mMultiScaleOesProcessMethod;
    private Method mMultiScaleProcessMethod;
    private MySRInitCallback mMySRInitCallback;
    private Method mProcessMethod;
    private Method mProcessOesMethod;
    private Method mProcessOesMethodWithYUV;
    private Object mSRObject;
    private volatile int mSupportSharpness;
    private int mTexType;
    private boolean mUseBmfComponent;
    private int oTextureId;
    private boolean useGL;

    private static class MySRInitCallback implements SRInitCallback {
        private final WeakReference<VideoOCLSRBmfWrapper> mRef;

        public MySRInitCallback(VideoOCLSRBmfWrapper videoOCLSRBmfWrapper) {
            this.mRef = new WeakReference<>(videoOCLSRBmfWrapper);
        }

        @Override // com.bytedance.bmf_mods_lite_api.callback.SRInitCallback
        public void onInitResult(int i, int i2) {
            VideoOCLSRBmfWrapper videoOCLSRBmfWrapper = this.mRef.get();
            if (videoOCLSRBmfWrapper == null) {
                TextureRenderLog.i(-1, VideoOCLSRBmfWrapper.LOG_TAG, "bmf on initResult fail vst is null");
            } else {
                videoOCLSRBmfWrapper.onSRAsyncInitResult(i, i2);
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

    public VideoOCLSRBmfWrapper(int i) {
        this(i, false);
    }

    public VideoOCLSRBmfWrapper(int i, boolean z) throws NoSuchMethodException, SecurityException {
        this.mSRObject = null;
        this.mInitMethod = null;
        this.mGlInitMethod = null;
        this.mAsyncInitMethod = null;
        this.mProcessMethod = null;
        this.mProcessOesMethod = null;
        this.mMultiScaleProcessMethod = null;
        this.mMultiScaleOesProcessMethod = null;
        this.mProcessOesMethodWithYUV = null;
        this.mFreeMethod = null;
        this.useGL = false;
        this.bmflogCount = 0;
        this.oTextureId = -1;
        this.mTexType = -1;
        this.mUseBmfComponent = false;
        this.mAsyncInitStatus = 0;
        this.mSupportSharpness = SRConfig.SHARP_LEVEL_DEFAULT;
        this.mMySRInitCallback = null;
        this.mTexType = i;
        this.mUseBmfComponent = z;
        if (DeviceManager.isVRDevice()) {
            this.useGL = true;
        }
        TextureRenderLog.d(this.mTexType, LOG_TAG, "new VideoOCLSRBmfWrapper");
        _initObjAndMethod();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean glSrInit(String str, int i, boolean z, int i2, int i3) throws NoSuchMethodException, SecurityException {
        Method method;
        this.bmflogCount = 0;
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        this.algType = i;
        Object obj_invokeMethod = null;
        Object obj = this.mSRObject;
        if (obj != null && (method = this.mGlInitMethod) != null) {
            obj_invokeMethod = _invokeMethod(method, obj, "", Integer.valueOf(i), Boolean.valueOf(z), 4096, 4096);
        }
        return obj_invokeMethod != null && ((Boolean) obj_invokeMethod).booleanValue();
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
    public boolean InitVideoOclSr(String str, int i, boolean z, boolean z2, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4) throws NoSuchMethodException, SecurityException {
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        this.algType = i;
        Object obj_invokeMethod = null;
        if (this.mSRObject != null) {
            if (str2 != null && str2.length() > 0) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitWithLicenseMethod " + str2);
                obj_invokeMethod = _invokeMethod(this.mInitMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str3, str2, str4, Integer.valueOf(i3), Integer.valueOf(i2));
            } else {
                obj_invokeMethod = _invokeMethod(this.mInitMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str3, "", str4, Integer.valueOf(i3), Integer.valueOf(i2));
            }
        }
        this.mAsyncInitStatus = 2;
        return obj_invokeMethod != null && ((Integer) obj_invokeMethod).intValue() == 0;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoAsyncOclSr(String str, int i, boolean z, boolean z2, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4, Bundle bundle) throws NoSuchMethodException, SecurityException {
        Object obj_invokeMethod;
        if (!this.mUseBmfComponent || this.mAsyncInitStatus == 1 || this.mAsyncInitStatus == 2) {
            return false;
        }
        if (this.mSRObject == null) {
            _initObjAndMethod();
        }
        this.algType = i;
        if (this.mSRObject != null) {
            if (this.mMySRInitCallback == null) {
                this.mMySRInitCallback = new MySRInitCallback(this);
            }
            objBuild = bundle != null ? new SRConfig.Builder().setHostAndAccessKey(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, ""), bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, "")).setDeviceId(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, "")).setAppId(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, "")).setAppVersion(bundle.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, "")).setSharpLevels(bundle.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_SHARP_LEVELS, 0), bundle.getBoolean(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ALLOW_FALLBACK, false)).setModelSource(bundle.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_SOURCE, 0)).build() : null;
            if (str2 != null && str2.length() > 0) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitWithLicenseMethod " + str2);
                obj_invokeMethod = _invokeMethod(this.mAsyncInitMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str3, str2, str4, Integer.valueOf(i3), Integer.valueOf(i2), objBuild, this.mMySRInitCallback);
            } else {
                obj_invokeMethod = _invokeMethod(this.mAsyncInitMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str3, "", str4, Integer.valueOf(i3), Integer.valueOf(i2), objBuild, this.mMySRInitCallback);
            }
            objBuild = obj_invokeMethod;
            if (objBuild != null && ((Integer) objBuild).intValue() == 200010) {
                this.mAsyncInitStatus = 1;
            } else if (objBuild != null && ((Integer) objBuild).intValue() == 0) {
                this.mSupportSharpness = SRConfig.SHARP_LEVEL_DEFAULT | SRConfig.SHARP_LEVEL_WEAK | SRConfig.SHARP_LEVEL_MEDIUM | SRConfig.SHARP_LEVEL_STRONG;
                this.mAsyncInitStatus = 2;
            }
        }
        if (objBuild == null || ((Integer) objBuild).intValue() < 0) {
            this.mAsyncInitStatus = 3;
        }
        return objBuild != null && ((Integer) objBuild).intValue() == 0;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, int i8, long j, int i9, int i10, Bundle bundle) throws NoSuchMethodException, SecurityException {
        SharpLevelParams sharpLevelParams;
        Object obj_invokeMethod;
        if (this.mAsyncInitStatus != 2) {
            return -1;
        }
        if (this.mSRObject == null || this.mProcessMethod == null) {
            _initObjAndMethod();
        }
        RoiParams roiParams = new RoiParams(i4, i5, i6, i7, i8, j);
        if (bundle == null || !bundle.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL)) {
            sharpLevelParams = null;
        } else {
            int i11 = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
            if (i11 != -1 && (this.mSupportSharpness & i11) == 0) {
                i11 = SRConfig.SHARP_LEVEL_DEFAULT;
            }
            sharpLevelParams = new SharpLevelParams(i11);
        }
        if (this.algType < 7) {
            if (this.mUseBmfComponent) {
                obj_invokeMethod = _invokeMethod(this.mProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), roiParams, null, sharpLevelParams);
            } else {
                obj_invokeMethod = _invokeMethod(this.mProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Long.valueOf(j));
            }
        } else {
            MultiScaleParams multiScaleParams = new MultiScaleParams(i10);
            if (this.mUseBmfComponent) {
                obj_invokeMethod = _invokeMethod(this.mMultiScaleProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), roiParams, multiScaleParams, sharpLevelParams);
            } else {
                obj_invokeMethod = _invokeMethod(this.mMultiScaleProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Long.valueOf(j), Integer.valueOf(i9), Integer.valueOf(i10));
            }
        }
        if (obj_invokeMethod != null) {
            int iIntValue = ((Integer) obj_invokeMethod).intValue();
            this.oTextureId = iIntValue;
            int i12 = this.bmflogCount;
            if (i12 >= 100 && iIntValue > 0) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess sucess, scale type: " + i10);
                this.bmflogCount = 0;
            } else {
                this.bmflogCount = i12 + 1;
            }
        }
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int i, int i2, int i3, float[] fArr, boolean z, int i4, int i5, int i6, int i7, int i8, long j, int i9, int i10, Bundle bundle) throws NoSuchMethodException, SecurityException {
        SharpLevelParams sharpLevelParams;
        Object obj_invokeMethod;
        if (this.mAsyncInitStatus != 2) {
            return -1;
        }
        if (this.mSRObject == null || this.mProcessOesMethod == null) {
            _initObjAndMethod();
        }
        RoiParams roiParams = new RoiParams(i4, i5, i6, i7, i8, j);
        if (bundle == null || !bundle.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL)) {
            sharpLevelParams = null;
        } else {
            int i11 = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
            if (i11 != -1 && (this.mSupportSharpness & i11) == 0) {
                i11 = SRConfig.SHARP_LEVEL_DEFAULT;
            }
            sharpLevelParams = new SharpLevelParams(i11);
        }
        if (this.algType < 7) {
            if (this.mUseBmfComponent) {
                obj_invokeMethod = _invokeMethod(this.mProcessOesMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, roiParams, null, sharpLevelParams, null);
            } else {
                obj_invokeMethod = _invokeMethod(this.mProcessOesMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Long.valueOf(j));
            }
        } else {
            MultiScaleParams multiScaleParams = new MultiScaleParams(i10);
            if (this.mUseBmfComponent) {
                obj_invokeMethod = _invokeMethod(this.mMultiScaleOesProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, roiParams, multiScaleParams, sharpLevelParams, null);
            } else {
                obj_invokeMethod = _invokeMethod(this.mMultiScaleOesProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Long.valueOf(j), Integer.valueOf(i9), Integer.valueOf(i10));
            }
        }
        if (obj_invokeMethod != null) {
            int iIntValue = ((Integer) obj_invokeMethod).intValue();
            this.oTextureId = iIntValue;
            if (iIntValue > 0) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess oes sucess, scale type: " + i10);
            }
        }
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3, boolean z, Bundle bundle) throws NoSuchMethodException, SecurityException {
        if (this.mAsyncInitStatus != 2) {
            return -1;
        }
        if (this.mSRObject == null || this.mProcessOesMethodWithYUV == null) {
            _initObjAndMethod();
        }
        OesParams oesParams = new OesParams(fArr2, fArr3, z);
        Object obj_invokeMethod = null;
        SharpLevelParams sharpLevelParams = (bundle == null || !bundle.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL)) ? null : new SharpLevelParams(bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL));
        if (this.algType == 12) {
            if (this.mUseBmfComponent) {
                obj_invokeMethod = _invokeMethod(this.mProcessOesMethodWithYUV, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, null, null, sharpLevelParams, oesParams);
            } else {
                obj_invokeMethod = _invokeMethod(this.mProcessOesMethodWithYUV, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr2, fArr3, fArr, Boolean.valueOf(z));
            }
        }
        if (obj_invokeMethod != null) {
            int iIntValue = ((Integer) obj_invokeMethod).intValue();
            this.oTextureId = iIntValue;
            int i4 = this.bmflogCount;
            if (i4 >= 100 && iIntValue > 0) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess oes yuv sucess");
                this.bmflogCount = 0;
            } else {
                this.bmflogCount = i4 + 1;
            }
        }
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int videoOclSrProcess(int i, int i2, int i3, boolean z, int i4) throws NoSuchMethodException, SecurityException {
        if (this.mSRObject == null || this.mProcessMethod == null) {
            _initObjAndMethod();
        }
        Object obj_invokeMethod = null;
        try {
            obj_invokeMethod = _invokeMethod(this.mProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
            TextureRenderLog.d(this.mTexType, LOG_TAG, "fatal bmf sr");
        }
        if (obj_invokeMethod != null) {
            int i5 = this.bmflogCount;
            if (i5 >= 100) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess sucess");
                this.bmflogCount = 0;
            } else {
                this.bmflogCount = i5 + 1;
            }
        }
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int i, int i2, int i3, boolean z) throws NoSuchMethodException, SecurityException {
        if (this.mSRObject == null || this.mProcessMethod == null) {
            _initObjAndMethod();
        }
        if (this.curr_width != i2 || this.curr_height != i3) {
            TexGLUtils.deleteTexture(this.oTextureId);
            this.curr_width = i2;
            this.curr_height = i3;
            double d = this.algType == 0 ? 2.0d : 1.5d;
            int i4 = (int) (i2 * d);
            int i5 = (int) (d * i3);
            if (DeviceManager.isVRDevice()) {
                this.oTextureId = TexGLUtils.genTexture(3553, 9728);
            } else {
                this.oTextureId = TexGLUtils.genTexture(3553);
            }
            GLES20.glBindTexture(3553, this.oTextureId);
            if (this.useGL && Build.VERSION.SDK_INT >= 18) {
                GLES30.glTexStorage2D(3553, 1, 32856, i4, i5);
            } else {
                GLES20.glTexImage2D(3553, 0, 6408, i4, i5, 0, 6408, 5121, null);
            }
        }
        Object obj_invokeMethod = null;
        try {
            obj_invokeMethod = _invokeMethod(this.mProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(this.oTextureId), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
            TextureRenderLog.d(this.mTexType, LOG_TAG, "fatal bmf sr");
        }
        if (obj_invokeMethod != null) {
            int i6 = this.bmflogCount;
            if (i6 >= 100) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "bmfTextureProcess sucess");
                this.bmflogCount = 0;
            } else {
                this.bmflogCount = i6 + 1;
            }
        }
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public void ReleaseVideoOclSr() {
        Method method;
        Object obj = this.mSRObject;
        if (obj != null && (method = this.mFreeMethod) != null) {
            _invokeMethod(method, obj, new Object[0]);
            TextureRenderLog.i(this.mTexType, LOG_TAG, "FreeVideoOclSr");
        }
        this.mAsyncInitStatus = 0;
        this.mSRObject = null;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int GetVideoOclSrOutput() {
        return this.oTextureId;
    }

    private void _initObjAndMethod() throws NoSuchMethodException, SecurityException {
        Class<?> clzUsingPluginLoader;
        try {
            if (this.mUseBmfComponent) {
                clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_COMPONENT_CLASS_NAME);
            } else if (this.useGL) {
                clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_PICO_CLASS_NAME);
            } else {
                clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_CLASS_NAME);
            }
            if (clzUsingPluginLoader != null) {
                if (this.useGL) {
                    this.mGlInitMethod = clzUsingPluginLoader.getDeclaredMethod("GlSrInit", String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE);
                    this.mProcessMethod = clzUsingPluginLoader.getDeclaredMethod("Process", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
                } else {
                    this.mInitMethod = clzUsingPluginLoader.getDeclaredMethod("Init", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, String.class, String.class, Integer.TYPE, Integer.TYPE);
                    if (this.mUseBmfComponent) {
                        this.mProcessMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, RoiParams.class, MultiScaleParams.class, SharpLevelParams.class);
                        this.mAsyncInitMethod = clzUsingPluginLoader.getDeclaredMethod("Init", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, String.class, String.class, Integer.TYPE, Integer.TYPE, SRConfig.class, SRInitCallback.class);
                    } else {
                        this.mProcessMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE);
                        this.mAsyncInitMethod = null;
                    }
                }
                if (!this.useGL) {
                    if (this.mUseBmfComponent) {
                        Method declaredMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessOesTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, float[].class, RoiParams.class, MultiScaleParams.class, SharpLevelParams.class, OesParams.class);
                        this.mProcessOesMethod = declaredMethod;
                        this.mProcessOesMethodWithYUV = declaredMethod;
                        this.mMultiScaleOesProcessMethod = declaredMethod;
                        this.mMultiScaleProcessMethod = this.mProcessMethod;
                    } else {
                        this.mProcessOesMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessOesTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, float[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE);
                        if (clzUsingPluginLoader != null) {
                            try {
                                this.mProcessOesMethodWithYUV = clzUsingPluginLoader.getDeclaredMethod("ProcessOesTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, float[].class, float[].class, float[].class, Boolean.TYPE);
                            } catch (Exception e) {
                                TextureRenderLog.e(this.mTexType, LOG_TAG, "getmethod error:" + e.toString() + ", old bmf version maybe");
                            }
                        }
                        if (clzUsingPluginLoader != null) {
                            try {
                                this.mMultiScaleProcessMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessMultiScaleTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Integer.TYPE, Integer.TYPE);
                            } catch (Exception e2) {
                                TextureRenderLog.e(this.mTexType, LOG_TAG, "getmethod error:" + e2.toString() + ", old bmf version maybe");
                            }
                        }
                        if (clzUsingPluginLoader != null) {
                            try {
                                this.mMultiScaleOesProcessMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessMultiScaleOesTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, float[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Integer.TYPE, Integer.TYPE);
                            } catch (Exception e3) {
                                TextureRenderLog.e(this.mTexType, LOG_TAG, "getmethod error:" + e3.toString() + ", old bmf version maybe");
                            }
                        }
                    }
                }
                this.mFreeMethod = clzUsingPluginLoader.getDeclaredMethod("Free", new Class[0]);
                if (this.useGL) {
                    this.mSRObject = clzUsingPluginLoader.newInstance();
                } else {
                    this.mSRObject = clzUsingPluginLoader.getConstructor(Context.class).newInstance(TextureRenderManager.getManager().getContext());
                }
            }
        } catch (Exception e4) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "VideoOCLSR get fail:" + e4.toString());
            this.mSRObject = null;
            this.mInitMethod = null;
            this.mGlInitMethod = null;
            this.mFreeMethod = null;
            this.mProcessMethod = null;
            this.mProcessOesMethod = null;
        }
    }

    private Object _invokeMethod(Method method, Object obj, Object... objArr) {
        if (method == null || obj == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            TextureRenderLog.e(this.mTexType, LOG_TAG, e.toString());
            return null;
        }
    }
}
