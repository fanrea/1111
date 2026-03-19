package com.apm.insight.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.insight.o.r;
import com.apm.insight.o.v;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    private static String a = null;
    private static long b = -1;
    private static boolean c = false;
    private static FileObserver d;
    private static ActivityManager.ProcessErrorStateInfo e;

    static String a(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoA;
        if (r.a(256)) {
            c = false;
            return "TEST_ANR_INFO";
        }
        if (SystemClock.uptimeMillis() - b < 5000) {
            return null;
        }
        try {
            processErrorStateInfoA = com.apm.insight.o.a.a(context, i);
        } catch (Throwable unused) {
        }
        if (processErrorStateInfoA == null || Process.myPid() != processErrorStateInfoA.pid) {
            e = null;
            String str = a;
            if (str == null) {
                return null;
            }
            c = true;
            a = null;
            b = SystemClock.uptimeMillis();
            return str;
        }
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = e;
        if (processErrorStateInfo != null && a.a(processErrorStateInfo, processErrorStateInfoA)) {
            return null;
        }
        e = processErrorStateInfoA;
        a = null;
        b = SystemClock.uptimeMillis();
        c = false;
        return a.a(processErrorStateInfoA);
    }

    public static JSONObject a(boolean z) {
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("thread_number", 1);
            jSONObject.put("mainStackFromTrace", v.a(stackTrace));
            return jSONObject;
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
            return null;
        }
    }

    public static void a(final String str, final com.apm.insight.e eVar) {
        FileObserver fileObserver = d;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        FileObserver fileObserver2 = new FileObserver(str, 136) { // from class: com.apm.insight.b.d.1
            @Override // android.os.FileObserver
            public void onEvent(int i, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    String unused = d.a = eVar.a(str, str2);
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                }
            }
        };
        d = fileObserver2;
        fileObserver2.startWatching();
    }

    public static boolean a() {
        return c;
    }
}
