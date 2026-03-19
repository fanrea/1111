package com.kwad.components.ct.home.d.b;

import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.home.d.a.a {
    private ImageView awj;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awj = (ImageView) findViewById(R.id.ksad_slide_profile_cover);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.home.d.a.b) this.cdN).cdM;
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
        String strG = com.kwad.components.ct.response.a.c.g((PhotoInfo) ctPhotoInfoAy);
        if (bq.isNullString(strG)) {
            strG = com.kwad.components.ct.response.a.c.a(ctPhotoInfoAy);
        }
        if (bq.isNullString(strG)) {
            return;
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.home.d.a.b) this.cdN).alG).hh(strG).a(new com.kwad.components.ct.b.a(strG, ctAdTemplate)).b(this.awj);
    }
}
