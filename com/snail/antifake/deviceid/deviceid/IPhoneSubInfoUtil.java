package com.snail.antifake.deviceid.deviceid;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.BinderUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class IPhoneSubInfoUtil {
    public static String getDeviceId(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String deviceIdLevel2 = getDeviceIdLevel2(context);
        if (TextUtils.isEmpty(deviceIdLevel2)) {
            deviceIdLevel2 = getDeviceIdLevel1(context);
            if (TextUtils.isEmpty(deviceIdLevel2)) {
                deviceIdLevel2 = getDeviceIdLevel0(context);
                if (!TextUtils.isEmpty(deviceIdLevel2)) {
                }
            }
        }
        return deviceIdLevel2;
    }

    public static String getDeviceIdLevel0(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberInfo", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(telephonyManager, new Object[0]);
            try {
                Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("getDeviceId", String.class);
                if (declaredMethod2 != null) {
                    return (String) declaredMethod2.invoke(objInvoke, context.getPackageName());
                }
            } catch (Exception unused) {
            }
            Method declaredMethod3 = objInvoke.getClass().getDeclaredMethod("getDeviceId", new Class[0]);
            return declaredMethod3 != null ? (String) declaredMethod3.invoke(objInvoke, new Object[0]) : "";
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String getDeviceIdLevel1(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
            declaredMethod.setAccessible(true);
            IBinder iBinder = (IBinder) declaredMethod.invoke(null, "iphonesubinfo");
            Method declaredMethod2 = Class.forName("com.android.internal.telephony.IPhoneSubInfo$Stub").getDeclaredMethod("asInterface", IBinder.class);
            declaredMethod2.setAccessible(true);
            Object objInvoke = declaredMethod2.invoke(null, iBinder);
            try {
                Method declaredMethod3 = objInvoke.getClass().getDeclaredMethod("getDeviceId", String.class);
                if (declaredMethod3 != null) {
                    return (String) declaredMethod3.invoke(objInvoke, context.getPackageName());
                }
            } catch (Exception unused) {
            }
            Method declaredMethod4 = objInvoke.getClass().getDeclaredMethod("getDeviceId", new Class[0]);
            return declaredMethod4 != null ? (String) declaredMethod4.invoke(objInvoke, new Object[0]) : "";
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String getDeviceIdLevel2(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String str = "";
        try {
            Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
            declaredMethod.setAccessible(true);
            IBinder iBinder = (IBinder) declaredMethod.invoke(null, "iphonesubinfo");
            Method declaredMethod2 = Class.forName("com.android.internal.telephony.IPhoneSubInfo$Stub").getDeclaredMethod("asInterface", IBinder.class);
            declaredMethod2.setAccessible(true);
            Object objInvoke = declaredMethod2.invoke(null, iBinder);
            String strBinderGetHardwareInfo = objInvoke.getClass().getDeclaredMethod("getDeviceId", String.class) != null ? binderGetHardwareInfo(context.getPackageName(), iBinder, BinderUtil.getInterfaceDescriptor(objInvoke), BinderUtil.getTransactionId(objInvoke, "TRANSACTION_getDeviceId")) : "";
            try {
                return objInvoke.getClass().getDeclaredMethod("getDeviceId", new Class[0]) != null ? binderGetHardwareInfo("", iBinder, BinderUtil.getInterfaceDescriptor(objInvoke), BinderUtil.getTransactionId(objInvoke, "TRANSACTION_getDeviceId")) : strBinderGetHardwareInfo;
            } catch (Exception unused) {
                str = strBinderGetHardwareInfo;
                return str;
            }
        } catch (Exception unused2) {
        }
    }

    private static String binderGetHardwareInfo(String str, IBinder iBinder, String str2, int i) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(str2);
            if (!TextUtils.isEmpty(str)) {
                parcelObtain.writeString(str);
            }
            iBinder.transact(i, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
