package com.bytedance.sdk.component.b.d;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface u extends rf, ReadableByteChannel {
    InputStream an();

    an b(long j) throws IOException;

    @Deprecated
    b b();

    String cb() throws IOException;

    long d(byte b) throws IOException;

    String d(Charset charset) throws IOException;

    void d(long j) throws IOException;

    void d(byte[] bArr) throws IOException;

    boolean d(long j, an anVar) throws IOException;

    byte gb() throws IOException;

    void gb(long j) throws IOException;

    byte[] h(long j) throws IOException;

    short mk() throws IOException;

    int mq() throws IOException;

    int tc() throws IOException;

    short tt() throws IOException;

    String u(long j) throws IOException;

    boolean u() throws IOException;

    long uo() throws IOException;

    byte[] w() throws IOException;
}
