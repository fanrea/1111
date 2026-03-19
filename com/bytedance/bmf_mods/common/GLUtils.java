package com.bytedance.bmf_mods.common;

import android.opengl.GLES20;
import com.sigmob.sdk.archives.tar.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class GLUtils {
    public static int createFbo() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        checkGLError("GLUtils: createFbo");
        return iArr[0];
    }

    public static void deleteFbo(int i) {
        if (i > 0) {
            GLES20.glDeleteFramebuffers(1, new int[i], 0);
        }
    }

    public static int genTexture(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGLError("GLUtils: glGenTextures");
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

    public static void deleteTexture(int i) {
        if (i > 0) {
            GLES20.glDeleteTextures(1, new int[i], 0);
        }
    }

    public static boolean checkGLError(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return false;
        }
        Logging.d(" " + str + " : " + android.opengl.GLUtils.getEGLErrorString(iGlGetError));
        return true;
    }

    public static String texTargetToString(int i) {
        return i == 36197 ? "texture_oes" : i == 3553 ? "texture_2d" : Integer.toString(i);
    }
}
