package com.snail.antifake.deviceid.androidid;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class IAndroidIdUtil {
    public static String getAndroidId(Context context) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String androidPropertyLevel1 = ISettingUtils.getAndroidPropertyLevel1(context, "android_id");
        if (TextUtils.isEmpty(androidPropertyLevel1)) {
            androidPropertyLevel1 = ISettingUtils.getAndroidProperty(context, "android_id");
            if (TextUtils.isEmpty(androidPropertyLevel1)) {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
        }
        return androidPropertyLevel1;
    }
}
