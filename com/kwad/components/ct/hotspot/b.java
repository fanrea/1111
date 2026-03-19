package com.kwad.components.ct.hotspot;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.HotspotFeedResultData;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.home.b.a {
    private int aIX;
    private boolean aIZ = false;
    private l<com.kwad.components.ct.request.g, HotspotFeedResultData> aJd;
    private final List<HotspotInfo> aPv;
    private HotspotInfo aPw;
    private int mRequestCount;
    private final SceneImpl mScene;

    static /* synthetic */ int a(b bVar, int i) {
        bVar.aIX = 0;
        return 0;
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.aIZ = false;
        return false;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.mRequestCount;
        bVar.mRequestCount = i + 1;
        return i;
    }

    static /* synthetic */ int g(b bVar) {
        int i = bVar.aIX;
        bVar.aIX = i + 1;
        return i;
    }

    public b(SceneImpl sceneImpl, List<HotspotInfo> list, HotspotInfo hotspotInfo) {
        this.mScene = sceneImpl;
        this.aPv = list;
        this.aPw = hotspotInfo;
    }

    @Override // com.kwad.components.ct.home.b.a
    public final void a(final boolean z, boolean z2, final int i) {
        HotspotInfo hotspotInfo;
        if (this.aIZ) {
            return;
        }
        this.aIZ = true;
        b(z, z2, i, this.aIX);
        int i2 = i != 0 ? (i == 1 || i == 2 || i == 3) ? 1 : (i == 5 || i == 6) ? 2 : 0 : 3;
        if (this.aIX < this.aPv.size() && (hotspotInfo = this.aPw) != null) {
            a(z, i2, hotspotInfo, false, i);
        } else {
            this.mHandler.post(new bh() { // from class: com.kwad.components.ct.hotspot.b.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b bVar = b.this;
                    bVar.d(z, bVar.aIX, i);
                    b.this.u(com.kwad.sdk.core.network.e.bCI.errorCode, com.kwad.sdk.core.network.e.bCI.msg);
                    b.a(b.this, false);
                }
            });
        }
    }

    public final void a(HotspotInfo hotspotInfo) {
        if (this.aIZ) {
            return;
        }
        this.aIZ = true;
        b(true, false, 1, this.aIX);
        a(true, 1, hotspotInfo, true, 1);
    }

    private void a(final boolean z, int i, final HotspotInfo hotspotInfo, final boolean z2, final int i2) {
        final k.a aVar = new k.a();
        ImpInfo impInfo = new ImpInfo(this.mScene);
        impInfo.pageScene = this.mScene.getPageScene();
        impInfo.subPageScene = 100L;
        aVar.anZ.add(impInfo);
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.nm = i;
        aVar2.aUX = this.mRequestCount;
        aVar2.aUY = this.aIT.size();
        aVar.aUG = aVar2;
        l<com.kwad.components.ct.request.g, HotspotFeedResultData> lVar = new l<com.kwad.components.ct.request.g, HotspotFeedResultData>() { // from class: com.kwad.components.ct.hotspot.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: IF, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.request.g createRequest() {
                return new com.kwad.components.ct.request.g(aVar, hotspotInfo);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bV, reason: merged with bridge method [inline-methods] */
            public HotspotFeedResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                HotspotFeedResultData hotspotFeedResultData = new HotspotFeedResultData(b.this.mScene, hotspotInfo);
                hotspotFeedResultData.parseJson(jSONObject);
                return hotspotFeedResultData;
            }
        };
        this.aJd = lVar;
        lVar.request(new o<com.kwad.components.ct.request.g, HotspotFeedResultData>() { // from class: com.kwad.components.ct.hotspot.b.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i3, String str) {
                w(i3, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((HotspotFeedResultData) baseResultData);
            }

            private void a(final HotspotFeedResultData hotspotFeedResultData) {
                b.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.hotspot.b.3.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (z) {
                            b.a(b.this, 0);
                            b.this.aIT.clear();
                        }
                        if (b.this.aIT.isEmpty()) {
                            t.abv();
                        }
                        b.this.aIT.addAll(hotspotFeedResultData.adTemplateList);
                        b.this.b(hotspotInfo);
                        b.this.d(z, b.this.aIX, i2);
                        b.f(b.this);
                        b.a(b.this, false);
                        b.g(b.this);
                    }
                });
            }

            private void w(final int i3, final String str) {
                b.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.hotspot.b.3.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        b.this.u(i3, str);
                        b.a(b.this, false);
                        if (z2 || com.kwad.sdk.core.network.e.bCL.errorCode != i3) {
                            return;
                        }
                        b.this.b(hotspotInfo);
                        b.this.bk(false);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.ct.home.b.a, com.kwad.components.ct.api.a.a.a
    public final void release() {
        super.release();
        l<com.kwad.components.ct.request.g, HotspotFeedResultData> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
        this.aIZ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HotspotInfo hotspotInfo) {
        HotspotInfo hotspotInfo2 = this.aPv.get((this.aPv.indexOf(hotspotInfo) + 1) % this.aPv.size());
        List<CtAdTemplate> listXc = xc();
        if (!listXc.isEmpty() && listXc.get(0).photoInfo.mHotspotInfo == hotspotInfo2) {
            this.aPw = null;
        } else {
            this.aPw = hotspotInfo2;
        }
    }
}
