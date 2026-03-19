package com.alliance.ssp.ad.impl.expressfeed;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl;
import com.alliance.ssp.ad.l.c;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.video.VideoController;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMExpressFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends Handler {
    public final /* synthetic */ NMExpressFeedAdImpl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(NMExpressFeedAdImpl nMExpressFeedAdImpl, Looper looper) {
        super(looper);
        this.a = nMExpressFeedAdImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() throws JSONException, PackageManager.NameNotFoundException, IOException {
        c cVar;
        try {
            this.a.A1 = true;
            com.alliance.ssp.ad.n0.b bVar = this.a.n1;
            if (bVar != null && (cVar = bVar.A) != null) {
                cVar.g();
            }
            View view = this.a.P1;
            if (view != null && view.getVisibility() == 0) {
                this.a.P1.setVisibility(8);
            }
            View view2 = this.a.s1;
            if (view2 != null && view2.getVisibility() == 0) {
                this.a.s1.setVisibility(8);
            }
            NMExpressFeedAdImpl nMExpressFeedAdImpl = this.a;
            if (nMExpressFeedAdImpl.F0 == NMExpressFeedAdImpl.SHOWING_STATE.INTERACTIVE) {
                if (nMExpressFeedAdImpl.G0 != 2) {
                    nMExpressFeedAdImpl.F0 = NMExpressFeedAdImpl.SHOWING_STATE.IMAGE;
                    return;
                }
                nMExpressFeedAdImpl.F0 = NMExpressFeedAdImpl.SHOWING_STATE.VIDEO;
                if (nMExpressFeedAdImpl.Y0) {
                    nMExpressFeedAdImpl.U();
                }
            }
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 029: ")), e);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        int i2 = l.a;
        if (i == 1) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                    this.f$0.a();
                }
            });
            return;
        }
        if (i == 3) {
            com.alliance.ssp.ad.l.l lVar = this.a.N1;
            if (lVar != null) {
                lVar.c();
                return;
            }
            return;
        }
        if (i == 4) {
            com.alliance.ssp.ad.l.l lVar2 = this.a.N1;
            if (lVar2 != null) {
                lVar2.b();
                return;
            }
            return;
        }
        if (i == 5) {
            NMExpressFeedAdImpl nMExpressFeedAdImpl = this.a;
            VideoController videoController = nMExpressFeedAdImpl.u1;
            if (videoController != null && !nMExpressFeedAdImpl.T0 && videoController.f()) {
                NMExpressFeedAdImpl nMExpressFeedAdImpl2 = this.a;
                nMExpressFeedAdImpl2.k("", "", nMExpressFeedAdImpl2.h);
                this.a.R1 = false;
            }
            NMExpressFeedAdImpl nMExpressFeedAdImpl3 = this.a;
            nMExpressFeedAdImpl3.E0 = NMExpressFeedAdImpl.EXPRESS_STATE.NO_FORE;
            nMExpressFeedAdImpl3.d(4);
            return;
        }
        if (i != 6) {
            return;
        }
        NMExpressFeedAdImpl nMExpressFeedAdImpl4 = this.a;
        VideoController videoController2 = nMExpressFeedAdImpl4.u1;
        if (videoController2 != null && !nMExpressFeedAdImpl4.T0 && videoController2.i()) {
            NMExpressFeedAdImpl nMExpressFeedAdImpl5 = this.a;
            if (!nMExpressFeedAdImpl5.R1) {
                nMExpressFeedAdImpl5.R1 = true;
                NMExpressFeedAdImpl nMExpressFeedAdImpl6 = this.a;
                nMExpressFeedAdImpl6.b(nMExpressFeedAdImpl6.h);
            }
        }
        this.a.E0 = NMExpressFeedAdImpl.EXPRESS_STATE.SHOWING;
    }
}
