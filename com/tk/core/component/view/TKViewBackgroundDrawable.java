package com.tk.core.component.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.animation.j;
import com.tk.core.o.o;
import com.tk.core.o.r;
import com.tk.core.o.v;
import com.tk.core.o.x;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKViewBackgroundDrawable extends Drawable {
    private static final int ALL_BITS_SET = -1;
    private static final int ALL_BITS_UNSET = 0;
    private static final String BACKGROUND_SIZE_CONTAIN = "contain";
    private static final String BACKGROUND_SIZE_COVER = "cover";
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int PAINT_FLAGS = 3;
    private static float UNDEFINED = 1.0E21f;
    private Bitmap mBackgroundImageBitmap;
    private Drawable mBackgroundImageDrawable;
    private int mBackgroundImageOffsetX;
    private int mBackgroundImageOffsetY;
    private Path mBackgroundImagePath;
    private RectF mBackgroundImageRectF;
    private String mBackgroundPosition;
    private String mBackgroundSize;
    private BorderStyle mBorderBottomStyle;
    private float[] mBorderCornerRadii;
    private BorderStyle mBorderLeftStyle;
    private BorderStyle mBorderRightStyle;
    private BorderStyle mBorderStyle;
    private BorderStyle mBorderTopStyle;
    private x mBorderWidth;
    private Path mCenterDrawPath;
    private final Context mContext;
    private a mGradient;
    private Paint mGradientPaint;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private Path mInnerClipPathForBorderRadius;
    private RectF mInnerClipTempRectForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private boolean mIsDestroy;
    private int mLayoutDirection;
    private Path mOuterClipPathForBorderRadius;
    private RectF mOuterClipTempRectForBorderRadius;
    private PathEffect mPathEffectForBorderStyle;
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;
    private b mShadow;
    private Paint mShadowPaint;
    private com.tk.core.bridge.b mTKJSContext;
    private RectF mTempRectForBorderRadiusOutline;
    private RectF mTempRectForCenterDrawPath;
    private int mBorderColor = -16777216;
    private int mBorderLeftColor = -16777216;
    private int mBorderTopColor = -16777216;
    private int mBorderRightColor = -16777216;
    private int mBorderBottomColor = -16777216;
    private boolean mNeedUpdatePathForBorderRadius = false;
    private float mBorderRadius = UNDEFINED;
    private final Paint mPaint = new Paint();
    private int mColor = 0;
    private int mAlpha = 255;
    public String mDebugText = null;

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    public static class a {
        public float[] Lq;
        public int[] Lr;
        public int ahA;
    }

    private static int colorFromAlphaAndRGBComponents(float f, float f2) {
        return ((((int) f) << 24) & (-16777216)) | (((int) f2) & 16777215);
    }

    private static int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = (i4 > 0 ? i8 : -1) & (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        int i10 = i5 | i6;
        if (i3 <= 0) {
            i7 = 0;
        }
        int i11 = i10 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        if (i9 == (i11 | i8)) {
            return i9;
        }
        return 0;
    }

    public static void preLoad() {
    }

    private int transparentColor(int i) {
        return (i & (-16777216)) == -16777216 ? i & (-16777217) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* renamed from: com.tk.core.component.view.TKViewBackgroundDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ahz = new int[BorderStyle.values().length];

        static {
            try {
                ahz[BorderStyle.DASHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ahz[BorderStyle.DOTTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect getPathEffect(BorderStyle borderStyle, float f) {
            int i = AnonymousClass1.ahz[borderStyle.ordinal()];
            if (i == 1) {
                return new DashPathEffect(new float[]{2.0f * f, f}, 0.0f);
            }
            if (i != 2) {
                return null;
            }
            return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
        }
    }

    public TKViewBackgroundDrawable(Context context, com.tk.core.bridge.b bVar) {
        this.mContext = context;
        this.mTKJSContext = bVar;
    }

    public static boolean isUndefined(float f) {
        return Float.compare(f, UNDEFINED) == 0;
    }

    public TKViewBackgroundDrawable newDrawable() {
        TKViewBackgroundDrawable tKViewBackgroundDrawable = new TKViewBackgroundDrawable(this.mContext, this.mTKJSContext);
        tKViewBackgroundDrawable.mBorderWidth = this.mBorderWidth;
        tKViewBackgroundDrawable.mBorderColor = this.mBorderColor;
        tKViewBackgroundDrawable.mBorderLeftColor = this.mBorderLeftColor;
        tKViewBackgroundDrawable.mBorderTopColor = this.mBorderTopColor;
        tKViewBackgroundDrawable.mBorderRightColor = this.mBorderRightColor;
        tKViewBackgroundDrawable.mBorderBottomColor = this.mBorderBottomColor;
        tKViewBackgroundDrawable.mBorderStyle = this.mBorderStyle;
        tKViewBackgroundDrawable.mBorderLeftStyle = this.mBorderLeftStyle;
        tKViewBackgroundDrawable.mBorderTopStyle = this.mBorderTopStyle;
        tKViewBackgroundDrawable.mBorderRightStyle = this.mBorderRightStyle;
        tKViewBackgroundDrawable.mBorderBottomStyle = this.mBorderBottomStyle;
        tKViewBackgroundDrawable.mColor = this.mColor;
        tKViewBackgroundDrawable.mGradient = this.mGradient;
        tKViewBackgroundDrawable.mAlpha = this.mAlpha;
        tKViewBackgroundDrawable.mBorderCornerRadii = this.mBorderCornerRadii;
        tKViewBackgroundDrawable.mLayoutDirection = this.mLayoutDirection;
        tKViewBackgroundDrawable.mBorderRadius = this.mBorderRadius;
        tKViewBackgroundDrawable.mShadow = this.mShadow;
        tKViewBackgroundDrawable.mNeedUpdatePathForBorderRadius = true;
        tKViewBackgroundDrawable.mDebugText = this.mDebugText;
        return tKViewBackgroundDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mIsDestroy) {
            return;
        }
        canvas.save();
        resetAllPaint();
        drawShadowIfNeed(canvas);
        if (!hasRoundedBorders()) {
            drawRectangularBackgroundWithBorders(canvas);
        } else {
            drawRoundedBackgroundWithBorders(canvas);
        }
        canvas.restore();
        drawBackgroundImage(canvas);
    }

    private void resetAllPaint() {
        this.mPaint.reset();
        this.mPaint.setFlags(3);
        Paint paint = this.mGradientPaint;
        if (paint != null) {
            paint.reset();
            this.mGradientPaint.setFlags(3);
        }
        Paint paint2 = this.mShadowPaint;
        if (paint2 != null) {
            paint2.reset();
            this.mShadowPaint.setFlags(3);
        }
    }

    public boolean hasRoundedBorders() {
        if (!isUndefined(this.mBorderRadius) && this.mBorderRadius > 0.0f) {
            return true;
        }
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            for (float f : fArr) {
                if (!isUndefined(f) && f > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
        updateBackgroundImage();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return r.ed(r.aR(this.mColor, this.mAlpha));
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (Build.VERSION.SDK_INT < 21) {
            super.getOutline(outline);
            return;
        }
        if ((!isUndefined(this.mBorderRadius) && this.mBorderRadius > 0.0f) || this.mBorderCornerRadii != null) {
            updatePath();
            outline.setConvexPath(this.mPathForBorderRadiusOutline);
        } else {
            outline.setRect(getBounds());
        }
    }

    public void setBorderWidth(int i, float f) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new x();
        }
        if (v.r(this.mBorderWidth.ef(i), f)) {
            return;
        }
        this.mBorderWidth.d(i, f);
        if (i == 8) {
            this.mBorderWidth.d(0, f);
            this.mBorderWidth.d(1, f);
            this.mBorderWidth.d(2, f);
            this.mBorderWidth.d(3, f);
        }
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
            this.mNeedUpdatePathForBorderRadius = true;
        }
        updateBackgroundImage();
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setBorderColor(int r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            if (r3 == 0) goto L34
            if (r3 == r0) goto L2d
            r1 = 2
            if (r3 == r1) goto L26
            r1 = 3
            if (r3 == r1) goto L1f
            r1 = 8
            if (r3 == r1) goto L10
            goto L3b
        L10:
            int r3 = r2.mBorderColor
            if (r3 == r4) goto L3b
            r2.mBorderBottomColor = r4
            r2.mBorderRightColor = r4
            r2.mBorderTopColor = r4
            r2.mBorderLeftColor = r4
            r2.mBorderColor = r4
            goto L3c
        L1f:
            int r3 = r2.mBorderBottomColor
            if (r3 == r4) goto L3b
            r2.mBorderBottomColor = r4
            goto L3c
        L26:
            int r3 = r2.mBorderRightColor
            if (r3 == r4) goto L3b
            r2.mBorderRightColor = r4
            goto L3c
        L2d:
            int r3 = r2.mBorderTopColor
            if (r3 == r4) goto L3b
            r2.mBorderTopColor = r4
            goto L3c
        L34:
            int r3 = r2.mBorderLeftColor
            if (r3 == r4) goto L3b
            r2.mBorderLeftColor = r4
            goto L3c
        L3b:
            r0 = 0
        L3c:
            if (r0 == 0) goto L41
            r2.invalidateSelf()
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.view.TKViewBackgroundDrawable.setBorderColor(int, int):void");
    }

    public void setBorderStyle(int i, String str) {
        BorderStyle borderStyleValueOf = str == null ? null : BorderStyle.valueOf(str.toUpperCase(Locale.US));
        boolean z = false;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 8 && this.mBorderStyle != borderStyleValueOf) {
                            this.mBorderBottomStyle = borderStyleValueOf;
                            this.mBorderRightStyle = borderStyleValueOf;
                            this.mBorderTopStyle = borderStyleValueOf;
                            this.mBorderLeftStyle = borderStyleValueOf;
                            this.mBorderStyle = borderStyleValueOf;
                            z = true;
                        }
                    } else if (this.mBorderBottomStyle != borderStyleValueOf) {
                        this.mBorderBottomStyle = borderStyleValueOf;
                        z = true;
                    }
                } else if (this.mBorderRightStyle != borderStyleValueOf) {
                    this.mBorderRightStyle = borderStyleValueOf;
                    z = true;
                }
            } else if (this.mBorderTopStyle != borderStyleValueOf) {
                this.mBorderTopStyle = borderStyleValueOf;
                z = true;
            }
        } else if (this.mBorderLeftStyle != borderStyleValueOf) {
            this.mBorderLeftStyle = borderStyleValueOf;
            z = true;
        }
        if (z) {
            this.mNeedUpdatePathForBorderRadius = true;
            updateBackgroundImage();
            invalidateSelf();
        }
    }

    public void setRadius(float f) {
        if (v.r(this.mBorderRadius, f)) {
            return;
        }
        this.mBorderRadius = f;
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            Arrays.fill(fArr, f);
        }
        this.mNeedUpdatePathForBorderRadius = true;
        updateBackgroundImage();
        invalidateSelf();
    }

    public void setRadius(float f, int i) {
        if (this.mBorderCornerRadii == null) {
            this.mBorderCornerRadii = new float[8];
            Arrays.fill(this.mBorderCornerRadii, UNDEFINED);
        }
        if (v.r(this.mBorderCornerRadii[i], f)) {
            return;
        }
        this.mBorderCornerRadii[i] = f;
        this.mNeedUpdatePathForBorderRadius = true;
        updateBackgroundImage();
        invalidateSelf();
    }

    public void setBackgroundGradientColor(int i, int[] iArr, float[] fArr) {
        this.mGradient = new a();
        a aVar = this.mGradient;
        aVar.ahA = i;
        aVar.Lr = iArr;
        aVar.Lq = fArr;
        updateBackgroundImage();
        invalidateSelf();
    }

    public void setShadow(float f, float f2, float f3, int i) {
        this.mShadow = new b(f, f2, f3, i);
        this.mNeedUpdatePathForBorderRadius = true;
        updateBackgroundImage();
        invalidateSelf();
    }

    public float getFullBorderRadius() {
        if (isUndefined(this.mBorderRadius)) {
            return 0.0f;
        }
        return this.mBorderRadius;
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        return getBorderRadiusOrDefaultTo(UNDEFINED, borderRadiusLocation);
    }

    public float getBorderRadiusOrDefaultTo(float f, BorderRadiusLocation borderRadiusLocation) {
        float[] fArr = this.mBorderCornerRadii;
        if (fArr == null) {
            return f;
        }
        float f2 = fArr[borderRadiusLocation.ordinal()];
        return isUndefined(f2) ? f : f2;
    }

    public void setColor(int i) {
        this.mColor = i;
        this.mGradient = null;
        invalidateSelf();
    }

    public void removeGradient() {
        this.mGradient = null;
        invalidateSelf();
    }

    public int getResolvedLayoutDirection() {
        return this.mLayoutDirection;
    }

    public int getColor() {
        return this.mColor;
    }

    private void drawRoundedBackgroundWithBorders(Canvas canvas) {
        float f;
        float f2;
        float f3;
        updatePath();
        canvas.save();
        a aVar = this.mGradient;
        if (aVar != null) {
            drawGradient(canvas, aVar);
        } else {
            int iAR = r.aR(this.mColor, this.mAlpha);
            if (Color.alpha(iAR) != 0) {
                this.mPaint.setColor(iAR);
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
            }
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            if (directionAwareBorderInsets.top != fullBorderWidth || directionAwareBorderInsets.bottom != fullBorderWidth || directionAwareBorderInsets.left != fullBorderWidth || directionAwareBorderInsets.right != fullBorderWidth) {
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas.clipPath(this.mOuterClipPathForBorderRadius, Region.Op.INTERSECT);
                canvas.clipPath(this.mInnerClipPathForBorderRadius, Region.Op.DIFFERENCE);
                float f4 = this.mOuterClipTempRectForBorderRadius.left;
                float f5 = this.mOuterClipTempRectForBorderRadius.right;
                float f6 = this.mOuterClipTempRectForBorderRadius.top;
                float f7 = this.mOuterClipTempRectForBorderRadius.bottom;
                if (directionAwareBorderInsets.left > 0.0f) {
                    f = f7;
                    f2 = f6;
                    f3 = f5;
                    drawQuadrilateral(canvas, this.mBorderLeftColor, f4, f6, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, f4, f);
                } else {
                    f = f7;
                    f2 = f6;
                    f3 = f5;
                }
                if (directionAwareBorderInsets.top > 0.0f) {
                    drawQuadrilateral(canvas, this.mBorderTopColor, f4, f2, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerTopRightCorner.x, this.mInnerTopRightCorner.y, f3, f2);
                }
                if (directionAwareBorderInsets.right > 0.0f) {
                    drawQuadrilateral(canvas, this.mBorderRightColor, f3, f2, this.mInnerTopRightCorner.x, this.mInnerTopRightCorner.y, this.mInnerBottomRightCorner.x, this.mInnerBottomRightCorner.y, f3, f);
                }
                if (directionAwareBorderInsets.bottom > 0.0f) {
                    drawQuadrilateral(canvas, this.mBorderBottomColor, f4, f, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, this.mInnerBottomRightCorner.x, this.mInnerBottomRightCorner.y, f3, f);
                }
            } else if (fullBorderWidth > 0.0f) {
                try {
                    this.mPaint.setColor(this.mBorderColor);
                } catch (Exception unused) {
                }
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(fullBorderWidth);
                canvas.drawPath(this.mCenterDrawPath, this.mPaint);
            }
        }
        canvas.restore();
    }

    private void updatePath() {
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            Rect rect = new Rect(getBoundsExcludeShadow());
            this.mInnerClipTempRectForBorderRadius.set(rect);
            this.mOuterClipTempRectForBorderRadius.set(rect);
            this.mTempRectForBorderRadiusOutline.set(rect);
            this.mTempRectForCenterDrawPath.set(rect);
            float fullBorderWidth = getFullBorderWidth();
            if (fullBorderWidth > 0.0f) {
                float f = fullBorderWidth * 0.5f;
                this.mTempRectForCenterDrawPath.inset(f, f);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            this.mInnerClipTempRectForBorderRadius.top += directionAwareBorderInsets.top;
            this.mInnerClipTempRectForBorderRadius.bottom -= directionAwareBorderInsets.bottom;
            this.mInnerClipTempRectForBorderRadius.left += directionAwareBorderInsets.left;
            this.mInnerClipTempRectForBorderRadius.right -= directionAwareBorderInsets.right;
            float fullBorderRadius = getFullBorderRadius();
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = getResolvedLayoutDirection() == 1;
                float borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
                float borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
                float borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                float borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                float f2 = z ? borderRadius2 : borderRadius;
                if (!z) {
                    borderRadius = borderRadius2;
                }
                float f3 = z ? borderRadius4 : borderRadius3;
                if (!z) {
                    borderRadius3 = borderRadius4;
                }
                if (!isUndefined(f2)) {
                    borderRadiusOrDefaultTo = f2;
                }
                if (!isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo2 = borderRadius;
                }
                if (!isUndefined(f3)) {
                    borderRadiusOrDefaultTo3 = f3;
                }
                if (!isUndefined(borderRadius3)) {
                    borderRadiusOrDefaultTo4 = borderRadius3;
                }
            }
            float fMax = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.left, 0.0f);
            float fMax2 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
            float fMax3 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.right, 0.0f);
            float fMax4 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.top, 0.0f);
            float fMax5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, 0.0f);
            float fMax6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, 0.0f);
            float fMax7 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.left, 0.0f);
            float fMax8 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.bottom, 0.0f);
            float f4 = borderRadiusOrDefaultTo3;
            float f5 = borderRadiusOrDefaultTo4;
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{fMax, fMax2, fMax3, fMax4, fMax5, fMax6, fMax7, fMax8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo2, borderRadiusOrDefaultTo2, f5, f5, f4, f4}, Path.Direction.CW);
            x xVar = this.mBorderWidth;
            float f6 = xVar != null ? xVar.get(8) / 2.0f : 0.0f;
            float f7 = borderRadiusOrDefaultTo + f6;
            float f8 = borderRadiusOrDefaultTo2 + f6;
            float f9 = f5 + f6;
            float f10 = f4 + f6;
            this.mPathForBorderRadiusOutline.addRoundRect(this.mTempRectForBorderRadiusOutline, new float[]{f7, f7, f8, f8, f9, f9, f10, f10}, Path.Direction.CW);
            this.mCenterDrawPath.addRoundRect(this.mTempRectForCenterDrawPath, new float[]{fMax + f6, fMax2 + f6, fMax3 + f6, fMax4 + f6, fMax5 + f6, fMax6 + f6, fMax7 + f6, fMax8 + f6}, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            this.mInnerTopLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerTopLeftCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.left + (fMax * 2.0f), this.mInnerClipTempRectForBorderRadius.top + (fMax2 * 2.0f), this.mOuterClipTempRectForBorderRadius.left, this.mOuterClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopLeftCorner);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            this.mInnerBottomLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerBottomLeftCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.bottom - (fMax8 * 2.0f), this.mInnerClipTempRectForBorderRadius.left + (fMax7 * 2.0f), this.mInnerClipTempRectForBorderRadius.bottom, this.mOuterClipTempRectForBorderRadius.left, this.mOuterClipTempRectForBorderRadius.bottom, this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomLeftCorner);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            this.mInnerTopRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerTopRightCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.right - (fMax3 * 2.0f), this.mInnerClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.top + (fMax4 * 2.0f), this.mOuterClipTempRectForBorderRadius.right, this.mOuterClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopRightCorner);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            this.mInnerBottomRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerBottomRightCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.right - (fMax5 * 2.0f), this.mInnerClipTempRectForBorderRadius.bottom - (fMax6 * 2.0f), this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.bottom, this.mOuterClipTempRectForBorderRadius.right, this.mOuterClipTempRectForBorderRadius.bottom, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomRightCorner);
        }
    }

    private static void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        double d9 = (d + d3) / 2.0d;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = d5 - d9;
        double d12 = d6 - d10;
        double dAbs = Math.abs(d3 - d) / 2.0d;
        double dAbs2 = Math.abs(d4 - d2) / 2.0d;
        double d13 = ((d8 - d10) - d12) / ((d7 - d9) - d11);
        double d14 = d12 - (d11 * d13);
        double d15 = dAbs2 * dAbs2;
        double d16 = dAbs * dAbs;
        double d17 = d15 + (d16 * d13 * d13);
        double d18 = dAbs * 2.0d * dAbs * d14 * d13;
        double d19 = (-(d16 * ((d14 * d14) - d15))) / d17;
        double d20 = d17 * 2.0d;
        double dSqrt = ((-d18) / d20) - Math.sqrt(d19 + Math.pow(d18 / d20, 2.0d));
        double d21 = (d13 * dSqrt) + d14;
        double d22 = dSqrt + d9;
        double d23 = d21 + d10;
        if (Double.isNaN(d22) || Double.isNaN(d23)) {
            return;
        }
        pointF.x = (float) d22;
        pointF.y = (float) d23;
    }

    public float getBorderWidthOrDefaultTo(float f, int i) {
        x xVar = this.mBorderWidth;
        if (xVar == null) {
            return f;
        }
        float fEf = xVar.ef(i);
        return isUndefined(fEf) ? f : fEf;
    }

    private void updatePathEffect(BorderStyle borderStyle, float f) {
        this.mPathEffectForBorderStyle = borderStyle != null ? BorderStyle.getPathEffect(borderStyle, f) : null;
        this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
    }

    public float getFullBorderWidth() {
        x xVar = this.mBorderWidth;
        if (xVar == null || isUndefined(xVar.ef(8))) {
            return 0.0f;
        }
        return this.mBorderWidth.ef(8);
    }

    private void drawRectangularBackgroundWithBorders(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        TKViewBackgroundDrawable tKViewBackgroundDrawable;
        int i5;
        int iAR = r.aR(this.mColor, this.mAlpha);
        a aVar = this.mGradient;
        if (aVar != null) {
            drawGradient(canvas, aVar);
        } else if (Color.alpha(iAR) != 0) {
            this.mPaint.setColor(iAR);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(getBoundsExcludeShadow(), this.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int iRound = Math.round(directionAwareBorderInsets.left);
        int iRound2 = Math.round(directionAwareBorderInsets.top);
        int iRound3 = Math.round(directionAwareBorderInsets.right);
        int iRound4 = Math.round(directionAwareBorderInsets.bottom);
        if (iRound > 0 || iRound3 > 0 || iRound2 > 0 || iRound4 > 0) {
            Rect boundsExcludeShadow = getBoundsExcludeShadow();
            int i6 = boundsExcludeShadow.left;
            int i7 = boundsExcludeShadow.top;
            int iFastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(iRound, iRound2, iRound3, iRound4, this.mBorderLeftColor, this.mBorderTopColor, this.mBorderRightColor, this.mBorderBottomColor);
            if (iFastBorderCompatibleColorOrZero != 0) {
                if (Color.alpha(iFastBorderCompatibleColorOrZero) != 0) {
                    int i8 = boundsExcludeShadow.right;
                    int i9 = boundsExcludeShadow.bottom;
                    this.mPaint.setColor(iFastBorderCompatibleColorOrZero);
                    if (iRound > 0) {
                        i5 = i7;
                        canvas.drawRect(i6, i7, i6 + iRound, i9 - iRound4, this.mPaint);
                    } else {
                        i5 = i7;
                    }
                    if (iRound2 > 0) {
                        canvas.drawRect(iRound + i6, i5, i8, i5 + iRound2, this.mPaint);
                    }
                    if (iRound3 > 0) {
                        canvas.drawRect(i8 - iRound3, i5 + iRound2, i8, i9, this.mPaint);
                    }
                    if (iRound4 > 0) {
                        canvas.drawRect(i6, i9 - iRound4, i8 - iRound3, i9, this.mPaint);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mPaint.setAntiAlias(false);
            int iWidth = boundsExcludeShadow.width();
            int iHeight = boundsExcludeShadow.height();
            if (iRound > 0) {
                float f = i6;
                float f2 = i6 + iRound;
                i = i7;
                i2 = i6;
                drawQuadrilateral(canvas, this.mBorderLeftColor, f, i7, f2, i7 + iRound2, f2, r1 - iRound4, f, i7 + iHeight);
            } else {
                i = i7;
                i2 = i6;
            }
            if (iRound2 > 0) {
                float f3 = i;
                float f4 = i2 + iRound;
                float f5 = i + iRound2;
                int i10 = i2 + iWidth;
                int i11 = i2;
                tKViewBackgroundDrawable = this;
                i3 = iRound;
                i4 = i11;
                drawQuadrilateral(canvas, tKViewBackgroundDrawable.mBorderTopColor, i2, f3, f4, f5, i10 - iRound3, f5, i10, f3);
            } else {
                i3 = iRound;
                i4 = i2;
                tKViewBackgroundDrawable = this;
            }
            if (iRound3 > 0) {
                int i12 = i4 + iWidth;
                float f6 = i12;
                float f7 = i12 - iRound3;
                drawQuadrilateral(canvas, tKViewBackgroundDrawable.mBorderRightColor, f6, i, f6, i + iHeight, f7, r1 - iRound4, f7, i + iRound2);
            }
            if (iRound4 > 0) {
                int i13 = i + iHeight;
                float f8 = i13;
                int i14 = i4 + iWidth;
                float f9 = i14;
                float f10 = i14 - iRound3;
                float f11 = i13 - iRound4;
                drawQuadrilateral(canvas, tKViewBackgroundDrawable.mBorderBottomColor, i4, f8, f9, f8, f10, f11, i4 + i3, f11);
            }
            tKViewBackgroundDrawable.mPaint.setAntiAlias(true);
        }
    }

    private void drawGradient(Canvas canvas, a aVar) {
        float[] fArrA = com.tk.core.component.view.b.a(aVar.ahA, getBoundsExcludeShadow());
        LinearGradient linearGradient = new LinearGradient(fArrA[0], fArrA[1], fArrA[2], fArrA[3], aVar.Lr, aVar.Lq, Shader.TileMode.CLAMP);
        if (this.mGradientPaint == null) {
            this.mGradientPaint = new Paint();
        }
        this.mGradientPaint.setShader(linearGradient);
        if (!hasRoundedBorders()) {
            canvas.drawRect(getBoundsExcludeShadow(), this.mGradientPaint);
        } else {
            canvas.drawPath(this.mInnerClipPathForBorderRadius, this.mGradientPaint);
        }
    }

    private void drawShadowIfNeed(Canvas canvas) {
        if (this.mShadow == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            drawShadow(canvas);
        } else {
            drawShadowBelow_9_0(canvas);
        }
    }

    private void drawShadow(Canvas canvas) {
        if (this.mShadowPaint == null) {
            this.mShadowPaint = new Paint();
        }
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setShadowLayer(this.mShadow.ahB, this.mShadow.ahC, this.mShadow.ahD, transparentColor(this.mShadow.color));
        if (hasRoundedBorders()) {
            canvas.drawPath(this.mOuterClipPathForBorderRadius, this.mShadowPaint);
        } else {
            canvas.drawRect(getBoundsExcludeShadow(), this.mShadowPaint);
        }
    }

    private void drawShadowBelow_9_0(Canvas canvas) {
        try {
            int i = (int) (this.mShadow.ahB * 2.4f);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getBounds().width() + i, getBounds().height() + i, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f = i;
            canvas2.translate(f, f);
            if (this.mShadowPaint == null) {
                this.mShadowPaint = new Paint();
            }
            this.mShadowPaint.setColor(0);
            this.mShadowPaint.setStyle(Paint.Style.FILL);
            this.mShadowPaint.setShadowLayer(this.mShadow.ahB, this.mShadow.ahC, this.mShadow.ahD, transparentColor(this.mShadow.color));
            if (hasRoundedBorders()) {
                canvas2.drawPath(this.mOuterClipPathForBorderRadius, this.mShadowPaint);
            } else {
                canvas2.drawRect(getBoundsExcludeShadow(), this.mShadowPaint);
            }
            float f2 = -i;
            canvas.drawBitmap(bitmapCreateBitmap, f2, f2, (Paint) null);
            if (bitmapCreateBitmap.isRecycled()) {
                return;
            }
            bitmapCreateBitmap.recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i == 0) {
            return;
        }
        if (this.mPathForBorder == null) {
            this.mPathForBorder = new Path();
        }
        this.mPaint.setColor(i);
        this.mPathForBorder.reset();
        this.mPathForBorder.moveTo(f, f2);
        this.mPathForBorder.lineTo(f3, f4);
        this.mPathForBorder.lineTo(f5, f6);
        this.mPathForBorder.lineTo(f7, f8);
        this.mPathForBorder.lineTo(f, f2);
        canvas.drawPath(this.mPathForBorder, this.mPaint);
    }

    private int getBorderWidth(int i) {
        x xVar = this.mBorderWidth;
        if (xVar == null) {
            return 0;
        }
        float f = xVar.get(i);
        if (isUndefined(f)) {
            return -1;
        }
        return Math.round(f);
    }

    @Deprecated
    private Rect getBoundsExcludeShadow() {
        return getBounds();
    }

    public RectF getDirectionAwareBorderInsets() {
        float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(0.0f, 8);
        float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
        float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
        float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
        float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
        if (Build.VERSION.SDK_INT >= 17 && this.mBorderWidth != null) {
            boolean z = getResolvedLayoutDirection() == 1;
            float fEf = this.mBorderWidth.ef(4);
            float fEf2 = this.mBorderWidth.ef(5);
            float f = z ? fEf2 : fEf;
            if (!z) {
                fEf = fEf2;
            }
            if (!isUndefined(f)) {
                borderWidthOrDefaultTo4 = f;
            }
            if (!isUndefined(fEf)) {
                borderWidthOrDefaultTo5 = fEf;
            }
        }
        Rect bounds = getBounds();
        float fMax = Math.max(bounds.width(), bounds.height()) / 2.0f;
        if (fMax > 0.0f) {
            return new RectF(Math.min(borderWidthOrDefaultTo4, fMax), Math.min(borderWidthOrDefaultTo2, fMax), Math.min(borderWidthOrDefaultTo5, fMax), Math.min(borderWidthOrDefaultTo3, fMax));
        }
        return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
    }

    private void updatePaintOnBorderStyle(BorderStyle borderStyle, float f) {
        if (borderStyle != null) {
            updatePathEffect(borderStyle, f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(f * 2.0f);
        } else {
            updatePathEffect(null, 0.0f);
            this.mPaint.setStyle(Paint.Style.FILL);
        }
    }

    public static class b {
        public float ahB;
        public float ahC;
        public float ahD;
        public int color;

        public b(float f, float f2, float f3, int i) {
            this.ahB = f;
            this.ahC = f2;
            this.ahD = f3;
            this.color = i;
        }
    }

    private void drawBackgroundImage(Canvas canvas) {
        if (this.mBackgroundImageDrawable == null) {
            return;
        }
        Path path = this.mBackgroundImagePath;
        if (path != null) {
            canvas.clipPath(path);
        }
        if (this.mBackgroundImageOffsetX != 0 || this.mBackgroundImageOffsetY != 0) {
            canvas.translate(this.mBackgroundImageOffsetX, this.mBackgroundImageOffsetY);
        }
        try {
            this.mBackgroundImageDrawable.draw(canvas);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(this.mTKJSContext, th);
        }
    }

    public void updateBackgroundImage(Bitmap bitmap, String str, String str2) {
        this.mBackgroundImageBitmap = bitmap;
        this.mBackgroundSize = str;
        this.mBackgroundPosition = str2;
        updateBackgroundImage();
        invalidateSelf();
    }

    private void updateBackgroundImage() {
        Bitmap bitmap = this.mBackgroundImageBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            return;
        }
        createBackgroundImagePath(bounds);
        createBackgroundImageDrawable(bounds);
        createBackgroundImageOffset(bounds);
    }

    private void createBackgroundImagePath(Rect rect) {
        if (hasRoundedBorders()) {
            if (this.mInnerClipPathForBorderRadius == null) {
                updatePath();
            }
            this.mBackgroundImagePath = this.mInnerClipPathForBorderRadius;
            return;
        }
        RectF rectF = this.mBackgroundImageRectF;
        if (rectF == null) {
            this.mBackgroundImageRectF = new RectF(getBorderWidth(0), getBorderWidth(1), rect.right - getBorderWidth(2), rect.bottom - getBorderWidth(3));
        } else {
            rectF.left = getBorderWidth(0);
            this.mBackgroundImageRectF.top = getBorderWidth(1);
            this.mBackgroundImageRectF.right = rect.right - getBorderWidth(2);
            this.mBackgroundImageRectF.bottom = rect.bottom - getBorderWidth(3);
        }
        Path path = this.mBackgroundImagePath;
        if (path == null) {
            this.mBackgroundImagePath = new Path();
        } else {
            path.reset();
        }
        this.mBackgroundImagePath.addRect(this.mBackgroundImageRectF, Path.Direction.CW);
    }

    private void createBackgroundImageDrawable(Rect rect) {
        int width;
        int height;
        int[] iArrTargetSize;
        Bitmap bitmapCreateScaledBitmap = this.mBackgroundImageBitmap;
        if (!TextUtils.isEmpty(this.mBackgroundSize) && (iArrTargetSize = targetSize((width = this.mBackgroundImageBitmap.getWidth()), (height = this.mBackgroundImageBitmap.getHeight()), rect)) != null && iArrTargetSize.length == 2 && (iArrTargetSize[0] != width || iArrTargetSize[1] != height)) {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.mBackgroundImageBitmap, iArrTargetSize[0], iArrTargetSize[1], true);
        }
        this.mBackgroundImageDrawable = new BitmapDrawable(this.mContext.getResources(), bitmapCreateScaledBitmap);
        Drawable drawable = this.mBackgroundImageDrawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mBackgroundImageDrawable.getIntrinsicHeight());
    }

    private int[] targetSize(int i, int i2, Rect rect) {
        CharSequence charSequence;
        if (i != 0 && i2 != 0) {
            int[] iArr = new int[2];
            if (BACKGROUND_SIZE_CONTAIN.equals(this.mBackgroundSize)) {
                double d = i;
                Double.isNaN(d);
                double d2 = i2;
                Double.isNaN(d2);
                double d3 = (d * 1.0d) / d2;
                double dWidth = rect.width();
                Double.isNaN(dWidth);
                double dHeight = rect.height();
                Double.isNaN(dHeight);
                if (d3 >= (dWidth * 1.0d) / dHeight) {
                    iArr[0] = rect.width();
                    double dWidth2 = rect.width() * i2;
                    Double.isNaN(dWidth2);
                    Double.isNaN(d);
                    iArr[1] = (int) ((dWidth2 * 1.0d) / d);
                } else {
                    iArr[1] = rect.height();
                    double dHeight2 = rect.height() * i;
                    Double.isNaN(dHeight2);
                    Double.isNaN(d2);
                    iArr[0] = (int) ((dHeight2 * 1.0d) / d2);
                }
            } else if (BACKGROUND_SIZE_COVER.equals(this.mBackgroundSize)) {
                double d4 = i;
                Double.isNaN(d4);
                double d5 = i2;
                Double.isNaN(d5);
                double d6 = (d4 * 1.0d) / d5;
                double dWidth3 = rect.width();
                Double.isNaN(dWidth3);
                double dHeight3 = rect.height();
                Double.isNaN(dHeight3);
                if (d6 <= (dWidth3 * 1.0d) / dHeight3) {
                    iArr[0] = rect.width();
                    double dWidth4 = rect.width() * i2;
                    Double.isNaN(dWidth4);
                    Double.isNaN(d4);
                    iArr[1] = (int) ((dWidth4 * 1.0d) / d4);
                } else {
                    iArr[1] = rect.height();
                    double dHeight4 = rect.height() * i;
                    Double.isNaN(dHeight4);
                    Double.isNaN(d5);
                    iArr[0] = (int) ((dHeight4 * 1.0d) / d5);
                }
            } else {
                try {
                    String[] strArrSplit = this.mBackgroundSize.split(" ");
                    if (strArrSplit.length == 2) {
                        if (strArrSplit[0].endsWith("%")) {
                            strArrSplit[0] = strArrSplit[0].replace("%", "");
                            double d7 = Double.parseDouble(strArrSplit[0]);
                            if (d7 > 0.0d && d7 <= 100.0d) {
                                charSequence = "";
                                double dWidth5 = rect.width();
                                Double.isNaN(dWidth5);
                                iArr[0] = (int) ((dWidth5 * d7) / 100.0d);
                            }
                            return null;
                        }
                        charSequence = "";
                        double d8 = Double.parseDouble(strArrSplit[0]);
                        if (d8 <= 0.0d) {
                            return null;
                        }
                        iArr[0] = o.P((float) d8);
                        if (strArrSplit[1].endsWith("%")) {
                            strArrSplit[1] = strArrSplit[1].replace("%", charSequence);
                            double d9 = Double.parseDouble(strArrSplit[1]);
                            if (d9 > 0.0d && d9 <= 100.0d) {
                                double dHeight5 = rect.height();
                                Double.isNaN(dHeight5);
                                iArr[1] = (int) ((dHeight5 * d9) / 100.0d);
                            }
                            return null;
                        }
                        double d10 = Double.parseDouble(strArrSplit[1]);
                        if (d10 <= 0.0d) {
                            return null;
                        }
                        iArr[1] = o.P((float) d10);
                    } else {
                        throw new Exception("backgroundSize length illegal: " + strArrSplit.length);
                    }
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(this.mTKJSContext, th);
                }
            }
            return iArr;
        }
        return null;
    }

    private void createBackgroundImageOffset(Rect rect) {
        int iWidth = rect.width() - this.mBackgroundImageDrawable.getIntrinsicWidth();
        int iHeight = rect.height() - this.mBackgroundImageDrawable.getIntrinsicHeight();
        if (TextUtils.isEmpty(this.mBackgroundPosition)) {
            this.mBackgroundImageOffsetX = iWidth / 2;
            this.mBackgroundImageOffsetY = iHeight / 2;
            return;
        }
        String[] strArrSplit = this.mBackgroundPosition.split(" ");
        if (strArrSplit.length == 2) {
            if (j.d.equals(strArrSplit[0])) {
                this.mBackgroundImageOffsetX = 0;
            } else if (j.e.equals(strArrSplit[0])) {
                this.mBackgroundImageOffsetX = iWidth;
            } else if ("center".equals(strArrSplit[0])) {
                this.mBackgroundImageOffsetX = iWidth / 2;
            }
            if (j.f.equals(strArrSplit[1])) {
                this.mBackgroundImageOffsetY = 0;
                return;
            } else if (j.g.equals(strArrSplit[1])) {
                this.mBackgroundImageOffsetY = iHeight;
                return;
            } else {
                if ("center".equals(strArrSplit[1])) {
                    this.mBackgroundImageOffsetY = iHeight / 2;
                    return;
                }
                return;
            }
        }
        this.mBackgroundImageOffsetX = iWidth / 2;
        this.mBackgroundImageOffsetY = iHeight / 2;
        com.tk.core.i.a.a("TKViewBackgroundDrawable", "backgroundPosition size illegal, size is: " + strArrSplit.length, null);
    }

    public void destroy() {
        this.mIsDestroy = true;
        this.mBackgroundImageBitmap = null;
    }
}
