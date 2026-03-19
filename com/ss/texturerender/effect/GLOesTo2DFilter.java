package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLOesTo2DFilter extends GLDefaultFilter {
    private static final String LOG_TAG = "TR_GLOesTo2DFilter";
    private float[] mSTMatrix;
    private int muSTMatrixHandle;
    private final String oesFragmentShader;
    private final String oesVertexShader;

    public GLOesTo2DFilter(int i) {
        super(i, 3);
        this.oesVertexShader = "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        this.oesFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        this.mSTMatrix = new float[16];
        this.mInTextureTarget = 36197;
        this.mOrder = 100;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new GLOesTo2DFilter");
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        if (super.init(bundle) != 0) {
            if (this.mSurfaceTexture == null) {
                return -1;
            }
            this.mSurfaceTexture.notifyError(10, this.mEffectType, "super.init(bundle) != TR_OK");
            return -1;
        }
        this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        TextureRenderLog.i(this.mTexType, LOG_TAG, PointCategory.INIT);
        setOption(bundle);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        return i != 11000 ? i != 11001 ? super.getStringOption(i) : "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n" : "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        return 0;
    }
}
