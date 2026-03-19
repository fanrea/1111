package com.tk.core.component.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.tk.core.o.z;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class l {
    private static String getResName(String str) {
        int iLastIndexOf;
        String mappedPath = getMappedPath(str, UriUtils.ASSET_PREFIX);
        return (mappedPath == null || mappedPath.length() <= 0 || -1 == (iLastIndexOf = mappedPath.lastIndexOf("."))) ? mappedPath : mappedPath.substring(0, iLastIndexOf);
    }

    private static String getMappedPath(String str, String str2) {
        return (str == null || str.length() <= 0 || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static Drawable b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    if (str.startsWith(UriUtils.ASSET_PREFIX)) {
                        return i(context, str);
                    }
                    if (str.startsWith(UriUtils.FILE_PREFIX)) {
                        return cq(str);
                    }
                    if (str.startsWith(UriUtils.BUNDLE_PREFIX)) {
                        return t(str, str2);
                    }
                    return t(str, str2);
                }
                return null;
            } catch (Throwable th) {
                com.tk.core.i.a.a("SpanUtils", "SpanUtils getDrawable", th);
            }
        }
        return null;
    }

    private static Drawable i(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        int iB = z.b(getResName(str), "drawable", null);
        if (iB == 0) {
            com.tk.core.i.a.a("SpanUtils", "getAssetDrawable", new Exception(str + " not exist"));
            return null;
        }
        return context.getResources().getDrawable(iB);
    }

    private static Drawable cq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String mappedPath = getMappedPath(str, UriUtils.FILE_PREFIX);
        if (!com.tk.core.o.f.cS(mappedPath)) {
            com.tk.core.i.a.a("SpanUtils", "getFileDrawable", new Exception(str + " not exist"));
            return null;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(mappedPath);
        if (bitmapDecodeFile == null) {
            return null;
        }
        return new BitmapDrawable(bitmapDecodeFile);
    }

    private static Drawable t(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String strConcat = str2.concat(getMappedPath(str, UriUtils.BUNDLE_PREFIX));
        if (!com.tk.core.o.f.cS(strConcat)) {
            com.tk.core.i.a.a("SpanUtils", "getFileDrawable", new Exception(str + " not exist"));
            return null;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(strConcat);
        if (bitmapDecodeFile == null) {
            return null;
        }
        return new BitmapDrawable(bitmapDecodeFile);
    }
}
