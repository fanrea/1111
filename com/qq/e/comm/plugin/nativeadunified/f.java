package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.b5;
import com.qq.e.comm.plugin.d40;
import com.qq.e.comm.plugin.e2;
import com.qq.e.comm.plugin.eo;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.fr;
import com.qq.e.comm.plugin.g1;
import com.qq.e.comm.plugin.go;
import com.qq.e.comm.plugin.h4;
import com.qq.e.comm.plugin.j;
import com.qq.e.comm.plugin.mb;
import com.qq.e.comm.plugin.q8;
import com.qq.e.comm.plugin.qo;
import com.qq.e.comm.plugin.w1;
import com.qq.e.comm.plugin.xc;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f implements NUADI {
    private String a;
    private String b;
    private String c;
    private mb d;
    private String e;
    private ADListener f;
    private List<String> g;
    private String[] h;
    private String[] i;
    private int j;
    private int m;
    private f5 n;
    private Handler o;
    private volatile int p;
    private volatile int q;
    long r;
    private final e2 s;
    private g1<fr> t;
    private final j u;
    private String v;

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f != null) {
                f.this.f.onADEvent(new ADEvent(100, this.a));
                f5 f5Var = f.this.n;
                List list = this.a;
                go.c(f5Var, list != null ? list.size() : 0);
            }
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f != null) {
                f.this.f.onADEvent(new ADEvent(101, Integer.valueOf(this.a)));
            }
        }
    }

    static {
        q8.a().b(e2.NATIVEUNIFIEDAD);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i) {
        loadData(i, null);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.b, (h4) null, this.n, this, this.v);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                this.g.add(str);
            }
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i) {
        this.q = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i) {
        this.p = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
    }

    private void g() {
        if (this.t != null) {
            return;
        }
        synchronized (this) {
            if (this.t != null) {
                return;
            }
            boolean z = false;
            int iA = xc.a("nucasi", this.s.c(), this.b, 0);
            int iA2 = xc.a("nureti", this.s.c(), this.b, 0);
            if (TextUtils.isEmpty(this.c) && iA > 0) {
                z = true;
            }
            g1<fr> g1VarA = g1.a(this.b, this.n, this.s);
            g1VarA.a(z).a(iA).b(iA2);
            this.t = g1VarA;
        }
    }

    public int d() {
        return this.m;
    }

    public int f() {
        return this.j;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i, LoadAdParams loadAdParams) {
        if (Build.VERSION.SDK_INT < 16) {
            a(4007);
            return;
        }
        if (i < 1) {
            GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为1", null);
            i = 1;
        }
        if (i > 10) {
            GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为10", null);
            i = 10;
        }
        this.v = b5.a(loadAdParams);
        b(i, loadAdParams);
    }

    public String[] c() {
        return this.i;
    }

    private void b(int i, LoadAdParams loadAdParams) {
        g();
        this.t.a(a(i, loadAdParams), this.u, this.n, new a(loadAdParams));
    }

    public String e() {
        return this.b;
    }

    public f(Context context, String str, String str2, mb mbVar, String str3, ADListener aDListener) throws JSONException {
        this.j = -1;
        this.m = -1;
        this.n = new f5();
        this.o = new Handler(Looper.getMainLooper());
        this.a = str;
        this.b = str2;
        this.c = str3;
        e2 e2Var = e2.NATIVEUNIFIEDAD;
        this.s = e2Var;
        this.d = mbVar;
        this.f = aDListener;
        this.n.c(str2);
        this.n.a(e2Var);
        this.u = new j(e2Var, this.b);
    }

    public f(Context context, String str, String str2, String str3, ADListener aDListener) {
        this(context, str, str2, mb.DEFAULT, str3, aDListener);
    }

    public w1 a(int i, LoadAdParams loadAdParams) {
        w1 w1Var = new w1(this.s);
        w1Var.f(this.b);
        w1Var.g(this.c);
        w1Var.a(1);
        w1Var.b(i);
        w1Var.a(this.d);
        w1Var.e(this.e);
        w1Var.c(2);
        w1Var.a(this.g);
        w1Var.f(this.p);
        w1Var.e(d40.a(this.q));
        w1Var.a(q8.a().a(this.s));
        if (loadAdParams != null) {
            w1Var.a(loadAdParams.getDevExtra());
        }
        return w1Var;
    }

    /* compiled from: A */
    class a extends g1.i<fr> {
        final /* synthetic */ LoadAdParams a;

        a(LoadAdParams loadAdParams) {
            this.a = loadAdParams;
        }

        @Override // com.qq.e.comm.plugin.g1.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public fr a(JSONObject jSONObject) {
            return new fr(f.this.a, f.this.b, f.this.c, jSONObject, f.this.d);
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(eo eoVar) {
            f.this.a(eoVar.a());
        }

        @Override // com.qq.e.comm.plugin.g1.i
        public void a(List<fr> list) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            f.this.h = new String[size];
            f.this.i = new String[size];
            LoadAdParams loadAdParams = this.a;
            JSONObject params = loadAdParams == null ? null : loadAdParams.getParams();
            for (int i = 0; i < size; i++) {
                fr frVar = list.get(i);
                e eVar = new e(frVar, f.this, params);
                arrayList.add(eVar);
                if (i == 0) {
                    f.this.j = frVar.z0();
                    f.this.m = frVar.o0();
                    f.this.a((h4) frVar);
                }
                f.this.h[i] = eVar.y();
                f.this.i[i] = eVar.z();
            }
            go.b(f.this.n, size);
            f.this.a(arrayList);
        }
    }

    void a(fr frVar) {
        if (this.t != null) {
            w1 w1VarA = a(1, (LoadAdParams) null);
            this.t.a((g1<fr>) frVar, w1VarA, this.u, (qo.f) null, this.n);
            this.t.b(w1VarA, this.u, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NativeUnifiedADData> list) {
        this.r = System.currentTimeMillis();
        this.o.post(new b(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.o.post(new c(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h4 h4Var) {
        xc.d().a(h4Var, this.s.c(), "nucasi", 0).a(h4Var, this.s.c(), "nureti", 0).a();
    }

    public void a(String str) {
        this.e = str;
    }

    public String[] a() {
        return this.h;
    }
}
