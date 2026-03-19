package com.qq.e.comm.plugin;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l10 extends FilterInputStream implements jv {
    private int a;

    @Override // com.qq.e.comm.plugin.jv
    public InputStream a() throws IOException {
        return this;
    }

    public l10(InputStream inputStream) throws IOException {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.jv
    public byte c() throws IOException {
        byte b = (byte) read();
        this.a++;
        return b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.qq.e.comm.plugin.jv
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        this.a += Math.max(0, i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.qq.e.comm.plugin.jv
    public synchronized void reset() throws IOException {
        super.reset();
        this.a = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.qq.e.comm.plugin.jv
    public long skip(long j) throws IOException {
        long j2 = j;
        while (j2 > 0) {
            long jSkip = super.skip(j2);
            if (jSkip > 0) {
                j2 -= jSkip;
            } else {
                if (super.read() == -1) {
                    break;
                }
                j2--;
            }
        }
        long j3 = j - j2;
        this.a = (int) (this.a + j3);
        return j3;
    }

    @Override // com.qq.e.comm.plugin.jv
    public int b() {
        return this.a;
    }
}
