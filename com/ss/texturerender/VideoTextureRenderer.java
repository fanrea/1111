package com.ss.texturerender;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.BMFVQScoreWrapper;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectFactory;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.EffectTextureManager;
import com.ss.texturerender.effect.EmptyEffect;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import com.ss.texturerender.effect.GLOesTo2DFilter;
import com.ss.texturerender.effect.HardwareBuffer2GLFilter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoTextureRenderer extends TextureRenderer {
    private static VideoTextureRenderer mRenderInstance;
    private GLDefaultFilter mCurrentDrawer;
    private Queue<Integer> mErrorList;
    private int mFinalTexId;
    private FrameBuffer mFrameBuffer;
    private ByteBuffer mFrameCallbackBufffer;
    private AbsEffect mHardwareBuffer2GLFilter;
    private AbsEffect mMultiRenderTargetFilter;
    private int mOutTexHeight;
    private int mOutTexWidth;
    private ByteBuffer mSaveFrameBuffer;
    private GLDefaultFilter mTex2dDrawer;
    private GLOesTo2DFilter mTexOesDrawer;
    private VideoSurfaceTexture mTileVideoSurfaceTexture;
    private AbsEffect mTopEffect;
    private BMFVQScoreWrapper mVqscoreWrapper;

    @Override // com.ss.texturerender.TextureRenderer
    protected void onInternalStateChanged(int i) {
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void updateDisplaySize(int i, int i2) {
    }

    private void setupGraphics() {
        try {
            GLOesTo2DFilter gLOesTo2DFilter = this.mTexOesDrawer;
            if (gLOesTo2DFilter != null) {
                gLOesTo2DFilter.release();
            }
            GLOesTo2DFilter gLOesTo2DFilter2 = (GLOesTo2DFilter) EffectFactory.createEffect(this.mTexType, 3);
            this.mTexOesDrawer = gLOesTo2DFilter2;
            if (gLOesTo2DFilter2 == null) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "create effect failed");
            } else {
                gLOesTo2DFilter2.init(null);
                this.mTexOesDrawer.setParentRender(this);
            }
        } catch (Exception e) {
            notifyEGLError(0, e.toString());
        }
    }

    private void setup2DGraphics() {
        try {
            GLDefaultFilter gLDefaultFilter = this.mTex2dDrawer;
            if (gLDefaultFilter != null) {
                gLDefaultFilter.release();
            }
            GLDefaultFilter gLDefaultFilter2 = (GLDefaultFilter) EffectFactory.createEffect(this.mTexType, 7);
            this.mTex2dDrawer = gLDefaultFilter2;
            if (gLDefaultFilter2 == null) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "create effect failed");
            } else {
                gLDefaultFilter2.init(null);
                this.mTex2dDrawer.setParentRender(this);
            }
        } catch (Exception e) {
            notifyEGLError(0, e.toString());
        }
    }

    public VideoTextureRenderer(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig, boolean z) {
        super(effectConfig, i, eGLContext, eGLConfig, z);
        this.mErrorList = new LinkedList();
        this.mSaveFrameBuffer = null;
        this.mFrameCallbackBufffer = null;
        this.mOutTexWidth = -1;
        this.mOutTexHeight = -1;
        this.mFinalTexId = -1;
        this.mTileVideoSurfaceTexture = null;
        this.mVqscoreWrapper = null;
        if (effectConfig.isOpenTile()) {
            initTileVideoSurfaceTexture();
        }
        this.mTopEffect = new EmptyEffect(i);
    }

    public VideoTextureRenderer(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig) {
        super(effectConfig, i, eGLContext, eGLConfig, false);
        this.mErrorList = new LinkedList();
        this.mSaveFrameBuffer = null;
        this.mFrameCallbackBufffer = null;
        this.mOutTexWidth = -1;
        this.mOutTexHeight = -1;
        this.mFinalTexId = -1;
        this.mTileVideoSurfaceTexture = null;
        this.mVqscoreWrapper = null;
        if (effectConfig.isOpenTile()) {
            initTileVideoSurfaceTexture();
        }
        this.mTopEffect = new EmptyEffect(i);
    }

    public VideoTextureRenderer(EffectConfig effectConfig, int i) {
        super(effectConfig, i);
        this.mErrorList = new LinkedList();
        this.mSaveFrameBuffer = null;
        this.mFrameCallbackBufffer = null;
        this.mOutTexWidth = -1;
        this.mOutTexHeight = -1;
        this.mFinalTexId = -1;
        this.mTileVideoSurfaceTexture = null;
        this.mVqscoreWrapper = null;
        this.mTopEffect = new EmptyEffect(i);
    }

    @Override // com.ss.texturerender.TextureRenderer
    public synchronized void release() {
        super.release();
        mRenderInstance = null;
    }

    public static synchronized VideoTextureRenderer getRenderer(EGLContext eGLContext, EGLConfig eGLConfig) {
        if (mRenderInstance == null) {
            mRenderInstance = new VideoTextureRenderer(new EffectConfig(0), 0, eGLContext, eGLConfig);
        }
        VideoTextureRenderer videoTextureRenderer = mRenderInstance;
        if (videoTextureRenderer != null && videoTextureRenderer.mState == -1) {
            return null;
        }
        return mRenderInstance;
    }

    public static synchronized VideoTextureRenderer getRenderer() {
        return getRenderer(null, null);
    }

    private int getConsumerWidth(EGLSurface eGLSurface) {
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            return -1;
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, eGLSurface, 12375, iArr, 0);
        return iArr[0];
    }

    private int getConsumerHeight(EGLSurface eGLSurface) {
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            return -1;
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, eGLSurface, 12374, iArr, 0);
        return iArr[0];
    }

    private boolean draw(VideoSurfaceTexture videoSurfaceTexture, int i) throws NoSuchMethodException, SecurityException {
        VideoSurface.VQScoreCallback vQScoreCallback;
        boolean z;
        EffectTexture effectTexture;
        BMFVQScoreWrapper bMFVQScoreWrapper;
        boolean zSurfaceTextureUpdateImage = surfaceTextureUpdateImage(videoSurfaceTexture);
        if (!zSurfaceTextureUpdateImage) {
            return zSurfaceTextureUpdateImage;
        }
        if (this.mErrorList != null) {
            while (!this.mErrorList.isEmpty()) {
                videoSurfaceTexture.notifyError(this.mErrorList.poll().intValue(), 0, "");
            }
        }
        if (videoSurfaceTexture.needDrop() || i == 0) {
            return false;
        }
        if (!videoSurfaceTexture.isMakeCurrent()) {
            if (videoSurfaceTexture.getRenderSurface() == null) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "texture : " + videoSurfaceTexture + " not set surface");
                if (videoSurfaceTexture.getEnableUseEglDummySurface() != 1 || this.mEGLRuntime == null) {
                    return false;
                }
                TextureRenderLog.e(this.mTexType, LOG_TAG, "create dummy surface");
                videoSurfaceTexture.createEGLWindowSurface(true);
            } else if (!this.mHandler.hasMessages(4)) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "texture : " + videoSurfaceTexture + ", retry create");
                if (!videoSurfaceTexture.createEGLWindowSurface(false)) {
                    TextureRenderLog.e(this.mTexType, LOG_TAG, "texture : " + videoSurfaceTexture + ", retry failed");
                    return false;
                }
            }
        }
        CopyOnWriteArrayList<Bundle> paramList = videoSurfaceTexture.getParamList();
        if (paramList != null) {
            Iterator<Bundle> it = paramList.iterator();
            while (it.hasNext()) {
                setEffect(it.next(), videoSurfaceTexture);
            }
        }
        boolean zHasEffectOpen = hasEffectOpen(videoSurfaceTexture);
        videoSurfaceTexture.effectChainBegin();
        EffectTexture effectTexture2 = videoSurfaceTexture.getEffectTexture();
        if (effectTexture2 == null) {
            TextureRenderLog.d(-1, LOG_TAG, "surfaceTexture.getEffectTexture() null");
            return false;
        }
        EffectTexture effectTexture3 = null;
        if (effectTexture2.getSourceType() == 2 && Build.VERSION.SDK_INT >= 21) {
            if (this.mHardwareBuffer2GLFilter == null && this.mEGLRuntime != null) {
                this.mHardwareBuffer2GLFilter = new HardwareBuffer2GLFilter(this.mTexType, this.mEGLRuntime.eglDisplay);
            }
            effectTexture2 = this.mHardwareBuffer2GLFilter.process(effectTexture2, null);
        }
        if (this.mVqscoreWrapper == null || videoSurfaceTexture.getIntOption(152) != 1) {
            vQScoreCallback = null;
            z = false;
        } else {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "enter open vqscore");
            this.mVqscoreWrapper.setSurfaceTexture(videoSurfaceTexture);
            Bundle option = videoSurfaceTexture.getOption(153);
            if (option != null) {
                vQScoreCallback = (VideoSurface.VQScoreCallback) option.getSerializable(TextureRenderKeys.KEY_IS_BMF_VQSCORE_CALLBACK);
                if (vQScoreCallback != null) {
                    this.mVqscoreWrapper.processVqscore(effectTexture2, vQScoreCallback, false);
                    z = true;
                }
                videoSurfaceTexture.setOption(152, 0);
            } else {
                vQScoreCallback = null;
            }
            z = false;
            videoSurfaceTexture.setOption(152, 0);
        }
        EffectConfig effectConfig = videoSurfaceTexture.getEffectConfig();
        AbsEffect absEffect = this.mMultiRenderTargetFilter;
        if (absEffect != null && effectConfig.getEffectOpen(absEffect.getIntOption(10005))) {
            if (effectTexture2.getTexTarget() == 36197 && this.mMultiRenderTargetFilter.getIntOption(10004) == 3553) {
                this.mTexOesDrawer.setSurfaceTexture(videoSurfaceTexture);
                effectTexture2 = this.mTexOesDrawer.process(effectTexture2, this.mFrameBuffer);
            }
            EffectTexture[] effectTextureArrProcessWithMRT = this.mMultiRenderTargetFilter.processWithMRT(effectTexture2, this.mFrameBuffer);
            if (effectTextureArrProcessWithMRT != null) {
                effectTexture2 = effectTextureArrProcessWithMRT[0];
                effectTexture3 = effectTextureArrProcessWithMRT[1];
            }
        }
        EffectTexture effectTexture4 = effectTexture3;
        if (zHasEffectOpen) {
            effectTexture2 = processEffectTexture(videoSurfaceTexture, effectTexture2);
        } else {
            videoSurfaceTexture.resetFlag();
        }
        EffectTexture effectTexture5 = effectTexture2;
        if (effectTexture5 == null) {
            videoSurfaceTexture.effectChainEnd();
            return true;
        }
        if (zHasEffectOpen && z && (bMFVQScoreWrapper = this.mVqscoreWrapper) != null) {
            bMFVQScoreWrapper.processVqscore(effectTexture5, vQScoreCallback, true);
        }
        boolean z2 = false;
        for (Map.Entry<Surface, EGLSurface> entry : videoSurfaceTexture.getExtraRealSurfaces().entrySet()) {
            EGLSurface value = entry.getValue();
            videoSurfaceTexture.makeCurrent(value);
            if (drawToSurface(effectTexture4 == null ? effectTexture5 : effectTexture4, videoSurfaceTexture, videoSurfaceTexture.getConsumerHeight(value), videoSurfaceTexture.getConsumerWidth(value), true) == 0) {
                videoSurfaceTexture.eglSwapBuffer(value, false);
                Surface key = entry.getKey();
                if (videoSurfaceTexture.getIntOption(141) == 1) {
                    videoSurfaceTexture.notifyExtraSurfaceRender(key);
                }
            }
            z2 = true;
        }
        if (effectTexture4 != null) {
            effectTexture4.giveBack();
        }
        if (!switchContextToMainSurface(videoSurfaceTexture, Boolean.valueOf(z2))) {
            return false;
        }
        this.mOutTexWidth = effectTexture5.getWidth();
        this.mOutTexHeight = effectTexture5.getHeight();
        if (videoSurfaceTexture.getFrameCallbackBundle() == null || effectTexture5.getTexTarget() == 3553) {
            effectTexture = effectTexture5;
        } else {
            if (this.mFrameBuffer == null) {
                initFbo();
            }
            this.mTexOesDrawer.setSurfaceTexture(videoSurfaceTexture);
            this.mTexOesDrawer.setOption(10006, videoSurfaceTexture.getViewportWidth());
            this.mTexOesDrawer.setOption(10007, videoSurfaceTexture.getViewportHeight());
            EffectTexture effectTextureProcess = this.mTexOesDrawer.process(effectTexture5, this.mFrameBuffer);
            if (this.mTex2dDrawer == null) {
                setup2DGraphics();
            }
            this.mFinalTexId = effectTextureProcess.getTexID();
            effectTexture = effectTextureProcess;
        }
        int iDrawToSurface = !effectConfig.getEffectOpen(18) ? drawToSurface(effectTexture, videoSurfaceTexture, videoSurfaceTexture.getViewportHeight(), videoSurfaceTexture.getViewportWidth(), false) : 0;
        videoSurfaceTexture.effectChainEnd();
        return iDrawToSurface == 0;
    }

    private boolean switchContextToMainSurface(VideoSurfaceTexture videoSurfaceTexture, Boolean bool) {
        if (!videoSurfaceTexture.isCurrentObject()) {
            if (videoSurfaceTexture.isMakeCurrent()) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "not active texture but already make current : " + videoSurfaceTexture);
                videoSurfaceTexture.makeCurrent();
                TextureRenderLog.d(this.mTexType, LOG_TAG, "texture switch surface & playing ");
                return true;
            }
            TextureRenderLog.e(this.mTexType, LOG_TAG, "tex: " + videoSurfaceTexture + " not current object id " + videoSurfaceTexture.getOjbectId());
            videoSurfaceTexture.effectChainEnd();
            return false;
        }
        if (!bool.booleanValue()) {
            return true;
        }
        videoSurfaceTexture.makeCurrent();
        return true;
    }

    private boolean surfaceTextureUpdateImage(VideoSurfaceTexture videoSurfaceTexture) {
        try {
            if (videoSurfaceTexture == null) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "surface texture is null not draw");
                return false;
            }
            videoSurfaceTexture.lock();
            if (videoSurfaceTexture.isRelease()) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "surface texture is released not draw");
                return false;
            }
            videoSurfaceTexture.updateTexImage();
            videoSurfaceTexture.mFrameReady = false;
            videoSurfaceTexture.unlock();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TextureRenderLog.d(this.mTexType, LOG_TAG, "surface texture no draw" + e.toString());
            return false;
        } finally {
            videoSurfaceTexture.unlock();
        }
    }

    private boolean hasEffectOpen(VideoSurfaceTexture videoSurfaceTexture) {
        ConcurrentHashMap<Integer, Integer> effectConfigMap = this.mEffectConfig.getEffectConfigMap();
        EffectConfig effectConfig = videoSurfaceTexture.getEffectConfig();
        for (Map.Entry<Integer, Integer> entry : effectConfigMap.entrySet()) {
            if (entry.getValue().intValue() == 1 && effectConfig.getEffectOpen(entry.getKey().intValue())) {
                return true;
            }
        }
        return false;
    }

    private EffectTexture processEffectTexture(VideoSurfaceTexture videoSurfaceTexture, EffectTexture effectTexture) {
        videoSurfaceTexture.effectChainBegin();
        EffectConfig effectConfig = videoSurfaceTexture.getEffectConfig();
        EffectTexture effectTextureProcess = effectTexture;
        for (AbsEffect nextEffect = this.mTopEffect.getNextEffect(); nextEffect != null; nextEffect = nextEffect.getNextEffect()) {
            int intOption = nextEffect.getIntOption(10005);
            if (effectConfig.getEffectOpen(intOption)) {
                if (effectTextureProcess.getTexTarget() == 36197 && nextEffect.getIntOption(10004) == 3553 && !effectConfig.getEffectOpen(18)) {
                    if (this.mTexType == 1) {
                        this.mTexOesDrawer.resetCropParams();
                    }
                    this.mTexOesDrawer.setSurfaceTexture(videoSurfaceTexture);
                    if (DeviceManager.isVRDevice()) {
                        effectTexture.switchFilterType(EffectTexture.FilterType.NEAREST, EffectTexture.FilterType.NEAREST);
                    }
                    if (this.mFrameBuffer == null) {
                        TextureRenderLog.i(this.mTexType, LOG_TAG, "init fbo before oesTo2d process");
                        initFbo();
                    }
                    effectTextureProcess = this.mTexOesDrawer.process(effectTextureProcess, this.mFrameBuffer);
                    if (DeviceManager.isVRDevice()) {
                        effectTexture.switchFilterType(EffectTexture.FilterType.LINEAR, EffectTexture.FilterType.LINEAR);
                    }
                }
                nextEffect.setSurfaceTexture(videoSurfaceTexture);
                if (nextEffect.getIntOption(10005) == 18) {
                    nextEffect.setOption(10006, videoSurfaceTexture.getViewportWidth());
                    nextEffect.setOption(10007, videoSurfaceTexture.getViewportHeight());
                }
                if (videoSurfaceTexture.getExtraVideoSurfaceTexture() != null) {
                    VideoSurfaceTexture extraVideoSurfaceTexture = videoSurfaceTexture.getExtraVideoSurfaceTexture();
                    effectTextureProcess.setExtraEffectTexture(new EffectTexture[]{new EffectTexture((EffectTextureManager) null, extraVideoSurfaceTexture.getTexId().lock(), extraVideoSurfaceTexture.getTexWidth(), extraVideoSurfaceTexture.getTexHeight(), 36197)});
                    extraVideoSurfaceTexture.getTexId().unlock();
                }
                if (!DeviceManager.isVRDevice() ? checkDirectRenderToScreen(nextEffect, videoSurfaceTexture) : false) {
                    switchContextToMainSurface(videoSurfaceTexture, false);
                }
                effectTextureProcess = nextEffect.process(effectTextureProcess, this.mFrameBuffer);
            } else {
                videoSurfaceTexture.setOption(19, intOption, 0);
            }
        }
        videoSurfaceTexture.effectChainEnd();
        return effectTextureProcess;
    }

    private int drawToSurface(EffectTexture effectTexture, VideoSurfaceTexture videoSurfaceTexture, int i, int i2, boolean z) {
        GLDefaultFilter gLDefaultFilter;
        if (effectTexture.getTexTarget() == 3553) {
            gLDefaultFilter = this.mTex2dDrawer;
        } else {
            gLDefaultFilter = this.mTexOesDrawer;
        }
        this.mCurrentDrawer = gLDefaultFilter;
        if (gLDefaultFilter == null) {
            return -1;
        }
        gLDefaultFilter.setSurfaceTexture(videoSurfaceTexture);
        gLDefaultFilter.setOption(26, videoSurfaceTexture.mLayoutMode);
        gLDefaultFilter.setOption(27, videoSurfaceTexture.mLayoutRatio);
        if (videoSurfaceTexture.getIntOption(146) == 1) {
            gLDefaultFilter.setOption(30, videoSurfaceTexture.mIsMirrorHorizontal);
            gLDefaultFilter.setOption(31, videoSurfaceTexture.mIsMirrorVertical);
            gLDefaultFilter.setOption(29, videoSurfaceTexture.mRotationType);
        } else {
            gLDefaultFilter.setOption(29, videoSurfaceTexture.mRotationType);
            gLDefaultFilter.setOption(30, videoSurfaceTexture.mIsMirrorHorizontal);
            gLDefaultFilter.setOption(31, videoSurfaceTexture.mIsMirrorVertical);
        }
        gLDefaultFilter.setOption(10006, i2);
        gLDefaultFilter.setOption(10007, i);
        if (this.mTexType == 1) {
            Bundle cropParamsBundle = videoSurfaceTexture.getCropParamsBundle(z);
            if (cropParamsBundle != null) {
                gLDefaultFilter.setOption(cropParamsBundle);
            } else if (!z && videoSurfaceTexture.getIntOption(171) == 1) {
                gLDefaultFilter.resetCropParams();
            }
        }
        gLDefaultFilter.process(effectTexture, null);
        return gLDefaultFilter.getIntOption(20005);
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void initGLComponents() {
        if (this.mState == -1) {
            return;
        }
        setupGraphics();
        if (this.mEffectConfig.isOpenSR()) {
            setup2DGraphics();
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void deinitGLComponents() {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "delete program");
        this.mCurrentDrawer = null;
        GLOesTo2DFilter gLOesTo2DFilter = this.mTexOesDrawer;
        if (gLOesTo2DFilter != null) {
            gLOesTo2DFilter.release();
            this.mTexOesDrawer = null;
        }
        GLDefaultFilter gLDefaultFilter = this.mTex2dDrawer;
        if (gLDefaultFilter != null) {
            gLDefaultFilter.release();
            this.mTex2dDrawer = null;
        }
        FrameBuffer frameBuffer = this.mFrameBuffer;
        if (frameBuffer != null) {
            frameBuffer.release();
            this.mFrameBuffer = null;
        }
        if (this.mEffectTextureManager != null) {
            this.mEffectTextureManager.release();
            this.mEffectTextureManager = null;
        }
        AbsEffect absEffect = this.mHardwareBuffer2GLFilter;
        if (absEffect != null) {
            absEffect.release();
            this.mHardwareBuffer2GLFilter = null;
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void deinitEffectComponents() {
        for (AbsEffect absEffectRelease = this.mTopEffect.release(); absEffectRelease != null; absEffectRelease = absEffectRelease.release()) {
            this.mEffectConfig.setEffectOpen(absEffectRelease.getIntOption(10005), 0);
        }
        if (this.mEffectConfig != null && this.mVqscoreWrapper != null) {
            this.mEffectConfig.setEffectOpen(16, 0);
            this.mVqscoreWrapper.release();
        }
        AbsEffect absEffect = this.mMultiRenderTargetFilter;
        if (absEffect != null) {
            absEffect.release();
            this.mMultiRenderTargetFilter = null;
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void handleGLThreadMessage(Message message) throws NoSuchMethodException, SecurityException {
        int i = message.what;
        if (i != 12) {
            if (i == 25) {
                Bundle data = message.getData();
                Surface surface = (Surface) data.getParcelable(VideoSurfaceTexture.KEY_SURFACE);
                VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) data.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
                if (message.arg1 == 1) {
                    videoSurfaceTexture.initExtraSurface(surface);
                    return;
                } else if (message.arg1 == 2) {
                    videoSurfaceTexture.releaseExtraSurface(surface);
                    return;
                } else {
                    if (message.arg1 == 3) {
                        videoSurfaceTexture.releaseAllExtraSurface();
                        return;
                    }
                    return;
                }
            }
            if (i == 26) {
                VideoSurfaceTexture videoSurfaceTexture2 = (VideoSurfaceTexture) message.obj;
                if (videoSurfaceTexture2 != null) {
                    videoSurfaceTexture2.handleUpdateVideoState(message.arg1);
                }
                this.mTopEffect.setOption(1, message.arg1);
                return;
            }
            switch (i) {
                case 34:
                    _setValueToElement(message.arg1, message.arg2);
                    break;
                case 35:
                    Bundle data2 = message.getData();
                    if (data2 != null) {
                        _setValueToElement(message.arg1, data2.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE));
                        break;
                    }
                    break;
                case 36:
                    break;
                default:
                    switch (i) {
                        case 40:
                            resetCropParams();
                            break;
                        case 41:
                            this.mTopEffect.setOption(message.arg1, message.obj);
                            break;
                        case 42:
                            resetRotationMirrorParams();
                            break;
                    }
            }
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setEffect bundle:" + message.getData() + " surfacetexture:" + message.obj);
        setEffect(message.getData(), (VideoSurfaceTexture) message.obj);
    }

    private void _setValueToElement(int i, int i2) {
        this.mTopEffect.setOption(i, i2);
    }

    private void _setValueToElement(int i, float f) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "_setValueToElement key:" + i + ", value:" + f);
        this.mTopEffect.setOption(i, f);
    }

    private void initFbo() {
        if (this.mFrameBuffer == null) {
            this.mFrameBuffer = new FrameBuffer();
        }
        if (this.mEffectTextureManager == null) {
            this.mEffectTextureManager = new EffectTextureManager(this.mTexType);
        }
    }

    private void resetCropParams() {
        GLOesTo2DFilter gLOesTo2DFilter = this.mTexOesDrawer;
        if (gLOesTo2DFilter != null) {
            gLOesTo2DFilter.resetCropParams();
        }
        GLDefaultFilter gLDefaultFilter = this.mTex2dDrawer;
        if (gLDefaultFilter != null) {
            gLDefaultFilter.resetCropParams();
        }
    }

    private void resetRotationMirrorParams() {
        GLOesTo2DFilter gLOesTo2DFilter = this.mTexOesDrawer;
        if (gLOesTo2DFilter != null) {
            gLOesTo2DFilter.setOption(30, 0);
            this.mTexOesDrawer.setOption(31, 0);
            this.mTexOesDrawer.setOption(29, 0);
            this.mTexOesDrawer.setOption(26, 1);
        }
        GLDefaultFilter gLDefaultFilter = this.mTex2dDrawer;
        if (gLDefaultFilter != null) {
            gLDefaultFilter.setOption(30, 0);
            this.mTex2dDrawer.setOption(31, 0);
            this.mTex2dDrawer.setOption(29, 0);
            this.mTex2dDrawer.setOption(26, 1);
        }
    }

    private void setEffect(Bundle bundle, VideoSurfaceTexture videoSurfaceTexture) throws NoSuchMethodException, SecurityException {
        if (bundle == null) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "set effect but missing bundle?");
            return;
        }
        int i = bundle.getInt("action");
        if (i == 21) {
            initEffect(bundle, videoSurfaceTexture);
            return;
        }
        if (i == 32) {
            releaseEffect(bundle, videoSurfaceTexture);
            return;
        }
        if (i == 151) {
            BMFVQScoreWrapper bMFVQScoreWrapper = this.mVqscoreWrapper;
            if (bMFVQScoreWrapper != null) {
                bMFVQScoreWrapper.init(bundle);
                return;
            }
            return;
        }
        AbsEffect effect = getEffect(bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE));
        if (effect != null) {
            effect.setOption(bundle);
        }
    }

    private int initEffect(Bundle bundle, VideoSurfaceTexture videoSurfaceTexture) throws NoSuchMethodException, SecurityException {
        AbsEffect effect;
        int iInit;
        int i = bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE);
        TextureRenderLog.d(this.mTexType, LOG_TAG, "initeffect:" + i);
        if (i == 1 || i == 5) {
            effect = getEffect(i);
            if (effect == null && (effect = EffectFactory.createEffect(this.mTexType, i)) == null) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "create effect failed");
                return -1;
            }
            if (!checkUseOesFormat(effect) || DeviceManager.isVRDevice()) {
                initFbo();
                bundle.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 3553);
            } else {
                bundle.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 36197);
            }
            effect.setSurfaceTexture(videoSurfaceTexture);
            iInit = effect.init(bundle);
            if (iInit < 0) {
                effect.release();
                effect = null;
                this.mErrorList.offer(Integer.valueOf(i == 5 ? 1 : 3));
            }
        } else {
            if (i == 11) {
                this.mTexOesDrawer.setOption(bundle);
                initFbo();
                checkUseOesFormat(this.mTexOesDrawer);
                this.mEffectConfig.setEffectOpen(i, 1);
                return 0;
            }
            if (i == 16) {
                if (this.mVqscoreWrapper == null) {
                    BMFVQScoreWrapper bMFVQScoreWrapper = (BMFVQScoreWrapper) EffectFactory.createEffect(this.mTexType, i);
                    this.mVqscoreWrapper = bMFVQScoreWrapper;
                    if (bMFVQScoreWrapper != null) {
                        bMFVQScoreWrapper.setSurfaceTexture(videoSurfaceTexture);
                        this.mVqscoreWrapper.setParentRender(this);
                        this.mVqscoreWrapper.downloadModel(bundle);
                    }
                }
                return 0;
            }
            effect = getEffect(i);
            if (effect == null) {
                effect = EffectFactory.createEffect(this.mTexType, i);
            }
            if (effect == null) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "create effect fail" + i);
                return -1;
            }
            effect.setSurfaceTexture(videoSurfaceTexture);
            effect.setParentRender(this);
            bundle.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, checkUseOesFormat(effect) ? 36197 : 3553);
            iInit = effect.init(bundle);
            if (i == 22) {
                this.mMultiRenderTargetFilter = effect;
            }
        }
        if (effect != null) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "initeffect successful:" + i);
            this.mEffectConfig.setEffectOpen(i, 1);
            if (this.mTex2dDrawer == null) {
                setup2DGraphics();
            }
            if (bundle.containsKey(TextureRenderKeys.KEY_IS_EFFECT_ORDER)) {
                effect.setOption(10011, bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_ORDER));
            }
            if (getEffect(i) == null) {
                this.mTopEffect.insertEffect(effect);
            }
            if (i != 1 && i != 5) {
                initFbo();
            }
            if (videoSurfaceTexture != null && bundle.containsKey(TextureRenderKeys.KEY_IS_USE_EFFECT)) {
                videoSurfaceTexture.setEffectOpen(i, bundle.getInt(TextureRenderKeys.KEY_IS_USE_EFFECT), bundle);
            }
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "initEffect render:" + this + ",chain:" + this.mTopEffect.toString());
        return iInit;
    }

    private boolean checkUseOesFormat(AbsEffect absEffect) {
        boolean z;
        if (absEffect == null) {
            return false;
        }
        AbsEffect nextEffect = this.mMultiRenderTargetFilter;
        if (nextEffect == null) {
            nextEffect = this.mTopEffect.getNextEffect();
        }
        if (nextEffect == null || nextEffect == absEffect) {
            z = true;
        } else if (absEffect.getIntOption(10011) >= nextEffect.getIntOption(10011)) {
            if (nextEffect.getIntOption(10004) == 36197) {
                int intOption = nextEffect.getIntOption(10005);
                if (reInitIfNeed(intOption, 3553) != 0) {
                    if (intOption == 5) {
                        this.mErrorList.offer(1);
                    } else if (intOption == 1) {
                        this.mErrorList.offer(3);
                    } else {
                        this.mErrorList.offer(6);
                    }
                }
            }
            z = true;
        } else {
            z = false;
        }
        return z && absEffect.getIntOption(10014) == 1 && !this.mEffectConfig.getEffectOpen(11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    private boolean checkDirectRenderToScreen(AbsEffect absEffect, VideoSurfaceTexture videoSurfaceTexture) {
        if (absEffect == 0) {
            return false;
        }
        boolean z = true;
        HashMap<Surface, EGLSurface> extraRealSurfaces = videoSurfaceTexture.getExtraRealSurfaces();
        if (extraRealSurfaces != null && !extraRealSurfaces.isEmpty()) {
            z = false;
        }
        if (videoSurfaceTexture.mRotationType != 0 || videoSurfaceTexture.mIsMirrorHorizontal != 0 || videoSurfaceTexture.mIsMirrorVertical != 0 || videoSurfaceTexture.getCropParamsBundle(false) != null) {
            z = false;
        }
        ?? r0 = absEffect.getNextEffect() == null ? z : 0;
        absEffect.setOption(10015, (int) r0);
        return r0;
    }

    private void releaseEffect(Bundle bundle, VideoSurfaceTexture videoSurfaceTexture) {
        if (bundle == null) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "releaseEffect bundle null");
            return;
        }
        int i = bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE);
        if (i == 24) {
            if (videoSurfaceTexture != null) {
                for (AbsEffect nextEffect = this.mTopEffect.getNextEffect(); nextEffect != null; nextEffect = nextEffect.getNextEffect()) {
                    videoSurfaceTexture.setOption(19, nextEffect.getIntOption(10005), 0);
                }
            }
            deinitEffectComponents();
        } else {
            AbsEffect effect = getEffect(i);
            if (effect != null) {
                effect.release();
            }
            this.mEffectConfig.setEffectOpen(i, 0);
            if (videoSurfaceTexture != null) {
                videoSurfaceTexture.setOption(19, i, 0);
            }
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "releaseEffect render:" + this + " type:" + i + " chain:" + this.mTopEffect);
    }

    private AbsEffect getEffect(int i) {
        AbsEffect absEffect = this.mMultiRenderTargetFilter;
        if (absEffect != null && i == absEffect.getIntOption(10005)) {
            return this.mMultiRenderTargetFilter;
        }
        for (AbsEffect nextEffect = this.mTopEffect.getNextEffect(); nextEffect != null; nextEffect = nextEffect.getNextEffect()) {
            if (nextEffect.getIntOption(10005) == i) {
                return nextEffect;
            }
        }
        return null;
    }

    private int reInitIfNeed(int i, int i2) {
        AbsEffect effect = getEffect(i);
        if (effect == null || effect.getIntOption(10004) == i2) {
            return 0;
        }
        Bundle initBundle = effect.getInitBundle();
        if (initBundle != null) {
            initBundle.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, i2);
        }
        int iInit = effect.init(initBundle);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "reInit, effectType:" + i + ",texTarget:" + TexGLUtils.texTargetToString(i2));
        if (iInit == 0) {
            return 0;
        }
        effect.release();
        return iInit;
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void handleSetSurface(Message message) {
        Bundle data = message.getData();
        if (data == null) {
            throw new RuntimeException("update surface but missing bundle?");
        }
        VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) data.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        if (videoSurfaceTexture == null) {
            throw new RuntimeException("update surface but missing texture");
        }
        if (videoSurfaceTexture.handleSurfaceChange(message)) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "texture switch surface & playing");
        }
        Object obj = message.obj;
        if (obj != null) {
            synchronized (obj) {
                obj.notify();
            }
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "set surface done");
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void handleFrameAvailable(Message message) throws NoSuchMethodException, SecurityException {
        if (message == null) {
            return;
        }
        VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) message.obj;
        if (videoSurfaceTexture == this.mTileVideoSurfaceTexture) {
            updateTexImage(videoSurfaceTexture);
            return;
        }
        if (videoSurfaceTexture != null && this.mEGLRuntime != null) {
            videoSurfaceTexture.checkGeometry();
        }
        this.mCheckDispatcher.onSurfaceTextureCallbackCalled(videoSurfaceTexture);
        this.mCheckDispatcher.onFrameCome(videoSurfaceTexture);
        boolean zDraw = draw(videoSurfaceTexture, message.arg1);
        frameBufferCallback(message);
        if (zDraw) {
            saveImage(message);
            zDraw = videoSurfaceTexture.render();
        }
        float fElapsedRealtime = SystemClock.elapsedRealtime();
        float floatOption = videoSurfaceTexture.getFloatOption(123);
        int intOption = videoSurfaceTexture.getIntOption(121);
        float floatOption2 = videoSurfaceTexture.getFloatOption(122);
        if (zDraw) {
            intOption++;
        }
        if (intOption > 1) {
            floatOption2 += fElapsedRealtime - floatOption;
        }
        videoSurfaceTexture.setOption(121, intOption);
        videoSurfaceTexture.setOption(122, floatOption2);
        videoSurfaceTexture.setOption(123, fElapsedRealtime);
        if (floatOption2 > 0.0f && intOption > 0) {
            videoSurfaceTexture.setOption(120, ((intOption - 1) * 1000.0f) / floatOption2);
        }
        if (zDraw) {
            this.mCheckDispatcher.onDrawSucceed(videoSurfaceTexture);
        }
        if (message.arg2 != 1 || videoSurfaceTexture == null) {
            return;
        }
        synchronized (videoSurfaceTexture) {
            videoSurfaceTexture.notify();
        }
    }

    private void saveImage(Message message) {
        int iRound;
        int iRound2;
        int intOption;
        int intOption2;
        int i;
        int i2;
        ByteBuffer byteBufferAllocateDirect;
        GLDefaultFilter gLDefaultFilter;
        VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) message.obj;
        Bundle data = message.getData();
        VideoSurface.SaveFrameCallback saveFrameCallback = (VideoSurface.SaveFrameCallback) data.getSerializable(TextureRenderKeys.KEY_IS_CALLBACK);
        if (saveFrameCallback != null) {
            try {
                int viewportWidth = videoSurfaceTexture.getViewportWidth();
                int viewportHeight = videoSurfaceTexture.getViewportHeight();
                if (!data.getBoolean(TextureRenderKeys.KEY_IS_ORIGIN_VIDEO, false) || (gLDefaultFilter = this.mCurrentDrawer) == null) {
                    iRound = 0;
                    iRound2 = 0;
                    intOption = viewportWidth;
                    intOption2 = viewportHeight;
                } else {
                    iRound = gLDefaultFilter.getIntOption(20003);
                    iRound2 = this.mCurrentDrawer.getIntOption(20004);
                    intOption = this.mCurrentDrawer.getIntOption(20001);
                    intOption2 = this.mCurrentDrawer.getIntOption(20002);
                }
                float f = data.getFloat("width", -1.0f);
                if (f > 0.0f) {
                    float f2 = viewportWidth;
                    int iRound3 = Math.round(f * f2);
                    float f3 = viewportHeight;
                    int iRound4 = Math.round(data.getFloat("height") * f3);
                    iRound = Math.round(data.getFloat("x") * f2);
                    i2 = iRound4;
                    i = iRound3;
                    iRound2 = Math.round(data.getFloat("y") * f3);
                } else {
                    i = intOption;
                    i2 = intOption2;
                }
                TextureRenderLog.i(this.mTexType, LOG_TAG, "async saveframe = " + i + ", " + i2 + " viewW:" + viewportWidth + " viewH:" + viewportHeight);
                int i3 = i * i2 * 4;
                if (data.getBoolean(TextureRenderKeys.KEY_IS_REUSE_BUFFER)) {
                    ByteBuffer byteBuffer = this.mSaveFrameBuffer;
                    if (byteBuffer == null || byteBuffer.capacity() < i3) {
                        this.mSaveFrameBuffer = ByteBuffer.allocateDirect(i3);
                    }
                    byteBufferAllocateDirect = this.mSaveFrameBuffer;
                } else {
                    byteBufferAllocateDirect = ByteBuffer.allocateDirect(i3);
                }
                byteBufferAllocateDirect.rewind();
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                GLES20.glFinish();
                GLES20.glReadPixels(iRound, iRound2, i, i2, 6408, 5121, byteBufferAllocateDirect);
                int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "handleSaveFrame");
                if (iCheckGLError != 0) {
                    videoSurfaceTexture.notifyError(iCheckGLError, 0, "handleSaveFrame");
                }
                byteBufferAllocateDirect.rewind();
                int i4 = i * 4;
                byte[] bArr = new byte[i4];
                for (int i5 = 0; i5 < i2 / 2; i5++) {
                    byteBufferAllocateDirect.get(bArr);
                    System.arraycopy(byteBufferAllocateDirect.array(), byteBufferAllocateDirect.limit() - byteBufferAllocateDirect.position(), byteBufferAllocateDirect.array(), byteBufferAllocateDirect.position() - i4, i4);
                    System.arraycopy(bArr, 0, byteBufferAllocateDirect.array(), byteBufferAllocateDirect.limit() - byteBufferAllocateDirect.position(), i4);
                }
                byteBufferAllocateDirect.rewind();
                saveFrameCallback.onFrame(byteBufferAllocateDirect, i, i2);
            } catch (Exception e) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "save frame failed " + e.getMessage());
                saveFrameCallback.onFrame(null, 0, 0);
            }
        }
    }

    private void initTileVideoSurfaceTexture() {
        ITexture texture = getTexture();
        if (texture != null) {
            VideoSurfaceTexture videoSurfaceTexture = new VideoSurfaceTexture(texture, this.mHandler, this);
            videoSurfaceTexture.setEffectOpen(18, 1, null);
            videoSurfaceTexture.setOption(5, this.mTexType);
            videoSurfaceTexture.bindEGLEnv(this.mEGLRuntime);
            texture.decRef();
            this.mTileVideoSurfaceTexture = videoSurfaceTexture;
            return;
        }
        TextureRenderLog.d(this.mTexType, LOG_TAG, "tile surface texture init failed");
    }

    @Override // com.ss.texturerender.TextureRenderer
    public VideoSurfaceTexture getExtraVideoSurfaceTexture() {
        return this.mTileVideoSurfaceTexture;
    }

    private boolean updateTexImage(VideoSurfaceTexture videoSurfaceTexture) {
        try {
            try {
                videoSurfaceTexture.lock();
                if (videoSurfaceTexture.isRelease()) {
                    TextureRenderLog.d(this.mTexType, LOG_TAG, "surface texture is released not draw");
                }
                videoSurfaceTexture.updateTexImage();
                videoSurfaceTexture.unlock();
                return !videoSurfaceTexture.needDrop();
            } catch (Exception e) {
                e.printStackTrace();
                videoSurfaceTexture.unlock();
                return false;
            }
        } catch (Throwable th) {
            videoSurfaceTexture.unlock();
            throw th;
        }
    }

    private void frameBufferCallback(Message message) {
        ByteBuffer byteBufferAllocateDirect;
        int i;
        VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) message.obj;
        Bundle frameCallbackBundle = videoSurfaceTexture.getFrameCallbackBundle();
        if (frameCallbackBundle != null) {
            VideoSurface.FrameRenderCallback frameRenderCallback = (VideoSurface.FrameRenderCallback) frameCallbackBundle.getSerializable(TextureRenderKeys.KEY_IS_CALLBACK);
            int i2 = this.mOutTexWidth;
            int i3 = this.mOutTexHeight;
            int i4 = frameCallbackBundle.getInt(TextureRenderKeys.KEY_IS_BUFFER_TYPE);
            try {
                if (i4 != 2) {
                    if (i4 == 1) {
                        frameRenderCallback.onTextureCallback(6408, 2, this.mFinalTexId, this.mEGLRuntime.eglContext, i2, i3, System.currentTimeMillis());
                        return;
                    }
                    return;
                }
                int i5 = i2 * i3 * 4;
                if (frameCallbackBundle.getBoolean(TextureRenderKeys.KEY_IS_REUSE_BUFFER)) {
                    ByteBuffer byteBuffer = this.mFrameCallbackBufffer;
                    if (byteBuffer == null || byteBuffer.capacity() < i5) {
                        this.mFrameCallbackBufffer = ByteBuffer.allocateDirect(i5);
                    }
                    byteBufferAllocateDirect = this.mFrameCallbackBufffer;
                } else {
                    byteBufferAllocateDirect = ByteBuffer.allocateDirect(i5);
                }
                byteBufferAllocateDirect.rewind();
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                GLES20.glFinish();
                FrameBuffer frameBuffer = this.mFrameBuffer;
                if (frameBuffer != null && (i = this.mFinalTexId) != -1) {
                    frameBuffer.bindTexture2D(i);
                }
                GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, byteBufferAllocateDirect);
                FrameBuffer frameBuffer2 = this.mFrameBuffer;
                if (frameBuffer2 != null) {
                    frameBuffer2.unbindTexture2D();
                }
                int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "handleFrameCallback");
                if (iCheckGLError != 0) {
                    videoSurfaceTexture.notifyError(iCheckGLError, 0, "handleFrameCallback");
                }
                byteBufferAllocateDirect.rewind();
                int i6 = i2 * 4;
                byte[] bArr = new byte[i6];
                for (int i7 = 0; i7 < i3 / 2; i7++) {
                    byteBufferAllocateDirect.get(bArr);
                    System.arraycopy(byteBufferAllocateDirect.array(), byteBufferAllocateDirect.limit() - byteBufferAllocateDirect.position(), byteBufferAllocateDirect.array(), byteBufferAllocateDirect.position() - i6, i6);
                    System.arraycopy(bArr, 0, byteBufferAllocateDirect.array(), byteBufferAllocateDirect.limit() - byteBufferAllocateDirect.position(), i6);
                }
                byteBufferAllocateDirect.rewind();
                frameRenderCallback.onBytebufferCallbck(2, byteBufferAllocateDirect, i2, i3, System.currentTimeMillis());
            } catch (Exception e) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "frame callback failed " + e.getMessage());
                if (i4 == 2) {
                    frameRenderCallback.onBytebufferCallbck(-1, null, -1, -1, System.currentTimeMillis());
                } else {
                    frameRenderCallback.onTextureCallback(-1, -1, -1, null, -1, -1, System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    public Object getOption(Bundle bundle) {
        AbsEffect effect = getEffect(bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE));
        if (effect != null) {
            return effect.getOption(bundle);
        }
        return null;
    }
}
