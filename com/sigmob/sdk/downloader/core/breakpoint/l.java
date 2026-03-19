package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.sigmob.sdk.downloader.core.breakpoint.m;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class l implements j, m.a {
    private static final String a = "RemitStoreOnSQLite";
    private final n b;
    private final i c;
    private final e d;
    private final j e;

    l(i sqlite) {
        this.b = new n(this);
        this.c = sqlite;
        this.e = sqlite.b;
        this.d = sqlite.a;
    }

    l(n helper, i sqlite, j sqliteCache, e sqLiteHelper) {
        this.b = helper;
        this.c = sqlite;
        this.e = sqliteCache;
        this.d = sqLiteHelper;
    }

    public static void j(int delayMillis) {
        g gVarC = com.sigmob.sdk.downloader.g.j().c();
        if (!(gVarC instanceof l)) {
            throw new IllegalStateException("The current store is " + gVarC + " not RemitStoreOnSQLite!");
        }
        ((l) gVarC).b.a = Math.max(0, delayMillis);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int id) {
        return this.c.a(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f task) throws IOException {
        return this.b.a(task.c()) ? this.e.a(task) : this.c.a(task);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f task, c ignored) {
        return this.c.a(task, ignored);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String url) {
        return this.c.a(url);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int id, com.sigmob.sdk.downloader.core.cause.a cause, Exception exception) {
        this.e.a(id, cause, exception);
        if (cause == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.b.d(id);
        } else {
            this.b.c(id);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c info, int blockIndex, long increaseLength) throws IOException {
        if (this.b.a(info.a())) {
            this.e.a(info, blockIndex, increaseLength);
        } else {
            this.c.a(info, blockIndex, increaseLength);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void a(List<Integer> idList) throws IOException {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<Integer> it = idList.iterator();
            while (it.hasNext()) {
                h(it.next().intValue());
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c info) throws IOException {
        return this.b.a(info.a()) ? this.e.a(info) : this.c.a(info);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f task) {
        return this.c.b(task);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void b(int id) {
        this.e.b(id);
        this.b.d(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int id) {
        return this.c.c(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int id) {
        this.c.d(id);
        this.b.b(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int id) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int id) {
        return this.c.f(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int id) {
        return this.c.g(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void h(int id) throws IOException {
        this.d.c(id);
        c cVarA = this.e.a(id);
        if (cVarA == null || cVarA.m() == null || cVarA.i() <= 0) {
            return;
        }
        this.d.a(cVarA);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void i(int id) {
        this.d.c(id);
    }
}
