package com.android.gdt.qone.ae;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class f {
    public static volatile f d;
    public final AtomicBoolean a = new AtomicBoolean(false);
    public String b;
    public String c;

    public static f a() {
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    d = new f();
                }
            }
        }
        return d;
    }

    public static String b(String str) {
        String string;
        com.android.gdt.qone.ad.c cVar = com.android.gdt.qone.ad.b.a;
        String strValueOf = "";
        if (cVar.a() == null || (string = cVar.a.getString(str, "")) == null) {
            string = "";
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (String str2 : string.split(i.b)) {
            if (!str2.isEmpty()) {
                linkedList.add(str2);
            }
        }
        if (str.equals("c_f_uptimes")) {
            strValueOf = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        } else {
            str.equals("c_f_bootids");
        }
        if ((linkedList.size() == 0 || !((String) linkedList.getFirst()).equals(strValueOf)) && !TextUtils.isEmpty(strValueOf)) {
            linkedList.addFirst(strValueOf);
            z = true;
        }
        if (linkedList.size() > 5) {
            linkedList.remove(linkedList.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(i.b);
        }
        if (!linkedList.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String string2 = sb.toString();
        if (z) {
            com.android.gdt.qone.ad.b.a.a(str, string2);
        }
        return string2;
    }

    public final synchronized void a(String str) {
        if (this.a.get()) {
            return;
        }
        com.android.gdt.qone.ad.h hVarA = com.android.gdt.qone.ad.h.a(str);
        if (hVarA.a() == null || !hVarA.a.contains("f_uptimes")) {
            com.android.gdt.qone.ad.h hVarA2 = com.android.gdt.qone.ad.h.a(str);
            if (hVarA2.a() != null) {
                com.android.gdt.qone.w.a.a(hVarA2.b, hVarA2.d, new com.android.gdt.qone.ad.e(hVarA2, "f_uptimes"));
            }
        }
        com.android.gdt.qone.ad.c cVar = com.android.gdt.qone.ad.b.a;
        if (cVar.a() == null || !cVar.a.contains("c_f_uptimes")) {
            String strC = com.android.gdt.qone.ad.h.a(str).c("c_f_uptimes");
            if (!TextUtils.isEmpty(strC)) {
                com.android.gdt.qone.ad.h hVarA3 = com.android.gdt.qone.ad.h.a(str);
                if (hVarA3.a() != null) {
                    com.android.gdt.qone.w.a.a(hVarA3.b, hVarA3.d, new com.android.gdt.qone.ad.e(hVarA3, "c_f_uptimes"));
                }
                if (strC.length() <= 1024) {
                    cVar.a("c_f_uptimes", strC);
                }
            }
        }
        if (cVar.a() == null || !cVar.a.contains("c_f_bootids")) {
            String strC2 = com.android.gdt.qone.ad.h.a(str).c("c_f_bootids");
            if (!TextUtils.isEmpty(strC2)) {
                com.android.gdt.qone.ad.h hVarA4 = com.android.gdt.qone.ad.h.a(str);
                if (hVarA4.a() != null) {
                    com.android.gdt.qone.w.a.a(hVarA4.b, hVarA4.d, new com.android.gdt.qone.ad.e(hVarA4, "c_f_bootids"));
                }
                if (strC2.length() <= 1024) {
                    cVar.a("c_f_bootids", strC2);
                }
            }
        }
        this.b = b("c_f_uptimes");
        this.c = b("c_f_bootids");
        this.a.set(true);
    }
}
