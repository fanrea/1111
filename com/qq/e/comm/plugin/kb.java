package com.qq.e.comm.plugin;

import android.graphics.PointF;
import android.view.View;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class kb {
    private final int a;
    private final x20 b;
    private final int c;
    private final int d;
    private final x20 e;
    private final int f;
    private PointF g;
    private int h = 0;
    private int i = 0;
    private boolean j;

    private kb(JSONObject jSONObject) {
        this.a = jSONObject.optInt(Config.DEVICE_ID_SEC, 0);
        this.b = new x20(jSONObject.optJSONArray("da"), true);
        this.c = jSONObject.optInt("ads", 0);
        this.d = jSONObject.optInt("adf", 0);
        this.e = new x20(jSONObject.optJSONArray("aa"), false);
        int iOptInt = jSONObject.optInt("at");
        this.f = iOptInt > 0 ? iOptInt : 0;
    }

    private Float b(View view, Float f, boolean z) {
        if (f == null) {
            return null;
        }
        float fB = z ? this.b.b() : this.b.d();
        float fA = z ? this.b.a() : this.b.c();
        float translationX = z ? view.getTranslationX() : view.getTranslationY();
        if (f.floatValue() < fB) {
            if (translationX != fB) {
                return Float.valueOf(fB);
            }
        } else {
            if (f.floatValue() <= fA) {
                return f;
            }
            if (translationX != fA) {
                return Float.valueOf(fA);
            }
        }
        return null;
    }

    private Float a(View view, Float f, boolean z) {
        if (f != null) {
            return f;
        }
        float translationX = z ? view.getTranslationX() : view.getTranslationY();
        float fB = z ? this.e.b() : this.e.d();
        float fA = z ? this.e.a() : this.e.c();
        if (translationX < fB) {
            return Float.valueOf(fB);
        }
        return translationX > fA ? Float.valueOf(fA) : f;
    }

    void b(View view, PointF pointF) {
        this.g = new PointF(pointF.x - view.getTranslationX(), pointF.y - view.getTranslationY());
        if (this.j) {
            return;
        }
        this.j = true;
        this.b.a(view);
        this.e.a(view);
        View view2 = (View) view.getParent();
        this.h = view2.getWidth();
        this.i = view2.getHeight();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r5, android.view.View r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L5
            int r5 = r4.c
            goto L7
        L5:
            int r5 = r4.d
        L7:
            if (r5 != 0) goto La
            return
        La:
            r0 = 0
            r1 = 1073741824(0x40000000, float:2.0)
            switch(r5) {
                case 1: goto L7b;
                case 2: goto L4c;
                case 3: goto L41;
                case 4: goto L36;
                case 5: goto L27;
                case 6: goto L1c;
                case 7: goto L11;
                default: goto L10;
            }
        L10:
            return
        L11:
            r5 = 0
            java.lang.Float r0 = java.lang.Float.valueOf(r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto Laa
        L1c:
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.a()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L31
        L27:
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.b()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
        L31:
            r3 = r0
            r0 = r5
            r5 = r3
            goto Laa
        L36:
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.c()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto Laa
        L41:
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.d()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto Laa
        L4c:
            float r5 = r6.getTranslationY()
            int r2 = r6.getTop()
            float r2 = (float) r2
            float r2 = r2 + r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r5 = r5 / r1
            float r2 = r2 + r5
            int r5 = r4.i
            float r5 = (float) r5
            float r5 = r5 / r1
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 <= 0) goto L70
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.c()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto Laa
        L70:
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.d()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto Laa
        L7b:
            float r5 = r6.getTranslationX()
            int r2 = r6.getLeft()
            float r2 = (float) r2
            float r2 = r2 + r5
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r5 = r5 / r1
            float r2 = r2 + r5
            int r5 = r4.h
            float r5 = (float) r5
            float r5 = r5 / r1
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 <= 0) goto L9f
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.a()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L31
        L9f:
            com.qq.e.comm.plugin.x20 r5 = r4.e
            float r5 = r5.b()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L31
        Laa:
            r1 = 1
            java.lang.Float r0 = r4.a(r6, r0, r1)
            r1 = 0
            java.lang.Float r5 = r4.a(r6, r5, r1)
            android.view.ViewPropertyAnimator r6 = r6.animate()
            if (r0 == 0) goto Lc1
            float r0 = r0.floatValue()
            r6.translationX(r0)
        Lc1:
            if (r5 == 0) goto Lca
            float r5 = r5.floatValue()
            r6.translationY(r5)
        Lca:
            int r5 = r4.f
            long r0 = (long) r5
            android.view.ViewPropertyAnimator r5 = r6.setDuration(r0)
            r5.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.kb.a(boolean, android.view.View):void");
    }

    static kb a(JSONObject jSONObject) {
        if (jSONObject.optInt("dg") == 1) {
            return new kb(jSONObject);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0098 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.view.View r4, android.graphics.PointF r5) {
        /*
            r3 = this;
            int r0 = r3.a
            r1 = 0
            switch(r0) {
                case 0: goto L76;
                case 1: goto L67;
                case 2: goto L5b;
                case 3: goto L46;
                case 4: goto L31;
                case 5: goto L1c;
                case 6: goto L7;
                default: goto L6;
            }
        L6:
            return
        L7:
            float r5 = r5.x
            android.graphics.PointF r0 = r3.g
            float r0 = r0.x
            float r5 = r5 - r0
            float r0 = r4.getTranslationX()
            float r0 = -r0
            float r5 = java.lang.Math.max(r5, r0)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L72
        L1c:
            float r5 = r5.x
            android.graphics.PointF r0 = r3.g
            float r0 = r0.x
            float r5 = r5 - r0
            float r0 = r4.getTranslationX()
            float r0 = -r0
            float r5 = java.lang.Math.min(r5, r0)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L72
        L31:
            float r5 = r5.y
            android.graphics.PointF r0 = r3.g
            float r0 = r0.y
            float r5 = r5 - r0
            float r0 = r4.getTranslationY()
            float r0 = -r0
            float r5 = java.lang.Math.max(r5, r0)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L8c
        L46:
            float r5 = r5.y
            android.graphics.PointF r0 = r3.g
            float r0 = r0.y
            float r5 = r5 - r0
            float r0 = r4.getTranslationY()
            float r0 = -r0
            float r5 = java.lang.Math.min(r5, r0)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L8c
        L5b:
            float r5 = r5.y
            android.graphics.PointF r0 = r3.g
            float r0 = r0.y
            float r5 = r5 - r0
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L8c
        L67:
            float r5 = r5.x
            android.graphics.PointF r0 = r3.g
            float r0 = r0.x
            float r5 = r5 - r0
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
        L72:
            r2 = r1
            r1 = r5
            r5 = r2
            goto L8c
        L76:
            float r0 = r5.x
            android.graphics.PointF r1 = r3.g
            float r1 = r1.x
            float r0 = r0 - r1
            java.lang.Float r1 = java.lang.Float.valueOf(r0)
            float r5 = r5.y
            android.graphics.PointF r0 = r3.g
            float r0 = r0.y
            float r5 = r5 - r0
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
        L8c:
            r0 = 1
            java.lang.Float r0 = r3.b(r4, r1, r0)
            r1 = 0
            java.lang.Float r5 = r3.b(r4, r5, r1)
            if (r0 != 0) goto L9b
            if (r5 != 0) goto L9b
            return
        L9b:
            android.view.ViewPropertyAnimator r4 = r4.animate()
            if (r0 == 0) goto La8
            float r0 = r0.floatValue()
            r4.translationX(r0)
        La8:
            if (r5 == 0) goto Lb1
            float r5 = r5.floatValue()
            r4.translationY(r5)
        Lb1:
            r0 = 0
            android.view.ViewPropertyAnimator r4 = r4.setDuration(r0)
            r4.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.kb.a(android.view.View, android.graphics.PointF):void");
    }
}
