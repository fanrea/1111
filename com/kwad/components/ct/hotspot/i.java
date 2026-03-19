package com.kwad.components.ct.hotspot;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.detail.listener.DetailPageListener;
import com.kwad.components.ct.hotspot.view.HotspotListView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.HotspotListData;
import com.kwad.components.ct.response.model.hotspot.HotspotListResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.AbstractKsHotspotPage;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends AbstractKsHotspotPage {
    private HotspotListView aPN;
    private KsContentPage.PageListener alM;
    private KsContentPage.VideoListener alN;
    private KsContentPage.KsShareListener alT;
    private HotspotListData mHotspotListData;
    private final SceneImpl mScene;
    private final AtomicBoolean aCX = new AtomicBoolean(false);
    private final DetailPageListener alX = new DetailPageListener() { // from class: com.kwad.components.ct.hotspot.i.3
        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageEnter(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alM != null) {
                i.this.alM.onPageEnter(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageResume(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alM != null) {
                i.this.alM.onPageResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPagePause(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alM != null) {
                i.this.alM.onPagePause(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageLeave(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alM != null) {
                i.this.alM.onPageLeave(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }
    };
    private final com.kwad.components.ct.detail.listener.a alY = new com.kwad.components.ct.detail.listener.a() { // from class: com.kwad.components.ct.hotspot.i.4
        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alN != null) {
                i.this.alN.onVideoPlayStart(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void b(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alN != null) {
                i.this.alN.onVideoPlayPaused(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void c(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alN != null) {
                i.this.alN.onVideoPlayResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void d(int i, CtAdTemplate ctAdTemplate) {
            if (i.this.alN != null) {
                i.this.alN.onVideoPlayCompleted(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate, int i2, int i3) {
            if (i.this.alN != null) {
                i.this.alN.onVideoPlayError(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate), i2, i3);
            }
        }
    };

    public i(SceneImpl sceneImpl, HotspotListData hotspotListData) {
        this.mScene = sceneImpl;
        sceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 13));
        this.mHotspotListData = hotspotListData;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsHotspotPage
    public final View getHotspotEntryView2(Context context) {
        HotspotListView hotspotListView = this.aPN;
        if (hotspotListView != null) {
            if (hotspotListView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aPN.getParent()).removeView(this.aPN);
            }
            return this.aPN;
        }
        HotspotListData hotspotListData = this.mHotspotListData;
        if (hotspotListData == null || hotspotListData.trends.isEmpty()) {
            return null;
        }
        HotspotListView hotspotListView2 = (HotspotListView) View.inflate(context, R.layout.ksad_view_hotspot_entry_layout, null);
        this.aPN = hotspotListView2;
        hotspotListView2.a(this.mScene, this.mHotspotListData);
        return this.aPN;
    }

    @Override // com.kwad.sdk.api.KsHotspotPage
    public final void refresh() {
        if (this.aCX.get()) {
            return;
        }
        this.aCX.set(true);
        final ImpInfo impInfo = new ImpInfo(this.mScene);
        impInfo.pageScene = 13L;
        new l<com.kwad.components.ct.request.h, HotspotListResultData>() { // from class: com.kwad.components.ct.hotspot.i.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bW(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: IH, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.request.h createRequest() {
                return new com.kwad.components.ct.request.h(impInfo);
            }

            private static HotspotListResultData bW(String str) {
                JSONObject jSONObject = new JSONObject(str);
                HotspotListResultData hotspotListResultData = new HotspotListResultData();
                hotspotListResultData.parseJson(jSONObject);
                return hotspotListResultData;
            }
        }.request(new o<com.kwad.components.ct.request.h, HotspotListResultData>() { // from class: com.kwad.components.ct.hotspot.i.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                II();
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((HotspotListResultData) baseResultData);
            }

            private void a(final HotspotListResultData hotspotListResultData) {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.hotspot.i.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        i.this.aCX.set(false);
                        if (hotspotListResultData.hotspotListData.trends.isEmpty() || i.this.aPN == null) {
                            return;
                        }
                        i.this.mHotspotListData = hotspotListResultData.hotspotListData;
                        i.this.aPN.a(i.this.mScene, i.this.mHotspotListData);
                    }
                });
            }

            private void II() {
                i.this.aCX.set(false);
                com.kwad.sdk.core.d.c.d("KsHotspotPageImpl", "onError");
            }
        });
    }

    private static com.kwad.components.ct.api.a.a xa() {
        com.kwad.components.ct.api.d dVar = (com.kwad.components.ct.api.d) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.d.class);
        if (dVar != null) {
            return dVar.xa();
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsHotspotPage
    public final void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.alN = videoListener;
        if (videoListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alY);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alY);
        }
    }

    @Override // com.kwad.sdk.api.KsHotspotPage
    public final void setPageListener(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
        if (pageListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alX);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alX);
        }
    }

    @Override // com.kwad.sdk.api.KsHotspotPage
    public final void setShareListener(KsContentPage.KsShareListener ksShareListener) {
        this.alT = ksShareListener;
        com.kwad.components.ct.api.a.a aVarXa = xa();
        if (aVarXa != null) {
            aVarXa.a(ksShareListener);
        }
    }
}
