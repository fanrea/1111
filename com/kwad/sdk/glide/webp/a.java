package com.kwad.sdk.glide.webp;

import android.content.Context;
import android.util.Log;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.a.k;
import com.kwad.sdk.glide.framesequence.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends com.kwad.sdk.glide.a {
    private final e caw = new e();

    @Override // com.kwad.sdk.glide.a
    public final /* synthetic */ k.a aeX() {
        return ajK();
    }

    public a() {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.kwad.sdk.glide.samples.webp.WebpModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.kwad.sdk.glide.framesequence.FsGlideLibraryModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.kwad.sdk.glide.webp.WebpGlideLibraryModule");
        }
    }

    @Override // com.kwad.sdk.glide.b.b
    public final void a(Context context, com.kwad.sdk.glide.c cVar, Registry registry) {
        new f().a(context, cVar, registry);
        new d().a(context, cVar, registry);
        this.caw.a(context, cVar, registry);
    }

    private static b ajK() {
        return new b();
    }
}
