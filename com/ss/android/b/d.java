package com.ss.android.b;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements hc {
    private final RandomAccessFile d;

    public d(File file) throws FileNotFoundException {
        this.d = new RandomAccessFile(file, t.k);
    }

    @Override // com.ss.android.b.hc
    public long d() throws IOException {
        return this.d.length();
    }

    @Override // com.ss.android.b.hc
    public int d(byte[] bArr, int i, int i2) throws IOException {
        return this.d.read(bArr, i, i2);
    }

    @Override // com.ss.android.b.hc
    public void d(long j, long j2) throws IOException {
        this.d.seek(j);
    }

    @Override // com.ss.android.b.hc
    public void hc() throws IOException {
        this.d.close();
    }
}
