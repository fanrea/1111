package com.alliance.ssp.ad.o0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.lang.reflect.Field;

/* compiled from: BitmapDecodeUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public static final Bitmap.Config a = Bitmap.Config.RGB_565;

    public static BitmapFactory.Options a(Context context) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inPreferredConfig = a;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inJustDecodeBounds = false;
        if (Build.VERSION.SDK_INT <= 10) {
            try {
                Field declaredField = BitmapFactory.Options.class.getDeclaredField("inNativeAlloc");
                declaredField.setAccessible(true);
                declaredField.setBoolean(options, true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
        int i = context.getResources().getDisplayMetrics().densityDpi;
        float f = context.getResources().getDisplayMetrics().density;
        if (i > 240 && f > 1.5f) {
            int i2 = (int) (i * 0.75f);
            options.inDensity = i2;
            options.inTargetDensity = i2;
        }
        return options;
    }
}
