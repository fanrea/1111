package com.kwad.components.ad.reward.f;

import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.k.a<j> {
    private IAdLivePlayModule jK;
    private List<j> wr;
    private long ws;
    private AdLivePlayStateListener wt;

    public a(AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule) {
        super(adTemplate);
        this.wr = new CopyOnWriteArrayList();
        this.ws = 30000L;
        this.wt = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(j jVar) {
                        c(jVar);
                    }

                    private static void c(j jVar) {
                        jVar.onMediaPrepared();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j) {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: c, reason: merged with bridge method [inline-methods] */
                    public void accept(j jVar) {
                        jVar.onMediaPlayProgress(a.this.ws, j);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(j jVar) {
                        c(jVar);
                    }

                    private static void c(j jVar) {
                        jVar.onMediaPlayStart();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(j jVar) {
                        c(jVar);
                    }

                    private static void c(j jVar) {
                        jVar.onLivePlayResume();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(j jVar) {
                        c(jVar);
                    }

                    private static void c(j jVar) {
                        jVar.onMediaPlayPaused();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(j jVar) {
                        c(jVar);
                    }

                    private static void c(j jVar) {
                        jVar.onMediaPlayCompleted();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(j jVar) {
                        c(jVar);
                    }

                    private static void c(j jVar) {
                        jVar.onLivePlayEnd();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z) {
                a.this.a(new com.kwad.sdk.g.a<j>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    @Override // com.kwad.sdk.g.a
                    public final /* bridge */ /* synthetic */ void accept(j jVar) {
                    }
                });
            }
        };
        this.jK = iAdLivePlayModule;
        if (e.eJ(adTemplate) == 2) {
            this.ws = com.kwad.sdk.core.response.b.a.ai(e.eP(adTemplate));
        }
        this.jK.registerAdLivePlayStateListener(this.wt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.g.a<j> aVar) {
        if (aVar != null) {
            Iterator<j> it = this.wr.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.jK.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.jK.skipToEnd();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.jK.getPlayDuration();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.jK.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.jK.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.jK.getCurrentShowShopItemInfo();
    }

    public final void onResume() {
        this.jK.onResume();
    }

    public final void onPause() {
        this.jK.onPause();
    }

    private void ii() {
        try {
            this.wr.clear();
            this.jK.unRegisterAdLivePlayStateListener(this.wt);
            this.jK.onDestroy();
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.jK.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(j jVar) {
        if (jVar != null) {
            this.wr.add(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(j jVar) {
        if (jVar != null) {
            this.wr.remove(jVar);
        }
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.jK.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.jK.setAudioEnabled(z, z2);
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        ii();
    }
}
