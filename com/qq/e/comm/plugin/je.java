package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.callback.biz.DynamicAdCallback;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.g1;
import com.qq.e.comm.plugin.me;
import com.qq.e.comm.plugin.qo;
import com.qq.e.comm.plugin.wd;
import com.qq.e.comm.plugin.xc;
import com.qq.e.comm.util.GDTLogger;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class je implements RVADI, wd.b, os {
    private static final String A;
    private static final xk<pw> B;
    public static volatile int C;
    private final String a;
    private final Context b;
    private final String c;
    private final String d;
    private final mb e;
    private final com.qq.e.comm.plugin.j f;
    private final ADListener g;
    private final int h;
    private final ho i;
    private LoadAdParams j;
    private pw m;
    private volatile boolean n;
    private volatile boolean o;
    private long p;
    private rw q;
    private boolean r;
    private ServerSideVerificationOptions s;
    private f5 t;
    private String u;
    private long v;
    private g1<pw> w;
    private final Map<String, Boolean> x;
    private final ns y;
    private String z;

    static {
        q8.a().b(e2.REWARDVIDEOAD);
        A = "je";
        B = new k();
        C = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_TYPE, 0, this, str, Integer.valueOf(i2));
    }

    protected w1 d() {
        return (w1) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE, 0, this);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return false;
    }

    /* compiled from: A */
    class k implements xk<pw> {
        @Override // com.qq.e.comm.plugin.xk
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public pw a(String str, String str2, String str3, e2 e2Var, JSONObject jSONObject, mb mbVar) {
            return new pw(str, str2, str3, jSONObject, mbVar);
        }

        k() {
        }
    }

    public je(Context context, String str, String str2, mb mbVar, String str3, ADListener aDListener) throws JSONException {
        this.j = null;
        this.n = false;
        this.o = false;
        this.q = rw.MEDIA;
        this.r = true;
        this.t = new f5();
        this.x = new ConcurrentHashMap();
        this.y = new ns();
        this.b = context;
        this.c = str2;
        this.d = str3;
        this.t.c(str2);
        f5 f5Var = this.t;
        e2 e2Var = e2.REWARDVIDEOAD;
        f5Var.a(e2Var);
        this.e = mbVar;
        this.h = dx.a(str2);
        this.g = aDListener;
        this.a = str;
        this.i = new ho(str2);
        this.f = new com.qq.e.comm.plugin.j(e2Var, str2);
        r();
    }

    private void r() {
        int iA = xc.a("skrvpdv", this.c, 6, (ku) null);
        e2 e2Var = e2.REWARDVIDEOAD;
        int iA2 = xc.a("skrvp", e2Var.c(), this.c, iA);
        String str = g1.o;
        g1<pw> g1VarA = g1.a(this.c, this.t, e2Var);
        this.w = g1VarA;
        g1VarA.a(b(iA2)).a(iA2).b(xc.a("apitp", e2Var.c(), this.c, 400)).a(new u(this, this.a, this.c, this.d, this.e, B));
    }

    /* compiled from: A */
    class m implements g1.h<pw> {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ w1 c;

        @Override // com.qq.e.comm.plugin.g1.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public pw a(JSONObject jSONObject) {
            return (pw) je.B.a(je.this.a, je.this.c, je.this.d, e2.REWARDVIDEOAD, jSONObject, je.this.e);
        }

        m(boolean z, String str, w1 w1Var) {
            this.a = z;
            this.b = str;
            this.c = w1Var;
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(pw pwVar) throws JSONException {
            pw pwVarE = je.this.e(pwVar);
            l1.a(pwVarE);
            if (this.a && je.this.m != null) {
                ((DynamicAdCallback) x5.b(je.this.m.s0(), DynamicAdCallback.class)).N().b(new Pair<>(this.b, pwVarE));
                je.this.w.a((g1) pwVarE, this.c, je.this.f, (qo.f) null, je.this.t);
            } else if (pwVarE == null) {
                je.this.a(new eo("", 5004));
            } else {
                je.this.a(pwVar, pwVarE.s1());
            }
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(eo eoVar) {
            if (this.a) {
                if (eoVar == null || eoVar.a() != 5014 || !je.this.i.a()) {
                    if (je.this.m != null) {
                        ((DynamicAdCallback) x5.b(je.this.m.s0(), DynamicAdCallback.class)).N().b(new Pair<>(this.b, null));
                        return;
                    }
                    return;
                }
                je.this.a(this.b, 1);
                return;
            }
            if (eoVar == null || eoVar.a() != 5014) {
                je.this.a(eoVar);
            } else {
                je.this.c(ErrorCode.NO_AD_FILL_FOR_INSTALLED);
            }
        }
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        this.i.b();
        a((String) null, 0);
    }

    /* compiled from: A */
    class n implements Runnable {
        final /* synthetic */ eo a;

        n(eo eoVar) {
            this.a = eoVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            je.this.a(this.a.a());
        }
    }

    /* compiled from: A */
    class o implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ h4 b;

        o(int i, h4 h4Var) {
            this.a = i;
            this.b = h4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strS0;
            if (je.this.g != null) {
                if (this.a == 5002) {
                    if (this.b != null) {
                        Boolean bool = Boolean.TRUE;
                        Map map = je.this.x;
                        strS0 = this.b.s0();
                        if (bool.equals(map.get(strS0))) {
                            return;
                        }
                    } else {
                        strS0 = "";
                    }
                    je.this.x.put(strS0, Boolean.TRUE);
                }
                je.this.g.onADEvent(new ADEvent(107, Integer.valueOf(this.a)));
                if (this.a == 5002 && this.b != null && com.qq.e.comm.plugin.k.b()) {
                    com.qq.e.comm.plugin.k.g(this.b);
                }
            }
        }
    }

    public je(Context context, String str, String str2, String str3, ADListener aDListener) {
        this(context, str, str2, mb.DEFAULT, str3, aDListener);
    }

    private int n() {
        return this.w != null ? 3 : 0;
    }

    /* compiled from: A */
    class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            je.this.g.onADEvent(new ADEvent(100, new Object[0]));
            go.a(je.this.t, 1, je.this.m);
        }
    }

    private boolean f(pw pwVar) {
        return pwVar.p0() != null && pwVar.p0().F() && xc.a("unflp", pwVar.y0(), 0) <= 0;
    }

    private boolean f() {
        return r1.d().f().a("rvaulap", 1) == 1;
    }

    /* compiled from: A */
    class q implements Runnable {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (je.this.m == null) {
                return;
            }
            String strD0 = je.this.m.d0();
            if (!TextUtils.isEmpty(strD0) && new File(gu.b(), gu.d(strD0)).exists()) {
                je.this.e();
            } else {
                if (TextUtils.isEmpty(this.a) || f40.a(je.this.m) == null) {
                    return;
                }
                je.this.e();
            }
        }
    }

    /* compiled from: A */
    class r implements me.c {
        final /* synthetic */ String a;
        final /* synthetic */ pw b;

        @Override // com.qq.e.comm.plugin.me.c
        public void a(boolean z) {
        }

        r(String str, pw pwVar) {
            this.a = str;
            this.b = pwVar;
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(String str) {
            String unused = je.A;
            je.this.e();
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void onCancel() {
            String unused = je.A;
            je.this.a(this.b, 5002);
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void b() {
            String unused = je.A;
            ax.c(je.this.t);
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(db dbVar) {
            String unused = je.A;
            dbVar.b();
            if (je.this.o) {
                return;
            }
            je.this.a(this.b, 5002);
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a() {
            String unused = je.A;
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(int i, long j, long j2) {
            String unused = je.A;
        }
    }

    private void g() {
        int iE = dx.e(this.m);
        String strV0 = this.m.V0();
        if (iE < 0 || TextUtils.isEmpty(strV0)) {
            return;
        }
        xo.a(new q(strV0), iE);
    }

    /* compiled from: A */
    class s implements nm {
        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
        }

        s() {
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            if (koVar.a()) {
                return;
            }
            b10.a(9130005, je.this.t, 2);
        }
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        a(r1.d().a(), true);
    }

    private boolean c(pw pwVar) {
        String strV0 = pwVar.V0();
        if (!TextUtils.isEmpty(strV0)) {
            String strA = ui.a().a(strV0);
            if (!TextUtils.isEmpty(strA) && v5.a(pwVar.K())) {
                e();
                return false;
            }
            if (f40.a(pwVar) == null) {
                pwVar.S0();
                me.a().a(strV0, strA, new r(strV0, pwVar), pwVar, true);
            } else {
                pwVar.S0();
                e();
            }
            b(pwVar);
            return true;
        }
        e();
        return true;
    }

    /* compiled from: A */
    private static class u implements g1.j {
        private static final String g = g1.o;
        private final WeakReference<je> a;
        private final String b;
        private final String c;
        private final String d;
        private final mb e;
        private final xk<pw> f;

        public u(je jeVar, String str, String str2, String str3, mb mbVar, xk<pw> xkVar) {
            this.a = new WeakReference<>(jeVar);
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = mbVar;
            this.f = xkVar;
        }

        @Override // com.qq.e.comm.plugin.g1.j
        public void a(List<JSONObject> list) {
            int size;
            je jeVar;
            if (list == null || (size = list.size()) <= 0 || (jeVar = this.a.get()) == null) {
                return;
            }
            for (int i = 0; i < size; i++) {
                pw pwVar = (pw) this.f.a(this.b, this.c, this.d, e2.REWARDVIDEOAD, list.get(i), this.e);
                if (!TextUtils.isEmpty(pwVar.V0())) {
                    jeVar.b(pwVar);
                }
            }
        }
    }

    private void u() {
        pw pwVar = this.m;
        if (pwVar == null) {
            return;
        }
        boolean zS1 = pwVar.s1();
        int i2 = zS1 ? 1 : System.currentTimeMillis() - this.v > ((long) r1.d().f().a("skrvltstg", this.m.y0(), 60000)) ? 2 : 0;
        boolean z = !TextUtils.isEmpty(this.d);
        b10.a(1020053, this.t, Integer.valueOf(i2), Integer.valueOf(((z ? 2 : 1) * 100) + n()), null);
        ax.a(this.t, zS1, z);
    }

    @Override // com.qq.e.comm.pi.RVADI
    @Deprecated
    public long getExpireTimestamp() {
        return this.p;
    }

    private boolean t() {
        return com.qq.e.comm.plugin.k.a(this.p);
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return (hasShown() || t()) ? false : true;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        return this.n;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        kp.b().a(this.c, e2.REWARDVIDEOAD);
        pw pwVar = this.m;
        if (pwVar == null) {
            return -1;
        }
        return pwVar.M();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i2) {
        b5.a(i2, this.m, this.c, this.t, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i2, int i3, String str) {
        b5.a(i2, i3, str, this.c, this.m, this.t, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i2) {
        pw pwVar = this.m;
        if (pwVar != null) {
            b5.a(pwVar.y0(), i2);
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        pw pwVar = this.m;
        if (pwVar != null) {
            return pwVar.V();
        }
        return new HashMap();
    }

    public int q() {
        pw pwVar = this.m;
        if (pwVar == null) {
            return -1;
        }
        return pwVar.z0();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        kp.b().a(this.c, e2.REWARDVIDEOAD);
        pw pwVar = this.m;
        if (pwVar == null) {
            return null;
        }
        return pwVar.g1();
    }

    public int o() {
        pw pwVar = this.m;
        if (pwVar == null) {
            return -1;
        }
        return pwVar.o0();
    }

    public boolean s() {
        pw pwVar = this.m;
        return pwVar != null && pwVar.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.m == null || this.o) {
            return;
        }
        this.o = true;
        a(this.m.S0(), 10005, (Object) null);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z) {
        this.r = z;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
        this.z = b5.a(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        pw pwVar = this.m;
        if (pwVar == null) {
            return 0;
        }
        return pwVar.W0() * 1000;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        return this.q == rw.PAGE ? 1 : 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.s = serverSideVerificationOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(pw pwVar) {
        String strD0 = pwVar.d0();
        mm.a().a(strD0, new s(), v5.b("vcri") + pwVar.k().e());
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        pw pwVar = this.m;
        if (pwVar != null) {
            return pwVar.p();
        }
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        pw pwVar = this.m;
        if (pwVar != null && downloadConfirmListener != null) {
            String strK0 = pwVar.k0();
            qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListener);
            d3.b().a(strK0, downloadConfirmListener);
            return;
        }
        GDTLogger.e("setDownloadConfirmListener调用错误，广告数据或listener为空");
    }

    /* compiled from: A */
    class t extends ms<Void> {
        t(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            je.this.g.onADEvent(new ADEvent(102, new Object[0]));
        }
    }

    /* compiled from: A */
    class a extends ms<Void> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            je.this.g.onADEvent(new ADEvent(103, new Object[0]));
            bd.a(je.this.t);
        }
    }

    /* compiled from: A */
    class b extends ms<Void> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            je.this.g.onADEvent(new ADEvent(106, new Object[0]));
        }
    }

    /* compiled from: A */
    class c extends ms<Void> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            je.this.g.onADEvent(new ADEvent(105, new Object[0]));
        }
    }

    /* compiled from: A */
    class d extends ms<zw> {
        final /* synthetic */ pw b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(os osVar, pw pwVar) {
            super(osVar);
            this.b = pwVar;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(zw zwVar) {
            int iA = zwVar.a();
            String strB = dx.b(this.b.S0());
            if (iA == 0) {
                je.this.g.onADEvent(new ADEvent(104, strB));
            } else {
                je.this.g.onADEvent(new ADEvent(104, strB, Integer.valueOf(iA)));
            }
            if (je.this.m != null && (iA == 0 || iA == 1 || r1.d().f().a("sksrsr", je.this.c, 0) == 1)) {
                dx.a(je.this.m, zwVar, je.this.s);
            }
            b10.a(1403021, je.this.t, 1, Integer.valueOf(iA), null);
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
            je.this.g.onADEvent(new ADEvent(107, num));
        }
    }

    /* compiled from: A */
    class f extends ms<Void> {
        f(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            je.this.g.onADEvent(new ADEvent(304, new Object[0]));
        }
    }

    public void a(Context context, boolean z) {
        w1 w1VarD;
        ax.b(this.t);
        int i2 = 0;
        if (this.m == null || this.w == null) {
            w1VarD = null;
        } else {
            w1VarD = d();
            this.w.a((g1<pw>) this.m, w1VarD, this.f, (qo.f) null, this.t);
            for (int i3 = 0; i3 < this.m.U(); i3++) {
                this.w.a((g1<pw>) this.m.b(i3), w1VarD, this.f, (qo.f) null, this.t);
            }
        }
        if (this.m == null) {
            i2 = 4014;
        } else if (this.n) {
            i2 = 4015;
        } else if (t()) {
            i2 = ErrorCode.AD_DATA_EXPIRE;
        }
        if (i2 != 0) {
            a(i2);
            ax.a(this.t, i2);
            return;
        }
        this.n = true;
        if (this.w != null) {
            if (w1VarD == null) {
                w1VarD = d();
            }
            this.w.b(w1VarD, this.f, this.t);
        }
        if (this.q != rw.PAGE) {
            b(this.m, context, z);
        } else {
            a(this.m, context, z);
        }
        u();
    }

    /* compiled from: A */
    class g extends ms<e40> {
        final /* synthetic */ pw b;

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(e40 e40Var) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(je.this.x.get(this.b.s0()))) {
                return;
            }
            je.this.x.put(this.b.s0(), bool);
            ADListener aDListener = je.this.g;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(e40Var == null ? 5002 : e40Var.b());
            aDListener.onADEvent(new ADEvent(107, objArr));
            if ((e40Var == null || e40Var.b() == 5002) && com.qq.e.comm.plugin.k.b()) {
                com.qq.e.comm.plugin.k.g(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(os osVar, pw pwVar) {
            super(osVar);
            this.b = pwVar;
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
            je.this.g.onADEvent(new ADEvent(209, new Object[0]));
        }
    }

    /* compiled from: A */
    class i extends ms<Integer> {
        i(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            if (num == null) {
                num = -1;
            }
            je.this.g.onADEvent(new ADEvent(210, num));
        }
    }

    /* compiled from: A */
    class j extends ms<Void> {
        j(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            je.this.g.onADEvent(new ADEvent(206, new Object[0]));
        }
    }

    /* compiled from: A */
    class l extends ms<String> {
        l(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            je.this.a(str, 0);
        }
    }

    protected boolean b(int i2) {
        return TextUtils.isEmpty(this.d) && i2 > 0;
    }

    public String[] m() {
        String[] strArr = new String[1];
        pw pwVar = this.m;
        strArr[0] = pwVar == null ? "" : pwVar.e1();
        return strArr;
    }

    public String[] h() {
        String[] strArr = new String[1];
        pw pwVar = this.m;
        strArr[0] = pwVar == null ? "" : pwVar.W();
        return strArr;
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pw e(pw pwVar) throws JSONException {
        if (!TextUtils.isEmpty(pwVar.V0())) {
            int iB1 = pwVar.b1();
            int iX0 = pwVar.X0();
            int iW0 = pwVar.W0();
            int iA = xc.a("rewardVideoServerMaxDuration", pwVar.y0(), 301);
            if (iB1 <= 0 || iX0 <= 0 || iW0 <= 0 || (iA > 0 && iW0 >= iA)) {
                go.a(ErrorCode.VIDEO_DURATION_ERROR, this.t, 1, new ja().a("width", Integer.valueOf(iB1)).a("height", Integer.valueOf(iX0)).a("du", Integer.valueOf(iW0)));
                return null;
            }
        }
        f5 f5VarA = f5.a(pwVar);
        this.t = f5VarA;
        go.b(f5VarA, 1);
        a(pwVar);
        return pwVar;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        if (activity == null) {
            GDTLogger.e("传入参数错误：showAD传入参数activity为空");
            a(4001);
        } else {
            a((Context) activity, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        if (this.i.a()) {
            a((String) null, 1);
        } else {
            a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        a((h4) null, i2);
    }

    private void d(pw pwVar) {
        ((DynamicAdCallback) x5.b(pwVar.s0(), DynamicAdCallback.class)).loadAd().a(new l(this));
    }

    private void g(pw pwVar) {
        FSCallback fSCallback = (FSCallback) x5.b(pwVar.s0(), FSCallback.class);
        fSCallback.M().a(new t(this));
        fSCallback.k().a(new a(this));
        fSCallback.Q().a(new b(this));
        fSCallback.u().a(new c(this));
        fSCallback.P().a(new d(this, pwVar));
        fSCallback.C().a(new e(this));
        fSCallback.onComplainSuccess().a(new f(this));
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        b5.a(map, this.m, this.c, this.t, this);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.c, this.m, this.t, this, this.z);
    }

    public void a(pw pwVar, boolean z) throws JSONException {
        qm$h$$ExternalSyntheticBackport0.m(pwVar);
        String strV0 = pwVar.V0();
        if (C == 1) {
            if ((pwVar.p0() != null && pwVar.p0().x()) || f(pwVar)) {
                this.q = rw.PAGE;
            } else {
                this.q = rw.MEDIA;
            }
        } else if ((TextUtils.isEmpty(strV0) && pwVar.p0() == null) || f(pwVar)) {
            this.q = rw.PAGE;
        } else {
            this.q = rw.MEDIA;
        }
        pwVar.a(this.q);
        this.m = pwVar;
        this.p = com.qq.e.comm.plugin.k.b(pwVar);
        this.n = false;
        this.o = false;
        this.v = System.currentTimeMillis();
        wd.a().b(this.m.S0(), this);
        if (this.q == rw.MEDIA) {
            this.m.f(3);
            this.t.c(3);
        }
        if (this.q == rw.PAGE && dx.d(this.m.y0())) {
            xw.a(this.b, this.m);
        }
        hd.a(this.m.y0(), new VideoOption.Builder().setAutoPlayMuted(!this.r).setDetailPageMuted(false).setAutoPlayPolicy(1).build());
        if (c(this.m)) {
            g();
        }
        b5.d(this.c, this);
        xo.a((Runnable) new p());
    }

    private void b(pw pwVar, Context context, boolean z) {
        ((ud) zm.a(pwVar.s0(), ud.class)).a(this);
        g(pwVar);
        d(pwVar);
        h(pwVar);
        pd.a(context, pwVar, z);
    }

    private void h(pw pwVar) {
        VideoCallback videoCallback = (VideoCallback) x5.b(pwVar.s0(), VideoCallback.class);
        videoCallback.K().a(new g(this, pwVar));
        videoCallback.Z().a(new h(this));
        videoCallback.b().a(new i(this));
        videoCallback.q().a(new j(this));
    }

    private void a(pw pwVar, Context context, boolean z) {
        Intent intent = new Intent();
        intent.setClassName(context, wx.d());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.REWARD_PAGE);
        intent.putExtra("appid", pwVar.n());
        intent.putExtra("clickStartTime", System.currentTimeMillis());
        intent.putExtra("objectId", pwVar.s0());
        ((ud) zm.a(pwVar.s0(), ud.class)).a((h4) pwVar);
        if (z) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            ((ud) zm.a(pwVar.s0(), ud.class)).a(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.wd.b
    public void a(String str, int i2, Object obj) {
        pw pwVar = this.m;
        if (pwVar == null || !str.equals(pwVar.S0())) {
            return;
        }
        switch (i2) {
            case 10000:
                this.g.onADEvent(new ADEvent(100, new Object[0]));
                break;
            case 10001:
                this.g.onADEvent(new ADEvent(102, new Object[0]));
                break;
            case 10002:
                this.g.onADEvent(new ADEvent(103, new Object[0]));
                bd.a(this.t);
                break;
            case 10003:
                this.g.onADEvent(new ADEvent(105, new Object[0]));
                break;
            case 10004:
                this.g.onADEvent(new ADEvent(106, new Object[0]));
                break;
            case 10005:
                this.g.onADEvent(new ADEvent(201, new Object[0]));
                break;
            default:
                switch (i2) {
                    case 10012:
                        this.g.onADEvent(new ADEvent(206, new Object[0]));
                        break;
                    case com.style.widget.ad.c /* 10013 */:
                    case 10015:
                        this.g.onADEvent(new ADEvent(107, obj));
                        break;
                    case 10014:
                        if (obj instanceof wd.c) {
                            wd.c cVar = (wd.c) obj;
                            this.g.onADEvent(new ADEvent(104, dx.b(cVar.a)));
                            pw pwVar2 = this.m;
                            if (pwVar2 != null) {
                                dx.a(pwVar2, cVar.b, this.s);
                                break;
                            }
                        }
                        break;
                    case com.style.widget.ad.f /* 10016 */:
                        this.g.onADEvent(new ADEvent(304, new Object[0]));
                        break;
                }
        }
    }

    public void a(String str) {
        this.u = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(eo eoVar) {
        xo.a((Runnable) new n(eoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h4 h4Var, int i2) {
        xo.a((Runnable) new o(i2, h4Var));
    }

    private void a(pw pwVar) {
        xc.c cVarD = xc.d();
        e2 e2Var = e2.REWARDVIDEOAD;
        cVarD.a(pwVar, e2Var.c(), "skrvp", 6).a(pwVar, e2Var.c(), "apitp", 400).a(pwVar, "rewardVideoServerMaxDuration", 301).a(pwVar, "sksrvmd", 0).a(pwVar, "rewardLoadAdCount", 1).a(pwVar, "rewardVideoLoadRetryTimes", 2).a();
    }
}
