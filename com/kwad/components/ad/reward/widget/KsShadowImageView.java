package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsShadowImageView extends ImageView {
    private Paint FL;
    private BlurMaskFilter FM;
    private int FN;
    private boolean FO;
    private boolean FP;
    private boolean FQ;
    private boolean FR;
    private Rect FS;
    private int FT;

    public KsShadowImageView(Context context) {
        super(context);
        this.FR = true;
        a(context, null, 0);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FR = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FR = true;
        a(context, attributeSet, i);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.FR = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.FL = new Paint();
        this.FM = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.FS = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i, 0);
        this.FN = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.FT = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.FO = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.FP = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.FQ = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.FR = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.FL.setMaskFilter(this.FM);
        this.FL.setColor(this.FT);
        this.FL.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.FS.left = this.FO ? this.FN : 0;
        this.FS.top = this.FQ ? this.FN : 0;
        this.FS.right = measuredWidth - (this.FP ? this.FN : 0);
        this.FS.bottom = measuredHeight - (this.FR ? this.FN : 0);
        canvas.drawRect(this.FS, this.FL);
    }
}
