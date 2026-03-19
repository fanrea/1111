package com.kwai.middleware.azeroth;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AzerothStorage {
    private static final String KEY_CURRENT_HOST = "KEY_CURRENT_HOST";
    private static final String KEY_SDK_CONFIG_MAP = "KEY_SDK_CONFIG_MAP";
    private static final String PREF_NAME = "azeroth.xml";
    private static final String PREF_NAME_TEST = "azeroth_test.xml";
    private static volatile AzerothStorage sInstance;
    private SharedPreferences mPreferences;

    private AzerothStorage() {
    }

    public static AzerothStorage get() {
        if (sInstance == null) {
            synchronized (AzerothStorage.class) {
                if (sInstance == null) {
                    sInstance = new AzerothStorage();
                }
            }
        }
        return sInstance;
    }

    public final SharedPreferences getPreferences() {
        if (this.mPreferences == null) {
            this.mPreferences = Azeroth.get().getSharedPreferences(Azeroth.get().isTest() ? PREF_NAME_TEST : PREF_NAME, 0);
        }
        return this.mPreferences;
    }

    public final Map<String, String> getSdkConfigMap() {
        Map<String, String> mapFromJsonToMap = null;
        String string = getPreferences().getString(KEY_SDK_CONFIG_MAP, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                mapFromJsonToMap = JsonUtils.fromJsonToMap(string);
            } catch (Exception e) {
                if (Azeroth.get().isDebugMode()) {
                    Log.e("open_azeroth", "", new Exception(string, e));
                }
            }
        }
        return mapFromJsonToMap == null ? new HashMap() : mapFromJsonToMap;
    }

    public final void setSdkConfigMap(Map<String, String> map) {
        getPreferences().edit().putString(KEY_SDK_CONFIG_MAP, JsonUtils.toJson(map).toString()).apply();
    }

    public final String getCurrentHost() {
        return getPreferences().getString(KEY_CURRENT_HOST, "");
    }

    public final void setCurrentHost(String str) {
        getPreferences().edit().putString(KEY_CURRENT_HOST, str).apply();
    }
}
