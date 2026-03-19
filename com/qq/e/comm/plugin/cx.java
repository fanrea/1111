package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.s4;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cx extends s4<BaseRewardAd> implements RVADI {
    private static String z;
    private ADListener t;
    private BaseRewardAd u;
    private Map<BaseRewardAd, b> v;
    private boolean w;
    private LoadAdParams x;
    private ServerSideVerificationOptions y;

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    public cx(Context context, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.v = new HashMap();
        this.w = true;
        this.x = null;
        this.y = null;
        this.t = aDListener;
        z = str2;
    }

    /* compiled from: A */
    class a implements s4.b {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ BaseRewardAd c;

        a(int i, long j, BaseRewardAd baseRewardAd) {
            this.a = i;
            this.b = j;
            this.c = baseRewardAd;
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c() {
            cx.this.c(this.c, 70242);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b() {
            yv.a(this.c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a() {
            cx.this.d(this.c, 70232);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void e() {
            cx.this.e(this.c, 70272);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void d(ADEvent aDEvent) {
            yv.a(aDEvent, cx.z, e2.REWARDVIDEOAD, this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void c(ADEvent aDEvent) {
            cx.this.a(e2.REWARDVIDEOAD, this.a, this.b, (long) this.c);
            cx.this.f(this.c);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void b(ADEvent aDEvent) {
            cx.this.a(e2.REWARDVIDEOAD, this.a, this.b, (long) this.c);
            cx.this.a((cx) this.c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void a(ADEvent aDEvent) {
            if (cx.this.t != null) {
                cx.this.t.onADEvent(aDEvent);
            }
        }

        @Override // com.qq.e.comm.plugin.s4.b
        public void d() {
            cx.this.f(this.c, 70262);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BaseRewardAd b(tr trVar) {
        if (trVar != null) {
            try {
                return t7.a(trVar.e(), this.e, trVar.b(), trVar.p(), trVar.j());
            } catch (Exception unused) {
                a(70252, trVar);
            }
        }
        return null;
    }

    protected void o() {
        ADListener aDListener = this.t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(107, 5004));
        }
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        k();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            yq.ch.ri.a(baseRewardAd, (Activity) null);
        }
    }

    @Override // com.qq.e.comm.pi.RVADI
    @Deprecated
    public long getExpireTimestamp() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            return baseRewardAd.getExpireTimestamp();
        }
        return 0L;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            return baseRewardAd.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            return baseRewardAd.hasShown();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            return baseRewardAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            return c((cx) baseRewardAd);
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        return i();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z2) {
        this.w = z2;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.x = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            return baseRewardAd.getVideoDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            return baseRewardAd.getRewardAdType();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.y = serverSideVerificationOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String d(BaseRewardAd baseRewardAd) {
        if (c()) {
            return baseRewardAd.getReqId();
        }
        return null;
    }

    /* compiled from: A */
    private static class b implements ADListener {
        private s4.b a;
        private boolean b;
        private boolean c = false;
        private Queue<ADEvent> d = new LinkedList();

        b(s4.b bVar) {
            this.a = bVar;
        }

        void b() {
            this.c = true;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            s4.b bVar;
            s4.b bVar2;
            int type = aDEvent.getType();
            if (type == 100) {
                this.d.offer(aDEvent);
                s4.b bVar3 = this.a;
                if (bVar3 != null) {
                    bVar3.c(null);
                    return;
                }
                return;
            }
            if (type != 107) {
                switch (type) {
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                        if (this.a != null) {
                            if (aDEvent.getType() == 103) {
                                this.a.a();
                                break;
                            } else if (aDEvent.getType() == 105) {
                                this.a.c();
                                break;
                            } else if (aDEvent.getType() == 104) {
                                this.a.e();
                                break;
                            } else if (aDEvent.getType() == 102) {
                                this.a.d();
                                break;
                            }
                        }
                        break;
                    default:
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
                if (this.c && (bVar2 = this.a) != null) {
                    bVar2.a(aDEvent);
                }
                this.d.offer(aDEvent);
                return;
            }
            s4.b bVar4 = this.a;
            if (bVar4 != null && !this.b) {
                this.b = true;
                bVar4.b(aDEvent);
            }
            if (this.c && (bVar = this.a) != null) {
                bVar.a(aDEvent);
            }
            this.d.offer(aDEvent);
        }

        Queue<ADEvent> a() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(BaseRewardAd baseRewardAd) {
        b bVar;
        qm$h$$ExternalSyntheticBackport0.m(baseRewardAd);
        a(e2.REWARDVIDEOAD);
        this.u = baseRewardAd;
        if (baseRewardAd != null) {
            if (this.t == null || (bVar = this.v.get(baseRewardAd)) == null) {
                return;
            }
            bVar.b();
            for (ADEvent aDEvent : bVar.a()) {
                aDEvent.getType();
                this.t.onADEvent(aDEvent);
            }
            return;
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    public int a(BaseRewardAd baseRewardAd) {
        return baseRewardAd.getECPM();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        BaseRewardAd baseRewardAd = this.u;
        if (baseRewardAd != null) {
            yq.ch.ri.a(baseRewardAd, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseRewardAd baseRewardAd, int i) {
        b bVar = new b(new a(i, System.currentTimeMillis(), baseRewardAd));
        baseRewardAd.setAdListener(bVar);
        baseRewardAd.setVolumeOn(this.w);
        baseRewardAd.setLoadAdParams(this.x);
        baseRewardAd.setServerSideVerificationOptions(this.y);
        this.v.put(baseRewardAd, bVar);
        baseRewardAd.getClass().getSimpleName();
        yq.ch.ri.a(baseRewardAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseRewardAd baseRewardAd, int i, String str) {
        baseRewardAd.setPayload(str);
        b(baseRewardAd, i);
    }
}
