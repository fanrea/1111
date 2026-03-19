package com.kwad.sdk.glide.framesequence;

import android.content.Context;
import com.kwad.sdk.glide.Registry;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f extends com.kwad.sdk.glide.b.b {
    @Override // com.kwad.sdk.glide.b.b
    public final void a(Context context, com.kwad.sdk.glide.c cVar, Registry registry) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVarAeZ = cVar.aeZ();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVarAfa = cVar.afa();
        a aVar = new a(registry.afj());
        g gVar = new g(registry.afj(), bVarAfa);
        registry.b(ByteBuffer.class, FrameSequence.class, aVar).b(InputStream.class, FrameSequence.class, gVar).b(ByteBuffer.class, FrameSequenceDrawable.class, new c(eVarAeZ, aVar)).b(InputStream.class, FrameSequenceDrawable.class, new c(eVarAeZ, gVar)).a(FrameSequence.class, FrameSequenceDrawable.class, new e(eVarAeZ));
    }
}
