package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.Context;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i implements j {
    private static final String c = "BreakpointStoreOnSQLite";
    protected final e a;
    protected final h b;

    public i(Context context) {
        e eVar = new e(context.getApplicationContext());
        this.a = eVar;
        this.b = new h(eVar.b(), eVar.a(), eVar.c());
    }

    i(e helper, h onCache) {
        this.a = helper;
        this.b = onCache;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int id) {
        return this.b.a(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f task) throws IOException {
        c cVarA = this.b.a(task);
        this.a.a(cVarA);
        return cVarA;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f task, c ignored) {
        return this.b.a(task, ignored);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String url) {
        return this.b.a(url);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int id, com.sigmob.sdk.downloader.core.cause.a cause, Exception exception) {
        this.b.a(id, cause, exception);
        if (cause == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.a.c(id);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c info, int blockIndex, long increaseLength) throws IOException {
        this.b.a(info, blockIndex, increaseLength);
        this.a.a(info, blockIndex, info.b(blockIndex).a());
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c breakpointInfo) throws IOException {
        boolean zA = this.b.a(breakpointInfo);
        this.a.b(breakpointInfo);
        String strM = breakpointInfo.m();
        com.sigmob.sdk.downloader.core.c.b(c, "update " + breakpointInfo);
        if (breakpointInfo.d() && strM != null) {
            this.a.a(breakpointInfo.l(), strM);
        }
        return zA;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f task) {
        return this.b.b(task);
    }

    void b() {
        this.a.close();
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void b(int id) {
        this.b.b(id);
        this.a.c(id);
    }

    public j c() {
        return new l(this);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int id) {
        return this.b.c(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int id) {
        this.b.d(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int id) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int id) {
        if (!this.b.f(id)) {
            return false;
        }
        this.a.a(id);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int id) {
        if (!this.b.g(id)) {
            return false;
        }
        this.a.b(id);
        return true;
    }
}
