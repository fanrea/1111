package com.alliance.ssp.ad.l;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.o0.n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SwipeDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class k {
    public Context a;
    public int b;
    public boolean c;
    public b d;
    public FrameLayout e;
    public TextView f;
    public TextView g;
    public AnimatorSet h;
    public GestureDetector i;

    /* compiled from: SwipeDecorator.java */
    public interface b {
    }

    /* compiled from: SwipeDecorator.java */
    public class c extends GestureDetector.SimpleOnGestureListener {

        /* compiled from: SwipeDecorator.java */
        public class a implements View.OnTouchListener {
            public a(k kVar) {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return k.this.i.onTouchEvent(motionEvent);
            }
        }

        public c(View view) {
            k.this.i = new GestureDetector(k.this.a, this);
            view.setClickable(true);
            view.setOnTouchListener(new a(k.this));
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            k kVar;
            b bVar;
            if ((f <= 30.0f && f >= -30.0f && f2 <= 30.0f && f2 >= -30.0f) || (bVar = (kVar = k.this).d) == null) {
                return true;
            }
            ((NMSplashAdImpl.a) bVar).a(kVar.e, motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY());
            return true;
        }
    }

    public k(Context context, int i, int i2, boolean z, b bVar) {
        this.a = context;
        this.b = i2;
        this.c = z;
        this.d = bVar;
        if (i != 1) {
            return;
        }
        a();
    }

    public static void a(k kVar, float f, List list, int i) {
        kVar.getClass();
        ImageView imageView = (ImageView) list.get(0);
        ImageView imageView2 = (ImageView) list.get(1);
        ImageView imageView3 = (ImageView) list.get(2);
        ImageView imageView4 = (ImageView) list.get(3);
        if (i == 1) {
            if (0.0f < f && f < 10.0f) {
                imageView.setAlpha(0.3f);
                return;
            }
            if (10.0f < f && f < 20.0f) {
                imageView2.setAlpha(0.6f);
                return;
            } else {
                if (20.0f >= f || f >= 30.0f) {
                    return;
                }
                imageView3.setAlpha(0.9f);
                return;
            }
        }
        if (i == 2) {
            if (0.0f < f && f < 10.0f) {
                imageView.setAlpha(0.0f);
                return;
            }
            if (10.0f < f && f < 20.0f) {
                imageView2.setAlpha(0.0f);
                return;
            } else {
                if (20.0f >= f || f >= 30.0f) {
                    return;
                }
                imageView3.setAlpha(0.0f);
                return;
            }
        }
        if (i == 3) {
            if (0.0f < f && f < 10.0f) {
                imageView4.setAlpha(0.9f);
                return;
            }
            if (10.0f < f && f < 20.0f) {
                imageView3.setAlpha(0.6f);
                return;
            } else {
                if (20.0f >= f || f >= 30.0f) {
                    return;
                }
                imageView2.setAlpha(0.3f);
                return;
            }
        }
        if (i != 4) {
            return;
        }
        if (0.0f < f && f < 10.0f) {
            imageView2.setAlpha(0.0f);
            return;
        }
        if (10.0f < f && f < 20.0f) {
            imageView3.setAlpha(0.0f);
        } else {
            if (20.0f >= f || f >= 30.0f) {
                return;
            }
            imageView4.setAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.h.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.h.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.h.resume();
    }

    public void b() {
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.l.k$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
    }

    public void f() {
        if (Build.VERSION.SDK_INT >= 19) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.l.k$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d();
                }
            });
        }
    }

    public void g() {
        if (Build.VERSION.SDK_INT >= 19) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.l.k$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            b bVar = this.d;
            if (bVar != null) {
                ((NMSplashAdImpl.a) bVar).a(this.e, motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }
        return this.i.onTouchEvent(motionEvent);
    }

    /* compiled from: SwipeDecorator.java */
    public class a extends View {
        public Paint a;
        public Paint b;
        public float c;
        public float d;

        public a(Context context) {
            super(context);
            this.c = 0.0f;
            this.d = 30.0f;
            a();
        }

        public final int a(float f) {
            Context context = k.this.a;
            if (context == null) {
                int i = com.alliance.ssp.ad.o0.l.a;
            } else {
                f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
            }
            return (int) f;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();
            double d = width;
            double d2 = 0.1d * d;
            float fA = a(this.c) * 1.0f;
            float f = (float) (((this.d + d2) - fA) + d2);
            Path path = new Path();
            float f2 = height;
            path.moveTo(-2.0f, f2);
            path.lineTo(-2.0f, f);
            float f3 = width + 2;
            path.quadTo(width / 2, (-(this.d + fA)) + ((float) (d * 0.06d)), f3, f);
            path.lineTo(f3, f2);
            path.close();
            canvas.drawPath(path, this.a);
            canvas.drawPath(path, this.b);
        }

        public final void a() {
            Paint paint = new Paint(1);
            this.a = paint;
            paint.setColor(Color.parseColor("#53000000"));
            Paint paint2 = new Paint(1);
            this.b = paint2;
            paint2.setColor(-1);
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setStrokeWidth(a(2.0f));
        }
    }

    public final void a() {
        float f = (float) (this.b * 0.875d);
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(this.b), a(f));
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        frameLayout2.addView(linearLayout);
        new c(frameLayout);
        LinearLayout linearLayoutA = a(-1, 0, 74.0f, 1);
        FrameLayout frameLayout3 = new FrameLayout(this.a);
        frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        int i = (int) (this.b * 0.03d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(0, frameLayout3));
        arrayList.add(a(i, frameLayout3));
        arrayList.add(a(i * 2, frameLayout3));
        arrayList.add(a(i * 3, frameLayout3));
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.a.getResources(), R.drawable.nmadssp_hands_swipe));
        frameLayout3.addView(imageView);
        linearLayoutA.addView(frameLayout3);
        LinearLayout linearLayoutA2 = a(-1, 0, 237.0f, 1);
        linearLayout.addView(linearLayoutA);
        linearLayout.addView(linearLayoutA2);
        FrameLayout frameLayout4 = new FrameLayout(this.a);
        frameLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        a aVar = new a(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a(this.b), a((float) (f * 0.67d)));
        layoutParams2.gravity = 80;
        aVar.setLayoutParams(layoutParams2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 30.0f);
        valueAnimatorOfFloat.setDuration(800L);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new e(this, aVar, imageView, arrayList));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(30.0f, 0.0f);
        valueAnimatorOfFloat2.setDuration(800L);
        valueAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new f(this, aVar, arrayList));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 30.0f);
        valueAnimatorOfFloat3.setDuration(200L);
        valueAnimatorOfFloat3.addUpdateListener(new g(this, arrayList));
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(0.0f, 30.0f);
        valueAnimatorOfFloat3.setDuration(200L);
        valueAnimatorOfFloat4.addListener(new h(this, imageView));
        valueAnimatorOfFloat4.addUpdateListener(new i(this, arrayList));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat4, valueAnimatorOfFloat2, valueAnimatorOfFloat3);
        this.h.addListener(new j(this));
        this.h.start();
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams3.bottomMargin = a((float) (this.b * 0.25d));
        linearLayout2.setLayoutParams(layoutParams3);
        TextView textView = new TextView(this.a);
        this.f = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f.setText("划一划");
        this.f.setTextColor(-1);
        this.f.setGravity(17);
        this.f.setTextSize(18.0f);
        TextView textView2 = new TextView(this.a);
        this.g = textView2;
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.g.setText("跳转详情页或第三方应用");
        this.g.setTextColor(-1);
        this.g.setGravity(17);
        this.g.setTextSize(14.0f);
        linearLayout2.addView(this.f);
        linearLayout2.addView(this.g);
        frameLayout4.addView(aVar);
        frameLayout4.addView(linearLayout2);
        linearLayoutA2.addView(frameLayout4);
        this.e = frameLayout;
        if (!this.c) {
            linearLayoutA2.setClickable(true);
            linearLayoutA2.setOnTouchListener(new View.OnTouchListener() { // from class: com.alliance.ssp.ad.l.k$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.a(view, motionEvent);
                }
            });
        } else {
            frameLayout2.setClickable(true);
            frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: com.alliance.ssp.ad.l.k$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.b(view, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            b bVar = this.d;
            if (bVar != null) {
                ((NMSplashAdImpl.a) bVar).a(this.e, motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }
        return this.i.onTouchEvent(motionEvent);
    }

    public final ImageView a(int i, FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.a.getResources(), R.drawable.nmadssp_up_arrow));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a((float) (this.b * 0.08d)), a((float) (this.b * 0.05d)));
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, a(i));
        imageView.setLayoutParams(layoutParams);
        imageView.setAlpha(0.0f);
        frameLayout.addView(imageView);
        return imageView;
    }

    public final int a(float f) {
        Context context = this.a;
        if (context == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }

    public final LinearLayout a(int i, int i2, float f, int i3) {
        LinearLayout.LayoutParams layoutParams;
        if (this.a == null) {
            int i4 = com.alliance.ssp.ad.o0.l.a;
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(this.a);
        if (f > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams(i, i2, f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(i, i2);
        }
        linearLayout.setOrientation(i3);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }
}
