package com.kwad.components.core.n;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.p.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class d<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Tj;
    public Presenter mPresenter;
    protected ViewGroup pQ;

    protected boolean am() {
        return false;
    }

    protected abstract void ao();

    protected abstract T ap();

    protected abstract int getLayoutId();

    protected abstract void initData();

    public abstract Presenter onCreatePresenter();

    public d(Context context) {
        this(context, null);
    }

    private d(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        if (am()) {
            return;
        }
        qG();
    }

    protected final void qG() {
        initData();
        this.pQ = (ViewGroup) m.inflate(getContext(), getLayoutId(), this);
        ao();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ae() {
        super.ae();
        initMVP();
    }

    private void initMVP() {
        this.Tj = (T) ap();
        if (this.mPresenter == null) {
            Presenter presenterOnCreatePresenter = onCreatePresenter();
            this.mPresenter = presenterOnCreatePresenter;
            presenterOnCreatePresenter.ak(this.pQ);
        }
        this.mPresenter.K(this.Tj);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void af() {
        super.af();
        T t = this.Tj;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
