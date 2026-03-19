package com.baidu.mobads.container.components.h;

import com.baidu.mobads.container.util.bq;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends com.baidu.mobads.container.d.a {
    private static final int a = 15;
    private static e c;
    private AtomicBoolean b = new AtomicBoolean(false);

    public static e c() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e();
                }
            }
        }
        return c;
    }

    private e() {
    }

    public synchronized void d() {
        try {
            if (!this.b.get()) {
                com.baidu.mobads.container.d.b.a().a(this, 0L, 15L, TimeUnit.SECONDS);
                this.b.set(true);
            }
        } catch (Exception e) {
            bq.a().a(e);
        }
    }

    public synchronized void e() {
        try {
        } catch (Exception e) {
            bq.a().a(e);
        }
        if (!h()) {
            a_();
            this.b.set(false);
        }
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        if (this.b.get()) {
            bq.a().a("StateMachine", "running!!!");
            d.a();
            d.b();
            d.c();
            if (d.a.size() == 0) {
                e();
                return null;
            }
            return null;
        }
        e();
        return null;
    }
}
