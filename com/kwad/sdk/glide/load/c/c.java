package com.kwad.sdk.glide.load.c;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements com.kwad.sdk.glide.load.a<ByteBuffer> {
    @Override // com.kwad.sdk.glide.load.a
    public final /* bridge */ /* synthetic */ boolean a(ByteBuffer byteBuffer, File file, com.kwad.sdk.glide.load.f fVar) {
        return a(byteBuffer, file);
    }

    private static boolean a(ByteBuffer byteBuffer, File file) throws Throwable {
        try {
            com.kwad.sdk.glide.e.a.b(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e);
            }
            return false;
        }
    }
}
