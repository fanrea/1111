package com.alliance.ssp.ad.impl.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.api.BaseAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.YTAdInfo;
import com.alliance.ssp.ad.api.banner.SABannerAdInteractionListener;
import com.alliance.ssp.ad.api.banner.SABannerAdLoadListener;
import com.alliance.ssp.ad.bean.Interaction;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.d0.g;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.l.l;
import com.alliance.ssp.ad.o0.j;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.r.i;
import com.alliance.ssp.ad.t.h;
import com.alliance.ssp.ad.u.f;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* compiled from: NMBannerAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends com.alliance.ssp.ad.u.a {
    public ImageView D0;
    public ImageView E0;
    public ImageView F0;
    public ImageView G0;
    public ImageView H0;
    public f I0;
    public Bitmap J0;
    public LinearLayout K0;
    public RelativeLayout L0;
    public RelativeLayout M0;
    public TextView N0;
    public TextView O0;
    public View P0;
    public long Q0;
    public a R0;
    public View.OnAttachStateChangeListener S0;
    public j.b T0;
    public View.OnClickListener U0;
    public View.OnClickListener V0;
    public View.OnClickListener W0;
    public View.OnClickListener X0;
    public i.a Y0;
    public Material Z0;
    public String a1;
    public ViewGroup b1;
    public int c1;
    public String d1;
    public Handler e1;
    public Handler f1;
    public SAAllianceAdData g1;
    public String h1;
    public boolean i1;
    public int j1;
    public l k1;
    public int l1;
    public View m1;
    public com.alliance.ssp.ad.m0.a n1;

    /* compiled from: NMBannerAdImpl.java */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            if (!a.this.a1.isEmpty()) {
                a aVar = a.this;
                com.alliance.ssp.ad.o0.d.a(aVar.f, aVar.D0, aVar.a1, 0.7f);
            }
            a aVar2 = a.this;
            int i = com.alliance.ssp.ad.o0.l.a;
            aVar2.a(1, 0, (String) null);
            a.this.B();
            a aVar3 = a.this;
            aVar3.t("", "", aVar3.h);
            a.this.F();
            l lVar = a.this.k1;
            if (lVar != null) {
                lVar.c();
            }
            Context contextA = com.alliance.ssp.ad.o0.b.a(a.this.f);
            a aVar4 = a.this;
            h hVar = aVar4.E;
            if (hVar != null) {
                hVar.a(contextA, aVar4.d1, aVar4.h1);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a.this.p();
            a.this.I();
        }
    }

    public a(int i, WeakReference<Activity> weakReference, ViewGroup viewGroup, SAAllianceAdParams sAAllianceAdParams, SABannerAdLoadListener sABannerAdLoadListener, g gVar) {
        super(i, weakReference, "", "", viewGroup, sAAllianceAdParams, sABannerAdLoadListener, null, gVar);
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = null;
        this.Q0 = 0L;
        this.R0 = null;
        this.a1 = "";
        this.c1 = 0;
        new AtomicInteger(0);
        this.i1 = false;
        this.j1 = 0;
        this.k1 = null;
        this.l1 = 0;
        gVar.b = this;
        this.R0 = this;
        a(sAAllianceAdParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        a(this.D0, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.A <= 0.0f && b()) {
            a(this.D0, (String) null);
            this.Z0.getLdptype();
            if (a("close_button", 0)) {
                this.B = true;
                c(2);
                l lVar = this.k1;
                if (lVar != null) {
                    lVar.b();
                    return;
                }
                return;
            }
        }
        if (this.I0 != null) {
            a(3, 0, (String) null);
            p();
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        a("user", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        a("user", 1);
    }

    public final void E() {
        this.S0 = new b();
        this.T0 = new c();
        this.U0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        };
        this.V0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        };
        this.W0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        };
        this.X0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.e(view);
            }
        };
        this.Y0 = new d();
    }

    public final void F() {
        float f = this.A;
        if (f > 0.0f) {
            this.k1 = l.a((long) (f * 1000.0f), 100L, new l.a() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda3
                @Override // com.alliance.ssp.ad.l.l.a
                public final void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
                    this.f$0.a(d2, d3);
                }
            });
        }
    }

    public final void H() {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            return;
        }
        com.alliance.ssp.ad.m0.a aVar = new com.alliance.ssp.ad.m0.a(new com.alliance.ssp.ad.m0.c() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda2
            @Override // com.alliance.ssp.ad.m0.c
            public final void a(Object obj) {
                this.f$0.a((Intent) obj);
            }
        }, contextA);
        this.n1 = aVar;
        aVar.b("SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }

    public final void I() {
        com.alliance.ssp.ad.m0.a aVar = this.n1;
        if (aVar != null) {
            aVar.a();
        }
        l lVar = this.k1;
        if (lVar != null) {
            lVar.d();
        }
    }

    public final void a(final int i, final int i2, final String str) {
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(i, i2, str);
            }
        });
    }

    @Override // com.alliance.ssp.ad.t.a
    public void n() {
        l lVar = this.k1;
        if (lVar != null) {
            lVar.c();
        }
    }

    @Override // com.alliance.ssp.ad.t.a
    public void o() {
        l lVar = this.k1;
        if (lVar != null) {
            lVar.b();
        }
    }

    @Override // com.alliance.ssp.ad.t.a
    public void q() {
    }

    @Override // com.alliance.ssp.ad.t.a
    public void r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.A <= 0.0f && b()) {
            a(this.D0, (String) null);
            this.Z0.getLdptype();
            if (a("close_button", 0)) {
                this.B = true;
                c(2);
                l lVar = this.k1;
                if (lVar != null) {
                    lVar.b();
                    return;
                }
                return;
            }
        }
        if (this.I0 != null) {
            a(3, 0, (String) null);
            p();
            I();
        }
    }

    /* compiled from: NMBannerAdImpl.java */
    public class c implements j.b {
        public c() {
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(int i) {
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(File file) {
            a.this.a1 = file.getAbsolutePath() + "/aaaccc.gif";
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(Exception exc) {
            Objects.toString(exc);
            int i = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public static void a(a aVar, int i, String str, String str2) {
        Handler handler;
        aVar.getClass();
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (aVar.g1 != null && (handler = aVar.f1) != null) {
            handler.removeCallbacksAndMessages(null);
            aVar.f1.sendEmptyMessage(0);
        } else {
            aVar.a(i, str, str2);
            com.alliance.ssp.ad.t.i.a(aVar.w, aVar.d1, i, str2);
        }
    }

    public static void a(a aVar, String str) {
        SAAllianceAdData sAAllianceAdDataCopy;
        aVar.getClass();
        int i = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(aVar.f);
        if (contextA == null || (sAAllianceAdDataCopy = aVar.h.copy()) == null) {
            return;
        }
        if (sAAllianceAdDataCopy.getMaterial() == null) {
            sAAllianceAdDataCopy.setMaterial(new Material(null));
        }
        sAAllianceAdDataCopy.getMaterial().setLdp(str);
        if (sAAllianceAdDataCopy.getInteraction() == null) {
            sAAllianceAdDataCopy.setInteraction(new Interaction(null));
        }
        sAAllianceAdDataCopy.setInteraction(aVar.h.getInteraction());
        Intent intent = new Intent(contextA, (Class<?>) SAAllianceWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("extra_name_land_page_ad_data", sAAllianceAdDataCopy);
        contextA.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        SABannerAdInteractionListener sABannerAdInteractionListener;
        synchronized (f.g) {
            try {
                f fVar = this.I0;
                if (fVar != null && (sABannerAdInteractionListener = fVar.c) != null) {
                    if (i == 0) {
                        sABannerAdInteractionListener.onAdError(i2, str);
                    } else if (i == 1) {
                        sABannerAdInteractionListener.onAdShow();
                    } else if (i != 2) {
                        if (i == 3) {
                            sABannerAdInteractionListener.onAdClose();
                        }
                    } else if (this.j1 != 1) {
                        sABannerAdInteractionListener.onAdClick();
                        x();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(final a aVar, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) {
        aVar.getClass();
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.e1 = new com.alliance.ssp.ad.u.c(aVar, Looper.getMainLooper());
            }
            aVar.E();
            if (sAAllianceAdData == null) {
                aVar.h = sAAllianceAdData2;
                aVar.h1 = aVar.w;
            } else if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                aVar.h = sAAllianceAdData2;
                aVar.h1 = aVar.w;
            } else {
                aVar.h = sAAllianceAdData;
                aVar.h1 = sAAllianceAdData.getRequestid();
                aVar.h.setParentCrequestid(sAAllianceAdData.getRequestid());
            }
            aVar.h.setCrequestid(aVar.w);
            aVar.E.a(aVar.d1, aVar.h1);
            int i = com.alliance.ssp.ad.o0.l.a;
            aVar.h.setSpostype(Integer.parseInt(aVar.j0));
            aVar.j1 = aVar.h.getClickCallbackSwitch();
            String tagCode = aVar.h.getTagCode();
            if (tagCode != null && !tagCode.isEmpty()) {
                aVar.o = tagCode;
            }
            String price = aVar.h.getPrice();
            aVar.s = price;
            if (price == null || price.isEmpty()) {
                aVar.s = "-1";
            }
            SAAllianceAdParams sAAllianceAdParams = aVar.g;
            if (sAAllianceAdParams != null && sAAllianceAdParams.getUserId() != null && !aVar.g.getUserId().isEmpty()) {
                aVar.h.setUserId(aVar.g.getUserId());
            }
            f fVar = new f(aVar.v, aVar.R0);
            aVar.I0 = fVar;
            fVar.a = aVar.s;
            fVar.b = new YTAdInfo(new ArrayList<String>() { // from class: com.alliance.ssp.ad.impl.banner.NMBannerAdImpl$3
                {
                    if (this.this$0.h.getMaterial() != null) {
                        add(this.this$0.h.getMaterial().getAdm());
                    }
                }
            });
            aVar.a((BaseAllianceAd) aVar.I0);
            com.alliance.ssp.ad.t.i.a(aVar.w, aVar.d1);
            aVar.i1 = true;
            System.currentTimeMillis();
            SAAllianceAdData sAAllianceAdData3 = aVar.h;
            aVar.t();
            i.a().a(sAAllianceAdData3.getMaterial().getAdm(), aVar.Y0);
        } catch (Exception e) {
            e.getMessage();
            int i2 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMBannerAdImpl 001: ")), e);
            aVar.a(8194, "001", "渲染失败。");
            com.alliance.ssp.ad.t.i.a(aVar.w, aVar.d1, 8194, "渲染失败。");
        }
    }

    /* compiled from: NMBannerAdImpl.java */
    /* renamed from: com.alliance.ssp.ad.impl.banner.a$a, reason: collision with other inner class name */
    public class C0086a implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ Context a;

        public C0086a(Context context) {
            this.a = context;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(SAAllianceEngineData sAAllianceEngineData) throws JSONException, PackageManager.NameNotFoundException, IOException {
            SAAllianceEngineData sAAllianceEngineData2 = sAAllianceEngineData;
            if (sAAllianceEngineData2 == null) {
                a.a(a.this, 8193, "002", "无广告填充，请联系技术进行排查。");
                return;
            }
            try {
                List<SAAllianceAdData> data = sAAllianceEngineData2.getData();
                if (data == null) {
                    a.a(a.this, sAAllianceEngineData2.getCode(), "001", sAAllianceEngineData2.getMessage());
                    return;
                }
                if (data.size() > 0 && sAAllianceEngineData2.getData() != null && !sAAllianceEngineData2.getData().isEmpty()) {
                    for (SAAllianceAdData sAAllianceAdData : data) {
                        sAAllianceAdData.setDeadlineTime(a.this.E.a(sAAllianceAdData.getCacheTimeout()));
                        sAAllianceAdData.setPriceD(a.this.E.a(sAAllianceAdData.getPrice()));
                        a aVar = a.this;
                        h hVar = aVar.E;
                        if (hVar != null) {
                            hVar.a(this.a, aVar.d1, sAAllianceAdData.getWaitLoadTimeout());
                            if (sAAllianceAdData.isNeedCache()) {
                                sAAllianceAdData.setRequestid(a.this.w);
                                a aVar2 = a.this;
                                aVar2.E.a(this.a, sAAllianceAdData, aVar2.d1);
                            }
                        }
                        a aVar3 = a.this;
                        if (!aVar3.i1) {
                            Handler handler = aVar3.f1;
                            if (handler != null) {
                                handler.removeCallbacksAndMessages(null);
                                a.this.f1 = null;
                            }
                            a aVar4 = a.this;
                            a.a(aVar4, aVar4.g1, sAAllianceAdData);
                        }
                    }
                    return;
                }
                a.a(a.this, sAAllianceEngineData2.getCode(), "003", sAAllianceEngineData2.getMessage());
            } catch (Exception e) {
                e.getMessage();
                int i = com.alliance.ssp.ad.o0.l.a;
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMBannerAdImpl 001: ")), e);
                a.this.a(8194, "001", "渲染失败。");
                a aVar5 = a.this;
                com.alliance.ssp.ad.t.i.a(aVar5.w, aVar5.d1, 8194, "渲染失败。");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            a.a(a.this, i, "004", str);
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) {
        sAAllianceAdParams.getPosId();
        int i = com.alliance.ssp.ad.o0.l.a;
        this.d1 = sAAllianceAdParams.getPosId();
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        SAAllianceAdData sAAllianceAdDataA = a(contextA, this.d1);
        this.g1 = sAAllianceAdDataA;
        if (sAAllianceAdDataA != null) {
            long jA = this.E.a(contextA, this.d1);
            this.g1.getRequestid();
            this.g1.getPriceD();
            com.alliance.ssp.ad.u.b bVar = new com.alliance.ssp.ad.u.b(this, Looper.getMainLooper());
            this.f1 = bVar;
            bVar.sendEmptyMessageDelayed(0, jA);
        }
        this.Q0 = System.currentTimeMillis();
        sAAllianceAdParams.setImageAcceptedWidth(0);
        sAAllianceAdParams.setImageAcceptedHeight(0);
        sAAllianceAdParams.setSpostype(4);
        com.alliance.ssp.ad.http.action.b bVar2 = new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 0, new C0086a(contextA), BaseNetAction.Method.POST);
        com.alliance.ssp.ad.t.i.a(this.w, this.d1, null, "0", "横幅");
        bVar2.a();
    }

    /* compiled from: NMBannerAdImpl.java */
    public class d implements i.a {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:68:0x0213  */
        @Override // com.alliance.ssp.ad.r.i.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.lang.String r18, android.graphics.Bitmap r19) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
            /*
                Method dump skipped, instructions count: 594
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.impl.banner.a.d.a(java.lang.String, android.graphics.Bitmap):void");
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            a aVar = a.this;
            long jCurrentTimeMillis = System.currentTimeMillis();
            a aVar2 = a.this;
            aVar.Q0 = jCurrentTimeMillis - aVar2.Q0;
            long j = aVar2.Q0;
            int i = com.alliance.ssp.ad.o0.l.a;
            aVar2.b(100006, "1", "加载素材失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            if (((float) d2) == this.A && !this.B && b()) {
                if (!a(this.m1) && this.m1.getVisibility() == 0) {
                    n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.banner.a$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.G();
                        }
                    });
                    if (a("unuser", 0)) {
                        this.B = true;
                        c(1);
                        return;
                    }
                    return;
                }
                int i = com.alliance.ssp.ad.o0.l.a;
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMBannerAdImpl 004: ")), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cb, code lost:
    
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.View r10) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.impl.banner.a.a(android.view.View):boolean");
    }

    public final boolean a(String str, int i) {
        this.x = str;
        this.D = i == 1;
        boolean zA = a(this.Z0, this.h, true);
        if (zA) {
            a(2, 0, (String) null);
            H();
            l lVar = this.k1;
            if (lVar != null) {
                lVar.b();
            }
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        l lVar = this.k1;
        if (lVar != null) {
            lVar.c();
        }
        this.n1.a();
    }
}
