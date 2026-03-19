package com.bytedance.common.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class UIUtils {
    public static final boolean API_ET_20;
    private static final int BURY_WIDTH_DP = 20;
    public static final char ELLIPSIS_CHAR = 8230;
    private static final float FLOAT_BIAS = 0.5f;
    private static final float FLOAT_DOT999 = 0.999f;
    public static final int LAYOUT_PARAMS_KEEP_OLD = -3;
    private static final int MASK_1000 = 16777216;
    private static final int MASK_FF = 255;
    private static final int MASK_FFFF = 16777215;
    private static final int MAX_COUNT = 10000;
    private static final int MAX_WIDTH = 1375;
    private static int mDpi;
    private static String sScreenResolution;
    public static EllipsisMeasureResult sTempEllipsisResult;
    private static ToastHook sToastHook;

    public static class EllipsisMeasureResult {
        public String ellipsisStr;
        public int length;
    }

    public interface ToastHook {
        boolean showToast(Context context, int i, CharSequence charSequence, long j, int i2);
    }

    public static int floatToIntBig(float f) {
        return (int) (f + FLOAT_DOT999);
    }

    public static int setColorAlpha(int i, int i2) {
        if (i2 > 255) {
            i2 = 255;
        } else if (i2 < 0) {
            i2 = 0;
        }
        return (i & 16777215) | (i2 * 16777216);
    }

    private static boolean visibilityValid(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    private UIUtils() {
    }

    static {
        API_ET_20 = Build.VERSION.SDK_INT > 19;
        sScreenResolution = "";
        mDpi = -1;
        sTempEllipsisResult = new EllipsisMeasureResult();
    }

    public static void setToastHook(ToastHook toastHook) {
        sToastHook = toastHook;
    }

    public static void displayToast(Context context, String str) {
        displayToast(context, 0, str);
    }

    public static void displayToast(Context context, int i) {
        displayToast(context, context.getString(i));
    }

    public static void displayToastWithIcon(Context context, int i, int i2) {
        displayToast(context, i, context.getString(i2));
    }

    public static void displayToastWithIcon(Context context, int i, String str) {
        displayToast(context, i, str);
    }

    public static void displayToast(Context context, int i, int i2) {
        displayToast(context, context.getString(i), i2);
    }

    public static void displayToast(Context context, String str, int i) {
        displayToastInternal(context, 0, str, 0, i);
    }

    public static void displayToast(Context context, int i, String str) {
        displayToastInternal(context, i, str, 0, 17);
    }

    public static void displayLongTimeToast(Context context, int i, int i2) {
        if (context == null) {
            return;
        }
        String string = context.getString(i2);
        if (StringUtils.isEmpty(string)) {
            return;
        }
        displayToastInternal(context, i, string, 1, 17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToastInternal(final Context context, final int i, final String str, final int i2, final int i3) {
        if (context == 0 || StringUtils.isEmpty(str)) {
            return;
        }
        if (!isInUIThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.common.utility.UIUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    UIUtils.displayToastInternal(context, i, str, i2, i3);
                }
            });
            return;
        }
        ToastHook toastHook = sToastHook;
        if (toastHook == null || !toastHook.showToast(context, i, str, i2, i3)) {
            if (context instanceof ICustomToast) {
                if (i2 == 1) {
                    ((ICustomToast) context).showCustomLongToast(i, str);
                    return;
                }
                ICustomToast iCustomToast = (ICustomToast) context;
                if (i2 == 0) {
                    i2 = 2000;
                }
                iCustomToast.showCustomToast(i, str, i2, i3);
                return;
            }
            try {
                Toast toastMakeText = Toast.makeText(context, str, i2);
                if (toastMakeText != null) {
                    toastMakeText.setGravity(i3, 0, 0);
                    toastMakeText.show();
                }
            } catch (Exception e) {
                Logger.throwException(e);
            }
        }
    }

    public static float sp2px(Context context, float f) {
        if (context != null) {
            return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float dip2Px(Context context, float f) {
        if (context != null) {
            return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return 0.0f;
    }

    public static int px2dip(Context context, float f) {
        if (context != null) {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static void expandClickRegion(final View view, final int i, final int i2, final int i3, final int i4) {
        view.post(new Runnable() { // from class: com.bytedance.common.utility.UIUtils.2
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top += i2;
                rect.bottom += i4;
                rect.left += i;
                rect.right += i3;
                TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                if (View.class.isInstance(view.getParent())) {
                    ((View) view.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    public static void setViewBackgroundWithPadding(View view, int i) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundResource(i);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setViewBackgroundWithPadding(View view, Resources resources, int i) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundColor(resources.getColor(i));
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setViewBackgroundWithPadding(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static String getDisplayCount(int i) {
        if (i > 10000) {
            String str = String.format(Locale.getDefault(), "%.1f", Double.valueOf((i * 1.0d) / 10000.0d));
            if ('0' == str.charAt(str.length() - 1)) {
                return str.substring(0, str.length() - 2) + "万";
            }
            return str + "万";
        }
        return String.valueOf(i);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int getRatioOfScreen(Context context, float f) {
        if (context.getResources().getDisplayMetrics() == null) {
            return 0;
        }
        return (int) (r0.widthPixels * f);
    }

    public static boolean isInUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void assertInUIThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        Logger.alertErrorInfo("not in UI thread");
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static String getScreenResolution(Context context) {
        if (StringUtils.isEmpty(sScreenResolution) && context != null) {
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            if (screenWidth > 0 && screenHeight > 0) {
                sScreenResolution = screenWidth + "*" + screenHeight;
            }
        }
        return sScreenResolution;
    }

    public static int getDpi(Context context) {
        if (mDpi == -1 && context != null) {
            mDpi = context.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        return mDpi;
    }

    public static int getDiggBuryWidth(Context context) {
        return ((context.getResources().getDisplayMetrics().widthPixels * MAX_WIDTH) / 10000) + ((int) dip2Px(context, 20.0f));
    }

    public static int getStatusBarHeight(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void setViewVisibility(View view, int i) {
        if (view == null || view.getVisibility() == i || !visibilityValid(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static boolean isViewVisible(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void getLocationInUpView(View view, View view2, int[] iArr, boolean z) {
        if (view == null || view2 == null || iArr == null || iArr.length < 2) {
            return;
        }
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view2.getLocationInWindow(iArr);
        int width = iArr[0] - i;
        int height = iArr[1] - i2;
        if (z) {
            width += view2.getWidth() / 2;
            height += view2.getHeight() / 2;
        }
        iArr[0] = width;
        iArr[1] = height;
    }

    public static void updateLayout(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (layoutParams.width == i && layoutParams.height == i2) {
            return;
        }
        if (i != -3) {
            layoutParams.width = i;
        }
        if (i2 != -3) {
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void updateLayoutMargin(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        updateMargin(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void updateMargin(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static void setTopMargin(View view, float f) {
        if (view == null) {
            return;
        }
        updateLayoutMargin(view, -3, (int) TypedValue.applyDimension(1, f, view.getContext().getResources().getDisplayMetrics()), -3, -3);
    }

    public static void setLayoutParams(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i != Integer.MIN_VALUE) {
            layoutParams.width = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.height = i2;
        }
    }

    public static void setTxtAndAdjustVisible(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            setViewVisibility(textView, 8);
        } else {
            setViewVisibility(textView, 0);
            textView.setText(charSequence);
        }
    }

    public static void setText(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void detachFromParent(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            try {
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                Logger.throwException(e);
            }
        }
    }

    public static void setViewMinHeight(View view, int i) {
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 16 || view.getMinimumHeight() != i) {
            view.setMinimumHeight(i);
        }
    }

    public static void setTextViewMaxLines(TextView textView, int i) {
        if (textView == null || i <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT < 16 || textView.getMaxLines() != i) {
            textView.setSingleLine(i == 1);
            textView.setMaxLines(i);
        }
    }

    public static int[] getLocationInAncestor(View view, View view2) {
        boolean z;
        if (view == null || view2 == null) {
            Logger.alertErrorInfo("invalid params: child:" + view + ",ancestor:" + view2);
            return null;
        }
        int[] iArr = new int[2];
        float[] fArr = {0.0f, 0.0f};
        fArr[0] = fArr[0] + view.getLeft();
        fArr[1] = fArr[1] + view.getTop();
        ViewParent parent = view.getParent();
        while (true) {
            if (!(parent instanceof View)) {
                z = false;
                break;
            }
            View view3 = (View) parent;
            if (parent == view2) {
                z = true;
                break;
            }
            fArr[0] = fArr[0] - view3.getScrollX();
            fArr[1] = fArr[1] - view3.getScrollY();
            fArr[0] = fArr[0] + view3.getLeft();
            fArr[1] = fArr[1] + view3.getTop();
            parent = view3.getParent();
        }
        if (!z) {
            Logger.alertErrorInfo("ancestorView:" + view2 + " is not the ancestor of child : " + view);
            return null;
        }
        iArr[0] = (int) (fArr[0] + 0.5f);
        iArr[1] = (int) (fArr[1] + 0.5f);
        return iArr;
    }

    public static void ellipseSingleLineStr(String str, int i, Paint paint, int i2, EllipsisMeasureResult ellipsisMeasureResult) {
        if (i <= i2 || StringUtils.isEmpty(str)) {
            ellipsisMeasureResult.ellipsisStr = "";
            ellipsisMeasureResult.length = 0;
            return;
        }
        int iFloatToIntBig = floatToIntBig(paint.measureText(str));
        if (iFloatToIntBig <= i) {
            ellipsisMeasureResult.ellipsisStr = str;
            ellipsisMeasureResult.length = iFloatToIntBig;
            return;
        }
        StringBuilder sb = new StringBuilder();
        int iBreakText = paint.breakText(str, 0, str.length(), true, i - i2, null);
        if (iBreakText < 1) {
            ellipsisMeasureResult.ellipsisStr = "";
            ellipsisMeasureResult.length = 0;
        } else {
            sb.append(str.substring(0, iBreakText));
            sb.append((char) 8230);
            ellipsisMeasureResult.ellipsisStr = sb.toString();
            ellipsisMeasureResult.length = i;
        }
    }

    public static void requestOrienation(Activity activity, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.setRequestedOrientation(!z ? 1 : 0);
        if (z) {
            activity.getWindow().setFlags(1024, 1024);
        } else {
            activity.getWindow().clearFlags(1024);
        }
    }

    public static int getIndexInParent(View view) {
        if (view != null && view.getParent() != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return ((ViewGroup) parent).indexOfChild(view);
            }
        }
        return -1;
    }

    public static boolean clearAnimation(View view) {
        if (view == null || view.getAnimation() == null) {
            return false;
        }
        view.clearAnimation();
        return true;
    }

    public static void setClickListener(boolean z, View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setOnClickListener(onClickListener);
            view.setClickable(true);
        } else {
            view.setOnClickListener(null);
            view.setClickable(false);
        }
    }
}
