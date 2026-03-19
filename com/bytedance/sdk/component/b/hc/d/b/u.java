package com.bytedance.sdk.component.b.hc.d.b;

import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.rf;
import com.bytedance.sdk.component.b.hc.uo;
import com.bytedance.sdk.component.b.hc.yo;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u {
    private static final Pattern d = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long d(j jVar) {
        return d(jVar.h());
    }

    public static long d(yo yoVar) {
        return d(yoVar.d("Content-Length"));
    }

    private static long d(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> hc(yo yoVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iD = yoVar.d();
        for (int i = 0; i < iD; i++) {
            if ("Vary".equalsIgnoreCase(yoVar.d(i))) {
                String strHc = yoVar.hc(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strHc.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static yo hc(j jVar) {
        return d(jVar.tc().d().b(), jVar.h());
    }

    public static yo d(yo yoVar, yo yoVar2) {
        Set<String> setHc = hc(yoVar2);
        if (setHc.isEmpty()) {
            return new yo.d().d();
        }
        yo.d dVar = new yo.d();
        int iD = yoVar.d();
        for (int i = 0; i < iD; i++) {
            String strD = yoVar.d(i);
            if (setHc.contains(strD)) {
                dVar.d(strD, yoVar.hc(i));
            }
        }
        return dVar.d();
    }

    public static void d(uo uoVar, rf rfVar, yo yoVar) {
        if (uoVar == uo.d) {
            return;
        }
        com.bytedance.sdk.component.b.hc.mq.d(rfVar, yoVar).isEmpty();
    }

    public static boolean b(j jVar) {
        if (jVar.d().hc().equals("HEAD")) {
            return false;
        }
        int iB = jVar.b();
        return (((iB >= 100 && iB < 200) || iB == 204 || iB == 304) && d(jVar) == -1 && !"chunked".equalsIgnoreCase(jVar.d("Transfer-Encoding"))) ? false : true;
    }

    public static int d(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int d(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int hc(String str, int i) throws NumberFormatException {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
