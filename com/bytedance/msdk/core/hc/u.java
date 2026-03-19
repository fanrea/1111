package com.bytedance.msdk.core.hc;

import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private final int[] b;
    private final String d;
    private final float[] hc;

    public u(String str, JSONArray jSONArray, JSONArray jSONArray2) {
        this.d = str;
        this.hc = new float[jSONArray.length()];
        this.b = new int[jSONArray2.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            this.hc[i] = (float) jSONArray.optDouble(i);
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            this.b[i2] = jSONArray2.optInt(i2);
        }
    }

    public int d(float f) {
        int[] iArr;
        int i;
        float[] fArr = this.hc;
        int i2 = -1;
        if (fArr == null || fArr.length == 0 || (iArr = this.b) == null || iArr.length == 0) {
            return -1;
        }
        int length = fArr.length;
        int i3 = 0;
        while (i3 < length) {
            float[] fArr2 = this.hc;
            float f2 = fArr2[i3];
            if (f > f2 && (i = i3 + 1) < length && f <= fArr2[i]) {
                int[] iArr2 = this.b;
                return i3 < iArr2.length ? iArr2[i3] : i2;
            }
            if (i3 == length - 1 && f > f2) {
                i2 = this.b[i3];
            }
            i3++;
        }
        return i2;
    }
}
