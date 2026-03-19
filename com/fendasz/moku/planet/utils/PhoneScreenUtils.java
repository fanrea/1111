package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class PhoneScreenUtils {
    private static final int BIG_TEXT_SIZE = 50;
    private static final int MIDDLE_TEXT_SIZE = 42;
    private static final int MIN_TEXT_SIZE = 22;
    private static final int NORMAL_TEXT_SIZE = 46;
    private static final int SCREEN_SCALE = 1080;
    private static final int SMALL35_TEXT_SIZE = 35;
    private static final int SMALL_TEXT_SIZE = 38;
    private static final String TAG = "PhoneScreenUtils";
    private static final int TIPS_TEXT_SIZE = 32;
    private static final int TITLE_TEXT_SIZE = 54;
    private static PhoneScreenUtils mPhoneUtils;
    private DisplayMetrics displayMetrics;

    private PhoneScreenUtils() {
    }

    public static PhoneScreenUtils getInstance() {
        if (mPhoneUtils == null) {
            mPhoneUtils = new PhoneScreenUtils();
        }
        return mPhoneUtils;
    }

    public DisplayMetrics getPhoneScreen(Context context) {
        if (this.displayMetrics == null) {
            this.displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(this.displayMetrics);
        }
        return this.displayMetrics;
    }

    public int getWidthPixels(Context context) {
        return getPhoneScreen(context).widthPixels;
    }

    public int getHeightPixels(Context context) {
        return getPhoneScreen(context).heightPixels;
    }

    public int getDensityDpi(Context context) {
        return getPhoneScreen(context).densityDpi;
    }

    public int getScale(Context context, float f) {
        return (int) (f * getWidthScale(context, 1080));
    }

    public int getAppointResolutionScale(Context context, float f, float f2) {
        return (int) (f * getWidthScale(context, (int) f2));
    }

    public int getScaleTextSize(Context context, int i) {
        return px2sp(context, getScale(context, i));
    }

    public int getTitleTextSize(Context context) {
        return px2sp(context, getScale(context, 54.0f));
    }

    public int getBigTextSize(Context context) {
        return px2sp(context, getScale(context, 50.0f));
    }

    public int getNormalTextSize(Context context) {
        return px2sp(context, getScale(context, 46.0f));
    }

    public int getMiddleTextSize(Context context) {
        return px2sp(context, getScale(context, 42.0f));
    }

    public int getSmallTextSize(Context context) {
        return px2sp(context, getScale(context, 38.0f));
    }

    public int getSmall35TextSize(Context context) {
        return px2sp(context, getScale(context, 35.0f));
    }

    public int getTipsTextSize(Context context) {
        return px2sp(context, getScale(context, 32.0f));
    }

    public int getMinTextSize(Context context) {
        return px2sp(context, getScale(context, 22.0f));
    }

    private float getWidthScale(Context context, int i) {
        return ((getWidthPixels(context) * 1.0f) / i) * 1.0f;
    }

    private float getHeightScale(Context context, int i) {
        return ((getHeightPixels(context) * 1.0f) / i) * 1.0f;
    }

    public int px2sp(Context context, float f) {
        return (int) ((f / getPhoneScreen(context).scaledDensity) + 0.5f);
    }

    public int sp2px(Context context, float f) {
        return (int) ((f - 0.5f) * getPhoneScreen(context).scaledDensity);
    }
}
