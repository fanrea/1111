package com.bytedance.sdk.component.b.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface yo extends Closeable, Flushable {
    void a_(b bVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
    void close() throws IOException;

    jh d();

    void flush() throws IOException;
}
