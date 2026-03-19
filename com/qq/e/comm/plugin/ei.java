package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ei {
    private static float[] a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[4];
        float f = fArr[0] % 360.0f;
        int i = (int) (f / 90.0f);
        float f2 = f % 90.0f;
        if (f2 == 0.0f) {
            return a(fArr2, fArr3, i);
        }
        return a(fArr2, fArr3, f2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Shader a(java.lang.Object[] r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.ei.a(java.lang.Object[], int, int):android.graphics.Shader");
    }

    private static float[] a(float[] fArr) {
        int length;
        if (fArr == null || (length = fArr.length) < 2) {
            return fArr;
        }
        float f = fArr[0];
        float f2 = fArr[length - 1];
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            return fArr;
        }
        float fMin = Math.min(Math.min(f, f2), 0.0f);
        float fMax = Math.max(Math.max(f, f2), 1.0f) - fMin;
        if (fMax <= 0.0f) {
            return fArr;
        }
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = (fArr[i] - fMin) / fMax;
        }
        return fArr2;
    }

    private static float[] a(float[] fArr, float[] fArr2, float f, int i) {
        int i2 = i % 4;
        double d = (i2 == 1 || i2 == 3) ? 90.0f - f : f;
        Double.isNaN(d);
        double d2 = (float) ((d / 180.0d) * 3.141592653589793d);
        double dSin = Math.sin(d2);
        double dCos = Math.cos(d2);
        double dTan = Math.tan(d2);
        double d3 = 0.5f;
        Double.isNaN(d3);
        Double.isNaN(d3);
        float f2 = (float) (d3 / dCos);
        double d4 = 0.5f - ((float) (dTan * d3));
        Double.isNaN(d4);
        double d5 = f2 + ((float) (d4 * dSin));
        Double.isNaN(d5);
        float f3 = (float) (d5 * dCos);
        Double.isNaN(d5);
        float f4 = ((float) (d5 * dSin)) / 1.0f;
        float f5 = f3 / 1.0f;
        if (i == 0) {
            fArr2[0] = 0.5f - f4;
            fArr2[1] = f5 + 0.5f;
            fArr2[2] = f4 + 0.5f;
            fArr2[3] = 0.5f - f5;
        } else if (i == 1) {
            fArr2[0] = 0.5f - f4;
            fArr2[1] = 0.5f - f5;
            fArr2[2] = f4 + 0.5f;
            fArr2[3] = f5 + 0.5f;
        } else if (i == 2) {
            fArr2[0] = f4 + 0.5f;
            fArr2[1] = 0.5f - f5;
            fArr2[2] = 0.5f - f4;
            fArr2[3] = f5 + 0.5f;
        } else {
            fArr2[0] = f4 + 0.5f;
            fArr2[1] = f5 + 0.5f;
            fArr2[2] = 0.5f - f4;
            fArr2[3] = 0.5f - f5;
        }
        if (fArr != null && fArr.length >= 2) {
            float f6 = fArr[0];
            float f7 = fArr[fArr.length - 1];
            float fMin = Math.min(f6, f7);
            float fMax = Math.max(f6, f7);
            double dAbs = Math.abs(fArr2[0] - fArr2[2]) * 1.0f;
            Double.isNaN(dAbs);
            float f8 = (float) (dAbs / dSin);
            if (fMin < 0.0f) {
                double dAbs2 = Math.abs(fMin) * f8;
                Double.isNaN(dAbs2);
                float f9 = ((float) (dAbs2 * dSin)) / 1.0f;
                Double.isNaN(dAbs2);
                float f10 = ((float) (dAbs2 * dCos)) / 1.0f;
                if (i == 0) {
                    fArr2[0] = fArr2[0] - f9;
                    fArr2[1] = fArr2[1] + f10;
                } else if (i == 1) {
                    fArr2[0] = fArr2[0] - f9;
                    fArr2[1] = fArr2[1] - f10;
                } else if (i == 2) {
                    fArr2[0] = fArr2[0] + f9;
                    fArr2[1] = fArr2[1] - f10;
                } else if (i == 3) {
                    fArr2[0] = fArr2[0] + f9;
                    fArr2[1] = fArr2[1] + f10;
                }
            }
            if (fMax > 1.0f) {
                double d6 = f8 * (fMax - 1.0f);
                Double.isNaN(d6);
                float f11 = ((float) (dSin * d6)) / 1.0f;
                Double.isNaN(d6);
                float f12 = ((float) (d6 * dCos)) / 1.0f;
                if (i == 0) {
                    fArr2[2] = fArr2[2] + f11;
                    fArr2[3] = fArr2[3] - f12;
                } else if (i == 1) {
                    fArr2[2] = fArr2[2] + f11;
                    fArr2[3] = fArr2[3] + f12;
                } else if (i == 2) {
                    fArr2[2] = fArr2[2] - f11;
                    fArr2[3] = fArr2[3] + f12;
                } else if (i == 3) {
                    fArr2[2] = fArr2[2] - f11;
                    fArr2[3] = fArr2[3] - f12;
                }
            }
        }
        return fArr2;
    }

    private static float[] a(float[] fArr, float[] fArr2, int i) {
        int i2 = i % 4;
        if (i2 == 0) {
            fArr2[0] = 0.0f;
            fArr2[1] = 1.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
        } else if (i2 == 1) {
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 1.0f;
            fArr2[3] = 0.0f;
        } else if (i2 == 2) {
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 1.0f;
        } else if (i2 == 3) {
            fArr2[0] = 1.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
        }
        if (fArr != null && fArr.length >= 2) {
            float f = fArr[0];
            float f2 = fArr[fArr.length - 1];
            float fMin = Math.min(f, f2);
            float fMax = Math.max(f, f2);
            if (fMin < 0.0f) {
                float fAbs = Math.abs(fMin);
                if (i2 == 0) {
                    fArr2[1] = fAbs + 1.0f;
                } else if (i2 == 1) {
                    fArr2[0] = 0.0f - fAbs;
                } else if (i2 == 2) {
                    fArr2[1] = 0.0f - fAbs;
                } else if (i2 == 3) {
                    fArr2[0] = fAbs + 1.0f;
                }
            }
            if (fMax > 1.0f) {
                float f3 = fMax - 1.0f;
                if (i2 == 0) {
                    fArr2[3] = 0.0f - f3;
                } else if (i2 == 1) {
                    fArr2[2] = f3 + 1.0f;
                } else if (i2 == 2) {
                    fArr2[3] = f3 + 1.0f;
                } else if (i2 == 3) {
                    fArr2[2] = 0.0f - f3;
                }
            }
        }
        return fArr2;
    }
}
