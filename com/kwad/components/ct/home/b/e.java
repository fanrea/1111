package com.kwad.components.ct.home.b;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.components.ct.request.q;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends a {
    private volatile boolean aIZ = false;
    private l<com.kwad.sdk.core.network.f, CtAdResultData> aJd;
    private final ProfileVideoDetailParam aJl;
    private String mPcursor;
    private int mRequestCount;
    private SceneImpl mSceneImpl;

    static /* synthetic */ int a(e eVar) {
        int i = eVar.mRequestCount;
        eVar.mRequestCount = i + 1;
        return i;
    }

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.aIZ = false;
        return false;
    }

    public e(SceneImpl sceneImpl, ProfileVideoDetailParam profileVideoDetailParam) {
        this.mSceneImpl = sceneImpl;
        this.aJl = profileVideoDetailParam;
    }

    @Override // com.kwad.components.ct.home.b.a
    public final void a(final boolean z, boolean z2, final int i) {
        if (this.aIZ) {
            return;
        }
        this.aIZ = true;
        b(z, z2, i, 0);
        if (g.Gz()) {
            this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.e.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (z) {
                        e.this.aIT.clear();
                    }
                    e.this.aIT.addAll(g.GA());
                    if (!e.this.aIT.isEmpty()) {
                        e eVar = e.this;
                        eVar.mPcursor = eVar.aIT.get(e.this.aIT.size() - 1).mPcursor;
                    }
                    g.GB();
                    e.this.d(z, 0, i);
                    e.a(e.this, false);
                }
            });
            return;
        }
        if (!Gx()) {
            this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.e.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    e.this.u(com.kwad.sdk.core.network.e.bCI.errorCode, com.kwad.sdk.core.network.e.bCI.msg);
                    e.a(e.this, false);
                }
            });
            return;
        }
        final q.a aVar = new q.a();
        aVar.pcursor = this.mPcursor;
        ImpInfo impInfo = new ImpInfo(this.mSceneImpl);
        impInfo.pageScene = this.mSceneImpl.getPageScene();
        aVar.Tk = impInfo;
        aVar.authorId = this.aJl.mAuthorId;
        aVar.tabId = this.aJl.mTabId;
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.aUX = this.mRequestCount;
        aVar.aUG = aVar2;
        l<com.kwad.sdk.core.network.f, CtAdResultData> lVar = new l<com.kwad.sdk.core.network.f, CtAdResultData>() { // from class: com.kwad.components.ct.home.b.e.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Gy, reason: merged with bridge method [inline-methods] */
            public q createRequest() {
                return new q(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(aVar.Tk.adScene);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }
        };
        this.aJd = lVar;
        lVar.request(new o<com.kwad.sdk.core.network.f, CtAdResultData>() { // from class: com.kwad.components.ct.home.b.e.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                f((CtAdResultData) baseResultData);
            }

            private void f(final CtAdResultData ctAdResultData) {
                e.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.e.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (z) {
                            e.this.aIT.clear();
                        }
                        if (e.this.aIT.isEmpty()) {
                            t.abv();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (CtAdTemplate ctAdTemplate : ctAdResultData.getCtAdTemplateList()) {
                            if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                                arrayList.add(ctAdTemplate);
                            }
                        }
                        e.this.aIT.addAll(arrayList);
                        e.this.mPcursor = ctAdResultData.pcursor;
                        e.this.d(z, 0, i);
                        e.a(e.this, false);
                        e.a(e.this);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(com.kwad.sdk.core.network.f fVar, final int i2, final String str) {
                e.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.e.4.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        e.this.u(i2, str);
                        e.a(e.this, false);
                    }
                });
            }
        });
    }

    private boolean Gx() {
        return !"0".equals(this.mPcursor);
    }

    @Override // com.kwad.components.ct.home.b.a, com.kwad.components.ct.api.a.a.a
    public final void release() {
        super.release();
        l<com.kwad.sdk.core.network.f, CtAdResultData> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
        this.aIZ = false;
    }
}
