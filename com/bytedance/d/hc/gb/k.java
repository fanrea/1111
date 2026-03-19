package com.bytedance.d.hc.gb;

import android.os.Build;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class k {
    public static String d(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            d(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder d(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String d(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (b(th)) {
                d(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Exception unused) {
            printWriter.close();
            return "";
        } catch (Throwable th2) {
            printWriter.close();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject d(java.lang.String r16) {
        /*
            r0 = r16
            java.lang.String r1 = ")"
            java.lang.String r2 = "("
            r3 = 0
            java.util.Map r4 = java.lang.Thread.getAllStackTraces()     // Catch: java.lang.Throwable -> Le9
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Le9
            r5.<init>()     // Catch: java.lang.Throwable -> Le9
            if (r4 != 0) goto L13
            return r3
        L13:
            java.lang.String r6 = "thread_all_count"
            int r7 = r4.size()     // Catch: java.lang.Throwable -> Le9
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Le9
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le9
            r6.<init>()     // Catch: java.lang.Throwable -> Le9
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> Le9
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> Le9
        L29:
            boolean r7 = r4.hasNext()     // Catch: java.lang.Throwable -> Le9
            if (r7 == 0) goto Le3
            java.lang.Object r7 = r4.next()     // Catch: java.lang.Throwable -> Le9
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch: java.lang.Throwable -> Le9
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Le9
            r8.<init>()     // Catch: java.lang.Throwable -> Le9
            java.lang.Object r9 = r7.getKey()     // Catch: java.lang.Throwable -> Le9
            java.lang.Thread r9 = (java.lang.Thread) r9     // Catch: java.lang.Throwable -> Le9
            java.lang.String r10 = r9.getName()     // Catch: java.lang.Throwable -> Le9
            boolean r11 = hc(r10)     // Catch: java.lang.Throwable -> Le9
            if (r11 != 0) goto L29
            if (r0 == 0) goto L5e
            boolean r11 = r0.equals(r10)     // Catch: java.lang.Throwable -> Le9
            if (r11 != 0) goto L29
            boolean r11 = r10.startsWith(r0)     // Catch: java.lang.Throwable -> Le9
            if (r11 != 0) goto L29
            boolean r10 = r10.endsWith(r0)     // Catch: java.lang.Throwable -> Le9
            if (r10 != 0) goto L29
        L5e:
            java.lang.String r10 = "thread_name"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le9
            r11.<init>()     // Catch: java.lang.Throwable -> Le9
            java.lang.String r12 = r9.getName()     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch: java.lang.Throwable -> Le9
            long r12 = r9.getId()     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = r11.append(r12)     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Le9
            r8.put(r10, r9)     // Catch: java.lang.Throwable -> Le9
            java.lang.Object r7 = r7.getValue()     // Catch: java.lang.Throwable -> Le9
            java.lang.StackTraceElement[] r7 = (java.lang.StackTraceElement[]) r7     // Catch: java.lang.Throwable -> Le9
            if (r7 == 0) goto Ldb
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le9
            r10.<init>()     // Catch: java.lang.Throwable -> Le9
            int r11 = r7.length     // Catch: java.lang.Throwable -> Le9
            r12 = 0
            r13 = r12
        L94:
            if (r13 >= r11) goto Lcd
            r14 = r7[r13]     // Catch: java.lang.Throwable -> Le9
            java.lang.String r15 = r14.getClassName()     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le9
            r9.<init>()     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = r9.append(r15)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r15 = "."
            java.lang.StringBuilder r9 = r9.append(r15)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r15 = r14.getMethodName()     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = r9.append(r15)     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = r9.append(r2)     // Catch: java.lang.Throwable -> Le9
            int r14 = r14.getLineNumber()     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = r9.append(r14)     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Le9
            r10.put(r9)     // Catch: java.lang.Throwable -> Le9
            int r13 = r13 + 1
            goto L94
        Lcd:
            java.lang.String r7 = "thread_stack"
            r8.put(r7, r10)     // Catch: java.lang.Throwable -> Le9
            int r7 = r10.length()     // Catch: java.lang.Throwable -> Le9
            if (r7 <= 0) goto Ld9
            goto Ldb
        Ld9:
            r9 = r12
            goto Ldc
        Ldb:
            r9 = 1
        Ldc:
            if (r9 == 0) goto L29
            r6.put(r8)     // Catch: java.lang.Throwable -> Le9
            goto L29
        Le3:
            java.lang.String r0 = "thread_stacks"
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> Le9
            return r5
        Le9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.d.hc.gb.k.d(java.lang.String):org.json.JSONObject");
    }

    private static boolean hc(String str) {
        Set<String> setD = u.d();
        if (setD.contains(str)) {
            return true;
        }
        for (String str2 : setD) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hc(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            i++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static class d {
        private final PrintWriter d;

        d(PrintWriter printWriter) {
            this.d = printWriter;
        }

        Object d() {
            return this.d;
        }

        void d(Object obj) {
            this.d.println(obj);
        }
    }

    private static void d(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        d dVar = new d(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (dVar.d()) {
            dVar.d(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (i2 > 256) {
                    dVar.d("\t... skip " + (stackTrace.length - i2) + " lines");
                    break;
                } else {
                    dVar.d("\tat " + stackTraceElement);
                    i2++;
                    i++;
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    d(th2, dVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                d(cause, dVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void d(Throwable th, d dVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            dVar.d("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int iMin = Math.min(stackTrace.length, 256);
        int i = iMin - 1;
        int i2 = i;
        for (int iMin2 = Math.min(stackTraceElementArr.length, 256) - 1; i2 >= 0 && iMin2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[iMin2]); iMin2--) {
            i2--;
        }
        int i3 = i - i2;
        dVar.d(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            dVar.d(str2 + "\tat " + stackTrace[i4]);
        }
        if (iMin < stackTrace.length) {
            dVar.d("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i3 != 0) {
            dVar.d(str2 + "\t... " + i3 + " more");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                d(th2, dVar, stackTrace, "Suppressed: ", str2 + "\t", set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            d(cause, dVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean b(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }
}
