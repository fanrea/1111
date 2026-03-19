package com.ss.texturerender;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import com.alipay.sdk.m.u.i;
import com.kuaishou.socket.nano.SocketMessages;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.base.EGLRuntime;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.EffectTextureManager;
import com.ss.texturerender.math.Quaternion;
import com.ss.texturerender.overlay.FrameTimeQueue;
import com.ss.texturerender.producer.IFrameProducer;
import com.ss.texturerender.producer.ImageReaderProducer;
import com.ss.texturerender.touch.TouchHelper;
import com.ss.texturerender.vsync.IVsyncCallback;
import com.ss.texturerender.vsync.IVsyncHelper;
import com.ss.texturerender.vsync.VsyncHelperFactory;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoSurfaceTexture extends SurfaceTexture implements Serializable, TextureRenderer.OnTextureFocusLossListener, IVsyncCallback {

    @Deprecated
    public static final int ERROR_SR_EXE_FAIL = 2;

    @Deprecated
    public static final int ERROR_SR_INIT_FAIL = 1;
    private static final long FORCE_EXIPRE_TIME_MS = 120000;
    public static final String KEY_QUATERNION_W = "quaternion_w";
    public static final String KEY_QUATERNION_X = "quaternion_x";
    public static final String KEY_QUATERNION_Y = "quaternion_y";
    public static final String KEY_QUATERNION_Z = "quaternion_z";
    public static final String KEY_SURFACE = "surface";
    public static final String KEY_TEXTURE = "texture";
    public static final String KEY_TIME = "timeStamp";
    private static final int MAX_DROP_COUNT = 5;
    protected static final int SUPER_RES_CLOSE = 0;
    protected static final int SUPER_RES_OPEN = 1;
    protected static final String TAG = "VideoSurfaceTexture";
    protected static final long TIME_UNSET = -9223372036854775807L;
    protected double mAccumulatedPlayingTime;
    private int mBitDepth;
    protected EffectConfig mConfig;
    private Looper mCreateLooper;
    private int mCurrentEffectProcessDepth;
    private double mCurrentEffectStartTime;
    private int mDataSpace;
    private int mDoMirrorFirst;
    protected int mDropCount;
    private EGLRuntime mEGLRuntime;
    private double mEffectChainAccumulatedTime;
    private float mEffectChainAverageTime;
    private int mEffectChainFrameCount;
    private double mEffectChainStartTime;
    protected EffectTexture mEffectTexture;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    private int mEnableExtraSurfaceRenderCallback;
    private int mEnableNativeWindow;
    private int mEnableResetCropParamsInRender;
    private int mEnableUseEglDummySurface;
    private Bundle mExtraRenderCropParamsBundle;
    private HashMap<Surface, EGLSurface> mExtraSurfaceMap;
    protected float mFPS;
    private int mForbidReuseVideoSurfaceTexture;
    private VideoSurface.SaveFrameCallback mFrameCallback;
    private Bundle mFrameCallbackBundle;
    private int mFrameCallbackInRenderThread;
    private int mFrameCount;
    private List<FrameMetaData> mFrameMetaData;
    private IFrameProducer mFrameProducer;
    public boolean mFrameReady;
    private int mFreezeDirector;
    private int mHDRType;
    Quaternion mHeadPose;
    public int mHeadposeCallbackIntegral;
    protected long mIdleTimeStamp;
    private boolean mIgnoreSRResCheck;
    private boolean mIsMakeCurrent;
    public volatile int mIsMirrorHorizontal;
    public volatile int mIsMirrorVertical;
    private boolean mIsPaused;
    private boolean mIsPreRender;
    protected volatile boolean mIsRelease;
    private volatile int mLastComeFrameType;
    protected double mLastFrameTime;
    public volatile int mLayoutMode;
    public volatile float mLayoutRatio;
    private ReentrantLock mLock;
    private Bundle mMainRenderCropParamsBundle;
    private NativeWindow mNativeWindow;
    private int mNotKeepLastParams;
    private long mObjectId;
    protected VideoSurface mOffScreenSurface;
    private MyOnFrameAvailableListener mOnFrameAvailableListener;
    private int mOpenVQScore;
    private CopyOnWriteArrayList<Bundle> mParamList;
    private HashMap<Integer, Double> mPerEffectAccumulatedTime;
    private HashMap<Integer, Float> mPerEffectAverageTime;
    private HashMap<Integer, Integer> mPerEffectFrameCount;
    private int mRGBBitsFromEGLConfig;
    private Handler mRenderHandler;
    private Bundle mRenderMsgBundle;
    private Surface mRenderSurface;
    private Bundle mRoiSRParamsBundle;
    public volatile int mRotationType;
    private float mSRProcessAverageCostTime;
    private Bundle mSRProcessParamter;
    private int mSRProcessScaleType;
    private volatile float mSRProcessSuccessRate;
    private Bundle mSaveFrameBundle;
    private int mSerial;
    private long mStartPlayTimeNanos;
    private int mState;
    private List<Integer> mStaticMetadata;
    private volatile int mSuperOpen;
    private Message mSyncMsg;
    private int mSyncSetVsync;
    private int mSyncUpdateSurface;
    private int mTexHeight;
    protected int mTexType;
    private int mTexWidth;
    private ITexture mTextureId;
    private LinkedList<EffectTexture> mTextureQueue;
    protected TextureRenderer mTextureRenderer;
    private long mTid;
    private TouchHelper mTouchHelper;
    private HashMap<Integer, Integer> mTrackingErrorCode;
    private HashMap<Integer, String> mTrackingErrorMsg;
    private Surface mUpdateSurface;
    private long mUpdateSurfaceTime;
    private HashMap<Integer, Integer> mUsingEffect;
    private Bundle mVQScoreBundle;
    private float mVQScoreProcessAverageCostTime;
    private float mVQScoreProcessSuccessRate;
    private int mViewportHeight;
    private int mViewportWidth;
    protected IVsyncHelper mVsyncHelper;
    private static int[] resWdithTab = {480, 540, 544, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND};
    private static int[] resHeightTab = {SocketMessages.PayloadType.SC_LIVE_FANS_GROUP_ATTACH_GIFT_REPLACE_NOTICE, 960, 960, 1024, 648, 1016};

    public interface TextureDrawCallback {
        void onTextureUpdate(int i, float f, float f2, float f3, float f4);

        void onTextureUpdate(int i, long j);

        void onTextureUpdate(int i, Surface surface, long j);
    }

    public interface TextureErrorCallback {
        void onTextureRenderError(int i, int i2, String str);
    }

    protected void releaseOther() {
    }

    public static class FrameMetaData {
        private Map<Integer, String> mFrameMetaData;
        private long mMasterClockDiff;
        private long mPts;
        private long mReleaseNanoTime;

        public FrameMetaData(long j, long j2, long j3, Map<Integer, String> map) {
            this.mPts = j;
            this.mReleaseNanoTime = j2;
            this.mMasterClockDiff = j3;
            this.mFrameMetaData = map;
        }

        public String getStringifiedTileInfo() {
            Map<Integer, String> map = this.mFrameMetaData;
            if (map == null) {
                return null;
            }
            return map.get(74);
        }

        public long getReleaseNanoTime() {
            return this.mReleaseNanoTime;
        }
    }

    public void effectChainBegin() {
        this.mEffectChainStartTime = SystemClock.elapsedRealtime();
        this.mCurrentEffectProcessDepth = 0;
    }

    public void effectChainEnd() {
        double dElapsedRealtime = SystemClock.elapsedRealtime() - this.mEffectChainStartTime;
        if (this.mCurrentEffectStartTime == 0.0d) {
            return;
        }
        double d = this.mEffectChainAccumulatedTime + dElapsedRealtime;
        this.mEffectChainAccumulatedTime = d;
        int i = this.mEffectChainFrameCount + 1;
        this.mEffectChainFrameCount = i;
        if (i > 0) {
            this.mEffectChainAverageTime = (float) (d / i);
        }
    }

    public void currentEffectProcessBegin(int i) {
        if (this.mCurrentEffectProcessDepth == 0) {
            this.mCurrentEffectStartTime = SystemClock.elapsedRealtime();
        }
        this.mCurrentEffectProcessDepth++;
    }

    public void currentEffectProcessEnd(int i) {
        int i2 = this.mCurrentEffectProcessDepth - 1;
        this.mCurrentEffectProcessDepth = i2;
        if (i2 != 0 || this.mCurrentEffectStartTime == 0.0d) {
            return;
        }
        double dElapsedRealtime = SystemClock.elapsedRealtime() - this.mCurrentEffectStartTime;
        HashMap<Integer, Double> map = this.mPerEffectAccumulatedTime;
        if (map == null || this.mPerEffectFrameCount == null || this.mPerEffectAverageTime == null) {
            return;
        }
        if (!map.containsKey(Integer.valueOf(i))) {
            this.mPerEffectAccumulatedTime.put(Integer.valueOf(i), Double.valueOf(dElapsedRealtime));
            this.mPerEffectFrameCount.put(Integer.valueOf(i), 1);
            this.mPerEffectAverageTime.put(Integer.valueOf(i), Float.valueOf((float) dElapsedRealtime));
            return;
        }
        Double d = this.mPerEffectAccumulatedTime.get(Integer.valueOf(i));
        Integer num = this.mPerEffectFrameCount.get(Integer.valueOf(i));
        if (d == null || num == null) {
            return;
        }
        double dDoubleValue = d.doubleValue() + dElapsedRealtime;
        int iIntValue = num.intValue() + 1;
        this.mPerEffectAccumulatedTime.put(Integer.valueOf(i), Double.valueOf(dDoubleValue));
        this.mPerEffectFrameCount.put(Integer.valueOf(i), Integer.valueOf(iIntValue));
        if (iIntValue > 0) {
            this.mPerEffectAverageTime.put(Integer.valueOf(i), Float.valueOf((float) (dDoubleValue / iIntValue)));
        }
    }

    public void onFrameAvailable(boolean z, int i) {
        this.mLastComeFrameType = i;
        this.mFrameReady = true;
        if (z) {
            IVsyncHelper iVsyncHelper = this.mVsyncHelper;
            if (iVsyncHelper != null && iVsyncHelper.isWorking() && this.mConfig.getEffectOpen(8)) {
                return;
            }
            sendRenderMsg(1, false);
            return;
        }
        sendRenderMsg(0, false);
    }

    private static class MyOnFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener, IFrameAvailableListener {
        private boolean mIsEnable = true;
        private final WeakReference<VideoSurfaceTexture> mRef;

        public MyOnFrameAvailableListener(VideoSurfaceTexture videoSurfaceTexture) {
            this.mRef = new WeakReference<>(videoSurfaceTexture);
        }

        public void disable() {
            this.mIsEnable = false;
        }

        public void onAvailable(int i) {
            VideoSurfaceTexture videoSurfaceTexture = this.mRef.get();
            if (videoSurfaceTexture == null) {
                return;
            }
            videoSurfaceTexture.onFrameAvailable(this.mIsEnable, i);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            onAvailable(1);
        }

        @Override // com.ss.texturerender.IFrameAvailableListener
        public void onFrameAvailable() {
            onAvailable(2);
        }
    }

    protected void sendRenderMsg(int i, boolean z) {
        Handler handler = this.mRenderHandler;
        if (handler != null) {
            try {
                Message messageObtainMessage = handler.obtainMessage(2);
                messageObtainMessage.obj = this;
                messageObtainMessage.arg1 = i;
                messageObtainMessage.arg2 = z ? 1 : 0;
                if (!this.mSaveFrameBundle.isEmpty()) {
                    synchronized (this.mSaveFrameBundle) {
                        messageObtainMessage.setData(this.mSaveFrameBundle);
                        this.mSaveFrameBundle = new Bundle();
                    }
                }
                sendMsg(messageObtainMessage, false, z, 100L);
            } catch (Exception e) {
                TextureRenderLog.i(this.mTexType, TAG, e.toString());
            }
        }
    }

    protected int sendMsg(Message message, boolean z, boolean z2, long j) {
        Handler handler = this.mRenderHandler;
        if (handler == null) {
            return -1;
        }
        try {
            if (!z2) {
                if (z) {
                    handler.sendMessageAtFrontOfQueue(message);
                    return 0;
                }
                handler.sendMessage(message);
                return 0;
            }
            synchronized (this) {
                if (z) {
                    this.mRenderHandler.sendMessageAtFrontOfQueue(message);
                } else {
                    this.mRenderHandler.sendMessage(message);
                }
                TextureRenderLog.i(this.mTexType, TAG, "sendMsg, msg:" + message.toString());
                wait(j);
            }
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.ss.texturerender.vsync.IVsyncCallback
    public void notifyVsync() {
        boolean z = false;
        if (this.mLastComeFrameType != 0) {
            if (this.mSyncSetVsync == 1 && DeviceManager.isVRDevice()) {
                z = true;
            }
            sendRenderMsg(1, z);
            return;
        }
        sendRenderMsg(0, false);
    }

    public boolean isMakeCurrent() {
        return this.mIsMakeCurrent && this.mEglSurface != EGL14.EGL_NO_SURFACE;
    }

    public boolean makeCurrent() {
        if (!makeCurrent(this.mEglSurface)) {
            return false;
        }
        this.mIsMakeCurrent = true;
        EGLRuntime eGLRuntime = this.mEGLRuntime;
        if (eGLRuntime != null) {
            eGLRuntime.setDrawingObjectId(this.mObjectId);
        }
        return true;
    }

    public boolean makeCurrent(EGLSurface eGLSurface) {
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            TextureRenderLog.e(this.mTexType, TAG, "no surface for make current");
            return false;
        }
        TextureRenderLog.i(this.mTexType, TAG, this + " make current again");
        GLES20.glFinish();
        if (!EGL14.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            int iEglGetError = EGL14.eglGetError();
            notifyError(iEglGetError, 0, "");
            TextureRenderLog.e(this.mTexType, TAG, "make current failed:" + eGLSurface + " error:" + GLUtils.getEGLErrorString(iEglGetError));
            return false;
        }
        TextureRenderLog.i(this.mTexType, TAG, this + "make current done = " + this.mOffScreenSurface);
        return true;
    }

    public VideoSurfaceTexture(ITexture iTexture, Handler handler, TextureRenderer textureRenderer) {
        super(iTexture.lock());
        this.mIsRelease = false;
        this.mIsPaused = false;
        this.mIsMakeCurrent = false;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mViewportWidth = 0;
        this.mViewportHeight = 0;
        this.mRenderSurface = null;
        this.mUpdateSurface = null;
        this.mOffScreenSurface = null;
        this.mSerial = 0;
        this.mIsPreRender = false;
        this.mIgnoreSRResCheck = false;
        this.mStartPlayTimeNanos = -1L;
        this.mDropCount = 0;
        this.mSyncMsg = new Message();
        this.mTexType = -1;
        this.mSyncUpdateSurface = 0;
        this.mConfig = new EffectConfig(-1);
        this.mTextureQueue = new LinkedList<>();
        this.mUsingEffect = new HashMap<>();
        this.mSaveFrameBundle = new Bundle();
        this.mState = 3;
        this.mFrameMetaData = new ArrayList();
        this.mFrameReady = false;
        this.mFrameCount = 0;
        this.mAccumulatedPlayingTime = 0.0d;
        this.mLastFrameTime = 0.0d;
        this.mFPS = 0.0f;
        this.mCurrentEffectStartTime = 0.0d;
        this.mCurrentEffectProcessDepth = 0;
        this.mPerEffectFrameCount = new HashMap<>();
        this.mPerEffectAccumulatedTime = new HashMap<>();
        this.mPerEffectAverageTime = new HashMap<>();
        this.mEffectChainStartTime = 0.0d;
        this.mEffectChainAccumulatedTime = 0.0d;
        this.mEffectChainFrameCount = 0;
        this.mEffectChainAverageTime = 0.0f;
        this.mTrackingErrorCode = new HashMap<>();
        this.mTrackingErrorMsg = new HashMap<>();
        this.mSRProcessSuccessRate = Float.MIN_VALUE;
        this.mSRProcessAverageCostTime = Float.MIN_VALUE;
        this.mStaticMetadata = null;
        this.mFreezeDirector = 0;
        this.mEnableExtraSurfaceRenderCallback = 0;
        this.mFrameCallback = null;
        this.mFrameCallbackBundle = null;
        this.mEnableUseEglDummySurface = 0;
        this.mNotKeepLastParams = 0;
        this.mDoMirrorFirst = 0;
        this.mNativeWindow = null;
        this.mEnableNativeWindow = 0;
        this.mSRProcessScaleType = -1;
        this.mLayoutMode = 1;
        this.mLayoutRatio = 0.5f;
        this.mRotationType = 0;
        this.mIsMirrorHorizontal = 0;
        this.mIsMirrorVertical = 0;
        this.mExtraRenderCropParamsBundle = null;
        this.mMainRenderCropParamsBundle = null;
        this.mSyncSetVsync = 0;
        this.mForbidReuseVideoSurfaceTexture = 0;
        this.mHDRType = 0;
        this.mBitDepth = 8;
        this.mRoiSRParamsBundle = null;
        this.mHeadposeCallbackIntegral = 1;
        this.mFrameCallbackInRenderThread = 0;
        this.mVQScoreProcessSuccessRate = -1.0f;
        this.mVQScoreProcessAverageCostTime = -1.0f;
        this.mOpenVQScore = 0;
        this.mVQScoreBundle = null;
        this.mEffectTexture = null;
        this.mFrameProducer = null;
        this.mLastComeFrameType = 0;
        this.mDataSpace = -1;
        this.mSRProcessParamter = null;
        this.mEnableResetCropParamsInRender = 0;
        iTexture.addRef();
        this.mTextureId = iTexture;
        iTexture.unlock();
        internalConstruct(handler);
        this.mExtraSurfaceMap = new HashMap<>();
        this.mTextureRenderer = textureRenderer;
    }

    public void lock() {
        this.mLock.lock();
    }

    public void unlock() {
        this.mLock.unlock();
    }

    public VideoSurfaceTexture(ITexture iTexture, boolean z, Handler handler, TextureRenderer textureRenderer) {
        super(iTexture.lock(), z);
        this.mIsRelease = false;
        this.mIsPaused = false;
        this.mIsMakeCurrent = false;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mViewportWidth = 0;
        this.mViewportHeight = 0;
        this.mRenderSurface = null;
        this.mUpdateSurface = null;
        this.mOffScreenSurface = null;
        this.mSerial = 0;
        this.mIsPreRender = false;
        this.mIgnoreSRResCheck = false;
        this.mStartPlayTimeNanos = -1L;
        this.mDropCount = 0;
        this.mSyncMsg = new Message();
        this.mTexType = -1;
        this.mSyncUpdateSurface = 0;
        this.mConfig = new EffectConfig(-1);
        this.mTextureQueue = new LinkedList<>();
        this.mUsingEffect = new HashMap<>();
        this.mSaveFrameBundle = new Bundle();
        this.mState = 3;
        this.mFrameMetaData = new ArrayList();
        this.mFrameReady = false;
        this.mFrameCount = 0;
        this.mAccumulatedPlayingTime = 0.0d;
        this.mLastFrameTime = 0.0d;
        this.mFPS = 0.0f;
        this.mCurrentEffectStartTime = 0.0d;
        this.mCurrentEffectProcessDepth = 0;
        this.mPerEffectFrameCount = new HashMap<>();
        this.mPerEffectAccumulatedTime = new HashMap<>();
        this.mPerEffectAverageTime = new HashMap<>();
        this.mEffectChainStartTime = 0.0d;
        this.mEffectChainAccumulatedTime = 0.0d;
        this.mEffectChainFrameCount = 0;
        this.mEffectChainAverageTime = 0.0f;
        this.mTrackingErrorCode = new HashMap<>();
        this.mTrackingErrorMsg = new HashMap<>();
        this.mSRProcessSuccessRate = Float.MIN_VALUE;
        this.mSRProcessAverageCostTime = Float.MIN_VALUE;
        this.mStaticMetadata = null;
        this.mFreezeDirector = 0;
        this.mEnableExtraSurfaceRenderCallback = 0;
        this.mFrameCallback = null;
        this.mFrameCallbackBundle = null;
        this.mEnableUseEglDummySurface = 0;
        this.mNotKeepLastParams = 0;
        this.mDoMirrorFirst = 0;
        this.mNativeWindow = null;
        this.mEnableNativeWindow = 0;
        this.mSRProcessScaleType = -1;
        this.mLayoutMode = 1;
        this.mLayoutRatio = 0.5f;
        this.mRotationType = 0;
        this.mIsMirrorHorizontal = 0;
        this.mIsMirrorVertical = 0;
        this.mExtraRenderCropParamsBundle = null;
        this.mMainRenderCropParamsBundle = null;
        this.mSyncSetVsync = 0;
        this.mForbidReuseVideoSurfaceTexture = 0;
        this.mHDRType = 0;
        this.mBitDepth = 8;
        this.mRoiSRParamsBundle = null;
        this.mHeadposeCallbackIntegral = 1;
        this.mFrameCallbackInRenderThread = 0;
        this.mVQScoreProcessSuccessRate = -1.0f;
        this.mVQScoreProcessAverageCostTime = -1.0f;
        this.mOpenVQScore = 0;
        this.mVQScoreBundle = null;
        this.mEffectTexture = null;
        this.mFrameProducer = null;
        this.mLastComeFrameType = 0;
        this.mDataSpace = -1;
        this.mSRProcessParamter = null;
        this.mEnableResetCropParamsInRender = 0;
        iTexture.addRef();
        this.mTextureId = iTexture;
        iTexture.unlock();
        internalConstruct(handler);
        this.mExtraSurfaceMap = new HashMap<>();
        this.mTextureRenderer = textureRenderer;
    }

    private void internalConstruct(Handler handler) {
        this.mObjectId = new Random().nextLong();
        this.mRenderHandler = handler;
        this.mLock = new ReentrantLock();
        this.mCreateLooper = Looper.myLooper();
        this.mRenderMsgBundle = new Bundle();
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mSuperOpen = 0;
        this.mOnFrameAvailableListener = new MyOnFrameAvailableListener(this);
        if (Build.VERSION.SDK_INT >= 21 && this.mFrameCallbackInRenderThread == 1) {
            setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
        } else {
            setOnFrameAvailableListener(this.mOnFrameAvailableListener);
        }
        IFrameProducer iFrameProducer = this.mFrameProducer;
        if (iFrameProducer != null) {
            iFrameProducer.setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
        }
        TextureRenderLog.i(this.mTexType, TAG, this + "gen a texture :" + this.mObjectId + ", thread id " + Thread.currentThread().getId() + ", looper = " + looperToString(this.mCreateLooper));
    }

    public void bindEGLEnv(EGLRuntime eGLRuntime) {
        if (eGLRuntime == null) {
            throw new RuntimeException("no egl env for texture bind");
        }
        this.mEGLRuntime = eGLRuntime;
        this.mEglContext = eGLRuntime.eglContext;
        this.mEglDisplay = eGLRuntime.eglDisplay;
        EGLConfig eGLConfig = eGLRuntime.eglConfig;
        this.mEglConfig = eGLConfig;
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        EGL14.eglGetConfigAttrib(this.mEglDisplay, eGLConfig, 12324, iArr, 0);
        EGL14.eglGetConfigAttrib(this.mEglDisplay, this.mEglConfig, 12323, iArr2, 0);
        EGL14.eglGetConfigAttrib(this.mEglDisplay, this.mEglConfig, 12322, iArr3, 0);
        this.mRGBBitsFromEGLConfig = iArr[0] + iArr2[0] + iArr3[0];
        TextureRenderLog.d(this.mTexType, TAG, "bindEGLEnv rgbbits:" + this.mRGBBitsFromEGLConfig);
    }

    public long getOjbectId() {
        return this.mObjectId;
    }

    public boolean isCurrentObject() {
        EGLRuntime eGLRuntime = this.mEGLRuntime;
        return eGLRuntime != null && eGLRuntime.isCurrentObject(this.mObjectId);
    }

    public ITexture getTexId() {
        return this.mTextureId;
    }

    public int getSerial() {
        return this.mSerial;
    }

    public long getSurfaceUpdateTime() {
        return this.mUpdateSurfaceTime;
    }

    public boolean isRelease() {
        return this.mIsRelease;
    }

    public synchronized void releaseInternal() {
        if (!this.mIsRelease) {
            try {
                lock();
                TextureRenderLog.i(this.mTexType, TAG, this + " release internal");
                this.mIsRelease = true;
                this.mTextureId.decRef();
                this.mEffectTexture = null;
                IFrameProducer iFrameProducer = this.mFrameProducer;
                if (iFrameProducer != null) {
                    iFrameProducer.release();
                    this.mFrameProducer = null;
                }
                this.mRenderHandler = null;
                this.mCreateLooper = null;
                EffectTextureManager effectTextureManager = this.mTextureRenderer.getEffectTextureManager();
                while (this.mTextureQueue.size() > 0) {
                    EffectTexture effectTexturePoll = this.mTextureQueue.poll();
                    if (effectTextureManager != null) {
                        effectTextureManager.onTextureReturn(effectTexturePoll);
                    } else {
                        TexGLUtils.deleteTexture(effectTexturePoll.getTexID());
                    }
                    TextureRenderLog.i(this.mTexType, TAG, "return fbotex:" + effectTexturePoll.getTexID() + ",st:" + this);
                }
                TextureRenderLog.i(this.mTexType, TAG, this + " release internal done");
                unlock();
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
    }

    public void release(boolean z) {
        TextureRenderLog.i(this.mTexType, TAG, "release " + this + ", glthread = " + z);
        releaseOffScreenSurface(z);
        release();
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        TextureRenderLog.i(this.mTexType, TAG, "release");
        releaseInternal();
        super.release();
    }

    @Override // android.graphics.SurfaceTexture
    protected void finalize() throws Throwable {
        TextureRenderLog.i(this.mTexType, TAG, "finalize");
        releaseInternal();
        super.finalize();
    }

    public synchronized void setSuperResolutionConfig(int i, String str, String str2, String str3, int i2, int i3, String str4) {
        Handler handler = this.mRenderHandler;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(12);
            messageObtainMessage.obj = this;
            Bundle bundle = new Bundle();
            bundle.putInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE, 5);
            bundle.putInt("action", 21);
            bundle.putInt(TextureRenderKeys.KEY_SR_ALG_TYPE, i);
            bundle.putInt(TextureRenderKeys.KEY_SR_ALG_MAX_SIZE_WIDTH, i2);
            bundle.putInt(TextureRenderKeys.KEY_SR_ALG_MAX_SIZE_HEIGHT, i3);
            bundle.putString(TextureRenderKeys.KEY_KERNEL_BIN_PATH, str);
            bundle.putString(TextureRenderKeys.KEY_OCL_MODLE_NAME, str2);
            bundle.putString(TextureRenderKeys.KEY_DSP_MODLE_NAME, str3);
            bundle.putString(TextureRenderKeys.KEY_MODULE_NAME, str4);
            messageObtainMessage.setData(bundle);
            this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
        }
    }

    public synchronized void setSuperResolutionMode(int i) {
        TextureRenderLog.i(this.mTexType, TAG, this + " set sr = " + i);
        this.mSuperOpen = i;
        setEffectOpen(5, i, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec A[Catch: all -> 0x01a1, TRY_LEAVE, TryCatch #1 {, blocks: (B:6:0x0005, B:25:0x005a, B:27:0x005f, B:29:0x006b, B:31:0x006f, B:32:0x0073, B:34:0x007f, B:36:0x0083, B:37:0x0087, B:38:0x0090, B:39:0x0099, B:41:0x00a1, B:43:0x00a6, B:44:0x00a9, B:45:0x00b2, B:47:0x00bc, B:49:0x00c1, B:50:0x00c4, B:58:0x00ec, B:60:0x00f0, B:62:0x00ff, B:65:0x0114, B:67:0x0121, B:75:0x0137, B:77:0x013b, B:78:0x0142, B:80:0x0151, B:82:0x0155, B:84:0x0179, B:86:0x017d, B:51:0x00ce, B:52:0x00d1, B:53:0x00dc), top: B:95:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0114 A[Catch: all -> 0x01a1, TryCatch #1 {, blocks: (B:6:0x0005, B:25:0x005a, B:27:0x005f, B:29:0x006b, B:31:0x006f, B:32:0x0073, B:34:0x007f, B:36:0x0083, B:37:0x0087, B:38:0x0090, B:39:0x0099, B:41:0x00a1, B:43:0x00a6, B:44:0x00a9, B:45:0x00b2, B:47:0x00bc, B:49:0x00c1, B:50:0x00c4, B:58:0x00ec, B:60:0x00f0, B:62:0x00ff, B:65:0x0114, B:67:0x0121, B:75:0x0137, B:77:0x013b, B:78:0x0142, B:80:0x0151, B:82:0x0155, B:84:0x0179, B:86:0x017d, B:51:0x00ce, B:52:0x00d1, B:53:0x00dc), top: B:95:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013b A[Catch: all -> 0x01a1, TryCatch #1 {, blocks: (B:6:0x0005, B:25:0x005a, B:27:0x005f, B:29:0x006b, B:31:0x006f, B:32:0x0073, B:34:0x007f, B:36:0x0083, B:37:0x0087, B:38:0x0090, B:39:0x0099, B:41:0x00a1, B:43:0x00a6, B:44:0x00a9, B:45:0x00b2, B:47:0x00bc, B:49:0x00c1, B:50:0x00c4, B:58:0x00ec, B:60:0x00f0, B:62:0x00ff, B:65:0x0114, B:67:0x0121, B:75:0x0137, B:77:0x013b, B:78:0x0142, B:80:0x0151, B:82:0x0155, B:84:0x0179, B:86:0x017d, B:51:0x00ce, B:52:0x00d1, B:53:0x00dc), top: B:95:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0151 A[Catch: all -> 0x01a1, TryCatch #1 {, blocks: (B:6:0x0005, B:25:0x005a, B:27:0x005f, B:29:0x006b, B:31:0x006f, B:32:0x0073, B:34:0x007f, B:36:0x0083, B:37:0x0087, B:38:0x0090, B:39:0x0099, B:41:0x00a1, B:43:0x00a6, B:44:0x00a9, B:45:0x00b2, B:47:0x00bc, B:49:0x00c1, B:50:0x00c4, B:58:0x00ec, B:60:0x00f0, B:62:0x00ff, B:65:0x0114, B:67:0x0121, B:75:0x0137, B:77:0x013b, B:78:0x0142, B:80:0x0151, B:82:0x0155, B:84:0x0179, B:86:0x017d, B:51:0x00ce, B:52:0x00d1, B:53:0x00dc), top: B:95:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0179 A[Catch: all -> 0x01a1, TryCatch #1 {, blocks: (B:6:0x0005, B:25:0x005a, B:27:0x005f, B:29:0x006b, B:31:0x006f, B:32:0x0073, B:34:0x007f, B:36:0x0083, B:37:0x0087, B:38:0x0090, B:39:0x0099, B:41:0x00a1, B:43:0x00a6, B:44:0x00a9, B:45:0x00b2, B:47:0x00bc, B:49:0x00c1, B:50:0x00c4, B:58:0x00ec, B:60:0x00f0, B:62:0x00ff, B:65:0x0114, B:67:0x0121, B:75:0x0137, B:77:0x013b, B:78:0x0142, B:80:0x0151, B:82:0x0155, B:84:0x0179, B:86:0x017d, B:51:0x00ce, B:52:0x00d1, B:53:0x00dc), top: B:95:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void setEffect(android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.VideoSurfaceTexture.setEffect(android.os.Bundle):void");
    }

    private String getBundleString(Bundle bundle, String str) {
        try {
            return bundle.toString();
        } catch (Exception e) {
            TextureRenderLog.e(this.mTexType, TAG, str + e.toString());
            return "bundle modified";
        }
    }

    private void removeParamBundle(int i, int i2) {
        Iterator<Bundle> it = this.mParamList.iterator();
        while (it.hasNext()) {
            Bundle next = it.next();
            if (next.getInt("action") == i && next.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE) == i2) {
                this.mParamList.remove(next);
                return;
            }
        }
    }

    public CopyOnWriteArrayList<Bundle> getParamList() {
        return this.mParamList;
    }

    public Bundle getCropParamsBundle(boolean z) {
        return z ? this.mExtraRenderCropParamsBundle : this.mMainRenderCropParamsBundle;
    }

    public Bundle getFrameCallbackBundle() {
        return this.mFrameCallbackBundle;
    }

    public synchronized void pause(boolean z, boolean z2) {
        if (z2 && !z) {
            if (this.mRenderHandler != null && (this.mIsPaused || this.mIsPreRender)) {
                TextureRenderLog.i(this.mTexType, TAG, this + "need active , post a resume msg");
                Message messageObtainMessage = this.mRenderHandler.obtainMessage(10);
                messageObtainMessage.obj = this;
                this.mIsPreRender = false;
                this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
            }
            this.mIsPaused = z;
            TextureRenderLog.i(this.mTexType, TAG, this + "paused = " + this.mIsPaused);
        } else {
            this.mIsPaused = z;
            TextureRenderLog.i(this.mTexType, TAG, this + "paused = " + this.mIsPaused);
        }
    }

    public boolean canReuse(Looper looper) {
        int i;
        StringBuilder sb;
        boolean z = false;
        try {
            if (looper == this.mCreateLooper) {
                if (this.mForbidReuseVideoSurfaceTexture <= 0) {
                    z = true;
                }
            }
            i = this.mTexType;
            sb = new StringBuilder();
        } catch (Exception unused) {
            i = this.mTexType;
            sb = new StringBuilder();
        } catch (Throwable unused2) {
            i = this.mTexType;
            sb = new StringBuilder();
        }
        TextureRenderLog.i(i, TAG, sb.append(this).append("ret = ").append(z).append(" looper =").append(looperToString(looper)).append(", mlooper = ").append(looperToString(this.mCreateLooper)).append(", mForbidReuseVideoSurfaceTexture = ").append(this.mForbidReuseVideoSurfaceTexture).toString());
        return z;
    }

    private String looperToString(Looper looper) {
        if (looper == null) {
            return null;
        }
        Thread thread = looper.getThread();
        if (thread != null) {
            return "Looper (" + thread.getName() + ", tid " + thread.getId() + ") {" + Integer.toHexString(System.identityHashCode(looper)) + i.d;
        }
        return "Looper {" + Integer.toHexString(System.identityHashCode(looper)) + i.d;
    }

    public synchronized void updateSurface(Surface surface) {
        TextureRenderLog.i(this.mTexType, TAG, "update Surface = " + this + ", " + surface + ", " + this.mUpdateSurface);
        if (surface == this.mUpdateSurface && surface != null && surface.toString().contains("SurfaceTexture")) {
            TextureRenderLog.i(this.mTexType, TAG, "prevent the same surface???");
            return;
        }
        this.mLock.lock();
        this.mUpdateSurface = surface;
        this.mLock.unlock();
        Handler handler = this.mRenderHandler;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(4);
            this.mRenderMsgBundle.putSerializable(KEY_TEXTURE, this);
            messageObtainMessage.setData(this.mRenderMsgBundle);
            if (this.mSyncUpdateSurface != 1) {
                this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
            } else {
                Object obj = new Object();
                messageObtainMessage.obj = obj;
                synchronized (obj) {
                    this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
                    try {
                        TextureRenderLog.i(this.mTexType, TAG, "update surface wait");
                        obj.wait(100L);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        TextureRenderLog.i(this.mTexType, TAG, "update Surface end");
    }

    public synchronized void setExtraSurface(Surface surface, int i) {
        TextureRenderLog.i(this.mTexType, TAG, "setExtraSurface = " + this + ", " + surface + ", opera:" + i);
        Handler handler = this.mRenderHandler;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(25);
            messageObtainMessage.arg1 = i;
            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_TEXTURE, this);
            bundle.putParcelable(KEY_SURFACE, surface);
            messageObtainMessage.setData(bundle);
            this.mRenderHandler.sendMessage(messageObtainMessage);
        }
        TextureRenderLog.i(this.mTexType, TAG, "setExtraSurface end");
    }

    public void initExtraSurface(Surface surface) {
        TextureRenderLog.i(this.mTexType, TAG, "initExtraSurface begin sf:" + this + ", surface:" + surface + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
        if (surface == null || this.mExtraSurfaceMap.containsKey(surface)) {
            return;
        }
        EGLSurface eGLSurfaceCreateEGLWindowSurface = createEGLWindowSurface(surface);
        this.mExtraSurfaceMap.put(surface, eGLSurfaceCreateEGLWindowSurface);
        TextureRenderLog.i(this.mTexType, TAG, "initExtraSurface end sf:" + this + ", eglSurface:" + eGLSurfaceCreateEGLWindowSurface + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
    }

    public void releaseExtraSurface(Surface surface) {
        TextureRenderLog.i(this.mTexType, TAG, "releaseExtraSurface begin sf:" + this + ", surface:" + surface + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
        EGLSurface eGLSurface = this.mExtraSurfaceMap.get(surface);
        if (eGLSurface != null) {
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
            }
            this.mExtraSurfaceMap.remove(surface);
        }
        TextureRenderLog.i(this.mTexType, TAG, "releaseExtraSurface end sf:" + this + ", eglSurface:" + eGLSurface + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
    }

    public synchronized void releaseAllExtraSurface_l() {
        Handler handler = this.mRenderHandler;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(25);
            messageObtainMessage.arg1 = 3;
            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_TEXTURE, this);
            messageObtainMessage.setData(bundle);
            this.mRenderHandler.sendMessage(messageObtainMessage);
        }
    }

    public void releaseAllExtraSurface() {
        Iterator<Map.Entry<Surface, EGLSurface>> it = this.mExtraSurfaceMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Surface, EGLSurface> next = it.next();
            if (next.getValue() != EGL14.EGL_NO_SURFACE && next.getValue() != null) {
                EGL14.eglDestroySurface(this.mEglDisplay, next.getValue());
                TextureRenderLog.i(this.mTexType, TAG, "releaseAllExtraSurface sf:" + this + ", eglSurface:" + next.getValue());
            }
            it.remove();
        }
    }

    public HashMap<Surface, EGLSurface> getExtraRealSurfaces() {
        return this.mExtraSurfaceMap;
    }

    public boolean handleSurfaceChange(Message message) {
        if (this.mEGLRuntime == null) {
            return false;
        }
        int i = message.arg1;
        this.mLock.lock();
        if (i == 7) {
            if (!checkRecreateEGLSurface(i)) {
                TextureRenderLog.d(this.mTexType, TAG, "don't recreateEGLSurface for HDR");
                ReentrantLock reentrantLock = this.mLock;
                if (reentrantLock != null) {
                    reentrantLock.unlock();
                }
                return false;
            }
        } else {
            Surface surface = this.mRenderSurface;
            Surface surface2 = this.mUpdateSurface;
            if (surface == surface2 && surface2 != null && surface2.toString().contains("SurfaceTexture")) {
                TextureRenderLog.i(this.mTexType, TAG, "surface change the same surface hashcode");
                ReentrantLock reentrantLock2 = this.mLock;
                if (reentrantLock2 != null) {
                    reentrantLock2.unlock();
                }
                return false;
            }
        }
        this.mRenderSurface = this.mUpdateSurface;
        this.mOnFrameAvailableListener.disable();
        this.mOnFrameAvailableListener = new MyOnFrameAvailableListener(this);
        if (Build.VERSION.SDK_INT >= 21 && this.mFrameCallbackInRenderThread == 1) {
            setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
        } else {
            setOnFrameAvailableListener(this.mOnFrameAvailableListener);
        }
        IFrameProducer iFrameProducer = this.mFrameProducer;
        if (iFrameProducer != null) {
            iFrameProducer.setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
        }
        this.mLock.unlock();
        boolean zCreateEGLWindowSurface = createEGLWindowSurface(this.mEGLRuntime.getDrawingObjectId() != 0 && this.mEGLRuntime.isCurrentObject(this.mObjectId));
        if (!zCreateEGLWindowSurface) {
            return zCreateEGLWindowSurface;
        }
        this.mSerial++;
        TextureRenderLog.i(this.mTexType, TAG, this + "update surface done serial = " + this.mSerial + "update time = " + this.mUpdateSurfaceTime);
        return this.mEglSurface != EGL14.EGL_NO_SURFACE;
    }

    private boolean checkRecreateEGLSurface(int i) {
        int i2;
        if (i == 7 && this.mEglSurface != EGL14.EGL_NO_SURFACE) {
            int[] iArr = new int[1];
            boolean zEglQuerySurface = EGL14.eglQuerySurface(this.mEglDisplay, this.mEglSurface, TextureRenderKeys.EGL_GL_COLORSPACE_KHR, iArr, 0);
            TextureRenderLog.d(this.mTexType, TAG, "colorspace:" + iArr[0] + ",mHDRType:" + this.mHDRType + ",ret:" + zEglQuerySurface);
            if (zEglQuerySurface && (((i2 = iArr[0]) == 13120 && this.mHDRType != 1) || (i2 != 13120 && this.mHDRType == 1))) {
                if (i2 == 13120) {
                    return true;
                }
                EGLRuntime eGLRuntime = this.mEGLRuntime;
                return eGLRuntime != null && eGLRuntime.isSupportBt2020PQ() > 0;
            }
        }
        return false;
    }

    public boolean createEGLWindowSurface(boolean z) {
        EGLRuntime eGLRuntime = this.mEGLRuntime;
        if (eGLRuntime == null) {
            return false;
        }
        EGLSurface eGLSurface = eGLRuntime.eglDummySurface;
        if (this.mEglSurface != EGL14.EGL_NO_SURFACE) {
            TextureRenderLog.i(this.mTexType, TAG, "destory previous surface = " + this.mEglSurface);
            if (z) {
                TextureRenderLog.i(this.mTexType, TAG, "make current to dummy surface");
                EGL14.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext);
                this.mEGLRuntime.setDrawingObjectId(0L);
            }
            EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            this.mEglSurface = EGL14.EGL_NO_SURFACE;
            this.mIsMakeCurrent = false;
            NativeWindow nativeWindow = this.mNativeWindow;
            if (nativeWindow != null) {
                nativeWindow.releaseWindow();
                this.mNativeWindow = null;
            }
            TextureRenderLog.i(this.mTexType, TAG, "destory previous surface done = " + this.mEglSurface);
        }
        if (this.mEnableUseEglDummySurface == 1 && z && eGLSurface != EGL14.EGL_NO_SURFACE && this.mRenderSurface == null) {
            this.mEglSurface = eGLSurface;
        } else {
            this.mEglSurface = createEGLWindowSurface(this.mRenderSurface);
        }
        TextureRenderLog.i(this.mTexType, TAG, "createEGLWindowSurface eglSurface:" + this.mEglSurface);
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) {
            return false;
        }
        try {
            makeCurrent();
            if (this.mEnableNativeWindow > 0 && this.mRenderSurface != null) {
                NativeWindow nativeWindow2 = this.mNativeWindow;
                if (nativeWindow2 != null) {
                    nativeWindow2.releaseWindow();
                }
                this.mNativeWindow = new NativeWindow(this.mTexType, this.mRenderSurface);
            }
            this.mUpdateSurfaceTime = System.nanoTime();
            return true;
        } catch (Exception unused) {
            TextureRenderLog.e(this.mTexType, TAG, "makeCurrent exception failed");
            return false;
        }
    }

    public EGLSurface createEGLWindowSurface(Surface surface) {
        int[] iArr;
        boolean z;
        EGLRuntime eGLRuntime;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (surface == null || !surface.isValid()) {
            return eGLSurface;
        }
        String strEglQueryString = EGL14.eglQueryString(this.mEglDisplay, 12373);
        if (this.mHDRType != 1 || (eGLRuntime = this.mEGLRuntime) == null || eGLRuntime.isSupportBt2020PQ() <= 0) {
            iArr = new int[]{12344};
            z = false;
        } else {
            iArr = new int[]{TextureRenderKeys.EGL_GL_COLORSPACE_KHR, TextureRenderKeys.EGL_GL_COLORSPACE_BT2020_PQ_EXT, 12344};
            z = true;
        }
        try {
            TextureRenderLog.i(this.mTexType, TAG, this + ",create window surface from " + surface + ",attr:" + Arrays.toString(iArr));
            EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, surface, iArr, 0);
            if (eGLSurfaceEglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
                int iEglGetError = EGL14.eglGetError();
                notifyError(iEglGetError, 0, "");
                TextureRenderLog.e(this.mTexType, TAG, "create window surface failed" + GLUtils.getEGLErrorString(iEglGetError));
                return eGLSurfaceEglCreateWindowSurface;
            }
            List<Integer> list = this.mStaticMetadata;
            if (list != null && list.size() >= 10 && z && !TextUtils.isEmpty(strEglQueryString) && strEglQueryString.contains("EGL_EXT_surface_SMPTE2086_metadata")) {
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_RX_EXT, this.mStaticMetadata.get(0).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_RY_EXT, this.mStaticMetadata.get(1).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_GX_EXT, this.mStaticMetadata.get(2).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_GY_EXT, this.mStaticMetadata.get(3).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_BX_EXT, this.mStaticMetadata.get(4).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_BY_EXT, this.mStaticMetadata.get(5).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_WHITE_POINT_X_EXT, this.mStaticMetadata.get(6).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_WHITE_POINT_Y_EXT, this.mStaticMetadata.get(7).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_MAX_LUMINANCE_EXT, this.mStaticMetadata.get(8).intValue());
                EGL14.eglSurfaceAttrib(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, TextureRenderKeys.EGL_SMPTE2086_MIN_LUMINANCE_EXT, this.mStaticMetadata.get(9).intValue());
            }
            return eGLSurfaceEglCreateWindowSurface;
        } catch (Exception unused) {
            notifyError(5, 0, "");
            TextureRenderLog.e(this.mTexType, TAG, "createEGLWindowSurface exception failed");
            return EGL14.EGL_NO_SURFACE;
        }
    }

    @Override // com.ss.texturerender.TextureRenderer.OnTextureFocusLossListener
    public void onFocusLoss() {
        this.mIsMakeCurrent = false;
    }

    public synchronized VideoSurface getOffScreenSurface() {
        if (this.mIsRelease) {
            return null;
        }
        if (this.mOffScreenSurface == null) {
            this.mOffScreenSurface = new VideoSurface(this);
        }
        this.mIdleTimeStamp = -9223372036854775807L;
        return this.mOffScreenSurface;
    }

    public void setFrameRenderChecker(RenderCheckDispatcher renderCheckDispatcher) {
        VideoSurface videoSurface = this.mOffScreenSurface;
        if (videoSurface != null) {
            videoSurface.setFrameRenderChecker(renderCheckDispatcher);
        }
    }

    public void releaseOffScreenSurface(boolean z) {
        this.mOffScreenSurface = null;
        IFrameProducer iFrameProducer = this.mFrameProducer;
        if (iFrameProducer != null) {
            iFrameProducer.release();
        }
        this.mFrameProducer = null;
        if (z) {
            this.mUpdateSurface = null;
            if (this.mEglSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
                this.mIsMakeCurrent = false;
                NativeWindow nativeWindow = this.mNativeWindow;
                if (nativeWindow != null) {
                    nativeWindow.releaseWindow();
                    this.mNativeWindow = null;
                }
            }
            releaseAllExtraSurface();
        } else {
            updateSurface(null);
            releaseAllExtraSurface_l();
        }
        if ((this.mTexType & 4) > 0) {
            synchronized (this.mSyncMsg) {
                this.mSyncMsg.arg1 = Integer.MIN_VALUE;
                this.mSyncMsg.notify();
                TextureRenderLog.i(this.mTexType, TAG, "releaseOffScreenSurface mSyncMsg.notify");
            }
        }
        this.mIdleTimeStamp = SystemClock.elapsedRealtime();
        this.mState = 3;
        IVsyncHelper iVsyncHelper = this.mVsyncHelper;
        if (iVsyncHelper != null) {
            iVsyncHelper.setEnable(false);
        }
        CopyOnWriteArrayList<Bundle> copyOnWriteArrayList = this.mParamList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.mParamList = null;
        }
        if (this.mExtraRenderCropParamsBundle != null || this.mMainRenderCropParamsBundle != null) {
            this.mExtraRenderCropParamsBundle = null;
            this.mMainRenderCropParamsBundle = null;
            Handler handler = this.mRenderHandler;
            if (handler != null) {
                try {
                    Message messageObtainMessage = handler.obtainMessage(40);
                    messageObtainMessage.obj = this;
                    this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
                } catch (Exception unused) {
                }
            } else {
                Message message = new Message();
                message.what = 40;
                message.obj = this;
                this.mTextureRenderer.handleTextureRenderMsg(message);
            }
        }
        if (this.mLastComeFrameType != 0) {
            sendRenderMsg(0, false);
            this.mLastComeFrameType = 0;
        }
        this.mFrameCount = 0;
        this.mAccumulatedPlayingTime = 0.0d;
        this.mLastFrameTime = 0.0d;
        this.mFPS = 0.0f;
        this.mCurrentEffectStartTime = 0.0d;
        this.mCurrentEffectProcessDepth = 0;
        HashMap<Integer, Integer> map = this.mPerEffectFrameCount;
        if (map != null) {
            map.clear();
        }
        HashMap<Integer, Double> map2 = this.mPerEffectAccumulatedTime;
        if (map2 != null) {
            map2.clear();
        }
        HashMap<Integer, Float> map3 = this.mPerEffectAverageTime;
        if (map3 != null) {
            map3.clear();
        }
        this.mEffectChainStartTime = 0.0d;
        this.mEffectChainAccumulatedTime = 0.0d;
        this.mEffectChainFrameCount = 0;
        this.mEffectChainAverageTime = 0.0f;
        HashMap<Integer, Integer> map4 = this.mTrackingErrorCode;
        if (map4 != null) {
            map4.clear();
        }
        HashMap<Integer, String> map5 = this.mTrackingErrorMsg;
        if (map5 != null) {
            map5.clear();
        }
        releaseOther();
        this.mConfig.reset();
        this.mIgnoreSRResCheck = false;
        this.mRoiSRParamsBundle = null;
        this.mStaticMetadata = null;
        this.mFreezeDirector = 0;
        this.mOpenVQScore = 0;
        this.mVQScoreBundle = null;
        this.mEnableResetCropParamsInRender = 0;
        TextureRenderLog.i(this.mTexType, TAG, this + "release offscreen surface done = " + this.mIdleTimeStamp);
    }

    public boolean isAlive() {
        TextureRenderLog.i(this.mTexType, TAG, "is alive = " + this.mOffScreenSurface + ", eglsur = " + this.mEglSurface);
        return (this.mOffScreenSurface == null && this.mEglSurface == EGL14.EGL_NO_SURFACE) ? false : true;
    }

    public boolean couldForceRelease() {
        return SystemClock.elapsedRealtime() - this.mIdleTimeStamp > FORCE_EXIPRE_TIME_MS;
    }

    public int getConsumerWidth(EGLSurface eGLSurface) {
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            return -1;
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEglDisplay, eGLSurface, 12375, iArr, 0);
        return iArr[0];
    }

    public int getConsumerHeight(EGLSurface eGLSurface) {
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            return -1;
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEglDisplay, eGLSurface, 12374, iArr, 0);
        return iArr[0];
    }

    public int getViewportWidth() {
        int consumerWidth = getConsumerWidth(this.mEglSurface);
        if (this.mViewportWidth != consumerWidth) {
            this.mViewportWidth = consumerWidth;
        }
        return this.mViewportWidth;
    }

    public int getViewportHeight() {
        int consumerHeight = getConsumerHeight(this.mEglSurface);
        if (this.mViewportHeight != consumerHeight) {
            this.mViewportHeight = consumerHeight;
        }
        return this.mViewportHeight;
    }

    public int setHeadPose(Quaternion quaternion) {
        this.mHeadPose = quaternion;
        return 1;
    }

    public boolean render() {
        if (!eglSwapBuffer(this.mEglSurface, true)) {
            return false;
        }
        notifyRenderFrame(this.mSerial);
        return true;
    }

    public void notifyExtraSurfaceRender(Surface surface) {
        try {
            VideoSurface videoSurface = this.mOffScreenSurface;
            if (videoSurface != null) {
                videoSurface.onTextureUpdate(this.mSerial, surface, getTimestamp());
            }
        } catch (Exception unused) {
        }
    }

    public boolean eglSwapBuffer(EGLSurface eGLSurface, boolean z) {
        if (EGL14.eglSwapBuffers(this.mEglDisplay, eGLSurface)) {
            return true;
        }
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12301 && z) {
            createEGLWindowSurface(true);
        }
        notifyError(iEglGetError, 0, "");
        TextureRenderLog.e(this.mTexType, TAG, this + "swap buffer failed:" + GLUtils.getEGLErrorString(iEglGetError));
        return false;
    }

    public void notifyRenderFrame(int i) {
        if (i != this.mSerial) {
            return;
        }
        try {
            VideoSurface videoSurface = this.mOffScreenSurface;
            if (videoSurface != null) {
                videoSurface.onTextureUpdate(i, getTimestamp());
                Quaternion quaternion = this.mHeadPose;
                if (quaternion != null) {
                    this.mOffScreenSurface.onTextureUpdate(i, (float) quaternion.getX0(), (float) this.mHeadPose.getX1(), (float) this.mHeadPose.getX2(), (float) this.mHeadPose.getX3());
                }
            }
        } catch (Exception unused) {
        }
    }

    public void notifyError(int i, int i2, String str) {
        Integer num;
        try {
            HashMap<Integer, Integer> map = this.mTrackingErrorCode;
            if (map != null && this.mTrackingErrorMsg != null && ((num = map.get(Integer.valueOf(i2))) == null || num.intValue() == 0)) {
                this.mTrackingErrorCode.put(Integer.valueOf(i2), Integer.valueOf(i));
                this.mTrackingErrorMsg.put(Integer.valueOf(i2), str);
            }
            this.mOffScreenSurface.onTextureRenderError(i, i2, str);
        } catch (Exception unused) {
        }
    }

    public int getUseSr() {
        return this.mSuperOpen;
    }

    public void updateTexDimension(int i, int i2) {
        TextureRenderLog.i(this.mTexType, TAG, "update tex dimension : " + i + ", " + i2);
        super.setDefaultBufferSize(i, i2);
        IFrameProducer iFrameProducer = this.mFrameProducer;
        if (iFrameProducer != null) {
            iFrameProducer.updateTexDimension(i, i2);
        }
        this.mTexWidth = i;
        this.mTexHeight = i2;
    }

    public int getTexWidth() {
        return this.mTexWidth;
    }

    public int getTexHeight() {
        return this.mTexHeight;
    }

    public int getEnableUseEglDummySurface() {
        return this.mEnableUseEglDummySurface;
    }

    public boolean supportProcessResolution(int i, int i2) {
        if (this.mIgnoreSRResCheck) {
            return true;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = resWdithTab;
            if (i3 < iArr.length) {
                if (iArr[i3] == i && resHeightTab[i3] == i2) {
                    return true;
                }
                i3++;
            } else {
                TextureRenderLog.e(this.mTexType, TAG, "sr not support resolution width:" + i + ",height：" + i2);
                return false;
            }
        }
    }

    public void ignoreSRResolutionCheck(boolean z) {
        this.mIgnoreSRResCheck = z;
        TextureRenderLog.i(this.mTexType, TAG, "ignoreSRResolutionCheck:" + z);
    }

    public void preRender() {
        this.mIsPreRender = true;
    }

    public boolean isPreRender() {
        return this.mIsPreRender;
    }

    public Surface getRenderSurface() {
        return this.mRenderSurface;
    }

    public Surface getUpdateSurface() {
        return this.mUpdateSurface;
    }

    public EffectConfig getEffectConfig() {
        return this.mConfig;
    }

    public Bitmap saveFrame(Bundle bundle, VideoSurface.SaveFrameCallback saveFrameCallback) {
        Handler handler = this.mRenderHandler;
        if (handler == null) {
            return null;
        }
        if (saveFrameCallback != null) {
            synchronized (this.mSaveFrameBundle) {
                if (!this.mSaveFrameBundle.isEmpty()) {
                    this.mSaveFrameBundle.clear();
                }
                this.mSaveFrameBundle.putAll(bundle);
                this.mSaveFrameBundle.putSerializable(TextureRenderKeys.KEY_IS_CALLBACK, saveFrameCallback);
            }
            if (this.mState != 1) {
                sendRenderMsg(1, false);
            }
            return null;
        }
        Message messageObtainMessage = handler.obtainMessage(14);
        this.mRenderMsgBundle.putSerializable(KEY_TEXTURE, this);
        messageObtainMessage.setData(this.mRenderMsgBundle);
        Message message = new Message();
        messageObtainMessage.obj = message;
        try {
            synchronized (message) {
                this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
                message.wait(500L);
            }
            if (message.obj == null && this.mRenderHandler.hasMessages(14)) {
                TextureRenderLog.i(this.mTexType, TAG, "render thread is busy");
            }
            TextureRenderLog.i(this.mTexType, TAG, "save frame done = " + message.obj);
            return (Bitmap) message.obj;
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public synchronized void updateVideoState(int i) {
        Handler handler = this.mRenderHandler;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(26);
            messageObtainMessage.obj = this;
            messageObtainMessage.arg1 = i;
            this.mRenderHandler.sendMessage(messageObtainMessage);
        }
    }

    public void handleUpdateVideoState(int i) {
        int i2 = this.mState;
        this.mState = i;
        if (i != 1) {
            if (i == 2) {
                TextureRenderLog.i(this.mTexType, TAG, "TEXTURE_STATE_STOP mStartPlayTimeNanos:" + this.mStartPlayTimeNanos);
                return;
            } else {
                if (i != 3) {
                    return;
                }
                handleUpdateVideoStateForStop();
                this.mDropCount = 0;
                TextureRenderLog.i(this.mTexType, TAG, "TEXTURE_STATE_STOP");
                return;
            }
        }
        this.mLastFrameTime = SystemClock.elapsedRealtime();
        if (this.mStartPlayTimeNanos <= 0) {
            this.mStartPlayTimeNanos = System.nanoTime();
            TextureRenderLog.i(this.mTexType, TAG, "TEXTURE_STATE_PLAYING mStartPlayTimeNanos:" + this.mStartPlayTimeNanos);
        }
        IVsyncHelper iVsyncHelper = this.mVsyncHelper;
        if (iVsyncHelper != null) {
            iVsyncHelper.addObserver(this);
        }
        if (i2 == 1 || i2 == 2) {
            return;
        }
        this.mLastComeFrameType = 0;
    }

    protected void handleUpdateVideoStateForStop() {
        this.mDropCount = 0;
        IVsyncHelper iVsyncHelper = this.mVsyncHelper;
        if (iVsyncHelper != null) {
            iVsyncHelper.removeObserver(this);
        }
        this.mFreezeDirector = 0;
    }

    public boolean needDrop() {
        int i;
        long j = this.mStartPlayTimeNanos;
        if (j > 0 && j > getTimestamp() && (i = this.mDropCount) < 5) {
            this.mDropCount = i + 1;
            TextureRenderLog.i(this.mTexType, TAG, KEY_TEXTURE + this + " previous play period,drop count:" + this.mDropCount);
            return true;
        }
        if (!this.mIsPaused) {
            return false;
        }
        TextureRenderLog.i(this.mTexType, TAG, KEY_TEXTURE + this + " is paused");
        return true;
    }

    public synchronized void setOption(int i, int i2) {
        boolean z = false;
        if (i == 2) {
            if (i2 != 1) {
                return;
            }
            Handler handler = this.mRenderHandler;
            if (handler == null) {
                return;
            }
            try {
                Message messageObtainMessage = handler.obtainMessage(33);
                messageObtainMessage.obj = this;
                this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
            } catch (Exception unused) {
            }
        } else if (i == 3) {
            TextureRenderLog.i(this.mTexType, TAG, "set TEXTURE_OPTION_SET_OVERLAY_SYNC st:" + this);
            Handler handler2 = this.mRenderHandler;
            if (handler2 != null) {
                Message messageObtainMessage2 = handler2.obtainMessage(31);
                messageObtainMessage2.obj = this;
                messageObtainMessage2.arg1 = i2;
                messageObtainMessage2.sendToTarget();
            }
        } else if (i == 5) {
            this.mTexType = i2;
            this.mConfig.setTexType(i2);
        } else if (i == 6) {
            this.mUsingEffect.put(5, Integer.valueOf(i2));
        } else if (i == 8) {
            this.mHDRType = i2;
            _tryUpdateEGLSurface(7);
            _trySetupHDR2SDRFilter(i2);
        } else if (i == 9) {
            this.mSyncUpdateSurface = i2;
        } else if (i == 15) {
            this.mUsingEffect.put(1, Integer.valueOf(i2));
        } else if (i == 16) {
            setEffectOpen(1, i2, null);
        } else if (i == 25) {
            for (int i3 = 0; i3 < i2; i3++) {
                sendRenderMsg(1, false);
            }
        } else if (i != 26) {
            if (i == 106) {
                IVsyncHelper iVsyncHelper = this.mVsyncHelper;
                if (iVsyncHelper != null) {
                    if (i2 == 1) {
                        iVsyncHelper.removeObserver(this);
                    } else {
                        iVsyncHelper.addObserver(this);
                    }
                }
            } else if (i == 107) {
                IVsyncHelper iVsyncHelper2 = this.mVsyncHelper;
                if (iVsyncHelper2 != null) {
                    iVsyncHelper2.update();
                } else {
                    TextureRenderLog.d(this.mTexType, TAG, "vsyncHelper is null");
                }
            } else if (i == 116) {
                this.mForbidReuseVideoSurfaceTexture = i2;
            } else if (i != 117) {
                switch (i) {
                    case 29:
                        this.mRotationType = i2;
                        break;
                    case 30:
                        this.mIsMirrorHorizontal = i2;
                        break;
                    case 31:
                        this.mIsMirrorVertical = i2;
                        break;
                    default:
                        switch (i) {
                            case 110:
                                this.mSyncSetVsync = i2;
                                break;
                            case 121:
                                this.mFrameCount = i2;
                                break;
                            case 130:
                                this.mBitDepth = i2;
                                break;
                            case 135:
                                this.mHeadposeCallbackIntegral = i2;
                                break;
                            case 137:
                                this.mFreezeDirector = i2;
                                break;
                            case 141:
                                this.mEnableExtraSurfaceRenderCallback = i2;
                                break;
                            case 144:
                                this.mNotKeepLastParams = i2;
                                break;
                            case 145:
                                TextureRenderLog.i(this.mTexType, TAG, "set TEXTURE_OPTION_INT_RESET_ROTATION_MIRROR_PARAMS: " + i2);
                                Handler handler3 = this.mRenderHandler;
                                if (handler3 != null && i2 == 1) {
                                    try {
                                        Message messageObtainMessage3 = handler3.obtainMessage(42);
                                        messageObtainMessage3.obj = this;
                                        this.mRenderHandler.sendMessage(messageObtainMessage3);
                                    } catch (Exception unused2) {
                                    }
                                    this.mRotationType = 0;
                                    this.mIsMirrorHorizontal = 0;
                                    this.mIsMirrorVertical = 0;
                                    this.mLayoutMode = 1;
                                    this.mFrameCallbackBundle = null;
                                    break;
                                }
                                break;
                            case 146:
                                this.mDoMirrorFirst = i2;
                                break;
                            case 147:
                                this.mSRProcessScaleType = i2;
                                TextureRenderLog.i(this.mTexType, TAG, "set process scale type " + this.mSRProcessScaleType);
                                break;
                            case 169:
                                TextureRenderLog.d(this.mTexType, TAG, "TEXTURE_OPTION_INT_DATASPACE:" + i2);
                                this.mDataSpace = i2;
                                return;
                            case 171:
                                TextureRenderLog.d(this.mTexType, TAG, "TEXTURE_OPTION_INT_RESET_CROP_PARAMS:" + i2);
                                this.mEnableResetCropParamsInRender = i2;
                                return;
                            default:
                                switch (i) {
                                    case 149:
                                        this.mFrameCallbackInRenderThread = i2;
                                        return;
                                    case 150:
                                        this.mEnableNativeWindow = i2;
                                        return;
                                    case 151:
                                        if (this.mRenderHandler != null && i2 == -1) {
                                            try {
                                                Bundle bundle = new Bundle();
                                                bundle.putInt("action", 151);
                                                Message messageObtainMessage4 = this.mRenderHandler.obtainMessage(36);
                                                messageObtainMessage4.obj = this;
                                                messageObtainMessage4.setData(bundle);
                                                this.mRenderHandler.sendMessage(messageObtainMessage4);
                                            } catch (Exception unused3) {
                                            }
                                        }
                                        return;
                                    case 152:
                                        this.mOpenVQScore = i2;
                                        return;
                                }
                        }
                }
            } else {
                TextureRenderLog.i(this.mTexType, TAG, "set TEXTURE_OPTION_INT_FORBID_REUSE_TEXTURE: " + i2);
                lock();
                ITexture iTexture = this.mTextureId;
                if (iTexture != null) {
                    ((Texture) iTexture).setForbidTextureReuse(i2);
                }
                unlock();
            }
            z = true;
        } else {
            this.mLayoutMode = i2;
        }
        if (z) {
            sendSetOptionMsg(i, i2);
        }
    }

    protected void sendSetOptionMsg(int i, int i2) {
        Handler handler = this.mRenderHandler;
        if (handler == null) {
            return;
        }
        try {
            Message messageObtainMessage = handler.obtainMessage(34);
            messageObtainMessage.obj = this;
            messageObtainMessage.arg1 = i;
            messageObtainMessage.arg2 = i2;
            messageObtainMessage.sendToTarget();
        } catch (Exception unused) {
        }
    }

    private void _tryUpdateEGLSurface(int i) {
        Handler handler = this.mRenderHandler;
        if (handler == null || this.mRenderMsgBundle == null) {
            return;
        }
        try {
            Message messageObtainMessage = handler.obtainMessage(4);
            this.mRenderMsgBundle.putSerializable(KEY_TEXTURE, this);
            messageObtainMessage.setData(this.mRenderMsgBundle);
            messageObtainMessage.arg1 = i;
            this.mRenderHandler.sendMessage(messageObtainMessage);
        } catch (Exception unused) {
        }
    }

    private void _trySetupHDR2SDRFilter(int i) {
        EGLRuntime eGLRuntime;
        boolean z = i == 2 || (i == 1 && (eGLRuntime = this.mEGLRuntime) != null && eGLRuntime.isSupportBt2020PQ() <= 0);
        Bundle bundle = new Bundle();
        bundle.putInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE, 4);
        if (z) {
            bundle.putInt("action", 21);
            bundle.putInt(TextureRenderKeys.KEY_IS_HDR_TYPE, i);
            bundle.putInt(TextureRenderKeys.KEY_IS_USE_EFFECT, 1);
        } else {
            bundle.putInt("action", 19);
            bundle.putInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);
        }
        TextureRenderLog.d(this.mTexType, TAG, "tryHDR2SDR,need:" + z + ",type:" + i);
        setEffect(bundle);
    }

    public synchronized void setOption(int i, float f) {
        try {
            if (i == 4) {
                TextureRenderLog.i(this.mTexType, TAG, "set TEXTURE_OPTION_SET_OVERLAY_RATIO ratio:" + f);
                Message messageObtainMessage = this.mRenderHandler.obtainMessage(27);
                messageObtainMessage.obj = this;
                Bundle bundle = new Bundle();
                bundle.putFloat(TextureRenderKeys.OVERLAY_RATIO, f);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            } else if (i == 27) {
                this.mLayoutRatio = f;
            } else if (i == 120) {
                this.mFPS = f;
            } else if (i == 122) {
                this.mAccumulatedPlayingTime = f;
            } else if (i == 123) {
                this.mLastFrameTime = f;
            } else if (i == 131) {
                this.mSRProcessSuccessRate = f;
            } else if (i == 132) {
                this.mSRProcessAverageCostTime = f;
            } else if (i == 154) {
                this.mVQScoreProcessSuccessRate = f;
            } else if (i == 155) {
                this.mVQScoreProcessAverageCostTime = f;
            } else {
                Handler handler = this.mRenderHandler;
                if (handler == null) {
                    return;
                }
                Message messageObtainMessage2 = handler.obtainMessage(35);
                messageObtainMessage2.obj = this;
                messageObtainMessage2.arg1 = i;
                Bundle bundle2 = new Bundle();
                bundle2.putFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, f);
                messageObtainMessage2.setData(bundle2);
                messageObtainMessage2.sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    public void setOption(int i, Object obj) {
        if (i != 118) {
            if (i != 136) {
                return;
            }
            this.mStaticMetadata = (List) obj;
            return;
        }
        if (this.mRenderHandler == null) {
            return;
        }
        try {
            Object obj2 = new Object();
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj2);
            arrayList.add(obj);
            Message messageObtainMessage = this.mRenderHandler.obtainMessage(41);
            messageObtainMessage.obj = arrayList;
            messageObtainMessage.arg1 = 118;
            synchronized (obj2) {
                this.mRenderHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
                try {
                    obj2.wait(1000L);
                    TextureRenderLog.i(this.mTexType, TAG, "update background texture OK");
                } catch (InterruptedException unused) {
                    throw new RuntimeException("update background texture timeout");
                }
            }
        } catch (Exception unused2) {
        }
    }

    public void setOption(int i, int i2, int i3) {
        HashMap<Integer, Integer> map;
        if (i == 19) {
            if (i2 < 0) {
                return;
            }
            this.mUsingEffect.put(Integer.valueOf(i2), Integer.valueOf(i3));
        } else if (i == 126 && (map = this.mTrackingErrorCode) != null) {
            map.put(Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public void setOption(int i, int i2, String str) {
        HashMap<Integer, String> map;
        if (i == 127 && (map = this.mTrackingErrorMsg) != null) {
            map.put(Integer.valueOf(i2), str);
        }
    }

    public void resetFlag() {
        this.mUsingEffect.clear();
    }

    public void setEffectOpen(int i, int i2, Bundle bundle) {
        this.mConfig.setEffectOpen(i, i2);
        if (i == 8 || i == 12) {
            if (i2 == 1) {
                if (this.mVsyncHelper == null) {
                    this.mVsyncHelper = VsyncHelperFactory.createVsyncHelper(TextureRenderManager.getManager().getContext(), this.mTexType, bundle);
                }
                this.mVsyncHelper.setEnable(true);
                this.mVsyncHelper.addObserver(this);
                return;
            }
            IVsyncHelper iVsyncHelper = this.mVsyncHelper;
            if (iVsyncHelper != null) {
                iVsyncHelper.removeObserver(this);
            }
        }
    }

    public int getIntOption(int i) {
        if (i == 121) {
            return this.mFrameCount;
        }
        if (i == 130) {
            return this.mBitDepth;
        }
        if (i == 137) {
            return this.mFreezeDirector;
        }
        if (i == 141) {
            return this.mEnableExtraSurfaceRenderCallback;
        }
        if (i == 144) {
            return this.mNotKeepLastParams;
        }
        if (i == 152) {
            return this.mOpenVQScore;
        }
        if (i == 171) {
            return this.mEnableResetCropParamsInRender;
        }
        if (i == 146) {
            return this.mDoMirrorFirst;
        }
        if (i == 147) {
            return this.mSRProcessScaleType;
        }
        return getIntOption(i, -1);
    }

    public int getIntOption(int i, int i2) {
        Integer num;
        if (i != 6) {
            if (i == 8) {
                return this.mHDRType;
            }
            if (i == 10) {
                TextureRenderer textureRenderer = this.mTextureRenderer;
                return (textureRenderer == null || !textureRenderer.getEffectConfig().isOpenSR()) ? 0 : 1;
            }
            if (i == 23) {
                TextureRenderer textureRenderer2 = this.mTextureRenderer;
                return (textureRenderer2 == null || !textureRenderer2.getEffectConfig().getEffectOpen(i2)) ? 0 : 1;
            }
            if (i == 126) {
                HashMap<Integer, Integer> map = this.mTrackingErrorCode;
                if (map == null || (num = map.get(Integer.valueOf(i2))) == null) {
                    return -1;
                }
                return num.intValue();
            }
            if (i == 135) {
                return this.mHeadposeCallbackIntegral;
            }
            if (i == 137) {
                return this.mFreezeDirector;
            }
            if (i == 163) {
                return this.mConfig.getEffectOpen(21) ? 1 : 0;
            }
            if (i != 15) {
                if (i == 16) {
                    return this.mConfig.getEffectOpen(1) ? 1 : 0;
                }
                if (i == 18) {
                    TextureRenderer textureRenderer3 = this.mTextureRenderer;
                    return (textureRenderer3 == null || !textureRenderer3.getEffectConfig().isOpenSharpen()) ? 0 : 1;
                }
                if (i != 19) {
                    return -1;
                }
            }
        }
        if (i == 6) {
            i2 = 5;
        } else if (i == 15) {
            i2 = 1;
        }
        Integer num2 = this.mUsingEffect.get(Integer.valueOf(i2));
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    public long getLongOption(int i, int i2) {
        if (i != 162) {
            return -1L;
        }
        return getTimestamp();
    }

    public float getFloatOption(int i) {
        return getFloatOption(i, -1);
    }

    public float getFloatOption(int i, int i2) {
        double d;
        Float f;
        if (i == 120) {
            return this.mFPS;
        }
        if (i == 131) {
            return this.mSRProcessSuccessRate;
        }
        if (i == 132) {
            return this.mSRProcessAverageCostTime;
        }
        if (i == 154) {
            return this.mVQScoreProcessSuccessRate;
        }
        if (i != 155) {
            switch (i) {
                case 122:
                    d = this.mAccumulatedPlayingTime;
                    break;
                case 123:
                    d = this.mLastFrameTime;
                    break;
                case 124:
                    HashMap<Integer, Float> map = this.mPerEffectAverageTime;
                    if (map == null || (f = map.get(Integer.valueOf(i2))) == null) {
                        return 0.0f;
                    }
                    return f.floatValue();
                case 125:
                    return this.mEffectChainAverageTime;
                default:
                    return 0.0f;
            }
            return (float) d;
        }
        return this.mVQScoreProcessAverageCostTime;
    }

    public String getStringOption(int i) {
        return getStringOption(i, -1);
    }

    public String getStringOption(int i, int i2) {
        HashMap<Integer, String> map;
        String str;
        return (i != 127 || (map = this.mTrackingErrorMsg) == null || (str = map.get(Integer.valueOf(i2))) == null) ? "" : str;
    }

    public Bundle getBundleOption(int i) {
        if (i != 170) {
            return null;
        }
        return this.mSRProcessParamter;
    }

    public Bundle getOption(int i) {
        if (i == 130) {
            return this.mRoiSRParamsBundle;
        }
        if (i != 153) {
            return null;
        }
        return this.mVQScoreBundle;
    }

    public Object getOption(Bundle bundle) {
        TextureRenderer textureRenderer = this.mTextureRenderer;
        if (textureRenderer != null) {
            return textureRenderer.getOption(bundle);
        }
        return null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchHelper touchHelper = this.mTouchHelper;
        if (touchHelper != null) {
            return touchHelper.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void registerTouchListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        if (this.mTouchHelper == null) {
            this.mTouchHelper = new TouchHelper(TextureRenderManager.getManager().getContext());
        }
        this.mTouchHelper.register(simpleOnGestureListener);
    }

    public void unRegisterTouchListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        TouchHelper touchHelper = this.mTouchHelper;
        if (touchHelper != null) {
            touchHelper.unregister(simpleOnGestureListener);
        }
    }

    public void registerTouchListener(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        if (this.mTouchHelper == null) {
            this.mTouchHelper = new TouchHelper(TextureRenderManager.getManager().getContext());
        }
        this.mTouchHelper.register(onScaleGestureListener);
    }

    public void unRegisterTouchListener(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        TouchHelper touchHelper = this.mTouchHelper;
        if (touchHelper != null) {
            touchHelper.unregister(onScaleGestureListener);
        }
    }

    public void frameMetaCallback(long j, long j2, Map<Integer, String> map) {
        TextureRenderLog.i(this.mTexType, TAG, "frameMetaCallback this:" + this + " pts:" + j + " mRenderHandler:" + this.mRenderHandler);
        if (this.mRenderHandler == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (getIntOption(19, 18) == 1) {
            TextureRenderLog.i(this.mTexType, TAG, "frameMetaCallback tile info: " + map.get(74));
            if (map != null) {
                this.mFrameMetaData.add(new FrameMetaData(j, j2, jElapsedRealtime, map));
            }
        }
        int i = this.mTexType;
        if ((i & 4) == 0) {
            return;
        }
        if (this.mOffScreenSurface == null) {
            TextureRenderLog.i(i, TAG, "mOffScreenSurface null,return this:" + this);
            return;
        }
        try {
            Message messageObtainMessage = this.mRenderHandler.obtainMessage(32);
            Bundle bundle = new Bundle();
            bundle.putSerializable(TextureRenderKeys.OVERLAY_UPDATE_FRAME_TIME, new FrameTimeQueue.FrameTime(j, j2));
            bundle.putString(TextureRenderKeys.OVERLAY_MASTER_CLOCK, map != null ? map.get(46) : null);
            bundle.putString(TextureRenderKeys.FOV_TILE_INFO, map != null ? map.get(74) : null);
            bundle.putLong(TextureRenderKeys.OVERLAY_MASTER_CLOCK_DIFF, jElapsedRealtime);
            bundle.putSerializable(KEY_TEXTURE, this);
            messageObtainMessage.setData(bundle);
            messageObtainMessage.obj = this.mSyncMsg;
            synchronized (this.mSyncMsg) {
                messageObtainMessage.sendToTarget();
                try {
                    this.mSyncMsg.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.mSyncMsg.arg1 != Integer.MIN_VALUE && this.mSyncMsg.arg1 != j) {
                    this.mSyncMsg.wait();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public LinkedList<FrameMetaData> getFrameMetaData(long j, long j2) {
        LinkedList<FrameMetaData> linkedList = new LinkedList<>();
        if (this.mFrameMetaData == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mFrameMetaData.size(); i2++) {
            if (Math.abs(this.mFrameMetaData.get(i2).getReleaseNanoTime() - j) <= j2) {
                linkedList.addLast(this.mFrameMetaData.get(i2));
            }
        }
        if (this.mFrameMetaData.size() > 10) {
            while (i < this.mFrameMetaData.size()) {
                if (Math.abs(this.mFrameMetaData.get(i).getReleaseNanoTime() - j) > j2) {
                    TextureRenderLog.i(this.mTexType, TAG, "FrameMetaData size large than 10, remove: " + i);
                    this.mFrameMetaData.remove(i);
                } else {
                    i++;
                }
            }
        }
        if (linkedList.isEmpty()) {
            TextureRenderLog.i(this.mTexType, TAG, "getFrameMetaData failed for cached metadate out of sync releaseNanoTime " + j);
        }
        return linkedList;
    }

    public boolean isUpdateFrame() {
        return this.mFrameReady;
    }

    public VideoSurfaceTexture getExtraVideoSurfaceTexture() {
        TextureRenderer textureRenderer = this.mTextureRenderer;
        if (textureRenderer != null) {
            return textureRenderer.getExtraVideoSurfaceTexture();
        }
        return null;
    }

    public int texType() {
        return this.mTexType;
    }

    public void onHeadposeChanged(Quaternion quaternion) {
        VideoSurface offScreenSurface = getOffScreenSurface();
        if (offScreenSurface != null) {
            offScreenSurface.onHeadposeChanged(this.mSerial, (float) quaternion.getX0(), (float) quaternion.getX1(), (float) quaternion.getX2(), (float) quaternion.getX3());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkGeometry() {
        /*
            r9 = this;
            com.ss.texturerender.NativeWindow r0 = r9.mNativeWindow
            int r1 = r9.mEnableNativeWindow
            r2 = 1
            if (r1 != r2) goto Lae
            if (r0 == 0) goto Lae
            com.ss.texturerender.VideoSurface r1 = r9.mOffScreenSurface
            r3 = 0
            if (r1 == 0) goto L13
            int r4 = r1.mSurfaceWidth
            int r1 = r1.mSurfaceHeight
            goto L15
        L13:
            r1 = r3
            r4 = r1
        L15:
            if (r1 <= 0) goto L26
            if (r4 <= 0) goto L26
            int r5 = r9.getViewportWidth()
            if (r5 != r4) goto L25
            int r5 = r9.getViewportHeight()
            if (r5 == r1) goto L26
        L25:
            r3 = r2
        L26:
            int r5 = r0.getSurfaceFormat()
            r6 = 43
            if (r5 <= 0) goto L49
            int r7 = r9.mRGBBitsFromEGLConfig
            r8 = 24
            if (r7 > r8) goto L3f
            if (r5 == r2) goto L47
            r6 = 2
            if (r5 == r6) goto L47
            r6 = 3
            if (r5 == r6) goto L47
            r3 = r2
            r6 = r3
            goto L4a
        L3f:
            r7 = 22
            if (r5 == r7) goto L47
            if (r5 == r6) goto L47
            r3 = r2
            goto L4a
        L47:
            r6 = r5
            goto L4a
        L49:
            r6 = r2
        L4a:
            if (r3 == 0) goto Lae
            if (r4 > 0) goto L52
            int r4 = r9.getViewportWidth()
        L52:
            if (r1 > 0) goto L58
            int r1 = r9.getViewportHeight()
        L58:
            r0.setBuffersGeometry(r4, r1, r6)
            int r0 = r9.mTexType
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "setBuffersGeometry,oriW:"
            java.lang.StringBuilder r3 = r3.append(r7)
            int r7 = r9.mViewportWidth
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r7 = ",oriH:"
            java.lang.StringBuilder r3 = r3.append(r7)
            int r7 = r9.mViewportHeight
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r7 = ",oriFmt:"
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r5 = ",newW:"
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = ",newH:"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r3 = ",newFmt:"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "VideoSurfaceTexture"
            com.ss.texturerender.TextureRenderLog.d(r0, r3, r1)
            r9.createEGLWindowSurface(r2)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.VideoSurfaceTexture.checkGeometry():void");
    }

    public EffectTexture getEffectTexture() {
        IFrameProducer iFrameProducer;
        if (this.mIsRelease) {
            return null;
        }
        if (this.mLastComeFrameType == 1) {
            EffectTexture effectTexture = this.mEffectTexture;
            if (effectTexture == null || this.mTexHeight != effectTexture.getHeight() || this.mTexWidth != this.mEffectTexture.getWidth()) {
                this.mEffectTexture = new EffectTexture((EffectTextureManager) null, this.mTextureId.lock(), this.mTexWidth, this.mTexHeight, 36197);
                this.mTextureId.unlock();
            }
            return this.mEffectTexture;
        }
        if (this.mLastComeFrameType != 2 || (iFrameProducer = this.mFrameProducer) == null) {
            return null;
        }
        return iFrameProducer.getEffectTexture();
    }

    @Override // android.graphics.SurfaceTexture
    public void getTransformMatrix(float[] fArr) {
        IFrameProducer iFrameProducer = this.mFrameProducer;
        if (iFrameProducer != null && this.mLastComeFrameType == 2) {
            iFrameProducer.getTransformMatrix(fArr);
        } else {
            super.getTransformMatrix(fArr);
        }
    }

    @Override // android.graphics.SurfaceTexture
    public long getTimestamp() {
        IFrameProducer iFrameProducer = this.mFrameProducer;
        if (iFrameProducer != null && this.mLastComeFrameType == 2) {
            return iFrameProducer.getTimestamp();
        }
        return super.getTimestamp();
    }

    public IFrameProducer getFrameProducer() {
        if (this.mFrameProducer == null && Build.VERSION.SDK_INT >= 28) {
            ImageReaderProducer imageReaderProducer = new ImageReaderProducer(this.mTexType);
            this.mFrameProducer = imageReaderProducer;
            imageReaderProducer.setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
        }
        return this.mFrameProducer;
    }

    public Handler getRenderHandler() {
        return this.mRenderHandler;
    }

    @Override // android.graphics.SurfaceTexture
    public void updateTexImage() {
        IFrameProducer iFrameProducer = this.mFrameProducer;
        if (iFrameProducer != null && this.mLastComeFrameType == 2) {
            iFrameProducer.updateImage();
        } else {
            super.updateTexImage();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ss.texturerender.math.ColorConversion getYUV2RGBMatrix(com.ss.texturerender.effect.EffectTexture r12) {
        /*
            r11 = this;
            boolean r0 = r11.isRelease()
            r1 = 0
            if (r0 != 0) goto L67
            if (r12 == 0) goto L67
            int r0 = r12.getTexTarget()
            r2 = 36197(0x8d65, float:5.0723E-41)
            if (r0 == r2) goto L13
            goto L67
        L13:
            int r12 = r12.getFormat()
            r0 = 0
            r2 = 842094169(0x32315659, float:1.0322389E-8)
            r3 = 17
            r4 = 40
            r5 = 39
            r6 = 35
            r7 = 1
            if (r12 <= 0) goto L32
            if (r12 == r6) goto L30
            if (r12 == r5) goto L30
            if (r12 == r4) goto L30
            if (r12 == r3) goto L30
            if (r12 != r2) goto L5c
        L30:
            r0 = r7
            goto L5c
        L32:
            com.ss.texturerender.VideoSurface r12 = r11.mOffScreenSurface
            r8 = -1
            if (r12 == 0) goto L3e
            r9 = 133(0x85, float:1.86E-43)
            int r9 = r12.getIntOption(r9)
            goto L3f
        L3e:
            r9 = r8
        L3f:
            r10 = 4
            if (r9 != r10) goto L43
            goto L30
        L43:
            if (r12 == 0) goto L49
            int r8 = com.ss.texturerender.NativeWindow.getFormat(r12)
        L49:
            if (r8 == r6) goto L30
            if (r8 == r5) goto L30
            if (r8 == r4) goto L30
            r12 = 16
            if (r8 == r12) goto L30
            if (r8 == r3) goto L30
            r12 = 20
            if (r8 == r12) goto L30
            if (r8 != r2) goto L5c
            goto L30
        L5c:
            if (r0 == 0) goto L67
            int r12 = r11.mDataSpace
            int r0 = r11.mBitDepth
            com.ss.texturerender.math.ColorConversion r12 = com.ss.texturerender.math.ColorConversion.getFromDataspace(r12, r0)
            return r12
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.VideoSurfaceTexture.getYUV2RGBMatrix(com.ss.texturerender.effect.EffectTexture):com.ss.texturerender.math.ColorConversion");
    }
}
