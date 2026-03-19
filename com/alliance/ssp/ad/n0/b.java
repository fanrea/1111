package com.alliance.ssp.ad.n0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.bean.Shake;
import com.alliance.ssp.ad.l.c;
import com.alliance.ssp.ad.o0.l;
import com.google.android.material.badge.BadgeDrawable;

/* compiled from: ExpressFeedTemplate.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public com.alliance.ssp.ad.l.c A;
    public int a;
    public Context b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public View g = null;
    public View h = null;
    public View i = null;
    public View j = null;
    public View k = null;
    public View l = null;
    public View m = null;
    public View n = null;
    public View o = null;
    public View p = null;
    public View q = null;
    public View r = null;
    public View s = null;
    public View t = null;
    public View u = null;
    public View v = null;
    public View w = null;
    public View x = null;
    public View y = null;
    public int[] z = new int[2];

    public b(Context context, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.b = context;
        this.c = i;
        this.a = i2;
        this.e = i3;
        this.d = i4;
        this.f = z;
        int i5 = l.a;
        switch (i2) {
            case 1:
                a(true);
                break;
            case 2:
                c();
                break;
            case 3:
                b();
                break;
            case 4:
                a();
                break;
            case 5:
                a(false);
                break;
            case 6:
                b(z2);
                break;
        }
        this.z[0] = i;
    }

    public final void a(boolean z) {
        double d;
        double d2;
        LinearLayout linearLayout;
        if (this.f) {
            d = this.c;
            d2 = 0.37d;
        } else {
            d = this.c;
            d2 = 0.27d;
        }
        float f = (float) (d * d2);
        this.z[1] = (int) f;
        LinearLayout linearLayoutA = a(a(this.c), a(f), 1.0f, 1);
        LinearLayout linearLayoutA2 = a(-1, 0, 12.0f, 1);
        LinearLayout linearLayoutA3 = a(-1, 0, 72.0f, 0);
        LinearLayout linearLayoutA4 = a(-1, 0, 12.0f, 1);
        View view = null;
        if (this.f) {
            LinearLayout linearLayoutA5 = a(-1, 0, 36.0f, 0);
            a(linearLayoutA5, f.g.b, 0.0f, 0.0f, 0.0f, 0.0f);
            LinearLayout linearLayoutA6 = a(0, -1, 12.0f, 1);
            LinearLayout linearLayoutB = b(0, -1, 336.0f, 1);
            a.a(linearLayoutA5, linearLayoutA6, linearLayoutB, a(0, -1, 12.0f, 1));
            linearLayout = linearLayoutB;
            view = linearLayoutA5;
        } else {
            linearLayout = null;
        }
        a.a(linearLayoutA, linearLayoutA2, linearLayoutA3, linearLayoutA4);
        if (this.f && view != null) {
            linearLayoutA.addView(view);
            this.o = linearLayout;
        }
        View viewA = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA7 = a(0, -1, 128.0f, 1);
        a(linearLayoutA7, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayoutA7.addView(frameLayout);
        FrameLayout frameLayout2 = new FrameLayout(this.b);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.setBackgroundColor(Color.parseColor("#00000000"));
        FrameLayout frameLayout3 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a((float) (this.c * 0.045d)), a((float) (this.c * 0.045d)));
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.setMargins(a(2.0f), a(2.0f), 0, 0);
        frameLayout3.setLayoutParams(layoutParams);
        FrameLayout frameLayout4 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a((float) (this.c * 0.117d)), a((float) (this.c * 0.05d)));
        layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
        frameLayout4.setLayoutParams(layoutParams2);
        FrameLayout frameLayout5 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a((float) (this.c * 0.08d)), a((float) (this.c * 0.03d)));
        layoutParams3.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams3.setMargins(0, 0, a(2.0f), a(4.0f));
        frameLayout5.setLayoutParams(layoutParams3);
        FrameLayout frameLayout6 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, a(3.0f));
        layoutParams4.gravity = 80;
        frameLayout6.setLayoutParams(layoutParams4);
        frameLayout2.addView(frameLayout3);
        frameLayout2.addView(frameLayout4);
        frameLayout2.addView(frameLayout5);
        frameLayout2.addView(frameLayout6);
        this.u = frameLayout3;
        this.v = frameLayout2;
        this.m = frameLayout4;
        this.s = frameLayout5;
        this.t = frameLayout6;
        LinearLayout linearLayoutA8 = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA9 = a(0, -1, 196.0f, 1);
        View viewA2 = a(0, -1, 12.0f, 1);
        linearLayoutA3.addView(viewA);
        if (z) {
            a.a(linearLayoutA3, linearLayoutA7, linearLayoutA8, linearLayoutA9);
        } else {
            a.a(linearLayoutA3, linearLayoutA9, linearLayoutA8, linearLayoutA7);
        }
        linearLayoutA3.addView(viewA2);
        LinearLayout linearLayoutA10 = a(-1, 0, 49.0f, 1);
        LinearLayout linearLayoutA11 = a(-1, 0, 7.0f, 1);
        LinearLayout linearLayoutA12 = a(-1, 0, 18.0f, 0);
        a.a(linearLayoutA9, linearLayoutA10, linearLayoutA11, linearLayoutA12);
        View viewA3 = a(0, -1, 118.0f, 1);
        View viewA4 = a(0, -1, 6.0f, 1);
        View viewA5 = a(0, -1, 52.0f, 1);
        View viewA6 = a(0, -1, 6.0f, 1);
        View viewA7 = a(0, -1, 20.0f, 1);
        linearLayoutA12.addView(viewA3);
        linearLayoutA12.addView(viewA4);
        linearLayoutA12.addView(viewA5);
        linearLayoutA12.addView(viewA6);
        linearLayoutA12.addView(viewA7);
        this.g = linearLayoutA;
        this.h = frameLayout;
        this.i = linearLayoutA10;
        this.j = viewA3;
        this.k = viewA5;
        this.l = viewA7;
    }

    public final void b(boolean z) {
        LinearLayout linearLayout;
        float f = (float) (this.f ? this.c * 0.9d : this.c * 0.8d);
        float f2 = 24.0f;
        if ((a(f) * 0.9d) / 16.0d <= this.e) {
            f += 25.0f;
            f2 = 49.0f;
        }
        float f3 = f2;
        this.z[1] = (int) f;
        LinearLayout linearLayoutA = a(a(this.c), a(f), 1.0f, 1);
        LinearLayout linearLayoutA2 = a(-1, 0, 296.0f, 0);
        View view = null;
        float f4 = 12.0f;
        if (this.f) {
            LinearLayout linearLayoutA3 = a(-1, 0, 36.0f, 0);
            a(linearLayoutA3, f.g.b, 0.0f, 0.0f, 0.0f, 0.0f);
            LinearLayout linearLayoutA4 = a(0, -1, 12.0f, 1);
            LinearLayout linearLayoutB = b(0, -1, 336.0f, 1);
            a.a(linearLayoutA3, linearLayoutA4, linearLayoutB, a(0, -1, 12.0f, 1));
            linearLayout = linearLayoutB;
            view = linearLayoutA3;
        } else {
            linearLayout = null;
        }
        linearLayoutA.addView(linearLayoutA2);
        if (this.f && view != null) {
            linearLayoutA.addView(view);
            this.o = linearLayout;
        }
        LinearLayout linearLayoutA5 = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA6 = a(0, -1, 336.0f, 1);
        a.a(linearLayoutA2, linearLayoutA5, linearLayoutA6, a(0, -1, 12.0f, 1));
        View viewA = a(-1, 0, 12.0f, 1);
        LinearLayout linearLayoutA7 = a(-1, 0, 32.0f, 0);
        View viewA2 = a(-1, 0, 12.0f, 1);
        View viewA3 = a(-1, 0, f3, 1);
        LinearLayout linearLayoutA8 = a(-1, 0, 12.0f, 1);
        LinearLayout linearLayoutA9 = a(-1, 0, 197.0f, 1);
        a(linearLayoutA9, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayoutA9.addView(frameLayout);
        c(true);
        LinearLayout linearLayoutA10 = a(-1, 0, 12.0f, 1);
        linearLayoutA6.addView(viewA);
        linearLayoutA6.addView(linearLayoutA7);
        linearLayoutA6.addView(viewA2);
        linearLayoutA6.addView(viewA3);
        a.a(linearLayoutA6, linearLayoutA8, linearLayoutA9, linearLayoutA10);
        if (z) {
            View viewA4 = a(0, -1, 32.0f, 1);
            View viewA5 = a(0, -1, 12.0f, 1);
            linearLayoutA7.addView(viewA4);
            linearLayoutA7.addView(viewA5);
            this.n = viewA4;
        } else {
            f4 = 56.0f;
        }
        View viewB = b(0, -1, 192.0f, 1);
        View viewA6 = a(0, -1, f4, 1);
        View viewB2 = b(0, -1, 80.0f, 1);
        View viewA7 = a(0, -1, 6.0f, 1);
        View viewA8 = a(0, -1, 20.0f, 1);
        linearLayoutA7.addView(viewB);
        linearLayoutA7.addView(viewA6);
        linearLayoutA7.addView(viewB2);
        linearLayoutA7.addView(viewA7);
        linearLayoutA7.addView(viewA8);
        this.g = linearLayoutA;
        this.h = frameLayout;
        this.i = viewA3;
        this.j = viewB;
        this.k = viewB2;
        this.l = viewA8;
    }

    public final void c() {
        double d;
        double d2;
        float f;
        LinearLayout linearLayout;
        if (this.f) {
            d = this.c;
            d2 = 0.85d;
        } else {
            d = this.c;
            d2 = 0.75d;
        }
        float f2 = (float) (d * d2);
        if ((a(f2) * 0.9d) / 16.0d <= this.e) {
            f2 += 25.0f;
            f = 49.0f;
        } else {
            f = 24.0f;
        }
        this.z[1] = (int) f2;
        LinearLayout linearLayoutA = a(a(this.c), a(f2), 1.0f, 1);
        View view = null;
        if (this.f) {
            LinearLayout linearLayoutA2 = a(-1, 0, 36.0f, 0);
            a(linearLayoutA2, f.g.b, 0.0f, 0.0f, 0.0f, 0.0f);
            LinearLayout linearLayoutA3 = a(0, -1, 12.0f, 1);
            LinearLayout linearLayoutB = b(0, -1, 336.0f, 1);
            a.a(linearLayoutA2, linearLayoutA3, linearLayoutB, a(0, -1, 12.0f, 1));
            linearLayout = linearLayoutB;
            view = linearLayoutA2;
        } else {
            linearLayout = null;
        }
        LinearLayout linearLayoutA4 = a(-1, 0, 296.0f, 0);
        linearLayoutA.addView(linearLayoutA4);
        if (this.f && view != null) {
            linearLayoutA.addView(view);
            this.o = linearLayout;
        }
        LinearLayout linearLayoutA5 = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA6 = a(0, -1, 336.0f, 1);
        a.a(linearLayoutA4, linearLayoutA5, linearLayoutA6, a(0, -1, 12.0f, 1));
        View viewA = a(-1, 0, 12.0f, 1);
        LinearLayout linearLayoutA7 = a(-1, 0, 224.0f, 1);
        a(linearLayoutA7, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayoutA7.addView(frameLayout);
        c(false);
        View viewA2 = a(-1, 0, 12.0f, 1);
        View viewA3 = a(-1, 0, f, 1);
        LinearLayout linearLayoutA8 = a(-1, 0, 12.0f, 1);
        LinearLayout linearLayoutA9 = a(-1, 0, 24.0f, 0);
        LinearLayout linearLayoutA10 = a(-1, 0, 12.0f, 1);
        linearLayoutA6.addView(viewA);
        linearLayoutA6.addView(linearLayoutA7);
        linearLayoutA6.addView(viewA2);
        linearLayoutA6.addView(viewA3);
        a.a(linearLayoutA6, linearLayoutA8, linearLayoutA9, linearLayoutA10);
        View viewA4 = a(0, -1, 42.0f, 1);
        View viewA5 = a(0, -1, 8.0f, 1);
        View viewB = b(0, -1, 174.0f, 1);
        View viewA6 = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA11 = a(0, -1, 80.0f, 1);
        LinearLayout linearLayoutA12 = a(0, -1, 6.0f, 1);
        LinearLayout linearLayoutA13 = a(0, -1, 20.0f, 1);
        linearLayoutA9.addView(viewA4);
        linearLayoutA9.addView(viewA5);
        linearLayoutA9.addView(viewB);
        linearLayoutA9.addView(viewA6);
        a.a(linearLayoutA9, linearLayoutA11, linearLayoutA12, linearLayoutA13);
        this.g = linearLayoutA;
        this.h = frameLayout;
        this.i = viewA3;
        this.j = viewB;
        this.k = linearLayoutA11;
        this.l = linearLayoutA13;
        this.m = viewA4;
    }

    public final void c(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#00000000"));
        FrameLayout frameLayout2 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a((float) (this.c * 0.078d)), a((float) (this.c * 0.078d)));
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.setMargins(a(4.0f), a(4.0f), 0, 0);
        frameLayout2.setLayoutParams(layoutParams);
        if (z) {
            FrameLayout frameLayout3 = new FrameLayout(this.b);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a((float) (this.c * 0.117d)), a((float) (this.c * 0.05d)));
            layoutParams2.setMargins(a(8.0f), 0, 0, a(8.0f));
            layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
            frameLayout3.setLayoutParams(layoutParams2);
            frameLayout.addView(frameLayout3);
            this.m = frameLayout3;
        }
        FrameLayout frameLayout4 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a((float) (this.c * 0.106d)), a((float) (this.c * 0.05d)));
        layoutParams3.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams.setMargins(0, 0, a(8.0f), a(8.0f));
        frameLayout4.setLayoutParams(layoutParams3);
        FrameLayout frameLayout5 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, a(2.0f));
        layoutParams4.gravity = 80;
        frameLayout5.setLayoutParams(layoutParams4);
        FrameLayout frameLayout6 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a((float) (this.c * 0.4d)), a((float) (this.c * 0.08d)));
        layoutParams5.gravity = 81;
        layoutParams5.setMargins(0, 0, 0, a(5.0f));
        frameLayout6.setLayoutParams(layoutParams5);
        frameLayout.addView(frameLayout2);
        frameLayout.addView(frameLayout4);
        frameLayout.addView(frameLayout5);
        frameLayout.addView(frameLayout6);
        this.u = frameLayout2;
        this.v = frameLayout;
        this.s = frameLayout4;
        this.t = frameLayout5;
        this.y = frameLayout6;
    }

    public final void b() {
        double d;
        double d2;
        LinearLayout linearLayout;
        if (this.f) {
            d = this.c;
            d2 = 0.775d;
        } else {
            d = this.c;
            d2 = 0.675d;
        }
        float f = (float) (d * d2);
        this.z[1] = (int) f;
        LinearLayout linearLayoutA = a(a(this.c), a(f), 1.0f, 1);
        LinearLayout linearLayoutA2 = a(-1, 0, 243.0f, 0);
        View view = null;
        if (this.f) {
            LinearLayout linearLayoutA3 = a(-1, 0, 36.0f, 0);
            a(linearLayoutA3, f.g.b, 0.0f, 0.0f, 0.0f, 0.0f);
            LinearLayout linearLayoutA4 = a(0, -1, 12.0f, 1);
            LinearLayout linearLayoutB = b(0, -1, 336.0f, 1);
            a.a(linearLayoutA3, linearLayoutA4, linearLayoutB, a(0, -1, 12.0f, 1));
            linearLayout = linearLayoutB;
            view = linearLayoutA3;
        } else {
            linearLayout = null;
        }
        linearLayoutA.addView(linearLayoutA2);
        if (this.f && view != null) {
            linearLayoutA.addView(view);
            this.o = linearLayout;
        }
        LinearLayout linearLayoutA5 = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA6 = a(0, -1, 336.0f, 1);
        a.a(linearLayoutA2, linearLayoutA5, linearLayoutA6, a(0, -1, 12.0f, 1));
        View viewA = a(-1, 0, 12.0f, 1);
        LinearLayout linearLayoutA7 = a(-1, 0, 209.0f, 1);
        a(linearLayoutA7, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayoutA7.addView(frameLayout);
        c(false);
        View viewA2 = a(-1, 0, 12.0f, 1);
        LinearLayout linearLayoutA8 = a(-1, 0, 24.0f, 0);
        View viewA3 = a(-1, 0, 12.0f, 1);
        linearLayoutA6.addView(viewA);
        linearLayoutA6.addView(linearLayoutA7);
        linearLayoutA6.addView(viewA2);
        linearLayoutA6.addView(linearLayoutA8);
        linearLayoutA6.addView(viewA3);
        View viewA4 = a(0, -1, 42.0f, 1);
        View viewA5 = a(0, -1, 8.0f, 1);
        View viewB = b(0, -1, 174.0f, 1);
        View viewA6 = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA9 = a(0, -1, 80.0f, 1);
        LinearLayout linearLayoutA10 = a(0, -1, 6.0f, 1);
        LinearLayout linearLayoutA11 = a(0, -1, 20.0f, 1);
        linearLayoutA8.addView(viewA4);
        linearLayoutA8.addView(viewA5);
        linearLayoutA8.addView(viewB);
        linearLayoutA8.addView(viewA6);
        a.a(linearLayoutA8, linearLayoutA9, linearLayoutA10, linearLayoutA11);
        this.g = linearLayoutA;
        this.h = frameLayout;
        this.j = viewB;
        this.k = linearLayoutA9;
        this.l = linearLayoutA11;
        this.m = viewA4;
    }

    public final void a() {
        double d;
        double d2;
        float f;
        float f2;
        float f3;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (this.f) {
            d = this.c;
            d2 = 0.53d;
        } else {
            d = this.c;
            d2 = 0.43d;
        }
        float f4 = (float) (d * d2);
        if ((a(f4) * 0.9d) / 16.0d <= this.e) {
            f4 += 25.0f;
            f = 49.0f;
        } else {
            f = 24.0f;
        }
        this.z[1] = (int) f4;
        LinearLayout linearLayoutA = a(a(this.c), a(f4), 1.0f, 1);
        LinearLayout linearLayoutA2 = a(-1, 0, 181.0f, 0);
        View view = null;
        if (this.f) {
            LinearLayout linearLayoutA3 = a(-1, 0, 36.0f, 0);
            f2 = 12.0f;
            a(linearLayoutA3, f.g.b, 0.0f, 0.0f, 0.0f, 0.0f);
            LinearLayout linearLayoutA4 = a(0, -1, 12.0f, 1);
            f3 = 336.0f;
            LinearLayout linearLayoutB = b(0, -1, 336.0f, 1);
            a.a(linearLayoutA3, linearLayoutA4, linearLayoutB, a(0, -1, 12.0f, 1));
            linearLayout = linearLayoutB;
            view = linearLayoutA3;
        } else {
            f2 = 12.0f;
            f3 = 336.0f;
            linearLayout = null;
        }
        linearLayoutA.addView(linearLayoutA2);
        if (this.f && view != null) {
            linearLayoutA.addView(view);
            this.o = linearLayout;
        }
        LinearLayout linearLayoutA5 = a(0, -1, f2, 1);
        LinearLayout linearLayoutA6 = a(0, -1, f3, 1);
        a.a(linearLayoutA2, linearLayoutA5, linearLayoutA6, a(0, -1, f2, 1));
        View viewA = a(-1, 0, f2, 1);
        View viewA2 = a(-1, 0, f, 1);
        View viewA3 = a(-1, 0, f2, 1);
        LinearLayout linearLayoutA7 = a(-1, 0, 72.0f, 0);
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayoutA7.addView(frameLayout);
        LinearLayout linearLayoutA8 = a(-1, -1, 1.0f, 0);
        LinearLayout linearLayoutA9 = a(-1, 0, f2, 1);
        LinearLayout linearLayoutA10 = a(-1, 0, 24.0f, 0);
        LinearLayout linearLayoutA11 = a(-1, 0, f2, 1);
        linearLayoutA6.addView(viewA);
        linearLayoutA6.addView(viewA2);
        linearLayoutA6.addView(viewA3);
        linearLayoutA6.addView(linearLayoutA7);
        a.a(linearLayoutA6, linearLayoutA9, linearLayoutA10, linearLayoutA11);
        if (this.d == 2) {
            LinearLayout linearLayoutA12 = a(0, -1, 166.0f, 1);
            linearLayout2 = linearLayoutA10;
            a(linearLayoutA12, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
            FrameLayout frameLayout2 = new FrameLayout(this.b);
            frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            linearLayoutA12.addView(frameLayout2);
            LinearLayout linearLayoutA13 = a(0, -1, 4.0f, 1);
            LinearLayout linearLayoutA14 = a(0, -1, 166.0f, 1);
            a(linearLayoutA14, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
            FrameLayout frameLayout3 = new FrameLayout(this.b);
            frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            linearLayoutA14.addView(frameLayout3);
            a.a(linearLayoutA8, linearLayoutA12, linearLayoutA13, linearLayoutA14);
            this.p = frameLayout2;
            this.q = frameLayout3;
        } else {
            linearLayout2 = linearLayoutA10;
            LinearLayout linearLayoutA15 = a(0, -1, 109.0f, 1);
            a(linearLayoutA15, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
            FrameLayout frameLayout4 = new FrameLayout(this.b);
            frameLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            linearLayoutA15.addView(frameLayout4);
            View viewA4 = a(0, -1, 4.0f, 1);
            LinearLayout linearLayoutA16 = a(0, -1, 109.0f, 1);
            a(linearLayoutA16, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
            FrameLayout frameLayout5 = new FrameLayout(this.b);
            frameLayout5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            linearLayoutA16.addView(frameLayout5);
            View viewA5 = a(0, -1, 4.0f, 1);
            LinearLayout linearLayoutA17 = a(0, -1, 109.0f, 1);
            a(linearLayoutA17, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
            FrameLayout frameLayout6 = new FrameLayout(this.b);
            frameLayout6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            linearLayoutA17.addView(frameLayout6);
            linearLayoutA8.addView(linearLayoutA15);
            linearLayoutA8.addView(viewA4);
            linearLayoutA8.addView(linearLayoutA16);
            linearLayoutA8.addView(viewA5);
            linearLayoutA8.addView(linearLayoutA17);
            this.p = frameLayout4;
            this.q = frameLayout5;
            this.r = frameLayout6;
        }
        frameLayout.addView(linearLayoutA8);
        View viewA6 = a(0, -1, 42.0f, 1);
        View viewA7 = a(0, -1, 8.0f, 1);
        View viewB = b(0, -1, 174.0f, 1);
        View viewA8 = a(0, -1, 12.0f, 1);
        LinearLayout linearLayoutA18 = a(0, -1, 80.0f, 1);
        LinearLayout linearLayoutA19 = a(0, -1, 6.0f, 1);
        LinearLayout linearLayoutA20 = a(0, -1, 20.0f, 1);
        LinearLayout linearLayout3 = linearLayout2;
        linearLayout3.addView(viewA6);
        linearLayout3.addView(viewA7);
        linearLayout3.addView(viewB);
        linearLayout3.addView(viewA8);
        a.a(linearLayout3, linearLayoutA18, linearLayoutA19, linearLayoutA20);
        this.h = frameLayout;
        this.g = linearLayoutA;
        this.i = viewA2;
        this.j = viewB;
        this.k = linearLayoutA18;
        this.l = linearLayoutA20;
        this.m = viewA6;
    }

    public final LinearLayout b(int i, int i2, float f, int i3) {
        if (this.b == null) {
            int i4 = l.a;
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2, f);
        linearLayout.setOrientation(i3);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor(f.g.a));
        return linearLayout;
    }

    public View a(int i, int i2, Shake shake, c.b bVar) {
        if (i == 1) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setBackgroundColor(Color.parseColor("#42000000"));
            int iA = a((float) (this.c * 0.2d));
            FrameLayout frameLayout2 = new FrameLayout(this.b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = 17;
            frameLayout2.setLayoutParams(layoutParams);
            com.alliance.ssp.ad.l.c cVar = new com.alliance.ssp.ad.l.c(this.b, i2, (int) (this.c * 0.2d), shake, bVar);
            this.A = cVar;
            frameLayout2.addView(cVar.h);
            ImageView imageView = new ImageView(this.b);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a((float) (this.c * 0.117d)), a((float) (this.c * 0.05d)));
            layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
            imageView.setLayoutParams(layoutParams2);
            imageView.setImageResource(R.drawable.nmadssp_logo_ad);
            frameLayout.addView(frameLayout2);
            frameLayout.addView(imageView);
            return frameLayout;
        }
        if (i != 2) {
            if (i != 3) {
                return null;
            }
            FrameLayout frameLayout3 = new FrameLayout(this.b);
            frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout3.setBackgroundColor(Color.parseColor("#42000000"));
            int iA2 = a((float) (this.c * 0.2d));
            FrameLayout frameLayout4 = new FrameLayout(this.b);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams3.gravity = 17;
            frameLayout4.setLayoutParams(layoutParams3);
            com.alliance.ssp.ad.l.c cVar2 = new com.alliance.ssp.ad.l.c(this.b, i2, (int) (this.c * 0.2d), shake, bVar);
            this.A = cVar2;
            frameLayout4.addView(cVar2.h);
            frameLayout3.addView(frameLayout4);
            return frameLayout3;
        }
        FrameLayout frameLayout5 = new FrameLayout(this.b);
        frameLayout5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout5.setBackgroundColor(Color.parseColor("#42000000"));
        int iA3 = a((float) (this.c * 0.25d));
        FrameLayout frameLayout6 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iA3, iA3);
        layoutParams4.gravity = 81;
        layoutParams4.setMargins(0, 0, 0, a((float) (this.c * 0.2d)));
        frameLayout6.setLayoutParams(layoutParams4);
        com.alliance.ssp.ad.l.c cVar3 = new com.alliance.ssp.ad.l.c(this.b, i2, (int) (this.c * 0.25d), shake, bVar);
        this.A = cVar3;
        frameLayout6.addView(cVar3.h);
        frameLayout5.addView(frameLayout6);
        FrameLayout frameLayout7 = new FrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a((float) (this.c * 0.4d)), a((float) (this.c * 0.07d)));
        layoutParams5.gravity = 81;
        layoutParams5.setMargins(0, 0, 0, a((float) (this.c * 0.13d)));
        frameLayout7.setLayoutParams(layoutParams5);
        float f = (float) (this.c * 0.03d);
        a(frameLayout7, "#80000000", f, f, f, f);
        TextView textView = new TextView(this.b);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 17;
        textView.setText("跳转详情页或下载APP");
        textView.setTextSize(10.0f);
        int i3 = this.c;
        if (i3 <= 180) {
            textView.setTextSize(7.0f);
        } else if (i3 <= 240) {
            textView.setTextSize(8.0f);
        } else if (i3 <= 300) {
            textView.setTextSize(9.0f);
        }
        textView.setTextColor(Color.parseColor("#ffffffff"));
        frameLayout7.addView(textView, layoutParams6);
        frameLayout5.addView(frameLayout7);
        int i4 = this.a;
        if (i4 != 2 && i4 != 3) {
            ImageView imageView2 = new ImageView(this.b);
            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(a((float) (this.c * 0.117d)), a((float) (this.c * 0.05d)));
            layoutParams7.gravity = BadgeDrawable.BOTTOM_START;
            layoutParams7.setMargins(a(8.0f), 0, 0, a(8.0f));
            imageView2.setLayoutParams(layoutParams7);
            imageView2.setImageResource(R.drawable.nmadssp_logo_ad);
            frameLayout5.addView(imageView2);
        }
        return frameLayout5;
    }

    public final int a(float f) {
        Context context = this.b;
        if (context == null) {
            int i = l.a;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }

    public final LinearLayout a(int i, int i2, float f, int i3) {
        if (this.b == null) {
            int i4 = l.a;
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2, f);
        linearLayout.setOrientation(i3);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor(f.g.a));
        return linearLayout;
    }

    public final void a(View view, String str, float f, float f2, float f3, float f4) {
        if (view == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{a(f), a(f), a(f2), a(f2), a(f3), a(f3), a(f4), a(f4)});
        view.setBackground(gradientDrawable);
    }

    public void a(View view, Bitmap bitmap) {
        Bitmap bitmapA;
        if (this.b == null || view == null || bitmap == null || (bitmapA = d.a(bitmap, 10.0f)) == null) {
            return;
        }
        ImageView imageView = new ImageView(this.b);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bitmapA);
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#38FFFFFF"));
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.addView(imageView);
        viewGroup.addView(frameLayout);
    }
}
