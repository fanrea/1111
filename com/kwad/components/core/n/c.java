package com.kwad.components.core.n;

import android.os.Bundle;
import com.kwad.components.core.proxy.h;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends h {
    protected T Tj;
    protected Presenter mPresenter;

    protected abstract T ap();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.Tj = (T) ap();
        if (this.mPresenter == null) {
            Presenter presenterOnCreatePresenter = onCreatePresenter();
            this.mPresenter = presenterOnCreatePresenter;
            presenterOnCreatePresenter.ak(this.pQ);
        }
        this.mPresenter.K(this.Tj);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        T t = this.Tj;
        if (t != null) {
            t.release();
        }
        onActivityDestroy();
    }

    protected void onActivityDestroy() {
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
        this.pQ = null;
    }
}
