package com.ss.texturerender.effect;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPI;
import com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.VideoSurface;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BMFVQScoreWrapper extends AbsEffect {
    private static final String BMF_VQSCORE_CLASS_NAME = "com.bytedance.bmf_mods.VqscoreLive";
    private static final String LOG_TAG = "TR_BMFVQScoreWrapper";
    private final int OPENCL;
    private final int OPENGL;
    private final String defaultAccessKey;
    private final int defaultConcurrencyLimit;
    private final String defaultPlatformSdkVersion;
    private int mAlgorithmType;
    private int mBackEnd;
    private String mCachePath;
    private int mConcurrencyLimit;
    private Method mDownloadMethod;
    private Method mDownlodCallbackMethod;
    private int mForwardType;
    private Method mFreeMethod;
    private Method mInitMethod;
    private boolean mInited;
    private float mProcessAverageCostTime;
    private Method mProcessCallbackMethod;
    private Method mProcessMethod;
    private Method mProcessOesMethod;
    private float mProcessSuccessFrame;
    private float mProcessSumCostTime;
    private float mProcessSumFrame;
    private long mSequenceId;
    private boolean mSupportVQSCoreAfterEffect;
    private Object mVQScoreObject;
    private Map<Long, Long> mVqscoreTimeMap;

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        return null;
    }

    static /* synthetic */ float access$108(BMFVQScoreWrapper bMFVQScoreWrapper) {
        float f = bMFVQScoreWrapper.mProcessSuccessFrame;
        bMFVQScoreWrapper.mProcessSuccessFrame = 1.0f + f;
        return f;
    }

    public BMFVQScoreWrapper(int i) {
        super(i, 16);
        this.mVQScoreObject = null;
        this.mInitMethod = null;
        this.mDownlodCallbackMethod = null;
        this.mProcessCallbackMethod = null;
        this.mDownloadMethod = null;
        this.mProcessMethod = null;
        this.mProcessOesMethod = null;
        this.mFreeMethod = null;
        this.mInited = false;
        this.mCachePath = "";
        this.defaultConcurrencyLimit = 2;
        this.mConcurrencyLimit = -1;
        this.defaultAccessKey = "142710f02c3a11e8b42429f14557854a";
        this.defaultPlatformSdkVersion = "11.0.0";
        this.OPENCL = 2;
        this.OPENGL = 3;
        this.mSequenceId = 0L;
        this.mSupportVQSCoreAfterEffect = false;
        this.mProcessAverageCostTime = 0.0f;
        this.mProcessSumCostTime = 0.0f;
        this.mProcessSumFrame = 0.0f;
        this.mProcessSuccessFrame = 0.0f;
        this.mVqscoreTimeMap = new ConcurrentHashMap();
        this.mBackEnd = 2;
        this.mAlgorithmType = 0;
        this.mForwardType = 1;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new BMFVQScoreWrapper");
        this.mIsSupportOes = 1;
        _initObjAndMethod();
    }

    public void downloadModel(Bundle bundle) {
        if (this.mInited || this.mVQScoreObject == null || this.mDownloadMethod == null) {
            return;
        }
        String string = bundle.getString(TextureRenderKeys.KEY_IS_BMF_VQSCORE_ACCESS_KEY);
        if (TextUtils.isEmpty(string)) {
            string = "142710f02c3a11e8b42429f14557854a";
        }
        String string2 = bundle.getString("sdk_version");
        if (TextUtils.isEmpty(string2)) {
            string2 = "11.0.0";
        }
        String string3 = bundle.getString("host", "");
        if (TextUtils.isEmpty(string3)) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "vqscore host is null");
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(19, this.mEffectType, "vqscore host is null");
                return;
            }
            return;
        }
        this.mCachePath = bundle.getString(TextureRenderKeys.KEY_IS_BMF_VQSCORE_CACHE_DIR, "");
        this.mConcurrencyLimit = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_CONCURRENCY_LIMIT, 2);
        this.mSupportVQSCoreAfterEffect = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_ENABLE_POSTEFFECT) == 1;
        this.mBackEnd = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_BACKEND, 2);
        this.mAlgorithmType = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_ALGTYPE, 0);
        String string4 = bundle.getString(TextureRenderKeys.KEY_IS_BMF_VQSCORE_DOWNLOAD_SOURCE, "");
        this.mForwardType = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_FORWARED_TYPE, 1);
        HashMap map = new HashMap();
        map.put("accessKey", string);
        map.put("platformSdkVersion", string2);
        map.put("host", string3);
        if (!TextUtils.isEmpty(string4)) {
            map.put("downloadSource", string4);
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "vqscore download params: " + map);
        _invokeMethod(this.mDownlodCallbackMethod, this.mVQScoreObject, new VqscoreLiveCallbackAPI() { // from class: com.ss.texturerender.effect.BMFVQScoreWrapper.1
            @Override // com.bytedance.bmf_mods_api.IDownloadCallback
            public void callback(int i) {
                TextureRenderLog.i(BMFVQScoreWrapper.this.mTexType, BMFVQScoreWrapper.LOG_TAG, "vqscore callback, status: " + i);
                if (i == 1) {
                    BMFVQScoreWrapper.this.mSurfaceTexture.setOption(151, -1);
                    return;
                }
                TextureRenderLog.i(BMFVQScoreWrapper.this.mTexType, BMFVQScoreWrapper.LOG_TAG, "download model fail");
                if (BMFVQScoreWrapper.this.mSurfaceTexture != null) {
                    BMFVQScoreWrapper.this.mSurfaceTexture.notifyError(19, BMFVQScoreWrapper.this.mEffectType, "vqscore download model fail, status: " + i);
                }
            }
        });
        _invokeMethod(this.mDownloadMethod, this.mVQScoreObject, TextureRenderManager.getManager().getContext(), map);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        if (!this.mInited && this.mVQScoreObject != null && this.mInitMethod != null && bundle != null && bundle.getInt("action") == 151) {
            Object obj_invokeMethod = _invokeMethod(this.mInitMethod, this.mVQScoreObject, Integer.valueOf(this.mAlgorithmType), Integer.valueOf(this.mBackEnd), 1, Integer.valueOf(this.mForwardType), true, this.mCachePath, Integer.valueOf(this.mConcurrencyLimit));
            iIntValue = obj_invokeMethod != null ? ((Integer) obj_invokeMethod).intValue() : -1;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "vqscore init result: " + iIntValue);
            if (iIntValue == 0) {
                this.mInited = true;
                if (this.mParentRender != null) {
                    this.mParentRender.setVQSCoreInitResult(true);
                }
            }
            if (iIntValue != 0 && this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(15, this.mEffectType, "vqscore init fail, ret: " + iIntValue);
            }
        }
        return iIntValue;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        Method method;
        Object obj = this.mVQScoreObject;
        if (obj != null && (method = this.mFreeMethod) != null) {
            _invokeMethod(method, obj, new Object[0]);
        }
        this.mVQScoreObject = null;
        this.mVqscoreTimeMap = null;
        return super.release();
    }

    public void processVqscore(EffectTexture effectTexture, final VideoSurface.VQScoreCallback vQScoreCallback, boolean z) {
        int iIntValue;
        if (!this.mInited || vQScoreCallback == null || effectTexture == null) {
            return;
        }
        if ((z && !this.mSupportVQSCoreAfterEffect) || this.mVQScoreObject == null || this.mProcessMethod == null || this.mProcessOesMethod == null || this.mProcessCallbackMethod == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mSupportVQSCoreAfterEffect && !z) {
            long j = this.mSequenceId;
            if (j % 2 == 0) {
                this.mSequenceId = j + 1;
            } else {
                this.mSequenceId = j + 2;
            }
        } else {
            this.mSequenceId++;
        }
        this.mVqscoreTimeMap.put(Long.valueOf(this.mSequenceId), Long.valueOf(jCurrentTimeMillis));
        this.mProcessSumFrame += 1.0f;
        int i = 0;
        _invokeMethod(this.mProcessCallbackMethod, this.mVQScoreObject, new VqscoreProcessCallbackAPI() { // from class: com.ss.texturerender.effect.BMFVQScoreWrapper.2
            @Override // com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI
            public void onProcessResult(long j2, int i2, float f) {
                if (BMFVQScoreWrapper.this.mVqscoreTimeMap != null && BMFVQScoreWrapper.this.mVqscoreTimeMap.containsKey(Long.valueOf(j2))) {
                    Long l = (Long) BMFVQScoreWrapper.this.mVqscoreTimeMap.get(Long.valueOf(j2));
                    jLongValue = l != null ? l.longValue() : -1L;
                    BMFVQScoreWrapper.this.mVqscoreTimeMap.remove(Long.valueOf(j2));
                }
                long j3 = jLongValue;
                TextureRenderLog.i(BMFVQScoreWrapper.this.mTexType, BMFVQScoreWrapper.LOG_TAG, "onProcessResult, sequenceId: " + j2 + ", status: " + i2 + ", score: " + f + ", cost: " + (System.currentTimeMillis() - j3));
                if (i2 == 0) {
                    BMFVQScoreWrapper.access$108(BMFVQScoreWrapper.this);
                    if (j3 > 0) {
                        BMFVQScoreWrapper.this.mProcessSumCostTime += System.currentTimeMillis() - j3;
                        BMFVQScoreWrapper bMFVQScoreWrapper = BMFVQScoreWrapper.this;
                        bMFVQScoreWrapper.mProcessAverageCostTime = bMFVQScoreWrapper.mProcessSumCostTime / BMFVQScoreWrapper.this.mProcessSumFrame;
                        if (BMFVQScoreWrapper.this.mSurfaceTexture != null) {
                            BMFVQScoreWrapper.this.mSurfaceTexture.setOption(155, BMFVQScoreWrapper.this.mProcessAverageCostTime);
                            BMFVQScoreWrapper.this.mSurfaceTexture.setOption(154, BMFVQScoreWrapper.this.mProcessSuccessFrame / BMFVQScoreWrapper.this.mProcessSumFrame);
                        }
                    }
                    vQScoreCallback.onProcessScore(f, j2, j3);
                }
            }
        });
        int texTarget = effectTexture.getTexTarget();
        if (texTarget == 36197) {
            float[] fArr = new float[16];
            this.mSurfaceTexture.getTransformMatrix(fArr);
            Object obj_invokeMethod = _invokeMethod(this.mProcessOesMethod, this.mVQScoreObject, Integer.valueOf(effectTexture.getTexID()), Integer.valueOf(effectTexture.getWidth()), Integer.valueOf(effectTexture.getHeight()), fArr, Long.valueOf(this.mSequenceId));
            if (obj_invokeMethod != null) {
                iIntValue = ((Integer) obj_invokeMethod).intValue();
                i = iIntValue;
            }
            i = -1;
        } else if (texTarget == 3553) {
            Object obj_invokeMethod2 = _invokeMethod(this.mProcessMethod, this.mVQScoreObject, Integer.valueOf(effectTexture.getTexID()), Integer.valueOf(effectTexture.getWidth()), Integer.valueOf(effectTexture.getHeight()), Long.valueOf(this.mSequenceId));
            if (obj_invokeMethod2 != null) {
                iIntValue = ((Integer) obj_invokeMethod2).intValue();
                i = iIntValue;
            }
            i = -1;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "process sequenceId: " + this.mSequenceId + ", ret: " + i + ", textarget: " + texTarget);
        if (this.mSurfaceTexture == null || i >= 0) {
            return;
        }
        this.mSurfaceTexture.notifyError(16, this.mEffectType, "vqscore process fail, ret: " + i);
    }

    private void _initObjAndMethod() {
        try {
            Class<?> clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_VQSCORE_CLASS_NAME);
            if (clzUsingPluginLoader != null) {
                this.mInitMethod = clzUsingPluginLoader.getDeclaredMethod("Init", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE, String.class, Integer.TYPE);
                this.mDownlodCallbackMethod = clzUsingPluginLoader.getDeclaredMethod("SetCallback", VqscoreLiveCallbackAPI.class);
                this.mDownloadMethod = clzUsingPluginLoader.getDeclaredMethod("DownloadModel", Context.class, Map.class);
                this.mProcessCallbackMethod = clzUsingPluginLoader.getDeclaredMethod("SetProcessCallback", VqscoreProcessCallbackAPI.class);
                this.mProcessMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessAsync", Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE);
                this.mProcessOesMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessOesAsync", Integer.TYPE, Integer.TYPE, Integer.TYPE, float[].class, Long.TYPE);
                this.mFreeMethod = clzUsingPluginLoader.getDeclaredMethod("Free", new Class[0]);
                this.mVQScoreObject = clzUsingPluginLoader.newInstance();
            }
        } catch (Exception e) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "BMFVQScore get fail:" + e.toString());
            this.mVQScoreObject = null;
            this.mInitMethod = null;
            this.mDownlodCallbackMethod = null;
            this.mDownloadMethod = null;
            this.mProcessCallbackMethod = null;
            this.mProcessMethod = null;
            this.mProcessOesMethod = null;
            this.mFreeMethod = null;
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
