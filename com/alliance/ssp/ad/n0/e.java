package com.alliance.ssp.ad.n0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: SAOverlapShapeView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e extends View {
    public Paint a;
    public Paint b;
    public Path c;
    public Path d;
    public Context e;
    public float f;
    public int g;
    public int h;
    public int i;

    public e(Context context, float f) throws JSONException, PackageManager.NameNotFoundException, IOException {
        super(context);
        this.g = 1;
        this.h = 1;
        this.i = 1;
        this.e = context;
        this.f = f;
        a();
    }

    public final void a() throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            Paint paint = new Paint(1);
            this.a = paint;
            paint.setColor(Color.parseColor(f.g.a));
            Paint paint2 = new Paint(1);
            this.b = paint2;
            paint2.setColor(0);
            this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            RectF rectF = new RectF(0.0f, 0.0f, 500.0f, 500.0f);
            Path path = new Path();
            this.c = path;
            path.addRect(rectF, Path.Direction.CW);
            Path path2 = new Path();
            this.d = path2;
            if (Build.VERSION.SDK_INT >= 21) {
                path2.addRoundRect(rectF, com.alliance.ssp.ad.l.b.a(this.e, this.f), com.alliance.ssp.ad.l.b.a(this.e, this.f), Path.Direction.CW);
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("OverlapShapeView 001: ")), e);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) throws JSONException, PackageManager.NameNotFoundException, IOException {
        super.onDraw(canvas);
        try {
            int width = getWidth();
            int height = getHeight();
            this.c.reset();
            float f = height;
            this.c.addRect(0.0f, 0.0f, width, f, Path.Direction.CW);
            this.d = new Path();
            this.d.addRoundRect(new RectF(this.h, this.i, width - this.g, f), com.alliance.ssp.ad.l.b.a(this.e, this.f), com.alliance.ssp.ad.l.b.a(this.e, this.f), Path.Direction.CW);
            int iSaveLayer = Build.VERSION.SDK_INT >= 21 ? canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null) : 0;
            canvas.drawPath(this.c, this.a);
            canvas.drawPath(this.d, this.b);
            canvas.restoreToCount(iSaveLayer);
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("OverlapShapeView 002: ")), e);
        }
    }
}
