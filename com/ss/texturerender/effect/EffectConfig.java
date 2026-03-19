package com.ss.texturerender.effect;

import com.ss.texturerender.TextureRenderLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EffectConfig {
    private static final String LOG_TAG = "EffectConfig";
    private int mEGLBitDepth;
    private ConcurrentHashMap<Integer, Integer> mEffectOpenMap;
    private int mTexType;
    private boolean openSR;
    private boolean openSharpen;
    private boolean openTile;

    public EffectConfig(int i) {
        this.openSR = false;
        this.openSharpen = false;
        this.openTile = false;
        this.mEffectOpenMap = new ConcurrentHashMap<>();
        this.mEGLBitDepth = 8;
        this.mTexType = i;
    }

    public EffectConfig() {
        this(-1);
    }

    public int getEGLBitDepth() {
        return this.mEGLBitDepth;
    }

    public void setEGLBitDepth(int i) {
        this.mEGLBitDepth = i;
    }

    public boolean isOpenSR() {
        return this.openSR;
    }

    public EffectConfig setOpenSR(boolean z) {
        this.openSR = z;
        this.mEffectOpenMap.put(5, Integer.valueOf(z ? 1 : 0));
        return this;
    }

    public boolean isOpenSharpen() {
        return this.openSharpen;
    }

    public EffectConfig setOpenSharpen(boolean z) {
        this.openSharpen = z;
        this.mEffectOpenMap.put(1, Integer.valueOf(z ? 1 : 0));
        return this;
    }

    public boolean isOpenTile() {
        return this.openTile;
    }

    public EffectConfig setOpenTile(boolean z) {
        this.openTile = z;
        return this;
    }

    public EffectConfig setEffectOpen(int i, int i2) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setEffectOpen effect:" + i + ",isOpen:" + i2);
        if (i == 1) {
            this.openSharpen = i2 == 1;
        }
        if (i == 5) {
            this.openSR = i2 == 1;
        }
        this.mEffectOpenMap.put(Integer.valueOf(i), Integer.valueOf(i2));
        return this;
    }

    public boolean getEffectOpen(int i) {
        Integer num = this.mEffectOpenMap.get(Integer.valueOf(i));
        return num != null && num.intValue() == 1;
    }

    public boolean isSubSet(EffectConfig effectConfig) {
        if (effectConfig.openSR && !this.openSR) {
            return false;
        }
        if (effectConfig.openSharpen && !this.openSharpen) {
            return false;
        }
        if (effectConfig.getEffectOpen(14) && !getEffectOpen(14)) {
            return false;
        }
        if (effectConfig.getEffectOpen(16) && !getEffectOpen(16)) {
            return false;
        }
        if (effectConfig.openSharpen || effectConfig.openSR || effectConfig.getEffectOpen(14) || effectConfig.getEffectOpen(16)) {
            return true;
        }
        return (this.openSR || this.openSharpen || getEffectOpen(14) || getEffectOpen(16)) ? false : true;
    }

    public boolean hasFboEffect() {
        for (Map.Entry<Integer, Integer> entry : this.mEffectOpenMap.entrySet()) {
            if (entry.getKey().intValue() != 1 && entry.getKey().intValue() != 5) {
                return true;
            }
        }
        return false;
    }

    public ConcurrentHashMap<Integer, Integer> getEffectConfigMap() {
        return this.mEffectOpenMap;
    }

    public void reset() {
        this.mEffectOpenMap.clear();
        this.openSR = false;
        this.openSharpen = false;
    }

    public String toString() {
        return "Config:[opengSR:" + this.openSR + " opengSharpen:" + this.openSharpen + " config:" + this.mEffectOpenMap.toString() + "]";
    }

    public int texType() {
        return this.mTexType;
    }

    public void setTexType(int i) {
        this.mTexType = i;
    }
}
