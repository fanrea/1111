package com.bytedance.sdk.component.b.d;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class uo implements c {
    boolean b;
    public final b d = new b();
    public final yo hc;

    uo(yo yoVar) {
        if (yoVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.hc = yoVar;
    }

    @Override // com.bytedance.sdk.component.b.d.c, com.bytedance.sdk.component.b.d.u
    public b b() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.b.d.yo
    public void a_(b bVar, long j) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.a_(bVar, j);
        sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c hc(an anVar) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.hc(anVar);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c hc(String str) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.hc(str);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c b(byte[] bArr) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.b(bArr);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c b(byte[] bArr, int i, int i2) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.b(bArr, i, i2);
        return sy();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.d.write(byteBuffer);
        sy();
        return iWrite;
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c tt(int i) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.tt(i);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c gb(int i) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.gb(i);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c h(int i) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.h(i);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c mq(long j) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.mq(j);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c mk(long j) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.d.mk(j);
        return sy();
    }

    @Override // com.bytedance.sdk.component.b.d.c
    public c sy() throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        long jH = this.d.h();
        if (jH > 0) {
            this.hc.a_(this.d, jH);
        }
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.c, com.bytedance.sdk.component.b.d.yo, java.io.Flushable
    public void flush() throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (this.d.hc > 0) {
            yo yoVar = this.hc;
            b bVar = this.d;
            yoVar.a_(bVar, bVar.hc);
        }
        this.hc.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.b;
    }

    @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
    public void close() throws Throwable {
        if (this.b) {
            return;
        }
        Throwable th = null;
        try {
            if (this.d.hc > 0) {
                yo yoVar = this.hc;
                b bVar = this.d;
                yoVar.a_(bVar, bVar.hc);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.hc.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.b = true;
        if (th != null) {
            sy.d(th);
        }
    }

    @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
    public jh d() {
        return this.hc.d();
    }

    public String toString() {
        return "buffer(" + this.hc + ")";
    }
}
