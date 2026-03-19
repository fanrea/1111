package com.kwad.components.ct.tube.channel.home.d;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.response.model.tube.TubeInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ct.tube.channel.home.c.a {
    private final com.kwad.components.ct.detail.listener.a amS = new com.kwad.components.ct.detail.listener.b() { // from class: com.kwad.components.ct.tube.channel.home.d.g.1
        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            TubeEpisode tubeEpisodeP;
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
            if (com.kwad.components.ct.response.a.c.o(ctPhotoInfoAy) && (tubeEpisodeP = com.kwad.components.ct.response.a.c.p(ctPhotoInfoAy)) != null) {
                g.this.a(tubeEpisodeP);
            }
        }
    };

    @Override // com.kwad.components.ct.tube.channel.home.c.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.detail.listener.c.zh().a(this.amS);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.detail.listener.c.zh().b(this.amS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeEpisode tubeEpisode) {
        for (TubeInfo tubeInfo : this.aWq.aFU.akS()) {
            if (tubeInfo.tubeId == tubeEpisode.tubeInfo.tubeId) {
                tubeInfo.lastWatchTime = System.currentTimeMillis();
                tubeInfo.watchEpisodeNum = tubeEpisode.episodeNumber;
            }
        }
    }
}
