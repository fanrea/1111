package com.bytedance.sdk.djx.core.business.buguide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.sdk.djx.core.business.buguide.DJXGuideConfig;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXGuideView extends ConstraintLayout {
    private DJXGuideConfig.Anchor mAnchor;
    private final int[] mAnchorViewCoordinate;
    private DJXGuideConfig mConfig;
    private Context mContext;
    private boolean mIsShowing;
    private int mLineAnchorInterval;
    private int mLinkAnchorImageResId;
    private ImageView mLinkAnchorView;
    private Paint mPaint;
    private int mScreenHeight;
    private int mScreenWidth;

    public DJXGuideView(Context context) {
        super(context);
        this.mAnchorViewCoordinate = new int[2];
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mIsShowing = false;
        this.mLinkAnchorView = null;
        init(context);
    }

    public DJXGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnchorViewCoordinate = new int[2];
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mIsShowing = false;
        this.mLinkAnchorView = null;
        init(context);
    }

    public DJXGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnchorViewCoordinate = new int[2];
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mIsShowing = false;
        this.mLinkAnchorView = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(Color.parseColor("#D0000000"));
        getScreenSize(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawAnchorMask(canvas);
    }

    public DJXGuideView updateConfig(DJXGuideConfig dJXGuideConfig) {
        this.mConfig = dJXGuideConfig;
        this.mAnchor = dJXGuideConfig.getAnchor();
        this.mLinkAnchorImageResId = this.mConfig.getLinkAnchorRes();
        this.mLineAnchorInterval = this.mConfig.getLinkAnchorInterval();
        setBackgroundColor(this.mConfig.getBackgroundColorInt());
        getCoordinate();
        return this;
    }

    public void show() {
        if (this.mConfig == null || this.mIsShowing) {
            return;
        }
        addRealAnchor();
        addLinkAnchorView();
        addHintView();
        this.mIsShowing = true;
    }

    public void hide() {
        if (this.mIsShowing) {
            removeAllViews();
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
            }
            this.mIsShowing = false;
        }
    }

    private void drawAnchorMask(Canvas canvas) {
        int[] anchorViewSize;
        Bitmap bitmapCreateBitmap;
        float fDp2px;
        int height;
        DJXGuideConfig.Anchor anchor = this.mAnchor;
        if (anchor == null || (anchorViewSize = anchor.getAnchorViewSize()) == null) {
            return;
        }
        int width = canvas.getWidth();
        if (width == 0 || (height = canvas.getHeight()) == 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(this.mScreenWidth, this.mScreenHeight, Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        canvas2.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.mPaint);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        this.mPaint.setAntiAlias(true);
        int i = anchorViewSize[0];
        int i2 = anchorViewSize[1];
        float f = i / 2.0f;
        float f2 = r5[0] + f;
        float f3 = this.mAnchorViewCoordinate[1];
        float f4 = i2 / 2.0f;
        float f5 = f3 + f4;
        if (i >= i2) {
            fDp2px = f + 3.0f + UIUtil.dp2px(this.mConfig.getGap());
        } else {
            fDp2px = f4 + 3.0f + UIUtil.dp2px(this.mConfig.getGap());
        }
        canvas2.drawCircle(f2, f5, fDp2px, this.mPaint);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.mPaint);
    }

    private void getScreenSize(Context context) {
        this.mScreenWidth = UIUtil.getScreenWidth(context);
        this.mScreenHeight = UIUtil.getScreenHeight(context);
    }

    private void getCoordinate() {
        int[] anchorCoordinate;
        DJXGuideConfig.Anchor anchor = this.mAnchor;
        if (anchor == null || (anchorCoordinate = anchor.getAnchorCoordinate()) == null) {
            return;
        }
        int[] iArr = this.mAnchorViewCoordinate;
        iArr[0] = anchorCoordinate[0];
        iArr[1] = anchorCoordinate[1] - UIUtil.getStatusBarHeight(this.mContext);
    }

    private void addRealAnchor() {
        int[] anchorViewSize = this.mAnchor.getAnchorViewSize();
        int i = anchorViewSize[0];
        int i2 = anchorViewSize[1];
        int[] iArr = this.mAnchorViewCoordinate;
        float f = iArr[0];
        float f2 = iArr[1];
        ImageView imageView = new ImageView(this.mContext);
        imageView.setBackgroundColor(this.mContext.getResources().getColor(R.color.djx_transparent_color));
        imageView.setId(R.id.djx_id_guide_line);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i, i2);
        layoutParams.leftToLeft = 0;
        layoutParams.topToTop = 0;
        layoutParams.leftMargin = (int) f;
        layoutParams.topMargin = (int) f2;
        addView(imageView, layoutParams);
    }

    private void addLinkAnchorView() {
        if (this.mLinkAnchorImageResId == 0 || this.mAnchor == null) {
            return;
        }
        ImageView imageView = new ImageView(this.mContext);
        this.mLinkAnchorView = imageView;
        imageView.setId(R.id.djx_id_guide_link_image_view);
        this.mLinkAnchorView.setImageResource(this.mLinkAnchorImageResId);
        this.mLinkAnchorView.setScaleType(ImageView.ScaleType.FIT_XY);
        int hintPosition = this.mConfig.getHintPosition();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        if (hintPosition == 0) {
            layoutParams.topToTop = R.id.djx_id_guide_line;
            layoutParams.bottomToBottom = R.id.djx_id_guide_line;
            layoutParams.rightToLeft = R.id.djx_id_guide_line;
            layoutParams.rightMargin = UIUtil.dp2px(this.mLineAnchorInterval);
        } else if (hintPosition == 1) {
            layoutParams.topToTop = R.id.djx_id_guide_line;
            layoutParams.bottomToBottom = R.id.djx_id_guide_line;
            layoutParams.leftToRight = R.id.djx_id_guide_line;
            layoutParams.leftMargin = UIUtil.dp2px(this.mLineAnchorInterval);
        } else if (hintPosition == 2) {
            layoutParams.leftToLeft = R.id.djx_id_guide_line;
            layoutParams.rightToRight = R.id.djx_id_guide_line;
            layoutParams.bottomToTop = R.id.djx_id_guide_line;
            layoutParams.bottomMargin = UIUtil.dp2px(this.mLineAnchorInterval);
        } else if (hintPosition == 3) {
            layoutParams.leftToLeft = R.id.djx_id_guide_line;
            layoutParams.rightToRight = R.id.djx_id_guide_line;
            layoutParams.topToBottom = R.id.djx_id_guide_line;
            layoutParams.topMargin = UIUtil.dp2px(this.mLineAnchorInterval);
        }
        addView(this.mLinkAnchorView, layoutParams);
    }

    private void addHintView() {
        View hintView;
        int[] anchorViewSize;
        if (this.mAnchor == null || (hintView = this.mConfig.getHintView()) == null || (anchorViewSize = this.mAnchor.getAnchorViewSize()) == null) {
            return;
        }
        int hintPosition = this.mConfig.getHintPosition();
        int measuredWidth = hintView.getMeasuredWidth();
        int measuredHeight = hintView.getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            doHintViewMeasure(hintView);
            measuredWidth = hintView.getMeasuredWidth();
            measuredHeight = hintView.getMeasuredHeight();
        }
        int i = anchorViewSize[0];
        int i2 = anchorViewSize[1];
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        if (hintPosition == 0) {
            int i3 = this.mAnchorViewCoordinate[1];
            int i4 = i2 / 2;
            int i5 = measuredHeight / 2;
            if ((i3 + i4) - i5 <= 0) {
                layoutParams.topToTop = 0;
                layoutParams.rightToLeft = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.topMargin = UIUtil.dp2px(5.0f);
            } else if (((this.mScreenHeight - i3) - i4) - i5 <= 0) {
                layoutParams.bottomToBottom = 0;
                layoutParams.rightToLeft = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.bottomMargin = UIUtil.dp2px(5.0f);
            } else {
                layoutParams.topToTop = R.id.djx_id_guide_line;
                layoutParams.bottomToBottom = R.id.djx_id_guide_line;
                layoutParams.rightToLeft = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
            }
        } else if (hintPosition == 1) {
            int i6 = this.mAnchorViewCoordinate[1];
            int i7 = i2 / 2;
            int i8 = measuredHeight / 2;
            if ((i6 + i7) - i8 <= 0) {
                layoutParams.topToTop = 0;
                layoutParams.leftToRight = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.topMargin = UIUtil.dp2px(5.0f);
            } else if (((this.mScreenHeight - i6) - i7) - i8 <= 0) {
                layoutParams.bottomToBottom = 0;
                layoutParams.leftToRight = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.bottomMargin = UIUtil.dp2px(5.0f);
            } else {
                layoutParams.topToTop = R.id.djx_id_guide_line;
                layoutParams.bottomToBottom = R.id.djx_id_guide_line;
                layoutParams.leftToRight = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
            }
        } else if (hintPosition == 2) {
            int i9 = this.mAnchorViewCoordinate[0];
            int i10 = i / 2;
            int i11 = measuredWidth / 2;
            if ((i9 + i10) - i11 <= 0) {
                layoutParams.leftToLeft = 0;
                layoutParams.bottomToTop = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.leftMargin = UIUtil.dp2px(5.0f);
            } else if (((this.mScreenWidth - i9) - i10) - i11 <= 0) {
                layoutParams.rightToRight = 0;
                layoutParams.bottomToTop = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.rightMargin = UIUtil.dp2px(5.0f);
            } else {
                layoutParams.leftToLeft = R.id.djx_id_guide_line;
                layoutParams.rightToRight = R.id.djx_id_guide_line;
                layoutParams.bottomToTop = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
            }
        } else if (hintPosition == 3) {
            int i12 = this.mAnchorViewCoordinate[0];
            int i13 = i / 2;
            int i14 = measuredWidth / 2;
            if ((i12 + i13) - i14 <= 0) {
                layoutParams.leftToLeft = 0;
                layoutParams.topToBottom = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.leftMargin = UIUtil.dp2px(5.0f);
            } else if (((this.mScreenWidth - i12) - i13) - i14 <= 0) {
                layoutParams.rightToRight = 0;
                layoutParams.topToBottom = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
                layoutParams.rightMargin = UIUtil.dp2px(5.0f);
            } else {
                layoutParams.leftToLeft = R.id.djx_id_guide_line;
                layoutParams.rightToRight = R.id.djx_id_guide_line;
                layoutParams.topToBottom = this.mLinkAnchorView != null ? R.id.djx_id_guide_link_image_view : R.id.djx_id_guide_line;
            }
        }
        addView(hintView, layoutParams);
    }

    private void doHintViewMeasure(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = 0;
        if (layoutParams != null) {
            int i2 = layoutParams.width;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, (i2 == -1 || i2 == -2) ? Integer.MIN_VALUE : i2 >= 0 ? 1073741824 : 0);
            int i3 = layoutParams.height;
            if (i3 == -1 || i3 == -2) {
                i = Integer.MIN_VALUE;
            } else if (i3 >= 0) {
                i = 1073741824;
            }
            view.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(layoutParams.height, i));
            return;
        }
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec2);
    }
}
