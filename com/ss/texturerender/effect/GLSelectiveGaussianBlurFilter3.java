package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLSelectiveGaussianBlurFilter3 extends AbsEffect {
    private static final String LOG_TAG = "TR_GLSelectiveGaussianBlurFilter3";
    private GLSelectiveGaussianBlurFilter m2DFilter;
    private GLSelectiveGaussianBlurFilterOpt m2DFilterOpt;
    private int mCount;
    private boolean mDisableOpt;
    private GLSelectiveGaussianBlurFilterOptMerge mGLSelectiveGaussianBlurFilterOptMerge;
    private int mGauBlurControlNum;
    private boolean mGauBlurHaveSucessful;
    private GLSelectiveGaussianBlurFilter mOesFilter;
    protected int mProcessStage;
    private int mRenderPasses;
    private int mRepeatType;
    protected float mSigma;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;

    public GLSelectiveGaussianBlurFilter3(int i) {
        super(i, 15);
        this.mDisableOpt = false;
        this.m2DFilterOpt = null;
        this.mGLSelectiveGaussianBlurFilterOptMerge = null;
        this.mOesFilter = null;
        this.m2DFilter = null;
        this.mRenderPasses = 2;
        this.mRepeatType = 2;
        this.mSigma = 2.0f;
        this.mProcessStage = 0;
        this.mSurfaceHeight = -1;
        this.mSurfaceWidth = -1;
        this.mEffectType = 15;
        this.mOrder = 4;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new,this:" + toString());
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        super.init(bundle);
        this.mSigma = bundle.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, -1.0f);
        int i = bundle.getInt(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE, 2);
        this.mRepeatType = i;
        this.mRenderPasses = (this.mSigma <= 1.0f || i == 3) ? 1 : 2;
        boolean z = bundle.getBoolean(TextureRenderKeys.KEY_IS_SELSCT_GAUSSBLUR_DISABLE_OPT, false);
        this.mDisableOpt = z;
        int i2 = 3553;
        if (z) {
            this.mIsSupportOes = 1;
            int i3 = bundle.getInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE);
            GLSelectiveGaussianBlurFilter gLSelectiveGaussianBlurFilter = this.mOesFilter;
            if (gLSelectiveGaussianBlurFilter != null) {
                gLSelectiveGaussianBlurFilter.release();
                this.mOesFilter = null;
            }
            if (i3 == 36197) {
                this.mOesFilter = new GLSelectiveGaussianBlurFilter(this.mTexType);
                if (Build.VERSION.SDK_INT >= 15) {
                    bundle.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 36197);
                }
                this.mOesFilter.init(bundle);
                this.mOesFilter.setParentRender(this.mParentRender);
                this.mOesFilter.mEnableSecondPass = false;
                this.mOesFilter.setOption(20006, 0);
            }
            GLSelectiveGaussianBlurFilter gLSelectiveGaussianBlurFilter2 = this.m2DFilter;
            if (gLSelectiveGaussianBlurFilter2 != null) {
                gLSelectiveGaussianBlurFilter2.release();
            }
            this.m2DFilter = new GLSelectiveGaussianBlurFilter(this.mTexType);
            bundle.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 3553);
            this.m2DFilter.init(bundle);
            this.m2DFilter.mEnableSecondPass = false;
            this.m2DFilter.setParentRender(this.mParentRender);
            this.m2DFilter.setOption(20006, 0);
            i2 = i3;
        } else {
            GLSelectiveGaussianBlurFilterOpt gLSelectiveGaussianBlurFilterOpt = this.m2DFilterOpt;
            if (gLSelectiveGaussianBlurFilterOpt != null) {
                gLSelectiveGaussianBlurFilterOpt.release();
            }
            this.m2DFilterOpt = new GLSelectiveGaussianBlurFilterOpt(this.mTexType);
            bundle.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 3553);
            this.m2DFilterOpt.init(bundle);
            this.m2DFilterOpt.mEnableSecondPass = false;
            this.m2DFilterOpt.setParentRender(this.mParentRender);
            this.m2DFilterOpt.setOption(20006, 0);
            GLSelectiveGaussianBlurFilterOptMerge gLSelectiveGaussianBlurFilterOptMerge = this.mGLSelectiveGaussianBlurFilterOptMerge;
            if (gLSelectiveGaussianBlurFilterOptMerge != null) {
                gLSelectiveGaussianBlurFilterOptMerge.release();
                this.mGLSelectiveGaussianBlurFilterOptMerge = null;
            }
            GLSelectiveGaussianBlurFilterOptMerge gLSelectiveGaussianBlurFilterOptMerge2 = new GLSelectiveGaussianBlurFilterOptMerge(this.mTexType);
            this.mGLSelectiveGaussianBlurFilterOptMerge = gLSelectiveGaussianBlurFilterOptMerge2;
            gLSelectiveGaussianBlurFilterOptMerge2.setParentRender(this.mParentRender);
            this.mGLSelectiveGaussianBlurFilterOptMerge.init(bundle);
            this.mGauBlurHaveSucessful = false;
            this.mGauBlurControlNum = bundle.getInt(TextureRenderKeys.KEY_IS_SELECT_GAUSSBLUR_CONTROL_NUM, 2);
            this.mCount = 0;
        }
        this.mInTextureTarget = i2;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "init,texFormat:" + this.mInTextureTarget);
        return 0;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        EffectTexture effectTextureProcess;
        GLSelectiveGaussianBlurFilterOpt gLSelectiveGaussianBlurFilterOpt;
        EffectTexture effectTextureProcess2;
        boolean z;
        float[] fArr;
        float width = effectTexture.getWidth();
        float height = effectTexture.getHeight();
        int viewportWidth = this.mSurfaceTexture.getViewportWidth();
        int viewportHeight = this.mSurfaceTexture.getViewportHeight();
        float f = (viewportHeight * 1.0f) / viewportWidth;
        float f2 = (height * 1.0f) / width;
        if ((!this.mDisableOpt && f < f2) || Math.abs(f - f2) < 1.0E-9d) {
            return effectTexture;
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        }
        boolean z2 = false;
        if (viewportHeight != this.mSurfaceHeight || viewportWidth != this.mSurfaceWidth) {
            this.mSurfaceHeight = viewportHeight;
            this.mSurfaceWidth = viewportWidth;
            this.mCount = 0;
        }
        if (this.mDisableOpt) {
            this.mProcessStage = 0;
            GLSelectiveGaussianBlurFilter gLSelectiveGaussianBlurFilter = this.mOesFilter;
            if (gLSelectiveGaussianBlurFilter != null) {
                gLSelectiveGaussianBlurFilter.setSurfaceTexture(this.mSurfaceTexture);
                this.mOesFilter.mProcessStage = this.mProcessStage;
                effectTextureProcess = this.mOesFilter.process(effectTexture, getFrameBuffer(this.mProcessStage, frameBuffer));
                this.mProcessStage++;
                fArr = this.mOesFilter.mLayoutCoord;
            } else {
                effectTextureProcess = null;
                fArr = null;
            }
            if (effectTextureProcess == null) {
                effectTextureProcess = effectTexture;
            }
            if (this.m2DFilter != null) {
                while (this.mProcessStage < this.mRenderPasses) {
                    this.m2DFilter.setSurfaceTexture(this.mSurfaceTexture);
                    this.m2DFilter.mProcessStage = this.mProcessStage;
                    if (fArr != null) {
                        this.m2DFilter.mLayoutCoord = fArr;
                    }
                    effectTextureProcess = this.m2DFilter.process(effectTextureProcess, getFrameBuffer(this.mProcessStage, frameBuffer));
                    this.mProcessStage++;
                    fArr = this.m2DFilter.mLayoutCoord;
                    if (effectTextureProcess == null) {
                        effectTextureProcess = effectTexture;
                    }
                }
            }
        } else {
            if (this.mCount % this.mGauBlurControlNum == 0) {
                this.mProcessStage = 0;
                if (this.m2DFilterOpt != null) {
                    EffectTexture effectTexture2 = effectTexture;
                    float[] fArr2 = null;
                    while (true) {
                        if (this.mProcessStage >= this.mRenderPasses) {
                            z = false;
                            break;
                        }
                        this.m2DFilterOpt.setSurfaceTexture(this.mSurfaceTexture);
                        this.m2DFilterOpt.mProcessStage = this.mProcessStage;
                        if (fArr2 != null) {
                            this.m2DFilterOpt.mLayoutCoord = fArr2;
                        }
                        EffectTexture effectTextureProcess3 = this.m2DFilterOpt.process(effectTexture2, getFrameBuffer(this.mProcessStage, frameBuffer));
                        this.mProcessStage++;
                        float[] fArr3 = this.m2DFilterOpt.mLayoutCoord;
                        if (effectTextureProcess3 == null) {
                            effectTextureProcess3 = effectTexture;
                        }
                        if (effectTextureProcess3 == effectTexture) {
                            z = true;
                            break;
                        }
                        effectTexture2 = effectTextureProcess3;
                        fArr2 = fArr3;
                    }
                    if (z) {
                        this.mGauBlurHaveSucessful = false;
                    } else {
                        this.mGauBlurHaveSucessful = true;
                    }
                }
            }
            if (this.mGLSelectiveGaussianBlurFilterOptMerge == null || (gLSelectiveGaussianBlurFilterOpt = this.m2DFilterOpt) == null || gLSelectiveGaussianBlurFilterOpt.getSecondGauBlurTexture() == null || !this.mGauBlurHaveSucessful) {
                effectTextureProcess = effectTexture;
            } else {
                this.mGLSelectiveGaussianBlurFilterOptMerge.setSurfaceTexture(this.mSurfaceTexture);
                this.mGLSelectiveGaussianBlurFilterOptMerge.setGaussianBlurTexture(this.m2DFilterOpt.getSecondGauBlurTexture());
                this.mGLSelectiveGaussianBlurFilterOptMerge.setLayoutCoord(this.m2DFilterOpt.mLayoutCoord);
                this.mGLSelectiveGaussianBlurFilterOptMerge.mHeightFit = this.m2DFilterOpt.mHeightFit;
                this.mGLSelectiveGaussianBlurFilterOptMerge.updateSurfaceViewPortSize(this.m2DFilterOpt.mSurfaceWidth, this.m2DFilterOpt.mSurfaceHeight);
                if (this.mRenderToScreen) {
                    effectTextureProcess2 = this.mGLSelectiveGaussianBlurFilterOptMerge.process(effectTexture, null);
                } else {
                    effectTextureProcess2 = this.mGLSelectiveGaussianBlurFilterOptMerge.process(effectTexture, frameBuffer);
                }
                effectTextureProcess = effectTextureProcess2;
                z2 = true;
            }
        }
        this.mCount++;
        GLES20.glFinish();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        }
        if (effectTextureProcess != null) {
            effectTexture = effectTextureProcess;
        } else if (!this.mRenderToScreen) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "gauopt ret effectTexture is null");
        }
        if ((this.mDisableOpt || z2) && this.mRenderToScreen) {
            return null;
        }
        return effectTexture;
    }

    private FrameBuffer getFrameBuffer(int i, FrameBuffer frameBuffer) {
        if (this.mDisableOpt && i >= this.mRenderPasses - 1 && this.mRenderToScreen) {
            return null;
        }
        return frameBuffer;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        GLSelectiveGaussianBlurFilter gLSelectiveGaussianBlurFilter = this.mOesFilter;
        if (gLSelectiveGaussianBlurFilter != null) {
            gLSelectiveGaussianBlurFilter.release();
            this.mOesFilter = null;
        }
        GLSelectiveGaussianBlurFilter gLSelectiveGaussianBlurFilter2 = this.m2DFilter;
        if (gLSelectiveGaussianBlurFilter2 != null) {
            gLSelectiveGaussianBlurFilter2.release();
            this.m2DFilter = null;
        }
        GLSelectiveGaussianBlurFilterOpt gLSelectiveGaussianBlurFilterOpt = this.m2DFilterOpt;
        if (gLSelectiveGaussianBlurFilterOpt != null) {
            gLSelectiveGaussianBlurFilterOpt.release();
            this.m2DFilterOpt = null;
        }
        GLSelectiveGaussianBlurFilterOptMerge gLSelectiveGaussianBlurFilterOptMerge = this.mGLSelectiveGaussianBlurFilterOptMerge;
        if (gLSelectiveGaussianBlurFilterOptMerge != null) {
            gLSelectiveGaussianBlurFilterOptMerge.release();
            this.mGLSelectiveGaussianBlurFilterOptMerge = null;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "release,this:" + this);
        return super.release();
    }
}
