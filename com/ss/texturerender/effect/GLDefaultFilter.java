package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.sigmob.sdk.archives.tar.d;
import com.ss.texturerender.ShaderHelper;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLDefaultFilter extends AbsEffect {
    private static final String LOG_TAG = "TR_GLDefaultFilter";
    public static final int OPTION_FILTER_CALL_GLFINISH = 20006;
    public static final int OPTION_FILTER_INT_GL_ERROR = 20005;
    public static final int OPTION_FILTER_INT_PORT_HEIGHT = 20002;
    public static final int OPTION_FILTER_INT_PORT_WIDTH = 20001;
    public static final int OPTION_FILTER_INT_PORT_X = 20003;
    public static final int OPTION_FILTER_INT_PORT_Y = 20004;
    int FLOAT_SIZE_BYTES;
    protected int TEXTURE_VERTICES_DATA_STRIDE_BYTES;
    protected int TRIANGLE_VERTICES_DATA_POS_OFFSET;
    protected int TRIANGLE_VERTICES_DATA_STRIDE_BYTES;
    protected int TRIANGLE_VERTICES_DATA_UV_OFFSET;
    private final String fragmentDefaultShader;
    protected boolean isMirrorHorizontal;
    protected boolean isMirrorVertical;
    protected float mCropHeightNormalize;
    protected float[] mCropTextureCoord;
    protected float mCropWidthNormalize;
    protected float mCropXNormalize;
    protected float mCropYNormalize;
    protected int mGLError;
    protected ShortBuffer mIndexBuffers;
    protected int mInputTextureHandle;
    protected int mIsCallGLfinish;
    protected float mLayoutAspectRatio;
    protected int mLayoutMode;
    protected boolean mNeedClear;
    protected int mOutTexHeight;
    protected int mOutTexWidth;
    protected int mProgram;
    protected int mRotation;
    protected int mTextureMagFilter;
    protected int mTextureMinFilter;
    protected FloatBuffer mTextureVertices;
    protected FloatBuffer mTriangleVertices;
    protected int mViewPortHeight;
    protected int mViewPortWidth;
    protected int mViewPortX;
    protected int mViewPortY;
    protected int maPositionHandle;
    protected int maTextureHandle;
    private final String vertexDefaultShader;
    public static float[] mTriangleVerticesData = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    public static float[] mTextureVerticesData = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    public int onDrawFrameAfter() {
        return 0;
    }

    public int onDrawFrameBefore() {
        return 0;
    }

    public int updateRenderParam(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        return -1;
    }

    public GLDefaultFilter(int i) {
        this(i, 7);
    }

    public GLDefaultFilter(int i, int i2) {
        super(i, i2);
        this.vertexDefaultShader = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position =  aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
        this.fragmentDefaultShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 12;
        this.TEXTURE_VERTICES_DATA_STRIDE_BYTES = 8;
        this.TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        this.TRIANGLE_VERTICES_DATA_UV_OFFSET = 0;
        this.FLOAT_SIZE_BYTES = 4;
        this.mViewPortWidth = -1;
        this.mViewPortHeight = -1;
        this.mViewPortX = 0;
        this.mViewPortY = 0;
        this.mNeedClear = true;
        this.mLayoutMode = 1;
        this.mLayoutAspectRatio = 0.5f;
        this.mCropXNormalize = 0.0f;
        this.mCropYNormalize = 0.0f;
        this.mCropWidthNormalize = 1.0f;
        this.mCropHeightNormalize = 1.0f;
        this.mCropTextureCoord = null;
        this.mTextureMinFilter = 9729;
        this.mTextureMagFilter = 9729;
        this.mRotation = 0;
        this.isMirrorHorizontal = false;
        this.isMirrorVertical = false;
        this.mGLError = 0;
        this.mIsCallGLfinish = 1;
        this.mInTextureTarget = 3553;
        this.mOrder = 0;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        if (this.mSurfaceTexture != null && this.mSurfaceTexture.getIntOption(126, this.mEffectType) == -1) {
            this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
        }
        int iCompileShader = ShaderHelper.compileShader(35633, getStringOption(11000));
        int iCompileShader2 = ShaderHelper.compileShader(35632, getStringOption(11001));
        if (iCompileShader == 0 || iCompileShader2 == 0) {
            this.mGLError = -1;
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(8, this.mEffectType, "compile shader error");
            }
            return -1;
        }
        int iCreateAndLinkProgram = ShaderHelper.createAndLinkProgram(iCompileShader, iCompileShader2, null);
        this.mProgram = iCreateAndLinkProgram;
        if (iCreateAndLinkProgram == 0) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "create program error,filter:" + this.mEffectType);
            this.mGLError = -1;
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(9, this.mEffectType, "create program error");
            }
            return -1;
        }
        this.mInputTextureHandle = GLES20.glGetUniformLocation(iCreateAndLinkProgram, "sTexture");
        this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        initParam();
        this.mGLError = 0;
        return 0;
    }

    protected void initParam() {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVertices = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(mTextureVerticesData).position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(mTriangleVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(mTriangleVerticesData).position(0);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        return process(effectTexture, frameBuffer, true);
    }

    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer, Boolean bool) {
        if (this.mSurfaceTexture != null && this.mSurfaceTexture.getIntOption(126, this.mEffectType) == -1) {
            this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
        }
        if (effectTexture.getTexTarget() != this.mInTextureTarget) {
            TextureRenderLog.e(this.mTexType, getClass().getSimpleName(), "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + effectTexture.getTexTarget());
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + effectTexture.getTexTarget());
            }
            return effectTexture;
        }
        if (this.mProgram == 0) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
            }
            return effectTexture;
        }
        int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "filter process start,type:" + this.mEffectType);
        if (iCheckGLError != 0) {
            this.mGLError = -1;
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(iCheckGLError, this.mEffectType, "");
            }
            return effectTexture;
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        }
        if (updateRenderParam(effectTexture, frameBuffer) == -1) {
            updateDefaultRenderParam(effectTexture, frameBuffer);
        }
        EffectTexture effectTextureGenTexture = null;
        if (frameBuffer != null) {
            if (this.mOutTexWidth == 0 || this.mOutTexHeight == 0) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
                if (this.mSurfaceTexture != null) {
                    this.mSurfaceTexture.notifyError(14, this.mEffectType, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
                }
            }
            effectTextureGenTexture = genTexture();
            if (effectTextureGenTexture == null) {
                return effectTexture;
            }
            frameBuffer.bindTexture2D(effectTextureGenTexture.getTexID());
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
        GLES20.glTexParameteri(this.mInTextureTarget, 10241, this.mTextureMinFilter);
        GLES20.glTexParameteri(this.mInTextureTarget, d.b, this.mTextureMagFilter);
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        onDrawFrameBefore();
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
        onDrawFrameAfter();
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        if (this.mIsCallGLfinish == 1) {
            GLES20.glFinish();
        }
        if (frameBuffer != null) {
            frameBuffer.unbindTexture2D();
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        }
        int iCheckGLError3 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays after,type:" + this.mEffectType);
        if (this.mGLError == 0 && iCheckGLError3 == 0) {
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
            }
            if (bool.booleanValue()) {
                effectTexture.giveBack();
            }
            return effectTextureGenTexture;
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.notifyError(iCheckGLError3, this.mEffectType, "filter glDrawArrays after,type:" + this.mEffectType);
        }
        if (effectTextureGenTexture != null) {
            effectTextureGenTexture.giveBack();
        }
        this.mGLError = -1;
        return effectTexture;
    }

    protected EffectTexture genTexture() {
        if (this.mParentRender == null || this.mParentRender.getEffectTextureManager() == null) {
            return null;
        }
        if (this.mSurfaceTexture != null) {
            return this.mParentRender.getEffectTextureManager().genTexture(this.mOutTexWidth, this.mOutTexHeight, this.mSurfaceTexture.getIntOption(130));
        }
        return this.mParentRender.getEffectTextureManager().genTexture(this.mOutTexWidth, this.mOutTexHeight);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        int i = this.mProgram;
        if (i > 0) {
            GLES20.glDeleteProgram(i);
        }
        return super.release();
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, int i2) {
        boolean z;
        if (i == 26) {
            if (this.mLayoutMode != i2) {
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.mTextureVertices = floatBufferAsFloatBuffer;
                if (floatBufferAsFloatBuffer != null) {
                    floatBufferAsFloatBuffer.put(mTextureVerticesData).position(0);
                }
                this.mLayoutMode = i2;
                reTransformIfNeeded();
            }
            return;
        }
        if (i == 20006) {
            this.mIsCallGLfinish = i2;
            return;
        }
        if (i == 158) {
            this.mTextureMinFilter = i2;
            return;
        }
        if (i == 159) {
            this.mTextureMagFilter = i2;
            return;
        }
        switch (i) {
            case 29:
                if (this.mSurfaceTexture != null && this.mSurfaceTexture.getIntOption(144) == 1) {
                    if (this.mRotation != i2 || i2 != 0) {
                        this.mRotation = i2;
                        if (i2 != 0) {
                            if (this.isMirrorVertical || this.isMirrorHorizontal) {
                                rotate(this.mTextureVertices, i2);
                                break;
                            } else {
                                rotate(null, i2);
                                break;
                            }
                        } else {
                            resetRotationMirrorParams();
                            break;
                        }
                    }
                } else {
                    int i3 = this.mRotation;
                    if (i3 != i2) {
                        rotate(this.mTextureVertices, i2 - i3);
                        this.mRotation = i2;
                        break;
                    }
                }
                break;
            case 30:
                if (this.mSurfaceTexture != null && this.mSurfaceTexture.getIntOption(144) == 1) {
                    boolean z2 = this.isMirrorHorizontal;
                    if (z2 != (i2 > 0) || z2) {
                        z = i2 > 0;
                        this.isMirrorHorizontal = z;
                        if (z) {
                            mirror(30, null);
                            break;
                        } else {
                            resetRotationMirrorParams();
                            break;
                        }
                    }
                } else {
                    if (this.isMirrorHorizontal != (i2 > 0)) {
                        this.isMirrorHorizontal = i2 > 0;
                        mirror(30, this.mTextureVertices);
                        break;
                    }
                }
                break;
            case 31:
                if (this.mSurfaceTexture != null && this.mSurfaceTexture.getIntOption(144) == 1) {
                    boolean z3 = this.isMirrorVertical;
                    if (z3 != (i2 > 0) || z3) {
                        z = i2 > 0;
                        this.isMirrorVertical = z;
                        if (z) {
                            mirror(31, null);
                            break;
                        } else {
                            resetRotationMirrorParams();
                            break;
                        }
                    }
                } else {
                    if (this.isMirrorVertical != (i2 > 0)) {
                        this.isMirrorVertical = i2 > 0;
                        mirror(31, this.mTextureVertices);
                        break;
                    }
                }
                break;
            default:
                switch (i) {
                    case 10006:
                        this.mViewPortWidth = i2;
                        break;
                    case 10007:
                        this.mViewPortHeight = i2;
                        break;
                    case 10008:
                        this.mViewPortX = i2;
                        break;
                    case 10009:
                        this.mViewPortY = i2;
                        break;
                    case 10010:
                        this.mNeedClear = i2 == 1;
                        break;
                    default:
                        super.setOption(i, i2);
                        break;
                }
        }
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, float f) {
        if (i != 27) {
            return;
        }
        this.mLayoutAspectRatio = f;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, float[] fArr) {
        if (i != 13000) {
            super.setOption(i, fArr);
        } else if (fArr != null) {
            this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
            this.mTextureVertices.put(fArr);
        }
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        return i != 11000 ? i != 11001 ? super.getStringOption(i) : "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n" : "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position =  aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i = bundle.getInt("action", -1);
        if (bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE, -1) == 11) {
            if (i == 21 || i == 28 || i == 35) {
                float f = bundle.getFloat("width", 1.0f);
                float f2 = bundle.getFloat("height", 1.0f);
                float f3 = bundle.getFloat("x", 0.0f);
                float f4 = bundle.getFloat("y", 0.0f);
                if (f3 > 1.0f || f3 < 0.0f || f4 > 1.0f || f4 < 0.0f || f <= 0.0f || f2 <= 0.0f) {
                    return;
                }
                if (f4 == this.mCropYNormalize && f3 == this.mCropXNormalize && f == this.mCropWidthNormalize && f2 == this.mCropHeightNormalize) {
                    return;
                }
                this.mCropWidthNormalize = f;
                this.mCropHeightNormalize = f2;
                this.mCropXNormalize = f3;
                this.mCropYNormalize = f4;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                this.mCropXNormalize = f3;
                float f5 = f4 >= 0.0f ? f4 : 0.0f;
                this.mCropYNormalize = f5;
                if (f3 + f > 1.0f) {
                    f = 1.0f - f3;
                }
                this.mCropWidthNormalize = f;
                if (f5 + f2 > 1.0f) {
                    f2 = 1.0f - f5;
                }
                this.mCropHeightNormalize = f2;
                this.mCropTextureCoord = new float[]{f3, f5, f3 + f, f5, f3, f5 + f2, f3 + f, f5 + f2};
                TextureRenderLog.i(this.mTexType, LOG_TAG, "param set success, bundle:" + bundle);
            }
        }
    }

    public int updateDefaultRenderParam(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        int iRound = Math.round(effectTexture.getWidth() * this.mCropWidthNormalize);
        int iRound2 = Math.round(effectTexture.getHeight() * this.mCropHeightNormalize);
        if (frameBuffer != null) {
            this.mOutTexWidth = iRound;
            this.mOutTexHeight = iRound2;
            this.mViewPortWidth = iRound;
            this.mViewPortHeight = iRound2;
            this.mViewPortY = 0;
            this.mViewPortX = 0;
            setOption(AbsEffect.OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES, this.mCropTextureCoord);
        } else {
            int i = this.mViewPortWidth;
            int i2 = this.mViewPortHeight;
            float f = iRound2;
            float f2 = iRound;
            float f3 = (f * 1.0f) / f2;
            float f4 = i2 * 1.0f;
            float f5 = i;
            float f6 = f4 / f5;
            int i3 = this.mLayoutMode;
            if (i3 == 0) {
                if (f6 > f3) {
                    int i4 = this.mRotation;
                    if (i4 == 90 || i4 == 270) {
                        int iMin = Math.min((int) (f4 * f3), i);
                        this.mViewPortWidth = iMin;
                        this.mViewPortHeight = (int) ((iMin * 1.0f) / f3);
                        float f7 = i - iMin;
                        float f8 = this.mLayoutAspectRatio;
                        this.mViewPortX = (int) (f7 * f8);
                        this.mViewPortY = (int) ((i2 - r0) * f8);
                    } else {
                        this.mViewPortWidth = i;
                        this.mViewPortHeight = (int) (f5 * 1.0f * f3);
                        this.mViewPortX = 0;
                        this.mViewPortY = (int) ((i2 - r13) * this.mLayoutAspectRatio);
                    }
                } else {
                    int i5 = this.mRotation;
                    if (i5 == 90 || i5 == 270) {
                        int iMin2 = Math.min((int) ((f5 * 1.0f) / f3), i2);
                        this.mViewPortHeight = iMin2;
                        int i6 = (int) (iMin2 * 1.0f * f3);
                        this.mViewPortWidth = i6;
                        float f9 = i - i6;
                        float f10 = this.mLayoutAspectRatio;
                        this.mViewPortX = (int) (f9 * f10);
                        this.mViewPortY = (int) ((i2 - iMin2) * f10);
                    } else {
                        this.mViewPortWidth = (int) (f4 / f3);
                        this.mViewPortHeight = i2;
                        this.mViewPortX = (int) ((i - r13) * this.mLayoutAspectRatio);
                        this.mViewPortY = 0;
                    }
                }
                setOption(AbsEffect.OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES, this.mCropTextureCoord);
            } else if (i3 == 2) {
                this.mViewPortWidth = i;
                this.mViewPortHeight = i2;
                this.mViewPortY = 0;
                this.mViewPortX = 0;
                int i7 = this.mRotation;
                if (i7 == 90 || i7 == 270) {
                    float f11 = (f2 * 1.0f) / f;
                    if (f6 > f11) {
                        float f12 = 1.0f - (f11 / f6);
                        this.mTextureVertices.put(0, this.mCropXNormalize);
                        this.mTextureVertices.put(1, this.mCropYNormalize + (this.mCropHeightNormalize * f12 * this.mLayoutAspectRatio));
                        this.mTextureVertices.put(2, this.mCropXNormalize + this.mCropWidthNormalize);
                        this.mTextureVertices.put(5, this.mCropYNormalize + (this.mCropHeightNormalize * (1.0f - (f12 * (1.0f - this.mLayoutAspectRatio)))));
                    } else {
                        float f13 = 1.0f - (f6 / f11);
                        this.mTextureVertices.put(0, this.mCropXNormalize + (this.mCropWidthNormalize * f13 * this.mLayoutAspectRatio));
                        this.mTextureVertices.put(1, this.mCropYNormalize);
                        this.mTextureVertices.put(2, this.mCropXNormalize + (this.mCropWidthNormalize * (1.0f - (f13 * this.mLayoutAspectRatio))));
                        this.mTextureVertices.put(5, this.mCropYNormalize + this.mCropHeightNormalize);
                    }
                } else if (f6 > f3) {
                    float f14 = 1.0f - (f3 / f6);
                    this.mTextureVertices.put(0, this.mCropXNormalize + (this.mCropWidthNormalize * f14 * this.mLayoutAspectRatio));
                    this.mTextureVertices.put(1, this.mCropYNormalize);
                    this.mTextureVertices.put(2, this.mCropXNormalize + (this.mCropWidthNormalize * (1.0f - (f14 * (1.0f - this.mLayoutAspectRatio)))));
                    this.mTextureVertices.put(5, this.mCropYNormalize + this.mCropHeightNormalize);
                } else {
                    float f15 = 1.0f - (f6 / f3);
                    this.mTextureVertices.put(0, this.mCropXNormalize);
                    this.mTextureVertices.put(1, this.mCropYNormalize + (this.mCropHeightNormalize * f15 * this.mLayoutAspectRatio));
                    this.mTextureVertices.put(2, this.mCropXNormalize + this.mCropWidthNormalize);
                    this.mTextureVertices.put(5, this.mCropYNormalize + (this.mCropHeightNormalize * (1.0f - (f15 * (1.0f - this.mLayoutAspectRatio)))));
                }
                FloatBuffer floatBuffer = this.mTextureVertices;
                floatBuffer.put(3, floatBuffer.get(1));
                FloatBuffer floatBuffer2 = this.mTextureVertices;
                floatBuffer2.put(4, floatBuffer2.get(0));
                FloatBuffer floatBuffer3 = this.mTextureVertices;
                floatBuffer3.put(6, floatBuffer3.get(2));
                FloatBuffer floatBuffer4 = this.mTextureVertices;
                floatBuffer4.put(7, floatBuffer4.get(5));
                reTransformIfNeeded();
            } else {
                this.mViewPortWidth = i;
                this.mViewPortHeight = i2;
                this.mViewPortY = 0;
                this.mViewPortX = 0;
                setOption(AbsEffect.OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES, this.mCropTextureCoord);
            }
        }
        return 0;
    }

    private void reTransformIfNeeded() {
        int i;
        int i2;
        if (this.mSurfaceTexture != null && this.mSurfaceTexture.getIntOption(146) == 0 && (i2 = this.mRotation) != 0) {
            rotate(this.mTextureVertices, i2);
        }
        if (this.isMirrorHorizontal) {
            mirror(30, this.mTextureVertices);
        }
        if (this.isMirrorVertical) {
            mirror(31, this.mTextureVertices);
        }
        if (this.mSurfaceTexture == null || this.mSurfaceTexture.getIntOption(146) != 1 || (i = this.mRotation) == 0) {
            return;
        }
        rotate(this.mTextureVertices, i);
    }

    private void rotate(FloatBuffer floatBuffer, int i) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        if (floatBuffer != null) {
            floatBuffer.rewind();
            floatBufferAsFloatBuffer.put(floatBuffer);
            floatBuffer.rewind();
            floatBufferAsFloatBuffer.flip();
        } else {
            floatBufferAsFloatBuffer.put(mTextureVerticesData);
        }
        if (i < 0) {
            i += 360;
        }
        if (i == 90) {
            this.mTextureVertices.put(0, floatBufferAsFloatBuffer.get(2));
            this.mTextureVertices.put(1, floatBufferAsFloatBuffer.get(3));
            this.mTextureVertices.put(2, floatBufferAsFloatBuffer.get(6));
            this.mTextureVertices.put(3, floatBufferAsFloatBuffer.get(7));
            this.mTextureVertices.put(4, floatBufferAsFloatBuffer.get(0));
            this.mTextureVertices.put(5, floatBufferAsFloatBuffer.get(1));
            this.mTextureVertices.put(6, floatBufferAsFloatBuffer.get(4));
            this.mTextureVertices.put(7, floatBufferAsFloatBuffer.get(5));
        } else if (i == 180) {
            this.mTextureVertices.put(0, floatBufferAsFloatBuffer.get(6));
            this.mTextureVertices.put(1, floatBufferAsFloatBuffer.get(7));
            this.mTextureVertices.put(2, floatBufferAsFloatBuffer.get(4));
            this.mTextureVertices.put(3, floatBufferAsFloatBuffer.get(5));
            this.mTextureVertices.put(4, floatBufferAsFloatBuffer.get(2));
            this.mTextureVertices.put(5, floatBufferAsFloatBuffer.get(3));
            this.mTextureVertices.put(6, floatBufferAsFloatBuffer.get(0));
            this.mTextureVertices.put(7, floatBufferAsFloatBuffer.get(1));
        } else if (i == 270) {
            this.mTextureVertices.put(0, floatBufferAsFloatBuffer.get(4));
            this.mTextureVertices.put(1, floatBufferAsFloatBuffer.get(5));
            this.mTextureVertices.put(2, floatBufferAsFloatBuffer.get(0));
            this.mTextureVertices.put(3, floatBufferAsFloatBuffer.get(1));
            this.mTextureVertices.put(4, floatBufferAsFloatBuffer.get(6));
            this.mTextureVertices.put(5, floatBufferAsFloatBuffer.get(7));
            this.mTextureVertices.put(6, floatBufferAsFloatBuffer.get(2));
            this.mTextureVertices.put(7, floatBufferAsFloatBuffer.get(3));
        } else {
            this.mTextureVertices.put(floatBufferAsFloatBuffer).position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        }
        floatBufferAsFloatBuffer.clear();
    }

    private void mirror(int i, FloatBuffer floatBuffer) {
        if (this.mTextureVertices == null) {
            return;
        }
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        if (floatBuffer != null) {
            floatBuffer.rewind();
            floatBufferAsFloatBuffer.put(floatBuffer);
            floatBuffer.rewind();
            floatBufferAsFloatBuffer.flip();
        } else {
            floatBufferAsFloatBuffer.put(mTextureVerticesData);
        }
        if (i == 30) {
            this.mTextureVertices.put(0, floatBufferAsFloatBuffer.get(2));
            this.mTextureVertices.put(1, floatBufferAsFloatBuffer.get(3));
            this.mTextureVertices.put(2, floatBufferAsFloatBuffer.get(0));
            this.mTextureVertices.put(3, floatBufferAsFloatBuffer.get(1));
            this.mTextureVertices.put(4, floatBufferAsFloatBuffer.get(6));
            this.mTextureVertices.put(5, floatBufferAsFloatBuffer.get(7));
            this.mTextureVertices.put(6, floatBufferAsFloatBuffer.get(4));
            this.mTextureVertices.put(7, floatBufferAsFloatBuffer.get(5));
        } else if (i == 31) {
            this.mTextureVertices.put(0, floatBufferAsFloatBuffer.get(4));
            this.mTextureVertices.put(1, floatBufferAsFloatBuffer.get(5));
            this.mTextureVertices.put(2, floatBufferAsFloatBuffer.get(6));
            this.mTextureVertices.put(3, floatBufferAsFloatBuffer.get(7));
            this.mTextureVertices.put(4, floatBufferAsFloatBuffer.get(0));
            this.mTextureVertices.put(5, floatBufferAsFloatBuffer.get(1));
            this.mTextureVertices.put(6, floatBufferAsFloatBuffer.get(2));
            this.mTextureVertices.put(7, floatBufferAsFloatBuffer.get(3));
        } else {
            this.mTextureVertices.put(floatBufferAsFloatBuffer).position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        }
        floatBufferAsFloatBuffer.clear();
    }

    public void resetCropParams() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 21);
        bundle.putInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE, 11);
        bundle.putFloat("width", 1.0f);
        bundle.putFloat("height", 1.0f);
        bundle.putFloat("x", 0.0f);
        bundle.putFloat("y", 0.0f);
        setOption(bundle);
    }

    public void resetRotationMirrorParams() {
        FloatBuffer floatBuffer = this.mTextureVertices;
        if (floatBuffer != null) {
            floatBuffer.position(0);
            this.mTextureVertices.put(mTextureVerticesData).position(0);
        }
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int getIntOption(int i) {
        switch (i) {
            case 20001:
                return this.mViewPortWidth;
            case 20002:
                return this.mViewPortHeight;
            case 20003:
                return this.mViewPortX;
            case 20004:
                return this.mViewPortY;
            case 20005:
                return this.mGLError;
            default:
                return super.getIntOption(i);
        }
    }
}
