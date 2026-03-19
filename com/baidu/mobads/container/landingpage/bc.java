package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bc extends ImageView {
    int a;
    RectF b;
    private final Paint c;
    private final Context d;

    public bc(Context context) {
        super(context);
        this.a = 0;
        this.b = new RectF();
        this.d = context;
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int iA = a(this.d, 15.0f);
        int iA2 = a(this.d, 3.0f);
        int i = iA + 1 + (iA2 / 2);
        float f = width - i;
        this.b.left = f;
        this.b.top = f;
        float f2 = width + i;
        this.b.right = f2;
        this.b.bottom = f2;
        this.c.setColor(-1907998);
        this.c.setStrokeWidth(iA2);
        canvas.drawArc(this.b, this.a + 0, 72.0f, false, this.c);
        this.c.setColor(-1594427658);
        canvas.drawArc(this.b, this.a + 72, 270.0f, false, this.c);
        this.a += 10;
        if (this.a >= 360) {
            this.a = 0;
        }
        super.onDraw(canvas);
        invalidate();
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
