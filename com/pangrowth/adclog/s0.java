package com.pangrowth.adclog;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class s0 implements Closeable {
    public final FileChannel a;

    public s0(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.a = new FileInputStream(file).getChannel();
    }

    public int a(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.String> a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.s0.a():java.util.List");
    }

    public void a(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int i2 = this.a.read(byteBuffer, j + j2);
            if (i2 == -1) {
                throw new EOFException();
            }
            j2 += i2;
        }
        byteBuffer.position(0);
    }

    public long b(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public long c(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 4);
        return byteBuffer.getInt() & C00oOOo.f362O8oO888;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }
}
