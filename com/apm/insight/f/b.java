package com.apm.insight.f;

import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.entity.c;
import com.apm.insight.n.i;
import com.apm.insight.o.v;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.q;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b {
    private static String a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (i < stackTraceElementArr.length) {
            v.a(stackTraceElementArr[i], sb);
            i++;
        }
        return sb.toString();
    }

    public static void a(final Object obj, final Throwable th, final String str, final boolean z, final Map<String, String> map, final String str2, final String str3) {
        try {
            q.b().a(new Runnable() { // from class: com.apm.insight.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.c(obj, th, str, z, map, str2, str3);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void a(Throwable th, String str, boolean z) {
        a(th, str, z, "core_exception_monitor");
    }

    public static void a(Throwable th, String str, boolean z, String str2) {
        a(th, str, z, (Map<String, String>) null, str2);
    }

    public static void a(final Throwable th, final String str, final boolean z, final Map<String, String> map, final String str2) {
        try {
            q.b().a(new Runnable() { // from class: com.apm.insight.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.b((Object) null, th, str, z, (Map<String, String>) map, str2);
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void a(Map<String, String> map, c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
                cVar.a(SchedulerSupport.CUSTOM, jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(final StackTraceElement[] stackTraceElementArr, final int i, final String str, final String str2, final Map<String, String> map) {
        try {
            q.b().a(new Runnable() { // from class: com.apm.insight.f.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.b(stackTraceElementArr, i, str, str2, "core_exception_monitor", (Map<String, String>) map);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Object obj, Throwable th, String str, boolean z, Map<String, String> map, String str2) {
        c(obj, th, str, z, map, "EnsureNotReachHere", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StackTraceElement[] stackTraceElementArr, int i, String str, String str2, String str3, Map<String, String> map) {
        StackTraceElement stackTraceElement;
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length > i + 1 && (stackTraceElement = stackTraceElementArr[i]) != null) {
                    String strA = a(stackTraceElementArr, i);
                    if (TextUtils.isEmpty(strA)) {
                        return;
                    }
                    c cVarA = c.a(stackTraceElement, strA, str, Thread.currentThread().getName(), true, str2, str3);
                    a(map, cVarA);
                    f.a().a(CrashType.ENSURE, cVarA);
                    i.a(cVarA);
                    com.apm.insight.o.q.b("[report] " + str);
                    com.apm.insight.a.a.a().a(cVarA.h());
                }
            } catch (Throwable th) {
                com.apm.insight.o.q.b(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Object obj, Throwable th, String str, boolean z, Map<String, String> map, String str2, String str3) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        try {
            if (com.apm.insight.n.q.a(obj)) {
                com.apm.insight.o.q.b("[reportException]upload limit all.");
                return;
            }
            if (th == null || (stackTraceElement = (stackTrace = th.getStackTrace())[0]) == null) {
                return;
            }
            String strA = v.a(th);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            c cVarA = c.a(stackTraceElement, strA, str, Thread.currentThread().getName(), z, str2, str3);
            if (obj != null) {
                cVarA.a("exception_line_num", (Object) com.apm.insight.entity.b.a(obj, th, stackTrace));
            }
            a(map, cVarA);
            f.a().a(CrashType.ENSURE, cVarA);
            i.a(obj, cVarA);
            com.apm.insight.o.q.b("[reportException] " + str);
            com.apm.insight.a.a.a().a(cVarA.h());
        } catch (Throwable th2) {
            com.apm.insight.o.q.b(th2);
        }
    }
}
