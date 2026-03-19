package com.baidu.mobads.container.util.b;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f<T> {
    private T a;
    private long b;

    public f(T t) {
        this.a = t;
    }

    public f(T t, long j) {
        this.a = t;
        this.b = j;
    }

    public Class<?> a() {
        return this.a.getClass();
    }

    public T b() {
        return this.a;
    }

    public int c() {
        if (this.a instanceof Bitmap) {
            return ((Bitmap) this.a).getByteCount();
        }
        if (this.a instanceof File) {
            return (int) ((File) this.a).length();
        }
        if (this.a instanceof byte[]) {
            return ((byte[]) this.a).length;
        }
        if (!(this.a instanceof InputStream)) {
            return 1;
        }
        return (int) this.b;
    }

    public boolean d() {
        boolean zDelete;
        if (!(this.a instanceof File)) {
            zDelete = true;
        } else {
            zDelete = ((File) this.a).delete();
        }
        this.a = null;
        return zDelete;
    }

    public boolean a(long j) {
        return (this.a instanceof File) && System.currentTimeMillis() - ((File) this.a).lastModified() > j;
    }
}
