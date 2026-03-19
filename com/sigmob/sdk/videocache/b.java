package com.sigmob.sdk.videocache;

import java.io.ByteArrayInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements u {
    private final byte[] a;
    private ByteArrayInputStream b;

    public b(byte[] data) {
        this.a = data;
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] buffer) throws q {
        return this.b.read(buffer, 0, buffer.length);
    }

    @Override // com.sigmob.sdk.videocache.u
    public long a() throws q {
        return this.a.length;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long offset) throws q {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.a);
        this.b = byteArrayInputStream;
        byteArrayInputStream.skip(offset);
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() throws q {
    }

    @Override // com.sigmob.sdk.videocache.u
    public String c() throws q {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return null;
    }
}
