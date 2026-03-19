package com.kwad.sdk.api.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class ApiResUtil {
    ApiResUtil() {
    }

    private static Resources getResources(Context context) {
        return context.getResources();
    }

    private static String getPackageName(Context context) {
        return context.getPackageName();
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return getResources(context).getIdentifier(str, str2, getPackageName(context));
    }

    static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    static int getLayoutId(Context context, String str) {
        return getIdentifier(context, str, "layout");
    }

    static int getDimenId(Context context, String str) {
        return getIdentifier(context, str, "dimen");
    }

    static int getStyleId(Context context, String str) {
        return getIdentifier(context, str, "style");
    }

    static int getDrawableId(Context context, String str) {
        return getIdentifier(context, str, "drawable");
    }

    static String getString(Context context, String str) {
        return getResources(context).getString(getIdentifier(context, str, TypedValues.Custom.S_STRING));
    }

    static Drawable getDrawable(Context context, String str) {
        return getResources(context).getDrawable(getIdentifier(context, str, "drawable"));
    }

    static int getColor(Context context, String str) {
        return getResources(context).getColor(getIdentifier(context, str, TypedValues.Custom.S_COLOR));
    }

    static int getAttrId(Context context, String str) {
        return getIdentifier(context, str, "attr");
    }

    static int getRawId(Context context, String str) {
        return getIdentifier(context, str, "raw");
    }
}
