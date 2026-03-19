package com.alliance.ssp.ad.v;

import android.content.pm.PackageManager;
import android.view.View;
import com.alliance.ssp.ad.c0.b.ViewTreeObserverOnScrollChangedListenerC0072b;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMExpressFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements View.OnAttachStateChangeListener {
    public final /* synthetic */ NMExpressFeedAdImpl a;

    public b(NMExpressFeedAdImpl nMExpressFeedAdImpl) {
        this.a = nMExpressFeedAdImpl;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.a.d(6);
        this.a.d(3);
        NMExpressFeedAdImpl nMExpressFeedAdImpl = this.a;
        nMExpressFeedAdImpl.getClass();
        if (view == null) {
            int i = l.a;
        } else {
            int i2 = l.a;
            com.alliance.ssp.ad.c0.b bVar = new com.alliance.ssp.ad.c0.b();
            bVar.a = view;
            bVar.c = new c(nMExpressFeedAdImpl);
            bVar.b = bVar.new ViewTreeObserverOnScrollChangedListenerC0072b();
            view.getViewTreeObserver().addOnScrollChangedListener(bVar.b);
            nMExpressFeedAdImpl.B1 = bVar;
        }
        NMExpressFeedAdImpl nMExpressFeedAdImpl2 = this.a;
        if (nMExpressFeedAdImpl2.G0 == 2 && nMExpressFeedAdImpl2.u1 != null) {
            if (!nMExpressFeedAdImpl2.U0) {
                nMExpressFeedAdImpl2.U0 = true;
                NMExpressFeedAdImpl nMExpressFeedAdImpl3 = this.a;
                if (!nMExpressFeedAdImpl3.R1) {
                    nMExpressFeedAdImpl3.R1 = true;
                    NMExpressFeedAdImpl nMExpressFeedAdImpl4 = this.a;
                    nMExpressFeedAdImpl4.b(nMExpressFeedAdImpl4.h);
                }
            }
            this.a.T0 = false;
        }
        NMExpressFeedAdImpl nMExpressFeedAdImpl5 = this.a;
        if (nMExpressFeedAdImpl5.b1) {
            return;
        }
        nMExpressFeedAdImpl5.b1 = true;
        this.a.K1.sendEmptyMessageDelayed(0, 50L);
        try {
            if (this.a.G1.get(0) != null && this.a.G1.get(0).get(1) != null && this.a.G1.get(0).get(1).contains("true")) {
                this.a.U1.sendEmptyMessageDelayed(0, 50L);
            }
            NMExpressFeedAdImpl nMExpressFeedAdImpl6 = this.a;
            if (nMExpressFeedAdImpl6.I0 == 4) {
                if (nMExpressFeedAdImpl6.G1.get(1) != null && this.a.G1.get(0).get(1) != null && this.a.G1.get(0).get(1).contains("true")) {
                    this.a.V1.sendEmptyMessageDelayed(0, 50L);
                }
                if (this.a.G1.get(2) == null || this.a.G1.get(0).get(1) == null || !this.a.G1.get(0).get(1).contains("true")) {
                    return;
                }
                this.a.W1.sendEmptyMessageDelayed(0, 50L);
            }
        } catch (NullPointerException e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 011: ").append(e.getMessage()).toString(), e);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.a.d(5);
        this.a.T0 = true;
        this.a.d(4);
    }
}
