package com.snail.antifake.deviceid.deviceid;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DeviceIdUtil {
    public static String getDeviceId(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String deviceIdLevel2 = ITelephonyUtil.getDeviceIdLevel2(context);
        if (!TextUtils.isEmpty(deviceIdLevel2)) {
            return deviceIdLevel2;
        }
        String deviceIdLevel22 = IPhoneSubInfoUtil.getDeviceIdLevel2(context);
        if (!TextUtils.isEmpty(deviceIdLevel22)) {
            return deviceIdLevel22;
        }
        String deviceIdLevel1 = ITelephonyUtil.getDeviceIdLevel1(context);
        if (!TextUtils.isEmpty(deviceIdLevel1)) {
            return deviceIdLevel1;
        }
        String deviceIdLevel12 = IPhoneSubInfoUtil.getDeviceIdLevel1(context);
        if (!TextUtils.isEmpty(deviceIdLevel12)) {
            return deviceIdLevel12;
        }
        String deviceIdLevel0 = IPhoneSubInfoUtil.getDeviceIdLevel0(context);
        if (!TextUtils.isEmpty(deviceIdLevel0)) {
            return deviceIdLevel0;
        }
        String deviceIdLevel02 = ITelephonyUtil.getDeviceIdLevel0(context);
        if (!TextUtils.isEmpty(deviceIdLevel02)) {
            return deviceIdLevel02;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return deviceIdLevel02;
        }
    }

    public static boolean isEmulatorFromDeviceId(Context context) {
        return isAllZero(getDeviceId(context));
    }

    private static boolean isAllZero(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
