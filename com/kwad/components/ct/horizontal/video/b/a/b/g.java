package com.kwad.components.ct.horizontal.video.b.a.b;

import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ct.horizontal.video.b.a.a.a {
    private TextView Pc;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Pc = (TextView) findViewById(R.id.ksad_horizontal_detail_video_related_item_title);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Pc.setText(com.kwad.components.ct.response.a.a.aN((CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM));
    }
}
