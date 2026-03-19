package com.kwai.player.vr;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.kwai.player.vr.BaseConfigChooser;
import com.kwai.video.player.R;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import com.sigmob.sdk.archives.tar.d;
import com.ss.texturerender.VideoSurfaceTexture;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SurfaceTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
    private static final int MSG_DESTROYSURFACE = 2002;
    private static final int MSG_INIT = 1000;
    private static final int MSG_RENDER = 1001;
    private static final int MSG_RENDER_LOOP = 1004;
    private static final int MSG_RESIZE_VIDEO = 1002;
    private static final int MSG_RESIZE_WINDOW = 1003;
    private static final int MSG_UPDATESURFACE = 2001;
    private static final String TAG = "SurfaceTextureRenderer";
    private static final int VERTICES_DATA_POS_SIZE = 3;
    private static final int VERTICES_DATA_UV_SIZE = 2;
    private static final int mLoopDuration = 40;
    private static final int maxDelayDuration = 60;
    private int fragmentShader;
    private String fragmentShaderSource;
    protected KwaiMesh kwaiMesh;
    private Object mBindedNativeWindow;
    private Context mContext;
    private BaseConfigChooser.SimpleEGLConfigChooser mEGLConfigChooser;
    private boolean mEGLInited;
    private EGLConfig mEglConfig;
    private EGLSurface mEglSurface;
    private HandlerThread mHandlerThread;
    private KwaiMediaPlayer.IHeadTrackerListener mHeadTrackerListener;
    private int mHeight;
    private KwaiVR mKwaiVR;
    private volatile long mLastDisplayFrameTime;
    private RenderHandler mRenderHandler;
    private Surface mSurface;
    private int mTexName;
    private SurfaceTexture mTexSurfaceTexture;
    private int mWidth;
    private int mWindowHeight;
    private int mWindowWidth;
    private int program;
    private int vertexShader;
    private String vertexShaderSource;
    private volatile boolean mLoopEnd = false;
    private float[] mTransformMatrix = new float[16];
    private boolean mFirstRender = true;
    private EGL10 mEgl = null;
    private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
    private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
    private int mEGLContextClientVersion = 2;
    private final HashMap<String, Integer> handleMap = new HashMap<>();
    private FpsStatistic mFpsStatistic = new FpsStatistic();
    private Object mGlRenderSync = new Object();
    private volatile boolean mWindowSizeChanged = false;

    public SurfaceTextureRenderer(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class RenderHandler extends Handler {
        private WeakReference<SurfaceTextureRenderer> mWeakObj;

        public RenderHandler(SurfaceTextureRenderer surfaceTextureRenderer, Looper looper) {
            super(looper);
            this.mWeakObj = new WeakReference<>(surfaceTextureRenderer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SurfaceTextureRenderer surfaceTextureRenderer = this.mWeakObj.get();
            if (surfaceTextureRenderer == null) {
                return;
            }
            int i = message.what;
            if (i != 2001) {
                if (i != 2002) {
                    switch (i) {
                        case 1000:
                            surfaceTextureRenderer.initEGL();
                            return;
                        case 1001:
                            surfaceTextureRenderer.syncDrawFrame();
                            return;
                        case 1002:
                            surfaceTextureRenderer.resizeVideoImpl(message.arg1, message.arg2);
                            return;
                        case 1003:
                            surfaceTextureRenderer.resizeWindowImpl(message.arg1, message.arg2);
                            break;
                        case 1004:
                            surfaceTextureRenderer.timerDrawFrameLoop();
                            return;
                        default:
                            return;
                    }
                } else {
                    surfaceTextureRenderer.destroySurfaceImpl();
                    return;
                }
            }
            surfaceTextureRenderer.updateSurfaceTextureImpl();
        }
    }

    public void init() {
        if (this.mHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("Renderer Thread");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
        }
        if (this.mRenderHandler == null) {
            this.mRenderHandler = new RenderHandler(this, this.mHandlerThread.getLooper());
            sendMsg(1000, 0, 0);
        }
    }

    public void sendMsg(int i, int i2, int i3) {
        RenderHandler renderHandler = this.mRenderHandler;
        if (renderHandler != null) {
            renderHandler.removeMessages(i);
        }
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        message.arg2 = i3;
        RenderHandler renderHandler2 = this.mRenderHandler;
        if (renderHandler2 != null) {
            renderHandler2.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEGL() {
        Log.i(TAG, "initEGL in");
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEglDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            Log.e(TAG, "initEGL eglGetDisplay failed! " + this.mEgl.eglGetError());
            return;
        }
        if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
            Log.e(TAG, "initEGL eglInitialize failed! " + this.mEgl.eglGetError());
            return;
        }
        BaseConfigChooser.SimpleEGLConfigChooser simpleEGLConfigChooser = new BaseConfigChooser.SimpleEGLConfigChooser(true, this.mEGLContextClientVersion);
        this.mEGLConfigChooser = simpleEGLConfigChooser;
        EGLConfig eGLConfigChooseConfig = simpleEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
        this.mEglConfig = eGLConfigChooseConfig;
        this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, eGLConfigChooseConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, this.mEGLContextClientVersion, 12344});
        if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
            Log.e(TAG, "initEGL eglCreateContext fail failed! " + this.mEgl.eglGetError());
        } else {
            this.mEGLInited = true;
            Log.i(TAG, "initEGL out");
        }
    }

    public synchronized void updateNativeWindow(Object obj) {
        this.mBindedNativeWindow = obj;
        if (obj != null) {
            Log.i(TAG, "SurfaceTextureRenderer updateNativeWindow " + obj);
        }
        sendMsg(2001, 0, 0);
    }

    public void destroyGlSurface() {
        sendMsg(2002, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateSurfaceTextureImpl() {
        if (this.mEgl != null && this.mEglDisplay != null && this.mEglConfig != null) {
            destroySurfaceImpl();
            Object obj = this.mBindedNativeWindow;
            if (obj == null) {
                return false;
            }
            try {
                EGLSurface eGLSurfaceEglCreateWindowSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, obj, null);
                this.mEglSurface = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface != null && eGLSurfaceEglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
                    EGL10 egl10 = this.mEgl;
                    EGLDisplay eGLDisplay = this.mEglDisplay;
                    EGLSurface eGLSurface = this.mEglSurface;
                    if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                        return false;
                    }
                    setupEgl();
                    return true;
                }
                Log.e(TAG, "eglCreateWindowSurface error " + this.mEgl.eglGetError());
                return false;
            } catch (Exception e) {
                Log.e(TAG, "throw eglCreateWindowSurface failed" + e.getMessage());
                return false;
            }
        }
        Log.d(TAG, "updateSurfaceTextureImpl: failed");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroySurfaceImpl() {
        EGLSurface eGLSurface;
        if (this.mEgl != null && (eGLSurface = this.mEglSurface) != null && eGLSurface != EGL10.EGL_NO_SURFACE && this.mEglDisplay != null) {
            Log.i(TAG, "eglDestroySurface in");
            EGL10 egl10 = this.mEgl;
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            this.mEglSurface = EGL10.EGL_NO_SURFACE;
            Log.i(TAG, "eglDestroySurface out");
        }
    }

    private void releaseImpl() {
        Log.i(TAG, "SurfaceTextureRenderer releaseImpl in");
        RenderHandler renderHandler = this.mRenderHandler;
        if (renderHandler != null) {
            renderHandler.removeMessages(1000);
            this.mRenderHandler.removeMessages(1001);
            stopDrawFrameLoop();
            this.mRenderHandler = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
        }
        destroyEgl();
        Surface surface = this.mSurface;
        if (surface != null && surface.isValid()) {
            Log.i(TAG, "Surface.release() in" + this.mSurface);
            this.mSurface.release();
            this.mSurface = null;
            Log.i(TAG, "Surface.release() out");
        }
        Log.i(TAG, "SurfaceTextureRenderer releaseImpl out");
    }

    private void destroyEgl() {
        if (this.mEgl != null) {
            releaseEgl();
            destroySurfaceImpl();
            if (this.mEglContext != null) {
                Log.i(TAG, "eglDestroyContext in");
                this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = null;
                Log.i(TAG, "eglDestroyContext out");
            }
            if (this.mEglDisplay != null) {
                Log.i(TAG, "eglTerminate in");
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
                Log.i(TAG, "eglTerminate out");
            }
        }
    }

    public SurfaceTexture createTexture() {
        this.mTexName = createTextureObject();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTexName);
        this.mTexSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        return this.mTexSurfaceTexture;
    }

    public SurfaceTexture getTexture() {
        if (this.mTexSurfaceTexture == null) {
            createTexture();
        }
        return this.mTexSurfaceTexture;
    }

    public Surface getSurface() {
        SurfaceTexture surfaceTexture;
        if (this.mSurface == null) {
            this.mSurface = SurfaceUtil.create(getTexture());
        }
        if (!this.mSurface.isValid()) {
            SurfaceUtil.release(this.mSurface);
            if (Build.VERSION.SDK_INT >= 21 && (surfaceTexture = this.mTexSurfaceTexture) != null) {
                surfaceTexture.setOnFrameAvailableListener(null);
                this.mTexSurfaceTexture.release();
                this.mTexSurfaceTexture = null;
            }
            this.mSurface = SurfaceUtil.create(getTexture());
        }
        Surface surface = this.mSurface;
        if (surface == null || !surface.isValid()) {
            StringBuilder sbAppend = new StringBuilder("getSurface: Surface invalid mSurface:").append(this.mSurface).append(",valid:");
            Surface surface2 = this.mSurface;
            Log.d(TAG, sbAppend.append(surface2 != null ? surface2.isValid() : false).toString());
            throw new RuntimeException("getSurface invalid");
        }
        Log.d(TAG, "create surface" + this.mSurface);
        return this.mSurface;
    }

    private int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, d.b, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        return iArr[0];
    }

    public void resizeVideo(int i, int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        if (this.mWidth == i && this.mHeight == i2) {
            return;
        }
        Log.d(TAG, "resize width:" + i + ",height:" + i2);
        this.mWidth = i;
        this.mHeight = i2;
        sendMsg(1002, i, i2);
    }

    public void resizeWindow(int i, int i2) {
        synchronized (this.mGlRenderSync) {
            Log.i(TAG, "resizeWindow width:" + i + ",height:" + i2);
            if (this.mWindowWidth != i || this.mWindowHeight != i2) {
                Log.i(TAG, "send resizeWindow width:" + i + ",height:" + i2);
                this.mWindowWidth = i;
                this.mWindowHeight = i2;
                sendMsg(1003, i, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeVideoImpl(int i, int i2) {
        Log.d(TAG, "resizeVideo width " + i + " height: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeWindowImpl(int i, int i2) {
        synchronized (this.mGlRenderSync) {
            if (this.mKwaiVR != null) {
                this.mWindowSizeChanged = true;
                this.mKwaiVR.setViewport(i, i2);
            }
        }
    }

    public void release() {
        synchronized (this.mGlRenderSync) {
            KwaiVR kwaiVR = this.mKwaiVR;
            if (kwaiVR != null) {
                kwaiVR.release();
                this.mKwaiVR = null;
                Log.d(TAG, "release mKwaiVR");
            }
            releaseImpl();
        }
    }

    public void reset() {
        this.mFpsStatistic.resetFps();
    }

    public void startFps() {
        this.mFpsStatistic.startFps();
    }

    public void stopFps() {
        this.mFpsStatistic.stopFps();
    }

    public int getFps() {
        return this.mFpsStatistic.getFps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timerDrawFrameLoop() {
        if (System.currentTimeMillis() - this.mLastDisplayFrameTime > 60) {
            syncDrawFrame();
            Log.d(TAG, "timerDrawFrameLoop draw frame");
        }
        synchronized (this.mGlRenderSync) {
            if (this.mRenderHandler != null && !this.mLoopEnd) {
                this.mRenderHandler.sendEmptyMessageDelayed(1004, 40L);
            }
        }
    }

    public void stopDrawFrameLoop() {
        synchronized (this.mGlRenderSync) {
            this.mLoopEnd = true;
            RenderHandler renderHandler = this.mRenderHandler;
            if (renderHandler != null) {
                renderHandler.removeMessages(1004);
            }
        }
    }

    public void setKwaiVR(KwaiVR kwaiVR) {
        this.mKwaiVR = kwaiVR;
        if (kwaiVR != null) {
            this.kwaiMesh = kwaiVR.getKwaiMesh();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        KwaiVR kwaiVR;
        sendMsg(1001, 0, 0);
        if (!this.mFirstRender || (kwaiVR = this.mKwaiVR) == null) {
            return;
        }
        kwaiVR.setInteractiveValid();
    }

    private void setupEgl() {
        releaseEgl();
        Log.i(TAG, "setupEgl in");
        try {
            this.vertexShaderSource = EglUtil.readTextFileFromRaw(this.mContext, R.raw.kwaiplayer_vertex_shader);
            this.fragmentShaderSource = EglUtil.readTextFileFromRaw(this.mContext, R.raw.kwaiplayer_fragment_shader);
            this.vertexShader = EglUtil.loadShader(this.vertexShaderSource, 35633);
            int iLoadShader = EglUtil.loadShader(this.fragmentShaderSource, 35632);
            this.fragmentShader = iLoadShader;
            this.program = EglUtil.createProgram(this.vertexShader, iLoadShader);
        } catch (Exception e) {
            Log.e(TAG, "throw setupEgl failed" + e.getMessage());
        }
        Log.i(TAG, "setupEgl out");
    }

    private void releaseEgl() {
        GLES20.glDeleteProgram(this.program);
        this.program = 0;
        GLES20.glDeleteShader(this.vertexShader);
        this.vertexShader = 0;
        GLES20.glDeleteShader(this.fragmentShader);
        this.fragmentShader = 0;
        this.handleMap.clear();
    }

    protected final void useProgram() {
        GLES20.glUseProgram(this.program);
    }

    protected final int getHandle(String str) {
        Integer num = this.handleMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.program, str);
        if (iGlGetAttribLocation == -1) {
            iGlGetAttribLocation = GLES20.glGetUniformLocation(this.program, str);
        }
        if (iGlGetAttribLocation == -1) {
            Log.e(TAG, "Could not get attrib or uniform location for " + str);
        }
        this.handleMap.put(str, Integer.valueOf(iGlGetAttribLocation));
        return iGlGetAttribLocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncDrawFrame() {
        synchronized (this.mGlRenderSync) {
            drawFrame();
            this.mLastDisplayFrameTime = System.currentTimeMillis();
        }
    }

    private void drawFrame() {
        if (!eglIsVaild()) {
            Log.d(TAG, "Egl init failed");
            return;
        }
        if (this.mKwaiVR == null) {
            Log.e(TAG, "KwaiVR init failed");
            return;
        }
        if (this.mEglSurface == EGL10.EGL_NO_SURFACE) {
            updateSurfaceTextureImpl();
        }
        if (this.mFirstRender) {
            this.mFirstRender = false;
            this.mLoopEnd = false;
            timerDrawFrameLoop();
            startFps();
        }
        if (!eglSetSurfaceSize(this.mWidth, this.mHeight)) {
            Log.e(TAG, "eglSetSurfaceSize failed");
            return;
        }
        if (this.mWindowSizeChanged) {
            KwaiVR kwaiVR = this.mKwaiVR;
            if (kwaiVR != null) {
                kwaiVR.setViewport(this.mWindowWidth, this.mWindowHeight);
            }
            if (!updateSurfaceTextureImpl()) {
                Log.e(TAG, "updateSurfaceTextureImpl failed");
                return;
            }
        } else {
            EGL10 egl10 = this.mEgl;
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
        }
        try {
            SurfaceTexture surfaceTexture = this.mTexSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.mTexSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
                this.mFpsStatistic.onFrame();
                synchronized (this.mGlRenderSync) {
                    float[] mVPMatrix = this.mKwaiVR.getMVPMatrix();
                    float[] orientation = this.mKwaiVR.getOrientation();
                    KwaiMediaPlayer.IHeadTrackerListener iHeadTrackerListener = this.mHeadTrackerListener;
                    if (iHeadTrackerListener != null) {
                        iHeadTrackerListener.onHeadTracker(orientation[0], orientation[1], orientation[2]);
                    }
                    drawTexture(this.mTexName, mVPMatrix, this.mTransformMatrix);
                }
            }
            this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
        } catch (Exception unused) {
        }
        if (this.mWindowSizeChanged) {
            this.mWindowSizeChanged = false;
        }
    }

    public void drawTexture(int i, float[] fArr, float[] fArr2) {
        if (this.kwaiMesh == null) {
            Log.e(TAG, "kwaiMesh is null");
            return;
        }
        GLES20.glViewport(0, 0, this.mWindowWidth, this.mWindowHeight);
        GLES20.glClear(16384);
        useProgram();
        GLES20.glUniformMatrix4fv(getHandle("uMVPMatrix"), 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(getHandle("uSTMatrix"), 1, false, fArr2, 0);
        FloatBuffer verticesBuffer = this.kwaiMesh.getVerticesBuffer(0);
        if (verticesBuffer == null) {
            return;
        }
        verticesBuffer.position(0);
        GLES20.glEnableVertexAttribArray(getHandle("aPosition"));
        GLES20.glVertexAttribPointer(getHandle("aPosition"), 3, 5126, false, 0, (Buffer) verticesBuffer);
        FloatBuffer texCoordinateBuffer = this.kwaiMesh.getTexCoordinateBuffer(0);
        if (texCoordinateBuffer == null) {
            Log.d(TAG, "getTexCoordinateBuffer is null");
            return;
        }
        texCoordinateBuffer.position(0);
        GLES20.glEnableVertexAttribArray(getHandle("aTextureCoord"));
        GLES20.glVertexAttribPointer(getHandle("aTextureCoord"), 2, 5126, false, 0, (Buffer) texCoordinateBuffer);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(getHandle(VideoSurfaceTexture.KEY_TEXTURE), 0);
        if (this.kwaiMesh.getIndicesBuffer() != null) {
            this.kwaiMesh.getIndicesBuffer().position(0);
            GLES20.glDrawElements(4, this.kwaiMesh.getNumIndices(), 5123, this.kwaiMesh.getIndicesBuffer());
        }
        GLES20.glDisableVertexAttribArray(getHandle("aPosition"));
        GLES20.glDisableVertexAttribArray(getHandle("aTextureCoord"));
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(3553, 0);
    }

    public boolean eglSetSurfaceSize(int i, int i2) {
        if (!eglIsVaild()) {
            return false;
        }
        if (i == this.mWindowWidth && i2 == this.mWindowHeight) {
            return true;
        }
        int iEglGetSurfaceWidth = eglGetSurfaceWidth();
        int iEglGetSurfaceHeight = eglGetSurfaceHeight();
        if (iEglGetSurfaceWidth != this.mWindowWidth || iEglGetSurfaceHeight != this.mWindowHeight) {
            this.mWindowSizeChanged = true;
            this.mWindowWidth = iEglGetSurfaceWidth;
            this.mWindowHeight = iEglGetSurfaceHeight;
            Log.d(TAG, "eglSetSurfaceSize window " + this.mWindowWidth + "*" + this.mWindowHeight);
        }
        return (this.mWindowWidth == 0 || this.mWindowHeight == 0) ? false : true;
    }

    public int eglGetSurfaceWidth() {
        int[] iArr = new int[1];
        this.mEgl.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12375, iArr);
        return iArr[0];
    }

    public int eglGetSurfaceHeight() {
        int[] iArr = new int[1];
        this.mEgl.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12374, iArr);
        return iArr[0];
    }

    public boolean eglIsVaild() {
        return (!this.mEGLInited || this.mEgl == null || this.mEglDisplay == null || this.mEglContext == null || this.mEglSurface == null) ? false : true;
    }

    public void setHeadTrackerListener(KwaiMediaPlayer.IHeadTrackerListener iHeadTrackerListener) {
        this.mHeadTrackerListener = iHeadTrackerListener;
    }
}
