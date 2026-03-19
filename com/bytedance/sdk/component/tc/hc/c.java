package com.bytedance.sdk.component.tc.hc;

import com.bytedance.sdk.component.tc.hc.b;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c<T extends b> {
    private int d;
    private BlockingQueue<T> hc = new LinkedBlockingQueue();

    public static c d(int i) {
        return new c(i);
    }

    private c(int i) {
        this.d = i;
    }

    public T d() {
        return this.hc.poll();
    }

    public boolean d(T t) {
        if (t == null) {
            return false;
        }
        t.d();
        if (this.hc.size() >= this.d) {
            return false;
        }
        return this.hc.offer(t);
    }
}
