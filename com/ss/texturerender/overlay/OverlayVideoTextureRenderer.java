package com.ss.texturerender.overlay;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.ss.texturerender.ITexture;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.EffectTextureManager;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import com.ss.texturerender.effect.GLOesTo2DFilter;
import com.ss.texturerender.overlay.FrameTimeQueue;
import com.ss.texturerender.vsync.VsyncHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class OverlayVideoTextureRenderer extends TextureRenderer {
    private static int ALL_VIDEO_STREAM_NUM = 2;
    private static int DROP_NUM_THRESHOLD = 3;
    private static int DROP_THRESHOLD_MS = 500;
    private static final String LOG_TAG = "OverlayVideoTextureRenderer";
    private int mAvailCount;
    private NormalClock mClock;
    private Surface mCurrentSurface;
    private GLDefaultFilter mDefaultDrawer;
    private EGLSurface mEglSurface;
    private FrameBuffer mFBO;
    private int mFBOTexH;
    private int mFBOTexW;
    private boolean mIsMakeCurrent;
    private boolean mIsOverlayRatioChanged;
    private boolean mIsVsyncWorking;
    private FrameTimeQueue mMainFrameTimeQueue;
    private VideoSurfaceTexture mMainSurfaceTexture;
    private ITexture mMainTex;
    private float[] mMainTexVerticesData;
    private int mMainVideoFastDropNum;
    private boolean mNeedSync;
    private GLOesTo2DFilter mOESDrawer;
    private float mOverlayRatio;
    private Vector<SurfaceTextureStatus> mReadySurfaceTextureVector;
    private FrameTimeQueue mSubFrameTimeQueue;
    private ITexture mSubTex;
    private float[] mSubTexVerticesData;
    private int mSubVideoFastDropNum;
    private int mTexType;
    private HashMap<VideoSurfaceTexture, Message> mTextureNotifyMap;
    private long mTid;
    private long mUpdateSurfaceTime;
    private VsyncHelper.VsyncCallback mVsyncCallback;
    private VsyncHelper mVsyncHelper;

    @Override // com.ss.texturerender.TextureRenderer
    protected void deinitEffectComponents() {
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void onInternalStateChanged(int i) {
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void updateDisplaySize(int i, int i2) {
    }

    public OverlayVideoTextureRenderer(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig) {
        super(effectConfig, i, eGLContext, eGLConfig, false);
        this.mCurrentSurface = null;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mIsMakeCurrent = false;
        this.mAvailCount = 0;
        this.mIsVsyncWorking = false;
        this.mFBOTexH = 0;
        this.mFBOTexW = 0;
        this.mOverlayRatio = 0.5f;
        this.mIsOverlayRatioChanged = false;
        this.mNeedSync = false;
        this.mMainVideoFastDropNum = 0;
        this.mSubVideoFastDropNum = 0;
        this.mTextureNotifyMap = new HashMap<>();
        this.mTexType = -1;
        this.mReadySurfaceTextureVector = new Vector<>(2);
        this.mVsyncHelper = new VsyncHelper(TextureRenderManager.getManager().getContext(), this.mTexType);
        this.mMainFrameTimeQueue = new FrameTimeQueue();
        this.mSubFrameTimeQueue = new FrameTimeQueue();
        this.mTexType = i;
        this.mClock = new NormalClock(this.mTexType);
        TextureRenderLog.i(this.mTexType, LOG_TAG, LOG_TAG);
    }

    public OverlayVideoTextureRenderer(EffectConfig effectConfig, int i) {
        this(effectConfig, i, null, null);
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void handleSetSurface(Message message) {
        Bundle data = message.getData();
        if (data == null) {
            throw new RuntimeException("OverlayVideoTextureRenderer update surface but missing bundle?");
        }
        VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) data.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        if (videoSurfaceTexture == null) {
            throw new RuntimeException("OverlayVideoTextureRenderer update surface but missing texture");
        }
        Surface updateSurface = videoSurfaceTexture.getUpdateSurface();
        Surface surface = this.mCurrentSurface;
        if (surface != null && surface == updateSurface && updateSurface != null && updateSurface.toString().contains("SurfaceTexture")) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "set same surface, return");
            return;
        }
        if (updateSurface == null) {
            _dropAllFrames();
            if (this.mCurrentSurface == null) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "reset null surface, return");
                return;
            }
        }
        if (this.mEglSurface != EGL14.EGL_NO_SURFACE) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "destory previous surface = " + this.mEglSurface);
            if (updateSurface == null) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "make current to dummy surface due to non render surface");
                EGL14.eglMakeCurrent(this.mEGLRuntime.eglDisplay, this.mEGLRuntime.eglDummySurface, this.mEGLRuntime.eglDummySurface, this.mEGLRuntime.eglContext);
            }
            boolean zEglDestroySurface = EGL14.eglDestroySurface(this.mEGLRuntime.eglDisplay, this.mEglSurface);
            this.mEglSurface = EGL14.EGL_NO_SURFACE;
            this.mIsMakeCurrent = false;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "destory previous surface done = " + this.mEglSurface + " ret:" + zEglDestroySurface);
        }
        if (updateSurface != null && updateSurface.isValid()) {
            int[] iArr = {12344};
            try {
                TextureRenderLog.i(this.mTexType, LOG_TAG, this + ",create window surface from " + updateSurface);
                EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLRuntime.eglDisplay, this.mEGLRuntime.eglConfig, updateSurface, iArr, 0);
                this.mEglSurface = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
                    TextureRenderLog.i(this.mTexType, LOG_TAG, "create window surface failed" + GLUtils.getEGLErrorString(EGL14.eglGetError()));
                    return;
                }
                _makeCurrent();
                int length = GLDefaultFilter.mTextureVerticesData.length;
                this.mMainTexVerticesData = new float[length];
                System.arraycopy(GLDefaultFilter.mTextureVerticesData, 0, this.mMainTexVerticesData, 0, length);
                this.mSubTexVerticesData = new float[length];
                System.arraycopy(GLDefaultFilter.mTextureVerticesData, 0, this.mSubTexVerticesData, 0, length);
            } catch (Exception unused) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "create current exception failed");
                return;
            }
        }
        this.mUpdateSurfaceTime = System.nanoTime();
        this.mCurrentSurface = updateSurface;
        Object obj = message.obj;
        if (obj != null) {
            synchronized (obj) {
                obj.notify();
            }
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "set surface done, mEglSurface=" + this.mEglSurface + " render:" + this);
    }

    private void _dropAllFrames() {
        Iterator<SurfaceTextureStatus> it = this.mReadySurfaceTextureVector.iterator();
        while (it.hasNext()) {
            SurfaceTextureStatus next = it.next();
            TextureRenderLog.i(this.mTexType, LOG_TAG, "_dropAllFrames isMain:" + isMainSurface(next.surfaceTexture));
            _updateTexImage(next.surfaceTexture);
            notify(next.surfaceTexture);
            it.remove();
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void handleFrameAvailable(Message message) {
        FrameTimeQueue.FrameTime frameTimePoll;
        VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) message.obj;
        if (isMainSurface(videoSurfaceTexture)) {
            frameTimePoll = this.mMainFrameTimeQueue.poll(videoSurfaceTexture.getTimestamp());
        } else {
            frameTimePoll = this.mSubFrameTimeQueue.poll(videoSurfaceTexture.getTimestamp());
        }
        long masterTimeStamp = frameTimePoll != null ? frameTimePoll.pts - getMasterTimeStamp() : -1L;
        TextureRenderLog.d(this.mTexType, LOG_TAG, "handleFrameAvailable,st = " + videoSurfaceTexture + " isMainSurface:" + isMainSurface(videoSurfaceTexture) + " pts:" + (frameTimePoll != null ? frameTimePoll.pts : -1L) + " master:" + getMasterTimeStamp() + " diff:" + masterTimeStamp);
        if (masterTimeStamp < 0) {
            _updateTexImage(videoSurfaceTexture);
            notify(videoSurfaceTexture);
        } else {
            if (!this.mIsVsyncWorking) {
                this.mVsyncHelper.addObserver(this.mVsyncCallback);
                this.mIsVsyncWorking = true;
            }
            this.mReadySurfaceTextureVector.add(new SurfaceTextureStatus(videoSurfaceTexture, frameTimePoll));
        }
    }

    private void _initFBOComponents() {
        VideoSurfaceTexture videoSurfaceTexture;
        VideoSurfaceTexture videoSurfaceTexture2;
        if (this.mFBO == null) {
            this.mFBO = new FrameBuffer();
        }
        if (this.mSubTex == null) {
            this.mSubTex = this.mTextureFactory.createTexture(3553, this.mTexType);
        }
        if (this.mMainTex == null) {
            this.mMainTex = this.mTextureFactory.createTexture(3553, this.mTexType);
        }
        int consumerWidth = getConsumerWidth();
        int consumerHeight = getConsumerHeight();
        if (consumerWidth <= 0 || consumerHeight <= 0) {
            return;
        }
        if (this.mFBOTexW == consumerWidth && this.mFBOTexH == consumerHeight) {
            return;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "_initFBOComponents surface H:" + consumerHeight + " W:" + consumerWidth + " mFBOTexH:" + this.mFBOTexH + " mFBOTexW:" + this.mFBOTexW);
        GLES20.glBindTexture(3553, this.mSubTex.lock());
        GLES20.glTexImage2D(3553, 0, 6408, consumerWidth, consumerHeight, 0, 6408, 5121, null);
        this.mSubTex.unlock();
        int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "createTexture sub");
        if (iCheckGLError != 0 && (videoSurfaceTexture2 = this.mMainSurfaceTexture) != null) {
            videoSurfaceTexture2.notifyError(iCheckGLError, 0, "createTexture sub");
        }
        ITexture iTexture = this.mMainTex;
        if (iTexture != null) {
            GLES20.glBindTexture(3553, iTexture.lock());
            GLES20.glTexImage2D(3553, 0, 6408, consumerWidth, consumerHeight, 0, 6408, 5121, null);
            this.mMainTex.unlock();
        }
        int iCheckGLError2 = TexGLUtils.checkGLError(this.mTexType, "createTexture main");
        if (iCheckGLError2 != 0 && (videoSurfaceTexture = this.mMainSurfaceTexture) != null) {
            videoSurfaceTexture.notifyError(iCheckGLError2, 0, "createTexture main");
        }
        this.mFBOTexH = consumerHeight;
        this.mFBOTexW = consumerWidth;
    }

    private boolean _makeCurrent() {
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "no surface for make current");
            return false;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, this + " make current again");
        GLES20.glFinish();
        EGLDisplay eGLDisplay = this.mEGLRuntime.eglDisplay;
        EGLSurface eGLSurface = this.mEglSurface;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLRuntime.eglContext)) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "make current failed = " + this.mEglSurface);
            return false;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, this + "make current done");
        this.mIsMakeCurrent = true;
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    private boolean _draw() {
        ITexture iTexture;
        _initFBOComponents();
        Iterator<SurfaceTextureStatus> it = this.mReadySurfaceTextureVector.iterator();
        ?? r2 = 0;
        int i = 0;
        while (it.hasNext()) {
            SurfaceTextureStatus next = it.next();
            if (next.status == SurfaceTextureStatus.NEED_DRAW) {
                i++;
            } else if (next.status == SurfaceTextureStatus.NEED_DROP) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, "_draw drop isMainSurface:" + isMainSurface(next.surfaceTexture));
                _updateTexImage(next.surfaceTexture);
                notify(next.surfaceTexture);
                it.remove();
            }
        }
        boolean z = this.mNeedSync;
        boolean z2 = (z && i >= ALL_VIDEO_STREAM_NUM) || (!z && i > 0);
        int consumerWidth = getConsumerWidth();
        int consumerHeight = getConsumerHeight();
        Iterator<SurfaceTextureStatus> it2 = this.mReadySurfaceTextureVector.iterator();
        while (it2.hasNext()) {
            SurfaceTextureStatus next2 = it2.next();
            if (next2.status == SurfaceTextureStatus.NEED_DRAW) {
                if (isMainSurface(next2.surfaceTexture)) {
                    this.mMainVideoFastDropNum = r2;
                } else {
                    this.mSubVideoFastDropNum = r2;
                }
                _updateTexImage(next2.surfaceTexture);
                if (!z2 || next2.surfaceTexture.needDrop()) {
                    notify(next2.surfaceTexture);
                    it2.remove();
                } else {
                    this.mNeedSync = r2;
                    ITexture texId = next2.surfaceTexture.getTexId();
                    int iLock = texId.lock();
                    GLOesTo2DFilter gLOesTo2DFilter = this.mOESDrawer;
                    if (isMainSurface(next2.surfaceTexture)) {
                        iTexture = this.mMainTex;
                    } else {
                        iTexture = this.mSubTex;
                    }
                    this.mFBO.bindTexture2D(iTexture.lock());
                    gLOesTo2DFilter.setSurfaceTexture(next2.surfaceTexture);
                    gLOesTo2DFilter.setOption(AbsEffect.OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES, GLDefaultFilter.mTextureVerticesData);
                    gLOesTo2DFilter.setOption(10006, consumerWidth);
                    gLOesTo2DFilter.setOption(10007, consumerHeight);
                    gLOesTo2DFilter.setOption(10010, 1);
                    gLOesTo2DFilter.process(new EffectTexture((EffectTextureManager) null, iLock, -1, -1, 36197), null);
                    iTexture.unlock();
                    texId.unlock();
                    notify(next2.surfaceTexture);
                    next2.surfaceTexture.notifyRenderFrame(next2.surfaceTexture.getSerial());
                    it2.remove();
                }
            }
            r2 = 0;
        }
        boolean z3 = z2 || this.mIsOverlayRatioChanged;
        TextureRenderLog.d(this.mTexType, LOG_TAG, "_draw needDrawCount:" + i + " needDrawToFBO:" + z2 + " needDrawToScreen" + z3 + " mNeedSync:" + this.mNeedSync);
        if (z3) {
            GLES20.glBindFramebuffer(36160, 0);
            float[] fArr = this.mMainTexVerticesData;
            float f = this.mOverlayRatio;
            fArr[2] = f;
            fArr[6] = f;
            this.mDefaultDrawer.setOption(10008, 0);
            float f2 = consumerWidth;
            this.mDefaultDrawer.setOption(10006, (int) (this.mOverlayRatio * f2));
            this.mDefaultDrawer.setOption(10007, consumerHeight);
            this.mDefaultDrawer.setOption(AbsEffect.OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES, this.mMainTexVerticesData);
            this.mDefaultDrawer.setOption(10010, 1);
            this.mDefaultDrawer.process(new EffectTexture((EffectTextureManager) null, this.mMainTex.lock(), -1, -1, 3553), null);
            this.mMainTex.unlock();
            float[] fArr2 = this.mSubTexVerticesData;
            float f3 = this.mOverlayRatio;
            fArr2[0] = f3;
            fArr2[4] = f3;
            this.mDefaultDrawer.setOption(10008, (int) (f3 * f2));
            this.mDefaultDrawer.setOption(10006, (int) (f2 * (1.0f - this.mOverlayRatio)));
            this.mDefaultDrawer.setOption(10007, getConsumerHeight());
            this.mDefaultDrawer.setOption(AbsEffect.OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES, this.mSubTexVerticesData);
            this.mDefaultDrawer.setOption(10010, 0);
            this.mDefaultDrawer.process(new EffectTexture((EffectTextureManager) null, this.mSubTex.lock(), -1, -1, 3553), null);
            this.mSubTex.unlock();
            this.mIsOverlayRatioChanged = false;
        }
        return z3;
    }

    private int _render() {
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "no surface to render");
            return -1;
        }
        if (EGL14.eglSwapBuffers(this.mEGLRuntime.eglDisplay, this.mEglSurface)) {
            return 0;
        }
        TextureRenderLog.e(this.mTexType, LOG_TAG, this + "swap buffer failed");
        return -1;
    }

    public void updateMaster(long j) {
        this.mClock.updateClock(j);
    }

    public long getMasterTimeStamp() {
        return this.mClock.getClock();
    }

    private static class SurfaceTextureStatus {
        public static int NEED_DRAW = 1;
        public static int NEED_DROP = 3;
        public static int NEED_NOT_DRAW = 2;
        public FrameTimeQueue.FrameTime frameTime;
        public int status = NEED_DRAW;
        public VideoSurfaceTexture surfaceTexture;

        public SurfaceTextureStatus(VideoSurfaceTexture videoSurfaceTexture, FrameTimeQueue.FrameTime frameTime) {
            this.surfaceTexture = videoSurfaceTexture;
            this.frameTime = frameTime;
        }
    }

    private void _updateTexImage(VideoSurfaceTexture videoSurfaceTexture) {
        try {
            try {
                videoSurfaceTexture.lock();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (videoSurfaceTexture.isRelease()) {
                return;
            }
            videoSurfaceTexture.updateTexImage();
        } finally {
            videoSurfaceTexture.unlock();
        }
    }

    public long getSurfaceUpdateTime() {
        return this.mUpdateSurfaceTime;
    }

    public int getConsumerWidth() {
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) {
            return -1;
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, this.mEglSurface, 12375, iArr, 0);
        return iArr[0];
    }

    public int getConsumerHeight() {
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) {
            return -1;
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, this.mEglSurface, 12374, iArr, 0);
        return iArr[0];
    }

    public void handleSetOverlayRatio(Message message) {
        float f = message.getData().getFloat(TextureRenderKeys.OVERLAY_RATIO);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "SetOverlayRatio ratio:" + f);
        if (f != this.mOverlayRatio) {
            this.mOverlayRatio = f;
            this.mIsOverlayRatioChanged = true;
            if (this.mIsVsyncWorking) {
                return;
            }
            this.mVsyncHelper.addObserver(this.mVsyncCallback);
            this.mIsVsyncWorking = true;
        }
    }

    public void handleVsyncComing(Message message) {
        handleVsyncDraw();
    }

    private void handleVsyncDraw() {
        _avSyncByVsync();
        if (_draw()) {
            _render();
        }
        TextureRenderLog.d(this.mTexType, LOG_TAG, "handleVsyncDraw end, ReadyVector size:" + this.mReadySurfaceTextureVector.size());
        if (this.mReadySurfaceTextureVector.isEmpty()) {
            this.mVsyncHelper.removeObserver(this.mVsyncCallback);
            this.mIsVsyncWorking = false;
        }
    }

    private void _avSyncByVsync() {
        int i;
        long masterTimeStamp = getMasterTimeStamp();
        Iterator<SurfaceTextureStatus> it = this.mReadySurfaceTextureVector.iterator();
        while (it.hasNext()) {
            SurfaceTextureStatus next = it.next();
            long j = next.frameTime.pts - masterTimeStamp;
            if (j > DROP_THRESHOLD_MS) {
                if (isMainSurface(next.surfaceTexture)) {
                    i = this.mMainVideoFastDropNum + 1;
                    this.mMainVideoFastDropNum = i;
                } else {
                    i = this.mSubVideoFastDropNum + 1;
                    this.mSubVideoFastDropNum = i;
                }
                if (i <= DROP_NUM_THRESHOLD) {
                    next.status = SurfaceTextureStatus.NEED_DROP;
                } else {
                    next.status = SurfaceTextureStatus.NEED_NOT_DRAW;
                }
            } else {
                long j2 = 1000000 * j;
                if (j2 < this.mVsyncHelper.getVsyncDurationNs() * (-2)) {
                    next.status = SurfaceTextureStatus.NEED_DROP;
                } else if (j2 > this.mVsyncHelper.getVsyncDurationNs()) {
                    next.status = SurfaceTextureStatus.NEED_NOT_DRAW;
                } else {
                    next.status = SurfaceTextureStatus.NEED_DRAW;
                }
            }
            TextureRenderLog.d(this.mTexType, LOG_TAG, "_avSyncByVsync pts:" + next.frameTime.pts + " master:" + masterTimeStamp + " diff:" + j + " isMainSurface:" + isMainSurface(next.surfaceTexture) + " status:" + next.status);
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    public synchronized void release() {
        super.release();
        _dropAllFrames();
        this.mAvailCount = 0;
        this.mClock.stop();
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void initGLComponents() {
        if (this.mState == -1) {
            return;
        }
        try {
            GLOesTo2DFilter gLOesTo2DFilter = this.mOESDrawer;
            if (gLOesTo2DFilter != null) {
                gLOesTo2DFilter.release();
            }
            GLOesTo2DFilter gLOesTo2DFilter2 = new GLOesTo2DFilter(this.mTexType);
            this.mOESDrawer = gLOesTo2DFilter2;
            gLOesTo2DFilter2.init(null);
            GLDefaultFilter gLDefaultFilter = this.mDefaultDrawer;
            if (gLDefaultFilter != null) {
                gLDefaultFilter.release();
            }
            GLDefaultFilter gLDefaultFilter2 = new GLDefaultFilter(this.mTexType);
            this.mDefaultDrawer = gLDefaultFilter2;
            gLDefaultFilter2.init(null);
            this.mVsyncCallback = new VsyncHelper.VsyncCallback(this.mHandler);
        } catch (Exception e) {
            notifyEGLError(0, e.toString());
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "initGLComponents done render:" + this);
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void deinitGLComponents() {
        GLOesTo2DFilter gLOesTo2DFilter = this.mOESDrawer;
        if (gLOesTo2DFilter != null) {
            gLOesTo2DFilter.release();
            this.mOESDrawer = null;
        }
        GLDefaultFilter gLDefaultFilter = this.mDefaultDrawer;
        if (gLDefaultFilter != null) {
            gLDefaultFilter.release();
            this.mDefaultDrawer = null;
        }
        FrameBuffer frameBuffer = this.mFBO;
        if (frameBuffer != null) {
            frameBuffer.release();
            this.mFBO = null;
        }
        ITexture iTexture = this.mMainTex;
        if (iTexture != null) {
            iTexture.decRef();
            this.mMainTex = null;
        }
        ITexture iTexture2 = this.mSubTex;
        if (iTexture2 != null) {
            iTexture2.decRef();
            this.mSubTex = null;
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    protected void handleGLThreadMessage(Message message) {
        switch (message.what) {
            case 26:
                if (isMainSurface((VideoSurfaceTexture) message.obj)) {
                    int i = message.arg1;
                    if (i == 1) {
                        this.mClock.start();
                        return;
                    }
                    if (i != 3) {
                        if (i != 4) {
                            return;
                        }
                        this.mClock.pause();
                        return;
                    } else {
                        TextureRenderLog.i(this.mTexType, LOG_TAG, "TEXTURE_STATE_STOP");
                        this.mMainFrameTimeQueue.clear();
                        this.mSubFrameTimeQueue.clear();
                        this.mClock.stop();
                        return;
                    }
                }
                return;
            case 27:
                handleSetOverlayRatio(message);
                return;
            case 28:
                handleVsyncComing(message);
                return;
            case 29:
            case 30:
            default:
                return;
            case 31:
                this.mNeedSync = message.arg1 == 1;
                TextureRenderLog.i(this.mTexType, LOG_TAG, "MSG_SET_OVERLAY_SYNC mNeedSync:" + this.mNeedSync);
                return;
            case 32:
                Bundle data = message.getData();
                VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) data.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
                FrameTimeQueue.FrameTime frameTime = (FrameTimeQueue.FrameTime) data.getSerializable(TextureRenderKeys.OVERLAY_UPDATE_FRAME_TIME);
                if (isMainSurface(videoSurfaceTexture)) {
                    String string = data.getString(TextureRenderKeys.OVERLAY_MASTER_CLOCK);
                    if (!TextUtils.isEmpty(string)) {
                        updateMaster(Long.parseLong(string.trim()) + (SystemClock.elapsedRealtime() - data.getLong(TextureRenderKeys.OVERLAY_MASTER_CLOCK_DIFF)));
                    }
                }
                boolean zNeedNotify = needNotify(videoSurfaceTexture);
                if (zNeedNotify) {
                    Message message2 = (Message) message.obj;
                    synchronized (message2) {
                        message2.arg1 = (int) frameTime.pts;
                        message.obj.notify();
                    }
                }
                this.mTextureNotifyMap.put(videoSurfaceTexture, (Message) message.obj);
                if (isMainSurface(videoSurfaceTexture)) {
                    this.mMainFrameTimeQueue.add(frameTime);
                } else {
                    this.mSubFrameTimeQueue.add(frameTime);
                }
                TextureRenderLog.i(this.mTexType, LOG_TAG, "MSG_UPDATE_FRAME_TIME needNotify:" + zNeedNotify + " MainQueue:" + this.mMainFrameTimeQueue.getSize() + " SubQueue:" + this.mSubFrameTimeQueue.getSize());
                return;
            case 33:
                this.mMainSurfaceTexture = (VideoSurfaceTexture) message.obj;
                TextureRenderLog.i(this.mTexType, LOG_TAG, "MSG_SET_MAIN_SURFACE st:" + this.mMainSurfaceTexture);
                return;
        }
    }

    private boolean isMainSurface(VideoSurfaceTexture videoSurfaceTexture) {
        return videoSurfaceTexture == this.mMainSurfaceTexture;
    }

    private boolean needNotify(VideoSurfaceTexture videoSurfaceTexture) {
        Iterator<SurfaceTextureStatus> it = this.mReadySurfaceTextureVector.iterator();
        while (it.hasNext()) {
            if (it.next().surfaceTexture == videoSurfaceTexture) {
                return false;
            }
        }
        return isMainSurface(videoSurfaceTexture) ? this.mMainFrameTimeQueue.getSize() <= 0 : this.mSubFrameTimeQueue.getSize() <= 0;
    }

    private void notify(VideoSurfaceTexture videoSurfaceTexture) {
        Message message = this.mTextureNotifyMap.get(videoSurfaceTexture);
        if (message != null) {
            synchronized (message) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "notify st:" + videoSurfaceTexture + " MainQueue:" + this.mMainFrameTimeQueue.toString() + " SubQueue:" + this.mSubFrameTimeQueue.toString());
                message.arg1 = Integer.MIN_VALUE;
                message.notify();
            }
        }
    }
}
