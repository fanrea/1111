package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public KsAdVideoPlayConfig dG;
    public com.kwad.sdk.core.video.videoview.a ed;
    public KSFrameLayout hG;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public com.kwad.components.ad.interstitial.g.b mF;
    public KsInterstitialAd.AdInteractionListener mH;
    public com.kwad.components.ad.interstitial.d mN;
    public com.kwad.components.ad.interstitial.h.d ob;
    public boolean oc;
    public boolean od;
    public boolean oe;
    public a of;
    public com.kwad.components.core.webview.tachikoma.f.g oh;
    public e oi;
    public boolean om;
    public boolean on;
    public List<b> og = new CopyOnWriteArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public volatile boolean ol = false;
    public int oo = -1;
    public List<a.c> ok = new CopyOnWriteArrayList();
    public List<d> oj = new ArrayList();

    public interface a {
        void a(long j, long j2, boolean z);
    }

    public interface b {
        void c(long j, long j2);
    }

    public interface d {
        void eg();
    }

    public interface e {
        void eh();
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void a(a.c cVar) {
        if (this.ok.contains(cVar)) {
            return;
        }
        this.ok.add(cVar);
    }

    public final void b(a.c cVar) {
        this.ok.remove(cVar);
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.ok.clear();
        this.oj.clear();
        com.kwad.components.ad.interstitial.g.b bVar = this.mF;
        if (bVar != null) {
            bVar.wL();
        }
    }

    public final boolean a(final C0420c c0420c) {
        com.kwad.components.ad.interstitial.report.a.eT().a(this.mAdTemplate, 1L, c0420c.oz);
        boolean z = c0420c.eb() == 1;
        boolean z2 = com.kwad.components.ad.interstitial.b.b.dP() || z || c0420c.ed() || c0420c.oD;
        if (z2) {
            com.kwad.components.core.e.d.a.a(new a.C0469a(c0420c.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(z).aE(1).aF(c0420c.oz).A(this.ed.getCurrentPosition()).aG(c0420c.eb()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(c0420c);
                    if (c.this.mN == null || !com.kwad.components.ad.interstitial.d.b.u(c.this.mAdTemplate)) {
                        return;
                    }
                    c cVar = c.this;
                    cVar.a(false, -1, cVar.ed);
                    c.this.mHandler.postDelayed(new bh() { // from class: com.kwad.components.ad.interstitial.f.c.1.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            c.this.mN.dismiss();
                            c.this.ac();
                        }
                    }, 500L);
                }
            }));
        }
        return z2;
    }

    public final void b(C0420c c0420c) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.f(c0420c.getTouchCoords());
        if (!c0420c.ec() && !c0420c.oA) {
            c0420c.M(153);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eP(c0420c.ee()).f(c0420c.getTouchCoords()).fd(aq.apb() ? 2 : 1).o(c0420c.ef()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.ed;
        if (aVar != null) {
            long jA = a(aVar);
            int iB = b(this.ed);
            bVar.aV(jA);
            bVar.eX(iB);
        }
        this.oc = true;
        c(1L, c0420c.oz);
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.ad.interstitial.report.a.eT().a(this.mAdTemplate, 6L, i);
        final int i4 = 9;
        com.kwad.components.core.e.d.a.a(new a.C0469a(context).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aG(2).aE(6).aF(i).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i5 = i4;
                int i6 = i;
                cVar.a(i5, i6, context, 6L, i6);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context, long j, long j2) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eW(i).eP(i2).fd(aq.apb() ? 2 : 1).Xu(), (JSONObject) null);
        this.oc = true;
        c(j, j2);
    }

    public final void ac() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.mH;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.og.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.og.remove(bVar);
    }

    public final void c(long j, long j2) {
        Iterator<b> it = this.og.iterator();
        while (it.hasNext()) {
            it.next().c(j, j2);
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.mH;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        a aVar = this.of;
        if (aVar != null) {
            aVar.a(j, j2, true);
        }
    }

    public final void dY() {
        e eVar = this.oi;
        if (eVar != null) {
            eVar.eh();
        }
    }

    public final void dZ() {
        Iterator<d> it = this.oj.iterator();
        while (it.hasNext()) {
            it.next().eg();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.ba(adInfo) && !aq.apb();
    }

    public final boolean M(Context context) {
        if (this.mAdTemplate == null || context == null) {
            com.kwad.sdk.core.d.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
            return false;
        }
        return com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bA(adInfo).getUrl();
        if (bq.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.c$3, reason: invalid class name */
    final class AnonymousClass3 implements ImageLoadingListener {
        final /* synthetic */ View gh;
        final /* synthetic */ Context val$context;

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }

        AnonymousClass3(Context context, View view) {
            this.val$context = context;
            this.gh = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            h.execute(new bh() { // from class: com.kwad.components.ad.interstitial.f.c.3.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() throws Resources.NotFoundException {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap bitmapStackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.val$context.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.val$context.getResources(), bitmapStackBlur);
                    roundedBitmapDrawableCreate.setCornerRadius(dimension);
                    AnonymousClass3.this.gh.post(new bh() { // from class: com.kwad.components.ad.interstitial.f.c.3.1.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            AnonymousClass3.this.gh.setBackground(roundedBitmapDrawableCreate);
                        }
                    });
                }
            });
        }
    }

    public final boolean ea() {
        com.kwad.components.ad.interstitial.h.d dVar = this.ob;
        boolean z = dVar == null || dVar.getParent() == null;
        com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    public final void c(Context context, AdTemplate adTemplate) {
        if (this.ol) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.ol = true;
    }

    public final void a(boolean z, int i, com.kwad.sdk.core.video.videoview.a aVar) {
        long jA;
        int iA;
        com.kwad.components.ad.interstitial.report.a.eT().a(this.mAdTemplate, ca.m(this.hG, true));
        if (aVar != null) {
            jA = a(aVar);
            iA = b(aVar);
        } else {
            jA = i;
            iA = a(jA, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z ? 14 : 1, jA, iA, this.mN.getTimerHelper().getTime(), null);
    }

    private static long a(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int b(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((currentPosition / duration) * 100.0f);
        }
        return -1;
    }

    private static int a(long j, AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float fN = com.kwad.sdk.core.response.b.a.N(com.kwad.sdk.core.response.b.e.eP(adTemplate)) / 1000.0f;
        if (fN != 0.0f) {
            return Math.round((j / fN) * 100.0f);
        }
        return -1;
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.c$c, reason: collision with other inner class name */
    public static class C0420c {
        private final Context dR;
        private boolean oA;
        private aj.a oB;
        public double oC;
        public boolean oD;
        private int ox;
        private boolean oy;
        private int oz;

        public C0420c(Context context) {
            this.dR = context;
        }

        public final Context getContext() {
            return this.dR;
        }

        public final int eb() {
            return this.ox;
        }

        public final C0420c L(int i) {
            this.ox = i;
            return this;
        }

        public final boolean ec() {
            return this.oy;
        }

        public final C0420c l(boolean z) {
            this.oy = z;
            return this;
        }

        public final boolean ed() {
            return this.oA;
        }

        public final C0420c m(boolean z) {
            this.oA = true;
            return this;
        }

        public final C0420c n(boolean z) {
            this.oD = true;
            return this;
        }

        public final int ee() {
            return this.oz;
        }

        public final C0420c M(int i) {
            this.oz = i;
            return this;
        }

        public final aj.a getTouchCoords() {
            return this.oB;
        }

        public final C0420c a(aj.a aVar) {
            this.oB = aVar;
            return this;
        }

        public final double ef() {
            return this.oC;
        }

        public final C0420c f(double d) {
            this.oC = d;
            return this;
        }
    }
}
