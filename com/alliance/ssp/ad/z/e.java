package com.alliance.ssp.ad.z;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMSplashAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e extends Handler {
    public final /* synthetic */ NMSplashAdImpl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NMSplashAdImpl nMSplashAdImpl, Looper looper) {
        super(looper);
        this.a = nMSplashAdImpl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        int i = l.a;
        NMSplashAdImpl nMSplashAdImpl = this.a;
        NMSplashAdImpl.a(nMSplashAdImpl, nMSplashAdImpl.o1, (SAAllianceAdData) null);
    }
}
