package com.bytedance.pangle.hc.hc;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method hc;

    static {
        try {
            d = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            hc = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            b = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            c = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Field d(java.lang.Class<?> r8, java.lang.String r9) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.hc.hc.d.d
            r1 = 0
            if (r0 == 0) goto L43
            r2 = 0
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L19
            r4[r2] = r9     // Catch: java.lang.Throwable -> L19
            java.lang.Object r0 = r0.invoke(r8, r4)     // Catch: java.lang.Throwable -> L19
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L42
            r0.setAccessible(r3)     // Catch: java.lang.Throwable -> L17
            goto L42
        L17:
            r1 = move-exception
            goto L1d
        L19:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L1d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "DoubleReflector"
            r4.<init>(r5)
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r8.getName()
            r5[r2] = r6
            r5[r3] = r9
            java.lang.String r2 = "getField %s#%s failed !!!"
            java.lang.String r2 = java.lang.String.format(r2, r5)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r3, r2, r1)
        L42:
            r1 = r0
        L43:
            if (r1 == 0) goto L46
            return r1
        L46:
            java.lang.reflect.Field r8 = com.bytedance.pangle.hc.d.d.d(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.hc.hc.d.d(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method d(java.lang.Class<?> r8, java.lang.String r9, java.lang.Class<?>... r10) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.hc.hc.d.hc
            r1 = 0
            if (r0 == 0) goto L45
            r2 = 0
            r3 = 2
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1c
            r5[r2] = r9     // Catch: java.lang.Throwable -> L1c
            r5[r4] = r10     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r0 = r0.invoke(r8, r5)     // Catch: java.lang.Throwable -> L1c
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L44
            r0.setAccessible(r4)     // Catch: java.lang.Throwable -> L1a
            goto L44
        L1a:
            r1 = move-exception
            goto L20
        L1c:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L20:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "DoubleReflector"
            r5.<init>(r6)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = r8.getName()
            r3[r2] = r6
            r3[r4] = r9
            java.lang.String r2 = "getMethod %s#%s failed !!!"
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.StringBuilder r2 = r5.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r3, r2, r1)
        L44:
            r1 = r0
        L45:
            if (r1 == 0) goto L48
            return r1
        L48:
            java.lang.reflect.Method r8 = com.bytedance.pangle.hc.d.d.d(r8, r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.hc.hc.d.d(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static Constructor d(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Method method = b;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("DoubleReflector");
                Object[] objArr = new Object[2];
                objArr[0] = cls.getName();
                objArr[1] = Integer.valueOf(clsArr != null ? clsArr.length : 0);
                ZeusLogger.w(ZeusLogger.TAG, sb.append(String.format("getConstructor %s<init>%s failed !!!", objArr)).toString(), th);
            }
        } else {
            constructor = null;
        }
        return constructor != null ? constructor : com.bytedance.pangle.hc.d.d.d(cls, clsArr);
    }
}
