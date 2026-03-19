package com.kwad.sdk.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.sdk.R;
import java.lang.reflect.Array;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsRadiusStrokeTextView extends TextView {
    private int aTg;
    private GradientDrawable bKs;
    private GradientDrawable bKt;
    private StateListDrawable bKu;
    private int mRadius;

    public KsRadiusStrokeTextView(Context context) {
        super(context);
    }

    public KsRadiusStrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    public KsRadiusStrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateList;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsRadiusStrokeTextView);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textStrokeColor, 0);
        this.mRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textRadius, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textLeftTopRadius, 0);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textLeftBottomRadius, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textRightTopRadius, 0);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textRightBottomRadius, 0);
        this.aTg = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textStrokeWidth, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textNormalTextColor, 0);
        int color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textSelectedTextColor, 0);
        int color4 = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textNormalSolidColor, 0);
        int color5 = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textPressedSolidColor, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textIsSelected, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textNoLeftStroke, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textNoRightStroke, false);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textNoTopStroke, false);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textNoBottomStroke, false);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KsRadiusStrokeTextView_ksad_textDrawable);
        typedArrayObtainStyledAttributes.recycle();
        this.bKu = new StateListDrawable();
        this.bKs = new GradientDrawable();
        this.bKt = new GradientDrawable();
        a(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize4, dimensionPixelSize3, color, color5, z2, z3, z4, z5, z);
        a(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize4, dimensionPixelSize3, color, color4, z2, z3, z4, z5);
        setBackgroundDrawable(this.bKu);
        if (drawable != null) {
            ImageSpan imageSpan = new ImageSpan(getContext(), ((BitmapDrawable) drawable).getBitmap());
            SpannableString spannableString = new SpannableString("[icon]");
            spannableString.setSpan(imageSpan, 0, 6, 33);
            setText(spannableString);
        }
        if (color2 != 0 && color3 != 0) {
            setClickable(true);
            if (z) {
                int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 1);
                iArr[0] = new int[]{android.R.attr.state_selected};
                iArr[1] = new int[0];
                colorStateList = new ColorStateList(iArr, new int[]{color3, color2});
            } else {
                int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 1);
                iArr2[0] = new int[]{android.R.attr.state_selected};
                iArr2[1] = new int[]{android.R.attr.state_pressed};
                iArr2[2] = new int[0];
                colorStateList = new ColorStateList(iArr2, new int[]{color3, color3, color2});
            }
            setTextColor(colorStateList);
            return;
        }
        setClickable(false);
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, boolean z4) {
        this.bKs.setColor(i6);
        this.bKs.setStroke(this.aTg, i5);
        a(this.bKs, i, i2, i3, i4);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.bKs});
        a(layerDrawable, 0, z, z2, z3, z4);
        this.bKu.addState(new int[0], layerDrawable);
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (i6 != 0) {
            this.bKt.setColor(i6);
            this.bKt.setStroke(this.aTg, i5);
            a(this.bKt, i, i2, i3, i4);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.bKt});
            a(layerDrawable, 0, z, z2, z3, z4);
            if (z5) {
                this.bKu.addState(new int[]{android.R.attr.state_selected}, layerDrawable);
            } else {
                this.bKu.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
            }
        }
    }

    private void a(GradientDrawable gradientDrawable, int i, int i2, int i3, int i4) {
        int i5 = this.mRadius;
        if (i5 != 0) {
            gradientDrawable.setCornerRadius(i5);
            return;
        }
        if (i == 0 && i2 == 0 && i4 == 0 && i3 == 0) {
            return;
        }
        float f = i;
        float f2 = i4;
        float f3 = i3;
        float f4 = i2;
        gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
    }

    private void a(LayerDrawable layerDrawable, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        layerDrawable.setLayerInset(0, z ? -this.aTg : 0, z3 ? -this.aTg : 0, z2 ? -this.aTg : 0, z4 ? -this.aTg : 0);
    }

    public void setTextDrawable(int i) {
        if (i != 0) {
            ImageSpan imageSpan = new ImageSpan(getContext(), ((BitmapDrawable) getResources().getDrawable(i)).getBitmap());
            SpannableString spannableString = new SpannableString("[icon]");
            spannableString.setSpan(imageSpan, 0, 6, 33);
            setText(spannableString);
        }
    }

    public void setSolidColor(int i) {
        this.bKs.setColor(i);
        setBackgroundDrawable(this.bKs);
    }

    public final void b(int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i3;
        float f3 = i4;
        float f4 = i2;
        this.bKs.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
        setBackgroundDrawable(this.bKs);
    }

    public final void J(int i, int i2) {
        this.bKs.setStroke(i, i2);
    }
}
