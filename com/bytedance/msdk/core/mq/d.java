package com.bytedance.msdk.core.mq;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final Map<String, InterfaceC0245d> d = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.msdk.core.mq.d$d, reason: collision with other inner class name */
    public interface InterfaceC0245d {
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hc(str);
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hc(str);
    }

    private static InterfaceC0245d hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.remove(str);
    }
}
