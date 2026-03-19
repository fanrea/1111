package com.qq.e.comm.plugin;

import android.app.Dialog;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class we extends Dialog {
    Context a;
    private LinearLayout b;
    private jm c;
    private double d;
    private double e;
    private double f;
    private int g;
    private int h;
    private double i;
    private int j;
    private int m;
    private boolean n;
    private boolean o;

    public we(Context context) {
        super(context);
        this.d = 0.8d;
        this.e = 1.0d;
        this.f = 0.095d;
        this.i = 0.8d;
        this.n = false;
        this.o = true;
        this.a = context;
    }

    private void c() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.b = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.b.setOrientation(1);
        this.b.setBackgroundColor(-1);
        setContentView(this.b);
        jm jmVarA = new qh(this.a).a();
        this.c = jmVarA;
        jmVarA.a().setLayerType(1, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
        int i = this.h;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
        layoutParams2.gravity = 83;
        imageView.setLayoutParams(layoutParams2);
        FrameLayout frameLayout = new FrameLayout(this.a);
        int i2 = this.g;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, i2);
        layoutParams3.gravity = 5;
        frameLayout.setLayoutParams(layoutParams3);
        frameLayout.setBackgroundColor(-1);
        frameLayout.addView(imageView);
        this.b.addView(frameLayout);
        this.b.addView(this.c.a(), layoutParams);
        frameLayout.setOnClickListener(new a());
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            we.this.cancel();
        }
    }

    private void a() {
        b();
        c();
        setCanceledOnTouchOutside(this.n);
        setCancelable(this.o);
    }

    private void d() {
        try {
            show();
            Window window = getWindow();
            if (window != null) {
                window.setLayout(this.j, this.m);
            }
        } catch (Exception unused) {
        }
    }

    private void b() {
        Pair<Integer, Integer> pairB = pa.b();
        double dMin = Math.min(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
        double d = this.d;
        Double.isNaN(dMin);
        int i = (int) (dMin * d);
        this.j = i;
        double d2 = i;
        double d3 = this.e;
        Double.isNaN(d2);
        this.m = (int) (d3 * d2);
        double d4 = this.f;
        Double.isNaN(d2);
        int i2 = (int) (d2 * d4);
        this.g = i2;
        double d5 = i2;
        double d6 = this.i;
        Double.isNaN(d5);
        this.h = (int) (d5 * d6);
    }

    public void b(String str) {
        a();
        a(str);
        d();
    }

    private void a(String str) {
        this.c.loadUrl(str);
    }
}
