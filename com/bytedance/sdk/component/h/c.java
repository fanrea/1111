package com.bytedance.sdk.component.h;

import android.content.Context;
import com.bytedance.sdk.openadsdk.ats.AutoService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {

    public static class d {
        private volatile int an;
        private volatile int b;
        private volatile boolean c;
        private volatile Context d;
        private volatile String hc;
        private volatile boolean u;

        public d d(Context context) {
            if (context == null) {
                return this;
            }
            this.d = context.getApplicationContext();
            b.d(this.d);
            return this;
        }

        public d d(String str) {
            this.hc = str;
            return this;
        }

        public d d(int i) {
            this.b = i;
            return this;
        }

        public d d(boolean z) {
            this.c = z;
            return this;
        }

        public d hc(int i) {
            this.an = i;
            return this;
        }

        public com.bytedance.sdk.component.c.d.hc d() {
            if (this.b == 2) {
                return b();
            }
            return hc();
        }

        private com.bytedance.sdk.component.c.d.hc hc() {
            if (this.c) {
                return com.bytedance.sdk.component.h.b.d.d.hc(this.hc);
            }
            return ((com.bytedance.sdk.component.c.c) AutoService.d(com.bytedance.sdk.component.c.c.class)).d(this.hc);
        }

        private com.bytedance.sdk.component.c.d.hc b() {
            com.bytedance.sdk.component.c.d.hc hcVarD = com.bytedance.sdk.component.h.hc.d.d.d(this.d, this.hc, this.c, this.an);
            this.u = true;
            if (hcVarD != null) {
                return hcVarD;
            }
            this.u = false;
            return hc();
        }
    }
}
