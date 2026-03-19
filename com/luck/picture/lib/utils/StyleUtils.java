package com.luck.picture.lib.utils;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class StyleUtils {
    private static final int INVALID = 0;

    public static boolean checkSizeValidity(int i) {
        return i > 0;
    }

    public static boolean checkStyleValidity(int i) {
        return i != 0;
    }

    public static boolean checkTextValidity(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean checkTextFormatValidity(String str) {
        return Pattern.compile("\\([^)]*\\)").matcher(str).find();
    }

    public static boolean checkTextTwoFormatValidity(String str) {
        int i = 0;
        while (Pattern.compile("%[^%]*\\d").matcher(str).find()) {
            i++;
        }
        return i >= 2;
    }

    public static boolean checkArrayValidity(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    public static ColorFilter getColorFilter(Context context, int i) {
        return BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(context, i), BlendModeCompat.SRC_ATOP);
    }
}
