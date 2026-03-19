package com.kwad.components.ct.home.d;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.q;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.home.b.a {
    private boolean aIZ = false;
    private l<f, CtAdResultData> aJd;
    private CtAdTemplate aKM;
    private String mPcursor;
    private SceneImpl mSceneImpl;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.aIZ = false;
        return false;
    }

    public c(SceneImpl sceneImpl) {
        this.mSceneImpl = sceneImpl;
    }

    public final void v(CtAdTemplate ctAdTemplate) {
        this.aKM = ctAdTemplate;
    }

    @Override // com.kwad.components.ct.home.b.a
    public final void a(final boolean z, boolean z2, final int i) {
        if (this.aIZ) {
            return;
        }
        this.aIZ = true;
        if (!Gx()) {
            this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.d.c.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    c.this.u(e.bCI.errorCode, e.bCI.msg);
                    c.a(c.this, false);
                }
            });
            return;
        }
        b(z, z2, i, 0);
        final q.a aVar = new q.a();
        aVar.pcursor = this.mPcursor;
        ImpInfo impInfo = new ImpInfo(this.mSceneImpl);
        impInfo.pageScene = this.mSceneImpl.getPageScene();
        aVar.Tk = impInfo;
        aVar.authorId = com.kwad.components.ct.response.a.c.e(this.aKM.photoInfo);
        aVar.aUG = new com.kwad.components.ct.request.a.a();
        l<f, CtAdResultData> lVar = new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.home.d.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(c.this.mSceneImpl);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final f createRequest() {
                return new q(aVar);
            }
        };
        this.aJd = lVar;
        lVar.request(new o<f, CtAdResultData>() { // from class: com.kwad.components.ct.home.d.c.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                f((CtAdResultData) baseResultData);
            }

            private void f(final CtAdResultData ctAdResultData) {
                c.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.d.c.3.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (z) {
                            c.this.aIT.clear();
                        }
                        if (c.this.aIT.isEmpty()) {
                            t.abv();
                        }
                        c.this.mPcursor = ctAdResultData.pcursor;
                        c.this.G(ctAdResultData.getCtAdTemplateList());
                        c.this.d(z, 0, i);
                        c.a(c.this, false);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(f fVar, final int i2, final String str) {
                if ((e.bCw.errorCode == i2 || (c.this.aIT.isEmpty() && e.bCy.errorCode == i2)) && !c.this.aIT.contains(c.this.aKM)) {
                    c.this.aIT.add(c.this.aKM);
                    c.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.d.c.3.2
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            c.this.d(z, 0, i);
                            c.a(c.this, false);
                        }
                    });
                } else {
                    c.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.d.c.3.3
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            c.this.u(i2, str);
                            c.a(c.this, false);
                        }
                    });
                }
            }
        });
    }

    private boolean Gx() {
        return !"0".equals(this.mPcursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<CtAdTemplate> list) {
        long j = com.kwad.components.ct.response.a.c.j((PhotoInfo) this.aKM.photoInfo);
        Iterator<CtAdTemplate> it = list.iterator();
        while (it.hasNext()) {
            CtAdTemplate next = it.next();
            if (j == com.kwad.components.ct.response.a.c.j((PhotoInfo) next.photoInfo)) {
                if (this.aIT.contains(this.aKM)) {
                    it.remove();
                } else {
                    list.set(list.indexOf(next), this.aKM);
                }
            }
            next.mIsLeftSlipStatus = 1;
        }
        this.aIT.addAll(list);
        if (this.aIT.contains(this.aKM)) {
            return;
        }
        if (this.aIT.size() <= 3) {
            this.aIT.add(this.aKM);
        } else {
            this.aIT.add(2, this.aKM);
        }
    }

    @Override // com.kwad.components.ct.home.b.a, com.kwad.components.ct.api.a.a.a
    public final void release() {
        super.release();
        this.aIZ = false;
        l<f, CtAdResultData> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
    }
}
