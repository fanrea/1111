package com.qq.e.comm.plugin;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class te implements jv {
    public jv a;

    public te(jv jvVar) {
        this.a = jvVar;
    }

    @Override // com.qq.e.comm.plugin.jv, java.io.InputStream
    public long skip(long j) throws IOException {
        return this.a.skip(j);
    }

    @Override // com.qq.e.comm.plugin.jv
    public byte c() throws IOException {
        return this.a.c();
    }

    @Override // com.qq.e.comm.plugin.jv, java.io.InputStream
    public void reset() throws IOException {
        this.a.reset();
    }

    @Override // com.qq.e.comm.plugin.jv
    public int b() {
        return this.a.b();
    }

    @Override // com.qq.e.comm.plugin.jv, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.a.read(bArr, i, i2);
    }

    @Override // com.qq.e.comm.plugin.jv
    public int available() throws IOException {
        return this.a.available();
    }

    @Override // com.qq.e.comm.plugin.jv
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.qq.e.comm.plugin.jv
    public InputStream a() throws IOException {
        reset();
        return this.a.a();
    }
}
