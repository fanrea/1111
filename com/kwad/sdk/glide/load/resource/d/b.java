package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.gifdecoder.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements a.InterfaceC0603a {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bPD;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bPy = eVar;
        this.bPD = bVar;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a.InterfaceC0603a
    public final Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.bPy.g(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a.InterfaceC0603a
    public final void d(Bitmap bitmap) {
        this.bPy.e(bitmap);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a.InterfaceC0603a
    public final byte[] fW(int i) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.bPD;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.a(i, byte[].class);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a.InterfaceC0603a
    public final void h(byte[] bArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.bPD;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a.InterfaceC0603a
    public final int[] fX(int i) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.bPD;
        if (bVar == null) {
            return new int[i];
        }
        return (int[]) bVar.a(i, int[].class);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a.InterfaceC0603a
    public final void b(int[] iArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.bPD;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
