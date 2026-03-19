package com.bytedance.bdtracker;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class l2 {
    @JvmStatic
    public static final void a(i2 i2Var, long j, String str, int i) {
        if (str == null) {
            str = "";
        }
        u2 u2Var = new u2(j, str, 1L);
        u2Var.a = i;
        if (i2Var != null) {
            ((n2) i2Var).a(u2Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.bytedance.bdtracker.i2 r4, java.lang.String r5, java.lang.String r6, long r7) {
        /*
            java.lang.String r0 = "metricsName"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            long r0 = android.os.SystemClock.elapsedRealtime()
            int r2 = r5.hashCode()
            r3 = -73212100(0xfffffffffba2df3c, float:-1.6913596E36)
            if (r2 == r3) goto L27
            r6 = 270071285(0x1018f5f5, float:3.0166193E-29)
            if (r2 == r6) goto L18
            goto L36
        L18:
            java.lang.String r6 = "sdk_init"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L36
            com.bytedance.bdtracker.a3 r5 = new com.bytedance.bdtracker.a3
            long r0 = r0 - r7
            r5.<init>(r0)
            goto L37
        L27:
            java.lang.String r2 = "api_usage"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L36
            com.bytedance.bdtracker.o2 r5 = new com.bytedance.bdtracker.o2
            long r0 = r0 - r7
            r5.<init>(r6, r0)
            goto L37
        L36:
            r5 = 0
        L37:
            if (r5 == 0) goto L40
            if (r4 == 0) goto L40
            com.bytedance.bdtracker.n2 r4 = (com.bytedance.bdtracker.n2) r4
            r4.a(r5)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.l2.a(com.bytedance.bdtracker.i2, java.lang.String, java.lang.String, long):void");
    }

    @JvmStatic
    public static final void a(i2 i2Var, Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        if (i2Var != null) {
            ((n2) i2Var).a(new t2(th));
        }
    }

    @JvmStatic
    public static final void b(i2 i2Var, Throwable th) {
        String string;
        Intrinsics.checkParameterIsNotNull(th, "e");
        try {
            string = th.getStackTrace()[0].toString();
        } catch (Exception unused) {
            string = "";
        }
        if ((StringsKt.startsWith$default(string, "com.bytedance.applog", false, 2, (Object) null) || StringsKt.startsWith$default(string, "com.bytedance.bdtracker", false, 2, (Object) null)) && i2Var != null) {
            ((n2) i2Var).a(new z2(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.bytedance.bdtracker.i2 r4, java.net.URL r5, long r6, int r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "responseMsg"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            if (r4 == 0) goto L75
            r0 = 0
            if (r5 != 0) goto L10
            goto L1a
        L10:
            java.lang.String r1 = r5.getPath()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L1c
        L1a:
            r1 = r0
            goto L26
        L1c:
            java.lang.String r1 = r5.getPath()
            java.lang.String r2 = "/simulator/"
            boolean r1 = r1.startsWith(r2)
        L26:
            if (r1 != 0) goto L75
            long r1 = android.os.SystemClock.elapsedRealtime()
            com.bytedance.bdtracker.y2 r3 = new com.bytedance.bdtracker.y2
            r3.<init>()
            long r1 = r1 - r6
            r3.e = r1
            r6 = 1
            if (r5 != 0) goto L38
            goto L42
        L38:
            java.lang.String r7 = r5.getPath()
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L45
        L42:
            java.lang.String r7 = ""
            goto L5e
        L45:
            java.lang.String r1 = "/"
            boolean r2 = r7.contains(r1)
            if (r2 == 0) goto L5e
            java.lang.String r5 = r5.getPath()
            java.lang.String[] r5 = r5.split(r1)
            if (r5 == 0) goto L5e
            int r1 = r5.length
            if (r1 <= 0) goto L5e
            int r7 = r5.length
            int r7 = r7 - r6
            r7 = r5[r7]
        L5e:
            r3.d = r7
            r5 = 200(0xc8, float:2.8E-43)
            if (r8 != r5) goto L66
            r0 = r6
            goto L6e
        L66:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r3.b = r5
            r3.c = r9
        L6e:
            r3.a = r0
            com.bytedance.bdtracker.n2 r4 = (com.bytedance.bdtracker.n2) r4
            r4.a(r3)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.l2.a(com.bytedance.bdtracker.i2, java.net.URL, long, int, java.lang.String):void");
    }
}
