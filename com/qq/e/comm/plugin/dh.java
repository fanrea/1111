package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.dd;
import com.qq.e.comm.plugin.f0;
import com.qq.e.comm.plugin.g1;
import com.qq.e.comm.plugin.xc;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dh extends f0 implements dd.i {
    private final int x;
    private int y;
    private int z;

    static {
        q8.a().b(e2.NATIVEEXPRESSAD);
    }

    public void d(int i) {
        wt wtVar = new wt(2302001);
        wtVar.b(i);
        b10.a(wtVar);
    }

    public dh(Context context, ADSize aDSize, String str, String str2, mb mbVar, String str3, ADListener aDListener) {
        super(context, aDSize, str, str2, mbVar, aDListener, str3, e2.NATIVEEXPRESSAD);
        this.z = -1;
        this.x = hd.b(str2);
    }

    public void c(int i) {
        this.z = i;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        loadAd(i, null);
    }

    /* compiled from: A */
    class a implements xc.b<Integer> {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // com.qq.e.comm.plugin.xc.b
        public void a(boolean z, Integer num, boolean z2, Integer num2) {
            if (z2) {
                b10.a(this.a > num2.intValue() ? 1210041 : 1210042, null, Integer.valueOf(this.a), num2, null);
            }
        }
    }

    public dh(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        this(context, aDSize, str, str2, mb.DEFAULT, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.f0
    protected g1<ed> f() {
        return super.a(xc.a("necasi", this.a.c(), this.d, 0), xc.a("nereti", this.a.c(), this.d, 0));
    }

    @Override // com.qq.e.comm.plugin.f0, com.qq.e.comm.pi.NEADI
    public void loadAd(int i, LoadAdParams loadAdParams) {
        int iA;
        int iA2;
        this.v = loadAdParams;
        this.w = b5.a(loadAdParams);
        if (h()) {
            ADSize aDSize = this.f;
            if (aDSize != null && aDSize.getWidth() > 0 && (iA = yu.a(r1.d().a(), this.f.getWidth())) > mq.j && this.f.getHeight() > 0 && (iA2 = yu.a(r1.d().a(), this.f.getHeight())) > mq.m + mq.p) {
                this.y = mq.a(iA) * mq.b(iA2);
                int iA3 = hd.a(this.d);
                if (this.y > iA3) {
                    this.y = iA3;
                }
                i = this.y + this.x;
            } else {
                this.h.onADEvent(new ADEvent(101, 4005));
                return;
            }
        } else {
            int iA4 = this.z;
            if (iA4 <= 0) {
                d(i);
                iA4 = xc.a("exrec", this.d, 3, new a(i));
                if (i < 1) {
                    GDTLogger.w(String.format("原生广告请求数量范围为[1, %s]，已将本次广告请求的广告数量设为1", Integer.valueOf(iA4)), null);
                    i = 1;
                }
                if (i > iA4) {
                    GDTLogger.w(String.format("原生广告请求数量范围为[1, %s]，已将本次广告请求的广告数量设为%s", Integer.valueOf(iA4), Integer.valueOf(iA4)), null);
                    i = iA4;
                }
            } else {
                i = iA4;
            }
        }
        this.i = i;
        b(i, loadAdParams);
    }

    /* compiled from: A */
    class b extends g1.i<ed> {
        b() {
        }

        @Override // com.qq.e.comm.plugin.g1.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ed a(JSONObject jSONObject) {
            return dh.this.a(jSONObject);
        }

        @Override // com.qq.e.comm.plugin.g1.i
        public void a(List<ed> list) {
            int size = list.size();
            if (dh.this.h()) {
                size = Math.min(size, dh.this.y);
            }
            dh dhVar = dh.this;
            dhVar.p = new String[size];
            dhVar.q = new String[size];
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            ed edVar = null;
            for (int i = 0; i < size; i++) {
                ed edVar2 = list.get(i);
                dh.this.q[i] = edVar2.e1();
                dh.this.p[i] = edVar2.W();
                if (i == 0) {
                    edVar = edVar2;
                }
                dd ddVarA = dh.this.u.a(edVar2);
                ddVarA.a(dh.this);
                if (dh.this.h()) {
                    arrayList2.add(ddVarA);
                } else {
                    arrayList.add(new jq(dh.this.e(), ddVarA, dh.this.b, new ff(edVar2)));
                }
            }
            if (dh.this.h()) {
                ADListener aDListenerE = dh.this.e();
                dh dhVar2 = dh.this;
                arrayList.add(new mq(aDListenerE, arrayList2, dhVar2.b, dhVar2.y));
            }
            dh.this.a((h4) edVar);
            go.b(dh.this.r, size);
            dh.this.a(arrayList, edVar);
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(eo eoVar) {
            dh.this.b(eoVar.a());
        }
    }

    private void b(int i, LoadAdParams loadAdParams) {
        g();
        this.s.a(a(i, loadAdParams), this.t, this.r, new b());
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ List a;

        c(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            dh.this.h.onADEvent(new ADEvent(100, this.a));
        }
    }

    protected void b(h4 h4Var) {
        xc.d().a(h4Var, this.a.c(), "necasi", 0).a(h4Var, this.a.c(), "nereti", 0).a(h4Var, "exrec", 3).a();
    }

    /* compiled from: A */
    private static class d extends f0.b {
        @Override // com.qq.e.comm.plugin.f0.b
        public dd a(ed edVar) {
            return new oe(this.a, edVar);
        }

        private d(Context context, ADSize aDSize) {
            super(context, aDSize);
        }

        /* synthetic */ d(Context context, ADSize aDSize, a aVar) {
            this(context, aDSize);
        }
    }

    @Override // com.qq.e.comm.plugin.f0, com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.d, (h4) null, this.r, this, this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.x > -1;
    }

    @Override // com.qq.e.comm.plugin.f0
    protected f0.b a() {
        return new d(this.b, h() ? new ADSize(-1, -2) : this.f, null);
    }

    @Override // com.qq.e.comm.plugin.dd.i
    public void a(ed edVar) {
        b(edVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NativeExpressADView> list, h4 h4Var) {
        xo.a((Runnable) new c(list));
        go.a(this.r, list.size(), h4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h4 h4Var) {
        b(h4Var);
    }
}
