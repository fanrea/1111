package com.sigmob.sdk.downloader.core;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b implements Runnable {
    protected final String a;

    public b(String name) {
        this.a = name;
    }

    protected abstract void a() throws InterruptedException;

    protected abstract void a(InterruptedException e);

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.a);
        try {
            try {
                a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                a(e);
            }
        } finally {
            Thread.currentThread().setName(name);
            b();
        }
    }
}
