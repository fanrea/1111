package com.fendasz.moku.planet.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class GuideDialog extends Dialog {
    private static final String TAG = "GuideDialog";

    /* synthetic */ GuideDialog(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    private GuideDialog(Context context) {
        super(context, R.style.MokuDialogTheme);
    }

    public static class Builder {
        private Context mContext;
        private Bitmap mGuideAreaBitmap;
        private int mGuideAreaHeight;
        private int mGuideAreaWidth;
        private int mGuideAreaX;
        private int mGuideAreaY;
        private View mHighlightView;
        private int mHighlightViewHeight;
        private int mHighlightViewWidth;
        private int mHighlightX;
        private int mHighlightY;
        private PhoneScreenUtils mPhoneScreenUtils;
        private int mScreenHeight;
        private int mScreenWidth;
        private View mView;
        private boolean mIsHighlight = true;
        private Integer mHighlightViewColor = null;
        private int[] mHighlightViewMargin = new int[4];
        private Orientation mOrientation = null;
        private Integer mBackgroundColor = null;
        private int[] mGuideAreaMargin = new int[4];
        private boolean mIsCancelable = true;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setHighlightView(View view) {
            this.mHighlightView = view;
            return this;
        }

        public Builder setIsHighlight(boolean z) {
            this.mIsHighlight = z;
            return this;
        }

        public Builder setHighlightViewColor(Integer num) {
            this.mHighlightViewColor = num;
            return this;
        }

        public Builder setHighlightViewMargin(Integer num) {
            setHighlightViewMargin(num, num, num, num);
            return this;
        }

        public Builder setHighlightViewMarginTopAndBottom(Integer num) {
            setHighlightViewMarginTopAndBottom(num, num);
            return this;
        }

        public Builder setHighlightViewMarginTopAndBottom(Integer num, Integer num2) {
            setHighlightViewMargin(num, null, num2, null);
            return this;
        }

        public Builder setHighlightViewMarginLeftAndRight(Integer num) {
            setHighlightViewMarginLeftAndRight(num, num);
            return this;
        }

        public Builder setHighlightViewMarginLeftAndRight(Integer num, Integer num2) {
            setHighlightViewMargin(null, num, null, num2);
            return this;
        }

        public Builder setHighlightViewMargin(Integer num, Integer num2, Integer num3, Integer num4) {
            if (num != null) {
                this.mHighlightViewMargin[0] = num.intValue();
            }
            if (num2 != null) {
                this.mHighlightViewMargin[1] = num2.intValue();
            }
            if (num3 != null) {
                this.mHighlightViewMargin[2] = num3.intValue();
            }
            if (num4 != null) {
                this.mHighlightViewMargin[3] = num4.intValue();
            }
            return this;
        }

        public Builder setOrientation(Orientation orientation) {
            this.mOrientation = orientation;
            return this;
        }

        public Builder setGuideBitmap(Bitmap bitmap) {
            this.mGuideAreaBitmap = bitmap;
            return this;
        }

        public Builder setBackgroundColor(Integer num) {
            this.mBackgroundColor = num;
            return this;
        }

        public Builder setGuideBitMapMargin(Integer num) {
            setGuideBitMapMargin(num, num, num, num);
            return this;
        }

        public Builder setGuideBitMapMarginTopAndBottom(Integer num) {
            setGuideBitMapMarginTopAndBottom(num, num);
            return this;
        }

        public Builder setGuideBitMapMarginTopAndBottom(Integer num, Integer num2) {
            setGuideBitMapMargin(num, null, num2, null);
            return this;
        }

        public Builder setGuideBitMapMarginLeftAndRight(Integer num) {
            setGuideBitMapMarginLeftAndRight(num, num);
            return this;
        }

        public Builder setGuideBitMapMarginLeftAndRight(Integer num, Integer num2) {
            setGuideBitMapMargin(null, num, null, num2);
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mIsCancelable = z;
            return this;
        }

        public Builder setGuideBitMapMargin(Integer num, Integer num2, Integer num3, Integer num4) {
            if (num != null) {
                this.mGuideAreaMargin[0] = num.intValue();
            }
            if (num2 != null) {
                this.mGuideAreaMargin[1] = num2.intValue();
            }
            if (num3 != null) {
                this.mGuideAreaMargin[2] = num3.intValue();
            }
            if (num4 != null) {
                this.mGuideAreaMargin[3] = num4.intValue();
            }
            return this;
        }

        public Builder setView(View view) {
            this.mView = view;
            return this;
        }

        public GuideDialog create() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            int i;
            int i2;
            final GuideDialog guideDialog = new GuideDialog(this.mContext, null);
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_dialog_guide, (ViewGroup) null);
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.iv_guide);
            if (this.mView != null) {
                this.mView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(this.mView);
            }
            PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
            this.mPhoneScreenUtils = phoneScreenUtils;
            this.mScreenWidth = phoneScreenUtils.getWidthPixels(this.mContext);
            this.mScreenHeight = getRealHeight(this.mContext);
            View view = this.mHighlightView;
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                this.mHighlightX = iArr[0];
                this.mHighlightY = iArr[1];
                this.mHighlightViewHeight = this.mHighlightView.getHeight();
                this.mHighlightViewWidth = this.mHighlightView.getWidth();
                if (this.mGuideAreaBitmap != null) {
                    if (this.mOrientation == null) {
                        this.mOrientation = getOrientation();
                    }
                    setGuideArea();
                }
            }
            int statusBarHeight = getStatusBarHeight(this.mContext);
            int virtualBarHeight = getVirtualBarHeight(this.mContext);
            getHeight(this.mContext);
            if (virtualBarHeight == 0 || (i2 = virtualBarHeight - statusBarHeight) == 0) {
                i = this.mScreenHeight - statusBarHeight;
            } else if (i2 > statusBarHeight) {
                i = this.mScreenHeight - virtualBarHeight;
            } else {
                i = (this.mScreenHeight - virtualBarHeight) - statusBarHeight;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.mScreenWidth, i, Bitmap.Config.ARGB_8888);
            draw(new Canvas(bitmapCreateBitmap));
            imageView.setImageBitmap(bitmapCreateBitmap);
            guideDialog.setContentView(frameLayout);
            guideDialog.setCancelable(this.mIsCancelable);
            if (this.mIsCancelable && this.mView == null) {
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.GuideDialog.Builder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        guideDialog.dismiss();
                    }
                });
            }
            return guideDialog;
        }

        private void setGuideArea() {
            switch (AnonymousClass1.$SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[this.mOrientation.ordinal()]) {
                case 1:
                    this.mGuideAreaX = 0;
                    this.mGuideAreaY = 0;
                    this.mGuideAreaWidth = this.mHighlightX + this.mHighlightViewWidth;
                    this.mGuideAreaHeight = this.mHighlightY;
                    break;
                case 2:
                    int i = this.mHighlightX;
                    this.mGuideAreaX = i;
                    this.mGuideAreaY = 0;
                    this.mGuideAreaWidth = this.mScreenWidth - i;
                    this.mGuideAreaHeight = this.mHighlightY;
                    break;
                case 3:
                    int i2 = this.mHighlightX;
                    int i3 = this.mHighlightViewWidth;
                    this.mGuideAreaX = i2 + i3;
                    this.mGuideAreaY = 0;
                    this.mGuideAreaWidth = (this.mScreenWidth - i2) - i3;
                    this.mGuideAreaHeight = this.mHighlightY + this.mHighlightViewHeight;
                    break;
                case 4:
                    int i4 = this.mHighlightX;
                    int i5 = this.mHighlightViewWidth;
                    this.mGuideAreaX = i4 + i5;
                    int i6 = this.mHighlightY;
                    this.mGuideAreaY = i6;
                    this.mGuideAreaWidth = (this.mScreenWidth - i4) - i5;
                    this.mGuideAreaHeight = this.mScreenHeight - i6;
                    break;
                case 5:
                    int i7 = this.mHighlightX;
                    this.mGuideAreaX = i7;
                    int i8 = this.mHighlightY;
                    int i9 = this.mHighlightViewHeight;
                    this.mGuideAreaY = i8 + i9;
                    this.mGuideAreaWidth = this.mScreenWidth - i7;
                    this.mGuideAreaHeight = (this.mScreenHeight - i8) - i9;
                    break;
                case 6:
                    this.mGuideAreaX = 0;
                    int i10 = this.mHighlightY;
                    int i11 = this.mHighlightViewHeight;
                    this.mGuideAreaY = i10 + i11;
                    this.mGuideAreaWidth = this.mHighlightX + this.mHighlightViewWidth;
                    this.mGuideAreaHeight = (this.mScreenHeight - i10) - i11;
                    break;
                case 7:
                    this.mGuideAreaX = 0;
                    int i12 = this.mHighlightY;
                    this.mGuideAreaY = i12;
                    this.mGuideAreaWidth = this.mHighlightX;
                    this.mGuideAreaHeight = this.mScreenHeight - i12;
                    break;
                case 8:
                    this.mGuideAreaX = 0;
                    this.mGuideAreaY = 0;
                    this.mGuideAreaWidth = this.mHighlightX;
                    this.mGuideAreaHeight = this.mHighlightY + this.mHighlightViewHeight;
                    break;
            }
            int i13 = this.mGuideAreaX;
            int[] iArr = this.mGuideAreaMargin;
            int i14 = iArr[3];
            this.mGuideAreaX = i13 + i14;
            int i15 = this.mGuideAreaY;
            int i16 = iArr[0];
            this.mGuideAreaY = i15 + i16;
            this.mGuideAreaWidth = (this.mGuideAreaWidth - i14) - iArr[1];
            this.mGuideAreaHeight = (this.mGuideAreaHeight - i16) - iArr[2];
        }

        private void draw(Canvas canvas) {
            Paint paint = new Paint(1);
            if (this.mBackgroundColor == null) {
                this.mBackgroundColor = Integer.valueOf(this.mContext.getResources().getColor(R.color.moku_gray_masking));
            }
            paint.setColor(this.mBackgroundColor.intValue());
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(0.0f, 0.0f, this.mScreenWidth, this.mScreenHeight, paint);
            canvas.translate(0.0f, getStatusBarHeight(this.mContext) * (-1));
            if (this.mHighlightView != null) {
                if (this.mIsHighlight) {
                    Paint paint2 = new Paint();
                    paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    int i = this.mHighlightX;
                    int[] iArr = this.mHighlightViewMargin;
                    int i2 = i - iArr[3];
                    int i3 = this.mHighlightY;
                    int i4 = i3 - iArr[0];
                    int i5 = i + this.mHighlightViewWidth + iArr[1];
                    int i6 = i3 + this.mHighlightViewHeight + iArr[2];
                    LogUtils.log(GuideDialog.TAG, "left >> " + i2 + " top >> " + i4 + " right >> " + i5 + " bottom >> " + i6);
                    canvas.drawRect(i2, i4, i5, i6, paint2);
                }
                if (this.mGuideAreaBitmap != null) {
                    Paint paint3 = new Paint(1);
                    paint3.setColor(this.mContext.getResources().getColor(R.color.moku_gray_transparent));
                    paint3.setStyle(Paint.Style.FILL);
                    Rect rect = new Rect();
                    rect.left = 0;
                    rect.right = this.mGuideAreaBitmap.getWidth();
                    rect.top = 0;
                    rect.bottom = this.mGuideAreaBitmap.getHeight();
                    float scale = getScale(this.mGuideAreaWidth, this.mGuideAreaHeight, this.mGuideAreaBitmap);
                    int width = (int) (this.mGuideAreaBitmap.getWidth() * scale);
                    int height = (int) (this.mGuideAreaBitmap.getHeight() * scale);
                    RectF rectF = new RectF();
                    switch (AnonymousClass1.$SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[this.mOrientation.ordinal()]) {
                        case 1:
                        case 8:
                            rectF.left = (this.mGuideAreaX + this.mGuideAreaWidth) - width;
                            rectF.top = (this.mGuideAreaY + this.mGuideAreaHeight) - height;
                            rectF.right = this.mGuideAreaX + this.mGuideAreaWidth;
                            rectF.bottom = this.mGuideAreaY + this.mGuideAreaHeight;
                            break;
                        case 2:
                        case 3:
                            rectF.left = this.mGuideAreaX;
                            rectF.top = (this.mGuideAreaY + this.mGuideAreaHeight) - height;
                            rectF.right = this.mGuideAreaX + width;
                            rectF.bottom = this.mGuideAreaY + this.mGuideAreaHeight;
                            break;
                        case 4:
                        case 5:
                            rectF.left = this.mGuideAreaX;
                            rectF.top = this.mGuideAreaY;
                            rectF.right = this.mGuideAreaX + this.mGuideAreaWidth;
                            rectF.bottom = this.mGuideAreaY + this.mGuideAreaHeight;
                            break;
                        case 6:
                        case 7:
                            rectF.left = (this.mGuideAreaX + this.mGuideAreaWidth) - width;
                            rectF.top = this.mGuideAreaY;
                            rectF.right = this.mGuideAreaX + this.mGuideAreaWidth;
                            rectF.bottom = this.mGuideAreaY + height;
                            break;
                    }
                    canvas.drawBitmap(this.mGuideAreaBitmap, rect, rectF, paint3);
                }
            }
        }

        private float getScale(float f, float f2, Bitmap bitmap) {
            if (f2 / f >= bitmap.getHeight() / bitmap.getWidth()) {
                return f / bitmap.getWidth();
            }
            return f2 / bitmap.getHeight();
        }

        public static int getVirtualBarHeight(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels - defaultDisplay.getHeight();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        public static int getHeight(Context context) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }

        public static int getRealHeight(Context context) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            return displayMetrics.heightPixels;
        }

        private int getStatusBarHeight(Context context) {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        }

        private Orientation getOrientation() {
            int i = this.mHighlightY;
            int i2 = this.mHighlightX;
            int i3 = this.mScreenWidth - i2;
            int i4 = this.mHighlightViewWidth;
            int i5 = i3 - i4;
            int i6 = this.mScreenHeight - i;
            int i7 = this.mHighlightViewHeight;
            int i8 = i6 - i7;
            int i9 = (i4 / 2) + i2;
            int i10 = (i7 / 2) + i;
            int iMax = Math.max(Math.max(Math.max(i, i2), i5), i8);
            if (iMax == i8) {
                if (i9 >= this.mScreenWidth / 2) {
                    return Orientation.BOTTOM_LEFT;
                }
                return Orientation.BOTTOM_RIGHT;
            }
            if (iMax == i) {
                if (i9 >= this.mScreenWidth / 2) {
                    return Orientation.TOP_LEFT;
                }
                return Orientation.TOP_RIGHT;
            }
            if (iMax == i2) {
                if (i10 >= this.mScreenHeight / 2) {
                    return Orientation.LEFT_TOP;
                }
                return Orientation.LEFT_BOTTOM;
            }
            if (i10 >= this.mScreenHeight / 2) {
                return Orientation.RIGHT_TOP;
            }
            return Orientation.RIGHT_BOTTOM;
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.dialog.GuideDialog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation;

        static {
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation = iArr;
            try {
                iArr[Orientation.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[Orientation.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[Orientation.RIGHT_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[Orientation.RIGHT_BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[Orientation.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[Orientation.BOTTOM_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[Orientation.LEFT_BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$ui$dialog$GuideDialog$Orientation[Orientation.LEFT_TOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum Orientation {
        TOP_LEFT(0, "上左"),
        TOP_RIGHT(1, "上右"),
        RIGHT_TOP(2, "右上"),
        RIGHT_BOTTOM(3, "右下"),
        BOTTOM_RIGHT(4, "下右"),
        BOTTOM_LEFT(5, "下左"),
        LEFT_BOTTOM(6, "左下"),
        LEFT_TOP(7, "左上");

        private String mDesc;
        private int mIndex;

        Orientation(int i, String str) {
            this.mIndex = i;
            this.mDesc = str;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }

        public String getDesc() {
            return this.mDesc;
        }

        public void setDesc(String str) {
            this.mDesc = str;
        }
    }
}
