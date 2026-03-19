package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.adexpress.dynamic.c.mk;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class TTRatingBar2 extends FrameLayout {
    private Drawable an;
    private float b;
    private float c;
    LinearLayout d;
    private float gb;
    private double h;
    LinearLayout hc;
    private Drawable u;
    private static final int tt = (mk.hc("", 0.0f, true)[1] / 2) + 1;
    private static final int tc = (mk.hc("", 0.0f, true)[1] / 2) + 3;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new LinearLayout(getContext());
        this.hc = new LinearLayout(getContext());
        this.d.setOrientation(0);
        this.d.setGravity(GravityCompat.START);
        this.hc.setOrientation(0);
        this.hc.setGravity(GravityCompat.START);
        this.u = jh.b(context, "tt_star_thick");
        this.an = jh.b(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.u;
    }

    public Drawable getStarFillDrawable() {
        return this.an;
    }

    public void d(double d, int i, int i2, int i3) {
        float f = i2;
        this.b = (int) gb.b(getContext(), f);
        this.c = (int) gb.b(getContext(), f);
        this.h = d;
        this.gb = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.hc.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.d.addView(starImageView2);
        }
        addView(this.d);
        addView(this.hc);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.b, (int) this.c));
        imageView.setPadding(1, tt, 1, tc);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d.measure(i, i2);
        double d = this.h;
        float f = this.b;
        this.hc.measure(View.MeasureSpec.makeMeasureSpec((int) ((((int) d) * f) + 1.0f + ((f - 2.0f) * (d - ((int) d)))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.d.getMeasuredHeight(), 1073741824));
        if (this.gb > 0.0f) {
            this.d.setPadding(0, ((int) (r7.getMeasuredHeight() - this.gb)) / 2, 0, 0);
            this.hc.setPadding(0, ((int) (this.d.getMeasuredHeight() - this.gb)) / 2, 0, 0);
        }
    }
}
