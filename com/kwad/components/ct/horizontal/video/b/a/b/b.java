package com.kwad.components.ct.horizontal.video.b.a.b;

import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.video.b.a.a.a {
    private TextView Fa;
    private TextView aLW;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Fa = (TextView) findViewById(R.id.ksad_horizontal_detail_video_related_item_author);
        this.aLW = (TextView) findViewById(R.id.ksad_horizontal_detail_video_related_item_watch_count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM;
        String strAL = com.kwad.components.ct.response.a.a.aL(ctAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.Fa.setText(strAL);
        this.aLW.setText(bq.bC(com.kwad.components.ct.response.a.c.n((PhotoInfo) ctAdTemplate.photoInfo)) + "次");
    }
}
