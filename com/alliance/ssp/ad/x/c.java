package com.alliance.ssp.ad.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.alliance.ssp.ad.api.NMNativeADEventListener;
import com.alliance.ssp.ad.api.NMPlayerView;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData;
import com.alliance.ssp.ad.api.nativead.SANativeFeedAdLoadListener;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.c0.b;
import com.alliance.ssp.ad.c0.b.ViewTreeObserverOnScrollChangedListenerC0072b;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.l.l;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.t.i;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.video.f;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* compiled from: NMNativeFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends com.alliance.ssp.ad.x.a implements f.a {
    public c D0;
    public boolean E0;
    public View F0;
    public NMNativeADEventListener G0;
    public boolean H0;
    public com.alliance.ssp.ad.c0.b I0;
    public boolean J0;
    public boolean K0;
    public int L0;
    public boolean M0;
    public int N0;
    public int O0;
    public String P0;
    public String Q0;
    public VideoController R0;
    public View S0;
    public Handler T0;
    public SAAllianceAdData U0;
    public String V0;
    public boolean W0;
    public boolean X0;
    public float Y0;
    public int Z0;
    public boolean a1;
    public boolean b1;
    public Handler c1;
    public boolean d1;
    public boolean e1;
    public final Object f1;
    public l g1;
    public com.alliance.ssp.ad.m0.a h1;
    public boolean i1;
    public boolean j1;
    public boolean k1;
    public boolean l1;
    public boolean m1;
    public boolean n1;

    /* compiled from: NMNativeFeedAdImpl.java */
    public class b implements b.a {
        public b() {
        }

        @Override // com.alliance.ssp.ad.c0.b.a
        public void a(float f) throws JSONException, PackageManager.NameNotFoundException, IOException {
            c cVar = c.this;
            cVar.N0 = Math.max(cVar.N0, (int) f);
            c.this.e0 = com.alliance.ssp.ad.a.b.a("").append(c.this.N0).toString();
            if (f >= 50.0f) {
                c cVar2 = c.this;
                if (!cVar2.H0) {
                    c.b(cVar2, true);
                    l lVar = c.this.g1;
                    if (lVar != null) {
                        lVar.c();
                    }
                    c.this.H0 = true;
                    c cVar3 = c.this;
                    if (!cVar3.d1) {
                        cVar3.G();
                    }
                }
            }
            if (f < 50.0f) {
                c cVar4 = c.this;
                if (cVar4.H0) {
                    c.b(cVar4, false);
                    l lVar2 = c.this.g1;
                    if (lVar2 != null) {
                        lVar2.b();
                    }
                    c.this.H0 = false;
                }
            }
        }
    }

    /* compiled from: NMNativeFeedAdImpl.java */
    /* renamed from: com.alliance.ssp.ad.x.c$c, reason: collision with other inner class name */
    public class HandlerC0099c extends Handler {
        public HandlerC0099c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            try {
                if (c.this.F0.getVisibility() == 0) {
                    c cVar = c.this;
                    if (cVar.a1) {
                        com.alliance.ssp.ad.c0.b bVar = cVar.I0;
                        if (bVar == null) {
                            cVar.G();
                            return;
                        }
                        float fA = bVar.a(cVar.F0);
                        c.this.H0 = fA >= 50.0f;
                        c cVar2 = c.this;
                        if (cVar2.H0) {
                            cVar2.G();
                            return;
                        }
                        return;
                    }
                }
                c cVar3 = c.this;
                int i = cVar3.L0 + 100;
                cVar3.L0 = i;
                if (i >= 3000) {
                    return;
                }
                cVar3.c1.sendEmptyMessageDelayed(0, 100L);
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 008: ")), e);
            }
        }
    }

    /* compiled from: NMNativeFeedAdImpl.java */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            c.this.S0.setVisibility(0);
        }
    }

    public c(int i, WeakReference<Activity> weakReference, SAAllianceAdParams sAAllianceAdParams, SANativeFeedAdLoadListener sANativeFeedAdLoadListener, com.alliance.ssp.ad.d0.g gVar) {
        super(i, weakReference, "", null, "", sAAllianceAdParams, sANativeFeedAdLoadListener, null, gVar);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.E0 = false;
        this.H0 = true;
        this.J0 = false;
        this.K0 = false;
        this.L0 = 0;
        this.M0 = true;
        this.N0 = 0;
        this.Q0 = "";
        this.W0 = false;
        this.X0 = true;
        this.Y0 = 0.0f;
        this.Z0 = 0;
        this.a1 = false;
        this.b1 = false;
        this.c1 = new HandlerC0099c(Looper.getMainLooper());
        this.d1 = false;
        new d(Looper.getMainLooper());
        this.e1 = false;
        this.f1 = new Object();
        this.g1 = null;
        this.i1 = false;
        this.j1 = false;
        this.k1 = false;
        this.l1 = false;
        this.m1 = false;
        this.n1 = false;
        gVar.h = this;
        this.D0 = this;
        this.P0 = sAAllianceAdParams.getPosId();
        a(sAAllianceAdParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        NMNativeADEventListener nMNativeADEventListener = this.G0;
        if (nMNativeADEventListener != null) {
            nMNativeADEventListener.onAdExposed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMNativeADEventListener nMNativeADEventListener = this.G0;
        if (nMNativeADEventListener == null || this.Z0 == 1) {
            return;
        }
        nMNativeADEventListener.onAdClicked();
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        NMNativeADEventListener nMNativeADEventListener = this.G0;
        if (nMNativeADEventListener != null) {
            nMNativeADEventListener.onAdExposed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        a(this.F0, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.l0.playerView.mListener.onVideoStart();
    }

    public static void a(c cVar, int i, String str, String str2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        Handler handler;
        cVar.getClass();
        try {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            if (cVar.U0 == null || (handler = cVar.T0) == null) {
                cVar.a(i, str, str2);
                i.a(cVar.w, cVar.g.getPosId(), i, str2);
            } else {
                handler.removeCallbacksAndMessages(null);
                cVar.T0.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 002: ")), e);
        }
    }

    public static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.getClass();
        return z;
    }

    public final void E() throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView nMPlayerView;
        try {
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
            if (sAAllianceNativeFeedAdData == null || (nMPlayerView = sAAllianceNativeFeedAdData.playerView) == null || !this.J0 || !nMPlayerView.pauseVideo()) {
                return;
            }
            b("", "", this.h);
            this.b1 = false;
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 013: ")), e);
        }
    }

    public final void F() throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView nMPlayerView;
        try {
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
            if (sAAllianceNativeFeedAdData == null || (nMPlayerView = sAAllianceNativeFeedAdData.playerView) == null || !this.J0 || !nMPlayerView.startVideo() || this.b1) {
                return;
            }
            b(this.h);
            this.b1 = true;
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 014: ")), e);
        }
    }

    public final void G() throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            if (this.d1) {
                return;
            }
            this.d1 = true;
            A();
            t("", "", this.h);
            H();
            this.T = "" + this.F0.getWidth();
            this.U = "" + this.F0.getHeight();
            int[] iArr = new int[2];
            this.F0.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            this.X = "" + i;
            this.Y = "" + i2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.G = "" + jCurrentTimeMillis;
            this.H = String.valueOf((int) (jCurrentTimeMillis / 1000));
            Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
            com.alliance.ssp.ad.t.h hVar = this.E;
            if (hVar != null) {
                hVar.a(contextA, this.P0, this.V0);
            }
            l lVar = this.g1;
            if (lVar != null) {
                lVar.c();
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 009: ")), e);
        }
    }

    public final void H() {
        this.g1 = l.a((long) (Math.max(this.A, ((int) this.Y0) + 1) * 1000.0f), 100L, new l.a() { // from class: com.alliance.ssp.ad.x.c$$ExternalSyntheticLambda1
            @Override // com.alliance.ssp.ad.l.l.a
            public final void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.a(d2, d3);
            }
        });
    }

    public void I() throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
            if (contextA != null && (!(contextA instanceof Activity) || !((Activity) contextA).isFinishing())) {
                SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
                VideoController videoController = new VideoController(contextA, this.Q0, null, sAAllianceNativeFeedAdData != null ? sAAllianceNativeFeedAdData.videoPlayLoop : true, false, this.X0, this);
                this.R0 = videoController;
                this.p = videoController;
                this.S0 = videoController.t;
                return;
            }
            a(8198, "001", "渲染失败，请检查Activity状态。");
            i.a(this.w, this.P0, 8198, "渲染失败，请检查Activity状态。");
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 007: ")), e);
        }
    }

    public final void O() {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            return;
        }
        com.alliance.ssp.ad.m0.a aVar = new com.alliance.ssp.ad.m0.a(new com.alliance.ssp.ad.m0.c() { // from class: com.alliance.ssp.ad.x.c$$ExternalSyntheticLambda0
            @Override // com.alliance.ssp.ad.m0.c
            public final void a(Object obj) {
                this.f$0.a((Intent) obj);
            }
        }, contextA);
        this.h1 = aVar;
        aVar.b("SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(int i) {
    }

    @Override // com.alliance.ssp.ad.t.a
    public void n() throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView nMPlayerView;
        try {
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
            if (sAAllianceNativeFeedAdData != null && (nMPlayerView = sAAllianceNativeFeedAdData.playerView) != null) {
                sAAllianceNativeFeedAdData.isVideoStop = false;
                this.u = false;
                nMPlayerView.setVolumeWithoutReport(this.t);
                this.J0 = true;
                if (this.M0) {
                    this.M0 = false;
                } else if (this.l0.playerView.startVideo() && !this.b1) {
                    this.D0.b(this.h);
                    this.b1 = true;
                }
                l lVar = this.g1;
                if (lVar != null) {
                    lVar.c();
                }
            }
            int i = com.alliance.ssp.ad.o0.l.a;
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 012: ")), e);
        }
    }

    @Override // com.alliance.ssp.ad.t.a
    public void o() throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView nMPlayerView;
        try {
            this.M0 = false;
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
            if (sAAllianceNativeFeedAdData != null && (nMPlayerView = sAAllianceNativeFeedAdData.playerView) != null) {
                sAAllianceNativeFeedAdData.isVideoStop = true;
                if (!this.u) {
                    this.t = nMPlayerView.getVolume();
                }
                E();
                this.J0 = false;
            }
            l lVar = this.g1;
            if (lVar != null) {
                lVar.b();
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 011: ")), e);
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onError(MediaPlayer mediaPlayer, int i, int i2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i3 = com.alliance.ssp.ad.o0.l.a;
        a("Show failure", 100006, "1", "素材不可用");
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.f.a("NMNativeFeedAdImpl 006: 视频错误，what = ", i), (Exception) null);
        b(100006, "1", "视频素材出现错误");
        q("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }

    @Override // com.alliance.ssp.ad.t.a
    public void q() throws JSONException, PackageManager.NameNotFoundException, IOException {
        F();
    }

    @Override // com.alliance.ssp.ad.t.a
    public void r() throws JSONException, PackageManager.NameNotFoundException, IOException {
        F();
    }

    public final void b(View view) {
        if (view == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        com.alliance.ssp.ad.c0.b bVar = new com.alliance.ssp.ad.c0.b();
        bVar.a = view;
        bVar.c = new b();
        bVar.b = bVar.new ViewTreeObserverOnScrollChangedListenerC0072b();
        view.getViewTreeObserver().addOnScrollChangedListener(bVar.b);
        this.I0 = bVar;
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(MediaPlayer mediaPlayer) throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView nMPlayerView;
        try {
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
            if (sAAllianceNativeFeedAdData == null || (nMPlayerView = sAAllianceNativeFeedAdData.playerView) == null || this.i1) {
                return;
            }
            this.i1 = true;
            nMPlayerView.videoIsPrepared();
            this.D0.l("", "", this.h);
            this.D0.s();
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 015: ")), e);
        }
    }

    public static void a(c cVar, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        cVar.getClass();
        try {
            if (sAAllianceAdData == null) {
                cVar.h = sAAllianceAdData2;
                cVar.V0 = cVar.w;
            } else if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                cVar.h = sAAllianceAdData2;
                cVar.V0 = cVar.w;
            } else {
                cVar.h = sAAllianceAdData;
                cVar.V0 = sAAllianceAdData.getRequestid();
                cVar.h.setParentCrequestid(sAAllianceAdData.getRequestid());
            }
            cVar.h.setCrequestid(cVar.w);
            cVar.E.a(cVar.P0, cVar.V0);
            int i = com.alliance.ssp.ad.o0.l.a;
            cVar.h.setSpostype(Integer.parseInt(cVar.j0));
            cVar.Z0 = cVar.h.getClickCallbackSwitch();
            float validExposeTime = cVar.h.getValidExposeTime();
            cVar.Y0 = validExposeTime;
            if (validExposeTime <= 0.0f) {
                cVar.Y0 = 1.0f;
            }
            String tagCode = cVar.h.getTagCode();
            if (tagCode != null && !tagCode.isEmpty()) {
                cVar.o = tagCode;
            }
            if (cVar.h.getMaterial() == null) {
                cVar.a(8196, "001", "广告素材为空，请联系运营检查代码位ID配置情况。01");
                i.a(cVar.w, cVar.P0, 8196, "广告素材为空，请联系运营检查代码位ID配置情况。01");
                return;
            }
            String videourl = cVar.h.getMaterial().getVideourl();
            cVar.Q0 = videourl;
            if (videourl != null && !videourl.isEmpty()) {
                cVar.E0 = true;
                cVar.I();
            } else {
                cVar.E0 = false;
            }
            String price = cVar.h.getPrice();
            if (price != null) {
                price.isEmpty();
            }
            SAAllianceAdParams sAAllianceAdParams = cVar.g;
            if (sAAllianceAdParams != null && sAAllianceAdParams.getUserId() != null && !cVar.g.getUserId().isEmpty()) {
                cVar.h.setUserId(cVar.g.getUserId());
            }
            h hVar = new h();
            hVar.g = cVar.h;
            hVar.h = cVar.D0;
            cVar.a(hVar);
            i.a(cVar.w, cVar.P0);
            cVar.W0 = true;
        } catch (Exception e) {
            e.toString();
            int i2 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 003: ")), e);
            cVar.a(8194, "001", "渲染失败。");
            i.a(cVar.w, cVar.P0, 8194, "渲染失败。");
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) {
        sAAllianceAdParams.getPosId();
        int i = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        SAAllianceAdData sAAllianceAdDataA = a(contextA, this.P0);
        this.U0 = sAAllianceAdDataA;
        if (sAAllianceAdDataA != null) {
            long jA = this.E.a(contextA, this.P0);
            this.U0.getRequestid();
            this.U0.getPriceD();
            com.alliance.ssp.ad.x.d dVar = new com.alliance.ssp.ad.x.d(this, Looper.getMainLooper());
            this.T0 = dVar;
            dVar.sendEmptyMessageDelayed(0, jA);
        }
        sAAllianceAdParams.setImageAcceptedWidth(SAAllianceAdParams.Screen_Width);
        sAAllianceAdParams.setImageAcceptedHeight(SAAllianceAdParams.Screen_Height);
        this.X0 = sAAllianceAdParams.getMute();
        sAAllianceAdParams.setSpostype(3);
        com.alliance.ssp.ad.http.action.b bVar = new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 1, new a(contextA), BaseNetAction.Method.POST);
        i.a(this.w, this.P0, null, "1", "原生-自渲染");
        bVar.a();
    }

    /* compiled from: NMNativeFeedAdImpl.java */
    public class a implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(SAAllianceEngineData sAAllianceEngineData) throws JSONException, PackageManager.NameNotFoundException, IOException {
            SAAllianceEngineData sAAllianceEngineData2 = sAAllianceEngineData;
            if (sAAllianceEngineData2 == null) {
                c.a(c.this, 8193, "002", "无广告填充，请联系技术进行排查。");
                return;
            }
            try {
                List<SAAllianceAdData> data = sAAllianceEngineData2.getData();
                if (data == null) {
                    c.a(c.this, sAAllianceEngineData2.getCode(), "001", sAAllianceEngineData2.getMessage());
                    return;
                }
                if (data.size() > 0 && sAAllianceEngineData2.getData() != null && !sAAllianceEngineData2.getData().isEmpty()) {
                    SAAllianceAdData sAAllianceAdData = data.get(0);
                    c.this.O0 = sAAllianceAdData.getLoadtype();
                    c cVar = c.this;
                    if (cVar.O0 == 0) {
                        cVar.a(8195, "001", "广告渲染方式和代码位ID类型不符，请联系运营排查。");
                        c cVar2 = c.this;
                        i.a(cVar2.w, cVar2.P0, 8195, "广告渲染方式和代码位ID类型不符，请联系运营排查。");
                        Handler handler = c.this.T0;
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                            c.this.T0 = null;
                            return;
                        }
                        return;
                    }
                    sAAllianceAdData.setDeadlineTime(cVar.E.a(sAAllianceAdData.getCacheTimeout()));
                    sAAllianceAdData.setPriceD(c.this.E.a(sAAllianceAdData.getPrice()));
                    c cVar3 = c.this;
                    com.alliance.ssp.ad.t.h hVar = cVar3.E;
                    if (hVar != null) {
                        hVar.a(this.a, cVar3.P0, sAAllianceAdData.getWaitLoadTimeout());
                        if (sAAllianceAdData.isNeedCache()) {
                            sAAllianceAdData.setRequestid(c.this.w);
                            c cVar4 = c.this;
                            cVar4.E.a(this.a, sAAllianceAdData, cVar4.P0);
                        }
                    }
                    c cVar5 = c.this;
                    if (cVar5.W0) {
                        return;
                    }
                    Handler handler2 = cVar5.T0;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                        c.this.T0 = null;
                    }
                    c cVar6 = c.this;
                    c.a(cVar6, cVar6.U0, sAAllianceAdData);
                    return;
                }
                c.a(c.this, sAAllianceEngineData2.getCode(), "003", sAAllianceEngineData2.getMessage());
            } catch (Exception e) {
                e.toString();
                int i = com.alliance.ssp.ad.o0.l.a;
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 001: ")), e);
                c.this.a(8194, "001", "渲染失败。");
                c cVar7 = c.this;
                i.a(cVar7.w, cVar7.P0, 8194, "渲染失败。");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            c.a(c.this, 100005, "001", str);
        }
    }

    public final void a(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            this.J0 = true;
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
            sAAllianceNativeFeedAdData.firstPlayReport = true;
            if (sAAllianceNativeFeedAdData != null && sAAllianceNativeFeedAdData.playerView != null) {
                sAAllianceNativeFeedAdData.isVideoStop = false;
                F();
            }
            b(view);
            if (this.K0) {
                return;
            }
            this.K0 = true;
            this.c1.sendEmptyMessageDelayed(0, 50L);
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData2 = this.l0;
            if (!sAAllianceNativeFeedAdData2.firstPlayReport) {
                sAAllianceNativeFeedAdData2.firstPlayReport = true;
                sAAllianceNativeFeedAdData2.isVideoStop = false;
                VideoController videoController = this.R0;
                if (videoController != null && videoController.i() && !this.b1) {
                    this.D0.b(this.h);
                    this.b1 = true;
                }
            }
            if (this.R0 != null) {
                SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData3 = this.l0;
                if (sAAllianceNativeFeedAdData3.firstMuteReport) {
                    return;
                }
                sAAllianceNativeFeedAdData3.firstMuteReport = true;
                this.D0.j("", "", this.h);
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 006: ")), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            synchronized (this.f1) {
                if (!this.e1 && ((float) d2) >= this.Y0) {
                    B();
                    n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.x.c$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.L();
                        }
                    });
                    this.e1 = true;
                }
            }
            float f = this.A;
            if (f > 0.0f && ((float) d2) == f && b()) {
                n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.x.c$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.M();
                    }
                });
                if (a("unuser", 0)) {
                    c(1);
                    E();
                    l lVar = this.g1;
                    if (lVar != null) {
                        lVar.b();
                    }
                    this.B = true;
                }
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 010: ")), e);
        }
    }

    public final boolean a(String str, int i) throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.x = str;
        this.D = i == 1;
        if (!this.d1) {
            G();
        }
        synchronized (this.f1) {
            if (!this.e1) {
                B();
                n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.x.c$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.J();
                    }
                });
                this.e1 = true;
            }
        }
        boolean zA = a(this.h.getMaterial(), this.h, true);
        if (zA) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.x.c$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                    this.f$0.K();
                }
            });
            O();
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        l lVar = this.g1;
        if (lVar != null) {
            lVar.c();
        }
        this.h1.a();
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a() throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView nMPlayerView;
        try {
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.l0;
            if (sAAllianceNativeFeedAdData == null || (nMPlayerView = sAAllianceNativeFeedAdData.playerView) == null) {
                return;
            }
            if (nMPlayerView.mListener != null) {
                n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.x.c$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.N();
                    }
                });
            }
            if (this.b1) {
                return;
            }
            b(this.h);
            this.b1 = true;
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 016: ")), e);
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(int i) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (i >= 25) {
            try {
                if (!this.j1) {
                    this.j1 = true;
                    g("", "", this.h);
                }
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 017: ")), e);
                return;
            }
        }
        if (i >= 50 && !this.k1) {
            this.k1 = true;
            i("", "", this.h);
        }
        if (i >= 50 && !this.l1) {
            this.l1 = true;
            y();
        }
        if (i >= 75 && !this.m1) {
            this.m1 = true;
            n("", "", this.h);
        }
        if (!this.n1 && i >= 99) {
            this.n1 = true;
            p("", "", this.h);
            this.b1 = false;
            if (this.l1) {
                this.l1 = false;
            }
        }
        if (!this.n1 || i < 1 || this.b1) {
            return;
        }
        this.n1 = false;
        b(this.h);
        this.b1 = true;
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(MediaPlayer mediaPlayer) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            int i = com.alliance.ssp.ad.o0.l.a;
            this.w0 = false;
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 018: ")), e);
        }
    }
}
