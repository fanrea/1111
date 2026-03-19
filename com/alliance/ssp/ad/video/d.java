package com.alliance.ssp.ad.video;

import android.view.View;
import com.alliance.ssp.ad.video.VideoController;

/* compiled from: VideoDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements View.OnClickListener {
    public final /* synthetic */ VideoController.g a;

    public d(e eVar, VideoController.g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar = (c) this.a;
        cVar.b.h();
        VideoController.f fVar = cVar.a;
        if (fVar != null) {
            fVar.a();
        }
    }
}
