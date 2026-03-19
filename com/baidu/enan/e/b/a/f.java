package com.baidu.enan.e.b.a;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    public GL10 a;
    private EGL10 b;
    private EGLDisplay c;
    private EGLConfig d;
    private EGLSurface e;
    private EGLContext f;
    private Object h;
    private int g = 1;
    private int i = 8;
    private int j = 8;
    private int k = 8;
    private int l = 8;
    private int m = 16;
    private int n = 4;
    private EGLContext o = EGL10.EGL_NO_CONTEXT;

    public void a() {
        EGL10 egl10 = this.b;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = this.e;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f);
        this.a = (GL10) this.f.getGL();
    }

    public boolean a(int i, int i2) {
        int[] iArr = {12324, this.i, 12323, this.j, 12322, this.k, 12321, this.l, 12325, this.m, 12352, this.n, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.b = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.c = eGLDisplayEglGetDisplay;
        this.b.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
        int[] iArr2 = new int[1];
        this.b.eglChooseConfig(this.c, iArr, null, 0, iArr2);
        if (iArr2[0] == 0) {
            return false;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[iArr2[0]];
        this.b.eglChooseConfig(this.c, iArr, eGLConfigArr, iArr2[0], iArr2);
        this.d = eGLConfigArr[0];
        this.e = a(new int[]{12375, i, 12374, i2, 12344});
        this.f = this.b.eglCreateContext(this.c, this.d, this.o, new int[]{12440, 2, 12344});
        a();
        return true;
    }

    public void b() {
        EGL10 egl10 = this.b;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.b.eglDestroySurface(this.c, this.e);
        this.b.eglDestroyContext(this.c, this.f);
        this.b.eglTerminate(this.c);
    }

    private EGLSurface a(int[] iArr) {
        int i = this.g;
        if (i == 2) {
            return this.b.eglCreatePixmapSurface(this.c, this.d, this.h, iArr);
        }
        if (i != 3) {
            return this.b.eglCreatePbufferSurface(this.c, this.d, iArr);
        }
        return this.b.eglCreateWindowSurface(this.c, this.d, this.h, iArr);
    }
}
