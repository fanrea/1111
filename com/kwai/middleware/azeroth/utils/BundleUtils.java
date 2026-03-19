package com.kwai.middleware.azeroth.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class BundleUtils {
    private static final String TAG = "BundleUtils";

    public static boolean getBoolean(Bundle bundle, String str, boolean z) {
        if (bundle == null) {
            return z;
        }
        try {
            return bundle.getBoolean(str, z);
        } catch (RuntimeException e) {
            Log.e(TAG, "throw exception when getBooleanExtra，with bundle = " + bundle + " ,name: " + str, e);
            return z;
        }
    }

    public static String getString(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        try {
            return bundle.getString(str);
        } catch (RuntimeException e) {
            Log.e(TAG, "throw exception when getStringExtra，with bundle = " + bundle + " ,name: " + str, e);
            return str2;
        }
    }

    public static int getInt(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, i);
        } catch (RuntimeException e) {
            Log.e(TAG, "throw exception when getIntExtra，with bundle = " + bundle + " ,name: " + str, e);
            return i;
        }
    }

    public static boolean containsKey(Bundle bundle, String str) {
        if (bundle == null) {
            return false;
        }
        try {
            return bundle.containsKey(str);
        } catch (RuntimeException e) {
            Log.e(TAG, "throw exception when hasExtra，with bundle = " + bundle + " ,name: " + str, e);
            return false;
        }
    }

    public static long getLong(Bundle bundle, String str, long j) {
        if (bundle == null) {
            return j;
        }
        try {
            return bundle.getLong(str, j);
        } catch (RuntimeException e) {
            Log.e(TAG, "throw exception when getLongExtra，with bundle = " + bundle + " ,name: " + str, e);
            return j;
        }
    }

    public static <T extends Serializable> T getSerializable(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return (T) bundle.getSerializable(str);
        } catch (RuntimeException e) {
            Log.e(TAG, "throw exception when getSerializableExtra，with bundle = " + bundle + " ,name: " + str, e);
            return null;
        }
    }

    public static <T extends Parcelable> T getParcelable(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return (T) bundle.getParcelable(str);
        } catch (RuntimeException e) {
            Log.e(TAG, "throw exception when getParcelableExtra，with bundle = " + bundle + " ,name: " + str, e);
            return null;
        }
    }
}
