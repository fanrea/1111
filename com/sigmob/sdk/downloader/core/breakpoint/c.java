package com.sigmob.sdk.downloader.core.breakpoint;

import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    final int a;
    final File b;
    private final String c;
    private String d;
    private File e;
    private final g.a f;
    private final List<a> g = new ArrayList();
    private final boolean h;
    private boolean i;

    public c(int id, String url, File parentFile, String filename) {
        this.a = id;
        this.c = url;
        this.b = parentFile;
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) filename)) {
            this.f = new g.a();
            this.h = true;
        } else {
            this.f = new g.a(filename);
            this.h = false;
            this.e = new File(parentFile, filename);
        }
    }

    c(int id, String url, File parentFile, String filename, boolean taskOnlyProvidedParentPath) {
        this.a = id;
        this.c = url;
        this.b = parentFile;
        this.f = com.sigmob.sdk.downloader.core.c.a((CharSequence) filename) ? new g.a() : new g.a(filename);
        this.h = taskOnlyProvidedParentPath;
    }

    public int a() {
        return this.a;
    }

    public c a(int replaceId, String newUrl) {
        c cVar = new c(replaceId, newUrl, this.b, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().g());
        }
        return cVar;
    }

    public void a(a blockInfo) {
        this.g.add(blockInfo);
    }

    public void a(c info) {
        this.g.clear();
        this.g.addAll(info.g);
    }

    public void a(String etag) {
        this.d = etag;
    }

    public void a(boolean chunked) {
        this.i = chunked;
    }

    public boolean a(int blockIndex) {
        return blockIndex == this.g.size() - 1;
    }

    public boolean a(com.sigmob.sdk.downloader.f task) {
        if (!this.b.equals(task.l()) || !this.c.equals(task.i())) {
            return false;
        }
        String strD = task.d();
        if (strD != null && strD.equals(this.f.a())) {
            return true;
        }
        if (this.h && task.a()) {
            return strD == null || strD.equals(this.f.a());
        }
        return false;
    }

    public a b(int blockIndex) {
        return this.g.get(blockIndex);
    }

    public boolean b() {
        return this.i;
    }

    public c c(int replaceId) {
        c cVar = new c(replaceId, this.c, this.b, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().g());
        }
        return cVar;
    }

    public boolean c() {
        return this.g.size() == 1;
    }

    boolean d() {
        return this.h;
    }

    public void e() {
        this.g.clear();
        this.d = null;
    }

    public void f() {
        this.g.clear();
    }

    public int g() {
        return this.g.size();
    }

    public File h() {
        return this.b;
    }

    public long i() {
        Object[] array = this.g.toArray();
        long jA = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    jA += ((a) obj).a();
                }
            }
        }
        return jA;
    }

    public long j() {
        if (b()) {
            return i();
        }
        long jD = 0;
        Object[] array = this.g.toArray();
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    jD += ((a) obj).d();
                }
            }
        }
        return jD;
    }

    public String k() {
        return this.d;
    }

    public String l() {
        return this.c;
    }

    public String m() {
        return this.f.a();
    }

    public g.a n() {
        return this.f;
    }

    public File o() {
        String strA = this.f.a();
        if (strA == null) {
            return null;
        }
        if (this.e == null) {
            this.e = new File(this.b, strA);
        }
        return this.e;
    }

    public c p() {
        c cVar = new c(this.a, this.c, this.b, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().g());
        }
        return cVar;
    }

    public String toString() {
        return "id[" + this.a + "] url[" + this.c + "] etag[" + this.d + "] taskOnlyProvidedParentPath[" + this.h + "] parent path[" + this.b + "] filename[" + this.f.a() + "] block(s):" + this.g.toString();
    }
}
