package com.apm.insight.j;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.b.g;
import com.apm.insight.b.k;
import com.apm.insight.h.c;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.o.j;
import com.apm.insight.o.p;
import com.apm.insight.o.r;
import com.apm.insight.o.v;
import com.apm.insight.runtime.a.c;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.h;
import com.apm.insight.runtime.l;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements c {
    private Context a;

    public b(Context context) {
        this.a = context;
    }

    private synchronized void b(final long j, final Thread thread, final Throwable th, final String str, File file, final String str2, final boolean z) {
        final File file2 = new File(p.a(this.a), str);
        com.apm.insight.h.a.a().a(file2.getName());
        file2.mkdirs();
        j.f(file2);
        final boolean zC = v.c(th);
        com.apm.insight.entity.a aVarA = f.a().a(CrashType.LAUNCH, null, new c.a() { // from class: com.apm.insight.j.b.1
            long a = 0;

            @Override // com.apm.insight.runtime.a.c.a
            public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
                String strValueOf;
                String str3;
                this.a = SystemClock.uptimeMillis();
                if (i != 0) {
                    if (i == 1) {
                        aVar.a(com.alipay.sdk.m.t.a.k, Long.valueOf(j));
                        aVar.a("main_process", Boolean.valueOf(com.apm.insight.o.a.b(b.this.a)));
                        aVar.a("crash_type", CrashType.JAVA);
                        Thread thread2 = thread;
                        aVar.a("crash_thread_name", (Object) (thread2 != null ? thread2.getName() : ""));
                        aVar.a("tid", Integer.valueOf(Process.myTid()));
                        aVar.a("crash_after_crash", Npth.hasCrashWhenJavaCrash() ? "true" : "false");
                        aVar.a("crash_after_native", NativeImpl.d() ? "true" : "false");
                        com.apm.insight.h.a.a().a(thread, th, true, aVar);
                    } else if (i == 2) {
                        if (zC) {
                            com.apm.insight.o.a.a(b.this.a, aVar.h());
                        }
                        aVar.a("launch_did", (Object) a.a(b.this.a));
                        JSONArray jSONArrayC = g.c();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        JSONObject jSONObjectA = g.a(jUptimeMillis);
                        JSONArray jSONArrayA = k.a(100, jUptimeMillis);
                        aVar.a("history_message", (Object) jSONArrayC);
                        aVar.a("current_message", jSONObjectA);
                        aVar.a("pending_messages", (Object) jSONArrayA);
                        aVar.a("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.d()));
                        strValueOf = String.valueOf(com.apm.insight.c.b.a());
                        str3 = "npth_force_apm_crash";
                        aVar.a(str3, strValueOf);
                    } else if (i == 3) {
                        JSONObject jSONObjectB = v.b(Thread.currentThread().getName());
                        if (jSONObjectB != null) {
                            aVar.a("all_thread_stacks", jSONObjectB);
                        }
                        aVar.a("logcat", (Object) l.b(com.apm.insight.g.e()));
                    } else if (i != 4) {
                        if (i == 5) {
                            aVar.a("crash_uuid", (Object) str);
                            h.a(p.k(com.apm.insight.g.f()), CrashType.LAUNCH, "");
                        }
                    } else if (!zC) {
                        com.apm.insight.o.a.a(b.this.a, aVar.h());
                    }
                } else {
                    aVar.a("stack", (Object) v.a(th));
                    aVar.a(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, "start_crash");
                    aVar.a("isOOM", Boolean.valueOf(zC));
                    aVar.a("crash_time", Long.valueOf(j));
                    aVar.a("launch_mode", Integer.valueOf(com.apm.insight.runtime.a.b.b()));
                    aVar.a("launch_time", Long.valueOf(com.apm.insight.runtime.a.b.c()));
                    String str4 = str2;
                    if (str4 != null) {
                        aVar.a("crash_md5", (Object) str4);
                        aVar.a("crash_md5", str2);
                        boolean z2 = z;
                        if (z2) {
                            strValueOf = String.valueOf(z2);
                            str3 = "has_ignore";
                            aVar.a(str3, strValueOf);
                        }
                    }
                }
                return aVar;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar, boolean z2) {
                if (r.a(r.b(i))) {
                    return aVar;
                }
                try {
                    j.a(new File(file2, file2.getName() + "." + i), aVar.h(), false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return aVar;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public void a(Throwable th2) {
            }
        }, true);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        try {
            aVarA.a("crash_type", "normal");
            aVarA.b("crash_cost", String.valueOf(jCurrentTimeMillis));
            aVarA.a("crash_cost", String.valueOf(jCurrentTimeMillis / 1000));
        } catch (Throwable th2) {
            com.apm.insight.b.a().a("NPTH_CATCH", th2);
        }
        if (r.a(4)) {
            return;
        }
        if (!Npth.isStopUpload()) {
            if (!r.a(2048)) {
            }
        }
    }

    @Override // com.apm.insight.h.c
    public void a(long j, Thread thread, Throwable th, String str, File file, String str2, boolean z) {
        b(j, thread, th, str, file, str2, z);
    }

    @Override // com.apm.insight.h.c
    public boolean a(Throwable th) {
        return true;
    }
}
