package com.bytedance.sdk.component.b.d;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface c extends yo, WritableByteChannel {
    b b();

    c b(byte[] bArr) throws IOException;

    c b(byte[] bArr, int i, int i2) throws IOException;

    @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
    void flush() throws IOException;

    c gb(int i) throws IOException;

    c h(int i) throws IOException;

    c hc(an anVar) throws IOException;

    c hc(String str) throws IOException;

    c mk(long j) throws IOException;

    c mq(long j) throws IOException;

    c sy() throws IOException;

    c tt(int i) throws IOException;
}
