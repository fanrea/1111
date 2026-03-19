package com.ss.texturerender.effect;

import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.base.EGLExt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HardwareBuffer2GLFilter extends AbsEffect {
    private static final String LOG_TAG = "TR_HardwareBuffer2GLFilter";
    private EGLDisplay mDisplay;
    private EffectTexture mEffectTexture;
    private int mTexID;

    public HardwareBuffer2GLFilter(int i, EGLDisplay eGLDisplay) {
        super(i, 23);
        this.mDisplay = eGLDisplay;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        if (effectTexture == null || effectTexture.getSourceType() == 1) {
            return effectTexture;
        }
        if (this.mTexID == 0) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i = iArr[0];
            this.mTexID = i;
            if (i == 0) {
                return effectTexture;
            }
        }
        int iBindHardwareBufferToTexture = EGLExt.bindHardwareBufferToTexture(this.mDisplay, effectTexture.getHardwareBuffer(), this.mTexID, 36197);
        if (iBindHardwareBufferToTexture != 0) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "bindHardwareBufferToTexture fail,ret:" + iBindHardwareBufferToTexture);
            return effectTexture;
        }
        EffectTexture effectTexture2 = this.mEffectTexture;
        if (effectTexture2 == null || effectTexture2.getWidth() != effectTexture.getWidth() || this.mEffectTexture.getHeight() != effectTexture.getHeight() || this.mEffectTexture.getTexTarget() != 36197) {
            this.mEffectTexture = new EffectTexture(null, this.mTexID, effectTexture.getWidth(), effectTexture.getHeight(), 36197, effectTexture.getInternalFormat(), effectTexture.getFormat(), effectTexture.getType());
        }
        return this.mEffectTexture;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        TexGLUtils.deleteTexture(this.mTexID);
        this.mTexID = 0;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "release,this:" + this);
        return super.release();
    }
}
