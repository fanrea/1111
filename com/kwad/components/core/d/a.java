package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.l;
import com.kwad.sdk.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.m;
import com.kwai.CpuMemoryProfiler;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static boolean PR;
    private static boolean PS;
    private static List<Throwable> PU;
    private static Map<String, String> PV;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean PT = new AtomicBoolean(false);
    private static final List<b> PW = new CopyOnWriteArrayList();
    private static final List<c> PX = new CopyOnWriteArrayList();

    public interface b {
        String getKey();

        JSONObject getValue();
    }

    public interface c {
        void onCrashOccur(int i, String str);
    }

    public static synchronized void initAsync(Context context) {
        if (context != null) {
            if (!mHasInit.get() && !PR) {
                PR = true;
                h.execute(new bh() { // from class: com.kwad.components.core.d.a.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (e.b(com.kwad.sdk.core.config.c.bwT)) {
                            com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", PointCategory.INIT);
                            com.kwad.sdk.crash.b.a(a.oG());
                            a.mHasInit.set(true);
                            a.oE();
                            a.oF();
                        }
                    }
                });
            }
        }
    }

    public static synchronized void am(Context context) {
        if (context != null) {
            if (!PT.get() && !PS) {
                PS = true;
                h.execute(new bh() { // from class: com.kwad.components.core.d.a.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (e.b(com.kwad.sdk.core.config.c.bwT)) {
                            com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init Native");
                            com.kwad.sdk.crash.b.b(a.oG());
                            a.PT.set(true);
                        }
                    }
                });
            }
        }
    }

    public static void a(b bVar) {
        PW.add(bVar);
    }

    public static void a(c cVar) {
        PX.add(cVar);
    }

    public static void reportSdkCaughtException(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTrace(th);
        if (!mHasInit.get()) {
            b(th);
        } else if (oD()) {
            com.kwad.sdk.crash.b.s(th);
        }
    }

    private static boolean oD() {
        return e.b(com.kwad.sdk.core.config.c.bwU);
    }

    public static void j(String str, String str2) {
        if (!mHasInit.get()) {
            k(str, str2);
        } else {
            com.kwad.sdk.crash.report.h.ao(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (PV == null) {
            PV = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PV.put(str, str2);
    }

    private static void b(Throwable th) {
        if (PU == null) {
            PU = new CopyOnWriteArrayList();
        }
        PU.add(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oE() {
        if (PU == null || !oD()) {
            return;
        }
        Iterator<Throwable> it = PU.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.s(it.next());
        }
        PU.clear();
        PU = null;
        ServiceProvider.f(new com.kwad.sdk.g.a<Throwable>() { // from class: com.kwad.components.core.d.a.3
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(Throwable th) {
                c(th);
            }

            private static void c(Throwable th) {
                com.kwad.sdk.crash.b.s(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oF() {
        Map<String, String> map = PV;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                com.kwad.sdk.crash.report.h.ao(entry.getKey(), entry.getValue());
            }
        }
        PV.clear();
    }

    private static com.kwad.sdk.crash.model.b al(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("KsAdExceptionCollectorHelper", e);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwad.sdk.crash.c oG() {
        String strA = e.a(com.kwad.sdk.core.config.c.byq);
        com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "configStr:" + strA);
        com.kwad.sdk.crash.model.b bVarAl = al(strA);
        String str = bVarAl.bNS;
        String str2 = bVarAl.bNT;
        boolean zA = g.a(bVarAl);
        boolean zB = g.b(bVarAl);
        final Context context = ServiceProvider.getContext();
        String strAn = C0464a.an(context);
        c.a aVarGA = new c.a().cr(context).cL(zA).cM(zB).cN(l.UL().TQ()).gB(str).gA(str2);
        l.UL();
        c.a aVarGI = aVarGA.gI(ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 2));
        l.UL();
        return aVarGI.fP(BuildConfig.VERSION_CODE).gJ(ExceptionMessage.getSdkCrashVersionName(l.UL().getApiVersion(), 2)).fQ(l.UL().getApiVersionCode()).fR(2).gH("com.kwad.sdk").gK(context.getPackageName()).gL(ServiceProvider.getSDKConfig().appId).gM(ServiceProvider.getSDKConfig().appName).gN(m.dc(context)).gO(bVarAl.bNO).gP(bVarAl.bNP).gE(be.getDeviceId()).gF(ServiceProvider.getSDKConfig().appId).gD(bVarAl.version).gQ(bVarAl.bNR).gR(bVarAl.bNQ).gC("Android").gG(strAn).a(new com.kwad.sdk.crash.h() { // from class: com.kwad.components.core.d.a.5
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a oP() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.gW(t.abs());
                aVar.putString("mKsadAppId", ServiceProvider.getSDKConfig().appId);
                aVar.putString("mKsadAppName", ServiceProvider.getSDKConfig().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", m.dc(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                l.UL();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 2));
                l.UL();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(l.UL().getApiVersion(), 2));
                aVar.putInt("mKsadSdKApiVersionCode", l.UL().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 2);
                aVar.putInt("mBuildNumber", 215);
                for (b bVar : a.PW) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                n.bc(context);
                if (i == 1 || i == 3 || i == 4) {
                    com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
                Iterator it = a.PX.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onCrashOccur(i, exceptionMessage.mCrashDetail);
                }
            }
        }).f(oH()).g(oI()).ar(e.XI()).p(e.a(com.kwad.sdk.core.config.c.bzy)).aee();
    }

    private static String[] oH() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(am(KsAdSDKImpl.class.getName()));
            arrayList.add(am(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(am(CpuMemoryProfiler.class.getName()));
            arrayList.add(am(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] oI() {
        String[] strArr = new String[1];
        try {
            String name = d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return strArr;
    }

    /* renamed from: com.kwad.components.core.d.a$a, reason: collision with other inner class name */
    static class C0464a {
        public static String an(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            if (Build.VERSION.SDK_INT >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!dataDir.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return dataDir;
        }
    }

    private static String am(String str) {
        try {
            int iIndexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (iIndexOf > 0) {
                return str.substring(0, iIndexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }
}
