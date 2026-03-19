package com.kwad.sdk.glide.load.resource.d;

import android.util.Log;
import com.kwad.sdk.glide.load.EncodeStrategy;
import com.kwad.sdk.glide.load.engine.s;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements com.kwad.sdk.glide.load.h<c> {
    @Override // com.kwad.sdk.glide.load.a
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, com.kwad.sdk.glide.load.f fVar) {
        return a((s) obj, file);
    }

    @Override // com.kwad.sdk.glide.load.h
    public final EncodeStrategy b(com.kwad.sdk.glide.load.f fVar) {
        return EncodeStrategy.SOURCE;
    }

    private static boolean a(s<c> sVar, File file) throws Throwable {
        try {
            com.kwad.sdk.glide.e.a.b(sVar.get().getBuffer(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
