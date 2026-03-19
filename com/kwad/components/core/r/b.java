package com.kwad.components.core.r;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    private static volatile b Zu = null;
    private static volatile int Zv = 204800;
    static volatile boolean Zw = true;
    static volatile boolean Zx = false;
    static volatile Set<c> Zy = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static void register() {
        try {
            com.kwad.sdk.service.c.h(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    public static b sM() {
        if (Zu == null) {
            synchronized (b.class) {
                if (Zu == null) {
                    Zu = new b();
                }
            }
        }
        return Zu;
    }

    public static void f(boolean z, int i) {
        if (i > 0) {
            Zv = i * 1024;
        }
        Zw = z;
    }

    private static synchronized InputStream wrap(InputStream inputStream) {
        c cVar;
        cVar = new c(inputStream, Zv / (Zy.size() + 1));
        Zy.add(cVar);
        return cVar;
    }

    public static synchronized void a(c cVar) {
        if (Zy.contains(cVar)) {
            Zy.remove(cVar);
        }
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public static boolean sN() {
        return Zw;
    }

    public static void aO(boolean z) {
        Zx = z;
    }

    public static int sO() {
        return Zv / 1024;
    }

    public final synchronized int sP() {
        int iSQ;
        iSQ = 0;
        try {
            Iterator<c> it = Zy.iterator();
            while (it.hasNext()) {
                iSQ += (int) it.next().sQ();
            }
        } catch (Exception unused) {
        }
        return iSQ;
    }
}
