package com.kwad.components.ct.home.b;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.related.RelatedVideoDetailParam;
import com.kwad.components.ct.request.p;
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
public final class f extends a {
    private l<com.kwad.sdk.core.network.f, CtAdResultData> aJd;
    private RelatedVideoDetailParam aJq;
    private int mRequestCount;
    private SceneImpl mSceneImpl;
    private boolean aIZ = false;
    private boolean aJr = true;

    static /* synthetic */ boolean a(f fVar, boolean z) {
        fVar.aIZ = false;
        return false;
    }

    static /* synthetic */ int b(f fVar) {
        int i = fVar.mRequestCount;
        fVar.mRequestCount = i + 1;
        return i;
    }

    static /* synthetic */ boolean b(f fVar, boolean z) {
        fVar.aJr = false;
        return false;
    }

    public f(SceneImpl sceneImpl, RelatedVideoDetailParam relatedVideoDetailParam) {
        this.mSceneImpl = sceneImpl;
        this.aJq = relatedVideoDetailParam;
    }

    @Override // com.kwad.components.ct.home.b.a
    public final void a(final boolean z, boolean z2, final int i) {
        if (this.aIZ) {
            return;
        }
        this.aIZ = true;
        b(z, z2, i, 0);
        if (g.Gz()) {
            this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.f.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (z) {
                        f.this.aIT.clear();
                    }
                    if (f.this.aIT.isEmpty()) {
                        t.abv();
                    }
                    f.this.aIT.addAll(g.GA());
                    g.GB();
                    f.this.d(z, 0, i);
                    f.a(f.this, false);
                }
            });
            return;
        }
        if (!Gx()) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ct.home.b.f.2
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.u(com.kwad.sdk.core.network.e.bCI.errorCode, com.kwad.sdk.core.network.e.bCI.msg);
                    f.a(f.this, false);
                }
            });
            return;
        }
        final p.a aVar = new p.a();
        ImpInfo impInfo = new ImpInfo(this.mSceneImpl);
        impInfo.pageScene = this.mSceneImpl.getPageScene();
        aVar.Tk = impInfo;
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.aUX = this.mRequestCount;
        aVar.aUG = aVar2;
        aVar.aUV = this.aJq.mSourcePhotoId;
        l<com.kwad.sdk.core.network.f, CtAdResultData> lVar = new l<com.kwad.sdk.core.network.f, CtAdResultData>() { // from class: com.kwad.components.ct.home.b.f.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(f.this.mSceneImpl);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final com.kwad.sdk.core.network.f createRequest() {
                return new p(aVar);
            }
        };
        this.aJd = lVar;
        lVar.request(new o<com.kwad.sdk.core.network.f, CtAdResultData>() { // from class: com.kwad.components.ct.home.b.f.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                f((CtAdResultData) baseResultData);
            }

            private void f(final CtAdResultData ctAdResultData) {
                f.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.f.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (z) {
                            f.this.aIT.clear();
                        }
                        if (f.this.aIT.isEmpty()) {
                            t.abv();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (CtAdTemplate ctAdTemplate : ctAdResultData.getCtAdTemplateList()) {
                            if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                                arrayList.add(ctAdTemplate);
                            }
                        }
                        f.this.aIT.addAll(arrayList);
                        f.this.d(z, 0, i);
                        f.a(f.this, false);
                        f.b(f.this);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(com.kwad.sdk.core.network.f fVar, final int i2, final String str) {
                f.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.f.4.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (com.kwad.sdk.core.network.e.bCI.errorCode == i2) {
                            f.b(f.this, false);
                        }
                        f.this.u(i2, str);
                        f.a(f.this, false);
                    }
                });
            }
        });
    }

    private boolean Gx() {
        return this.aJr;
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
