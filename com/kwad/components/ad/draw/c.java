package com.kwad.components.ad.draw;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.p.m;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {
    private KsDrawAd.AdInteractionListener eU;
    private com.kwad.components.ad.draw.view.b eV;
    private com.kwad.components.ad.draw.view.a eW;
    private com.kwad.components.ad.draw.view.c eX;
    private FrameLayout eZ;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private long startTime;
    private boolean eY = false;
    private com.kwad.components.core.internal.api.c dl = new com.kwad.components.core.internal.api.c();
    private final com.kwad.sdk.core.j.b fa = new com.kwad.sdk.core.j.b() { // from class: com.kwad.components.ad.draw.c.2
        @Override // com.kwad.sdk.core.j.b
        public final void aP() {
            c.this.dl.h(c.this);
        }

        @Override // com.kwad.sdk.core.j.b
        public final void aQ() {
            c.this.dl.i(c.this);
        }
    };
    private final KsDrawAd.AdInteractionListener fb = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.3
        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.eU != null) {
                c.this.eU.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.eU != null) {
                c.this.eU.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.eU != null) {
                try {
                    c.this.eU.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.eU != null) {
                try {
                    c.this.eU.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.eU != null) {
                try {
                    c.this.eU.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.eU != null) {
                try {
                    c.this.eU.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.eU != null) {
                try {
                    c.this.eU.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }
    };

    public interface a {
        void aN();

        void aO();
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    public c(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        this.mAdTemplate = adTemplateS;
        AdInfo adInfoEP = e.eP(adTemplateS);
        this.mAdInfo = adInfoEP;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.bA(adInfoEP).getUrl(), this.mAdTemplate);
        com.kwad.components.ad.i.b.fW().a(this);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aV(e.eP(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.Yf()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    public final View getDrawView2(Context context) {
        if (context == null || !l.UL().TT()) {
            return null;
        }
        if (aM()) {
            return this.eZ;
        }
        this.eZ = new FrameLayout(context);
        com.kwad.components.ad.draw.a.c.j(this.mAdTemplate);
        this.startTime = SystemClock.elapsedRealtime();
        try {
            context = m.wrapContextIfNeed(context);
            if (com.kwad.sdk.core.response.b.b.dB(this.mAdTemplate)) {
                a(context, this.eZ);
            } else {
                b(context, this.eZ);
                com.kwad.components.ad.draw.a.c.a(this.mAdTemplate, SystemClock.elapsedRealtime() - this.startTime, 1, 1, true);
            }
        } catch (Throwable th) {
            if (l.UL().TQ()) {
                RuntimeException runtimeException = new RuntimeException("context:" + context.getClass().getName() + "--classloader:" + context.getClass().getClassLoader());
                if (Build.VERSION.SDK_INT >= 19) {
                    runtimeException.addSuppressed(th);
                }
                com.kwad.components.ad.draw.a.c.b(this.mAdTemplate, SystemClock.elapsedRealtime() - this.startTime, th.getMessage());
                com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
            } else {
                throw th;
            }
        }
        if (aM()) {
            return this.eZ;
        }
        return null;
    }

    private boolean aM() {
        FrameLayout frameLayout = this.eZ;
        return frameLayout != null && frameLayout.getChildCount() == 1;
    }

    private void a(final Context context, final ViewGroup viewGroup) {
        if (this.eX == null) {
            com.kwad.components.ad.draw.view.c cVar = new com.kwad.components.ad.draw.view.c(context);
            this.eX = cVar;
            cVar.setPageExitListener(this.fa);
            this.eX.setAdInteractionListener(this.eU);
            this.eX.setTKLoadStateListener(new a() { // from class: com.kwad.components.ad.draw.c.1
                @Override // com.kwad.components.ad.draw.c.a
                public final void aN() {
                    com.kwad.components.ad.draw.a.c.a(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.startTime, 2, 2, false);
                }

                @Override // com.kwad.components.ad.draw.c.a
                public final void aO() {
                    viewGroup.removeAllViews();
                    c.this.b(context, viewGroup);
                    com.kwad.components.ad.draw.a.c.a(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.startTime, 1, 2, true);
                }
            });
            this.eX.c(this.mAdResultData);
        }
        a(viewGroup, this.eX);
    }

    private static void a(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || view.getParent() != null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, ViewGroup viewGroup) {
        if (com.kwad.sdk.core.response.b.a.df(this.mAdInfo)) {
            if (this.eW == null) {
                com.kwad.components.ad.draw.view.a aVar = new com.kwad.components.ad.draw.view.a(context, this.mAdTemplate);
                this.eW = aVar;
                aVar.setPageExitListener(this.fa);
                this.eW.setAdInteractionListener(this.eU);
                this.eW.bD();
            } else {
                com.kwad.sdk.core.d.c.i("KSDrawAdControl", "mDrawAdLiveView is not null");
            }
            a(viewGroup, this.eW);
            return;
        }
        if (this.eV == null) {
            com.kwad.components.ad.draw.view.b bVar = new com.kwad.components.ad.draw.view.b(context);
            this.eV = bVar;
            bVar.setPageExitListener(this.fa);
            this.eV.setAdInteractionListener(this.eU);
            this.eV.l(this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.c.i("KSDrawAdControl", "mDrawVideoView is not null");
        }
        a(viewGroup, this.eV);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.eU = adInteractionListener;
        com.kwad.components.ad.draw.view.b bVar = this.eV;
        if (bVar != null) {
            bVar.setAdInteractionListener(adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.bk(e.eP(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aU(e.eP(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setVideoSoundEnable(boolean z) {
        com.kwad.components.ad.draw.view.b bVar = this.eV;
        if (bVar != null) {
            bVar.setVideoSound(z);
        }
        com.kwad.components.ad.draw.view.a aVar = this.eW;
        if (aVar != null) {
            aVar.setVideoSound(z);
        }
        com.kwad.components.ad.draw.view.c cVar = this.eX;
        if (cVar != null) {
            cVar.setVideoSound(z);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void controlPlayerStatus() {
        this.eY = true;
        com.kwad.components.ad.draw.view.b bVar = this.eV;
        if (bVar != null) {
            bVar.bP();
        }
        com.kwad.components.ad.draw.view.c cVar = this.eX;
        if (cVar != null) {
            cVar.bP();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void play() {
        if (this.eY) {
            com.kwad.components.ad.draw.view.b bVar = this.eV;
            if (bVar != null) {
                bVar.play();
            }
            com.kwad.components.ad.draw.view.c cVar = this.eX;
            if (cVar != null) {
                cVar.A(1);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void pause() {
        if (this.eY) {
            com.kwad.components.ad.draw.view.b bVar = this.eV;
            if (bVar != null) {
                bVar.pause();
            }
            com.kwad.components.ad.draw.view.c cVar = this.eX;
            if (cVar != null) {
                cVar.A(2);
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.dl.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.dl.b(bVar);
    }
}
