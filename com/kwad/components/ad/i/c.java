package com.kwad.components.ad.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements Runnable {
    private static volatile boolean sC;
    private static final Handler sy = new Handler(Looper.getMainLooper());
    private final AdTemplate sA;
    private boolean sB = false;
    private d sD;
    private final long sz;

    static /* synthetic */ boolean access$002(boolean z) {
        sC = false;
        return false;
    }

    public c(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.sA = adTemplate;
        long jDp = com.kwad.sdk.core.response.b.a.dp(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        this.sz = jDp;
        com.kwad.sdk.core.d.c.d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + jDp);
    }

    public final void ga() {
        com.kwad.sdk.core.d.c.w("PushAdManager", "startRequestPushAd processingPush: " + sC);
        if (sC || this.sA.mAdScene == null) {
            return;
        }
        sC = true;
        com.kwad.components.core.j.a.b(this.sA.mAdScene, new a.InterfaceC0474a() { // from class: com.kwad.components.ad.i.c.1
            @Override // com.kwad.components.core.j.a.InterfaceC0474a
            public final void onRequestResult(int i) {
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0474a
            public final void onError(int i, String str) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onError: " + str);
                c.access$002(false);
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0474a
            public final void f(List<com.kwad.components.core.j.c> list) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onInnerAdLoad: " + list);
                if (list != null && list.size() > 0) {
                    AdTemplate adTemplate = list.get(0).getAdTemplate();
                    if (com.kwad.sdk.core.response.b.a.dn(com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
                        com.kwad.sdk.core.d.c.d("PushAdManager", "loadPushTK");
                        c.this.sD = new d(ServiceProvider.getContext(), adTemplate);
                        return;
                    }
                    c.access$002(false);
                    com.kwad.sdk.core.d.c.d("PushAdManager", "pushAdInfo templateId invalid");
                    return;
                }
                c.access$002(false);
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.oS().isShowing()) {
            com.kwad.components.core.e.a.e.oS().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.i.c.2
                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void gd() {
                    com.kwad.components.core.e.a.e.oS().b(this);
                    c.this.gb();
                }
            });
        } else {
            gb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb() {
        d dVar;
        if (!b.fW().fY()) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        sC = false;
        if (this.sB || (dVar = this.sD) == null || !dVar.gg()) {
            return;
        }
        this.sB = true;
        this.sD.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.i.c.3
            @Override // com.kwad.components.ad.b.a.b
            public final void Y() {
                ag.bz(System.currentTimeMillis());
                e.gj().gf();
            }

            @Override // com.kwad.components.ad.b.a.b
            public final void Z() {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onAdClose: ");
                e.gj().gh();
                b.fW().a(c.this);
            }
        });
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.sA)) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.sz + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.supportPushAd()) {
            a(1000001, this, this.sz);
        }
    }

    public final void gc() {
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: ");
        if (sy.hasMessages(1000001)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        a(1000002, this, 500L);
    }

    private static void a(int i, Runnable runnable, long j) {
        Handler handler = sy;
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.what = i;
        handler.sendMessageDelayed(messageObtain, j);
    }
}
