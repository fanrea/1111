package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.plugin.sf;
import com.qq.e.mediation.interfaces.IBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class s4<T> implements k10<T> {
    private final mp a;
    private final yn b;
    protected Context d;
    protected Context e;
    private boolean f;
    private String g;
    private tr h;
    private tr i;
    private q4<T> j;
    private final String m;
    private long n;
    private final Random o;
    private final List<Integer> c = new ArrayList();
    private int p = 900;
    private int q = 990;
    protected Handler r = new Handler(Looper.getMainLooper());
    private Map<Integer, Long> s = new HashMap();

    /* compiled from: A */
    protected interface b {
        void a();

        void a(ADEvent aDEvent);

        void b();

        void b(ADEvent aDEvent);

        void c();

        void c(ADEvent aDEvent);

        void d();

        void d(ADEvent aDEvent);

        void e();
    }

    private String g() {
        String string;
        if (su.j()) {
            string = UUID.randomUUID().toString();
        } else {
            Pair<String, String> pairF = c20.f();
            string = (pairF == null || TextUtils.isEmpty((CharSequence) pairF.first)) ? ma.IMEI.a(this.d) : (String) pairF.first;
        }
        return gp.a(string + System.currentTimeMillis());
    }

    private void h() {
        String[] strArrSplit = r1.d().f().b("retrealtpr", "100").split(",");
        if (strArrSplit.length > 0) {
            for (String str : strArrSplit) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        this.c.add(Integer.valueOf(str));
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    protected abstract int a(T t);

    protected abstract T b(tr trVar);

    protected abstract void b(T t, int i);

    protected abstract void b(T t, int i, String str);

    protected abstract String d(T t);

    protected abstract void e(T t);

    public void sendLossNotification(int i, int i2, String str) {
    }

    public void sendLossNotification(Map<String, Object> map) {
    }

    public void sendWinNotification(int i) {
    }

    public void sendWinNotification(Map<String, Object> map) {
    }

    public void setBidECPM(int i) {
    }

    public s4(Context context, String str) throws NumberFormatException {
        mp mpVarA = mp.a(context);
        this.a = mpVarA;
        yn ynVarA = mpVarA.a(str);
        this.b = ynVarA;
        this.d = context.getApplicationContext();
        this.e = context;
        this.m = str;
        this.o = new Random();
        h();
        f();
        if (ynVarA == null) {
            b10.a(70002, new f5().c(str));
        }
    }

    protected void k() {
        if (this.b == null || this.f) {
            return;
        }
        this.n = System.currentTimeMillis();
        b10.a(1231006, (f5) null);
        m();
        if (this.b.l()) {
            this.j = new mt(this.b, this);
        } else {
            this.j = new py(this.b, this);
        }
        this.f = true;
        this.b.e();
        this.a.a(false);
        if (su.j()) {
            sf.l().a(new a());
        } else {
            this.j.a();
        }
    }

    /* compiled from: A */
    class a implements sf.j {
        a() {
        }

        @Override // com.qq.e.comm.plugin.sf.j
        public void a() {
            s4.this.j.a();
        }
    }

    private void m() {
        this.h = null;
        this.i = null;
        this.g = null;
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(T t) {
        qm$h$$ExternalSyntheticBackport0.m(t);
        lo<T> loVar = new lo<>();
        loVar.a((lo<T>) t);
        loVar.b(3);
        loVar.a(b((s4<T>) t));
        loVar.b(d(t));
        loVar.a(Integer.valueOf((int) (System.currentTimeMillis() - this.s.get(Integer.valueOf(t.hashCode())).longValue())));
        this.j.a(loVar);
    }

    private int b(T t) {
        if (t instanceof op) {
            int mediationPrice = ((op) t).getMediationPrice();
            if (mediationPrice <= 0) {
                pp.a(mediationPrice, this.m);
            }
            return mediationPrice;
        }
        return a((s4<T>) t);
    }

    private void a(List<tr> list) {
        if (!d() || list == null || list.size() == 0) {
            return;
        }
        for (tr trVar : list) {
            if (trVar.u()) {
                IBaseAd iBaseAdC = trVar.c();
                if (iBaseAdC != null) {
                    if (trVar.v()) {
                        iBaseAdC.sendWinNotification(trVar.f());
                        iBaseAdC.setBidECPM(-1);
                    } else {
                        iBaseAdC.sendLossNotification(-1, -1, "");
                    }
                }
                trVar.a((IBaseAd) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(T t, int i) {
        if (t == null) {
            return;
        }
        this.j.b(true);
        yv.a(t.hashCode(), System.currentTimeMillis() - this.n);
        HashMap map = new HashMap();
        map.put("adapter", t.getClass().getSimpleName());
        a(i, map);
    }

    private boolean d() {
        return su.h() >= 450;
    }

    protected String i() {
        return this.g;
    }

    public String getECPMLevel() {
        tr trVar = this.h;
        if (trVar == null) {
            return null;
        }
        if (trVar.u()) {
            return e();
        }
        return String.valueOf(this.h.q());
    }

    private String e() {
        if (this.c.contains(Integer.valueOf(this.h.a()))) {
            tr trVar = this.i;
            if (trVar != null) {
                return String.valueOf(trVar.q());
            }
            return String.valueOf(Math.round(this.h.r()));
        }
        return String.valueOf(this.h.f());
    }

    protected final Map<String, Object> c(T t) {
        if (a()) {
            return ((IBaseAd) t).getExtraInfo();
        }
        String strD = d(t);
        HashMap map = new HashMap();
        if (strD != null) {
            map.put("request_id", strD);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(T t, int i) {
        if (t == null) {
            return;
        }
        yv.c(t.hashCode());
        HashMap map = new HashMap();
        map.put("adapter", t.getClass().getSimpleName());
        a(i, map);
    }

    private void f() throws NumberFormatException {
        String strB = r1.d().f().b("meprblrange", "");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        try {
            String[] strArrSplit = strB.split(",");
            if (strArrSplit.length == 2) {
                this.p = Integer.parseInt(strArrSplit[0]);
                int i = Integer.parseInt(strArrSplit[1]);
                this.q = i;
                int i2 = this.p;
                if (i2 >= i || i2 > 1000 || i > 1000) {
                    this.p = 900;
                    this.q = 990;
                }
            }
        } catch (Exception unused) {
        }
    }

    private int a(int i) {
        return ((this.o.nextInt(this.q - this.p) + this.p) * i) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(T t, int i) {
        if (t == null) {
            return;
        }
        yv.b(t.hashCode());
        HashMap map = new HashMap();
        map.put("adapter", t.getClass().getSimpleName());
        a(i, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(T t, int i) {
        if (t == null) {
            return;
        }
        yv.a(t.hashCode());
        HashMap map = new HashMap();
        map.put("adapter", t.getClass().getSimpleName());
        a(i, map);
    }

    protected boolean c() {
        return su.h() >= 441;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t, ADEvent aDEvent) {
        String str;
        Integer num;
        qm$h$$ExternalSyntheticBackport0.m(t);
        if (qp.e(t.toString())) {
            num = (Integer) aDEvent.getParam(0, Integer.class);
            str = "no_reason";
        } else {
            Integer num2 = (Integer) aDEvent.getParam(1, Integer.class);
            str = (String) aDEvent.getParam(2, String.class);
            num = num2;
        }
        lo<T> loVar = new lo<>();
        loVar.a((lo<T>) t);
        loVar.b(1);
        loVar.a(-1);
        loVar.b((String) null);
        loVar.a(Integer.valueOf((int) (System.currentTimeMillis() - this.s.get(Integer.valueOf(t.hashCode())).longValue())));
        loVar.b(num);
        loVar.a(str);
        this.j.a(loVar);
    }

    @Override // com.qq.e.comm.plugin.k10
    public T a(tr trVar) {
        T tB = b(trVar);
        if (d()) {
            try {
                trVar.a((IBaseAd) tB);
            } catch (Exception e) {
                e.toString();
            }
        }
        return tB;
    }

    @Override // com.qq.e.comm.plugin.k10
    public void a(T t, tr trVar, List<tr> list, tr trVar2) {
        qm$h$$ExternalSyntheticBackport0.m(t);
        qm$h$$ExternalSyntheticBackport0.m(trVar);
        qm$h$$ExternalSyntheticBackport0.m(trVar2);
        String strG = g();
        if (trVar != null) {
            this.g = trVar.o();
            trVar.a(true);
            trVar.d(a(trVar.f()));
            this.h = trVar;
            yv.a(t, trVar, strG, this.b.c());
        }
        if (trVar2 != null) {
            if (trVar != null) {
                yv.a(trVar.p(), trVar2.n(), trVar2.p());
            }
            this.i = trVar2;
        }
        a(strG, list);
        e(t);
        a(list);
        this.f = false;
        this.s.clear();
    }

    @Override // com.qq.e.comm.plugin.k10
    public void a(T t, int i) {
        b(t, i);
    }

    @Override // com.qq.e.comm.plugin.k10
    public void a(T t, int i, String str) {
        b(t, i, str);
    }

    protected void a(int i, tr trVar) {
        HashMap map = new HashMap();
        if (trVar != null) {
            map.put("config_name", trVar.o());
            map.put("config_class_name", trVar.e());
            map.put("identity", trVar.p());
        }
        a(i, map);
    }

    private void a(int i, Map<String, Object> map) throws JSONException {
        ja jaVar = map == null ? new ja() : new ja(new JSONObject(map));
        yn ynVar = this.b;
        jaVar.a("layer_timeout", Integer.valueOf(ynVar == null ? 0 : ynVar.i()));
        jaVar.toString();
        f5 f5Var = new f5();
        yn ynVar2 = this.b;
        b10.a(i, f5Var.c(ynVar2 == null ? "" : ynVar2.e()), null, null, jaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e2 e2Var, int i, long j, T t) {
        this.s.put(Integer.valueOf(t.hashCode()), Long.valueOf(j));
        pp.a(i, j, new f5().a(e2Var).c(this.m));
    }

    protected void a(e2 e2Var) {
        pp.a(this.n, new f5().a(e2Var).c(this.m));
    }

    private void a(String str, List<tr> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        yv.a(arrayList, str, this.b.c());
    }

    private boolean a() {
        return su.h() >= 464;
    }
}
