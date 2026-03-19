package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class r {
    private static r c;
    private static Application d;
    public boolean a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    public static r a(Context context, boolean z) {
        try {
            if (c == null) {
                d = (Application) context.getApplicationContext();
                c = new r();
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    private r() {
    }

    public static r a() {
        return c;
    }

    public boolean a(s sVar, boolean z) {
        this.a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.e)) {
                s sVar2 = g.get(sVar.e);
                if (sVar2 != null) {
                    if (sVar2.d.equals(sVar.d)) {
                        return true;
                    }
                    a(sVar2.e);
                }
                try {
                    sVar.f = d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (TextUtils.isEmpty(sVar.c) || TextUtils.isEmpty(sVar.e)) {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                                sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.a;
                                String str = sVar.m + "/dex";
                                String str2 = sVar.m + "/lib/" + this.e;
                                dn.c(sVar.m + "/lib");
                                String str3 = str2 + "/" + f.nextInt();
                                e(str);
                                dn.a(str, Boolean.FALSE);
                                e(str3);
                                a(sVar, str3, str, false);
                                h.put(sVar.c, sVar);
                                g.put(sVar.e, sVar);
                                z = false;
                            } catch (Throwable unused) {
                                return false;
                            }
                        } catch (Throwable unused2) {
                            a(sVar.e);
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (sVar.p != 1 || z) {
                        PackageInfo packageArchiveInfo = sVar.r;
                        if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                            packageArchiveInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                        }
                        if (TextUtils.isEmpty(packageArchiveInfo.packageName) || !packageArchiveInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            throw new Exception("weapon package name check failed");
                        }
                        if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                            return false;
                        }
                        sVar.c = packageArchiveInfo.packageName;
                        sVar.o = packageArchiveInfo.applicationInfo.className;
                        sVar.d = packageArchiveInfo.versionName;
                        sVar.l = packageArchiveInfo.activities;
                        sVar.q = packageArchiveInfo.applicationInfo.theme;
                        sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.a;
                        String str4 = sVar.m + "/dex";
                        String str5 = sVar.m + "/lib/" + this.e;
                        dn.c(sVar.m + "/lib");
                        String str6 = str5 + "/" + f.nextInt();
                        e(str4);
                        dn.a(str4, Boolean.FALSE);
                        e(str6);
                        a(sVar, str6, str4, true);
                        h.put(sVar.c, sVar);
                        g.put(sVar.e, sVar);
                        b.add(Integer.valueOf(sVar.a));
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (!dn.a(file)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        String strA = f.a(file);
        if (TextUtils.isEmpty(strA)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        if (!strA.equalsIgnoreCase(str)) {
            return new Pair<>(Boolean.FALSE, strA);
        }
        return new Pair<>(Boolean.TRUE, "");
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(str);
        h.remove(sVar.c);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(sVar.e);
        h.remove(str);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public Map<String, s> b() {
        return h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02fa A[PHI: r9 r14 r15 r18 r19 r21
  0x02fa: PHI (r9v7 int) = (r9v3 int), (r9v4 int), (r9v8 int) binds: [B:156:0x02bc, B:174:0x02f8, B:165:0x02da] A[DONT_GENERATE, DONT_INLINE]
  0x02fa: PHI (r14v16 ??) = (r14v6 ??), (r14v7 ??), (r14v17 ??) binds: [B:156:0x02bc, B:174:0x02f8, B:165:0x02da] A[DONT_GENERATE, DONT_INLINE]
  0x02fa: PHI (r15v5 java.lang.StringBuilder) = (r15v1 java.lang.StringBuilder), (r15v2 java.lang.StringBuilder), (r15v6 java.lang.StringBuilder) binds: [B:156:0x02bc, B:174:0x02f8, B:165:0x02da] A[DONT_GENERATE, DONT_INLINE]
  0x02fa: PHI (r18v10 java.io.InputStream) = (r18v7 java.io.InputStream), (r18v8 java.io.InputStream), (r18v11 java.io.InputStream) binds: [B:156:0x02bc, B:174:0x02f8, B:165:0x02da] A[DONT_GENERATE, DONT_INLINE]
  0x02fa: PHI (r19v9 ??) = (r19v6 ??), (r19v7 ??), (r19v10 ??) binds: [B:156:0x02bc, B:174:0x02f8, B:165:0x02da] A[DONT_GENERATE, DONT_INLINE]
  0x02fa: PHI (r21v10 java.lang.String) = (r21v6 java.lang.String), (r21v7 java.lang.String), (r21v11 java.lang.String) binds: [B:156:0x02bc, B:174:0x02f8, B:165:0x02da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0426 A[Catch: all -> 0x04a5, TryCatch #3 {all -> 0x04a5, blocks: (B:210:0x0405, B:211:0x0418, B:213:0x0426, B:215:0x0430, B:219:0x0480, B:220:0x04a4, B:217:0x043a), top: B:244:0x0405, inners: #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04a5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0387 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x013c A[EDGE_INSN: B:300:0x013c->B:62:0x013c BREAK  A[LOOP:1: B:285:0x012d->B:301:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0198 A[Catch: all -> 0x020f, TryCatch #34 {all -> 0x020f, blocks: (B:87:0x0192, B:89:0x0198, B:92:0x01a0), top: B:266:0x0192 }] */
    /* JADX WARN: Type inference failed for: r0v52, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v59 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r14v64 */
    /* JADX WARN: Type inference failed for: r14v66 */
    /* JADX WARN: Type inference failed for: r14v67 */
    /* JADX WARN: Type inference failed for: r14v68 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v39 */
    /* JADX WARN: Type inference failed for: r19v43 */
    /* JADX WARN: Type inference failed for: r19v45 */
    /* JADX WARN: Type inference failed for: r19v46 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r19v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r25, java.lang.String r26, java.lang.String r27, boolean r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0139 A[EDGE_INSN: B:102:0x0139->B:50:0x0139 BREAK  A[LOOP:2: B:79:0x012e->B:49:0x0134], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0134 A[Catch: all -> 0x0158, LOOP:2: B:79:0x012e->B:49:0x0134, LOOP_END, TryCatch #2 {all -> 0x0158, blocks: (B:47:0x012e, B:49:0x0134, B:50:0x0139, B:52:0x0143, B:53:0x0146), top: B:79:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0143 A[Catch: all -> 0x0158, TryCatch #2 {all -> 0x0158, blocks: (B:47:0x012e, B:49:0x0134, B:50:0x0139, B:52:0x0143, B:53:0x0146), top: B:79:0x012e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r17, java.lang.String r18, java.lang.String r19, java.util.HashSet<java.lang.String> r20, byte[] r21, java.lang.StringBuilder r22, boolean r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, java.util.HashSet, byte[], java.lang.StringBuilder, boolean):void");
    }
}
