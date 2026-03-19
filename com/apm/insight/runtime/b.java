package com.apm.insight.runtime;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    private static long a = -30000;
    private static File b;

    public static String a(long j, String str) {
        try {
            return com.apm.insight.o.j.c(new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/TrackInfo/" + ((j - (j % 86400000)) / 86400000) + "/" + str));
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static void a() {
        File file = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/TrackInfo/");
        String[] list = file.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 5; i++) {
                com.apm.insight.o.j.a(new File(file, list[i]));
            }
        }
    }

    public static void a(long j) throws Throwable {
        if (j - a < 30000) {
            return;
        }
        a = j;
        try {
            com.apm.insight.o.j.a(b(), String.valueOf(System.currentTimeMillis()), false);
        } catch (IOException unused) {
        }
    }

    private static File b() {
        if (b == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/TrackInfo/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % 86400000)) / 86400000) + "/" + com.apm.insight.g.e());
        }
        return b;
    }
}
