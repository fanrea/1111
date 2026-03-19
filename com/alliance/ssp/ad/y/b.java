package com.alliance.ssp.ad.y;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMRewardVideoAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends Handler {
    public final /* synthetic */ com.alliance.ssp.ad.impl.reward.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.alliance.ssp.ad.impl.reward.a aVar, Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        int i = l.a;
        com.alliance.ssp.ad.impl.reward.a aVar = this.a;
        com.alliance.ssp.ad.impl.reward.a.a(aVar, aVar.X0, (SAAllianceAdData) null);
    }
}
