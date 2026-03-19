package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.an.c;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UGRatingBar extends FrameLayout {
    private LinearLayout an;
    private double b;
    private float c;
    private float d;
    private b gb;
    private Context h;
    private float hc;
    private LinearLayout u;

    public UGRatingBar(Context context) {
        super(context);
        this.h = context;
        this.u = new LinearLayout(context);
        this.an = new LinearLayout(context);
        this.u.setOrientation(0);
        this.u.setGravity(GravityCompat.START);
        this.an.setOrientation(0);
        this.an.setGravity(GravityCompat.START);
    }

    public void d(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.u.removeAllViews();
        this.an.removeAllViews();
        this.d = (int) gb.d(this.h, f);
        this.hc = (int) gb.d(this.h, f);
        this.b = d;
        this.c = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(c.hc(this.h, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.an.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(c.hc(this.h, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.u.addView(starImageView2);
        }
        addView(this.u);
        addView(this.an);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.d, (int) this.hc);
        layoutParams.leftMargin = (int) this.c;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.c;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        b bVar = this.gb;
        if (bVar != null) {
            bVar.d(i, i2);
        }
        super.onMeasure(i, i2);
        this.u.measure(i, i2);
        double dFloor = Math.floor(this.b);
        this.an.measure(View.MeasureSpec.makeMeasureSpec((int) (((r0 + r0 + r2) * dFloor) + this.c + ((this.b - dFloor) * this.d)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.u.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar = this.gb;
        if (bVar != null) {
            bVar.d(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.gb;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.gb;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b bVar = this.gb;
        if (bVar != null) {
            bVar.d(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b bVar = this.gb;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i4);
        }
    }

    public void d(b bVar) {
        this.gb = bVar;
    }
}
