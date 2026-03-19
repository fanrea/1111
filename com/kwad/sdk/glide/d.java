package com.kwad.sdk.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.a.k;
import com.kwad.sdk.glide.load.engine.a.a;
import com.kwad.sdk.glide.load.engine.a.i;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.j;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.b bPD;
    private com.kwad.sdk.glide.a.d bPF;
    private com.kwad.sdk.glide.load.engine.b.a bPJ;
    private com.kwad.sdk.glide.load.engine.b.a bPK;
    private a.InterfaceC0610a bPL;
    private i bPM;
    private k.a bPO;
    private com.kwad.sdk.glide.load.engine.b.a bPP;
    private boolean bPQ;
    private List<com.kwad.sdk.glide.request.h<Object>> bPR;
    private boolean bPS;
    private com.kwad.sdk.glide.load.engine.i bPx;
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private com.kwad.sdk.glide.load.engine.a.h bPz;
    private final Map<Class<?>, h<?, ?>> bPI = new ArrayMap();
    private int logLevel = 4;
    private com.kwad.sdk.glide.request.i bPN = new com.kwad.sdk.glide.request.i();

    final void a(k.a aVar) {
        this.bPO = aVar;
    }

    final c cz(Context context) {
        if (this.bPJ == null) {
            this.bPJ = com.kwad.sdk.glide.load.engine.b.a.ahp();
        }
        if (this.bPK == null) {
            this.bPK = com.kwad.sdk.glide.load.engine.b.a.aho();
        }
        if (this.bPP == null) {
            this.bPP = com.kwad.sdk.glide.load.engine.b.a.ahr();
        }
        if (this.bPM == null) {
            this.bPM = new i.a(context).ahk();
        }
        if (this.bPF == null) {
            this.bPF = new com.kwad.sdk.glide.a.f();
        }
        if (this.bPy == null) {
            int iAhi = this.bPM.ahi();
            if (iAhi > 0) {
                this.bPy = new com.kwad.sdk.glide.load.engine.bitmap_recycle.k(iAhi);
            } else {
                this.bPy = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.bPD == null) {
            this.bPD = new j(this.bPM.ahj());
        }
        if (this.bPz == null) {
            this.bPz = new com.kwad.sdk.glide.load.engine.a.g(this.bPM.ahh());
        }
        if (this.bPL == null) {
            this.bPL = new com.kwad.sdk.glide.load.engine.a.f(context);
        }
        if (this.bPx == null) {
            this.bPx = new com.kwad.sdk.glide.load.engine.i(this.bPz, this.bPL, this.bPK, this.bPJ, com.kwad.sdk.glide.load.engine.b.a.ahq(), com.kwad.sdk.glide.load.engine.b.a.ahr(), this.bPQ);
        }
        List<com.kwad.sdk.glide.request.h<Object>> list = this.bPR;
        if (list == null) {
            this.bPR = Collections.emptyList();
        } else {
            this.bPR = Collections.unmodifiableList(list);
        }
        return new c(context, this.bPx, this.bPz, this.bPy, this.bPD, new k(this.bPO), this.bPF, this.logLevel, this.bPN.aiD(), this.bPI, this.bPR, this.bPS);
    }
}
