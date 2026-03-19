package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static Set<String> bNy;

    static {
        HashSet hashSet = new HashSet();
        bNy = hashSet;
        hashSet.add("commonHT");
        bNy.add("reportHT");
        bNy.add("IpDirectHelper");
        bNy.add("filedownloader serial thread");
        bNy.add("RemitHandoverToDB");
        bNy.add("source-status-callback");
        bNy.add("ObiwanMMAPTracer");
        bNy.add("FrameSequence decoding thread");
    }

    private static boolean as(List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] strArrAeg = e.aef().aeg();
        if (strArrAeg == null || strArrAeg.length == 0) {
            return true;
        }
        boolean zA = false;
        for (String str : strArrAeg) {
            zA = a(stackTraceElementArr, str);
            if (zA) {
                break;
            }
        }
        if (zA) {
            for (String str2 : e.aef().aeh()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return zA;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean t(Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return as(arrayList);
    }

    private static boolean gS(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return gT(str) || str.startsWith("ksad-") || str.startsWith("filedownloader serial thread");
    }

    private static boolean gT(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("kwad.kwadsdk")) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadStr:" + str);
        return true;
    }

    public static boolean gU(String str) {
        if (gS(str) || i.cT(str)) {
            return true;
        }
        Set<String> set = bNy;
        if (set == null || !set.contains(str)) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadName:" + str);
        return true;
    }

    public static boolean gV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArrAeg = e.aef().aeg();
        if (strArrAeg == null || strArrAeg.length == 0) {
            return true;
        }
        boolean zContains = false;
        for (String str2 : strArrAeg) {
            zContains = str.contains(str2);
            if (zContains) {
                break;
            }
        }
        if (zContains) {
            for (String str3 : e.aef().aeh()) {
                if (str.contains(str3)) {
                    return false;
                }
            }
        }
        return zContains;
    }
}
