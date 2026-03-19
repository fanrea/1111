package com.ss.ttm.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.bytedance.common.utility.DeviceUtils;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class DummySurface extends Surface {
    public static final int CACHE_MODE_ALL = 0;
    public static final int CACHE_MODE_DYNAMIC_EXCEPTION = 1;
    public static final int CACHE_MODE_DYNAMIC_EXCEPTION_OTHER = 2;
    public static final int CACHE_MODE_FORBIDDEN_EXCEPTION = 3;
    public static final int CACHE_MODE_FORBIDDEN_EXCEPTION_OTHER = 4;
    public static final int EVENT_SETOUTPUTSSURFACE_EXCEPTION = 1;
    public static final int EVENT_SETOUTPUTSSURFACE_EXCEPTION_OTHER = 2;
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final int MAX_CAPACITY_CACHES = 2;
    private static int SetOutputSurfaceExceptionCounter = 0;
    private static volatile int SetOutputSurfaceExceptionLimit = 1;
    private static int SetOutputSurfaceExceptionOtherCounter = 0;
    private static volatile int SetOutputSurfaceExceptionOtherLimit = 1;
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    private volatile boolean cached;
    private boolean hasSetOutputSurfaceException;
    private boolean hasSetOutputSurfaceExceptionOther;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;
    private static final ConcurrentLinkedQueue<DummySurface> caches = new ConcurrentLinkedQueue<>();
    private static volatile boolean useDummySurfaceCaches = false;
    private static volatile int cacheMode = 0;

    public static void useCaches(boolean z) {
        useCaches(z, 0);
    }

    public static void useCaches(boolean z, int i) {
        useCaches(z, i, SetOutputSurfaceExceptionLimit);
    }

    public static void useCaches(boolean z, int i, int i2) {
        Log.d(TAG, "useCaches:" + z + ":" + i + ":" + i2);
        useDummySurfaceCaches = z;
        cacheMode = i;
        if (i == 3) {
            SetOutputSurfaceExceptionLimit = i2;
        } else if (i == 4) {
            SetOutputSurfaceExceptionOtherLimit = i2;
        }
        if (useDummySurfaceCaches) {
            return;
        }
        while (true) {
            ConcurrentLinkedQueue<DummySurface> concurrentLinkedQueue = caches;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            DummySurface dummySurfacePoll = concurrentLinkedQueue.poll();
            if (dummySurfacePoll != null) {
                dummySurfacePoll.release();
            }
        }
    }

    public static synchronized boolean isSecureSupported(Context context) {
        if (!secureModeInitialized) {
            secureMode = Build.VERSION.SDK_INT < 24 ? 0 : getSecureModeV24(context);
            secureModeInitialized = true;
        }
        return secureMode != 0;
    }

    public static DummySurface newInstanceV17(boolean z) {
        DummySurface dummySurfacePoll;
        if (useDummySurfaceCaches && !z && (dummySurfacePoll = caches.poll()) != null) {
            dummySurfacePoll.cached = false;
            Log.d(TAG, "get cached DummySurface@" + dummySurfacePoll.hashCode());
            return dummySurfacePoll;
        }
        return newInstanceV17Internal(z);
    }

    private static DummySurface newInstanceV17Internal(boolean z) {
        Log.d(TAG, "create DummySurface internal:" + z);
        assertApiLevel17OrHigher();
        return new DummySurfaceThread().init(z ? secureMode : 0);
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.cached = false;
        this.hasSetOutputSurfaceException = false;
        this.hasSetOutputSurfaceExceptionOther = false;
        this.thread = dummySurfaceThread;
        this.secure = z;
    }

    public void addEvent(int i) {
        if (i == 1) {
            this.hasSetOutputSurfaceException = true;
            this.hasSetOutputSurfaceExceptionOther = true;
        } else {
            if (i != 2) {
                return;
            }
            this.hasSetOutputSurfaceExceptionOther = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005d  */
    @Override // android.view.Surface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void release() {
        /*
            r5 = this;
            boolean r0 = com.ss.ttm.player.DummySurface.useDummySurfaceCaches
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L1c
            java.util.concurrent.ConcurrentLinkedQueue<com.ss.ttm.player.DummySurface> r0 = com.ss.ttm.player.DummySurface.caches
            int r0 = r0.size()
            if (r0 > r1) goto L1c
            boolean r0 = r5.secure
            if (r0 != 0) goto L1c
            boolean r0 = r5.isValid()
            if (r0 != 0) goto L1a
            goto L1c
        L1a:
            r0 = r2
            goto L1d
        L1c:
            r0 = r3
        L1d:
            if (r0 == 0) goto L5d
            int r4 = com.ss.ttm.player.DummySurface.cacheMode
            if (r4 != r2) goto L28
            boolean r4 = r5.hasSetOutputSurfaceException
            if (r4 == 0) goto L28
            goto L5e
        L28:
            int r4 = com.ss.ttm.player.DummySurface.cacheMode
            if (r4 != r1) goto L31
            boolean r1 = r5.hasSetOutputSurfaceExceptionOther
            if (r1 == 0) goto L31
            goto L5e
        L31:
            int r1 = com.ss.ttm.player.DummySurface.cacheMode
            r4 = 3
            if (r1 != r4) goto L47
            boolean r1 = r5.hasSetOutputSurfaceException
            if (r1 == 0) goto L47
            int r1 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionCounter
            int r1 = r1 + r2
            com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionCounter = r1
            int r4 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionLimit
            if (r1 < r4) goto L5d
            useCaches(r3)
            goto L5e
        L47:
            int r1 = com.ss.ttm.player.DummySurface.cacheMode
            r4 = 4
            if (r1 != r4) goto L5d
            boolean r1 = r5.hasSetOutputSurfaceExceptionOther
            if (r1 == 0) goto L5d
            int r1 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionOtherCounter
            int r1 = r1 + r2
            com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionOtherCounter = r1
            int r4 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionOtherLimit
            if (r1 < r4) goto L5d
            useCaches(r3)
            goto L5e
        L5d:
            r3 = r0
        L5e:
            if (r3 != 0) goto L64
            r5.releaseInternal()
            return
        L64:
            boolean r0 = r5.cached
            if (r0 != 0) goto L8b
            java.util.concurrent.ConcurrentLinkedQueue<com.ss.ttm.player.DummySurface> r0 = com.ss.ttm.player.DummySurface.caches
            r0.add(r5)
            r5.cached = r2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cache DummySurface@"
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = r5.hashCode()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DummySurface"
            android.util.Log.d(r1, r0)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.DummySurface.release():void");
    }

    private void releaseInternal() {
        Log.d(TAG, "release DummySurface internal@" + hashCode());
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private static void assertApiLevel17OrHigher() {
        if (Build.VERSION.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    private static int getSecureModeV24(Context context) {
        String strEglQueryString;
        if ((Build.VERSION.SDK_INT >= 26 || !(DeviceUtils.ROM_SAMSUNG.equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return strEglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT) ? 1 : 2;
        }
        return 0;
    }

    private static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        public DummySurface init(int i) {
            boolean z;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z = false;
                this.handler.obtainMessage(1, i, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.initError;
            if (error != null) {
                throw error;
            }
            DummySurface dummySurface = this.surface;
            dummySurface.getClass();
            return dummySurface;
        }

        public void release() {
            Handler handler = this.handler;
            handler.getClass();
            handler.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        releaseInternal();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e);
                    this.initError = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e2);
                    this.initException = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        private void initInternal(int i) {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            eGLSurfaceTexture.getClass();
            eGLSurfaceTexture.init(i);
            this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i != 0);
        }

        private void releaseInternal() {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            eGLSurfaceTexture.getClass();
            eGLSurfaceTexture.release();
        }
    }
}
