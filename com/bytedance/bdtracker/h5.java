package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.e0;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h5 {
    public static f5<j5> a = new a();

    public static class a extends f5<j5> {
        @Override // com.bytedance.bdtracker.f5
        public j5 a(Object[] objArr) {
            return new j5((Context) objArr[0]);
        }
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void a(IOaidObserver iOaidObserver) {
        j5.a(iOaidObserver);
    }

    public static void a(g gVar) {
        g gVar2;
        j5.k = gVar;
        Map<String, String> map = j5.m;
        if (map == null || (gVar2 = j5.k) == null) {
            return;
        }
        ((e0.b) gVar2).a(map);
    }

    public static void b(IOaidObserver iOaidObserver) {
        j5.b(iOaidObserver);
    }

    public static String a(SharedPreferences sharedPreferences) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strB = g5.a.b(sharedPreferences);
        LoggerImpl.global().debug(1, "getCdid takes " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms", new Object[0]);
        return strB;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map a(android.content.Context r11) {
        /*
            long r0 = android.os.SystemClock.elapsedRealtime()
            com.bytedance.bdtracker.f5<com.bytedance.bdtracker.j5> r2 = com.bytedance.bdtracker.h5.a
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r11
            java.lang.Object r11 = r2.b(r4)
            com.bytedance.bdtracker.j5 r11 = (com.bytedance.bdtracker.j5) r11
            boolean r2 = r11.c
            java.lang.String r4 = " ms"
            if (r2 != 0) goto L1b
            r11 = 0
            goto Laf
        L1b:
            r11.a()
            com.bytedance.applog.log.IAppLogLogger r2 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Oaid#getOaid timeoutMills="
            java.lang.StringBuilder r6 = r6.append(r7)
            r7 = 100
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r2.debug(r3, r6, r9)
            java.util.Map<java.lang.String, java.lang.String> r2 = com.bytedance.bdtracker.j5.m
            if (r2 != 0) goto L9e
            long r9 = android.os.SystemClock.elapsedRealtime()
            java.util.concurrent.locks.ReentrantLock r2 = r11.a     // Catch: java.lang.Throwable -> L80
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L80
            boolean r2 = r2.tryLock(r7, r6)     // Catch: java.lang.Throwable -> L80
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L7e
            long r6 = r6 - r9
            com.bytedance.applog.log.IAppLogLogger r8 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L7e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r9.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r10 = "Oaid#getOaid locked="
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.lang.Throwable -> L7e
            java.lang.StringBuilder r9 = r9.append(r2)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r10 = ", took "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.lang.Throwable -> L7e
            java.lang.StringBuilder r6 = r9.append(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.StringBuilder r6 = r6.append(r4)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L7e
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L7e
            r8.debug(r3, r6, r7)     // Catch: java.lang.Throwable -> L7e
            if (r2 == 0) goto L9e
            goto L8f
        L7e:
            r6 = move-exception
            goto L82
        L80:
            r6 = move-exception
            r2 = r5
        L82:
            com.bytedance.applog.log.IAppLogLogger r7 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L95
            java.lang.String r8 = "Get oaid failed"
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L95
            r7.error(r3, r8, r6, r9)     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L9e
        L8f:
            java.util.concurrent.locks.ReentrantLock r11 = r11.a
            r11.unlock()
            goto L9e
        L95:
            r0 = move-exception
            if (r2 == 0) goto L9d
            java.util.concurrent.locks.ReentrantLock r11 = r11.a
            r11.unlock()
        L9d:
            throw r0
        L9e:
            com.bytedance.applog.log.IAppLogLogger r11 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.util.Map<java.lang.String, java.lang.String> r6 = com.bytedance.bdtracker.j5.m
            r2[r5] = r6
            java.lang.String r6 = "Oaid#getOaid return apiMap={}"
            r11.debug(r3, r6, r2)
            java.util.Map<java.lang.String, java.lang.String> r11 = com.bytedance.bdtracker.j5.m
        Laf:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = r6 - r0
            com.bytedance.applog.log.IAppLogLogger r0 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getOaid takes "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r0.debug(r3, r1, r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.h5.a(android.content.Context):java.util.Map");
    }
}
