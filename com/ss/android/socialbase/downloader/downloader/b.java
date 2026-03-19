package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.dc;
import com.ss.android.socialbase.downloader.c.us;
import com.ss.android.socialbase.downloader.downloader.de;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static volatile com.ss.android.socialbase.downloader.impls.d an;
    private static volatile uo b;
    private static volatile com.ss.android.socialbase.downloader.tt.an ba;
    private static int bc;
    private static volatile tc c;
    private static volatile ExecutorService cb;
    private static volatile Context d;
    private static final int dc;
    private static volatile ExecutorService de;
    private static volatile ExecutorService e;
    private static volatile com.ss.android.socialbase.downloader.tt.an fs;
    private static boolean fu;
    private static volatile w gb;
    private static volatile w h;
    private static volatile mq hc;
    private static volatile jh he;
    private static volatile us j;
    private static volatile ExecutorService jh;
    private static volatile k k;
    private static int l;
    private static volatile com.ss.android.socialbase.downloader.tt.gb mk;
    private static volatile com.ss.android.socialbase.downloader.tt.tc mq;
    private static volatile de mt;
    private static volatile tt np;
    private static final int nv;
    private static boolean q;
    private static com.ss.android.socialbase.downloader.gb.b ra;
    private static volatile ExecutorService rf;
    private static final List<com.ss.android.socialbase.downloader.c.mq> ru;
    private static volatile boolean rw;
    private static volatile ExecutorService sy;
    private static volatile com.ss.android.socialbase.downloader.tt.tc tc;
    private static rf to;
    private static final int tr;
    private static volatile d tt;
    private static volatile ba u;
    private static volatile com.ss.android.socialbase.downloader.tt.gb uo;
    private static volatile ScheduledExecutorService v;
    private static volatile yo vv;
    private static volatile ExecutorService w;
    private static int wl;
    private static boolean xp;
    private static final int y;
    private static volatile DownloadReceiver yi;
    private static final List<Object> yn;
    private static volatile ExecutorService yo;
    private static volatile com.ss.android.socialbase.downloader.gb.hc zw;
    private static volatile List<dc> s = new ArrayList();
    private static volatile boolean us = false;
    private static volatile OkHttpClient z = null;
    private static final List<com.ss.android.socialbase.downloader.c.k> r = new ArrayList();
    private static boolean hv = false;

    public interface d {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.b$d$d, reason: collision with other inner class name */
        public interface InterfaceC0786d {
            void d();
        }

        sy d(InterfaceC0786d interfaceC0786d);

        w d();

        e hc();
    }

    public static void d(rf rfVar) {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        dc = iAvailableProcessors;
        tr = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        nv = iAvailableProcessors;
        y = iAvailableProcessors;
        wl = 8192;
        ru = new ArrayList();
        yn = new ArrayList();
        fu = true;
        xp = false;
        rw = false;
    }

    private b() {
    }

    static synchronized void d(gb gbVar) {
        if (rw) {
            com.ss.android.socialbase.downloader.an.d.u("DownloadComponentManager", "component has init");
            return;
        }
        boolean z2 = us;
        b(gbVar);
        if (hc == null) {
            hc = new com.ss.android.socialbase.downloader.impls.c();
        }
        if (h == null) {
            h = new com.ss.android.socialbase.downloader.impls.gb();
        }
        if (gb == null && tt != null) {
            gb = tt.d();
        }
        if (b == null) {
            b = new com.ss.android.socialbase.downloader.impls.tt();
        }
        if (an == null) {
            an = new com.ss.android.socialbase.downloader.impls.u();
        }
        if (c == null) {
            c = new com.ss.android.socialbase.downloader.impls.b();
        }
        if (np == null) {
            np = new com.ss.android.socialbase.downloader.impls.hc();
        }
        if (he == null) {
            he = new com.ss.android.socialbase.downloader.impls.tc();
        }
        int i = bc;
        if (i <= 0 || i > dc) {
            bc = dc;
        }
        l();
        if (us && !z2 && !com.ss.android.socialbase.downloader.e.an.b()) {
            com.ss.android.socialbase.downloader.impls.mq.d(true).startService();
        } else if (com.ss.android.socialbase.downloader.e.an.c()) {
            ExecutorService executorServiceMq = mq();
            if (executorServiceMq != null) {
                executorServiceMq.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextTr = b.tr();
                        if (contextTr != null) {
                            com.ss.android.socialbase.downloader.e.an.c(contextTr);
                        }
                    }
                });
            }
        } else {
            Context contextTr = tr();
            if (contextTr != null) {
                com.ss.android.socialbase.downloader.e.an.c(contextTr);
            }
        }
        z();
        rw = true;
    }

    static synchronized void hc(gb gbVar) {
        b(gbVar);
    }

    private static void b(gb gbVar) {
        if (gbVar != null) {
            if (gbVar.getContext() != null) {
                d(gbVar.getContext());
            }
            if (gbVar.d() != null) {
                d(gbVar.d());
            }
            if (gbVar.hc() != null) {
                d(gbVar.hc());
            }
            if (gbVar.cb() != null) {
                d(gbVar.cb());
            }
            if (gbVar.np() != null) {
                d(gbVar.np());
            }
            if (gbVar.e() != 0) {
                hc(gbVar.e());
            }
            if (gbVar.b() != null) {
                d(gbVar.b());
            }
            if (gbVar.c() != null) {
                d(gbVar.c());
            }
            if (gbVar.u() != null) {
                d(gbVar.u());
            }
            if (gbVar.an() != null) {
                b(gbVar.an());
            }
            if (gbVar.h() != null) {
                c(gbVar.h());
            }
            if (gbVar.gb() != null) {
                u(gbVar.gb());
            }
            if (gbVar.tt() != null) {
                an(gbVar.tt());
            }
            if (gbVar.tc() != null) {
                h(gbVar.tc());
            }
            if (gbVar.mk() != null) {
                gb(gbVar.mk());
            }
            if (gbVar.mq() != null) {
                d(gbVar.mq());
            }
            if (gbVar.uo() != null) {
                hc(gbVar.uo());
            }
            if (!gbVar.k().isEmpty()) {
                d(gbVar.k());
            }
            if (gbVar.jh() != null) {
                vv = gbVar.jh();
            }
            if (gbVar.yo() > 1024) {
                wl = gbVar.yo();
            }
            if (gbVar.w() != null) {
                d(gbVar.w());
            }
            if (gbVar.rf()) {
                us = true;
            }
            if (gbVar.sy() != 0) {
                l = gbVar.sy();
            }
            if (gbVar.yi() != null) {
                d(gbVar.yi());
            }
            if (gbVar.vv() != null) {
                fs = gbVar.vv();
            }
            if (gbVar.de() != null) {
                de deVarDe = gbVar.de();
                mt = deVarDe;
                if (deVarDe.d()) {
                    d(mt.hc());
                    d(mt.b());
                } else {
                    d(h());
                    d(gb());
                }
            }
            hc(gbVar.v());
            if (gbVar.he() != null) {
                d(gbVar.he());
            }
        }
    }

    private static void l() {
        if (yi == null) {
            yi = new DownloadReceiver();
        }
        if (hv) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            d.registerReceiver(yi, intentFilter);
            hv = true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public static synchronized void d() {
        if (us) {
            return;
        }
        us = true;
        try {
            Intent intent = new Intent(tr(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            tr().startService(intent);
            if (!com.ss.android.socialbase.downloader.e.an.b()) {
                com.ss.android.socialbase.downloader.impls.mq.d(true).startService();
            }
        } catch (Throwable th) {
            us = false;
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public static synchronized boolean hc() {
        return us;
    }

    public static com.ss.android.socialbase.downloader.tt.tc b() {
        return tc;
    }

    public static void d(dc dcVar) {
        if (dcVar == null) {
            return;
        }
        synchronized (s) {
            s.add(dcVar);
        }
    }

    public static List<dc> c() {
        List<dc> list;
        synchronized (s) {
            list = s;
        }
        return list;
    }

    public static void d(com.ss.android.socialbase.downloader.c.mq mqVar) {
        List<com.ss.android.socialbase.downloader.c.mq> list = ru;
        synchronized (list) {
            if (mqVar != null) {
                if (!list.contains(mqVar)) {
                    list.add(mqVar);
                }
            }
        }
    }

    public static void d(com.ss.android.socialbase.downloader.hc.c cVar) {
        List<com.ss.android.socialbase.downloader.c.mq> list = ru;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.c.mq mqVar : list) {
                if (mqVar != null && cVar != com.ss.android.socialbase.downloader.hc.c.SYNC_START && cVar == com.ss.android.socialbase.downloader.hc.c.SYNC_SUCCESS) {
                    mqVar.d();
                }
            }
            if (cVar == com.ss.android.socialbase.downloader.hc.c.SYNC_SUCCESS) {
                ru.clear();
            }
        }
    }

    public static void d(com.ss.android.socialbase.downloader.h.c cVar, int i) {
        List<Object> list = yn;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static void hc(com.ss.android.socialbase.downloader.h.c cVar, int i) {
        List<Object> list = yn;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static com.ss.android.socialbase.downloader.tt.gb u() {
        return mk;
    }

    public static com.ss.android.socialbase.downloader.gb.hc an() {
        return zw;
    }

    public static com.ss.android.socialbase.downloader.tt.tt d(boolean z2, int i, String str, List<com.ss.android.socialbase.downloader.h.u> list) throws Exception {
        return d(z2, i, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.tt.tt d(boolean z2, int i, String str, String str2, List<com.ss.android.socialbase.downloader.h.u> list, int i2, boolean z3, com.ss.android.socialbase.downloader.h.b bVar) throws Exception {
        List<com.ss.android.socialbase.downloader.h.u> list2;
        int i3;
        com.ss.android.socialbase.downloader.tt.tt ttVarD;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.h.u> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.h.u("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i3 = 1;
        } else if (z2) {
            list2 = list;
            i3 = i2;
        } else {
            i3 = 2;
            list2 = list;
        }
        int[] iArrD = d(i3);
        Exception exc = null;
        for (int i4 : iArrD) {
            try {
                ttVarD = d(i, str, str2, list2, i4, z3, bVar);
            } catch (Exception e2) {
                if (bVar.pq() && com.ss.android.socialbase.downloader.e.an.h(e2) && com.ss.android.socialbase.downloader.e.an.b(list2)) {
                    com.ss.android.socialbase.downloader.an.d.d("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
            if (ttVarD != null) {
                return ttVarD;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.tt.tt d(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.ss.android.socialbase.downloader.h.u> r14, int r15, boolean r16, com.ss.android.socialbase.downloader.h.b r17) throws java.lang.Throwable {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.tt.tc r0 = b()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.tt.tc r0 = h()
        Ld:
            if (r0 == 0) goto L57
            r1 = 0
            r2 = 0
            r3 = 0
            if (r16 == 0) goto L20
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r6 = r12
            goto L3e
        L1d:
            r0 = move-exception
            r6 = r12
            goto L41
        L20:
            r5 = r11
            r6 = r12
            r8 = r14
            com.ss.android.socialbase.downloader.tt.tt r0 = r0.d(r11, r12, r14)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            if (r16 == 0) goto L3c
            long r1 = java.lang.System.currentTimeMillis()
            long r4 = r1 - r3
            r8 = 0
            java.lang.String r9 = "get"
            r1 = r0
            r2 = r12
            r3 = r13
            r6 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.gb.d.d(r1, r2, r3, r4, r6, r7, r8, r9)
        L3c:
            return r0
        L3d:
            r0 = move-exception
        L3e:
            r8 = r2
            goto L43
        L40:
            r0 = move-exception
        L41:
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> L3d
        L43:
            if (r16 == 0) goto L56
            long r9 = java.lang.System.currentTimeMillis()
            long r4 = r9 - r3
            java.lang.String r9 = "get"
            r2 = r12
            r3 = r13
            r6 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.gb.d.d(r1, r2, r3, r4, r6, r7, r8, r9)
        L56:
            throw r0
        L57:
            com.ss.android.socialbase.downloader.u.d r0 = new com.ss.android.socialbase.downloader.u.d
            r1 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "httpService not exist, netLib = "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r15)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.b.d(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.h.b):com.ss.android.socialbase.downloader.tt.tt");
    }

    public static com.ss.android.socialbase.downloader.tt.h d(String str, List<com.ss.android.socialbase.downloader.h.u> list) throws Exception {
        return d(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.tt.h d(String str, List<com.ss.android.socialbase.downloader.h.u> list, int i, boolean z2, com.ss.android.socialbase.downloader.h.b bVar) throws Exception {
        com.ss.android.socialbase.downloader.tt.h hVarHc;
        Exception e2 = null;
        for (int i2 : d(i)) {
            try {
                hVarHc = hc(str, list, i2, z2, bVar);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (hVarHc != null) {
                return hVarHc;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.tt.h hc(java.lang.String r12, java.util.List<com.ss.android.socialbase.downloader.h.u> r13, int r14, boolean r15, com.ss.android.socialbase.downloader.h.b r16) throws java.lang.Throwable {
        /*
            r7 = r14
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.tt.gb r0 = u()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.tt.gb r0 = gb()
        Ld:
            if (r0 == 0) goto L5a
            r1 = 0
            r2 = 0
            r3 = 0
            if (r15 == 0) goto L20
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r5 = r12
            goto L40
        L1d:
            r0 = move-exception
            r5 = r12
            goto L43
        L20:
            r5 = r12
            r6 = r13
            com.ss.android.socialbase.downloader.tt.h r0 = r0.d(r12, r13)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            if (r15 == 0) goto L3e
            r6 = 0
            long r1 = java.lang.System.currentTimeMillis()
            long r8 = r1 - r3
            r10 = 0
            java.lang.String r11 = "head"
            r1 = r0
            r2 = r12
            r3 = r6
            r4 = r8
            r6 = r11
            r7 = r14
            r8 = r10
            r9 = r16
            com.ss.android.socialbase.downloader.gb.d.d(r1, r2, r3, r4, r6, r7, r8, r9)
        L3e:
            return r0
        L3f:
            r0 = move-exception
        L40:
            r8 = r2
            goto L45
        L42:
            r0 = move-exception
        L43:
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> L3f
        L45:
            if (r15 == 0) goto L59
            r6 = 0
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r3
            java.lang.String r11 = "head"
            r2 = r12
            r3 = r6
            r4 = r9
            r6 = r11
            r7 = r14
            r9 = r16
            com.ss.android.socialbase.downloader.gb.d.d(r1, r2, r3, r4, r6, r7, r8, r9)
        L59:
            throw r0
        L5a:
            com.ss.android.socialbase.downloader.u.d r0 = new com.ss.android.socialbase.downloader.u.d
            r1 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "httpService not exist, netLib = "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.b.hc(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.h.b):com.ss.android.socialbase.downloader.tt.h");
    }

    private static int[] d(int i) {
        return i != 1 ? i != 2 ? i != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static com.ss.android.socialbase.downloader.tt.tc h() {
        if (mq == null) {
            synchronized (b.class) {
                if (mq == null) {
                    mq = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return mq;
    }

    public static com.ss.android.socialbase.downloader.tt.gb gb() {
        if (uo == null) {
            synchronized (b.class) {
                if (uo == null) {
                    uo = new com.ss.android.socialbase.downloader.impls.an();
                }
            }
        }
        return uo;
    }

    public static synchronized void d(k kVar) {
        if (kVar != null) {
            k = kVar;
            if (hc instanceof com.ss.android.socialbase.downloader.impls.c) {
                ((com.ss.android.socialbase.downloader.impls.c) hc).gb();
            }
        }
    }

    private static void b(ExecutorService executorService) {
        if (executorService != null) {
            e = executorService;
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            cb = executorService;
        }
    }

    private static void u(ExecutorService executorService) {
        if (executorService != null) {
            w = executorService;
        }
    }

    private static void an(ExecutorService executorService) {
        if (executorService != null) {
            yo = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            rf = executorService;
        }
    }

    private static void gb(ExecutorService executorService) {
        if (executorService != null) {
            jh = executorService;
        }
    }

    public static void d(ExecutorService executorService) {
        if (executorService != null) {
            sy = executorService;
        }
    }

    public static void hc(ExecutorService executorService) {
        if (executorService != null) {
            de = executorService;
        }
    }

    private static void d(List<com.ss.android.socialbase.downloader.c.k> list) {
        List<com.ss.android.socialbase.downloader.c.k> list2 = r;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void d(boolean z2) {
        xp = z2;
    }

    public static boolean tt() {
        return com.ss.android.socialbase.downloader.uo.d.b().d("switch_not_auto_boot_service", xp ? 1 : 0) > 0;
    }

    public static synchronized yo tc() {
        return vv;
    }

    public static void d(Runnable runnable) {
        d(runnable, false);
    }

    public static void hc(Runnable runnable) {
        hc(runnable, false);
    }

    public static void d(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.e.an.c()) {
            runnable.run();
        } else {
            mk().execute(runnable);
        }
    }

    public static void hc(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.e.an.c()) {
            runnable.run();
        } else {
            mq().execute(runnable);
        }
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.e.an.c()) {
            runnable.run();
        } else {
            w().execute(runnable);
        }
    }

    public static Future d(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return rf().schedule(runnable, j2, timeUnit);
    }

    public static ExecutorService mk() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    int i = dc;
                    com.bytedance.sdk.component.tc.c.c cVar = new com.bytedance.sdk.component.tc.c.c(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.k.d("DownloadThreadPool-cpu-fixed", true));
                    try {
                        cVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                    e = cVar;
                }
            }
        }
        return e;
    }

    public static ExecutorService mq() {
        return cb != null ? cb : mk();
    }

    public static ExecutorService uo() {
        return yo != null ? yo : e();
    }

    public static ExecutorService k() {
        return rf != null ? rf : e();
    }

    public static ExecutorService e() {
        if (w == null) {
            synchronized (b.class) {
                if (w == null) {
                    int i = nv;
                    com.bytedance.sdk.component.tc.c.c cVar = new com.bytedance.sdk.component.tc.c.c(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.k.d("DownloadThreadPool-mix-fixed", true));
                    try {
                        cVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                    w = cVar;
                }
            }
        }
        return w;
    }

    public static ExecutorService cb() {
        if (sy == null) {
            synchronized (b.class) {
                if (sy == null) {
                    int i = tr;
                    com.bytedance.sdk.component.tc.c.c cVar = new com.bytedance.sdk.component.tc.c.c(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.k.d("DownloadThreadPool-chunk-fixed", true));
                    try {
                        cVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                    sy = cVar;
                }
            }
        }
        return sy;
    }

    public static ExecutorService w() {
        if (jh == null) {
            synchronized (b.class) {
                if (jh == null) {
                    int i = y;
                    com.bytedance.sdk.component.tc.c.c cVar = new com.bytedance.sdk.component.tc.c.c(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.k.d("DownloadThreadPool-db-fixed", true));
                    try {
                        cVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                    jh = cVar;
                }
            }
        }
        return jh;
    }

    public static OkHttpClient yo() {
        if (z == null) {
            synchronized (b.class) {
                if (z == null) {
                    z = jh().build();
                }
            }
        }
        return z;
    }

    public static ScheduledExecutorService rf() {
        if (v == null) {
            synchronized (b.class) {
                if (v == null) {
                    v = new com.bytedance.sdk.component.tc.c.u(1, new com.ss.android.socialbase.downloader.k.d("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return v;
    }

    public static OkHttpClient.Builder jh() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (de != null) {
            builder.dispatcher(new Dispatcher(de));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.tt.an sy() {
        return fs;
    }

    public static com.ss.android.socialbase.downloader.tt.an de() {
        if (ba == null) {
            synchronized (b.class) {
                if (ba == null) {
                    ba = new com.ss.android.socialbase.downloader.tt.an() { // from class: com.ss.android.socialbase.downloader.downloader.b.2
                        @Override // com.ss.android.socialbase.downloader.tt.an
                        public List<InetAddress> d(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return ba;
    }

    public static synchronized k v() {
        return k;
    }

    public static void d(com.ss.android.socialbase.downloader.tt.tc tcVar) {
        if (tcVar != null) {
            tc = tcVar;
        }
        q = tc != null;
    }

    public static void d(com.ss.android.socialbase.downloader.tt.gb gbVar) {
        if (gbVar != null) {
            mk = gbVar;
        }
    }

    public static mq np() {
        if (hc == null) {
            synchronized (b.class) {
                if (hc == null) {
                    hc = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return hc;
    }

    private static void d(mq mqVar) {
        if (mqVar != null) {
            hc = mqVar;
        }
    }

    public static w yi() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new com.ss.android.socialbase.downloader.impls.gb();
                }
            }
        }
        return h;
    }

    public static w he() {
        if (gb == null) {
            synchronized (b.class) {
                if (gb == null) {
                    gb = tt.d();
                }
            }
        }
        return gb;
    }

    public static List<com.ss.android.socialbase.downloader.c.k> vv() {
        return r;
    }

    public static uo zw() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new com.ss.android.socialbase.downloader.impls.tt();
                }
            }
        }
        return b;
    }

    public static com.ss.android.socialbase.downloader.impls.d j() {
        if (an == null) {
            synchronized (b.class) {
                if (an == null) {
                    an = new com.ss.android.socialbase.downloader.impls.u();
                }
            }
        }
        return an;
    }

    private static void d(uo uoVar) {
        if (uoVar != null) {
            b = uoVar;
        }
    }

    private static void hc(int i) {
        if (i > 0) {
            bc = i;
        }
    }

    private static void d(com.ss.android.socialbase.downloader.gb.hc hcVar) {
        if (hcVar != null) {
            zw = hcVar;
        }
    }

    public static int s() {
        return l;
    }

    public static JSONObject us() {
        if (j == null || j.d() == null) {
            return com.ss.android.socialbase.downloader.hc.u.tt;
        }
        return j.d();
    }

    public static void z() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.hc.u.b)) {
            com.ss.android.socialbase.downloader.hc.u.b = "oppo";
            com.ss.android.socialbase.downloader.hc.u.hc = "oppo".toUpperCase();
        }
    }

    public static void d(us usVar) {
        j = usVar;
        com.ss.android.socialbase.downloader.uo.d.d();
    }

    private static void hc(boolean z2) {
        fu = z2;
    }

    public static boolean fs() {
        return fu;
    }

    public static synchronized int ba() {
        return wl;
    }

    public static tc mt() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return c;
    }

    private static void d(tc tcVar) {
        if (tcVar != null) {
            c = tcVar;
        }
    }

    public static void d(ba baVar) {
        if (baVar != null) {
            u = baVar;
        }
    }

    public static ba r() {
        return u;
    }

    public static tt hv() {
        if (np == null) {
            synchronized (b.class) {
                if (np == null) {
                    np = new com.ss.android.socialbase.downloader.impls.hc();
                }
            }
        }
        return np;
    }

    private static void d(tt ttVar) {
        if (ttVar != null) {
            np = ttVar;
        }
    }

    public static jh bc() {
        if (he == null) {
            synchronized (b.class) {
                if (he == null) {
                    he = new com.ss.android.socialbase.downloader.impls.tc();
                }
            }
        }
        return he;
    }

    public static de dc() {
        if (mt == null) {
            synchronized (b.class) {
                if (mt == null) {
                    mt = new de.d();
                }
            }
        }
        return mt;
    }

    public static synchronized Context tr() {
        return d;
    }

    public static synchronized void d(Context context) {
        if (context != null) {
            if (d == null) {
                d = context.getApplicationContext();
                com.ss.android.socialbase.downloader.d.d.d().d(d);
            }
        }
    }

    public static int d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return 0;
        }
        String strHe = bVar.he();
        if (TextUtils.isEmpty(strHe)) {
            strHe = bVar.tc();
        }
        return d(strHe, bVar.mk());
    }

    public static int d(String str, String str2) {
        uo uoVarZw = zw();
        if (uoVarZw == null) {
            return 0;
        }
        return uoVarZw.d(str, str2);
    }

    public static synchronized boolean nv() {
        return q;
    }

    public static com.ss.android.socialbase.downloader.gb.b y() {
        if (ra == null) {
            ra = new com.ss.android.socialbase.downloader.gb.b() { // from class: com.ss.android.socialbase.downloader.downloader.b.3
                @Override // com.ss.android.socialbase.downloader.gb.b
                public void d(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.gb.b
                public void hc(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return ra;
    }

    public static rf wl() {
        return to;
    }

    public static void d(com.ss.android.socialbase.downloader.gb.b bVar) {
        ra = bVar;
    }

    public static boolean q() {
        return rw;
    }

    public static void d(d dVar) {
        com.ss.android.socialbase.downloader.an.d.d("wjd", "setIndependentServiceCreator::creator=" + dVar);
        tt = dVar;
    }

    public static boolean ru() {
        com.ss.android.socialbase.downloader.an.d.d("wjd", "supportMultiProc::=" + (tt != null));
        return tt != null;
    }

    public static d yn() {
        return tt;
    }
}
