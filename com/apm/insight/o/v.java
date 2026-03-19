package com.apm.insight.o;

import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.o.f;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class v {
    private static final StackTraceElement a = new StackTraceElement("", "", "", 0);

    public static class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.a);
                jSONObject.put(PointCategory.END, this.b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r8 = r0.exists()
            if (r8 != 0) goto L14
            return r1
        L14:
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 10
            r5 = 0
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5c
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5c
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L5c
            r0 = r5
        L31:
            java.lang.String r1 = r6.readLine()     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L57
            r7 = 256(0x100, float:3.59E-43)
            if (r0 > r7) goto L46
            r8.add(r1)     // Catch: java.lang.Throwable -> L5b
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch: java.lang.Throwable -> L5b
            r1.append(r4)     // Catch: java.lang.Throwable -> L5b
            goto L54
        L46:
            r2.add(r1)     // Catch: java.lang.Throwable -> L5b
            int r1 = r2.size()     // Catch: java.lang.Throwable -> L5b
            if (r1 <= r7) goto L54
            r2.poll()     // Catch: java.lang.Throwable -> L5b
            int r5 = r5 + 1
        L54:
            int r0 = r0 + 1
            goto L31
        L57:
            com.apm.insight.o.l.a(r6)
            goto L5f
        L5b:
            r1 = r6
        L5c:
            com.apm.insight.o.l.a(r1)
        L5f:
            boolean r8 = r2.isEmpty()
            if (r8 != 0) goto L8e
            if (r5 == 0) goto L76
            java.lang.String r8 = "\t... skip "
            java.lang.StringBuilder r8 = r3.append(r8)
            java.lang.StringBuilder r8 = r8.append(r5)
            java.lang.String r0 = " lines\n"
            r8.append(r0)
        L76:
            java.util.Iterator r8 = r2.iterator()
        L7a:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L8e
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r0 = r3.append(r0)
            r0.append(r4)
            goto L7a
        L8e:
            java.lang.String r8 = r3.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.o.v.a(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            a(th, printWriter);
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    public static String a(Throwable th, Thread thread, PrintStream printStream, f.a aVar) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Throwable unused) {
            messageDigest = null;
        }
        f fVar = new f(printStream, messageDigest, aVar);
        try {
            a(th, fVar);
        } catch (Throwable unused2) {
        }
        fVar.close();
        if (messageDigest != null) {
            return a(messageDigest.digest());
        }
        return null;
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static JSONArray a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (aVar.a == -1) {
                if (a(stackTraceElementArr[i].getClassName(), strArr)) {
                    aVar.a = i;
                    aVar.b = i;
                }
            } else if (!a(stackTraceElementArr[i].getClassName(), strArr)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.a != -1) {
            aVar.b = stackTraceElementArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static JSONArray a(String[] strArr, String[] strArr2) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (aVar.a == -1) {
                if (a(strArr[i], strArr2)) {
                    aVar.a = i;
                    aVar.b = i;
                }
            } else if (!a(strArr[i], strArr2)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.a != -1) {
            aVar.b = strArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    private static void a(StackTraceElement stackTraceElement, int i) {
        String str;
        String strValueOf;
        try {
            a("\tat ", i);
            a(stackTraceElement.getClassName(), i);
            a(".", i);
            a(stackTraceElement.getMethodName(), i);
            if (!stackTraceElement.isNativeMethod()) {
                if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        a("(", i);
                        a(stackTraceElement.getFileName(), i);
                        a(":", i);
                        strValueOf = String.valueOf(stackTraceElement.getLineNumber());
                    } else {
                        a("(", i);
                        strValueOf = stackTraceElement.getFileName();
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    a("(Unknown Source:", i);
                    strValueOf = String.valueOf(stackTraceElement.getLineNumber());
                } else {
                    str = "(Unknown Source)";
                }
                a(strValueOf, i);
                a(")", i);
                a("\n", i);
            }
            str = "(Native Method)";
            a(str, i);
            a("\n", i);
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, int i) {
        NativeImpl.a(i, str);
    }

    public static void a(Throwable th, int i) {
        try {
            c(th, i);
        } catch (Throwable unused) {
        }
    }

    private static void a(Throwable th, int i, String str, String str2) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        try {
            NativeImpl.a(i, str2);
            NativeImpl.a(i, str);
        } catch (Throwable unused) {
        }
        b(th, i);
        for (StackTraceElement stackTraceElement : stackTrace) {
            a(stackTraceElement, i);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i, "Suppressed: ", str2 + "\t");
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, i, "Caused by: ", str2);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        printWriter.println(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (z && i2 > 256) {
                printWriter.println("\t... skip " + ((stackTrace.length - i2) + com.alipay.sdk.m.n.a.g) + " lines");
                break;
            } else {
                printWriter.println("\tat " + stackTraceElement);
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length + com.alipay.sdk.m.n.a.g; length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, printWriter, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) setNewSetFromMap, 128);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, printWriter, stackTrace, "Caused by: ", "", (Set<Throwable>) setNewSetFromMap, 128);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            printWriter.println("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        printWriter.println(str2 + str + th);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                printWriter.println("\t... skip " + ((stackTrace.length - i3) - (i / 2)) + " lines");
                break;
            } else {
                printWriter.println("\tat " + stackTraceElement);
                i3++;
                i2++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                int i4 = i / 2;
                a(th2, printWriter, stackTrace, "Suppressed: ", str2 + "\t", set, i4 > 10 ? i4 : 10);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            a(cause, printWriter, stackTrace, "Caused by: ", str2, set, i5 > 10 ? i5 : 10);
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list) {
        if (th == null || list == null) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        list.add(a);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (z && i2 > 256) {
                list.add(a);
                break;
            } else {
                list.add(stackTraceElement);
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length + com.alipay.sdk.m.n.a.g; length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, list, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) setNewSetFromMap, 128);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, list, stackTrace, "Caused by: ", "", (Set<Throwable>) setNewSetFromMap, 128);
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            list.add(a);
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        list.add(a);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                list.add(a);
                break;
            } else {
                list.add(stackTraceElement);
                i3++;
                i2++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                int i4 = i / 2;
                a(th2, list, stackTrace, "Suppressed: ", str2 + "\t", set, i4 > 10 ? i4 : 10);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            a(cause, list, stackTrace, "Caused by: ", str2, set, i5 > 10 ? i5 : 10);
        }
    }

    public static boolean a(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject b(java.lang.String r16) {
        /*
            r0 = r16
            java.lang.String r1 = ")"
            java.lang.String r2 = "("
            r3 = 0
            java.util.Map r4 = java.lang.Thread.getAllStackTraces()     // Catch: java.lang.Throwable -> Lee
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lee
            r5.<init>()     // Catch: java.lang.Throwable -> Lee
            if (r4 != 0) goto L13
            return r3
        L13:
            java.lang.String r6 = "thread_all_count"
            int r7 = r4.size()     // Catch: java.lang.Throwable -> Lee
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Lee
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Lee
            r6.<init>()     // Catch: java.lang.Throwable -> Lee
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> Lee
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> Lee
        L2a:
            boolean r7 = r4.hasNext()     // Catch: java.lang.Throwable -> Lee
            if (r7 == 0) goto Le7
            java.lang.Object r7 = r4.next()     // Catch: java.lang.Throwable -> Lee
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch: java.lang.Throwable -> Lee
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lee
            r8.<init>()     // Catch: java.lang.Throwable -> Lee
            java.lang.Object r9 = r7.getKey()     // Catch: java.lang.Throwable -> Lee
            java.lang.Thread r9 = (java.lang.Thread) r9     // Catch: java.lang.Throwable -> Lee
            java.lang.String r10 = r9.getName()     // Catch: java.lang.Throwable -> Lee
            boolean r11 = c(r10)     // Catch: java.lang.Throwable -> Lee
            if (r11 != 0) goto L2a
            if (r0 == 0) goto L60
            boolean r11 = r0.equals(r10)     // Catch: java.lang.Throwable -> Lee
            if (r11 != 0) goto L2a
            boolean r11 = r10.startsWith(r0)     // Catch: java.lang.Throwable -> Lee
            if (r11 != 0) goto L2a
            boolean r10 = r10.endsWith(r0)     // Catch: java.lang.Throwable -> Lee
            if (r10 == 0) goto L60
            goto L2a
        L60:
            java.lang.String r10 = "thread_name"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lee
            r11.<init>()     // Catch: java.lang.Throwable -> Lee
            java.lang.String r12 = r9.getName()     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch: java.lang.Throwable -> Lee
            long r12 = r9.getId()     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = r11.append(r12)     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch: java.lang.Throwable -> Lee
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lee
            r8.put(r10, r9)     // Catch: java.lang.Throwable -> Lee
            java.lang.Object r7 = r7.getValue()     // Catch: java.lang.Throwable -> Lee
            java.lang.StackTraceElement[] r7 = (java.lang.StackTraceElement[]) r7     // Catch: java.lang.Throwable -> Lee
            if (r7 == 0) goto Ldf
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Lee
            r10.<init>()     // Catch: java.lang.Throwable -> Lee
            int r11 = r7.length     // Catch: java.lang.Throwable -> Lee
            r12 = 0
            r13 = r12
        L97:
            if (r13 >= r11) goto Ld0
            r14 = r7[r13]     // Catch: java.lang.Throwable -> Lee
            java.lang.String r15 = r14.getClassName()     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lee
            r9.<init>()     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = r9.append(r15)     // Catch: java.lang.Throwable -> Lee
            java.lang.String r15 = "."
            java.lang.StringBuilder r9 = r9.append(r15)     // Catch: java.lang.Throwable -> Lee
            java.lang.String r15 = r14.getMethodName()     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = r9.append(r15)     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = r9.append(r2)     // Catch: java.lang.Throwable -> Lee
            int r14 = r14.getLineNumber()     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = r9.append(r14)     // Catch: java.lang.Throwable -> Lee
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch: java.lang.Throwable -> Lee
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lee
            r10.put(r9)     // Catch: java.lang.Throwable -> Lee
            int r13 = r13 + 1
            goto L97
        Ld0:
            java.lang.String r7 = "thread_stack"
            r8.put(r7, r10)     // Catch: java.lang.Throwable -> Lee
            int r7 = r10.length()     // Catch: java.lang.Throwable -> Lee
            if (r7 <= 0) goto Ldd
            goto Ldf
        Ldd:
            r9 = r12
            goto Le0
        Ldf:
            r9 = 1
        Le0:
            if (r9 == 0) goto L2a
            r6.put(r8)     // Catch: java.lang.Throwable -> Lee
            goto L2a
        Le7:
            java.lang.String r0 = "thread_stacks"
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> Lee
            return r5
        Lee:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.o.v.b(java.lang.String):org.json.JSONObject");
    }

    private static void b(Throwable th, int i) {
        th.getClass().getName();
        String localizedMessage = th.getLocalizedMessage();
        try {
            a(th.getClass().getName(), i);
            if (localizedMessage != null) {
                a(": ", i);
                a(localizedMessage, i);
            }
            a("\n", i);
        } catch (Throwable unused) {
        }
    }

    public static StackTraceElement[] b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            a(th, arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    private static void c(Throwable th, int i) {
        if (th == null || i <= 0) {
            return;
        }
        b(th, i);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            a(stackTraceElement, i);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i, "Suppressed: ", "\t");
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, i, "Caused by: ", "");
        }
    }

    private static boolean c(String str) {
        Set<String> setA = k.a();
        if (setA.contains(str)) {
            return true;
        }
        for (String str2 : setA) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (th.getMessage().contains("allocate") || th.getMessage().contains("thrown"))) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }
}
