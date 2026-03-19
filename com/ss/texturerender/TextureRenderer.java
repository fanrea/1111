package com.ss.texturerender;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.ss.texturerender.base.EGLRuntime;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectTextureManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class TextureRenderer implements Handler.Callback {
    public static final int ERROR_FATAl = 0;
    public static final int ERROR_WARN = 1;
    private static final long EXPIRE_TIME = 120000;
    protected static final String KEY_SURFACE_OBJ = "surface";
    public static String LOG_TAG = "TextureRenderer";
    protected static final int MSG_AUTO_RELEASE = 11;
    protected static final int MSG_CHECK_FRAME_CALLBACK = 37;
    protected static final int MSG_CLEAR_SURFACE = 13;
    protected static final int MSG_DEINIT = 3;
    protected static final int MSG_ERROR = 6;
    protected static final int MSG_GEN_TEXTURE = 9;
    protected static final int MSG_INIT = 1;
    public static final int MSG_RENDER = 2;
    protected static final int MSG_RESET_CROP_PARAMS = 40;
    protected static final int MSG_RESET_ROTATION_MIRROR_PARAMS = 42;
    protected static final int MSG_SAVE_FRAME = 14;
    protected static final int MSG_SET_ACTIVE_TEXTURE = 10;
    public static final int MSG_SET_EFFECT = 36;
    protected static final int MSG_SET_EXTRA_SURFACE = 25;
    public static final int MSG_SET_FLOAT_OPTION = 35;
    public static final int MSG_SET_INT_OPTION = 34;
    protected static final int MSG_SET_MAIN_SURFACE = 33;
    protected static final int MSG_SET_OBJECT_OPTION = 41;
    protected static final int MSG_SET_OVERLAY_RATIO = 27;
    protected static final int MSG_SET_OVERLAY_SYNC = 31;
    protected static final int MSG_SET_SURFACE = 4;
    public static final int MSG_SR_INIT_CONFIG = 12;
    protected static final int MSG_START_RENDER_CHECK = 38;
    protected static final int MSG_STATE_CHANGED = 7;
    protected static final int MSG_STOP_RENDER_CHECK = 39;
    protected static final int MSG_TEXTURE_RENDERED = 8;
    protected static final int MSG_UPDATE_FRAME_TIME = 32;
    public static final int MSG_UPDATE_VIDEO_STATUS = 26;
    public static final int STATE_ERROR = -1;
    public static final int STATE_EXECUTING = 2;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INITED = 1;
    private static final String VERSION = "3.58.11-tob";
    protected RenderCheckDispatcher mCheckDispatcher;
    protected EGLRuntime mEGLRuntime;
    protected EffectConfig mEffectConfig;
    protected EffectConfig mEffectConfigWant;
    protected EffectTextureManager mEffectTextureManager;
    private OnEglErrorListener mErrorListener;
    private String mErrorReason;
    protected volatile Handler mHandler;
    private final Object mHandlerObject;
    private HandlerThread mHandlerThread;
    protected Handler mNotifyHandler;
    private Object mSetupFence;
    protected volatile int mState;
    private OnStateChangeListener mStateChangeListener;
    protected int mTexType;
    protected TextureFactory mTextureFactory;
    protected List<VideoSurfaceTexture> mTextureList;

    public interface OnEglErrorListener {
        void onError(int i, String str);
    }

    public interface OnStateChangeListener {
        void onStateChanged(int i);
    }

    public interface OnTextureFocusLossListener {
        void onFocusLoss();
    }

    protected abstract void deinitEffectComponents();

    protected abstract void deinitGLComponents();

    public VideoSurfaceTexture getExtraVideoSurfaceTexture() {
        return null;
    }

    public Object getOption(Bundle bundle) {
        return null;
    }

    protected abstract void handleFrameAvailable(Message message);

    protected abstract void handleGLThreadMessage(Message message);

    protected abstract void handleSetSurface(Message message);

    protected abstract void initGLComponents();

    protected abstract void onInternalStateChanged(int i);

    protected abstract void updateDisplaySize(int i, int i2);

    public String getErrorReason() {
        return this.mErrorReason;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 6) {
            OnEglErrorListener onEglErrorListener = this.mErrorListener;
            if (onEglErrorListener == null) {
                return true;
            }
            onEglErrorListener.onError(message.arg1, message.obj.toString());
            return true;
        }
        if (i != 7) {
            if (i != 8) {
                return true;
            }
            int i2 = message.arg1;
            VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) message.obj;
            if (videoSurfaceTexture == null) {
                return true;
            }
            videoSurfaceTexture.notifyRenderFrame(i2);
            return true;
        }
        OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
        if (onStateChangeListener == null) {
            return true;
        }
        onStateChangeListener.onStateChanged(message.arg1);
        if (message.arg1 != 0) {
            return true;
        }
        this.mNotifyHandler.removeCallbacksAndMessages(null);
        this.mNotifyHandler = null;
        return true;
    }

    public void setOnErrorListener(OnEglErrorListener onEglErrorListener) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setOnErrorListener =  " + onEglErrorListener);
        this.mErrorListener = onEglErrorListener;
    }

    public void setOnStateChangedListener(OnStateChangeListener onStateChangeListener) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setOnStateChangedListener =  " + onStateChangeListener);
        this.mStateChangeListener = onStateChangeListener;
    }

    protected void changeState(int i, boolean z) {
        Handler handler;
        if (this.mState == i) {
            return;
        }
        if (this.mState != -1 || i == 0) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "state change from " + this.mState + " to " + i);
            this.mState = i;
            if (z) {
                synchronized (this.mHandlerObject) {
                    if (this.mStateChangeListener != null && (handler = this.mNotifyHandler) != null) {
                        Message messageObtainMessage = handler.obtainMessage(7);
                        messageObtainMessage.arg1 = i;
                        messageObtainMessage.sendToTarget();
                    }
                }
            }
        }
    }

    public TextureRenderer(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig, boolean z) {
        this.mHandlerObject = new Object();
        this.mSetupFence = new Object();
        TextureRenderLog.i(this.mTexType, LOG_TAG, "version :3.58.11-tob config:" + effectConfig + " type:" + i + ", useGL3: " + z);
        EGLRuntime eGLRuntime = new EGLRuntime(i, new MyEGLErrorCallback(), eGLContext, eGLConfig);
        this.mEGLRuntime = eGLRuntime;
        eGLRuntime.setUseGL3(z);
        this.mEGLRuntime.setBitDepth(effectConfig != null ? effectConfig.getEGLBitDepth() : 8);
        this.mState = 0;
        this.mErrorReason = null;
        this.mEffectConfig = new EffectConfig(i);
        this.mEffectConfigWant = effectConfig;
        this.mTexType = i;
        this.mTextureFactory = new TextureFactory(this);
        this.mTextureList = new ArrayList();
        init(i);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "construct done");
    }

    public TextureRenderer(EffectConfig effectConfig, int i) {
        this(effectConfig, i, null, null, false);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "version :3.58.11-tob config:" + effectConfig + " type:" + i);
    }

    public void init(int i) {
        HandlerThread handlerThread = new HandlerThread("TRThread_" + i);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.ss.texturerender.TextureRenderer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                TextureRenderer.this.handleTextureRenderMsg(message);
            }
        };
        this.mCheckDispatcher = new RenderCheckDispatcher(this.mHandler, this.mTexType);
        Message messageObtainMessage = this.mHandler.obtainMessage(1);
        messageObtainMessage.obj = this.mSetupFence;
        synchronized (this.mSetupFence) {
            messageObtainMessage.sendToTarget();
            try {
                this.mSetupFence.wait(1000L);
            } catch (InterruptedException unused) {
                throw new RuntimeException("EGL initial timeout");
            }
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(11), EXPIRE_TIME);
    }

    public void handleTextureRenderMsg(Message message) {
        int i = message.what;
        if (i == 1) {
            handleInit(message.obj);
            return;
        }
        if (i == 2) {
            handleFrameAvailable(message);
            return;
        }
        if (i == 3) {
            handleDeinit();
            return;
        }
        if (i == 4) {
            handleSetSurface(message);
            return;
        }
        if (i == 13) {
            handleClearSurface(message);
            return;
        }
        if (i != 14) {
            switch (i) {
                case 9:
                    handleGenTexture((Message) message.obj);
                    break;
                case 10:
                    handleChangeActiveTexture((VideoSurfaceTexture) message.obj);
                    break;
                case 11:
                    checkExpired();
                    break;
                default:
                    switch (i) {
                        case 37:
                            handleCheckFrameCallback();
                            break;
                        case 38:
                            handleStartRenderCheck();
                            break;
                        case 39:
                            handleStopRenderCheck();
                            break;
                        default:
                            handleGLThreadMessage(message);
                            break;
                    }
            }
            return;
        }
        handleSaveFrame(message);
    }

    private void handleStartRenderCheck() {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "handleStartRenderCheck " + this);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(37);
        }
    }

    private void handleStopRenderCheck() {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "handleStopRenderCheck " + this);
        if (this.mHandler != null) {
            this.mHandler.removeMessages(37);
        }
    }

    protected void handleCheckFrameCallback() {
        if (!this.mCheckDispatcher.isEnabled() || !this.mCheckDispatcher.isStarted()) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "handleCheckFrameCallback invalid state " + this);
            return;
        }
        this.mHandler.removeMessages(37);
        this.mCheckDispatcher.checkSurfaceTextureCallbackTime();
        this.mHandler.sendEmptyMessageDelayed(37, 500L);
    }

    private void checkExpired() {
        if (this.mHandler != null) {
            if ((this.mEffectConfig.isOpenSR() || this.mEffectConfig.isOpenSharpen() || this.mEffectConfig.getEffectOpen(14)) && (this.mTexType & 4) == 0) {
                return;
            }
            TextureRenderLog.i(this.mTexType, LOG_TAG, "renderer =" + this + ", check expired");
            synchronized (this.mTextureList) {
                if (!this.mHandler.hasMessages(8) && !this.mHandler.hasMessages(9)) {
                    if (this.mTextureList.size() == 0) {
                        TextureRenderLog.i(this.mTexType, LOG_TAG, "renderer is expired");
                        release();
                        return;
                    }
                    boolean z = false;
                    for (VideoSurfaceTexture videoSurfaceTexture : this.mTextureList) {
                        if (!videoSurfaceTexture.isRelease() && (videoSurfaceTexture.isAlive() || !videoSurfaceTexture.couldForceRelease())) {
                            TextureRenderLog.i(this.mTexType, LOG_TAG, "a texture is still working " + videoSurfaceTexture);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        TextureRenderLog.i(this.mTexType, LOG_TAG, "non live texture , renderer is expired");
                        release();
                        return;
                    } else {
                        this.mHandler.sendEmptyMessageDelayed(11, EXPIRE_TIME);
                        return;
                    }
                }
                TextureRenderLog.i(this.mTexType, LOG_TAG, "renderer is excuting");
                this.mHandler.sendEmptyMessageDelayed(11, EXPIRE_TIME);
            }
        }
    }

    protected void handleInit(Object obj) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "init start");
        EGLRuntime eGLRuntime = this.mEGLRuntime;
        if (eGLRuntime != null) {
            eGLRuntime.initEGL();
        }
        if (this.mState == -1) {
            return;
        }
        initGLComponents();
        if (this.mState == -1) {
            return;
        }
        changeState(1, true);
        synchronized (obj) {
            obj.notify();
            TextureRenderLog.i(this.mTexType, LOG_TAG, "init done");
        }
    }

    public int getState() {
        return this.mState;
    }

    protected void deleteTextures() {
        synchronized (this.mTextureList) {
            if (this.mTextureList.size() > 0) {
                Iterator<VideoSurfaceTexture> it = this.mTextureList.iterator();
                while (it.hasNext()) {
                    it.next().release(true);
                    it.remove();
                }
            }
            TextureRenderLog.i(this.mTexType, LOG_TAG, "delete textures : " + this.mTextureList.size());
            this.mTextureFactory.release();
        }
    }

    protected void handleDeinit() {
        TextureRenderLog.i(this.mTexType, LOG_TAG, this + "deinit");
        changeState(0, true);
        deinitEffectComponents();
        deleteTextures();
        deinitGLComponents();
        EGLRuntime eGLRuntime = this.mEGLRuntime;
        if (eGLRuntime != null) {
            eGLRuntime.deinitEGL();
        }
        this.mHandler = null;
        TextureRenderLog.i(this.mTexType, LOG_TAG, this + "deinit done");
    }

    protected void notifyEGLError(int i, String str) {
        synchronized (this.mHandlerObject) {
            this.mErrorReason = str + ", reason = " + GLUtils.getEGLErrorString(EGL14.eglGetError());
            changeState(-1, false);
            if (this.mErrorListener != null) {
                Message messageObtainMessage = this.mNotifyHandler.obtainMessage(6);
                messageObtainMessage.arg1 = i;
                messageObtainMessage.obj = "EGL fail = " + str + ", reason = " + GLUtils.getEGLErrorString(EGL14.eglGetError());
                messageObtainMessage.sendToTarget();
            }
        }
    }

    private class MyEGLErrorCallback implements EGLRuntime.ErrorCallback {
        private MyEGLErrorCallback() {
        }

        @Override // com.ss.texturerender.base.EGLRuntime.ErrorCallback
        public void onError(EGLRuntime eGLRuntime, int i, String str) {
            TextureRenderer.this.notifyEGLError(i, str);
        }
    }

    private void handleChangeActiveTexture(VideoSurfaceTexture videoSurfaceTexture) {
        if (videoSurfaceTexture == null) {
            return;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "resume texture =" + videoSurfaceTexture);
        if (videoSurfaceTexture.isCurrentObject()) {
            return;
        }
        videoSurfaceTexture.makeCurrent();
        TextureRenderLog.i(this.mTexType, LOG_TAG, "change active drawing id");
    }

    private void handleGenTexture(Message message) {
        ITexture iTextureCreateTexture = this.mTextureFactory.createTexture(36197, this.mTexType);
        if (iTextureCreateTexture == null) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "Create Texture failed.");
        }
        message.obj = iTextureCreateTexture;
        synchronized (message) {
            message.notify();
        }
    }

    private final void msgNotify(Message message) {
        if (message != null) {
            synchronized (message) {
                message.arg1 = this.mState;
                message.notify();
            }
        }
    }

    private void handleSaveFrame(Message message) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "handle save frame");
        Bundle data = message.getData();
        if (data == null) {
            throw new RuntimeException("update surface but missing bundle?");
        }
        VideoSurfaceTexture videoSurfaceTexture = (VideoSurfaceTexture) data.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        if (videoSurfaceTexture == null) {
            throw new RuntimeException("update surface but missing texture");
        }
        Message message2 = (Message) message.obj;
        if (this.mState < 1) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "state is invalid : " + this.mState);
            msgNotify(message2);
            return;
        }
        try {
            int viewportWidth = videoSurfaceTexture.getViewportWidth();
            int viewportHeight = videoSurfaceTexture.getViewportHeight();
            if (viewportWidth == 0 || viewportHeight == 0) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "texture size is invalid = " + viewportWidth + ", height =" + viewportHeight);
            }
            TextureRenderLog.i(this.mTexType, LOG_TAG, "savexx frame = " + viewportWidth + ", " + viewportHeight);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(viewportWidth * viewportHeight * 4);
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glFinish();
            GLES20.glReadPixels(0, 0, viewportWidth, viewportHeight, 6408, 5121, byteBufferAllocateDirect);
            int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "handleSaveFrame");
            if (iCheckGLError != 0 && videoSurfaceTexture != null) {
                videoSurfaceTexture.notifyError(iCheckGLError, 0, "handleSaveFrame");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(viewportWidth, viewportHeight, Bitmap.Config.ARGB_8888);
            byteBufferAllocateDirect.rewind();
            bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f);
            message2.obj = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, viewportWidth, viewportHeight, matrix, true);
            bitmapCreateBitmap.recycle();
        } catch (Exception e) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "save frame failed " + e.getMessage());
        }
        msgNotify(message2);
    }

    private void handleClearSurface(Message message) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "handle clear surface");
        Message message2 = (Message) message.obj;
        if (this.mState < 1) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "state is invalid : " + this.mState);
            msgNotify(message2);
        } else {
            if (this.mEGLRuntime != null) {
                this.mEGLRuntime.clearSurface((Surface) message.getData().getParcelable("surface"));
            }
            msgNotify(message2);
        }
    }

    private VideoSurfaceTexture getSurfaceTexture() {
        synchronized (this.mTextureList) {
            Iterator<VideoSurfaceTexture> it = this.mTextureList.iterator();
            while (true) {
                VideoSurfaceTexture videoSurfaceTextureGenNewVideoSurfaceTexture = null;
                while (it.hasNext()) {
                    videoSurfaceTextureGenNewVideoSurfaceTexture = it.next();
                    if (!videoSurfaceTextureGenNewVideoSurfaceTexture.isRelease() && !videoSurfaceTextureGenNewVideoSurfaceTexture.isAlive()) {
                        if (videoSurfaceTextureGenNewVideoSurfaceTexture.canReuse(Looper.myLooper())) {
                            TextureRenderLog.i(this.mTexType, LOG_TAG, "same looper reuse texture");
                            videoSurfaceTextureGenNewVideoSurfaceTexture.pause(false, false);
                            videoSurfaceTextureGenNewVideoSurfaceTexture.getOffScreenSurface();
                            videoSurfaceTextureGenNewVideoSurfaceTexture.setFrameRenderChecker(this.mCheckDispatcher);
                            return videoSurfaceTextureGenNewVideoSurfaceTexture;
                        }
                        TextureRenderLog.i(this.mTexType, LOG_TAG, "can't reuse, delete = " + videoSurfaceTextureGenNewVideoSurfaceTexture);
                        videoSurfaceTextureGenNewVideoSurfaceTexture.release(false);
                        it.remove();
                    } else if (!this.mEffectConfig.isOpenSR() && !this.mEffectConfig.isOpenSharpen() && !this.mEffectConfig.getEffectOpen(14) && !this.mEffectConfig.getEffectOpen(16)) {
                        int i = this.mTexType;
                        if ((i & 4) == 0) {
                            TextureRenderLog.i(i, LOG_TAG, "still living");
                            return null;
                        }
                    }
                }
                ITexture texture = getTexture();
                if (texture == null) {
                    if (videoSurfaceTextureGenNewVideoSurfaceTexture != null) {
                        if (!videoSurfaceTextureGenNewVideoSurfaceTexture.isRelease()) {
                            if (videoSurfaceTextureGenNewVideoSurfaceTexture.isAlive()) {
                            }
                        }
                    }
                    return null;
                }
                videoSurfaceTextureGenNewVideoSurfaceTexture = genNewVideoSurfaceTexture(texture);
                videoSurfaceTextureGenNewVideoSurfaceTexture.setOption(5, this.mTexType);
                videoSurfaceTextureGenNewVideoSurfaceTexture.bindEGLEnv(this.mEGLRuntime);
                texture.decRef();
                videoSurfaceTextureGenNewVideoSurfaceTexture.getOffScreenSurface();
                videoSurfaceTextureGenNewVideoSurfaceTexture.setFrameRenderChecker(this.mCheckDispatcher);
                this.mTextureList.add(videoSurfaceTextureGenNewVideoSurfaceTexture);
                return videoSurfaceTextureGenNewVideoSurfaceTexture;
            }
        }
    }

    protected VideoSurfaceTexture genNewVideoSurfaceTexture(ITexture iTexture) {
        return new VideoSurfaceTexture(iTexture, this.mHandler, this);
    }

    public VideoSurface genOffscreenSurface() {
        VideoSurfaceTexture surfaceTexture;
        if (this.mState >= 1 && (surfaceTexture = getSurfaceTexture()) != null) {
            return surfaceTexture.getOffScreenSurface();
        }
        return null;
    }

    protected ITexture getTexture() {
        try {
            Message messageObtainMessage = this.mHandler.obtainMessage(9);
            Message message = new Message();
            messageObtainMessage.obj = message;
            try {
                synchronized (message) {
                    this.mHandler.sendMessageAtFrontOfQueue(messageObtainMessage);
                    message.wait(1000L);
                }
                if (message.obj == null) {
                    if (this.mHandler.hasMessages(9)) {
                        this.mErrorReason = "The handler is busy for other operation timeout";
                    } else {
                        this.mErrorReason = "Try modify the wait timeOut";
                    }
                }
                return (ITexture) message.obj;
            } catch (Exception e) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "texture render may exit, error:" + e.toString());
                return null;
            }
        } catch (Exception unused) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "texture render already exit");
            return null;
        }
    }

    public void release() {
        TextureRenderLog.i(this.mTexType, LOG_TAG, this + "call release");
        synchronized (this) {
            if (this.mState != 0 && this.mHandler != null) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, this + "send deinit");
                this.mHandler.sendEmptyMessage(3);
                try {
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.mHandlerThread.quitSafely();
                    } else {
                        this.mHandlerThread.quit();
                    }
                } catch (Exception unused) {
                }
                TextureRenderLog.i(this.mTexType, LOG_TAG, this + "call release end");
                return;
            }
            TextureRenderLog.i(this.mTexType, LOG_TAG, this + "release return");
        }
    }

    private boolean isSupportGL3() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        try {
            Context context = TextureRenderManager.getManager().getContext();
            if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
                z = deviceConfigurationInfo.reqGlEsVersion >= 196608;
                TextureRenderLog.i(this.mTexType, LOG_TAG, "gles version: " + deviceConfigurationInfo.reqGlEsVersion + ", isSupportGL3: " + z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public EffectConfig getEffectConfig() {
        return this.mEffectConfig;
    }

    public int texType() {
        return this.mTexType;
    }

    public EffectTextureManager getEffectTextureManager() {
        return this.mEffectTextureManager;
    }

    public boolean clearSurface(Surface surface, boolean z) {
        Message messageObtainMessage = this.mHandler.obtainMessage(13);
        Bundle bundle = new Bundle();
        bundle.putParcelable("surface", surface);
        messageObtainMessage.setData(bundle);
        if (!z) {
            Message message = new Message();
            messageObtainMessage.obj = message;
            try {
                synchronized (message) {
                    TextureRenderLog.i(this.mTexType, LOG_TAG, "clear surface start");
                    this.mHandler.sendMessage(messageObtainMessage);
                    message.wait(1000L);
                    TextureRenderLog.i(this.mTexType, LOG_TAG, "clear surface end : ret = " + message.arg1);
                }
                if (message.arg1 < 1) {
                    return false;
                }
            } catch (InterruptedException unused) {
                return false;
            }
        } else {
            this.mHandler.sendMessage(messageObtainMessage);
        }
        return true;
    }

    public void sendMessage(int i, Bundle bundle) {
        if (this.mHandler != null) {
            try {
                Message messageObtainMessage = this.mHandler.obtainMessage(i);
                messageObtainMessage.setData(bundle);
                this.mHandler.sendMessage(messageObtainMessage);
            } catch (Exception unused) {
            }
        }
    }

    public void setVQSCoreInitResult(boolean z) {
        EffectConfig effectConfig;
        if (!z || (effectConfig = this.mEffectConfig) == null) {
            return;
        }
        effectConfig.setEffectOpen(16, 1);
    }
}
