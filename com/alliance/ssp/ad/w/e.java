package com.alliance.ssp.ad.w;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.l.a;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: NMInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e extends Handler {
    public final /* synthetic */ com.alliance.ssp.ad.impl.interstitial.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(com.alliance.ssp.ad.impl.interstitial.a aVar, Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        super.handleMessage(message);
        int i = message.what;
        if (i <= 0 || i > 100) {
            return;
        }
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.a;
        if (!aVar.O1 && aVar.r == 1) {
            aVar.O1 = true;
        }
        com.alliance.ssp.ad.impl.interstitial.a aVar2 = this.a;
        if (i == aVar2.P1) {
            return;
        }
        aVar2.P1 = i;
        a.b bVar = aVar2.G1;
        if (bVar != null) {
            bVar.a(i);
        }
        if (i == 100) {
            com.alliance.ssp.ad.impl.interstitial.a aVar3 = this.a;
            aVar3.r = 2;
            aVar3.c();
        }
    }
}
