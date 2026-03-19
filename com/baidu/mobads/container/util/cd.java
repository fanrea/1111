package com.baidu.mobads.container.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.container.util.by;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class cd {
    private static final String a = "ny7bn1whIvNMIvN_";
    private static final String b = "FZVjiNKcwNFxNDNmNZYb";

    public static String a(com.baidu.mobads.container.adrequest.j jVar, String str, String str2, String str3) {
        try {
            b("firstwon");
            if (jVar != null && jVar.isEncryptionExpose()) {
                String strA = a(jVar, Uri.parse(str).getQueryParameter(com.baidu.mobads.container.components.command.j.s), str2, str3, 4);
                String strB = u.b(b);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strA)) {
                    return str.replace(strB, strA);
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String b(com.baidu.mobads.container.adrequest.j jVar, String str, String str2, String str3) {
        if (jVar != null) {
            try {
                if (jVar.isEncryptionExpose()) {
                    String queryParameter = Uri.parse(str).getQueryParameter(com.baidu.mobads.container.components.command.j.s);
                    int iA = ab.a(1, 4);
                    String str4 = str + "&ent=" + iA;
                    String strA = a(jVar, queryParameter, str2, str3, iA);
                    String strB = u.b(b);
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(strA)) {
                        return str4.replace(strB, strA);
                    }
                    return str;
                }
                return str;
            } catch (Throwable th) {
                th.printStackTrace();
                return str;
            }
        }
        return str;
    }

    private static String a(String str, int i) {
        return Base64.encodeToString((new String(Base64.decode(str, 0)) + "ent=" + i).getBytes(), 0);
    }

    private static String a(com.baidu.mobads.container.adrequest.j jVar, String str, String str2, String str3, int i) {
        String strA = a(jVar.getQueryKey());
        if (!TextUtils.isEmpty(str3) && str3.length() > 2 && i < 3) {
            str3 = str3.substring(0, str3.length() - 2);
        }
        String strB = u.b(a);
        String str4 = strA + str + str3 + str2;
        if (i != 2) {
            str4 = str4 + strB;
        }
        return ap.a(str4);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 <= str.length()) {
                sb.insert(0, str.substring(i, i2));
                i = i2;
            } else {
                return sb.toString();
            }
        }
    }

    public static void b(String str) {
        try {
            by.a.a(com.baidu.mobads.container.config.b.a().c()).a(1008).a("subtype", 812L).a(cm.V, u.a(Arrays.toString(Thread.currentThread().getStackTrace()))).a("reason", str).f();
        } catch (Throwable th) {
            th.getLocalizedMessage();
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        try {
            if (!jVar.isNeedEncWin()) {
                return;
            }
            HashMap map = new HashMap();
            map.put("qk", jVar.getQueryKey());
            map.put("appid", tVar.z());
            map.put(com.baidu.mobads.container.components.h.b.e.b, tVar.l());
            map.put("oaid", com.baidu.mobads.container.util.f.z.a(tVar.t()));
            map.put("cuid", IDManager.getInstance().a(tVar.t()));
            map.put("adid", jVar.getAdId());
            map.put("price", jVar.getBidlayer());
            map.put("sdk_v", "" + com.baidu.mobads.container.j.b());
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append(com.alipay.sdk.m.s.a.n);
                } catch (Throwable th) {
                    com.baidu.mobads.container.l.g.e(th);
                }
            }
            by.a(o.e(com.baidu.mobads.container.adrequest.h.h) + "?&c=" + Base64.encodeToString(sb.toString().substring(0, r3.length() - 1).getBytes(), 0), null);
        } catch (Throwable th2) {
            throw new RuntimeException(th2);
        }
    }

    public static void a(Context context, int i, HashMap<String, String> map, boolean z) {
        try {
            long j = i;
            Map<String, String> mapA = by.a.a(context).a("type", j).a("sdk_v", "" + com.baidu.mobads.container.j.b()).a("cuid", IDManager.getInstance().a(context)).a(com.baidu.mobads.container.adrequest.g.E, IDManager.getInstance().b(context)).a("sn", com.baidu.mobads.container.util.f.z.a(context)).a("sn2", IDManager.getInstance().c(context)).a(map).a();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : mapA.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(com.alipay.sdk.m.s.a.n);
                } catch (Throwable th) {
                    com.baidu.mobads.container.l.g.e(th);
                }
            }
            by.a(o.e(com.baidu.mobads.container.adrequest.h.i) + "?c=" + Base64.encodeToString(sb.toString().substring(0, r2.length() - 1).getBytes(), 0), null);
            if (z) {
                if (map.containsKey("pk")) {
                    map.put("pk", u.a(map.get("pk")));
                }
                by.a.a(context).a(1050).a("subtype", j).a(com.baidu.mobads.container.adrequest.g.B, u.a(mapA.get("sn2"))).a(map).f();
            }
        } catch (Throwable th2) {
            com.baidu.mobads.container.l.g.e(th2.getMessage());
        }
    }
}
