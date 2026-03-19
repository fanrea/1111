package com.baidu.mobads.container.components.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    public static ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();
    public static LinkedList<String> c = new LinkedList<>();
    private static final int d = 100;
    private static final long e = 1800000;
    private static Context f;
    private static String g;
    private static String h;

    public static void a(long j, String str, j jVar) {
        if (j < 0 || jVar == null) {
            return;
        }
        String uniqueId = jVar.getUniqueId();
        if (TextUtils.isEmpty(uniqueId)) {
            return;
        }
        if (c(uniqueId) == null) {
            a.put(uniqueId, new c(j, str, jVar));
            c.add(uniqueId);
        }
        e.c().d();
    }

    public static void a(Context context) {
        if (context != null && f == null) {
            f = context.getApplicationContext();
        }
    }

    public static boolean a(String str, String str2) {
        return false;
    }

    public static String a(String str) {
        return null;
    }

    public static void b(String str, String str2) {
    }

    public static void a(String str, String str2, String str3) {
    }

    public static void a(String str, a aVar) {
    }

    public static long c(String str, String str2) {
        return 0L;
    }

    public static void b(String str) {
    }

    protected static void a() {
        try {
            Set<String> setKeySet = a.keySet();
            if (setKeySet != null && setKeySet.size() > 0) {
                Iterator<String> it = setKeySet.iterator();
                while (it.hasNext()) {
                    c cVarC = c(it.next());
                    if (cVarC != null && System.currentTimeMillis() - cVarC.b > e) {
                        cVarC.a(true);
                        cVarC.a(b.f, System.currentTimeMillis() + "");
                    }
                }
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    protected static void b() {
        try {
            if (a.size() > 0) {
                Iterator<String> it = a.keySet().iterator();
                while (it.hasNext()) {
                    c cVar = a.get(it.next());
                    if (cVar != null && cVar.e.get() && !cVar.f.get()) {
                        a(cVar);
                    }
                }
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    protected static void c() {
        try {
            if (a.size() > 100) {
                Set<String> setKeySet = a.keySet();
                if (setKeySet.size() > 0) {
                    for (String str : setKeySet) {
                        c cVar = a.get(str);
                        if (cVar != null && cVar.f.get()) {
                            a.remove(str);
                            c.remove(str);
                        }
                    }
                }
                if (a.size() > 100) {
                    int size = a.size() - 100;
                    for (int i = 0; i < size; i++) {
                        String first = c.getFirst();
                        c.remove(0);
                        a.remove(first);
                    }
                }
                Set<String> setKeySet2 = b.keySet();
                if (setKeySet2.size() > 0) {
                    for (String str2 : setKeySet2) {
                        String str3 = b.get(str2);
                        if (!TextUtils.isEmpty(str3) && !a.containsKey(str3)) {
                            b.remove(str2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private static void a(c cVar) {
        try {
            if (f != null) {
                by.a.a(f).a(1048).a(cVar.a).c(cVar.c).a("states", cVar.b()).a(b.a, "" + cVar.b).a(cVar.a()).f();
                cVar.b(true);
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private static c c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && a.size() > 0) {
                if (!a.containsKey(str) && b.containsKey(str)) {
                    str = b.get(str);
                }
                if (!TextUtils.isEmpty(str)) {
                    return a.get(str);
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }
}
