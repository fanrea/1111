package com.sigmob.sdk.archives;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class c extends InputStream {
    private static final int b = 255;
    private byte[] a = new byte[1];
    private long c = 0;

    private void b(long read) {
        if (read != -1) {
            this.c += read;
        }
    }

    public abstract a a() throws IOException;

    protected void a(int read) {
        b(read);
    }

    protected void a(long pushedBack) {
        this.c -= pushedBack;
    }

    public boolean a(a ae) {
        return true;
    }

    @Deprecated
    public int b() {
        return (int) this.c;
    }

    protected long c() {
        return this.c;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.a, 0, 1) == -1) {
            return -1;
        }
        return this.a[0] & 255;
    }
}
