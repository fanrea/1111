package com.ss.texturerender.effect;

import android.os.Bundle;
import com.ss.texturerender.AdaptiveGradingWrapper;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdaptiveGradingEffect extends AbsEffect {
    private static final int PROCESS_NEED_BMF_COMPUTE = -2;
    private static final int PROCESS_NO_NEED_PROCESS = -1;
    private AdaptiveGradingWrapper mAdaptiveGradingWrappers;
    private float mDstBrightness;
    private float mDstContrast;
    private float mDstSaturation;
    private long mGopTimeMs;
    private boolean mIsNewFrame;
    private int mMaxHeight;
    private int mMaxWidth;
    private float mSrcBrightness;
    private float mSrcContrast;
    private float mSrcSaturation;
    private float[] mStMatrix;
    private long mStartPlayTime;

    public AdaptiveGradingEffect(int i) {
        super(i, 14);
        this.mGopTimeMs = 2000L;
        this.mStartPlayTime = 0L;
        this.mOrder = 6;
        this.mAdaptiveGradingWrappers = new AdaptiveGradingWrapper(i);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        String str;
        float[] floatArray;
        int iInit = super.init(bundle);
        if (iInit < 0) {
            return iInit;
        }
        float[] floatArray2 = new float[2];
        float[] floatArray3 = new float[2];
        float[] fArr = new float[2];
        if (bundle != null) {
            this.mMaxWidth = bundle.getInt(TextureRenderKeys.KEY_IS_MAX_WIDTH);
            this.mMaxHeight = bundle.getInt(TextureRenderKeys.KEY_IS_MAX_HEIGHT);
            String string = bundle.getString(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_CACHE_FILE);
            this.mGopTimeMs = bundle.getLong(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_GOP_TIME_MS);
            floatArray2 = bundle.getFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_BRIGHTNESS_THRESHOLD);
            floatArray3 = bundle.getFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_CONTRAST_THRESHOLD);
            floatArray = bundle.getFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SATURATION_THRESHOLD);
            str = string;
        } else {
            str = "";
            floatArray = fArr;
        }
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading width=" + this.mMaxWidth + "::height=" + this.mMaxHeight);
        return this.mAdaptiveGradingWrappers.init(this.mMaxWidth, this.mMaxHeight, str, floatArray2, floatArray3, floatArray) ? 0 : -1;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle bundle) {
        super.setOption(bundle);
        if (bundle == null) {
            return;
        }
        try {
            this.mDstBrightness = getBundleValue(bundle, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_BRIGHTNESS, this.mDstBrightness);
            this.mDstContrast = getBundleValue(bundle, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_CONTRAST, this.mDstContrast);
            this.mDstSaturation = getBundleValue(bundle, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_SATURATION, this.mDstSaturation);
            this.mSrcSaturation = getBundleValue(bundle, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_SATURATION, this.mSrcSaturation);
            this.mSrcContrast = getBundleValue(bundle, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_CONTRAST, this.mSrcContrast);
            this.mSrcBrightness = getBundleValue(bundle, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_BRIGHTNESS, this.mSrcBrightness);
            boolean z = bundle.getBoolean(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_IS_NEW_FRAME);
            this.mIsNewFrame = z;
            if (z) {
                this.mStartPlayTime = 0L;
                this.mSrcBrightness = 0.0f;
                this.mSrcContrast = 0.0f;
                this.mSrcSaturation = 0.0f;
            }
        } catch (Exception e) {
            TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading ex=" + e.toString());
        }
    }

    private float getBundleValue(Bundle bundle, String str, float f) {
        float f2 = bundle.getFloat(str);
        return f2 == 0.0f ? f : f2;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        EffectTexture effectTexture2;
        if (this.mSurfaceTexture == null || this.mAdaptiveGradingWrappers == null || effectTexture == null) {
            TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "process mAdaptiveGradingWrappers null");
            return effectTexture;
        }
        float f = this.mSrcBrightness;
        if (f == -1.0f && this.mSrcContrast == -1.0f && this.mSrcSaturation == -1.0f) {
            TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "process no need");
            return effectTexture;
        }
        if (f == 0.0f && this.mSrcContrast == 0.0f && this.mSrcSaturation == 0.0f) {
            if (System.currentTimeMillis() - this.mStartPlayTime <= this.mGopTimeMs) {
                return effectTexture;
            }
            this.mSrcBrightness = -2.0f;
            this.mSrcContrast = -2.0f;
            this.mSrcSaturation = -2.0f;
        }
        if (effectTexture.getTexTarget() == 36197) {
            if (this.mStMatrix == null) {
                this.mStMatrix = new float[16];
            }
            this.mSurfaceTexture.getTransformMatrix(this.mStMatrix);
            int iProcessOES = this.mAdaptiveGradingWrappers.processOES(effectTexture.getTexID(), effectTexture.getWidth(), effectTexture.getHeight(), this.mStMatrix, this.mSrcBrightness, this.mDstBrightness, this.mSrcContrast, this.mDstContrast, this.mSrcSaturation, this.mDstSaturation, this.mIsNewFrame);
            effectTexture2 = new EffectTexture((EffectTextureManager) null, iProcessOES, effectTexture.getWidth(), effectTexture.getHeight(), iProcessOES == effectTexture.getTexID() ? effectTexture.getTexTarget() : 3553);
        } else {
            effectTexture2 = new EffectTexture((EffectTextureManager) null, this.mAdaptiveGradingWrappers.process(effectTexture.getTexID(), effectTexture.getWidth(), effectTexture.getHeight(), this.mSrcBrightness, this.mDstBrightness, this.mSrcContrast, this.mDstContrast, this.mSrcSaturation, this.mDstSaturation, this.mIsNewFrame), effectTexture.getWidth(), effectTexture.getHeight(), 3553);
            effectTexture.giveBack();
        }
        if (this.mIsNewFrame) {
            this.mStartPlayTime = System.currentTimeMillis();
            this.mIsNewFrame = false;
        }
        return effectTexture2;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        this.mAdaptiveGradingWrappers.free();
        this.mAdaptiveGradingWrappers = null;
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "release");
        return super.release();
    }
}
