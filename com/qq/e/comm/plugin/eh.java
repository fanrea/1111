package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.s4;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class eh extends s4<BaseNativeExpressAd> implements NEADI {
    private static String C;
    private ADSize A;
    private Map<BaseNativeExpressAd, b> B;
    private ADListener t;
    private int u;
    private LoadAdParams v;
    private VideoOption w;
    private int x;
    private int y;
    private ServerSideVerificationOptions z;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseNativeExpressAd baseNativeExpressAd, int i, String str) {
    }

    public eh(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.x = -1;
        this.y = -1;
        this.B = new HashMap();
        this.t = aDListener;
        this.A = aDSize;
        C = str2;
    }

    /* compiled from: A */
    class a implements s4.b {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ BaseNativeExpressAd c;

        @Override // com.qq.e.comm.plugin.s4.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void e() {
        }

        a(int i, long j, BaseNativeExpressAd baseNativeExpressAd) {
            this.a = i;
            this.b = j;
            this.c = baseNativeExpressAd;
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c() {
            eh.this.c(this.c, 70542);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b() {
            yv.a(this.c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a() {
            eh.this.d(this.c, 70532);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void d(ADEvent aDEvent) {
            yv.a(aDEvent, eh.C, e2.NATIVEEXPRESSAD, this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c(ADEvent aDEvent) {
            eh.this.a(e2.NATIVEEXPRESSAD, this.a, this.b, (long) this.c);
            eh.this.f(this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b(ADEvent aDEvent) {
            eh.this.a(e2.NATIVEEXPRESSAD, this.a, this.b, (long) this.c);
            eh.this.a((eh) this.c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a(ADEvent aDEvent) {
            if (eh.this.t != null) {
                eh.this.t.onADEvent(aDEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BaseNativeExpressAd b(tr trVar) {
        if (trVar == null) {
            return null;
        }
        try {
            return r7.a(trVar.e(), this.A, this.e, trVar.b(), trVar.p(), trVar.j());
        } catch (Exception unused) {
            a(70552, trVar);
            return null;
        }
    }

    protected void o() {
        ADListener aDListener = this.t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        this.u = i;
        this.v = null;
        k();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        this.w = videoOption;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i) {
        this.x = i;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i) {
        this.y = i;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public String getAdNetWorkName() {
        return i();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.z = serverSideVerificationOptions;
    }

    /* compiled from: A */
    private static class b implements ADListener {
        private s4.b a;
        private Queue<ADEvent> b = new LinkedList();
        private boolean c;

        b(s4.b bVar) {
            this.a = bVar;
        }

        Queue<ADEvent> a() {
            return this.b;
        }

        void b() {
            this.c = true;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.a != null) {
                int type = aDEvent.getType();
                if (type == 100) {
                    this.b.offer(aDEvent);
                    this.a.c(aDEvent);
                    return;
                }
                if (type == 101) {
                    this.a.b(aDEvent);
                    return;
                }
                if (type == 103) {
                    this.a.a();
                    this.a.a(aDEvent);
                    return;
                }
                if (type != 105) {
                    switch (type) {
                        case 401:
                        case 402:
                        case 403:
                        case 404:
                        case 405:
                        case 406:
                            this.a.d(aDEvent);
                            break;
                        case 407:
                            this.a.b();
                            break;
                        default:
                            this.a.a(aDEvent);
                            break;
                    }
                    return;
                }
                this.a.c();
                this.a.a(aDEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String d(BaseNativeExpressAd baseNativeExpressAd) {
        if (c()) {
            return baseNativeExpressAd.getReqId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(BaseNativeExpressAd baseNativeExpressAd) {
        a(e2.NATIVEEXPRESSAD);
        if (baseNativeExpressAd != null) {
            baseNativeExpressAd.setECPMLevel(getECPMLevel());
            b bVar = this.B.get(baseNativeExpressAd);
            if (bVar == null || this.t == null) {
                return;
            }
            bVar.b();
            Queue<ADEvent> queueA = bVar.a();
            if (queueA == null || queueA.size() <= 0) {
                return;
            }
            Iterator<ADEvent> it = queueA.iterator();
            while (it.hasNext()) {
                this.t.onADEvent(it.next());
            }
            return;
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    public int a(BaseNativeExpressAd baseNativeExpressAd) {
        return baseNativeExpressAd.getECPM();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i, LoadAdParams loadAdParams) {
        this.u = i;
        this.v = loadAdParams;
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseNativeExpressAd baseNativeExpressAd, int i) {
        int i2 = this.y;
        if (i2 >= 0) {
            baseNativeExpressAd.setMaxVideoDuration(i2);
        }
        int i3 = this.x;
        if (i3 >= 0) {
            baseNativeExpressAd.setMinVideoDuration(i3);
        }
        VideoOption videoOption = this.w;
        if (videoOption != null) {
            baseNativeExpressAd.setVideoOption(videoOption);
        }
        ServerSideVerificationOptions serverSideVerificationOptions = this.z;
        if (serverSideVerificationOptions != null) {
            baseNativeExpressAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
        b bVar = new b(new a(i, System.currentTimeMillis(), baseNativeExpressAd));
        baseNativeExpressAd.setAdListener(bVar);
        this.B.put(baseNativeExpressAd, bVar);
        LoadAdParams loadAdParams = this.v;
        if (loadAdParams == null) {
            baseNativeExpressAd.loadAD(this.u);
        } else {
            baseNativeExpressAd.loadAD(this.u, loadAdParams);
        }
    }
}
