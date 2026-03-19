package com.baidu.enan.e.b.a;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public static String a() {
        try {
            Map<String, String> mapB = b();
            if (mapB != null && mapB.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry<String, String> entry : mapB.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        stringBuffer.append(key);
                        stringBuffer.append("#");
                        stringBuffer.append(value);
                        stringBuffer.append(com.alipay.sdk.m.u.i.b);
                    }
                }
                return stringBuffer.substring(0, stringBuffer.length() - 1);
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
        return "";
    }

    public static Map<String, String> b() {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        try {
            int codecCount = MediaCodecList.getCodecCount();
            if (codecCount < 1) {
                return null;
            }
            HashMap map = new HashMap();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                String name = codecInfoAt.getName();
                String string = Arrays.asList(codecInfoAt.getSupportedTypes()).toString();
                if (!TextUtils.isEmpty(name) && !name.contains("google") && !name.contains("ffmpeg")) {
                    map.put(name, string);
                }
            }
            return map;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return null;
        }
    }
}
