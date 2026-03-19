package com.baidu.mobads.container.x;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.x;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends RelativeLayout {
    protected static final int f = 1234234933;
    protected static final int g = 1234234934;
    protected static final int h = 1234234935;
    protected static final int i = 1234234936;
    private static final int p = 3;
    protected SeekBar a;
    protected ImageView b;
    protected ImageView c;
    protected TextView d;
    protected TextView e;
    private Context j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int q;

    j(Context context) {
        super(context);
        this.k = 30;
        this.l = 5;
        this.m = 10;
        this.n = 25;
        this.o = 45;
        this.q = 14;
        this.j = context;
        this.l = bv.b(this.j, this.l);
        this.o = bv.b(this.j, this.o);
        this.m = bv.b(this.j, this.m);
        this.k = bv.b(this.j, this.k);
        this.n = bv.b(this.j, this.n);
        this.q = bv.b(this.j, this.q);
        setBackgroundColor(1291845631);
        this.b = new ImageView(this.j);
        this.b.setId(f);
        int i2 = this.l;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.n + i2, this.k);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.b.setPadding(i2, i2, i2, i2);
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        this.e = new TextView(this.j);
        this.e.setId(g);
        this.e.setText("00:00");
        this.e.setGravity(17);
        this.e.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.o, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.b.getId());
        this.e.setLayoutParams(layoutParams2);
        addView(this.e);
        this.c = new ImageView(this.j);
        this.c.setId(h);
        int i3 = this.l;
        this.c.setPadding(i3, i3, i3, i3);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.n + i3, this.k);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        this.c.setLayoutParams(layoutParams3);
        a(true);
        addView(this.c);
        this.d = new TextView(this.j);
        this.d.setId(i);
        this.d.setText("00:00");
        this.d.setTextColor(-1);
        this.d.setGravity(17);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.o, -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, this.c.getId());
        this.d.setLayoutParams(layoutParams4);
        addView(this.d);
        this.a = new SeekBar(this.j);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, bv.b(context, 30));
        layoutParams5.addRule(15);
        layoutParams5.addRule(0, this.d.getId());
        layoutParams5.addRule(1, this.e.getId());
        layoutParams5.rightMargin = this.m;
        layoutParams5.leftMargin = 0;
        this.a.setPadding(this.m, 0, this.m, 0);
        this.a.setLayoutParams(layoutParams5);
        addView(this.a);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.a == null) {
            return;
        }
        a aVar = new a(this.j, this.k, this.a.getWidth());
        aVar.e.setARGB(255, 0, 191, 255);
        this.a.setProgressDrawable(new ClipDrawable(aVar, 3, 1));
        a aVar2 = new a(this.j, this.k, this.a.getWidth(), this.m);
        aVar2.e.setColor(-1);
        this.a.setBackgroundDrawable(aVar2);
        if (x.a(this.j).a() >= 11) {
            this.a.getBackground().setAlpha(0);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(this.q);
        shapeDrawable.setIntrinsicWidth(this.q);
        shapeDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        this.a.setThumb(shapeDrawable);
    }

    public void a(boolean z) {
        if (this.c == null) {
            return;
        }
        if (z) {
            com.component.b.a.a().a(this.c, "ic_white_fullscreen_stretch");
        } else {
            com.component.b.a.a().a(this.c, "ic_white_fullscreen_shrink");
        }
    }

    public void b(boolean z) {
        if (this.b == null) {
            return;
        }
        if (z) {
            com.component.b.a.a().a(this.b, "ic_white_play");
        } else {
            com.component.b.a.a().a(this.b, "ic_white_pause");
        }
    }

    private static class a extends Drawable {
        int a;
        int b;
        int c;
        Context d;
        private Paint e;

        public a(Context context, int i, int i2) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = context;
            this.a = i;
            this.b = i2;
            this.e = a();
        }

        public a(Context context, int i, int i2, int i3) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = context;
            this.a = i;
            this.b = i2;
            this.e = a();
            this.c = i3;
        }

        private Paint a() {
            if (this.e == null) {
                this.e = new Paint();
                this.e.setStyle(Paint.Style.STROKE);
                this.e.setAlpha(255);
                this.e.setAntiAlias(true);
                this.e.setStrokeWidth(bv.b(this.d, 3));
            }
            return this.e;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawLine(this.c, this.a / 2, this.b - this.c, this.a / 2, this.e);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }
}
