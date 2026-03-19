package com.qq.e.comm.plugin;

import java.util.concurrent.Future;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface rr {
    Future<hw> a(aw awVar);

    Future<hw> a(aw awVar, a aVar);

    Future<hw> a(aw awVar, a aVar, qr qrVar);

    /* compiled from: A */
    public enum a {
        High(1),
        Mid(2),
        Low(3);

        private int a;

        a(int i) {
            this.a = i;
        }

        public int b() {
            return this.a;
        }
    }
}
