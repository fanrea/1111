package com.tencent.turingfd.sdk.ams.au;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Serpens extends Ara {
    public final AtomicReference<String> a = new AtomicReference<>(null);
    public final boolean b;

    public Serpens(boolean z) {
        this.b = z;
    }

    public String toString() {
        synchronized (this.a) {
            String str = this.a.get();
            if (str != null) {
                return str;
            }
            try {
                this.a.wait(2000L);
            } catch (InterruptedException unused) {
            }
            return this.a.get();
        }
    }
}
