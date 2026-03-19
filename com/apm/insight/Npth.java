package com.apm.insight;

import android.app.Application;
import android.content.Context;
import com.apm.insight.o.q;
import com.apm.insight.o.r;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.k;
import com.apm.insight.runtime.p;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class Npth {
    private static boolean sInit;

    public static void addAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            g.b().b(attachUserData, crashType);
        }
    }

    public static void addAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            g.b().a(attachUserData, crashType);
        }
    }

    public static void addTags(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        g.b().a(map);
    }

    public static void checkInnerNpth(boolean z) {
        p.c(z);
    }

    public static void dumpHprof(String str) {
        p.c(str);
    }

    public static void enableALogCollector(String str, com.apm.insight.a.b bVar, com.apm.insight.a.c cVar) {
        p.a(str, bVar, cVar);
    }

    public static void enableAnrInfo(boolean z) {
        p.b(z);
    }

    public static void enableLoopMonitor(boolean z) {
        p.a(z);
    }

    public static void enableNativeDump(boolean z) {
        p.d(z);
    }

    public static void enableThreadsBoost() {
        g.a(1);
    }

    public static ConfigManager getConfigManager() {
        return g.h();
    }

    public static boolean hasCrash() {
        return p.k();
    }

    public static boolean hasCrashWhenJavaCrash() {
        return p.l();
    }

    public static boolean hasCrashWhenNativeCrash() {
        return p.m();
    }

    public static synchronized void init(Application application, Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        if (sInit) {
            return;
        }
        sInit = true;
        p.a(application, context, z, z2, z3, z4, j);
        g.a(application, context, iCommonParams);
        Map<String, Object> mapA = g.a().a();
        MonitorCrash monitorCrashInit = MonitorCrash.init(context, String.valueOf(r.a(mapA.get("aid"), 4444)), r.a(mapA.get("update_version_code"), 0), String.valueOf(mapA.get("app_version")));
        if (monitorCrashInit != null) {
            monitorCrashInit.config().setDeviceId(g.a().d()).setChannel(String.valueOf(mapA.get("channel")));
        }
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams) {
        init(context, iCommonParams, true, false, false);
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3) {
        init(context, iCommonParams, z, z, z2, z3);
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4) {
        init(context, iCommonParams, z, z2, z3, z4, 0L);
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        Application applicationG;
        Context baseContext = context;
        synchronized (Npth.class) {
            if (g.g() != null) {
                applicationG = g.g();
            } else if (baseContext instanceof Application) {
                applicationG = (Application) baseContext;
                if (applicationG.getBaseContext() == null) {
                    throw new IllegalArgumentException("初始化时传入的Application还未attach, 请在init时传入attachBaseContext的参数, 并在init之前手动调用Npth.setApplication(Application).");
                }
            } else {
                applicationG = (Application) context.getApplicationContext();
                if (applicationG == null) {
                    throw new IllegalArgumentException("初始化时传入了baseContext, 导致无法获取Application实例, 请在init之前手动调用Npth.setApplication(Application).");
                }
                if (applicationG.getBaseContext() != null) {
                    baseContext = applicationG.getBaseContext();
                }
            }
            init(applicationG, baseContext, iCommonParams, z, z2, z3, z4, j);
        }
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams) {
        g.a(true);
        init(context, iCommonParams, true, false, true, true);
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams, int i, String str) {
        g.a(true);
        g.b(i, str);
        init(context, iCommonParams, true, true, true, true);
    }

    public static boolean isANREnable() {
        return p.c();
    }

    public static boolean isInit() {
        return sInit;
    }

    public static boolean isJavaCrashEnable() {
        return p.b();
    }

    public static boolean isNativeCrashEnable() {
        return p.d();
    }

    public static boolean isRunning() {
        return p.i();
    }

    public static boolean isStopUpload() {
        return p.n();
    }

    public static void openANRMonitor() {
        p.g();
    }

    public static void openJavaCrashMonitor() {
        p.f();
    }

    public static boolean openNativeCrashMonitor() {
        return p.h();
    }

    public static void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        p.a(iCrashCallback, crashType);
    }

    public static void registerOOMCallback(IOOMCallback iOOMCallback) {
        p.a(iOOMCallback);
    }

    public static void registerSdk(int i, String str) {
        g.a(i, str);
    }

    public static void removeAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            g.b().b(crashType, attachUserData);
        }
    }

    public static void removeAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            g.b().a(crashType, attachUserData);
        }
    }

    public static void reportDartError(String str) {
        q.a((Object) ("reportDartError " + str));
        p.a(str);
    }

    public static void reportDartError(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, IUploadCallback iUploadCallback) {
        q.a((Object) ("reportDartError " + str));
        p.a(str, map, map2, iUploadCallback);
    }

    public static void reportDartError(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, IUploadCallback iUploadCallback) {
        q.a((Object) ("reportDartError " + str));
        p.a(str, map, map2, map3, iUploadCallback);
    }

    @Deprecated
    public static void reportError(String str) {
        p.b(str);
    }

    @Deprecated
    public static void reportError(Throwable th) {
        p.a(th);
    }

    public static void setAlogFlushAddr(long j) {
        p.a(j);
    }

    public static void setAlogFlushV2Addr(long j) {
        p.b(j);
    }

    public static void setAlogLogDirAddr(long j) {
        p.c(j);
    }

    public static void setAlogWriteAddr(long j) {
    }

    public static void setAnrInfoFileObserver(String str, e eVar) {
        p.a(str, eVar);
    }

    public static void setApplication(Application application) {
        g.a(application);
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            g.b().a(attachUserData, crashType);
        }
    }

    public static void setBusiness(String str) {
        if (str != null) {
            g.a(str);
        }
    }

    public static void setCrashFilter(ICrashFilter iCrashFilter) {
        g.b().a(iCrashFilter);
    }

    public static void setCurProcessName(String str) {
        com.apm.insight.o.a.a(str);
    }

    public static void setEncryptImpl(d dVar) {
        p.a(dVar);
    }

    public static void setLogcatImpl(k kVar) {
        p.a(kVar);
    }

    public static void setRequestIntercept(com.apm.insight.n.k kVar) {
        p.a(kVar);
    }

    public static void stopAnr() {
        p.j();
    }

    public static void stopUpload() {
        p.o();
    }

    public static void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        p.b(iCrashCallback, crashType);
    }

    public static void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        p.a(iOOMCallback, crashType);
    }
}
