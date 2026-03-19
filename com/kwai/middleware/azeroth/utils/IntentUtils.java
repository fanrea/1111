package com.kwai.middleware.azeroth.utils;

import android.content.Intent;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class IntentUtils {
    public static boolean getBooleanExtra(Intent intent, String str, boolean z) {
        return intent == null ? z : BundleUtils.getBoolean(intent.getExtras(), str, z);
    }

    public static String getStringExtra(Intent intent, String str, String str2) {
        return intent == null ? str2 : BundleUtils.getString(intent.getExtras(), str, str2);
    }

    public static int getIntExtra(Intent intent, String str, int i) {
        return intent == null ? i : BundleUtils.getInt(intent.getExtras(), str, i);
    }

    public static boolean hasExtra(Intent intent, String str) {
        if (intent == null) {
            return false;
        }
        return BundleUtils.containsKey(intent.getExtras(), str);
    }

    public static long getLongExtra(Intent intent, String str, long j) {
        return intent == null ? j : BundleUtils.getLong(intent.getExtras(), str, j);
    }

    public static <T extends Serializable> T getSerializableExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        return (T) BundleUtils.getSerializable(intent.getExtras(), str);
    }

    public static <T extends Parcelable> T getParcelableExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        return (T) BundleUtils.getParcelable(intent.getExtras(), str);
    }
}
