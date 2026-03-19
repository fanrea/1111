package com.kwad.components.ct;

import android.content.Context;
import com.kwad.components.core.request.h;
import com.kwad.components.core.request.i;
import com.kwad.sdk.components.e;
import com.kwad.sdk.core.response.b.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bf;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements com.kwad.components.ct.api.a {
    private g alI;

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        return -100;
    }

    @Override // com.kwad.components.ct.api.a
    public final boolean wQ() {
        return com.kwad.components.ct.a.b.wQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SdkConfigData sdkConfigData) {
        com.kwad.components.ct.coupon.b.xo().a(sdkConfigData.couponActiveConfig);
        List<com.kwad.sdk.core.response.model.a> value = com.kwad.components.ct.a.a.amn.getValue();
        if (value != null) {
            r(value);
        }
        if (com.kwad.components.ct.a.b.xg()) {
            wS();
        }
    }

    @Override // com.kwad.components.ct.api.a
    public final void resumeCurrentPlayer() {
        com.kwad.components.core.video.c.ub().resumeCurrentPlayer();
    }

    @Override // com.kwad.components.ct.api.a
    public final void pauseCurrentPlayer() {
        com.kwad.components.core.video.c.ub().pauseCurrentPlayer();
    }

    @Override // com.kwad.components.ct.api.a
    public final void bx(int i) {
        com.kwad.components.ct.f.d.Kb().bx(i);
    }

    @Override // com.kwad.components.ct.api.a
    public final int wR() {
        return com.kwad.components.ct.f.d.Kb().wR();
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        com.kwad.components.ct.f.d.Kb().init(context, ServiceProvider.getSDKConfig());
        l.UL();
        if (l.isDebugLogEnable() && !com.kwad.sdk.core.video.a.e.acI()) {
            com.kwad.sdk.core.d.c.e("ContentPluginImpl", "必要类缺失，请检查proguard规则");
        }
        h.b(new i() { // from class: com.kwad.components.ct.a.1
            @Override // com.kwad.components.core.request.i, com.kwad.components.core.request.h.a
            public final void d(SdkConfigData sdkConfigData) {
                a.this.e(sdkConfigData);
            }
        });
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ct.api.a.class;
    }

    private static void r(List<com.kwad.sdk.core.response.model.a> list) {
        if (com.kwad.components.ct.a.b.xf()) {
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.core.response.model.a aVar : list) {
                if (aVar != null && aVar.bGW) {
                    arrayList.add(new SceneImpl(aVar.posId));
                }
            }
            b.s(arrayList);
        }
    }

    private void wS() {
        Context context = ServiceProvider.getContext();
        if (ay.getProcessName(context).endsWith(":filedownloader")) {
            return;
        }
        com.kwad.components.ct.emotion.a.d.DG().a(com.kwad.components.ct.emotion.model.a.DK().bH(bf.ev(context)).DM(), new com.kwad.components.ct.emotion.model.b() { // from class: com.kwad.components.ct.a.2
        });
    }

    @Override // com.kwad.components.ct.api.a
    public final void setLoadingLottieAnimation(boolean z, int i) {
        com.kwad.components.ct.d.a.Jd().setLoadingLottieAnimation(z, i);
    }

    @Override // com.kwad.components.ct.api.a
    public final void setLoadingLottieAnimationColor(boolean z, int i) {
        com.kwad.components.ct.d.a.Jd().setLoadingLottieAnimationColor(z, i);
    }

    @Override // com.kwad.components.ct.api.a
    public final boolean aR(AdTemplate adTemplate) {
        return com.kwad.components.ct.response.a.a.ar(com.kwad.components.ct.response.a.a.ba(adTemplate));
    }

    @Override // com.kwad.components.ct.api.a
    public final com.kwad.components.ct.api.a.b wT() {
        return new com.kwad.components.ct.api.a.b() { // from class: com.kwad.components.ct.a.3
            @Override // com.kwad.components.ct.api.a.b
            public final void bj(boolean z) {
                com.kwad.components.ct.home.download.a.Gc().bj(true);
            }

            @Override // com.kwad.components.ct.api.a.b
            public final void aS(AdTemplate adTemplate) {
                com.kwad.components.ct.home.download.a.Gc().l(com.kwad.components.ct.response.a.a.ba(adTemplate));
            }

            @Override // com.kwad.components.ct.api.a.b
            public final void aT(AdTemplate adTemplate) {
                com.kwad.components.ct.home.download.a.Gc().m(com.kwad.components.ct.response.a.a.ba(adTemplate));
            }

            @Override // com.kwad.components.ct.api.a.b
            public final void aU(AdTemplate adTemplate) {
                com.kwad.components.ct.home.download.a.Gc().n(com.kwad.components.ct.response.a.a.ba(adTemplate));
            }

            @Override // com.kwad.components.ct.api.a.b
            public final void aV(AdTemplate adTemplate) {
                com.kwad.components.ct.home.download.a.Gc().o(com.kwad.components.ct.response.a.a.ba(adTemplate));
            }
        };
    }

    @Override // com.kwad.components.ct.api.a
    public final g wU() {
        if (this.alI == null) {
            this.alI = new com.kwad.components.ct.response.a.b();
        }
        return this.alI;
    }
}
