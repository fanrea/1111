package com.kwad.components.ct.tube.a;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.detail.request.ChannelDetailResultData;
import com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData;
import com.kwad.components.ct.tube.channel.home.request.c;
import com.kwad.components.ct.tube.history.d.b;
import com.kwad.sdk.api.tube.KSTubeChannelData;
import com.kwad.sdk.api.tube.detail.KSTubeEpisodeLoadListener;
import com.kwad.sdk.api.tube.detail.KSTubeEpisodeResult;
import com.kwad.sdk.api.tube.log.KSTubeLog;
import com.kwad.sdk.api.tube.request.KSTubeLoadListener;
import com.kwad.sdk.api.tube.request.KSTubeResult;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private final SceneImpl aVE;
    private final SceneImpl aVF;
    private final SceneImpl aVG;
    private volatile boolean aVH;
    private final boolean aVx;
    private final KSTubeParamInner mTubeParam;

    public a(long j, KSTubeParamInner kSTubeParamInner, boolean z) {
        this.mTubeParam = kSTubeParamInner;
        this.aVE = new SceneImpl(j).setUrlPackage(new URLPackage(25));
        this.aVF = new SceneImpl(j).setUrlPackage(new URLPackage(33));
        this.aVG = new SceneImpl(j).setUrlPackage(new URLPackage(5));
        this.aVx = z;
    }

    public final void requestTube(int i, int i2, KSTubeLoadListener kSTubeLoadListener) {
        if (kSTubeLoadListener == null || this.aVH) {
            return;
        }
        if (this.aVx) {
            kSTubeLoadListener.onError(e.bCG.errorCode, e.bCG.msg);
            return;
        }
        int iMax = Math.max(i, 1);
        a(c.Kr().cR(1).cN(this.mTubeParam.freeEpisodeCount).cO(this.mTubeParam.unlockEpisodeCount).cM(iMax).cL(Math.min(Math.max(1, i2), 30)), kSTubeLoadListener);
    }

    public final void requestTube(List<Long> list, KSTubeLoadListener kSTubeLoadListener) {
        if (ap.aF(list) || kSTubeLoadListener == null || this.aVH) {
            return;
        }
        if (this.aVx) {
            kSTubeLoadListener.onError(e.bCG.errorCode, e.bCG.msg);
        } else {
            a(c.Kr().cR(1).cN(this.mTubeParam.freeEpisodeCount).cO(this.mTubeParam.unlockEpisodeCount).T(list), kSTubeLoadListener);
        }
    }

    public final void a(int i, int i2, final KSTubeLoadListener kSTubeLoadListener) {
        if (kSTubeLoadListener == null || this.aVH) {
            return;
        }
        if (this.aVx) {
            kSTubeLoadListener.onError(e.bCG.errorCode, e.bCG.msg);
            return;
        }
        final c cVarCM = c.Kr().cR(1).cN(this.mTubeParam.freeEpisodeCount).cO(this.mTubeParam.unlockEpisodeCount).cL(Math.min(Math.max(1, i2), 30)).cM(Math.max(i, 1));
        final ImpInfo impInfo = new ImpInfo(this.aVE);
        impInfo.pageScene = this.aVE.getPageScene();
        final g gVarFM = g.abH().fL(this.mTubeParam.userId).fM(this.mTubeParam.userName);
        new l<f, ChannelDetailResultData>() { // from class: com.kwad.components.ct.tube.a.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: ce, reason: merged with bridge method [inline-methods] */
            public ChannelDetailResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ChannelDetailResultData channelDetailResultData = new ChannelDetailResultData(a.this.aVF);
                channelDetailResultData.parseJson(jSONObject);
                return channelDetailResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final f createRequest() {
                return new b(impInfo, cVarCM, gVarFM);
            }
        }.request(new o<f, ChannelDetailResultData>() { // from class: com.kwad.components.ct.tube.a.a.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                a((ChannelDetailResultData) baseResultData);
            }

            private void a(ChannelDetailResultData channelDetailResultData) {
                if (a.this.aVH) {
                    return;
                }
                final KSTubeResult kSTubeResultObtain = KSTubeResult.obtain();
                Iterator<TubeInfo> it = channelDetailResultData.tubes.iterator();
                while (it.hasNext()) {
                    kSTubeResultObtain.tubeList.add(com.kwad.components.ct.tube.d.b.g(it.next()));
                }
                kSTubeResultObtain.hasMore = channelDetailResultData.hasMore;
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ct.tube.a.a.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.aVH) {
                            return;
                        }
                        kSTubeLoadListener.onSuccess(kSTubeResultObtain);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(f fVar, final int i3, final String str) {
                if (a.this.aVH) {
                    return;
                }
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ct.tube.a.a.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.aVH) {
                            return;
                        }
                        kSTubeLoadListener.onError(i3, str);
                    }
                });
            }
        });
    }

    public final void requestTubeEpisode(final KSTubeChannelData kSTubeChannelData, int i, final KSTubeEpisodeLoadListener kSTubeEpisodeLoadListener) {
        if (kSTubeEpisodeLoadListener == null || this.aVH) {
            return;
        }
        if (this.aVx) {
            kSTubeEpisodeLoadListener.onError(e.bCG.errorCode, e.bCG.msg);
            return;
        }
        final int iMax = Math.max(i, 1);
        CtAdResultData ctAdResultDataE = com.kwad.components.ct.tube.slide.b.b.KX().e(kSTubeChannelData.getTubeId(), iMax);
        if (ctAdResultDataE != null && ap.aM(ctAdResultDataE.getCtAdTemplateList())) {
            a(ctAdResultDataE, kSTubeEpisodeLoadListener);
            return;
        }
        final c cVarCM = c.Kr().cR(1).am(kSTubeChannelData.getTubeId()).cN(this.mTubeParam.freeEpisodeCount).cO(this.mTubeParam.unlockEpisodeCount).cL(iMax).cM(30);
        final ImpInfo impInfo = new ImpInfo(this.aVE);
        impInfo.pageScene = this.aVE.getPageScene();
        final g gVarFM = g.abH().fL(this.mTubeParam.userId).fM(this.mTubeParam.userName);
        new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.tube.a.a.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(a.this.aVG);
                ctAdResultData.parseJson(jSONObject);
                com.kwad.components.ct.tube.slide.b.b.KX().a(kSTubeChannelData.getTubeId(), iMax, ctAdResultData);
                return ctAdResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final f createRequest() {
                return new com.kwad.components.ct.tube.slide.b.c(impInfo, cVarCM, gVarFM);
            }
        }.request(new o<f, CtAdResultData>() { // from class: com.kwad.components.ct.tube.a.a.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                f((CtAdResultData) baseResultData);
            }

            private void f(CtAdResultData ctAdResultData) {
                a.this.a(ctAdResultData, kSTubeEpisodeLoadListener);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(f fVar, final int i2, final String str) {
                if (a.this.aVH) {
                    return;
                }
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ct.tube.a.a.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.aVH) {
                            return;
                        }
                        kSTubeEpisodeLoadListener.onError(i2, str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CtAdResultData ctAdResultData, final KSTubeEpisodeLoadListener kSTubeEpisodeLoadListener) {
        if (this.aVH) {
            return;
        }
        final KSTubeEpisodeResult kSTubeEpisodeResultObtain = KSTubeEpisodeResult.obtain();
        Iterator<CtAdTemplate> it = ctAdResultData.getCtAdTemplateList().iterator();
        while (it.hasNext()) {
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(it.next());
            if (com.kwad.components.ct.response.a.c.o(ctPhotoInfoAy)) {
                kSTubeEpisodeResultObtain.tubeEpisodeList.add(com.kwad.components.ct.tube.d.b.L(ctPhotoInfoAy));
            }
        }
        kSTubeEpisodeResultObtain.hasMore = ctAdResultData.hasMore;
        bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ct.tube.a.a.5
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.aVH) {
                    return;
                }
                kSTubeEpisodeLoadListener.onSuccess(kSTubeEpisodeResultObtain);
            }
        });
    }

    public final void destroy() {
        this.aVH = true;
    }

    private void a(final c cVar, final KSTubeLoadListener kSTubeLoadListener) {
        if (kSTubeLoadListener == null || this.aVH) {
            return;
        }
        new l<f, TubeChannelResultData>() { // from class: com.kwad.components.ct.tube.a.a.6
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: cf, reason: merged with bridge method [inline-methods] */
            public TubeChannelResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeChannelResultData tubeChannelResultData = new TubeChannelResultData(a.this.aVE);
                tubeChannelResultData.parseJson(jSONObject);
                return tubeChannelResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final f createRequest() {
                ImpInfo impInfo = new ImpInfo(a.this.aVE);
                impInfo.pageScene = a.this.aVE.getPageScene();
                return new com.kwad.components.ct.tube.channel.home.request.b(impInfo, cVar, g.abH().fL(a.this.mTubeParam.userId).fM(a.this.mTubeParam.userName));
            }
        }.request(new o<f, TubeChannelResultData>() { // from class: com.kwad.components.ct.tube.a.a.7
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                a((TubeChannelResultData) baseResultData);
            }

            private void a(TubeChannelResultData tubeChannelResultData) {
                if (a.this.aVH) {
                    return;
                }
                final KSTubeResult kSTubeResultObtain = KSTubeResult.obtain();
                Iterator<TubeInfo> it = tubeChannelResultData.recommendTubeChannel.tubes.iterator();
                while (it.hasNext()) {
                    kSTubeResultObtain.tubeList.add(com.kwad.components.ct.tube.d.b.g(it.next()));
                }
                kSTubeResultObtain.hasMore = tubeChannelResultData.hasMore;
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ct.tube.a.a.7.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.aVH) {
                            return;
                        }
                        kSTubeLoadListener.onSuccess(kSTubeResultObtain);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(f fVar, final int i, final String str) {
                if (a.this.aVH) {
                    return;
                }
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ct.tube.a.a.7.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.aVH) {
                            return;
                        }
                        kSTubeLoadListener.onError(i, str);
                    }
                });
            }
        });
    }

    public final void reportKSTubeLog(KSTubeLog kSTubeLog) {
        if (kSTubeLog == null) {
            return;
        }
        int tubePageType = kSTubeLog.getTubePageType();
        com.kwad.components.ct.e.b.JK();
        com.kwad.components.ct.e.c cVarJL = com.kwad.components.ct.e.b.JL();
        cVarJL.aUm = 1;
        switch (tubePageType) {
            case 1:
                cVarJL.actionType = 27L;
                cVarJL.adScene = this.aVE;
                break;
            case 2:
                cVarJL.actionType = 20L;
                cVarJL.adScene = this.aVE;
                a(cVarJL, kSTubeLog.getKSTubeChannelData());
                break;
            case 3:
                cVarJL.actionType = 21L;
                cVarJL.adScene = this.aVE;
                a(cVarJL, kSTubeLog.getKSTubeChannelData());
                break;
            case 4:
                cVarJL.actionType = 27L;
                cVarJL.adScene = this.aVF;
                break;
            case 5:
                cVarJL.actionType = 20L;
                cVarJL.adScene = this.aVF;
                a(cVarJL, kSTubeLog.getKSTubeChannelData());
                break;
            case 6:
                cVarJL.actionType = 21L;
                cVarJL.adScene = this.aVF;
                a(cVarJL, kSTubeLog.getKSTubeChannelData());
                break;
        }
        com.kwad.sdk.core.report.g.a((n) cVarJL);
    }

    private static void a(com.kwad.components.ct.e.c cVar, KSTubeChannelData kSTubeChannelData) {
        if (kSTubeChannelData != null) {
            cVar.tubeId = kSTubeChannelData.getTubeId();
            cVar.tubeName = kSTubeChannelData.getTubeName();
            try {
                cVar.authorId = Integer.parseInt(kSTubeChannelData.getAuthorId());
            } catch (Throwable unused) {
            }
        }
    }
}
