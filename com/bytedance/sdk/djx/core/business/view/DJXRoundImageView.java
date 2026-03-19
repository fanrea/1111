package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.base.R;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXRoundImageView extends ImageView {
    private static final float BORDER_WIDTH_DEFAULT = 0.5f;
    private static final int RADIUS_DEFAULT = 0;
    public static final int SHAPE_CIRCLE = 0;
    public static final int SHAPE_DEFAULT = -1;
    public static final int SHAPE_RECT = 1;
    private int mBorderColor;
    private Paint mBorderPaint;
    private Path mBorderPath;
    private float[] mBorderRadii;
    private int mBorderWidth;
    private int mCornerBottomLeftRadius;
    private int mCornerBottomRightRadius;
    private int mCornerRadius;
    private int mCornerTopLeftRadius;
    private int mCornerTopRightRadius;
    private int mCoverColor;
    private Paint mPaint;
    private Path mPath;
    private float[] mRadii;
    private int mShape;

    public DJXRoundImageView(Context context) {
        super(context);
        this.mShape = -1;
        init(null);
    }

    public DJXRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShape = -1;
        init(attributeSet);
    }

    public DJXRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShape = -1;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DJXRoundImageView);
            this.mShape = typedArrayObtainStyledAttributes.getInt(R.styleable.DJXRoundImageView_djx_shape, this.mShape);
            this.mCoverColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DJXRoundImageView_djx_cover_color, 0);
            this.mBorderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DJXRoundImageView_djx_border_color, Color.parseColor("#f2f2f2"));
            this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DJXRoundImageView_djx_border_width, UIUtil.dp2px(0.5f));
            this.mCornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DJXRoundImageView_djx_corner_radius, UIUtil.dp2px(0.0f));
            this.mCornerTopLeftRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXRoundImageView_djx_corner_top_left_radius, UIUtil.dp2px(0.0f));
            this.mCornerTopRightRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXRoundImageView_djx_corner_top_right_radius, UIUtil.dp2px(0.0f));
            this.mCornerBottomLeftRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXRoundImageView_djx_corner_bottom_left_radius, UIUtil.dp2px(0.0f));
            this.mCornerBottomRightRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXRoundImageView_djx_corner_bottom_right_radius, UIUtil.dp2px(0.0f));
        } catch (Throwable unused) {
            if (typedArrayObtainStyledAttributes != null) {
            }
        }
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mPaint.setColor(this.mCoverColor);
        this.mPaint.setAntiAlias(true);
        this.mPath = new Path();
        this.mBorderPath = new Path();
        calculateRadii();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.mShape;
        if (i == 0) {
            drawCircleCover(canvas);
        } else if (i == 1) {
            drawRectCover(canvas);
        }
        super.onDraw(canvas);
        if (this.mShape != 1) {
            return;
        }
        drawRectFBorder(canvas);
    }

    private void drawCircleCover(Canvas canvas) {
        this.mPath.addCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 2, Path.Direction.CW);
        canvas.clipPath(this.mPath);
    }

    private void drawRectCover(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        this.mPath.addRoundRect(rectF, this.mRadii, Path.Direction.CW);
        canvas.clipPath(this.mPath);
    }

    private void drawRectFBorder(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int i = this.mBorderWidth;
        if (i <= 0) {
            return;
        }
        initBorderPaint(i, this.mBorderColor);
        this.mBorderPath.reset();
        this.mBorderPath.addRoundRect(rectF, this.mBorderRadii, Path.Direction.CCW);
        canvas.drawPath(this.mBorderPath, this.mBorderPaint);
    }

    private void initBorderPaint(int i, int i2) {
        this.mBorderPaint.reset();
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStrokeWidth(i);
        this.mBorderPaint.setColor(i2);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    private void calculateRadii() {
        int i = this.mCornerRadius;
        if (i > 0) {
            Arrays.fill(this.mRadii, i);
            Arrays.fill(this.mBorderRadii, this.mCornerRadius);
            return;
        }
        float[] fArr = this.mBorderRadii;
        int i2 = this.mCornerTopLeftRadius;
        float f = i2;
        fArr[1] = f;
        fArr[0] = f;
        int i3 = this.mCornerTopRightRadius;
        float f2 = i3;
        fArr[3] = f2;
        fArr[2] = f2;
        int i4 = this.mCornerBottomRightRadius;
        float f3 = i4;
        fArr[5] = f3;
        fArr[4] = f3;
        int i5 = this.mCornerBottomLeftRadius;
        float f4 = i5;
        fArr[7] = f4;
        fArr[6] = f4;
        float[] fArr2 = this.mRadii;
        float f5 = i2;
        fArr2[1] = f5;
        fArr2[0] = f5;
        float f6 = i3;
        fArr2[3] = f6;
        fArr2[2] = f6;
        float f7 = i4;
        fArr2[5] = f7;
        fArr2[4] = f7;
        float f8 = i5;
        fArr2[7] = f8;
        fArr2[6] = f8;
    }

    private void calculateRadiiAndRectF(boolean z) {
        if (z) {
            this.mCornerRadius = 0;
        }
        calculateRadii();
        invalidate();
    }

    public void setShape(int i) {
        this.mShape = i;
        invalidate();
    }

    public void setCoverColor(int i) {
        this.mCoverColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.mCornerRadius = UIUtil.dp2px(i);
        calculateRadiiAndRectF(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.mCornerTopLeftRadius = UIUtil.dp2px(i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.mCornerTopRightRadius = UIUtil.dp2px(i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.mCornerBottomLeftRadius = UIUtil.dp2px(i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.mCornerBottomRightRadius = UIUtil.dp2px(i);
        calculateRadiiAndRectF(true);
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
        invalidate();
    }
}
