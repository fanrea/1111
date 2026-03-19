package com.alliance.ssp.ad.v;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl;
import com.alliance.ssp.ad.l.a;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMExpressFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d extends Handler {
    public final /* synthetic */ NMExpressFeedAdImpl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(NMExpressFeedAdImpl nMExpressFeedAdImpl, Looper looper) {
        super(looper);
        this.a = nMExpressFeedAdImpl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
        super.handleMessage(message);
        int i = message.what;
        if (i <= 0 || i > 100) {
            return;
        }
        NMExpressFeedAdImpl nMExpressFeedAdImpl = this.a;
        if (!nMExpressFeedAdImpl.X1 && nMExpressFeedAdImpl.r == 1) {
            nMExpressFeedAdImpl.X1 = true;
        }
        NMExpressFeedAdImpl nMExpressFeedAdImpl2 = this.a;
        if (i == nMExpressFeedAdImpl2.Y1) {
            return;
        }
        nMExpressFeedAdImpl2.Y1 = i;
        a.b bVar = nMExpressFeedAdImpl2.v1;
        if (bVar != null) {
            bVar.a(i);
        }
        if (i == 100) {
            NMExpressFeedAdImpl nMExpressFeedAdImpl3 = this.a;
            nMExpressFeedAdImpl3.r = 2;
            nMExpressFeedAdImpl3.c();
        }
    }
}
