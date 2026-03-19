package com.dhylive.app.utils.task;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DeviceUtil {
    public static int[] getScreenWH(Context context) {
        int[] iArr = {0, 0};
        int i = Build.VERSION.SDK_INT;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        int iIntValue = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        if (i >= 14 && i < 17) {
            try {
                iIntValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
                iIntValue = displayMetrics.heightPixels;
            }
        } else if (i >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
            iIntValue = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        }
        iArr[0] = i2;
        iArr[1] = iIntValue;
        return iArr;
    }

    public static String getScreenSize(Context context) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf(Math.sqrt(Math.pow(r0.widthPixels / r0.xdpi, 2.0d) + Math.pow(r0.heightPixels / r0.ydpi, 2.0d))));
    }

    public static String getIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    public static String getImei2(Context context) {
        int iIntValue;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 26) {
                String imei = telephonyManager.getImei();
                if (TextUtils.isEmpty(imei)) {
                    imei = telephonyManager.getImei(0);
                    if (TextUtils.isEmpty(imei) && telephonyManager.getPhoneCount() > 1) {
                        return telephonyManager.getImei(1);
                    }
                }
                return imei;
            }
            if (Build.VERSION.SDK_INT <= 20) {
                return "";
            }
            String imei2 = (String) telephonyManager.getClass().getMethod("getImei", new Class[0]).invoke(telephonyManager, new Object[0]);
            if (TextUtils.isEmpty(imei2)) {
                imei2 = getIMEI(context, 0);
                if (TextUtils.isEmpty(imei2)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        iIntValue = telephonyManager.getPhoneCount();
                    } else {
                        iIntValue = ((Integer) telephonyManager.getClass().getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
                    }
                    if (iIntValue > 1) {
                        return getIMEI(context, 1);
                    }
                }
            }
            return imei2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMEI(Context context, int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (String) telephonyManager.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getMeid(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 26 ? ((TelephonyManager) context.getSystemService("phone")).getMeid() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getIMSI(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    public static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getSerialNumber() {
        if (Build.VERSION.SDK_INT >= 26) {
            Build.getSerial();
        }
        return Build.SERIAL;
    }

    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static String getPhoneManufacturer() {
        return Build.MANUFACTURER;
    }
}
