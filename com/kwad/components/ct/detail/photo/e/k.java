package com.kwad.components.ct.detail.photo.e;

import android.content.DialogInterface;
import android.view.View;
import com.kwad.components.ct.detail.photo.d.f;
import com.kwad.components.ct.detail.photo.d.h;
import com.kwad.components.ct.detail.photo.d.i;
import com.kwad.components.ct.detail.photo.d.l;
import com.kwad.components.ct.detail.photo.d.m;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends a<e> implements com.kwad.components.ec.api.live.a {
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.detail.photo.d.i awN;
    private m awO;
    private boolean ari = false;
    private final com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.e.k.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            k.this.ari = true;
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            k.this.ari = false;
            if (k.this.awq != 0) {
                ((e) k.this.awq).BB();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.e.d
    /* renamed from: BM, reason: merged with bridge method [inline-methods] */
    public e Ag() {
        return new e(getContext());
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoE = true;
        ((e) this.awq).setOnClickListener(this);
        this.aok = this.aop.aok;
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
        com.kwad.components.ct.detail.photo.d.i iVar = this.awN;
        if (iVar != null) {
            iVar.dismiss();
        }
        m mVar = this.awO;
        if (mVar != null) {
            mVar.dismiss();
        }
        this.aok.h(true, 3);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.components.ct.response.a.a.eH(this.aop.mAdTemplate)) {
            ac.ae(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            BN();
        }
        com.kwad.sdk.components.d.g(com.kwad.components.ec.api.a.class);
        com.kwad.components.ct.e.b.JK().L(this.aop.mAdTemplate);
    }

    private void BN() {
        com.kwad.components.ct.detail.photo.d.h hVarAk = new h.a().f(this.aop.mAdTemplate).bv(true).bw(true).bu(true).bx(this.aop.aol.aHh).Ak();
        com.kwad.components.ct.detail.photo.d.i iVar = this.awN;
        if (iVar == null || !iVar.isShowing()) {
            com.kwad.components.ct.detail.photo.d.i iVar2 = new com.kwad.components.ct.detail.photo.d.i(getContext(), hVarAk);
            this.awN = iVar2;
            iVar2.c(new f.a() { // from class: com.kwad.components.ct.detail.photo.e.k.2
                @Override // com.kwad.components.ct.detail.photo.d.f.a
                public final void onCancel() {
                }

                @Override // com.kwad.components.ct.detail.photo.d.f.a
                public final void b(d dVar) {
                    if (dVar instanceof com.kwad.components.ct.detail.photo.d.e) {
                        try {
                            if (k.this.aop.aol.alT != null) {
                                k.this.aop.aol.alT.onClickShareButton((String) dVar.getData());
                            }
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                }
            });
            this.awN.a(new i.a() { // from class: com.kwad.components.ct.detail.photo.e.k.3
                @Override // com.kwad.components.ct.detail.photo.d.i.a
                public final void Al() {
                    k.this.aop.aoA = true;
                    com.kwad.components.ct.e.b.JK().ad(k.this.aop.mAdTemplate);
                    k.this.aok.h(false, 3);
                }

                @Override // com.kwad.components.ct.detail.photo.d.i.a
                public final void d(d dVar) {
                    if (dVar instanceof com.kwad.components.ct.detail.photo.d.j) {
                        k.this.BO();
                    } else {
                        k.this.aop.aoA = false;
                        k.this.aok.h(true, 3);
                    }
                }
            });
            this.awN.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO() {
        l lVar = new l(this.aop.mAdTemplate);
        m mVar = this.awO;
        if (mVar == null || !mVar.isShowing()) {
            m mVar2 = new m(getContext(), lVar);
            this.awO = mVar2;
            mVar2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ct.detail.photo.e.k.4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    k.this.aop.aoA = false;
                    k.this.aok.h(true, 3);
                }
            });
            this.awO.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.kwad.components.ct.detail.photo.e.k.5
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    com.kwad.components.ct.e.b.JK().ae(k.this.aop.mAdTemplate);
                }
            });
            this.awO.show();
        }
    }
}
