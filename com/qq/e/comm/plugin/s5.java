package com.qq.e.comm.plugin;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s5 implements y50 {
    protected ByteBuffer a;

    @Override // com.qq.e.comm.plugin.y50
    public void close() {
    }

    public s5() {
        a(com.sigmob.sdk.archives.tar.d.b);
    }

    public int a() {
        return this.a.position();
    }

    public void b(int i) {
        this.a.position(i + a());
    }

    public void a(byte b) {
        this.a.put(b);
    }

    public byte[] b() {
        return this.a.array();
    }

    public void a(byte[] bArr) {
        this.a.put(bArr);
    }

    public void a(int i) {
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.a = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.a.clear();
    }
}
