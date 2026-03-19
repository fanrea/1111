package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wr {
    private static volatile HashSet<String> a;

    public static String a(String str, int i) {
        return b(str, i);
    }

    private static String b(String str, int i) throws JSONException {
        if (TextUtils.isEmpty(str) || !str.startsWith("http://")) {
            return str;
        }
        a();
        ja jaVarA = new ja().a("url", str);
        if (!a30.a(str, a)) {
            b10.a(9720000, null, Integer.valueOf(i), 0, jaVarA);
            return str;
        }
        b10.a(9720000, null, Integer.valueOf(i), 1, jaVarA);
        return a(str, true);
    }

    private static String a(String str, boolean z) {
        if (z) {
            return "https://" + str.substring(7);
        }
        return "http://" + str.substring(8);
    }

    private static void a() {
        String[] strArrSplit;
        if (a != null) {
            return;
        }
        synchronized (wr.class) {
            if (a != null) {
                return;
            }
            try {
                String strB = r1.d().f().b("sthdwl", "");
                HashSet<String> hashSet = new HashSet<>();
                if (!TextUtils.isEmpty(strB) && (strArrSplit = strB.split(",")) != null && strArrSplit.length > 0) {
                    for (String str : strArrSplit) {
                        hashSet.add(str);
                    }
                }
                a = hashSet;
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
