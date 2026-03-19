package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.e;
import com.ss.android.socialbase.downloader.c.k;
import com.ss.android.socialbase.downloader.c.rf;
import com.ss.android.socialbase.downloader.c.sy;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.c.zw;
import com.ss.android.socialbase.downloader.downloader.jh;
import com.ss.android.socialbase.downloader.downloader.tc;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private String an;
    private String b;
    private boolean ba;
    private int bc;
    private List<String> c;
    private Activity d;
    private boolean de;
    private String e;
    private String ey;
    private boolean fs;
    private JSONObject fu;
    private List<com.ss.android.socialbase.downloader.h.u> gb;
    private String h;
    private Context hc;
    private long he;
    private int ia;
    private int j;
    private jh jh;
    private vv k;
    private boolean l;
    private boolean mt;
    private String np;
    private String nr;
    private e nv;
    private boolean nw;
    private rf q;
    private int[] qr;
    private int ra;
    private tc rf;
    private boolean ru;
    private long rw;
    private boolean s;
    private com.ss.android.socialbase.downloader.notification.d sy;
    private zw tr;
    private String u;
    private vv uo;
    private String us;
    private boolean v;
    private boolean vv;
    private boolean w;
    private sy wl;
    private String xp;
    private com.ss.android.socialbase.appdownloader.b.an y;
    private String yi;
    private ba yn;
    private com.ss.android.socialbase.downloader.downloader.tt yo;
    private boolean tt = true;
    private boolean tc = false;
    private boolean mk = true;
    private boolean mq = false;
    private String cb = "application/vnd.android.package-archive";
    private int zw = 5;
    private boolean z = true;
    private com.ss.android.socialbase.downloader.hc.h r = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE;
    private int hv = 150;
    private boolean dc = true;
    private List<k> to = new ArrayList();
    private boolean dz = true;
    private boolean i = true;

    public an(Context context, String str) {
        this.hc = context.getApplicationContext();
        this.b = str;
    }

    public Activity getActivity() {
        return this.d;
    }

    public Context getContext() {
        return this.hc;
    }

    public String d() {
        return this.b;
    }

    public String hc() {
        return this.u;
    }

    public String b() {
        return this.h;
    }

    public List<com.ss.android.socialbase.downloader.h.u> c() {
        return this.gb;
    }

    public boolean u() {
        return this.tt;
    }

    public boolean an() {
        return this.tc;
    }

    public boolean h() {
        return this.mk;
    }

    public boolean gb() {
        return this.mq;
    }

    public vv tt() {
        return this.uo;
    }

    public vv tc() {
        return this.k;
    }

    public String mk() {
        return this.e;
    }

    public String mq() {
        return this.cb;
    }

    public boolean uo() {
        return this.w;
    }

    public com.ss.android.socialbase.downloader.notification.d k() {
        return this.sy;
    }

    public tc e() {
        return this.rf;
    }

    public com.ss.android.socialbase.downloader.downloader.tt cb() {
        return this.yo;
    }

    public boolean w() {
        return this.de;
    }

    public boolean yo() {
        return this.v;
    }

    public int rf() {
        return this.ia;
    }

    public void d(int i) {
        this.ia = i;
    }

    public String jh() {
        return this.np;
    }

    public String sy() {
        return this.yi;
    }

    public long de() {
        return this.he;
    }

    public int v() {
        return this.zw;
    }

    public int np() {
        return this.j;
    }

    public boolean yi() {
        return this.s;
    }

    public String he() {
        return this.us;
    }

    public boolean vv() {
        return this.z;
    }

    public boolean zw() {
        return this.fs;
    }

    public jh j() {
        return this.jh;
    }

    public int s() {
        return this.hv;
    }

    public int us() {
        return this.bc;
    }

    public boolean z() {
        return this.ba;
    }

    public boolean fs() {
        return this.mt;
    }

    public boolean ba() {
        return this.dc;
    }

    public boolean mt() {
        return this.ru;
    }

    public com.ss.android.socialbase.downloader.hc.h r() {
        return this.r;
    }

    public boolean hv() {
        return this.vv;
    }

    public String bc() {
        return this.an;
    }

    public zw dc() {
        return this.tr;
    }

    public e tr() {
        return this.nv;
    }

    public com.ss.android.socialbase.appdownloader.b.an nv() {
        return this.y;
    }

    public sy y() {
        return this.wl;
    }

    public ba wl() {
        return this.yn;
    }

    public List<k> q() {
        return this.to;
    }

    public String ru() {
        return this.nr;
    }

    public boolean yn() {
        return this.l;
    }

    public int l() {
        return this.ra;
    }

    public long fu() {
        return this.rw;
    }

    public boolean xp() {
        return this.i;
    }

    public String to() {
        return this.ey;
    }

    public int[] ra() {
        return this.qr;
    }

    public boolean rw() {
        return this.nw;
    }

    public boolean ia() {
        return this.dz;
    }

    public an d(String str) {
        this.u = str;
        return this;
    }

    public an hc(String str) {
        this.an = str;
        return this;
    }

    public an b(String str) {
        this.h = str;
        return this;
    }

    public an d(List<com.ss.android.socialbase.downloader.h.u> list) {
        this.gb = list;
        return this;
    }

    public an d(boolean z) {
        this.tt = z;
        return this;
    }

    public an c(String str) {
        this.nr = str;
        return this;
    }

    public an hc(boolean z) {
        this.tc = z;
        return this;
    }

    public an b(boolean z) {
        this.mq = z;
        return this;
    }

    public an d(vv vvVar) {
        this.uo = vvVar;
        return this;
    }

    public an u(String str) {
        this.e = str;
        return this;
    }

    public an an(String str) {
        this.cb = str;
        return this;
    }

    public an c(boolean z) {
        this.w = z;
        return this;
    }

    public an u(boolean z) {
        this.de = z;
        return this;
    }

    public an an(boolean z) {
        this.v = z;
        return this;
    }

    public an h(String str) {
        this.np = str;
        return this;
    }

    public an gb(String str) {
        this.yi = str;
        return this;
    }

    public an d(long j) {
        this.he = j;
        return this;
    }

    public an hc(int i) {
        this.zw = i;
        return this;
    }

    public an b(int i) {
        this.j = i;
        return this;
    }

    public an h(boolean z) {
        this.s = z;
        return this;
    }

    public an tt(String str) {
        this.us = str;
        return this;
    }

    public an gb(boolean z) {
        this.ru = z;
        return this;
    }

    public an tt(boolean z) {
        this.z = z;
        return this;
    }

    public an tc(boolean z) {
        this.fs = z;
        return this;
    }

    public an mk(boolean z) {
        this.ba = z;
        return this;
    }

    public an mq(boolean z) {
        this.mt = z;
        return this;
    }

    public an c(int i) {
        this.hv = i;
        return this;
    }

    public an u(int i) {
        this.bc = i;
        return this;
    }

    public an uo(boolean z) {
        this.dc = z;
        return this;
    }

    public an d(com.ss.android.socialbase.downloader.hc.h hVar) {
        this.r = hVar;
        return this;
    }

    public an k(boolean z) {
        this.vv = z;
        return this;
    }

    public an d(sy syVar) {
        this.wl = syVar;
        return this;
    }

    public an tc(String str) {
        this.ey = str;
        return this;
    }

    public an mk(String str) {
        this.xp = str;
        return this;
    }

    public String nw() {
        return this.xp;
    }

    public an an(int i) {
        this.ra = i;
        return this;
    }

    public List<String> dz() {
        return this.c;
    }

    public an hc(List<String> list) {
        this.c = list;
        return this;
    }

    public rf nr() {
        return this.q;
    }

    public an d(rf rfVar) {
        this.q = rfVar;
        return this;
    }

    public JSONObject i() {
        return this.fu;
    }

    public an d(JSONObject jSONObject) {
        this.fu = jSONObject;
        return this;
    }

    public an d(k kVar) {
        synchronized (this.to) {
            if (kVar != null) {
                if (!this.to.contains(kVar)) {
                    this.to.add(kVar);
                    return this;
                }
            }
            return this;
        }
    }

    public an e(boolean z) {
        this.nw = z;
        return this;
    }

    public an cb(boolean z) {
        this.dz = z;
        return this;
    }
}
