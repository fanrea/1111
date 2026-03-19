package com.kwad.components.ct.tube.slide.b;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.api.tube.TubeEpisodeHomeParam;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bh;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.home.b.a {
    private l<c, CtAdResultData> aJd;
    private final g aXp;
    private final AtomicBoolean aYK = new AtomicBoolean(false);
    private int aYL;
    private int aYM;
    private int aYN;
    private final TubeEpisodeHomeParam aYk;
    private final ImpInfo amX;
    private final KSTubeParamInner mKSTubeParam;
    private final SceneImpl mScene;

    public a(SceneImpl sceneImpl, TubeEpisodeHomeParam tubeEpisodeHomeParam) {
        this.mScene = sceneImpl;
        this.aYk = tubeEpisodeHomeParam;
        KSTubeParamInner kSTubeParamInner = tubeEpisodeHomeParam.mKSTubeParam;
        this.mKSTubeParam = kSTubeParamInner;
        ImpInfo impInfo = new ImpInfo(sceneImpl);
        this.amX = impInfo;
        impInfo.pageScene = sceneImpl.getPageScene();
        impInfo.subPageScene = 100L;
        this.aXp = g.abH().fL(kSTubeParamInner.userId).fM(kSTubeParamInner.userName);
        this.aYM = 1;
        this.aYL = 1;
    }

    @Override // com.kwad.components.ct.home.b.a, com.kwad.components.ct.api.a.a.a
    public final void t(List<CtAdTemplate> list) {
        super.t(list);
        if (list.isEmpty()) {
            return;
        }
        this.aYL = com.kwad.components.ct.tube.d.b.e(com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay(list.get(0))));
        this.aYM = com.kwad.components.ct.tube.d.b.e(com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay(list.get(list.size() - 1))));
    }

    @Override // com.kwad.components.ct.home.b.a
    public final void a(final boolean z, boolean z2, final int i) {
        if (this.aYK.get()) {
            return;
        }
        if (this.mKSTubeParam.pageMode != 2 || i == 0) {
            if (i == 5 && this.aYM >= com.kwad.components.ct.tube.d.b.cX(this.aYN)) {
                this.mHandler.post(new bh() { // from class: com.kwad.components.ct.tube.slide.b.a.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        a.this.u(e.bCI.errorCode, e.bCI.msg);
                        a.this.aYK.set(false);
                    }
                });
                return;
            }
            final int i2 = 0;
            if (i == 6 && this.aYL <= 1) {
                this.aYK.set(false);
                return;
            }
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    this.aYM = 1;
                    this.aYL = 1;
                    i2 = 1;
                    break;
                case 5:
                    i2 = this.aYM + 1;
                    this.aYM = i2;
                    break;
                case 6:
                    i2 = this.aYL - 1;
                    this.aYL = i2;
                    break;
            }
            com.kwad.sdk.core.d.c.d("DataFetcherTubeImpl", "loadData pcursor= " + i2);
            CtAdResultData ctAdResultDataE = b.KX().e(this.aYk.mTubeId, i2);
            if (ctAdResultDataE != null && ap.aM(ctAdResultDataE.getCtAdTemplateList())) {
                a(i2, z, i, ctAdResultDataE);
                return;
            }
            b(z, z2, i, cV(i2));
            final com.kwad.components.ct.tube.channel.home.request.c cVarCM = com.kwad.components.ct.tube.channel.home.request.c.Kr().am(this.aYk.mTubeId).cN(this.mKSTubeParam.freeEpisodeCount).cO(this.mKSTubeParam.unlockEpisodeCount).cL(30).cM(i2);
            if (i == 0) {
                cVarCM.cP(this.aYk.watchEpisodeNum);
            }
            l<c, CtAdResultData> lVar = new l<c, CtAdResultData>() { // from class: com.kwad.components.ct.tube.slide.b.a.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                /* renamed from: KW, reason: merged with bridge method [inline-methods] */
                public c createRequest() {
                    return new c(a.this.amX, cVarCM, a.this.aXp);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.l
                /* renamed from: bz, reason: merged with bridge method [inline-methods] */
                public CtAdResultData parseData(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    CtAdResultData ctAdResultData = new CtAdResultData(a.this.mScene);
                    ctAdResultData.parseJson(jSONObject);
                    return ctAdResultData;
                }
            };
            this.aJd = lVar;
            lVar.request(new o<c, CtAdResultData>() { // from class: com.kwad.components.ct.tube.slide.b.a.3
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onError(f fVar, int i3, String str) {
                    E(i3, str);
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                    j((CtAdResultData) baseResultData);
                }

                private void j(final CtAdResultData ctAdResultData) {
                    a.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.tube.slide.b.a.3.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            if (ap.aF(ctAdResultData.getCtAdTemplateList())) {
                                a.this.u(e.bCI.errorCode, e.bCI.msg);
                                a.this.aYK.set(false);
                            } else {
                                a.this.a(i2, z, i, ctAdResultData);
                            }
                        }
                    });
                }

                private void E(final int i3, final String str) {
                    a.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.tube.slide.b.a.3.2
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            a.this.u(i3, str);
                            a.this.aYK.set(false);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, int i2, CtAdResultData ctAdResultData) {
        List<CtAdTemplate> ctAdTemplateList = ctAdResultData.getCtAdTemplateList();
        if (z) {
            this.aIT.clear();
        }
        if (this.mKSTubeParam.pageMode == 2) {
            this.aIT.add(V(ctAdTemplateList));
        } else if (6 == i2) {
            this.aIT.addAll(0, ctAdTemplateList);
        } else {
            this.aIT.addAll(ctAdTemplateList);
        }
        TubeEpisode tubeEpisodeP = com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay(ctAdTemplateList.get(0)));
        if (i2 == 0) {
            this.aYN = com.kwad.components.ct.tube.d.b.f(tubeEpisodeP);
            this.aYL = com.kwad.components.ct.tube.d.b.e(tubeEpisodeP);
            this.aYM = com.kwad.components.ct.tube.d.b.e(tubeEpisodeP);
        }
        b.KX().a(com.kwad.components.ct.tube.d.b.d(tubeEpisodeP), com.kwad.components.ct.tube.d.b.e(tubeEpisodeP), ctAdResultData);
        d(z, cV(i), i2);
        this.aYK.set(false);
    }

    private CtAdTemplate V(List<CtAdTemplate> list) {
        for (CtAdTemplate ctAdTemplate : list) {
            if (com.kwad.components.ct.response.a.c.q(com.kwad.components.ct.response.a.a.ay(ctAdTemplate)) == this.aYk.watchEpisodeNum) {
                return ctAdTemplate;
            }
        }
        return list.get(0);
    }

    private static int cV(int i) {
        return Math.max(i - 1, 0);
    }

    @Override // com.kwad.components.ct.home.b.a, com.kwad.components.ct.api.a.a.a
    public final void release() {
        super.release();
        l<c, CtAdResultData> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
        this.aYK.set(false);
    }
}
