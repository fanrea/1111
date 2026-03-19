package com.qq.e.comm.plugin;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class uu {
    private final pe a;
    private volatile boolean b;
    private boolean d;
    private ConcurrentHashMap<String, Boolean> e = new ConcurrentHashMap<>();
    private AtomicInteger c = new AtomicInteger(0);

    protected abstract void a(OutputStream outputStream) throws IOException;

    uu(pe peVar) {
        this.a = peVar;
    }

    protected void a() throws vu {
        try {
            if (this.a.e()) {
                return;
            }
            if (this.c.incrementAndGet() >= 5 || this.a.g()) {
                this.c.set(0);
                throw new vu("Error reading downloading file ");
            }
        } catch (IOException e) {
            throw new vu("Error reading downloading file IOException ", e);
        }
    }

    void b() throws IOException {
        try {
            this.b = true;
            this.a.b();
        } catch (vu unused) {
        }
    }

    protected void c() throws InterruptedException, vu {
        try {
            Thread.sleep((this.c.get() + 1) * 300);
        } catch (InterruptedException e) {
            throw new vu("Error waiting cache", e);
        }
    }

    private boolean a(long j, int i, vh vhVar) throws IOException {
        return !this.a.f() && this.a.a() < j + ((long) i) && !this.b && a(vhVar);
    }

    private boolean a(vh vhVar) {
        Boolean bool = this.e.get(vhVar.e);
        qm$h$$ExternalSyntheticBackport0.m(bool);
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public int a(byte[] bArr, long j, int i, OutputStream outputStream, vh vhVar) throws InterruptedException, IOException, vu {
        wu.a(bArr, j, i);
        while (a(j, i, vhVar)) {
            this.a.a();
            c();
            if (!this.d) {
                a(outputStream);
                this.d = true;
            }
            a();
        }
        this.d = false;
        return this.a.a(bArr, j, i);
    }

    void a(String str) {
        this.e.put(str, Boolean.FALSE);
    }
}
