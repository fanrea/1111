package com.kwad.sdk.lib.b;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b<MODEL, PAGE extends BaseResultData> extends a<PAGE, MODEL> {
    private boolean aIZ;
    private l<com.kwad.sdk.core.network.f, PAGE> aJd;
    private boolean aJr;
    private Handler aeI = new Handler(Looper.getMainLooper());
    private boolean ccB;
    private PAGE ccC;

    protected abstract l<com.kwad.sdk.core.network.f, PAGE> Bn();

    protected boolean Bo() {
        return false;
    }

    protected PAGE Bq() {
        return null;
    }

    protected abstract List<MODEL> a(PAGE page, boolean z);

    protected boolean a(PAGE page) {
        return true;
    }

    protected boolean bL(int i) {
        return true;
    }

    @Override // com.kwad.sdk.lib.b.c
    public final void release() {
        l<com.kwad.sdk.core.network.f, PAGE> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
        akM();
    }

    private void akM() {
        this.ccA.akM();
    }

    @Override // com.kwad.sdk.lib.b.c
    public final boolean Gx() {
        return this.aJr;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void refresh() {
        invalidate();
        akN();
    }

    private void invalidate() {
        this.ccB = true;
    }

    @Override // com.kwad.sdk.lib.b.c
    public final void akN() {
        final BaseResultData baseResultDataBq;
        if (this.aIZ) {
            return;
        }
        if (this.aJr || this.ccB) {
            this.aIZ = true;
            if (akO() && Bo() && (baseResultDataBq = Bq()) != null) {
                this.ccA.s(akO(), true);
                this.aeI.post(new bh() { // from class: com.kwad.sdk.lib.b.b.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        b.this.b(baseResultDataBq, true);
                    }
                });
                return;
            }
            l<com.kwad.sdk.core.network.f, PAGE> lVarBn = Bn();
            this.aJd = lVarBn;
            if (lVarBn == null) {
                this.aJr = false;
                this.aIZ = false;
                this.ccB = false;
            } else {
                this.ccA.s(akO(), false);
                this.aJd.request(new o<com.kwad.sdk.core.network.f, PAGE>() { // from class: com.kwad.sdk.lib.b.b.2
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    public final void onSuccess(com.kwad.sdk.core.network.f fVar, final PAGE page) {
                        b.this.aeI.post(new bh() { // from class: com.kwad.sdk.lib.b.b.2.1
                            @Override // com.kwad.sdk.utils.bh
                            public final void doTask() {
                                b.this.b(page, false);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    public final void onError(com.kwad.sdk.core.network.f fVar, final int i, final String str) {
                        b.this.aeI.post(new bh() { // from class: com.kwad.sdk.lib.b.b.2.2
                            @Override // com.kwad.sdk.utils.bh
                            public final void doTask() {
                                b.this.L(i, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private boolean akO() {
        return this.ccC == null || this.ccB;
    }

    public final boolean akP() {
        return this.ccC != null && this.ccB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.b.c
    /* renamed from: akQ, reason: merged with bridge method [inline-methods] */
    public PAGE akR() {
        return this.ccC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PAGE page, boolean z) {
        boolean zAkO = akO();
        this.aJr = a((b<MODEL, PAGE>) page);
        a((b<MODEL, PAGE>) page, this.ccz, z);
        this.ccC = page;
        this.ccA.t(zAkO, z);
        this.aIZ = false;
        this.ccB = false;
        this.aJd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
        com.kwad.sdk.core.d.c.w("BasePageList", "onError: errorCode" + i + "--errorMsg:" + str);
        boolean zAkO = akO();
        this.aJr = bL(i);
        this.aIZ = false;
        this.ccB = false;
        this.aJd = null;
        this.ccA.b(zAkO, i, str);
    }

    private void a(PAGE page, List<MODEL> list, boolean z) {
        if (akO()) {
            list.clear();
        }
        List<MODEL> listA = a(page, z);
        if (listA == null) {
            return;
        }
        list.addAll(listA);
    }
}
