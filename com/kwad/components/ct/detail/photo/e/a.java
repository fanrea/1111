package com.kwad.components.ct.detail.photo.e;

import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a<T extends View> extends com.kwad.components.ct.detail.b implements d<T> {
    protected LinearLayout aul;
    protected T awq = null;

    @Override // com.kwad.components.ct.detail.photo.e.d
    public final Object getData() {
        return null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.aul = (LinearLayout) findViewById(R.id.ksad_photo_detail_bottom_toolbar);
        this.aul.addView(BA(), new LinearLayout.LayoutParams(-2, -2));
        this.aul.setVisibility(0);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
    }

    protected final T BA() {
        if (this.awq == null) {
            this.awq = Ag();
        }
        return this.awq;
    }
}
