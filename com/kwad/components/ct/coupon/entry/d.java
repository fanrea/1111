package com.kwad.components.ct.coupon.entry;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private volatile a anN;
    private Paint anO;
    private Paint anP;
    private com.kwad.components.ct.coupon.entry.a anW;
    private final CouponEntryProgress anv;
    private final Context mContext;
    private float mRadius = 0.0f;
    private int anQ = 0;
    private int anR = 100;
    private int anS = 2;
    private int anT = 536870912;
    private int anU = -1;
    private int anV = 0;
    private RectF anX = new RectF();

    public interface a {
        void onFinish();
    }

    d(CouponEntryProgress couponEntryProgress) {
        this.anv = couponEntryProgress;
        this.mContext = couponEntryProgress.getContext();
        setRadius(com.kwad.sdk.c.a.a.a(r3, 31.0f));
        xY();
        dJ();
    }

    private void xY() {
        setTargetProgress(100);
        this.anV = 5000 / this.anR;
    }

    private void dJ() {
        Paint paint = new Paint();
        this.anP = paint;
        paint.setColor(this.anT);
        this.anP.setAntiAlias(true);
        this.anP.setStyle(Paint.Style.STROKE);
        this.anP.setStrokeWidth(com.kwad.sdk.c.a.a.a(this.mContext, this.anS));
        Paint paint2 = new Paint();
        this.anO = paint2;
        paint2.setColor(this.anU);
        this.anO.setAntiAlias(true);
        this.anO.setStyle(Paint.Style.STROKE);
        this.anO.setStrokeWidth(com.kwad.sdk.c.a.a.a(this.mContext, this.anS));
    }

    public final void setRadius(float f) {
        this.mRadius = f;
    }

    public final void setProgress(int i) {
        this.anQ = i;
    }

    public final void setTargetProgress(int i) {
        this.anR = i;
    }

    public final void setStokeWidth(int i) {
        this.anS = i;
    }

    public final void setColor(int i) {
        this.anU = i;
    }

    public final void setSpeed(int i) {
        this.anV = i / this.anR;
    }

    protected final void a(Canvas canvas, int i, int i2) {
        float f = i / 2;
        float f2 = i2 / 2;
        canvas.drawCircle(f, f2, this.mRadius, this.anP);
        RectF rectF = this.anX;
        float f3 = this.mRadius;
        rectF.set(f - f3, f2 - f3, f + f3, f2 + f3);
        canvas.drawArc(this.anX, -90.0f, (this.anQ * 360) / 100, false, this.anO);
    }

    public final void b(a aVar) {
        this.anN = aVar;
        if (this.anW == null) {
            int i = this.anR;
            this.anW = new com.kwad.components.ct.coupon.entry.a(i * r1, this.anV) { // from class: com.kwad.components.ct.coupon.entry.d.1
                @Override // com.kwad.components.ct.coupon.entry.a
                public final void onTick(long j) {
                    d dVar = d.this;
                    dVar.setProgress(dVar.anR - ((int) (j / d.this.anV)));
                    d.this.anv.invalidate();
                }

                @Override // com.kwad.components.ct.coupon.entry.a
                public final void onFinish() {
                    d dVar = d.this;
                    dVar.setProgress(dVar.anR);
                    d.this.anv.invalidate();
                    cancel();
                    if (d.this.anN != null) {
                        d.this.anN.onFinish();
                    }
                }
            };
        }
        this.anW.cancel();
        this.anW.xP();
    }

    public final void reset() {
        com.kwad.components.ct.coupon.entry.a aVar = this.anW;
        if (aVar != null) {
            aVar.cancel();
        }
        setProgress(this.anR);
    }

    public final void pause() {
        com.kwad.components.ct.coupon.entry.a aVar = this.anW;
        if (aVar != null) {
            aVar.pause();
        }
    }

    public final void resume() {
        com.kwad.components.ct.coupon.entry.a aVar = this.anW;
        if (aVar != null) {
            aVar.resume();
        }
    }

    public final int getProgress() {
        return this.anQ;
    }
}
