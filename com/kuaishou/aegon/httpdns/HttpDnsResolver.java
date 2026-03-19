package com.kuaishou.aegon.httpdns;

import android.os.Handler;
import android.os.Looper;
import com.kuaishou.aegon.Aegon;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HttpDnsResolver {
    private static a sLogger;
    private static Handler sLoggerHandler;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface a {
        void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeIncreasePriority(String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native List<ResolvedIP> nativeResolve(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetJsonConfig(String str);

    public static void setLogger(a aVar) {
        synchronized (HttpDnsResolver.class) {
            sLogger = aVar;
            sLoggerHandler = new Handler(Looper.getMainLooper());
        }
    }

    public static void increasePriority(List<String> list) {
        if (!Aegon.isInitialized() || list == null) {
            return;
        }
        Aegon.getCronetEngine();
        com.kuaishou.aegon.a.a.b(com.kuaishou.aegon.httpdns.a.a(list));
    }

    public static List<ResolvedIP> resolve(String str) {
        if (!Aegon.isInitialized()) {
            return new ArrayList();
        }
        Aegon.getCronetEngine();
        List<ResolvedIP> list = (List) com.kuaishou.aegon.a.a.a(b.a(str));
        return list == null ? new ArrayList() : list;
    }

    public static void updateConfig(String str) {
        if (Aegon.isInitialized()) {
            Aegon.getCronetEngine();
            com.kuaishou.aegon.a.a.b(c.a(str));
        }
    }

    static void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo) {
        Handler handler;
        synchronized (HttpDnsResolver.class) {
            if (sLogger != null && (handler = sLoggerHandler) != null) {
                handler.post(d.a(resolveFinishedInfo));
            }
        }
    }
}
