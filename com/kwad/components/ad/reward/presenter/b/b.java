package com.kwad.components.ad.reward.presenter.b;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.video.o;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private IAdLiveEndRequest kJ;
    private long lP;
    private p tU;
    private View za;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        public final /* synthetic */ BaseResultData parseData(String str) {
            return Y(str);
        }

        private static AdLiveEndResultData Y(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        /* renamed from: cR, reason: merged with bridge method [inline-methods] */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.kJ);
        }
    };
    private final o xI = new o() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            b.this.lP = j2;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.j
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.jd();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.je();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.j
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.je();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        com.kwad.components.core.p.a.b.a aVar;
        super.ay();
        if (this.vb.tu.la()) {
            this.vb.tu.a(this.xI);
            String strBn = com.kwad.sdk.core.response.b.a.bn(e.eP(this.vb.mAdTemplate));
            if (TextUtils.isEmpty(strBn) || (aVar = (com.kwad.components.core.p.a.b.a) d.g(com.kwad.components.core.p.a.b.a.class)) == null) {
                return;
            }
            this.kJ = aVar.getAdLiveEndRequest(strBn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.vb.tu.la()) {
            this.vb.tu.b(this.xI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jd() {
        if (this.kJ == null) {
            return;
        }
        this.mNetworking.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.liveEnd.a aVar, final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.vb.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() throws Resources.NotFoundException {
                        if (b.this.tU == null) {
                            b.this.tU = new p(b.this.vb);
                        }
                        b.this.tU.h(b.this.vb.mRootContainer);
                        b.this.tU.b(r.ab(b.this.vb.mAdTemplate));
                        b.this.tU.a(b.this.vb, adLiveEndResultData.mQLivePushEndInfo, b.this.lP);
                        b.this.vb.tU = b.this.tU;
                        if (b.this.vb.mContext.getResources().getConfiguration().orientation == 2) {
                            b.this.za = b.this.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                        } else {
                            b.this.za = b.this.findViewById(R.id.ksad_live_end_page_layout_root);
                        }
                        b.this.za.setVisibility(0);
                        b.this.iM();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.liveEnd.a aVar, int i, String str) {
                super.onError(aVar, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je() {
        View view = this.za;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0576a c0576a = new a.C0576a();
        bVar.eY(24);
        bVar.b(c0576a);
        com.kwad.components.ad.reward.j.b.a(true, this.vb.mAdTemplate, null, bVar);
    }
}
