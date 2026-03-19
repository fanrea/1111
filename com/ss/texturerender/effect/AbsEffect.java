package com.ss.texturerender.effect;

import android.os.Bundle;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurfaceTexture;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbsEffect {
    public static final int MAX_ORDER = 100;
    public static final int OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES = 13000;
    public static final int OPTION_EFFECT_FLOAT_SRCROPSIZEU = 14000;
    public static final int OPTION_EFFECT_FLOAT_SRCROPSIZEV = 14001;
    public static final int OPTION_EFFECT_INT_MAX_HEIGHT = 10002;
    public static final int OPTION_EFFECT_INT_MAX_WIDTH = 10001;
    public static final int OPTION_EFFECT_INT_NEED_CLEAR_BEFORE_DRAW = 10010;
    public static final int OPTION_EFFECT_INT_ORDER = 10011;
    public static final int OPTION_EFFECT_INT_POWER_LEVEL = 10003;
    public static final int OPTION_EFFECT_INT_RENDER_TO_SCREEN = 10015;
    public static final int OPTION_EFFECT_INT_SUPPORT_OES = 10014;
    public static final int OPTION_EFFECT_INT_TEXTURE_TARGET_IN = 10004;
    public static final int OPTION_EFFECT_INT_TYPE = 10005;
    public static final int OPTION_EFFECT_INT_VIEWPORT_HEIGHT = 10007;
    public static final int OPTION_EFFECT_INT_VIEWPORT_WIDTH = 10006;
    public static final int OPTION_EFFECT_INT_VIEWPORT_X = 10008;
    public static final int OPTION_EFFECT_INT_VIEWPORT_Y = 10009;
    public static final int OPTION_EFFECT_INT_VR_MODE = 10012;
    public static final int OPTION_EFFECT_STR_FRAGMENT_SHADER = 11001;
    public static final int OPTION_EFFECT_STR_VERTEX_SHADER = 11000;
    protected Bundle mBundle;
    protected int mEffectType;
    protected int mInTextureTarget;
    protected AbsEffect mNext;
    protected int mOrder;
    protected TextureRenderer mParentRender;
    protected AbsEffect mPrevious;
    public VideoSurfaceTexture mSurfaceTexture;
    protected int mTexType;
    protected int mIsSupportOes = 0;
    protected boolean mRenderToScreen = false;

    public float getFloatOption(int i) {
        return 0.0f;
    }

    public Object getOption(Bundle bundle) {
        return null;
    }

    public String getStringOption(int i) {
        return "";
    }

    public abstract EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer);

    public EffectTexture[] processWithMRT(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        return null;
    }

    public AbsEffect(int i, int i2) {
        this.mEffectType = i2;
        this.mTexType = i;
    }

    public int effectType() {
        return this.mEffectType;
    }

    public int texType() {
        return this.mTexType;
    }

    public int init(Bundle bundle) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null && videoSurfaceTexture.getIntOption(126, this.mEffectType) == -1) {
            this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
            this.mSurfaceTexture.setOption(127, this.mEffectType, "");
        }
        this.mBundle = bundle;
        return 0;
    }

    public void insertEffect(AbsEffect absEffect) {
        int i = absEffect.mOrder;
        if (i <= this.mOrder) {
            AbsEffect absEffect2 = this.mNext;
            if (absEffect2 == null) {
                this.mNext = absEffect;
                absEffect.mPrevious = this;
                return;
            } else {
                if (absEffect2.mOrder >= i) {
                    absEffect2.insertEffect(absEffect);
                    return;
                }
                absEffect.mPrevious = this;
                absEffect.mNext = absEffect2;
                this.mNext.mPrevious = absEffect;
                this.mNext = absEffect;
                return;
            }
        }
        AbsEffect absEffect3 = this.mPrevious;
        if (absEffect3 == null) {
            this.mPrevious = absEffect;
            absEffect.mNext = this;
        } else {
            if (absEffect3.mOrder >= i) {
                absEffect3.mNext = absEffect;
                absEffect.mPrevious = absEffect3;
                absEffect.mNext = this;
                this.mPrevious = absEffect;
                return;
            }
            absEffect3.insertEffect(absEffect);
        }
    }

    public void removeEffect() {
        AbsEffect absEffect = this.mPrevious;
        if (absEffect != null) {
            absEffect.mNext = this.mNext;
        }
        AbsEffect absEffect2 = this.mNext;
        if (absEffect2 != null) {
            absEffect2.mPrevious = absEffect;
        }
        this.mNext = null;
        this.mPrevious = null;
    }

    public void setOption(int i, int i2) {
        AbsEffect absEffect;
        if (i != 10011) {
            if (i == 10015) {
                this.mRenderToScreen = i2 > 0;
                return;
            }
            AbsEffect absEffect2 = this.mNext;
            if (absEffect2 != null) {
                absEffect2.setOption(i, i2);
                return;
            }
            return;
        }
        this.mOrder = i2;
        AbsEffect absEffect3 = this.mPrevious;
        if ((absEffect3 == null || i2 <= absEffect3.mOrder) && ((absEffect = this.mNext) == null || i2 >= absEffect.mOrder)) {
            return;
        }
        removeEffect();
        insertEffect(this);
    }

    public void setOption(int i, float f) {
        AbsEffect absEffect = this.mNext;
        if (absEffect != null) {
            absEffect.setOption(i, f);
        }
    }

    public void setOption(int i, float[] fArr) {
        AbsEffect absEffect = this.mNext;
        if (absEffect != null) {
            absEffect.setOption(i, fArr);
        }
    }

    public void setOption(Bundle bundle) {
        AbsEffect absEffect = this.mNext;
        if (absEffect != null) {
            absEffect.setOption(bundle);
        }
    }

    public void setOption(int i, Object obj) {
        AbsEffect absEffect = this.mNext;
        if (absEffect != null) {
            absEffect.setOption(i, obj);
        }
    }

    public void setSurfaceTexture(VideoSurfaceTexture videoSurfaceTexture) {
        this.mSurfaceTexture = videoSurfaceTexture;
        if (videoSurfaceTexture != null) {
            this.mTexType = videoSurfaceTexture.texType();
        }
    }

    public void setParentRender(TextureRenderer textureRenderer) {
        this.mParentRender = textureRenderer;
    }

    public int getIntOption(int i) {
        if (i == 10004) {
            return this.mInTextureTarget;
        }
        if (i == 10005) {
            return this.mEffectType;
        }
        if (i == 10011) {
            return this.mOrder;
        }
        if (i != 10014) {
            return -1;
        }
        return this.mIsSupportOes;
    }

    public AbsEffect getPreviousEffect() {
        return this.mPrevious;
    }

    public AbsEffect getNextEffect() {
        return this.mNext;
    }

    public AbsEffect release() {
        AbsEffect absEffect = this.mNext;
        removeEffect();
        return absEffect;
    }

    public Bundle getInitBundle() {
        return this.mBundle;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append(super.toString()).append("[").append(this.mOrder).append("]->");
        AbsEffect absEffect = this.mNext;
        return sbAppend.append(absEffect != null ? absEffect.toString() : PointCategory.END).toString();
    }
}
