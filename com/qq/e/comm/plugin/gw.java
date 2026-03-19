package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gw {
    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            if (bArrDecode == null || bArrDecode.length <= 0) {
                return null;
            }
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable a(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            try {
                return resources.getDrawable(resources.getIdentifier(str, "drawable", context.getPackageName()));
            } catch (Exception unused) {
                n20.g("Drawable 资源 输入有误");
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }
}
