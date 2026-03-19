package com.android.gdt.qone.af;

import android.util.Log;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static boolean a = false;
    public static boolean b = true;
    public static com.android.gdt.qone.a.a c;

    public static synchronized void a(com.android.gdt.qone.a.a aVar) {
        c = aVar;
    }

    public static synchronized void b(boolean z) {
        b = z;
    }

    public static synchronized void a(boolean z) {
        Log.i("Q_LOG", "logAble: " + z);
        a = z;
    }

    public static boolean a() {
        boolean z;
        synchronized (a.class) {
            z = a;
        }
        return z;
    }

    public static int a(StackTraceElement[] stackTraceElementArr, Class cls) {
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!(cls.equals(Log.class) && i < stackTraceElementArr.length - 1 && stackTraceElementArr[i + 1].getClassName().equals(Log.class.getName())) && className.equals(cls.getName())) {
                return i + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r5, java.lang.Object... r6) {
        /*
            java.lang.Class<com.android.gdt.qone.af.a> r0 = com.android.gdt.qone.af.a.class
            monitor-enter(r0)
            boolean r1 = com.android.gdt.qone.af.a.b     // Catch: java.lang.Throwable -> Lbf
            monitor-exit(r0)
            if (r1 == 0) goto L77
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.Class<com.android.gdt.qone.af.a> r1 = com.android.gdt.qone.af.a.class
            int r1 = a(r0, r1)
            r2 = -1
            if (r1 != r2) goto L23
            java.lang.Class<android.util.Log> r1 = android.util.Log.class
            int r1 = a(r0, r1)
            if (r1 != r2) goto L23
            r0 = 0
            goto L25
        L23:
            r0 = r0[r1]
        L25:
            if (r0 == 0) goto L77
            java.lang.String r1 = r0.getFileName()
            if (r1 != 0) goto L2f
            java.lang.String r1 = ""
        L2f:
            java.lang.String r2 = r0.getMethodName()
            java.lang.String r3 = "$"
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L4f
            java.lang.String r3 = "$"
            int r3 = r2.indexOf(r3)
            int r3 = r3 + 1
            java.lang.String r4 = "$"
            int r4 = r2.lastIndexOf(r4)
            int r4 = r4 + (-2)
            java.lang.String r2 = r2.substring(r3, r4)
        L4f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            int r0 = r0.getLineNumber()
            r3.append(r0)
            java.lang.String r0 = ")"
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = " "
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            goto L79
        L77:
            java.lang.String r0 = ""
        L79:
            if (r5 != 0) goto L8d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r6 = "msg is null"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            goto Lb5
        L8d:
            int r1 = r6.length
            if (r1 != 0) goto La0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto Lb5
        La0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = java.lang.String.format(r0, r5, r6)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
        Lb5:
            com.android.gdt.qone.a.a r6 = com.android.gdt.qone.af.a.c
            if (r6 == 0) goto Lbe
            com.android.gdt.qone.log.IObservableLog r6 = r6.a
            r6.onLog(r5)
        Lbe:
            return r5
        Lbf:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.af.a.a(java.lang.String, java.lang.Object[]):java.lang.String");
    }
}
