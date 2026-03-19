package com.apm.insight.n;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.o.w;
import com.apm.insight.runtime.r;
import com.bytedance.apm.common.utility.NetworkUtils;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class c {
    private static volatile c d;
    private Context c;
    private b f;
    private HashMap<String, b> g;
    List<File> a = new ArrayList();
    List<File> b = new ArrayList();
    private int e = -1;
    private volatile boolean h = false;
    private Runnable i = new Runnable() { // from class: com.apm.insight.n.c.1
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            c.this.g();
        }
    };
    private Runnable j = new Runnable() { // from class: com.apm.insight.n.c.2
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            c.this.e();
        }
    };

    static class a {
        File a;
        long b;
        long c;
        CrashType d;
        String e;

        a(File file, long j, CrashType crashType) {
            this.c = -1L;
            this.a = file;
            this.b = j;
            this.d = crashType;
            this.e = file.getName();
        }

        a(File file, CrashType crashType) {
            this.b = -1L;
            this.c = -1L;
            this.a = file;
            this.d = crashType;
            this.e = file.getName();
        }
    }

    static class b {
        String a;
        a d;
        a e;
        List<a> b = new ArrayList();
        List<a> c = new ArrayList();
        boolean f = false;
        int g = 0;
        boolean h = true;

        b(String str) {
            this.a = str;
        }
    }

    private c(Context context) {
        this.c = context;
    }

    private com.apm.insight.entity.e a(File file, CrashType crashType, String str, long j, long j2) {
        com.apm.insight.entity.e eVar;
        try {
            try {
                if (file.isFile()) {
                    com.apm.insight.o.j.a(file);
                    return null;
                }
                boolean z = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return com.apm.insight.o.j.d(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th) {
                        th = th;
                        eVar = null;
                        com.apm.insight.o.j.a(file);
                        com.apm.insight.b.a().a("NPTH_CATCH", th);
                        return eVar;
                    }
                }
                com.apm.insight.entity.e eVarA = com.apm.insight.o.j.a(file, crashType);
                try {
                    JSONObject jSONObjectB = eVarA.b();
                    if (eVarA.b() == null) {
                        com.apm.insight.o.j.a(file);
                    } else {
                        if (crashType == CrashType.ANR) {
                            return eVarA;
                        }
                        jSONObjectB.put("crash_time", j);
                        jSONObjectB.put("app_start_time", j2);
                        JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("header");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = Header.a(this.c, j).g();
                        } else if (z) {
                            jSONObjectB.remove("header");
                        }
                        String strOptString = jSONObjectOptJSONObject.optString("sdk_version_name", null);
                        if (strOptString == null) {
                            strOptString = "1.5.7.oversea";
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "sdk_version", strOptString);
                        if (com.apm.insight.o.j.a(jSONObjectB.optJSONArray("logcat"))) {
                            jSONObjectB.put("logcat", com.apm.insight.runtime.l.b(str));
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_dump", "true");
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_logcat", String.valueOf(!com.apm.insight.o.m.a(jSONObjectB, "logcat")));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "memory_leak", String.valueOf(com.apm.insight.entity.a.b(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "fd_leak", String.valueOf(com.apm.insight.entity.a.c(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "threads_leak", String.valueOf(com.apm.insight.entity.a.d(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_64_devices", String.valueOf(Header.a()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_64_runtime", String.valueOf(NativeImpl.e()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_x86_devices", String.valueOf(Header.b()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_meminfo_file", String.valueOf(com.apm.insight.entity.a.a(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_root", String.valueOf(com.apm.insight.nativecrash.b.l()));
                        jSONObjectB.put("launch_did", com.apm.insight.j.a.a(this.c));
                        jSONObjectB.put("crash_uuid", file.getName());
                        jSONObjectB.put("jiffy", r.a.a());
                        try {
                            long j3 = Long.parseLong(com.apm.insight.runtime.b.a(j, str));
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "lastAliveTime", Math.abs(j3 - j) < 60000 ? "< 60s" : "> 60s");
                            jSONObjectB.put("lastAliveTime", String.valueOf(j3));
                        } catch (Throwable unused) {
                            jSONObjectB.put("lastAliveTime", "unknown");
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "lastAliveTime", "unknown");
                        }
                        jSONObjectB.put("has_dump", "true");
                        if (jSONObjectB.opt("storage") == null) {
                            com.apm.insight.entity.a.a(jSONObjectB, w.a(com.apm.insight.g.f()));
                        }
                        if (Header.b(jSONObjectOptJSONObject)) {
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "unauthentic_version", "unauthentic_version");
                        }
                        com.apm.insight.entity.d.b(jSONObjectB);
                        eVarA.b().put("upload_scene", "launch_scan");
                        if (z) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObjectB.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, "start_crash");
                            jSONObjectB.put("stack", jSONObjectB.remove("data"));
                            jSONObject.put("data", new JSONArray().put(jSONObjectB));
                            jSONObject.put("header", jSONObjectOptJSONObject);
                            eVarA.a(jSONObject);
                        } else {
                            jSONObjectB.put("isJava", 1);
                        }
                    }
                    return eVarA;
                } catch (Throwable th2) {
                    th = th2;
                    eVar = eVarA;
                    com.apm.insight.o.j.a(file);
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                    return eVar;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            eVar = null;
        }
    }

    public static c a() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c(com.apm.insight.g.f());
                }
            }
        }
        return d;
    }

    private JSONObject a(com.apm.insight.nativecrash.b bVar) {
        JSONObject jSONObjectD = bVar.d();
        if (jSONObjectD != null && jSONObjectD.length() != 0) {
            return jSONObjectD;
        }
        if (!bVar.c()) {
            bVar.k();
            return null;
        }
        if (!bVar.f()) {
            bVar.k();
            return null;
        }
        if (bVar.g()) {
            bVar.k();
            return null;
        }
        bVar.e();
        return bVar.j();
    }

    private void a(b bVar) {
        if (bVar == null || !bVar.h) {
            return;
        }
        com.apm.insight.o.j.a(com.apm.insight.o.p.a(this.c, bVar.a));
        com.apm.insight.o.j.a(com.apm.insight.o.p.b(this.c, bVar.a));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0083 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:18:0x007d, B:20:0x0083, B:21:0x0088, B:24:0x008f, B:28:0x009a, B:30:0x00a9, B:32:0x00b7, B:35:0x00ca, B:39:0x00de, B:41:0x00e2, B:46:0x00f7, B:58:0x0141, B:62:0x0168, B:64:0x016f, B:53:0x0123, B:48:0x00fb, B:55:0x012d, B:57:0x013b, B:50:0x0103), top: B:77:0x007d, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(final com.apm.insight.n.c.b r25, boolean r26, com.apm.insight.runtime.i r27) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.n.c.a(com.apm.insight.n.c$b, boolean, com.apm.insight.runtime.i):void");
    }

    private void a(File file, b bVar) {
    }

    private void a(HashMap<String, b> map) {
        File[] fileArrListFiles = com.apm.insight.o.p.f(this.c).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (file.isDirectory() && file.getName().endsWith("G")) {
                    String name = file.getName();
                    b bVar = map.get(name);
                    if (bVar == null) {
                        bVar = new b(name);
                        map.put(name, bVar);
                    }
                    JSONArray jSONArrayA = com.apm.insight.nativecrash.c.a(com.apm.insight.o.p.l(file), com.apm.insight.o.p.m(file));
                    bVar.g = jSONArrayA.length();
                    if (bVar.g > 0) {
                        try {
                            com.apm.insight.o.j.a(com.apm.insight.o.p.n(file), jSONArrayA, false);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    com.apm.insight.o.j.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
                com.apm.insight.o.j.a(file);
            }
        }
    }

    private void a(HashMap<String, b> map, b bVar) {
        File[] fileArrListFiles = com.apm.insight.o.p.d(this.c).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (file.isDirectory() && file.getName().endsWith("G")) {
                    String name = file.getName();
                    b bVar2 = map.get(name);
                    if (bVar2 == null) {
                        bVar2 = new b(name);
                        map.put(name, bVar2);
                    }
                    bVar2.c.add(new a(file, CrashType.NATIVE));
                } else {
                    com.apm.insight.o.j.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
                com.apm.insight.o.j.a(file);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.HashMap<java.lang.String, com.apm.insight.n.c.b> r12, com.apm.insight.n.c.b r13, java.io.File r14, java.lang.String r15) {
        /*
            r11 = this;
            java.lang.String r0 = "G"
            boolean r0 = r15.endsWith(r0)
            if (r0 == 0) goto Ld1
            java.lang.String r0 = "_"
            java.lang.String[] r0 = r15.split(r0)
            int r1 = r0.length
            r2 = 5
            r3 = 0
            if (r1 >= r2) goto L1e
            java.util.List<com.apm.insight.n.c$a> r12 = r13.b
            com.apm.insight.n.c$a r13 = new com.apm.insight.n.c$a
            r13.<init>(r14, r3)
            r12.add(r13)
            return
        L1e:
            r1 = 0
            r2 = r0[r1]     // Catch: java.lang.Throwable -> La5
            long r4 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> La5
            r2 = 4
            r2 = r0[r2]     // Catch: java.lang.Throwable -> La5
            long r6 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> La5
            r13 = 2
            r2 = r0[r13]
            r8 = 1
            r0 = r0[r8]
            r0.hashCode()
            r9 = -1
            int r10 = r0.hashCode()
            switch(r10) {
                case -1109843021: goto L55;
                case 96741: goto L4a;
                case 3254818: goto L3f;
                default: goto L3d;
            }
        L3d:
            r1 = r9
            goto L5e
        L3f:
            java.lang.String r1 = "java"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L3d
        L48:
            r1 = r13
            goto L5e
        L4a:
            java.lang.String r13 = "anr"
            boolean r13 = r0.equals(r13)
            if (r13 != 0) goto L53
            goto L3d
        L53:
            r1 = r8
            goto L5e
        L55:
            java.lang.String r13 = "launch"
            boolean r13 = r0.equals(r13)
            if (r13 != 0) goto L5e
            goto L3d
        L5e:
            switch(r1) {
                case 0: goto L68;
                case 1: goto L65;
                case 2: goto L62;
                default: goto L61;
            }
        L61:
            goto L6a
        L62:
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.JAVA
            goto L6a
        L65:
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.ANR
            goto L6a
        L68:
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.LAUNCH
        L6a:
            java.lang.Object r13 = r12.get(r2)
            com.apm.insight.n.c$b r13 = (com.apm.insight.n.c.b) r13
            if (r13 != 0) goto L7a
            com.apm.insight.n.c$b r13 = new com.apm.insight.n.c$b
            r13.<init>(r2)
            r12.put(r2, r13)
        L7a:
            com.apm.insight.n.c$a r12 = new com.apm.insight.n.c$a
            r12.<init>(r14, r4, r3)
            r12.c = r6
            com.apm.insight.n.c$a r14 = r13.d
            if (r14 == 0) goto L8f
            com.apm.insight.n.c$a r14 = r13.d
            long r0 = r14.b
            long r4 = r12.b
            int r14 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r14 <= 0) goto L9f
        L8f:
            if (r3 == 0) goto L9f
            com.apm.insight.CrashType r14 = com.apm.insight.CrashType.ANR
            if (r3 == r14) goto L9f
            java.lang.String r14 = "ignore"
            boolean r14 = r15.contains(r14)
            if (r14 != 0) goto L9f
            r13.d = r12
        L9f:
            java.util.List<com.apm.insight.n.c$a> r13 = r13.b
            r13.add(r12)
            goto Ld4
        La5:
            java.util.List<com.apm.insight.n.c$a> r12 = r13.b
            com.apm.insight.n.c$a r13 = new com.apm.insight.n.c$a
            r13.<init>(r14, r3)
            r12.add(r13)
            com.apm.insight.c r12 = com.apm.insight.b.a()
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "err format crashTime:"
            java.lang.StringBuilder r14 = r14.append(r0)
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            java.lang.String r14 = "NPTH_CATCH"
            r12.a(r14, r13)
            return
        Ld1:
            com.apm.insight.o.j.a(r14)
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.n.c.a(java.util.HashMap, com.apm.insight.n.c$b, java.io.File, java.lang.String):void");
    }

    private boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:20|(6:121|22|117|23|(6:119|25|26|115|27|(2:135|33)(4:128|31|32|141))(3:39|(5:41|42|125|43|(6:45|(3:123|47|(5:129|49|50|32|141)(1:139))(1:138)|53|(1:55)|56|57)(1:137))(2:136|60)|61)|140)(3:133|68|(0)(1:72))|73|74|(1:76)(1:78)|111|77|(9:80|109|81|(2:83|84)|(3:86|(1:88)(1:89)|90)|91|92|107|93)) */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0173, code lost:
    
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(final com.apm.insight.n.c.b r21, boolean r22, com.apm.insight.runtime.i r23) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.n.c.b(com.apm.insight.n.c$b, boolean, com.apm.insight.runtime.i):void");
    }

    private void b(HashMap<String, b> map, b bVar) {
        File[] fileArrListFiles = com.apm.insight.o.p.a(this.c).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Arrays.sort(fileArrListFiles, Collections.reverseOrder());
        for (File file : fileArrListFiles) {
            try {
                if (com.apm.insight.e.a.a().a(file.getAbsolutePath())) {
                    com.apm.insight.o.j.a(file);
                } else if (!com.apm.insight.o.j.g(file) && !com.apm.insight.h.a.a().b(file.getName())) {
                    if (file.isFile()) {
                        com.apm.insight.o.j.a(file);
                    } else {
                        a(map, bVar, file, file.getName());
                    }
                }
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    private void c(HashMap<String, b> map, b bVar) {
        com.apm.insight.o.j.a(com.apm.insight.o.p.b(this.c));
    }

    private void d() throws Throwable {
        if (this.f != null) {
            return;
        }
        this.f = new b("old_uuid");
        HashMap<String, b> map = new HashMap<>();
        this.g = map;
        a(map);
        b(this.g, this.f);
        c(this.g, this.f);
        a(this.g, this.f);
        b(this.f, true, null);
        a(this.f, true, null);
        this.f = null;
        if (!this.g.isEmpty()) {
            g();
            return;
        }
        if (com.apm.insight.g.u() > 0 && NetworkUtils.isNetworkAvailable(this.c)) {
            com.apm.insight.g.b.a(this.c);
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws Throwable {
        if (this.h || this.g == null) {
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(this.c)) {
            f();
        }
        boolean zH = h();
        com.apm.insight.runtime.i iVar = new com.apm.insight.runtime.i(this.c);
        Iterator<b> it = this.g.values().iterator();
        while (it.hasNext()) {
            b(it.next(), zH, iVar);
        }
        Iterator<b> it2 = this.g.values().iterator();
        while (it2.hasNext()) {
            a(it2.next(), zH, iVar);
        }
        Iterator<b> it3 = this.g.values().iterator();
        while (it3.hasNext()) {
            a(it3.next());
        }
        if (com.apm.insight.g.u() > 0) {
            com.apm.insight.g.b.a(this.c);
        }
        iVar.a();
        com.apm.insight.runtime.b.a();
        f();
    }

    private void f() {
        this.h = true;
        this.g = null;
        NativeImpl.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws Throwable {
        if (this.h) {
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(this.c) || (System.currentTimeMillis() - com.apm.insight.g.i() <= 5000 && com.apm.insight.g.h().isApmExists() && !Npth.hasCrash())) {
            com.apm.insight.runtime.q.b().a(this.i, 5000L);
        } else {
            e();
        }
    }

    private boolean h() {
        if (this.e == -1) {
            if (com.apm.insight.runtime.a.b() && com.apm.insight.runtime.a.g()) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }
        return this.e == 1;
    }

    private void i() {
        File[] fileArrListFiles = com.apm.insight.o.p.i(this.c).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            if (file.getName().endsWith(".atmp")) {
                com.apm.insight.a.a.a().a(file.getAbsolutePath());
            } else {
                try {
                    com.apm.insight.entity.e eVarE = com.apm.insight.o.j.e(file.getAbsolutePath());
                    if (eVarE != null) {
                        if (eVarE.b() != null) {
                            eVarE.b().put("upload_scene", "launch_scan");
                        }
                        if (f.a(f.d(), eVarE.e(), eVarE.d(), eVarE.f(), eVarE.g())) {
                            com.apm.insight.o.j.a(file);
                            com.apm.insight.o.j.a(eVarE.c());
                        }
                    } else {
                        com.apm.insight.o.j.a(file);
                    }
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                }
            }
        }
    }

    public void a(boolean z) throws Throwable {
        if (!Npth.isStopUpload() && z) {
            d();
            i();
            com.apm.insight.c.a.a();
        }
    }

    public void b() {
        try {
            if (!this.h && com.apm.insight.o.a.b(com.apm.insight.g.f())) {
                com.apm.insight.runtime.q.b().a(this.j);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean c() {
        return this.h;
    }
}
