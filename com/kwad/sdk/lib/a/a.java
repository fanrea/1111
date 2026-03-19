package com.kwad.sdk.lib.a;

import android.os.Bundle;
import android.view.View;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private final KsFragment alG;
    private final InterfaceC0618a ccg;
    private Presenter mPresenter;

    /* renamed from: com.kwad.sdk.lib.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0618a {
        Presenter onCreatePresenter();
    }

    public a(KsFragment ksFragment, InterfaceC0618a interfaceC0618a) {
        this.alG = ksFragment;
        this.ccg = interfaceC0618a;
        KsFragmentManager fragmentManager = ksFragment.getFragmentManager();
        if (fragmentManager != null) {
            a(fragmentManager);
        }
    }

    public final void J(Object obj) {
        Da();
        this.mPresenter.K(obj);
    }

    private void a(KsFragmentManager ksFragmentManager) {
        ksFragmentManager.registerFragmentLifecycleCallbacks(new KsFragmentManager.FragmentLifecycleCallbacks() { // from class: com.kwad.sdk.lib.a.a.1
            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public final void onFragmentViewCreated(KsFragmentManager ksFragmentManager2, KsFragment ksFragment, View view, Bundle bundle) {
                super.onFragmentViewCreated(ksFragmentManager2, ksFragment, view, bundle);
                if (ksFragment == a.this.alG) {
                    a.this.Da();
                }
            }

            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public final void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                super.onFragmentViewDestroyed(ksFragmentManager2, ksFragment);
                if (ksFragment == a.this.alG) {
                    a.this.akH();
                }
            }

            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public final void onFragmentDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                super.onFragmentDestroyed(ksFragmentManager2, ksFragment);
                if (ksFragment == a.this.alG) {
                    ksFragmentManager2.unregisterFragmentLifecycleCallbacks(this);
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da() {
        if (this.mPresenter == null) {
            Presenter presenterOnCreatePresenter = this.ccg.onCreatePresenter();
            this.mPresenter = presenterOnCreatePresenter;
            presenterOnCreatePresenter.ak(this.alG.getView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akH() {
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
    }
}
