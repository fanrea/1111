package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h6 extends View {
    private final float a;
    private final Paint b;

    public h6(Context context, int i) {
        super(context);
        this.a = i / 2.0f;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b.setColor(2130706432);
        float f = this.a;
        canvas.drawCircle(f, f, f, this.b);
    }
}
