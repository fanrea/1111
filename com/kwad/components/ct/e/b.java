package com.kwad.components.ct.e;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.core.q.a {
    /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.kwad.components.core.q.a
    public final /* synthetic */ n M(long j) {
        return al(j);
    }

    @Override // com.kwad.components.core.q.a
    public final /* synthetic */ n a(long j, AdTemplate adTemplate, String str) {
        return b(j, adTemplate, str);
    }

    @Override // com.kwad.components.core.q.a
    public final /* synthetic */ n b(long j, AdTemplate adTemplate) {
        return c(j, adTemplate);
    }

    static final class a {
        private static final b aTu = new b(0);
    }

    private b() {
    }

    public static b JK() {
        return a.aTu;
    }

    public static c JL() {
        return new c(0L);
    }

    private static c al(long j) {
        return new c(j);
    }

    public static c c(long j, AdTemplate adTemplate) {
        return new c(j, adTemplate);
    }

    private static c b(long j, AdTemplate adTemplate, String str) {
        return new c(j, adTemplate, str);
    }

    public final void a(CtAdTemplate ctAdTemplate, String str) {
        c cVarC = c(7L, ctAdTemplate);
        cVarC.coverUrl = str;
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, int i, int i2) {
        c cVarC = c(1L, ctAdTemplate);
        if (ctAdTemplate.adFromAdx) {
            cVarC.aTR = 1;
        }
        cVarC.aTz = i;
        cVarC.aTB = i2;
        g.a((n) cVarC, true);
    }

    public final void b(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(130L, ctAdTemplate);
        cVarC.aTR = 1;
        g.a((n) cVarC, true);
    }

    public final void a(CtAdTemplate ctAdTemplate, int i, int i2, int i3) {
        c cVarC = c(1L, ctAdTemplate);
        if (ctAdTemplate.adFromAdx) {
            cVarC.aTR = 1;
        }
        cVarC.aTz = 0;
        cVarC.aTB = i3;
        cVarC.aUa = i2;
        g.a((n) cVarC, true);
    }

    public final void b(CtAdTemplate ctAdTemplate, String str) {
        if (ctAdTemplate.mContentPvReported) {
            return;
        }
        ctAdTemplate.mContentPvReported = true;
        c cVarC = c(20L, ctAdTemplate);
        cVarC.entryId = str;
        g.a((n) cVarC);
    }

    public final void K(CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate.mContentPvReported) {
            return;
        }
        ctAdTemplate.mContentPvReported = true;
        g.a((n) c(20L, ctAdTemplate));
    }

    public final void c(CtAdTemplate ctAdTemplate, int i) {
        if (ctAdTemplate.mContentPvReported) {
            return;
        }
        ctAdTemplate.mContentPvReported = true;
        c cVarC = c(20L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void c(CtAdTemplate ctAdTemplate, String str) {
        if (ctAdTemplate.mContentPvReported) {
            return;
        }
        ctAdTemplate.mContentPvReported = true;
        c cVarC = c(20L, ctAdTemplate);
        cVarC.aUe = str;
        g.a((n) cVarC);
    }

    public final void d(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(21L, ctAdTemplate);
        cVarC.aTO = i;
        g.a((n) cVarC);
    }

    public final void b(CtAdTemplate ctAdTemplate, int i, int i2) {
        c cVarC = c(21L, ctAdTemplate);
        cVarC.aTO = 1;
        cVarC.aUa = i2;
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, int i, String str) {
        c cVarC = c(21L, ctAdTemplate);
        cVarC.aTO = 1;
        cVarC.aUe = str;
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, String str, int i) {
        c cVarC = c(21L, ctAdTemplate);
        cVarC.entryId = str;
        cVarC.aTO = i;
        g.a((n) cVarC);
    }

    public final void c(CtAdTemplate ctAdTemplate, int i, int i2) {
        c cVarC = c(30L, ctAdTemplate);
        cVarC.aTz = 5;
        cVarC.aTy = i2;
        g.a((n) cVarC);
    }

    public final void e(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(110L, ctAdTemplate);
        cVarC.aTy = i;
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, long j, String str, int i) {
        a(ctAdTemplate, j, str, "", i);
    }

    public final void a(CtAdTemplate ctAdTemplate, long j, String str, String str2, int i) {
        c cVarC = c(2L, ctAdTemplate);
        cVarC.aTv = j;
        cVarC.aTK = str;
        cVarC.aTB = i;
        cVarC.bEV = str2;
        cVarC.abm();
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, long j, String str, String str2, int i, int i2) {
        c cVarC = c(58L, ctAdTemplate);
        cVarC.aTv = j;
        cVarC.aTK = str;
        cVarC.aTB = i2;
        cVarC.bEV = str2;
        cVarC.aUa = i;
        cVarC.abm();
        g.a((n) cVarC);
    }

    public final void a(SceneImpl sceneImpl, CtAdTemplate ctAdTemplate, long j, int i, long j2, long j3, int i2, int i3) {
        c cVarC = c(4L, ctAdTemplate);
        cVarC.abm();
        cVarC.adScene = sceneImpl;
        cVarC.adZ = j;
        cVarC.aTA = i;
        cVarC.aTw = j2;
        cVarC.blockDuration = j3;
        cVarC.bET = i2;
        cVarC.aTD = i3;
        g.a((n) cVarC, true);
    }

    public final void a(SceneImpl sceneImpl, CtAdTemplate ctAdTemplate, long j, int i, long j2, long j3, int i2, int i3, int i4, int i5, int i6) {
        c cVarC = c(59L, ctAdTemplate);
        cVarC.abm();
        cVarC.adScene = sceneImpl;
        cVarC.adZ = j;
        cVarC.aTA = i;
        cVarC.aTw = j2;
        cVarC.blockDuration = j3;
        cVarC.bET = i2;
        cVarC.aTD = i3;
        cVarC.aUa = i4;
        cVarC.aUb = i5;
        cVarC.aUc = i6;
        g.a((n) cVarC, true);
    }

    public final void a(CtAdTemplate ctAdTemplate, long j, float f) {
        c cVarC = c(4L, ctAdTemplate);
        cVarC.aTw = j;
        cVarC.aUj = f;
        g.a((n) cVarC, true);
    }

    public final void a(SceneImpl sceneImpl, CtAdTemplate ctAdTemplate, long j, int i) {
        c cVarC = c(5L, ctAdTemplate);
        cVarC.abm();
        cVarC.adScene = sceneImpl;
        cVarC.bEP = j;
        cVarC.aTB = i;
        g.a((n) cVarC);
    }

    public final void a(SceneImpl sceneImpl, CtAdTemplate ctAdTemplate, long j, int i, int i2) {
        c cVarC = c(160L, ctAdTemplate);
        cVarC.abm();
        cVarC.adScene = sceneImpl;
        cVarC.bEP = j;
        cVarC.aTB = i2;
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void f(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(6L, ctAdTemplate);
        cVarC.aTB = i;
        cVarC.abm();
        g.a((n) cVarC);
    }

    public final void d(CtAdTemplate ctAdTemplate, int i, int i2) {
        c cVarC = c(161L, ctAdTemplate);
        cVarC.aTB = i2;
        cVarC.abm();
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void e(CtAdTemplate ctAdTemplate, int i, int i2) {
        c cVarC = c(10011L, ctAdTemplate);
        cVarC.aTB = i2;
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void f(CtAdTemplate ctAdTemplate, int i, int i2) {
        c cVarC = c(3L, ctAdTemplate);
        cVarC.aTC = i;
        cVarC.aTH = i2;
        g.a((n) cVarC);
    }

    public final void b(CtAdTemplate ctAdTemplate, int i, int i2, int i3) {
        c cVarC = c(3L, ctAdTemplate);
        cVarC.aTC = 0;
        cVarC.aTH = 0;
        cVarC.aUa = i3;
        g.a((n) cVarC);
    }

    public final void L(CtAdTemplate ctAdTemplate) {
        g.a((n) c(98L, ctAdTemplate));
    }

    public final void M(CtAdTemplate ctAdTemplate) {
        g.a((n) c(99L, ctAdTemplate));
    }

    public final void g(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(99L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void c(com.kwad.components.ct.response.model.a.a aVar) {
        if (aVar.aQz) {
            return;
        }
        aVar.aQz = true;
        c cVarAl = al(19L);
        cVarAl.entryId = aVar.entryId;
        if (aVar.aVj != null && aVar.aVj.size() > 0) {
            cVarAl.adScene = aVar.aVj.get(0).mAdScene;
        }
        g.a((n) cVarAl);
    }

    public final void N(CtAdTemplate ctAdTemplate) {
        g.a((n) c(9L, ctAdTemplate));
    }

    public final void c(CtAdTemplate ctAdTemplate, boolean z) {
        c cVarC = c(10L, ctAdTemplate);
        cVarC.aTJ = z ? 1 : 2;
        g.a((n) cVarC);
    }

    public final void O(CtAdTemplate ctAdTemplate) {
        g.a((n) c(112L, ctAdTemplate));
    }

    public final void d(CtAdTemplate ctAdTemplate, boolean z) {
        g.a((n) c(z ? 113L : 114L, ctAdTemplate));
    }

    public final void P(CtAdTemplate ctAdTemplate) {
        g.a((n) c(12L, ctAdTemplate));
    }

    public final void Q(CtAdTemplate ctAdTemplate) {
        g.a((n) c(13L, ctAdTemplate));
    }

    public final void c(CtAdTemplate ctAdTemplate, long j) {
        c cVarC = c(14L, ctAdTemplate);
        cVarC.aTM = j;
        g.a((n) cVarC);
    }

    public final void d(CtAdTemplate ctAdTemplate, long j) {
        c cVarC = c(15L, ctAdTemplate);
        cVarC.aTM = j;
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, long j, long j2) {
        c cVarC = c(18L, ctAdTemplate);
        com.kwad.sdk.core.d.c.d("CtBatchReportManager", "stayDuration=" + j2 + " seenCount=" + j);
        cVarC.aTN = j;
        cVarC.aTw = j2;
        g.a((n) cVarC);
    }

    public final void R(CtAdTemplate ctAdTemplate) {
        g.a((n) c(22L, ctAdTemplate));
    }

    public final void S(CtAdTemplate ctAdTemplate) {
        g.a((n) c(23L, ctAdTemplate));
    }

    public final void bY(String str) {
        c cVarAl = al(26L);
        cVarAl.aTL = str;
        g.a((n) cVarAl);
    }

    public final void a(SceneImpl sceneImpl, HotspotInfo hotspotInfo) {
        c cVarAl = al(41L);
        cVarAl.adScene = sceneImpl;
        cVarAl.trendId = hotspotInfo.trendId;
        cVarAl.aTS = hotspotInfo.name;
        g.a((n) cVarAl);
    }

    public final void b(SceneImpl sceneImpl, HotspotInfo hotspotInfo) {
        c cVarAl = al(42L);
        cVarAl.adScene = sceneImpl;
        cVarAl.trendId = hotspotInfo.trendId;
        cVarAl.aTS = hotspotInfo.name;
        g.a((n) cVarAl);
    }

    public final void e(SceneImpl sceneImpl) {
        c cVarAl = al(43L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void c(SceneImpl sceneImpl, HotspotInfo hotspotInfo) {
        if (hotspotInfo.mHotPhotoImpressionReported) {
            return;
        }
        hotspotInfo.mHotPhotoImpressionReported = true;
        c cVarAl = al(44L);
        cVarAl.adScene = sceneImpl;
        cVarAl.trendId = hotspotInfo.trendId;
        cVarAl.aTS = hotspotInfo.name;
        g.a((n) cVarAl);
    }

    public final void d(SceneImpl sceneImpl, HotspotInfo hotspotInfo) {
        c cVarAl = al(45L);
        cVarAl.adScene = sceneImpl;
        cVarAl.trendId = hotspotInfo.trendId;
        cVarAl.aTS = hotspotInfo.name;
        g.a((n) cVarAl);
    }

    public final void b(SceneImpl sceneImpl, int i) {
        c cVarAl = al(46L);
        cVarAl.adScene = sceneImpl;
        cVarAl.closeType = i;
        g.a((n) cVarAl);
    }

    public final void c(SceneImpl sceneImpl, String str) {
        c cVarAl = al(36L);
        cVarAl.adScene = sceneImpl;
        cVarAl.tabName = str;
        g.a((n) cVarAl);
    }

    public final void f(SceneImpl sceneImpl) {
        com.kwad.sdk.core.scene.b.abP().s(sceneImpl);
        c cVarAl = al(27L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void a(SceneImpl sceneImpl, com.kwad.sdk.g.a<c> aVar) {
        com.kwad.sdk.core.scene.b.abP().s(sceneImpl);
        c cVarAl = al(27L);
        cVarAl.adScene = sceneImpl;
        if (aVar != null) {
            aVar.accept(cVarAl);
        }
        g.a((n) cVarAl);
    }

    public final void a(SceneImpl sceneImpl, long j) {
        c cVarAl = al(28L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aTx = j;
        g.a((n) cVarAl);
    }

    public final void a(SceneImpl sceneImpl, long j, com.kwad.sdk.g.a<c> aVar) {
        c cVarAl = al(28L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aTx = j;
        if (aVar != null) {
            aVar.accept(cVarAl);
        }
        g.a((n) cVarAl);
    }

    public final void g(SceneImpl sceneImpl) {
        com.kwad.sdk.core.scene.b.abP().s(sceneImpl);
        c cVarAl = al(29L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void b(SceneImpl sceneImpl, com.kwad.sdk.g.a<c> aVar) {
        com.kwad.sdk.core.scene.b.abP().s(sceneImpl);
        c cVarAl = al(29L);
        cVarAl.adScene = sceneImpl;
        if (aVar != null) {
            aVar.accept(cVarAl);
        }
        g.a((n) cVarAl);
    }

    public final void c(SceneImpl sceneImpl, int i) {
        com.kwad.sdk.core.scene.b.abP().s(sceneImpl);
        c cVarAl = al(27L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aUa = i;
        g.a((n) cVarAl);
    }

    public final void a(SceneImpl sceneImpl, long j, int i) {
        c cVarAl = al(28L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aTx = j;
        cVarAl.aUa = i;
        g.a((n) cVarAl);
    }

    public final void d(SceneImpl sceneImpl, int i) {
        com.kwad.sdk.core.scene.b.abP().s(sceneImpl);
        c cVarAl = al(29L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aUa = i;
        g.a((n) cVarAl);
    }

    public final void T(CtAdTemplate ctAdTemplate) {
        g.a((n) c(222L, ctAdTemplate));
    }

    public final void U(CtAdTemplate ctAdTemplate) {
        g.a((n) c(223L, ctAdTemplate));
    }

    public final void a(SceneImpl sceneImpl, TubeEpisode tubeEpisode) {
        c cVarAl = al(224L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aTQ = tubeEpisode.locked;
        cVarAl.episodeName = tubeEpisode.episodeName;
        cVarAl.episodeNumber = tubeEpisode.episodeNumber;
        a(cVarAl, tubeEpisode.tubeInfo);
        g.a((n) cVarAl);
    }

    public final void a(SceneImpl sceneImpl, TubeInfo tubeInfo) {
        c cVarAl = al(20L);
        cVarAl.adScene = sceneImpl;
        a(cVarAl, tubeInfo);
        g.a((n) cVarAl);
    }

    public final void b(SceneImpl sceneImpl, TubeInfo tubeInfo) {
        c cVarAl = al(21L);
        cVarAl.adScene = sceneImpl;
        a(cVarAl, tubeInfo);
        g.a((n) cVarAl);
    }

    public final void V(CtAdTemplate ctAdTemplate) {
        g.a((n) c(20L, ctAdTemplate));
    }

    public final void JM() {
        g.a((n) al(21L));
    }

    public final void W(CtAdTemplate ctAdTemplate) {
        g.a((n) c(35L, ctAdTemplate));
    }

    public final void h(SceneImpl sceneImpl) {
        c cVarAl = al(35L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void i(SceneImpl sceneImpl) {
        c cVarAl = al(48L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void X(CtAdTemplate ctAdTemplate) {
        g.a((n) c(49L, ctAdTemplate));
    }

    public final void Y(CtAdTemplate ctAdTemplate) {
        g.a((n) c(50L, ctAdTemplate));
    }

    public final void e(SceneImpl sceneImpl, int i) {
        c cVarAl = al(52L);
        cVarAl.adScene = sceneImpl;
        cVarAl.afw = i;
        g.a((n) cVarAl);
    }

    public final void h(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(53L, ctAdTemplate);
        cVarC.aTP = i;
        g.a((n) cVarC);
    }

    public final void Z(CtAdTemplate ctAdTemplate) {
        g.a((n) c(54L, ctAdTemplate));
    }

    public final void aa(CtAdTemplate ctAdTemplate) {
        g.a((n) c(93L, ctAdTemplate));
    }

    public final void M(List<CtAdTemplate> list) {
        c cVarAl = al(55L);
        cVarAl.aUd = N(list);
        g.a((n) cVarAl);
    }

    private static JSONArray N(List<CtAdTemplate> list) {
        JSONArray jSONArray = new JSONArray();
        for (CtAdTemplate ctAdTemplate : list) {
            if (ctAdTemplate != null) {
                JSONObject jSONObject = new JSONObject();
                aa.putValue(jSONObject, "photoId", com.kwad.components.ct.response.a.a.bg(ctAdTemplate));
                aa.putValue(jSONObject, "posId", ctAdTemplate.posId);
                aa.a(jSONArray, jSONObject);
            }
        }
        return jSONArray;
    }

    public final void ab(CtAdTemplate ctAdTemplate) {
        g.a((n) c(72L, ctAdTemplate));
    }

    public final void ac(CtAdTemplate ctAdTemplate) {
        g.a((n) c(73L, ctAdTemplate));
    }

    public final void ad(CtAdTemplate ctAdTemplate) {
        g.a((n) c(74L, ctAdTemplate));
    }

    public final void ae(CtAdTemplate ctAdTemplate) {
        g.a((n) c(75L, ctAdTemplate));
    }

    public final void af(CtAdTemplate ctAdTemplate) {
        g.a((n) c(124L, ctAdTemplate));
    }

    public final void ag(CtAdTemplate ctAdTemplate) {
        g.a((n) c(80L, ctAdTemplate));
    }

    public final void ah(CtAdTemplate ctAdTemplate) {
        g.a((n) c(81L, ctAdTemplate));
    }

    public final void i(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(102L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void j(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(101L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void k(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(10010L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void l(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(111L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void ai(CtAdTemplate ctAdTemplate) {
        g.a((n) c(82L, ctAdTemplate));
    }

    public final void m(CtAdTemplate ctAdTemplate, int i) {
        g.a((n) c(i, ctAdTemplate));
    }

    public final void n(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(162L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void o(CtAdTemplate ctAdTemplate, int i) {
        if (ctAdTemplate.mHorizontalFeedSuggestPvReported) {
            return;
        }
        ctAdTemplate.mHorizontalFeedSuggestPvReported = true;
        c cVarC = c(84L, ctAdTemplate);
        cVarC.aUa = i;
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2) {
        if (ctAdTemplate.mRelatedContentPvReported) {
            return;
        }
        ctAdTemplate.mRelatedContentPvReported = true;
        c cVarC = c(77L, ctAdTemplate);
        cVarC.aTY = com.kwad.components.ct.response.a.a.bg(ctAdTemplate2);
        cVarC.aTZ = com.kwad.components.ct.response.a.a.bh(ctAdTemplate2);
        g.a((n) cVarC);
    }

    public final void b(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2) {
        if (ctAdTemplate.mHorizontalRelatedSuggestPvReported) {
            return;
        }
        ctAdTemplate.mHorizontalRelatedSuggestPvReported = true;
        c cVarC = c(79L, ctAdTemplate);
        cVarC.aTY = com.kwad.components.ct.response.a.a.bg(ctAdTemplate2);
        cVarC.aTZ = com.kwad.components.ct.response.a.a.bh(ctAdTemplate2);
        g.a((n) cVarC);
    }

    public final void c(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2) {
        c cVarC = c(78L, ctAdTemplate);
        cVarC.aTY = com.kwad.components.ct.response.a.a.bg(ctAdTemplate2);
        cVarC.aTZ = com.kwad.components.ct.response.a.a.bh(ctAdTemplate2);
        g.a((n) cVarC);
    }

    public final void a(CtAdTemplate ctAdTemplate, int i, long j, long j2, int i2) {
        c cVarC = c(103L, ctAdTemplate);
        cVarC.aTE = i;
        cVarC.aTF = j;
        cVarC.aTG = j2;
        cVarC.aUa = i2;
        g.a((n) cVarC);
    }

    public final void p(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(76L, ctAdTemplate);
        cVarC.aTI = i;
        g.a((n) cVarC);
    }

    public final void q(CtAdTemplate ctAdTemplate, int i) {
        c cVarC = c(83L, ctAdTemplate);
        cVarC.aUf = i;
        g.a((n) cVarC);
    }

    public final void aj(CtAdTemplate ctAdTemplate) {
        g.a((n) c(88L, ctAdTemplate));
    }

    public final void ak(CtAdTemplate ctAdTemplate) {
        g.a((n) c(89L, ctAdTemplate));
    }

    public final void al(CtAdTemplate ctAdTemplate) {
        g.a((n) c(90L, ctAdTemplate));
    }

    public final void am(CtAdTemplate ctAdTemplate) {
        g.a((n) c(91L, ctAdTemplate));
    }

    public final void an(CtAdTemplate ctAdTemplate) {
        g.a((n) c(92L, ctAdTemplate));
    }

    public final void ao(CtAdTemplate ctAdTemplate) {
        g.a((n) c(85L, ctAdTemplate));
    }

    public final void e(CtAdTemplate ctAdTemplate, boolean z) {
        c cVarC = c(86L, ctAdTemplate);
        cVarC.aTJ = z ? 1 : 2;
        g.a((n) cVarC);
    }

    public final void bZ(String str) {
        c cVarAl = al(87L);
        cVarAl.aUg = str;
        g.a((n) cVarAl);
    }

    public final void d(com.kwad.components.ct.response.model.a.a aVar) {
        c cVarAl = al(106L);
        cVarAl.entryId = aVar.entryId;
        if (aVar.aVj != null && aVar.aVj.size() > 0) {
            cVarAl.adScene = aVar.aVj.get(0).mAdScene;
        }
        g.a((n) cVarAl);
    }

    public final void a(com.kwad.components.ct.response.model.a.a aVar, int i) {
        c cVarAl = al(105L);
        cVarAl.entryId = aVar.entryId;
        if (aVar.aVj != null && aVar.aVj.size() > 0) {
            cVarAl.adScene = aVar.aVj.get(0).mAdScene;
        }
        cVarAl.aTO = i;
        g.a((n) cVarAl);
    }

    public final void a(com.kwad.components.ct.response.model.a.a aVar, boolean z) {
        c cVarAl = al(12100L);
        cVarAl.aUh = z ? 1 : 0;
        cVarAl.entryId = aVar.entryId;
        if (aVar.aVj != null && aVar.aVj.size() > 0) {
            cVarAl.adScene = aVar.aVj.get(0).mAdScene;
        }
        g.a((n) cVarAl);
    }

    public final void j(SceneImpl sceneImpl) {
        c cVarAl = al(176L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void f(SceneImpl sceneImpl, int i) {
        c cVarAl = al(177L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aUi = i;
        g.a((n) cVarAl);
    }

    public final void g(SceneImpl sceneImpl, int i) {
        c cVarAl = al(178L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aUi = i;
        g.a((n) cVarAl);
    }

    public final void JN() {
        g.a((n) al(185L));
    }

    public final void JO() {
        g.a((n) al(120L));
    }

    public final void JP() {
        g.a((n) al(121L));
    }

    public final void JQ() {
        g.a((n) al(198L));
    }

    public final void JR() {
        g.a((n) al(199L));
    }

    public final void d(SceneImpl sceneImpl, String str) {
        c cVarAl = al(125L);
        cVarAl.adScene = sceneImpl;
        cVarAl.aUk = str;
        g.a((n) cVarAl);
    }

    public final void k(SceneImpl sceneImpl) {
        c cVarAl = al(122L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void l(SceneImpl sceneImpl) {
        c cVarAl = al(150L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void m(SceneImpl sceneImpl) {
        c cVarAl = al(151L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void n(SceneImpl sceneImpl) {
        c cVarAl = al(152L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    public final void o(SceneImpl sceneImpl) {
        c cVarAl = al(153L);
        cVarAl.adScene = sceneImpl;
        g.a((n) cVarAl);
    }

    private static void a(c cVar, TubeInfo tubeInfo) {
        if (cVar == null || tubeInfo == null) {
            return;
        }
        cVar.tubeId = tubeInfo.tubeId;
        cVar.tubeName = tubeInfo.name;
        cVar.authorId = tubeInfo.authorId;
    }
}
