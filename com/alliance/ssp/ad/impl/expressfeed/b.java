package com.alliance.ssp.ad.impl.expressfeed;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdVideoListener;
import com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl;
import com.alliance.ssp.ad.l.c;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.t.g;

/* compiled from: NMExpressFeedAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends g implements SAExpressFeedAd {
    public static final Object h = new Object();
    public SAExpressFeedAdVideoListener d;
    public SAExpressFeedAdInteractionListener c = null;
    public int e = -1;
    public int f = -1;
    public NMExpressFeedAdImpl g = null;

    public b(View view) {
    }

    @Override // com.alliance.ssp.ad.t.g
    public String a() {
        return "1";
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public void destroy() {
        c cVar;
        int i = l.a;
        NMExpressFeedAdImpl nMExpressFeedAdImpl = this.g;
        nMExpressFeedAdImpl.getClass();
        nMExpressFeedAdImpl.p();
        nMExpressFeedAdImpl.S();
        com.alliance.ssp.ad.l.l lVar = nMExpressFeedAdImpl.N1;
        if (lVar != null) {
            lVar.d();
            nMExpressFeedAdImpl.N1 = null;
        }
        View view = nMExpressFeedAdImpl.P0;
        if (view != null) {
            view.setVisibility(4);
        }
        Handler handler = nMExpressFeedAdImpl.T1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            nMExpressFeedAdImpl.T1 = null;
        }
        Bitmap bitmap = nMExpressFeedAdImpl.v;
        if (bitmap != null && !bitmap.isRecycled()) {
            nMExpressFeedAdImpl.v.recycle();
            nMExpressFeedAdImpl.v = null;
        }
        com.alliance.ssp.ad.c0.b bVar = nMExpressFeedAdImpl.B1;
        if (bVar != null) {
            bVar.a();
            nMExpressFeedAdImpl.B1 = null;
        }
        com.alliance.ssp.ad.n0.b bVar2 = nMExpressFeedAdImpl.n1;
        if (bVar2 != null && (cVar = bVar2.A) != null) {
            cVar.g();
        }
        nMExpressFeedAdImpl.E0 = NMExpressFeedAdImpl.EXPRESS_STATE.IDLE;
        nMExpressFeedAdImpl.F0 = NMExpressFeedAdImpl.SHOWING_STATE.IDLE;
        if (nMExpressFeedAdImpl.v1 != null) {
            nMExpressFeedAdImpl.v1 = null;
        }
        if (nMExpressFeedAdImpl.C1 != null) {
            nMExpressFeedAdImpl.C1 = null;
        }
        if (nMExpressFeedAdImpl.I1 != null) {
            nMExpressFeedAdImpl.I1 = null;
            nMExpressFeedAdImpl.Q1 = false;
        }
        if (nMExpressFeedAdImpl.H1 != null) {
            nMExpressFeedAdImpl.H1 = null;
        }
        com.alliance.ssp.ad.m0.a aVar = nMExpressFeedAdImpl.S1;
        if (aVar != null) {
            aVar.a();
        }
        com.alliance.ssp.ad.r.c.a(nMExpressFeedAdImpl.f1.getDeeplink());
    }

    @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd
    public int getAdInteractionType() {
        return this.f;
    }

    @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd
    public int getAdMode() {
        return this.e;
    }

    @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd
    public void render() {
        Handler handler;
        NMExpressFeedAdImpl nMExpressFeedAdImpl = this.g;
        if (nMExpressFeedAdImpl != null) {
            boolean z = nMExpressFeedAdImpl.d1;
            int i = l.a;
            nMExpressFeedAdImpl.c1 = true;
            if (z) {
                nMExpressFeedAdImpl.c1 = false;
                nMExpressFeedAdImpl.a(4, nMExpressFeedAdImpl.P0, 0, (String) null);
            } else {
                if (nMExpressFeedAdImpl.G0 != 2 || (handler = nMExpressFeedAdImpl.T1) == null) {
                    return;
                }
                handler.sendEmptyMessageDelayed(0, 50L);
            }
        }
    }

    @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd
    public void setExpressFeedAdInteractionListener(SAExpressFeedAdInteractionListener sAExpressFeedAdInteractionListener) {
        synchronized (h) {
            this.c = sAExpressFeedAdInteractionListener;
        }
    }

    @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd
    public void setExpressFeedAdVideoListener(SAExpressFeedAdVideoListener sAExpressFeedAdVideoListener) {
        this.d = sAExpressFeedAdVideoListener;
    }
}
