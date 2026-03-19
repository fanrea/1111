package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.u.p;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public static void a(KsScene ksScene, final KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        if (!l.UL().TT()) {
            com.kwad.sdk.core.d.c.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.e.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    feedAdListener.onError(com.kwad.sdk.core.network.e.bCy.errorCode, com.kwad.sdk.core.network.e.bCy.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.q(sceneImplCovert);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.B(sceneImplCovert.getAdNum());
        boolean zB = p.tH().b(sceneImplCovert, "loadConfigFeedAd");
        sceneImplCovert.setAdStyle(1);
        KsAdLoadManager.P().a(new a.C0487a().e(new ImpInfo(sceneImplCovert)).aN(zB).a(new AnonymousClass2(feedAdListener, sceneImplCovert, z, jElapsedRealtime)).sK());
    }

    /* renamed from: com.kwad.components.ad.feed.e$2, reason: invalid class name */
    final class AnonymousClass2 extends com.kwad.components.core.request.d {
        final /* synthetic */ SceneImpl dJ;
        final /* synthetic */ KsLoadManager.FeedAdListener ja;
        final /* synthetic */ boolean jb;
        final /* synthetic */ long jc;

        AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z, long j) {
            this.ja = feedAdListener;
            this.dJ = sceneImpl;
            this.jb = z;
            this.jc = j;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
        public final void onError(final int i, final String str) {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    AnonymousClass2.this.ja.onError(i, str);
                }
            });
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            com.kwad.components.ad.feed.monitor.b.e(i, str);
            if (i == com.kwad.sdk.core.network.e.bCt.errorCode || i == com.kwad.sdk.core.network.e.bCy.errorCode) {
                return;
            }
            com.kwad.components.ad.feed.monitor.b.g(i, str);
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
        public final void b(AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.cm();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
                    if (!FeedType.checkTypeValid(adTemplate)) {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.bk(adInfoEP)), FeedType.fromInt(adTemplate.type, adTemplate.defaultType));
                        com.kwad.components.ad.feed.monitor.b.b(com.kwad.sdk.core.response.b.a.bk(adInfoEP), adTemplate.type, adTemplate);
                    } else {
                        adTemplate.mAdScene = this.dJ;
                        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(adInfoEP))) {
                            Pair<Integer, String> pairN = com.kwad.components.ad.feed.monitor.a.n(adTemplate);
                            com.kwad.components.ad.feed.monitor.b.f(((Integer) pairN.first).intValue(), (String) pairN.second);
                        }
                        arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate), this.jb));
                    }
                }
            }
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.b.C(arrayList.size());
            if (arrayList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.e(com.kwad.sdk.core.network.e.bCy.errorCode, com.kwad.sdk.core.network.e.bCy.msg + str);
                onError(com.kwad.sdk.core.network.e.bCy.errorCode, com.kwad.sdk.core.network.e.bCy.msg + str);
                com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onError");
                return;
            }
            com.kwad.sdk.commercial.d.d.h(this.dJ, arrayList.size());
            if (com.kwad.sdk.core.config.e.XC() && (!l.UL().TQ() || (l.UL().TQ() && com.kwad.sdk.core.config.e.XD() == 1))) {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.e.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.jc);
                        KsAdLoadManager.P().b(arrayList);
                        AnonymousClass2.this.ja.onFeedAdLoad(arrayList);
                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.dJ.getPosId(), (List<KsFeedAd>) arrayList);
                    }
                });
            } else {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.e.2.3
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        final int size = arrayList.size();
                        final int[] iArr = {0};
                        for (final KsFeedAd ksFeedAd : arrayList) {
                            final c cVar = (c) ksFeedAd;
                            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                            final int i = com.kwad.sdk.core.response.b.b.dA(cVar.getAdTemplate()) ? 3 : 2;
                            final long jElapsedRealtime = SystemClock.elapsedRealtime();
                            cVar.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                @Override // com.kwad.components.ad.feed.c.a
                                public final void d(int i2, String str2) {
                                    com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                                    com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i2, i, SystemClock.elapsedRealtime() - jElapsedRealtime, str2);
                                    int[] iArr2 = iArr;
                                    int i3 = iArr2[0] + 1;
                                    iArr2[0] = i3;
                                    int i4 = size;
                                    if (i3 == i4) {
                                        com.kwad.components.ad.feed.monitor.b.a(i4, SystemClock.elapsedRealtime() - AnonymousClass2.this.jc);
                                        KsAdLoadManager.P().b(arrayList);
                                        AnonymousClass2.this.ja.onFeedAdLoad(arrayList);
                                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.dJ.getPosId(), (List<KsFeedAd>) arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }
}
