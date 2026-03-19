package com.bytedance.sdk.commonsdk.api.utils;

import android.content.Context;
import com.nativekv.NativeKV;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SimpleSPUtils {
    private static final Map<String, SimpleSPUtils> SP_UTILS_MAP = new HashMap();
    private final NativeKV mNativeKV;

    private SimpleSPUtils(String str) {
        checkInitializeNativeKV();
        this.mNativeKV = NativeKV.nativeKVWithID(str);
    }

    public static void checkInitializeNativeKV() {
        Context context;
        if (NativeKV.getRootDir() != null || (context = CommonSdkUtils.getContext()) == null) {
            return;
        }
        NativeKV.initialize(context);
        NativeKV.initialize(context, NativeKV.getRootDir());
    }

    public static SimpleSPUtils getInstance(String str) {
        checkInitializeNativeKV();
        if (isSpace(str)) {
            str = "CommonSdkSp";
        }
        Map<String, SimpleSPUtils> map = SP_UTILS_MAP;
        SimpleSPUtils simpleSPUtils = map.get(str);
        if (simpleSPUtils == null) {
            synchronized (SimpleSPUtils.class) {
                simpleSPUtils = map.get(str);
                if (simpleSPUtils == null) {
                    simpleSPUtils = new SimpleSPUtils(str);
                    map.put(str, simpleSPUtils);
                }
            }
        }
        return simpleSPUtils;
    }

    public NativeKV getNativeKV() {
        return this.mNativeKV;
    }

    public void put(String str, String str2) {
        this.mNativeKV.edit().putString(str, str2);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getString(String str, String str2) {
        return this.mNativeKV.getString(str, str2);
    }

    public void put(String str, int i) {
        this.mNativeKV.edit().putInt(str, i);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public int getInt(String str, int i) {
        return this.mNativeKV.getInt(str, i);
    }

    public void put(String str, long j) {
        this.mNativeKV.edit().putLong(str, j);
    }

    public long getLong(String str) {
        return getLong(str, -1L);
    }

    public long getLong(String str, long j) {
        return this.mNativeKV.getLong(str, j);
    }

    public void put(String str, float f) {
        this.mNativeKV.edit().putFloat(str, f);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public float getFloat(String str, float f) {
        return this.mNativeKV.getFloat(str, f);
    }

    public void put(String str, boolean z) {
        this.mNativeKV.edit().putBoolean(str, z);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mNativeKV.getBoolean(str, z);
    }

    public void put(String str, Set<String> set) {
        this.mNativeKV.edit().putStringSet(str, set);
    }

    public Set<String> getStringSet(String str) {
        return getStringSet(str, Collections.emptySet());
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.mNativeKV.getStringSet(str, set);
    }

    public boolean contains(String str) {
        return this.mNativeKV.contains(str);
    }

    public void remove(String str) {
        this.mNativeKV.edit().remove(str);
    }

    public void clear() {
        this.mNativeKV.edit().clear();
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
