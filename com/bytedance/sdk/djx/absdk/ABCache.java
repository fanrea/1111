package com.bytedance.sdk.djx.absdk;

import android.text.TextUtils;
import com.nativekv.NativeKV;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ABCache {
    private static final String F_NAME = "djxsdk_absdk_cache";
    private final Map<String, String> mRomMap = new ConcurrentHashMap();
    private final NativeKV mNativeKV = NativeKV.nativeKVWithID(F_NAME);

    public void save(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mNativeKV.encode(str, str2);
        this.mRomMap.put(str, str2);
    }

    public String getData(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strDecodeString = this.mRomMap.get(str);
            if (TextUtils.isEmpty(strDecodeString)) {
                strDecodeString = this.mNativeKV.decodeString(str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strDecodeString)) {
                    this.mRomMap.put(str, strDecodeString);
                }
            }
            return strDecodeString;
        } catch (Exception unused) {
            return null;
        }
    }

    public void clear(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mRomMap.remove(str);
        this.mNativeKV.remove(str);
    }
}
