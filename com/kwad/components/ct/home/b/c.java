package com.kwad.components.ct.home.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.request.o;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends a {
    private int aIX;
    private int aIY;
    private String aJa;
    private String aJb;
    private l<k, CtAdResultData> aJd;
    private SceneImpl mAdScene;
    private int mRequestCount;
    private boolean aIZ = false;
    private boolean aJc = true;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    static /* synthetic */ int a(c cVar, int i) {
        cVar.aIX = 0;
        return 0;
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.aIZ = false;
        return false;
    }

    static /* synthetic */ int b(c cVar) {
        int i = cVar.aIX;
        cVar.aIX = i + 1;
        return i;
    }

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.aJc = false;
        return false;
    }

    static /* synthetic */ int c(c cVar) {
        int i = cVar.mRequestCount;
        cVar.mRequestCount = i + 1;
        return i;
    }

    public c(SceneImpl sceneImpl) {
        this.mAdScene = sceneImpl;
    }

    public final void bT(String str) {
        this.aJa = com.kwad.sdk.o.b.au(str, Config.PUSH);
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "setPushLinkData mPushData=" + this.aJa);
    }

    public final void bU(String str) {
        this.aJb = com.kwad.sdk.o.b.ih(str);
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "setShareSchemaData mMediaShareData=" + this.aJb);
    }

    public final void bP(boolean z) {
        this.aIY = z ? 1 : 0;
    }

    @Override // com.kwad.components.ct.home.b.a
    public final void a(final boolean z, boolean z2, final int i) {
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "loadData requestType=" + i);
        if (this.aIZ) {
            com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "mLoading");
            return;
        }
        this.aIZ = true;
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "loadData isRefresh=" + z);
        if (i == 4) {
            this.aJc = true;
            this.aIT.clear();
            this.aIX = 0;
            b(z, z2, i, 0);
            return;
        }
        b(z, z2, i, this.aIX);
        if (!this.aJc) {
            this.aJa = null;
            this.aJb = null;
        }
        if (g.Gz()) {
            this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.c.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (z) {
                        c.this.aIT.clear();
                        c.a(c.this, 0);
                    }
                    if (c.this.aIT.isEmpty()) {
                        t.abv();
                    }
                    List<CtAdTemplate> listGA = g.GA();
                    if (!listGA.isEmpty()) {
                        c.this.mRequestCount = listGA.get(listGA.size() - 1).mRequestCount;
                    }
                    c.this.aIT.addAll(listGA);
                    g.GB();
                    c cVar = c.this;
                    cVar.d(z, cVar.aIX, i);
                    c.b(c.this);
                    c.a(c.this, false);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(this.aJa) && TextUtils.isEmpty(this.aJb) && !Gw() && !z && !z2 && this.aIT.isEmpty()) {
            final List<CtAdTemplate> listD = d(this.mAdScene);
            if (ap.aM(listD)) {
                this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.c.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        c.this.aIT.addAll(listD);
                        t.abv();
                        c cVar = c.this;
                        cVar.d(false, cVar.aIX, i);
                        c.a(c.this, false);
                        c.this.a(false, 5, (List<CtAdTemplate>) listD);
                    }
                });
                return;
            }
        }
        a(z, i, (List<CtAdTemplate>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final int i, List<CtAdTemplate> list) {
        final k.a aVar = new k.a();
        ImpInfo impInfo = new ImpInfo(this.mAdScene);
        impInfo.pageScene = this.mAdScene.getPageScene();
        impInfo.subPageScene = 100L;
        aVar.anZ.add(impInfo);
        int i2 = 2;
        final int i3 = 0;
        switch (i) {
            case 0:
            case 4:
                i2 = 3;
                break;
            case 1:
                com.kwad.components.ct.e.b.JK().e(this.mAdScene, 1);
                i2 = 1;
                i3 = 1;
                break;
            case 2:
                com.kwad.components.ct.e.b.JK().e(this.mAdScene, 2);
                i3 = 2;
                i2 = 1;
                break;
            case 3:
                com.kwad.components.ct.e.b.JK().e(this.mAdScene, 3);
                i3 = 3;
                i2 = 1;
                break;
            case 5:
            case 6:
                break;
            default:
                i2 = 0;
                break;
        }
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.nm = i2;
        aVar2.aUW = this.aIY;
        aVar2.aUX = this.mRequestCount;
        aVar2.aUY = this.aIT.size();
        aVar.aUG = aVar2;
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "requestCount=" + aVar2.aUX);
        aVar.aUH = this.aJa;
        aVar.aUg = this.aJb;
        if (list != null) {
            aVar.aUI = new o(list);
        }
        this.aJd = new l<k, CtAdResultData>() { // from class: com.kwad.components.ct.home.b.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: EY, reason: merged with bridge method [inline-methods] */
            public k createRequest() {
                return new k(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                Iterator<ImpInfo> it = aVar.anZ.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().adScene);
                }
                CtAdResultData ctAdResultData = new CtAdResultData(arrayList);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }
        };
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "mRequest.request");
        this.aJd.request(new com.kwad.sdk.core.network.o<k, CtAdResultData>() { // from class: com.kwad.components.ct.home.b.c.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i4, String str) {
                v(i4, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                e((CtAdResultData) baseResultData);
            }

            private void e(CtAdResultData ctAdResultData) {
                c.c(c.this);
                final ArrayList arrayList = new ArrayList();
                for (CtAdTemplate ctAdTemplate : ctAdResultData.getCtAdTemplateList()) {
                    if (ctAdTemplate != null && !c.this.r(ctAdTemplate)) {
                        ctAdTemplate.mPhotoResponseType = i3;
                        ctAdTemplate.mRequestCount = c.this.mRequestCount;
                        arrayList.add(ctAdTemplate);
                    }
                }
                com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "onSuccess templates size= " + arrayList.size());
                c.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.c.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        c.b(c.this, false);
                        if (z) {
                            c.a(c.this, 0);
                            c.this.aIT.clear();
                        }
                        if (c.this.aIT.isEmpty()) {
                            t.abv();
                        }
                        c.this.aIT.addAll(arrayList);
                        c.this.d(z, c.this.aIX, i);
                        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "onContentAllianceLoad mTemplateList:" + c.this.aIT.size());
                        c.a(c.this, false);
                        c.b(c.this);
                    }
                });
            }

            private void v(final int i4, final String str) {
                c.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.b.c.4.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "onError msg:" + str);
                        c.this.u(i4, str);
                        c.a(c.this, false);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(CtAdTemplate ctAdTemplate) {
        return this.mAdScene.getPageScene() != 9 && com.kwad.components.ct.response.a.a.aq(ctAdTemplate);
    }

    private static List<CtAdTemplate> d(SceneImpl sceneImpl) {
        List<CtAdTemplate> listAe;
        long posId = sceneImpl.getPosId();
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "preload usePreloadContentData posId=" + posId);
        b bVarGv = b.Gv();
        if (bVarGv.ag(posId) || (listAe = bVarGv.ae(posId)) == null || listAe.isEmpty()) {
            return null;
        }
        bVarGv.af(listAe.get(0).posId);
        for (CtAdTemplate ctAdTemplate : listAe) {
            ctAdTemplate.mAdScene = sceneImpl;
            ctAdTemplate.posId = posId;
        }
        com.kwad.sdk.core.d.c.d("DataFetcherContentImpl", "usePreloadContentData cache item list size=" + listAe.size());
        return new ArrayList(listAe);
    }

    @Override // com.kwad.components.ct.home.b.a, com.kwad.components.ct.api.a.a.a
    public final void release() {
        super.release();
        l<k, CtAdResultData> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
        this.aIZ = false;
    }

    private boolean Gw() {
        SceneImpl sceneImpl = this.mAdScene;
        if (sceneImpl == null) {
            return false;
        }
        return sceneImpl.getPageScene() == 16 || this.mAdScene.getPageScene() == 15;
    }
}
