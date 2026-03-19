package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fx extends ImageView {
    private RectF a;
    private Path b;
    private float[] c;

    public fx(Context context) {
        super(context);
        this.a = new RectF();
        this.b = new Path();
        this.c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.a.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.addRoundRect(this.a, this.c, Path.Direction.CW);
        canvas.clipPath(this.b);
        super.onDraw(canvas);
        this.b.reset();
    }

    public void a(float f) {
        float[] fArr = this.c;
        fArr[0] = f;
        fArr[1] = f;
        fArr[2] = f;
        fArr[3] = f;
        fArr[4] = f;
        fArr[5] = f;
        fArr[6] = f;
        fArr[7] = f;
    }
}
