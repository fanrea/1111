package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yi {
    private static final AtomicLong an = new AtomicLong(1000);
    private static d e;
    private i b;
    private i c;
    private final fs d;
    private int gb;
    private long h;
    private final ba hc;
    private dz k;
    private long mk;
    private int mq;
    private volatile boolean tc;
    private long tt = -1;
    private String u;
    private String uo;

    yi(ba baVar, fs fsVar) {
        this.hc = baVar;
        this.d = fsVar;
    }

    public String d() {
        return this.u;
    }

    synchronized Bundle d(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.d.u() && b()) {
            long j3 = this.h;
            if (j3 > 0 && j - j3 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.mq);
                int i = this.gb + 1;
                this.gb = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.h) / 1000);
                bundle.putString("session_start_time", to.hc(this.tt));
                this.h = j;
            }
        }
        return bundle;
    }

    public boolean hc() {
        return this.tc;
    }

    boolean b() {
        return hc() && this.mk == 0;
    }

    private synchronized void d(to toVar, ArrayList<to> arrayList, boolean z) {
        long j = toVar instanceof d ? -1L : toVar.hc;
        this.u = UUID.randomUUID().toString();
        an.set(1000L);
        this.tt = j;
        this.tc = z;
        this.mk = 0L;
        this.h = 0L;
        if (um.hc) {
            um.d("startSession, " + this.u + ", hadUi:" + z + " data:" + toVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String string = new StringBuilder().append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            if (TextUtils.isEmpty(this.uo)) {
                this.uo = this.d.hc();
                this.mq = this.d.b();
            }
            if (!string.equals(this.uo)) {
                this.uo = string;
                this.mq = 1;
            } else {
                this.mq++;
            }
            this.d.d(string, this.mq);
            this.gb = 0;
            this.h = toVar.hc;
        }
        if (j != -1) {
            dz dzVar = new dz(false);
            dzVar.c = this.u;
            dzVar.b = c();
            dzVar.hc = this.tt;
            dzVar.k = this.tc ? false : true;
            dzVar.uo = this.hc.b();
            dzVar.mq = this.hc.hc();
            dzVar.an = com.bytedance.embedapplog.d.tc();
            dzVar.h = com.bytedance.embedapplog.d.tt();
            if (this.d.sy()) {
                dzVar.gb = com.bytedance.embedapplog.d.u();
            }
            arrayList.add(dzVar);
            this.k = dzVar;
            if (um.hc) {
                um.d("gen launch, " + dzVar.c + ", hadUi:" + z, null);
            }
        }
    }

    public static boolean d(to toVar) {
        if (toVar instanceof i) {
            return ((i) toVar).tc();
        }
        return false;
    }

    boolean d(to toVar, ArrayList<to> arrayList) {
        boolean z = toVar instanceof i;
        boolean zD = d(toVar);
        boolean z2 = true;
        if (this.tt == -1) {
            d(toVar, arrayList, d(toVar));
        } else if (!this.tc && zD) {
            d(toVar, arrayList, true);
        } else if (this.mk == 0 || toVar.hc <= this.mk + this.d.v()) {
            if (this.tt > toVar.hc + 7200000) {
                d(toVar, arrayList, zD);
            } else {
                z2 = false;
            }
        } else if (!fv.hc() && fv.d()) {
            d(toVar, arrayList, zD);
        }
        if (z) {
            i iVar = (i) toVar;
            if (iVar.tc()) {
                this.mk = 0L;
                arrayList.add(toVar);
                if (TextUtils.isEmpty(iVar.uo)) {
                    if (this.c != null && (iVar.hc - this.c.hc) - this.c.mq < 500) {
                        iVar.uo = this.c.k;
                    } else if (this.b != null && (iVar.hc - this.b.hc) - this.b.mq < 500) {
                        iVar.uo = this.b.k;
                    }
                }
            } else {
                Bundle bundleD = d(toVar.hc, 0L);
                if (bundleD != null) {
                    com.bytedance.embedapplog.d.d("play_session", bundleD);
                }
                this.mk = iVar.hc;
                arrayList.add(toVar);
                if (iVar.mk()) {
                    this.b = iVar;
                } else {
                    this.c = iVar;
                    this.b = null;
                }
            }
        } else if (!(toVar instanceof d)) {
            arrayList.add(toVar);
        }
        hc(toVar);
        return z2;
    }

    public void hc(to toVar) {
        if (toVar != null) {
            if (this.d.sy()) {
                toVar.gb = com.bytedance.embedapplog.d.u();
            }
            toVar.an = com.bytedance.embedapplog.d.tc();
            toVar.h = com.bytedance.embedapplog.d.tt();
            toVar.c = this.u;
            toVar.b = c();
        }
    }

    public static long c() {
        return an.incrementAndGet();
    }

    static class d extends ey {
        private d() {
        }
    }

    static d u() {
        if (e == null) {
            e = new d();
        }
        e.hc = System.currentTimeMillis();
        return e;
    }
}
