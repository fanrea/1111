package com.ss.texturerender;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.sigmob.sdk.archives.tar.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TexGLUtils {
    private static final String LOG_TAG = "GLUtils";

    public static int createFbo() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        checkGLError(-1, "createFbo");
        return iArr[0];
    }

    public static void deleteFbo(int i) {
        if (i > 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
        }
    }

    public static int genTexture(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGLError(-1, "glGenTextures");
        int i2 = iArr[0];
        if (i2 != 0) {
            GLES20.glBindTexture(i, i2);
            GLES20.glTexParameteri(i, 10242, 33071);
            GLES20.glTexParameteri(i, 10243, 33071);
            GLES20.glTexParameteri(i, 10241, 9729);
            GLES20.glTexParameteri(i, d.b, 9729);
        }
        return iArr[0];
    }

    public static int genTexture(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGLError(-1, "glGenTextures");
        int i3 = iArr[0];
        if (i3 != 0) {
            GLES20.glBindTexture(i, i3);
            GLES20.glTexParameteri(i, 10242, 33071);
            GLES20.glTexParameteri(i, 10243, 33071);
            GLES20.glTexParameteri(i, 10241, i2);
            GLES20.glTexParameteri(i, d.b, i2);
        }
        return iArr[0];
    }

    public static void deleteTexture(int i) {
        if (i > 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }

    public static int checkGLError(int i, String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            TextureRenderLog.e(i, LOG_TAG, str + ": gl error = " + GLUtils.getEGLErrorString(iGlGetError));
        }
        return iGlGetError;
    }

    public static String texTargetToString(int i) {
        return i == 36197 ? "texture_oes" : i == 3553 ? "texture_2d" : Integer.toString(i);
    }
}
