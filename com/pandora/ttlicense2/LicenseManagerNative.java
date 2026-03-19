package com.pandora.ttlicense2;

import com.pandora.ttlicense2.utils.L;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class LicenseManagerNative {
    private static native String nativeAddLicense(String content, String sign);

    private static native int nativeCheckFeatureAuth(String sdkName, String featureName);

    private static native int nativeCheckSDKAuth(String sdkName);

    private static native int nativeGetIntValue(int key, int dValue);

    private static native License nativeGetLicenseInfo(String licenseId);

    private static native String nativeGetSDKEdition(String sdkName);

    private static native int nativeInit(String packageName);

    private static native int nativeSetIntValue(int key, int value);

    public static native void openLog(boolean isOpen);

    static {
        System.loadLibrary("ttlicense2");
    }

    private LicenseManagerNative() {
    }

    static synchronized void init(String packageName) {
        nativeInit(packageName);
    }

    static synchronized void setAuthParams() {
        try {
            try {
                try {
                    Method method = Class.forName("com.ss.ttvideoengine.InfoWrapper").getMethod("getExpiredDegradeEnabled", new Class[0]);
                    method.setAccessible(true);
                    nativeSetIntValue(0, ((Integer) method.invoke(null, new Object[0])).intValue());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                }
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }

    static synchronized String addLicense(LicenseFile license) {
        String strNativeAddLicense;
        long jNanoTime = System.nanoTime();
        strNativeAddLicense = nativeAddLicense(license.getContent(), license.getSignature());
        L.v("LicenseManagerNative", "addLicense", Long.valueOf(System.nanoTime() - jNanoTime));
        return strNativeAddLicense;
    }

    static synchronized String getSDKEdition(String sdkName) {
        return nativeGetSDKEdition(sdkName);
    }

    static synchronized License getLicense(String licenseId) {
        return nativeGetLicenseInfo(licenseId);
    }

    static synchronized int checkSDKAuth(String sdkName) {
        return nativeCheckSDKAuth(sdkName);
    }

    static synchronized int checkFeatureAuth(String sdkName, String featureName) {
        return nativeCheckFeatureAuth(sdkName, featureName);
    }

    static synchronized int setIntValue(int key, int value) {
        return nativeSetIntValue(key, value);
    }

    static synchronized int getIntValue(int key, int dValue) {
        return nativeGetIntValue(key, dValue);
    }
}
