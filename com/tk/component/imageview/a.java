package com.tk.component.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tk.core.o.o;
import com.tk.core.o.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends ImageView {
    private static final Bitmap.Config PZ = Bitmap.Config.ARGB_8888;
    private Bitmap BF;
    private Path FC;
    private final RectF Qa;
    private final RectF Qb;
    private final Matrix Qc;
    private final Paint Qd;
    private final Paint Qe;
    private float Qf;
    private BitmapShader Qg;
    private int Qh;
    private int Qi;
    private float Qj;
    private float Qk;
    private float Ql;
    private float Qm;
    private float Qn;
    private boolean Qo;
    private boolean Qp;
    private volatile boolean Qq;
    private Integer Qr;
    private int mBorderColor;

    public a(Context context) {
        this(context, null);
    }

    private a(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.Qa = new RectF();
        this.Qb = new RectF();
        this.Qc = new Matrix();
        this.Qd = new Paint();
        this.Qe = new Paint();
        this.FC = new Path();
        this.mBorderColor = 0;
        this.Qf = 0.0f;
        this.Qf = 0.0f;
        this.mBorderColor = 0;
        this.Qo = true;
        if (this.Qp) {
            setup();
            this.Qp = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (this.Qq) {
            return;
        }
        Bitmap bitmap = this.BF;
        if ((bitmap == null || !bitmap.isRecycled()) && getDrawable() != null) {
            this.FC.reset();
            float fMin = Math.min(this.Qa.height() / 2.0f, this.Qa.width() / 2.0f);
            float fMin2 = Math.min(this.Qk, fMin);
            float fMin3 = Math.min(this.Ql, fMin);
            float fMin4 = Math.min(this.Qm, fMin);
            float fMin5 = Math.min(this.Qn, fMin);
            this.FC.addRoundRect(this.Qa, new float[]{fMin2, fMin2, fMin3, fMin3, fMin4, fMin4, fMin5, fMin5}, Path.Direction.CW);
            canvas.drawPath(this.FC, this.Qd);
            if (this.Qf > 0.0f) {
                if (this.Qk <= 0.0f && this.Ql <= 0.0f && this.Qm <= 0.0f && this.Qn <= 0.0f) {
                    canvas.drawRect(this.Qb, this.Qe);
                    return;
                }
                Path path = new Path();
                path.addRoundRect(this.Qb, new float[]{fMin2, fMin2, fMin3, fMin3, fMin4, fMin4, fMin5, fMin5}, Path.Direction.CW);
                canvas.drawPath(path, this.Qe);
            }
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public final int getBorderColor() {
        return this.mBorderColor;
    }

    public final void setBorderColor(int i) {
        if (i == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i;
        this.Qe.setColor(this.mBorderColor);
        invalidate();
    }

    public final float getBorderWidth() {
        return this.Qf;
    }

    public final void setBorderWidth(float f) {
        if (f == this.Qf) {
            return;
        }
        this.Qf = f;
        setup();
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.BF = bitmap;
        mR();
        setup();
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.BF = n(drawable);
        mR();
        setup();
    }

    private void mR() {
        Bitmap bitmap = this.BF;
        if (bitmap == null || this.Qr == null) {
            return;
        }
        try {
            Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
            Canvas canvas = new Canvas(bitmapCopy);
            Paint paint = new Paint();
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            paint.setColorFilter(new PorterDuffColorFilter(this.Qr.intValue(), PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(this.BF, 0.0f, 0.0f, paint);
            this.BF = bitmapCopy;
        } catch (Throwable th) {
            com.tk.core.i.a.a("RoundImageView", "updateBitmapColorFilter", th);
        }
    }

    public final void setTintColor(String str) {
        this.Qr = Integer.valueOf(r.parseColor(str));
        mR();
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i) {
        super.setImageResource(i);
        this.BF = n(getDrawable());
        mR();
        setup();
    }

    private static Bitmap n(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmapCreateBitmap = Bitmap.createBitmap(1, 1, PZ);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), PZ);
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            com.tk.core.i.a.a("RoundImageView", "RoundImageView getBitmapFromDrawable exception:", th);
            return null;
        }
    }

    private void setup() {
        if (!this.Qo) {
            this.Qp = true;
            return;
        }
        Bitmap bitmap = this.BF;
        if (bitmap == null) {
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.Qg = new BitmapShader(bitmap, tileMode, tileMode);
        this.Qd.setAntiAlias(true);
        this.Qd.setShader(this.Qg);
        this.Qe.setStyle(Paint.Style.STROKE);
        this.Qe.setAntiAlias(true);
        this.Qe.setColor(this.mBorderColor);
        this.Qe.setStrokeWidth(this.Qf);
        this.Qi = this.BF.getHeight();
        this.Qh = this.BF.getWidth();
        RectF rectF = this.Qb;
        float f = this.Qf;
        rectF.set(f / 2.0f, f / 2.0f, getWidth() - (this.Qf / 2.0f), getHeight() - (this.Qf / 2.0f));
        RectF rectF2 = this.Qa;
        float f2 = this.Qf;
        rectF2.set(f2 / 2.0f, f2 / 2.0f, getWidth() - (this.Qf / 2.0f), getHeight() - (this.Qf / 2.0f));
        this.Qj = Math.min(this.Qa.height() / 2.0f, this.Qa.width() / 2.0f);
        mS();
        invalidate();
    }

    private void mS() {
        float fWidth;
        float fWidth2;
        this.Qc.set(null);
        float fHeight = 0.0f;
        if (this.Qh * this.Qa.height() > this.Qa.width() * this.Qi) {
            fWidth = this.Qa.height() / this.Qi;
            fWidth2 = (this.Qa.width() - (this.Qh * fWidth)) * 0.5f;
        } else {
            fWidth = this.Qa.width() / this.Qh;
            fHeight = (this.Qa.height() - (this.Qi * fWidth)) * 0.5f;
            fWidth2 = 0.0f;
        }
        this.Qc.setScale(fWidth, fWidth);
        Matrix matrix = this.Qc;
        float f = this.Qf;
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + f, ((int) (fHeight + 0.5f)) + f);
        this.Qg.setLocalMatrix(this.Qc);
    }

    protected final void setBorderRadius(float f) {
        float fP = o.P(f);
        this.Qk = fP;
        this.Ql = fP;
        this.Qm = fP;
        this.Qn = fP;
        setup();
    }

    public final void setTopLeftRoundRadius(float f) {
        this.Qk = f;
    }

    public final void setTopRightRoundRadius(float f) {
        this.Ql = f;
    }

    public final void setBottomRightRoundRadius(float f) {
        this.Qm = f;
    }

    public final void setBottomLeftRoundRadius(float f) {
        this.Qn = f;
    }

    public final void onDestroy() {
        this.Qq = true;
    }
}
