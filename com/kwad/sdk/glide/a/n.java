package com.kwad.sdk.glide.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class n extends KsFragment {
    private com.kwad.sdk.glide.g bQg;
    private final com.kwad.sdk.glide.a.a bYS;
    private final l bYT;
    private final Set<n> bYU;
    private n bYV;
    private KsFragment bYW;

    public n() {
        this(new com.kwad.sdk.glide.a.a());
    }

    private n(com.kwad.sdk.glide.a.a aVar) {
        this.bYT = new a(this);
        this.bYU = new HashSet();
        this.bYS = aVar;
    }

    public final void c(com.kwad.sdk.glide.g gVar) {
        this.bQg = gVar;
    }

    final com.kwad.sdk.glide.a.a air() {
        return this.bYS;
    }

    public final com.kwad.sdk.glide.g ais() {
        return this.bQg;
    }

    public final l ait() {
        return this.bYT;
    }

    private void a(n nVar) {
        this.bYU.add(nVar);
    }

    private void b(n nVar) {
        this.bYU.remove(nVar);
    }

    final void j(KsFragment ksFragment) {
        this.bYW = ksFragment;
        if (ksFragment == null || ksFragment.getActivity() == null) {
            return;
        }
        b(ksFragment.getFragmentManager(), ksFragment.getActivity());
    }

    private KsFragment aiu() {
        KsFragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.bYW;
    }

    private void b(KsFragmentManager ksFragmentManager, Activity activity) {
        aiv();
        n nVarA = com.kwad.sdk.glide.c.cv(getActivity()).afd().a(ksFragmentManager, activity);
        this.bYV = nVarA;
        if (equals(nVarA)) {
            return;
        }
        this.bYV.a(this);
    }

    private void aiv() {
        n nVar = this.bYV;
        if (nVar != null) {
            nVar.b(this);
            this.bYV = null;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onAttach(Context context) {
        super.onAttach(context);
        try {
            b(getFragmentManager(), getActivity());
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDetach() {
        super.onDetach();
        this.bYW = null;
        aiv();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onStart() {
        super.onStart();
        this.bYS.onStart();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onStop() {
        super.onStop();
        this.bYS.onStop();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        this.bYS.onDestroy();
        aiv();
    }

    public final String toString() {
        return super.toString() + "{parent=" + aiu() + com.alipay.sdk.m.u.i.d;
    }

    static class a implements l {
        private WeakReference<n> bYX;

        a(n nVar) {
            this.bYX = new WeakReference<>(nVar);
        }

        public final String toString() {
            return super.toString() + "{fragment=" + this.bYX.get() + com.alipay.sdk.m.u.i.d;
        }
    }
}
