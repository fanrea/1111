package com.alliance.ssp.ad.t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.api.BaseAdLoadListener;
import com.alliance.ssp.ad.api.BaseAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData;
import com.alliance.ssp.ad.api.banner.SABannerAd;
import com.alliance.ssp.ad.api.banner.SABannerAdLoadListener;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdLoadListener;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAd;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdLoadListener;
import com.alliance.ssp.ad.api.nativead.SANativeFeedAdLoadListener;
import com.alliance.ssp.ad.api.reward.SARewardVideoAd;
import com.alliance.ssp.ad.api.reward.SARewardVideoAdLoadListener;
import com.alliance.ssp.ad.api.splash.SASplashAd;
import com.alliance.ssp.ad.api.splash.SASplashAdLoadListener;
import com.alliance.ssp.ad.api.stream.SAStreamAd;
import com.alliance.ssp.ad.api.stream.SAStreamAdLoadListener;
import com.alliance.ssp.ad.api.unifiedfeed.SAUnifiedFeedAdLoadListener;
import com.alliance.ssp.ad.bean.Ca;
import com.alliance.ssp.ad.bean.Ldpca;
import com.alliance.ssp.ad.bean.Ledowncomptrs;
import com.alliance.ssp.ad.bean.Ledownstarttrs;
import com.alliance.ssp.ad.bean.Ledp;
import com.alliance.ssp.ad.bean.Ledpfailtrs;
import com.alliance.ssp.ad.bean.Lefirstquartile;
import com.alliance.ssp.ad.bean.Leinstallstarttrs;
import com.alliance.ssp.ad.bean.Lemidpoint;
import com.alliance.ssp.ad.bean.Lemute;
import com.alliance.ssp.ad.bean.Lepause;
import com.alliance.ssp.ad.bean.Leready;
import com.alliance.ssp.ad.bean.Leskip;
import com.alliance.ssp.ad.bean.Lethirdquartile;
import com.alliance.ssp.ad.bean.Leunmute;
import com.alliance.ssp.ad.bean.Levideoend;
import com.alliance.ssp.ad.bean.Levideoloaderror;
import com.alliance.ssp.ad.bean.Levideostart;
import com.alliance.ssp.ad.bean.Lurl;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.Monitor;
import com.alliance.ssp.ad.bean.Nurl;
import com.alliance.ssp.ad.bean.Pa;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.oaidgithub.ykrank.androidlifecycle.event.ActivityEvent;
import com.alliance.ssp.ad.r.c;
import com.alliance.ssp.ad.t.h;
import com.alliance.ssp.ad.utils.TimeInfo;
import com.alliance.ssp.ad.video.VideoController;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pandora.common.utils.Times;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseAllianceAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a<T extends BaseAdLoadListener> {
    public static boolean B0 = false;
    public float A;
    public com.alliance.ssp.ad.l.a F;
    public AtomicInteger a;
    public AtomicInteger b;
    public AtomicInteger c;
    public AtomicInteger d;
    public ArrayList e;
    public WeakReference<Activity> f;
    public SAAllianceAdParams g;
    public T i;
    public String j0;
    public com.alliance.ssp.ad.m0.a r0;
    public String w;
    public List<TimeInfo> z;
    public SAAllianceAdData h = null;
    public boolean j = false;
    public long l = 0;
    public long m = 0;
    public long n = 0;
    public String o = "";
    public VideoController p = null;
    public boolean q = false;
    public int r = 0;
    public String s = "";
    public float t = -1.0f;
    public boolean u = false;
    public Bitmap v = null;
    public String x = "user";
    public float y = 0.0f;
    public boolean B = false;
    public int[] C = new int[3];
    public boolean D = false;
    public com.alliance.ssp.ad.t.h E = com.alliance.ssp.ad.t.h.a();
    public String G = "";
    public String H = "";
    public String I = "";
    public String J = "";

    /* renamed from: K, reason: collision with root package name */
    public String f716K = "";
    public String L = "";
    public String M = "";
    public String N = "";
    public String O = "";
    public String P = "";
    public String Q = "";
    public String R = "";
    public String S = "";
    public String T = "";
    public String U = "";
    public String V = "";
    public String W = "";
    public String X = "";
    public String Y = "";
    public String Z = "";
    public String a0 = "";
    public String b0 = "";
    public String c0 = "";
    public String d0 = "";
    public String e0 = "";
    public String f0 = "";
    public String g0 = "";
    public String h0 = "";
    public String i0 = "";
    public boolean k0 = false;
    public SAAllianceNativeFeedAdData l0 = null;
    public boolean m0 = false;
    public boolean n0 = false;
    public boolean o0 = false;
    public boolean p0 = false;
    public Handler q0 = null;
    public boolean s0 = false;
    public boolean t0 = false;
    public boolean u0 = false;
    public boolean v0 = false;
    public boolean w0 = true;
    public com.alliance.ssp.ad.r.f x0 = null;
    public com.alliance.ssp.ad.r.g y0 = null;
    public String z0 = "";
    public boolean A0 = false;
    public a k = this;

    /* compiled from: BaseAllianceAdImpl.java */
    public class h extends TypeToken<List<TimeInfo>> {
        public h(a aVar) {
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class q extends TypeToken<List<TimeInfo>> {
        public q(a aVar) {
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.A0 = false;
            a.this.q();
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class s implements View.OnClickListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Material b;
        public final /* synthetic */ SAAllianceAdData c;
        public final /* synthetic */ Handler d;
        public final /* synthetic */ c.b e;

        public s(Activity activity, Material material, SAAllianceAdData sAAllianceAdData, Handler handler, c.b bVar) {
            this.a = activity;
            this.b = material;
            this.c = sAAllianceAdData;
            this.d = handler;
            this.e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
            a.this.a((Context) this.a, this.b, this.c, this.d, this.e);
            a.this.A0 = false;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class v implements com.alliance.ssp.ad.i0.b {
        public v() {
        }

        @Override // com.alliance.ssp.ad.i0.b
        public void a() {
            int i = com.alliance.ssp.ad.o0.l.a;
            a.this.n();
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class w implements com.alliance.ssp.ad.i0.b {
        public w() {
        }

        @Override // com.alliance.ssp.ad.i0.b
        public void a() {
            int i = com.alliance.ssp.ad.o0.l.a;
            a.this.o();
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class x implements com.alliance.ssp.ad.i0.b {
        public x() {
        }

        @Override // com.alliance.ssp.ad.i0.b
        public void a() {
            int i = com.alliance.ssp.ad.o0.l.a;
            a.this.m();
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class y implements com.alliance.ssp.ad.p.a<String> {
        public y(a aVar) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public /* bridge */ /* synthetic */ void a(String str) {
        }
    }

    public a(WeakReference<Activity> weakReference, String str, String str2, SAAllianceAdParams sAAllianceAdParams, T t2, com.alliance.ssp.ad.d0.c cVar, com.alliance.ssp.ad.d0.g gVar, String str3, String str4, int i2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.w = "";
        this.j0 = "";
        this.w = UUID.randomUUID().toString().replace("-", "");
        this.f = weakReference;
        this.g = sAAllianceAdParams;
        this.a = new AtomicInteger(0);
        this.b = new AtomicInteger(0);
        this.c = new AtomicInteger(0);
        this.d = new AtomicInteger(0);
        this.i = t2;
        this.e = new ArrayList();
        this.j0 = str3;
        com.alliance.ssp.ad.d0.f.y = com.alliance.ssp.ad.a.b.a("").append(sAAllianceAdParams.getImageAcceptedHeight()).toString();
        com.alliance.ssp.ad.d0.f.z = com.alliance.ssp.ad.a.b.a("").append(sAAllianceAdParams.getImageAcceptedWidth()).toString();
        com.alliance.ssp.ad.d0.f.A = com.alliance.ssp.ad.a.b.a("").append(sAAllianceAdParams.getAdCount()).toString();
        com.alliance.ssp.ad.d0.f.b().a(0, 0, null, this.w, this.g.getPosId(), this.j0, str4, i2, sAAllianceAdParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.i.onError(100006, "广告加载数据为空");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        ((SASplashAdLoadListener) this.i).onSplashAdLoad((SASplashAd) this.e.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        ((SAExpressFeedAdLoadListener) this.i).onExpressFeedAdLoad(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        ((SAUnifiedFeedAdLoadListener) this.i).onUnifiedFeedAdLoad(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        ((SARewardVideoAdLoadListener) this.i).onRewardVideoAdLoad((SARewardVideoAd) this.e.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.i.onResourceLoad();
    }

    public void A() throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.m = System.currentTimeMillis();
        if (this.n0) {
            return;
        }
        this.n0 = true;
        new com.alliance.ssp.ad.d0.f().a(0, 0, this.h, this.w);
    }

    public void B() throws JSONException, PackageManager.NameNotFoundException, IOException {
        new com.alliance.ssp.ad.d0.f().a(1, 0, this.h, this.w);
    }

    public void C() throws JSONException, PackageManager.NameNotFoundException, IOException {
        new com.alliance.ssp.ad.d0.f().a(5, 0, this.h, this.w, "", 0);
        try {
            if (this.q0 != null) {
                com.alliance.ssp.ad.r.f fVar = this.x0;
                if (fVar != null) {
                    fVar.a(this.y0.b, com.alliance.ssp.ad.r.f.h);
                }
            } else {
                com.alliance.ssp.ad.r.f fVar2 = (com.alliance.ssp.ad.r.f) ((HashMap) com.alliance.ssp.ad.r.c.d).get(this.h.getMaterial().getDeeplink());
                com.alliance.ssp.ad.r.g gVar = (com.alliance.ssp.ad.r.g) ((HashMap) com.alliance.ssp.ad.r.c.e).get(this.h.getMaterial().getDeeplink());
                if (fVar2 != null && gVar != null) {
                    fVar2.a(gVar.b, com.alliance.ssp.ad.r.f.h);
                }
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 014: restart download tas error", e2);
        }
    }

    public void D() throws JSONException, PackageManager.NameNotFoundException, IOException {
        new com.alliance.ssp.ad.d0.f().a(5, 1, this.h, this.w, "", 0);
        B0 = true;
        try {
            if (this.q0 != null) {
                com.alliance.ssp.ad.r.f fVar = this.x0;
                if (fVar != null) {
                    fVar.a(this.y0.b);
                }
            } else {
                com.alliance.ssp.ad.r.f fVar2 = (com.alliance.ssp.ad.r.f) ((HashMap) com.alliance.ssp.ad.r.c.d).get(this.h.getMaterial().getDeeplink());
                com.alliance.ssp.ad.r.g gVar = (com.alliance.ssp.ad.r.g) ((HashMap) com.alliance.ssp.ad.r.c.e).get(this.h.getMaterial().getDeeplink());
                if (fVar2 != null && gVar != null) {
                    fVar2.a(gVar.b);
                }
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 014: pause download tas error", e2);
        }
    }

    public void b(String str, String str2, SAAllianceAdData sAAllianceAdData) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            new com.alliance.ssp.ad.d0.f().a(4, 1, this.h, this.w, "", 0);
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 006: ")), e2);
        }
        if (this.w0 && !this.v0) {
            if (sAAllianceAdData == null) {
                int i2 = com.alliance.ssp.ad.o0.l.a;
                return;
            }
            int i3 = com.alliance.ssp.ad.o0.l.a;
            Objects.toString(this.h);
            Monitor monitor = sAAllianceAdData.getMonitor();
            Objects.toString(monitor);
            if (monitor == null) {
                return;
            }
            if (monitor.getAdvml() == null) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
                return;
            }
            List<Lepause> lepause = monitor.getAdvml().getLepause();
            if (lepause != null && !lepause.isEmpty()) {
                Iterator<Lepause> it = lepause.iterator();
                while (it.hasNext()) {
                    String url = it.next().getUrl();
                    if (!TextUtils.isEmpty(url)) {
                        String strB = b(url);
                        new com.alliance.ssp.ad.http.action.a(strB, new k(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                    }
                }
            }
            int i4 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public void c(String str, String str2, SAAllianceAdData sAAllianceAdData) throws JSONException, PackageManager.NameNotFoundException, IOException {
        Monitor monitor;
        new com.alliance.ssp.ad.d0.f().a(2, 1, this.h, this.w, "", 0);
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null || (monitor = sAAllianceAdData.getMonitor()) == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Ledp> ledp = monitor.getAdvml().getLedp();
        if (ledp == null || ledp.isEmpty()) {
            return;
        }
        for (Ledp ledp2 : ledp) {
            String url = ledp2.getUrl();
            if (!TextUtils.isEmpty(url)) {
                if (TextUtils.isEmpty(ledp2.getSdkid()) && url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                    url = a(a(url, "__SDKID__", str), "__NTAGID__", str2);
                }
                new com.alliance.ssp.ad.http.action.a(b(url), new a0(this), this.o, false, BaseNetAction.Method.GET).a();
            }
        }
    }

    public void d(String str, String str2, SAAllianceAdData sAAllianceAdData) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        new com.alliance.ssp.ad.d0.f().a(5, 2, this.h, this.w, "", 0);
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Ledowncomptrs> ledowncomptrs = monitor.getAdvml().getLedowncomptrs();
        if (ledowncomptrs == null || ledowncomptrs.isEmpty()) {
            return;
        }
        Iterator<Ledowncomptrs> it = ledowncomptrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                String strB = b(url);
                new com.alliance.ssp.ad.http.action.a(strB, new n(this, strB), this.o, false, BaseNetAction.Method.GET).a();
            }
        }
    }

    public void e(String str, String str2, SAAllianceAdData sAAllianceAdData) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        new com.alliance.ssp.ad.d0.f().a(5, 0, this.h, this.w, "", 0);
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Ledownstarttrs> ledownstarttrs = monitor.getAdvml().getLedownstarttrs();
        if (ledownstarttrs == null || ledownstarttrs.isEmpty()) {
            return;
        }
        Iterator<Ledownstarttrs> it = ledownstarttrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                String strB = b(url);
                new com.alliance.ssp.ad.http.action.a(strB, new m(this, strB), this.o, false, BaseNetAction.Method.GET).a();
            }
        }
    }

    public void f(String str, String str2, SAAllianceAdData sAAllianceAdData) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        new com.alliance.ssp.ad.d0.f().a(2, 2, this.h, this.w, "", 0);
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Ledpfailtrs> ledpfailtrs = monitor.getAdvml().getLedpfailtrs();
        if (ledpfailtrs == null || ledpfailtrs.isEmpty()) {
            return;
        }
        Iterator<Ledpfailtrs> it = ledpfailtrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                String strB = b(url);
                new com.alliance.ssp.ad.http.action.a(strB, new z(this, strB), this.o, false, BaseNetAction.Method.GET).a();
            }
        }
    }

    public void m(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        try {
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 005: ")), e2);
        }
        if (sAAllianceAdData == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        Objects.toString(this.h);
        int i3 = com.alliance.ssp.ad.o0.l.a;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Leskip> leskip = monitor.getAdvml().getLeskip();
        if (leskip != null && !leskip.isEmpty()) {
            Iterator<Leskip> it = leskip.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new j(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i4 = com.alliance.ssp.ad.o0.l.a;
    }

    public void n(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Lethirdquartile> lethirdquartile = monitor.getAdvml().getLethirdquartile();
        if (lethirdquartile != null && !lethirdquartile.isEmpty()) {
            Iterator<Lethirdquartile> it = lethirdquartile.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new e(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }

    public void o(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        Objects.toString(this.h);
        int i3 = com.alliance.ssp.ad.o0.l.a;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Leunmute> leunmute = monitor.getAdvml().getLeunmute();
        if (leunmute != null && !leunmute.isEmpty()) {
            Iterator<Leunmute> it = leunmute.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new i(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i4 = com.alliance.ssp.ad.o0.l.a;
    }

    public void p(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        int duration;
        new com.alliance.ssp.ad.d0.f().a(4, 2, this.h, this.w, "", 0);
        if (this.v0) {
            return;
        }
        this.v0 = true;
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Levideoend> levideoend = monitor.getAdvml().getLevideoend();
        if (levideoend != null && !levideoend.isEmpty()) {
            Iterator<Levideoend> it = levideoend.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    if (this.p != null) {
                        StringBuilder sbA = com.alliance.ssp.ad.a.b.a("");
                        MediaPlayer mediaPlayer = this.p.w;
                        if (mediaPlayer == null) {
                            duration = 0;
                            String string = sbA.append(duration / 1000).toString();
                            url = a(a(a(url, SAAllianceAdParams.__LEMON__VIDEO_DURATION__, string), SAAllianceAdParams.__LEMON__PROGRESS__, string), SAAllianceAdParams.__LEMON__VD__, string);
                        } else {
                            try {
                                duration = mediaPlayer.getDuration();
                            } catch (Exception unused) {
                            }
                            String string2 = sbA.append(duration / 1000).toString();
                            url = a(a(a(url, SAAllianceAdParams.__LEMON__VIDEO_DURATION__, string2), SAAllianceAdParams.__LEMON__PROGRESS__, string2), SAAllianceAdParams.__LEMON__VD__, string2);
                        }
                    }
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new f(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }

    public void q(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        Monitor monitor;
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null || (monitor = sAAllianceAdData.getMonitor()) == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Levideoloaderror> levideoloaderror = monitor.getAdvml().getLevideoloaderror();
        if (levideoloaderror == null || levideoloaderror.isEmpty()) {
            return;
        }
        Iterator<Levideoloaderror> it = levideoloaderror.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                String strB = b(url);
                new com.alliance.ssp.ad.http.action.a(strB, new b(this, strB), this.o, false, BaseNetAction.Method.GET).a();
            }
        }
    }

    public void r(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData != null) {
            try {
                if (sAAllianceAdData.getMonitor() != null && sAAllianceAdData.getMonitor().getLurl() != null && !sAAllianceAdData.getMonitor().getLurl().isEmpty()) {
                    List<Lurl> lurl = sAAllianceAdData.getMonitor().getLurl();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Iterator<Lurl> it = lurl.iterator();
                    while (it.hasNext()) {
                        String url = it.next().getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            this.I = String.valueOf(jCurrentTimeMillis);
                            this.Z = String.valueOf((int) (jCurrentTimeMillis / 1000));
                            if (url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                                url = a(a(url, "__SDKID__", str), "__NTAGID__", str2);
                            }
                            String strB = b(url);
                            new com.alliance.ssp.ad.http.action.a(strB, new com.alliance.ssp.ad.t.d(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void s() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (this.i != null) {
            com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.l();
                }
            });
        }
        if (this.k0) {
            return;
        }
        new com.alliance.ssp.ad.d0.f().a(2, 1, this.h, this.w, this.g.getPosId(), "");
    }

    public void t() {
        new com.alliance.ssp.ad.d0.f().a(2, 0, this.h, this.w, this.g.getPosId(), "");
    }

    public void u() throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (this.m0) {
            return;
        }
        this.m0 = true;
        new com.alliance.ssp.ad.d0.f().a(2, 2, this.h, this.w, 100006, "1", "素材加载超时");
    }

    public void v() throws JSONException, PackageManager.NameNotFoundException, IOException {
        WeakReference<Activity> weakReference = this.f;
        Activity activityB = weakReference != null ? weakReference.get() : com.alliance.ssp.ad.o0.b.b();
        if (activityB == null) {
            return;
        }
        try {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            com.alliance.ssp.ad.k0.a aVarA = com.alliance.ssp.ad.h0.a.a((Context) activityB);
            if (aVarA != null) {
                aVarA.a(ActivityEvent.RESUME, new v());
                aVarA.a(ActivityEvent.STOP, new w());
                aVarA.a(ActivityEvent.DESTROY, new x());
            }
        } catch (Exception e2) {
            int i3 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 012: ")), e2);
        }
    }

    public void w() throws JSONException, PackageManager.NameNotFoundException, IOException {
        new com.alliance.ssp.ad.d0.f().a(1, 3, this.h, this.w, this.x, 0);
    }

    public void x() throws JSONException, PackageManager.NameNotFoundException, IOException {
        new com.alliance.ssp.ad.d0.f().a(1, 0, this.h, this.w, this.x, 0);
    }

    public void y() {
        new com.alliance.ssp.ad.d0.f().a(4, 3, this.h, this.w, "", 0);
    }

    public void z() throws JSONException, PackageManager.NameNotFoundException, IOException {
        new com.alliance.ssp.ad.d0.f().a(0, 0, this.h, this.w, "", 0);
    }

    /* compiled from: BaseAllianceAdImpl.java */
    /* renamed from: com.alliance.ssp.ad.t.a$a, reason: collision with other inner class name */
    public class C0098a implements com.alliance.ssp.ad.p.a<String> {
        public C0098a(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class a0 implements com.alliance.ssp.ad.p.a<String> {
        public a0(a aVar) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class b implements com.alliance.ssp.ad.p.a<String> {
        public b(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class b0 implements com.alliance.ssp.ad.p.a<String> {
        public b0(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class c implements com.alliance.ssp.ad.p.a<String> {
        public c(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class d implements com.alliance.ssp.ad.p.a<String> {
        public d(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class e implements com.alliance.ssp.ad.p.a<String> {
        public e(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class f implements com.alliance.ssp.ad.p.a<String> {
        public f(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class g implements com.alliance.ssp.ad.p.a<String> {
        public g(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class i implements com.alliance.ssp.ad.p.a<String> {
        public i(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class j implements com.alliance.ssp.ad.p.a<String> {
        public j(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class k implements com.alliance.ssp.ad.p.a<String> {
        public k(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class l implements com.alliance.ssp.ad.p.a<String> {
        public l(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class m implements com.alliance.ssp.ad.p.a<String> {
        public m(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class n implements com.alliance.ssp.ad.p.a<String> {
        public n(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class o implements com.alliance.ssp.ad.p.a<String> {
        public o(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class p implements com.alliance.ssp.ad.p.a<String> {
        public p(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class z implements com.alliance.ssp.ad.p.a<String> {
        public z(a aVar, String str) {
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(String str) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public void a(final int i2, String str, final String str2) {
        if (this.i != null) {
            com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(i2, str2);
                }
            });
        }
        com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
        String str3 = this.w;
        String posId = this.g.getPosId();
        String str4 = this.j0;
        fVar.a(1, 2, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() - com.alliance.ssp.ad.d0.f.f), (SAAllianceAdData) null);
        try {
            if (fVar.b == null) {
                fVar.b = new JSONObject();
            }
            fVar.b.put("stage", 6);
            fVar.b.put("sdkecode", "" + i2);
            fVar.b.put("errmsg", "" + i2 + "-" + str + "-" + str2);
            fVar.a.put("crequestid", str3);
            fVar.a.put("sposid", posId);
            fVar.a.put("spostype", str4);
            JSONObject jSONObject = new JSONObject();
            fVar.a(jSONObject, str3);
            fVar.a.put("ext", jSONObject.toString());
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 003: ")), e2);
        }
        try {
            fVar.a();
        } catch (Exception e3) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 004: ")), e3);
        }
    }

    public void g(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Lefirstquartile> lefirstquartile = monitor.getAdvml().getLefirstquartile();
        if (lefirstquartile != null && !lefirstquartile.isEmpty()) {
            Iterator<Lefirstquartile> it = lefirstquartile.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new c(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }

    public void h(String str, String str2, SAAllianceAdData sAAllianceAdData) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Leinstallstarttrs> leinstallstarttrs = monitor.getAdvml().getLeinstallstarttrs();
        if (leinstallstarttrs == null || leinstallstarttrs.isEmpty()) {
            return;
        }
        Iterator<Leinstallstarttrs> it = leinstallstarttrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                String strB = b(url);
                new com.alliance.ssp.ad.http.action.a(strB, new b0(this, strB), this.o, false, BaseNetAction.Method.GET).a();
            }
        }
    }

    public void i(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Lemidpoint> lemidpoint = monitor.getAdvml().getLemidpoint();
        if (lemidpoint != null && !lemidpoint.isEmpty()) {
            Iterator<Lemidpoint> it = lemidpoint.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new d(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }

    public void j(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        Objects.toString(this.h);
        int i3 = com.alliance.ssp.ad.o0.l.a;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Lemute> lemute = monitor.getAdvml().getLemute();
        if (lemute != null && !lemute.isEmpty()) {
            Iterator<Lemute> it = lemute.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new g(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i4 = com.alliance.ssp.ad.o0.l.a;
    }

    public void k(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        try {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(4, 1, this.h, this.w, "", 0);
            Objects.toString(this.h);
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 007: ")), e2);
        }
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Lepause> lepause = monitor.getAdvml().getLepause();
        if (lepause != null && !lepause.isEmpty()) {
            Iterator<Lepause> it = lepause.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new l(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }

    public void l(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData == null || this.k0 || this.t0) {
            return;
        }
        this.t0 = true;
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Leready> leready = monitor.getAdvml().getLeready();
        if (leready != null) {
            Iterator<Leready> it = leready.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new C0098a(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class u implements c.a {
        public final /* synthetic */ SAAllianceAdData a;

        public u(SAAllianceAdData sAAllianceAdData) {
            this.a = sAAllianceAdData;
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void a() throws JSONException, PackageManager.NameNotFoundException, IOException {
            com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
            SAAllianceAdData sAAllianceAdData = this.a;
            fVar.a(5, 1, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "", 0);
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void b() throws JSONException, PackageManager.NameNotFoundException, IOException {
            com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
            SAAllianceAdData sAAllianceAdData = this.a;
            fVar.a(5, 0, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "", 0);
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void c() throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            a.this.e("", "", this.a);
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void a(String str) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            int i = com.alliance.ssp.ad.o0.l.a;
            a.this.h("", "", this.a);
            a.this.d("", "", this.a);
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void a(Exception exc) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public void t(String str, String str2, SAAllianceAdData sAAllianceAdData) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        this.l = System.currentTimeMillis();
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData == null || sAAllianceAdData.getMonitor() == null) {
            return;
        }
        List<Pa> pa = sAAllianceAdData.getMonitor().getPa();
        if (pa == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-pa is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        if (pa.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.n = jCurrentTimeMillis - this.m;
        for (Pa pa2 : pa) {
            String url = pa2.getUrl();
            if (!TextUtils.isEmpty(url)) {
                this.I = String.valueOf(jCurrentTimeMillis);
                this.Z = String.valueOf((int) (jCurrentTimeMillis / 1000));
                if (TextUtils.isEmpty(pa2.getSdkid()) && url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                    url = a(a(url, "__SDKID__", str), "__NTAGID__", str2);
                }
                if (url.contains("__LEMON__PRICE__") && sAAllianceAdData.getPrice() != null) {
                    try {
                        String strA = com.alliance.ssp.ad.o0.a.a(sAAllianceAdData.getPrice());
                        if (strA != null) {
                            url = a(url, "__LEMON__PRICE__", strA);
                        }
                    } catch (Exception e2) {
                        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 008: ")), e2);
                    }
                }
                String strB = b(url);
                new com.alliance.ssp.ad.http.action.a(strB, new o(this, strB), this.o, false, BaseNetAction.Method.GET).a();
            }
        }
    }

    /* compiled from: BaseAllianceAdImpl.java */
    public class t implements com.alliance.ssp.ad.r.j {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ SAAllianceAdData b;

        public t(Handler handler, SAAllianceAdData sAAllianceAdData) {
            this.a = handler;
            this.b = sAAllianceAdData;
        }

        @Override // com.alliance.ssp.ad.r.j
        public void a(int i, int i2, a aVar) {
            if (this.a != null) {
                int i3 = (int) ((i2 * 100.0f) / i);
                if (i2 == i) {
                    i3 = 100;
                }
                Message message = new Message();
                message.what = i3;
                this.a.sendMessage(message);
            }
        }

        @Override // com.alliance.ssp.ad.r.j
        public void a(a aVar) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            Message message = new Message();
            message.what = -100;
            this.a.sendMessage(message);
            if (a.B0) {
                a.B0 = false;
            } else {
                int i = com.alliance.ssp.ad.o0.l.a;
                a.this.d("", "", this.b);
            }
        }
    }

    public void s(String str, String str2, SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.h);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (sAAllianceAdData != null) {
            try {
                if (sAAllianceAdData.getMonitor() != null && sAAllianceAdData.getMonitor().getNurl() != null && !sAAllianceAdData.getMonitor().getNurl().isEmpty()) {
                    List<Nurl> nurl = sAAllianceAdData.getMonitor().getNurl();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Iterator<Nurl> it = nurl.iterator();
                    while (it.hasNext()) {
                        String url = it.next().getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            this.I = String.valueOf(jCurrentTimeMillis);
                            this.Z = String.valueOf((int) (jCurrentTimeMillis / 1000));
                            if (url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                                url = a(a(url, "__SDKID__", str), "__NTAGID__", str2);
                            }
                            String strB = b(url);
                            new com.alliance.ssp.ad.http.action.a(strB, new p(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void q() {
        int i2 = com.alliance.ssp.ad.o0.l.a;
    }

    public void r() {
        int i2 = com.alliance.ssp.ad.o0.l.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        ((SAStreamAdLoadListener) this.i).onStreamAdLoad((SAStreamAd) this.e.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        ((SANativeFeedAdLoadListener) this.i).onNativeFeedAdLoad(this.l0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        ((SAInterstitialAdLoadListener) this.i).onInterstitialAdLoad((SAInterstitialAd) this.e.get(0));
    }

    public void o() {
        int i2 = com.alliance.ssp.ad.o0.l.a;
    }

    public void n() {
        int i2 = com.alliance.ssp.ad.o0.l.a;
    }

    public void c(int i2) {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String sposid = this.h.getSposid();
        ArrayList arrayList = (ArrayList) com.alliance.ssp.ad.d0.d.a(contextA, sposid);
        arrayList.add(Long.valueOf(jCurrentTimeMillis));
        SharedPreferences sharedPreferences = contextA.getSharedPreferences("click_cache_pref", 0);
        HashSet hashSet = new HashSet();
        Calendar calendar = Calendar.getInstance();
        int i3 = 1;
        int i4 = calendar.get(1);
        int i5 = calendar.get(2);
        int i6 = calendar.get(5);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            calendar.setTimeInMillis(jLongValue);
            int i7 = calendar.get(i3);
            int i8 = calendar.get(2);
            int i9 = calendar.get(5);
            if (i7 == i4 && i8 == i5 && i9 == i6) {
                hashSet.add(String.valueOf(jLongValue));
            }
            i3 = 1;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putStringSet("click_cache_times" + sposid, hashSet);
        editorEdit.apply();
    }

    public void m() {
        int i2 = com.alliance.ssp.ad.o0.l.a;
    }

    public void b(SAAllianceAdData sAAllianceAdData) {
        new com.alliance.ssp.ad.d0.f().a(4, 0, this.h, this.w, "", 0);
        if (this.u0) {
            return;
        }
        this.u0 = true;
        if (sAAllianceAdData == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        int i3 = com.alliance.ssp.ad.o0.l.a;
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
            return;
        }
        List<Levideostart> levideostart = monitor.getAdvml().getLevideostart();
        if (levideostart != null && !levideostart.isEmpty()) {
            Iterator<Levideostart> it = levideostart.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    String strB = b(url);
                    new com.alliance.ssp.ad.http.action.a(strB, new com.alliance.ssp.ad.t.b(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
        int i4 = com.alliance.ssp.ad.o0.l.a;
    }

    public void p() {
        if (this.o0) {
            return;
        }
        this.o0 = true;
        if (this.p0) {
            new com.alliance.ssp.ad.d0.f().a(1, 2, this.h, this.w, "", 1);
        } else {
            new com.alliance.ssp.ad.d0.f().a(1, 2, this.h, this.w, "", 0);
        }
    }

    public void c() throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA != null && !com.alliance.ssp.ad.r.f.h.contains("nmssp_download")) {
            com.alliance.ssp.ad.r.f.h = contextA.getExternalCacheDir() + "/nmssp_download/";
        }
        com.alliance.ssp.ad.o0.i.a(contextA, com.alliance.ssp.ad.r.f.h, this.z0);
        h("", "", this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i2, String str) {
        this.i.onError(i2, str);
    }

    public void a(final String str, int i2, String str2, String str3) {
        this.k0 = true;
        if (this.i != null) {
            com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(str);
                }
            });
        }
        com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
        SAAllianceAdData sAAllianceAdData = this.h;
        String str4 = this.w;
        fVar.a(3, 2, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() - com.alliance.ssp.ad.d0.f.h), sAAllianceAdData);
        try {
            if (fVar.b == null) {
                fVar.b = new JSONObject();
            }
            fVar.b.put("stage", 7);
            fVar.b.put("sdkecode", "" + i2);
            fVar.b.put("errmsg", "" + i2 + "-" + str2 + "-" + str3);
            fVar.a.put("crequestid", str4);
            JSONObject jSONObject = new JSONObject();
            if (sAAllianceAdData != null) {
                fVar.a.put("sposprice", sAAllianceAdData.getAdtype());
                fVar.a.put("adtesting", sAAllianceAdData.getIstesting());
                fVar.a.put("payload", sAAllianceAdData.getPayload());
                fVar.a.put("sposid", sAAllianceAdData.getSposid());
                fVar.a.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                Material material = sAAllianceAdData.getMaterial();
                fVar.a.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                fVar.a.put("aecpm", fVar.a(sAAllianceAdData.getPrice()));
                fVar.a.put("ldptype", Integer.valueOf(material.getLdptype()));
                fVar.a.put("deeplink", material.getDeeplink());
                fVar.a.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, material.getDesc());
                fVar.a.put("ldp", material.getLdp());
                String videourl = material.getVideourl();
                List<String> imgurl = material.getImgurl();
                if (videourl != null && !TextUtils.isEmpty(videourl)) {
                    fVar.a.put("murl", videourl);
                } else {
                    fVar.a.put("murl", (imgurl == null || imgurl.isEmpty()) ? "" : imgurl.get(0));
                }
                fVar.a.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                fVar.a.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
                fVar.a(jSONObject, sAAllianceAdData);
            }
            fVar.a(jSONObject, str4);
            fVar.a.put("ext", jSONObject.toString());
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 009: ")), e2);
        }
        try {
            fVar.a();
        } catch (Exception e3) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 010: ")), e3);
        }
    }

    public void b(int i2, String str, String str2) {
        if (this.m0) {
            return;
        }
        this.m0 = true;
        new com.alliance.ssp.ad.d0.f().a(2, 2, this.h, this.w, i2, str, str2);
    }

    public boolean b() throws NumberFormatException {
        int iIndexOf;
        int i2;
        if (this.B) {
            int i3 = com.alliance.ssp.ad.o0.l.a;
            return false;
        }
        if (this.z == null) {
            boolean z2 = new Random().nextFloat() * 100.0f <= this.y;
            int i4 = com.alliance.ssp.ad.o0.l.a;
            return z2;
        }
        int i5 = Calendar.getInstance().get(11);
        try {
            loop0: for (TimeInfo timeInfo : this.z) {
                Iterator<Integer> it = timeInfo.getTimeRange().iterator();
                while (it.hasNext()) {
                    if (i5 == it.next().intValue()) {
                        iIndexOf = this.z.indexOf(timeInfo);
                        break loop0;
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        iIndexOf = -1;
        if (iIndexOf == -1) {
            int i6 = com.alliance.ssp.ad.o0.l.a;
            return false;
        }
        try {
            i2 = Integer.parseInt(this.z.get(iIndexOf).getCount());
        } catch (Exception e3) {
            e3.printStackTrace();
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it2 = this.z.get(iIndexOf).getTimeRange().iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(it2.next().intValue()));
        }
        HashMap map = new HashMap();
        String str = new SimpleDateFormat(Times.YYYY_MM_DD).format(new Date());
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            map.put(String.format("%s %02d", str, Integer.valueOf(((Integer) it3.next()).intValue())), Boolean.TRUE);
        }
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            int i7 = com.alliance.ssp.ad.o0.l.a;
            return false;
        }
        List<Long> listA = com.alliance.ssp.ad.d0.d.a(contextA, this.h.getSposid());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        Iterator it4 = ((ArrayList) listA).iterator();
        int i8 = 0;
        while (it4.hasNext()) {
            if (map.containsKey(simpleDateFormat.format(new Date(((Long) it4.next()).longValue())))) {
                i8++;
            }
        }
        int i9 = com.alliance.ssp.ad.o0.l.a;
        return i2 > i8 && new Random().nextFloat() * 100.0f <= this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        this.i.onError(100006, str);
    }

    public void a(BaseAllianceAd baseAllianceAd) {
        if (this.d == null) {
            this.d = new AtomicInteger(0);
        }
        this.d.incrementAndGet();
        AtomicInteger atomicInteger = this.d;
        if (atomicInteger != null) {
            atomicInteger.get();
        }
        AtomicInteger atomicInteger2 = this.c;
        if (atomicInteger2 != null) {
            atomicInteger2.get();
        }
        AtomicInteger atomicInteger3 = this.b;
        if (atomicInteger3 != null) {
            atomicInteger3.get();
        }
        AtomicInteger atomicInteger4 = this.a;
        if (atomicInteger4 != null) {
            atomicInteger4.get();
        }
        int i2 = com.alliance.ssp.ad.o0.l.a;
        SAAllianceAdData sAAllianceAdData = this.h;
        if (sAAllianceAdData != null && sAAllianceAdData.getInteraction() != null) {
            Gson gson = new Gson();
            if (this.h.getInteraction().getClick() != null) {
                Type type = new h(this).getType();
                if (this.h.getInteraction().getClick().limitation != null) {
                    this.z = (List) gson.fromJson(this.h.getInteraction().getClick().limitation, type);
                }
                if (this.h.getInteraction().getClick().probability != null) {
                    this.y = this.h.getInteraction().getClick().probability.floatValue();
                }
            }
            if (this.h.getInteraction().getAuto() != null) {
                Type type2 = new q(this).getType();
                if (this.h.getInteraction().getAuto().limitation != null) {
                    this.z = (List) gson.fromJson(this.h.getInteraction().getAuto().limitation, type2);
                }
                if (this.h.getInteraction().getAuto().probability != null) {
                    this.y = this.h.getInteraction().getAuto().probability.floatValue();
                }
                if (this.h.getInteraction().getAuto().clickCountdownTime != null) {
                    this.A = this.h.getInteraction().getAuto().clickCountdownTime.floatValue();
                }
            }
            float f2 = this.A;
            Objects.toString(f2 == 0.0f ? ILogConst.CACHE_PLAY_REASON_NULL : Float.valueOf(f2));
        }
        if (baseAllianceAd != null) {
            this.e.add(baseAllianceAd);
        }
        if (this.d.get() >= this.a.get()) {
            ArrayList arrayList = this.e;
            if (arrayList != null && !arrayList.isEmpty()) {
                T t2 = this.i;
                if (t2 == null) {
                    return;
                }
                if (t2 instanceof SASplashAdLoadListener) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.h();
                        }
                    });
                } else if (t2 instanceof SABannerAdLoadListener) {
                    final com.alliance.ssp.ad.u.f fVar = (com.alliance.ssp.ad.u.f) baseAllianceAd;
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(fVar);
                        }
                    });
                } else if (t2 instanceof SAExpressFeedAdLoadListener) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda11
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.i();
                        }
                    });
                } else if (t2 instanceof SAUnifiedFeedAdLoadListener) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.j();
                        }
                    });
                } else if (t2 instanceof SARewardVideoAdLoadListener) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda13
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.k();
                        }
                    });
                } else if (t2 instanceof SAInterstitialAdLoadListener) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.d();
                        }
                    });
                } else if (t2 instanceof SAStreamAdLoadListener) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.e();
                        }
                    });
                } else if (t2 instanceof SANativeFeedAdLoadListener) {
                    com.alliance.ssp.ad.x.h hVar = (com.alliance.ssp.ad.x.h) baseAllianceAd;
                    this.l0 = new SAAllianceNativeFeedAdData(hVar.g, hVar.h);
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.f();
                        }
                    });
                }
            } else if (this.i != null) {
                com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.g();
                    }
                });
            }
        }
        new com.alliance.ssp.ad.d0.f().a(1, 0, this.h, this.w, this.g.getPosId(), "");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(34:0|2|(1:4)(2:5|(2:7|(2:12|13)(3:155|10|13)))|14|(1:16)|17|(9:19|165|20|(1:22)(4:23|(2:26|24)|172|27)|28|(1:30)|171|31|34)|35|169|36|(1:42)(2:40|41)|(8:147|43|(1:49)(2:47|48)|153|50|(1:56)(2:54|55)|161|57)|(1:73)(1:61)|74|157|75|(2:77|78)(1:79)|163|80|(1:82)(1:89)|90|(1:92)(4:93|(1:95)(1:96)|97|(1:99)(1:100))|101|159|102|(2:104|105)(1:106)|167|107|(2:109|110)(1:111)|(5:145|112|(2:114|115)(1:116)|151|117)|(1:119)(1:131)|132|(1:174)(6:149|135|(2:138|136)|173|139|175)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0492, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0493, code lost:
    
        r14 = r0;
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0496, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0497, code lost:
    
        r14 = r0;
        r3 = "";
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x049a, code lost:
    
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0345, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0346, code lost:
    
        r13 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0348, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0349, code lost:
    
        r13 = r0;
        r7 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x034b, code lost:
    
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(r13, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 043: ")), r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0431 A[Catch: Exception -> 0x0496, TRY_LEAVE, TryCatch #7 {Exception -> 0x0496, blocks: (B:102:0x0429, B:104:0x0431), top: B:159:0x0429 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x044a A[Catch: Exception -> 0x0492, TRY_LEAVE, TryCatch #11 {Exception -> 0x0492, blocks: (B:107:0x0442, B:109:0x044a), top: B:167:0x0442 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0463 A[Catch: Exception -> 0x048e, TRY_LEAVE, TryCatch #0 {Exception -> 0x048e, blocks: (B:112:0x045b, B:114:0x0463), top: B:145:0x045b }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x047c A[Catch: Exception -> 0x048b, TRY_LEAVE, TryCatch #3 {Exception -> 0x048b, blocks: (B:117:0x0474, B:119:0x047c), top: B:151:0x0474 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04b1 A[PHI: r3 r6 r8
  0x04b1: PHI (r3v16 java.lang.String) = (r3v15 java.lang.String), (r3v30 java.lang.String) binds: [B:130:0x049b, B:118:0x047a] A[DONT_GENERATE, DONT_INLINE]
  0x04b1: PHI (r6v12 java.lang.String) = (r6v11 java.lang.String), (r6v17 java.lang.String) binds: [B:130:0x049b, B:118:0x047a] A[DONT_GENERATE, DONT_INLINE]
  0x04b1: PHI (r8v41 java.lang.String) = (r8v40 java.lang.String), (r8v46 java.lang.String) binds: [B:130:0x049b, B:118:0x047a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0511 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x031d A[Catch: Exception -> 0x0348, TRY_LEAVE, TryCatch #6 {Exception -> 0x0348, blocks: (B:75:0x0315, B:77:0x031d), top: B:157:0x0315 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0336 A[Catch: Exception -> 0x0345, TRY_LEAVE, TryCatch #9 {Exception -> 0x0345, blocks: (B:80:0x032e, B:82:0x0336), top: B:163:0x032e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0361 A[PHI: r7
  0x0361: PHI (r7v44 java.lang.String) = (r7v43 java.lang.String), (r7v51 java.lang.String) binds: [B:88:0x034b, B:81:0x0334] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(java.lang.String r18) throws java.lang.IllegalStateException, org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instructions count: 1365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.t.a.b(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.alliance.ssp.ad.u.f fVar) {
        ((SABannerAdLoadListener) this.i).onBannerAdLoad((SABannerAd) this.e.get(0), fVar.d);
    }

    public void a(View view, String str) {
        if (view == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int iRandom = ((int) (Math.random() * width)) + i3;
        int iRandom2 = ((int) (Math.random() * height)) + i4;
        this.P = com.alliance.ssp.ad.a.b.a("").append(iRandom - Integer.parseInt(this.X)).toString();
        this.Q = com.alliance.ssp.ad.a.b.a("").append(iRandom2 - Integer.parseInt(this.Y)).toString();
        this.R = com.alliance.ssp.ad.a.b.a("").append(iRandom - Integer.parseInt(this.X)).toString();
        this.S = com.alliance.ssp.ad.a.b.a("").append(iRandom2 - Integer.parseInt(this.Y)).toString();
        this.f716K = com.alliance.ssp.ad.a.f.a("", iRandom);
        this.L = com.alliance.ssp.ad.a.f.a("", iRandom2);
        this.M = com.alliance.ssp.ad.a.f.a("", iRandom);
        this.N = com.alliance.ssp.ad.a.f.a("", iRandom2);
        if (str == null || str.isEmpty()) {
            return;
        }
        this.W = str;
    }

    public final Point a(View view, float f2, float f3) {
        view.getLocationOnScreen(new int[2]);
        return new Point(Math.round(r0[0] + f2), Math.round(r0[1] + f3));
    }

    public boolean a(Material material, SAAllianceAdData sAAllianceAdData, boolean z2) {
        return a(material, sAAllianceAdData, z2, (c.b) null, (com.alliance.ssp.ad.c0.a) null);
    }

    public boolean a(Material material, SAAllianceAdData sAAllianceAdData, boolean z2, c.b bVar, com.alliance.ssp.ad.c0.a aVar) {
        if (material == null) {
            return false;
        }
        int ldptype = material.getLdptype();
        w();
        material.getLdp();
        material.getDeeplink();
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (ldptype == 0) {
            if (material.getLdp() == null || material.getLdp().length() == 0) {
                return false;
            }
            a(sAAllianceAdData);
        } else if (ldptype == 1) {
            if (material.getDeeplink() == null || material.getDeeplink().length() == 0) {
                return false;
            }
            a(material, sAAllianceAdData, this.q0, z2, bVar, aVar);
        } else if (ldptype == 2 && (material.getDeeplink() == null || material.getDeeplink().length() == 0 || (!a(material.getDeeplink(), sAAllianceAdData) && TextUtils.isEmpty(material.getLdp())))) {
            return false;
        }
        this.B = true;
        a("", "", sAAllianceAdData);
        return true;
    }

    public void a(String str, String str2, SAAllianceAdData sAAllianceAdData) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (monitor == null) {
            return;
        }
        Objects.toString(this.h);
        List<Ca> ca2 = monitor.getCa();
        if (ca2 != null && !ca2.isEmpty()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (Ca ca3 : ca2) {
                String url = ca3.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    this.I = String.valueOf(jCurrentTimeMillis);
                    this.Z = String.valueOf((int) (jCurrentTimeMillis / 1000));
                    this.O = this.I;
                    if (TextUtils.isEmpty(ca3.getSdkid()) && url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                        url = a(a(url, "__SDKID__", str), "__NTAGID__", str2);
                    }
                    new com.alliance.ssp.ad.http.action.a(b(url), new y(this), this.o, Objects.equals(this.x, "shake"), BaseNetAction.Method.GET).a();
                }
            }
            return;
        }
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Ca is null, The old version will be incompatible ", (Exception) null);
    }

    public static String a(String str, String str2, String str3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (!a(str, str2) || !str.contains(str2)) {
            return str;
        }
        try {
            Matcher matcher = Pattern.compile("#" + Pattern.quote(str2) + ":(.*?)#").matcher(str);
            if (str3 != null && !str3.isEmpty()) {
                return matcher.replaceAll(str3);
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, (String) Objects.requireNonNull(matcher.group(1)));
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 041: ")), e2);
            return str;
        }
    }

    public static boolean a(String... strArr) {
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(final java.lang.String r18, final com.alliance.ssp.ad.bean.SAAllianceAdData r19) throws java.lang.IllegalStateException, org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException, java.net.URISyntaxException, java.io.IOException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.t.a.a(java.lang.String, com.alliance.ssp.ad.bean.SAAllianceAdData):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SAAllianceAdData sAAllianceAdData, String str, Intent intent) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, URISyntaxException, IOException, InvalidKeyException {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        intent.getAction();
        int i2 = com.alliance.ssp.ad.o0.l.a;
        String action = intent.getAction();
        action.getClass();
        if (action.equals("SA_TARGET_YT_DEEPLINK_OPEN_FAIL")) {
            a(sAAllianceAdData);
            this.s0 = true;
            f("", "", sAAllianceAdData);
        } else if (action.equals("SA_TARGET_YT_DEEPLINK_OPEN_FINISH")) {
            if (!this.s0 && !str.endsWith(".apk")) {
                c("", "", sAAllianceAdData);
            }
            this.r0.a();
        }
    }

    public final void a(SAAllianceAdData sAAllianceAdData) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, URISyntaxException, IOException, InvalidKeyException {
        Material material;
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null || sAAllianceAdData == null || (material = sAAllianceAdData.getMaterial()) == null) {
            return;
        }
        String ldp = material.getLdp();
        if (TextUtils.isEmpty(ldp)) {
            return;
        }
        if (ldp.endsWith(".apk")) {
            a(material.getLdp(), sAAllianceAdData);
            return;
        }
        if (ldp.contains("http://") || ldp.contains("https://")) {
            if (sAAllianceAdData.getInteraction() == null) {
                sAAllianceAdData.setInteraction(this.h.getInteraction());
            }
            if ((sAAllianceAdData.getTagName() == null || sAAllianceAdData.getTagName().isEmpty()) && this.h.getTagName() != null && !this.h.getTagName().isEmpty()) {
                sAAllianceAdData.setTagName(this.h.getTagName());
            }
            if ((sAAllianceAdData.getTagVer() == null || sAAllianceAdData.getTagVer().isEmpty()) && this.h.getTagVer() != null && !this.h.getTagVer().isEmpty()) {
                sAAllianceAdData.setTagVer(this.h.getTagVer());
            }
            if ((sAAllianceAdData.getTagCode() == null || sAAllianceAdData.getTagCode().isEmpty()) && this.h.getTagCode() != null && !this.h.getTagCode().isEmpty()) {
                sAAllianceAdData.setTagCode(this.h.getTagCode());
            }
            sAAllianceAdData.setSpostype(this.h.getSpostype());
            Intent intent = new Intent(contextA, (Class<?>) SAAllianceWebViewActivity.class);
            intent.addFlags(268435456);
            sAAllianceAdData.setCrequestid(this.w);
            intent.putExtra("extra_name_land_page_ad_data", sAAllianceAdData.copy());
            contextA.startActivity(intent);
            new com.alliance.ssp.ad.d0.f().a(2, 0, this.h, this.w, "", 0);
            Objects.toString(this.h);
            int i2 = com.alliance.ssp.ad.o0.l.a;
            Monitor monitor = sAAllianceAdData.getMonitor();
            Objects.toString(monitor);
            if (monitor == null) {
                return;
            }
            List<Ldpca> ldpca = monitor.getLdpca();
            if (ldpca == null) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Ldpca is null, The old version will be incompatible ", (Exception) null);
                return;
            }
            if (ldpca.isEmpty()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<Ldpca> it = ldpca.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    this.I = String.valueOf(jCurrentTimeMillis);
                    this.Z = String.valueOf((int) (jCurrentTimeMillis / 1000));
                    if (url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                        url = a(a(url, "__SDKID__", ""), "__NTAGID__", "");
                    }
                    if (url.contains("__LEMON__PRICE__") && sAAllianceAdData.getPrice() != null) {
                        try {
                            String strA = com.alliance.ssp.ad.o0.a.a(sAAllianceAdData.getPrice());
                            if (strA != null) {
                                url = a(url, "__LEMON__PRICE__", strA);
                            }
                        } catch (Exception e2) {
                            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 004: ")), e2);
                        }
                    }
                    new com.alliance.ssp.ad.http.action.a(b(url), new com.alliance.ssp.ad.t.e(this), this.o, false, BaseNetAction.Method.GET).a();
                }
            }
        }
    }

    public SAAllianceAdData a(Context context, String str) {
        SAAllianceAdData sAAllianceAdDataB;
        if (str != null && !str.isEmpty()) {
            try {
                String str2 = com.alliance.ssp.ad.t.h.c;
                com.alliance.ssp.ad.t.h hVar = h.c.a;
                this.E = hVar;
                if (context != null && (sAAllianceAdDataB = hVar.b(context, str)) != null) {
                    int i2 = com.alliance.ssp.ad.o0.l.a;
                    return sAAllianceAdDataB;
                }
            } catch (Exception e2) {
                e2.getMessage();
                int i3 = com.alliance.ssp.ad.o0.l.a;
            }
            return null;
        }
        int i4 = com.alliance.ssp.ad.o0.l.a;
        return null;
    }

    public void a(boolean z2, float f2, int i2, int i3, int i4, HashMap<String, Object> map) {
        int i5;
        try {
            if (z2) {
                s("", "", this.h);
                i5 = 1;
            } else {
                r("", "", this.h);
                i5 = 2;
            }
            new com.alliance.ssp.ad.d0.f().a(4, i5, this.h, this.w, f2, i2, i3, i4);
        } catch (Exception unused) {
        }
    }

    public final void a(final Material material, final SAAllianceAdData sAAllianceAdData, final Handler handler, boolean z2, final c.b bVar, final com.alliance.ssp.ad.c0.a aVar) throws JSONException, PackageManager.NameNotFoundException, IOException {
        Activity activityB;
        try {
            WeakReference<Activity> weakReference = this.f;
            if (weakReference != null && weakReference.get() != null) {
                activityB = this.f.get();
            } else {
                activityB = com.alliance.ssp.ad.o0.b.b();
            }
            if (activityB == null) {
                return;
            }
            if (z2) {
                if (!this.A0 && Build.VERSION.SDK_INT >= 17) {
                    if (activityB.isDestroyed()) {
                        activityB = com.alliance.ssp.ad.o0.b.b();
                    }
                    final Activity activity = activityB;
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(activity, material, sAAllianceAdData, handler, bVar, aVar);
                        }
                    });
                    return;
                }
                return;
            }
            if (Build.VERSION.SDK_INT >= 17 && activityB.isDestroyed()) {
                activityB = com.alliance.ssp.ad.o0.b.b();
            }
            final Activity activity2 = activityB;
            com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.t.a$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                    this.f$0.a(activity2, material, sAAllianceAdData, handler, bVar);
                }
            });
        } catch (Exception e2) {
            e2.getMessage();
            int i2 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 011: ")), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Material material, SAAllianceAdData sAAllianceAdData, Handler handler, c.b bVar, com.alliance.ssp.ad.c0.a aVar) {
        com.alliance.ssp.ad.q0.b bVar2 = new com.alliance.ssp.ad.q0.b(activity);
        bVar2.i = material.getApkname();
        int i2 = R.string.nm_cancel;
        r rVar = new r();
        bVar2.e = bVar2.getContext().getString(i2);
        bVar2.g = rVar;
        int i3 = R.string.nm_download;
        s sVar = new s(activity, material, sAAllianceAdData, handler, bVar);
        bVar2.d = bVar2.getContext().getString(i3);
        bVar2.f = sVar;
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        bVar2.show();
        if (bVar2.isShowing()) {
            this.A0 = true;
            if (aVar != null) {
                NMSplashAdImpl.c cVar = (NMSplashAdImpl.c) aVar;
                NMSplashAdImpl.this.A1 = true;
                NMSplashAdImpl nMSplashAdImpl = NMSplashAdImpl.this;
                int i4 = nMSplashAdImpl.t1;
                if (i4 == 1 || i4 == 2) {
                    nMSplashAdImpl.E();
                }
                NMSplashAdImpl.this.q = true;
                com.alliance.ssp.ad.l.c cVar2 = NMSplashAdImpl.this.R0;
                if (cVar2 != null) {
                    cVar2.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, Material material, SAAllianceAdData sAAllianceAdData, Handler handler, c.b bVar) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a((Context) activity, material, sAAllianceAdData, handler, bVar);
    }

    public final void a(Context context, Material material, SAAllianceAdData sAAllianceAdData, Handler handler, c.b bVar) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        try {
            String str = context.getExternalCacheDir() + "/nmssp_download/";
            material.getApkname();
            Toast.makeText(context, "正在下载app", 1).show();
            if (handler != null) {
                String deeplink = material.getDeeplink();
                if (deeplink != null) {
                    this.r = 1;
                    int iLastIndexOf = deeplink.lastIndexOf(47) + 1;
                    String str2 = deeplink.substring(iLastIndexOf, deeplink.indexOf(".apk", iLastIndexOf)) + ".apk";
                    e("", "", sAAllianceAdData);
                    this.z0 = str2;
                    com.alliance.ssp.ad.r.a aVar = new com.alliance.ssp.ad.r.a(context);
                    a aVar2 = this.k;
                    t tVar = new t(handler, sAAllianceAdData);
                    com.alliance.ssp.ad.r.f fVar = com.alliance.ssp.ad.r.f.i;
                    if (fVar == null && fVar == null) {
                        com.alliance.ssp.ad.r.f.i = new com.alliance.ssp.ad.r.f(aVar, tVar);
                    }
                    com.alliance.ssp.ad.r.f fVar2 = com.alliance.ssp.ad.r.f.i;
                    fVar2.e = aVar2;
                    fVar2.c = tVar;
                    this.x0 = fVar2;
                    com.alliance.ssp.ad.r.g gVar = new com.alliance.ssp.ad.r.g(str2, deeplink);
                    this.y0 = gVar;
                    fVar2.a(gVar);
                    com.alliance.ssp.ad.r.f.h = str;
                    this.x0.a(this.y0.b, str);
                }
            } else {
                String deeplink2 = material.getDeeplink();
                u uVar = new u(sAAllianceAdData);
                int i3 = com.alliance.ssp.ad.r.c.a;
                if (deeplink2 != null && !TextUtils.isEmpty(deeplink2)) {
                    new com.alliance.ssp.ad.r.b(deeplink2, context, uVar, bVar).start();
                }
            }
            r();
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("BaseAllianceAdImpl 011: ")), e2);
        }
    }
}
