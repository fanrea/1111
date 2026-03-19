package com.ss.texturerender;

import android.opengl.GLES20;
import android.opengl.GLUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ShaderHelper {
    private static final String TAG = "ShaderHelper";

    public static int compileShader(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        if (iGlCreateShader != 0) {
            int[] iArr = new int[1];
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                TextureRenderLog.e(-1, TAG, "Fail to compile shader" + GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                iGlCreateShader = 0;
            }
        }
        if (iGlCreateShader == 0) {
            TextureRenderLog.e(-1, TAG, "EGL Error: " + GLUtils.getEGLErrorString(GLES20.glGetError()));
        }
        return iGlCreateShader;
    }

    public static int createAndLinkProgram(int i, int i2, String[] strArr) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            return iGlCreateProgram;
        }
        int[] iArr = new int[1];
        GLES20.glAttachShader(iGlCreateProgram, i2);
        GLES20.glAttachShader(iGlCreateProgram, i);
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                GLES20.glBindAttribLocation(iGlCreateProgram, i3, strArr[i3]);
            }
        }
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateProgram;
        }
        TextureRenderLog.e(-1, TAG, "Failed to compile program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }
}
