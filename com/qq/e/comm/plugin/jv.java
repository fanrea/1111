package com.qq.e.comm.plugin;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface jv {
    InputStream a() throws IOException;

    int available() throws IOException;

    int b();

    byte c() throws IOException;

    void close() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    void reset() throws IOException;

    long skip(long j) throws IOException;
}
