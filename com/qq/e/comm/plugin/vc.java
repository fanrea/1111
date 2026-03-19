package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vc {
    private static volatile boolean a;
    private static volatile boolean b;
    private static final Map<String, uc> c = new ConcurrentHashMap();
    private static final Map<Integer, Boolean> d = new ConcurrentHashMap();
    private static final Map<String, Boolean> e = new ConcurrentHashMap();
    private static final Map<String, Integer> f = new ConcurrentHashMap();

    public static void b() {
        e.clear();
    }

    public static void b(String str) {
        a();
        if (b && a(str)) {
            e.put(str, Boolean.TRUE);
        }
    }

    private static List<Integer> b(r4 r4Var) {
        Integer num;
        Map<String, uc> map = c;
        uc ucVar = map.get("*");
        if (ucVar != null && ucVar.a(r4Var.c(), null)) {
            return new ArrayList(f.values());
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, uc> entry : map.entrySet()) {
            String key = entry.getKey();
            uc value = entry.getValue();
            f5 f5VarA = r4Var.a();
            if (value.a(r4Var.c(), f5VarA == null ? null : Integer.valueOf(f5VarA.b())) && (num = f.get(key)) != null) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    private static boolean a(String str) {
        try {
            return Integer.parseInt(str) > 10000;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a() {
        if (a) {
            return;
        }
        synchronized (vc.class) {
            if (a) {
                return;
            }
            try {
                JSONObject jSONObjectA = jn.a(r1.d().f().b("epatelc", "")).a();
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    c.put(next, new uc(jSONObjectA.optJSONObject(next)));
                }
                c.size();
                for (String str : r1.d().f().b("epatelb", "").split(",")) {
                    try {
                        d.put(Integer.valueOf(Integer.parseInt(str.trim())), Boolean.TRUE);
                    } catch (NumberFormatException unused) {
                    }
                }
                b = c.containsKey("*");
            } catch (Throwable unused2) {
            }
            a = true;
        }
    }

    public static void a(ku kuVar) {
        Set<String> setKeySet;
        if (b) {
            setKeySet = e.keySet();
        } else {
            setKeySet = c.keySet();
        }
        if (setKeySet.isEmpty() || kuVar == null) {
            return;
        }
        try {
            JSONObject jSONObjectB = kuVar.b();
            if (jSONObjectB == null) {
                return;
            }
            for (String str : setKeySet) {
                String strOptString = jSONObjectB.optString(str);
                if (!TextUtils.isEmpty(strOptString)) {
                    a(str, strOptString);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2) {
        Map<String, Integer> map = f;
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, Integer.valueOf(String.format("%s_%s", str, str2).hashCode()));
    }

    public static void a(r4 r4Var) {
        if (c.size() == 0 || d.containsKey(Integer.valueOf(r4Var.c()))) {
            return;
        }
        List<Integer> listB = b(r4Var);
        if (listB.size() == 0) {
            return;
        }
        Collections.sort(listB);
        r4Var.a(TextUtils.join(",", listB));
    }
}
