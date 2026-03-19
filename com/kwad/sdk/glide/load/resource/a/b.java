package com.kwad.sdk.glide.load.resource.a;

import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements s<byte[]> {
    private final byte[] bXT;

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
    }

    public b(byte[] bArr) {
        this.bXT = (byte[]) ax.checkNotNull(bArr);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<byte[]> afv() {
        return byte[].class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: ahX, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.bXT;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return this.bXT.length;
    }
}
