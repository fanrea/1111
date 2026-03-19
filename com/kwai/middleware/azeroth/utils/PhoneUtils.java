package com.kwai.middleware.azeroth.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class PhoneUtils {
    private static final String PREFERENCE_FILE_NAME = "PhoneUtil";
    private static final String PREFERENCE_KEY_IMEI = "KEY_DEVICE_ID";
    private static String sIMEI;

    private PhoneUtils() {
    }

    public static int getSimCount(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return 1;
        }
        try {
            return ((Integer) JavaCalls.callMethod(telephonyManager, "getSimCount", new Object[0])).intValue();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static int getSubId(int i, Context context) {
        Uri uri = Uri.parse("content://telephony/siminfo");
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{"_id", "sim_id"}, "sim_id = ?", new String[]{String.valueOf(i)}, null);
        } catch (Exception unused) {
            if (cursorQuery == null) {
                return -1;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return i2;
        }
        if (cursorQuery == null) {
            return -1;
        }
        cursorQuery.close();
        return -1;
    }

    public static int getCurrentDataSlotId(Context context) {
        SubscriptionManager subscriptionManager;
        if (Build.VERSION.SDK_INT < 22 || (subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service")) == null) {
            return -1;
        }
        try {
            return ((Integer) JavaCalls.callMethod(subscriptionManager, "getDefaultDataPhoneId", new Object[0])).intValue();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getDefaultDataSubId(Context context) {
        SubscriptionManager subscriptionManager;
        if (Build.VERSION.SDK_INT < 22 || (subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service")) == null) {
            return -1;
        }
        try {
            return ((Integer) JavaCalls.callMethod(subscriptionManager, "getDefaultDataSubscriptionId", new Object[0])).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String getSubscriberId(int i, Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            return (String) JavaCalls.callMethod(telephonyManager, "getSubscriberId", Integer.valueOf(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getPhoneCount(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return 1;
        }
        try {
            return ((Integer) JavaCalls.callMethod(telephonyManager, "getPhoneCount", new Object[0])).intValue();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static String getDeviceId(int i, Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            return (String) JavaCalls.callMethod(telephonyManager, "getDeviceId", Integer.valueOf(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getImei(int i, Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            return (String) JavaCalls.callMethod(telephonyManager, "getImei", Integer.valueOf(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getMeid(int i, Context context) {
        TelephonyManager telephonyManager;
        if (Build.VERSION.SDK_INT < 26 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        try {
            return telephonyManager.getMeid(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isNetworkEnabled(int i, Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return false;
        }
        try {
            Integer num = (Integer) JavaCalls.callMethod(telephonyManager, "getDataNetworkType", Integer.valueOf(i));
            if (num != null) {
                if (num.intValue() != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isUnicom(String str) {
        if (str != null) {
            return str.startsWith("46001") || str.startsWith("46009");
        }
        return false;
    }

    public static String getTelephoneOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isChinaMobile(String str) {
        return TextUtils.equals(str, "46000") || TextUtils.equals(str, "46002") || TextUtils.equals(str, "46007");
    }

    public static String getImsi(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return TextUtils.emptyIfNull(telephonyManager.getSubscriberId());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        try {
            if (android.text.TextUtils.isEmpty(sIMEI)) {
                if ((Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    sIMEI = telephonyManager.getDeviceId();
                }
                if (!android.text.TextUtils.isEmpty(sIMEI) && android.text.TextUtils.isEmpty(getSavedIMEI(context))) {
                    saveIMEI(context, sIMEI);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (android.text.TextUtils.isEmpty(sIMEI)) {
            sIMEI = getSavedIMEI(context);
        }
        return sIMEI;
    }

    private static void saveIMEI(Context context, String str) {
        context.getSharedPreferences(PREFERENCE_FILE_NAME, 0).edit().putString(PREFERENCE_KEY_IMEI, str).apply();
    }

    private static String getSavedIMEI(Context context) {
        return context.getSharedPreferences(PREFERENCE_FILE_NAME, 0).getString(PREFERENCE_KEY_IMEI, "");
    }

    public static List<String> getDeviceIds(Context context) {
        ArrayList arrayList = new ArrayList();
        int phoneCount = getPhoneCount(context);
        for (int i = 0; i < phoneCount; i++) {
            String deviceId = getDeviceId(i, context);
            if (!TextUtils.isEmpty(deviceId)) {
                arrayList.add(deviceId);
            }
            String meid = getMeid(i, context);
            if (!TextUtils.isEmpty(meid) && !arrayList.contains(meid)) {
                arrayList.add(meid);
            }
            String imei = getImei(i, context);
            if (!TextUtils.isEmpty(imei) && !arrayList.contains(imei)) {
                arrayList.add(imei);
            }
        }
        return arrayList;
    }
}
