package com.ss.android.d.d.u;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    public boolean an;
    public String b;
    public String c;
    public Context d;
    public hc gb;
    public Drawable h;
    public String hc;
    public int tc;
    public View tt;
    public String u;

    public interface hc {
        void b(DialogInterface dialogInterface);

        void d(DialogInterface dialogInterface);

        void hc(DialogInterface dialogInterface);
    }

    private b(d dVar) {
        this.an = true;
        this.d = dVar.b;
        this.hc = dVar.c;
        this.b = dVar.u;
        this.c = dVar.an;
        this.u = dVar.h;
        this.an = dVar.gb;
        this.h = dVar.tt;
        this.gb = dVar.tc;
        this.tt = dVar.d;
        this.tc = dVar.hc;
    }

    public static final class d {
        private String an;
        private Context b;
        private String c;
        public View d;
        private boolean gb;
        private String h;
        public int hc;
        private hc tc;
        private Drawable tt;
        private String u;

        public d(Context context) {
            this.b = context;
        }

        public d d(String str) {
            this.c = str;
            return this;
        }

        public d hc(String str) {
            this.u = str;
            return this;
        }

        public d b(String str) {
            this.an = str;
            return this;
        }

        public d c(String str) {
            this.h = str;
            return this;
        }

        public d d(boolean z) {
            this.gb = z;
            return this;
        }

        public d d(Drawable drawable) {
            this.tt = drawable;
            return this;
        }

        public d d(hc hcVar) {
            this.tc = hcVar;
            return this;
        }

        public d d(int i) {
            this.hc = i;
            return this;
        }

        public b d() {
            return new b(this);
        }
    }
}
