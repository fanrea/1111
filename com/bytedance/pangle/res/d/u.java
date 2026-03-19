package com.bytedance.pangle.res.d;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends tc {
    private long d;

    public u(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.d.tc, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = super.skip(j);
        this.d += jSkip;
        return jSkip;
    }

    @Override // com.bytedance.pangle.res.d.tc
    protected synchronized void d(int i) {
        if (i != -1) {
            this.d += i;
        }
    }

    public int d() {
        long jHc = hc();
        if (jHc <= 2147483647L) {
            return (int) jHc;
        }
        throw new ArithmeticException("The byte count " + jHc + " is too large to be converted to an int");
    }

    public synchronized long hc() {
        return this.d;
    }
}
