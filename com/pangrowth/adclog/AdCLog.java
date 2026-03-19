package com.pangrowth.adclog;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.ad.android.alog.Alog;
import com.apm.insight.runtime.ConfigManager;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdCLog {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    private static final int EXPIRE_DAYS = 7;
    public static final int INFO = 4;
    private static final int MAX_SIZE = 30;
    private static final String PATH_SUFFIX = "/pangrowth_alog";
    private static final int PER_SIZE = 2;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final AtomicBoolean sAdCLogInitialized = new AtomicBoolean(false);
    private static final AtomicBoolean sCloudMessageInitialized = new AtomicBoolean(false);
    private static final ExecutorService sExecutor = Executors.newSingleThreadExecutor();

    public static class b implements Runnable {
        /* JADX WARN: Code restructure failed: missing block: B:57:0x015e, code lost:
        
            r2 = r4.getValue();
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 502
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.AdCLog.b.run():void");
        }
    }

    public static void d(String str, String str2) {
        if (sAdCLogInitialized.get() && f.a(3, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(3, str, str2);
                return;
            }
            Alog alog = f.d;
            if (alog == null || !zA) {
                i.a(1, str, str2);
            } else {
                alog.a(1, str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (sAdCLogInitialized.get() && f.a(6, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(6, str, str2);
                return;
            }
            Alog alog = f.d;
            if (alog == null || !zA) {
                i.a(4, str, str2);
            } else {
                alog.a(4, str, str2);
            }
        }
    }

    public static void fetchCommand() {
        if (sCloudMessageInitialized.get()) {
            sExecutor.execute(new b());
        }
    }

    public static void i(String str, String str2) {
        if (sAdCLogInitialized.get() && f.a(4, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(4, str, str2);
                return;
            }
            Alog alog = f.d;
            if (alog == null || !zA) {
                i.a(2, str, str2);
            } else {
                alog.a(2, str, str2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0206 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x014a A[EXC_TOP_SPLITTER, PHI: r3
  0x014a: PHI (r3v14 java.io.BufferedReader) = (r3v12 java.io.BufferedReader), (r3v15 java.io.BufferedReader), (r3v15 java.io.BufferedReader) binds: [B:70:0x0148, B:58:0x012c, B:60:0x0136] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void initAdCLog(android.content.Context r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.AdCLog.initAdCLog(android.content.Context):void");
    }

    public static void initCloudMessage(Context context, String str) {
        if (sCloudMessageInitialized.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = v.a;
            if (applicationContext != null) {
                if (!(applicationContext instanceof Application)) {
                    applicationContext = applicationContext.getApplicationContext();
                }
                v.a = (Application) applicationContext;
            }
            v.b = true;
            v.g = true;
            d1 d1Var = new d1("3892", str);
            synchronized (v.class) {
                v.d = d1Var;
                Map<String, String> mapA = d1Var.a();
                v.e = mapA;
                if (!((HashMap) mapA).containsKey("aid")) {
                    v.e.put("aid", v.c.optString("aid"));
                }
                if (!v.e.containsKey(com.baidu.mobads.upgrade.remote.gray.c.l)) {
                    v.e.put(com.baidu.mobads.upgrade.remote.gray.c.l, v.c.optString(com.baidu.mobads.upgrade.remote.gray.c.l));
                }
                if (!v.e.containsKey("device_platform")) {
                    v.e.put("device_platform", "android");
                }
                v.e.put("os", "Android");
                if (!v.e.containsKey("update_version_code")) {
                    v.e.put("update_version_code", v.c.optString("update_version_code"));
                }
                if (!v.e.containsKey("version_code")) {
                    v.e.put("version_code", v.c.optString("version_code"));
                }
                if (!v.e.containsKey("channel")) {
                    v.e.put("channel", v.c.optString("channel"));
                }
                if (!v.e.containsKey("os_api")) {
                    v.e.put("os_api", Build.VERSION.SDK_INT + "");
                }
                if (v.a() && !v.e.containsKey("_log_level")) {
                    v.e.put("_log_level", "debug");
                }
            }
            String str2 = "https://mon.snssdk.com" + ConfigManager.FILE_UPLOAD_URL_SUFFIX;
            i.f = "mon.snssdk.com";
            f1.i = true;
            f1.f = context.getApplicationContext();
            f1.c();
            if (v.a()) {
                Log.d("cloudmessage", a0.a(new String[]{"CloudMessageManager Init."}));
            }
            a aVar = new a();
            if (f1.i) {
                f1.c().a(aVar);
            } else {
                f1.h = aVar;
            }
            fetchCommand();
        }
    }

    public static void v(String str, String str2) {
        if (sAdCLogInitialized.get() && f.a(2, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(2, str, str2);
                return;
            }
            Alog alog = f.d;
            if (alog == null || !zA) {
                i.a(0, str, str2);
            } else {
                alog.a(0, str, str2);
            }
        }
    }

    public static void w(String str, String str2) {
        if (sAdCLogInitialized.get() && f.a(5, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(5, str, str2);
                return;
            }
            Alog alog = f.d;
            if (alog == null || !zA) {
                i.a(3, str, str2);
            } else {
                alog.a(3, str, str2);
            }
        }
    }

    public static class a implements i1 {
        public List<String> a;

        @Override // com.pangrowth.adclog.j1
        public q1 a() {
            List<String> list = this.a;
            boolean z = list != null && list.size() > 0;
            String str = z ? "" : "alog file not get";
            HashMap map = null;
            if (!z) {
                int i = f.a;
                if (i.e != null) {
                    HashMap map2 = new HashMap();
                    map2.put("start", Long.toString(i.a));
                    map2.put(PointCategory.END, Long.toString(i.b));
                    map2.put("reason", i.d);
                    if (i.c != null) {
                        StringBuilder sb = new StringBuilder();
                        Iterator<String> it = i.c.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next.endsWith(".alog.hot")) {
                                next = next.substring(0, next.length() - 9);
                            }
                            sb.append(next).append(com.alipay.sdk.m.u.i.b);
                        }
                        map2.put(com.sigmob.sdk.base.n.z, sb.toString());
                    }
                    i.d = null;
                    i.c = null;
                    map = map2;
                }
            }
            return new q1(z, str, map);
        }

        @Override // com.pangrowth.adclog.i1
        public List<String> a(long j, long j2, JSONObject jSONObject) throws InterruptedException {
            if (j < j2) {
                Handler handler = f.g;
                if (handler != null) {
                    handler.sendEmptyMessage(2);
                }
                Alog alog = i.e;
                if (alog != null) {
                    alog.a();
                }
                Alog alog2 = f.d;
                if (alog2 != null) {
                    alog2.a();
                }
                Iterator<WeakReference<Alog>> it = f.e.iterator();
                while (it.hasNext()) {
                    Alog alog3 = it.next().get();
                    if (alog3 != null) {
                        alog3.a();
                    }
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ArrayList arrayList = new ArrayList();
                try {
                    File[] fileArrA = i.a((String) null, (String) null, j * 1000, j2 * 1000);
                    for (File file : fileArrA) {
                        arrayList.add(file.getAbsolutePath());
                    }
                } catch (Exception unused) {
                }
                this.a = arrayList;
            }
            return this.a;
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sAdCLogInitialized.get() && f.a(6, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(6, str, str2, th, null, null);
                return;
            }
            String str3 = str2 + "\n" + i.a(th);
            Alog alog = f.d;
            if (alog != null && zA) {
                alog.a(4, str, str3);
            } else {
                i.a(4, str, str3);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sAdCLogInitialized.get() && f.a(5, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(5, str, str2, th, null, null);
                return;
            }
            String str3 = str2 + "\n" + i.a(th);
            Alog alog = f.d;
            if (alog != null && zA) {
                alog.a(3, str, str3);
            } else {
                i.a(3, str, str3);
            }
        }
    }

    public static void e(String str, Throwable th) {
        if (sAdCLogInitialized.get() && f.a(6, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(6, str, null, th, null, null);
                return;
            }
            String strA = i.a(th);
            Alog alog = f.d;
            if (alog != null && zA) {
                alog.a(4, str, strA);
            } else {
                i.a(4, str, strA);
            }
        }
    }

    public static void w(String str, Throwable th) {
        if (sAdCLogInitialized.get() && f.a(5, str)) {
            boolean zA = i.a();
            if (zA && f.g != null) {
                f.a(5, str, null, th, null, null);
                return;
            }
            String strA = i.a(th);
            Alog alog = f.d;
            if (alog != null && zA) {
                alog.a(3, str, strA);
            } else {
                i.a(3, str, strA);
            }
        }
    }
}
