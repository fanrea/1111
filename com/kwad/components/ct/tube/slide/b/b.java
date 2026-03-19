package com.kwad.components.ct.tube.slide.b;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bh;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private l<com.kwad.components.ct.tube.slide.b.c, CtAdResultData> aJd;
    private final AtomicBoolean aYR;
    private final ConcurrentHashMap<Long, c> aYS;
    private final Handler mHandler;

    /* renamed from: com.kwad.components.ct.tube.slide.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0542b {
        void b(List<CtAdTemplate> list, TubeEpisode tubeEpisode);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.aYR = new AtomicBoolean(false);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.aYS = new ConcurrentHashMap<>();
    }

    static class a {
        private static final b aZa = new b(0);
    }

    public static b KX() {
        return a.aZa;
    }

    public final void a(final SceneImpl sceneImpl, KSTubeParamInner kSTubeParamInner, final long j, final int i, final InterfaceC0542b interfaceC0542b) {
        final List<CtAdTemplate> ctAdTemplateList;
        final TubeEpisode tubeEpisodeA;
        if (this.aYR.get()) {
            return;
        }
        this.aYR.set(true);
        c cVar = this.aYS.get(Long.valueOf(j));
        if (cVar != null) {
            for (CtAdResultData ctAdResultData : cVar.aZb.values()) {
                if (ctAdResultData != null && (tubeEpisodeA = com.kwad.components.ct.tube.d.b.a((ctAdTemplateList = ctAdResultData.getCtAdTemplateList()), j, i)) != null) {
                    this.mHandler.post(new bh() { // from class: com.kwad.components.ct.tube.slide.b.b.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            interfaceC0542b.b(ctAdTemplateList, tubeEpisodeA);
                            b.this.aYR.set(false);
                        }
                    });
                    return;
                }
            }
        }
        final g gVarFM = g.abH().fL(kSTubeParamInner.userId).fM(kSTubeParamInner.userName);
        final ImpInfo impInfo = new ImpInfo(sceneImpl);
        impInfo.pageScene = sceneImpl.getPageScene();
        impInfo.subPageScene = 100L;
        final com.kwad.components.ct.tube.channel.home.request.c cVarCM = com.kwad.components.ct.tube.channel.home.request.c.Kr().cP(i).am(j).cN(kSTubeParamInner.freeEpisodeCount).cO(kSTubeParamInner.unlockEpisodeCount).cL(30).cM(1);
        l<com.kwad.components.ct.tube.slide.b.c, CtAdResultData> lVar = new l<com.kwad.components.ct.tube.slide.b.c, CtAdResultData>() { // from class: com.kwad.components.ct.tube.slide.b.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: KW, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.tube.slide.b.c createRequest() {
                return new com.kwad.components.ct.tube.slide.b.c(impInfo, cVarCM, gVarFM);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData2 = new CtAdResultData(sceneImpl);
                ctAdResultData2.parseJson(jSONObject);
                return ctAdResultData2;
            }
        };
        this.aJd = lVar;
        lVar.request(new o<com.kwad.components.ct.tube.slide.b.c, CtAdResultData>() { // from class: com.kwad.components.ct.tube.slide.b.b.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i2, String str) {
                KZ();
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                j((CtAdResultData) baseResultData);
            }

            private void j(final CtAdResultData ctAdResultData2) {
                b.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.tube.slide.b.b.3.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        List<CtAdTemplate> ctAdTemplateList2 = ctAdResultData2.getCtAdTemplateList();
                        if (ap.aF(ctAdTemplateList2)) {
                            b.this.aYR.set(false);
                            return;
                        }
                        TubeEpisode tubeEpisodeA2 = com.kwad.components.ct.tube.d.b.a(ctAdTemplateList2, j, i);
                        if (tubeEpisodeA2 == null) {
                            tubeEpisodeA2 = com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay(ctAdTemplateList2.get(0)));
                        }
                        b.this.a(com.kwad.components.ct.tube.d.b.d(tubeEpisodeA2), com.kwad.components.ct.tube.d.b.e(tubeEpisodeA2), ctAdResultData2);
                        interfaceC0542b.b(ctAdTemplateList2, tubeEpisodeA2);
                        b.this.aYR.set(false);
                    }
                });
            }

            private void KZ() {
                b.this.aYR.set(false);
            }
        });
    }

    public final void KY() {
        this.aYR.set(false);
        l<com.kwad.components.ct.tube.slide.b.c, CtAdResultData> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    public final CtAdResultData e(long j, int i) {
        c cVar = this.aYS.get(Long.valueOf(j));
        if (cVar != null) {
            return cVar.cW(i);
        }
        return null;
    }

    public final void a(long j, int i, CtAdResultData ctAdResultData) {
        c cVarLb = this.aYS.get(Long.valueOf(j));
        if (cVarLb == null) {
            cVarLb = c.Lb();
            this.aYS.put(Long.valueOf(j), cVarLb);
        }
        cVarLb.a(i, ctAdResultData);
    }

    private void an(long j) {
        this.aYS.remove(Long.valueOf(j));
    }

    public final void ao(long j) {
        this.mHandler.removeCallbacksAndMessages(null);
        KY();
        an(j);
    }

    public final List<Integer> ap(long j) {
        c cVar = this.aYS.get(Long.valueOf(j));
        if (cVar == null) {
            return null;
        }
        for (CtAdResultData ctAdResultData : cVar.aZb.values()) {
            if (ctAdResultData != null) {
                List<CtAdTemplate> ctAdTemplateList = ctAdResultData.getCtAdTemplateList();
                if (!ap.aF(ctAdTemplateList)) {
                    return com.kwad.components.ct.response.a.c.s(com.kwad.components.ct.response.a.a.ay(ctAdTemplateList.get(0)));
                }
            }
        }
        return null;
    }

    static class c {
        private final ConcurrentHashMap<Integer, CtAdResultData> aZb = new ConcurrentHashMap<>();

        private c() {
        }

        public static c Lb() {
            return new c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, CtAdResultData ctAdResultData) {
            this.aZb.put(Integer.valueOf(i), ctAdResultData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CtAdResultData cW(int i) {
            return this.aZb.get(Integer.valueOf(i));
        }
    }
}
