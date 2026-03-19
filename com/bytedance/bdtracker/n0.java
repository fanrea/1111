package com.bytedance.bdtracker;

import android.os.Process;
import com.bytedance.applog.exception.AppCrashType;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.l0;
import java.lang.Thread;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class n0 implements Thread.UncaughtExceptionHandler {
    public static volatile n0 b;
    public final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

    public class a implements b.e {
        public a(n0 n0Var) {
        }

        @Override // com.bytedance.bdtracker.b.e
        public boolean a(d dVar) {
            return dVar.getInitConfig() != null && AppCrashType.hasJavaCrashType(dVar.getInitConfig().getTrackCrashType());
        }
    }

    public class b implements b.d {
        public final /* synthetic */ Throwable a;
        public final /* synthetic */ b.e b;
        public final /* synthetic */ a4 c;

        public b(n0 n0Var, Throwable th, b.e eVar, a4 a4Var) {
            this.a = th;
            this.b = eVar;
            this.c = a4Var;
        }

        @Override // com.bytedance.bdtracker.b.d
        public void a(d dVar) {
            if (dVar.getInitConfig() != null && dVar.getInitConfig().isMonitorEnabled()) {
                l2.b(dVar.getMonitor(), this.a);
            }
            if (this.b.a(dVar)) {
                dVar.receive(this.c);
                dVar.flush();
            }
        }
    }

    public n0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static synchronized void a() {
        if (b == null) {
            b = new n0();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a aVar = new a(this);
        if (!com.bytedance.bdtracker.b.a(aVar)) {
            com.bytedance.bdtracker.b.a(new o0(this, th));
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            try {
                Process.killProcess(Process.myPid());
                System.exit(10);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$is_backstage", !w.b);
            jSONObject.put("$event_time", jCurrentTimeMillis);
            jSONObject.put("$crash_thread", thread.getName());
            jSONObject.put("$crash_process", l0.b.b());
            StringBuilder sb = new StringBuilder();
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                sb.append(cause.toString());
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    sb.append("\n\tat ").append(stackTraceElement);
                }
            }
            jSONObject.put("$detailed_stack", sb.toString());
        } catch (Throwable th2) {
            LoggerImpl.global().error(Collections.singletonList("ExceptionHandler"), "Collect crash params failed", th2, new Object[0]);
        }
        com.bytedance.bdtracker.b.a(new b(this, th, aVar, new a4("$crash", jSONObject)));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.a;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }
}
