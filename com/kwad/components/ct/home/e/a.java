package com.kwad.components.ct.home.e;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.home.a.e;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private boolean NZ;
    private e aIv;
    private final FrameLayout aLa;
    private CtAdTemplate aLb;
    private final int aLc;
    private l<com.kwad.components.core.request.a, CtAdResultData> aeV;
    private final SceneImpl mScene;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private volatile boolean aIu = false;
    private final int aIQ = 4;

    /* renamed from: com.kwad.components.ct.home.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0521a {
        void y(CtAdTemplate ctAdTemplate);
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.aIu = false;
        return false;
    }

    public a(FrameLayout frameLayout, SceneImpl sceneImpl, int i) {
        this.aLa = frameLayout;
        this.mScene = sceneImpl;
        this.aLc = i;
    }

    public final void Ds() {
        if (He() != null) {
            w(He());
        } else {
            a(new InterfaceC0521a() { // from class: com.kwad.components.ct.home.e.a.1
                @Override // com.kwad.components.ct.home.e.a.InterfaceC0521a
                public final void y(CtAdTemplate ctAdTemplate) {
                    a.this.x(ctAdTemplate);
                    a.this.w(ctAdTemplate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(CtAdTemplate ctAdTemplate) {
        if (Gk()) {
            return;
        }
        Hg();
        e eVar = new e();
        this.aIv = eVar;
        eVar.a(new e.a(ctAdTemplate).n(this.aLa).cq(4).cr(this.aLc));
        this.aIv.pj();
    }

    public final boolean b(final com.kwad.components.ct.home.a.b bVar) {
        if (!Hf()) {
            return false;
        }
        this.aIv.a(new com.kwad.components.ct.home.a.b() { // from class: com.kwad.components.ct.home.e.a.2
            @Override // com.kwad.components.ct.home.a.b
            public final void Al() {
                a.this.NZ = true;
                com.kwad.components.ct.home.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.Al();
                }
            }

            @Override // com.kwad.components.ct.home.a.b
            public final void co(int i) {
                a.this.NZ = false;
                com.kwad.components.ct.home.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.co(i);
                }
                a.this.Ds();
            }
        });
        this.aIv.yb();
        Hh();
        return true;
    }

    public final void release() {
        Hi();
        Hh();
        Hg();
    }

    private CtAdTemplate He() {
        return this.aLb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(CtAdTemplate ctAdTemplate) {
        this.aLb = ctAdTemplate;
    }

    private boolean Hf() {
        e eVar = this.aIv;
        return eVar != null && eVar.yc();
    }

    public final boolean Gk() {
        return this.aIv != null && this.NZ;
    }

    private void Hg() {
        e eVar = this.aIv;
        if (eVar != null) {
            eVar.release();
            this.aIv = null;
        }
        this.NZ = false;
    }

    private void Hh() {
        this.aLb = null;
    }

    private void a(final InterfaceC0521a interfaceC0521a) {
        if (this.aIu) {
            return;
        }
        this.aIu = true;
        final ImpInfo impInfo = new ImpInfo(this.mScene);
        impInfo.pageScene = this.mScene.getPageScene();
        impInfo.subPageScene = 107L;
        l<com.kwad.components.core.request.a, CtAdResultData> lVar = new l<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.home.e.a.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: oC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(impInfo.adScene);
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
        lVar.request(new o<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.home.e.a.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                k(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.request.a aVar, CtAdResultData ctAdResultData) {
                a.b(a.this, false);
                if (ctAdResultData.isAdResultDataEmpty()) {
                    k(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : ctAdResultData.testErrorMsg);
                } else {
                    final CtAdTemplate ctAdTemplate = ctAdResultData.getCtAdTemplateList().get(0);
                    a.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.e.a.4.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            interfaceC0521a.y(ctAdTemplate);
                        }
                    });
                }
            }

            private void k(final int i, final String str) {
                a.b(a.this, false);
                a.this.mHandler.post(new bh() { // from class: com.kwad.components.ct.home.e.a.4.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        c.w("StayAdHelper", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    }
                });
            }
        });
    }

    private void Hi() {
        this.aIu = false;
        l<com.kwad.components.core.request.a, CtAdResultData> lVar = this.aeV;
        if (lVar != null) {
            lVar.cancel();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
