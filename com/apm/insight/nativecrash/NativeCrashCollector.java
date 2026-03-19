package com.apm.insight.nativecrash;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.b.k;
import com.apm.insight.g;
import com.apm.insight.o.j;
import com.apm.insight.o.q;
import com.apm.insight.o.v;
import com.apm.insight.runtime.a.c;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.h;
import com.apm.insight.runtime.p;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NativeCrashCollector {
    public static int a() {
        return 6;
    }

    private static void a(String str, Thread thread) {
        Iterator<ICrashCallback> it = p.a().d().iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(CrashType.NATIVE, str, thread);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (LiveConfigKey.MAIN.equalsIgnoreCase(str)) {
            return v.a(Looper.getMainLooper().getThread().getStackTrace());
        }
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int iActiveCount = threadGroup.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroup.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            String name = threadArr[i].getName();
            if (!TextUtils.isEmpty(name) && (name.equals(str) || name.startsWith(str) || name.endsWith(str))) {
                return v.a(threadArr[i].getStackTrace());
            }
        }
        try {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                String name2 = entry.getKey().getName();
                if (name2.equals(str) || name2.startsWith(str) || name2.endsWith(str)) {
                    return v.a(entry.getValue());
                }
            }
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
        return "";
    }

    public static void onNativeCrash(final String str) {
        d dVar;
        d dVar2;
        String strD;
        d dVar3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        q.a((Object) "[onNativeCrash] enter");
        try {
            try {
                com.apm.insight.n.c.a().b();
                final File file = new File(com.apm.insight.o.p.a(), g.e());
                final File fileE = com.apm.insight.o.p.e(file);
                com.apm.insight.entity.a aVarA = f.a().a(CrashType.NATIVE, null, new c.a() { // from class: com.apm.insight.nativecrash.NativeCrashCollector.1
                    @Override // com.apm.insight.runtime.a.c.a
                    public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
                        String str2;
                        String str3;
                        str2 = "true";
                        if (i != 1) {
                            if (i == 2) {
                                JSONArray jSONArrayC = com.apm.insight.b.g.c();
                                long jUptimeMillis = SystemClock.uptimeMillis();
                                JSONObject jSONObjectA = com.apm.insight.b.g.a(jUptimeMillis);
                                JSONArray jSONArrayA = k.a(100, jUptimeMillis);
                                aVar.a("history_message", (Object) jSONArrayC);
                                aVar.a("current_message", jSONObjectA);
                                aVar.a("pending_messages", (Object) jSONArrayA);
                                aVar.a("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.d()));
                                aVar.a("npth_force_apm_crash", String.valueOf(com.apm.insight.c.b.a()));
                            } else if (i != 3) {
                                if (i == 4) {
                                    com.apm.insight.o.a.a(g.f(), aVar.h());
                                    h.a(com.apm.insight.o.p.k(g.f()), CrashType.NATIVE, "");
                                }
                            } else if (com.apm.insight.runtime.a.e()) {
                                aVar.a("all_thread_stacks", v.b(str));
                                str3 = "has_all_thread_stack";
                            }
                            return aVar;
                        }
                        com.apm.insight.entity.b.a(file, CrashType.NATIVE);
                        String str4 = str;
                        if (str4 != null && str4.length() != 0) {
                            aVar.a("java_data", (Object) NativeCrashCollector.b(str));
                        }
                        str2 = Npth.hasCrashWhenNativeCrash() ? "true" : "false";
                        str3 = "crash_after_crash";
                        aVar.a(str3, str2);
                        return aVar;
                    }

                    @Override // com.apm.insight.runtime.a.c.a
                    public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar, boolean z) {
                        try {
                            JSONObject jSONObjectH = aVar.h();
                            if (jSONObjectH.length() > 0) {
                                j.a(new File(fileE.getAbsolutePath() + '.' + i), jSONObjectH, false);
                            }
                        } catch (IOException e) {
                            com.apm.insight.b.a().a("NPTH_CATCH", e);
                        }
                        if (i == 0) {
                            com.apm.insight.a.a.a().b();
                        }
                        return aVar;
                    }

                    @Override // com.apm.insight.runtime.a.c.a
                    public void a(Throwable th) {
                    }
                }, true);
                JSONObject jSONObjectH = aVarA.h();
                if (jSONObjectH != null && jSONObjectH.length() != 0) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long j = jCurrentTimeMillis2 - jCurrentTimeMillis;
                    try {
                        jSONObjectH.put("java_end", jCurrentTimeMillis2);
                        aVarA.b("crash_cost", String.valueOf(j));
                        aVarA.a("crash_cost", String.valueOf(j / 1000));
                    } catch (Throwable unused) {
                    }
                    File file2 = new File(fileE.getAbsolutePath() + ".tmp");
                    j.a(file2, jSONObjectH, false);
                    file2.renameTo(fileE);
                }
                try {
                    dVar3 = new d(new File(com.apm.insight.o.p.a(), g.e()));
                    try {
                        JSONArray jSONArrayB = com.apm.insight.entity.b.b(dVar3.b());
                        com.apm.insight.a.a.a().a(CrashType.NATIVE, dVar3.d(), dVar3.a());
                        com.apm.insight.a.a.a().a(CrashType.NATIVE, jCurrentTimeMillis, g.e(), jSONArrayB);
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    dVar3 = null;
                }
            } catch (Throwable th) {
                try {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                    try {
                        dVar2 = new d(new File(com.apm.insight.o.p.a(), g.e()));
                        try {
                            JSONArray jSONArrayB2 = com.apm.insight.entity.b.b(dVar2.b());
                            com.apm.insight.a.a.a().a(CrashType.NATIVE, dVar2.d(), dVar2.a());
                            com.apm.insight.a.a.a().a(CrashType.NATIVE, jCurrentTimeMillis, g.e(), jSONArrayB2);
                        } catch (Throwable unused4) {
                        }
                    } catch (Throwable unused5) {
                        dVar2 = null;
                    }
                    if (p.a().d().isEmpty()) {
                        return;
                    }
                    if (dVar2 == null) {
                        dVar2 = new d(new File(com.apm.insight.o.p.a(), g.e()));
                    }
                    strD = dVar2.d();
                } catch (Throwable th2) {
                    try {
                        dVar = new d(new File(com.apm.insight.o.p.a(), g.e()));
                        try {
                            JSONArray jSONArrayB3 = com.apm.insight.entity.b.b(dVar.b());
                            com.apm.insight.a.a.a().a(CrashType.NATIVE, dVar.d(), dVar.a());
                            com.apm.insight.a.a.a().a(CrashType.NATIVE, jCurrentTimeMillis, g.e(), jSONArrayB3);
                        } catch (Throwable unused6) {
                        }
                    } catch (Throwable unused7) {
                        dVar = null;
                    }
                    try {
                        if (p.a().d().isEmpty()) {
                            throw th2;
                        }
                        if (dVar == null) {
                            dVar = new d(new File(com.apm.insight.o.p.a(), g.e()));
                        }
                        a(dVar.d(), null);
                        throw th2;
                    } catch (Throwable unused8) {
                        a("", null);
                        throw th2;
                    }
                }
            }
            if (p.a().d().isEmpty()) {
                return;
            }
            if (dVar3 == null) {
                dVar3 = new d(new File(com.apm.insight.o.p.a(), g.e()));
            }
            strD = dVar3.d();
            a(strD, null);
        } catch (Throwable unused9) {
            a("", null);
        }
    }
}
