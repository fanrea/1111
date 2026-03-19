package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.jh;
import com.bytedance.adsdk.lottie.u.hc;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends h {
    private float gb;
    private final Runnable k;
    private Drawable mk;
    private LottieAnimationView mq;
    private ImageView tc;
    private float tt;
    private final Handler uo;

    public d(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, Context context) {
        super(gbVar, gbVar2);
        this.gb = -1.0f;
        this.tt = -1.0f;
        this.uo = new Handler(Looper.getMainLooper());
        this.k = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mq != null && d.this.mq.u()) {
                    d.this.mq.invalidate();
                }
                d.this.uo.postDelayed(d.this.k, 40L);
            }
        };
        if (this.h == null || gbVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewHc = gbVar.hc();
        this.mq = lottieAnimationViewHc;
        if (lottieAnimationViewHc == null) {
            return;
        }
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        this.gb = (int) (this.h.d() * fD);
        this.tt = (int) (this.h.hc() * fD);
        jh jhVarYi = gbVar.yi();
        String strD = jhVarYi != null ? jhVarYi.d(this.h.mq()) : null;
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.tc = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.tc.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.d.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (d.this.tc == view) {
                    d.this.cb();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (d.this.tc == view) {
                    d.this.k();
                    if (Build.VERSION.SDK_INT < 28 || !(d.this.mk instanceof AnimatedImageDrawable)) {
                        return;
                    }
                    ((AnimatedImageDrawable) d.this.mk).stop();
                }
            }
        });
        this.mq.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.d.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (d.this.mq == view) {
                    if (d.this.hc()) {
                        d.this.mq.removeOnAttachStateChangeListener(this);
                    } else {
                        d.this.d(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.w();
                            }
                        });
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (d.this.mq == view) {
                    d.this.d(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.d.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent = d.this.tc.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(d.this.tc);
                            }
                        }
                    });
                }
            }
        });
        d(strD, context);
    }

    private void d(String str, Context context) {
        File file = new File(com.bytedance.adsdk.lottie.u.hc.d(context), com.bytedance.sdk.component.utils.u.hc(str));
        if (file.exists()) {
            d(file);
        } else {
            com.bytedance.adsdk.lottie.u.hc.d(str, context, new hc.d<File>() { // from class: com.bytedance.adsdk.lottie.model.layer.d.3
                @Override // com.bytedance.adsdk.lottie.u.hc.d
                public void d(File file2) {
                    d.this.d(file2);
                }

                @Override // com.bytedance.adsdk.lottie.u.hc.d
                public void d(int i, String str2) {
                    com.bytedance.sdk.component.utils.mq.d("TMe", "--==--- webp: " + i + ", " + str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(File file) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable drawable = this.mk;
                if (drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).stop();
                }
                this.mk = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.uo.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.w();
                    }
                });
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.uo.removeCallbacksAndMessages(null);
    }

    private void e() {
        k();
        if (this.mq != null) {
            this.uo.postDelayed(this.k, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        if (Build.VERSION.SDK_INT >= 28) {
            Drawable drawable = this.mk;
            if (!(drawable instanceof AnimatedImageDrawable) || ((AnimatedImageDrawable) drawable).isRunning()) {
                return;
            }
            ((AnimatedImageDrawable) this.mk).setRepeatCount(-1);
            ((AnimatedImageDrawable) this.mk).start();
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.mk != null) {
            ViewParent parent = this.tc.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tc);
            }
            ViewParent parent2 = this.mq.getParent();
            if (parent2 instanceof ViewGroup) {
                this.tc.setTranslationX(2.1474836E9f);
                this.tc.setImageDrawable(this.mk);
                ((ViewGroup) parent2).addView(this.tc);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.h, com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        if (this.gb <= 0.0f || this.tc == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        d(i);
        float fGb = gb();
        d(this.tc, (int) this.gb, (int) this.tt);
        this.tc.setAlpha(fGb);
        canvas.clipRect(0.0f, 0.0f, this.gb, this.tt);
        this.tc.draw(canvas);
        canvas.restore();
    }

    private static void d(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
