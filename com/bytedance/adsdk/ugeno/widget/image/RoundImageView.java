package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.b.u;
import com.bytedance.adsdk.ugeno.d.gb;
import com.bytedance.adsdk.ugeno.d.h;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RoundImageView extends ImageView implements u, h {
    static final /* synthetic */ boolean hc = true;
    private Drawable an;
    private float b;
    private int cb;
    private int e;
    private float gb;
    private ColorStateList h;
    private b jh;
    private boolean k;
    private Drawable mk;
    private boolean mq;
    private Shader.TileMode rf;
    private gb sy;
    private boolean tc;
    private ColorFilter tt;
    private final float[] u;
    private boolean uo;
    private ImageView.ScaleType w;
    private Shader.TileMode yo;
    public static final Shader.TileMode d = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] c = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    public RoundImageView(Context context) {
        super(context);
        this.u = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.h = ColorStateList.valueOf(-16777216);
        this.gb = 0.0f;
        this.tt = null;
        this.tc = false;
        this.mq = false;
        this.uo = false;
        this.k = false;
        Shader.TileMode tileMode = d;
        this.yo = tileMode;
        this.rf = tileMode;
        this.sy = new gb(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.w;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!hc && scaleType == null) {
            throw new AssertionError();
        }
        if (this.w != scaleType) {
            this.w = scaleType;
            int i = AnonymousClass1.d[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            b();
            d(false);
            invalidate();
        }
    }

    /* renamed from: com.bytedance.adsdk.ugeno.widget.image.RoundImageView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            d = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.e = 0;
        this.mk = d.d(drawable);
        b();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.e = 0;
        this.mk = d.d(bitmap);
        b();
        super.setImageDrawable(this.mk);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.e != i) {
            this.e = i;
            this.mk = d();
            b();
            super.setImageDrawable(this.mk);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable d() throws Resources.NotFoundException {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.e;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                mq.hc("RoundedImageView", "Unable to find resource: " + this.e, e);
                this.e = 0;
            }
        }
        return d.d(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) throws Resources.NotFoundException {
        if (this.cb != i) {
            this.cb = i;
            Drawable drawableHc = hc();
            this.an = drawableHc;
            setBackgroundDrawable(drawableHc);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.an = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable hc() throws Resources.NotFoundException {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.cb;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                mq.hc("RoundedImageView", "Unable to find resource: " + this.cb, e);
                this.cb = 0;
            }
        }
        return d.d(drawable);
    }

    private void b() {
        d(this.mk, this.w);
    }

    private void d(boolean z) {
        if (this.k) {
            if (z) {
                this.an = d.d(this.an);
            }
            d(this.an, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.tt != colorFilter) {
            this.tt = colorFilter;
            this.mq = true;
            this.tc = true;
            c();
            invalidate();
        }
    }

    private void c() {
        Drawable drawable = this.mk;
        if (drawable == null || !this.tc) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.mk = drawableMutate;
        if (this.mq) {
            drawableMutate.setColorFilter(this.tt);
        }
    }

    private void d(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof d) {
            d dVar = (d) drawable;
            dVar.d(scaleType).d(this.gb).d(this.h).d(this.uo).d(this.yo).hc(this.rf);
            float[] fArr = this.u;
            if (fArr != null) {
                dVar.d(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            c();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                d(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.an = drawable;
        d(true);
        super.setBackgroundDrawable(this.an);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.u) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    public void setCornerRadiusDimen(int i) throws Resources.NotFoundException {
        float dimension = getResources().getDimension(i);
        d(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        d(f, f, f, f);
    }

    public void d(float f, float f2, float f3, float f4) {
        float[] fArr = this.u;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        b();
        d(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.gb;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.gb == f) {
            return;
        }
        this.gb = f;
        b();
        d(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.h.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.h;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.h.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.h = colorStateList;
        b();
        d(false);
        if (this.gb > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z) {
        this.uo = z;
        b();
        d(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.yo;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.yo == tileMode) {
            return;
        }
        this.yo = tileMode;
        b();
        d(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.rf;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.rf == tileMode) {
            return;
        }
        this.rf = tileMode;
        b();
        d(false);
        invalidate();
    }

    public void d(b bVar) {
        this.jh = bVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        b bVar = this.jh;
        if (bVar != null) {
            int[] iArrD = bVar.d(i, i2);
            super.onMeasure(iArrD[0], iArrD[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar = this.jh;
        if (bVar != null) {
            bVar.d(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.jh;
        if (bVar != null) {
            bVar.d(canvas, this);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b bVar = this.jh;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.jh;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.jh;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b.u, com.bytedance.adsdk.ugeno.d.h
    public float getRipple() {
        return this.b;
    }

    public void setShine(float f) {
        gb gbVar = this.sy;
        if (gbVar != null) {
            gbVar.b(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getShine() {
        return this.sy.getShine();
    }

    public void setStretch(float f) {
        gb gbVar = this.sy;
        if (gbVar != null) {
            gbVar.c(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getStretch() {
        return this.sy.getStretch();
    }

    public void setRubIn(float f) {
        gb gbVar = this.sy;
        if (gbVar != null) {
            gbVar.u(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getRubIn() {
        return this.sy.getRubIn();
    }

    public void setRipple(float f) {
        this.b = f;
        gb gbVar = this.sy;
        if (gbVar != null) {
            gbVar.hc(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b bVar = this.jh;
        if (bVar != null) {
            bVar.d(z);
        }
    }

    public void setBorderRadius(float f) {
        gb gbVar = this.sy;
        if (gbVar != null) {
            gbVar.d(f);
        }
    }

    public float getBorderRadius() {
        return this.sy.d();
    }
}
