package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ScreenAdaptationUtils {
    public static void setHeight(Context context, View view, Integer num) {
        setSize(context, view, null, num);
    }

    public static void setWidth(Context context, View view, Integer num) {
        setSize(context, view, num, null);
    }

    public static void setSize(Context context, View view, Integer num, Integer num2) {
        setLayoutParams(context, view, num, num2, null, null, null, null);
    }

    public static void setPaddingTop(Context context, View view, Integer num) {
        setPaddingTopAndBottom(context, view, num, null);
    }

    public static void setPaddingRight(Context context, View view, Integer num) {
        setPaddingLeftAndRight(context, view, null, num);
    }

    public static void setPaddingBottom(Context context, View view, Integer num) {
        setPaddingTopAndBottom(context, view, null, num);
    }

    public static void setPaddingLeft(Context context, View view, Integer num) {
        setPaddingLeftAndRight(context, view, num, null);
    }

    public static void setPaddingTopAndBottom(Context context, View view, Integer num) {
        setPaddingTopAndBottom(context, view, num, num);
    }

    public static void setPaddingTopAndBottom(Context context, View view, Integer num, Integer num2) {
        setPadding(context, view, num, null, num2, null);
    }

    public static void setPaddingLeftAndRight(Context context, View view, Integer num) {
        setPaddingLeftAndRight(context, view, num, num);
    }

    public static void setPaddingLeftAndRight(Context context, View view, Integer num, Integer num2) {
        setPadding(context, view, null, num2, null, num);
    }

    public static void setPadding(Context context, View view, Integer num) {
        setPadding(context, view, num, num, num, num);
    }

    public static void setPadding(Context context, View view, Integer num, Integer num2, Integer num3, Integer num4) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        Integer numValueOf4;
        PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
        if (num == null) {
            numValueOf = Integer.valueOf(view.getPaddingTop());
        } else {
            numValueOf = Integer.valueOf(phoneScreenUtils.getScale(context, num.intValue()));
        }
        if (num2 == null) {
            numValueOf2 = Integer.valueOf(view.getPaddingRight());
        } else {
            numValueOf2 = Integer.valueOf(phoneScreenUtils.getScale(context, num2.intValue()));
        }
        if (num3 == null) {
            numValueOf3 = Integer.valueOf(view.getPaddingBottom());
        } else {
            numValueOf3 = Integer.valueOf(phoneScreenUtils.getScale(context, num3.intValue()));
        }
        if (num4 == null) {
            numValueOf4 = Integer.valueOf(view.getPaddingLeft());
        } else {
            numValueOf4 = Integer.valueOf(phoneScreenUtils.getScale(context, num4.intValue()));
        }
        view.setPadding(numValueOf4.intValue(), numValueOf.intValue(), numValueOf2.intValue(), numValueOf3.intValue());
    }

    public static void setMarginTop(Context context, View view, Integer num) {
        setMarginTopAndBottom(context, view, num, null);
    }

    public static void setMarginRight(Context context, View view, Integer num) {
        setMarginLeftAndRight(context, view, null, num);
    }

    public static void setMarginBottom(Context context, View view, Integer num) {
        setMarginTopAndBottom(context, view, null, num);
    }

    public static void setMarginLeft(Context context, View view, Integer num) {
        setMarginLeftAndRight(context, view, num, null);
    }

    public static void setMarginTopAndBottom(Context context, View view, Integer num) {
        setMargin(context, view, num, null, num, null);
    }

    public static void setMarginTopAndBottom(Context context, View view, Integer num, Integer num2) {
        setMargin(context, view, num, null, num2, null);
    }

    public static void setMarginLeftAndRight(Context context, View view, Integer num) {
        setMargin(context, view, null, num, null, num);
    }

    public static void setMarginLeftAndRight(Context context, View view, Integer num, Integer num2) {
        setMargin(context, view, null, num2, null, num);
    }

    public static void setMargin(Context context, View view, Integer num, Integer num2, Integer num3, Integer num4) {
        setLayoutParams(context, view, null, null, num, num2, num3, num4);
    }

    public static void setLayoutParams(Context context, View view, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
        if (num != null) {
            if (num.equals(-1)) {
                marginLayoutParams.width = -1;
            } else if (num.equals(-2)) {
                marginLayoutParams.width = -2;
            } else {
                marginLayoutParams.width = phoneScreenUtils.getScale(context, num.intValue());
            }
        }
        if (num2 != null) {
            if (num2.equals(-1)) {
                marginLayoutParams.height = -1;
            } else if (num2.equals(-2)) {
                marginLayoutParams.width = -2;
            } else {
                marginLayoutParams.height = phoneScreenUtils.getScale(context, num2.intValue());
            }
        }
        if (num3 != null) {
            marginLayoutParams.topMargin = phoneScreenUtils.getScale(context, num3.intValue());
        }
        if (num4 != null) {
            marginLayoutParams.rightMargin = phoneScreenUtils.getScale(context, num4.intValue());
        }
        if (num5 != null) {
            marginLayoutParams.bottomMargin = phoneScreenUtils.getScale(context, num5.intValue());
        }
        if (num6 != null) {
            marginLayoutParams.leftMargin = phoneScreenUtils.getScale(context, num6.intValue());
        }
    }
}
