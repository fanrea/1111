package com.kwai.player.vr;

import com.badlogic.gdx.math.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MDQuaternion {
    private final float[] q;

    private void set(float f, float f2, float f3, float f4) {
        float[] fArr = this.q;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
    }

    private void set(float[] fArr, float[] fArr2) {
        set((float) Math.acos(dot(r2, r3)), normal(cross(normal(fArr), normal(fArr2))));
    }

    private void set(float f, float[] fArr) {
        double d = f / 2.0f;
        this.q[0] = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float[] fArr2 = this.q;
        fArr2[1] = fArr[0] * fSin;
        fArr2[2] = fArr[1] * fSin;
        fArr2[3] = fArr[2] * fSin;
    }

    public void clone(MDQuaternion mDQuaternion) {
        float[] fArr = mDQuaternion.q;
        float[] fArr2 = this.q;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }

    public void idt() {
        set(1.0f, 0.0f, 0.0f, 0.0f);
    }

    private static float[] cross(float[] fArr, float[] fArr2) {
        float f = fArr[1];
        float f2 = fArr2[2];
        float f3 = fArr2[1];
        float f4 = fArr[2];
        float f5 = fArr2[0];
        float f6 = fArr[0];
        return new float[]{(f * f2) - (f3 * f4), (f4 * f5) - (f2 * f6), (f6 * f3) - (f5 * f)};
    }

    private static float dot(float[] fArr, float[] fArr2) {
        return (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    private static float[] normal(float[] fArr) {
        float fSqrt = (float) Math.sqrt(dot(fArr, fArr));
        return new float[]{fArr[0] / fSqrt, fArr[1] / fSqrt, fArr[2] / fSqrt};
    }

    public static float calcAngle(float[] fArr, float[] fArr2) {
        return (float) Math.acos(Math.min(dot(normal(fArr), normal(fArr2)), 1.0f));
    }

    public static float[] calcAxis(float[] fArr, float[] fArr2) {
        return normal(cross(normal(fArr), normal(fArr2)));
    }

    public MDQuaternion(float f, float f2, float f3, float f4) {
        this.q = new float[]{f, f2, f3, f4};
    }

    public MDQuaternion() {
        this.q = new float[4];
        idt();
    }

    public MDQuaternion conjugate() {
        float[] fArr = this.q;
        return new MDQuaternion(fArr[0], -fArr[1], -fArr[2], -fArr[3]);
    }

    public MDQuaternion plus(MDQuaternion mDQuaternion) {
        float[] fArr = this.q;
        float f = fArr[0];
        float[] fArr2 = mDQuaternion.q;
        return new MDQuaternion(f + fArr2[0], fArr[1] + fArr2[1], fArr[2] + fArr2[2], fArr[3] + fArr2[3]);
    }

    public MDQuaternion times(MDQuaternion mDQuaternion) {
        float[] fArr = this.q;
        float f = fArr[0];
        float[] fArr2 = mDQuaternion.q;
        float f2 = fArr2[0];
        float f3 = fArr[1];
        float f4 = fArr2[1];
        float f5 = (f * f2) - (f3 * f4);
        float f6 = fArr[2];
        float f7 = fArr2[2];
        float f8 = fArr[3];
        float f9 = fArr2[3];
        return new MDQuaternion((f5 - (f6 * f7)) - (f8 * f9), (((f * f4) + (f3 * f2)) + (f6 * f9)) - (f8 * f7), ((f * f7) - (f3 * f9)) + (f6 * f2) + (f8 * f4), (((f * f9) + (f3 * f7)) - (f6 * f4)) + (f8 * f2));
    }

    public MDQuaternion inverse() {
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = (f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4);
        return new MDQuaternion(f / f5, (-f2) / f5, (-f3) / f5, (-f4) / f5);
    }

    public MDQuaternion divides(MDQuaternion mDQuaternion) {
        return inverse().times(mDQuaternion);
    }

    public float[] rotateVec(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float[] fArr2 = this.q;
        float f4 = fArr2[1];
        float f5 = fArr2[2];
        float f6 = fArr2[3];
        float f7 = (f4 * f) + (f5 * f2) + (f6 * f3);
        float f8 = fArr2[0];
        return new float[]{(((((f * f8) - ((f5 * f3) - (f6 * f2))) * f8) + (f7 * f4)) * 2.0f) - f, (((((f2 * f8) - ((f6 * f) - (f4 * f3))) * f8) + (f7 * f5)) * 2.0f) - f2, (((f8 * ((f3 * f8) - ((f4 * f2) - (f5 * f)))) + (f7 * f6)) * 2.0f) - f3};
    }

    public void toMatrix(float[] fArr) {
        float[] fArr2 = this.q;
        float f = fArr2[1];
        float f2 = f * f;
        float f3 = fArr2[2];
        float f4 = f * f3;
        float f5 = fArr2[3];
        float f6 = f * f5;
        float f7 = fArr2[0];
        float f8 = f * f7;
        float f9 = f3 * f3;
        float f10 = f3 * f5;
        float f11 = f3 * f7;
        float f12 = f5 * f5;
        float f13 = f5 * f7;
        fArr[0] = 1.0f - ((f9 + f12) * 2.0f);
        fArr[1] = (f4 - f13) * 2.0f;
        fArr[2] = (f6 + f11) * 2.0f;
        fArr[4] = (f4 + f13) * 2.0f;
        fArr[5] = 1.0f - ((f12 + f2) * 2.0f);
        fArr[6] = (f10 - f8) * 2.0f;
        fArr[8] = (f6 - f11) * 2.0f;
        fArr[9] = (f10 + f8) * 2.0f;
        fArr[10] = 1.0f - ((f2 + f9) * 2.0f);
        fArr[14] = 0.0f;
        fArr[13] = 0.0f;
        fArr[12] = 0.0f;
        fArr[11] = 0.0f;
        fArr[7] = 0.0f;
        fArr[3] = 0.0f;
        fArr[15] = 1.0f;
    }

    public void fromMatrix(float[] fArr) {
        setFromAxes(false, fArr[0], fArr[1], fArr[2], fArr[4], fArr[5], fArr[6], fArr[8], fArr[9], fArr[10]);
    }

    public void setFromAxis(float f, float f2, float f3, float f4) {
        setFromAxisRad(f, f2, f3, f4 * 0.017453292f);
    }

    public void setFromAxisRad(float f, float f2, float f3, float f4) {
        float fLen = MDVector3D.len(f, f2, f3);
        if (fLen == 0.0f) {
            idt();
            return;
        }
        float f5 = 1.0f / fLen;
        double d = (f4 < 0.0f ? 6.2831855f - ((-f4) % 6.2831855f) : f4 % 6.2831855f) / 2.0f;
        float fSin = (float) Math.sin(d);
        set((float) Math.cos(d), f * f5 * fSin, f2 * f5 * fSin, f5 * f3 * fSin);
        nor();
    }

    private void setFromAxes(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (z) {
            float fLen = 1.0f / MDVector3D.len(f, f2, f3);
            float fLen2 = 1.0f / MDVector3D.len(f4, f5, f6);
            float fLen3 = 1.0f / MDVector3D.len(f7, f8, f9);
            f *= fLen;
            f2 *= fLen;
            f3 *= fLen;
            f4 *= fLen2;
            f5 *= fLen2;
            f6 *= fLen2;
            f7 *= fLen3;
            f8 *= fLen3;
            f9 *= fLen3;
        }
        if (f + f5 + f9 >= 0.0f) {
            float fSqrt = (float) Math.sqrt(r6 + 1.0f);
            f14 = fSqrt * 0.5f;
            float f15 = 0.5f / fSqrt;
            f12 = (f8 - f6) * f15;
            f10 = (f3 - f7) * f15;
            f13 = (f4 - f2) * f15;
        } else {
            if (f > f5 && f > f9) {
                float fSqrt2 = (float) Math.sqrt(((f + 1.0d) - f5) - f9);
                float f16 = fSqrt2 * 0.5f;
                float f17 = 0.5f / fSqrt2;
                float f18 = (f4 + f2) * f17;
                f13 = (f3 + f7) * f17;
                f11 = (f8 - f6) * f17;
                f10 = f18;
                f12 = f16;
            } else if (f5 > f9) {
                float fSqrt3 = (float) Math.sqrt(((f5 + 1.0d) - f) - f9);
                float f19 = fSqrt3 * 0.5f;
                float f20 = 0.5f / fSqrt3;
                float f21 = (f4 + f2) * f20;
                f13 = (f8 + f6) * f20;
                f11 = (f3 - f7) * f20;
                f12 = f21;
                f10 = f19;
            } else {
                float fSqrt4 = (float) Math.sqrt(((f9 + 1.0d) - f) - f5);
                float f22 = fSqrt4 * 0.5f;
                float f23 = 0.5f / fSqrt4;
                float f24 = (f3 + f7) * f23;
                f10 = (f8 + f6) * f23;
                f11 = (f4 - f2) * f23;
                f12 = f24;
                f13 = f22;
            }
            f14 = f11;
        }
        set(f14, f12, f10, f13);
    }

    public void setEulerAngles(float f, float f2, float f3) {
        setEulerAnglesRad(f * 0.017453292f, f2 * 0.017453292f, f3 * 0.017453292f);
    }

    public void setEulerAnglesRad(float f, float f2, float f3) {
        double d = f3 * 0.5f;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        double d2 = f * 0.5f;
        float fSin2 = (float) Math.sin(d2);
        float fCos2 = (float) Math.cos(d2);
        double d3 = f2 * 0.5f;
        float fSin3 = (float) Math.sin(d3);
        float fCos3 = (float) Math.cos(d3);
        float f4 = fCos3 * fSin2;
        float f5 = fSin3 * fCos2;
        float f6 = fCos3 * fCos2;
        float f7 = fSin3 * fSin2;
        float[] fArr = this.q;
        fArr[1] = (f4 * fCos) + (f5 * fSin);
        fArr[2] = (f5 * fCos) - (f4 * fSin);
        fArr[3] = (f6 * fSin) - (f7 * fCos);
        fArr[0] = (f6 * fCos) + (f7 * fSin);
    }

    public int getGimbalPole() {
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = (fArr[2] * fArr[1]) + (fArr[3] * f);
        if (f2 > 0.499f) {
            return 1;
        }
        return f2 < -0.499f ? -1 : 0;
    }

    public float getRollRad() {
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int gimbalPole = getGimbalPole();
        if (gimbalPole == 0) {
            return a.a(((f * f4) + (f3 * f2)) * 2.0f, 1.0f - (((f2 * f2) + (f4 * f4)) * 2.0f));
        }
        return gimbalPole * 2.0f * a.a(f3, f);
    }

    public float getRoll() {
        return getRollRad() * 57.295776f;
    }

    public float getPitchRad() {
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int gimbalPole = getGimbalPole();
        return gimbalPole == 0 ? (float) Math.asin(a.a(((f * f2) - (f4 * f3)) * 2.0f, -1.0f, 1.0f)) : gimbalPole * 3.1415927f * 0.5f;
    }

    public float getPitch() {
        return getPitchRad() * 57.295776f;
    }

    public float getYawRad() {
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        if (getGimbalPole() == 0) {
            return a.a(((f * f3) + (f4 * f2)) * 2.0f, 1.0f - (((f3 * f3) + (f2 * f2)) * 2.0f));
        }
        return 0.0f;
    }

    public float getYaw() {
        return getYawRad() * 57.295776f;
    }

    public void nor() {
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = (f2 * f2) + (f3 * f3) + (f4 * f4) + (f * f);
        if (f5 != 0.0f && !a.b(f5, 1.0f)) {
            float fSqrt = (float) Math.sqrt(f5);
            f /= fSqrt;
            f2 /= fSqrt;
            f3 /= fSqrt;
            f4 /= fSqrt;
        }
        set(f, f2, f3, f4);
    }

    public String toString() {
        return String.format("MDQuaternion w=%f x=%f, y=%f, z=%f", Float.valueOf(this.q[0]), Float.valueOf(this.q[1]), Float.valueOf(this.q[2]), Float.valueOf(this.q[3]));
    }
}
