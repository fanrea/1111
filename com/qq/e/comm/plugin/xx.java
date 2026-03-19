package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class xx implements Runnable {
    private static volatile Boolean a;

    private boolean a() {
        if (a == null) {
            a = Boolean.valueOf(r1.d().f().a("ctraet", 0) == 1);
        }
        return a.booleanValue();
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        boolean zA;
        try {
            b();
        } finally {
            if (zA) {
            }
        }
    }
}
