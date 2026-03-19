package com.ss.texturerender.effect;

import android.os.Bundle;
import android.os.SystemClock;
import com.ss.texturerender.SharpenBaseWrapper;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdaptiveSharpenEffect extends AbsEffect {
    private static final String LOG_TAG = "TR_AdaptiveSharpenEffect";
    private float mAmount;
    private float[] mCm;
    private float[] mCo;
    private int mDiffImgSmoothEnable;
    private float mEdgeWeightGamma;
    private boolean mEnableBMF;
    private boolean mInitSharpenError;
    private int mMaxHeight;
    private int mMaxWidth;
    private float mOverRatio;
    private int mPowerLevel;
    private int mProcessSuccess;
    private float[] mSTMatrix;
    private int mSceneMode;
    private SharpenBaseWrapper mWrapper;

    public AdaptiveSharpenEffect(int i) {
        super(i, 1);
        this.mMaxWidth = 1920;
        this.mMaxHeight = 1080;
        this.mPowerLevel = 0;
        this.mSceneMode = 0;
        this.mAmount = -1.0f;
        this.mOverRatio = -1.0f;
        this.mEdgeWeightGamma = -1.0f;
        this.mDiffImgSmoothEnable = -1;
        this.mProcessSuccess = Integer.MIN_VALUE;
        this.mEnableBMF = false;
        this.mCm = new float[0];
        this.mCo = new float[0];
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new AdaptiveSharpenEffect");
        this.mOrder = 10;
        this.mIsSupportOes = 1;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        super.init(bundle);
        int i = 0;
        this.mEnableBMF = bundle.getInt(TextureRenderKeys.KEY_IS_ENABLE_BMF) == 1;
        int i2 = bundle.getInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE);
        if ((this.mPowerLevel != bundle.getInt(TextureRenderKeys.KEY_IS_POWER_LEVEL) || this.mInTextureTarget != i2) && this.mWrapper != null) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "release prev sharpen instance");
            this.mWrapper.ReleaseAdaptiveSharpen();
            this.mWrapper = null;
        }
        if (this.mWrapper == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!this.mEnableBMF) {
                this.mInTextureTarget = i2;
                if (this.mInTextureTarget == 36197 && this.mSTMatrix == null) {
                    this.mSTMatrix = new float[16];
                }
                this.mMaxWidth = bundle.getInt(TextureRenderKeys.KEY_IS_MAX_WIDTH);
                this.mMaxHeight = bundle.getInt(TextureRenderKeys.KEY_IS_MAX_HEIGHT);
                this.mPowerLevel = bundle.getInt(TextureRenderKeys.KEY_IS_POWER_LEVEL);
                AdaptiveSharpenWrapper adaptiveSharpenWrapper = new AdaptiveSharpenWrapper(this.mTexType);
                this.mWrapper = adaptiveSharpenWrapper;
                if (!adaptiveSharpenWrapper.InitAdaptiveSharpen(this.mInTextureTarget == 36197, this.mMaxWidth, this.mMaxHeight, this.mPowerLevel)) {
                    i = -1;
                }
            } else {
                this.mInTextureTarget = i2;
                TextureRenderLog.i(this.mTexType, LOG_TAG, "init sharpen mInTextureTarget: " + this.mInTextureTarget);
                if (this.mInTextureTarget == 36197 && this.mSTMatrix == null) {
                    this.mSTMatrix = new float[16];
                }
                this.mMaxWidth = bundle.getInt(TextureRenderKeys.KEY_IS_MAX_WIDTH);
                this.mMaxHeight = bundle.getInt(TextureRenderKeys.KEY_IS_MAX_HEIGHT);
                int i3 = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARPEN_ALG_TYPE);
                int i4 = bundle.getInt("pool_size");
                float f = bundle.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARPEN_WEIGHT_THRESHOLD);
                float f2 = bundle.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARPEN_GLOBAL_THRESHOLD);
                float f3 = bundle.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARPEN_OVERFLOW_RATIO);
                boolean z = bundle.getInt(TextureRenderKeys.KEY_IS_BMF_SHARPEN_ENABLE_ADAPTIVE) == 1;
                float f4 = bundle.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARPEN_INITIAL_WEIGHT);
                float f5 = bundle.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARPEN_LOW_WEIGHT_THRESHOLD);
                String string = bundle.getString(TextureRenderKeys.KEY_IS_BMF_SHARPEN_PROGRAME_CACHE_DIR, "");
                BMFAdaptiveSharpenWrapper bMFAdaptiveSharpenWrapper = new BMFAdaptiveSharpenWrapper(this.mTexType);
                this.mWrapper = bMFAdaptiveSharpenWrapper;
                int iInitAdaptiveSharpen = bMFAdaptiveSharpenWrapper.InitAdaptiveSharpen(i3, this.mMaxWidth, this.mMaxHeight, i4, string, f, f2, f3, z, f4, f5);
                TextureRenderLog.i(this.mTexType, LOG_TAG, "init sharpen, algType: " + i3);
                i = iInitAdaptiveSharpen;
            }
            TextureRenderLog.i(this.mTexType, LOG_TAG, "init sharpen, ret:" + i + ",cost:" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
        if (i != 0) {
            this.mInitSharpenError = true;
            this.mWrapper.ReleaseAdaptiveSharpen();
            this.mWrapper = null;
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(3, this.mEffectType, "init sharpen fail, release");
            }
            TextureRenderLog.i(this.mTexType, LOG_TAG, "init sharpen fail, release");
        }
        return i;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, int i2) {
        if (i == 14) {
            this.mDiffImgSmoothEnable = i2;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "set DiffImgSmoothEnable:" + i2);
        } else if (i == 17) {
            this.mSceneMode = i2;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "set SceneMode:" + i2);
        } else {
            super.setOption(i, i2);
        }
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, float f) {
        switch (i) {
            case 11:
                this.mAmount = f;
                break;
            case 12:
                this.mOverRatio = f;
                break;
            case 13:
                this.mEdgeWeightGamma = f;
                break;
            default:
                super.setOption(i, f);
                break;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setOption float, key:" + i + ",value:" + f);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int getIntOption(int i) {
        switch (i) {
            case 10001:
                return this.mMaxWidth;
            case 10002:
                return this.mMaxHeight;
            case 10003:
                return this.mPowerLevel;
            case 10004:
                return this.mInTextureTarget;
            default:
                return super.getIntOption(i);
        }
    }

    public boolean supportProcessResolution(int i, int i2) {
        if (this.mMaxWidth <= 0 || this.mMaxHeight <= 0) {
            return true;
        }
        int iMax = Math.max(i, i2);
        int iMin = Math.min(i, i2);
        int iMax2 = Math.max(this.mMaxWidth, this.mMaxHeight);
        int iMin2 = Math.min(this.mMaxWidth, this.mMaxHeight);
        if (iMax <= iMax2 && iMin <= iMin2) {
            return true;
        }
        TextureRenderLog.e(this.mTexType, LOG_TAG, "width/height out of range");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0129  */
    @Override // com.ss.texturerender.effect.AbsEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ss.texturerender.effect.EffectTexture process(com.ss.texturerender.effect.EffectTexture r20, com.ss.texturerender.effect.FrameBuffer r21) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.effect.AdaptiveSharpenEffect.process(com.ss.texturerender.effect.EffectTexture, com.ss.texturerender.effect.FrameBuffer):com.ss.texturerender.effect.EffectTexture");
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        SharpenBaseWrapper sharpenBaseWrapper = this.mWrapper;
        if (sharpenBaseWrapper != null) {
            sharpenBaseWrapper.ReleaseAdaptiveSharpen();
            this.mWrapper = null;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "sharpen released");
        }
        return super.release();
    }
}
