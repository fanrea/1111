package com.ss.texturerender.effect.vr.distortion;

import com.ss.texturerender.TextureRenderLog;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BrownDistortion {
    private static final String LOG_TAG = "TR_BrownDistortion";
    private float[] mCoefficients;
    private int mTexType;

    public BrownDistortion(float[] fArr, int i) {
        this.mTexType = i;
        this.mCoefficients = Arrays.copyOf(fArr, fArr.length);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new BrownDistortion:" + Arrays.toString(this.mCoefficients));
    }

    public float[] distort(float f, float f2) {
        float fDistortionFactor = distortionFactor((f * f) + (f2 * f2));
        return new float[]{f * fDistortionFactor, fDistortionFactor * f2};
    }

    public float[] distortInverse(float f, float f2) {
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        if (fSqrt - 0.0f < Math.ulp(0.0f)) {
            return new float[]{f, f2};
        }
        float f3 = fSqrt / 2.0f;
        float f4 = fSqrt / 3.0f;
        float fDistortionFactor = fSqrt - (distortionFactor(f3 * f3) * f3);
        while (true) {
            float f5 = f4;
            float f6 = f3;
            f3 = f5;
            float f7 = f3 - f6;
            if (Math.abs(f7) <= 1.0E-4f) {
                float f8 = f3 / fSqrt;
                return new float[]{f * f8, f8 * f2};
            }
            float fDistortionFactor2 = fSqrt - (distortionFactor(f3 * f3) * f3);
            f4 = f3 - ((f7 / (fDistortionFactor2 - fDistortionFactor)) * fDistortionFactor2);
            fDistortionFactor = fDistortionFactor2;
        }
    }

    private float distortionFactor(float f) {
        float fFloatValue = 1.0f;
        float f2 = 1.0f;
        for (float f3 : this.mCoefficients) {
            f2 *= f;
            fFloatValue += Float.valueOf(f3).floatValue() * f2;
        }
        return fFloatValue;
    }
}
