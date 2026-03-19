package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.exception.i;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private String a;
    private final com.sigmob.sdk.downloader.core.file.d b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile IOException i;

    static class a extends d {
        a(IOException realCause) {
            super(null);
            c(realCause);
        }
    }

    private d() {
        this.b = null;
    }

    d(com.sigmob.sdk.downloader.core.file.d outputStream) {
        this.b = outputStream;
    }

    com.sigmob.sdk.downloader.core.file.d a() {
        com.sigmob.sdk.downloader.core.file.d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException();
    }

    public void a(IOException realCause) {
        this.c = true;
        this.i = realCause;
    }

    void a(String redirectLocation) {
        this.a = redirectLocation;
    }

    String b() {
        return this.a;
    }

    public void b(IOException realCause) {
        this.e = true;
        this.i = realCause;
    }

    public void c(IOException realCause) {
        this.f = true;
        this.i = realCause;
    }

    boolean c() {
        return this.c;
    }

    public void d(IOException realCause) {
        this.h = true;
        this.i = realCause;
    }

    public boolean d() {
        return this.d;
    }

    public void e(IOException e) {
        if (d()) {
            return;
        }
        if (e instanceof com.sigmob.sdk.downloader.core.exception.f) {
            a(e);
            return;
        }
        if (e instanceof i) {
            b(e);
            return;
        }
        if (e == com.sigmob.sdk.downloader.core.exception.b.a) {
            m();
            return;
        }
        if (e instanceof com.sigmob.sdk.downloader.core.exception.e) {
            d(e);
        } else if (e != com.sigmob.sdk.downloader.core.exception.c.a) {
            c(e);
            if (e instanceof SocketException) {
                return;
            }
            com.sigmob.sdk.downloader.core.c.b("DownloadCache", "catch unknown error " + e);
        }
    }

    boolean e() {
        return this.e;
    }

    boolean f() {
        return this.f;
    }

    boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    IOException i() {
        return this.i;
    }

    com.sigmob.sdk.downloader.core.cause.b j() {
        return ((com.sigmob.sdk.downloader.core.exception.f) this.i).a();
    }

    public boolean k() {
        return this.c || this.d || this.e || this.f || this.g || this.h;
    }

    void l() {
        this.d = true;
    }

    public void m() {
        this.g = true;
    }
}
