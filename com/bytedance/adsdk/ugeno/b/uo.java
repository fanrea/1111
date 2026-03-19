package com.bytedance.adsdk.ugeno.b;

import android.animation.AnimatorSet;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo {
    private int an;
    private AnimatorSet b = new AnimatorSet();
    private View c;
    Paint d;
    private String h;
    private d hc;
    private int u;

    public uo(View view, d dVar) {
        this.c = view;
        this.hc = dVar;
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.b.uo.d():void");
    }

    public void hc() {
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void d(Canvas canvas, u uVar) {
        try {
            if (uVar.getRipple() == 0.0f || TextUtils.isEmpty(this.h)) {
                return;
            }
            this.d.setColor(com.bytedance.adsdk.ugeno.an.d.d(this.h));
            this.d.setAlpha(90);
            ((ViewGroup) this.c.getParent()).setClipChildren(true);
            canvas.drawCircle(this.u, this.an, Math.min(r0, r2) * 2 * uVar.getRipple(), this.d);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void d(int i, int i2) {
        this.u = i / 2;
        this.an = i2 / 2;
    }
}
