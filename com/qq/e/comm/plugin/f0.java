package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.qo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class f0 implements NEADI {
    protected final e2 a;
    protected final Context b;
    protected final String c;
    protected final String d;
    protected final String e;
    protected final ADSize f;
    protected final mb g;
    protected final ADListener h;
    protected int i;
    protected VideoOption j;
    private volatile int m;
    private volatile int n;
    private String o;
    protected String[] p;
    protected String[] q;
    protected f5 r;
    protected volatile g1<ed> s;
    protected final j t;
    protected final b u;
    protected LoadAdParams v;
    protected String w;

    protected abstract b a();

    protected abstract g1<ed> f();

    @Override // com.qq.e.comm.pi.NEADI
    public String getAdNetWorkName() {
        return "";
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
    }

    protected f0(Context context, ADSize aDSize, String str, String str2, mb mbVar, ADListener aDListener, String str3, e2 e2Var) throws JSONException {
        f5 f5Var = new f5();
        this.r = f5Var;
        this.a = e2Var;
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = aDSize;
        this.h = aDListener;
        this.g = mbVar;
        f5Var.c(str2);
        this.r.a(e2Var);
        this.t = new j(e2Var, str2);
        this.u = a();
    }

    protected void g() {
        if (this.s != null) {
            return;
        }
        synchronized (this) {
            if (this.s != null) {
                return;
            }
            this.s = f();
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            f0.this.h.onADEvent(new ADEvent(101, Integer.valueOf(this.a)));
        }
    }

    protected w1 a(int i) {
        return a(i, (LoadAdParams) null);
    }

    public final ADListener e() {
        return this.h;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public final void setVideoOption(VideoOption videoOption) {
        this.j = videoOption;
        if (videoOption != null) {
            hd.a(this.d, videoOption);
        }
        this.u.a(videoOption);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public final void setMinVideoDuration(int i) {
        this.n = i;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public final void setMaxVideoDuration(int i) {
        this.m = i;
    }

    public String[] d() {
        return this.q;
    }

    public String[] c() {
        return this.p;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i, LoadAdParams loadAdParams) {
        this.v = loadAdParams;
        this.w = b5.a(loadAdParams);
    }

    protected final void b(ed edVar) {
        if (this.s != null) {
            w1 w1VarA = a(this.i);
            this.s.a((g1<ed>) edVar, w1VarA, this.t, (qo.f) null, this.r);
            this.s.b(w1VarA, this.t, this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i) {
        xo.a((Runnable) new a(i));
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.d, (h4) null, this.r, this, this.w);
    }

    /* compiled from: A */
    protected static abstract class b implements xk<ed> {
        protected final Context a;
        private final int b;
        private final int c;
        private VideoOption d;

        public abstract dd a(ed edVar);

        @Override // com.qq.e.comm.plugin.xk
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ed a(String str, String str2, String str3, e2 e2Var, JSONObject jSONObject, mb mbVar) {
            return new ed(str, str2, str3, e2Var, mbVar, jSONObject, this.b, this.c, this.d);
        }

        protected b(Context context, ADSize aDSize) {
            this.a = context;
            Pair<Integer, Integer> pairA = c2.a(aDSize, context);
            this.b = ((Integer) pairA.first).intValue();
            this.c = ((Integer) pairA.second).intValue();
        }

        public void a(VideoOption videoOption) {
            this.d = videoOption;
        }
    }

    protected final w1 a(int i, LoadAdParams loadAdParams) {
        w1 w1Var = new w1(this.a);
        w1Var.f(this.d);
        w1Var.g(this.e);
        w1Var.a(1);
        w1Var.b(i);
        w1Var.c(2);
        w1Var.i(this.f.getWidth());
        w1Var.h(this.f.getHeight());
        w1Var.f(this.n);
        w1Var.e(d40.a(this.m));
        w1Var.a(this.g);
        w1Var.e(this.o);
        w1Var.a(q8.a().a(this.a));
        if (loadAdParams != null) {
            w1Var.a(loadAdParams.getDevExtra());
        }
        return w1Var;
    }

    protected final g1<ed> a(int i, int i2) {
        boolean z = TextUtils.isEmpty(this.e) && i > 0;
        g1<ed> g1VarA = g1.a(this.d, this.r, this.a);
        g1VarA.a(z).a(i).b(i2);
        return g1VarA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ed a(JSONObject jSONObject) {
        return this.u.a(this.c, this.d, this.e, this.a, jSONObject, this.g);
    }

    public final void a(String str) {
        this.o = str;
    }
}
