package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Betelnut {
    public static final Hydra<Cfinal> a = new Hydra<>(3);
    public static final Hydra<Cfinal> b = new Hydra<>(3);
    public static final Cfinal[] c = new Cfinal[0];
    public static long d = 0;
    public static final Nucleus e = new Cdo();

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Betelnut$do, reason: invalid class name */
    public class Cdo implements Nucleus {
        public void a(Cfinal cfinal) {
            int i = cfinal.b;
            if (i == 2 || i == 3) {
                Hydra<Cfinal> hydra = Betelnut.b;
                synchronized (hydra) {
                    hydra.a(cfinal);
                }
                return;
            }
            Fig fig = cfinal.c;
            if (fig != null) {
                long jAbs = Math.abs(fig.a - Betelnut.d);
                Betelnut.d = System.currentTimeMillis();
                if (jAbs < 1000) {
                    return;
                }
                Hydra<Cfinal> hydra2 = Betelnut.a;
                synchronized (hydra2) {
                    hydra2.a(cfinal);
                }
            }
        }
    }
}
