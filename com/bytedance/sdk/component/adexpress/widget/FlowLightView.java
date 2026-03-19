package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.jh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FlowLightView extends View {
    private int an;
    private int b;
    private int c;
    Rect d;
    private final List<d> e;
    private int gb;
    private int h;
    Rect hc;
    private LinearGradient k;
    private Paint mk;
    private Xfermode mq;
    private Bitmap tc;
    private int[] tt;
    private int u;
    private PorterDuff.Mode uo;

    public FlowLightView(Context context) {
        super(context);
        this.uo = PorterDuff.Mode.DST_IN;
        this.e = new ArrayList();
        d();
    }

    private void d() {
        this.b = jh.u(getContext(), "tt_splash_unlock_image_arrow");
        this.c = Color.parseColor("#00ffffff");
        this.u = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.an = color;
        this.h = 10;
        this.gb = 40;
        this.tt = new int[]{this.c, this.u, color};
        setLayerType(1, null);
        this.mk = new Paint(1);
        this.tc = BitmapFactory.decodeResource(getResources(), this.b);
        this.mq = new PorterDuffXfermode(this.uo);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.tc, this.d, this.hc, this.mk);
        canvas.save();
        Iterator<d> it = this.e.iterator();
        while (it.hasNext()) {
            d next = it.next();
            this.k = new LinearGradient(next.hc, 0.0f, next.hc + this.gb, this.h, this.tt, (float[]) null, Shader.TileMode.CLAMP);
            this.mk.setColor(-1);
            this.mk.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.mk);
            this.mk.setShader(null);
            next.d();
            if (next.hc > getWidth()) {
                it.remove();
            }
        }
        this.mk.setXfermode(this.mq);
        canvas.drawBitmap(this.tc, this.d, this.hc, this.mk);
        this.mk.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.tc == null) {
            return;
        }
        this.d = new Rect(0, 0, this.tc.getWidth(), this.tc.getHeight());
        this.hc = new Rect(0, 0, getWidth(), getHeight());
    }

    public void d(int i) {
        this.e.add(new d(i));
        postInvalidate();
    }

    public static class d {
        private final int d;
        private int hc = 0;

        public d(int i) {
            this.d = i;
        }

        public void d() {
            this.hc += this.d;
        }
    }
}
