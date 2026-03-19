package com.kwad.components.ct.detail.photo.related.b;

import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.detail.photo.related.a.a {
    private TextView awp;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awp = (TextView) findViewById(R.id.ksad_related_like_count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.awp.setText(bq.bB(com.kwad.components.ct.response.a.a.aH((CtAdTemplate) ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).cdM)));
    }
}
