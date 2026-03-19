package com.bytedance.sdk.component.adexpress.dynamic.interact.d;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h implements View.OnTouchListener {
    private static int b = 10;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gb c;
    private float d;
    private float hc;
    private int u;
    private RectF an = new RectF();
    private long h = 0;
    private final int gb = 200;
    private final int tt = 3;
    private SoftReference<View> tc = new SoftReference<>(null);

    public h(com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar, int i, final ViewGroup viewGroup) {
        this.u = b;
        this.c = gbVar;
        if (i > 0) {
            this.u = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.d.h.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    h.this.tc = new SoftReference(viewFindViewById);
                }
            });
        }
    }

    private RectF d(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.an = d(this.tc.get());
            this.d = motionEvent.getRawX();
            this.hc = motionEvent.getRawY();
            this.h = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.an;
            if (rectF != null && !rectF.contains(this.d, this.hc)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.d);
            float fAbs2 = Math.abs(rawY - this.hc);
            int iHc = com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), Math.abs(rawX - this.d));
            int i = b;
            if (fAbs < i || fAbs2 < i) {
                if ((System.currentTimeMillis() - this.h < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (gbVar = this.c) != null) {
                    gbVar.d();
                }
            } else if (rawX > this.d && iHc > this.u && (gbVar2 = this.c) != null) {
                gbVar2.d();
            }
        }
        return true;
    }
}
