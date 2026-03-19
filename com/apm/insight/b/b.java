package com.apm.insight.b;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.o.m;
import com.apm.insight.o.p;
import com.apm.insight.runtime.s;
import com.baidu.mobstat.forbes.Config;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    static volatile boolean a = true;
    private static volatile boolean f;
    private c c;
    private final Context d;
    private volatile boolean e;
    private JSONObject j;
    private JSONObject k;
    private JSONArray p;
    private JSONObject q;
    private JSONArray t;
    private JSONArray u;
    private JSONObject v;
    private boolean w;
    private volatile boolean y;
    private long g = -1;
    private File h = null;
    private boolean i = true;
    private String l = "unknown";
    private String m = "unknown";
    private String n = "unknown";
    private String o = "npth_inner_default";
    private int r = 0;
    private long s = -1;
    private final Object x = new Object();
    private long z = -1;
    private long A = 0;
    private final Runnable B = new Runnable() { // from class: com.apm.insight.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a(200, 25);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    };
    private int C = 0;
    private List<Pattern> D = null;
    Pattern b = null;
    private File E = null;

    public b(Context context) {
        this.d = context;
    }

    private static String a(float f2) {
        return f2 <= 0.0f ? "0%" : f2 <= 0.1f ? "0% - 10%" : f2 <= 0.3f ? "10% - 30%" : f2 <= 0.6f ? "30% - 60%" : f2 <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    private static String a(float f2, float f3) {
        return f3 > 0.0f ? a(f2 / f3) : f2 > 0.0f ? "100%" : "0%";
    }

    private JSONObject a(String str, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayA = m.a(256, 128, jSONArray);
        if (jSONArrayA.length() != jSONArray.length()) {
            this.r++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", jSONArrayA);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x023d, code lost:
    
        if (r7 != 5) goto L139;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282 A[PHI: r20 r29
  0x0282: PHI (r20v3 char) = (r20v2 char), (r20v16 char) binds: [B:128:0x027c, B:118:0x0246] A[DONT_GENERATE, DONT_INLINE]
  0x0282: PHI (r29v3 char) = (r29v2 char), (r29v9 char) binds: [B:128:0x027c, B:118:0x0246] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0290 A[PHI: r20 r29
  0x0290: PHI (r20v4 char) = (r20v3 char), (r20v17 char) binds: [B:131:0x028a, B:117:0x0241] A[DONT_GENERATE, DONT_INLINE]
  0x0290: PHI (r29v4 char) = (r29v3 char), (r29v10 char) binds: [B:131:0x028a, B:117:0x0241] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x029c A[PHI: r29
  0x029c: PHI (r29v6 char) = (r29v4 char), (r29v11 char) binds: [B:134:0x0296, B:115:0x023d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0309 A[LOOP:2: B:102:0x0222->B:156:0x0309, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0440 A[EDGE_INSN: B:234:0x0440->B:207:0x0440 BREAK  A[LOOP:0: B:3:0x0039->B:205:0x0423], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0423 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03e4 A[EDGE_INSN: B:238:0x03e4->B:194:0x03e4 BREAK  A[LOOP:2: B:102:0x0222->B:156:0x0309], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0311 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r31, org.json.JSONObject r32) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(java.lang.String, org.json.JSONObject):void");
    }

    private static void a(HashMap<String, Float> map, JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String strA;
        String str3 = "npth_anr_" + str;
        if (map.isEmpty()) {
            str2 = str3 + "_total";
            strA = "not found";
        } else {
            float fFloatValue = 0.0f;
            float fFloatValue2 = 0.0f;
            float fFloatValue3 = 0.0f;
            float fFloatValue4 = 0.0f;
            float fFloatValue5 = 0.0f;
            for (Map.Entry<String, Float> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key.endsWith("user")) {
                    fFloatValue += entry.getValue().floatValue();
                } else if (key.endsWith("kernel")) {
                    fFloatValue2 += entry.getValue().floatValue();
                } else if (key.endsWith("iowait")) {
                    fFloatValue3 += entry.getValue().floatValue();
                } else if (key.endsWith("irq")) {
                    fFloatValue4 += entry.getValue().floatValue();
                } else if (key.endsWith("softirq")) {
                    fFloatValue5 += entry.getValue().floatValue();
                }
            }
            float f2 = fFloatValue + fFloatValue2 + fFloatValue3 + fFloatValue4 + fFloatValue5;
            jSONObject.put(str3 + "_total", b(f2));
            jSONObject.put(str3 + "_kernel_user_ratio", a(fFloatValue2, f2));
            str2 = str3 + "_iowait_user_ratio";
            strA = a(fFloatValue3, f2);
        }
        jSONObject.put(str2, strA);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0152 A[Catch: all -> 0x0179, TRY_LEAVE, TryCatch #4 {all -> 0x0179, blocks: (B:83:0x0144, B:85:0x0152), top: B:117:0x0144 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONArray r17) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(org.json.JSONArray):void");
    }

    private boolean a(long j) {
        if (this.y) {
            this.y = false;
            b(j);
        }
        return false;
    }

    private boolean a(String str) {
        if (this.D == null) {
            JSONArray jSONArrayC = com.apm.insight.runtime.a.c();
            if (jSONArrayC != null) {
                this.D = new LinkedList();
                this.o = jSONArrayC.optString(0);
                for (int i = 1; i < jSONArrayC.length(); i++) {
                    try {
                        this.D.add(Pattern.compile(jSONArrayC.optString(i)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.D == null) {
                LinkedList linkedList = new LinkedList();
                this.D = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.D.add(Pattern.compile("^default_npth_thread$"));
                this.D.add(Pattern.compile("^RenderThread$"));
                this.D.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.D.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private static String b(float f2) {
        return a(f2 / 100.0f);
    }

    private void b(long j) {
        if (this.A != this.z) {
            try {
                this.s = System.currentTimeMillis();
                this.u = g.c();
                this.t = k.a(100, j);
                this.k = g.a(j);
                JSONObject jSONObject = new JSONObject();
                this.v = jSONObject;
                com.apm.insight.o.a.a(this.d, jSONObject);
                this.w = g();
                this.i = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.g = this.s;
                    if (com.apm.insight.g.x()) {
                        String strB = p.b();
                        File file = new File(new File(p.f(this.d), strB), "trace_" + com.apm.insight.o.a.c(this.d).replace(':', '_') + ".txt");
                        file.getParentFile().mkdirs();
                        com.apm.insight.o.j.a(file, com.apm.insight.o.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                        s.a("anr_trace", strB);
                        NativeImpl.i(file.getAbsolutePath());
                        try {
                            JSONArray jSONArrayB = com.apm.insight.o.j.b(file.getAbsolutePath());
                            this.p = jSONArrayB;
                            a(jSONArrayB);
                        } catch (IOException unused2) {
                        } catch (Throwable th) {
                            com.apm.insight.b.a().a("NPTH_CATCH", th);
                        }
                    } else {
                        NativeImpl.i(null);
                    }
                }
                if (this.j == null) {
                    this.j = d.a(true);
                }
            } catch (Throwable th2) {
                com.apm.insight.b.a().a("NPTH_CATCH", th2);
            }
            com.apm.insight.o.g.a();
        } else {
            try {
                this.g = this.s;
                if (Build.VERSION.SDK_INT >= 21) {
                    if (com.apm.insight.g.x()) {
                        String strB2 = p.b();
                        File file2 = new File(new File(p.f(this.d), strB2), Config.TRACE_PART + com.apm.insight.o.a.c(this.d).replace(':', '_') + ".txt");
                        file2.getParentFile().mkdirs();
                        com.apm.insight.o.j.a(file2, com.apm.insight.o.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                        s.a("anr_trace", strB2);
                        NativeImpl.i(file2.getAbsolutePath());
                        try {
                            JSONArray jSONArrayB2 = com.apm.insight.o.j.b(file2.getAbsolutePath());
                            this.p = jSONArrayB2;
                            a(jSONArrayB2);
                        } catch (IOException unused3) {
                        } catch (Throwable th3) {
                            com.apm.insight.b.a().a("NPTH_CATCH", th3);
                        }
                    } else {
                        NativeImpl.i(null);
                    }
                }
                if (this.j == null) {
                    this.j = d.a(true);
                }
            } catch (Throwable th4) {
                com.apm.insight.b.a().a("NPTH_CATCH", th4);
            }
        }
        long j2 = this.z;
        this.A = j2;
        this.z = -1L;
        if (j2 == -1) {
            this.A = (-1) - 1;
        }
    }

    private static void b(String str) {
        Iterator<ICrashCallback> it = com.apm.insight.runtime.p.a().e().iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(CrashType.ANR, str, null);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    private int[] b(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            int iIndexOf = (strOptString == null || strOptString.isEmpty()) ? -1 : strOptString.indexOf("utm=");
            if (iIndexOf > 0) {
                if (this.b == null) {
                    this.b = Pattern.compile("[^0-9]+");
                }
                String[] strArrSplit = this.b.split(strOptString.substring(iIndexOf));
                if (strArrSplit == null || strArrSplit.length < 2) {
                    return null;
                }
                int iIntValue = Integer.decode(strArrSplit[1]).intValue();
                int iIntValue2 = Integer.decode(strArrSplit[2]).intValue();
                return new int[]{iIntValue, iIntValue2, iIntValue + iIntValue2};
            }
        }
        return null;
    }

    private String c(long j) {
        long jI = j - com.apm.insight.g.i();
        return jI < 30000 ? "0 - 30s" : jI < 60000 ? "30s - 1min" : jI < 120000 ? "1min - 2min" : jI < 300000 ? "2min - 5min" : jI < 600000 ? "5min - 10min" : jI < 1800000 ? "10min - 30min" : jI < 3600000 ? "30min - 1h" : "1h - ";
    }

    private JSONObject c(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayA = m.a(256, 128, jSONArray);
        if (jSONArrayA.length() != jSONArray.length()) {
            this.r++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArrayA.length(); i++) {
                sb.append(jSONArrayA.getString(i)).append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private boolean g() {
        boolean z = !com.apm.insight.o.a.a(this.d);
        if (!z || com.apm.insight.runtime.a.b.d().e() > 2000) {
            return z;
        }
        return false;
    }

    private File h() {
        if (this.E == null) {
            this.E = new File(this.d.getFilesDir(), "has_anr_signal_" + com.apm.insight.o.a.c(this.d).replaceAll(":", Config.replace));
        }
        return this.E;
    }

    private boolean i() {
        return com.apm.insight.runtime.a.i();
    }

    public void a() {
        if (this.e) {
            return;
        }
        this.c = new c(this);
        this.g = com.apm.insight.g.i();
        this.e = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x03e5 A[Catch: all -> 0x0499, TRY_ENTER, TryCatch #11 {all -> 0x0499, blocks: (B:77:0x017f, B:81:0x0200, B:83:0x0205, B:86:0x020e, B:88:0x0212, B:90:0x0218, B:92:0x0220, B:132:0x03e5, B:133:0x040e, B:135:0x0412, B:142:0x0461, B:91:0x021e), top: B:178:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x040e A[Catch: all -> 0x0499, TryCatch #11 {all -> 0x0499, blocks: (B:77:0x017f, B:81:0x0200, B:83:0x0205, B:86:0x020e, B:88:0x0212, B:90:0x0218, B:92:0x0220, B:132:0x03e5, B:133:0x040e, B:135:0x0412, B:142:0x0461, B:91:0x021e), top: B:178:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean a(int r29, int r30) {
        /*
            Method dump skipped, instructions count: 1191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(int, int):boolean");
    }

    public void b() {
        if (this.e) {
            this.e = false;
            c cVar = this.c;
            if (cVar != null) {
                cVar.b();
            }
            this.c = null;
        }
    }

    public void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        if (f) {
            return;
        }
        synchronized (this.x) {
            if (f) {
                return;
            }
            this.B.run();
        }
    }

    public void e() {
        if (NativeImpl.g()) {
            try {
                com.apm.insight.o.j.a(h(), String.valueOf(this.C + 1), false);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
        this.z = SystemClock.uptimeMillis();
        this.y = true;
    }

    public void f() {
        File fileH = h();
        try {
            int iIntValue = Integer.decode(com.apm.insight.o.j.c(fileH.getAbsolutePath())).intValue();
            this.C = iIntValue;
            if (iIntValue >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            com.apm.insight.o.j.a(fileH);
        }
    }
}
