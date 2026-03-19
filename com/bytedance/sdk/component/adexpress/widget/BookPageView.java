package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BookPageView extends View {
    Point an;
    Point b;
    Point c;
    Paint d;
    Point h;
    Paint hc;
    Point u;

    public BookPageView(Context context) {
        super(context);
        this.d = new Paint();
        this.hc = new Paint();
        this.b = new Point();
        this.c = new Point();
        this.u = new Point();
        this.an = new Point();
        this.h = new Point();
        this.d.setColor(-16711936);
        this.d.setTextSize(25.0f);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.b.x = BookPageView.this.getWidth() - 10;
                BookPageView.this.b.y = BookPageView.this.getHeight() - 10;
                BookPageView.this.hc.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.hc.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.hc.setStrokeWidth(6.0f);
                BookPageView.this.hc.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public void d(Point point) {
        this.b.x = point.x;
        this.b.y = point.y;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d();
        Path path = new Path();
        path.moveTo(this.an.x, this.an.y);
        path.lineTo(this.b.x, this.b.y);
        path.lineTo(this.h.x, this.h.y);
        path.close();
        canvas.drawPath(path, this.hc);
    }

    private void d() {
        this.c.x = getWidth();
        this.c.y = getHeight();
        this.u.x = (this.b.x + this.c.x) / 2;
        this.u.y = (this.b.y + this.c.y) / 2;
        this.an.x = this.u.x - (((this.c.y - this.u.y) * (this.c.y - this.u.y)) / (this.c.x - this.u.x));
        this.an.y = this.c.y;
        this.h.x = this.c.x;
        this.h.y = this.u.y - (((this.c.x - this.u.x) * (this.c.x - this.u.x)) / (this.c.y - this.u.y));
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        path.moveTo(this.c.x, this.c.y);
        path.lineTo(this.an.x, this.an.y);
        path.lineTo(this.h.x, this.h.y);
        path.close();
        return path;
    }
}
