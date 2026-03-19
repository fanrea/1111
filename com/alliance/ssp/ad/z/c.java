package com.alliance.ssp.ad.z;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;

/* compiled from: NMSplashAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends Handler {
    public final /* synthetic */ ViewGroup a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NMSplashAdImpl nMSplashAdImpl, Looper looper, ViewGroup viewGroup) {
        super(looper);
        this.a = viewGroup;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        this.a.setVisibility(0);
    }
}
