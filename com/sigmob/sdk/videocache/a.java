package com.sigmob.sdk.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a implements c {
    private volatile byte[] a;
    private volatile boolean b;

    public a() {
        this(new byte[0]);
    }

    public a(byte[] data) {
        this.a = (byte[]) o.a(data);
    }

    @Override // com.sigmob.sdk.videocache.c
    public int a(byte[] buffer, long offset, int length) throws q {
        if (offset >= this.a.length) {
            return -1;
        }
        if (offset <= 2147483647L) {
            return new ByteArrayInputStream(this.a).read(buffer, (int) offset, length);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + offset);
    }

    @Override // com.sigmob.sdk.videocache.c
    public long a() throws q {
        return this.a.length;
    }

    @Override // com.sigmob.sdk.videocache.c
    public void a(byte[] newData, int length) throws q {
        o.a(this.a);
        o.a(length >= 0 && length <= newData.length);
        byte[] bArrCopyOf = Arrays.copyOf(this.a, this.a.length + length);
        System.arraycopy(newData, 0, bArrCopyOf, this.a.length, length);
        this.a = bArrCopyOf;
    }

    @Override // com.sigmob.sdk.videocache.c
    public void b() throws q {
    }

    @Override // com.sigmob.sdk.videocache.c
    public void c() {
        this.b = true;
    }

    @Override // com.sigmob.sdk.videocache.c
    public boolean d() {
        return this.b;
    }
}
