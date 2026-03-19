package com.baidu.enan.e.a.g;

import android.text.TextUtils;
import com.baidu.enan.e.d.c;
import com.baidu.enan.f.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static int a() {
        try {
            return b();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return 0;
        }
    }

    private static int b() {
        try {
            i = c() != 0 ? 1 : 0;
            if (d() != 0) {
                i |= 2;
            }
            if (e() != 0) {
                i |= 4;
            }
            return f() != 0 ? i | 8 : i;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return i;
        }
    }

    private static int c() {
        try {
            String strA = b.a("L3N5c3RlbS9iaW4vbWluaWNhcC5zbw==");
            String strA2 = b.a("L3N5c3RlbS9saWIvbWluaWNhcC5zbw==");
            if (new File(strA).exists() && "1".equals(c("stat -c %h " + strA).trim())) {
                return 1;
            }
            if (new File(strA2).exists()) {
                return "1".equals(c(new StringBuilder().append("stat -c %h ").append(strA2).toString()).trim()) ? 1 : 0;
            }
            return 0;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return 0;
        }
    }

    private static int d() {
        try {
            String strA = b.a("L3Byb2MvbmV0L3RjcA==");
            String strA2 = b.a("L3Byb2MvbmV0L3RjcDY=");
            if (a(strA) == 0) {
                return a(strA2) != 0 ? 1 : 0;
            }
            return 1;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return 0;
        }
    }

    private static int e() {
        try {
            return b("cndrcG9ydA==") ? 1 : 0;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return 0;
        }
    }

    private static int f() {
        try {
            String strA = b.a("L3N5c3RlbS9iaW4vdG9weHo=");
            if (new File(strA).exists()) {
                return "1".equals(c(new StringBuilder().append("stat -c %h ").append(strA).toString())) ? 1 : 0;
            }
            return 0;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        com.baidu.enan.f.a.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.String r1 = "L3Byb2MvbmV0L3VuaXg="
            java.lang.String r1 = com.baidu.enan.f.b.a(r1)     // Catch: java.lang.Throwable -> L40
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L40
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L40
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto L3f
            boolean r2 = r2.canRead()     // Catch: java.lang.Throwable -> L40
            if (r2 != 0) goto L19
            goto L3f
        L19:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L40
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L40
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L40
        L23:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L39
            boolean r1 = r1.contains(r4)     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L23
            r2.close()     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r4 = move-exception
            com.baidu.enan.f.a.a(r4)
        L37:
            r4 = 1
            return r4
        L39:
            r2.close()     // Catch: java.lang.Throwable -> L4b
            goto L4f
        L3d:
            r4 = move-exception
            goto L42
        L3f:
            return r0
        L40:
            r4 = move-exception
            r2 = 0
        L42:
            com.baidu.enan.f.a.a(r4)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L4f
            r2.close()     // Catch: java.lang.Throwable -> L4b
            goto L4f
        L4b:
            r4 = move-exception
            com.baidu.enan.f.a.a(r4)
        L4f:
            return r0
        L50:
            r4 = move-exception
            if (r2 == 0) goto L5b
            r2.close()     // Catch: java.lang.Throwable -> L57
            goto L5b
        L57:
            r0 = move-exception
            com.baidu.enan.f.a.a(r0)
        L5b:
            goto L5d
        L5c:
            throw r4
        L5d:
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.enan.e.a.g.a.b(java.lang.String):boolean");
    }

    private static String c(String str) {
        try {
            c.a aVarA = c.a(str, false);
            if (!TextUtils.isEmpty(aVarA.b)) {
                return aVarA.b;
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
        return "";
    }

    private static int a(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            try {
                bufferedReader.readLine();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return 0;
                    }
                    String strTrim = line.trim();
                    if (!strTrim.isEmpty()) {
                        String[] strArrSplit = strTrim.split("\\s+");
                        if (strArrSplit.length >= 10) {
                            String[] strArrSplit2 = strArrSplit[1].split(":");
                            if (strArrSplit2.length == 2) {
                                int i = Integer.parseInt(strArrSplit2[1], 16);
                                int i2 = Integer.parseInt(strArrSplit[7]);
                                if (i != 0 && i2 == 2000) {
                                    bufferedReader.close();
                                    return 1;
                                }
                            }
                        }
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return 0;
        }
    }
}
