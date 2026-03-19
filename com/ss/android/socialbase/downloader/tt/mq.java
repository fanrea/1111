package com.ss.android.socialbase.downloader.tt;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mq {
    private static final String d = "mq";
    private final ArrayList<Object> an;
    private volatile boolean b;
    private final AtomicReference<uo> c;
    private int h;
    private final c hc;
    private AtomicReference<uo> u;

    private static class d {
        public static final mq d = new mq(null);
    }

    /* synthetic */ mq(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static mq d() {
        return d.d;
    }

    private mq() {
        this.hc = new c(0.05d);
        this.b = false;
        this.c = new AtomicReference<>(uo.UNKNOWN);
        this.an = new ArrayList<>();
    }

    public synchronized void d(long j, long j2) {
        double d2 = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d2 < 3.0d) {
            return;
        }
        try {
            this.hc.d(d2);
            uo uoVarHc = hc();
            if (this.b) {
                this.h++;
                if (uoVarHc != this.u.get()) {
                    this.b = false;
                    this.h = 1;
                }
                if (this.h >= 5.0d && b()) {
                    this.b = false;
                    this.h = 1;
                    this.c.set(this.u.get());
                    c();
                }
                return;
            }
            if (this.c.get() != uoVarHc) {
                this.b = true;
                this.u = new AtomicReference<>(uoVarHc);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean b() {
        if (this.hc == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.d[this.c.get().ordinal()];
            double d2 = 2000.0d;
            double d3 = 550.0d;
            if (i == 1) {
                d3 = 0.0d;
                d2 = 150.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d3 = 150.0d;
            } else if (i != 3) {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d3 = 2000.0d;
            }
            double d4 = this.hc.d();
            if (d4 > d2) {
                if (d4 > d2 * 1.25d) {
                    return true;
                }
            } else if (d4 < d3 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        return false;
    }

    /* renamed from: com.ss.android.socialbase.downloader.tt.mq$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[uo.values().length];
            d = iArr;
            try {
                iArr[uo.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[uo.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[uo.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[uo.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public synchronized uo hc() {
        c cVar = this.hc;
        if (cVar == null) {
            return uo.UNKNOWN;
        }
        try {
            return d(cVar.d());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return uo.UNKNOWN;
        }
    }

    private uo d(double d2) {
        if (d2 < 0.0d) {
            return uo.UNKNOWN;
        }
        if (d2 < 150.0d) {
            return uo.POOR;
        }
        if (d2 < 550.0d) {
            return uo.MODERATE;
        }
        if (d2 < 2000.0d) {
            return uo.GOOD;
        }
        return uo.EXCELLENT;
    }

    private void c() {
        try {
            int size = this.an.size();
            for (int i = 0; i < size; i++) {
                this.an.get(i);
                this.c.get();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }
}
