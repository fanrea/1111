package com.kwad.components.ct.tube.slide.detail.a;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.detail.e.a;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.tube.slide.detail.reward.a;
import com.kwad.components.ct.tube.slide.detail.reward.unlock.TubeUnlockResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private com.kwad.components.ct.tube.slide.detail.reward.a aYu;
    private boolean aYv;
    private ImageButton aYw;
    private com.kwad.components.ct.detail.e.a aoz;
    private CtPhotoInfo asj;
    private CtAdTemplate mAdTemplate;
    private KSTubeParamInner mKSTubeParam;
    private final a.InterfaceC0507a aGT = new a.InterfaceC0507a() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.1
        @Override // com.kwad.components.ct.detail.e.a.InterfaceC0507a
        public final boolean yM() {
            return b.this.aYv;
        }
    };
    private final com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            b bVar = b.this;
            bVar.aYv = bVar.KQ();
            if (b.this.aYv) {
                b.this.KM();
            }
        }
    };
    private final com.kwad.components.ct.tube.b.b aYx = new com.kwad.components.ct.tube.b.b() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.5
        @Override // com.kwad.components.ct.tube.b.b
        public final void onRewardArrived() {
            b.this.KN();
            b.this.KP();
            com.kwad.components.ct.e.b.JK();
            com.kwad.components.ct.e.c cVarC = com.kwad.components.ct.e.b.c(132L, b.this.mAdTemplate);
            cVarC.adScene = b.this.aop.aol.mSceneImpl;
            g.a((n) cVarC);
        }

        @Override // com.kwad.components.ct.tube.b.b
        public final void onRewardFail(int i) {
            b.this.cS(i);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aYw = (ImageButton) findViewById(R.id.ksad_tube_reward_button);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mKSTubeParam = this.aop.aol.mKSTubeParam;
        this.aoz = this.aop.aoz;
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        this.asj = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
        this.aoz.a(this.aGT);
        this.aop.aoq.add(this.aoQ);
        this.aYv = KQ();
        this.aYw.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aoz.b(this.aGT);
        this.aop.aoq.remove(this.aoQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM() {
        KSTubeParamInner kSTubeParamInner;
        cb(true);
        final com.kwad.components.ct.tube.b.c cVarKw = com.kwad.components.ct.tube.b.a.Kv().Kw();
        if (cVarKw == null || (kSTubeParamInner = this.mKSTubeParam) == null) {
            KP();
        } else if (kSTubeParamInner.disableUnLockTipDialog) {
            com.kwad.sdk.core.d.c.d("PhotoTubeUnLockPresenter", "disableLockTipDialog");
            c(cVarKw);
        } else {
            com.kwad.sdk.core.d.c.d("PhotoTubeUnLockPresenter", "showRewardTipDialog");
            a(this.mKSTubeParam.dialogCloseNextStep, new Runnable() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c(cVarKw);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.kwad.components.ct.tube.b.c cVar) {
        com.kwad.components.core.u.a.aC(getContext()).aT(false);
        cVar.a(getActivity(), com.kwad.components.ct.detail.d.a.m(this.aop.aok.getRealPosition(), this.mAdTemplate), this.aYx);
        com.kwad.components.ct.e.b.JK();
        com.kwad.components.ct.e.c cVarC = com.kwad.components.ct.e.b.c(131L, this.mAdTemplate);
        cVarC.adScene = this.aop.aol.mSceneImpl;
        g.a((n) cVarC);
    }

    private void a(final int i, final Runnable runnable) {
        com.kwad.components.ct.tube.slide.detail.reward.a aVar = this.aYu;
        if (aVar != null && aVar.isShowing()) {
            this.aYu.dismiss();
        }
        this.aYu = com.kwad.components.ct.tube.slide.detail.reward.a.a(getActivity(), this.mAdTemplate, new a.InterfaceC0543a() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.4
            @Override // com.kwad.components.ct.tube.slide.detail.reward.a.InterfaceC0543a
            public final void KR() {
                runnable.run();
            }

            @Override // com.kwad.components.ct.tube.slide.detail.reward.a.InterfaceC0543a
            public final void em() {
                b.this.cS(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN() {
        com.kwad.components.ct.tube.slide.detail.reward.a aVar = this.aYu;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS(int i) {
        if (i == 1) {
            cb(false);
            KN();
            iE();
        } else {
            if (i == 2) {
                cb(false);
                KN();
                if (KO()) {
                    return;
                }
                iE();
                return;
            }
            this.aYw.setVisibility(0);
            this.aYw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.this.KM();
                }
            });
        }
    }

    private boolean KO() {
        CtAdTemplate ctAdTemplate = this.aop.aol.aHl;
        if (ctAdTemplate == null) {
            return false;
        }
        List<CtAdTemplate> data = this.aop.aok.getData();
        if (ap.aF(data)) {
            return false;
        }
        int iQ = com.kwad.components.ct.response.a.c.q(com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
        ArrayList arrayList = new ArrayList(data);
        for (int i = 0; i < arrayList.size(); i++) {
            if (iQ == com.kwad.components.ct.response.a.c.q(com.kwad.components.ct.response.a.a.ay((CtAdTemplate) arrayList.get(i)))) {
                return this.aop.aok.h(i, true);
            }
        }
        return false;
    }

    private void iE() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private void cb(boolean z) {
        this.aop.aok.h(!z, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i) {
        cb(false);
        this.aYv = false;
        cU(i);
        this.aoz.resume();
    }

    private void cU(int i) {
        List<CtAdTemplate> data = this.aop.aok.getData();
        if (ap.aF(data)) {
            return;
        }
        int iU = com.kwad.components.ct.response.a.c.u(this.asj);
        int realPosition = this.aop.aok.getRealPosition();
        int i2 = 0;
        for (int i3 = 0; i3 < iU; i3++) {
            int i4 = realPosition + i3;
            if (i4 < data.size()) {
                com.kwad.components.ct.response.a.c.a(com.kwad.components.ct.response.a.a.ay(data.get(i4)), false);
                update(i4);
                i2++;
            }
        }
        if (i2 < iU) {
            com.kwad.sdk.core.d.c.d("PhotoTubeUnLockPresenter", "realLockCount:" + i2 + ", count:" + iU);
        }
        if (i > 0) {
            this.aop.aol.cn(i);
        }
    }

    private void update(int i) {
        int i2;
        List<CtAdTemplate> data = this.aop.aok.getData();
        if (!ap.aF(data) && (i2 = i + 1) < data.size()) {
            this.aop.aol.cn(com.kwad.components.ct.response.a.c.z(com.kwad.components.ct.response.a.a.ay(data.get(i2))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KP() {
        final com.kwad.components.ct.tube.channel.home.request.c cVarCQ = com.kwad.components.ct.tube.channel.home.request.c.Kr().am(com.kwad.components.ct.response.a.c.t(this.asj)).cN(com.kwad.components.ct.response.a.c.v(this.asj)).cO(com.kwad.components.ct.response.a.c.u(this.asj)).cP(com.kwad.components.ct.response.a.c.z(this.asj)).cQ(com.kwad.components.ct.response.a.c.z(this.asj));
        final com.kwad.sdk.core.request.model.g gVarAbH = com.kwad.sdk.core.request.model.g.abH();
        KSTubeParamInner kSTubeParamInner = this.mKSTubeParam;
        if (kSTubeParamInner != null) {
            gVarAbH.fL(kSTubeParamInner.userId).fM(this.mKSTubeParam.userName);
        }
        new l<com.kwad.components.ct.tube.slide.detail.reward.unlock.a, TubeUnlockResultData>() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.7
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return cg(str);
            }

            private static TubeUnlockResultData cg(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeUnlockResultData tubeUnlockResultData = new TubeUnlockResultData();
                tubeUnlockResultData.parseJson(jSONObject);
                return tubeUnlockResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: KS, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.tube.slide.detail.reward.unlock.a createRequest() {
                return new com.kwad.components.ct.tube.slide.detail.reward.unlock.a(cVarCQ, gVarAbH);
            }
        }.request(new o<com.kwad.components.ct.tube.slide.detail.reward.unlock.a, TubeUnlockResultData>() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.ct.tube.slide.detail.reward.unlock.a aVar, final TubeUnlockResultData tubeUnlockResultData) {
                super.onSuccess(aVar, tubeUnlockResultData);
                com.kwad.sdk.core.d.c.d("PhotoTubeUnLockPresenter", "requestUnlock success");
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ct.tube.slide.detail.a.b.8.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.cT(tubeUnlockResultData.unlockEpisodeNum);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KQ() {
        return com.kwad.components.ct.tube.d.b.q(this.aop.abR, this.mAdTemplate);
    }
}
