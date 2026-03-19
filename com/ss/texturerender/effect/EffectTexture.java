package com.ss.texturerender.effect;

import android.hardware.HardwareBuffer;
import android.opengl.GLES20;
import com.sigmob.sdk.archives.tar.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EffectTexture {
    private EffectTexture[] extraEffectTextures;
    private int format;
    private HardwareBuffer hardwareBuffer;
    private int height;
    private int internalFormat;
    private FilterType mMagFilterType;
    private FilterType mMinFilterType;
    private EffectTextureManager manager;
    private int sourceType;
    private int texID;
    private int texTarget;
    private int type;
    private int width;

    public enum FilterType {
        LINEAR,
        NEAREST,
        LINEAR_MIPMAP_LINEAR,
        LINEAR_MIPMAP_NEAREST,
        NEAREST_MIPMAP_LINEAR,
        NEAREST_MIPMAP_NEAREST
    }

    public enum TextureType {
        TEXTURE_2D,
        TEXTURE_2D_MULTISAMPLE,
        TEXTURE_OES
    }

    public EffectTexture(EffectTextureManager effectTextureManager, int i, int i2, int i3, int i4) {
        this.manager = effectTextureManager;
        this.texID = i;
        this.width = i2;
        this.height = i3;
        this.texTarget = i4;
        this.mMinFilterType = FilterType.LINEAR;
        this.mMagFilterType = FilterType.LINEAR;
        this.extraEffectTextures = null;
        this.sourceType = 1;
    }

    public EffectTexture(EffectTextureManager effectTextureManager, int i, int i2, int i3, int i4, FilterType filterType, FilterType filterType2) {
        this.manager = effectTextureManager;
        this.texID = i;
        this.width = i2;
        this.height = i3;
        this.texTarget = i4;
        this.mMinFilterType = filterType;
        this.mMagFilterType = filterType2;
        this.extraEffectTextures = null;
        this.sourceType = 1;
    }

    public EffectTexture(EffectTextureManager effectTextureManager, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(effectTextureManager, i, i2, i3, i4);
        this.internalFormat = i5;
        this.format = i6;
        this.type = i7;
    }

    public EffectTexture(EffectTextureManager effectTextureManager, HardwareBuffer hardwareBuffer, int i, int i2, int i3) {
        this.hardwareBuffer = hardwareBuffer;
        this.manager = effectTextureManager;
        this.width = i;
        this.height = i2;
        this.format = i3;
        this.sourceType = 2;
    }

    public void setManager(EffectTextureManager effectTextureManager) {
        this.manager = effectTextureManager;
    }

    public void setExtraEffectTexture(EffectTexture[] effectTextureArr) {
        this.extraEffectTextures = effectTextureArr;
    }

    public void giveBack() {
        EffectTextureManager effectTextureManager = this.manager;
        if (effectTextureManager != null) {
            effectTextureManager.onTextureReturn(this);
        }
    }

    public boolean isEqualTo(EffectTexture effectTexture) {
        return effectTexture != null && this.texID == effectTexture.texID;
    }

    public int getTexID() {
        return this.texID;
    }

    public int getTexTarget() {
        return this.texTarget;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public EffectTexture[] getExtraEffectTexture() {
        return this.extraEffectTextures;
    }

    public int getInternalFormat() {
        return this.internalFormat;
    }

    public int getFormat() {
        return this.format;
    }

    public int getType() {
        return this.type;
    }

    public HardwareBuffer getHardwareBuffer() {
        return this.hardwareBuffer;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String toString() {
        return "[manager:" + this.manager + "," + this.texID + "," + this.texTarget + "," + this.width + "," + this.height + "," + this.internalFormat + "," + this.format + "," + this.type + "]";
    }

    /* renamed from: com.ss.texturerender.effect.EffectTexture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType;

        static {
            int[] iArr = new int[FilterType.values().length];
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType = iArr;
            try {
                iArr[FilterType.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.NEAREST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.LINEAR_MIPMAP_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.LINEAR_MIPMAP_NEAREST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.NEAREST_MIPMAP_LINEAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.NEAREST_MIPMAP_NEAREST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static int getGLFilerType(FilterType filterType) {
        switch (AnonymousClass1.$SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[filterType.ordinal()]) {
            case 1:
                return 9729;
            case 2:
                return 9728;
            case 3:
                return 9987;
            case 4:
                return 9985;
            case 5:
                return 9986;
            case 6:
                return 9984;
            default:
                return 0;
        }
    }

    public void switchFilterType(FilterType filterType, FilterType filterType2) {
        if (this.mMinFilterType == filterType && this.mMagFilterType == filterType2) {
            return;
        }
        this.mMinFilterType = filterType;
        this.mMagFilterType = filterType2;
        GLES20.glBindTexture(this.texTarget, this.texID);
        int i = this.texTarget;
        if (i != 37120) {
            GLES20.glTexParameteri(i, 10241, getGLFilerType(filterType));
            GLES20.glTexParameteri(this.texTarget, d.b, getGLFilerType(filterType2));
        }
        GLES20.glBindTexture(this.texTarget, 0);
    }
}
