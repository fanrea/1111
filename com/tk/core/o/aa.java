package com.tk.core.o;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class aa {
    public static String t(HashMap<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Object obj = map.get("overflow");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static boolean db(String str) {
        return TextUtils.equals(str, "visible");
    }
}
