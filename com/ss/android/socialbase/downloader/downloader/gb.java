package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.us;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb {
    private com.ss.android.socialbase.downloader.tt.tc an;
    private uo b;
    private tc c;
    private ExecutorService cb;
    private final Context d;
    private ExecutorService de;
    private ExecutorService e;
    private com.ss.android.socialbase.downloader.tt.an gb;
    private com.ss.android.socialbase.downloader.tt.gb h;
    private mq hc;
    private boolean he;
    private ExecutorService jh;
    private us k;
    private yo mk;
    private com.ss.android.socialbase.downloader.gb.hc mq;
    private int np;
    private ExecutorService rf;
    private ExecutorService sy;
    private tt tc;
    private k tt;
    private ba u;
    private de v;
    private ExecutorService w;
    private int yi;
    private ExecutorService yo;
    private List<com.ss.android.socialbase.downloader.c.k> uo = new ArrayList();
    private boolean vv = true;
    private int zw = 1056964607;

    public gb(Context context) {
        this.d = context;
    }

    public gb d(com.ss.android.socialbase.downloader.tt.tc tcVar) {
        this.an = tcVar;
        return this;
    }

    public gb d(com.ss.android.socialbase.downloader.c.k kVar) {
        synchronized (this.uo) {
            if (kVar != null) {
                if (!this.uo.contains(kVar)) {
                    this.uo.add(kVar);
                    return this;
                }
            }
            return this;
        }
    }

    public gb d(ba baVar) {
        this.u = baVar;
        return this;
    }

    public gb d(us usVar) {
        this.k = usVar;
        return this;
    }

    public Context getContext() {
        return this.d;
    }

    public mq d() {
        return this.hc;
    }

    public uo hc() {
        return this.b;
    }

    public com.ss.android.socialbase.downloader.tt.tc b() {
        return this.an;
    }

    public com.ss.android.socialbase.downloader.tt.gb c() {
        return this.h;
    }

    public k u() {
        return this.tt;
    }

    public ExecutorService an() {
        return this.e;
    }

    public ExecutorService h() {
        return this.cb;
    }

    public ExecutorService gb() {
        return this.w;
    }

    public ExecutorService tt() {
        return this.yo;
    }

    public ExecutorService tc() {
        return this.rf;
    }

    public ExecutorService mk() {
        return this.jh;
    }

    public ExecutorService mq() {
        return this.sy;
    }

    public ExecutorService uo() {
        return this.de;
    }

    public List<com.ss.android.socialbase.downloader.c.k> k() {
        return this.uo;
    }

    public int e() {
        return this.np;
    }

    public tc cb() {
        return this.c;
    }

    public tt w() {
        return this.tc;
    }

    public int yo() {
        return this.yi;
    }

    public boolean rf() {
        return this.he;
    }

    public yo jh() {
        return this.mk;
    }

    public int sy() {
        return this.zw;
    }

    public de de() {
        return this.v;
    }

    public boolean v() {
        return this.vv;
    }

    public ba np() {
        return this.u;
    }

    public us yi() {
        return this.k;
    }

    public com.ss.android.socialbase.downloader.gb.hc he() {
        return this.mq;
    }

    public com.ss.android.socialbase.downloader.tt.an vv() {
        return this.gb;
    }

    public h zw() {
        return new h(this);
    }
}
