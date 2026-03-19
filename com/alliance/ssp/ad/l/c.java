package com.alliance.ssp.ad.l;

import android.content.Context;
import android.hardware.SensorManager;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.bean.Shake;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.utils.ShakeDetector;
import java.util.concurrent.TimeUnit;

/* compiled from: ShakeDecoratorNew.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public ShakeDetector a = null;
    public SensorManager b = null;
    public ShakeDetector.a c = null;
    public Shake d;
    public Double e;
    public Double f;
    public Double g;
    public View h;
    public Context i;
    public int j;
    public b k;

    /* compiled from: ShakeDecoratorNew.java */
    public class a implements ShakeDetector.a {
        public a() {
        }
    }

    /* compiled from: ShakeDecoratorNew.java */
    public interface b {
        void a(int[] iArr);
    }

    public c(Context context, int i, int i2, Shake shake, b bVar) {
        this.i = context;
        this.j = a(i2);
        this.d = shake;
        this.k = bVar;
        if (i == 1) {
            c();
        } else if (i == 2) {
            d();
        } else {
            if (i != 3) {
                return;
            }
            e();
        }
    }

    public static void b(final View view, final AnimationSet animationSet) {
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.l.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                view.startAnimation(animationSet);
            }
        });
    }

    public final void c() {
        FrameLayout frameLayout = new FrameLayout(this.i);
        int i = this.j;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(this.i);
        imageView.setImageResource(R.drawable.nmadssp_icon_shake_background);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(this.i);
        int i2 = (int) (this.j * 0.435d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (this.j * 0.37d);
        imageView2.setLayoutParams(layoutParams);
        imageView2.setImageResource(R.drawable.nmadssp_icon_shake);
        frameLayout.addView(imageView);
        frameLayout.addView(imageView2);
        this.h = frameLayout;
        a(imageView2);
    }

    public final void d() {
        FrameLayout frameLayout = new FrameLayout(this.i);
        int i = this.j;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(this.i);
        int i2 = (int) (this.j * 0.435d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (this.j * 0.37d);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.nmadssp_icon_shake);
        TextView textView = new TextView(this.i);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        textView.setTextColor(-1);
        textView.setText("摇一摇");
        textView.setTextSize(12.0f);
        int i3 = this.j;
        if (i3 <= 180) {
            textView.setTextSize(9.0f);
        } else if (i3 <= 240) {
            textView.setTextSize(10.0f);
        } else if (i3 <= 300) {
            textView.setTextSize(11.0f);
        }
        layoutParams2.bottomMargin = (int) (this.j * 0.12d);
        textView.setLayoutParams(layoutParams2);
        frameLayout.addView(imageView);
        frameLayout.addView(textView);
        this.h = frameLayout;
        a(imageView);
    }

    public final void e() {
        FrameLayout frameLayout = new FrameLayout(this.i);
        int i = this.j;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(this.i);
        double d = this.j;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (0.746d * d), (int) (d * 0.259d));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (this.j * 0.545d);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.nmadssp_shake_arr);
        ImageView imageView2 = new ImageView(this.i);
        double d2 = this.j;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (0.272d * d2), (int) (d2 * 0.428d));
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = (int) (this.j * 0.454d);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setImageResource(R.drawable.nmadssp_shake_mobile);
        ImageView imageView3 = new ImageView(this.i);
        int i2 = this.j;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i2, (int) (i2 * 0.337d));
        layoutParams3.gravity = 81;
        imageView3.setLayoutParams(layoutParams3);
        imageView3.setImageResource(R.drawable.nmadssp_shake_white_text);
        frameLayout.addView(imageView);
        frameLayout.addView(imageView2);
        frameLayout.addView(imageView3);
        this.h = frameLayout;
        a(imageView2);
    }

    public void f() {
        ShakeDetector shakeDetector = this.a;
        if (shakeDetector != null) {
            shakeDetector.b();
            SensorManager sensorManager = this.b;
            if (sensorManager != null) {
                sensorManager.registerListener(this.a, sensorManager.getDefaultSensor(1), 3);
                SensorManager sensorManager2 = this.b;
                sensorManager2.registerListener(this.a, sensorManager2.getDefaultSensor(4), 3);
            }
        }
    }

    public void g() {
        ShakeDetector shakeDetector;
        SensorManager sensorManager = this.b;
        if (sensorManager == null || (shakeDetector = this.a) == null) {
            return;
        }
        sensorManager.unregisterListener(shakeDetector);
        this.b = null;
        this.a = null;
    }

    public void a() {
        ShakeDetector shakeDetector = this.a;
        if (shakeDetector != null) {
            shakeDetector.a();
            SensorManager sensorManager = this.b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.a);
            }
        }
    }

    public void b() {
        Shake shake;
        if (this.i != null && (shake = this.d) != null && this.k != null) {
            double d = shake.acceleration;
            double d2 = shake.rotationAngle;
            double d3 = shake.operationTime;
            int i = com.alliance.ssp.ad.o0.l.a;
            Double dValueOf = Double.valueOf(d);
            this.e = dValueOf;
            if (dValueOf == null) {
                this.e = Double.valueOf(15.0d);
            }
            Double dValueOf2 = Double.valueOf(this.d.rotationAngle);
            this.f = dValueOf2;
            if (dValueOf2 == null) {
                this.f = Double.valueOf(25.0d);
            }
            Double dValueOf3 = Double.valueOf(this.d.operationTime);
            this.g = dValueOf3;
            if (dValueOf3 == null) {
                this.g = Double.valueOf(2000.0d);
            } else {
                this.g = Double.valueOf(dValueOf3.doubleValue() * 1000.0d);
            }
            a aVar = new a();
            this.c = aVar;
            this.a = new ShakeDetector(aVar, this.i, this.e.doubleValue(), this.f.doubleValue(), this.g.doubleValue());
            SensorManager sensorManager = (SensorManager) this.i.getSystemService("sensor");
            this.b = sensorManager;
            if (sensorManager != null) {
                try {
                    sensorManager.registerListener(this.a, sensorManager.getDefaultSensor(1), 3);
                    SensorManager sensorManager2 = this.b;
                    sensorManager2.registerListener(this.a, sensorManager2.getDefaultSensor(4), 3);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        int i2 = com.alliance.ssp.ad.o0.l.a;
    }

    public void a(double d, double d2, double d3) {
        SensorManager sensorManager;
        int i = com.alliance.ssp.ad.o0.l.a;
        ShakeDetector shakeDetector = this.a;
        if (shakeDetector == null || (sensorManager = this.b) == null || this.c == null || this.i == null) {
            return;
        }
        sensorManager.unregisterListener(shakeDetector);
        ShakeDetector shakeDetector2 = new ShakeDetector(this.c, this.i, d, d2, d3);
        this.a = shakeDetector2;
        SensorManager sensorManager2 = this.b;
        sensorManager2.registerListener(shakeDetector2, sensorManager2.getDefaultSensor(1), 3);
        SensorManager sensorManager3 = this.b;
        sensorManager3.registerListener(this.a, sensorManager3.getDefaultSensor(4), 3);
    }

    public void a(final View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setStartOffset(0L);
        RotateAnimation rotateAnimation2 = new RotateAnimation(20.0f, -20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation2.setDuration(300L);
        rotateAnimation2.setStartOffset(150L);
        RotateAnimation rotateAnimation3 = new RotateAnimation(-20.0f, 20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation3.setDuration(300L);
        rotateAnimation3.setStartOffset(450L);
        RotateAnimation rotateAnimation4 = new RotateAnimation(20.0f, -20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation4.setDuration(300L);
        rotateAnimation4.setStartOffset(750L);
        RotateAnimation rotateAnimation5 = new RotateAnimation(-20.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation5.setDuration(150L);
        rotateAnimation5.setStartOffset(1050L);
        final AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(rotateAnimation2);
        animationSet.addAnimation(rotateAnimation3);
        animationSet.addAnimation(rotateAnimation4);
        animationSet.addAnimation(rotateAnimation5);
        n.d.b.scheduleAtFixedRate(new Runnable() { // from class: com.alliance.ssp.ad.l.c$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                c.b(view, animationSet);
            }
        }, 400L, 1600L, TimeUnit.MILLISECONDS);
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
}
