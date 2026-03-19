package com.qq.e.comm.plugin;

import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class zo implements ot {
    private final pt a;
    private final File b;
    private final long c;
    private String d;
    private int e;
    private k0 f;

    public zo(pt ptVar, File file, long j) {
        this.a = ptVar;
        this.b = file;
        this.c = j;
    }

    @Override // com.qq.e.comm.plugin.ot
    public int a(il ilVar) {
        long length;
        try {
            length = this.c - this.b.length();
        } catch (IOException e) {
            this.e |= 4194304;
            this.d = "UnknownNetworkExceptionWhileDoMainPartitionDownloaderWork" + e.getMessage();
        } catch (IllegalStateException unused) {
            this.e |= 8388608;
            this.d = "IllegalStateExceptionWhileDoMainPartitionDownloaderWork";
        }
        if (length == 0 && this.c > 0) {
            ilVar.a(this.b.length());
            return 0;
        }
        if (this.c <= 0) {
            this.f = new tt(this.a.i(), this.b, ilVar);
        } else {
            this.f = new st(this.a.i(), length, this.b, ilVar);
        }
        this.e |= this.f.a();
        this.d = this.f.b();
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.ot
    public int b() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.ot
    public void pause() {
        k0 k0Var = this.f;
        if (k0Var != null) {
            k0Var.c();
        }
        pt ptVar = this.a;
        if (ptVar != null) {
            ptVar.b();
        }
    }

    @Override // com.qq.e.comm.plugin.ot
    public String a() {
        return this.d;
    }
}
