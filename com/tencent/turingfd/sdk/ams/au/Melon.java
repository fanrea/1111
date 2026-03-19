package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.alipay.sdk.m.u.i;
import com.tencent.turingfd.sdk.ams.au.Hickory.Cdo;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Melon {
    public static final long a = System.currentTimeMillis();
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final Serpens d = new Serpens(false);
    public static final Serpens e = new Serpens(true);

    public static void a(Foxnut foxnut) {
        Hickory hickory = Hickory.l;
        hickory.a = foxnut;
        if (!hickory.c) {
            hickory.c = true;
            Ccase.a(foxnut.b());
            HandlerThread handlerThread = new HandlerThread("TuringFdCore_90_" + Casaba.a + "_au", -8);
            handlerThread.start();
            hickory.b = hickory.new Cdo(handlerThread.getLooper(), foxnut.b());
            Kiwifruit kiwifruit = new Kiwifruit(hickory.b);
            hickory.d = kiwifruit;
            Lichee lichee = Lichee.g;
            lichee.d = foxnut;
            lichee.e = kiwifruit;
            String str = Build.BRAND;
            if ("xiaomi".equalsIgnoreCase(str) || "redmi".equalsIgnoreCase(str)) {
                synchronized (lichee.a) {
                    lichee.a.add(148);
                }
            }
            int[] iArr = Ccatch.a;
            if (iArr.length > 0) {
                synchronized (lichee.a) {
                    for (int i : iArr) {
                        lichee.a.add(Integer.valueOf(i));
                    }
                }
            }
            lichee.b();
            new Grapefruit(hickory).start();
        }
        Blueberry.a();
    }

    public static int b(Foxnut foxnut) {
        AtomicBoolean atomicBoolean = b;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z = true;
        if (foxnut.h) {
            TextUtils.isEmpty(foxnut.k);
            String str = foxnut.k;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("turingau");
                } else {
                    System.load(str);
                }
            } catch (Throwable th) {
                Log.w("TuringFdJava", th);
                z = false;
            }
            b.set(z);
            if (!z) {
                Log.e("TuringFdJava", "load so failure");
            }
        } else {
            atomicBoolean.set(true);
        }
        return b.get() ? 0 : -10001;
    }

    public static int c(Foxnut foxnut) {
        Context contextB = foxnut.b();
        HashMap map = new HashMap();
        Lemon lemon = Lemon.f;
        boolean zA = UrsaMajor.a();
        map.put("2008", (zA && lemon.a("e_w_d", false)) ? "1" : "0");
        map.put("2009", (zA && lemon.a("e_r_d", true)) ? "1" : "0");
        map.put("2010", (zA && lemon.a("e_w_nd", true)) ? "1" : "0");
        map.put("2011", (zA && lemon.a("e_r_nd", true)) ? "1" : "0");
        map.put("2025", foxnut.C ? "1" : "0");
        map.put("2028", foxnut.E ? "1" : "0");
        try {
            int iB = Sagittarius.b(TNative$aa.i90_BD4FE23C352252DC(new SparseArray(), contextB, map, d, e, Mandarin.a.b()));
            if (iB == 0) {
                return 0;
            }
            Log.e("TuringFdJava", "native init fail, err: " + iB);
            return -10020;
        } catch (Throwable th) {
            Log.e("TuringFdJava", "native init exception", th);
            return -10020;
        }
    }

    public static String b() {
        Foxnut foxnut;
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        sb.append(String.format(locale, "TuringFD v%d", 90));
        sb.append(" (BD4FE23C352252DC, au, b8ba8c8");
        StringBuilder sb2 = new StringBuilder();
        if (!"".isEmpty()) {
            sb2.append(i.b);
        }
        sb2.append("rfr");
        if (!sb2.toString().isEmpty()) {
            sb2.append(i.b);
        }
        sb2.append("rs");
        String string = sb2.toString();
        if (!TextUtils.isEmpty(string)) {
            sb.append(", ");
            sb.append(string);
        }
        sb.append(", ");
        StringBuilder sb3 = new StringBuilder();
        if (!"".isEmpty()) {
            sb3.append(i.b);
        }
        sb3.append("wup");
        if (!sb3.toString().isEmpty()) {
            sb3.append(i.b);
        }
        sb3.append("105498");
        sb.append(sb3.toString());
        sb.append(String.format(locale, ", compiled %s)", "2024_10_22_17_50_09"));
        synchronized (Foxnut.class) {
            foxnut = Foxnut.F;
        }
        if (foxnut != null) {
            sb.append(" [");
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sbA = Bennet.a("url(");
            sbA.append(TextUtils.join(",", foxnut.i));
            sbA.append(")");
            String string2 = sbA.toString();
            if (!"".isEmpty()) {
                sb4.append(i.b);
            }
            sb4.append(string2);
            String str = "c(" + foxnut.f + ")";
            if (!sb4.toString().isEmpty()) {
                sb4.append(i.b);
            }
            sb4.append(str);
            if (foxnut.z) {
                if (!sb4.toString().isEmpty()) {
                    sb4.append(i.b);
                }
                sb4.append("ext");
            }
            sb.append(sb4.toString());
            sb.append("]");
        }
        return sb.toString();
    }

    public static int a() {
        Foxnut foxnut;
        if (!c.get()) {
            return -10002;
        }
        if (Casaba.a == 0) {
            return -10018;
        }
        if (!b.get()) {
            return -10001;
        }
        synchronized (Foxnut.class) {
            foxnut = Foxnut.F;
        }
        return !foxnut.c().a() ? -10019 : 0;
    }
}
