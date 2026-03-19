package com.kwad.components.ct.horizontal.news.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.widget.b;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.news.b.a {
    private l<com.kwad.components.core.request.a, CtAdResultData> aJd;
    private com.kwad.components.ct.horizontal.feed.a aLL;
    private com.kwad.components.core.widget.b aLU;
    private View aNU;
    private FrameLayout aNV;
    private final KsAdVideoPlayConfig dG = new KsAdVideoPlayConfig.Builder().build();
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewA = com.kwad.sdk.c.a.a.a((ViewGroup) getRootView(), R.layout.ksad_news_header_ad_layout, false);
        this.aNU = viewA;
        this.aNV = (FrameLayout) viewA.findViewById(R.id.ksad_news_ad_container);
        this.aLL = new com.kwad.components.ct.horizontal.feed.a();
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aNU.setVisibility(8);
        this.aNz.aFW.addHeaderView(this.aNU);
        this.mAdTemplate = this.aNz.mEntryAdTemplate;
        Ic();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        l<com.kwad.components.core.request.a, CtAdResultData> lVar = this.aJd;
        if (lVar != null) {
            lVar.cancel();
        }
        com.kwad.components.core.widget.b bVar = this.aLU;
        if (bVar != null) {
            bVar.cv();
        }
    }

    private void Ic() {
        final ImpInfo impInfo = new ImpInfo(this.aNz.mSceneImpl);
        impInfo.pageScene = this.aNz.mSceneImpl.getPageScene();
        impInfo.subPageScene = 109L;
        impInfo.sdkExtraData = com.kwad.components.ct.response.a.a.aZ(this.aNz.mEntryAdTemplate);
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate);
        final com.kwad.components.core.request.model.c cVar = new com.kwad.components.core.request.model.c();
        cVar.photoId = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
        cVar.authorId = com.kwad.components.ct.response.a.c.e(ctPhotoInfoAy);
        l<com.kwad.components.core.request.a, CtAdResultData> lVar = new l<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.horizontal.news.c.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: oC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo, cVar);
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
        this.aJd = lVar;
        lVar.request(new o<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.horizontal.news.c.b.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                h((CtAdResultData) baseResultData);
            }

            private void h(final CtAdResultData ctAdResultData) {
                if (ctAdResultData.isAdResultDataEmpty()) {
                    return;
                }
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.horizontal.news.c.b.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        b.this.C(ctAdResultData.getCtAdTemplateList().get(0));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(CtAdTemplate ctAdTemplate) {
        View viewG = com.kwad.components.ct.horizontal.feed.a.g(this.aNV, this.aLL.z(ctAdTemplate));
        if (viewG instanceof com.kwad.components.core.widget.b) {
            this.aLU = (com.kwad.components.core.widget.b) viewG;
        }
        if (this.aLU != null) {
            this.aNV.removeAllViews();
            this.aNV.addView(this.aLU);
            this.aLU.d(com.kwad.sdk.core.response.b.c.ev(ctAdTemplate));
            this.aNU.setVisibility(0);
            com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) com.kwad.sdk.components.d.g(com.kwad.components.ad.b.d.class);
            if (dVar == null || !dVar.a(this.aLU, this.dG)) {
                com.kwad.components.core.widget.b bVar = this.aLU;
                if (bVar instanceof com.kwad.components.ct.horizontal.feed.c.a) {
                    ((com.kwad.components.ct.horizontal.feed.c.a) bVar).b(this.dG);
                }
            }
            a(this.aLU);
        }
    }

    private void a(com.kwad.components.core.widget.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.a() { // from class: com.kwad.components.ct.horizontal.news.c.b.3
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                ac.ae(b.this.getContext(), "操作成功，将减少此类推荐");
            }
        });
    }
}
