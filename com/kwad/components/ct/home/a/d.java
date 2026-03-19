package com.kwad.components.ct.home.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.home.a.e;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    private static volatile d aIs = null;
    private static volatile boolean aIu = false;
    private boolean NZ;
    private HashMap<String, List<CtAdTemplate>> aIt;
    private e aIv;
    private long aIw = 0;
    private l<com.kwad.components.core.request.a, CtAdResultData> aeV;

    interface a {
        void Gn();
    }

    private d() {
    }

    public static d Gi() {
        if (aIs == null) {
            synchronized (d.class) {
                if (aIs == null) {
                    aIs = new d();
                }
            }
        }
        return aIs;
    }

    public final void a(String str, CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate == null) {
            return;
        }
        if (this.aIt == null) {
            this.aIt = new HashMap<>();
        }
        List<CtAdTemplate> arrayList = this.aIt.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.aIt.put(str, arrayList);
        }
        arrayList.add(ctAdTemplate);
        this.aIt.put(str, arrayList);
    }

    private CtAdTemplate bQ(String str) {
        List<CtAdTemplate> list;
        HashMap<String, List<CtAdTemplate>> map = this.aIt;
        if (map == null || (list = map.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public final boolean ad(long j) {
        if (j - this.aIw <= com.kwad.sdk.core.config.c.bxQ.Zn()) {
            return false;
        }
        this.aIw = j;
        return true;
    }

    public final void bR(String str) {
        List<CtAdTemplate> list;
        HashMap<String, List<CtAdTemplate>> map = this.aIt;
        if (map == null || (list = map.get(str)) == null || list.size() <= 0) {
            return;
        }
        list.remove(0);
    }

    public static boolean n(long j, long j2) {
        return j2 - j > ((long) com.kwad.sdk.core.config.c.bxQ.Zm());
    }

    public final void a(String str, SceneImpl sceneImpl) {
        if (bQ(str) == null) {
            a(str, sceneImpl, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final SceneImpl sceneImpl, final a aVar) {
        if (aIu) {
            return;
        }
        l<com.kwad.components.core.request.a, CtAdResultData> lVar = new l<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.home.a.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: oC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                ImpInfo impInfo = new ImpInfo(sceneImpl);
                impInfo.pageScene = sceneImpl.getPageScene();
                impInfo.subPageScene = 107L;
                if (sceneImpl.getPageScene() == 9) {
                    sceneImpl.setAdStyle(13);
                }
                return new com.kwad.components.core.request.a(impInfo);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str2) {
                com.kwad.sdk.core.d.c.d("[IAd]InterstitialAdManager", "parseData");
                JSONObject jSONObject = new JSONObject(str2);
                CtAdResultData ctAdResultData = new CtAdResultData(sceneImpl);
                ctAdResultData.parseJson(jSONObject);
                if (ctAdResultData.getCtAdTemplateList().size() > 0) {
                    Iterator<CtAdTemplate> it = ctAdResultData.getCtAdTemplateList().iterator();
                    while (it.hasNext()) {
                        it.next().mIsFromContent = true;
                    }
                }
                return ctAdResultData;
            }
        };
        this.aeV = lVar;
        lVar.request(new o<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.home.a.d.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str2) {
                k(i, str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.core.request.a aVar2) {
                super.onStartRequest(aVar2);
                com.kwad.sdk.core.d.c.d("[IAd]InterstitialAdManager", "onStartRequest");
                boolean unused = d.aIu = true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.request.a aVar2, CtAdResultData ctAdResultData) {
                com.kwad.sdk.core.d.c.d("[IAd]InterstitialAdManager", "onSuccess");
                boolean unused = d.aIu = false;
                if (ctAdResultData.isAdResultDataEmpty()) {
                    k(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : ctAdResultData.testErrorMsg);
                    return;
                }
                d.this.a(str, ctAdResultData.getCtAdTemplateList().get(0));
                a aVar3 = aVar;
                if (aVar3 != null) {
                    ctAdResultData.getCtAdTemplateList().get(0);
                    aVar3.Gn();
                }
            }

            private static void k(int i, String str2) {
                boolean unused = d.aIu = false;
                com.kwad.sdk.core.d.c.w("[IAd]InterstitialAdManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str2));
            }
        });
    }

    public final void a(final int i, final ViewGroup viewGroup, final SceneImpl sceneImpl, final String str, final int i2) {
        CtAdTemplate ctAdTemplateBQ = bQ(str);
        if (ctAdTemplateBQ != null) {
            e eVar = new e();
            this.aIv = eVar;
            eVar.a(new e.a(ctAdTemplateBQ).n(viewGroup).cq(i).cr(i2).bO(true));
            this.aIv.a(new c() { // from class: com.kwad.components.ct.home.a.d.3
                @Override // com.kwad.components.ct.home.a.c
                public final void aV(int i3) {
                    if (i3 == 1) {
                        d.this.Gj();
                        d.this.bR(str);
                        d.this.a(str, sceneImpl, null);
                    }
                }
            });
            this.aIv.pj();
            return;
        }
        a(str, sceneImpl, new a() { // from class: com.kwad.components.ct.home.a.d.4
            @Override // com.kwad.components.ct.home.a.d.a
            public final void Gn() {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.home.a.d.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        d.this.a(i, viewGroup, sceneImpl, str, i2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj() {
        e eVar = this.aIv;
        if (eVar == null || !eVar.yc()) {
            return;
        }
        this.aIv.a(new b() { // from class: com.kwad.components.ct.home.a.d.5
            @Override // com.kwad.components.ct.home.a.b
            public final void Al() {
                d.this.NZ = true;
            }

            @Override // com.kwad.components.ct.home.a.b
            public final void co(int i) {
                d.this.NZ = false;
            }
        });
        this.aIv.yb();
    }

    public final boolean Gk() {
        return this.aIv != null && this.NZ;
    }

    public final void Gl() {
        e eVar = this.aIv;
        if (eVar != null) {
            eVar.release();
            this.aIv = null;
        }
        this.NZ = false;
    }

    public final void bS(String str) {
        l<com.kwad.components.core.request.a, CtAdResultData> lVar = this.aeV;
        if (lVar != null) {
            lVar.cancel();
        }
        Gl();
        HashMap<String, List<CtAdTemplate>> map = this.aIt;
        if (map != null) {
            map.remove(str);
        }
    }

    public static boolean Gm() {
        return com.kwad.sdk.core.config.c.aLt.getValue() != null && com.kwad.sdk.core.config.c.aLt.getValue().intValue() == 1;
    }
}
