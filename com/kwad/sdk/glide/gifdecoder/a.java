package com.kwad.sdk.glide.gifdecoder;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface a {

    /* renamed from: com.kwad.sdk.glide.gifdecoder.a$a, reason: collision with other inner class name */
    public interface InterfaceC0603a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void b(int[] iArr);

        void d(Bitmap bitmap);

        byte[] fW(int i);

        int[] fX(int i);

        void h(byte[] bArr);
    }

    void a(Bitmap.Config config);

    void advance();

    Bitmap afA();

    int afx();

    int afy();

    void afz();

    void clear();

    int getByteSize();

    ByteBuffer getData();

    int getFrameCount();
}
