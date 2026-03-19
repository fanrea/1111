package com.component.lottie.e;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public interface h extends z, WritableByteChannel {
    h K();

    long a(aa aaVar);

    h a(aa aaVar, long j);

    h b(String str);

    h b(String str, int i, int i2);

    h b(String str, int i, int i2, Charset charset);

    h b(String str, Charset charset);

    e c();

    h c(byte[] bArr, int i, int i2);

    h d(byte[] bArr);

    OutputStream e();

    @Override // com.component.lottie.e.z, java.io.Flushable
    void flush();

    h g();

    h g(j jVar);

    h i(int i);

    h j(int i);

    h k(int i);

    h l(int i);

    h m(int i);

    h n(int i);

    h n(long j);

    h o(long j);

    h p(long j);

    h q(long j);
}
