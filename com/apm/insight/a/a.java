package com.apm.insight.a;

import android.os.Looper;
import android.text.TextUtils;
import com.apm.applog.AppLog;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.MonitorCrash;
import com.apm.insight.Npth;
import com.apm.insight.entity.e;
import com.apm.insight.f;
import com.apm.insight.g;
import com.apm.insight.log.ILog;
import com.apm.insight.log.VLog;
import com.apm.insight.o.j;
import com.apm.insight.o.l;
import com.apm.insight.o.m;
import com.apm.insight.o.p;
import com.apm.insight.o.q;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements ICrashCallback {
    private static volatile a c;
    private volatile b a = new b() { // from class: com.apm.insight.a.a.1
        @Override // com.apm.insight.a.b
        public void a(String str) {
            try {
                try {
                    ILog vLog = VLog.getInstance(str);
                    if (vLog != null) {
                        vLog.asyncFlush();
                    } else if (TextUtils.equals(f.f(), str)) {
                        VLog.flush();
                    }
                } catch (Throwable unused) {
                    if (TextUtils.equals(f.f(), str)) {
                        VLog.flush();
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    };
    private volatile c b = new c() { // from class: com.apm.insight.a.a.2
        @Override // com.apm.insight.a.c
        public List<String> a(String str, String str2, long j) {
            ILog vLog;
            List<String> files;
            List<String> logFiles;
            int iE = com.apm.insight.runtime.a.e(str);
            List<String> logFiles2 = null;
            try {
                try {
                    if (com.apm.insight.runtime.a.d(str)) {
                        ILog vLog2 = VLog.getInstance(str);
                        if (vLog2 != null) {
                            logFiles = vLog2.getFiles((j / 1000) - iE, j / 1000);
                        } else if (TextUtils.equals(f.f(), str)) {
                            logFiles = VLog.getLogFiles(g.f().getPackageName().equals(str2), (j / 1000) - iE, j / 1000, 2);
                        }
                        logFiles2 = logFiles;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                if (TextUtils.equals(f.f(), str)) {
                    logFiles2 = VLog.getLogFiles(g.f().getPackageName().equals(str2), (j / 1000) - 3600, j / 1000, 2);
                }
            }
            try {
                if (!com.apm.insight.runtime.a.f(str) || (vLog = VLog.getInstance("APMPlus")) == null || (files = vLog.getFiles((j / 1000) - iE, j / 1000)) == null) {
                    return logFiles2;
                }
                if (logFiles2 == null) {
                    return files;
                }
                logFiles2.addAll(files);
                return logFiles2;
            } catch (Throwable unused3) {
                return logFiles2;
            }
        }
    };
    private volatile boolean d = false;

    private a() {
        Npth.registerCrashCallback(this, CrashType.ALL);
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public static e a(String str, List<String> list, String str2) {
        String strD;
        e eVar = new e();
        if (TextUtils.isEmpty(str)) {
            Map<String, Object> mapA = g.a().a();
            if (mapA != null) {
                eVar.d(String.valueOf(mapA.get("aid")));
                strD = g.c().a();
            }
            eVar.e(str2);
            eVar.a(list);
            return eVar;
        }
        eVar.d(str);
        strD = d(str);
        eVar.c(strD);
        eVar.e(str2);
        eVar.a(list);
        return eVar;
    }

    private void a(String str, CrashType crashType, long j, String str2, String str3) {
        FileOutputStream fileOutputStream;
        try {
            if (this.a != null) {
                try {
                    this.a.a(str);
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                }
            }
            File file = new File(p.i(g.f()), crashType.getName() + Config.replace + str + Config.replace + str2 + ".atmp");
            if (file.exists()) {
                return;
            }
            file.getParentFile().mkdirs();
            Properties properties = new Properties();
            properties.setProperty("aid", str);
            properties.setProperty(ContentProviderManager.PLUGIN_PROCESS_NAME, str3);
            properties.setProperty("crash_time", String.valueOf(j));
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable unused) {
            }
            try {
                properties.store(fileOutputStream, "");
                fileOutputStream.close();
                l.a(fileOutputStream);
            } catch (Throwable unused2) {
                fileOutputStream2 = fileOutputStream;
                l.a(fileOutputStream2);
            }
        } catch (Throwable th2) {
            com.apm.insight.b.a().a("NPTH_CATCH", th2);
        }
    }

    public static boolean a(e eVar) {
        return (TextUtils.isEmpty(eVar.e()) || TextUtils.isEmpty(eVar.d()) || TextUtils.isEmpty(eVar.f()) || eVar.g() == null || eVar.g().size() == 0) ? false : true;
    }

    private boolean a(String str, final CrashType crashType, long j, String str2, String str3, String str4, c cVar) {
        if (TextUtils.isEmpty(str) || !(com.apm.insight.runtime.a.d(str) || com.apm.insight.runtime.a.f(str))) {
            return true;
        }
        c(str);
        if (cVar == null) {
            return false;
        }
        List<String> listA = cVar.a(str, str2, j);
        if (listA != null && listA.size() > 0 && str2 != null) {
            try {
                final e eVarA = a(str, listA, str2);
                if (!a(eVarA)) {
                    return true;
                }
                final String strA = j.a(p.i(g.f()), p.c(), eVarA.d(), eVarA.e(), eVarA.f(), eVarA.g());
                if (!TextUtils.isEmpty(str4)) {
                    j.a(str4);
                }
                Runnable runnable = new Runnable() { // from class: com.apm.insight.a.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zA = com.apm.insight.n.e.a().a(eVarA.e(), eVarA.d(), eVarA.f(), eVarA.g());
                        q.a((Object) ("upload ALog " + eVarA.g()));
                        if (zA) {
                            j.a(strA);
                        }
                    }
                };
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    try {
                        com.apm.insight.runtime.q.b().a(runnable);
                    } catch (Throwable unused) {
                    }
                } else {
                    runnable.run();
                }
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
        return true;
    }

    private ILog c() {
        if (g.h().isApmPLusLogEnable()) {
            return VLog.getInstance("APMPlus");
        }
        return null;
    }

    private void c(String str) {
        if (this.a != null) {
            try {
                this.a.a(str);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    private static String d(String str) {
        AppLog appLog;
        String deviceId = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.equals(f.f(), str)) {
                Object objA = f.a();
                if (objA instanceof MonitorCrash) {
                    deviceId = ((MonitorCrash) objA).config().getDeviceId();
                }
            } else {
                MonitorCrash monitorCrashA = f.a(str);
                if (monitorCrashA != null) {
                    deviceId = monitorCrashA.config().getDeviceId();
                }
            }
            return (!TextUtils.isEmpty(deviceId) || (appLog = AppLog.getInstance(str)) == null) ? deviceId : appLog.getDid();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(int i, String str, int i2) {
        try {
            ILog iLogC = c();
            if (iLogC == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "process_exit");
            jSONObject.put("service", "process_exit");
            jSONObject.put("reason", i);
            jSONObject.put("description", str);
            jSONObject.put("status", i2);
            iLogC.e("APMPlus", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public void a(CrashType crashType, long j, String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strB = m.b(jSONArray.optJSONObject(i), "header", "aid");
                if (com.apm.insight.runtime.a.d(strB) || com.apm.insight.runtime.a.f(strB)) {
                    a(strB, crashType, j, str, com.apm.insight.o.a.c(g.f()));
                }
            }
        }
    }

    public void a(CrashType crashType, String str, String str2) {
        try {
            ILog iLogC = c();
            if (iLogC == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "crash");
            jSONObject.put("service", "crash");
            jSONObject.put("crash_type", crashType);
            if (str.length() > 3000) {
                str = str.substring(0, 3000);
            }
            jSONObject.put("stack", str);
            jSONObject.put("crash_thread_name", str2);
            iLogC.e("APMPlus", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public void a(String str) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        CrashType crashType = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                properties.load(fileInputStream);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        l.a(fileInputStream);
        try {
            long jLongValue = Long.decode(properties.getProperty("crash_time")).longValue();
            String name = new File(str).getName();
            if (name.startsWith(CrashType.LAUNCH.getName())) {
                crashType = CrashType.LAUNCH;
            } else if (name.startsWith(CrashType.JAVA.getName())) {
                crashType = CrashType.JAVA;
            } else if (name.startsWith(CrashType.ANR.getName())) {
                crashType = CrashType.ANR;
            } else if (name.startsWith(CrashType.DART.getName())) {
                crashType = CrashType.DART;
            } else if (name.startsWith(CrashType.NATIVE.getName())) {
                crashType = CrashType.NATIVE;
            }
            CrashType crashType2 = crashType;
            String property = properties.getProperty(ContentProviderManager.PLUGIN_PROCESS_NAME);
            String strSubstring = name.substring(name.lastIndexOf(95) + 1, name.length() - 5);
            String property2 = properties.getProperty("aid");
            if (TextUtils.isEmpty(property2)) {
                property2 = f.f();
            }
            if (a(property2, crashType2, jLongValue, property, strSubstring, str, this.b)) {
                j.a(str);
            }
        } catch (Throwable unused3) {
            j.a(str);
        }
    }

    public void a(Throwable th, Thread thread) {
        try {
            ILog iLogC = c();
            if (iLogC == null) {
                return;
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "crash");
            jSONObject.put("service", "crash");
            jSONObject.put("crash_type", CrashType.JAVA);
            String string = stringWriter.toString();
            if (string.length() > 3000) {
                string = string.substring(0, 3000);
            }
            jSONObject.put("stack", string);
            jSONObject.put("crash_thread_name", thread.getName());
            iLogC.e("APMPlus", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            ILog iLogC = c();
            if (iLogC == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("log_type", "ensure");
            jSONObject2.put("service", "ensure");
            jSONObject2.put("body", jSONObject);
            iLogC.w("APMPlus", jSONObject2.toString());
        } catch (Throwable unused) {
        }
    }

    public void b() {
        if (this.a != null) {
            try {
                Map<String, MonitorCrash> mapB = f.b();
                if (mapB != null) {
                    Iterator<String> it = mapB.keySet().iterator();
                    while (it.hasNext()) {
                        this.a.a(it.next());
                    }
                }
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    public void b(String str) {
        try {
            ILog iLogC = c();
            if (iLogC == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "dart");
            jSONObject.put("service", "dart");
            jSONObject.put("body", str);
            iLogC.e("APMPlus", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    @Override // com.apm.insight.ICrashCallback
    public void onCrash(CrashType crashType, String str, Thread thread) {
        crashType.equals(CrashType.NATIVE);
    }
}
