package com.kwad.components.ad.draw.presenter.c;

import android.widget.FrameLayout;
import com.kwad.components.ad.l.b;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.draw.b.a {
    private com.kwad.components.ad.l.b fs;
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.presenter.c.b.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.fm.eU != null) {
                b.this.fm.eU.onAdClicked();
            }
        }
    };
    private FrameLayout gO;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gO = (FrameLayout) findViewById(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.l.b bVar = this.fm.fs;
        this.fs = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.gF);
        this.fs.a(this.gO, this.fm.mRootContainer, this.fm.mAdTemplate, this.fm.mApkDownloadHelper);
        this.fs.a((b.InterfaceC0426b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.l.b bVar = this.fs;
        if (bVar != null) {
            bVar.nC();
        }
    }
}
