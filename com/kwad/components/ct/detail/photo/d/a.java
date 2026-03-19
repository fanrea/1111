package com.kwad.components.ct.detail.photo.d;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a<T extends View> extends Presenter implements com.kwad.components.ct.detail.photo.e.d<T> {
    protected g asK = null;
    protected T asL = null;

    @Override // com.kwad.components.ct.detail.photo.e.d
    public Object getData() {
        return null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        Ab();
    }

    private void Ab() {
        ((ViewGroup) getRootView()).addView(Ac());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.asK = (g) amf();
        this.asL.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.asL.setOnClickListener(null);
    }

    private T Ac() {
        if (this.asL == null) {
            this.asL = Ag();
        }
        return this.asL;
    }
}
