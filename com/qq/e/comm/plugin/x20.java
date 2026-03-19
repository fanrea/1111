package com.qq.e.comm.plugin;

import android.view.View;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class x20 {
    private final float[] a;
    private final boolean b;
    private final float c;

    x20(JSONArray jSONArray, boolean z) {
        int length;
        this.b = z;
        float f = z ? -1.0f : 0.0f;
        this.c = f;
        this.a = new float[]{f, f, f, f};
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return;
        }
        int i = length <= 4 ? length : 4;
        for (int i2 = 0; i2 < i; i2++) {
            if (!JSONObject.NULL.equals(jSONArray.opt(i2))) {
                this.a[i2] = t30.c(r1).a(new JSONObject[0]);
            }
        }
    }

    void a(View view) {
        View view2 = (View) view.getParent();
        int width = view2.getWidth() - view.getRight();
        int height = view2.getHeight() - view.getBottom();
        float fMin = this.b ? -2.1474836E9f : -view.getTop();
        float fMax = this.b ? 2.1474836E9f : height;
        float[] fArr = this.a;
        float f = fArr[0];
        if (f > this.c) {
            fMin = Math.min(0.0f, f - view.getTop());
        }
        fArr[0] = fMin;
        float[] fArr2 = this.a;
        float f2 = fArr2[1];
        if (f2 > this.c) {
            fMax = Math.max(0.0f, height - f2);
        }
        fArr2[1] = fMax;
        float fMin2 = this.b ? -2.1474836E9f : -view.getLeft();
        float fMax2 = this.b ? 2.1474836E9f : width;
        float[] fArr3 = this.a;
        float f3 = fArr3[2];
        if (f3 > this.c) {
            fMin2 = Math.min(0.0f, f3 - view.getLeft());
        }
        fArr3[2] = fMin2;
        float[] fArr4 = this.a;
        float f4 = fArr4[3];
        if (f4 > this.c) {
            fMax2 = Math.max(0.0f, width - f4);
        }
        fArr4[3] = fMax2;
    }

    float b() {
        return this.a[2];
    }

    float d() {
        return this.a[0];
    }

    float c() {
        return this.a[1];
    }

    float a() {
        return this.a[3];
    }
}
