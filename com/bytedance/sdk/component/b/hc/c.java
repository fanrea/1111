package com.bytedance.sdk.component.b.hc;

import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {
    public static final c d = new d().d().b();
    public static final c hc = new d().hc().d(Integer.MAX_VALUE, TimeUnit.SECONDS).b();
    private final int an;
    String b;
    private final boolean c;
    private final boolean e;
    private final boolean gb;
    private final int h;
    private final boolean k;
    private final int mk;
    private final int mq;
    private final boolean tc;
    private final boolean tt;
    private final boolean u;
    private final boolean uo;

    private c(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.c = z;
        this.u = z2;
        this.an = i;
        this.h = i2;
        this.gb = z3;
        this.tt = z4;
        this.tc = z5;
        this.mk = i3;
        this.mq = i4;
        this.uo = z6;
        this.k = z7;
        this.e = z8;
        this.b = str;
    }

    c(d dVar) {
        this.c = dVar.d;
        this.u = dVar.hc;
        this.an = dVar.b;
        this.h = -1;
        this.gb = false;
        this.tt = false;
        this.tc = false;
        this.mk = dVar.c;
        this.mq = dVar.u;
        this.uo = dVar.an;
        this.k = dVar.h;
        this.e = dVar.gb;
    }

    public boolean d() {
        return this.c;
    }

    public boolean hc() {
        return this.u;
    }

    public int b() {
        return this.an;
    }

    public boolean c() {
        return this.gb;
    }

    public boolean u() {
        return this.tt;
    }

    public boolean an() {
        return this.tc;
    }

    public int h() {
        return this.mk;
    }

    public int gb() {
        return this.mq;
    }

    public boolean tt() {
        return this.uo;
    }

    public boolean tc() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.b.hc.c d(com.bytedance.sdk.component.b.hc.yo r22) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.c.d(com.bytedance.sdk.component.b.hc.yo):com.bytedance.sdk.component.b.hc.c");
    }

    public String toString() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        String strMk = mk();
        this.b = strMk;
        return strMk;
    }

    private String mk() {
        StringBuilder sb = new StringBuilder();
        if (this.c) {
            sb.append("no-cache, ");
        }
        if (this.u) {
            sb.append("no-store, ");
        }
        if (this.an != -1) {
            sb.append("max-age=").append(this.an).append(", ");
        }
        if (this.h != -1) {
            sb.append("s-maxage=").append(this.h).append(", ");
        }
        if (this.gb) {
            sb.append("private, ");
        }
        if (this.tt) {
            sb.append("public, ");
        }
        if (this.tc) {
            sb.append("must-revalidate, ");
        }
        if (this.mk != -1) {
            sb.append("max-stale=").append(this.mk).append(", ");
        }
        if (this.mq != -1) {
            sb.append("min-fresh=").append(this.mq).append(", ");
        }
        if (this.uo) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.e) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class d {
        boolean an;
        boolean d;
        boolean gb;
        boolean h;
        boolean hc;
        int b = -1;
        int c = -1;
        int u = -1;

        public d d() {
            this.d = true;
            return this;
        }

        public d d(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public d hc() {
            this.an = true;
            return this;
        }

        public c b() {
            return new c(this);
        }
    }
}
