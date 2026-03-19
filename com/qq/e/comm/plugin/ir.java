package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.s4;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ir extends s4<BaseNativeUnifiedAd> implements NUADI {
    private static String A;
    private ADListener t;
    private int u;
    private Map<BaseNativeUnifiedAd, d> v;
    private List<String> w;
    private int x;
    private int y;
    private String z;

    public ir(Context context, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.v = new HashMap();
        this.y = -1;
        this.t = aDListener;
        A = str2;
    }

    /* compiled from: A */
    class a implements s4.b {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ BaseNativeUnifiedAd c;

        @Override // com.qq.e.comm.plugin.s4.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void e() {
        }

        a(int i, long j, BaseNativeUnifiedAd baseNativeUnifiedAd) {
            this.a = i;
            this.b = j;
            this.c = baseNativeUnifiedAd;
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c() {
            ir.this.c(this.c, 70342);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b() {
            yv.a(this.c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a() {
            ir.this.d(this.c, 70332);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void d(ADEvent aDEvent) {
            yv.a(aDEvent, ir.A, e2.NATIVEUNIFIEDAD, this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c(ADEvent aDEvent) {
            ir.this.a(e2.NATIVEUNIFIEDAD, this.a, this.b, (long) this.c);
            ir.this.f(this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b(ADEvent aDEvent) {
            ir.this.a(e2.NATIVEUNIFIEDAD, this.a, this.b, (long) this.c);
            ir.this.a((ir) this.c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a(ADEvent aDEvent) {
            if (ir.this.t == null) {
                return;
            }
            ir.this.t.onADEvent(aDEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BaseNativeUnifiedAd b(tr trVar) {
        if (trVar == null) {
            return null;
        }
        try {
            return s7.a(trVar.e(), this.d, trVar.b(), trVar.p(), trVar.j());
        } catch (Exception e) {
            a(70352, trVar);
            e.printStackTrace();
            return null;
        }
    }

    protected void o() {
        ADListener aDListener = this.t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i) {
        this.u = i;
        k();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        this.w = list;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i) {
        this.x = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i) {
        this.y = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        return i();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
        this.z = str;
    }

    /* compiled from: A */
    class b implements s4.b {
        final /* synthetic */ BaseNativeUnifiedAd a;

        @Override // com.qq.e.comm.plugin.s4.b
        public void a(ADEvent aDEvent) {
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b(ADEvent aDEvent) {
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c(ADEvent aDEvent) {
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void e() {
        }

        b(BaseNativeUnifiedAd baseNativeUnifiedAd) {
            this.a = baseNativeUnifiedAd;
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c() {
            ir.this.c(this.a, 70342);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b() {
            yv.a(this.a, 1143007);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a() {
            ir.this.d(this.a, 70332);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void d(ADEvent aDEvent) {
            yv.a(aDEvent, ir.A, e2.NATIVEUNIFIEDAD, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String d(BaseNativeUnifiedAd baseNativeUnifiedAd) {
        if (c()) {
            return baseNativeUnifiedAd.getReqId();
        }
        return null;
    }

    /* compiled from: A */
    private static class d implements ADListener {
        private s4.b a;
        private Queue<ADEvent> b = new LinkedList();

        public d(s4.b bVar) {
            this.a = bVar;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent.getType() == 101) {
                this.a.b(aDEvent);
            } else if (aDEvent.getType() == 100) {
                this.b.offer(aDEvent);
                this.a.c(aDEvent);
            }
        }

        Queue<ADEvent> a() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(BaseNativeUnifiedAd baseNativeUnifiedAd) {
        d dVar;
        a(e2.NATIVEUNIFIEDAD);
        if (baseNativeUnifiedAd != null && (dVar = this.v.get(baseNativeUnifiedAd)) != null) {
            baseNativeUnifiedAd.setECPMLevel(getECPMLevel());
            for (ADEvent aDEvent : dVar.a()) {
                if (aDEvent.getType() == 100) {
                    aDEvent = new ADEvent(100, a(a(aDEvent), baseNativeUnifiedAd));
                }
                this.t.onADEvent(aDEvent);
            }
            return;
        }
        o();
    }

    /* compiled from: A */
    static class c implements ADListener {
        private ADListener a;
        private s4.b b;

        public c(s4.b bVar) {
            this.b = bVar;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            aDEvent.getType();
            this.a.onADEvent(aDEvent);
            if (aDEvent.getType() == 105) {
                this.b.c();
            } else if (aDEvent.getType() == 103) {
                this.b.a();
            } else if (aDEvent.getType() == 407) {
                this.b.b();
            }
            switch (aDEvent.getType()) {
                case 401:
                case 402:
                case 403:
                case 404:
                case 405:
                case 406:
                    this.b.d(aDEvent);
                    break;
            }
        }

        void a(ADListener aDListener) {
            this.a = aDListener;
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i, LoadAdParams loadAdParams) {
        loadData(i);
    }

    private List<NativeUnifiedADData> a(List<NativeUnifiedADData> list, BaseNativeUnifiedAd baseNativeUnifiedAd) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NativeUnifiedADData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(s7.a(it.next(), new c(new b(baseNativeUnifiedAd))));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    public int a(BaseNativeUnifiedAd baseNativeUnifiedAd) {
        return baseNativeUnifiedAd.getECPM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseNativeUnifiedAd baseNativeUnifiedAd, int i) {
        d dVar = new d(new a(i, System.currentTimeMillis(), baseNativeUnifiedAd));
        this.v.put(baseNativeUnifiedAd, dVar);
        baseNativeUnifiedAd.setAdListener(dVar);
        List<String> list = this.w;
        if (list != null) {
            baseNativeUnifiedAd.setCategories(list);
        }
        int i2 = this.x;
        if (i2 > 0) {
            baseNativeUnifiedAd.setMinVideoDuration(i2);
        }
        int i3 = this.y;
        if (i3 >= 0) {
            baseNativeUnifiedAd.setMaxVideoDuration(i3);
        }
        if (baseNativeUnifiedAd instanceof w30) {
            ((w30) baseNativeUnifiedAd).setVastClassName(this.z);
        }
        yq.ch.ri.a(baseNativeUnifiedAd, this.u);
        baseNativeUnifiedAd.getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseNativeUnifiedAd baseNativeUnifiedAd, int i, String str) {
        baseNativeUnifiedAd.setPayload(str);
        b(baseNativeUnifiedAd, i);
    }

    private List<NativeUnifiedADData> a(ADEvent aDEvent) {
        List<NativeUnifiedADData> list;
        return (aDEvent == null || aDEvent.getType() != 100 || (list = (List) aDEvent.getParam(List.class)) == null || list.size() < 1 || !(list.get(0) instanceof NativeUnifiedADData)) ? new ArrayList() : list;
    }
}
