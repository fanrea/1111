package com.baidu.mobads.container.util.animation;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ad extends c.a {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ ac c;
    private int d;
    private int e;
    private final ArgbEvaluator f = new ArgbEvaluator();

    ad(ac acVar, int i, int i2) {
        this.c = acVar;
        this.a = i;
        this.b = i2;
        this.d = this.a;
    }

    @Override // com.baidu.mobads.container.util.animation.c.a, com.baidu.mobads.container.util.animation.a.a
    public void a(float f, View view) {
        int iFloor = (int) Math.floor(f);
        float f2 = this.c.b + ((this.b == 0 ? 0.0f : f / this.b) * (this.c.f - this.c.b));
        float f3 = f - iFloor;
        int i = iFloor % this.c.a;
        Object objEvaluate = this.f.evaluate(f3, Integer.valueOf(this.c.c[i]), Integer.valueOf(this.c.c[(i + 1) % this.c.a]));
        if (objEvaluate instanceof Integer) {
            this.d = com.component.a.i.r.a(((Integer) objEvaluate).intValue(), f2);
        }
        if (a.EnumC0133a.BACKGROUND.equals(this.c.g)) {
            this.c.e.setBackgroundColor(this.d);
        }
    }

    @Override // com.baidu.mobads.container.util.animation.c.a, com.baidu.mobads.container.util.animation.a.a
    public void a(float f, Canvas canvas, c cVar) {
        Paint paint;
        if (a.EnumC0133a.PAINT.equals(this.c.g) && (paint = (Paint) cVar.a(a.a)) != null) {
            this.e = paint.getColor();
            paint.setColor(this.d);
        }
    }

    @Override // com.baidu.mobads.container.util.animation.c.a, com.baidu.mobads.container.util.animation.a.a
    public void b(float f, Canvas canvas, c cVar) {
        Paint paint;
        if (a.EnumC0133a.PAINT.equals(this.c.g) && (paint = (Paint) cVar.a(a.a)) != null) {
            paint.setColor(this.e);
        }
    }
}
