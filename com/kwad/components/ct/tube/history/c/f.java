package com.kwad.components.ct.tube.history.c;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.tube.history.b.a {
    private final com.kwad.components.ct.detail.listener.a amS = new com.kwad.components.ct.detail.listener.b() { // from class: com.kwad.components.ct.tube.history.c.f.1
        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
            TubeEpisode tubeEpisodeP = com.kwad.components.ct.response.a.c.p(ctPhotoInfoAy);
            if (com.kwad.components.ct.response.a.c.o(ctPhotoInfoAy)) {
                ArrayList<TubeInfo> arrayList = new ArrayList(f.this.aWQ.avY.getItems());
                for (TubeInfo tubeInfo : arrayList) {
                    tubeInfo.mIsShowTitle = false;
                    f.this.aWQ.aWW = com.kwad.components.ct.tube.history.a.a.Ku();
                    f.this.aWQ.aWX = com.kwad.components.ct.tube.history.a.a.Ku();
                    if (tubeInfo.tubeId == tubeEpisodeP.tubeInfo.tubeId) {
                        tubeInfo.lastWatchTime = System.currentTimeMillis();
                        tubeInfo.watchEpisodeNum = tubeEpisodeP.episodeNumber;
                    }
                }
                Collections.sort(arrayList, new Comparator<TubeInfo>() { // from class: com.kwad.components.ct.tube.history.c.f.1.1
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(TubeInfo tubeInfo2, TubeInfo tubeInfo3) {
                        return a(tubeInfo2, tubeInfo3);
                    }

                    private static int a(TubeInfo tubeInfo2, TubeInfo tubeInfo3) {
                        long j = tubeInfo2.lastWatchTime - tubeInfo3.lastWatchTime;
                        if (j < 0) {
                            return 1;
                        }
                        return j > 0 ? -1 : 0;
                    }
                });
                f.this.aWQ.avY.aB(arrayList);
                f.this.aWQ.Wj.scrollToPosition(0);
            }
        }
    };

    @Override // com.kwad.components.ct.tube.history.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.detail.listener.c.zh().a(this.amS);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.detail.listener.c.zh().b(this.amS);
    }
}
