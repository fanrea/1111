package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cp {
    private static volatile String a;
    private static volatile String b;

    private static String a(Context context, Map<Integer, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (q.b(context, entry.getValue())) {
                sb.append(",");
                sb.append(entry.getKey());
            }
        }
        return sb.length() > 1 ? sb.substring(1) : "";
    }

    private static Map<Integer, String> a(String[] strArr) {
        HashMap map = new HashMap();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length == 2) {
                    try {
                        map.put(Integer.valueOf(Integer.parseInt(strArrSplit[0])), strArrSplit[1]);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return map;
    }

    public static String a() {
        Context contextA;
        String strC;
        try {
            contextA = r1.d().a();
            strC = r1.d().f().c("markets");
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(strC)) {
            return "";
        }
        if (b != null && b.equals(strC)) {
            return a;
        }
        if (contextA != null && !TextUtils.isEmpty(strC)) {
            String strA = a(contextA, a(strC.split(",")));
            a = strA;
            b = strC;
            return strA;
        }
        return "";
    }
}
