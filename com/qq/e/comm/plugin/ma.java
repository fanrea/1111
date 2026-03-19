package com.qq.e.comm.plugin;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum ma {
    IMEI("m1", new wo() { // from class: com.qq.e.comm.plugin.tk
        @Override // com.qq.e.comm.plugin.la
        public String a(Context context) {
            return r1.d().c().j();
        }

        @Override // com.qq.e.comm.plugin.wo, com.qq.e.comm.plugin.la
        public /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }
    }),
    ANDROIDID("m3", new wo() { // from class: com.qq.e.comm.plugin.p2
        @Override // com.qq.e.comm.plugin.la
        public String a(Context context) {
            return na.b();
        }

        @Override // com.qq.e.comm.plugin.wo, com.qq.e.comm.plugin.la
        public /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }
    }),
    ALLID("device_ext", new l2());

    private final String a;
    private final la b;

    ma(String str, la laVar) {
        this.a = str;
        this.b = laVar;
    }

    public la c() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String a(Context context) {
        return c().b(context);
    }
}
