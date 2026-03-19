package com.ss.android.socialbase.downloader.mk;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class w {
    private int an;
    final String b;
    final boolean c;
    final String d;
    private int gb;
    private boolean h;
    final String hc;
    private final AtomicLong tc;
    private String tt;
    private final List<uo> u;

    public w(String str, boolean z) {
        this.u = new ArrayList();
        this.tc = new AtomicLong();
        this.d = str;
        this.c = z;
        this.hc = null;
        this.b = null;
    }

    public w(String str, String str2) {
        this.u = new ArrayList();
        this.tc = new AtomicLong();
        this.d = str;
        this.c = false;
        this.hc = str2;
        this.b = d(str2);
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(".");
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return null;
        }
    }

    public synchronized void d(uo uoVar) {
        this.u.add(uoVar);
    }

    public synchronized void hc(uo uoVar) {
        try {
            this.u.remove(uoVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized int d() {
        return this.u.size();
    }

    public synchronized void hc() {
        this.an++;
        this.h = true;
    }

    public synchronized void b() {
        this.h = false;
    }

    public synchronized boolean c() {
        return this.h;
    }

    public void d(long j) {
        this.tc.addAndGet(j);
    }

    public int hashCode() {
        if (this.gb == 0) {
            this.gb = u().hashCode();
        }
        return this.gb;
    }

    private String u() {
        if (this.tt == null) {
            StringBuilder sbAppend = new StringBuilder().append(this.d).append(Config.replace);
            String str = this.hc;
            if (str == null) {
                str = "";
            }
            this.tt = sbAppend.append(str).append(Config.replace).append(this.c).toString();
        }
        return this.tt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return u().equals(((w) obj).u());
        }
        return false;
    }

    public String toString() {
        return "UrlRecord{url='" + this.d + "', ip='" + this.hc + "', ipFamily='" + this.b + "', isMainUrl=" + this.c + ", failedTimes=" + this.an + ", isCurrentFailed=" + this.h + '}';
    }
}
