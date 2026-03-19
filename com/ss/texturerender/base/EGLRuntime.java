package com.ss.texturerender.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextUtils;
import android.view.Surface;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EGLRuntime {
    private static String LOG_TAG = "TR_EGLRuntime";
    public EGLConfig eglConfig;
    public EGLContext eglContext;
    public EGLDisplay eglDisplay;
    public EGLSurface eglDummySurface;
    protected long mDrawingObjectId;
    private ErrorCallback mErrorCallback;
    protected volatile EGLConfig mSharedEglConfig;
    protected volatile EGLContext mSharedEglContext;
    private int mTexType;
    private int mIsSupport2020PQ = -1;
    private boolean mUseGL3 = false;
    private int mBitDepth = 8;

    public interface ErrorCallback {
        void onError(EGLRuntime eGLRuntime, int i, String str);
    }

    public EGLRuntime(int i, ErrorCallback errorCallback) {
        this.mTexType = i;
        this.mErrorCallback = errorCallback;
    }

    public EGLRuntime(int i, ErrorCallback errorCallback, EGLContext eGLContext, EGLConfig eGLConfig) {
        this.mTexType = i;
        this.mErrorCallback = errorCallback;
        this.mSharedEglContext = eGLContext;
        this.mSharedEglConfig = eGLConfig;
    }

    public void setUseGL3(boolean z) {
        this.mUseGL3 = z;
    }

    public void setBitDepth(int i) {
        this.mBitDepth = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[Catch: Exception -> 0x0074, TryCatch #0 {Exception -> 0x0074, blocks: (B:21:0x0059, B:24:0x0062, B:26:0x006e, B:23:0x005d), top: B:31:0x0059 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int initEGL() {
        /*
            r6 = this;
            android.opengl.EGLDisplay r0 = r6.getDefaultDisplay()
            r6.eglDisplay = r0
            r1 = -1
            if (r0 != 0) goto La
            return r1
        La:
            android.opengl.EGLConfig r0 = r6.mSharedEglConfig
            if (r0 == 0) goto L13
            android.opengl.EGLConfig r0 = r6.mSharedEglConfig
            r6.eglConfig = r0
            goto L19
        L13:
            android.opengl.EGLConfig r0 = r6.chooseEglConfig()
            r6.eglConfig = r0
        L19:
            android.opengl.EGLConfig r0 = r6.eglConfig
            if (r0 != 0) goto L1e
            return r1
        L1e:
            android.opengl.EGLContext r0 = r6.mSharedEglContext
            r2 = 0
            if (r0 == 0) goto L36
            r0 = 3
            int[] r0 = new int[r0]
            r0 = {x007e: FILL_ARRAY_DATA , data: [12440, 3, 12344} // fill-array
            android.opengl.EGLDisplay r3 = r6.eglDisplay
            android.opengl.EGLConfig r4 = r6.mSharedEglConfig
            android.opengl.EGLContext r5 = r6.mSharedEglContext
            android.opengl.EGLContext r0 = android.opengl.EGL14.eglCreateContext(r3, r4, r5, r0, r2)
            r6.eglContext = r0
            goto L40
        L36:
            android.opengl.EGLDisplay r0 = r6.eglDisplay
            android.opengl.EGLConfig r3 = r6.eglConfig
            android.opengl.EGLContext r0 = r6.createContext(r0, r3)
            r6.eglContext = r0
        L40:
            android.opengl.EGLContext r0 = r6.eglContext
            android.opengl.EGLContext r3 = android.opengl.EGL14.EGL_NO_CONTEXT
            if (r0 != r3) goto L47
            return r1
        L47:
            r0 = 5
            int[] r0 = new int[r0]
            r0 = {x0088: FILL_ARRAY_DATA , data: [12375, 1, 12374, 1, 12344} // fill-array
            android.opengl.EGLDisplay r3 = r6.eglDisplay
            android.opengl.EGLConfig r4 = r6.eglConfig
            android.opengl.EGLSurface r0 = android.opengl.EGL14.eglCreatePbufferSurface(r3, r4, r0, r2)
            r6.eglDummySurface = r0
            if (r0 == 0) goto L5d
            android.opengl.EGLSurface r3 = android.opengl.EGL14.EGL_NO_SURFACE     // Catch: java.lang.Exception -> L74
            if (r0 != r3) goto L62
        L5d:
            java.lang.String r0 = "create eglCreatePbufferSurface failed"
            r6.notifyEGLError(r2, r0)     // Catch: java.lang.Exception -> L74
        L62:
            android.opengl.EGLDisplay r0 = r6.eglDisplay     // Catch: java.lang.Exception -> L74
            android.opengl.EGLSurface r3 = r6.eglDummySurface     // Catch: java.lang.Exception -> L74
            android.opengl.EGLContext r4 = r6.eglContext     // Catch: java.lang.Exception -> L74
            boolean r0 = android.opengl.EGL14.eglMakeCurrent(r0, r3, r3, r4)     // Catch: java.lang.Exception -> L74
            if (r0 != 0) goto L73
            java.lang.String r0 = "eglMakeCurrent failed"
            r6.notifyEGLError(r2, r0)     // Catch: java.lang.Exception -> L74
        L73:
            return r2
        L74:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = "create dummy env failed"
            r6.notifyEGLError(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.base.EGLRuntime.initEGL():int");
    }

    public int clearSurface(Surface surface) {
        EGLSurface eGLSurfaceEglCreateWindowSurface;
        try {
            TextureRenderLog.i(this.mTexType, LOG_TAG, this + ",create window surface from " + surface);
            eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surface, new int[]{12344}, 0);
        } catch (Exception unused) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "create current exception failed");
        }
        if (eGLSurfaceEglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "create window surface failed" + GLUtils.getEGLErrorString(EGL14.eglGetError()));
            return 0;
        }
        if (!EGL14.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext)) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "make current failed = " + eGLSurfaceEglCreateWindowSurface);
            return 0;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        EGL14.eglSwapBuffers(this.eglDisplay, eGLSurfaceEglCreateWindowSurface);
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = this.eglDummySurface;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext);
        EGL14.eglDestroySurface(this.eglDisplay, eGLSurfaceEglCreateWindowSurface);
        return 0;
    }

    public int isSupportBt2020PQ() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay == null) {
            return -1;
        }
        int i = this.mIsSupport2020PQ;
        if (i >= 0) {
            return i;
        }
        String strEglQueryString = EGL14.eglQueryString(eGLDisplay, 12373);
        if (!TextUtils.isEmpty(strEglQueryString) && strEglQueryString.contains("EGL_EXT_gl_colorspace_bt2020_pq")) {
            this.mIsSupport2020PQ = 1;
        } else {
            this.mIsSupport2020PQ = 0;
        }
        return this.mIsSupport2020PQ;
    }

    public void deinitEGL() {
        if (this.eglDisplay == EGL14.EGL_NO_DISPLAY) {
            return;
        }
        try {
            EGL14.eglMakeCurrent(this.eglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            if (this.eglDummySurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.eglDisplay, this.eglDummySurface);
                this.eglDummySurface = EGL14.EGL_NO_SURFACE;
            }
            if (this.eglContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
                this.eglContext = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglTerminate(this.eglDisplay);
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        } catch (Exception unused) {
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, this + "OpenGL deinit OK.");
    }

    private EGLDisplay getDefaultDisplay() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            notifyEGLError(0, "egl get display failed");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        notifyEGLError(0, "eglInitialize failed");
        return null;
    }

    private EGLContext createContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr;
        if (this.mTexType == 1 && this.mUseGL3 && isSupportGL3()) {
            iArr = new int[]{12440, 3, 12344};
            TextureRenderLog.i(this.mTexType, LOG_TAG, "use GL3");
        } else {
            iArr = new int[]{12440, 2, 12344};
            TextureRenderLog.i(this.mTexType, LOG_TAG, "use GL2");
        }
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
        if (eGLContextEglCreateContext == EGL14.EGL_NO_CONTEXT) {
            notifyEGLError(0, "eglcreateContext failed");
        }
        return eGLContextEglCreateContext;
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

    private EGLConfig chooseEglConfig() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[][] iArr2 = {getRGB10Attributes(), getRGB888Attributes(), getRGB565Attributes()};
        for (int i = this.mBitDepth > 8 ? 0 : 1; i < 3; i++) {
            if (EGL14.eglChooseConfig(this.eglDisplay, iArr2[i], 0, eGLConfigArr, 0, 1, iArr, 0) && iArr[0] > 0) {
                TextureRenderLog.d(this.mTexType, LOG_TAG, this + ",chooseConfig:" + Arrays.toString(iArr2[i]));
                return eGLConfigArr[0];
            }
        }
        notifyEGLError(0, "eglChooseConfig failed");
        return null;
    }

    private int[] getRGB10Attributes() {
        return new int[]{12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, TextureRenderKeys.EGL_COLOR_COMPONENT_TYPE_EXT, TextureRenderKeys.EGL_COLOR_COMPONENT_TYPE_FIXED_EXT, 12344};
    }

    private int[] getRGB888Attributes() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};
    }

    private int[] getRGB565Attributes() {
        return new int[]{12352, 4, 12324, 5, 12323, 6, 12322, 5, 12344};
    }

    public long getDrawingObjectId() {
        return this.mDrawingObjectId;
    }

    public void setDrawingObjectId(long j) {
        this.mDrawingObjectId = j;
        TextureRenderLog.d(this.mTexType, LOG_TAG, "setDrawingObjectId:" + this.mDrawingObjectId);
    }

    public boolean isCurrentObject(long j) {
        return this.mDrawingObjectId == j;
    }

    private void notifyEGLError(int i, String str) {
        ErrorCallback errorCallback = this.mErrorCallback;
        if (errorCallback != null) {
            errorCallback.onError(this, i, str);
        }
    }
}
