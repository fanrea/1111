package com.kwad.components.ct.detail.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.glide.request.h;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.detail.b {
    private CtAdTemplate mAdTemplate;
    private ImageView mVideoBlurBg;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mVideoBlurBg = (ImageView) findViewById(R.id.ksad_video_blur_bg);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        String strBe = com.kwad.components.ct.response.a.a.be(ctAdTemplate);
        if (bq.isNullString(strBe)) {
            this.mVideoBlurBg.setVisibility(8);
        } else {
            this.mVideoBlurBg.setVisibility(0);
            bC(strBe);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.glide.c.h(this.aop.aoy).ac(this.mVideoBlurBg);
    }

    private void bC(final String str) {
        com.kwad.sdk.glide.c.h(this.aop.aoy).hh(str).a(new com.kwad.components.ct.b.a(str, this.mAdTemplate)).b(new h<Drawable>() { // from class: com.kwad.components.ct.detail.b.f.1
            @Override // com.kwad.sdk.glide.request.h
            public final /* bridge */ /* synthetic */ boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                return false;
            }

            @Override // com.kwad.sdk.glide.request.h
            public final boolean a(GlideException glideException) {
                com.kwad.components.ct.e.b.JK().a(f.this.aop.mAdTemplate, str);
                return false;
            }
        }).b(this.mVideoBlurBg);
    }
}
