package com.ss.texturerender.effect;

import android.os.Bundle;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoOCLSRBaseWrapper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoOCLSREffect extends AbsEffect {
    private static final String LOG_TAG = "TR_VideoOCLSREffect";
    private boolean mAsyncInit;
    private int mBackend;
    private boolean mEnableBmf;
    private boolean mIsMaliSync;
    private String mLibPath;
    private int mMaxHeight;
    private int mMaxWidth;
    private VideoOCLSRBaseWrapper mOclSr;
    private int mPoolSize;
    private float mProcessAverageCostTime;
    private int mProcessSuccess;
    private float mProcessSuccessFrame;
    private float mProcessSumCostTime;
    private float mProcessSumFrame;
    private float[] mSTMatrix;
    private int mScaleType;
    private Bundle mSrProParamter;
    private int mSuperAlgType;
    private boolean useGLSr;

    public VideoOCLSREffect(int i) {
        super(i, 5);
        this.mSuperAlgType = -1;
        this.mIsMaliSync = true;
        this.mProcessSuccess = Integer.MIN_VALUE;
        this.mEnableBmf = false;
        this.useGLSr = false;
        this.mBackend = 0;
        this.mScaleType = 0;
        this.mPoolSize = 0;
        this.mLibPath = "";
        this.mProcessAverageCostTime = 0.0f;
        this.mProcessSumCostTime = 0.0f;
        this.mProcessSumFrame = 0.0f;
        this.mProcessSuccessFrame = 0.0f;
        this.mSrProParamter = null;
        this.mAsyncInit = false;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new VideoOCLSREffect");
        if (DeviceManager.isVRDevice()) {
            this.useGLSr = true;
        }
        this.mOrder = 5;
        this.mIsSupportOes = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x035d  */
    @Override // com.ss.texturerender.effect.AbsEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int init(android.os.Bundle r29) {
        /*
            Method dump skipped, instructions count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.effect.VideoOCLSREffect.init(android.os.Bundle):int");
    }

    public boolean supportProcessResolution(int i, int i2) {
        if (this.mSurfaceTexture == null) {
            return false;
        }
        if (this.mMaxWidth > 0 && this.mMaxHeight > 0) {
            int iMax = Math.max(i, i2);
            int iMin = Math.min(i, i2);
            int iMax2 = Math.max(this.mMaxWidth, this.mMaxHeight);
            int iMin2 = Math.min(this.mMaxWidth, this.mMaxHeight);
            if (iMax > iMax2 || iMin > iMin2) {
                TextureRenderLog.e(this.mTexType, LOG_TAG, "width/height out of range");
                return false;
            }
        }
        return this.mSurfaceTexture.supportProcessResolution(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0250  */
    @Override // com.ss.texturerender.effect.AbsEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ss.texturerender.effect.EffectTexture process(com.ss.texturerender.effect.EffectTexture r28, com.ss.texturerender.effect.FrameBuffer r29) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.effect.VideoOCLSREffect.process(com.ss.texturerender.effect.EffectTexture, com.ss.texturerender.effect.FrameBuffer):com.ss.texturerender.effect.EffectTexture");
    }

    private EffectTexture originTex(EffectTexture effectTexture) {
        this.mSurfaceTexture.setOption(6, 0);
        return effectTexture;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        if (this.mOclSr != null) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "release video sr");
            this.mOclSr.ReleaseVideoOclSr();
            this.mOclSr = null;
        }
        return super.release();
    }
}
