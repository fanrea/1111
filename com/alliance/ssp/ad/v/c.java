package com.alliance.ssp.ad.v;

import com.alliance.ssp.ad.c0.b;
import com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl;

/* compiled from: NMExpressFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements b.a {
    public final /* synthetic */ NMExpressFeedAdImpl a;

    public c(NMExpressFeedAdImpl nMExpressFeedAdImpl) {
        this.a = nMExpressFeedAdImpl;
    }

    @Override // com.alliance.ssp.ad.c0.b.a
    public void a(float f) {
        NMExpressFeedAdImpl nMExpressFeedAdImpl = this.a;
        nMExpressFeedAdImpl.e1 = Math.max(nMExpressFeedAdImpl.e1, (int) f);
        this.a.e0 = com.alliance.ssp.ad.a.b.a("").append(this.a.e1).toString();
        if (f >= 50.0f) {
            NMExpressFeedAdImpl nMExpressFeedAdImpl2 = this.a;
            if (!nMExpressFeedAdImpl2.x1) {
                NMExpressFeedAdImpl.f(nMExpressFeedAdImpl2, true);
                this.a.d(3);
                this.a.x1 = true;
                if (!this.a.z1) {
                    this.a.E();
                }
            }
        }
        if (f < 50.0f) {
            NMExpressFeedAdImpl nMExpressFeedAdImpl3 = this.a;
            if (nMExpressFeedAdImpl3.x1) {
                NMExpressFeedAdImpl.f(nMExpressFeedAdImpl3, false);
                this.a.d(4);
                this.a.x1 = false;
            }
        }
    }
}
