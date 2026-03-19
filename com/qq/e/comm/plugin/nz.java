package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.s4;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nz extends s4<BaseSplashAd> implements NSPVI {
    private static String D;
    private Map<BaseSplashAd, c> A;
    private int B;
    private byte[] C;
    private ViewGroup t;
    private View u;
    private boolean v;
    private int w;
    private LoadAdParams x;
    private ADListener y;
    private BaseSplashAd z;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseSplashAd baseSplashAd, int i, String str) {
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    public nz(Context context, String str, String str2) {
        super(context, str2);
        this.w = -1;
        this.A = new HashMap();
        D = str2;
    }

    /* compiled from: A */
    class a implements s4.b {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ BaseSplashAd c;

        @Override // com.qq.e.comm.plugin.s4.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void e() {
        }

        a(int i, long j, BaseSplashAd baseSplashAd) {
            this.a = i;
            this.b = j;
            this.c = baseSplashAd;
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c() {
            nz.this.c(this.c, 70142);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b() {
            yv.a(this.c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a() {
            nz.this.d(this.c, 70132);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void d(ADEvent aDEvent) {
            yv.a(aDEvent, nz.D, e2.SPLASH, this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c(ADEvent aDEvent) {
            nz.this.a(e2.SPLASH, this.a, this.b, (long) this.c);
            nz.this.f(this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b(ADEvent aDEvent) {
            nz.this.a(e2.SPLASH, this.a, this.b, (long) this.c);
            nz.this.a((nz) this.c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a(ADEvent aDEvent) {
            if (nz.this.y != null) {
                nz.this.y.onADEvent(aDEvent);
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            nz.this.y.onADEvent(new ADEvent(101, 5004));
        }
    }

    protected void o() {
        if (this.y != null) {
            this.r.post(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BaseSplashAd b(tr trVar) {
        if (trVar != null) {
            try {
                return u7.a(trVar.e(), this.e, trVar.b(), trVar.p(), trVar.j());
            } catch (Exception unused) {
                a(70152, trVar);
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        this.y = aDListener;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        GDTLogger.w("流量分配不支持fetchAndShowIn接口.");
        o();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        fetchAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i) {
        this.w = i;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    @Deprecated
    public void setSkipView(View view) {
        this.u = view;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        GDTLogger.w("流量分配不支持preload接口");
        o();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.x = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        return i();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        k();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        this.t = viewGroup;
        BaseSplashAd baseSplashAd = this.z;
        if (baseSplashAd != null) {
            yq.ch.ri.a(baseSplashAd, viewGroup);
        } else {
            o();
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAdOnly() {
        fetchAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showFullScreenAd(ViewGroup viewGroup) {
        showAd(viewGroup);
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseSplashAd baseSplashAd = this.z;
        if (baseSplashAd != null) {
            return baseSplashAd.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseSplashAd baseSplashAd = this.z;
        if (baseSplashAd != null) {
            return baseSplashAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseSplashAd baseSplashAd = this.z;
        if (baseSplashAd != null) {
            return c((nz) baseSplashAd);
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSupportZoomOut(boolean z) {
        this.v = z;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void zoomOutAnimationFinish() {
        BaseSplashAd baseSplashAd = this.z;
        if (baseSplashAd != null) {
            baseSplashAd.zoomOutAnimationFinish();
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public Bitmap getZoomOutBitmap() {
        BaseSplashAd baseSplashAd = this.z;
        if (baseSplashAd == null) {
            return null;
        }
        baseSplashAd.getZoomOutBitmap();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String d(BaseSplashAd baseSplashAd) {
        if (c()) {
            return baseSplashAd.getReqId();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(int i) {
        this.B = i;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        BaseSplashAd baseSplashAd = this.z;
        if (baseSplashAd != null) {
            baseSplashAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(BaseSplashAd baseSplashAd) {
        c cVar;
        a(e2.SPLASH);
        this.z = baseSplashAd;
        if (baseSplashAd != null) {
            if (this.y == null || (cVar = this.A.get(baseSplashAd)) == null) {
                return;
            }
            cVar.b();
            Iterator<ADEvent> it = cVar.a().iterator();
            while (it.hasNext()) {
                this.y.onADEvent(it.next());
            }
            return;
        }
        o();
    }

    /* compiled from: A */
    private static class c implements ADListener {
        private s4.b a;
        private boolean b;
        private boolean c = false;
        private Queue<ADEvent> d = new LinkedList();

        c(s4.b bVar) {
            this.a = bVar;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            s4.b bVar;
            aDEvent.getType();
            int type = aDEvent.getType();
            if (type == 100) {
                this.d.offer(aDEvent);
                s4.b bVar2 = this.a;
                if (bVar2 != null) {
                    bVar2.c(aDEvent);
                    return;
                }
                return;
            }
            if (type == 101) {
                this.d.offer(aDEvent);
                s4.b bVar3 = this.a;
                if (bVar3 != null && !this.b) {
                    this.b = true;
                    bVar3.b(aDEvent);
                }
                s4.b bVar4 = this.a;
                if (bVar4 == null || !this.c) {
                    return;
                }
                bVar4.a(aDEvent);
                return;
            }
            if (type != 103) {
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
                    }
                    return;
                }
                s4.b bVar5 = this.a;
                if (bVar5 != null) {
                    bVar5.c();
                }
                if (this.c && (bVar = this.a) != null) {
                    bVar.a(aDEvent);
                }
                this.d.offer(aDEvent);
                return;
            }
            this.d.offer(aDEvent);
            s4.b bVar6 = this.a;
            if (bVar6 == null || !this.c) {
                return;
            }
            bVar6.a(aDEvent);
            this.a.a();
        }

        void b() {
            this.c = true;
        }

        Queue<ADEvent> a() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    public int a(BaseSplashAd baseSplashAd) {
        return baseSplashAd.getECPM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseSplashAd baseSplashAd, int i) {
        c cVar = new c(new a(i, System.currentTimeMillis(), baseSplashAd));
        baseSplashAd.setADListener(cVar);
        this.A.put(baseSplashAd, cVar);
        int i2 = this.w;
        if (i2 > 0) {
            baseSplashAd.setFetchDelay(i2);
        }
        View view = this.u;
        if (view != null) {
            baseSplashAd.setSkipView(view);
        }
        LoadAdParams loadAdParams = this.x;
        if (loadAdParams != null) {
            baseSplashAd.setLoadAdParams(loadAdParams);
        }
        int i3 = this.B;
        if (i3 != 0) {
            baseSplashAd.setDeveloperLogo(i3);
        }
        byte[] bArr = this.C;
        if (bArr != null) {
            baseSplashAd.setDeveloperLogo(bArr);
        }
        baseSplashAd.setSupportZoomOut(this.v);
        yq.ch.ri.a(baseSplashAd);
        baseSplashAd.getClass().getSimpleName();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(byte[] bArr) {
        this.C = bArr;
    }
}
