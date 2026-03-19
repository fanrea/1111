package com.bytedance.sdk.component.panglearmor;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private String b;
    private boolean c;
    private Context d;
    private String hc;
    private gb u;

    public Context d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public boolean b() {
        return this.c;
    }

    public gb c() {
        return this.u;
    }

    public static class d {
        private final String b;
        private final Context d;
        private final String hc;
        private boolean c = false;
        private gb u = null;

        public d(Context context, String str, String str2) {
            this.d = context;
            this.b = str2;
            this.hc = str;
        }

        public void d(gb gbVar) {
            this.u = gbVar;
        }

        public d d(boolean z) {
            this.c = z;
            return this;
        }

        public h d() {
            h hVar = new h();
            hVar.d = this.d;
            hVar.hc = this.hc;
            hVar.b = this.b;
            hVar.u = this.u;
            hVar.c = this.c;
            return hVar;
        }
    }
}
