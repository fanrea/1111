package com.baidu.mobads.container.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bh {
    private static String c = "OAdTimer";
    private static final int g = 300;
    private static final int i = -1;
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    protected int a;
    private a b;
    private int d;
    private int e;
    private int f;
    private AtomicInteger h;
    private com.baidu.mobads.container.d.a m;

    public interface a {
        void a();

        void a(int i);
    }

    static /* synthetic */ int f(bh bhVar) {
        int i2 = bhVar.e;
        bhVar.e = i2 - 1;
        return i2;
    }

    public bh(int i2) {
        this(i2, 300);
    }

    public bh(int i2, int i3) {
        this.a = 300;
        this.a = i3;
        int i4 = i2 / this.a;
        bq.a().a(c, "RendererTimer(duration=" + i4 + ")");
        this.d = i4;
        this.e = i4;
        this.h = new AtomicInteger(-1);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a() {
        bq.a().a(c, "start");
        this.h.set(0);
        try {
            this.m = new bi(this);
            com.baidu.mobads.container.d.b.a().a(this.m, 0L, this.a, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
        }
    }

    public void b() {
        try {
            bq.a().a(c, com.component.feed.a.e);
            this.h.set(2);
            synchronized (this) {
                if (this.m != null) {
                    this.m.b(true);
                    this.m = null;
                }
                if (this.b != null) {
                    this.b = null;
                }
            }
        } catch (Throwable th) {
        }
    }

    public void c() {
        bq.a().a(c, "pause");
        this.h.set(1);
    }

    public void d() {
        bq.a().a(c, "resume");
        this.h.set(0);
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.d;
    }

    public void g() {
        bq.a().a(c, "reset");
        this.h.set(-1);
        this.e = this.d;
    }
}
