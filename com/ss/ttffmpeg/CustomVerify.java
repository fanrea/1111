package com.ss.ttffmpeg;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CustomVerify {
    public static final int CUSTOM_VERFIY_STATUS_IS_EXCEPTION = -99996;
    public static final int CUSTOM_VERFIY_STATUS_IS_GET_METHOD_EXCEPTION = -99995;
    public static String TAG = "custom_verify_ffmpeg";
    private static Method getVerifyStatusMethod = null;
    private static boolean hasInited = false;
    private static Method verifyMethod;
    private static Class<?> verifyResultClass;

    private static final native void _init();

    static {
        try {
            verifyMethod = Class.forName("com.ttnet.org.chromium.net.X509Util").getMethod("verifyServerCertificates", byte[][].class, String.class, String.class);
            Class<?> cls = Class.forName("com.ttnet.org.chromium.net.AndroidCertVerifyResult");
            verifyResultClass = cls;
            getVerifyStatusMethod = cls.getMethod("getStatus", new Class[0]);
        } catch (Exception e) {
            Log.e(TAG, "found verify class or method exception:" + e.getMessage());
        }
        hasInited = true;
        if (verifyMethod == null || verifyResultClass == null) {
            return;
        }
        Log.e(TAG, "get verify method or verify result class suc");
    }

    public static int doVerify(byte[][] bArr, String str, String str2) {
        if (verifyMethod == null || verifyResultClass == null || getVerifyStatusMethod == null) {
            Log.e(TAG, "verify method is null ecception");
            return -99995;
        }
        try {
            Log.e(TAG, "host: " + str2 + "  authType: " + str);
            Object objInvoke = verifyMethod.invoke(null, bArr, str, str2);
            Log.e(TAG, "get status end");
            int iIntValue = ((Integer) getVerifyStatusMethod.invoke(objInvoke, new Object[0])).intValue();
            Log.e(TAG, "verify result status: " + iIntValue);
            return iIntValue;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e(TAG, "verify exception stacktrace:" + th.getMessage());
            return -99996;
        }
    }

    public static void init() {
        Log.e(TAG, "start init native");
        _init();
        Log.e(TAG, "end init native");
    }
}
