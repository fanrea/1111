package com.kwad.components.ad.splashscreen.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends AnimationDrawable {
    private Bitmap MA;
    private Bitmap MC;
    private Bitmap MD;
    private Bitmap ME;
    private Bitmap MF;
    private Bitmap MG;
    private int MH;
    private RectF MI;
    private Paint MJ;
    private Paint MK;
    private PorterDuffXfermode ML;
    private final int MM;
    private final int MN;
    private float MO;
    private float MP;
    private RectF MQ;
    private Paint MR;
    private int MS;
    private int MT;
    private ValueAnimator MU;
    private final float MV = 6.0f;
    private final float MW = 11.0f;
    private float MX;
    private float MY;
    private int MZ;
    private Context mContext;

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    public d(Context context, int i) {
        this.mContext = context;
        this.MM = com.kwad.sdk.c.a.a.a(context, 51.0f);
        this.MN = com.kwad.sdk.c.a.a.a(context, 61.0f);
        this.MZ = i;
        init();
    }

    private void init() {
        this.MA = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand);
        this.MC = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lt);
        this.MD = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lb);
        this.ME = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rt);
        this.MF = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rb);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_side_bg);
        int i = this.MZ;
        if (i == 0) {
            this.MG = bitmapDecodeResource;
        } else if (i == 1) {
            Matrix matrix = new Matrix();
            matrix.postRotate(270.0f);
            this.MG = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true);
        } else if (i == 2) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(90.0f);
            this.MG = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix2, true);
        }
        this.MH = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
        this.MR = new Paint(1);
        int i2 = this.MZ;
        if (i2 == 0) {
            this.MT = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.MS = dimension;
            this.MO = (-this.MN) * 0.22f;
            this.MP = dimension * 0.08f;
        } else if (i2 == 1) {
            this.MT = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.MS = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.MO = this.MT * 0.09f;
            this.MP = (-this.MM) * 0.2f;
        } else if (i2 == 2) {
            this.MT = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.MS = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.MO = this.MT * 0.09f;
            this.MP = (-this.MM) * 0.5f;
        }
        this.MQ = new RectF(0.0f, 0.0f, this.MS, this.MT);
        this.MJ = new Paint(3);
        Paint paint = new Paint(3);
        this.MK = paint;
        paint.setDither(true);
        this.MI = new RectF(this.MQ.right - this.MM, 0.0f, this.MQ.right, this.MN);
        this.ML = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.MU = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1100L);
        this.MU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.MX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d dVar = d.this;
                dVar.e(dVar.MX);
                d.this.invalidateSelf();
            }
        });
        this.MU.setRepeatCount(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f) {
        if (f <= 6.0f) {
            float f2 = f / 6.0f;
            int i = this.MZ;
            if (i == 0) {
                this.MQ.top = this.MT * (1.0f - f2);
                this.MI.offsetTo(this.MQ.left + this.MP, this.MQ.top + this.MO);
                this.MY = (f2 * 30.0f) + 290.0f;
                return;
            }
            if (i == 1) {
                float f3 = 1.0f - f2;
                this.MQ.left = this.MS * f3;
                this.MI.offsetTo(this.MQ.left + this.MP, this.MQ.top + this.MO);
                this.MY = f3 * 30.0f;
                return;
            }
            if (i != 2) {
                return;
            }
            this.MQ.right = this.MS * f2;
            this.MI.offsetTo(this.MQ.right + this.MP, this.MQ.top + this.MO);
            this.MY = (f2 * 30.0f) + 330.0f;
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.MS + this.MM;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.MT + this.MN + this.MH;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.MQ == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.MS) / 2, (getIntrinsicHeight() - this.MT) / 2);
        float f = this.MX;
        if (f <= 6.0f) {
            this.MR.setAlpha((int) ((f * 255.0f) / 6.0f));
            this.MK.setAlpha(255);
        } else {
            int i = (int) ((1.0f - ((f - 6.0f) / 5.0f)) * 255.0f);
            this.MR.setAlpha(i);
            this.MK.setAlpha(i);
        }
        int iSave = canvas.save();
        int iSaveLayer = canvas.saveLayer(this.MQ, this.MR, 31);
        try {
            canvas.drawBitmap(this.MG, (Rect) null, this.MQ, this.MR);
        } catch (Throwable unused) {
        }
        canvas.rotate(this.MY, this.MI.centerX(), this.MI.centerY());
        this.MJ.setXfermode(this.ML);
        int i2 = this.MZ;
        if (i2 == 0) {
            canvas.drawBitmap(this.ME, (Rect) null, this.MI, this.MJ);
            canvas.drawBitmap(this.MF, (Rect) null, this.MI, this.MJ);
        } else if (i2 == 1) {
            canvas.drawBitmap(this.MC, (Rect) null, this.MI, this.MJ);
            canvas.drawBitmap(this.MD, (Rect) null, this.MI, this.MJ);
        }
        canvas.drawBitmap(this.MA, (Rect) null, this.MI, this.MJ);
        canvas.restoreToCount(iSaveLayer);
        canvas.rotate(this.MY, this.MI.centerX(), this.MI.centerY());
        canvas.drawBitmap(this.MA, (Rect) null, this.MI, this.MK);
        canvas.restoreToCount(iSave);
        canvas.restore();
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.MU;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.MU;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.MU;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }
}
