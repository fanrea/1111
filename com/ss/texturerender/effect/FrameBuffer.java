package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import com.ss.texturerender.TexGLUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FrameBuffer {
    public static int[] GL_COLOR_ATTACHMENTS = {36064, 36065};
    private int mFboID = TexGLUtils.createFbo();

    public void bind() {
        GLES20.glBindFramebuffer(36160, this.mFboID);
    }

    public void unBind() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    public int bindTexture2D(int i) {
        bind();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        return GLES20.glCheckFramebufferStatus(36160) != 36053 ? -1 : 0;
    }

    public void unbindTexture2D() {
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
        unBind();
    }

    public int bindTexture2Ds(int[] iArr, int[] iArr2) {
        bind();
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            GLES20.glFramebufferTexture2D(36160, iArr2[i], 3553, iArr[i], 0);
        }
        if (Build.VERSION.SDK_INT < 18) {
            return -1;
        }
        GLES30.glDrawBuffers(length, iArr2, 0);
        return GLES20.glCheckFramebufferStatus(36160) != 36053 ? -1 : 0;
    }

    public void unbindTexture2Ds(int[] iArr) {
        for (int i : iArr) {
            GLES20.glFramebufferTexture2D(36160, i, 3553, 0, 0);
        }
        unBind();
    }

    public void release() {
        TexGLUtils.deleteFbo(this.mFboID);
    }
}
