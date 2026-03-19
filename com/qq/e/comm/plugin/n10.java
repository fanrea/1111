package com.qq.e.comm.plugin;

import com.ss.ttm.utils.AVLogger;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class n10 implements ot {
    private final String a;
    private final File b;
    private final long c;
    private final long d;
    private final qt e;
    private int f;
    private String g;
    private pt h;
    private AtomicBoolean i = new AtomicBoolean(false);
    private zo j;

    public n10(String str, File file, long j, long j2, qt qtVar) {
        this.a = str;
        this.b = file;
        this.c = j;
        this.d = j2;
        this.e = qtVar;
    }

    @Override // com.qq.e.comm.plugin.ot
    public int a(il ilVar) {
        pt ptVar;
        long length = this.c + this.b.length();
        long length2 = this.d - this.b.length();
        if (length2 == 0) {
            ilVar.a(this.b.length());
            return 0;
        }
        try {
        } catch (Throwable th) {
            try {
                this.f |= 1;
                this.g = "UnknownExceptionWhileSubpartitionDoWork" + th.getMessage();
                th.toString();
                ptVar = this.h;
                if (ptVar != null) {
                }
            } finally {
                pt ptVar2 = this.h;
                if (ptVar2 != null) {
                    ptVar2.b();
                }
            }
        }
        if (this.i.get()) {
            return 0;
        }
        pt ptVarA = this.e.a(this.a, length, length2, false);
        this.h = ptVarA;
        if (!ptVarA.c()) {
            this.f |= this.h.g();
            this.g = this.h.h();
        } else if (this.h.p()) {
            zo zoVar = new zo(this.h, this.b, this.d);
            this.j = zoVar;
            this.f = zoVar.a(ilVar) | this.f;
            this.g = this.j.a();
        } else {
            this.f |= AVLogger.LEVEL_LOG_INFO;
            this.g = "RangeNotSupportForURL-" + this.a;
        }
        ptVar = this.h;
        if (ptVar != null) {
            ptVar.b();
        }
        return this.f;
    }

    @Override // com.qq.e.comm.plugin.ot
    public int b() {
        return this.f;
    }

    @Override // com.qq.e.comm.plugin.ot
    public void pause() {
        this.i.compareAndSet(false, true);
        zo zoVar = this.j;
        if (zoVar != null) {
            zoVar.pause();
        }
        pt ptVar = this.h;
        if (ptVar != null) {
            ptVar.b();
        }
    }

    @Override // com.qq.e.comm.plugin.ot
    public String a() {
        return this.g;
    }
}
