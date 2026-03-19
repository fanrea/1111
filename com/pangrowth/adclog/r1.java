package com.pangrowth.adclog;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class r1 implements s1 {
    public static ConcurrentHashMap<String, Long> a = new ConcurrentHashMap<>();

    public boolean a(JSONObject jSONObject, p1 p1Var) {
        if (jSONObject.optBoolean("wifiOnly", false)) {
            f1.c().getClass();
            if (!t2.a(f1.f)) {
                q2 q2Var = new q2(0L, false, p1Var.c, null);
                q2Var.d = 0;
                q2Var.e = "4G环境下不执行指令";
                n2.a(q2Var);
                return true;
            }
        }
        return false;
    }

    public abstract String b();

    public abstract boolean b(p1 p1Var);

    public void c(p1 p1Var) {
        q2 q2Var = new q2(0L, false, p1Var.c, null);
        q2Var.d = 2;
        n2.a(q2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    @Override // com.pangrowth.adclog.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean a(com.pangrowth.adclog.p1 r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = r7.b()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r8.b     // Catch: java.lang.Throwable -> Lad
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lad
            r1 = 0
            if (r0 != 0) goto L10
            monitor-exit(r7)
            return r1
        L10:
            r0 = 1
            java.lang.String r2 = r8.c     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r3 = com.pangrowth.adclog.r1.a     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            boolean r3 = r3.containsKey(r2)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            if (r3 == 0) goto L34
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r3 = com.pangrowth.adclog.r1.a     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            long r3 = r3.longValue()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            long r5 = r5 - r3
            r3 = 10000(0x2710, double:4.9407E-320)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L34
            r2 = r1
            goto L42
        L34:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r3 = com.pangrowth.adclog.r1.a     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            r3.put(r2, r4)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            r2 = r0
        L42:
            if (r2 == 0) goto L7a
            com.pangrowth.adclog.m2 r2 = com.pangrowth.adclog.m2.b.a     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.lang.String r3 = r8.c     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r2.a     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            if (r2 != r3) goto L54
            r2 = r0
            goto L55
        L54:
            r2 = r1
        L55:
            if (r2 == 0) goto L71
            com.pangrowth.adclog.f1 r2 = com.pangrowth.adclog.f1.c()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            r2.getClass()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            android.content.Context r2 = com.pangrowth.adclog.f1.f     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            boolean r2 = com.pangrowth.adclog.t2.a(r2)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            if (r2 != 0) goto L71
            java.lang.String r2 = "产物超过阈值，等待WiFi环境执行"
            java.lang.String r3 = r8.c     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            r4 = 0
            com.pangrowth.adclog.i.a(r3, r2, r1, r4)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            r2 = r1
            goto L72
        L71:
            r2 = r0
        L72:
            if (r2 == 0) goto L7a
            boolean r8 = r7.b(r8)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            monitor-exit(r7)
            return r8
        L7a:
            java.lang.String r2 = "cloudmessage"
            java.lang.String r3 = "checkCmdInterval false: ignored for now."
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            java.lang.String r3 = com.pangrowth.adclog.a0.a(r3)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            android.util.Log.d(r2, r3)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Lad
            monitor-exit(r7)
            return r1
        L8b:
            r2 = move-exception
            java.lang.String r3 = "系统错误：%s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Lad
            java.io.StringWriter r4 = new java.io.StringWriter     // Catch: java.lang.Throwable -> Lad
            r4.<init>()     // Catch: java.lang.Throwable -> Lad
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> Lad
            r5.<init>(r4)     // Catch: java.lang.Throwable -> Lad
            r2.printStackTrace(r5)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> Lad
            r0[r1] = r2     // Catch: java.lang.Throwable -> Lad
            java.lang.String r0 = java.lang.String.format(r3, r0)     // Catch: java.lang.Throwable -> Lad
            r7.a(r0, r8)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r7)
            return r1
        Lad:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.r1.a(com.pangrowth.adclog.p1):boolean");
    }

    public void a(String str, p1 p1Var) {
        q2 q2Var = new q2(0L, false, p1Var.c, null);
        q2Var.d = 3;
        q2Var.e = str;
        n2.a(q2Var);
    }

    public void a(String str, HashMap<String, String> map, p1 p1Var) {
        q2 q2Var = new q2(0L, false, p1Var.c, map);
        q2Var.d = 3;
        q2Var.e = str;
        n2.a(q2Var);
    }
}
