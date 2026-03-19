package com.kwad.sdk.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class bn {
    protected final int mHeight;
    protected final int mWidth;

    public bn(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final float apK() {
        return this.mWidth;
    }

    public final float apL() {
        return this.mHeight;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bn) {
            bn bnVar = (bn) obj;
            if (this.mWidth == bnVar.mWidth && this.mHeight == bnVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
