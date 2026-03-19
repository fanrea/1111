package com.bytedance.msdk.core.d.d;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static an b;
    private static an d;
    private static an hc;

    public static an d(String str) {
        if (TextUtils.equals(str, "gdt")) {
            if (d == null) {
                d = new hc();
            }
            return d;
        }
        if (TextUtils.equals(str, "ks")) {
            if (hc == null) {
                hc = new b();
            }
            return hc;
        }
        if (!TextUtils.equals(str, "xiaomi")) {
            return null;
        }
        if (b == null) {
            b = new c();
        }
        return b;
    }

    public static void d(Map<String, Object> map) {
        if (map != null) {
            an anVar = d;
            if (anVar != null && !TextUtils.isEmpty(anVar.h())) {
                map.put("unsupported_gdt_version", d.h());
                d.d((String) null);
            }
            an anVar2 = hc;
            if (anVar2 != null && !TextUtils.isEmpty(anVar2.h())) {
                map.put("unsupported_ks_version", hc.h());
                hc.d((String) null);
            }
            an anVar3 = b;
            if (anVar3 == null || TextUtils.isEmpty(anVar3.h())) {
                return;
            }
            map.put("unsupported_xiaomi_version", b.h());
            b.d((String) null);
        }
    }

    public static boolean hc(String str) {
        return TextUtils.equals(str, "gdt") || TextUtils.equals(str, "ks") || TextUtils.equals(str, "xiaomi");
    }
}
