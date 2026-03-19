package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.sy;
import com.bytedance.adsdk.lottie.tt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends h {
    private float gb;
    private LottieAnimationView mk;
    private tt.d.C0170d mq;
    private VideoFrame tc;
    private float tt;

    public u(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, Context context, tt.d.C0170d c0170d) {
        super(gbVar, gbVar2);
        this.gb = -1.0f;
        this.tt = -1.0f;
        this.mq = c0170d;
        if (this.h == null || gbVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewHc = gbVar.hc();
        this.mk = lottieAnimationViewHc;
        if (lottieAnimationViewHc == null) {
            return;
        }
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        this.gb = (int) (this.h.d() * fD);
        this.tt = (int) (this.h.hc() * fD);
        sy syVarD = gbVar.d();
        View viewD = syVarD != null ? syVarD.d("videoview:", null) : null;
        if (viewD instanceof TextureView) {
            this.tc = new VideoFrame(context, (TextureView) viewD, c0170d);
        }
        this.mk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.u.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (u.this.mk == view) {
                    u.this.k();
                }
            }
        });
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        VideoFrame videoFrame = this.tc;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tc);
            }
            ViewParent parent2 = this.mk.getParent();
            if (parent2 instanceof ViewGroup) {
                this.tc.setTranslationX(2.1474836E9f);
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
        this.tc.draw(canvas);
        canvas.restore();
    }

    private static void d(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
