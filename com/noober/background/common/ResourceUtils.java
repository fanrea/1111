package com.noober.background.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ResourceUtils {
    public static Drawable getDrawable(Context context, String str) {
        Resources resources = context.getResources();
        if (str.startsWith("#")) {
            return new ColorDrawable(Color.parseColor(str));
        }
        int identifier = resources.getIdentifier(str, "drawable", context.getPackageName());
        if (identifier == 0) {
            identifier = resources.getIdentifier(str, "mipmap", context.getPackageName());
        }
        if (identifier == 0) {
            identifier = resources.getIdentifier(str, TypedValues.Custom.S_COLOR, context.getPackageName());
        }
        if (identifier == 0) {
            return null;
        }
        return ContextCompat.getDrawable(context, identifier);
    }

    public static int getColor(Context context, String str) {
        Resources resources = context.getResources();
        if (str.startsWith("#")) {
            return Color.parseColor(str);
        }
        int identifier = resources.getIdentifier(str, TypedValues.Custom.S_COLOR, context.getPackageName());
        if (identifier == 0) {
            return -1;
        }
        return ContextCompat.getColor(context, identifier);
    }
}
