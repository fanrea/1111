package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.h;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends b implements com.kwad.sdk.widget.e {
    private KsAdVideoPlayConfig dG;
    private List<Integer> dX;
    private com.kwad.sdk.core.video.videoview.a ed;
    private a.InterfaceC0593a em;
    private KSFrameLayout hn;
    private ImageView jF;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    private KSFrameLayout oZ;
    private c oa;
    private h pa;
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0488a jJ = new a.InterfaceC0488a() { // from class: com.kwad.components.ad.interstitial.f.f.4
        /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
        @Override // com.kwad.components.core.video.a.InterfaceC0488a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r11, com.kwad.sdk.utils.aj.a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L15
                if (r11 == r0) goto L12
                r3 = 3
                if (r11 == r3) goto Ld
                r11 = 108(0x6c, float:1.51E-43)
                goto L17
            Ld:
                r11 = 83
                r2 = r1
                r3 = r2
                goto L18
            L12:
                r11 = 82
                goto L17
            L15:
                r11 = 13
            L17:
                r3 = r0
            L18:
                com.kwad.components.ad.interstitial.f.f r4 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.ad.interstitial.f.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.aq.apb()
                if (r4 == 0) goto L24
                goto L25
            L24:
                r0 = r1
            L25:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.eT()
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.f.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.aC(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.ad.interstitial.f.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.aG(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.aq(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.as(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.aF(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.aI(r0)
                com.kwad.components.ad.interstitial.f.f$4$1 r0 = new com.kwad.components.ad.interstitial.f.f$4$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.AnonymousClass4.a(int, com.kwad.sdk.utils.aj$a):void");
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.oZ = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.hn = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.jF = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.hn.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() throws Resources.NotFoundException {
        super.ay();
        c cVar = (c) amf();
        this.oa = cVar;
        this.dG = cVar.dG;
        AdTemplate adTemplate = this.oa.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.mAdInfo = adInfoEP;
        this.dX = com.kwad.sdk.core.response.b.a.bv(adInfoEP);
        com.kwad.sdk.core.video.videoview.a aVar = this.oa.ed;
        this.ed = aVar;
        aVar.setTag(this.dX);
        h hVar = new h(this.mContext, this.mAdTemplate, this.ed);
        this.pa = hVar;
        hVar.setDataFlowAutoStart(this.dG.isDataFlowAutoStart());
        this.pa.setAdClickListener(this.jJ);
        this.pa.tS();
        this.mApkDownloadHelper = this.oa.mApkDownloadHelper;
        eC();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.hn.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.oa.oi = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    private void eC() {
        String strGa;
        this.mIsAudioEnable = this.dG.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.jF.setImageDrawable(null);
            KSImageLoader.loadImage(this.jF, url, this.mAdTemplate);
            this.jF.setVisibility(0);
        } else {
            this.jF.setVisibility(8);
        }
        int iUw = com.kwad.sdk.core.config.e.Uw();
        String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        if (iUw < 0) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(strL);
            if (fileDw == null || !fileDw.exists()) {
                strL = null;
            } else {
                strGa = fileDw.getAbsolutePath();
                strL = strGa;
            }
        } else if (iUw != 0) {
            com.kwad.sdk.core.videocache.f fVarCh = com.kwad.sdk.core.videocache.c.a.ch(this.mContext);
            if (com.kwad.sdk.core.config.e.XE()) {
                int iUw2 = com.kwad.sdk.core.config.e.Uw();
                if (!fVarCh.gc(strL)) {
                    if (fVarCh.a(strL, iUw2 * 1024, new a.C0589a(), null)) {
                        strGa = fVarCh.ga(strL);
                    }
                } else {
                    strGa = fVarCh.ga(strL);
                }
                strL = strGa;
            } else {
                strL = fVarCh.ga(strL);
            }
        }
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.ed.a(new b.a(this.mAdTemplate).ew(strL).ex(com.kwad.sdk.core.response.b.h.e(com.kwad.sdk.core.response.b.e.eQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).WR(), null);
        a.InterfaceC0593a interfaceC0593a = new a.InterfaceC0593a() { // from class: com.kwad.components.ad.interstitial.f.f.1
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0593a
            public final com.kwad.sdk.core.video.a.c aw() {
                int i = Build.VERSION.SDK_INT;
                return null;
            }
        };
        this.em = interfaceC0593a;
        this.ed.setExternalPlayerListener(interfaceC0593a);
        this.ed.setVideoSoundEnable(this.mIsAudioEnable);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.components.ad.interstitial.report.d.eZ().F(this.mAdTemplate);
        this.pa.setVideoPlayCallback(new h.a() { // from class: com.kwad.components.ad.interstitial.f.f.2
            private boolean gq = false;

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                f.this.c(j);
                Iterator<a.c> it = f.this.oa.ok.iterator();
                while (it.hasNext()) {
                    it.next().d(j);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.cm(f.this.mAdTemplate);
                com.kwad.components.ad.interstitial.report.d.eZ().b(f.this.mAdTemplate, System.currentTimeMillis() - jCurrentTimeMillis);
                com.kwad.components.ad.interstitial.report.b.eV().y(f.this.mAdTemplate);
                if (!f.this.oa.oe && f.this.oa.mH != null) {
                    f.this.oa.mH.onVideoPlayStart();
                }
                Iterator<a.c> it = f.this.oa.ok.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayStart();
                }
                f.this.oa.om = false;
            }

            @Override // com.kwad.components.core.video.h.a
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.interstitial.report.d.eZ().b(f.this.mAdTemplate, i, String.valueOf(i2));
                if (f.this.oa.mH != null) {
                    f.this.oa.mH.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void au() {
                if (!this.gq) {
                    this.gq = true;
                    com.kwad.components.core.q.a.ss().a(f.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                Iterator<a.c> it = f.this.oa.ok.iterator();
                while (it.hasNext()) {
                    it.next().au();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                com.kwad.sdk.core.adlog.c.cn(f.this.mAdTemplate);
                if (!f.this.oa.oe && f.this.oa.mH != null) {
                    f.this.oa.mH.onVideoPlayEnd();
                }
                Iterator<a.c> it = f.this.oa.ok.iterator();
                while (it.hasNext()) {
                    it.next().av();
                }
                f.this.oa.om = true;
            }
        });
        this.ed.setController(this.pa);
        this.hn.setClickable(true);
        new j(this.hn.getContext(), this.hn, this);
        this.hn.addView(this.ed);
        this.oa.oi = new c.e() { // from class: com.kwad.components.ad.interstitial.f.f.3
            @Override // com.kwad.components.ad.interstitial.f.c.e
            public final void eh() {
                if (f.this.ed != null) {
                    f.this.ed.restart();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.dX.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j) {
        this.oa.oc = true;
        this.oa.c(1L, j);
    }

    private c.C0420c c(View view, boolean z) {
        return new c.C0420c(view.getContext()).l(z).a(this.oZ.getTouchCoords()).L(3).M(85);
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        this.oa.a(c(view, true));
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        this.oa.a(c(view, false));
    }
}
