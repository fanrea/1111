package com.alliance.ssp.ad.y;

import android.content.pm.PackageManager;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMRewardVideoAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements com.alliance.ssp.ad.p.e {
    public final /* synthetic */ com.alliance.ssp.ad.impl.reward.a a;

    public d(com.alliance.ssp.ad.impl.reward.a aVar) {
        this.a = aVar;
    }

    public void a(String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        com.alliance.ssp.ad.impl.reward.a aVar = this.a;
        aVar.getClass();
        new com.alliance.ssp.ad.d0.f().a(3, 3, aVar.h, aVar.w, "", 0);
        com.alliance.ssp.ad.impl.reward.a aVar2 = this.a;
        aVar2.a(5, com.alliance.ssp.ad.impl.reward.a.a(aVar2, str));
    }

    public void a(int i, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        com.alliance.ssp.ad.impl.reward.a aVar = this.a;
        aVar.getClass();
        new com.alliance.ssp.ad.d0.f().a(3, 4, aVar.h, aVar.w, "", 0);
        com.alliance.ssp.ad.impl.reward.a aVar2 = this.a;
        aVar2.a(5, com.alliance.ssp.ad.impl.reward.a.a(aVar2, (String) null));
    }
}
