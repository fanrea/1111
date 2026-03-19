package com.alliance.ssp.ad.x;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMNativeFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d extends Handler {
    public final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Looper looper) {
        super(looper);
        this.a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        int i = l.a;
        c cVar = this.a;
        c.a(cVar, cVar.U0, (SAAllianceAdData) null);
    }
}
