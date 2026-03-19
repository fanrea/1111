package com.ss.android.socialbase.downloader.mk;

import com.baidu.mobstat.forbes.Config;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class tt {
    private long an;
    private final long b;
    private final AtomicLong c;
    volatile uo d;
    private JSONObject gb;
    private int h;
    int hc;
    private volatile long u;

    public tt(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.c = atomicLong;
        this.hc = 0;
        this.b = j;
        atomicLong.set(j);
        this.u = j;
        if (j2 >= j) {
            this.an = j2;
        } else {
            this.an = -1L;
        }
    }

    public tt(tt ttVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.c = atomicLong;
        this.hc = 0;
        this.b = ttVar.b;
        this.an = ttVar.an;
        atomicLong.set(ttVar.c.get());
        this.u = atomicLong.get();
        this.h = ttVar.h;
    }

    public tt(JSONObject jSONObject) {
        this.c = new AtomicLong();
        this.hc = 0;
        this.b = jSONObject.optLong(Config.STAT_SDK_TYPE);
        b(jSONObject.optLong("en"));
        d(jSONObject.optLong("cu"));
        c(c());
    }

    public long d() {
        return this.c.get() - this.b;
    }

    public long hc() {
        long j = this.an;
        if (j >= this.b) {
            return (j - u()) + 1;
        }
        return -1L;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        long j = this.c.get();
        long j2 = this.an;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long u() {
        uo uoVar = this.d;
        if (uoVar != null) {
            long jC = uoVar.c();
            if (jC > this.u) {
                return jC;
            }
        }
        return this.u;
    }

    public void d(long j) {
        long j2 = this.b;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.an;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.c.set(j);
    }

    void hc(long j) {
        this.c.addAndGet(j);
    }

    public long an() {
        return this.an;
    }

    void b(long j) {
        if (j >= this.b) {
            this.an = j;
            return;
        }
        com.bytedance.sdk.component.utils.mq.hc("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.an = j;
        }
    }

    public void c(long j) {
        if (j >= this.c.get()) {
            this.u = j;
        }
    }

    public int h() {
        return this.h;
    }

    void d(int i) {
        this.h = i;
    }

    void gb() {
        this.hc++;
    }

    void tt() {
        this.hc--;
    }

    int tc() {
        return this.hc;
    }

    void hc(int i) {
        this.hc = i;
    }

    public String toString() {
        return "Segment{startOffset=" + this.b + ",\t currentOffset=" + this.c + ",\t currentOffsetRead=" + u() + ",\t endOffset=" + this.an + '}';
    }

    public static String d(List<tt> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<tt>() { // from class: com.ss.android.socialbase.downloader.mk.tt.1
            @Override // java.util.Comparator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public int compare(tt ttVar, tt ttVar2) {
                return (int) (ttVar.b() - ttVar2.b());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<tt> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\r\n");
        }
        return sb.toString();
    }

    public JSONObject mk() throws JSONException {
        JSONObject jSONObject = this.gb;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.gb = jSONObject;
        }
        jSONObject.put(Config.STAT_SDK_TYPE, b());
        jSONObject.put("cu", c());
        jSONObject.put("en", an());
        return jSONObject;
    }
}
