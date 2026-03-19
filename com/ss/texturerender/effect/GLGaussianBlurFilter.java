package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.kuaishou.socket.nano.SocketMessages;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLGaussianBlurFilter extends GLDefaultFilter {
    private static final int BASE_RESOLUTION = 172800;
    private static final float DEFAULT_SIGMA = 2.0f;
    private static final String LOG_TAG = "TR_GLGaussianBlurFilter";
    private static final float MAX_SIGMA = 26.0f;
    private int mBlurRadius;
    private int mBlurRadiusLoc;
    private float mGaussianAlpha;
    private int mGaussianAlphaLoc;
    private float[] mGaussianWeights;
    private int mGaussianWeightsLoc;
    private boolean mIsGaussianWeightsSet;
    protected int mProcessStage;
    private float mScaleRatio;
    protected float mSigma;
    private int mTexH;
    private int mTexW;
    private float mTexelHeightOffset;
    private int mTexelOffsetLoc;
    private float mTexelWidthOffset;
    private final String vertexDefaultShader;

    public GLGaussianBlurFilter(int i) {
        super(i, 10);
        this.vertexDefaultShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nuniform float gaussianAlpha;\nvoid main() {\n    vec4 sum = texture2D(sTexture, vTextureCoord) * gaussianWeights[0];\n    for (int i = 1; i <= radius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, vTextureCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, vTextureCoord - stepOffset) * gaussianWeights[i];\n    }\n    gl_FragColor = vec4(sum.rgb, gaussianAlpha);\n}\n";
        this.mSigma = DEFAULT_SIGMA;
        this.mIsGaussianWeightsSet = false;
        this.mGaussianWeightsLoc = -1;
        this.mTexelOffsetLoc = -1;
        this.mBlurRadiusLoc = -1;
        this.mGaussianAlphaLoc = -1;
        this.mTexelWidthOffset = 0.0f;
        this.mTexelHeightOffset = 0.0f;
        this.mGaussianAlpha = 1.0f;
        this.mProcessStage = -1;
        this.mOrder = 6;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new GLGaussianBlurFilter,this:" + this);
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
        this.mGaussianWeightsLoc = GLES20.glGetUniformLocation(this.mProgram, "gaussianWeights");
        this.mTexelOffsetLoc = GLES20.glGetUniformLocation(this.mProgram, "texelOffset");
        this.mBlurRadiusLoc = GLES20.glGetUniformLocation(this.mProgram, "radius");
        this.mGaussianAlphaLoc = GLES20.glGetUniformLocation(this.mProgram, "gaussianAlpha");
        float f = bundle.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, -1.0f);
        if (f > 1.0f) {
            updateGaussianWeights(f);
        } else {
            updateGaussianWeights(DEFAULT_SIGMA);
        }
        this.mGaussianAlpha = bundle.getFloat("alpha", 1.0f);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "GLGaussianBlurFilter init,this:" + this);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        if (this.mSigma == 1.0f) {
            return effectTexture;
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        }
        EffectTexture effectTextureProcessWithTwoPass = processWithTwoPass(effectTexture, frameBuffer, true, false, true);
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        }
        return effectTextureProcessWithTwoPass;
    }

    protected EffectTexture processWithTwoPass(EffectTexture effectTexture, FrameBuffer frameBuffer, boolean z, boolean z2, boolean z3) {
        if (this.mTexH != effectTexture.getHeight() || this.mTexW != effectTexture.getWidth()) {
            this.mTexW = effectTexture.getWidth();
            this.mTexH = effectTexture.getHeight();
            float fSqrt = (float) Math.sqrt(((this.mTexW * 1.0f) * r0) / 172800.0f);
            this.mScaleRatio = fSqrt;
            this.mScaleRatio = Math.max(fSqrt, 1.0f);
            TextureRenderLog.d(this.mTexType, LOG_TAG, "tex w:" + this.mTexW + ",h:" + this.mTexH + ",ratio:" + this.mScaleRatio);
        }
        int i = this.mProcessStage;
        if (i == -1 || i == 0) {
            this.mTexelWidthOffset = (1.0f / effectTexture.getWidth()) * this.mScaleRatio;
            this.mTexelHeightOffset = 0.0f;
        } else {
            this.mTexelWidthOffset = 0.0f;
            this.mTexelHeightOffset = (1.0f / effectTexture.getHeight()) * this.mScaleRatio;
        }
        EffectTexture effectTextureProcess = super.process(effectTexture, frameBuffer, Boolean.valueOf(z3));
        if (!z) {
            return effectTextureProcess;
        }
        this.mTexelWidthOffset = 0.0f;
        this.mTexelHeightOffset = (1.0f / effectTexture.getHeight()) * this.mScaleRatio;
        if (z2) {
            super.process(effectTextureProcess, null, Boolean.valueOf(z3));
            return null;
        }
        return super.process(effectTextureProcess, frameBuffer, Boolean.valueOf(z3));
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        if (!this.mIsGaussianWeightsSet) {
            int i = this.mGaussianWeightsLoc;
            if (i >= 0) {
                GLES20.glUniform1fv(i, this.mBlurRadius + 1, this.mGaussianWeights, 0);
            }
            int i2 = this.mBlurRadiusLoc;
            if (i2 >= 0) {
                GLES20.glUniform1i(i2, this.mBlurRadius);
            }
            this.mIsGaussianWeightsSet = true;
        }
        int i3 = this.mBlurRadiusLoc;
        if (i3 >= 0) {
            GLES20.glUniform1i(i3, this.mBlurRadius);
        }
        int i4 = this.mTexelOffsetLoc;
        if (i4 >= 0) {
            GLES20.glUniform2f(i4, this.mTexelWidthOffset, this.mTexelHeightOffset);
        }
        float f = this.mGaussianAlpha;
        if (f < 1.0f) {
            int i5 = this.mGaussianAlphaLoc;
            if (i5 >= 0) {
                GLES20.glUniform1f(i5, f);
            }
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, SocketMessages.PayloadType.SC_LIVE_GIFT_OUTSIDE_MESSAGE);
        }
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        if (this.mGaussianAlpha >= 1.0f) {
            return 0;
        }
        GLES20.glDisable(3042);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, float f) {
        if (i == 20 && f != this.mSigma) {
            updateGaussianWeights(f);
            TextureRenderLog.i(this.mTexType, LOG_TAG, "set strength:" + this.mSigma + ",this:" + this);
        }
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle bundle) {
        if (bundle == null || this.mEffectType != bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE)) {
            return;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setOption:" + bundle.toString() + ",this:" + this);
        if (bundle.getInt("action") != 20) {
            return;
        }
        float f = bundle.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, -1.0f);
        if (f == this.mSigma || f <= 0.0f) {
            return;
        }
        updateGaussianWeights(f);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "set strength:" + this.mSigma + ",this:" + this);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        return i != 11001 ? super.getStringOption(i) : "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nuniform float gaussianAlpha;\nvoid main() {\n    vec4 sum = texture2D(sTexture, vTextureCoord) * gaussianWeights[0];\n    for (int i = 1; i <= radius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, vTextureCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, vTextureCoord - stepOffset) * gaussianWeights[i];\n    }\n    gl_FragColor = vec4(sum.rgb, gaussianAlpha);\n}\n";
    }

    private void updateGaussianWeights(float f) {
        float fMax = Math.max(Math.min(f, MAX_SIGMA), 1.0f);
        this.mSigma = fMax;
        this.mBlurRadius = (int) Math.floor(Math.sqrt(Math.pow(fMax, 2.0d) * (-2.0d) * Math.log(0.00390625f * Math.sqrt(Math.pow(this.mSigma, 2.0d) * 6.283185307179586d))));
        TextureRenderLog.i(this.mTexType, LOG_TAG, "updateGaussianWeights sigma:" + this.mSigma + ",mBlurRadius:" + this.mBlurRadius);
        this.mGaussianWeights = new float[this.mBlurRadius + 1];
        for (int i = 0; i <= this.mBlurRadius; i++) {
            this.mGaussianWeights[i] = (float) getGaussianWeight(this.mSigma, i);
        }
        float f2 = this.mGaussianWeights[0];
        for (int i2 = 1; i2 <= this.mBlurRadius; i2++) {
            f2 += this.mGaussianWeights[i2] * DEFAULT_SIGMA;
        }
        for (int i3 = 0; i3 <= this.mBlurRadius; i3++) {
            float[] fArr = this.mGaussianWeights;
            fArr[i3] = fArr[i3] / f2;
        }
        this.mIsGaussianWeightsSet = false;
    }

    private double getGaussianWeight(float f, int i) {
        double d = f;
        return (1.0d / Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i, 2.0d)) / (Math.pow(d, 2.0d) * 2.0d));
    }
}
