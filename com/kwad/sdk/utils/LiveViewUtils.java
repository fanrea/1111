package com.kwad.sdk.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveViewUtils {
    private static final long mClickInterval = 500;
    private static long mLastClickTime;
    private static int mStatusBarHeight;

    public static int dip2px(Context context, float f) {
        return (int) (context == null ? f * 2.0f : (f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (context == null ? f / 2.0f : (f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getDimensionPixelSize(Context context, int i) {
        if (context == null || i == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int sp2px(Context context, float f) {
        return applyDimension(2, f, context);
    }

    private static int applyDimension(int i, float f, Context context) {
        float fApplyDimension = TypedValue.applyDimension(i, f, context.getResources().getDisplayMetrics());
        int i2 = (int) (fApplyDimension >= 0.0f ? fApplyDimension + 0.5f : fApplyDimension - 0.5f);
        if (i2 != 0) {
            return i2;
        }
        if (f == 0.0f) {
            return 0;
        }
        return f > 0.0f ? 1 : -1;
    }

    public static boolean isFullScreen(Activity activity) {
        return isFullScreen(activity.getWindow());
    }

    private static boolean isFullScreen(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    @Deprecated
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    @Deprecated
    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenRealHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static View getContentView(Activity activity) {
        return getContentView(activity.getWindow());
    }

    public static View getContentView(Window window) {
        return window.getDecorView().findViewById(R.id.content);
    }

    public static int getDisplayWidth(Activity activity) {
        return getContentView(activity).getWidth();
    }

    public static int getDisplayHeight(Activity activity) {
        return getContentView(activity).getHeight();
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static boolean isNavigationBarOnRight(Point point, Point point2) {
        return point.x < point2.x;
    }

    private static boolean isNavigationBarOnBottom(Point point, Point point2) {
        return point.y < point2.y;
    }

    public static Point getAppUsableScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static boolean isStatusBarTranslucent(Activity activity) {
        return activity.getWindow().getStatusBarColor() == 0;
    }

    public static boolean deviceHasNavigationBar(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(activity).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public static boolean isFastClick() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(jUptimeMillis - mLastClickTime) < mClickInterval) {
            mLastClickTime = jUptimeMillis;
            return true;
        }
        mLastClickTime = jUptimeMillis;
        return false;
    }

    public static View inflate(ViewGroup viewGroup, int i, boolean z) {
        return getInflater(viewGroup.getContext()).inflate(i, viewGroup, z);
    }

    private static LayoutInflater getInflater(Context context) {
        return LayoutInflater.from(context);
    }

    public static void expandViewTouchDelegate(final View view, final int i, final int i2, final int i3, final int i4) {
        ((View) view.getParent()).post(new Runnable() { // from class: com.kwad.sdk.utils.LiveViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top -= i;
                rect.bottom += i2;
                rect.left -= i3;
                rect.right += i4;
                TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                if (View.class.isInstance(view.getParent())) {
                    ((View) view.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    public static void adapterAdViewSize(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i > i2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i2 > i) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static boolean isLastItemAtListEnd(android.support.v7.widget.aj ajVar, boolean z) {
        if (ajVar.getChildCount() == 0) {
            return true;
        }
        View childAt = ajVar.getChildAt(ajVar.getChildCount() - 1);
        return (!z ? childAt.getRight() <= ajVar.getWidth() - ajVar.getPaddingRight() : childAt.getBottom() <= ajVar.getHeight() - ajVar.getPaddingBottom()) && ajVar.getChildAdapterPosition(childAt) == ajVar.getAdapter().getItemCount() - 1;
    }

    public static void setWidth(View view, int i) {
        if (view == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public static void adapterAdViewSizeUseByForce(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void adapterAdViewSizeFixWidth(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height && i <= i2) {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static boolean doMonitorSoftKeyWord(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        return height - rect.bottom > height / 3;
    }

    public static void setOnKeyListener(View view, View.OnKeyListener onKeyListener) {
        if (view == null || onKeyListener == null) {
            return;
        }
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(onKeyListener);
    }

    public static void removeOnKeyListener(View view) {
        if (view == null) {
            return;
        }
        view.setFocusableInTouchMode(false);
        view.clearFocus();
        view.setOnKeyListener(null);
    }

    public static int getColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    public static ColorDrawable getColorDrawable(Context context, int i) {
        return new ColorDrawable(getColor(context, i));
    }

    public static void setMargins(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    public static int[] getViewScreenLocation(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static RectF getViewScreenRectF(View view) {
        view.getLocationOnScreen(new int[2]);
        return new RectF(r0[0], r0[1], r0[0] + view.getWidth(), r0[1] + view.getHeight());
    }

    public static int[] getViewCenterWindowLocation(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        iArr[0] = iArr[0] + (width / 2);
        iArr[1] = iArr[1] + (height / 2);
        return iArr;
    }

    public static void setHeight(View view, int i) {
        if (view == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static int getViewGravity(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static void setViewGravity(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
    }

    public static Bitmap textViewToBitmap(TextView textView) {
        TextPaint paint = textView.getPaint();
        int iCeil = ((int) Math.ceil(paint.measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int iCeil2 = (int) Math.ceil((fontMetrics.bottom - fontMetrics.top) + textView.getPaddingTop() + textView.getPaddingBottom());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        textView.layout(0, 0, iCeil, iCeil2);
        textView.draw(canvas);
        return bitmapCreateBitmap;
    }
}
