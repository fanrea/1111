package lkxssdk.u;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d implements SurfaceTexture.OnFrameAvailableListener {
    public EGL10 a;
    public EGLDisplay b;
    public EGLContext c;
    public EGLSurface d;
    public SurfaceTexture e;
    public Surface f;
    public final Object g;
    public boolean h;
    public f i;
    public int j;
    public int k;
    public int l;
    public ByteBuffer m;

    public d() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = new Object();
        this.l = 0;
        g();
    }

    public d(int i, int i2, int i3) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = new Object();
        this.l = 0;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.j = i;
        this.k = i2;
        this.l = i3;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
        this.m = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        a(i, i2);
        e();
        g();
    }

    public void a() {
        synchronized (this.g) {
            while (!this.h) {
                try {
                    this.g.wait(5000L);
                    if (!this.h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.h = false;
        }
        this.i.a("before updateTexImage");
        this.e.updateTexImage();
    }

    public final void a(int i, int i2) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.a = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.a.eglInitialize(eGLDisplayEglGetDisplay, null)) {
            this.b = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.a.eglChooseConfig(this.b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        this.c = this.a.eglCreateContext(this.b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        b();
        if (this.c == null) {
            throw new RuntimeException("null context");
        }
        this.d = this.a.eglCreatePbufferSurface(this.b, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344});
        b();
        if (this.d == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public void a(boolean z) {
        f fVar = this.i;
        SurfaceTexture surfaceTexture = this.e;
        fVar.a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(fVar.d);
        if (z) {
            float[] fArr = fVar.d;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(fVar.e);
        fVar.a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, fVar.f);
        fVar.b.position(0);
        GLES20.glVertexAttribPointer(fVar.i, 3, 5126, false, 20, (Buffer) fVar.b);
        fVar.a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(fVar.i);
        fVar.a("glEnableVertexAttribArray maPositionHandle");
        fVar.b.position(3);
        GLES20.glVertexAttribPointer(fVar.j, 2, 5126, false, 20, (Buffer) fVar.b);
        fVar.a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(fVar.j);
        fVar.a("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(fVar.h, 1, false, fVar.d, 0);
        GLES20.glUniformMatrix4fv(fVar.g, 1, false, fVar.c, 0);
        GLES20.glDrawArrays(5, 0, 4);
        fVar.a("glDrawArrays");
        GLES20.glFinish();
    }

    public final void b() {
        if (this.a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public ByteBuffer c() {
        this.m.rewind();
        GLES20.glReadPixels(0, 0, this.j, this.k, 6408, 5121, this.m);
        return this.m;
    }

    public Surface d() {
        return this.f;
    }

    public void e() {
        if (this.a == null) {
            throw new RuntimeException("not configured for makeCurrent");
        }
        b();
        EGL10 egl10 = this.a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.d;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void f() {
        EGL10 egl10 = this.a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.c)) {
                EGL10 egl102 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.a.eglDestroySurface(this.b, this.d);
            this.a.eglDestroyContext(this.b, this.c);
        }
        this.f.release();
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = null;
        this.i = null;
        this.f = null;
        this.e = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.u.d.g():void");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.g) {
            if (this.h) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.h = true;
            this.g.notifyAll();
        }
    }
}
