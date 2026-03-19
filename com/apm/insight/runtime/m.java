package com.apm.insight.runtime;

import android.os.SystemClock;
import android.util.Printer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class m {
    private static Printer a;
    private static m b;
    private static final Printer f = new Printer() { // from class: com.apm.insight.runtime.m.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.charAt(0) == '>') {
                m.a().a(str);
            } else if (str.charAt(0) == '<') {
                m.a().b(str);
            }
            if (m.a == null || m.a == m.f) {
                return;
            }
            m.a.println(str);
        }
    };
    private long c = -1;
    private final List<Printer> d = new ArrayList();
    private final List<Printer> e = new ArrayList();
    private boolean g = false;

    private m() {
    }

    public static m a() {
        if (b == null) {
            synchronized (m.class) {
                if (b == null) {
                    b = new m();
                }
            }
        }
        return b;
    }

    private static void a(List<? extends Printer> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Printer printer = list.get(i);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th) {
            com.apm.insight.o.q.a(th);
        }
    }

    void a(String str) {
        com.apm.insight.b.f.a(false);
        this.c = -1L;
        try {
            a(this.d, str);
        } catch (Exception e) {
            com.apm.insight.o.q.a((Throwable) e);
        }
    }

    void b(String str) {
        this.c = SystemClock.uptimeMillis();
        try {
            a(this.e, str);
        } catch (Exception e) {
            com.apm.insight.o.q.b((Throwable) e);
        }
    }

    public boolean b() {
        return this.c != -1 && SystemClock.uptimeMillis() - this.c > 5000;
    }
}
