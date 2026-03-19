package com.alliance.ssp.ad.l;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alliance.ssp.ad.o0.n;

/* compiled from: CTABtnDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public int A;
    public String a;
    public String b;
    public String c;
    public String d;
    public Handler f;
    public int g;
    public Context i;
    public int j;
    public float k;
    public int l;
    public c m;
    public b n;
    public FrameLayout o;
    public ProgressBar p;
    public TextView q;
    public FrameLayout r;
    public FrameLayout s;
    public ProgressBar t;
    public TextView u;
    public FrameLayout v;
    public ProgressBar w;
    public TextView x;
    public volatile int z;
    public HandlerThread e = null;
    public int h = 0;
    public final Object y = new Object();

    /* compiled from: CTABtnDecorator.java */
    /* renamed from: com.alliance.ssp.ad.l.a$a, reason: collision with other inner class name */
    public class HandlerC0092a extends Handler {
        public HandlerC0092a(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            int i = a.this.z;
            a aVar = a.this;
            if (i == aVar.A) {
                return;
            }
            aVar.A = aVar.z;
            a aVar2 = a.this;
            aVar2.p.setProgress(100 - aVar2.z);
            a.this.q.setText(a.this.z + "%");
            a aVar3 = a.this;
            aVar3.t.setProgress(100 - aVar3.z);
            a.this.u.setText(a.this.z + "%");
            a aVar4 = a.this;
            aVar4.w.setProgress(100 - aVar4.z);
            a.this.x.setText(a.this.z + "%");
            if (a.this.z == 100 || a.this.z == -100) {
                a aVar5 = a.this;
                aVar5.q.setText(aVar5.b);
                a.this.u.setText("立即安装");
                a.this.x.setText("立即安装");
                a.this.getClass();
                a.this.h = 4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            a aVar = a.this;
            aVar.q.setText(aVar.d);
            a.this.u.setText("继续下载");
            a.this.x.setText("继续下载");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (a.this.y) {
                int i = message.what;
                if (i == 1) {
                    a aVar = a.this;
                    if (aVar.h == 3) {
                        return;
                    }
                    aVar.z = ((Integer) message.obj).intValue();
                    a.this.getClass();
                    a.this.h = 2;
                    n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.l.a$a$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a();
                        }
                    });
                } else if (i != 2) {
                    if (i == 3) {
                        a aVar2 = a.this;
                        if (aVar2.h == 3) {
                            aVar2.h = 2;
                        }
                    }
                } else if (a.this.h == 2) {
                    n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.l.a$a$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.b();
                        }
                    });
                    a.this.h = 3;
                }
            }
        }
    }

    /* compiled from: CTABtnDecorator.java */
    public interface b {
        void a(int i);
    }

    /* compiled from: CTABtnDecorator.java */
    public interface c {
        void a(int i, boolean z);
    }

    public a(Context context, float f, int i, int i2, c cVar) {
        this.a = "立即下载";
        this.b = "立即安装";
        this.c = "查看详情";
        this.d = "继续下载";
        this.g = 0;
        this.j = 0;
        this.k = 0.0f;
        this.l = 11;
        this.i = context;
        this.k = f;
        this.g = i;
        this.j = i2;
        this.m = cVar;
        c();
        if (f <= 180.0f) {
            this.l = 8;
        } else if (f <= 240.0f) {
            this.l = 9;
        } else if (f <= 300.0f) {
            this.l = 10;
        }
        int i3 = this.g;
        if (i3 == 1) {
            double d = f;
            a((float) (0.21d * d), (float) (0.06d * d), (float) (d * 0.03d));
            return;
        }
        if (i3 == 2) {
            this.a = "下载";
            this.b = "安装";
            this.c = "查看";
            this.d = "继续";
            double d2 = f;
            a((float) (0.14d * d2), (float) (0.05d * d2), (float) (d2 * 0.025d));
            return;
        }
        if (i3 == 3) {
            this.l = 16;
            double d3 = f;
            a(f, (float) (0.13d * d3), (float) (d3 * 0.017d));
        } else {
            if (i3 != 4) {
                if (i3 != 5) {
                    return;
                }
                this.l = 16;
                double d4 = f;
                a(f, (float) (0.2d * d4), (float) (d4 * 0.022d));
                return;
            }
            this.a = "下载";
            this.b = "安装";
            this.c = "查看";
            this.d = "继续";
            this.l = 14;
            double d5 = f;
            a(f, (float) (0.54d * d5), (float) (d5 * 0.077d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(this.h, true);
        }
    }

    public void a(float f, float f2, float f3) {
        if (this.i == null) {
            return;
        }
        this.o = new FrameLayout(this.i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(f), a(f2));
        layoutParams.gravity = 17;
        this.o.setLayoutParams(layoutParams);
        a(this.o, f3, "#FF265AE0");
        this.p = new ProgressBar(this.i, null, R.attr.progressBarStyleHorizontal);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, a(f2));
        layoutParams2.gravity = 17;
        this.p.setLayoutParams(layoutParams2);
        float fA = a(f3);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
        shapeDrawable.getPaint().setColor(Color.parseColor("#FF739AFF"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#00000000"));
        gradientDrawable.setCornerRadius(fA);
        this.p.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(shapeDrawable, 5, 1)}));
        this.q = new TextView(this.i);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.q.setTextSize(this.l);
        this.q.setTextColor(Color.parseColor("#ffffffff"));
        int i = this.j;
        if (i == 1) {
            this.q.setText(this.a);
            this.n = new b() { // from class: com.alliance.ssp.ad.l.a$$ExternalSyntheticLambda0
                @Override // com.alliance.ssp.ad.l.a.b
                public final void a(int i2) {
                    this.f$0.a(i2);
                }
            };
        } else if (i == 4) {
            this.q.setText(this.b);
        } else if (i != 5) {
            this.q.setText(this.c);
        } else {
            this.q.setText(this.c);
        }
        this.h = this.j;
        this.q.setGravity(17);
        this.o.addView(this.p);
        this.o.addView(this.q, layoutParams3);
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.l.a$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        double d = this.k;
        float f4 = (float) (0.22d * d);
        float f5 = (float) (0.06d * d);
        float f6 = (float) (d * 0.03d);
        if (this.i != null) {
            this.r = new FrameLayout(this.i);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(a(f4), a(f5));
            layoutParams4.gravity = 17;
            this.r.setLayoutParams(layoutParams4);
            a(this.r, f6, "#FF265AE0");
            TextView textView = new TextView(this.i);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 17;
            textView.setText("查看详情");
            textView.setTextSize(this.l);
            textView.setTextColor(Color.parseColor("#ffffffff"));
            this.r.addView(textView, layoutParams5);
        }
        a();
        b();
    }

    public final void c() {
        if (this.e == null) {
            this.e = new HandlerThread("CTABtnDecoratorHandlerThread");
        }
        this.e.start();
        Looper looper = this.e.getLooper();
        if (looper == null) {
            return;
        }
        this.f = new HandlerC0092a(looper);
    }

    public final void b() {
        if (this.i == null) {
            return;
        }
        this.v = new FrameLayout(this.i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.v.setLayoutParams(layoutParams);
        a(this.v, 8.0f, "#FF265AE0");
        this.w = new ProgressBar(this.i, null, R.attr.progressBarStyleHorizontal);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.w.setLayoutParams(layoutParams2);
        float fA = a(8.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
        shapeDrawable.getPaint().setColor(Color.parseColor("#FF739AFF"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#00000000"));
        gradientDrawable.setCornerRadius(fA);
        this.w.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(shapeDrawable, 5, 1)}));
        this.x = new TextView(this.i);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.x.setTextSize(20.0f);
        this.x.setTextColor(Color.parseColor("#ffffffff"));
        int i = this.h;
        if (i == 1) {
            this.x.setText("立即下载");
        } else if (i != 4) {
            this.x.setText("查看详情");
        } else {
            this.x.setText("立即安装");
        }
        this.v.addView(this.w);
        this.v.addView(this.x, layoutParams3);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.l.a$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(this.h, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Integer numValueOf = Integer.valueOf(i);
        Handler handler = this.f;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 1;
            if (numValueOf != null) {
                messageObtainMessage.obj = numValueOf;
            }
            this.f.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(this.h, false);
        }
    }

    public final void a() {
        if (this.i == null) {
            return;
        }
        this.s = new FrameLayout(this.i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.s.setLayoutParams(layoutParams);
        a(this.s, 8.0f, "#FF265AE0");
        this.t = new ProgressBar(this.i, null, R.attr.progressBarStyleHorizontal);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.t.setLayoutParams(layoutParams2);
        float fA = a(8.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
        shapeDrawable.getPaint().setColor(Color.parseColor("#FF739AFF"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#00000000"));
        gradientDrawable.setCornerRadius(fA);
        this.t.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(shapeDrawable, 5, 1)}));
        this.u = new TextView(this.i);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.u.setTextSize(20.0f);
        this.u.setTextColor(Color.parseColor("#ffffffff"));
        int i = this.h;
        if (i == 1) {
            this.u.setText("立即下载");
        } else if (i != 4) {
            this.u.setText("查看详情");
        } else {
            this.u.setText("立即安装");
        }
        this.s.addView(this.t);
        this.s.addView(this.u, layoutParams3);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.l.a$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
    }

    public final void a(View view, float f, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (!str.isEmpty()) {
            gradientDrawable.setColor(Color.parseColor(str));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(a(f));
        view.setBackground(gradientDrawable);
    }

    public final int a(float f) {
        Context context = this.i;
        if (context == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }

    public void a(boolean z) {
        if (z) {
            Handler handler = this.f;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage();
                messageObtainMessage.what = 2;
                this.f.sendMessage(messageObtainMessage);
                return;
            }
            return;
        }
        Handler handler2 = this.f;
        if (handler2 != null) {
            Message messageObtainMessage2 = handler2.obtainMessage();
            messageObtainMessage2.what = 3;
            this.f.sendMessage(messageObtainMessage2);
        }
    }
}
