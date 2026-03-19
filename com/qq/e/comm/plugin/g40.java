package com.qq.e.comm.plugin;

import androidx.core.location.LocationRequestCompat;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g40 {
    private WeakReference<mk> c;
    private boolean e;
    private final String a = getClass().getSimpleName();
    private final List<o10> d = new CopyOnWriteArrayList();
    private final b b = new b(LocationRequestCompat.PASSIVE_INTERVAL, 500);

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g40.this.b.a(0L);
        }
    }

    public void b() {
        a(false);
    }

    public void a(em emVar) {
        if (emVar == null) {
            return;
        }
        emVar.getClass().getSimpleName();
        o10 o10Var = new o10();
        o10Var.a = new WeakReference<>(emVar);
        o10Var.b = emVar.getClass().getSimpleName();
        this.d.add(o10Var);
    }

    /* compiled from: A */
    private class b extends f20 {
        private int h;

        @Override // com.qq.e.comm.plugin.f20
        public void d() {
        }

        public b(long j, long j2) {
            super(j, j2);
            this.h = 0;
        }

        @Override // com.qq.e.comm.plugin.f20
        public void a(long j) {
            String unused = g40.this.a;
            mk mkVar = (mk) g40.this.c.get();
            if (mkVar == null) {
                String unused2 = g40.this.a;
                h();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (o10 o10Var : g40.this.d) {
                em emVar = o10Var.a.get();
                if (emVar == null) {
                    String unused3 = g40.this.a;
                    String str = o10Var.b;
                    o10Var.c = false;
                }
                if (o10Var.c) {
                    String unused4 = g40.this.a;
                    String str2 = o10Var.b;
                    if (this.h == 0) {
                        this.h = mkVar.getDuration();
                    }
                    o10Var.c = emVar.a(g40.this.e ? j40.ERROR : mkVar.getVideoState(), this.h, mkVar.getCurrentPosition());
                } else {
                    String unused5 = g40.this.a;
                    String str3 = o10Var.b;
                }
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis > 200) {
                String unused6 = g40.this.a;
            } else {
                String unused7 = g40.this.a;
            }
        }
    }

    public void a(mk mkVar) {
        if (mkVar == null) {
            return;
        }
        mkVar.getClass().getSimpleName();
        this.c = new WeakReference<>(mkVar);
        this.b.g();
    }

    public void a() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.h();
        }
        if (this.d.size() > 0) {
            this.d.clear();
        }
    }

    public void a(boolean z) {
        if (this.c == null) {
            return;
        }
        this.e = z;
        if (this.b != null) {
            xo.a((Runnable) new a());
        }
    }
}
