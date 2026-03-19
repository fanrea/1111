package com.kwad.sdk.lib.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.proxy.h;
import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a;
import com.kwad.sdk.mvp.Presenter;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class c<PAGE, MODEL> extends h implements a.InterfaceC0618a, b<PAGE> {
    protected RecyclerView Wj;
    protected com.kwad.sdk.lib.widget.a.c<MODEL, ?> aFU;
    private a aRg;
    private RefreshLayout cci;
    private boolean ccj;
    private com.kwad.sdk.lib.a.a.b<PAGE, MODEL> cck;

    protected boolean EU() {
        return false;
    }

    protected int EV() {
        return 1;
    }

    protected abstract com.kwad.sdk.lib.b.c<PAGE, MODEL> EW();

    protected abstract com.kwad.sdk.lib.widget.a.c<MODEL, ?> EX();

    protected RefreshLayout Hs() {
        return null;
    }

    protected void c(Presenter presenter) {
    }

    protected abstract int rN();

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aRg = new a(this, this);
    }

    public final RecyclerView getRecyclerView() {
        return this.Wj;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.Wj = (RecyclerView) this.pQ.findViewById(rN());
        RefreshLayout refreshLayoutHs = Hs();
        this.cci = refreshLayoutHs;
        this.ccj = refreshLayoutHs != null;
        if (this.aRg != null) {
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVarAkI = akI();
            this.cck = bVarAkI;
            this.aRg.J(bVarAkI);
        }
    }

    private com.kwad.sdk.lib.a.a.b<PAGE, MODEL> akI() {
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVarET = ET();
        bVarET.aGE = this;
        bVarET.Wj = this.Wj;
        bVarET.cct = this;
        bVarET.avY = EW();
        this.aFU = EX();
        com.kwad.sdk.lib.widget.a.d dVar = new com.kwad.sdk.lib.widget.a.d(this.aFU);
        bVarET.aFU = this.aFU;
        bVarET.aFW = dVar;
        bVarET.cci = this.cci;
        bVarET.ccu = EV();
        return bVarET;
    }

    @Override // com.kwad.sdk.lib.a.a.InterfaceC0618a
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.sdk.lib.a.b.b(EU()));
        if (this.ccj) {
            presenter.d(new com.kwad.sdk.lib.a.b.d());
        }
        presenter.d(new com.kwad.sdk.lib.a.b.a());
        c(presenter);
        presenter.d(new com.kwad.sdk.lib.a.b.c());
        return presenter;
    }

    protected com.kwad.sdk.lib.a.a.b<PAGE, MODEL> ET() {
        return new com.kwad.sdk.lib.a.a.b<>();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.cck;
        if (bVar == null || bVar.aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = this.cck.aor.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.cck;
        if (bVar == null || bVar.aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = this.cck.aor.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.cck;
        if (bVar == null || bVar.aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = this.cck.aor.iterator();
        while (it.hasNext()) {
            it.next().qC();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.cck;
        if (bVar == null || bVar.aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = this.cck.aor.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.cck;
        if (bVar != null && bVar.aor != null) {
            Iterator<com.kwad.components.core.k.c> it = this.cck.aor.iterator();
            while (it.hasNext()) {
                it.next().onDestroyView();
            }
        }
        com.kwad.sdk.lib.widget.a.c<MODEL, ?> cVar = this.aFU;
        if (cVar != null) {
            cVar.rT();
        }
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.cck;
        if (bVar == null || bVar.aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = this.cck.aor.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }
}
