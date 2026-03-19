package com.kwad.components.core.playable;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bm;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bx;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements p {
    private final KsAdWebView XG;
    private long XH;
    private int XI;
    private PlayableSource XJ = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<at.b> XK = new CopyOnWriteArrayList();
    private List<KsAdWebView.e> XL = new CopyOnWriteArrayList();
    private com.kwad.components.core.webview.a gB;
    private ba gE;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    public a(KsAdWebView ksAdWebView) {
        this.XG = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.XH = SystemClock.elapsedRealtime();
                a.this.XG.getClientConfig().cI(true);
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().fj(this.mAdTemplate).b(jy()));
        a(ksAdWebView);
    }

    private KsAdWebView.e jy() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                Iterator it = a.this.XL.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onReceivedHttpError(i, str, str2);
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                Iterator it = a.this.XL.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                Iterator it = a.this.XL.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageFinished();
                }
            }
        };
    }

    private static void a(KsAdWebView ksAdWebView) {
        if (Build.VERSION.SDK_INT < 17 || !e.YA()) {
            return;
        }
        ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.XG == null) {
            com.kwad.sdk.core.d.c.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.XI = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        bVar.bLv = this.mRootContainer;
        bVar.Vu = this.mRootContainer;
        bVar.UO = this.XG;
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.XG);
        this.gB = aVar;
        a(bVar, aVar, cVar);
        this.XG.addJavascriptInterface(this.gB, "KwaiAd");
    }

    public final void sd() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    public final void a(at.b bVar) {
        this.XK.add(bVar);
    }

    public final void b(at.b bVar) {
        this.XK.remove(bVar);
    }

    public final void a(KsAdWebView.e eVar) {
        this.XL.add(eVar);
    }

    public final void se() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.XG) == null) {
            return;
        }
        ksAdWebView.getClientConfig().cI(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.XG.loadUrl(url);
        }
        com.kwad.sdk.core.adlog.c.cu(this.mAdTemplate);
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.XG;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.bZ(com.kwad.sdk.core.response.b.e.eP(adTemplate));
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.XJ = playableSource;
        }
        if (this.XG == null) {
            return;
        }
        rD();
        com.kwad.sdk.core.d.c.d("PlayableViewHelper", "showPlayable");
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vd();
        }
        this.XG.setVisibility(0);
        ba baVar2 = this.gE;
        if (baVar2 != null) {
            baVar2.ve();
        }
    }

    public final void iO() {
        com.kwad.sdk.core.d.c.d("PlayableViewHelper", "showPlayable");
        if (this.XG == null) {
            return;
        }
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vf();
        }
        this.XG.setVisibility(8);
        ba baVar2 = this.gE;
        if (baVar2 != null) {
            baVar2.vg();
        }
        this.XG.reload();
    }

    public final boolean sf() {
        return this.XG != null && this.XI == 1;
    }

    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new bm(bVar, cVar, new C0484a(this)));
        aVar.a(new at(new at.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar2) {
                a.this.XI = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.adlog.c.ct(a.this.mAdTemplate);
                }
                Iterator it = a.this.XK.iterator();
                while (it.hasNext()) {
                    ((at.b) it.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new an(bVar));
        aVar.b(new o(bVar));
        aVar.b(new n(bVar));
        this.gE = new ba();
        aVar.a(new ai());
        aVar.a(new ah(bVar));
        aVar.a(new f());
        aVar.a(this.gE);
        aVar.a(new j(this));
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.p
    public final void a(j jVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            jVar.f(this.XJ);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        jVar.bl(adTemplate.adStyle);
    }

    /* renamed from: com.kwad.components.core.playable.a$a, reason: collision with other inner class name */
    static class C0484a implements bm.b {
        private final WeakReference<a> XN;

        public C0484a(a aVar) {
            this.XN = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.bm.b
        public final void ae(int i) {
            a aVar = this.XN.get();
            if (aVar != null) {
                aVar.aX(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i) {
        if (getAdTemplate() == null) {
            return;
        }
        long jYB = e.YB();
        if (jYB <= 0 || SystemClock.elapsedRealtime() - this.XH <= jYB) {
            com.kwad.components.core.e.d.a.a(new a.C0469a(this.mContext).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aF(i).d(this.mRootContainer.getTouchCoords()).as(true));
        }
    }

    private void rD() {
        if (com.kwad.sdk.core.response.b.a.bV(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)) > 0) {
            bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.XG.getClientConfig().cI(true);
                }
            }, com.kwad.sdk.core.response.b.a.bV(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.b.a.bV(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)) == 0) {
            this.XG.getClientConfig().cI(true);
        }
    }
}
