package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j30 implements UIADI, ApkDownloadComplianceInterface, os {
    public static AtomicBoolean n;
    public static long o;
    private final com.qq.e.comm.plugin.i a;
    private final l30 b;
    private yd c;
    private final ADListener d;
    private boolean e;
    private boolean f;
    private boolean g;
    private String h;
    private final ns i;
    private volatile boolean j;
    private String m;

    /* compiled from: A */
    public interface s {
        void a(boolean z);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return false;
    }

    public j30(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        this(activity, str, str2, str3, mb.DEFAULT, aDListener);
    }

    /* compiled from: A */
    class j implements s {
        j() {
        }

        @Override // com.qq.e.comm.plugin.j30.s
        public void a(boolean z) {
            j30.this.f = z;
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        this.b.show();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        if (activity == null) {
            GDTLogger.e("showFullScreenAD错误，Activity为空");
            return;
        }
        e2 e2Var = e2.SPLASH;
        f5 f5VarP = this.c.p();
        hn.a(f5VarP);
        if (this.g) {
            GDTLogger.e("showFullScreenAD错误，同一条广告不允许多次展示，请再次拉取后展示");
            hn.a(f5VarP, 4015);
        } else if (this.c.n() == null) {
            GDTLogger.e("showFullScreenAD错误，广告未加载");
            hn.a(f5VarP, 4014);
        } else if (this.c.o()) {
            hn.a(f5VarP, ErrorCode.AD_DATA_EXPIRE);
        } else {
            this.g = true;
            a(activity, this.d, new k(), this.c);
        }
    }

    /* compiled from: A */
    class k implements s {
        k() {
        }

        @Override // com.qq.e.comm.plugin.j30.s
        public void a(boolean z) {
            j30.this.f = z;
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        if (this.j) {
            GDTLogger.w("广告已关闭，close接口调用无效，请确认是否想调用的是UnifiedInterstitialAD#destroy?");
            return;
        }
        this.j = true;
        if (this.e) {
            this.c.close();
        } else {
            this.b.close();
        }
    }

    public int c() {
        h4 h4VarA = a();
        if (h4VarA == null) {
            return -1;
        }
        return h4VarA.z0();
    }

    public j30(Activity activity, String str, String str2, String str3, mb mbVar, ADListener aDListener) {
        this.i = new ns();
        this.h = str2;
        this.d = aDListener;
        com.qq.e.comm.plugin.i iVar = new com.qq.e.comm.plugin.i(this, aDListener, str2, new j());
        this.a = iVar;
        this.b = new l30(activity, new ADSize(-1, -2), str, str2, str3, mbVar, iVar);
        this.c = new yd(activity, new ADSize(-1, -2), str, str2, str3, mbVar, iVar);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        this.e = false;
        this.b.loadAd();
        this.g = false;
        this.j = false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        this.e = true;
        this.c.loadAd(r1.d().f().a("ilat", e2.UNIFIED_INTERSTITIAL.b()));
        this.g = false;
        this.j = false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.m = b5.a(loadAdParams);
        this.b.setLoadAdParams(loadAdParams);
        this.c.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destroy() {
        this.b.destroy();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        h4 h4VarA = a();
        kp.b().a(this.h, h4VarA != null ? h4VarA.k() : null);
        if (h4VarA == null) {
            return -1;
        }
        return h4VarA.M();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        this.b.show(activity);
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        h4 h4VarA = a();
        kp.b().a(this.h, h4VarA != null ? h4VarA.k() : null);
        if (h4VarA == null) {
            return null;
        }
        return h4VarA.g1();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i2) {
        b5.a(i2, a(), this.h, (this.e ? this.c : this.b).p(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i2, int i3, String str) {
        b5.a(i2, i3, str, this.h, a(), (this.e ? this.c : this.b).p(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i2) {
        h4 h4VarA = a();
        if (h4VarA != null) {
            b5.a(h4VarA.y0(), i2);
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        h4 h4VarA = a();
        if (h4VarA != null) {
            return h4VarA.V();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        this.b.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i2) {
        this.b.setMinVideoDuration(i2);
        this.c.setMinVideoDuration(i2);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i2) {
        this.b.setMaxVideoDuration(i2);
        this.c.setMaxVideoDuration(i2);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        if (this.e) {
            dn dnVarT = this.c.n();
            if (dnVarT == null) {
                return 0;
            }
            return TextUtils.isEmpty(dnVarT.V0()) ? 4 : 2;
        }
        return this.b.getAdPatternType();
    }

    private boolean h() {
        if (this.e) {
            return this.c.o();
        }
        return this.b.o();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        if (h()) {
            this.f = false;
        }
        return this.f;
    }

    private h4 a() {
        return this.e ? this.c.n() : this.b.n();
    }

    public int f() {
        h4 h4VarA = a();
        if (h4VarA == null) {
            return -1;
        }
        return h4VarA.o0();
    }

    public boolean g() {
        h4 h4VarA = a();
        if (h4VarA == null) {
            return false;
        }
        return h4VarA.l1();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getVideoDuration() {
        if (this.e) {
            dn dnVarT = this.c.n();
            return (dnVarT == null ? 0 : dnVarT.W0()) * 1000;
        }
        return this.b.getVideoDuration();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.c.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public String[] e() {
        if (this.e) {
            return this.c.d();
        }
        return this.b.d();
    }

    public String[] d() {
        if (this.e) {
            return this.c.c();
        }
        return this.b.c();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        if (this.e) {
            return this.c.getApkInfoUrl();
        }
        return this.b.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        if (this.e) {
            this.c.setDownloadConfirmListener(downloadConfirmListener);
        } else {
            this.b.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    /* compiled from: A */
    class l extends ms<Void> {
        final /* synthetic */ ADListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(os osVar, ADListener aDListener) {
            super(osVar);
            this.b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(102, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class m extends ms<Void> {
        final /* synthetic */ ADListener b;
        final /* synthetic */ qk c;
        final /* synthetic */ s d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(os osVar, ADListener aDListener, qk qkVar, s sVar) {
            super(osVar);
            this.b = aDListener;
            this.c = qkVar;
            this.d = sVar;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r5) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(103, new Object[0]));
                b10.a(1411000, this.c.p());
                bd.a(this.c.p());
            }
            s sVar = this.d;
            if (sVar != null) {
                sVar.a(false);
            }
        }
    }

    /* compiled from: A */
    class n extends ms<Void> {
        final /* synthetic */ ADListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(os osVar, ADListener aDListener) {
            super(osVar);
            this.b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(105, new Object[0]));
            }
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        b5.a(map, a(), this.h, (this.e ? this.c : this.b).p(), this);
    }

    /* compiled from: A */
    class o extends ms<i6> {
        final /* synthetic */ ADListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(os osVar, ADListener aDListener) {
            super(osVar);
            this.b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(i6 i6Var) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(105, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class p extends ms<Void> {
        final /* synthetic */ ADListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(os osVar, ADListener aDListener) {
            super(osVar);
            this.b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(106, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class q extends ms<Void> {
        final /* synthetic */ ADListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(os osVar, ADListener aDListener) {
            super(osVar);
            this.b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(303, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class r extends ms<zw> {
        final /* synthetic */ ADListener b;
        final /* synthetic */ h4 c;
        final /* synthetic */ qk d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(os osVar, ADListener aDListener, h4 h4Var, qk qkVar) {
            super(osVar);
            this.b = aDListener;
            this.c = h4Var;
            this.d = qkVar;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(zw zwVar) {
            if (this.b != null) {
                this.b.onADEvent(new ADEvent(104, dx.b(dx.b(this.c.S0()))));
            }
            dx.a(this.c, zwVar, this.d.l());
        }
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.h, a(), (this.e ? this.c : this.b).p(), this, this.m);
    }

    /* compiled from: A */
    class a extends ms<Void> {
        final /* synthetic */ ADListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(os osVar, ADListener aDListener) {
            super(osVar);
            this.b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(304, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class b extends ms<Integer> {
        final /* synthetic */ ADListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(os osVar, ADListener aDListener) {
            super(osVar);
            this.b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            ADListener aDListener = this.b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(101, num));
            }
        }
    }

    /* compiled from: A */
    class c extends ms<e40> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(e40 e40Var) {
            if (j30.this.d != null) {
                ADListener aDListener = j30.this.d;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(e40Var == null ? 5002 : e40Var.b());
                aDListener.onADEvent(new ADEvent(207, objArr));
            }
        }
    }

    /* compiled from: A */
    class d extends ms<Void> {
        d(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            if (j30.this.d != null) {
                j30.this.d.onADEvent(new ADEvent(209, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class e extends ms<Integer> {
        e(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            if (num == null) {
                num = -1;
            }
            if (j30.this.d != null) {
                j30.this.d.onADEvent(new ADEvent(210, num));
            }
        }
    }

    /* compiled from: A */
    class f extends ms<Void> {
        final /* synthetic */ f5 b;
        final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(os osVar, f5 f5Var, long j) {
            super(osVar);
            this.b = f5Var;
            this.c = j;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r5) {
            hn.d(this.b, System.currentTimeMillis() - this.c);
            if (j30.this.d != null) {
                j30.this.d.onADEvent(new ADEvent(202, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class g extends ms<Boolean> {
        g(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) {
            if (j30.this.d != null) {
                j30.this.d.onADEvent(new ADEvent(202, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class h extends ms<Void> {
        h(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            if (j30.this.d != null) {
                j30.this.d.onADEvent(new ADEvent(204, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    class i extends ms<Void> {
        i(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            if (j30.this.d != null) {
                j30.this.d.onADEvent(new ADEvent(206, new Object[0]));
            }
        }
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.i;
    }

    private void a(h4 h4Var, ADListener aDListener, s sVar, qk qkVar) {
        FSCallback fSCallback = (FSCallback) x5.b(h4Var.s0(), FSCallback.class);
        fSCallback.M().a(new l(this, aDListener));
        fSCallback.k().a(new m(this, aDListener, qkVar, sVar));
        fSCallback.u().a(new n(this, aDListener));
        fSCallback.s().a(new o(this, aDListener));
        fSCallback.Q().a(new p(this, aDListener));
        fSCallback.c().a(new q(this, aDListener));
        fSCallback.P().a(new r(this, aDListener, h4Var, qkVar));
        fSCallback.onComplainSuccess().a(new a(this, aDListener));
        fSCallback.C().a(new b(this, aDListener));
    }

    private void a(h4 h4Var, f5 f5Var) {
        VideoCallback videoCallback = (VideoCallback) x5.b(h4Var.s0(), VideoCallback.class);
        videoCallback.K().a(new c(this));
        videoCallback.Z().a(new d(this));
        videoCallback.b().a(new e(this));
        videoCallback.a().a(new f(this, f5Var, System.currentTimeMillis()));
        videoCallback.onResume().a(new g(this));
        videoCallback.onPause().a(new h(this));
        videoCallback.q().a(new i(this));
    }

    public void a(String str) {
        this.b.a(str);
        this.c.a(str);
    }

    public void a(Activity activity, ADListener aDListener, s sVar, yd ydVar) {
        dn dnVarT = ydVar.n();
        a(dnVarT, aDListener, sVar, ydVar);
        a(dnVarT, ydVar.p());
        ydVar.w();
        ((ud) zm.a(dnVarT.s0(), ud.class)).a(this);
        pd.a((Context) activity, (h4) dnVarT, false);
        hn.a(ydVar.p(), System.currentTimeMillis() - ydVar.I);
        hn.a(ydVar.p(), dnVarT.s1(), !TextUtils.isEmpty(ydVar.u()));
    }
}
