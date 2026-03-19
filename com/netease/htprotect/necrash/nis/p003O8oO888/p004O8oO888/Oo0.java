package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import android.text.TextUtils;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Oo0 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final Oo0 f92O8oO888 = new Oo0();

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final String f93O8 = ".java.crash";

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final String f94Ooo = "tombstone";

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final String f95o0o0 = ".native.crash";

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static final String f96oO = "CrashCrashStore";
    private String Oo0;

    private Oo0() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static Oo0 m562O8oO888() {
        return f92O8oO888;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static void m563O8(String str) {
        OO8.m557O8oO888();
        if (OO8.m558O8oO888(new File(str))) {
            o8o0.m581Ooo("delete file success");
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public static String m564o0o0(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line).append("\n");
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                        o8o0.m582Ooo(f96oO, "parse log file failed");
                    }
                    return string;
                } catch (FileNotFoundException unused2) {
                    bufferedReader = bufferedReader2;
                    o8o0.m582Ooo(f96oO, "parse log file failed");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                            o8o0.m582Ooo(f96oO, "parse log file failed");
                        }
                    }
                    return "";
                } catch (IOException unused4) {
                    bufferedReader = bufferedReader2;
                    o8o0.m582Ooo(f96oO, "parse log file failed");
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused5) {
                            o8o0.m582Ooo(f96oO, "parse log file failed");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused6) {
            } catch (IOException unused7) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m565O8oO888(String str) {
        this.Oo0 = str;
        OO8.m557O8oO888().m560O8oO888(str);
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final File[] m566O8() {
        if (TextUtils.isEmpty(this.Oo0)) {
            return new File[0];
        }
        File file = new File(this.Oo0);
        if (!file.exists() || !file.isDirectory()) {
            return new File[0];
        }
        File[] fileArrListFiles = file.listFiles(new C0663(this));
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles, new C00oOOo(this));
        return fileArrListFiles;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x005f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final java.io.File m567Ooo(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "write log file failed"
            java.lang.String r1 = "CrashCrashStore"
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            r3 = 0
            java.util.Locale r4 = java.util.Locale.US     // Catch: java.lang.Exception -> L3d
            java.lang.String r5 = "%s/%s_%020d_%s"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L3d
            r7 = 0
            java.lang.String r8 = r12.Oo0     // Catch: java.lang.Exception -> L3d
            r6[r7] = r8     // Catch: java.lang.Exception -> L3d
            r7 = 1
            java.lang.String r8 = "tombstone"
            r6[r7] = r8     // Catch: java.lang.Exception -> L3d
            r7 = 2
            long r8 = r2.getTime()     // Catch: java.lang.Exception -> L3d
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r10
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Exception -> L3d
            r6[r7] = r2     // Catch: java.lang.Exception -> L3d
            r2 = 3
            java.lang.String r7 = ".java.crash"
            r6[r2] = r7     // Catch: java.lang.Exception -> L3d
            java.lang.String r2 = java.lang.String.format(r4, r5, r6)     // Catch: java.lang.Exception -> L3d
            com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.OO〇8 r4 = com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.OO8.m557O8oO888()     // Catch: java.lang.Exception -> L3d
            java.io.File r2 = r4.m561Ooo(r2)     // Catch: java.lang.Exception -> L3d
            goto L43
        L3d:
            java.lang.String r2 = "createLogFile failed"
            com.netease.htprotect.necrash.nis.p003O8oO888.o8o0.m582Ooo(r1, r2)
            r2 = r3
        L43:
            if (r2 == 0) goto L7d
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r5 = "rws"
            r4.<init>(r2, r5)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            boolean r3 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            if (r3 != 0) goto L5b
            java.lang.String r3 = "UTF-8"
            byte[] r13 = r13.getBytes(r3)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            r4.write(r13)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
        L5b:
            r4.close()     // Catch: java.lang.Exception -> L5f
            goto L7d
        L5f:
            com.netease.htprotect.necrash.nis.p003O8oO888.o8o0.m582Ooo(r1, r0)
            goto L7d
        L63:
            r13 = move-exception
            r3 = r4
            goto L73
        L66:
            r3 = r4
            goto L6a
        L68:
            r13 = move-exception
            goto L73
        L6a:
            com.netease.htprotect.necrash.nis.p003O8oO888.o8o0.m582Ooo(r1, r0)     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L7d
            r3.close()     // Catch: java.lang.Exception -> L5f
            goto L7d
        L73:
            if (r3 == 0) goto L7c
            r3.close()     // Catch: java.lang.Exception -> L79
            goto L7c
        L79:
            com.netease.htprotect.necrash.nis.p003O8oO888.o8o0.m582Ooo(r1, r0)
        L7c:
            throw r13
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m567Ooo(java.lang.String):java.io.File");
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final File[] m568Ooo() {
        if (TextUtils.isEmpty(this.Oo0)) {
            return new File[0];
        }
        File file = new File(this.Oo0);
        if (!file.exists() || !file.isDirectory()) {
            return new File[0];
        }
        File[] fileArrListFiles = file.listFiles(new O(this));
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles, new o0O0O(this));
        return fileArrListFiles;
    }
}
