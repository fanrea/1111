package com.alliance.ssp.ad.u;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.o0.l;

/* compiled from: NMBannerAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends Handler {
    public final /* synthetic */ com.alliance.ssp.ad.impl.banner.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.alliance.ssp.ad.impl.banner.a aVar, Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        int i = l.a;
        com.alliance.ssp.ad.impl.banner.a aVar = this.a;
        com.alliance.ssp.ad.impl.banner.a.a(aVar, aVar.g1, (SAAllianceAdData) null);
    }
}
