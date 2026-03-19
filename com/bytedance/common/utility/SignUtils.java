package com.bytedance.common.utility;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SignUtils {
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int POS_NUM = 4;

    private SignUtils() {
    }

    public static boolean checkSignature(Context context, String str) {
        Signature[] appSignatures;
        Signature[] apkSignatures = getApkSignatures(context, str);
        if (apkSignatures == null || (appSignatures = getAppSignatures(context)) == null) {
            return true;
        }
        for (Signature signature : appSignatures) {
            for (Signature signature2 : apkSignatures) {
                if (signature.equals(signature2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Signature[] getAppSignatures(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (Exception e) {
            Logger.w("SignUtils", "failed to get package signatures: " + e);
            return null;
        }
    }

    public static Signature[] getApkSignatures(Context context, String str) {
        Signature[] signatureArr;
        try {
            signatureArr = context.getPackageManager().getPackageArchiveInfo(str, 64).signatures;
        } catch (Exception e) {
            Logger.w("SignUtils", "failed to get package signatures: " + e);
            signatureArr = null;
        }
        return signatureArr == null ? getApkSignaturesCompatible(str) : signatureArr;
    }

    public static byte[] getApkSignature(String str) {
        try {
            Signature[] apkSignaturesCompatible = getApkSignaturesCompatible(str);
            if (apkSignaturesCompatible == null) {
                return null;
            }
            return apkSignaturesCompatible[0].toByteArray();
        } catch (Exception e) {
            Logger.w("SignUtils", "failed to get package signatures: " + e);
            return null;
        }
    }

    private static Signature[] getApkSignaturesCompatible(String str) {
        Object objNewInstance;
        Object objInvoke;
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            Class<?>[] clsArr = {String.class};
            Object[] objArr = {str};
            if (Build.VERSION.SDK_INT > 19) {
                objNewInstance = cls.newInstance();
            } else {
                objNewInstance = cls.getConstructor(clsArr).newInstance(objArr);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            if (Build.VERSION.SDK_INT > 19) {
                Method declaredMethod = cls.getDeclaredMethod("parsePackage", File.class, Integer.TYPE);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(objNewInstance, new File(str), 64);
            } else {
                Method declaredMethod2 = cls.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                objInvoke = declaredMethod2.invoke(objNewInstance, new File(str), str, displayMetrics, 64);
            }
            cls.getDeclaredMethod("collectCertificates", objInvoke.getClass(), Integer.TYPE).invoke(objNewInstance, objInvoke, 64);
            return (Signature[]) objInvoke.getClass().getDeclaredField("mSignatures").get(objInvoke);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
