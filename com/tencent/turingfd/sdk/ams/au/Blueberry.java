package com.tencent.turingfd.sdk.ams.au;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.kuaishou.android.live.network.ApiStatus;
import com.tencent.turingfd.sdk.ams.au.Cthrow;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Blueberry {
    public static final String a = Cfinally.a(Cfinally.Z0);
    public static final String b = Cfinally.a(Cfinally.d1);
    public static final AtomicReference<Bullace> c = new AtomicReference<>(null);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Blueberry$do, reason: invalid class name */
    public static class Cdo implements Callable<Bullace> {
        public static final HashMap<String, FutureTask<Bullace>> d = new HashMap<>();
        public final String a;
        public final Map<Integer, String> b;
        public final boolean c;

        /* compiled from: A */
        /* renamed from: com.tencent.turingfd.sdk.ams.au.Blueberry$do$do, reason: invalid class name and collision with other inner class name */
        public class C0805do implements Comparator<Integer> {
            public C0805do(Cdo cdo) {
            }

            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }
        }

        public Cdo(Map<Integer, String> map, boolean z) {
            this.b = map;
            this.c = z;
            if (map == null || map.isEmpty()) {
                this.a = "";
                return;
            }
            TreeMap treeMap = new TreeMap(new C0805do(this));
            treeMap.putAll(map);
            Iterator it = treeMap.keySet().iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append((String) treeMap.get((Integer) it.next()));
            }
            this.a = sb.toString();
        }

        public FutureTask<Bullace> a() {
            FutureTask<Bullace> futureTask;
            HashMap<String, FutureTask<Bullace>> map = d;
            synchronized (map) {
                Iterator<Map.Entry<String, FutureTask<Bullace>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().isDone()) {
                        it.remove();
                    }
                }
                HashMap<String, FutureTask<Bullace>> map2 = d;
                futureTask = map2.get(this.a);
                if (futureTask == null || futureTask.isDone()) {
                    futureTask = new FutureTask<>(this);
                    Cpackage.a.submit(futureTask);
                    map2.put(this.a, futureTask);
                }
            }
            return futureTask;
        }

        @Override // java.util.concurrent.Callable
        public Bullace call() throws Exception {
            Context context;
            synchronized (Ccase.class) {
                context = Ccase.a;
            }
            Bilberry bilberry = new Bilberry();
            try {
                Lichee.g.a(context);
                bilberry.b = 1;
                bilberry.e = System.currentTimeMillis();
                byte[] bArrA = Blueberry.a(context, this.b, bilberry, this.c);
                bilberry.f = System.currentTimeMillis();
                bilberry.c = bArrA.length;
                Bullace bullaceA = Blueberry.a(context, bArrA, bilberry);
                Blueberry.a(context, bullaceA);
                Blueberry.a(context, bilberry);
                return bullaceA;
            } catch (Throwable unused) {
                return new Bullace(-10015);
            }
        }
    }

    public static void a() {
        Context context;
        Hydra<Cfinal> hydra = Betelnut.a;
        if (Lemon.f.a("enable_risk_click", Casaba.b)) {
            if (Build.VERSION.SDK_INT >= 28 && !Cbreak.a()) {
                Arbutus.a();
            }
            Log.i("TRCDM", "erc");
            Nucleus nucleus = Betelnut.e;
            synchronized (Cthrow.class) {
                WeakHashMap<Activity, Object> weakHashMap = Cthrow.a;
                if (nucleus != null) {
                    synchronized (Ccase.class) {
                        context = Ccase.a;
                    }
                    if (context instanceof Application) {
                        Application application = (Application) context;
                        AtomicReference<Cthrow.Cdo> atomicReference = Cthrow.b;
                        synchronized (atomicReference) {
                            if (atomicReference.get() == null) {
                                HandlerThread handlerThread = new HandlerThread("TuringDispatch");
                                handlerThread.start();
                                Cthrow.Cdo cdo = new Cthrow.Cdo(new Cconst(handlerThread.getLooper(), nucleus));
                                atomicReference.set(cdo);
                                application.registerActivityLifecycleCallbacks(cdo);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Bullace a(Context context, byte[] bArr, Bilberry bilberry) {
        if (bArr.length == 0) {
            return new Bullace(-1000);
        }
        Mangosteen mangosteenA = Loquat.b.a(5, bArr, 8123, 18123, null);
        int i = mangosteenA.a;
        if (i != 0) {
            return new Bullace(i);
        }
        byte[] bArr2 = mangosteenA.d;
        try {
            Carambola carambola = new Carambola();
            carambola.a = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
            if (bilberry.b == 1) {
                carambola = (Carambola) Peanut.a(carambola, bArr2);
            } else {
                Draco draco = new Draco(bArr2);
                draco.b = "UTF-8";
                carambola.a(draco);
            }
            if (carambola == null) {
                return new Bullace(-1002);
            }
            int i2 = carambola.a;
            if (i2 == 0) {
                if (TextUtils.isEmpty(carambola.b)) {
                    return new Bullace(-1001);
                }
                Cherry.a(carambola.f, carambola.e);
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (carambola.c < 0) {
                    carambola.c = seconds;
                }
                return new Bullace(0, carambola.b, System.currentTimeMillis(), carambola.c * 1000, carambola.d, carambola.e);
            }
            return new Bullace((-2000) - i2);
        } catch (Throwable unused) {
            return new Bullace(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r6, com.tencent.turingfd.sdk.ams.au.Bilberry r7) {
        /*
            java.lang.String r0 = "5_"
            java.lang.StringBuilder r0 = com.tencent.turingfd.sdk.ams.au.Bennet.a(r0)
            int r1 = r7.b
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            int r2 = r7.d
            r0.append(r2)
            r0.append(r1)
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r7.a
            long r2 = r2 - r4
            r0.append(r2)
            r0.append(r1)
            int r2 = r7.c
            r0.append(r2)
            r0.append(r1)
            long r1 = r7.e
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L36
            goto L3c
        L36:
            long r3 = r7.f
            int r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r7 >= 0) goto L3f
        L3c:
            r1 = -1
            goto L41
        L3f:
            long r1 = r3 - r1
        L41:
            r0.append(r1)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = com.tencent.turingfd.sdk.ams.au.Kiwifruit.b
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "703"
            r0.put(r1, r7)
            com.tencent.turingfd.sdk.ams.au.Kiwifruit.a(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Blueberry.a(android.content.Context, com.tencent.turingfd.sdk.ams.au.Bilberry):void");
    }

    public static String a(Context context, int i, Cabstract cabstract, boolean z, boolean z2) {
        Foxnut foxnut;
        HashMap map = new HashMap();
        map.put("3", "" + i);
        map.put("3005", z ? "1" : "0");
        map.put("3006", z2 ? "1" : "0");
        if (i == 17 || i == 40) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (Foxnut.class) {
                foxnut = Foxnut.F;
            }
            List<String> listA = UrsaMinor.a(foxnut.d);
            cabstract.a(-i, System.currentTimeMillis() - jCurrentTimeMillis);
            HashSet hashSet = new HashSet();
            if (!Cimport.a(listA)) {
                hashSet.addAll(listA);
            }
            if (z) {
                Set<String> setC = Lemon.f.c();
                if (setC != null) {
                    hashSet.addAll(setC);
                }
                hashSet.add(context.getPackageName());
            }
            if (!hashSet.isEmpty()) {
                map.put("277", UrsaMinor.a(hashSet));
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            SparseArray<Object> sparseArrayH90_BD4FE23C352252DC = TNative$aa.h90_BD4FE23C352252DC(new SparseArray(), context, map, 0);
            if (Sagittarius.b(sparseArrayH90_BD4FE23C352252DC) != 0) {
                return "";
            }
            String str = (String) Sagittarius.a(sparseArrayH90_BD4FE23C352252DC, 205, String.class);
            int i2 = Date.a;
            if (str == null) {
                str = "";
            }
            cabstract.a.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis2));
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:287:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0836  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(android.content.Context r20, java.util.Map r21, com.tencent.turingfd.sdk.ams.au.Bilberry r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 2317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Blueberry.a(android.content.Context, java.util.Map, com.tencent.turingfd.sdk.ams.au.Bilberry, boolean):byte[]");
    }

    public static Bullace a(Context context) throws NumberFormatException {
        long j;
        int i;
        Context context2;
        AtomicReference<Bullace> atomicReference = c;
        synchronized (atomicReference) {
            Bullace bullace = atomicReference.get();
            if (bullace == null) {
                String strB = Kiwifruit.b(context, "1001");
                if (TextUtils.isEmpty(strB)) {
                    return null;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(Kiwifruit.b(context, "1002"));
                } catch (Throwable unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(Kiwifruit.b(context, "1003"));
                } catch (Throwable unused2) {
                }
                long j3 = j2;
                try {
                    i = Integer.parseInt(Kiwifruit.b(context, "1004"));
                } catch (Throwable unused3) {
                    i = 0;
                }
                synchronized (Ccase.class) {
                    context2 = Ccase.a;
                }
                bullace = new Bullace(0, strB, j, j3, i, Kiwifruit.b(context2, "1005"));
                c.set(bullace);
            }
            return bullace;
        }
    }

    public static void a(Context context, Bullace bullace) {
        AtomicReference<Bullace> atomicReference = c;
        synchronized (atomicReference) {
            if (bullace.a != 0) {
                return;
            }
            atomicReference.set(bullace);
            String str = Kiwifruit.b;
            if (TextUtils.isEmpty(bullace.b)) {
                return;
            }
            HashMap map = new HashMap();
            map.put("1001", bullace.b);
            map.put("1002", String.valueOf(bullace.c));
            map.put("1003", String.valueOf(bullace.d));
            map.put("1004", String.valueOf(bullace.e));
            String str2 = bullace.f;
            int i = Date.a;
            if (str2 == null) {
                str2 = "";
            }
            map.put("1005", str2);
            Kiwifruit.a(context, map);
        }
    }
}
