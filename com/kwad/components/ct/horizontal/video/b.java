package com.kwad.components.ct.horizontal.video;

import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.n;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private String CZ;
    public com.kwad.components.core.video.b NN;
    private long aOG;
    private KsFragment alG;
    private long aww;
    private List<a> azC = new ArrayList();
    private ViewGroup azx;
    private CtAdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;

    public interface a {
        boolean yM();
    }

    public b(KsFragment ksFragment, DetailVideoView detailVideoView, CtAdTemplate ctAdTemplate) {
        this.alG = ksFragment;
        this.mContext = ksFragment.getContext();
        this.mAdTemplate = ctAdTemplate;
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
            this.CZ = com.kwad.sdk.core.response.b.a.L(adInfoEP);
            this.aww = com.kwad.sdk.core.response.b.a.ad(adInfoEP);
        } else {
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
            this.CZ = com.kwad.components.ct.response.a.c.d((PhotoInfo) ctPhotoInfoAy);
            this.aww = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
        }
        this.mDetailVideoView = detailVideoView;
        this.NN = new com.kwad.components.core.video.b(detailVideoView);
        this.azx = (ViewGroup) detailVideoView.getParent().getParent();
    }

    public final boolean isPlaying() {
        return this.NN.isPlaying();
    }

    public final boolean isPreparing() {
        return this.NN.isPreparing();
    }

    public final int getMediaPlayerType() {
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            return bVar.getMediaPlayerType();
        }
        return 0;
    }

    public final void bY(boolean z) {
        com.kwad.sdk.core.d.c.d("HorizontalVideoPlayModule", "createPlayerAndPrepare()");
        this.aOG = SystemClock.elapsedRealtime();
        this.NN.a(new b.a(this.mAdTemplate).ew(CI()).ex(com.kwad.components.ct.response.a.c.e((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR(), false, false, this.mDetailVideoView);
        this.NN.prepareAsync();
    }

    public final long Iu() {
        return this.aOG;
    }

    private String CI() {
        if (com.kwad.components.ct.a.b.xh()) {
            return com.kwad.sdk.core.videocache.c.a.ch(this.mContext.getApplicationContext()).ga(this.CZ);
        }
        return this.CZ;
    }

    public final void resume() {
        boolean z;
        if (this.alG.isResumed()) {
            loop0: while (true) {
                for (a aVar : this.azC) {
                    z = z || aVar.yM();
                }
            }
            if (z) {
                return;
            }
            this.NN.resume();
        }
    }

    public final void start() {
        this.NN.start();
    }

    public final void pause() {
        this.NN.pause();
    }

    public final void seekTo(long j) {
        this.NN.seekTo(j);
    }

    public final void release() {
        bZ(false);
    }

    public final void bZ(boolean z) {
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            bVar.clear();
            if (z && (this.NN.tT() instanceof com.kwad.sdk.core.video.a.b)) {
                this.NN.releaseAsync();
            } else {
                this.NN.release();
            }
        }
    }

    public final void c(n nVar) {
        this.NN.c(nVar);
    }

    public final void d(n nVar) {
        this.NN.d(nVar);
    }

    public final String getCurrentPlayingUrl() {
        return this.NN.getCurrentPlayingUrl();
    }

    public final int getBufferPercentage() {
        return this.NN.getBufferPercentage();
    }
}
