package com.bytedance.msdk.core.h;

import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private long b;
    private final Queue<Long> c = new LinkedList();
    private long hc;

    private d() {
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public void d(long j, long j2) {
        synchronized (d.class) {
            if (this.hc != j || this.b != j2) {
                this.hc = j;
                this.b = j2;
                this.c.clear();
            }
        }
    }

    public boolean hc() {
        synchronized (d.class) {
            if (this.hc > 0 && this.b > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.c.size() >= this.hc) {
                    while (this.c.size() > this.hc) {
                        this.c.poll();
                    }
                    if (Math.abs(jCurrentTimeMillis - this.c.peek().longValue()) <= this.b) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }
}
