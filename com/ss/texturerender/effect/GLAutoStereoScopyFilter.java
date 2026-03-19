package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLAutoStereoScopyFilter extends GLDefaultFilter {
    private static final String LOG_TAG = "TR_GLAutoStereoScopyFilter";
    private final String fragmentShader;
    private float[] mAlphaTextureVerticesData;
    private int mOffsetsHandle;
    private float[] mSTMatrix;
    private int mSTMatrixHandle;
    private int mVideoNums;
    private final String oesFragmentShader;
    private final String oesVertexShader;
    private final String vertexShader;

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        return effectTexture;
    }

    public GLAutoStereoScopyFilter(int i) {
        super(i, 22);
        this.vertexShader = "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}";
        this.oesVertexShader = "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}";
        this.fragmentShader = "#version 300 es\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform sampler2D sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x, 0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}";
        this.oesFragmentShader = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x,0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}";
        this.mSTMatrix = new float[16];
        this.mVideoNums = 3;
        this.mOrder = 100;
        this.mIsSupportOes = 1;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new GLAutoStereoScopyFilter");
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        int i = bundle.getInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE);
        if (i == this.mInTextureTarget && this.mProgram > 0) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "inited");
            return 0;
        }
        if (this.mProgram > 0) {
            GLES20.glDeleteProgram(this.mProgram);
            this.mProgram = 0;
        }
        this.mInTextureTarget = i;
        int i2 = bundle.getInt(TextureRenderKeys.KEY_IS_VIDEO_NUMS, 3);
        this.mVideoNums = i2;
        this.mAlphaTextureVerticesData = new float[]{0.0f, 0.0f, 1.0f / i2, 0.0f, 0.0f, 1.0f, 1.0f / i2, 1.0f};
        int iInit = super.init(bundle);
        if (this.mInTextureTarget == 36197) {
            this.mSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        }
        this.mOffsetsHandle = GLES20.glGetUniformLocation(this.mProgram, "offsets");
        TextureRenderLog.i(this.mTexType, LOG_TAG, "init texTarget:" + this.mInTextureTarget);
        return iInit;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    protected void initParam() {
        this.mTextureVertices = ByteBuffer.allocateDirect(this.mAlphaTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVertices.put(this.mAlphaTextureVerticesData).position(0);
        this.mTriangleVertices = ByteBuffer.allocateDirect(mTriangleVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices.put(mTriangleVerticesData).position(0);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture[] processWithMRT(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        EffectTexture effectTextureGenTexture;
        EffectTexture effectTextureGenTexture2;
        if (this.mSurfaceTexture != null && this.mSurfaceTexture.getIntOption(126, this.mEffectType) == -1) {
            this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
        }
        if (effectTexture.getTexTarget() != this.mInTextureTarget) {
            TextureRenderLog.e(this.mTexType, getClass().getSimpleName(), "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + effectTexture.getTexTarget());
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + effectTexture.getTexTarget());
            }
            return null;
        }
        if (this.mProgram == 0) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
            }
            return null;
        }
        int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "filter process start,type:" + this.mEffectType);
        if (iCheckGLError != 0) {
            this.mGLError = -1;
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(iCheckGLError, this.mEffectType, "");
            }
            return null;
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        }
        updateRenderParam(effectTexture, frameBuffer);
        if (frameBuffer != null) {
            if (this.mOutTexWidth == 0 || this.mOutTexHeight == 0) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
                if (this.mSurfaceTexture != null) {
                    this.mSurfaceTexture.notifyError(14, this.mEffectType, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
                }
            }
            effectTextureGenTexture = genTexture();
            effectTextureGenTexture2 = genTexture();
            if (effectTextureGenTexture == null || effectTextureGenTexture2 == null) {
                return null;
            }
            frameBuffer.bindTexture2Ds(new int[]{effectTextureGenTexture.getTexID(), effectTextureGenTexture2.getTexID()}, FrameBuffer.GL_COLOR_ATTACHMENTS);
        } else {
            effectTextureGenTexture = null;
            effectTextureGenTexture2 = null;
        }
        GLES20.glUseProgram(this.mProgram);
        if (this.mNeedClear) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        this.mTriangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, (Buffer) this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, (Buffer) this.mTextureVertices);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, effectTexture.getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        if (this.mInTextureTarget == 36197) {
            this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
            GLES20.glUniformMatrix4fv(this.mSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        }
        GLES20.glUniform2i(this.mOffsetsHandle, this.mOutTexWidth, this.mVideoNums == 2 ? 0 : this.mOutTexWidth * 2);
        int iCheckGLError2 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays before,type:" + this.mEffectType);
        if (iCheckGLError2 == 0) {
            GLES20.glDrawArrays(5, 0, 4);
            this.mGLError = 0;
        } else {
            this.mGLError = -1;
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(iCheckGLError2, this.mEffectType, "filter glDrawArrays before,type:" + this.mEffectType);
            }
        }
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        if (this.mIsCallGLfinish == 1) {
            GLES20.glFinish();
        }
        if (frameBuffer != null) {
            frameBuffer.unbindTexture2Ds(FrameBuffer.GL_COLOR_ATTACHMENTS);
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        }
        int iCheckGLError3 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays after,type:" + this.mEffectType);
        if (this.mGLError == 0 && iCheckGLError3 == 0) {
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
            }
            effectTexture.giveBack();
            return new EffectTexture[]{effectTextureGenTexture2, effectTextureGenTexture};
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.notifyError(iCheckGLError3, this.mEffectType, "filter glDrawArrays after,type:" + this.mEffectType);
        }
        if (effectTextureGenTexture2 != null) {
            effectTextureGenTexture2.giveBack();
        }
        if (effectTextureGenTexture != null) {
            effectTextureGenTexture.giveBack();
        }
        this.mGLError = -1;
        return null;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        this.mOutTexWidth = effectTexture.getWidth() / this.mVideoNums;
        this.mOutTexHeight = effectTexture.getHeight();
        this.mViewPortWidth = this.mOutTexWidth;
        this.mViewPortHeight = this.mOutTexHeight;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        if (i == 11000) {
            return this.mInTextureTarget == 36197 ? "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}" : "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}";
        }
        if (i != 11001) {
            return super.getStringOption(i);
        }
        return this.mInTextureTarget == 36197 ? "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x,0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}" : "#version 300 es\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform sampler2D sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x, 0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}";
    }
}
