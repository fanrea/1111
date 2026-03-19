package com.bytedance.sdk.component.an.b;

import android.content.Context;
import com.bytedance.sdk.component.an.mq;
import com.bytedance.sdk.component.an.rf;
import com.bytedance.sdk.component.an.sy;
import com.bytedance.sdk.component.an.uo;
import com.bytedance.sdk.component.an.w;
import com.bytedance.sdk.component.an.yo;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements uo {
    private com.bytedance.sdk.component.an.b an;
    private com.bytedance.sdk.component.an.c b;
    private yo c;
    private mq d;
    private com.bytedance.sdk.component.an.hc gb;
    private w h;
    private ExecutorService hc;
    private sy tt;
    private rf u;

    private u(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b;
        this.c = dVar.c;
        this.u = dVar.u;
        this.an = dVar.an;
        this.gb = dVar.gb;
        this.h = dVar.h;
        this.tt = dVar.tt;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public mq d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public ExecutorService hc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public com.bytedance.sdk.component.an.c c() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public yo u() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public rf an() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public com.bytedance.sdk.component.an.b h() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public w gb() {
        return this.h;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public sy b() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.component.an.uo
    public com.bytedance.sdk.component.an.hc tt() {
        return this.gb;
    }

    public static u d(Context context) {
        return new d().d();
    }

    public static class d {
        private com.bytedance.sdk.component.an.b an;
        private com.bytedance.sdk.component.an.c b;
        private yo c;
        private mq d;
        private com.bytedance.sdk.component.an.hc gb;
        private w h;
        private ExecutorService hc;
        private sy tt;
        private rf u;

        public d d(com.bytedance.sdk.component.an.hc hcVar) {
            this.gb = hcVar;
            return this;
        }

        public d d(ExecutorService executorService) {
            this.hc = executorService;
            return this;
        }

        public d d(com.bytedance.sdk.component.an.c cVar) {
            this.b = cVar;
            return this;
        }

        public u d() {
            return new u(this);
        }
    }
}
