package com.bytedance.msdk.api.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k {
    public boolean b() {
        return true;
    }

    public boolean d() {
        return true;
    }

    public tt hc() {
        return null;
    }

    public static k d(final com.bytedance.msdk.d.b.b bVar) {
        return new k() { // from class: com.bytedance.msdk.api.c.k.1
            @Override // com.bytedance.msdk.api.c.k
            public boolean d() {
                com.bytedance.msdk.d.b.b bVar2 = bVar;
                if (bVar2 != null) {
                    return bVar2.tt();
                }
                return super.d();
            }

            @Override // com.bytedance.msdk.api.c.k
            public tt hc() {
                com.bytedance.msdk.d.b.c cVarE;
                com.bytedance.msdk.d.b.b bVar2 = bVar;
                if (bVar2 != null && (cVarE = bVar2.e()) != null && cVarE.d() != 0.0d && cVarE.hc() != 0.0d) {
                    return new tt(cVarE.d(), cVarE.hc());
                }
                return super.hc();
            }

            @Override // com.bytedance.msdk.api.c.k
            public boolean b() {
                com.bytedance.msdk.d.b.b bVar2 = bVar;
                if (bVar2 != null) {
                    return bVar2.gb();
                }
                return super.b();
            }
        };
    }
}
