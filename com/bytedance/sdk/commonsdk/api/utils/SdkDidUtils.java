package com.bytedance.sdk.commonsdk.api.utils;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SdkDidUtils {
    public static final String SP_IS_HAS_LOCAL_UUID = "sp_is_has_local_uuid";
    public static final String SP_IS_HAS_LOCAL_UUID_OLD = "sp_is_has_local_uuid_old";
    private static String sAndroidId;
    private static String sLocalDid;
    private static final SimpleSPUtils sp = SimpleSPUtils.getInstance("common_sdk");

    private SdkDidUtils() {
    }

    public static Pair<String, String> getLocalDid(boolean z, String str, String str2) {
        if (TextUtils.isEmpty(sLocalDid)) {
            String androidId = getAndroidId(z, str);
            if (!TextUtils.isEmpty(androidId)) {
                sLocalDid = "ouid_" + androidId;
            }
        }
        if (TextUtils.isEmpty(sLocalDid)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = UUID.randomUUID().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                sLocalDid = "uuid_" + str2;
                sp.put(SP_IS_HAS_LOCAL_UUID, true);
            }
        }
        return new Pair<>(sLocalDid, str2);
    }

    public static boolean isHasLocalUuid() {
        return sp.getBoolean(SP_IS_HAS_LOCAL_UUID, false);
    }

    public static Pair<String, String> getDidOld(String str, boolean z, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            String androidId = getAndroidId(z, str2);
            if (!TextUtils.isEmpty(androidId)) {
                str = "ouid_" + androidId;
            }
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str3)) {
                str3 = UUID.randomUUID().toString();
            }
            if (!TextUtils.isEmpty(str3)) {
                str = "uuid_" + str3;
                sp.put(SP_IS_HAS_LOCAL_UUID_OLD, true);
            }
        }
        return new Pair<>(str, str3);
    }

    public static boolean isHasLocalUuidOld() {
        return sp.getBoolean(SP_IS_HAS_LOCAL_UUID_OLD, false);
    }

    public static String getAndroidId(boolean z, String str) {
        if (!z) {
            return str;
        }
        if (TextUtils.isEmpty(sAndroidId)) {
            try {
                sAndroidId = Settings.Secure.getString(CommonSdkUtils.getContext().getContentResolver(), "android_id");
            } catch (Throwable unused) {
            }
        }
        return sAndroidId;
    }
}
