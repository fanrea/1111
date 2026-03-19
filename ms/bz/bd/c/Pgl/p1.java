package ms.bz.bd.c.Pgl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class p1 {
    private static volatile p1 d;
    private Throwable hc = null;

    private p1() {
    }

    public static p1 d() {
        if (d == null) {
            synchronized (p1.class) {
                if (d == null) {
                    d = new p1();
                }
            }
        }
        return d;
    }

    public final synchronized Throwable hc() {
        return this.hc;
    }
}
