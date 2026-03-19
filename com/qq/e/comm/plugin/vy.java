package com.qq.e.comm.plugin;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class vy extends m4 {
    private final float g;
    private final boolean h;
    private final List<PointF> i;
    private List<PointF> j;

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[PHI: r7
  0x002b: PHI (r7v3 double) = (r7v0 double), (r7v1 double) binds: [B:12:0x0029, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    vy(com.qq.e.comm.plugin.h8 r10) {
        /*
            r9 = this;
            r9.<init>(r10)
            org.json.JSONObject r10 = r10.c
            r0 = 0
            r1 = 0
            if (r10 == 0) goto L70
            int r2 = r10.length()
            if (r2 > 0) goto L10
            goto L70
        L10:
            java.lang.String r2 = "rtdrn"
            int r2 = r10.optInt(r2, r1)
            r3 = 1
            if (r2 != r3) goto L1a
            goto L1b
        L1a:
            r3 = 0
        L1b:
            r9.h = r3
            java.lang.String r2 = "sml"
            r3 = 0
            double r5 = r10.optDouble(r2, r3)
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L2d
        L2b:
            r5 = r7
            goto L34
        L2d:
            r7 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 >= 0) goto L34
            goto L2b
        L34:
            float r2 = (float) r5
            r9.g = r2
            java.lang.String r2 = "pts"
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            if (r10 == 0) goto L6d
            int r2 = r10.length()
            if (r2 > 0) goto L46
            goto L6d
        L46:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r5 = r2 + 1
            int r5 = r5 / 2
            r0.<init>(r5)
            r9.i = r0
        L51:
            if (r1 >= r2) goto L6c
            double r5 = r10.optDouble(r1, r3)
            float r0 = (float) r5
            int r5 = r1 + 1
            double r5 = r10.optDouble(r5, r3)
            float r5 = (float) r5
            java.util.List<android.graphics.PointF> r6 = r9.i
            android.graphics.PointF r7 = new android.graphics.PointF
            r7.<init>(r0, r5)
            r6.add(r7)
            int r1 = r1 + 2
            goto L51
        L6c:
            return
        L6d:
            r9.i = r0
            return
        L70:
            r10 = 0
            r9.g = r10
            r9.h = r1
            r9.i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.vy.<init>(com.qq.e.comm.plugin.h8):void");
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        List<PointF> list = this.j;
        if (list != null) {
            list.add(pointF2);
        }
        return super.b(view, motionEvent, pointF, pointF2);
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        List<PointF> list = this.j;
        if (list != null) {
            list.add(pointF2);
        }
        return super.a(view, motionEvent, pointF, pointF2);
    }

    @Override // com.qq.e.comm.plugin.m4
    boolean d(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        return wy.a(this.i, this.j, this.h) >= this.g;
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        ArrayList arrayList = new ArrayList(20);
        this.j = arrayList;
        arrayList.add(pointF);
        return super.a(view, motionEvent, pointF);
    }
}
