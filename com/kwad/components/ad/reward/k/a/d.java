package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends i implements s, y.b {
    private com.kwad.components.ad.reward.c.e CJ;
    private m CK;
    private l CL;
    private n CM;
    private List<AdTemplate> CN;
    private DialogInterface.OnDismissListener CO;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private WeakReference<g> uS;

    public d(g gVar, long j, Context context) {
        super(j, context);
        this.CN = null;
        this.uS = new WeakReference<>(gVar);
    }

    public d(g gVar, long j, Context context, DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.CN = null;
        this.CO = onDismissListener;
        this.uS = new WeakReference<>(gVar);
    }

    public final com.kwad.components.ad.reward.c.e kB() {
        return this.CJ;
    }

    public final l kC() {
        return this.CL;
    }

    public final BackPressHandleResult hB() {
        m mVar = this.CK;
        if (mVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        mVar.ku();
        return BackPressHandleResult.HANDLED;
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(Activity activity, AdResultData adResultData, j jVar) {
        super.a(activity, adResultData, jVar);
        WeakReference<g> weakReference = this.uS;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void kD() {
        super.kD();
        WeakReference<g> weakReference = this.uS;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.b(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, t tVar, ViewGroup viewGroup) {
        super.a(bVar, cVar, tVar, viewGroup);
        this.mApkDownloadHelper = cVar;
        WeakReference<g> weakReference = this.uS;
        com.kwad.sdk.core.webview.c.a qVar = new q(bVar, cVar, weakReference != null ? weakReference.get() : null, this.CF, this, this.CO);
        com.kwad.components.core.e.e.g.qh().a(this);
        tVar.c(qVar);
        com.kwad.components.ad.reward.c.e eVar = new com.kwad.components.ad.reward.c.e();
        this.CJ = eVar;
        tVar.c(eVar);
        Context context = this.mContext;
        WeakReference<g> weakReference2 = this.uS;
        tVar.c(new com.kwad.components.ad.reward.k.t(context, weakReference2 != null ? weakReference2.get() : null));
        WeakReference<g> weakReference3 = this.uS;
        tVar.c(new o(weakReference3 != null ? weakReference3.get() : null));
        m mVar = new m();
        this.CK = mVar;
        tVar.c(mVar);
        l lVar = new l();
        this.CL = lVar;
        tVar.c(lVar);
        List<AdTemplate> list = this.CN;
        if (list != null) {
            this.CL.h(list);
            this.CN = null;
        }
        y yVar = new y(bVar);
        yVar.a(this);
        tVar.c(yVar);
        n nVar = new n();
        this.CM = nVar;
        tVar.c(nVar);
        tVar.c(new r(this.uS));
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final an c(com.kwad.sdk.core.webview.b bVar) {
        WeakReference<g> weakReference = this.uS;
        return new p(weakReference != null ? weakReference.get() : null, getTkTemplateId(), this.CF, bVar);
    }

    public final void i(List<AdTemplate> list) {
        this.CN = list;
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void show() {
        super.show();
        WeakReference<g> weakReference = this.uS;
        if (weakReference != null) {
            weakReference.get().E(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void dismiss() {
        WeakReference<g> weakReference = this.uS;
        if (weakReference != null) {
            weakReference.get().E(false);
        }
        super.dismiss();
    }

    @Override // com.kwad.components.core.webview.jshandler.y.b
    public final void X(AdTemplate adTemplate) {
        com.kwad.components.core.j.c cVar = new com.kwad.components.core.j.c(adTemplate, com.kwad.components.core.j.e.AGGREGATION);
        WeakReference<g> weakReference = this.uS;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.k.s
    public final void ab(boolean z) {
        n nVar = this.CM;
        if (nVar != null) {
            nVar.aa(z);
        }
    }
}
