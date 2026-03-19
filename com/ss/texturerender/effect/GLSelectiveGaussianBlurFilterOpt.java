package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLSelectiveGaussianBlurFilterOpt extends GLGaussianBlurFilter {
    private static final String LOG_TAG = "TR_GLSelectiveGaussianBlurFilterOPT";
    private final String fragmentShaderEmptyFunc;
    private final String fragmentShaderGaussianFunc;
    private final String fragmentShaderMainFunc;
    private final String fragmentShaderParam;
    private float mDisplayHeight;
    private float mDisplayWidth;
    private float mDisplayX;
    private float mDisplayY;
    protected boolean mEnableSecondPass;
    private EffectTexture mFirstGauBlurTexture;
    private int mGauBlurLongTexLength;
    private int mGaussianBlurTexHeight;
    private int mGaussianBlurTexWidth;
    public int mHeightFit;
    private int mHeightFitLoc;
    protected int mInTexHeight;
    protected int mInTexWidth;
    protected float[] mLayoutCoord;
    private int mLayoutCoordLoc;
    private int mProcessStageLoc;
    private EffectTexture mSecondGauBlurTexture;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;

    public GLSelectiveGaussianBlurFilterOpt(int i) {
        super(i);
        this.fragmentShaderParam = "precision mediump float;\n varying vec2 vTextureCoord;\n uniform sampler2D sTexture;\n uniform float gaussianAlpha;\n uniform vec4 layoutCoord;//x,y,w,h\n uniform int processStage;//0:stage1;1:stage2\n uniform int heightFit;//SurfaceRatio > TexRatio\n";
        this.fragmentShaderMainFunc = " void main() {\n     vec2 resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n    if (processStage == 0)\n    {\n        if (heightFit == 1) {\n            float middleY = layoutCoord.y / (1.0 - layoutCoord.w);\n            if (vTextureCoord.y <= middleY) {\n                float ycoord = -(((vTextureCoord.y / middleY * layoutCoord.y) - layoutCoord.y) / layoutCoord.w);\n                resetCoord = vec2(vTextureCoord.x, ycoord);\n            } else {\n                float ycoord =\n                    2.0 - ((((vTextureCoord.y - middleY) / (1.0 - middleY) * (1.0 - layoutCoord.y - layoutCoord.w) +\n                            (layoutCoord.y + layoutCoord.w)) -\n                           layoutCoord.y) /\n                              layoutCoord.w);\n                resetCoord = vec2(vTextureCoord.x, ycoord);\n            }\n        } else {\n            resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n        }\n    }\n    vec4 oriColor = texture2D(sTexture, resetCoord);\n    gl_FragColor = gaussianBlurKernel(oriColor, resetCoord);\n }";
        this.fragmentShaderGaussianFunc = "uniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nvec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    int curRadius = radius;\n    vec4 sum = oriColor * gaussianWeights[0];\n    for (int i = 1; i <= curRadius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, texCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, texCoord - stepOffset) * gaussianWeights[i];\n    }\n    return sum;\n}\n";
        this.fragmentShaderEmptyFunc = "vec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    return oriColor;\n}\n";
        this.mDisplayX = -1.0f;
        this.mLayoutCoord = null;
        this.mLayoutCoordLoc = -1;
        this.mProcessStageLoc = -1;
        this.mEnableSecondPass = false;
        this.mInTexHeight = -1;
        this.mInTexWidth = -1;
        this.mSurfaceHeight = -1;
        this.mSurfaceWidth = -1;
        this.mFirstGauBlurTexture = null;
        this.mSecondGauBlurTexture = null;
        this.mGaussianBlurTexWidth = 0;
        this.mGaussianBlurTexHeight = 0;
        this.mGauBlurLongTexLength = 320;
        this.mHeightFit = 0;
        this.mHeightFitLoc = -1;
        this.mEffectType = 15;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new GLSelectiveGaussianBlurFilter,this:" + toString());
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        this.mInTextureTarget = 3553;
        this.mSigma = bundle.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, -1.0f);
        if (this.mLayoutCoord == null) {
            this.mLayoutCoord = new float[4];
        }
        if (bundle.containsKey("x")) {
            this.mDisplayX = bundle.getFloat("x", 0.0f);
            this.mDisplayY = bundle.getFloat("y", 0.0f);
            this.mDisplayWidth = bundle.getFloat("width", 1.0f);
            this.mDisplayHeight = bundle.getFloat("height", 1.0f);
        } else {
            this.mLayoutAspectRatio = bundle.getFloat(TextureRenderKeys.KEY_IS_ASPECT_RATIO, 0.5f);
        }
        this.mGauBlurLongTexLength = bundle.getInt(TextureRenderKeys.KEY_IS_SELECT_GAUSSBLUR_TEX_LENGTH, 320);
        int iInit = super.init(bundle);
        if (iInit == 0) {
            this.mLayoutCoordLoc = GLES20.glGetUniformLocation(this.mProgram, "layoutCoord");
            this.mProcessStageLoc = GLES20.glGetUniformLocation(this.mProgram, "processStage");
            this.mHeightFitLoc = GLES20.glGetUniformLocation(this.mProgram, "heightFit");
        }
        GLES20.glUseProgram(this.mProgram);
        return iInit;
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        this.mInTexWidth = effectTexture.getWidth();
        this.mInTexHeight = effectTexture.getHeight();
        this.mSurfaceWidth = this.mSurfaceTexture.getViewportWidth();
        int viewportHeight = this.mSurfaceTexture.getViewportHeight();
        this.mSurfaceHeight = viewportHeight;
        if ((viewportHeight * 1.0f) / this.mSurfaceWidth >= (this.mInTexHeight * 1.0f) / this.mInTexWidth) {
            this.mHeightFit = 1;
        } else {
            this.mHeightFit = 0;
        }
        return processWithTwoPass(effectTexture, frameBuffer, false, false, false);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        if (this.mProcessStage == 0) {
            cacluGauBlurTexSize((this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth, (this.mInTexHeight * 1.0f) / this.mInTexWidth, 0);
        }
        this.mViewPortWidth = this.mGaussianBlurTexWidth;
        this.mViewPortHeight = this.mGaussianBlurTexHeight;
        this.mViewPortX = 0;
        this.mViewPortY = 0;
        this.mOutTexWidth = this.mGaussianBlurTexWidth;
        this.mOutTexHeight = this.mGaussianBlurTexHeight;
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        if (this.mProcessStage == 0) {
            float f = this.mDisplayX;
            if (f < 0.0f) {
                updateLayoutCoord((this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth, (this.mInTexHeight * 1.0f) / this.mInTexWidth, 0, this.mLayoutAspectRatio, this.mLayoutCoord);
            } else {
                float[] fArr = this.mLayoutCoord;
                fArr[0] = f;
                fArr[1] = this.mDisplayY;
                fArr[2] = this.mDisplayWidth;
                fArr[3] = this.mDisplayHeight;
            }
        }
        int i = this.mLayoutCoordLoc;
        float[] fArr2 = this.mLayoutCoord;
        GLES20.glUniform4f(i, fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        int i2 = this.mProcessStageLoc;
        if (i2 >= 0) {
            GLES20.glUniform1i(i2, this.mProcessStage);
        }
        GLES20.glUniform1i(this.mHeightFitLoc, this.mHeightFit);
        TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays before,type:" + this.mEffectType);
        return super.onDrawFrameBefore();
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        if (i != 11001) {
            return super.getStringOption(i);
        }
        if (this.mSigma == 1.0f) {
            return "precision mediump float;\n varying vec2 vTextureCoord;\n uniform sampler2D sTexture;\n uniform float gaussianAlpha;\n uniform vec4 layoutCoord;//x,y,w,h\n uniform int processStage;//0:stage1;1:stage2\n uniform int heightFit;//SurfaceRatio > TexRatio\nvec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    return oriColor;\n}\n void main() {\n     vec2 resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n    if (processStage == 0)\n    {\n        if (heightFit == 1) {\n            float middleY = layoutCoord.y / (1.0 - layoutCoord.w);\n            if (vTextureCoord.y <= middleY) {\n                float ycoord = -(((vTextureCoord.y / middleY * layoutCoord.y) - layoutCoord.y) / layoutCoord.w);\n                resetCoord = vec2(vTextureCoord.x, ycoord);\n            } else {\n                float ycoord =\n                    2.0 - ((((vTextureCoord.y - middleY) / (1.0 - middleY) * (1.0 - layoutCoord.y - layoutCoord.w) +\n                            (layoutCoord.y + layoutCoord.w)) -\n                           layoutCoord.y) /\n                              layoutCoord.w);\n                resetCoord = vec2(vTextureCoord.x, ycoord);\n            }\n        } else {\n            resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n        }\n    }\n    vec4 oriColor = texture2D(sTexture, resetCoord);\n    gl_FragColor = gaussianBlurKernel(oriColor, resetCoord);\n }";
        }
        return "precision mediump float;\n varying vec2 vTextureCoord;\n uniform sampler2D sTexture;\n uniform float gaussianAlpha;\n uniform vec4 layoutCoord;//x,y,w,h\n uniform int processStage;//0:stage1;1:stage2\n uniform int heightFit;//SurfaceRatio > TexRatio\nuniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nvec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    int curRadius = radius;\n    vec4 sum = oriColor * gaussianWeights[0];\n    for (int i = 1; i <= curRadius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, texCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, texCoord - stepOffset) * gaussianWeights[i];\n    }\n    return sum;\n}\n void main() {\n     vec2 resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n    if (processStage == 0)\n    {\n        if (heightFit == 1) {\n            float middleY = layoutCoord.y / (1.0 - layoutCoord.w);\n            if (vTextureCoord.y <= middleY) {\n                float ycoord = -(((vTextureCoord.y / middleY * layoutCoord.y) - layoutCoord.y) / layoutCoord.w);\n                resetCoord = vec2(vTextureCoord.x, ycoord);\n            } else {\n                float ycoord =\n                    2.0 - ((((vTextureCoord.y - middleY) / (1.0 - middleY) * (1.0 - layoutCoord.y - layoutCoord.w) +\n                            (layoutCoord.y + layoutCoord.w)) -\n                           layoutCoord.y) /\n                              layoutCoord.w);\n                resetCoord = vec2(vTextureCoord.x, ycoord);\n            }\n        } else {\n            resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n        }\n    }\n    vec4 oriColor = texture2D(sTexture, resetCoord);\n    gl_FragColor = gaussianBlurKernel(oriColor, resetCoord);\n }";
    }

    private void updateLayoutCoord(float f, float f2, int i, float f3, float[] fArr) {
        if (i == 0) {
            if (f >= f2) {
                float f4 = f2 / f;
                fArr[0] = 0.0f;
                fArr[1] = (1.0f - f4) * f3;
                fArr[2] = 1.0f;
                fArr[3] = f4;
                return;
            }
            float f5 = f / f2;
            fArr[0] = (1.0f - f5) * f3;
            fArr[1] = 0.0f;
            fArr[2] = f5;
            fArr[3] = 1.0f;
        }
    }

    private void cacluGauBlurTexSize(float f, float f2, int i) {
        if (i != 0 || f < f2) {
            return;
        }
        float f3 = this.mSurfaceHeight;
        int i2 = this.mSurfaceWidth;
        float f4 = f3 - (i2 * f2);
        if (f4 > i2) {
            int i3 = this.mGauBlurLongTexLength;
            this.mGaussianBlurTexHeight = i3;
            this.mGaussianBlurTexWidth = (int) (i3 * (i2 / f4));
        } else {
            int i4 = this.mGauBlurLongTexLength;
            this.mGaussianBlurTexWidth = i4;
            this.mGaussianBlurTexHeight = (int) (i4 * (f4 / i2));
        }
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    protected EffectTexture genTexture() {
        if (this.mGaussianBlurTexWidth == 0 || this.mGaussianBlurTexHeight == 0) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "gaussianBlur size invaild");
        }
        if (this.mProcessStage == 0) {
            EffectTexture effectTexture = this.mFirstGauBlurTexture;
            if (effectTexture == null || effectTexture.getWidth() != this.mGaussianBlurTexWidth || this.mFirstGauBlurTexture.getHeight() != this.mGaussianBlurTexHeight) {
                EffectTexture effectTexture2 = this.mFirstGauBlurTexture;
                if (effectTexture2 != null) {
                    _releaseEffectTex(effectTexture2);
                    this.mFirstGauBlurTexture = null;
                }
                if (this.mSurfaceTexture != null) {
                    this.mFirstGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight, this.mSurfaceTexture.getIntOption(130));
                } else {
                    this.mFirstGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight);
                }
            }
            return this.mFirstGauBlurTexture;
        }
        if (this.mProcessStage != 1) {
            return null;
        }
        EffectTexture effectTexture3 = this.mSecondGauBlurTexture;
        if (effectTexture3 == null || effectTexture3.getWidth() != this.mGaussianBlurTexWidth || this.mSecondGauBlurTexture.getHeight() != this.mGaussianBlurTexHeight) {
            EffectTexture effectTexture4 = this.mSecondGauBlurTexture;
            if (effectTexture4 != null) {
                _releaseEffectTex(effectTexture4);
                this.mSecondGauBlurTexture = null;
            }
            if (this.mSurfaceTexture != null) {
                this.mSecondGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight, this.mSurfaceTexture.getIntOption(130));
            } else {
                this.mSecondGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight);
            }
        }
        return this.mSecondGauBlurTexture;
    }

    private EffectTexture _genTexture(int i, int i2) {
        return _genTexture(i, i2, 6408, 6408, 5121);
    }

    private EffectTexture _genTexture(int i, int i2, int i3) {
        if (i3 >= 10 && Build.VERSION.SDK_INT >= 18) {
            return _genTexture(i, i2, 32857, 6408, 33640);
        }
        return _genTexture(i, i2);
    }

    private EffectTexture _genTexture(int i, int i2, int i3, int i4, int i5) {
        int iGenTexture = TexGLUtils.genTexture(3553);
        GLES20.glBindTexture(3553, iGenTexture);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i4, i5, null);
        EffectTexture effectTexture = new EffectTexture(null, iGenTexture, i, i2, 3553, i3, i4, i5);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "genTexture:" + effectTexture.toString());
        return effectTexture;
    }

    public EffectTexture getSecondGauBlurTexture() {
        return this.mSecondGauBlurTexture;
    }

    private void _releaseEffectTex(EffectTexture effectTexture) {
        if (effectTexture != null) {
            TexGLUtils.deleteTexture(effectTexture.getTexID());
            TextureRenderLog.i(this.mTexType, LOG_TAG, "onTextureReturn delTex:" + effectTexture);
        }
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        EffectTexture effectTexture = this.mFirstGauBlurTexture;
        if (effectTexture != null) {
            _releaseEffectTex(effectTexture);
            this.mFirstGauBlurTexture = null;
        }
        EffectTexture effectTexture2 = this.mSecondGauBlurTexture;
        if (effectTexture2 != null) {
            _releaseEffectTex(effectTexture2);
            this.mSecondGauBlurTexture = null;
        }
        return super.release();
    }
}
