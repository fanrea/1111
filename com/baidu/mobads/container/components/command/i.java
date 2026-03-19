package com.baidu.mobads.container.components.command;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i extends com.baidu.mobads.container.d.a {
    private final int a;
    private final int b;
    private final int c;
    private volatile int d;
    private a e;
    private AtomicBoolean f;

    public interface a {
        void a(int i);
    }

    public i() {
        super("bd_vp_producer");
        this.a = 70;
        this.b = 200;
        this.c = 5;
        this.d = 0;
        this.f = new AtomicBoolean(false);
    }

    public float a(float f) {
        double d = f - 100.0f;
        Double.isNaN(d);
        Double.isNaN(d);
        float f2 = (float) (100.0d - ((0.01d * d) * d));
        if (f2 < this.d) {
            return this.d;
        }
        if (f2 < 100.0f) {
            return f2;
        }
        return f;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void b(float f) {
        if (this.d < 70 && f < 70.0f && !this.f.get()) {
            this.f.set(true);
            com.baidu.mobads.container.d.b.a().a(this, 0L, 200L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.mobads.container.d.a
    public void a_() {
        this.f.set(false);
        super.a_();
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        if (this.d < 70) {
            this.d += 5;
        } else {
            a_();
        }
        if (this.e != null) {
            this.e.a(this.d);
            return null;
        }
        return null;
    }
}
