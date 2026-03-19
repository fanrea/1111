package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Lemon {
    public static final String d = Cfinally.a(Cfinally.a1);
    public static final long e = TimeUnit.HOURS.toMillis(32);
    public static final Lemon f = new Lemon();
    public volatile Cprivate a = null;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final ReentrantReadWriteLock c = new ReentrantReadWriteLock();

    public void a(Cprivate cprivate, boolean z) {
        this.c.writeLock().lock();
        if (z) {
            try {
                Eridanus eridanus = new Eridanus(128);
                cprivate.a(eridanus);
                if (Cstrictfp.a(b("2"), Cstatic.b(Cnative.a(eridanus.a()), Cstatic.a()), true)) {
                    File file = new File(b("1"));
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } finally {
                this.a = cprivate;
                this.c.writeLock().unlock();
            }
        }
    }

    public final String b(String str) {
        Context context;
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("12");
        File file = new File(sb.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str2 + Casaba.a + "_au_" + str;
    }

    public Set<String> c() {
        String strA = !d() ? Cfinally.a(Cfinally.h1) : a("p_l_h_l");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, strA.split(","));
        return hashSet;
    }

    public final boolean d() {
        return b() != null;
    }

    public final Cprivate b(String str, boolean z) {
        try {
            byte[] bArrA = Cstrictfp.a(str, true);
            if (bArrA == null) {
                return null;
            }
            if (z && ((bArrA = Cnative.b(Cstatic.a(bArrA, Cstatic.a()))) == null || bArrA.length == 0)) {
                return null;
            }
            Cprivate cprivate = new Cprivate();
            cprivate.a(new Draco(bArrA));
            return cprivate;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String a(String str) {
        Cprivate cprivateB;
        Map<String, String> map;
        if (str == null || (cprivateB = b()) == null || (map = cprivateB.g) == null) {
            return null;
        }
        return map.get(str);
    }

    public Cprivate b() {
        this.c.readLock().lock();
        try {
            if (this.b.get()) {
                return this.a;
            }
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.a;
                }
                Cprivate cprivateB = b(b("2"), true);
                if (cprivateB == null) {
                    cprivateB = b(b("1"), false);
                }
                this.a = cprivateB;
                this.b.set(true);
                return this.a;
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public final boolean a(String str, boolean z) {
        String strA = a(str);
        if (strA == null) {
            return z;
        }
        try {
            return Integer.parseInt(strA) > 0;
        } catch (NumberFormatException unused) {
            return z;
        }
    }

    public String a() {
        String strA;
        if (!d()) {
            strA = Cfinally.a(Cfinally.g1);
        } else {
            strA = a("a_f_ok_c");
        }
        String strA2 = a("a_f_ok_s");
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(strA)) {
            for (String str : strA.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        if (!TextUtils.isEmpty(strA2) && Mandarin.a.b().a() && UrsaMajor.a()) {
            for (String str2 : strA2.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
